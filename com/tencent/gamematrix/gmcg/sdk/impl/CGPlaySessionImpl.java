package com.tencent.gamematrix.gmcg.sdk.impl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamematrix.gmcg.api.GmCgApiService;
import com.tencent.gamematrix.gmcg.api.GmCgAuthRefreshListener;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.GmCgError;
import com.tencent.gamematrix.gmcg.api.GmCgFramerateDef;
import com.tencent.gamematrix.gmcg.api.GmCgGameCodecConfig;
import com.tencent.gamematrix.gmcg.api.GmCgImeInputController;
import com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayPerfListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayPushEventListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatus;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener;
import com.tencent.gamematrix.gmcg.api.GmCgResolutionDef;
import com.tencent.gamematrix.gmcg.api.GmCgSdkScreenShotListener;
import com.tencent.gamematrix.gmcg.api.GmCgSessionStatus;
import com.tencent.gamematrix.gmcg.api.GmCgSuperResolutionType;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocateDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgAllocatorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoginConfigInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoginInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameSensorCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgPlayPerfInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgSessionCfg;
import com.tencent.gamematrix.gmcg.base.delaycount.GmCgDelayCounter;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.task.CGHandlerTimer;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGNetworkUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGPermissionUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import com.tencent.gamematrix.gmcg.sdk.env.CGClientEnvHelper;
import com.tencent.gamematrix.gmcg.sdk.event.CGDcEventHelper;
import com.tencent.gamematrix.gmcg.sdk.event.CGPushEventHelper;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDEventCloudAppWindowStatusRequest;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidGameConfig;
import com.tencent.gamematrix.gmcg.sdk.impl.CGLocationGetter;
import com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl;
import com.tencent.gamematrix.gmcg.sdk.impl.CGSessionMonitor;
import com.tencent.gamematrix.gmcg.sdk.impl.CGStreamQualityAdjuster;
import com.tencent.gamematrix.gmcg.sdk.nonage.CGNonAgeProtectModule;
import com.tencent.gamematrix.gmcg.sdk.nonage.bean.CGFaceRecognitionResult;
import com.tencent.gamematrix.gmcg.sdk.service.CGAllocDeviceInfo;
import com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService;
import com.tencent.gamematrix.gmcg.sdk.service.CGCommonResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGGameConfigResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGGetIpAddressResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGHoldDeviceResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGLoadArchiveReqBody;
import com.tencent.gamematrix.gmcg.sdk.service.CGMergeLaunchCloudGameReqBody;
import com.tencent.gamematrix.gmcg.sdk.service.CGMergeLaunchCloudGameResp;
import com.tencent.gamematrix.gmcg.sdk.service.CGModelAbility;
import com.tencent.gamematrix.gmcg.sdk.service.CGServerProvider;
import com.tencent.gamematrix.gmcg.sdk.service.CGSetCloudGameResolutionReqBody;
import com.tencent.gamematrix.gmcg.sdk.service.CGSetMidasPropReqBody;
import com.tencent.gamematrix.gmcg.sdk.service.CGYybCloudGameLoginReqBody;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgPlaySessionViewHolder;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgPlayTextureView;
import com.tencent.gamematrix.gmcg.sdk.view.GmCgPlayView;
import com.tencent.gamematrix.gmcg.webrtc.CGSessionCtx;
import com.tencent.gamematrix.gmcg.webrtc.DeviceConfig;
import com.tencent.gamematrix.gmcg.webrtc.DeviceUtils;
import com.tencent.gamematrix.gmcg.webrtc.GmCgClientType;
import com.tencent.gamematrix.gmcg.webrtc.GmCgConnectionEvent;
import com.tencent.gamematrix.gmcg.webrtc.GmCgSubScribeEvent;
import com.tencent.gamematrix.gmcg.webrtc.PerfValue;
import com.tencent.gamematrix.gmcg.webrtc.ReportPerfValue;
import com.tencent.gamematrix.gmcg.webrtc.VideoCodecType;
import com.tencent.gamematrix.gmcg.webrtc.VideoFilterParams;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCParameters;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IKeyMapListener;
import com.tencent.gamematrix.gmcg.webrtc.sdp.SdpHelper;
import com.tencent.gamematrix.gmvideofilter.VideoFilter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;
import org.tencwebrtc.Loggable;
import org.tencwebrtc.Logging;

/* loaded from: classes6.dex */
public class CGPlaySessionImpl implements GmCgPlaySession, WebRTCEvents, GmCgPlayAllocatorListener, GmCgPlayDetectorListener, CGStreamQualityAdjuster.StreamQualityAction, CGDcEventHelper.DcEventRawSendAction, CGSessionMonitor.ReportInfoProvider {
    private static final String TAG_FSR = "GMCG_FSR";
    private static final int VIDEO_FILTER_LR_HEIGHT = 1280;
    private static final int VIDEO_FILTER_LR_WIDTH = 720;
    private static final int VIDEO_FILTER_SCALE = 2;
    private static final int mConnectionTimeoutTVjinnanCUCC = 30;
    private Activity mActivity;
    protected GmCgAllocatorCfg mAllocatorCfg;
    private GmCgAuthRefreshListener mAuthRefreshListener;
    private CGBizHttpService mBizHttpService;
    protected Context mContext;
    private GmCgPlayStatus mCurPlayStatus;
    private CGDcEventHelper mDcEventHelper;
    protected GmCgDeviceInfo mDeviceReadyToUse;
    private GmCgGameLoginInfo mGameAutoLoginInfo;
    private CGGameConfigResp mGameConfigResp;
    private GmCgImeInputController mImeInputController;
    private GmCgError mLastPlayError;
    private GmCgPlayStatus mLastPlayStatus;
    private int mLastTouchEventState;
    private CGHandlerTimer mLaunchTimeoutCheckTimer;
    private CGHandlerTimer.TimerTask mLaunchTimeoutCheckTimerTask;
    private CGLocationGetter mLocationGetter;
    private Handler mMainHandler;
    private int mNoTouchEventTime;
    private ScheduledExecutorService mPeriodExecutorService;
    private CGPlayAllocatorImpl mPlayAllocator;
    private GmCgPlayAllocatorListener mPlayAllocatorListener;
    private GmCgPlayDcEventListener mPlayDcEventListener;
    private GmCgPlayPerfListener mPlayPerfListener;
    private GmCgPlayPushEventListener mPlayPushEventListener;
    private GmCgPlayStatusListener mPlayStatusListener;
    private CGPushEventHelper mPushEventHelper;
    private CGQualificationChecker mQualificationChecker;
    protected GmCgSessionCfg mSessionCfg;
    protected CGSessionCtx mSessionCtx;
    protected CGSessionMonitor mSessionMonitor;
    private CGStreamQualityAdjuster mStreamQualityAdjuster;
    private ScheduledFuture<?> mTouchCountsSchedulder;
    private WebRTCParameters mWebRTCParameters;
    protected WebRTCSDK mWebRTCSdk;
    protected boolean mUseTextureView = false;

