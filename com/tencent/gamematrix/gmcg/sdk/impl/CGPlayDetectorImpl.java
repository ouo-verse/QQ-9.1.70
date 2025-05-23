package com.tencent.gamematrix.gmcg.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayNetDetector;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.base.delaycount.GmCgDelayCounter;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer;
import com.tencent.gamematrix.gmcg.sdk.impl.CGQualificationChecker;
import com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGDetectNetResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGGetIpAddressResp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class CGPlayDetectorImpl implements GmCgPlayNetDetector {
    private static final int DETECTION_NET_TIME_OUT_TOTAL = 15;
    private static final int DETECTION_UPDATE_PERIOD = 40;
    private CGBizHttpService mBizHttpService;
    private CGHandlerTimer.TimerTask mDetectNetOutTimerTask;
    private CGHandlerTimer mDetectNetTimer;
    private CGHandlerTimer.TimerTask mDetectNetTimerTask;
    private int mDetectionProgress;
    private String mGameTag;
    private Handler mMainHandler;
    private GmCgPlayDetectorListener mPlayDetectorListener;
    private CGQualificationChecker mQualificationChecker;
    private boolean mUseIpToDetect;

    private void cancelBizHttpService() {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.cancel();
        }
    }

    private void cancelDetectUpdateIfNecessary() {
        CGHandlerTimer.TimerTask timerTask = this.mDetectNetTimerTask;
        if (timerTask != null) {
            this.mDetectNetTimer.cancel(timerTask);
        }
    }

    private void cancelLaunchTimeoutDetectorTimer() {
        CGHandlerTimer.TimerTask timerTask = this.mDetectNetOutTimerTask;
        if (timerTask != null) {
            this.mDetectNetTimer.cancel(timerTask);
        }
    }

    private void checkQualification() {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_AUTH_USER, true);
        this.mQualificationChecker.check(this.mBizHttpService, new CGQualificationChecker.CGQualificationCheckResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bb
            @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGQualificationChecker.CGQualificationCheckResultListener
            public final void onCGQualificationCheckResult(GmCgError gmCgError) {
                CGPlayDetectorImpl.this.lambda$checkQualification$8(gmCgError);
            }
        });
    }

    private void checkStartDetectNet() {
        if (!CGNetDetectionManager.get().hasNetDetectionCache()) {
            CGLog.i("CGPlayDetectorImpl checkStartDetectNet need do new detection");
            GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_GATEWAY, true);
            CGBizHttpService cGBizHttpService = this.mBizHttpService;
            if (cGBizHttpService != null) {
                cGBizHttpService.requestGateWayIpAddress(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.av
                    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                    public final void onResult(GmCgError gmCgError, Object obj) {
                        CGPlayDetectorImpl.this.lambda$checkStartDetectNet$2(gmCgError, (CGGetIpAddressResp) obj);
                    }
                });
                return;
            }
            return;
        }
        internalStartNetDetect(false, 0.0f, 0.0f);
        CGLog.i("CGPlayDetectorImpl checkStartDetectNet not need detection");
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_SPEED_TEST, true);
        CGNetDetectionManager.get().detectionNetDelay(new aw(this));
    }

    public static CGPlayDetectorImpl create(@NonNull String str) {
        return create(str, false);
    }

    private void doStarDetectAfterQualification() {
        checkStartDetectNet();
    }

    private void innerStartDetectNet(List<CGGetIpAddressResp.GatewayBean> list) {
        CGLog.i("CGPlayDetectorImpl innerStartDetectNet");
        updateDetectionNetProgress();
        startLaunchTimeoutDetectorTimer();
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_SPEED_TEST, true);
        CGNetDetectionManager.get().detectionNetDelayByIps(new aw(this), list);
    }

    private void internalStartNetDetect(final boolean z16, final float f16, final float f17) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ay
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayDetectorImpl.this.lambda$internalStartNetDetect$6(z16, f16, f17);
            }
        });
    }

    private void internalStopDetector() {
        cancelBizHttpService();
        this.mDetectionProgress = 0;
        cancelDetectUpdateIfNecessary();
        cancelLaunchTimeoutDetectorTimer();
        CGNetDetectionManager.get().cancelDetectNet();
    }

    private void internalWhenErrorHappen(final GmCgError gmCgError) {
        CGLog.i("CGPlayDetectorImpl internalWhenErrorHappen: " + gmCgError.getDetailErrorMsg());
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ax
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayDetectorImpl.this.lambda$internalWhenErrorHappen$7(gmCgError);
            }
        });
    }

    private void internalWhenNetDetected(final int i3, final boolean z16, final List<GmCgNetDetectionInfo> list) {
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ba
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayDetectorImpl.this.lambda$internalWhenNetDetected$5(i3, z16, list);
            }
        });
    }

    private void internalWhenNetDetecting(final int i3) {
        CGLog.d("CGPlayDetectorImpl internalWhenNetDetecting progress: " + i3);
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.az
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayDetectorImpl.this.lambda$internalWhenNetDetecting$3(i3);
            }
        });
    }

    public /* synthetic */ void lambda$checkQualification$8(GmCgError gmCgError) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_AUTH_USER, false);
        if (GmCgError.isOK(gmCgError)) {
            doStarDetectAfterQualification();
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    public /* synthetic */ void lambda$checkStartDetectNet$2(GmCgError gmCgError, CGGetIpAddressResp cGGetIpAddressResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_GATEWAY, false);
        if (GmCgError.isOK(gmCgError)) {
            internalStartNetDetect(true, cGGetIpAddressResp.rtt_threshold, cGGetIpAddressResp.lost_rate_threshold);
            innerStartDetectNet(cGGetIpAddressResp.getGateway());
        } else {
            CGLog.w("CGPlayDetectorImpl requestGateWayIpAddress failed!");
            innerStartDetectNet(new ArrayList());
        }
    }

    public /* synthetic */ void lambda$internalStartNetDetect$6(boolean z16, float f16, float f17) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgDetectorStart(z16, f16, f17);
        }
    }

    public /* synthetic */ void lambda$internalWhenErrorHappen$7(GmCgError gmCgError) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgDetectorError(gmCgError);
        }
        internalStopDetector();
    }

    public /* synthetic */ void lambda$internalWhenNetDetected$5(int i3, boolean z16, List list) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgNetDetectResult(i3, z16, list);
        }
    }

    public /* synthetic */ void lambda$internalWhenNetDetecting$3(int i3) {
        GmCgPlayDetectorListener gmCgPlayDetectorListener = this.mPlayDetectorListener;
        if (gmCgPlayDetectorListener != null) {
            gmCgPlayDetectorListener.onGmCgDetectorUpdate(i3);
        }
    }

    public /* synthetic */ void lambda$requestNetDetectResult$4(List list, GmCgError gmCgError, CGDetectNetResp cGDetectNetResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_SPEED_TEST, false);
        if (cGDetectNetResp != null) {
            if (GmCgError.isOK(gmCgError)) {
                if (cGDetectNetResp.speedTestResult != 1 || !cGDetectNetResp.areaSupport) {
                    CGNetDetectionManager.get().clearCacheNetDelayDetection();
                }
                onDetectionNetResult(cGDetectNetResp, list);
            } else {
                CGNetDetectionManager.get().clearCacheNetDelayDetection();
                onDetectionNetError(gmCgError);
            }
        } else {
            onDetectionNetError(gmCgError);
        }
        cancelDetectUpdateIfNecessary();
        this.mDetectionProgress = 0;
    }

    public /* synthetic */ void lambda$startLaunchTimeoutDetectorTimer$0() {
        internalWhenErrorHappen(GmCgError.ErrorNetDetectionTimeOut);
    }

    public /* synthetic */ void lambda$updateDetectionNetProgress$1() {
        int i3;
        if (this.mPlayDetectorListener != null && (i3 = this.mDetectionProgress) < 100) {
            internalWhenNetDetecting(i3);
            this.mDetectionProgress += 2;
        }
    }

    private void onDetectionNetError(GmCgError gmCgError) {
        CGLog.i("onDetectionNetError: " + gmCgError.getDetailErrorMsg());
        internalWhenNetDetected(-1, false, null);
        this.mDetectionProgress = 100;
        internalWhenNetDetecting(100);
    }

    private void onDetectionNetResult(CGDetectNetResp cGDetectNetResp, List<GmCgNetDetectionInfo> list) {
        CGLog.i("CGPlayDetectorImpl onDetectionNetResult ret: " + cGDetectNetResp.ret);
        internalWhenNetDetected(cGDetectNetResp.speedTestResult, cGDetectNetResp.areaSupport, list);
        this.mDetectionProgress = 100;
        internalWhenNetDetecting(100);
    }

    public synchronized void requestNetDetectResult(final List<GmCgNetDetectionInfo> list) {
        cancelLaunchTimeoutDetectorTimer();
        CGLog.i("CGPlayDetectorImpl requestNetDetectResult");
        if (list != null && list.size() > 0) {
            CGLog.i("CGPlayDetectorImpl requestNetDetectResult, size: " + list.size());
        }
        this.mBizHttpService.requestDetectionNet(this.mGameTag, list, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.be
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlayDetectorImpl.this.lambda$requestNetDetectResult$4(list, gmCgError, (CGDetectNetResp) obj);
            }
        });
    }

    private void startLaunchTimeoutDetectorTimer() {
        cancelLaunchTimeoutDetectorTimer();
        this.mDetectNetOutTimerTask = this.mDetectNetTimer.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bd
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayDetectorImpl.this.lambda$startLaunchTimeoutDetectorTimer$0();
            }
        }, 15L, TimeUnit.SECONDS);
    }

    private void updateDetectionNetProgress() {
        cancelDetectUpdateIfNecessary();
        if (this.mDetectionProgress > 99) {
            this.mDetectionProgress = 99;
        }
        this.mDetectNetTimerTask = this.mDetectNetTimer.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bc
            @Override // java.lang.Runnable
            public final void run() {
                CGPlayDetectorImpl.this.lambda$updateDetectionNetProgress$1();
            }
        }, 0L, 40L, TimeUnit.MILLISECONDS);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayNetDetector
    public void restartDetector() {
        CGNetDetectionManager.get().clearCacheNetDelayDetection();
        internalStopDetector();
        startDetector();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayNetDetector
    public void setPlayDetectorListener(GmCgPlayDetectorListener gmCgPlayDetectorListener) {
        this.mPlayDetectorListener = gmCgPlayDetectorListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayNetDetector
    public void startDetector() {
        CGNetDetectionManager.get().setUseIp(this.mUseIpToDetect);
        checkQualification();
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayNetDetector
    public void stopDetector() {
        CGLog.i("CGPlayDetectorImpl stopDetector!");
        internalStopDetector();
        this.mPlayDetectorListener = null;
    }

    public static CGPlayDetectorImpl create(@NonNull String str, boolean z16) {
        CGPlayDetectorImpl cGPlayDetectorImpl = new CGPlayDetectorImpl();
        cGPlayDetectorImpl.mGameTag = str;
        cGPlayDetectorImpl.mUseIpToDetect = z16;
        cGPlayDetectorImpl.mMainHandler = new Handler(Looper.getMainLooper());
        cGPlayDetectorImpl.mDetectNetTimer = new CGHandlerTimer();
        cGPlayDetectorImpl.mBizHttpService = new CGBizHttpService();
        cGPlayDetectorImpl.mQualificationChecker = new CGQualificationChecker(true);
        return cGPlayDetectorImpl;
    }
}
