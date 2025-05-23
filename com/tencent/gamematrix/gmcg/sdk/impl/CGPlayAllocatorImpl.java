package com.tencent.gamematrix.gmcg.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.GmCgAuthRefreshListener;
import com.tencent.gamematrix.gmcg.api.GmCgDeviceAllocSource;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator;
import com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocateDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocatorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgColdStartDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo;
import com.tencent.gamematrix.gmcg.base.delaycount.GmCgDelayCounter;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.env.CGClientEnvHelper;
import com.tencent.gamematrix.gmcg.sdk.impl.CGQualificationChecker;
import com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule;
import com.tencent.gamematrix.gmcg.sdk.service.CGAllocDeviceInfo;
import com.tencent.gamematrix.gmcg.sdk.service.CGAllocDeviceResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGGameConfigResp;
import com.tencent.gamematrix.gmcg.webrtc.GmCgPxlwManager;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class CGPlayAllocatorImpl implements GmCgPlayAllocator, GmCgPlayDetectorListener {
    private static final int DEFAULT_QUERY_WAIT_QUEUE_GAP_IN_SEC = 3;
    private static final String TAG_FSR = "GMCG_FSR";
    private GmCgAllocatorCfg mAllocateCfg;
    private final CGAllocationCtx mAllocationCtx;
    private final CGAllocationMonitor mAllocationMonitor;
    private CGBizHttpService mBizHttpService;
    private String mBizInfo;
    private String mCgGameId;
    private long mColdStartTime;
    private int mColdStartTimeProcess;
    private GmCgDeviceInfo mDeviceReadyToUse;
    private int mIdentityProfileType;
    private CGLocationGetter mLocationGetter;
    private Handler mMainHandler;
    private GmCgPlayAllocatorListener mPlayAllocatorListener;
    private GmCgPlayDetectorListener mPlayDetectorListener;
    private CGPlayDetectorImpl mPlayNetDetector;
    private CGQualificationChecker mQualificationChecker;
    private CGHandlerTimer mQueryColdStartTimer;
    private CGHandlerTimer.TimerTask mQueryColdStartTimerTask;
    private CGHandlerTimer mQueryWaitingQueueTimer;
    private CGHandlerTimer.TimerTask mQueryWaitingQueueTimerTask;
    private String mShareCode;
    private CGHandlerTimer mUpdateProcessColdStartTimer;
    private CGHandlerTimer.TimerTask mUpdateProcessColdStartTimerTask;
    private volatile String mWaitIdIfQueueing;
    private int mWaitNextQueryColdStartGap;
    private int mWaitNextQueryGap;
    private boolean mCanWaitIfQueue = true;
    private volatile String mColdStartDeviceId = "";
    private final AtomicBoolean mStopped = new AtomicBoolean(true);
    private final AtomicBoolean mQueuePaused = new AtomicBoolean(false);
    private final AtomicBoolean mFistUpdate = new AtomicBoolean(true);

    @GmCgDeviceAllocSource
    private int mAllocSource = 1;

    public CGPlayAllocatorImpl() {
        CGAllocationCtx cGAllocationCtx = new CGAllocationCtx();
        this.mAllocationCtx = cGAllocationCtx;
        this.mAllocationMonitor = new CGAllocationMonitor(cGAllocationCtx);
    }

    private void cancelBizHttpService() {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.cancel();
        }
    }

    private void cancelQueryColdStartDeviceTask() {
        CGHandlerTimer.TimerTask timerTask = this.mQueryColdStartTimerTask;
        if (timerTask != null) {
            this.mQueryColdStartTimer.cancel(timerTask);
        }
    }

    private void cancelQueryWaitingQueueIfNecessary() {
        CGHandlerTimer.TimerTask timerTask = this.mQueryWaitingQueueTimerTask;
        if (timerTask != null) {
            this.mQueryWaitingQueueTimer.cancel(timerTask);
        }
    }

    private void cancelUpdateColdStartProcessTask() {
        CGHandlerTimer.TimerTask timerTask = this.mUpdateProcessColdStartTimerTask;
        if (timerTask != null) {
            this.mUpdateProcessColdStartTimer.cancel(timerTask);
        }
    }

    private void checkDeviceToUse() {
        CGLog.i("CGPlayAllocatorImpl checkDeviceToUse");
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null && gmCgDeviceInfo.isValid()) {
            internalWhenDeviceAllocated(this.mDeviceReadyToUse);
            return;
        }
        int i3 = this.mAllocSource;
        if (i3 != 2) {
            if (i3 != 3) {
                if (this.mAllocateCfg == null) {
                    internalWhenErrorHappen(GmCgError.ErrorParamsWrong);
                    return;
                } else {
                    directAllocDeviceToUse();
                    return;
                }
            }
            if (CGStringUtil.isEmpty(this.mShareCode)) {
                internalWhenErrorHappen(GmCgError.ErrorShareCodeIsInvalid);
                return;
            } else {
                queryDeviceFromShareCode();
                return;
            }
        }
        if (CGStringUtil.isEmpty(this.mWaitIdIfQueueing)) {
            internalWhenErrorHappen(GmCgError.ErrorParamsWrong);
        } else {
            checkWaitingQueue();
        }
    }

    private void checkQualification() {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_AUTH_USER, true);
        this.mQualificationChecker.check(this.mBizHttpService, new CGQualificationChecker.CGQualificationCheckResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ad
            @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGQualificationChecker.CGQualificationCheckResultListener
            public final void onCGQualificationCheckResult(GmCgError gmCgError) {
                CGPlayAllocatorImpl.this.lambda$checkQualification$4(gmCgError);
            }
        });
    }

    private void checkWaitingQueue() {
        CGLog.i("CGPlayAllocatorImpl checkQueueFromExternal");
        queryWaitingQueueAfterTime();
    }

    private void clearLocalColdStartInfo() {
        this.mColdStartTime = 0L;
        this.mColdStartDeviceId = "";
        this.mColdStartTimeProcess = 0;
    }

    private void clearLocalQueueWaiting() {
        this.mWaitIdIfQueueing = "";
    }

    public static CGPlayAllocatorImpl create(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg) {
        CGPlayAllocatorImpl cGPlayAllocatorImpl = new CGPlayAllocatorImpl();
        cGPlayAllocatorImpl.mAllocSource = 1;
        cGPlayAllocatorImpl.mAllocateCfg = gmCgAllocatorCfg;
        cGPlayAllocatorImpl.mCanWaitIfQueue = gmCgAllocatorCfg.pCanWaitIfQueue;
        cGPlayAllocatorImpl.mCgGameId = gmCgAllocatorCfg.pCgGameId;
        cGPlayAllocatorImpl.mBizInfo = gmCgAllocatorCfg.pBizExtraInfo;
        cGPlayAllocatorImpl.mWaitIdIfQueueing = null;
        cGPlayAllocatorImpl.mIdentityProfileType = gmCgAllocatorCfg.pIdentityProfileType;
        initAllocationCtxCommonPart(cGPlayAllocatorImpl.mAllocationCtx);
        cGPlayAllocatorImpl.mAllocationCtx.pCgGameId = gmCgAllocatorCfg.pCgGameId;
        cGPlayAllocatorImpl.init();
        return cGPlayAllocatorImpl;
    }

    public static CGPlayAllocatorImpl createFromQueue(@NonNull GmCgPlayQueueInfo gmCgPlayQueueInfo) {
        CGPlayAllocatorImpl cGPlayAllocatorImpl = new CGPlayAllocatorImpl();
        cGPlayAllocatorImpl.mAllocSource = 2;
        cGPlayAllocatorImpl.mWaitIdIfQueueing = gmCgPlayQueueInfo.pWaitId;
        cGPlayAllocatorImpl.mCanWaitIfQueue = true;
        cGPlayAllocatorImpl.mCgGameId = gmCgPlayQueueInfo.pGameTag;
        cGPlayAllocatorImpl.mBizInfo = gmCgPlayQueueInfo.pBizInfo;
        cGPlayAllocatorImpl.mIdentityProfileType = gmCgPlayQueueInfo.getIdentityProfType();
        initAllocationCtxCommonPart(cGPlayAllocatorImpl.mAllocationCtx);
        cGPlayAllocatorImpl.init();
        return cGPlayAllocatorImpl;
    }

    public static CGPlayAllocatorImpl createFromShareCode(@NonNull String str) {
        CGPlayAllocatorImpl cGPlayAllocatorImpl = new CGPlayAllocatorImpl();
        cGPlayAllocatorImpl.mAllocSource = 3;
        cGPlayAllocatorImpl.mShareCode = str;
        cGPlayAllocatorImpl.mIdentityProfileType = 0;
        initAllocationCtxCommonPart(cGPlayAllocatorImpl.mAllocationCtx);
        cGPlayAllocatorImpl.init();
        return cGPlayAllocatorImpl;
    }

    private void directAllocDeviceToUse() {
        CGLog.i("CGPlayAllocatorImpl directAllocDeviceToUse");
        GmCgAllocatorCfg gmCgAllocatorCfg = this.mAllocateCfg;
        if (gmCgAllocatorCfg.pSkipNetDetect) {
            requestAllocateDevice(null);
        } else if (CGStringUtil.notEmpty(gmCgAllocatorCfg.pUseFixedIpToNetDetect)) {
            useFixedIpAllocDevice(this.mAllocateCfg.pUseFixedIpToNetDetect);
        } else {
            doNetDetect();
        }
    }

    private void doNetDetect() {
        if (this.mPlayNetDetector == null) {
            this.mPlayNetDetector = CGPlayDetectorImpl.create(this.mCgGameId, this.mAllocateCfg.pUseIpToNetDetect);
        }
        this.mPlayNetDetector.setPlayDetectorListener(this);
        this.mPlayNetDetector.startDetector();
    }

    private void doStartAllocateAfterQualification() {
        getLocationToPrepare();
        checkDeviceToUse();
    }

    private void getLocationToPrepare() {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.requestGetGameConfig(this.mCgGameId, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ao
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlayAllocatorImpl.this.lambda$getLocationToPrepare$3(gmCgError, (CGGameConfigResp) obj);
                }
            });
        }
    }

    private int getNextColdStartQueryGap() {
        int i3 = this.mWaitNextQueryColdStartGap;
        if (i3 <= 0) {
            return 3;
        }
        return i3;
    }

    private int getNextQueryGap() {
        int i3 = this.mWaitNextQueryGap;
        if (i3 <= 0) {
            return 3;
        }
        return i3;
    }

    private void init() {
        boolean z16;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mQueryWaitingQueueTimer = new CGHandlerTimer();
        this.mQueryColdStartTimer = new CGHandlerTimer();
        this.mUpdateProcessColdStartTimer = new CGHandlerTimer();
        this.mBizHttpService = new CGBizHttpService();
        if (1 == this.mIdentityProfileType) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mQualificationChecker = new CGQualificationChecker(true, z16);
        CGClientEnvHelper.get().refresh();
    }

    private static void initAllocationCtxCommonPart(CGAllocationCtx cGAllocationCtx) {
        cGAllocationCtx.pBizId = CGGlbConfig.getBizId();
        cGAllocationCtx.pUserId = CGGlbConfig.getUserId();
        cGAllocationCtx.pServerType = CGGlbConfig.getServerType();
        cGAllocationCtx.pDeviceModel = CGGlbConfig.getBuildModel();
        cGAllocationCtx.pDeviceBrand = CGGlbConfig.getBuildBrand();
        cGAllocationCtx.pSoc = CGGlbConfig.getSoc();
        cGAllocationCtx.pOaid = CGGlbConfig.getOAID();
        cGAllocationCtx.pXid = CGGlbConfig.getXID();
    }

    private void internalCancelQueueIfNeed() {
        CGLog.i("CGPlayAllocatorImpl internalCancelQueueIfNeed");
        cancelQueryWaitingQueueIfNecessary();
        if (CGStringUtil.notEmpty(this.mWaitIdIfQueueing)) {
            CGLog.i("CGPlayAllocatorImpl internalCancelQueueIfNeed: " + this.mWaitIdIfQueueing);
            requestCancelQueryWaitingQueue(this.mWaitIdIfQueueing);
        }
    }

    private void internalWhenDeviceAllocated(final GmCgDeviceInfo gmCgDeviceInfo) {
        this.mDeviceReadyToUse = gmCgDeviceInfo;
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.at
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$internalWhenDeviceAllocated$13(gmCgDeviceInfo);
            }
        });
    }

    private void internalWhenDeviceColdStart(final GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ar
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$internalWhenDeviceColdStart$15(gmCgColdStartDeviceInfo);
            }
        });
    }

    private void internalWhenDeviceQueuing(final GmCgPlayQueueInfo gmCgPlayQueueInfo) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.aa
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$internalWhenDeviceQueuing$14(gmCgPlayQueueInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalWhenErrorHappen(final GmCgError gmCgError) {
        CGLog.i("CGPlayAllocatorImpl internalWhenErrorHappen: " + gmCgError.getDetailErrorMsg());
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ac
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$internalWhenErrorHappen$16(gmCgError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkQualification$4(GmCgError gmCgError) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_AUTH_USER, false);
        if (GmCgError.isOK(gmCgError)) {
            doStartAllocateAfterQualification();
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLocationToPrepare$3(GmCgError gmCgError, CGGameConfigResp cGGameConfigResp) {
        CGGameConfigResp.SensorBean sensorBean;
        if (GmCgError.isOK(gmCgError) && cGGameConfigResp != null && (sensorBean = cGGameConfigResp.sensor) != null && sensorBean.gps > 0) {
            CGLocationGetter cGLocationGetter = new CGLocationGetter(CGGlbConfig.getAppContext(), null);
            this.mLocationGetter = cGLocationGetter;
            cGLocationGetter.startGetLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalWhenDeviceAllocated$13(GmCgDeviceInfo gmCgDeviceInfo) {
        notifyAllocatorUpdate(3, true, gmCgDeviceInfo, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalWhenDeviceColdStart$15(GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo) {
        notifyAllocatorUpdate(2, false, null, null, gmCgColdStartDeviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalWhenDeviceQueuing$14(GmCgPlayQueueInfo gmCgPlayQueueInfo) {
        notifyAllocatorUpdate(1, false, null, gmCgPlayQueueInfo, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalWhenErrorHappen$16(GmCgError gmCgError) {
        GmCgPlayAllocatorListener gmCgPlayAllocatorListener = this.mPlayAllocatorListener;
        if (gmCgPlayAllocatorListener != null) {
            gmCgPlayAllocatorListener.onGmCgAllocatorError(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGmCgDetectorError$20(GmCgError gmCgError) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgDetectorError(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGmCgDetectorStart$17(boolean z16, float f16, float f17) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgDetectorStart(z16, f16, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGmCgDetectorUpdate$18(int i3) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgDetectorUpdate(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGmCgNetDetectResult$19(int i3, boolean z16, List list) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgNetDetectResult(i3, z16, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryColdStartDeviceAfterGapTime$12(int i3) {
        requestQueryColdDeviceWaitingTime(this.mColdStartDeviceId, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryDeviceFromShareCode$5(GmCgError gmCgError, CGAllocDeviceResp cGAllocDeviceResp) {
        if (GmCgError.isOK(gmCgError)) {
            onAllocDeviceResult(cGAllocDeviceResp, 3);
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryWaitingQueueAfterTime$11() {
        requestQueryWaitingQueue(this.mWaitIdIfQueueing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAllocateDevice$6(GmCgError gmCgError, CGAllocDeviceResp cGAllocDeviceResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_ALLOC_DEVICE, false);
        if (GmCgError.isOK(gmCgError)) {
            onAllocDeviceResult(cGAllocDeviceResp, 1);
        } else {
            this.mAllocationMonitor.reportAllocDeviceCallback(gmCgError.getErrorCode(), false, false);
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCancelQueryWaitingQueue$9(GmCgError gmCgError, Void r36) {
        if (!GmCgError.isOK(gmCgError)) {
            CGLog.e("CGPlayAllocatorImpl requestCancelQueryWaitingQueue: \u53d6\u6d88\u6392\u961f\u5931\u8d25, " + gmCgError.getDetailErrorMsg());
        }
        onCancelWaitingQueueResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryColdDeviceWaitingTime$8(int i3, GmCgError gmCgError, CGAllocDeviceResp cGAllocDeviceResp) {
        if (GmCgError.isOK(gmCgError)) {
            onQueryColdStartDeviceResult(cGAllocDeviceResp, i3);
        } else {
            this.mColdStartDeviceId = "";
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestQueryWaitingQueue$7(GmCgError gmCgError, CGAllocDeviceResp cGAllocDeviceResp) {
        if (GmCgError.isOK(gmCgError)) {
            onQueryWaitingQueueResult(cGAllocDeviceResp);
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAllocate$0(GmCgError gmCgError, CGGameConfigResp cGGameConfigResp) {
        if (GmCgError.isOK(gmCgError)) {
            onQtvNonageProtect(cGGameConfigResp);
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAllocate$1(GmCgError gmCgError, CGGameConfigResp cGGameConfigResp) {
        if (GmCgError.isOK(gmCgError)) {
            onQtvNonageProtect(cGGameConfigResp);
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAllocate$2(boolean z16, GmCgError gmCgError, CGGameConfigResp cGGameConfigResp) {
        int i3;
        if (!GmCgError.isOK(gmCgError)) {
            internalWhenErrorHappen(gmCgError);
            return;
        }
        CGLog.w(TAG_FSR, "\u67e5\u8be2" + this.mCgGameId + "\u7684\u8d85\u5206\u5f00\u5173: " + cGGameConfigResp.userCanSuperResolution);
        GmCgAllocatorCfg gmCgAllocatorCfg = this.mAllocateCfg;
        if (gmCgAllocatorCfg != null) {
            if (cGGameConfigResp.userCanSuperResolution) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            gmCgAllocatorCfg.pSuperResolutionType = i3;
        }
        if (z16) {
            onQtvNonageProtect(cGGameConfigResp);
        } else {
            startAllocateDetail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateProcessColdStart$10(GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo) {
        int i3 = this.mColdStartTimeProcess + 1;
        this.mColdStartTimeProcess = i3;
        if (i3 > 99) {
            this.mColdStartTimeProcess = 99;
        }
        gmCgColdStartDeviceInfo.startPercent = this.mColdStartTimeProcess;
        internalWhenDeviceColdStart(gmCgColdStartDeviceInfo);
    }

    private void notifyAllocatorUpdate(int i3, boolean z16, GmCgDeviceInfo gmCgDeviceInfo, GmCgPlayQueueInfo gmCgPlayQueueInfo, GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo) {
        if (this.mPlayAllocatorListener != null) {
            GmCgAllocateDeviceInfo gmCgAllocateDeviceInfo = new GmCgAllocateDeviceInfo();
            gmCgAllocateDeviceInfo.mCgDeviceInfo = gmCgDeviceInfo;
            gmCgAllocateDeviceInfo.mCgPlayQueueInfo = gmCgPlayQueueInfo;
            gmCgAllocateDeviceInfo.mCgColdStartDeviceInfo = gmCgColdStartDeviceInfo;
            GmCgPlayAllocatorListener gmCgPlayAllocatorListener = this.mPlayAllocatorListener;
            if (gmCgPlayAllocatorListener != null) {
                try {
                    gmCgPlayAllocatorListener.onGmCgAllocatorUpdate(i3, this.mFistUpdate.get(), gmCgAllocateDeviceInfo);
                } catch (Exception e16) {
                    StringWriter stringWriter = new StringWriter();
                    e16.printStackTrace(new PrintWriter(stringWriter));
                    CGLog.e("mPlayAllocatorListener onGmCgAllocatorUpdate error: " + stringWriter);
                }
            }
        }
        this.mFistUpdate.set(false);
    }

    private void onAllocDeviceResult(CGAllocDeviceResp cGAllocDeviceResp, int i3) {
        boolean z16;
        int i16;
        CGLog.i("onAllocDeviceResult: " + cGAllocDeviceResp);
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (cGAllocDeviceResp.hasDevice()) {
            cancelQueryWaitingQueueIfNecessary();
            clearLocalQueueWaiting();
            cancelUpdateColdStartProcessTask();
            cancelQueryColdStartDeviceTask();
            clearLocalColdStartInfo();
            if (cGAllocDeviceResp.hasValidDevice()) {
                if (3 == i3 && !cGAllocDeviceResp.device.isCreatedByOther) {
                    CGAllocationMonitor cGAllocationMonitor = this.mAllocationMonitor;
                    GmCgError gmCgError = GmCgError.ErrorDomainAccountUseShareCodeNotAllowed;
                    cGAllocationMonitor.reportAllocDeviceCallback(gmCgError.getErrorCode(), false, false);
                    internalWhenErrorHappen(gmCgError);
                    return;
                }
                if (z16) {
                    this.mAllocationMonitor.reportQueueSuccessCallback(this.mAllocationCtx);
                } else {
                    this.mAllocationMonitor.reportAllocDeviceCallback(0, false, cGAllocDeviceResp.device.reallocated);
                }
                GmCgPxlwManager gmCgPxlwManager = GmCgPxlwManager.get();
                CGAllocDeviceInfo cGAllocDeviceInfo = cGAllocDeviceResp.device;
                if (cGAllocDeviceInfo != null) {
                    i16 = cGAllocDeviceInfo.fps;
                } else {
                    i16 = 30;
                }
                gmCgPxlwManager.setFrcFps(i16);
                internalWhenDeviceAllocated(cGAllocDeviceResp.toGmCgDeviceInfo(i3));
                return;
            }
            CGAllocationMonitor cGAllocationMonitor2 = this.mAllocationMonitor;
            GmCgError gmCgError2 = GmCgError.ErrorParamsWrong;
            cGAllocationMonitor2.reportAllocDeviceCallback(gmCgError2.getErrorCode(), z16, false);
            internalWhenErrorHappen(gmCgError2);
            return;
        }
        GmCgAllocatorCfg gmCgAllocatorCfg = this.mAllocateCfg;
        if (gmCgAllocatorCfg != null && gmCgAllocatorCfg.pNeedColdStartDevice && cGAllocDeviceResp.isNeedColdStart()) {
            GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo = cGAllocDeviceResp.toGmCgColdStartDeviceInfo(this.mBizInfo);
            CGLog.i("enter cold start mColdStartDeviceId=" + this.mColdStartDeviceId + ", is equals: " + cGAllocDeviceResp.coldStartDevice.equals(this.mColdStartDeviceId) + ", coldStartTime: " + cGAllocDeviceResp.coldStartTime);
            long j3 = cGAllocDeviceResp.coldStartTime;
            if (j3 > 0) {
                this.mColdStartTime = j3;
                updateProcessColdStart(gmCgColdStartDeviceInfo);
            }
            this.mColdStartDeviceId = cGAllocDeviceResp.coldStartDevice;
            this.mWaitNextQueryColdStartGap = cGAllocDeviceResp.querygap;
            queryColdStartDeviceAfterGapTime(i3);
            return;
        }
        if (this.mCanWaitIfQueue) {
            this.mWaitIdIfQueueing = cGAllocDeviceResp.waitid;
            this.mWaitNextQueryGap = cGAllocDeviceResp.querygap;
            internalWhenDeviceQueuing(cGAllocDeviceResp.toGmCgQueueInfo(this.mBizInfo));
            this.mAllocationMonitor.reportAllocDeviceCallback(0, z16, false);
            queryWaitingQueueAfterTime();
            return;
        }
        CGAllocationMonitor cGAllocationMonitor3 = this.mAllocationMonitor;
        GmCgError gmCgError3 = GmCgError.ErrorNoIdleService;
        cGAllocationMonitor3.reportAllocDeviceCallback(gmCgError3.getErrorCode(), z16, false);
        internalWhenErrorHappen(gmCgError3);
    }

    private void onCancelWaitingQueueResult() {
        clearLocalQueueWaiting();
    }

    private void onQtvNonageProtect(CGGameConfigResp cGGameConfigResp) {
        if (cGGameConfigResp.protectChildren == 1) {
            CGNonAgeProtectModule.getInstance().login(this.mCgGameId, new CGNonAgeProtectModule.ILoginCheckListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlayAllocatorImpl.1
                @Override // com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.ILoginCheckListener
                public void onLoginFailure(GmCgError gmCgError) {
                    CGPlayAllocatorImpl.this.internalWhenErrorHappen(gmCgError);
                }

                @Override // com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule.ILoginCheckListener
                public void onLoginSuccess() {
                    CGPlayAllocatorImpl.this.startAllocateDetail();
                }
            });
        } else {
            CGLog.d("CGNonAgeProtect-this game not open protectChildren");
            startAllocateDetail();
        }
    }

    private void onQueryColdStartDeviceResult(CGAllocDeviceResp cGAllocDeviceResp, int i3) {
        cGAllocDeviceResp.coldStartDevice = this.mColdStartDeviceId;
        onAllocDeviceResult(cGAllocDeviceResp, i3);
    }

    private void onQueryWaitingQueueResult(CGAllocDeviceResp cGAllocDeviceResp) {
        onAllocDeviceResult(cGAllocDeviceResp, 2);
    }

    private void queryColdStartDeviceAfterGapTime(final int i3) {
        CGLog.i("queryColdStartDeviceAfterGapTime: " + this.mWaitNextQueryColdStartGap + ", mColdStartDeviceId: " + this.mColdStartDeviceId);
        cancelQueryColdStartDeviceTask();
        if (this.mStopped.get()) {
            return;
        }
        if (CGStringUtil.notEmpty(this.mColdStartDeviceId)) {
            this.mQueryColdStartTimerTask = this.mQueryColdStartTimer.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.aj
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlayAllocatorImpl.this.lambda$queryColdStartDeviceAfterGapTime$12(i3);
                }
            }, getNextColdStartQueryGap(), TimeUnit.SECONDS);
        } else {
            CGLog.w("query cold device failed and device id is null!");
        }
    }

    private void queryDeviceFromShareCode() {
        this.mBizHttpService.requestAllocDeviceByShareCode(this.mShareCode, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.au
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlayAllocatorImpl.this.lambda$queryDeviceFromShareCode$5(gmCgError, (CGAllocDeviceResp) obj);
            }
        });
    }

    private void queryWaitingQueueAfterTime() {
        cancelQueryWaitingQueueIfNecessary();
        if (!this.mStopped.get() && CGStringUtil.notEmpty(this.mWaitIdIfQueueing)) {
            this.mQueryWaitingQueueTimerTask = this.mQueryWaitingQueueTimer.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.al
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlayAllocatorImpl.this.lambda$queryWaitingQueueAfterTime$11();
                }
            }, getNextQueryGap(), TimeUnit.SECONDS);
        }
    }

    private void requestAllocateDevice(List<GmCgNetDetectionInfo> list) {
        if (list == null) {
            CGLog.w("requestAllocateDevice failed, server ips is null!");
        }
        if (this.mAllocateCfg == null) {
            CGLog.w("requestAllocateDevice failed, mAllocateCfg is null!");
            internalWhenErrorHappen(GmCgError.ErrorOther);
        } else {
            this.mAllocationMonitor.reportCallAllocDevice();
            this.mBizHttpService.requestAllocateDevice(this.mAllocateCfg, list, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ak
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlayAllocatorImpl.this.lambda$requestAllocateDevice$6(gmCgError, (CGAllocDeviceResp) obj);
                }
            });
        }
    }

    private void requestCancelQueryWaitingQueue(String str) {
        CGLog.i("CGPlayAllocatorImpl requestCancelQueryWaitingQueue: " + str);
        this.mBizHttpService.requestCancelQueryWaitingQueue(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.an
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlayAllocatorImpl.this.lambda$requestCancelQueryWaitingQueue$9(gmCgError, (Void) obj);
            }
        });
    }

    private void requestQueryColdDeviceWaitingTime(String str, final int i3) {
        if (CGStringUtil.isEmpty(str)) {
            CGLog.w("CGPlayAllocatorImpl requestQueryColdDeviceWaitingTime: deviceId is empty");
        } else {
            this.mBizHttpService.requestQueryColdStartDevice(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.am
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlayAllocatorImpl.this.lambda$requestQueryColdDeviceWaitingTime$8(i3, gmCgError, (CGAllocDeviceResp) obj);
                }
            });
        }
    }

    private void requestQueryWaitingQueue(String str) {
        if (CGStringUtil.isEmpty(str)) {
            CGLog.w("CGPlayAllocatorImpl requestQueryWaitingQueue: waitId is empty");
        } else if (this.mQueuePaused.get()) {
            CGLog.w("CGPlayAllocatorImpl requestQueryWaitingQueue: queue is paused");
            queryWaitingQueueAfterTime();
        } else {
            this.mBizHttpService.requestQueryWaitingQueue(str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ae
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlayAllocatorImpl.this.lambda$requestQueryWaitingQueue$7(gmCgError, (CGAllocDeviceResp) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAllocateDetail() {
        this.mStopped.set(false);
        this.mFistUpdate.set(true);
        CGClientEnvHelper.get().refresh();
        checkQualification();
    }

    private void updateProcessColdStart(final GmCgColdStartDeviceInfo gmCgColdStartDeviceInfo) {
        cancelUpdateColdStartProcessTask();
        if (this.mStopped.get()) {
            return;
        }
        if (this.mColdStartTime > 0) {
            CGLog.i("really updateProcessColdStart mColdStartTime: " + this.mColdStartTime + ", mColdStartTimeProcess: " + this.mColdStartTimeProcess);
            this.mUpdateProcessColdStartTimerTask = this.mUpdateProcessColdStartTimer.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.as
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlayAllocatorImpl.this.lambda$updateProcessColdStart$10(gmCgColdStartDeviceInfo);
                }
            }, 0L, this.mColdStartTime * 10, TimeUnit.MILLISECONDS);
            return;
        }
        CGLog.w("updateProcessColdStart error!");
    }

    private void useFixedIpAllocDevice(String str) {
        CGLog.i("useFixedIpAllocDevice ip: " + str);
        requestAllocateDevice(new ArrayList<GmCgNetDetectionInfo>(new GmCgNetDetectionInfo.Builder().setIpAddress(str).setAgvDelay(5.0f).setAgvLoss(0.0f).setRealIpAddress(str).build()) { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlayAllocatorImpl.2
            final /* synthetic */ GmCgNetDetectionInfo val$netDetectionInfo;

            {
                this.val$netDetectionInfo = r2;
                add(r2);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void cancelQueue() {
        CGLog.i("CGPlayAllocatorImpl cancelQueue");
        internalCancelQueueIfNeed();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgDetectorError(@NonNull final GmCgError gmCgError) {
        CGLog.i("CGPlayAllocatorImpl onGmCgDetectorError: " + gmCgError.getDetailErrorMsg());
        internalWhenErrorHappen(gmCgError);
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ab
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$onGmCgDetectorError$20(gmCgError);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgDetectorStart(final boolean z16, final float f16, final float f17) {
        CGLog.i("CGPlayAllocatorImpl onGmCgDetectorStart: " + z16 + "|" + f16 + "|" + f17);
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.aq
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$onGmCgDetectorStart$17(z16, f16, f17);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgDetectorUpdate(final int i3) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ai
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$onGmCgDetectorUpdate$18(i3);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgNetDetectResult(final int i3, final boolean z16, final List<GmCgNetDetectionInfo> list) {
        CGLog.i("CGPlayAllocatorImpl onGmCgNetDetectResult: " + i3 + "|" + z16);
        requestAllocateDevice(list);
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ap
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayAllocatorImpl.this.lambda$onGmCgNetDetectResult$19(i3, z16, list);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void pauseQueue() {
        CGLog.i("CGPlayAllocatorImpl pauseQueue");
        this.mQueuePaused.set(true);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void restartAllocate(int i3, String str) {
        this.mIdentityProfileType = i3;
        if (CGStringUtil.notEmpty(str)) {
            this.mBizInfo = str;
        }
        GmCgAllocatorCfg gmCgAllocatorCfg = this.mAllocateCfg;
        if (gmCgAllocatorCfg != null) {
            gmCgAllocatorCfg.pIdentityProfileType = this.mIdentityProfileType;
            gmCgAllocatorCfg.pBizExtraInfo = this.mBizInfo;
        }
        boolean z16 = true;
        stopAllocate(true);
        CGQualificationChecker cGQualificationChecker = this.mQualificationChecker;
        if (cGQualificationChecker != null) {
            if (1 != this.mIdentityProfileType) {
                z16 = false;
            }
            cGQualificationChecker.shouldCheckVip(z16);
        }
        startAllocate();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void resumeQueue() {
        CGLog.i("CGPlayAllocatorImpl resumeQueue");
        this.mQueuePaused.set(false);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void setAuthRefreshListener(GmCgAuthRefreshListener gmCgAuthRefreshListener) {
        CGQualificationChecker cGQualificationChecker = this.mQualificationChecker;
        if (cGQualificationChecker != null) {
            cGQualificationChecker.setAuthRefreshListener(gmCgAuthRefreshListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void setPlayAllocatorListener(GmCgPlayAllocatorListener gmCgPlayAllocatorListener) {
        this.mPlayAllocatorListener = gmCgPlayAllocatorListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void setPlayDetectorListener(GmCgPlayDetectorListener gmCgPlayDetectorListener) {
        this.mPlayDetectorListener = gmCgPlayDetectorListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void startAllocate() {
        final boolean isQtvBizChannel = GmCgSdk.isQtvBizChannel();
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_ALLOC_DEVICE, true);
        if (!CGGlbConfig.sEnableSuperResolution) {
            CGLog.w(TAG_FSR, "startAllocate() \u5173\u95ed\u8d85\u5206\u529f\u80fd");
            GmCgAllocatorCfg gmCgAllocatorCfg = this.mAllocateCfg;
            if (gmCgAllocatorCfg != null) {
                gmCgAllocatorCfg.pSuperResolutionType = 0;
            }
            if (isQtvBizChannel) {
                this.mBizHttpService.requestGetGameConfig(this.mCgGameId, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.af
                    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                    public final void onResult(GmCgError gmCgError, Object obj) {
                        CGPlayAllocatorImpl.this.lambda$startAllocate$0(gmCgError, (CGGameConfigResp) obj);
                    }
                });
                return;
            } else {
                startAllocateDetail();
                return;
            }
        }
        if (CGGlbConfig.sForceFsr) {
            CGLog.w(TAG_FSR, "startAllocate() \u672c\u5730\u5f3a\u5236\u5f00\u542f\u8d85\u5206");
            GmCgAllocatorCfg gmCgAllocatorCfg2 = this.mAllocateCfg;
            if (gmCgAllocatorCfg2 != null) {
                gmCgAllocatorCfg2.pSuperResolutionType = 2;
            }
            if (isQtvBizChannel) {
                this.mBizHttpService.requestGetGameConfig(this.mCgGameId, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ag
                    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                    public final void onResult(GmCgError gmCgError, Object obj) {
                        CGPlayAllocatorImpl.this.lambda$startAllocate$1(gmCgError, (CGGameConfigResp) obj);
                    }
                });
                return;
            } else {
                startAllocateDetail();
                return;
            }
        }
        this.mBizHttpService.requestGetGameConfig(this.mCgGameId, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ah
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlayAllocatorImpl.this.lambda$startAllocate$2(isQtvBizChannel, gmCgError, (CGGameConfigResp) obj);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocator
    public void stopAllocate(boolean z16) {
        this.mStopped.set(true);
        CGPlayDetectorImpl cGPlayDetectorImpl = this.mPlayNetDetector;
        if (cGPlayDetectorImpl != null) {
            cGPlayDetectorImpl.stopDetector();
        }
        cancelQueryWaitingQueueIfNecessary();
        cancelQueryColdStartDeviceTask();
        cancelUpdateColdStartProcessTask();
        cancelBizHttpService();
        clearLocalColdStartInfo();
        if (z16) {
            internalCancelQueueIfNeed();
        } else {
            clearLocalQueueWaiting();
        }
        CGLocationGetter cGLocationGetter = this.mLocationGetter;
        if (cGLocationGetter != null) {
            cGLocationGetter.stopGetLocation();
        }
    }
}