    @NonNull
    protected String mCgGameId = "unknown";
    private GmCgSessionStatus mCurSessionStatus = GmCgSessionStatus.StatusSessionStart;
    private boolean mFirstFrameRendered = false;
    private final Set<Integer> mServerConnCloseErrors = new HashSet();
    private String mCandidateIp = "unknown";
    private String mLocalNetCarrier = "unknown";
    private String mRemoteNetCarrier = "unknown";
    private boolean mSupportNetFreeFlow = false;
    private boolean mRealNetFreeFlow = false;
    private String mLocalClientProvince = "unknown";
    private String mLocalClientIp = "unknown";
    private volatile boolean mRestarted = false;
    private Runnable mPausingTask = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.br
        @Override // java.lang.Runnable
        public final void run() {
            CGPlaySessionImpl.this.internalStopPlay();
        }
    };
    private final Runnable mUpdateFinishStateTask = new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bs
        @Override // java.lang.Runnable
        public final void run() {
            CGPlaySessionImpl.this.lambda$new$0();
        }
    };
    private int mInGameLoginChannelType = 0;
    private String mInGameLoginDefaultParam = "";
    private String mInGameLoginYybParam = "";
    private boolean mHasLoadArchiveProcess = false;
    private boolean mDeviceIsNewAllocated = true;
    private boolean mForPreview = false;
    private String mTgpaPingValue = "-1";
    private String mGameCodecConfig = "";
    private boolean mUsingVDecoder = false;

    @NonNull
    protected GmCgGameConfigInfo mGameConfigInfo = new GmCgGameConfigInfo();

    @NonNull
    protected GmCgPlaySessionViewHolder mPlaySessionViewHolder = new GmCgPlaySessionViewHolder();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl$12, reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass12 implements Runnable {
        AnonymousClass12() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (CGPlaySessionImpl.this.mPlayDcEventListener != null) {
                CGPlaySessionImpl.this.mPlayDcEventListener.onGmCgSendTouchEvent(2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(int i3) {
            if (CGPlaySessionImpl.this.mPlayDcEventListener != null) {
                CGPlaySessionImpl.this.mPlayDcEventListener.onGmCgSendTouchEvent(i3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
        
            if (r0.mNoTouchEventTime >= r5.this$0.mSessionCfg.pNoTouchEventCallbackTimeSeconds) goto L25;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            final int i3;
            if (CGPlaySessionImpl.this.mPlayDcEventListener != null) {
                int touchEventCounts = CGPlaySessionImpl.this.getTouchEventCounts();
                if (touchEventCounts > 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (touchEventCounts != 0) {
                    CGPlaySessionImpl.this.mNoTouchEventTime = 0;
                } else {
                    CGPlaySessionImpl.access$508(CGPlaySessionImpl.this);
                }
                CGLog.d("onGmCgSendTouchEvent counts: " + touchEventCounts + ", mLastTouchEventState: " + CGPlaySessionImpl.this.mLastTouchEventState + ", mNoTouchEventTime: " + CGPlaySessionImpl.this.mNoTouchEventTime + ", pNoTouchLongTime: " + CGPlaySessionImpl.this.mSessionCfg.pNoTouchLongTime);
                if (CGPlaySessionImpl.this.mNoTouchEventTime > 0) {
                    CGPlaySessionImpl cGPlaySessionImpl = CGPlaySessionImpl.this;
                    if (cGPlaySessionImpl.mSessionCfg.pNoTouchLongTime > 0) {
                        int i16 = cGPlaySessionImpl.mNoTouchEventTime;
                        CGPlaySessionImpl cGPlaySessionImpl2 = CGPlaySessionImpl.this;
                        if (i16 == cGPlaySessionImpl2.mSessionCfg.pNoTouchLongTime) {
                            cGPlaySessionImpl2.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.do
                                @Override // java.lang.Runnable
                                public final void run() {
                                    CGPlaySessionImpl.AnonymousClass12.this.lambda$run$0();
                                }
                            });
                        }
                    }
                }
                if (CGPlaySessionImpl.this.mLastTouchEventState != i3) {
                    if (i3 != 1) {
                        CGPlaySessionImpl cGPlaySessionImpl3 = CGPlaySessionImpl.this;
                        if (cGPlaySessionImpl3.mSessionCfg != null) {
                        }
                    }
                    CGPlaySessionImpl.this.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dp
                        @Override // java.lang.Runnable
                        public final void run() {
                            CGPlaySessionImpl.AnonymousClass12.this.lambda$run$1(i3);
                        }
                    });
                    CGPlaySessionImpl.this.mLastTouchEventState = i3;
                }
            }
            CGPlaySessionImpl.this.clearTouchEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl$13, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState;
        static final /* synthetic */ int[] $SwitchMap$org$tencwebrtc$Logging$Severity;

        static {
            int[] iArr = new int[Logging.Severity.values().length];
            $SwitchMap$org$tencwebrtc$Logging$Severity = iArr;
            try {
                iArr[Logging.Severity.LS_VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Logging.Severity.LS_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Logging.Severity.LS_WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$tencwebrtc$Logging$Severity[Logging.Severity.LS_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[WebRTCEvents.ConnectionState.values().length];
            $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState = iArr2;
            try {
                iArr2[WebRTCEvents.ConnectionState.STATE_BEGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState[WebRTCEvents.ConnectionState.STATE_OFFER_ANSWERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState[WebRTCEvents.ConnectionState.STATE_ICE_RECEIVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState[WebRTCEvents.ConnectionState.STATE_ICE_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState[WebRTCEvents.ConnectionState.STATE_WEBRTC_CONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState[WebRTCEvents.ConnectionState.STATE_FIRST_FRAME_RENDERED.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState[WebRTCEvents.ConnectionState.STATE_WEBRTC_TIMEOUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl$8, reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass8 implements GmCgSdkScreenShotListener {
        final /* synthetic */ boolean[] val$isTimeout;
        final /* synthetic */ GmCgSdkScreenShotListener val$sdkScreenShotListener;
        final /* synthetic */ CGHandlerTimer val$timer;
        final /* synthetic */ CGHandlerTimer.TimerTask[] val$timerTasks;

        AnonymousClass8(CGHandlerTimer.TimerTask[] timerTaskArr, boolean[] zArr, CGHandlerTimer cGHandlerTimer, GmCgSdkScreenShotListener gmCgSdkScreenShotListener) {
            this.val$timerTasks = timerTaskArr;
            this.val$isTimeout = zArr;
            this.val$timer = cGHandlerTimer;
            this.val$sdkScreenShotListener = gmCgSdkScreenShotListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onScreenShotResult$0(CGHandlerTimer.TimerTask[] timerTaskArr, boolean[] zArr, CGHandlerTimer cGHandlerTimer, GmCgSdkScreenShotListener gmCgSdkScreenShotListener, Bitmap bitmap) {
            CGHandlerTimer.TimerTask timerTask = timerTaskArr[0];
            if (timerTask != null && zArr[0]) {
                CGLog.w("already execute timeout, do not call onScreenShotResult!!");
                return;
            }
            if (timerTask != null) {
                CGLog.i("stop timeout");
                cGHandlerTimer.cancel(timerTaskArr[0]);
            }
            if (gmCgSdkScreenShotListener != null) {
                CGLog.i("call onScreenShotResult");
                gmCgSdkScreenShotListener.onScreenShotResult(bitmap);
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgSdkScreenShotListener
        public void onScreenShotResult(@Nullable final Bitmap bitmap) {
            CGPlaySessionImpl cGPlaySessionImpl = CGPlaySessionImpl.this;
            final CGHandlerTimer.TimerTask[] timerTaskArr = this.val$timerTasks;
            final boolean[] zArr = this.val$isTimeout;
            final CGHandlerTimer cGHandlerTimer = this.val$timer;
            final GmCgSdkScreenShotListener gmCgSdkScreenShotListener = this.val$sdkScreenShotListener;
            cGPlaySessionImpl.runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dq
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.AnonymousClass8.lambda$onScreenShotResult$0(timerTaskArr, zArr, cGHandlerTimer, gmCgSdkScreenShotListener, bitmap);
                }
            });
        }
    }

    private void CGSessionLogD(String str) {
        CGLog.d("CGPlaySessionImpl@[" + getLocalSessionId() + "]@" + getActivityHashCode() + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CGSessionLogE(String str) {
        CGLog.e("CGPlaySessionImpl@[" + getLocalSessionId() + "]@" + getActivityHashCode() + " " + str);
    }

    private void CGSessionLogI(String str) {
        CGLog.i("CGPlaySessionImpl@[" + getLocalSessionId() + "]@" + getActivityHashCode() + " " + str);
    }

    private void CGSessionLogW(String str) {
        CGLog.w("CGPlaySessionImpl@[" + getLocalSessionId() + "]@" + getActivityHashCode() + " " + str);
    }

    static /* synthetic */ int access$508(CGPlaySessionImpl cGPlaySessionImpl) {
        int i3 = cGPlaySessionImpl.mNoTouchEventTime;
        cGPlaySessionImpl.mNoTouchEventTime = i3 + 1;
        return i3;
    }

    private void afterAssembleSuperResolutionConfig(CGGameConfigResp cGGameConfigResp) {
        CGGameConfigResp.VideoCodingBean videoCodingForH264;
        CGGameConfigResp.VideoCodingBean videoCodingForH265;
        CGSessionLogI("afterAssembleSuperResolutionConfig");
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null) {
            cGGameConfigResp.updateVideoCodingStreamQualityBean(gmCgDeviceInfo.hardwareType);
        }
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        int i3 = gmCgSessionCfg.pFeatSwitchForLocalImeInput;
        if (i3 != 1) {
            if (i3 != 2) {
                this.mGameConfigInfo.pEnableLocalInput = false;
            }
        } else {
            this.mGameConfigInfo.pEnableLocalInput = true;
        }
        if (gmCgSessionCfg.pUseLegacyStreamQualityCfg) {
            getStreamQualityAdjuster().setGameStreamCfgForLegacy(this.mGameConfigInfo.pStreamQualityCfg);
        } else {
            CGStreamQualityAdjuster streamQualityAdjuster = getStreamQualityAdjuster();
            GmCgSessionCfg gmCgSessionCfg2 = this.mSessionCfg;
            streamQualityAdjuster.forceUseCustomDecType(gmCgSessionCfg2.pForceUseCustomDecType, gmCgSessionCfg2.pForceUseDecH265, gmCgSessionCfg2.pForceUseDecSoft);
            if (this.mGameConfigInfo.pSupportSuperResolutionType == 2) {
                StringBuilder sb5 = new StringBuilder("afterAssembleSuperResolutionConfig() \u5f00\u542f\u8d85\u5206 ");
                videoCodingForH264 = cGGameConfigResp.getVideoCodingForH264FSR();
                videoCodingForH265 = cGGameConfigResp.getVideoCodingForH265FSR();
                if (videoCodingForH264 != null) {
                    sb5.append("\u4f7f\u7528H264\u8d85\u5206\u7801\u7387 ");
                } else {
                    videoCodingForH264 = cGGameConfigResp.getVideoCodingForH264();
                    sb5.append("\u4f7f\u7528H264\u5e38\u89c4\u7801\u7387 ");
                }
                if (videoCodingForH265 != null) {
                    sb5.append("\u4f7f\u7528H265\u8d85\u5206\u7801\u7387 ");
                } else {
                    videoCodingForH265 = cGGameConfigResp.getVideoCodingForH265();
                    sb5.append("\u4f7f\u7528H265\u5e38\u89c4\u7801\u7387 ");
                }
                CGLog.i(TAG_FSR, sb5.toString());
            } else {
                CGLog.i(TAG_FSR, "afterAssembleSuperResolutionConfig() \u672a\u5f00\u542f\u8d85\u5206 \u4f7f\u7528\u5e38\u89c4\u7801\u7387");
                videoCodingForH264 = cGGameConfigResp.getVideoCodingForH264();
                videoCodingForH265 = cGGameConfigResp.getVideoCodingForH265();
            }
            getStreamQualityAdjuster().setGameStreamCfgFromServer(videoCodingForH264, videoCodingForH265, this.mGameConfigInfo.pSupportSuperResolutionType, isDeviceForVip());
        }
        CGLog.i(TAG_FSR, "afterAssembleSuperResolutionConfig enter StatusGameConfigGot");
        this.mGameCodecConfig = this.mGameConfigInfo.pGameCodecConfig.asString();
        setupViewHolderAfterGameConfig();
        initGpsManagerForWebRtcIfNecessary();
        internalUpdateStatusWithData(GmCgPlayStatus.StatusGameConfigGot, this.mGameConfigInfo);
    }

    private void afterGotGameConfigSuccess(@NonNull CGGameConfigResp cGGameConfigResp) {
        boolean z16;
        CGModelAbility.DeviceLib deviceLib;
        String str;
        CGLog.i("afterGotGameConfigSuccess");
        this.mGameConfigInfo = cGGameConfigResp.toGmCgGameConfigInfo();
        this.mGameConfigResp = cGGameConfigResp;
        CGModelAbility cGModelAbility = cGGameConfigResp.modelAbility;
        if (cGModelAbility != null && (deviceLib = cGModelAbility.device_lib) != null && (str = deviceLib.score) != null) {
            this.mSessionCtx.pBenchmarkScore = str;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGPlaySessionImpl.afterGotGameConfigSuccess: \nSDK\u5141\u8bb8\u8d85\u5206 : ");
        sb5.append(CGGlbConfig.sEnableSuperResolution);
        sb5.append("\nSDK\u5f3a\u5236\u4f7f\u7528 fsr:");
        sb5.append(CGGlbConfig.sForceFsr);
        sb5.append("\n\u5148\u950b\u4e2d\u53f0\u5141\u8bb8\u8d85\u5206\u5b57\u6bb5 = ");
        sb5.append(this.mGameConfigInfo.pUserCanSuperResolution);
        sb5.append("\n\u5148\u950b\u4e2d\u53f0\u6709FSR\u8d85\u5206\u7801\u7387 = ");
        boolean z17 = true;
        if (cGGameConfigResp.getVideoCodingForH264FSR() == null && cGGameConfigResp.getVideoCodingForH265FSR() == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        sb5.append(z16);
        CGLog.i(TAG_FSR, sb5.toString());
        if (!CGGlbConfig.sEnableSuperResolution) {
            this.mGameConfigInfo.pSupportSuperResolutionType = 0;
        } else {
            Context context = this.mContext;
            if (context == null) {
                context = CGGlbConfig.getAppContext();
            }
            Pair<Integer, Integer> openGLESVersion = DeviceUtils.getOpenGLESVersion(context);
            if (((Integer) openGLESVersion.first).intValue() < 3 || ((Integer) openGLESVersion.second).intValue() < 1) {
                z17 = false;
            }
            CGLog.i(TAG_FSR, "\u8bbe\u5907gles\u7248\u672c: " + openGLESVersion.first + "." + openGLESVersion.second + "\n\u8bbe\u5907\u652f\u6301\u8d85\u5206 : " + z17);
            if (!z17) {
                this.mGameConfigInfo.pSupportSuperResolutionType = 0;
            } else if (CGGlbConfig.sForceFsr) {
                this.mGameConfigInfo.pSupportSuperResolutionType = 2;
            } else if (cGGameConfigResp.userCanSuperResolution) {
                this.mGameConfigInfo.pSupportSuperResolutionType = 2;
            } else {
                this.mGameConfigInfo.pSupportSuperResolutionType = 0;
            }
        }
        CGLog.i(TAG_FSR, "afterGotGameConfigSuccess \u8d85\u5206\u7c7b\u578b: " + this.mGameConfigInfo.pSupportSuperResolutionType);
        afterAssembleSuperResolutionConfig(cGGameConfigResp);
        endPrepareCloudGameData();
    }

    private void afterSRcheck(DeviceConfig deviceConfig, GmCgDeviceInfo gmCgDeviceInfo) {
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        int[] iArr = new int[3];
        if (this.mUseTextureView) {
            this.mWebRTCSdk = new WebRTCSDK(this.mContext.getApplicationContext(), this.mSessionCtx, this.mPlaySessionViewHolder.getPlayTextureView(), this);
        } else {
            this.mWebRTCSdk = new WebRTCSDK(this.mContext.getApplicationContext(), this.mSessionCtx, this.mPlaySessionViewHolder.getPlaySurfaceView(), this);
        }
        GmCgGameCodecConfig gmCgGameCodecConfig = this.mGameConfigInfo.pGameCodecConfig;
        if (gmCgGameCodecConfig != null && gmCgGameCodecConfig.pFps > 0) {
            CGLog.v("mGameConfigInfo.pGameCodecConfig.pFps = " + this.mGameConfigInfo.pGameCodecConfig.pFps);
            WebRTCSDK.setVDecoderFramerate(this.mGameConfigInfo.pGameCodecConfig.pFps);
        }
        updateWebRTCSDK(this.mWebRTCSdk);
        GmCgGameSensorCfg gmCgGameSensorCfg = this.mGameConfigInfo.pSensorCfg;
        boolean z19 = false;
        if (gmCgGameSensorCfg.pEnableAcceleration > 0) {
            iArr[0] = 1;
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (gmCgGameSensorCfg.pEnableGyro > 0) {
            iArr[i3] = 4;
            i3++;
        }
        if (gmCgGameSensorCfg.pEnableGravity > 0) {
            iArr[i3] = 9;
            i3++;
        }
        this.mWebRTCSdk.registerSensors(i3, iArr);
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (this.mGameConfigInfo.pSensorCfg.pEnableVoice > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        webRTCSDK.enableVoice(z16);
        WebRTCSDK webRTCSDK2 = this.mWebRTCSdk;
        if (this.mGameConfigInfo.pSensorCfg.pEnableGps > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        webRTCSDK2.enableLm(z17);
        if (!this.mSessionCfg.pEnableLegacyDataChannel && deviceConfig.getDeviceModel() != DeviceConfig.DeviceModel.DEVICE_VCA) {
            this.mWebRTCSdk.enablePassThrough(true);
        } else {
            this.mWebRTCSdk.enablePassThrough(false);
        }
        this.mWebRTCSdk.enablePinchFace(this.mSessionCfg.pEnablePinchFace);
        this.mWebRTCSdk.enablePerfReport(true);
        this.mWebRTCSdk.enableStutterDetect(true);
        this.mWebRTCSdk.enableIme(this.mGameConfigInfo.pEnableLocalInput);
        WebRTCSDK.enableKeepSession(this.mSessionCfg.pEnableKeepSession);
        if (this.mSessionCfg.pEnableQuic && this.mGameConfigInfo.pSupportQuic) {
            z18 = true;
        } else {
            z18 = false;
        }
        WebRTCSDK.enableQuic(z18);
        this.mWebRTCSdk.disableMediaEncryption(this.mGameConfigInfo.pDisableMediaEncryption);
        if (this.mSessionCfg.pEnableCustomizeDecoder && this.mGameConfigInfo.pGameCodecConfig.enabled()) {
            WebRTCSDK.customizeDecoder(true);
            WebRTCSDK.setDecoderType("customized");
            WebRTCSDK webRTCSDK3 = this.mWebRTCSdk;
            GmCgGameConfigInfo gmCgGameConfigInfo = this.mGameConfigInfo;
            if (gmCgGameConfigInfo.pSensorCfg.pEnableVoice > 0 && gmCgGameConfigInfo.pGameCodecConfig.canUseVoice()) {
                z19 = true;
            }
            webRTCSDK3.enableVoice(z19);
            this.mUsingVDecoder = true;
            this.mSessionCtx.pDecoderType = "VDecoder";
        } else {
            WebRTCSDK.customizeDecoder(false);
            this.mUsingVDecoder = false;
            this.mSessionCtx.pDecoderType = "default";
        }
        if (GmCgSdk.isAllTvBiz()) {
            WebRTCSDK.setClientType(GmCgClientType.WEBRTC_SESSION_TV);
        } else {
            WebRTCSDK.setClientType(GmCgClientType.WEBRTC_SESSION_ANDROID_APP);
        }
        WebRTCSDK.enableTouchInterpolation(this.mSessionCfg.pEnableTouchInterpolation);
        doWebRtcStartPlay(gmCgDeviceInfo);
    }

    private void allocateDeviceToUse() {
        internalUpdateStatus(GmCgPlayStatus.StatusAllocatingDevice);
        if (this.mPlayAllocator == null) {
            GmCgAllocatorCfg gmCgAllocatorCfg = this.mAllocatorCfg;
            if (gmCgAllocatorCfg != null) {
                this.mPlayAllocator = CGPlayAllocatorImpl.create(gmCgAllocatorCfg);
            } else {
                internalWhenErrorHappen(GmCgError.ErrorOther);
                return;
            }
        }
        this.mPlayAllocator.setPlayAllocatorListener(this);
        this.mPlayAllocator.setPlayDetectorListener(this);
        GmCgAuthRefreshListener gmCgAuthRefreshListener = this.mAuthRefreshListener;
        if (gmCgAuthRefreshListener != null) {
            this.mPlayAllocator.setAuthRefreshListener(gmCgAuthRefreshListener);
        }
        this.mPlayAllocator.startAllocate();
    }

    private void autoLoginIfNecessary() {
        CGSessionLogI("autoLoginIfNecessary");
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportStartAutoLogin();
        }
        if (this.mSessionCfg.wantAutoLogin()) {
            CGSessionLogI("want auto login");
            if (this.mDeviceReadyToUse.hasAutoLogin()) {
                CGSessionLogI("already auto login");
                onAutoLoginGameResult();
                return;
            } else {
                CGSessionLogI("not auto login: start auto login");
                requestAutoLoginGame();
                return;
            }
        }
        if (this.mSessionCfg.wantYybLogin()) {
            CGSessionLogI("want yyb login");
            if (this.mDeviceReadyToUse.hasAutoLogin()) {
                CGSessionLogI("already auto login");
                onAutoLoginGameResult();
                return;
            } else {
                CGSessionLogI("not auto login: start yyb login");
                requestYybLogin();
                return;
            }
        }
        CGSessionLogI("NOT want auto login");
        onAutoLoginGameResult();
    }

    private int calculateViewHeight(int i3, int i16, GmCgDeviceInfo gmCgDeviceInfo) {
        int i17;
        CGSessionLogI("calculateViewHeight: " + i3 + ", viewWidth: " + i16);
        if (gmCgDeviceInfo != null) {
            i17 = Math.min(gmCgDeviceInfo.getWidth(), gmCgDeviceInfo.getHeight());
        } else {
            i17 = 0;
        }
        if (i17 != 0 && i16 != 0) {
            return convertToEven((i3 * i17) / i16);
        }
        return i3;
    }

    private int calculateViewWidth(int i3, GmCgDeviceInfo gmCgDeviceInfo) {
        int i16;
        if (gmCgDeviceInfo != null) {
            i16 = Math.min(gmCgDeviceInfo.getWidth(), gmCgDeviceInfo.getHeight());
        } else {
            i16 = 0;
        }
        CGSessionLogI("calculateViewWidth: " + i16);
        if (i16 != 0) {
            i3 = i16;
        }
        return convertToEven(i3);
    }

    private void cancelBizHttpService() {
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null) {
            cGBizHttpService.cancel();
        }
    }

    private void cancelLaunchTimeoutCheckTimer() {
        CGHandlerTimer.TimerTask timerTask = this.mLaunchTimeoutCheckTimerTask;
        if (timerTask != null) {
            this.mLaunchTimeoutCheckTimer.cancel(timerTask);
        }
    }

    private void cancelTouchEventCounts() {
        ScheduledFuture<?> scheduledFuture = this.mTouchCountsSchedulder;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        clearTouchEvent();
    }

    private void checkDeviceIfValid2Play(final GmCgDeviceInfo gmCgDeviceInfo) {
        CGSessionLogI("checkDeviceIfExpireBeforeLaunching");
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            cGSessionCtx.pResolutionWidth = gmCgDeviceInfo.getWidth();
            this.mSessionCtx.pResolutionHeight = gmCgDeviceInfo.getHeight();
            this.mSessionCtx.pDeviceFps = gmCgDeviceInfo.getDeviceFps();
            this.mSessionCtx.pCloudGameDeviceType = gmCgDeviceInfo.getHardwareType();
        }
        internalUpdateStatus(GmCgPlayStatus.StatusCheckingDevice);
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_DEVICE, true);
        this.mBizHttpService.requestGetMyDeviceById(gmCgDeviceInfo.getDeviceID(), new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cr
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$checkDeviceIfValid2Play$34(gmCgDeviceInfo, gmCgError, (CGHoldDeviceResp) obj);
            }
        });
    }

    private void checkDeviceToUse() {
        CGSessionLogI("checkDeviceToUse");
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null && gmCgDeviceInfo.isValid()) {
            checkDeviceIfValid2Play(this.mDeviceReadyToUse);
        } else {
            allocateDeviceToUse();
        }
    }

    private void checkQualificationToPlay() {
        CGLog.i("checkQualificationToPlay");
        Runnable runnable = this.mPausingTask;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
        }
        doStartPlayAfterQualification();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTouchEvent() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.clearTouchEventCount();
        }
    }

    private void closeImeInputController() {
        GmCgImeInputController gmCgImeInputController = this.mImeInputController;
        if (gmCgImeInputController != null) {
            gmCgImeInputController.closeImeInput();
        }
    }

    private void configMidasPayIfNecessary() {
        CGSessionLogI("configMidasPayIfNecessary");
        if (this.mSessionCfg.needConfigMidasPay()) {
            CGSessionLogI("need config midas pay");
            requestSetMidasProp();
        } else {
            CGSessionLogI("NOT need config midas pay");
            onSetMidasPropResult();
        }
    }

    public static CGPlaySessionImpl create(@NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        CGPlaySessionImpl cGPlaySessionImpl = new CGPlaySessionImpl();
        cGPlaySessionImpl.mAllocatorCfg = gmCgAllocatorCfg;
        cGPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGPlaySessionImpl.mDeviceReadyToUse = null;
        cGPlaySessionImpl.mCgGameId = gmCgAllocatorCfg.pCgGameId;
        cGPlaySessionImpl.init(gmCgPlayView, null);
        return cGPlaySessionImpl;
    }

    public static CGPlaySessionImpl createFromDevice(@NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull GmCgPlayView gmCgPlayView) {
        CGPlaySessionImpl cGPlaySessionImpl = new CGPlaySessionImpl();
        cGPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGPlaySessionImpl.mDeviceReadyToUse = gmCgDeviceInfo;
        cGPlaySessionImpl.mCgGameId = gmCgDeviceInfo.getDeviceTag();
        cGPlaySessionImpl.init(gmCgPlayView, null);
        return cGPlaySessionImpl;
    }

    public static CGPlaySessionImpl createFromDeviceForPlugin(@NonNull Context context, @NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        CGPlaySessionImpl cGPlaySessionImpl = new CGPlaySessionImpl();
        cGPlaySessionImpl.mActivity = (Activity) context;
        cGPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGPlaySessionImpl.mDeviceReadyToUse = gmCgDeviceInfo;
        cGPlaySessionImpl.mCgGameId = gmCgDeviceInfo.getDeviceTag();
        WebRTCSDK.enableSeiExtension(true);
        cGPlaySessionImpl.init(null, frameLayout);
        return cGPlaySessionImpl;
    }

    private CGMergeLaunchCloudGameReqBody.BodyBean createLaunchCloudGameParam(String str, boolean z16, JsonObject jsonObject) {
        CGSessionLogI("createLaunchCloudGameParam url: " + str + ", requestBody: " + jsonObject);
        CGMergeLaunchCloudGameReqBody.BodyBean bodyBean = new CGMergeLaunchCloudGameReqBody.BodyBean();
        bodyBean.url = str;
        bodyBean.failGoOn = z16;
        bodyBean.request = jsonObject;
        return bodyBean;
    }

    public static CGPlaySessionImpl createPreviewFromDevice(@NonNull Context context, @NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        CGPlaySessionImpl cGPlaySessionImpl = new CGPlaySessionImpl();
        cGPlaySessionImpl.mContext = context;
        cGPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGPlaySessionImpl.mDeviceReadyToUse = gmCgDeviceInfo;
        cGPlaySessionImpl.mCgGameId = gmCgDeviceInfo.getDeviceTag();
        cGPlaySessionImpl.mForPreview = true;
        WebRTCSDK.enableSeiExtension(true);
        cGPlaySessionImpl.init(null, frameLayout);
        return cGPlaySessionImpl;
    }

    private CGMergeLaunchCloudGameReqBody.BodyBean createSetLoadArchiveParam(String str) {
        String str2;
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg != null && CGStringUtil.notEmpty(gmCgSessionCfg.pArchiveSessionId)) {
            str2 = this.mSessionCfg.pArchiveSessionId;
        } else {
            str2 = "";
        }
        CGSessionLogI("requestLoadArchive, sessionId: " + str2);
        CGLoadArchiveReqBody cGLoadArchiveReqBody = new CGLoadArchiveReqBody();
        cGLoadArchiveReqBody.identity = CGGlbConfig.getUserId();
        cGLoadArchiveReqBody.deviceid = str;
        cGLoadArchiveReqBody.session = str2;
        return createLaunchCloudGameParam("/sdk/v2/load_archive", true, (JsonObject) new Gson().fromJson(new Gson().toJson(cGLoadArchiveReqBody), JsonObject.class));
    }

    private CGMergeLaunchCloudGameReqBody.BodyBean createSetMidasParam(String str) {
        CGSetMidasPropReqBody cGSetMidasPropReqBody = new CGSetMidasPropReqBody();
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        cGSetMidasPropReqBody.linkid = gmCgSessionCfg.pMidasPayLinkId;
        cGSetMidasPropReqBody.client_offerid = gmCgSessionCfg.pMidasPayClientOfferId;
        cGSetMidasPropReqBody.client_openid = gmCgSessionCfg.pMidasPayClientOpenId;
        cGSetMidasPropReqBody.platform_id = gmCgSessionCfg.pMidasPayPlatformId;
        cGSetMidasPropReqBody.platform_type = gmCgSessionCfg.pMidasPayPlatformType;
        cGSetMidasPropReqBody.deviceid = str;
        return createLaunchCloudGameParam("/sdk/v2/set_midas_prop", true, (JsonObject) new Gson().fromJson(new Gson().toJson(cGSetMidasPropReqBody), JsonObject.class));
    }

    private CGMergeLaunchCloudGameReqBody.BodyBean createSetResolutionParam(String str) {
        int i3;
        int i16;
        int playRenderWidth = this.mPlaySessionViewHolder.getPlayRenderWidth();
        int playRenderHeight = this.mPlaySessionViewHolder.getPlayRenderHeight();
        GmCgGameStreamQualityCfg curStreamQualityCfg = getStreamQualityAdjuster().getCurStreamQualityCfg();
        if (curStreamQualityCfg != null) {
            i3 = curStreamQualityCfg.pResWidth;
            i16 = curStreamQualityCfg.pResHeight;
        } else {
            i3 = 0;
            i16 = 0;
        }
        this.mSessionCfg.pViewWidth = calculateViewWidth(Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
        this.mSessionCfg.pViewHeight = calculateViewHeight(Math.max(playRenderWidth, playRenderHeight), Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
        CGSetCloudGameResolutionReqBody cGSetCloudGameResolutionReqBody = new CGSetCloudGameResolutionReqBody();
        cGSetCloudGameResolutionReqBody.deviceid = str;
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        cGSetCloudGameResolutionReqBody.height = gmCgSessionCfg.pViewHeight;
        cGSetCloudGameResolutionReqBody.width = gmCgSessionCfg.pViewWidth;
        cGSetCloudGameResolutionReqBody.target_height = i16;
        cGSetCloudGameResolutionReqBody.target_width = i3;
        CGSessionLogI("GmCgPlayView width: " + this.mSessionCfg.pViewWidth + ", height = " + this.mSessionCfg.pViewHeight);
        return createLaunchCloudGameParam("/sdk/v2/set_resolution", true, (JsonObject) new Gson().fromJson(new Gson().toJson(cGSetCloudGameResolutionReqBody), JsonObject.class));
    }

    @SuppressLint({"MissingPermission"})
    private void destroyGpsManagerForWebRtcIfNecessary() {
        CGLocationGetter cGLocationGetter = this.mLocationGetter;
        if (cGLocationGetter != null) {
            cGLocationGetter.stopGetLocation();
            this.mLocationGetter = null;
        }
    }

    private void deviceReadyToConnect() {
        CGSessionLogI("deviceReadyToConnect: " + this.mDeviceReadyToUse.toString());
        internalUpdateStatus(GmCgPlayStatus.StatusDeviceReadyToConnect);
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cx
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$deviceReadyToConnect$33();
            }
        });
    }

    private void doDelayLoadingAfterConnected() {
        int i3;
        if (!this.mHasLoadArchiveProcess || !this.mDeviceIsNewAllocated || (i3 = Math.max(this.mGameConfigInfo.pArchiveLoadingTime * 1000, this.mSessionCfg.pLoadingDelayTimeMillis)) <= 0) {
            i3 = 100;
        }
        CGLog.i("do mUpdateFinishStateTask after " + i3 + "ms");
        runOnMainThreadAfterDelay(this.mUpdateFinishStateTask, (long) i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestSetCloudGameResolution() {
        int i3;
        int i16;
        int playRenderWidth = this.mPlaySessionViewHolder.getPlayRenderWidth();
        int playRenderHeight = this.mPlaySessionViewHolder.getPlayRenderHeight();
        GmCgGameStreamQualityCfg curStreamQualityCfg = getStreamQualityAdjuster().getCurStreamQualityCfg();
        if (curStreamQualityCfg != null) {
            int i17 = curStreamQualityCfg.pResWidth;
            i16 = curStreamQualityCfg.pResHeight;
            i3 = i17;
        } else {
            i3 = 0;
            i16 = 0;
        }
        this.mSessionCfg.pViewWidth = calculateViewWidth(Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
        this.mSessionCfg.pViewHeight = calculateViewHeight(Math.max(playRenderWidth, playRenderHeight), Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
        CGSessionLogI("GmCgPlayView width: " + this.mSessionCfg.pViewWidth + ", height = " + this.mSessionCfg.pViewHeight);
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_SET_RESOLUTION, true);
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        String deviceID = this.mDeviceReadyToUse.getDeviceID();
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        cGBizHttpService.setCloudGameResolution(deviceID, gmCgSessionCfg.pViewWidth, gmCgSessionCfg.pViewHeight, i3, i16, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dh
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$doRequestSetCloudGameResolution$44(gmCgError, (CGCommonResp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRestartPlay(String str) {
        doRestartPlay(str, false);
    }

    private void doStartPlayAfterQualification() {
        CGLog.i("doStartPlayAfterQualification");
        GmCgDelayCounter.getInstance().recordPrepareLinkProcessStart();
        internalUpdateStatus(GmCgPlayStatus.StatusPrepareData);
        this.mFirstFrameRendered = false;
        startLaunchTimeoutCheckTimer();
        if (this.mSessionMonitor.checkNetworkAvailable()) {
            startPrepareCloudGameData();
        } else {
            internalWhenErrorHappen(GmCgError.ErrorNetworkNotAvailable);
        }
    }

    private void doWebRtcRestartPlay(GmCgDeviceInfo gmCgDeviceInfo) {
        logI("doWebRtcRestartPlay");
        getLocalIpAndNetCarrier(gmCgDeviceInfo, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cv
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$doWebRtcRestartPlay$47(gmCgError, (CGGetIpAddressResp) obj);
            }
        });
    }

    private void doWebRtcStartPlay(GmCgDeviceInfo gmCgDeviceInfo) {
        logI("doWebRtcStartPlay");
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_GATEWAY, true);
        getLocalIpAndNetCarrier(gmCgDeviceInfo, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ch
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$doWebRtcStartPlay$48(gmCgError, (CGGetIpAddressResp) obj);
            }
        });
    }

    private boolean enableCumulativeDelayed() {
        GmCgGameConfigInfo gmCgGameConfigInfo;
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg == null || (gmCgGameConfigInfo = this.mGameConfigInfo) == null || !gmCgSessionCfg.pEnableCumulativeDelayed || !gmCgGameConfigInfo.pFrontEndShowDelay) {
            return false;
        }
        return true;
    }

    private void enableFsr() {
        VideoFilterParams videoFilterParams = new VideoFilterParams(true);
        videoFilterParams.setVideoFilterType(2);
        videoFilterParams.setFsrType(5);
        videoFilterParams.m_glContext = 0L;
        videoFilterParams.m_glDisplay = 0L;
        videoFilterParams.m_solution = 0;
        videoFilterParams.m_scale = 2;
        videoFilterParams.m_strCacheDir = this.mContext.getCacheDir().getAbsolutePath();
        videoFilterParams.m_strDspLibPath = this.mContext.getApplicationContext().getApplicationInfo().nativeLibraryDir;
        videoFilterParams.m_strBuildSoc = CGGlbConfig.getSoc();
        videoFilterParams.m_strBuildBrand = CGGlbConfig.getBuildBrand();
        videoFilterParams.m_strBuildModel = CGGlbConfig.getBuildModel();
        videoFilterParams.m_strSessionId = getLocalSessionId();
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            DeviceConfig deviceConfig = cGSessionCtx.pDeviceConfig;
            if (deviceConfig != null) {
                videoFilterParams.m_strDeviceId = deviceConfig.getDeviceId();
            } else {
                videoFilterParams.m_strDeviceId = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            }
            videoFilterParams.m_strGameId = this.mSessionCtx.pCgGameId;
        } else {
            videoFilterParams.m_strDeviceId = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            videoFilterParams.m_strGameId = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
        videoFilterParams.setOnlyHwDecode(false);
        CGLog.i(TAG_FSR, "FSR\u8d85\u5206\u53c2\u6570\u8bbe\u7f6e\u5b8c\u6bd5");
        videoFilterParams.setVideoFilterCallback(new VideoFilter.Callback() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cn
            @Override // com.tencent.gamematrix.gmvideofilter.VideoFilter.Callback
            public final void OnVideoFilterCallbak(int i3, int i16, int i17, int i18, String str) {
                CGPlaySessionImpl.this.lambda$enableFsr$53(i3, i16, i17, i18, str);
            }
        });
        this.mWebRTCParameters.setVideofilterParams(videoFilterParams);
    }

    private void enableImeInputController(boolean z16) {
        GmCgImeInputController gmCgImeInputController = this.mImeInputController;
        if (gmCgImeInputController != null) {
            gmCgImeInputController.enableImeInput(z16, this.mActivity, this.mPlaySessionViewHolder.getPlayContainerView(), new GmCgImeInputController.GmCgImeInputEvtListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.3
                @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController.GmCgImeInputEvtListener
                public void onImeInputEvtHide() {
                    CGLog.i("onImeInputEvtHide");
                    WebRTCSDK webRTCSDK = CGPlaySessionImpl.this.mWebRTCSdk;
                    if (webRTCSDK != null) {
                        webRTCSDK.sendClose();
                    }
                    CGPlaySessionImpl.this.onImeInputEventHide();
                }

                @Override // com.tencent.gamematrix.gmcg.api.GmCgImeInputController.GmCgImeInputEvtListener
                public void onImeInputEvtSizeRatioGot(float f16) {
                    CGLog.i("onImeInputEvtSizeRatioGot");
                    WebRTCSDK webRTCSDK = CGPlaySessionImpl.this.mWebRTCSdk;
                    if (webRTCSDK != null) {
                        webRTCSDK.sendHeightRatio(f16);
                    }
                }
            });
        }
    }

    private void endPrepareCloudGameData() {
        CGSessionLogI("endPrepareCloudGameData, mCurSessionStatus: " + this.mCurSessionStatus + ", mCurPlayStatus: " + this.mCurPlayStatus);
        if (enableCumulativeDelayed()) {
            setServerConfigForWebRtc(false, false, this.mGameConfigInfo.pFrontEndShowDelay);
        }
        if (this.mCurSessionStatus.is(GmCgSessionStatus.StatusSessionPrepareCGData)) {
            this.mCurSessionStatus = GmCgSessionStatus.StatusSessionWaitingCGData;
            return;
        }
        if (this.mCurSessionStatus.is(GmCgSessionStatus.StatusSessionWaitingCGData)) {
            this.mCurSessionStatus = GmCgSessionStatus.StatusSessionReadyCGData;
        }
        processCloudGameLaunching();
    }

    private void ensureDevice2Play(GmCgDeviceInfo gmCgDeviceInfo) {
        CGSessionLogI("ensureDevice2Play");
        gmCgDeviceInfo.setGamePackageName(this.mGameConfigInfo.pPackageName);
        this.mDeviceReadyToUse = gmCgDeviceInfo;
        getDcEventHelper().onSessionDeviceEnsured(this.mDeviceReadyToUse);
        internalUpdateStatusWithData(GmCgPlayStatus.StatusDeviceAllocated, gmCgDeviceInfo);
        endPrepareCloudGameData();
    }

    private JSONObject generatePrivileges(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WebRTCSDK.PRIVILEGE_CLOUD_PHOTO, str);
            jSONObject.put(WebRTCSDK.PRIVILEGE_INPUT_METHOD, str);
            jSONObject.put(WebRTCSDK.PRIVILEGE_AUDIO_INPUT, str);
            jSONObject.put("gps", str);
            jSONObject.put(WebRTCSDK.PRIVILEGE_SENSOR, str);
            jSONObject.put(WebRTCSDK.PRIVILEGE_VIRTUAL_PAD, str);
            jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, str);
            jSONObject.put(WebRTCSDK.PRIVILEGE_PASSTHROUGH, str);
        } catch (Exception e16) {
            CGSessionLogE("Failed to generatePrivileges, cause " + e16);
        }
        return jSONObject;
    }

    private int getActiveNetworkType() {
        int activeNetworkType = CGNetworkUtil.getActiveNetworkType(this.mContext);
        if (activeNetworkType != -1 && activeNetworkType != 1) {
            if (activeNetworkType == 10) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    private String getActivityHashCode() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return Integer.toHexString(activity.hashCode());
        }
        return "none";
    }

    private CGDcEventHelper getDcEventHelper() {
        if (this.mDcEventHelper == null) {
            this.mDcEventHelper = new CGDcEventHelper(this, this.mPlayDcEventListener);
        }
        return this.mDcEventHelper;
    }

    private String getDestinationIp(String str) {
        StringBuilder sb5 = new StringBuilder();
        Matcher matcher = Pattern.compile("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)").matcher(str);
        if (matcher.find()) {
            sb5.append(matcher.group());
        }
        CGSessionLogI("getDestinationIp: " + sb5.toString());
        return sb5.toString();
    }

    private void getLocalIpAndNetCarrier(final GmCgDeviceInfo gmCgDeviceInfo, final CGBizHttpService.ResultListener<CGGetIpAddressResp> resultListener) {
        this.mBizHttpService.requestGateWayIpAddress(new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cz
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$getLocalIpAndNetCarrier$46(gmCgDeviceInfo, resultListener, gmCgError, (CGGetIpAddressResp) obj);
            }
        });
    }

    private String getLocalSessionId() {
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            return cGSessionCtx.pLocalSessionNo;
        }
        return "unknown";
    }

    private CGPushEventHelper getPushEventHelper() {
        if (this.mPushEventHelper == null) {
            this.mPushEventHelper = new CGPushEventHelper(this.mPlayPushEventListener);
        }
        return this.mPushEventHelper;
    }

    private CGStreamQualityAdjuster getStreamQualityAdjuster() {
        if (this.mStreamQualityAdjuster == null) {
            GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
            this.mStreamQualityAdjuster = new CGStreamQualityAdjuster(gmCgSessionCfg.pEnableAdaptiveStreamQuality, this, this.mPlayPerfListener, this.mForPreview, gmCgSessionCfg.pDefaultStreamQualityCfg);
        }
        return this.mStreamQualityAdjuster;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTouchEventCounts() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            return webRTCSDK.getTouchEventCount();
        }
        return 0;
    }

    private String getWebRtcSignalServer(@NonNull GmCgDeviceInfo gmCgDeviceInfo) {
        String webrtcUrl = gmCgDeviceInfo.getWebrtcUrl();
        List<String> webrtcIP = gmCgDeviceInfo.getWebrtcIP();
        if (CGGlbConfig.hasServerMapping() && CGGlbConfig.getServerMapping().containsKey(webrtcUrl)) {
            return CGGlbConfig.getServerMapping().get(webrtcUrl);
        }
        StringBuilder sb5 = new StringBuilder(webrtcUrl);
        if (webrtcIP != null && webrtcIP.size() > 0) {
            for (String str : webrtcIP) {
                sb5.append("&IP=");
                sb5.append(str);
            }
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotGpsLocationForWebRtc(Location location) {
        CGSessionLogI("Location: got location " + location.toString());
        WebRTCSDK.setUserLocation(location);
        destroyGpsManagerForWebRtcIfNecessary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleClipboardDataFromWebRtc, reason: merged with bridge method [inline-methods] */
    public void lambda$onEventClipBoardDataRecved$23(String str) {
        try {
            ClipData newPlainText = ClipData.newPlainText("GmCg", str);
            ClipboardManager clipboardManager = (ClipboardManager) this.mContext.getApplicationContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
            }
        } catch (Exception e16) {
            CGLog.e("Failed to set data to clipboard: " + e16);
        }
    }

    private void handleMergeLaunchCloudGameResult(CGMergeLaunchCloudGameResp cGMergeLaunchCloudGameResp) {
        List<CGMergeLaunchCloudGameResp.DataBean> list;
        if (cGMergeLaunchCloudGameResp != null && (list = cGMergeLaunchCloudGameResp.data) != null) {
            for (CGMergeLaunchCloudGameResp.DataBean dataBean : list) {
                CGMergeLaunchCloudGameResp.DataBean.RespBean respBean = dataBean.resp;
                if (respBean != null && respBean.ret != 0) {
                    CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
                    if (cGSessionMonitor != null) {
                        cGSessionMonitor.reportError(GmCgError.ErrorRequestFail.getErrorCode(), dataBean.toString());
                    }
                    CGSessionLogE("requestMergeLaunchCloudGame error, url: " + dataBean.url + ", msg: " + dataBean.resp.f107899msg);
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private void initGpsManagerForWebRtcIfNecessary() {
        CGSessionLogI("Location: init gps manager");
        if (this.mGameConfigInfo.pSensorCfg.pEnableGps > 0 && CGPermissionUtil.hasPermissions(this.mContext, "android.permission.ACCESS_FINE_LOCATION")) {
            CGLocationGetter cGLocationGetter = new CGLocationGetter(this.mContext, new CGLocationGetter.CGLocationResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bi
                @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGLocationGetter.CGLocationResultListener
                public final void onGotLocation(Location location) {
                    CGPlaySessionImpl.this.gotGpsLocationForWebRtc(location);
                }
            });
            this.mLocationGetter = cGLocationGetter;
            cGLocationGetter.startGetLocation();
            return;
        }
        CGSessionLogI("Location: not enable gps or not have permission");
    }

    private void initInternal() {
        CGSessionCtx create = CGSessionCtx.create(CGGlbConfig.getAppContext(), CGGlbConfig.getUserId());
        this.mSessionCtx = create;
        create.pBizId = CGGlbConfig.getBizId();
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        cGSessionCtx.pGamePackageName = "TODO";
        cGSessionCtx.pServerEnv = CGServerProvider.getServerType();
        CGSessionCtx cGSessionCtx2 = this.mSessionCtx;
        cGSessionCtx2.pSceneInfo = "gmcgsdk";
        cGSessionCtx2.pCgGameId = this.mCgGameId;
        cGSessionCtx2.pAppBizNo = CGGlbConfig.getAppBizNo();
        this.mSessionCtx.pAppChannel = CGGlbConfig.getAppChannel();
        CGSessionCtx cGSessionCtx3 = this.mSessionCtx;
        cGSessionCtx3.pGameClientType = 0;
        cGSessionCtx3.pClientSource = CGClientEnvHelper.get().getDeviceSource();
        CGSessionCtx cGSessionCtx4 = this.mSessionCtx;
        cGSessionCtx4.pSceneId = "-1";
        cGSessionCtx4.pCodecType = VideoCodecType.UNKNOWN;
        cGSessionCtx4.pDeviceModel = CGGlbConfig.getBuildModel();
        this.mSessionCtx.pDeviceBrand = CGGlbConfig.getBuildBrand();
        this.mSessionCtx.pDeviceSource = CGClientEnvHelper.get().getDeviceSource();
        this.mSessionCtx.pXid = CGGlbConfig.getXID();
        this.mSessionCtx.pOaid = CGGlbConfig.getOAID();
        this.mSessionCtx.pSoc = CGGlbConfig.getSoc();
        CGSessionMonitor create2 = CGSessionMonitor.create(this.mContext, this.mSessionCtx, this);
        this.mSessionMonitor = create2;
        create2.enableTdmReport(this.mSessionCtx.pEnableTdmReport);
        this.mSessionMonitor.setReporter(new CGBeaconHttpReporter("0AND06187752FLY8"), new CGBeaconHttpReporter("0AND060QS4V16UN3"));
        GmCgPlayStatus gmCgPlayStatus = GmCgPlayStatus.StatusStart;
        this.mLastPlayStatus = gmCgPlayStatus;
        this.mCurPlayStatus = gmCgPlayStatus;
        this.mLastPlayError = GmCgError.ErrorNone;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mLaunchTimeoutCheckTimer = new CGHandlerTimer();
        this.mBizHttpService = new CGBizHttpService();
        this.mQualificationChecker = new CGQualificationChecker(true);
        this.mGameConfigInfo = new GmCgGameConfigInfo();
        this.mPeriodExecutorService = ProxyExecutors.newScheduledThreadPool(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalStopPlay() {
        CGSessionLogI("internalStopPlay");
        GmCgPlayStatus gmCgPlayStatus = this.mCurPlayStatus;
        GmCgPlayStatus gmCgPlayStatus2 = GmCgPlayStatus.StatusStopped;
        if (gmCgPlayStatus.not(gmCgPlayStatus2)) {
            CGSessionLogI("internalStopPlay: " + this.mCurPlayStatus);
            CGPlayAllocatorImpl cGPlayAllocatorImpl = this.mPlayAllocator;
            if (cGPlayAllocatorImpl != null) {
                cGPlayAllocatorImpl.stopAllocate(false);
            }
            cancelLaunchTimeoutCheckTimer();
            cancelBizHttpService();
            destroyGpsManagerForWebRtcIfNecessary();
            cancelTouchEventCounts();
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dc
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.stopWebRtc();
                }
            });
            if (this.mMainHandler != null) {
                CGLog.i("remove mUpdateFinishStateTask on stop");
                this.mMainHandler.removeCallbacks(this.mPausingTask);
                this.mMainHandler.removeCallbacks(this.mUpdateFinishStateTask);
            }
        }
        internalUpdateStatus(gmCgPlayStatus2);
    }

    private void internalUpdatePerfInfo(PerfValue perfValue) {
        final GmCgPlayPerfInfo gmCgPlayPerfInfo = new GmCgPlayPerfInfo();
        if (perfValue != null) {
            gmCgPlayPerfInfo.pVideoFirstFrameRenderDelay = perfValue.firstFrameRenderDelay;
            gmCgPlayPerfInfo.pVideoDecodeTimeMs = perfValue.decodeTimeMs;
            gmCgPlayPerfInfo.pVideoFramerate = perfValue.decodeRate;
            gmCgPlayPerfInfo.pVideoBitrate = perfValue.videoBitrate;
            gmCgPlayPerfInfo.pVideoFramesDecoded = perfValue.framesDecoded;
            gmCgPlayPerfInfo.pVideoFramesDropped = perfValue.framesDropped;
            gmCgPlayPerfInfo.pVideoBytesReceived = perfValue.bytesReceived;
            gmCgPlayPerfInfo.pVideoFramesReceived = perfValue.framesReceived;
            gmCgPlayPerfInfo.pVideoPacketsReceived = perfValue.packetsReceived;
            gmCgPlayPerfInfo.pVideoPacketsLost = perfValue.packetsLost;
            gmCgPlayPerfInfo.pVideoFrameWidth = perfValue.frameWidth;
            gmCgPlayPerfInfo.pVideoFrameHeight = perfValue.frameHeight;
            gmCgPlayPerfInfo.pVideoRtt = perfValue.rtt;
            gmCgPlayPerfInfo.pDecodeType = perfValue.codecType;
            gmCgPlayPerfInfo.pVideoAverageFrameRate = perfValue.averageFrameRate;
            gmCgPlayPerfInfo.pVideoAverageDecodeTimeMs = perfValue.averageDecodeTimeMs;
            gmCgPlayPerfInfo.pVideoAverageBitRate = perfValue.averageBitRate;
            gmCgPlayPerfInfo.pVideoAverageRtt = perfValue.averageRtt;
            gmCgPlayPerfInfo.pVideoPlayTime = perfValue.playTime;
            gmCgPlayPerfInfo.pVideoFreezeCount = perfValue.freezeCount;
            gmCgPlayPerfInfo.pVideoTotalFreezesDuration = perfValue.totalFreezesDuration;
            gmCgPlayPerfInfo.pVideoFreezeDuringLast10s = perfValue.freezeDuringLast10s;
            gmCgPlayPerfInfo.pNackRate = perfValue.nackRate;
            gmCgPlayPerfInfo.pFecRate = perfValue.fecRate;
            gmCgPlayPerfInfo.pRecoverRate = perfValue.recoverRate;
            gmCgPlayPerfInfo.pVideoStutterLatency = perfValue.stutterLatency;
            gmCgPlayPerfInfo.pAudioPacketsLost = perfValue.audioPacketsLost;
            gmCgPlayPerfInfo.pAudioPacketsReceived = perfValue.audioPacketsReceived;
            gmCgPlayPerfInfo.pAudioPacketsLossPercentage = perfValue.audioPacketsLossPercentage;
            gmCgPlayPerfInfo.pAudioBitrate = perfValue.audioBitrate;
            gmCgPlayPerfInfo.pReportTimestamp = perfValue.timestamp;
            gmCgPlayPerfInfo.pBitrate = perfValue.bitrate;
            gmCgPlayPerfInfo.pWebrtcNetworkBandwidth = perfValue.webrtcNetworkBandwidth;
            gmCgPlayPerfInfo.pWebrtcNetworkQuality = perfValue.webrtcNetworkQuality;
            gmCgPlayPerfInfo.pLocalNetCarrier = this.mLocalNetCarrier;
            gmCgPlayPerfInfo.pRemoteNetCarrier = this.mRemoteNetCarrier;
            gmCgPlayPerfInfo.pSupportNetFreeFlow = this.mSupportNetFreeFlow;
            gmCgPlayPerfInfo.pRealNetFreeFlow = this.mRealNetFreeFlow;
            gmCgPlayPerfInfo.pTgpaPingValue = this.mTgpaPingValue;
            gmCgPlayPerfInfo.pGameCodecConfig = this.mGameCodecConfig;
            gmCgPlayPerfInfo.pUsingVDecoder = this.mUsingVDecoder;
            gmCgPlayPerfInfo.pPerfdogStutter = perfValue.perfdogStutter;
            gmCgPlayPerfInfo.pPerfdogJankDuration = perfValue.perfdogJankDuration;
            gmCgPlayPerfInfo.pPerfdogPotentialJankDuration = perfValue.perfdogPotentialJankDuration;
            gmCgPlayPerfInfo.pLostRateNet = perfValue.lostRateNet;
            gmCgPlayPerfInfo.pLostRateFinal = perfValue.lostRateFinal;
            gmCgPlayPerfInfo.pRoundTripLatency = perfValue.roundTripLatency;
            gmCgPlayPerfInfo.pSrType = this.mSessionCtx.pSrType;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bl
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$internalUpdatePerfInfo$32(gmCgPlayPerfInfo);
            }
        });
    }

    private void internalUpdateStatus(GmCgPlayStatus gmCgPlayStatus) {
        internalUpdateStatusWithData(gmCgPlayStatus, null);
    }

    private void internalUpdateStatusWithData(final GmCgPlayStatus gmCgPlayStatus, final Object obj) {
        CGSessionLogI("internalUpdateStatus: " + gmCgPlayStatus);
        this.mLastPlayStatus = this.mCurPlayStatus;
        this.mCurPlayStatus = gmCgPlayStatus;
        if (!gmCgPlayStatus.is(GmCgPlayStatus.StatusGameConfigGot)) {
            if (gmCgPlayStatus.is(GmCgPlayStatus.StatusFirstFramedRendered)) {
                this.mFirstFrameRendered = true;
            } else if (gmCgPlayStatus.is(GmCgPlayStatus.StatusInStreaming)) {
                getStreamQualityAdjuster().adjustAdaptivePlayStreamQuality();
            }
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bf
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$internalUpdateStatusWithData$29(gmCgPlayStatus, obj);
            }
        });
    }

    private void internalWhenErrorHappen(final GmCgError gmCgError) {
        CGSessionLogI("internalWhenErrorHappen: " + gmCgError.getDetailErrorMsg());
        if (isSioErrorAfterServerConnClose(gmCgError.getErrorCode())) {
            return;
        }
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusRestart) && gmCgError.canRetry()) {
            return;
        }
        this.mLastPlayError = gmCgError;
        this.mSessionMonitor.reportError(gmCgError.getErrorCode(), gmCgError.getDetailErrorMsg());
        if (!gmCgError.isWarning()) {
            internalUpdateStatus(GmCgPlayStatus.StatusErrorHappen);
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dk
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.lambda$internalWhenErrorHappen$30(gmCgError);
                }
            });
        } else {
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dl
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.lambda$internalWhenErrorHappen$31(gmCgError);
                }
            });
        }
    }

    private boolean isDeviceForVip() {
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null && gmCgDeviceInfo.getIdentityProfType() == 1) {
            return true;
        }
        return false;
    }

    private boolean isEnsuredDeviceValid() {
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null && gmCgDeviceInfo.isValid()) {
            return true;
        }
        return false;
    }

    private boolean isNeedConfigMidasPay() {
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg != null && gmCgSessionCfg.needConfigMidasPay()) {
            return true;
        }
        return false;
    }

    private boolean isNeedLoadArchive() {
        GmCgSessionCfg gmCgSessionCfg;
        GmCgDeviceInfo gmCgDeviceInfo;
        GmCgGameConfigInfo gmCgGameConfigInfo = this.mGameConfigInfo;
        if (gmCgGameConfigInfo != null && gmCgGameConfigInfo.pSupportSaveArchive && (gmCgSessionCfg = this.mSessionCfg) != null && !gmCgSessionCfg.pForceSkipLoadArchive && (gmCgDeviceInfo = this.mDeviceReadyToUse) != null && !gmCgDeviceInfo.hasSaveArchive() && this.mDeviceIsNewAllocated) {
            return true;
        }
        return false;
    }

    private boolean isNeedSetResolution() {
        GmCgDeviceInfo gmCgDeviceInfo;
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg != null && !gmCgSessionCfg.pForceSkipSetResolution && (gmCgDeviceInfo = this.mDeviceReadyToUse) != null && !gmCgDeviceInfo.hasSetResolution()) {
            return true;
        }
        return false;
    }

    private boolean isSioErrorAfterServerConnClose(int i3) {
        if (this.mServerConnCloseErrors.contains(Integer.valueOf(this.mLastPlayError.getErrorCode())) && GmCgError.ErrorLongConnNetworkFail.getErrorCode() == i3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$OnEventDataReport$24(String str, Map map) {
        GmCgPlayPerfListener gmCgPlayPerfListener = this.mPlayPerfListener;
        if (gmCgPlayPerfListener != null) {
            gmCgPlayPerfListener.onGmCgPlayVDecoderPerfData(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkDeviceIfValid2Play$34(GmCgDeviceInfo gmCgDeviceInfo, GmCgError gmCgError, CGHoldDeviceResp cGHoldDeviceResp) {
        CGAllocDeviceInfo cGAllocDeviceInfo;
        List<CGAllocDeviceInfo> list;
        boolean z16 = false;
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_DEVICE, false);
        if (GmCgError.isOK(gmCgError) && (list = cGHoldDeviceResp.devices) != null) {
            Iterator<CGAllocDeviceInfo> it = list.iterator();
            while (it.hasNext()) {
                cGAllocDeviceInfo = it.next();
                if (gmCgDeviceInfo.getDeviceID().equals(cGAllocDeviceInfo.deviceID) && gmCgDeviceInfo.getControlkey().equals(cGAllocDeviceInfo.controlkey)) {
                    z16 = cGAllocDeviceInfo.isDeviceActive();
                    break;
                }
            }
        }
        cGAllocDeviceInfo = null;
        CGSessionLogI("after check device is active: " + z16);
        if (z16 && cGAllocDeviceInfo != null) {
            GmCgDeviceInfo gmCgDeviceInfo2 = cGAllocDeviceInfo.toGmCgDeviceInfo(gmCgDeviceInfo.getAllocateSource());
            this.mDeviceIsNewAllocated = cGAllocDeviceInfo.isDeviceNewAllocatedAndAlive();
            ensureDevice2Play(gmCgDeviceInfo2);
            return;
        }
        internalWhenErrorHappen(GmCgError.ErrorServiceSessionExpire);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deviceReadyToConnect$33() {
        webRtcPlay(this.mDeviceReadyToUse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$directPlay$10() {
        webRtcPlay(this.mDeviceReadyToUse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doRequestSetCloudGameResolution$44(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_SET_RESOLUTION, false);
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestSetCloudGameResolution: fail");
        }
        onSetCloudGameResolutionResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doRestartPlay$49() {
        webRtcPlayAgain(this.mDeviceReadyToUse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doRestartPlay$50(boolean z16) {
        webRtcPlay(this.mDeviceReadyToUse, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doWebRtcRestartPlay$47(GmCgError gmCgError, CGGetIpAddressResp cGGetIpAddressResp) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.restart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doWebRtcStartPlay$48(GmCgError gmCgError, CGGetIpAddressResp cGGetIpAddressResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_GATEWAY, false);
        GmCgDelayCounter.getInstance().recordPrepareLinkProcessEnd();
        if (this.mWebRTCSdk != null) {
            GmCgDelayCounter.getInstance().recordWebrtcLinkProcessStart();
            this.mWebRTCSdk.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$enableFsr$53(int i3, int i16, int i17, int i18, String str) {
        CGLog.i(TAG_FSR, "FSR\u8d85\u5206\u5f00\u542f\u7ed3\u679c: solution = " + i3 + ",module = " + i16 + ",function = " + i17 + ", errcode = " + i18 + ",desc = " + str);
        this.mSessionMonitor.reportCallSwitchSR(2, i18);
        if (i18 != 0) {
            this.mSessionCtx.pSrType = 0;
            CGLog.i(TAG_FSR, "OnSrServiceCallback: FSR\u8d85\u5206\u5f00\u542f\u5931\u8d25 errCode: " + i18 + ",\u6062\u590d\u6210\u539f\u59cb\u7684,\u5e76\u4e14\u91cd\u542f\u6574\u4e2awebrtc");
            onSuperResolutionTypeChange(0);
            this.mStreamQualityAdjuster.setGameStreamCfgFromServer(this.mGameConfigResp.getVideoCodingForH264(), this.mGameConfigResp.getVideoCodingForH265(), 0, isDeviceForVip());
            this.mWebRTCSdk.setAudioVolume(0.0d);
            this.mWebRTCSdk.stop();
            this.mWebRTCSdk.onDestroy();
            this.mWebRTCParameters.setVideofilterParams(null);
            this.mWebRTCSdk = null;
            doRestartPlay("enableFsr", true);
            return;
        }
        CGLog.i(TAG_FSR, "OnSrServiceCallback: FSR\u8d85\u5206\u5f00\u542f\u6210\u529f");
        if (this.mSessionCtx.pSrType != 2) {
            onSuperResolutionTypeChange(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchCloudGameLog$3(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            CGLog.i("fetchCloudGameLog success!");
        } else {
            CGLog.i("fetchCloudGameLog log failed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLocalIpAndNetCarrier$46(GmCgDeviceInfo gmCgDeviceInfo, CGBizHttpService.ResultListener resultListener, GmCgError gmCgError, CGGetIpAddressResp cGGetIpAddressResp) {
        boolean z16;
        if (GmCgError.isOK(gmCgError)) {
            String str = cGGetIpAddressResp.carrier;
            this.mLocalNetCarrier = str;
            this.mLocalClientProvince = cGGetIpAddressResp.province;
            this.mLocalClientIp = cGGetIpAddressResp.client_ip;
            if (gmCgDeviceInfo != null) {
                GmCgDelayCounter.getInstance().setCluster(gmCgDeviceInfo.cluster);
                GmCgDelayCounter.getInstance().setDeviceId(gmCgDeviceInfo.getDeviceID());
            }
            GmCgDelayCounter.getInstance().setArea(this.mLocalClientProvince);
            GmCgDelayCounter.getInstance().setUserCarrier(this.mLocalNetCarrier);
            WebRTCSDK webRTCSDK = this.mWebRTCSdk;
            if (webRTCSDK != null) {
                if (gmCgDeviceInfo != null && gmCgDeviceInfo.supportFreeFlow()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                webRTCSDK.setNetworkCarrier(str, z16);
            }
        } else {
            CGSessionLogW("doWebRtcRestartPlay get carrier fail: " + gmCgError.getDetailErrorMsg());
        }
        if (resultListener != null) {
            resultListener.onResult(gmCgError, cGGetIpAddressResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalUpdatePerfInfo$32(GmCgPlayPerfInfo gmCgPlayPerfInfo) {
        this.mPlaySessionViewHolder.onPerfInfoUpdate(gmCgPlayPerfInfo);
        GmCgPlayPerfListener gmCgPlayPerfListener = this.mPlayPerfListener;
        if (gmCgPlayPerfListener != null) {
            gmCgPlayPerfListener.onGmCgPlayPerfUpdate(gmCgPlayPerfInfo);
            this.mPlayPerfListener.onGmCgPlayPerfStreamShutterLatency(gmCgPlayPerfInfo.getShutterLatencyState(), gmCgPlayPerfInfo.pVideoStutterLatency, CGNetworkChangeObserver.mGmCgActivityNetWorkType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalUpdateStatusWithData$29(GmCgPlayStatus gmCgPlayStatus, Object obj) {
        GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder = this.mPlaySessionViewHolder;
        GmCgError gmCgError = GmCgError.ErrorNone;
        gmCgPlaySessionViewHolder.onStatusUpdate(gmCgPlayStatus, gmCgError.getErrorCode(), 0);
        if (gmCgPlayStatus.is(GmCgPlayStatus.StatusDeviceAllocated)) {
            this.mPlaySessionViewHolder.onDeviceInfoUpdate((GmCgDeviceInfo) obj);
        } else {
            GmCgPlayStatus gmCgPlayStatus2 = GmCgPlayStatus.StatusServerClosed;
            if (gmCgPlayStatus.is(gmCgPlayStatus2)) {
                this.mPlaySessionViewHolder.onStatusUpdate(gmCgPlayStatus2, gmCgError.getErrorCode(), ((Integer) obj).intValue());
            } else if (gmCgPlayStatus.is(GmCgPlayStatus.StatusRTCConnected)) {
                getDcEventHelper().onSessionConnected();
                resetShutterLatencyState();
            }
        }
        GmCgPlayStatusListener gmCgPlayStatusListener = this.mPlayStatusListener;
        if (gmCgPlayStatusListener != null) {
            gmCgPlayStatusListener.onGmCgPlayStatusUpdate(gmCgPlayStatus, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalWhenErrorHappen$30(GmCgError gmCgError) {
        GmCgPlayStatusListener gmCgPlayStatusListener = this.mPlayStatusListener;
        if (gmCgPlayStatusListener != null) {
            gmCgPlayStatusListener.onGmCgPlayError(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$internalWhenErrorHappen$31(GmCgError gmCgError) {
        GmCgPlayStatusListener gmCgPlayStatusListener = this.mPlayStatusListener;
        if (gmCgPlayStatusListener != null) {
            gmCgPlayStatusListener.onGmCgPlayWarning(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        internalUpdateStatus(GmCgPlayStatus.StatusLoadingFinished);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$null$41(GmCgError gmCgError, Void r46) {
        int i3 = 0;
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOGIN, false);
        if (GmCgError.isOK(gmCgError)) {
            onAutoLoginGameResult();
        } else {
            GmCgError gmCgError2 = GmCgError.ErrorAutoLoginGame;
            i3 = gmCgError2.getErrorCode();
            internalWhenErrorHappen(gmCgError2);
        }
        this.mSessionMonitor.reportAutoLoginCallback(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventChannelAck$16(String str) {
        getDcEventHelper().onEventChannelAck(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventChannelData$15(String str) {
        getDcEventHelper().onEventChannelData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventDataChannelConnected$21() {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcConnectionReady();
        }
        if (this.mSessionCfg.pEnableCloudAppMonitor) {
            sendAppMonitorReq(0);
        }
        if (this.mGameConfigInfo.pEnableLocalInput && this.mSessionCfg.pEnableClipboard) {
            sendClipboardDataToWebRtc();
        }
        if (this.mForPreview) {
            if (this.mSessionCfg.pEnableAdjustPreviewFpsRes) {
                CGLog.i("\u8bbe\u7f6e\u5c0f\u7a9715fps\u548c480p\u7684\u5206\u8fa8\u7387");
                setEncodePropertyForWebRtc(GmCgFramerateDef.FPS_15, GmCgResolutionDef.RES_480P);
            } else {
                CGLog.i("\u7981\u6b62\u8bbe\u7f6e\u5c0f\u7a97\u7684\u5e27\u7387\u548c\u5206\u8fa8\u7387");
            }
            sendDcEventRequest(CGDEventCloudAppWindowStatusRequest.OpenWindowStatusRequest());
            CGLog.i("onEventDataChannelConnected \u5f00\u542f\u5c0f\u7a97");
            return;
        }
        CGLog.i("onEventDataChannelConnected \u5173\u95ed\u5c0f\u7a97");
        sendDcEventRequest(CGDEventCloudAppWindowStatusRequest.CloseWindowStatusRequest());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventDataChannelDisconnected$22() {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcConnectionLost();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventDisconnect$14() {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgPlayDcConnectionLost();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventFinishInput$20() {
        GmCgImeInputController gmCgImeInputController = this.mImeInputController;
        if (gmCgImeInputController != null) {
            gmCgImeInputController.onImeInputCloudFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventGalleryOpen$18() {
        GmCgPlayStatusListener gmCgPlayStatusListener = this.mPlayStatusListener;
        if (gmCgPlayStatusListener != null) {
            gmCgPlayStatusListener.onGmCgPlayEventGalleryOpen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventGpsSwitched$26(boolean z16) {
        GmCgPlayStatusListener gmCgPlayStatusListener = this.mPlayStatusListener;
        if (gmCgPlayStatusListener != null) {
            gmCgPlayStatusListener.onGmCgPlayEventGpsSwitched(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventNetworkCarrierMismatch$28(String[] strArr, String str, String str2) {
        this.mPlayStatusListener.onGmCgNetworkCarrierMismatch(strArr, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventSessionInfo$27(String str) {
        getPushEventHelper().onPushEvent(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventStartInput$19() {
        GmCgImeInputController gmCgImeInputController = this.mImeInputController;
        if (gmCgImeInputController != null) {
            gmCgImeInputController.onImeInputCloudStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventStutter$25() {
        getStreamQualityAdjuster().onPlayStreamStutterHappen();
        GmCgPlayPerfListener gmCgPlayPerfListener = this.mPlayPerfListener;
        if (gmCgPlayPerfListener != null) {
            gmCgPlayPerfListener.onGmCgPlayPerfStreamStutterHappen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEventVoiceSwitched$17(boolean z16) {
        GmCgPlayStatusListener gmCgPlayStatusListener = this.mPlayStatusListener;
        if (gmCgPlayStatusListener != null) {
            gmCgPlayStatusListener.onGmCgPlayEventVoiceSwitched(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSuperResolutionTypeChange$54(int i3) {
        this.mPlayStatusListener.onGmCgPlaySuperResolutionTypeChanged(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processCloudGameLaunching$35(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestInGameLoginDefault: fail");
        }
        onCloudGameLoginResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processCloudGameLaunching$36(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestAutoLoginGame1: fail");
        }
        onCloudGameLoginResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processCloudGameLaunching$37(GmCgError gmCgError, Void r26) {
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestInGameLoginYyb: fail");
        }
        onCloudGameLoginResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryGameConfigFromServer$5(GmCgError gmCgError, CGGameConfigResp cGGameConfigResp) {
        CGSessionLogI("requestGetGameConfig result: " + gmCgError);
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_GAME_CONFIG, false);
        if (GmCgError.isOK(gmCgError)) {
            afterGotGameConfigSuccess(cGGameConfigResp);
            return;
        }
        CGSessionLogE("queryGameConfigFromServer failed, need continue: " + this.mSessionCfg.pAllowWorkIfNoGameConfig);
        if (this.mSessionCfg.pAllowWorkIfNoGameConfig) {
            internalUpdateStatusWithData(GmCgPlayStatus.StatusGameConfigGot, this.mGameConfigInfo);
            endPrepareCloudGameData();
            checkDeviceToUse();
            return;
        }
        internalWhenErrorHappen(GmCgError.ErrorFailOrInvalidGameConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releasePlay$8(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            internalWhenErrorHappen(GmCgError.ErrorServerClosedAfterSubAccountRelease);
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releasePlay$9(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            internalWhenErrorHappen(GmCgError.ErrorServerClosedAfterUserRelease);
        } else {
            internalWhenErrorHappen(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAutoLoginGame$42() {
        int i3;
        int i16;
        int i17;
        int playRenderWidth = this.mPlaySessionViewHolder.getPlayRenderWidth();
        int playRenderHeight = this.mPlaySessionViewHolder.getPlayRenderHeight();
        GmCgGameStreamQualityCfg curStreamQualityCfg = getStreamQualityAdjuster().getCurStreamQualityCfg();
        if (curStreamQualityCfg != null) {
            int i18 = curStreamQualityCfg.pResWidth;
            int i19 = curStreamQualityCfg.pResHeight;
            i17 = curStreamQualityCfg.pFps;
            i3 = i18;
            i16 = i19;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        this.mSessionCfg.pViewWidth = calculateViewWidth(Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
        this.mSessionCfg.pViewHeight = calculateViewHeight(Math.max(playRenderWidth, playRenderHeight), Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
        CGSessionLogI("GmCgPlayView width: " + this.mSessionCfg.pViewWidth + ", height = " + this.mSessionCfg.pViewHeight);
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOGIN, true);
        this.mSessionMonitor.reportCallAutoLogin();
        this.mBizHttpService.requestAutoLoginGame(this.mSessionCfg, this.mCgGameId, this.mDeviceReadyToUse.getDeviceID(), i3, i16, i17, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ce
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$null$41(gmCgError, (Void) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestLoadArchive$40(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOAD_ARCHIVE, false);
        if (GmCgError.isOK(gmCgError)) {
            onLoadArchiveResult();
        } else {
            CGSessionLogE("requestLoadArchive: fail");
            onLoadArchiveResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestSetMidasProp$45(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOAD_MIDAS, false);
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestSetMidasProp: fail");
        }
        onSetMidasPropResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestYybLogin$43(GmCgError gmCgError, Void r46) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOGIN, false);
        if (GmCgError.isOK(gmCgError)) {
            onAutoLoginGameResult();
        } else {
            internalWhenErrorHappen(GmCgError.ErrorAutoLoginGame);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetShutterLatencyState$51() {
        CGNetworkChangeObserver.mGmCgActivityNetWorkType = getActiveNetworkType();
        if (this.mPlayPerfListener != null) {
            CGLog.i("resetShutterLatencyState enableRemoteMediaStream: " + CGNetworkChangeObserver.mGmCgActivityNetWorkType);
            this.mPlayPerfListener.onGmCgPlayPerfStreamShutterLatency(0, 0L, CGNetworkChangeObserver.mGmCgActivityNetWorkType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartPlay$6(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestAutoLoginGame1: fail");
        }
        doRestartPlay("requestInGameGameForSP login");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartPlayWithResolutionChange$7(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestSetCloudGameResolution: fail");
        }
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null) {
            webRtcPlay(gmCgDeviceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$screenShot$11(GmCgSdkScreenShotListener gmCgSdkScreenShotListener, boolean[] zArr) {
        CGLog.w("screen shot timeout!!");
        gmCgSdkScreenShotListener.onScreenShotResult(null);
        zArr[0] = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendDcEventRequestThroughHttp$13(GmCgApiService.ActionResultListener actionResultListener, GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            if (actionResultListener != null) {
                actionResultListener.onActionSucceed();
            }
        } else if (actionResultListener != null) {
            actionResultListener.onActionResult(gmCgError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendUserFeedback$2(GmCgError gmCgError, CGCommonResp cGCommonResp) {
        if (GmCgError.isOK(gmCgError)) {
            CGLog.i("collectLog success!");
        } else {
            CGLog.i("collect log failed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParamsAndLaunchCloudGame$38(GmCgError gmCgError, CGMergeLaunchCloudGameResp cGMergeLaunchCloudGameResp) {
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_RPOCESS_MERGE_REQUEST, false);
        CGSessionLogI("requestMergeLaunchCloudGame result: " + cGMergeLaunchCloudGameResp);
        onSetParamsAndLaunchCloudGameResult();
        if (!GmCgError.isOK(gmCgError)) {
            CGSessionLogE("requestMergeLaunchCloudGame error");
        }
        handleMergeLaunchCloudGameResult(cGMergeLaunchCloudGameResp);
        this.mSessionMonitor.reportMergeLaunchCloudGameCallback(gmCgError.getErrorCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCloudGameFaceRecognition$1(Activity activity, GmCgError gmCgError, CGFaceRecognitionResult cGFaceRecognitionResult) {
        if (cGFaceRecognitionResult != null && CGStringUtil.notEmpty(cGFaceRecognitionResult.openlink)) {
            try {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(cGFaceRecognitionResult.openlink));
                intent.setFlags(805306368);
                activity.startActivity(intent);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        CGSessionLogI("requestFaceRecognitionOpenLink: " + cGFaceRecognitionResult + ", gmCgError: " + gmCgError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCollectTouchEventCounts$55() {
        GmCgPlayDcEventListener gmCgPlayDcEventListener = this.mPlayDcEventListener;
        if (gmCgPlayDcEventListener != null) {
            gmCgPlayDcEventListener.onGmCgSendTouchEvent(this.mLastTouchEventState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startLaunchCloudGameAndDoWebrtc$4() {
        setParamsAndLaunchCloudGame(this.mDeviceReadyToUse.getDeviceID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startLaunchTimeoutCheckTimer$39() {
        if (!this.mFirstFrameRendered) {
            this.mSessionMonitor.reportLaunchCostTooLong();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$webRtcPlay$52(String str, Logging.Severity severity, String str2) {
        int i3 = AnonymousClass13.$SwitchMap$org$tencwebrtc$Logging$Severity[severity.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.mSessionCfg.pRtcLogger.e(str2, str);
                        return;
                    }
                    return;
                }
                this.mSessionCfg.pRtcLogger.w(str2, str);
                return;
            }
            this.mSessionCfg.pRtcLogger.i(str2, str);
            return;
        }
        this.mSessionCfg.pRtcLogger.v(str2, str);
    }

    private void loadArchiveIfNecessary() {
        CGSessionLogI("loadArchiveIfNecessary, pForceSkipLoadArchive: " + this.mSessionCfg.pForceSkipLoadArchive);
        if (this.mGameConfigInfo.pSupportSaveArchive && !this.mSessionCfg.pForceSkipLoadArchive) {
            CGSessionLogI("game config support save archive");
            if (this.mDeviceIsNewAllocated && !this.mDeviceReadyToUse.hasSaveArchive()) {
                CGSessionLogI("not load archive: start load");
                requestLoadArchive();
                return;
            } else {
                CGSessionLogI("already load archive");
                configMidasPayIfNecessary();
                return;
            }
        }
        CGSessionLogI("game config NOT support save archive");
        configMidasPayIfNecessary();
    }

    private void logI(String str) {
        CGLog.i("CGPlaySessionImpl@" + hashCode() + MsgSummary.STR_COLON + str);
    }

    private boolean needDoV2CloudGameLoginDefault() {
        if (this.mSessionCfg.pUseV2CloudGameLogin && this.mInGameLoginChannelType != 0 && CGStringUtil.notEmpty(this.mInGameLoginDefaultParam)) {
            return true;
        }
        return false;
    }

    private boolean needDoV2CloudGameLoginV1() {
        if (this.mInGameLoginChannelType != 0 && this.mGameAutoLoginInfo != null) {
            return true;
        }
        return false;
    }

    private boolean needDoV2CloudGameLoginYyb() {
        if (this.mSessionCfg.pUseV2CloudGameLogin && CGStringUtil.notEmpty(this.mInGameLoginYybParam)) {
            return true;
        }
        return false;
    }

    private void onAutoLoginGameResult() {
        deviceReadyToConnect();
    }

    private void onCloudGameLoginResult() {
        this.mInGameLoginDefaultParam = "";
        this.mInGameLoginYybParam = "";
        this.mGameAutoLoginInfo = null;
        deviceReadyToConnect();
    }

    private void onLoadArchiveResult() {
        this.mHasLoadArchiveProcess = true;
        configMidasPayIfNecessary();
    }

    private void onSetCloudGameResolutionResult() {
        loadArchiveIfNecessary();
    }

    private void onSetMidasPropResult() {
        if (this.mSessionCfg.pUseV2CloudGameLogin) {
            deviceReadyToConnect();
        } else {
            autoLoginIfNecessary();
        }
    }

    private void onSetParamsAndLaunchCloudGameResult() {
        CGSessionLogI("onSetParamsAndLaunchCloudGameResult, mCurSessionStatus: " + this.mCurSessionStatus + ", mCurPlayStatus: " + this.mCurPlayStatus);
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        if (this.mCurSessionStatus.is(GmCgSessionStatus.StatusSessionStartLaunchCloudGame)) {
            this.mCurSessionStatus = GmCgSessionStatus.StatusSessionWaitingCGData;
            CGSessionLogI("onSetParamsAndLaunchCloudGameResult in waiting ");
            return;
        }
        CGSessionLogI("start into StatusFirstFramedRendered");
        this.mCurSessionStatus = GmCgSessionStatus.StatusSessionFinishLaunchCloudGame;
        GmCgDelayCounter.getInstance().recordWebrtcLinkProcessEnd();
        internalUpdateStatus(GmCgPlayStatus.StatusFirstFramedRendered);
        internalUpdateStatus(GmCgPlayStatus.StatusInStreaming);
        sendAppMonitorReq(0);
        startCollectTouchEventCounts();
        doDelayLoadingAfterConnected();
        GmCgDelayCounter.getInstance().reportStartUpDelay();
    }

    private void onSuperResolutionTypeChange(@GmCgSuperResolutionType final int i3) {
        this.mSessionCtx.pSrType = i3;
        if (this.mPlayStatusListener != null) {
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.db
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.lambda$onSuperResolutionTypeChange$54(i3);
                }
            });
        }
    }

    private void processCloudGameLaunching() {
        CGSessionLogI("processCloudGameLaunching , pUseV2CloudGameLogin: " + this.mSessionCfg.pUseV2CloudGameLogin + ", mInGameLoginChannelType: " + this.mInGameLoginChannelType + ", mGameAutoLoginInfo: " + this.mGameAutoLoginInfo);
        if (needDoV2CloudGameLoginDefault()) {
            CGSessionLogI("processCloudGameLaunching -> needDoV2CloudGameLoginDefault");
            requestInGameLoginDefault(this.mInGameLoginChannelType, this.mInGameLoginDefaultParam, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ci
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.this.lambda$processCloudGameLaunching$35(gmCgError, (CGCommonResp) obj);
                }
            });
            return;
        }
        if (needDoV2CloudGameLoginV1()) {
            CGSessionLogI("processCloudGameLaunching -> needDoV2CloudGameLoginV1");
            requestInGameGameForSP(this.mInGameLoginChannelType, this.mGameAutoLoginInfo, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cj
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.this.lambda$processCloudGameLaunching$36(gmCgError, (CGCommonResp) obj);
                }
            });
            return;
        }
        if (needDoV2CloudGameLoginYyb()) {
            CGSessionLogI("processCloudGameLaunching -> needDoV2CloudGameLoginYyb");
            requestInGameLoginYyb(this.mInGameLoginYybParam, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ck
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.this.lambda$processCloudGameLaunching$37(gmCgError, (Void) obj);
                }
            });
            return;
        }
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (!gmCgSessionCfg.pUseV2CloudGameLogin && !gmCgSessionCfg.wantYybLogin()) {
            CGSessionLogI("processCloudGameLaunching -> loadArchiveIfNecessary");
            loadArchiveIfNecessary();
        } else {
            CGSessionLogI("processCloudGameLaunching -> startLaunchCloudGameAndDoWebrtc");
            startLaunchCloudGameAndDoWebrtc();
        }
    }

    private void queryGameConfigFromServer() {
        CGSessionLogI("queryGameConfigFromServer");
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_QUERY_GAME_CONFIG, true);
        this.mBizHttpService.requestGetGameConfig(this.mCgGameId, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cw
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$queryGameConfigFromServer$5(gmCgError, (CGGameConfigResp) obj);
            }
        });
    }

    private void realSetInputController(Activity activity, GmCgImeInputController gmCgImeInputController) {
        CGSessionLogI("realSetInputController");
        this.mActivity = activity;
        this.mImeInputController = gmCgImeInputController;
    }

    private void reportQosInfoToWebRtc(String str, String str2, boolean z16, String str3, String str4) {
        String str5;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("province", str);
            jSONObject.put("ip", str2);
            if (z16) {
                str5 = "on";
            } else {
                str5 = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            jSONObject.put(WebRTCSDK.QOS_STATE, str5);
            jSONObject.put(WebRTCSDK.QOS_TAG, str3);
            jSONObject.put(WebRTCSDK.QOS_UUID, str4);
        } catch (JSONException unused) {
            CGSessionLogE("Failed to put province/ip/qos information into json");
        }
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.ReportSDKInfo(jSONObject);
        }
    }

    private void requestAutoLoginGame() {
        CGSessionLogI("requestAutoLoginGame");
        internalUpdateStatus(GmCgPlayStatus.StatusLoginLaunchingDevice);
        this.mPlaySessionViewHolder.getPlayRenderView().post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bq
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$requestAutoLoginGame$42();
            }
        });
    }

    private void requestInGameGameForSP(int i3, GmCgGameLoginInfo gmCgGameLoginInfo, @Nullable final CGBizHttpService.ResultListener<CGCommonResp> resultListener) {
        String str;
        CGSessionLogI("requestInGameGameForSP gameAutoLoginInfo: " + gmCgGameLoginInfo + ", mCgGameId: " + this.mCgGameId);
        internalUpdateStatus(GmCgPlayStatus.StatusLoginLaunchingDevice);
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        String deviceID = this.mDeviceReadyToUse.getDeviceID();
        String str2 = this.mCgGameId;
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg != null) {
            str = gmCgSessionCfg.pGameLoginPayLoad;
        } else {
            str = "";
        }
        cGBizHttpService.requestCloudGameLogin(deviceID, str2, i3, null, "", str, gmCgGameLoginInfo, new CGBizHttpService.ResultListener<CGCommonResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.9
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public void onResult(@NonNull GmCgError gmCgError, CGCommonResp cGCommonResp) {
                CGBizHttpService.ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onResult(gmCgError, cGCommonResp);
                }
            }
        });
    }

    private void requestInGameLoginDefault(int i3, String str, @Nullable CGBizHttpService.ResultListener<CGCommonResp> resultListener) {
        requestInGameLoginDefault(i3, str, true, null, resultListener);
    }

    private void requestInGameLoginYyb(String str, CGBizHttpService.ResultListener<Void> resultListener) {
        requestInGameLoginYyb(str, true, resultListener);
    }

    private void requestLoadArchive() {
        String str;
        internalUpdateStatus(GmCgPlayStatus.StatusLoadingGameArchive);
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg != null && CGStringUtil.notEmpty(gmCgSessionCfg.pArchiveSessionId)) {
            str = this.mSessionCfg.pArchiveSessionId;
        } else {
            str = "";
        }
        CGSessionLogI("requestLoadArchive, sessionId: " + str);
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOAD_ARCHIVE, true);
        this.mBizHttpService.requestLoadArchive(this.mDeviceReadyToUse.getDeviceID(), str, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bt
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$requestLoadArchive$40(gmCgError, (CGCommonResp) obj);
            }
        });
    }

    private void requestSetCloudGameResolution() {
        CGSessionLogI("requestSetCloudGameResolution");
        this.mPlaySessionViewHolder.getPlayRenderView().post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bh
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.doRequestSetCloudGameResolution();
            }
        });
    }

    private void requestSetMidasProp() {
        CGSessionLogI("requestSetMidasProp");
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOAD_MIDAS, true);
        this.mBizHttpService.requestSetMidasProp(this.mSessionCfg, this.mDeviceReadyToUse.getDeviceID(), new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bz
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$requestSetMidasProp$45(gmCgError, (CGCommonResp) obj);
            }
        });
    }

    private void requestYybLogin() {
        CGSessionLogI("requestYybLogin");
        internalUpdateStatus(GmCgPlayStatus.StatusLoginLaunchingDevice);
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_PROCESS_LOGIN, true);
        this.mBizHttpService.requestYybCloudGameLogin(this.mSessionCfg, this.mDeviceReadyToUse.getDeviceID(), new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cg
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public final void onResult(GmCgError gmCgError, Object obj) {
                CGPlaySessionImpl.this.lambda$requestYybLogin$43(gmCgError, (Void) obj);
            }
        });
    }

    private void resetShutterLatencyState() {
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bu
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$resetShutterLatencyState$51();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnMainThread(@NonNull Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            return;
        }
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        this.mMainHandler.post(runnable);
    }

    private void runOnMainThreadAfterDelay(@NonNull Runnable runnable, long j3) {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        this.mMainHandler.postDelayed(runnable, j3);
    }

    private void setCloudGameResolutionIfNecessary() {
        CGSessionLogI("setCloudGameResolutionIfNecessary, pForceSkipSetResolution: " + this.mSessionCfg.pForceSkipSetResolution);
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if ((gmCgSessionCfg.pUseV2CloudGameLogin || gmCgSessionCfg.wantYybLogin()) && !this.mSessionCfg.pForceSkipSetResolution) {
            if (this.mDeviceReadyToUse.hasSetResolution()) {
                CGSessionLogI("already set resolution");
                onSetCloudGameResolutionResult();
                return;
            } else {
                CGSessionLogI("not set resolution: start set resolution");
                requestSetCloudGameResolution();
                return;
            }
        }
        onSetCloudGameResolutionResult();
    }

    private void setEncodePropertyForWebRtc(GmCgFramerateDef gmCgFramerateDef, GmCgResolutionDef gmCgResolutionDef) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fps", gmCgFramerateDef.getString());
            jSONObject.put("resolution", gmCgResolutionDef.getValue());
            WebRTCSDK webRTCSDK = this.mWebRTCSdk;
            if (webRTCSDK != null) {
                webRTCSDK.setEncodeProperty(jSONObject);
            } else {
                CGSessionLogE("mWebRTCSdk is null, not to setEncodeProperty");
            }
        } catch (Exception e16) {
            CGSessionLogE("Failed to setEncodeProperty " + e16);
        }
    }

    private void setParamsAndLaunchCloudGame(String str) {
        boolean z16;
        boolean z17;
        CGSessionLogI("setParamsAndLaunchCloudGame");
        ArrayList arrayList = new ArrayList();
        boolean z18 = false;
        if (isNeedSetResolution()) {
            CGSessionLogI("need set resolution");
            arrayList.add(createSetResolutionParam(str));
            z16 = true;
        } else {
            z16 = false;
        }
        if (isNeedLoadArchive()) {
            CGSessionLogI("need load archive");
            arrayList.add(createSetLoadArchiveParam(str));
            z17 = true;
        } else {
            z17 = false;
        }
        if (isNeedConfigMidasPay()) {
            CGSessionLogI("need config midas pay");
            arrayList.add(createSetMidasParam(str));
            z18 = true;
        }
        GmCgDelayCounter.getInstance().recordSubProcess(GmCgDelayCounter.CGDelayLifeCycle.MAIN_PROCESS_LOAD_ARCHIVE_WEBRTC_LINK, GmCgDelayCounter.CGDelayLifeCycle.CGWebrtcSubProcessLifeCycle.SUB_RPOCESS_MERGE_REQUEST, true);
        if (this.mBizHttpService != null) {
            this.mSessionMonitor.reportCallMergeLaunchCloudGame(z16, z17, z18);
            this.mBizHttpService.requestMergeLaunchCloudGame(str, arrayList, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bn
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.this.lambda$setParamsAndLaunchCloudGame$38(gmCgError, (CGMergeLaunchCloudGameResp) obj);
                }
            });
        }
    }

    private void setServerConfigForWebRtc(boolean z16, boolean z17, boolean z18) {
        Object obj;
        Object obj2;
        CGSessionLogI("setServerConfigForWebRtc enableEncAudio: " + z16 + ", enableSoftEnc: " + z17 + ", enableShowDelay: " + z18);
        try {
            JSONObject jSONObject = new JSONObject();
            String str = "1";
            if (z16) {
                obj = "1";
            } else {
                obj = "0";
            }
            jSONObject.put(WebRTCSDK.ENCODER_USE_AUDIO, obj);
            if (z17) {
                obj2 = "1";
            } else {
                obj2 = "0";
            }
            jSONObject.put(WebRTCSDK.ENCODER_SOFTWARE_ENCODE, obj2);
            if (!z18) {
                str = "0";
            }
            jSONObject.put(WebRTCSDK.PASS_WEBRTC_PERF_STATS, str);
            WebRTCSDK.setServerConfig(jSONObject);
        } catch (Exception e16) {
            CGSessionLogE("Failed to setServerConfig " + e16);
        }
    }

    private void setupViewHolderAfterGameConfig() {
        this.mPlaySessionViewHolder.onGameLoadingViewCfgGot(this.mGameConfigInfo.pLoadingViewCfg);
        enableImeInputController(this.mGameConfigInfo.pEnableLocalInput);
    }

    private boolean shouldUseH265() {
        return getStreamQualityAdjuster().shouldUseH265();
    }

    private boolean shouldUseHwDecode() {
        if (!CGGlbConfig.isForceHwDec() && !getStreamQualityAdjuster().shouldUseHwDecode()) {
            return false;
        }
        return true;
    }

    private void startCollectTouchEventCounts() {
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg != null) {
            if (gmCgSessionCfg.pNoTouchEventCallbackTimeSeconds > 0 || gmCgSessionCfg.pNoTouchLongTime > 0) {
                CGLog.i("startCollectTouchEventCounts, period: " + this.mSessionCfg.pNoTouchEventCallbackTimeSeconds + ", pNoTouchLongTime: " + this.mSessionCfg.pNoTouchLongTime + ", longTimeCountdown: " + this.mSessionCfg.pNoTouchLongTimeCountdown);
                cancelTouchEventCounts();
                this.mLastTouchEventState = 0;
                if (this.mPlayDcEventListener != null) {
                    runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dn
                        @Override // java.lang.Runnable
                        public final void run() {
                            CGPlaySessionImpl.this.lambda$startCollectTouchEventCounts$55();
                        }
                    });
                }
                ScheduledExecutorService scheduledExecutorService = this.mPeriodExecutorService;
                if (scheduledExecutorService != null) {
                    this.mTouchCountsSchedulder = scheduledExecutorService.scheduleAtFixedRate(new AnonymousClass12(), 1L, 1L, TimeUnit.SECONDS);
                }
            }
        }
    }

    private void startLaunchCloudGameAndDoWebrtc() {
        CGSessionLogI("startLaunchCloudGameOrDoWebrtc, mCurSessionStatus: " + this.mCurPlayStatus);
        if (this.mDeviceReadyToUse != null) {
            this.mCurSessionStatus = GmCgSessionStatus.StatusSessionStartLaunchCloudGame;
            this.mPlaySessionViewHolder.getPlayRenderView().post(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cf
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.lambda$startLaunchCloudGameAndDoWebrtc$4();
                }
            });
            deviceReadyToConnect();
            return;
        }
        CGSessionLogE("startLaunchCloudGameAndDoWebrtc failed, mDeviceReadyToUse is null!");
    }

    private void startLaunchTimeoutCheckTimer() {
        cancelLaunchTimeoutCheckTimer();
        this.mLaunchTimeoutCheckTimerTask = this.mLaunchTimeoutCheckTimer.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cb
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$startLaunchTimeoutCheckTimer$39();
            }
        }, 10L, TimeUnit.SECONDS);
    }

    private void startPrepareCloudGameData() {
        CGSessionLogI("startPrepareCloudGameData");
        this.mCurSessionStatus = GmCgSessionStatus.StatusSessionPrepareCGData;
        queryGameConfigFromServer();
        checkDeviceToUse();
    }

    private void subscribePrivilege() {
        CGSessionLogI("subscribePrivilege");
        try {
            WebRTCSDK webRTCSDK = this.mWebRTCSdk;
            if (webRTCSDK != null) {
                webRTCSDK.subscribePriviledge(generatePrivileges(true));
            } else {
                CGSessionLogE("mWebRTCSDK is null, not to subscribePriviledge");
            }
        } catch (Exception unused) {
            CGSessionLogE("Failed to subscribePrivilege ");
        }
    }

    private void unsubscribePrivilege() {
        CGSessionLogI("unsubscribePrivilege");
        try {
            WebRTCSDK webRTCSDK = this.mWebRTCSdk;
            if (webRTCSDK != null) {
                webRTCSDK.unSubscribePriviledge(generatePrivileges(true));
            } else {
                CGSessionLogE("mWebRTCSDK is null, not to unSubscribePriviledge");
            }
        } catch (Exception unused) {
            CGSessionLogE("Failed to unsubscribePrivilege ");
        }
    }

    private void updatePriviledge(boolean z16) {
        CGSessionLogI("updatePriviledge: " + z16);
        try {
            WebRTCSDK webRTCSDK = this.mWebRTCSdk;
            if (webRTCSDK != null) {
                webRTCSDK.updatePriviledges(generatePrivileges(z16));
            } else {
                CGSessionLogE("mWebRTCSDK is null, not to setEncodeProperty");
            }
        } catch (Exception unused) {
            CGSessionLogE("Failed to updatePriviledge ");
        }
    }

    private void webRtcKickOff() {
        CGSessionLogI("webRtcKickOff");
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.kickOffline();
        }
    }

    private void webRtcOnDestroy() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.onDestroy();
            this.mWebRTCSdk = null;
        }
    }

    private void webRtcOnPause() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.pause();
        }
    }

    private void webRtcOnStart() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.onStart();
        }
    }

    private void webRtcPlay(GmCgDeviceInfo gmCgDeviceInfo) {
        webRtcPlay(gmCgDeviceInfo, false);
    }

    private void webRtcPlayAgain(GmCgDeviceInfo gmCgDeviceInfo) {
        CGSessionLogI("webRtcPlayAgain");
        internalUpdateStatus(GmCgPlayStatus.StatusRTCConnecting);
        doWebRtcRestartPlay(gmCgDeviceInfo);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void OnEventDataReport(int i3, int i16, final Map<String, String> map) {
        if (this.mPlayPerfListener != null && map != null) {
            final String str = "VDecoder_dataType_" + i3;
            map.put("xf_sys_os", CGSystemUtil.getAndroidVersionString());
            map.put("xf_brand", CGGlbConfig.getBuildBrand());
            map.put("xf_board", CGGlbConfig.getBuildManufacturer());
            map.put("xf_model", CGGlbConfig.getBuildModel());
            map.put("xf_hardware", CGGlbConfig.getBuildHardware());
            map.put("xf_net_type", CGNetworkUtil.getNetworkTypeSymbol(this.mContext));
            map.put("xf_user_id", CGGlbConfig.getUserId());
            map.put("xf_device_id", CGGlbConfig.getXID());
            map.put("xf_client_type", "android_" + CGGlbConfig.getAppBizNo());
            map.put("xf_app_version", CGAppUtil.getCurrentVersion(this.mContext));
            map.put("xf_biz_id", CGGlbConfig.getBizId());
            map.put("xf_channel", CGGlbConfig.getAppChannel());
            map.put("xf_game_id", this.mCgGameId);
            map.put("xf_instance_id", this.mDeviceReadyToUse.getDeviceID());
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.da
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.lambda$OnEventDataReport$24(str, map);
                }
            });
            return;
        }
        CGLog.v("OnEventDataReport: listener is null or params is null");
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void addDcEventParser(GmCgDcEventParser gmCgDcEventParser) {
        getDcEventHelper().addDcEventParser(gmCgDcEventParser);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void cancelQueue() {
        CGSessionLogI("cancelQueue");
        CGPlayAllocatorImpl cGPlayAllocatorImpl = this.mPlayAllocator;
        if (cGPlayAllocatorImpl != null) {
            cGPlayAllocatorImpl.cancelQueue();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void changeOrientationOnFly(int i3) {
        this.mPlaySessionViewHolder.setPlayScreenOrientation(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void configAutoLogin(int i3, String str, String str2, String str3) {
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg == null) {
            return;
        }
        gmCgSessionCfg.pAutoLoginIdType = 0;
        gmCgSessionCfg.pAutoLoginChannelType = i3;
        gmCgSessionCfg.pAutoLoginChannelAppId = str;
        gmCgSessionCfg.pAutoLoginChannelOpenId = str2;
        gmCgSessionCfg.pAutoLoginChannelAccessToken = str3;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void configAutoLoginForDelegateCode(int i3, String str, String str2) {
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg == null) {
            return;
        }
        gmCgSessionCfg.pAutoLoginIdType = 3;
        gmCgSessionCfg.pAutoLoginChannelType = i3;
        gmCgSessionCfg.pAutoLoginChannelParam1 = str;
        gmCgSessionCfg.pAutoLoginChannelParam2 = str2;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void configAutoLoginForYsdk(int i3, String str, String str2, String str3, String str4) {
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg == null) {
            return;
        }
        gmCgSessionCfg.pAutoLoginIdType = 6;
        gmCgSessionCfg.pAutoLoginChannelType = i3;
        gmCgSessionCfg.pAutoLoginChannelAppId = str;
        gmCgSessionCfg.pAutoLoginChannelOpenId = str2;
        gmCgSessionCfg.pAutoLoginChannelAccessToken = str3;
        gmCgSessionCfg.pAutoLoginChannelParam1 = str4;
    }

    int convertToEven(int i3) {
        if (i3 % 2 != 0) {
            return i3 + 1;
        }
        return i3;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void directPlay() {
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bj
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$directPlay$10();
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void enableRemoteMediaStream(boolean z16) {
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            CGLog.i("enableRemoteMediaStream failed, session is stopped status!");
            return;
        }
        if (this.mWebRTCSdk != null) {
            CGLog.i("enableRemoteMediaStream isEnable: " + z16 + ", status: " + this.mCurPlayStatus);
            if (!z16) {
                this.mWebRTCSdk.enableRemoteMediaStream(false);
                internalUpdateStatus(GmCgPlayStatus.RemoteStreamStopped);
            } else if (z16 && this.mCurPlayStatus.is(GmCgPlayStatus.RemoteStreamStopped)) {
                if (getDataChannelConnectedState() && getSignalServerConnectedState()) {
                    this.mWebRTCSdk.enableRemoteMediaStream(true);
                    internalUpdateStatus(GmCgPlayStatus.StatusInStreaming);
                } else {
                    CGSessionLogI("recover remoteStream failed!");
                    internalUpdateStatus(GmCgPlayStatus.RemoteStreamFailed);
                }
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void fetchCloudGameLog() {
        GmCgDeviceInfo gmCgDeviceInfo;
        CGSessionLogI("start fetchCloudGameLog ");
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null && (gmCgDeviceInfo = this.mDeviceReadyToUse) != null) {
            cGBizHttpService.fetchLog(gmCgDeviceInfo.getDeviceID(), new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ca
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.lambda$fetchCloudGameLog$3(gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public boolean getAudioStatus() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            return webRTCSDK.getAudioStatus();
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public int getConfigValue(int i3) {
        return -1;
    }

    public boolean getDataChannelConnectedState() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            return webRTCSDK.getDataChannelConnectedState();
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public int getGameType() {
        return 1;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public GmCgPlayStatus getPlayStatus() {
        return this.mCurPlayStatus;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public WebRTCParameters getRtcParameter() {
        return this.mWebRTCParameters;
    }

    public boolean getSignalServerConnectedState() {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            return webRTCSDK.getSignalServerConnectedState();
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public String getVideoCodecType() {
        CGStreamQualityAdjuster streamQualityAdjuster = getStreamQualityAdjuster();
        if (streamQualityAdjuster == null) {
            CGLog.w("getStreamQualityAdjuster() return null, video codec type is unknown");
            return "unknown";
        }
        VideoCodecType streamVideoCodecType = streamQualityAdjuster.getStreamVideoCodecType();
        if (streamVideoCodecType == null) {
            CGLog.w("video codec type is null, return unknown");
            return "unknown";
        }
        return streamVideoCodecType.name();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(GmCgPlayView gmCgPlayView, FrameLayout frameLayout) {
        this.mUseTextureView = false;
        initPlayView(gmCgPlayView, frameLayout);
        initInternal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initForTextureView(GmCgPlayTextureView gmCgPlayTextureView, FrameLayout frameLayout) {
        CGLog.d("rogers CGPlaySessionImpl/initForTextureView: ");
        this.mUseTextureView = true;
        initPlayView(gmCgPlayTextureView, frameLayout);
        initInternal();
    }

    protected void initPlayView(GmCgPlayTextureView gmCgPlayTextureView, FrameLayout frameLayout) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("rogers CGPlaySessionImpl/initPlayView: playViewContainer == null ? ");
        sb5.append(frameLayout == null);
        sb5.append(", playTextureView == null ?");
        sb5.append(gmCgPlayTextureView == null);
        CGLog.d(sb5.toString());
        if (frameLayout != null) {
            GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
            GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder = new GmCgPlaySessionViewHolder(frameLayout, gmCgSessionCfg.pUseCustomLoadingView, gmCgSessionCfg.pEnableExtraInfoOverlay, gmCgSessionCfg.pExtraInfoOverlayRightOrLeft, gmCgSessionCfg.pExtraInfoOverLayBottomOrTop, gmCgSessionCfg.pEnableConfigCallback);
            this.mPlaySessionViewHolder = gmCgPlaySessionViewHolder;
            gmCgPlaySessionViewHolder.setDefaultLoadingPortraitResId(this.mSessionCfg.pDefaultLoadingPortraitResId);
            this.mPlaySessionViewHolder.setDefaultLoadingLandscapeResId(this.mSessionCfg.pDefaultLoadingLandscapeResId);
            this.mPlaySessionViewHolder.setDefaultLoadingBackgroundResId(this.mSessionCfg.pDefaultLoadingBackgroundResId);
            this.mPlaySessionViewHolder.setLoadingScaleType(this.mSessionCfg.pLoadingScaleType);
            setImeInputController(this.mActivity, this.mPlaySessionViewHolder);
        } else if (gmCgPlayTextureView != null) {
            this.mPlaySessionViewHolder = new GmCgPlaySessionViewHolder(gmCgPlayTextureView);
        } else {
            throw new IllegalArgumentException("no play view or container view");
        }
        if (this.mContext == null) {
            this.mContext = this.mPlaySessionViewHolder.getContext();
        }
        this.mPlaySessionViewHolder.setPlayScreenOrientation(this.mSessionCfg.pGameScreenOrientation);
        this.mPlaySessionViewHolder.onBaseInfoUpdate(CGGlbConfig.getUserId(), this.mCgGameId);
        if (isTv()) {
            CGLog.i("rogers now set skip render");
            WebRTCSDK.enableHidSensor(true);
            WebRTCSDK.setSkipRender(true);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public /* synthetic */ boolean isSupportMonitorConfig() {
        return com.tencent.gamematrix.gmcg.webrtc.gamepad.api.a.a(this);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean isSupportTGPAConfig() {
        return false;
    }

    protected boolean isTv() {
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void keepRtcConnection(boolean z16) {
        CGSessionLogI("keepRtcConnection: " + z16);
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.keepConnection(z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public /* synthetic */ void loadGameSceneForSDKScene(int i3, boolean z16) {
        com.tencent.gamematrix.gmcg.webrtc.gamepad.api.a.b(this, i3, z16);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public /* synthetic */ boolean loadGameSceneFromMonitor(int i3, String str, boolean z16) {
        return com.tencent.gamematrix.gmcg.webrtc.gamepad.api.a.c(this, i3, str, z16);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean loadGameSceneFromTGPA(String str) {
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean loadKeyMapConfig(String str, String str2) {
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void login(GmCgApiService.ActionResultListener actionResultListener) {
        login(null, actionResultListener);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void loginGameInCloudGame(GmCgGameLoginInfo gmCgGameLoginInfo) {
        String str;
        if (gmCgGameLoginInfo == null) {
            CGLog.w("loginGameInCloudGame failed, gmCgGameLoginInfo is null!");
            return;
        }
        int i3 = gmCgGameLoginInfo.pIdType;
        String str2 = "";
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 7) {
                    return;
                }
            } else {
                CGBizHttpService cGBizHttpService = this.mBizHttpService;
                if (cGBizHttpService != null) {
                    String str3 = this.mCgGameId;
                    String deviceID = this.mDeviceReadyToUse.getDeviceID();
                    GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
                    if (gmCgSessionCfg == null) {
                        str = "";
                    } else {
                        str = gmCgSessionCfg.pGameLoginPayLoad;
                    }
                    cGBizHttpService.requestAutoLoginGameWithNoResolution(gmCgGameLoginInfo, str3, deviceID, str, new CGBizHttpService.ResultListener<Void>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.2
                        @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                        public void onResult(GmCgError gmCgError, Void r26) {
                            if (GmCgError.isOK(gmCgError)) {
                                return;
                            }
                            CGPlaySessionImpl.this.CGSessionLogE("requestAutoLoginGameWithNoResolution: fail");
                        }
                    });
                    return;
                }
                return;
            }
        }
        CGBizHttpService cGBizHttpService2 = this.mBizHttpService;
        if (cGBizHttpService2 != null) {
            String deviceID2 = this.mDeviceReadyToUse.getDeviceID();
            String str4 = this.mCgGameId;
            int i16 = gmCgGameLoginInfo.autoLoginChannelType;
            GmCgSessionCfg gmCgSessionCfg2 = this.mSessionCfg;
            if (gmCgSessionCfg2 != null) {
                str2 = gmCgSessionCfg2.pGameLoginPayLoad;
            }
            cGBizHttpService2.requestCloudGameLogin(deviceID2, str4, i16, null, "", str2, gmCgGameLoginInfo, new CGBizHttpService.ResultListener<CGCommonResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.1
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public void onResult(GmCgError gmCgError, CGCommonResp cGCommonResp) {
                    if (GmCgError.isOK(gmCgError)) {
                        return;
                    }
                    CGPlaySessionImpl.this.CGSessionLogE("requestSetCloudGameResolution: fail");
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onCumulativeDelayedInformationReport(ByteBuffer byteBuffer, int i3) {
        if (byteBuffer != null && enableCumulativeDelayed()) {
            try {
                byteBuffer.position(i3);
                byteBuffer.getInt();
                int i16 = (byteBuffer.get() >> 6) & 3;
                byteBuffer.getShort();
                byte b16 = byteBuffer.get();
                if (i16 == 1 && b16 == 1) {
                    short s16 = byteBuffer.getShort();
                    for (int i17 = 0; i17 < s16; i17++) {
                        long j3 = byteBuffer.getLong();
                        double d16 = byteBuffer.getDouble();
                        GmCgPlayPerfListener gmCgPlayPerfListener = this.mPlayPerfListener;
                        if (gmCgPlayPerfListener != null) {
                            gmCgPlayPerfListener.onGmCgPlayCumulativeDelayedUpdate(j3, d16);
                        }
                        CGLog.d("channelDataType perfStatsPayloadType : " + ((int) b16) + " arrival_time_ms: " + j3 + " smoothed_delay_ms:" + d16);
                    }
                }
            } catch (BufferUnderflowException e16) {
                CGLog.w("bufferUnderflowException: " + e16.getMessage());
            } catch (Exception e17) {
                CGLog.w("exception: " + e17.getMessage());
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onDecodeErrCodeReport(boolean z16, int i3, int i16, String str) {
        CGLog.e("onDecodeErrCodeReported, isCustomizeDecoder:" + z16 + " , errCode:" + i3 + ", subErrCode:" + i16 + " errorDesc: " + str);
        if (z16) {
            GmCgError gmCgError = GmCgError.ErrorNewVideoDecoderError;
            gmCgError.setSubErrorMsg(i3, i16 + "\u65b0\u89e3\u7801\u5668\u5f02\u5e38 errdesc: " + str);
            internalWhenErrorHappen(gmCgError);
            return;
        }
        GmCgError gmCgError2 = GmCgError.ErrorDefaultVideoDecoderError;
        gmCgError2.setSubErrorMsg(i3, i16 + "\u89e3\u7801\u5668\u5f02\u5e38 errdesc: " + str);
        internalWhenErrorHappen(gmCgError2);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventBeforeConnected(String str, String str2, boolean z16) {
        CGLog.i("onEventBeforeConnected: " + str);
        this.mRemoteNetCarrier = str2;
        this.mSupportNetFreeFlow = this.mDeviceReadyToUse.supportFreeFlow();
        this.mRealNetFreeFlow = z16;
        this.mCandidateIp = getDestinationIp(str);
        this.mSessionMonitor.reportBeforeWebRTCConnect();
        this.mSessionMonitor.reportBeforeP2PConnect();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventChannelAck(final String str) {
        CGSessionLogI("onEventChannelAck: " + str);
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cp
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventChannelAck$16(str);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventChannelData(final String str) {
        CGSessionLogI("onEventChannelData: " + str);
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dg
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventChannelData$15(str);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventClipBoardDataRecved(final String str) {
        CGSessionLogI("onEventClipBoardDataRecved");
        if (this.mGameConfigInfo.pEnableLocalInput && this.mSessionCfg.pEnableClipboard) {
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cc
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.lambda$onEventClipBoardDataRecved$23(str);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventCodecTypeReported(VideoCodecType videoCodecType) {
        CGSessionLogI("onEventCodecTypeReported: " + videoCodecType.mimeType());
        this.mSessionCtx.pCodecType = videoCodecType;
        getStreamQualityAdjuster().onVideoCodecTypeReported(videoCodecType);
        setPlayStreamQuality(getStreamQualityAdjuster().getCurStreamQualityId());
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportCodecTypeReported(videoCodecType + "|" + getStreamQualityAdjuster().getStreamCodecAbility().getValue());
        }
        internalUpdateStatusWithData(GmCgPlayStatus.StatusStreamQualityConfigGot, getStreamQualityAdjuster().getStreamQualityCfgList());
        this.mPlaySessionViewHolder.onStreamConfigGot(getStreamQualityAdjuster().getStreamCodecAbility(), getStreamQualityAdjuster().getStreamVideoCodecType());
        if (getStreamQualityAdjuster().badAbilityToRun()) {
            internalWhenErrorHappen(GmCgError.ErrorPoorMobileDevicePerformance);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventConnectFailed(WebRTCEvents.ConnectionState connectionState, String str) {
        onEventConnectFailed(connectionState, str, "");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventConnectStatus(WebRTCEvents.ConnectStateDisplay connectStateDisplay) {
        CGSessionLogI("onEventConnectStatus: " + connectStateDisplay.name());
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventConnected(String str, String str2, boolean z16) {
        CGSessionLogI("onEventConnected: " + str + "|" + str2 + "|" + z16 + ", mCurSessionStatus: " + this.mCurSessionStatus);
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        this.mRemoteNetCarrier = str2;
        this.mSupportNetFreeFlow = this.mDeviceReadyToUse.supportFreeFlow();
        this.mRealNetFreeFlow = z16;
        this.mCandidateIp = getDestinationIp(str);
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            CGSessionCtx cGSessionCtx = this.mSessionCtx;
            cGSessionMonitor.reportP2PConnected(cGSessionCtx.pClientIsp, cGSessionCtx.pServerIsp);
            this.mSessionMonitor.reportRTCConnected();
        }
        internalUpdateStatusWithData(GmCgPlayStatus.StatusRTCConnected, str);
        if (this.mCurSessionStatus.is(GmCgSessionStatus.StatusSessionStartLaunchCloudGame)) {
            CGSessionLogI("onEventConnected return");
        } else {
            doDelayLoadingAfterConnected();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventConnecting(String str, String str2, boolean z16) {
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportRTCConnecting();
            this.mSessionMonitor.reportP2PConnecting();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventDataChannelConnected() {
        CGSessionLogI("onEventDataChannelConnected");
        this.mSessionMonitor.reportDataChannelConnected();
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bg
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventDataChannelConnected$21();
            }
        });
        subscribePrivilege();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventDataChannelDisconnected(String str) {
        CGLog.i("onEventDataChannelDisconnected sessionId  = " + str);
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.de
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventDataChannelDisconnected$22();
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventDisconnect() {
        CGSessionLogI("onEventDisconnect");
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bo
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventDisconnect$14();
            }
        });
        internalUpdateStatus(GmCgPlayStatus.StatusRTCDisconnected);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventFinishInput() {
        CGLog.i("onEventFinishInput ");
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bm
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventFinishInput$20();
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventFirstFrameRendered() {
        CGSessionLogI("onEventFirstFrameRendered, mCurPlayStatus: " + this.mCurPlayStatus + ", mCurSessionStatus: " + this.mCurSessionStatus);
        if (this.mSessionMonitor != null) {
            CGLog.i("session monitor report rtc first frame");
            this.mSessionMonitor.reportRTCFirstFrame();
            this.mSessionMonitor.reportFirstFrameRendered();
        }
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        if (this.mCurSessionStatus.is(GmCgSessionStatus.StatusSessionStartLaunchCloudGame)) {
            this.mCurSessionStatus = GmCgSessionStatus.StatusSessionWaitingLaunchCloudGame;
            CGSessionLogI("onEventFirstFrameRendered in waiting");
            return;
        }
        GmCgDelayCounter.getInstance().recordWebrtcLinkProcessEnd();
        internalUpdateStatus(GmCgPlayStatus.StatusFirstFramedRendered);
        internalUpdateStatus(GmCgPlayStatus.StatusInStreaming);
        sendAppMonitorReq(0);
        startCollectTouchEventCounts();
        GmCgDelayCounter.getInstance().reportStartUpDelay();
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventGalleryOpen() {
        CGSessionLogI("onEventGalleryOpen");
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cd
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventGalleryOpen$18();
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventGpsSwitched(final boolean z16) {
        CGSessionLogI("onEventGpsSwitched: " + z16);
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.di
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventGpsSwitched$26(z16);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventNetworkCarrier(String str, String str2) {
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            if (str == null) {
                str = "";
            }
            cGSessionCtx.pServerIsp = str;
            if (str2 == null) {
                str2 = "";
            }
            cGSessionCtx.pClientIsp = str2;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventNetworkCarrierMismatch(final String[] strArr, final String str, @Nullable final String str2) {
        if (this.mPlayStatusListener != null) {
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cq
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.this.lambda$onEventNetworkCarrierMismatch$28(strArr, str, str2);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventOfferCreated(String str) {
        this.mSessionCtx.pRequestId = SdpHelper.findIceUfrag(SdpHelper.MEDIA_TYPE_VIDEO, str, "");
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventPriviledgeNotification(String str) {
        CGLog.i("onEventPriviledgeNotification " + str);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventReportPerfValueDelivered(ReportPerfValue reportPerfValue) {
        if (reportPerfValue != null) {
            this.mSessionMonitor.reportRTCStats(reportPerfValue);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventSamplePerfValueDelivered(PerfValue perfValue) {
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        internalUpdatePerfInfo(perfValue);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventSessionConnClose(int i3) {
        GmCgError gmCgError;
        CGSessionLogI("onEventSessionConnClose: " + i3);
        internalUpdateStatusWithData(GmCgPlayStatus.StatusServerClosed, Integer.valueOf(i3));
        if (i3 == 1002) {
            return;
        }
        internalStopPlay();
        if (i3 != 1001) {
            if (i3 != 1016) {
                if (i3 != 1102) {
                    if (i3 != 2002) {
                        switch (i3) {
                            case 1003:
                                gmCgError = GmCgError.ErrorServiceSessionExpire;
                                break;
                            case 1004:
                                gmCgError = GmCgError.ErrorServiceNotUse;
                                break;
                            case 1005:
                                gmCgError = GmCgError.ErrorServiceTryTimeNoLeft;
                                break;
                            case 1006:
                                gmCgError = GmCgError.ErrorServiceOnLineTimeNoLeft;
                                break;
                            default:
                                switch (i3) {
                                    case 1010:
                                        gmCgError = GmCgError.ErrorSubAccountSessionExpire;
                                        break;
                                    case 1011:
                                        gmCgError = GmCgError.ErrorDomainAccountKickSubAccount;
                                        break;
                                    case 1012:
                                        gmCgError = GmCgError.ErrorServerClosedAfterSubAccountRelease;
                                        break;
                                    default:
                                        gmCgError = GmCgError.ErrorServerClosedByOtherReason;
                                        break;
                                }
                        }
                    } else {
                        gmCgError = GmCgError.ErrorServerClosedByPassiveRelease;
                    }
                } else {
                    gmCgError = GmCgError.ErrorKickByRepeatConnectToSameDevice;
                }
            } else {
                gmCgError = GmCgError.ErrorServiceNotUse;
            }
        } else {
            gmCgError = GmCgError.ErrorServiceBroken;
        }
        internalWhenErrorHappen(gmCgError);
        this.mServerConnCloseErrors.add(Integer.valueOf(gmCgError.getErrorCode()));
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventSessionError(int i3) {
        CGSessionLogI("onEventSessionError: " + i3);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventSessionIdReceived(String str) {
        CGLog.i("CGPlaySessionImpl onEventSessionIdReceived: " + str);
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            cGSessionCtx.pSessionId = str;
        }
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportSessionIdReceived();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventSessionInfo(final String str) {
        CGSessionLogI("onEventSessionInfo: " + str);
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.co
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventSessionInfo$27(str);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventSocketIoError(Object obj) {
        CGSessionLogI("onEventSocketIoError");
        internalWhenErrorHappen(GmCgError.ErrorLongConnNetworkFail);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventStart() {
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportRTCStart();
            this.mSessionMonitor.reportCallStart();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventStartInput() {
        CGLog.i("onEventStartInput ");
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dm
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventStartInput$19();
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventStutter(WebRTCEvents.ConnectionState connectionState) {
        CGSessionLogI("onEventStutter: " + connectionState.name());
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bx
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventStutter$25();
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventVoiceSwitched(final boolean z16) {
        CGSessionLogI("onEventVoiceSwitched: " + z16);
        if (this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped)) {
            return;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dd
            @Override // java.lang.Runnable
            public final void run() {
                CGPlaySessionImpl.this.lambda$onEventVoiceSwitched$17(z16);
            }
        });
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onGateReconnect() {
        logI("onGateReconnect");
        getLocalIpAndNetCarrier(this.mDeviceReadyToUse, null);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener
    public void onGmCgAllocatorError(@NonNull GmCgError gmCgError) {
        internalWhenErrorHappen(gmCgError);
        GmCgPlayAllocatorListener gmCgPlayAllocatorListener = this.mPlayAllocatorListener;
        if (gmCgPlayAllocatorListener != null) {
            gmCgPlayAllocatorListener.onGmCgAllocatorError(gmCgError);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener
    public void onGmCgAllocatorUpdate(int i3, boolean z16, GmCgAllocateDeviceInfo gmCgAllocateDeviceInfo) {
        GmCgPlayAllocatorListener gmCgPlayAllocatorListener = this.mPlayAllocatorListener;
        if (gmCgPlayAllocatorListener != null) {
            gmCgPlayAllocatorListener.onGmCgAllocatorUpdate(i3, z16, gmCgAllocateDeviceInfo);
        }
        if (i3 == 3) {
            checkDeviceIfValid2Play(gmCgAllocateDeviceInfo.mCgDeviceInfo);
        } else {
            internalUpdateStatus(GmCgPlayStatus.StatusQueueingDevice);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgDetectorError(@NonNull GmCgError gmCgError) {
        internalWhenErrorHappen(gmCgError);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgDetectorStart(boolean z16, float f16, float f17) {
        internalUpdateStatus(GmCgPlayStatus.StatusTestingDeviceSpeed);
    }

    protected void onImeInputEventHide() {
        CGSessionLogI("onImeInputEventHide");
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        WebRTCSDK webRTCSDK;
        if (4 == i3 && (webRTCSDK = this.mWebRTCSdk) != null) {
            return webRTCSDK.onKeyDown(4, keyEvent);
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        WebRTCSDK webRTCSDK;
        if (4 == i3 && (webRTCSDK = this.mWebRTCSdk) != null) {
            return webRTCSDK.onKeyUp(4, keyEvent);
        }
        return false;
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public /* synthetic */ void onLoginView(boolean z16) {
        com.tencent.gamematrix.gmcg.webrtc.gamepad.api.a.d(this, z16);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void onPageDestroy() {
        CGSessionLogI("onPageDestroy");
        webRtcOnDestroy();
        this.mPlaySessionViewHolder.destroy();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void onPagePause() {
        webRtcOnPause();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void onPageStart() {
        webRtcOnStart();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.CGDcEventHelper.DcEventRawSendAction
    public void onPlayDcEventAppStatus(String str) {
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportCloudAppStatus(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.CGDcEventHelper.DcEventRawSendAction
    public void onPlayDcEventTGPAScene(String str) {
        if (CGStringUtil.notEmpty(str)) {
            this.mSessionCtx.pSceneId = str;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onVirtualGamepadMsgData(int i3, int i16, int i17, int i18) {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onWebrtcStartUpProcess(String str, boolean z16) {
        GmCgDelayCounter.getInstance().recordSubProcess(str, z16);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void pausePlay() {
        CGSessionLogI(QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY);
        Runnable runnable = this.mPausingTask;
        if (runnable != null) {
            runOnMainThreadAfterDelay(runnable, 1500L);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGSessionMonitor.ReportInfoProvider
    public CGSessionMonitor.StatusReportInfo provideSessionMonitorReportInfo() {
        String str;
        String str2;
        CGSessionMonitor.StatusReportInfo statusReportInfo = new CGSessionMonitor.StatusReportInfo();
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            str = cGSessionCtx.pSessionId;
        } else {
            str = "";
        }
        statusReportInfo.sessionId = str;
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null) {
            str2 = gmCgDeviceInfo.getWebrtcUrl();
        } else {
            str2 = "unknown";
        }
        statusReportInfo.gate = str2;
        statusReportInfo.f107702ip = this.mCandidateIp;
        statusReportInfo.carrier = this.mRemoteNetCarrier;
        statusReportInfo.supportFree = this.mSupportNetFreeFlow;
        statusReportInfo.realFree = this.mRealNetFreeFlow;
        statusReportInfo.restart = this.mRestarted;
        return statusReportInfo;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public List<GmCgGameStreamQualityCfg> regenerateAdaptivePlayStreamQuality(boolean z16) {
        List<GmCgGameStreamQualityCfg> regenerateAdaptivePlayStreamQuality = getStreamQualityAdjuster().regenerateAdaptivePlayStreamQuality(z16);
        GmCgPlayStatus gmCgPlayStatus = this.mCurPlayStatus;
        if (gmCgPlayStatus != null && gmCgPlayStatus.isWebRtcConnected()) {
            getStreamQualityAdjuster().adjustAdaptivePlayStreamQuality();
        }
        return regenerateAdaptivePlayStreamQuality;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void releasePlay() {
        CGSessionLogI("releasePlay");
        GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder = this.mPlaySessionViewHolder;
        if (gmCgPlaySessionViewHolder != null) {
            gmCgPlaySessionViewHolder.releaseLastFrameScreenshot();
        }
        if (GmCgSdk.isQtvBizChannel()) {
            CGNonAgeProtectModule.getInstance().stopHeartBeat();
        }
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportCallRelease();
        }
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null && gmCgDeviceInfo.isValid()) {
            if (this.mBizHttpService != null) {
                if (this.mDeviceReadyToUse.isCreatedByOther()) {
                    this.mBizHttpService.requestFreeDeviceForSubAccount(CGGlbConfig.getUserId(), this.mDeviceReadyToUse.getDeviceID(), new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cs
                        @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                        public final void onResult(GmCgError gmCgError, Object obj) {
                            CGPlaySessionImpl.this.lambda$releasePlay$8(gmCgError, (CGCommonResp) obj);
                        }
                    });
                    return;
                } else {
                    this.mBizHttpService.requestFreeMyDevice(this.mDeviceReadyToUse.getDeviceID(), false, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.ct
                        @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                        public final void onResult(GmCgError gmCgError, Object obj) {
                            CGPlaySessionImpl.this.lambda$releasePlay$9(gmCgError, (CGCommonResp) obj);
                        }
                    });
                    return;
                }
            }
            webRtcKickOff();
            internalWhenErrorHappen(GmCgError.ErrorServerClosedAfterUserRelease);
            return;
        }
        cancelQueue();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void removePlayStatusListener() {
        this.mPlayStatusListener = null;
        GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder = this.mPlaySessionViewHolder;
        if (gmCgPlaySessionViewHolder != null) {
            gmCgPlaySessionViewHolder.removePlayStatusListener();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void reportCustomEvent(String str, Object obj) {
        this.mSessionMonitor.reportCustomStatus(str);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void restartPlay() {
        restartPlay(false);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void restartPlayWithResolutionChange() {
        GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder;
        int i3;
        int i16;
        if (this.mWebRTCSdk != null && (gmCgPlaySessionViewHolder = this.mPlaySessionViewHolder) != null && this.mSessionCfg != null && this.mDeviceReadyToUse != null) {
            int playRenderWidth = gmCgPlaySessionViewHolder.getPlayRenderWidth();
            int playRenderHeight = this.mPlaySessionViewHolder.getPlayRenderHeight();
            GmCgGameStreamQualityCfg curStreamQualityCfg = getStreamQualityAdjuster().getCurStreamQualityCfg();
            if (curStreamQualityCfg != null) {
                int i17 = curStreamQualityCfg.pResWidth;
                i16 = curStreamQualityCfg.pResHeight;
                i3 = i17;
            } else {
                i3 = 0;
                i16 = 0;
            }
            this.mSessionCfg.pViewWidth = calculateViewWidth(Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
            this.mSessionCfg.pViewHeight = calculateViewHeight(Math.max(playRenderWidth, playRenderHeight), Math.min(playRenderWidth, playRenderHeight), this.mDeviceReadyToUse);
            CGSessionLogI("GmCgPlayView restartPlayWithResolutionChange width: " + this.mSessionCfg.pViewWidth + ", height = " + this.mSessionCfg.pViewHeight);
            CGBizHttpService cGBizHttpService = this.mBizHttpService;
            String deviceID = this.mDeviceReadyToUse.getDeviceID();
            GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
            cGBizHttpService.setCloudGameResolution(deviceID, gmCgSessionCfg.pViewWidth, gmCgSessionCfg.pViewHeight, i3, i16, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.df
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.this.lambda$restartPlayWithResolutionChange$7(gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public GmCgGameStreamQualityCfg restorePlayStreamQuality() {
        int curStreamQualityCfgId;
        CGStreamQualityAdjuster streamQualityAdjuster = getStreamQualityAdjuster();
        if (streamQualityAdjuster == null || (curStreamQualityCfgId = streamQualityAdjuster.getCurStreamQualityCfgId()) < 0) {
            return null;
        }
        return streamQualityAdjuster.setPlayVideoStreamQuality(curStreamQualityCfgId);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void resumePlay() {
        CGSessionLogI("resumePlay");
        checkQualificationToPlay();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void screenShot(@Nullable final GmCgSdkScreenShotListener gmCgSdkScreenShotListener, @Nullable Integer num) {
        final boolean[] zArr = {false};
        CGHandlerTimer.TimerTask[] timerTaskArr = new CGHandlerTimer.TimerTask[1];
        CGHandlerTimer cGHandlerTimer = new CGHandlerTimer();
        if (gmCgSdkScreenShotListener != null && num != null) {
            timerTaskArr[0] = cGHandlerTimer.schedule(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cy
                @Override // java.lang.Runnable
                public final void run() {
                    CGPlaySessionImpl.lambda$screenShot$11(GmCgSdkScreenShotListener.this, zArr);
                }
            }, num.intValue(), TimeUnit.MILLISECONDS);
        }
        GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder = this.mPlaySessionViewHolder;
        if (gmCgPlaySessionViewHolder != null) {
            gmCgPlaySessionViewHolder.screenShotPlaySessionView(new AnonymousClass8(timerTaskArr, zArr, cGHandlerTimer, gmCgSdkScreenShotListener));
        } else if (gmCgSdkScreenShotListener != null) {
            runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.dj
                @Override // java.lang.Runnable
                public final void run() {
                    GmCgSdkScreenShotListener.this.onScreenShotResult(null);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void screenShotPlaySessionView(GmCgSdkScreenShotListener gmCgSdkScreenShotListener) {
        screenShot(gmCgSdkScreenShotListener, null);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendAppMonitorReq(int i3) {
        getDcEventHelper().sendAppMonitorReq(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendCommonNotifyToRemoteClient(int i3, String str) {
        WebRTCSDK webRTCSDK;
        if (!this.mCurPlayStatus.is(GmCgPlayStatus.StatusStopped) && (webRTCSDK = this.mWebRTCSdk) != null) {
            webRTCSDK.sendChannelDataToRemoteClient(i3, str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendCopiedText(String str) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.sendCopiedText(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendDcEventRequest(GmCgDcEventRequest gmCgDcEventRequest) {
        getDcEventHelper().sendDcEventRequest(gmCgDcEventRequest);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendDcEventRequestThroughHttp(GmCgDcEventRequest gmCgDcEventRequest, final GmCgApiService.ActionResultListener actionResultListener) {
        GmCgDeviceInfo gmCgDeviceInfo = this.mDeviceReadyToUse;
        if (gmCgDeviceInfo != null && gmCgDeviceInfo.isValid()) {
            if (this.mBizHttpService != null && gmCgDcEventRequest != null && CGStringUtil.notEmpty(gmCgDcEventRequest.provideDcEventCmd())) {
                this.mBizHttpService.requestSendDataChannel(this.mDeviceReadyToUse.getDeviceID(), gmCgDcEventRequest.generateDcEventDataToSend(), new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bp
                    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                    public final void onResult(GmCgError gmCgError, Object obj) {
                        CGPlaySessionImpl.lambda$sendDcEventRequestThroughHttp$13(GmCgApiService.ActionResultListener.this, gmCgError, (CGCommonResp) obj);
                    }
                });
                return;
            } else {
                if (actionResultListener != null) {
                    actionResultListener.onActionResult(GmCgError.ErrorOther);
                    return;
                }
                return;
            }
        }
        if (actionResultListener != null) {
            actionResultListener.onActionResult(GmCgError.ErrorServiceSessionExpire);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendEnterGameRoomReq(String str, String str2, String str3) {
        getDcEventHelper().sendEnterRoomReq(str, str2, str3);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendGameLoginState(int i3) {
        getDcEventHelper().sendGameLoginStaterReq(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendImage(String str) {
        CGSessionLogI("sendImage: " + str);
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.sendPhoto(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendKingsHonorMidGameBeginReq(CGKingsHonorMidGameConfig cGKingsHonorMidGameConfig) {
        getDcEventHelper().sendKingsHonorMidGameBeginReq(cGKingsHonorMidGameConfig);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendObtainMidasConfigReq() {
        getDcEventHelper().sendObtainMidasConfigReq();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.CGDcEventHelper.DcEventRawSendAction
    public void sendPlayDcEventRawAck(String str) {
        CGSessionLogI("sendPlayChannelRawAck: " + str);
        if (this.mWebRTCSdk != null && CGStringUtil.notEmpty(str)) {
            this.mWebRTCSdk.sendChannelAck(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.event.CGDcEventHelper.DcEventRawSendAction
    public void sendPlayDcEventRawData(String str) {
        CGSessionLogI("sendPlayChannelRawData: " + str);
        if (this.mWebRTCSdk != null && CGStringUtil.notEmpty(str)) {
            this.mWebRTCSdk.sendChannelData(str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendRefreshGameReq() {
        getDcEventHelper().sendRefreshGameReq();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendRestartGameReq() {
        getDcEventHelper().sendRestartGameReq();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendSceneCheckReq(String str) {
        getDcEventHelper().sendSceneCheckReq(str);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendSwitchInfoLayerReq() {
        getDcEventHelper().sendSwitchInfoLayerReq();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void sendUserFeedback(boolean z16) {
        GmCgDeviceInfo gmCgDeviceInfo;
        CGSessionLogI("start user feedback need log: " + z16);
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        if (cGBizHttpService != null && (gmCgDeviceInfo = this.mDeviceReadyToUse) != null) {
            cGBizHttpService.collectLog(gmCgDeviceInfo.getDeviceID(), z16, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bw
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.lambda$sendUserFeedback$2(gmCgError, (CGCommonResp) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setAuthRefreshListener(GmCgAuthRefreshListener gmCgAuthRefreshListener) {
        this.mAuthRefreshListener = gmCgAuthRefreshListener;
        CGQualificationChecker cGQualificationChecker = this.mQualificationChecker;
        if (cGQualificationChecker != null) {
            cGQualificationChecker.setAuthRefreshListener(gmCgAuthRefreshListener);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setCloudGameLoginParam(int i3, String str) {
        this.mInGameLoginYybParam = "";
        this.mInGameLoginChannelType = i3;
        this.mInGameLoginDefaultParam = str;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setCloudGameLoginParamV1(int i3, GmCgGameLoginInfo gmCgGameLoginInfo) {
        this.mInGameLoginYybParam = "";
        this.mInGameLoginDefaultParam = "";
        this.mInGameLoginChannelType = i3;
        this.mGameAutoLoginInfo = gmCgGameLoginInfo;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setCloudGameLoginParamV2(int i3, String str) {
        GmCgGameLoginConfigInfo gmCgGameLoginConfigInfo;
        GmCgGameConfigInfo gmCgGameConfigInfo = this.mGameConfigInfo;
        if (gmCgGameConfigInfo != null && (gmCgGameLoginConfigInfo = gmCgGameConfigInfo.pGameLoginConfigInfo) != null) {
            if (gmCgGameLoginConfigInfo.mSdkType == 3) {
                if (gmCgGameLoginConfigInfo.mLoginType == 92) {
                    StringBuilder sb5 = new StringBuilder("tencentysdk");
                    sb5.append(this.mGameConfigInfo.pPackageName);
                    sb5.append("://?loginInfo=");
                    HashMap hashMap = new HashMap();
                    int i16 = 1;
                    hashMap.put("isAutoLogin", 1);
                    hashMap.put("loginMode", 6);
                    if (1 != i3) {
                        i16 = 0;
                    }
                    hashMap.put("loginChannel", Integer.valueOf(i16));
                    hashMap.put("cloudProxyCode", str);
                    sb5.append(CGJsonUtil.toJson(hashMap));
                    setInGameLoginYybParam(Base64.encodeToString(sb5.toString().getBytes(), 2));
                    return;
                }
                return;
            }
            setCloudGameLoginParam(i3, str);
            return;
        }
        CGLog.w("don't know game login config");
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setImeInputController(Activity activity, GmCgImeInputController gmCgImeInputController) {
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        if (gmCgSessionCfg != null && gmCgSessionCfg.pUseCustomInputView) {
            realSetInputController(activity, gmCgImeInputController);
        } else {
            CGLog.i("pUseCustomInputView is false!!!");
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setInGameLoginYybParam(String str) {
        this.mInGameLoginDefaultParam = "";
        this.mInGameLoginYybParam = str;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayAllocatorListener(GmCgPlayAllocatorListener gmCgPlayAllocatorListener) {
        this.mPlayAllocatorListener = gmCgPlayAllocatorListener;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayContainer(FrameLayout frameLayout, int i3, boolean z16) {
        this.mPlaySessionViewHolder.setPlayContainer(frameLayout);
        changeOrientationOnFly(i3);
        CGLog.i(CGStringUtil.format("setPlayContainer(%s, %d, %b), play view: %s, game screen: %d", frameLayout, Integer.valueOf(i3), Boolean.valueOf(z16), this.mPlaySessionViewHolder.getPlayRenderView(), Integer.valueOf(i3)));
        Context context = frameLayout.getContext();
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
            enableImeInputController(true);
        } else if (context instanceof Application) {
            this.mContext = context;
            closeImeInputController();
        } else {
            throw new IllegalArgumentException("the context of play container must be activity or application");
        }
        this.mForPreview = z16;
        if (this.mWebRTCSdk != null && this.mPlaySessionViewHolder.getPlaySurfaceView() != null) {
            this.mWebRTCSdk.setSurfaceView(this.mPlaySessionViewHolder.getPlaySurfaceView());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayDcEventListener(GmCgPlayDcEventListener gmCgPlayDcEventListener) {
        this.mPlayDcEventListener = gmCgPlayDcEventListener;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayPerfListener(GmCgPlayPerfListener gmCgPlayPerfListener) {
        this.mPlayPerfListener = gmCgPlayPerfListener;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayPushEventListener(GmCgPlayPushEventListener gmCgPlayPushEventListener) {
        this.mPlayPushEventListener = gmCgPlayPushEventListener;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlaySceneInfo(String str) {
        CGSessionCtx cGSessionCtx = this.mSessionCtx;
        if (cGSessionCtx != null) {
            cGSessionCtx.pSceneInfo = str;
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayStatusListener(GmCgPlayStatusListener gmCgPlayStatusListener) {
        this.mPlayStatusListener = gmCgPlayStatusListener;
        this.mPlaySessionViewHolder.setPlayStatusListener(gmCgPlayStatusListener);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public GmCgGameStreamQualityCfg setPlayStreamQuality(int i3) {
        GmCgGameStreamQualityCfg playVideoStreamQuality = getStreamQualityAdjuster().setPlayVideoStreamQuality(i3);
        this.mPlaySessionViewHolder.onGameStreamQualityChanged(playVideoStreamQuality);
        this.mSessionCtx.pResolutionType = playVideoStreamQuality.pName;
        return playVideoStreamQuality;
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayVideoBitrate(int i3) {
        CGSessionLogI("setPlayVideoBitrate: " + i3);
        this.mSessionMonitor.reportCallSwitchBitrate(300, i3);
        getStreamQualityAdjuster().setPlayVideoBitrateMax(i3);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPlayVideoBitrateRange(int i3, int i16) {
        CGSessionLogI("setPlayVideoBitrateRange minBit: " + i3 + "maxBit: " + i16);
        this.mSessionMonitor.reportCallSwitchBitrate(i3, i16);
        getStreamQualityAdjuster().setPlayVideoBitrate(i3, i16);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setPreview(boolean z16) {
        this.mForPreview = z16;
        if (z16) {
            sendDcEventRequest(CGDEventCloudAppWindowStatusRequest.OpenWindowStatusRequest());
            CGLog.i("setPreview \u5f00\u542f\u5c0f\u7a97");
        } else {
            sendDcEventRequest(CGDEventCloudAppWindowStatusRequest.CloseWindowStatusRequest());
            CGLog.i("setPreview \u5173\u95ed\u5c0f\u7a97");
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void setRemoteAudioVolume(double d16) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.setAudioVolume(d16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.impl.CGStreamQualityAdjuster.StreamQualityAction
    public void setVideoBitrateToEndian(int i3, int i16) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.setVideoBitrate(i3, i16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void showPlayExtraInfoOverlay(boolean z16) {
        this.mPlaySessionViewHolder.showExtraOverlay(z16);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void startCloudGameFaceRecognition(final Activity activity, String str, String str2, String str3) {
        if (activity != null && CGStringUtil.notEmpty(str3) && this.mBizHttpService != null) {
            String str4 = str3 + "&jumpAppid=" + str + "&pkgname=" + str2;
            CGSessionLogI("faceRecognitionUrl: " + str4);
            this.mBizHttpService.requestFaceRecognitionOpenLink(str4, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cu
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public final void onResult(GmCgError gmCgError, Object obj) {
                    CGPlaySessionImpl.this.lambda$startCloudGameFaceRecognition$1(activity, gmCgError, (CGFaceRecognitionResult) obj);
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void startPlay() {
        CGSessionLogI("startPlay preview:" + this.mForPreview);
        this.mRestarted = false;
        this.mCurSessionStatus = GmCgSessionStatus.StatusSessionStart;
        internalUpdateStatus(GmCgPlayStatus.StatusStart);
        this.mHasLoadArchiveProcess = false;
        checkQualificationToPlay();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void stopPlay() {
        CGSessionLogI(QZoneJsConstants.METHOD_RECORDER_STOP_PLAY);
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportCallStop();
            this.mSessionMonitor.reportCallDisconnect();
        }
        internalStopPlay();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void stopWebRtc() {
        CGSessionLogI("webRtcStop");
        if (this.mWebRTCSdk != null) {
            CGSessionLogI("webRtcStop doing");
            this.mWebRTCSdk.setAudioVolume(0.0d);
            this.mWebRTCSdk.stop();
            updateWebRTCSDK(this.mWebRTCSdk);
        }
        resetShutterLatencyState();
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void switchOnAudio(boolean z16) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.switchOnAudio(z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void switchOnGps(boolean z16) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.switchOnGps(z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void switchOnVoice(boolean z16) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.switchOnVoice(z16);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void switchToPreferredMode(int i3) {
        WebRTCSDK webRTCSDK = this.mWebRTCSdk;
        if (webRTCSDK != null) {
            webRTCSDK.switchToPreferredMode(i3);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public boolean updateStreamQualityCfgsToVGamepad(int i3, List<IGamepadController.StreamQualityCfg> list) {
        return false;
    }

    private void doRestartPlay(String str, final boolean z16) {
        CGSessionLogI("doRestartPlay from " + str);
        this.mRestarted = true;
        internalUpdateStatusWithData(GmCgPlayStatus.StatusRestart, this.mDeviceReadyToUse);
        this.mHasLoadArchiveProcess = false;
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportCallRestart();
        }
        if (isEnsuredDeviceValid()) {
            if (this.mWebRTCSdk != null) {
                runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cl
                    @Override // java.lang.Runnable
                    public final void run() {
                        CGPlaySessionImpl.this.lambda$doRestartPlay$49();
                    }
                });
                return;
            } else {
                runOnMainThread(new Runnable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.cm
                    @Override // java.lang.Runnable
                    public final void run() {
                        CGPlaySessionImpl.this.lambda$doRestartPlay$50(z16);
                    }
                });
                return;
            }
        }
        internalWhenErrorHappen(GmCgError.ErrorServiceSessionExpire);
    }

    private void requestInGameLoginDefault(int i3, String str, boolean z16, @Nullable String str2, @Nullable final CGBizHttpService.ResultListener<CGCommonResp> resultListener) {
        CGSessionLogI("requestInGameLoginDefault");
        if (z16) {
            internalUpdateStatus(GmCgPlayStatus.StatusLoginLaunchingDevice);
        }
        CGBizHttpService cGBizHttpService = this.mBizHttpService;
        String deviceID = this.mDeviceReadyToUse.getDeviceID();
        String str3 = this.mCgGameId;
        GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
        cGBizHttpService.requestCloudGameLogin(deviceID, str3, i3, str, str2, gmCgSessionCfg != null ? gmCgSessionCfg.pGameLoginPayLoad : "", null, new CGBizHttpService.ResultListener<CGCommonResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.10
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public void onResult(@NonNull GmCgError gmCgError, CGCommonResp cGCommonResp) {
                CGBizHttpService.ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onResult(gmCgError, cGCommonResp);
                }
            }
        });
    }

    private void requestInGameLoginYyb(String str, boolean z16, final CGBizHttpService.ResultListener<Void> resultListener) {
        CGSessionLogI("requestInGameLoginYyb");
        if (z16) {
            internalUpdateStatus(GmCgPlayStatus.StatusLoginLaunchingDevice);
        }
        CGYybCloudGameLoginReqBody cGYybCloudGameLoginReqBody = new CGYybCloudGameLoginReqBody();
        cGYybCloudGameLoginReqBody.login_type = 4;
        cGYybCloudGameLoginReqBody.deviceid = this.mDeviceReadyToUse.getDeviceID();
        cGYybCloudGameLoginReqBody.param1 = str;
        this.mBizHttpService.requestYybCloudGameLogin(cGYybCloudGameLoginReqBody, new CGBizHttpService.ResultListener<Void>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.11
            @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
            public void onResult(@NonNull GmCgError gmCgError, Void r36) {
                CGBizHttpService.ResultListener resultListener2 = resultListener;
                if (resultListener2 != null) {
                    resultListener2.onResult(gmCgError, r36);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void webRtcPlay(GmCgDeviceInfo gmCgDeviceInfo, boolean z16) {
        boolean shouldUseHwDecode;
        int i3;
        int i16;
        int i17;
        GmCgSessionCfg gmCgSessionCfg;
        GmCgSessionCfg gmCgSessionCfg2;
        Logging.Severity severity;
        int i18;
        GmCgGameConfigInfo gmCgGameConfigInfo;
        AudioManager audioManager;
        GmCgGameCodecConfig gmCgGameCodecConfig;
        CGSessionLogI("webRtcPlay");
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportStartWebRTCPlay();
        }
        if (this.mSessionCfg.pRtcHwDecode != null) {
            CGLog.i("SessionCfg.pRtcHwDecode = " + this.mSessionCfg.pRtcHwDecode);
            if (!this.mSessionCfg.pRtcHwDecode.booleanValue()) {
                CGLog.w("\u7981\u6b62Session\u8bbe\u7f6e\u8f6f\u89e3");
            }
            shouldUseHwDecode = true;
        } else {
            shouldUseHwDecode = shouldUseHwDecode();
        }
        boolean shouldUseH265 = shouldUseH265();
        GmCgGameConfigInfo gmCgGameConfigInfo2 = this.mGameConfigInfo;
        if (gmCgGameConfigInfo2 != null && (gmCgGameCodecConfig = gmCgGameConfigInfo2.pGameCodecConfig) != null && gmCgGameCodecConfig.pEnabled) {
            shouldUseH265 = gmCgGameCodecConfig.shouldUseH265();
        }
        internalUpdateStatus(GmCgPlayStatus.StatusRTCConnecting);
        if (this.mWebRTCSdk != null) {
            CGSessionLogI("webRtcPlay not null ");
            this.mWebRTCSdk.setAudioVolume(0.0d);
            this.mWebRTCSdk.stop();
            this.mWebRTCSdk.onDestroy();
            updateWebRTCSDK(this.mWebRTCSdk);
            this.mWebRTCSdk = null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CGPlaySessionImpl.webRtcPlay: Sdp mWebRTCParameters == null ? ");
        sb5.append(this.mWebRTCParameters == null);
        CGLog.i(sb5.toString());
        if (this.mWebRTCParameters == null) {
            this.mWebRTCParameters = new WebRTCParameters();
            int i19 = 10;
            try {
                audioManager = (AudioManager) this.mContext.getSystemService("audio");
            } catch (Exception e16) {
                CGLog.e(e16.getMessage());
            }
            if (audioManager != null) {
                i19 = audioManager.getStreamMaxVolume(3);
                i3 = SystemMethodProxy.getStreamVolume(audioManager, 3);
                CGSessionLogI("use h265:" + shouldUseH265 + " use hardware decode: " + shouldUseHwDecode);
                CGSessionCtx cGSessionCtx = this.mSessionCtx;
                cGSessionCtx.pCodecType = !shouldUseH265 ? VideoCodecType.H265 : VideoCodecType.H264;
                cGSessionCtx.pHardwareDecode = shouldUseHwDecode;
                this.mWebRTCParameters.setHwDecode(shouldUseHwDecode);
                this.mWebRTCParameters.setPreferH265(shouldUseH265);
                WebRTCParameters webRTCParameters = this.mWebRTCParameters;
                i16 = this.mSessionCfg.pRtcCurrAudioVolume;
                if (i16 >= 0) {
                    i3 = i16;
                }
                webRTCParameters.setCurrAudioVolume(i3);
                WebRTCParameters webRTCParameters2 = this.mWebRTCParameters;
                i17 = this.mSessionCfg.pRtcMaxAudioVolume;
                if (i17 >= 0) {
                    i19 = i17;
                }
                webRTCParameters2.setMaxAudioVolume(i19);
                this.mWebRTCParameters.setDumpReceivedBitstream(this.mSessionCfg.pEnableRtcDump);
                gmCgSessionCfg = this.mSessionCfg;
                if (gmCgSessionCfg.pEnableRtcDump) {
                    WebRTCParameters webRTCParameters3 = this.mWebRTCParameters;
                    int i26 = gmCgSessionCfg.pRtcDumpSize;
                    if (i26 <= 0) {
                        i26 = 536870912;
                    }
                    webRTCParameters3.setDumpSize(i26);
                    String str = Environment.getExternalStorageDirectory().toString() + "/Movies/";
                    WebRTCParameters webRTCParameters4 = this.mWebRTCParameters;
                    if (!TextUtils.isEmpty(this.mSessionCfg.pRtcDumpPath)) {
                        str = this.mSessionCfg.pRtcDumpPath;
                    }
                    webRTCParameters4.setDumpPath(str);
                }
                this.mWebRTCParameters.enableRtcEventLogOutput(this.mSessionCfg.pEnableLocalRtcEventLog);
                WebRTCParameters.setEnableLogToDebugOutput(this.mSessionCfg.pEnableRtcLog);
                WebRTCParameters webRTCParameters5 = this.mWebRTCParameters;
                gmCgSessionCfg2 = this.mSessionCfg;
                if (gmCgSessionCfg2.pEnableRtcLog) {
                    severity = Logging.Severity.LS_NONE;
                } else {
                    i18 = gmCgSessionCfg2.pRtcLoggingSeverity;
                    if (i18 < 0) {
                        severity = Logging.Severity.LS_VERBOSE;
                    }
                    webRTCParameters5.setLoggingSeverity(i18);
                    if (this.mSessionCfg.pRtcLogger != null) {
                        this.mWebRTCParameters.setCustomLogger(new Loggable() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bk
                            @Override // org.tencwebrtc.Loggable
                            public final void onLogMessage(String str2, Logging.Severity severity2, String str3) {
                                CGPlaySessionImpl.this.lambda$webRtcPlay$52(str2, severity2, str3);
                            }
                        });
                    }
                    this.mWebRTCParameters.setAudioSource(this.mSessionCfg.pWebRTCAudioSource);
                    getStreamQualityAdjuster().setDefaultMaxBitrateKbps(this.mSessionCfg.pMaxDefaultBitRate);
                    getStreamQualityAdjuster().setDefaultMinBitrateKbps(this.mSessionCfg.pMinDefaultBitRate);
                    CGLog.i("CGPlaySessionImpl/webRtcPlay: Sdp here set default value max = " + this.mSessionCfg.pMaxDefaultBitRate + ", min = " + this.mSessionCfg.pMinDefaultBitRate);
                    this.mWebRTCParameters.setMinBitRate(getStreamQualityAdjuster().getMinBandwidthForSdp());
                    this.mWebRTCParameters.setMaxBitRate(getStreamQualityAdjuster().getMaxBandwidthForSdp());
                    this.mWebRTCParameters.setStartBitRate(getStreamQualityAdjuster().getMinBandwidthForSdp());
                    gmCgGameConfigInfo = this.mGameConfigInfo;
                    if (gmCgGameConfigInfo != null && this.mSessionCfg.pEnableImgQualityPerferred) {
                        this.mWebRTCParameters.setImgQualityPreferred(gmCgGameConfigInfo.pImgQualityFirst);
                    }
                }
                i18 = severity.ordinal();
                webRTCParameters5.setLoggingSeverity(i18);
                if (this.mSessionCfg.pRtcLogger != null) {
                }
                this.mWebRTCParameters.setAudioSource(this.mSessionCfg.pWebRTCAudioSource);
                getStreamQualityAdjuster().setDefaultMaxBitrateKbps(this.mSessionCfg.pMaxDefaultBitRate);
                getStreamQualityAdjuster().setDefaultMinBitrateKbps(this.mSessionCfg.pMinDefaultBitRate);
                CGLog.i("CGPlaySessionImpl/webRtcPlay: Sdp here set default value max = " + this.mSessionCfg.pMaxDefaultBitRate + ", min = " + this.mSessionCfg.pMinDefaultBitRate);
                this.mWebRTCParameters.setMinBitRate(getStreamQualityAdjuster().getMinBandwidthForSdp());
                this.mWebRTCParameters.setMaxBitRate(getStreamQualityAdjuster().getMaxBandwidthForSdp());
                this.mWebRTCParameters.setStartBitRate(getStreamQualityAdjuster().getMinBandwidthForSdp());
                gmCgGameConfigInfo = this.mGameConfigInfo;
                if (gmCgGameConfigInfo != null) {
                    this.mWebRTCParameters.setImgQualityPreferred(gmCgGameConfigInfo.pImgQualityFirst);
                }
            }
            i3 = 0;
            CGSessionLogI("use h265:" + shouldUseH265 + " use hardware decode: " + shouldUseHwDecode);
            CGSessionCtx cGSessionCtx2 = this.mSessionCtx;
            cGSessionCtx2.pCodecType = !shouldUseH265 ? VideoCodecType.H265 : VideoCodecType.H264;
            cGSessionCtx2.pHardwareDecode = shouldUseHwDecode;
            this.mWebRTCParameters.setHwDecode(shouldUseHwDecode);
            this.mWebRTCParameters.setPreferH265(shouldUseH265);
            WebRTCParameters webRTCParameters6 = this.mWebRTCParameters;
            i16 = this.mSessionCfg.pRtcCurrAudioVolume;
            if (i16 >= 0) {
            }
            webRTCParameters6.setCurrAudioVolume(i3);
            WebRTCParameters webRTCParameters22 = this.mWebRTCParameters;
            i17 = this.mSessionCfg.pRtcMaxAudioVolume;
            if (i17 >= 0) {
            }
            webRTCParameters22.setMaxAudioVolume(i19);
            this.mWebRTCParameters.setDumpReceivedBitstream(this.mSessionCfg.pEnableRtcDump);
            gmCgSessionCfg = this.mSessionCfg;
            if (gmCgSessionCfg.pEnableRtcDump) {
            }
            this.mWebRTCParameters.enableRtcEventLogOutput(this.mSessionCfg.pEnableLocalRtcEventLog);
            WebRTCParameters.setEnableLogToDebugOutput(this.mSessionCfg.pEnableRtcLog);
            WebRTCParameters webRTCParameters52 = this.mWebRTCParameters;
            gmCgSessionCfg2 = this.mSessionCfg;
            if (gmCgSessionCfg2.pEnableRtcLog) {
            }
            i18 = severity.ordinal();
            webRTCParameters52.setLoggingSeverity(i18);
            if (this.mSessionCfg.pRtcLogger != null) {
            }
            this.mWebRTCParameters.setAudioSource(this.mSessionCfg.pWebRTCAudioSource);
            getStreamQualityAdjuster().setDefaultMaxBitrateKbps(this.mSessionCfg.pMaxDefaultBitRate);
            getStreamQualityAdjuster().setDefaultMinBitrateKbps(this.mSessionCfg.pMinDefaultBitRate);
            CGLog.i("CGPlaySessionImpl/webRtcPlay: Sdp here set default value max = " + this.mSessionCfg.pMaxDefaultBitRate + ", min = " + this.mSessionCfg.pMinDefaultBitRate);
            this.mWebRTCParameters.setMinBitRate(getStreamQualityAdjuster().getMinBandwidthForSdp());
            this.mWebRTCParameters.setMaxBitRate(getStreamQualityAdjuster().getMaxBandwidthForSdp());
            this.mWebRTCParameters.setStartBitRate(getStreamQualityAdjuster().getMinBandwidthForSdp());
            gmCgGameConfigInfo = this.mGameConfigInfo;
            if (gmCgGameConfigInfo != null) {
            }
        }
        int i27 = this.mSessionCfg.pWebrtcConnectionTime;
        if (i27 > 0) {
            this.mWebRTCParameters.setConnectionTimeOut(i27);
        }
        if (getWebRtcSignalServer(gmCgDeviceInfo).contains("&IP=")) {
            this.mWebRTCParameters.setConnectionTimeOut(30);
        }
        GmCgGameConfigInfo gmCgGameConfigInfo3 = this.mGameConfigInfo;
        if (gmCgGameConfigInfo3 != null) {
            this.mWebRTCParameters.setImgQualityPreferred(gmCgGameConfigInfo3.pImgQualityFirst);
        }
        DeviceConfig deviceConfig = new DeviceConfig();
        deviceConfig.setDeviceId(gmCgDeviceInfo.getDeviceID());
        deviceConfig.setControlKey(gmCgDeviceInfo.getControlkey());
        deviceConfig.setIdentity(gmCgDeviceInfo.getIdentity());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("CGPlaySessionImpl.webRtcPlay: instIp = ");
        sb6.append(gmCgDeviceInfo.getSignalServer() != null && gmCgDeviceInfo.getSignalServer().valid);
        CGLog.i(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("CGPlaySessionImpl.webRtcPlay: insthost = ");
        sb7.append(gmCgDeviceInfo.getSignalServer() != null ? gmCgDeviceInfo.getSignalServer().host : "");
        CGLog.i(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("CGPlaySessionImpl.webRtcPlay: instaddr = ");
        sb8.append(gmCgDeviceInfo.getSignalServer() != null ? gmCgDeviceInfo.getSignalServer().address : "");
        CGLog.i(sb8.toString());
        deviceConfig.setUseInstIp(gmCgDeviceInfo.getSignalServer() != null && gmCgDeviceInfo.getSignalServer().valid);
        deviceConfig.setInstHost(gmCgDeviceInfo.getSignalServer() != null ? gmCgDeviceInfo.getSignalServer().host : "");
        deviceConfig.setInstAddress(gmCgDeviceInfo.getSignalServer() != null ? gmCgDeviceInfo.getSignalServer().address : "");
        deviceConfig.setSignalServer(getWebRtcSignalServer(gmCgDeviceInfo));
        deviceConfig.resolutionWidth = gmCgDeviceInfo.getWidth();
        deviceConfig.resolutionHeight = gmCgDeviceInfo.getHeight();
        deviceConfig.fps = gmCgDeviceInfo.getDeviceFps();
        deviceConfig.cluster = gmCgDeviceInfo.getCluster();
        deviceConfig.area = gmCgDeviceInfo.getDeviceArea();
        GmCgDelayCounter.getInstance().setCluster(gmCgDeviceInfo.getCluster());
        GmCgDelayCounter.getInstance().setDeviceId(gmCgDeviceInfo.getDeviceID());
        GmCgDelayCounter.getInstance().setWebsocktUrl(getWebRtcSignalServer(gmCgDeviceInfo));
        deviceConfig.setDeviceModel(gmCgDeviceInfo.getFrameworkType() == 1 ? DeviceConfig.DeviceModel.DEVICE_ARM : DeviceConfig.DeviceModel.DEVICE_VCA);
        deviceConfig.setIdentity(CGGlbConfig.getUserId());
        deviceConfig.setToken(CGGlbConfig.getGmCgToken());
        CGSessionCtx cGSessionCtx3 = this.mSessionCtx;
        cGSessionCtx3.pWebRTCParameters = this.mWebRTCParameters;
        cGSessionCtx3.pDeviceConfig = deviceConfig;
        CGLog.i(TAG_FSR, "CGPlaySessionImpl.checkSuperResolution: \u5f00\u59cb\u68c0\u67e5\u8d85\u5206\u5f00\u5173 " + this.mGameConfigInfo.pSupportSuperResolutionType);
        WebRTCParameters webRTCParameters7 = this.mWebRTCParameters;
        if (webRTCParameters7 != null && this.mContext != null && !z16) {
            if (this.mGameConfigInfo.pSupportSuperResolutionType == 2) {
                enableFsr();
            } else {
                this.mSessionMonitor.reportCallSwitchSR(0, 0);
                onSuperResolutionTypeChange(0);
            }
        } else {
            if (webRTCParameters7 == null) {
                CGLog.w(TAG_FSR, "CGPlaySessionImpl.checkSuperResolution(): mWebRTCParameters \u4e3a\u7a7a\uff1f");
            }
            if (this.mContext == null) {
                CGLog.w(TAG_FSR, "CGPlaySessionImpl.checkSuperResolution: Context\u4e3a\u7a7a?");
            }
            if (this.mGameConfigInfo.pSupportSuperResolutionType == 0) {
                CGLog.w(TAG_FSR, "CGPlaySessionImpl.checkSuperResolution: \u5f53\u524d\u8d85\u5206\u5df2\u5173\u95ed");
            }
            if (z16) {
                CGLog.i(TAG_FSR, "CGPlaySessionImpl.checkSuperResolution: \u8fd9\u6b21\u662f\u4e4b\u524d\u5931\u8d25\u91cd\u65b0\u542f\u52a8\u7684");
            }
        }
        afterSRcheck(deviceConfig, gmCgDeviceInfo);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void login(int i3, String str, String str2, GmCgApiService.ActionResultListener actionResultListener) {
        setCloudGameLoginParamV2(i3, str);
        login(str2, actionResultListener);
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventConnectFailed(WebRTCEvents.ConnectionState connectionState, String str, String str2) {
        CGSessionLogI("onEventConnectFailed: " + connectionState.name());
        GmCgError gmCgError = GmCgError.ErrorOther;
        switch (AnonymousClass13.$SwitchMap$com$tencent$gamematrix$gmcg$webrtc$WebRTCEvents$ConnectionState[connectionState.ordinal()]) {
            case 1:
                gmCgError = GmCgError.ErrorRTCConnFailBegin;
                break;
            case 2:
                gmCgError = GmCgError.ErrorRTCConnFailAfterOfferAnswered;
                break;
            case 3:
                gmCgError = GmCgError.ErrorRTCConnFailAfterIceReceived;
                break;
            case 4:
                gmCgError = GmCgError.ErrorRTCConnFailAfterIceCompleted;
                break;
            case 5:
                gmCgError = GmCgError.ErrorRTCFirstFrameTimeOut;
                break;
            case 6:
                gmCgError = GmCgError.ErrorRTCFailAfterFirstFrame;
                break;
            case 7:
                gmCgError = GmCgError.ErrorRTCConnTimeOut;
                break;
        }
        internalWhenErrorHappen(gmCgError);
        CGSessionMonitor cGSessionMonitor = this.mSessionMonitor;
        if (cGSessionMonitor != null) {
            cGSessionMonitor.reportRTCConnectFailed();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onVirtualGamepadMsgData(int i3, int i16, String str) {
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.GmCgPlaySession
    public void restartPlay(boolean z16) {
        if (z16) {
            if (needDoV2CloudGameLoginDefault()) {
                CGLog.i(this.mCgGameId + " restart play with needDoV2CloudGameLoginDefault");
                requestInGameLoginDefault(this.mInGameLoginChannelType, this.mInGameLoginDefaultParam, new CGBizHttpService.ResultListener<CGCommonResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.6
                    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                    public void onResult(@NonNull GmCgError gmCgError, CGCommonResp cGCommonResp) {
                        if (!GmCgError.isOK(gmCgError)) {
                            CGPlaySessionImpl.this.CGSessionLogE("requestInGameLoginDefault: fail");
                        }
                        CGPlaySessionImpl.this.doRestartPlay("requestInGameLoginDefault login");
                    }
                });
                return;
            }
            if (needDoV2CloudGameLoginV1()) {
                CGLog.i("needDoV2CloudGameLoginV1");
                requestInGameGameForSP(this.mInGameLoginChannelType, this.mGameAutoLoginInfo, new CGBizHttpService.ResultListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.bv
                    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                    public final void onResult(GmCgError gmCgError, Object obj) {
                        CGPlaySessionImpl.this.lambda$restartPlay$6(gmCgError, (CGCommonResp) obj);
                    }
                });
                return;
            }
            if (needDoV2CloudGameLoginYyb()) {
                CGLog.i(this.mCgGameId + " restart play with needDoV2CloudGameLoginYyb");
                requestInGameLoginYyb(this.mInGameLoginYybParam, new CGBizHttpService.ResultListener<Void>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.7
                    @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                    public void onResult(@NonNull GmCgError gmCgError, Void r26) {
                        if (!GmCgError.isOK(gmCgError)) {
                            CGPlaySessionImpl.this.CGSessionLogE("requestInGameLoginDefault: fail");
                        }
                        CGPlaySessionImpl.this.doRestartPlay("requestInGameLoginYyb login");
                    }
                });
                return;
            }
            CGLog.i(this.mCgGameId + " restart play with no match login way");
            doRestartPlay("no match way login");
            return;
        }
        CGLog.i(this.mCgGameId + " restart play with no login");
        doRestartPlay("not perform login");
    }

    private void login(@Nullable String str, final GmCgApiService.ActionResultListener actionResultListener) {
        if (needDoV2CloudGameLoginDefault()) {
            CGLog.i(this.mCgGameId + " in game play with needDoV2CloudGameLoginDefault");
            requestInGameLoginDefault(this.mInGameLoginChannelType, this.mInGameLoginDefaultParam, false, str, new CGBizHttpService.ResultListener<CGCommonResp>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.4
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public void onResult(@NonNull GmCgError gmCgError, CGCommonResp cGCommonResp) {
                    if (!GmCgError.isOK(gmCgError)) {
                        CGPlaySessionImpl.this.CGSessionLogE("requestInGameLoginDefault: fail");
                    }
                    if (actionResultListener != null) {
                        if (GmCgError.isOK(gmCgError)) {
                            actionResultListener.onActionSucceed();
                        } else {
                            actionResultListener.onActionResult(gmCgError);
                        }
                    }
                }
            });
            return;
        }
        if (!needDoV2CloudGameLoginYyb()) {
            if (actionResultListener != null) {
                actionResultListener.onActionResult(GmCgError.ErrorOther);
            }
        } else {
            CGLog.i(this.mCgGameId + " in game play with needDoV2CloudGameLoginYyb");
            requestInGameLoginYyb(this.mInGameLoginYybParam, false, new CGBizHttpService.ResultListener<Void>() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGPlaySessionImpl.5
                @Override // com.tencent.gamematrix.gmcg.sdk.service.CGBizHttpService.ResultListener
                public void onResult(@NonNull GmCgError gmCgError, Void r36) {
                    if (!GmCgError.isOK(gmCgError)) {
                        CGPlaySessionImpl.this.CGSessionLogE("requestInGameLoginDefault: fail");
                    }
                    if (actionResultListener != null) {
                        if (GmCgError.isOK(gmCgError)) {
                            actionResultListener.onActionSucceed();
                        } else {
                            actionResultListener.onActionResult(gmCgError);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onEventDataChannelConnected(String str) {
        CGLog.i("onEventDataChannelConnected: sessionId = " + str);
        if (this.mWebRTCSdk != null) {
            int value = GmCgSubScribeEvent.SUBSCRIBE.getValue();
            if (GmCgSdk.isAllTvBiz()) {
                this.mWebRTCSdk.virtualGamepadSubscribeNotification(value, new int[]{GmCgClientType.WEBRTC_SESSION_TV_MINIPROGRAM.getValue(), GmCgClientType.WEBRTC_SESSION_H5.getValue(), GmCgClientType.WEBRTC_SESSION_TV.getValue()}, new int[]{GmCgConnectionEvent.CONNECTED.getValue(), GmCgConnectionEvent.DISCONNECTED.getValue()});
            } else {
                this.mWebRTCSdk.virtualGamepadSubscribeNotification(value, new int[]{GmCgClientType.WEBRTC_SESSION_TV_MINIPROGRAM.getValue(), GmCgClientType.WEBRTC_SESSION_H5.getValue(), GmCgClientType.WEBRTC_SESSION_ANDROID_APP.getValue()}, new int[]{GmCgConnectionEvent.CONNECTED.getValue(), GmCgConnectionEvent.DISCONNECTED.getValue()});
            }
        }
    }

    public static CGPlaySessionImpl createFromDevice(@NonNull Activity activity, @NonNull GmCgDeviceInfo gmCgDeviceInfo, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        CGPlaySessionImpl cGPlaySessionImpl = new CGPlaySessionImpl();
        cGPlaySessionImpl.mActivity = activity;
        cGPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGPlaySessionImpl.mDeviceReadyToUse = gmCgDeviceInfo;
        cGPlaySessionImpl.mCgGameId = gmCgDeviceInfo.getDeviceTag();
        WebRTCSDK.enableSeiExtension(true);
        cGPlaySessionImpl.init(null, frameLayout);
        return cGPlaySessionImpl;
    }

    public static CGPlaySessionImpl create(@NonNull Activity activity, @NonNull GmCgAllocatorCfg gmCgAllocatorCfg, @NonNull GmCgSessionCfg gmCgSessionCfg, @NonNull FrameLayout frameLayout) {
        CGPlaySessionImpl cGPlaySessionImpl = new CGPlaySessionImpl();
        cGPlaySessionImpl.mActivity = activity;
        cGPlaySessionImpl.mAllocatorCfg = gmCgAllocatorCfg;
        cGPlaySessionImpl.mSessionCfg = gmCgSessionCfg;
        cGPlaySessionImpl.mDeviceReadyToUse = null;
        cGPlaySessionImpl.mCgGameId = gmCgAllocatorCfg.pCgGameId;
        cGPlaySessionImpl.init(null, frameLayout);
        return cGPlaySessionImpl;
    }

    protected void initPlayView(GmCgPlayView gmCgPlayView, FrameLayout frameLayout) {
        if (frameLayout != null) {
            GmCgSessionCfg gmCgSessionCfg = this.mSessionCfg;
            GmCgPlaySessionViewHolder gmCgPlaySessionViewHolder = new GmCgPlaySessionViewHolder(frameLayout, gmCgSessionCfg.pUseCustomLoadingView, gmCgSessionCfg.pEnableExtraInfoOverlay, gmCgSessionCfg.pExtraInfoOverlayRightOrLeft, gmCgSessionCfg.pExtraInfoOverLayBottomOrTop, gmCgSessionCfg.pEnableConfigCallback);
            this.mPlaySessionViewHolder = gmCgPlaySessionViewHolder;
            gmCgPlaySessionViewHolder.setDefaultLoadingPortraitResId(this.mSessionCfg.pDefaultLoadingPortraitResId);
            this.mPlaySessionViewHolder.setDefaultLoadingLandscapeResId(this.mSessionCfg.pDefaultLoadingLandscapeResId);
            this.mPlaySessionViewHolder.setDefaultLoadingBackgroundResId(this.mSessionCfg.pDefaultLoadingBackgroundResId);
            this.mPlaySessionViewHolder.setLoadingScaleType(this.mSessionCfg.pLoadingScaleType);
            GmCgSessionCfg gmCgSessionCfg2 = this.mSessionCfg;
            if (gmCgSessionCfg2 != null && !gmCgSessionCfg2.pUseCustomInputView) {
                realSetInputController(this.mActivity, this.mPlaySessionViewHolder);
            } else {
                CGSessionLogI("need UseCustomInputView!!");
            }
        } else if (gmCgPlayView != null) {
            this.mPlaySessionViewHolder = new GmCgPlaySessionViewHolder(gmCgPlayView);
        } else {
            throw new IllegalArgumentException("no play view or container view");
        }
        if (this.mContext == null) {
            this.mContext = this.mPlaySessionViewHolder.getContext();
        }
        this.mPlaySessionViewHolder.setPlayScreenOrientation(this.mSessionCfg.pGameScreenOrientation);
        this.mPlaySessionViewHolder.onBaseInfoUpdate(CGGlbConfig.getUserId(), this.mCgGameId);
        if (isTv()) {
            WebRTCSDK.enableHidSensor(true);
            WebRTCSDK.setSkipRender(true);
        }
    }

    private void sendClipboardDataToWebRtc() {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void onFirstFrameRendered() {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void requestDoubleVirtualGamepad() {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void requestVirtualGamepad() {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void unregisterKeyMapListener() {
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgDetectorUpdate(int i3) {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void registerKeyMapListener(IKeyMapListener iKeyMapListener) {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void setKeyMapViewVisibility(boolean z16) {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void setKeyTrackMenuEnabled(boolean z16) {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void setPlayStreamQualityToVGamepad(int i3) {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController
    public void updateWebRTCSDK(WebRTCSDK webRTCSDK) {
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgPlayDetectorListener
    public void onGmCgNetDetectResult(int i3, boolean z16, List<GmCgNetDetectionInfo> list) {
    }

    @Override // com.tencent.gamematrix.gmcg.webrtc.WebRTCEvents
    public void onClientConnectionMsgData(int i3, int i16, String str, String str2, int i17) {
    }
}
