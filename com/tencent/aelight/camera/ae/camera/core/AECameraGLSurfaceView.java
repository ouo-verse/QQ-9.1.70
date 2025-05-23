package com.tencent.aelight.camera.ae.camera.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.core.AECameraManager;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.camera.filter.FilterProcessBase;
import com.tencent.aelight.camera.ae.camera.filter.a;
import com.tencent.aelight.camera.ae.camera.testpkg.c;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListScrollView;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.watermark.b;
import com.tencent.aelight.camera.ae.camera.util.AIOOperationUpdater;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.aelight.camera.ae.flashshow.util.g;
import com.tencent.aelight.camera.ae.flashshow.util.m;
import com.tencent.aelight.camera.ae.gif.a;
import com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.j;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.ark.EGLContextHolder;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.common.app.AppInterface;
import com.tencent.filter.GLSLRender;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.e;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
import org.libpag.VideoDecoder;
import org.light.DeviceCameraConfig;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.device.LightDeviceUtils;
import org.light.device.OfflineConfig;
import org.light.listener.OnLoadAssetListener;
import org.light.utils.MustRunOnGLThread;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECameraGLSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer, AudioCapture.b, com.tencent.mobileqq.videocodec.mediacodec.recorder.c, AEFilterProcessTex.c, SurfaceTexture.OnFrameAvailableListener, SensorEventListener {
    private static final String AIO_CAMERA_FIRST_INIT_FORBID_FILTER = "102459";
    private static final String AIO_CAMERA_RECORD_FORCE_720P = "103163";
    private static final int CHECK_FRAMES_COUNT = 30;
    private static final int CURRENT_PHONE_LEVEL;
    private static final int DELAY_ALPHA_TIME = 100;
    private static final int FULL_SCREEN_MAX_SIZE = 720;
    private static final long GIF_SKIP_FRAME_INTERVAL = 83;
    private static final int GIF_WANTED_SIZE = 640;
    private static final int MAX_PREVIEW_WIDTH;
    private static final int MICROSECOND = 1000;
    private static final int RECORDING_OFF = 0;
    private static final int RECORDING_ON = 1;
    private static final String TAG = "AECameraGLSurfaceView";
    private static volatile boolean isSdkInited;
    private int activityOrientation;
    private xp.a aeCaptureParam;
    private AEBottomListScrollView.a aeEditMaterialSelectedListener;
    private com.tencent.aelight.camera.ae.gif.a aeExpressionRecognizer;
    private AEGLSurfaceListener aeGLSurfaceListener;
    private AEFilterProcessTex.d aiBeautyFaceListener;
    protected AudioCapture audioCapture;
    private boolean beautyEnable;
    private com.tencent.aelight.camera.ae.a cameraConfig;
    protected CaptureListener captureListener;
    public AEVideoStoryDashboardPart.r debugInfoCallback;
    private int drawFrameCount;
    protected AEEffectListener effectListener;
    private int eglContextVersion;
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c encodeConfig;
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.c encodeTestConfig;
    private boolean faceEffectEnable;
    private boolean filterEnable;
    private boolean firstFrameActionDone;
    private tq.c fpsReporter;
    private int frameCount;
    protected AEGenderTypeListener genderTypeListener;
    private int gifPreviewHeight;
    private int gifPreviewWidth;
    private long gifRecordFrameIndex;
    private long gifRecordStartTimestamp;
    private volatile boolean hasRecorded;
    private e hwVideoRecorder;
    private e hwVideoTestRecorder;
    private boolean isAIOCameraFirstInitForbidFilter;
    private boolean isDynamicResolutionMode;
    protected boolean isFirstFrame;
    private boolean isFirstNonFilter;
    private boolean isGIFMode;
    private boolean isInit;
    private boolean isNeedVoiceEncode;
    private boolean isPaused;
    private boolean lastDetected;
    private boolean logTillHaveFrame;
    private AEKitInitListener mAEKitInitListener;
    private Sensor mAccelerometer;
    protected yp.a mAudioChangeCapture;
    protected int mCameraHeight;
    private SurfaceTexture mCameraSurfaceTexture;
    private int mCameraTexture;
    protected int mCameraWidth;
    private com.tencent.aelight.camera.ae.camera.ui.c mController;
    private AEVideoStoryTopBarViewModel.Ratio mCurrentRatio;
    private FilterProcessBase mFilterProcess;
    private volatile boolean mHaveFrame;
    private final int mIdentityHashCode;
    private boolean mIsMaterialSame;
    private volatile boolean mIsTryLocationPermission;
    private String mLastForceMaterialPath;
    private boolean mLastMateralApplySuccess;
    private VideoMaterial mLastVideoMaterial;
    private int mMaterialAlpha;
    private String mMaterialPath;
    private Runnable mOnFrameDrawCallback;
    private AIOOperationUpdater mOperationUpdater;
    private com.tencent.aelight.camera.ae.camera.util.a mOrientationEventListener;
    private volatile boolean mPendingReqLocationPermission;
    protected int mPreviewHeight;
    protected int mPreviewWidth;
    private int mRecordingStatus;
    private int mRecordingTestStatus;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;
    private PointF mTouchStartPoint;
    private int mTryCheckCount;
    private boolean needFace;
    private int notDetectedTimes;
    private boolean onFrameAvailableLogged;
    private int orientation;
    protected boolean pauseFilterChainWhenCapture;
    private boolean preExtractFrame;
    protected a.b recommendTextCallback;
    private volatile boolean recordingEnabled;
    private volatile boolean recordingTestEnabled;
    protected int selectedCamera;
    SensorManager sensorManager;
    private boolean sharpFaceEnable;
    private int smoothLevel;
    private long startTime;
    protected AEFilterManager.MaterialInnerEffectListener stickerInnerLutFilterListener;
    private boolean superMethodPostSubThread;
    private boolean useVideoOrientation;
    private AEVideoCaptureResult videoCaptureResult;
    private int videoHeight;
    private int videoWidth;
    private com.tencent.aelight.camera.aioeditor.shortvideo.b voiceRecognizer;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEEffectListener {
        void onAssetProcessingData(HashMap<String, String> hashMap);

        void onDetectStateChange(boolean z16, boolean z17);

        void onHideNormalTip();

        void onHidePagTip();

        void onRequestChangeCamera(int i3, AECameraManager.CameraOpenCallback cameraOpenCallback);

        void onSelectFaceEffect(VideoMaterial videoMaterial);

        void onSetFilterProcess(AEFilterProcessTex aEFilterProcessTex);

        void onShowNormalTip(String str, String str2, int i3);

        void onShowPagTip(String str, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEGLSurfaceListener {
        void onBasicBeautyDownload();

        void onDrawFrameWithEffect(int i3, AEFilterManager aEFilterManager);

        void onFirstFrameDone();

        void onOrientionChanged(int i3);

        void onPreviewSizeChanged(int i3, int i16, int i17, int i18);

        void onPreviewSurfaceTextureCreate(SurfaceTexture surfaceTexture);

        void onPreviewSurfaceTextureRelease();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEGenderTypeListener {
        void onGenderTypeListener(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEKitAction {
        void run(AEFilterProcessTex aEFilterProcessTex);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface AEKitInitListener {
        void onAEKitInited();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface CaptureListener {
        public static final int ERROR_CANCEL = 105;
        public static final int ERROR_CAPTURE_FRAME_OOM = 103;
        public static final int ERROR_ENCODE_ERROR = 104;
        public static final int ERROR_LOAD_MEDIAINFO_FAILED = 101;
        public static final int ERROR_STOP_WITHOUT_STARTED = 102;

        void onCaptureError(int i3);

        void onPhotoCaptured(AEPhotoCaptureResult aEPhotoCaptureResult);

        void onVideoCaptureStart();

        void onVideoCaptured(AEVideoCaptureResult aEVideoCaptureResult);

        void reportFirstFrameShown();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface ExtractFrameRequest {
        void onExtract(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class TapRunnable implements Runnable {
        int touchEvent;

        /* renamed from: x, reason: collision with root package name */
        float f62218x;

        /* renamed from: y, reason: collision with root package name */
        float f62219y;

        public TapRunnable(int i3, float f16, float f17) {
            this.touchEvent = i3;
            this.f62218x = f16;
            this.f62219y = f17;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess).P().setTouchTriggerEvent(this.touchEvent, this.f62218x, this.f62219y);
        }
    }

    static {
        int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.getContext());
        CURRENT_PHONE_LEVEL = phonePerfLevel;
        MAX_PREVIEW_WIDTH = phonePerfLevel < 4 ? phonePerfLevel < 2 ? PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT : 720 : 1080;
        isSdkInited = false;
    }

    public AECameraGLSurfaceView(Context context) {
        super(context);
        this.mTryCheckCount = 0;
        this.mCameraTexture = 0;
        this.isFirstNonFilter = false;
        this.mSurfaceWidth = 320;
        this.mSurfaceHeight = 480;
        this.mCameraWidth = 0;
        this.mCameraHeight = 0;
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        this.pauseFilterChainWhenCapture = true;
        this.smoothLevel = 0;
        this.isInit = false;
        this.isNeedVoiceEncode = false;
        this.beautyEnable = true;
        this.sharpFaceEnable = true;
        this.filterEnable = true;
        this.faceEffectEnable = true;
        this.orientation = 90;
        this.activityOrientation = 0;
        this.isFirstFrame = true;
        this.mHaveFrame = false;
        this.logTillHaveFrame = true;
        this.drawFrameCount = 0;
        this.onFrameAvailableLogged = false;
        this.isAIOCameraFirstInitForbidFilter = true;
        this.isPaused = true;
        this.lastDetected = false;
        this.notDetectedTimes = 0;
        this.needFace = false;
        this.isGIFMode = false;
        this.gifRecordStartTimestamp = 0L;
        this.gifRecordFrameIndex = 0L;
        this.fpsReporter = new tq.a();
        this.voiceRecognizer = new com.tencent.aelight.camera.aioeditor.shortvideo.b();
        this.mIsTryLocationPermission = false;
        this.mPendingReqLocationPermission = false;
        this.hasRecorded = false;
        this.useVideoOrientation = true;
        this.mLastVideoMaterial = null;
        this.mMaterialPath = null;
        this.mIsMaterialSame = false;
        this.mLastMateralApplySuccess = false;
        this.mMaterialAlpha = -1;
        this.mLastForceMaterialPath = null;
        this.frameCount = 0;
        this.startTime = System.currentTimeMillis();
        this.selectedCamera = 2;
        this.mTouchStartPoint = new PointF(0.0f, 0.0f);
        initEGL();
        this.mIdentityHashCode = System.identityHashCode(this);
    }

    private void addAEInitQueue(Runnable runnable) {
        if (isAEKitAvailable()) {
            ((AEFilterProcessTex) this.mFilterProcess).B(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkLocationPermissionGranted() {
        return getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || getContext().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private void clearSurfaceTexture() {
        if (this.mCameraSurfaceTexture == null) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{this.mCameraTexture}, 0);
        this.mCameraSurfaceTexture.release();
        this.mCameraSurfaceTexture = null;
        this.isFirstNonFilter = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FilterProcessBase createFilterProcess() {
        com.tencent.aelight.camera.ae.camera.filter.b bVar;
        com.tencent.aelight.camera.ae.camera.filter.a c16;
        ms.a.a(TAG, "[createFilterProcess]:");
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null && ((filterProcessBase instanceof AEFilterProcessTex) || this.hasRecorded)) {
            return this.mFilterProcess;
        }
        int i3 = this.mTryCheckCount + 1;
        this.mTryCheckCount = i3;
        FilterProcessBase filterProcessBase2 = this.mFilterProcess;
        if (filterProcessBase2 != null && i3 % 30 != 0) {
            return filterProcessBase2;
        }
        boolean k3 = d.k(false);
        boolean u16 = d.u();
        FilterProcessBase filterProcessBase3 = this.mFilterProcess;
        if (filterProcessBase3 != null) {
            if (!k3 || !u16) {
                return filterProcessBase3;
            }
            filterProcessBase3.b();
            this.hasRecorded = false;
        }
        ms.a.f(TAG, "createFilterProcess---BEGIN");
        if (k3 && u16) {
            int i16 = this.mIdentityHashCode;
            if (isDyStyleEnable()) {
                c16 = a.C0536a.a();
            } else {
                c16 = a.C0536a.c();
            }
            AEFilterProcessTex aEFilterProcessTex = new AEFilterProcessTex(i16, c16);
            aEFilterProcessTex.r(getRatio());
            if (isDyStyleEnable()) {
                AIOOperationUpdater aIOOperationUpdater = this.mOperationUpdater;
                AIOOperationUpdater aIOOperationUpdater2 = new AIOOperationUpdater();
                this.mOperationUpdater = aIOOperationUpdater2;
                aEFilterProcessTex.C0(aIOOperationUpdater2, aIOOperationUpdater);
            }
            aEFilterProcessTex.t0(new AEFilterProcessTex.e() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.8
                @Override // com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.e
                public void recover(VideoMaterial videoMaterial) {
                    ms.a.f(AECameraGLSurfaceView.TAG, "EditableWatermarkMaterialRecover recover---");
                    AECameraGLSurfaceView.this.mLastVideoMaterial = null;
                    AECameraGLSurfaceView.this.setMaterial(videoMaterial.getDataPath());
                }
            });
            if (isFromNonBlockingEntrance() && uq3.c.f6()) {
                AEResUtil.r0();
            }
            ms.a.f(TAG, "createFilterProcess---create AEFilterProcessTex");
            bVar = aEFilterProcessTex;
        } else {
            ms.a.a(TAG, "FeatureManager.loadBasicFeaturesInLight \u5931\u8d25\uff0c\u6784\u5efaNonAEFilterProcess");
            gq.c.b();
            com.tencent.aelight.camera.ae.camera.filter.b bVar2 = new com.tencent.aelight.camera.ae.camera.filter.b();
            this.isFirstNonFilter = true;
            ms.a.c(TAG, "createFilterProcess---create NonAEFilterProcess");
            showToast(HardCodeUtil.qqStr(R.string.xzx));
            bVar = bVar2;
        }
        if (com.tencent.aelight.camera.ae.util.c.d()) {
            try {
                VideoDecoder.SetMaxHardwareDecoderCount(0);
            } catch (Throwable th5) {
                ms.a.c(TAG, "call SetMaxHardwareDecoderCount method error." + th5.getMessage());
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyFilterProcess() {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null) {
            filterProcessBase.b();
            this.hasRecorded = false;
            this.mFilterProcess = null;
            AEGLSurfaceListener aEGLSurfaceListener = this.aeGLSurfaceListener;
            if (aEGLSurfaceListener != null) {
                aEGLSurfaceListener.onPreviewSurfaceTextureRelease();
            }
            clearSurfaceTexture();
        }
        AEFilterManagerHolder.setFilterProcess(null);
    }

    private void disableOrientationListen() {
        com.tencent.aelight.camera.ae.camera.util.a aVar = this.mOrientationEventListener;
        if (aVar != null) {
            aVar.disable();
        }
    }

    private void drawToMediaCodecForPause(int i3, float[] fArr, float[] fArr2) {
        if (isFromFlashShow()) {
            frameToMediaCodecVideo(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, SystemClock.elapsedRealtimeNanos());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishCapturePhoto(AEPhotoCaptureResult aEPhotoCaptureResult) {
        CaptureListener captureListener = this.captureListener;
        if (captureListener != null) {
            captureListener.onPhotoCaptured(aEPhotoCaptureResult);
        }
    }

    private int getMaxWidth() {
        if (isAIOCameraRecordForce720P() || !isDyStyleEnable()) {
            return 720;
        }
        if (this.mCurrentRatio == AEVideoStoryTopBarViewModel.Ratio.R_16_9 || MAX_PREVIEW_WIDTH <= 720) {
            return MAX_PREVIEW_WIDTH;
        }
        return 720;
    }

    private FilterProcessBase.VideoOutRatio getRatio() {
        ms.a.a(TAG, "getRatio" + this.mCurrentRatio);
        if (isFromFlashShow()) {
            return FilterProcessBase.VideoOutRatio.RATIO_9_16;
        }
        if (isFromCircle()) {
            return FilterProcessBase.VideoOutRatio.NONE;
        }
        if (this.isGIFMode) {
            return FilterProcessBase.VideoOutRatio.NONE;
        }
        if (this.mCurrentRatio == AEVideoStoryTopBarViewModel.Ratio.R_16_9) {
            return FilterProcessBase.VideoOutRatio.RATIO_9_16;
        }
        return FilterProcessBase.VideoOutRatio.NONE;
    }

    private int[] getVideoSize() {
        FilterProcessBase filterProcessBase;
        int[] f16;
        int i3;
        int i16;
        if (AEDashboardUtil.q() && (filterProcessBase = this.mFilterProcess) != null && (f16 = filterProcessBase.f()) != null && f16.length >= 2 && (i3 = f16[0]) > 0 && (i16 = f16[1]) > 0) {
            return new int[]{i3, g.a(i16)};
        }
        return new int[]{this.videoWidth, this.videoHeight};
    }

    private void initFilterProcess() {
        SurfaceTexture h16;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase == null || !(filterProcessBase instanceof AEFilterProcessTex)) {
            ms.a.a(TAG, "initFilterProcess: mFilterProcess==null, createFilterProcess");
            FilterProcessBase createFilterProcess = createFilterProcess();
            if (createFilterProcess == this.mFilterProcess) {
                return;
            } else {
                this.mFilterProcess = createFilterProcess;
            }
        }
        tq.b.h().n(TAG, "initFilterProcess---begin");
        initOrientationEventListener();
        FilterProcessBase filterProcessBase2 = this.mFilterProcess;
        if (filterProcessBase2 instanceof AEFilterProcessTex) {
            AEFilterManagerHolder.setFilterProcess((AEFilterProcessTex) filterProcessBase2);
            AEKitInitListener aEKitInitListener = this.mAEKitInitListener;
            if (aEKitInitListener != null) {
                aEKitInitListener.onAEKitInited();
            }
            ((AEFilterProcessTex) this.mFilterProcess).B0(this.stickerInnerLutFilterListener);
            ((AEFilterProcessTex) this.mFilterProcess).v0(this.genderTypeListener);
            ((AEFilterProcessTex) this.mFilterProcess).o0(this.aiBeautyFaceListener);
            ((AEFilterProcessTex) this.mFilterProcess).I0(new LightNode.ILightNodeTipsListener() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.9
                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onHideNormalTip() {
                    AEEffectListener aEEffectListener = AECameraGLSurfaceView.this.effectListener;
                    if (aEEffectListener != null) {
                        aEEffectListener.onHideNormalTip();
                    }
                }

                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onHidePagTip() {
                    AEEffectListener aEEffectListener = AECameraGLSurfaceView.this.effectListener;
                    if (aEEffectListener != null) {
                        aEEffectListener.onHidePagTip();
                    }
                }

                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onShowNormalTip(String str, String str2, int i3) {
                    AEEffectListener aEEffectListener = AECameraGLSurfaceView.this.effectListener;
                    if (aEEffectListener != null) {
                        aEEffectListener.onShowNormalTip(str, str2, i3);
                    }
                }

                @Override // com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener
                public void onShowPagTip(String str, int i3) {
                    AEEffectListener aEEffectListener = AECameraGLSurfaceView.this.effectListener;
                    if (aEEffectListener != null) {
                        aEEffectListener.onShowPagTip(str, i3);
                    }
                }
            });
            ((AEFilterProcessTex) this.mFilterProcess).z0(new OnLoadAssetListener() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.10
                @Override // org.light.listener.OnLoadAssetListener
                public void OnAssetProcessing(HashMap<String, String> hashMap) {
                    Log.d(AECameraGLSurfaceView.TAG, "OnAssetProcessing: " + hashMap);
                    AEEffectListener aEEffectListener = AECameraGLSurfaceView.this.effectListener;
                    if (aEEffectListener != null) {
                        aEEffectListener.onAssetProcessingData(hashMap);
                    }
                }

                @Override // org.light.listener.OnLoadAssetListener
                public void OnLoadAssetError(int i3) {
                    ms.a.c(AECameraGLSurfaceView.TAG, "OnLoadAssetError: " + i3);
                    String lightSdkAssetError2String = AECameraGLSurfaceView.lightSdkAssetError2String(i3);
                    if (lightSdkAssetError2String != null) {
                        AECameraGLSurfaceView.this.showToast(lightSdkAssetError2String);
                    }
                }

                @Override // org.light.listener.OnLoadAssetListener
                public void OnAssetDurationChange(long j3) {
                }
            });
            int i3 = this.mCameraWidth;
            if (i3 > 0) {
                this.mFilterProcess.v(this.mSurfaceWidth, this.mSurfaceHeight, i3, this.mCameraHeight, this.mPreviewWidth, this.mPreviewHeight);
                this.mFilterProcess.w(this.videoWidth, this.videoHeight);
                ms.a.f(TAG, "onSurfaceChanged:" + this.mSurfaceWidth + "," + this.mSurfaceHeight + "," + this.mCameraWidth + "," + this.mCameraHeight + ",previewWidth:" + this.mPreviewWidth + ",previewHeight:" + this.mPreviewHeight);
            }
        }
        if (this.isFirstNonFilter) {
            h16 = initSurfaceTexture();
            this.mFilterProcess.q(this.mCameraTexture, this.mCameraSurfaceTexture);
        } else {
            h16 = this.mFilterProcess.h();
        }
        h16.setOnFrameAvailableListener(this);
        if (h16 instanceof com.tencent.aelight.camera.ae.camera.testpkg.c) {
            ((com.tencent.aelight.camera.ae.camera.testpkg.c) h16).d(new c.a() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.11
                @Override // com.tencent.aelight.camera.ae.camera.testpkg.c.a
                public void endRecord() {
                    AECameraGLSurfaceView.this.stopCaptureTestVideo();
                }

                @Override // com.tencent.aelight.camera.ae.camera.testpkg.c.a
                public void startRecord() {
                    AECameraGLSurfaceView.this.startCaptureTestVideo();
                }
            });
        }
        onAeGLSurfaceListener(h16);
        tq.b.h().n(TAG, "initFilterProcess---end");
    }

    private void initOrientationEventListener() {
        if (this.mOrientationEventListener == null) {
            this.mOrientationEventListener = new com.tencent.aelight.camera.ae.camera.util.a(getContext().getApplicationContext()) { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.18
                @Override // com.tencent.aelight.camera.ae.camera.util.a
                public void onOrientationChanged(int i3) {
                    int i16;
                    AECameraGLSurfaceView.this.activityOrientation = i3;
                    if (AECameraGLSurfaceView.this.aeGLSurfaceListener != null) {
                        AECameraGLSurfaceView.this.aeGLSurfaceListener.onOrientionChanged(i3);
                    }
                    int i17 = 0;
                    if (i3 == -1) {
                        if (ms.a.g()) {
                            ms.a.c(AECameraGLSurfaceView.TAG, "OrientationEventListener unknown");
                        }
                        i16 = 90;
                    } else {
                        i16 = 0;
                    }
                    if (i3 > 315 || i3 < 45) {
                        i17 = 90;
                    } else if (i3 > 45 && i3 < 135) {
                        i17 = 180;
                    } else if (i3 > 135 && i3 < 225) {
                        i17 = 270;
                    } else if (i3 <= 225 || i3 >= 315) {
                        i17 = i16;
                    }
                    if (AECameraGLSurfaceView.this.isFromFlashShow()) {
                        AECameraGLSurfaceView.this.orientation = 90;
                    } else {
                        AECameraGLSurfaceView.this.orientation = i17;
                    }
                }

                @Override // com.tencent.aelight.camera.ae.camera.util.a
                public void onPoseChanged(float f16, float f17, float f18) {
                    if (AECameraGLSurfaceView.this.mFilterProcess != null) {
                        AECameraGLSurfaceView.this.mFilterProcess.u(f18);
                    }
                }
            };
        }
        if (this.mOrientationEventListener.canDetectOrientation()) {
            this.mOrientationEventListener.enable();
        }
    }

    public static synchronized void initSdk() {
        synchronized (AECameraGLSurfaceView.class) {
            ms.a.f(TAG, "[initSdk] + BEGIN, isSdkInited = " + isSdkInited);
            long currentTimeMillis = System.currentTimeMillis();
            if (!isSdkInited) {
                ms.a.f(TAG, "[initSdk] do init");
                isSdkInited = true;
                tq.b.h().o("glSurfaceViewStaticInit-begin");
                ms.a.f(TAG, "[initSdk] , AEKitForQQ.init in light result = " + d.j());
                tq.b.h().o("glSurfaceViewStaticInit-end");
            }
            ms.a.f(TAG, "[initSdk] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private SurfaceTexture initSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.mCameraSurfaceTexture;
        if (surfaceTexture != null) {
            return surfaceTexture;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mCameraTexture = iArr[0];
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.mCameraTexture);
        this.mCameraSurfaceTexture = surfaceTexture2;
        return surfaceTexture2;
    }

    private void initVideoSize(int i3, int i16) {
        int i17 = (int) (this.aeCaptureParam.i() * ((this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth));
        if (j.h().a()) {
            i17 = this.aeCaptureParam.j();
        }
        if (this.isDynamicResolutionMode) {
            int[] h16 = g.h(i17, i3, i16);
            int[] b16 = g.b(h16[0], h16[1], this.aeCaptureParam.c(), this.aeCaptureParam.b(), 1.0f);
            this.videoWidth = b16[0];
            this.videoHeight = b16[1];
            return;
        }
        int[] b17 = g.b(i3, i16, this.mSurfaceWidth, this.mSurfaceHeight, this.aeCaptureParam.h());
        int i18 = b17[0];
        this.videoWidth = i18;
        int i19 = b17[1];
        this.videoHeight = i19;
        int[] h17 = g.h(i17, i18, i19);
        this.videoWidth = h17[0];
        this.videoHeight = h17[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAEKitAvailable() {
        FilterProcessBase filterProcessBase;
        return AEResUtil.R() && (filterProcessBase = this.mFilterProcess) != null && (filterProcessBase instanceof AEFilterProcessTex);
    }

    private boolean isAIOCameraFirstInitForbidFilter() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(AIO_CAMERA_FIRST_INIT_FORBID_FILTER, true);
        ms.a.a(TAG, "isAIOCameraFirstInitForbidFilter:" + isSwitchOn);
        return isSwitchOn;
    }

    private boolean isAIOCameraRecordForce720P() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(AIO_CAMERA_RECORD_FORCE_720P, false);
        ms.a.a(TAG, "isAIOCameraRecordForce720P:" + isSwitchOn);
        return isSwitchOn;
    }

    private boolean isDyStyleEnable() {
        return AEDashboardUtil.q();
    }

    private boolean isFromAIO() {
        if (getContext() instanceof Activity) {
            return gq.a.l(((Activity) getContext()).getIntent());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFromARCake() {
        if (getContext() instanceof Activity) {
            return gq.a.j(((Activity) getContext()).getIntent());
        }
        return false;
    }

    private boolean isFromCircle() {
        if (getContext() instanceof Activity) {
            return gq.a.r(((Activity) getContext()).getIntent());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFromFlashShow() {
        if (getContext() instanceof Activity) {
            return gq.a.v(((Activity) getContext()).getIntent());
        }
        return false;
    }

    private boolean isFromNonBlockingEntrance() {
        return (getContext() instanceof Activity) && StoryPublishLauncher.h(((Activity) getContext()).getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b()));
    }

    private boolean isFromSimpleCapture() {
        if (getContext() instanceof Activity) {
            return gq.a.F(((Activity) getContext()).getIntent());
        }
        return false;
    }

    private boolean isFrontCamera() {
        return this.selectedCamera == 1;
    }

    private boolean isRecordingGIF() {
        return this.isGIFMode && this.recordingEnabled && this.encodeConfig != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPause$1() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$0() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needLocation(VideoMaterial videoMaterial) {
        return videoMaterial.getLightAsset() != null && videoMaterial.getLightAsset().needRenderAbility(LightConstants.AssetFeatureKey.WATERMARK_NEED_LOCATION);
    }

    private void notifyDetectChange(boolean z16, boolean z17) {
        AEEffectListener aEEffectListener = this.effectListener;
        if (aEEffectListener != null) {
            aEEffectListener.onDetectStateChange(z16, z17);
        }
    }

    private void onAeGLSurfaceListener(SurfaceTexture surfaceTexture) {
        AEGLSurfaceListener aEGLSurfaceListener = this.aeGLSurfaceListener;
        if (aEGLSurfaceListener != null) {
            if (!this.isFirstNonFilter || (this.mFilterProcess instanceof com.tencent.aelight.camera.ae.camera.filter.b)) {
                aEGLSurfaceListener.onPreviewSurfaceTextureCreate(surfaceTexture);
            }
            if (this.isFirstNonFilter && (this.mFilterProcess instanceof AEFilterProcessTex)) {
                this.aeGLSurfaceListener.onBasicBeautyDownload();
            }
        }
    }

    private void preAction() {
        ms.a.f(TAG, "preAction");
        if (!isSdkInited) {
            initSdk();
        }
        AppInterface a16 = QQStoryContext.a();
        if (a16 != null) {
            this.superMethodPostSubThread = ((IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("ae_camera_gl_surface_view_post_sub_thread", true);
        }
        ms.a.f(TAG, "superMethodPostSubThread: " + this.superMethodPostSubThread);
    }

    private void preInflateInCircleCamera() {
        AEGLSurfaceListener aEGLSurfaceListener;
        if (this.firstFrameActionDone || !isFromCircle() || (aEGLSurfaceListener = this.aeGLSurfaceListener) == null) {
            return;
        }
        aEGLSurfaceListener.onFirstFrameDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MustRunOnGLThread
    public void prepareWMData(Map<String, String> map) {
        AEFilterManager P;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if ((filterProcessBase instanceof AEFilterProcessTex) && (P = ((AEFilterProcessTex) filterProcessBase).P()) != null) {
            ms.a.f(TAG, "prepareWMData: watermarkDict=" + map);
            P.wmAddInfoDict(map);
            String str = map.get("City");
            String str2 = map.get("Road");
            StringBuilder sb5 = new StringBuilder();
            if (str == null) {
                str = "";
            }
            sb5.append(str);
            if (str2 == null) {
                str2 = "";
            }
            sb5.append(str2);
            String sb6 = sb5.toString();
            ms.a.f(TAG, "[prepareWMData] location : " + sb6);
            if (!TextUtils.isEmpty(sb6)) {
                P.wmSetLocation(sb6);
            }
            String str3 = map.get("WeatherType");
            if (!TextUtils.isEmpty(str3)) {
                try {
                    P.wmSetWeatherCode(Integer.parseInt(str3));
                } catch (NumberFormatException e16) {
                    ms.a.e(TAG, e16);
                }
            }
            String str4 = map.get("Weather");
            if (str4 != null) {
                P.wmSetWeatherStr(str4);
            }
            String str5 = map.get("TempCurr");
            if (str5 != null) {
                P.wmSetTemperature(str5.replace(HardCodeUtil.qqStr(R.string.y9o), ""));
            }
        }
    }

    private void queueAEKitAction(final AEKitAction aEKitAction) {
        if (isAEKitAvailable()) {
            FilterProcessBase filterProcessBase = this.mFilterProcess;
            if (filterProcessBase instanceof AEFilterProcessTex) {
                final AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) filterProcessBase;
                queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AECameraGLSurfaceView.AEKitAction.this.run(aEFilterProcessTex);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recoverAudioCapture() {
        VideoMaterial videoMaterial = this.mLastVideoMaterial;
        if (videoMaterial == null || this.audioCapture == null || !videoMaterial.isAudio2textMaterial()) {
            return;
        }
        this.voiceRecognizer.c(getContext(), this.audioCapture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reqLocationPermissionAndReqWMDict() {
        ms.a.f(TAG, "reqLocationPermissionAndReqWMDict");
        new m((Activity) getContext(), new m.c() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.25
            @Override // com.tencent.aelight.camera.ae.flashshow.util.m.c
            public void onGetLocation() {
                ms.a.f(AECameraGLSurfaceView.TAG, "LocationPermissionHelper onGetLocation");
                AECameraGLSurfaceView.this.requestWMDict();
            }
        }).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestWMDict() {
        com.tencent.aelight.camera.ae.camera.ui.watermark.b.f().k(new b.c() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.26
            @Override // com.tencent.aelight.camera.ae.camera.ui.watermark.b.c
            public void onGetWatermarkDict(final Map<String, String> map) {
                AECameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.26.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AECameraGLSurfaceView.this.prepareWMData(map);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTipsHandler(AEFilterProcessTex aEFilterProcessTex) {
        AEEffectListener aEEffectListener = this.effectListener;
        if (aEEffectListener != null) {
            aEEffectListener.onSetFilterProcess(aEFilterProcessTex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.19
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QQToast.makeText(BaseApplication.getContext(), str, 0).show();
                } catch (Exception e16) {
                    ms.a.c(AECameraGLSurfaceView.TAG, "showToast exception:" + e16.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCaptureVideo() {
        ms.a.f(TAG, "startCaptureVideo---recordingEnabled=" + this.recordingEnabled);
        this.fpsReporter.f();
        String str = this.aeCaptureParam.f448260n + File.separator + System.currentTimeMillis() + ".mp4";
        int f16 = (!this.useVideoOrientation || this.isGIFMode) ? 0 : g.f(this.orientation);
        int[] videoSize = getVideoSize();
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(str, videoSize[0], videoSize[1], this.aeCaptureParam.f(), this.aeCaptureParam.g(), false, f16);
        this.encodeConfig = cVar;
        cVar.f312572q = this.aeCaptureParam.a();
        this.encodeConfig.f312573r = this.aeCaptureParam.d();
        AEVideoCaptureResult aEVideoCaptureResult = new AEVideoCaptureResult();
        this.videoCaptureResult = aEVideoCaptureResult;
        aEVideoCaptureResult.startTimeMs = System.currentTimeMillis();
        AEVideoCaptureResult aEVideoCaptureResult2 = this.videoCaptureResult;
        aEVideoCaptureResult2.orientation = this.orientation;
        aEVideoCaptureResult2.type = 0;
        this.recordingEnabled = true;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null) {
            filterProcessBase.p(this.recordingEnabled);
        }
        g.i(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCaptureTestVideo() {
        ms.a.f(TAG, "stopCaptureVideo---recordingEnabled=" + this.recordingEnabled + ", recordingStatus=" + this.mRecordingStatus + ", isPaused=" + this.isPaused);
        if (this.recordingTestEnabled) {
            this.recordingTestEnabled = false;
            if (this.mRecordingTestStatus != 0 && this.isPaused) {
                draw2TestMediaCodec(0, null, null);
            }
        }
    }

    private short[] toShortArray(byte[] bArr) {
        int length = bArr.length >> 1;
        short[] sArr = new short[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            sArr[i3] = (short) ((bArr[i16 + 1] << 8) | (bArr[i16] & 255));
        }
        return sArr;
    }

    private void updateMaterial(String str, int i3) {
        setMaterial(str, i3);
        this.mMaterialAlpha = i3;
        ms.a.f(TAG, ":metaData path:" + str + ",alpha:" + i3);
    }

    private void updateTipsView() {
        if (isAEKitAvailable()) {
            AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) this.mFilterProcess;
            if (aEFilterProcessTex.Y() && !aEFilterProcessTex.O() && !this.lastDetected) {
                int i3 = this.notDetectedTimes + 1;
                this.notDetectedTimes = i3;
                if (i3 >= 4) {
                    notifyDetectChange(aEFilterProcessTex.Y(), aEFilterProcessTex.O());
                    this.notDetectedTimes = 0;
                }
            }
            if (!this.lastDetected && aEFilterProcessTex.O()) {
                notifyDetectChange(aEFilterProcessTex.Y(), aEFilterProcessTex.O());
            }
            if (!aEFilterProcessTex.Y()) {
                notifyDetectChange(aEFilterProcessTex.Y(), aEFilterProcessTex.O());
            }
            if (this.lastDetected && aEFilterProcessTex.O()) {
                notifyDetectChange(aEFilterProcessTex.Y(), true);
            }
            this.lastDetected = aEFilterProcessTex.O();
        }
    }

    public boolean captureByCameraProxy() {
        if (isAEKitAvailable()) {
            return !((AEFilterProcessTex) this.mFilterProcess).U();
        }
        return true;
    }

    public void capturePhotoByAEKit(int i3) {
        if (i3 > 0) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.28
                @Override // java.lang.Runnable
                public void run() {
                    AECameraGLSurfaceView.this.capturePhotoByAEKit();
                }
            }, i3);
        } else {
            capturePhotoByAEKit();
        }
    }

    public void checkChangeCameraAndApplyMaterial(final VideoMaterial videoMaterial) {
        LightAsset lightAsset = videoMaterial.getLightAsset();
        if (lightAsset != null && this.effectListener != null && !this.mIsMaterialSame) {
            int defaultCameraPosition = lightAsset.getDefaultCameraPosition();
            ms.a.f(TAG, "checkChangeCameraAndApplyMaterial---cameraPosition=" + defaultCameraPosition);
            if (defaultCameraPosition == 1 && this.selectedCamera != 1) {
                this.effectListener.onRequestChangeCamera(1, new AECameraManager.CameraOpenCallback() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.21
                    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback
                    public void onOpenResult(int i3, boolean z16) {
                        AECameraGLSurfaceView.this.realQueueApplyMaterial(videoMaterial);
                    }
                });
                return;
            } else if (defaultCameraPosition == 2 && this.selectedCamera != 2) {
                this.effectListener.onRequestChangeCamera(2, new AECameraManager.CameraOpenCallback() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.22
                    @Override // com.tencent.aelight.camera.ae.camera.core.AECameraManager.CameraOpenCallback
                    public void onOpenResult(int i3, boolean z16) {
                        AECameraGLSurfaceView.this.realQueueApplyMaterial(videoMaterial);
                    }
                });
                return;
            }
        }
        realQueueApplyMaterial(videoMaterial);
    }

    protected void finishCaptureVideo(final AEVideoCaptureResult aEVideoCaptureResult) {
        if (this.captureListener != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.12
                @Override // java.lang.Runnable
                public void run() {
                    AECameraGLSurfaceView.this.captureListener.onVideoCaptured(aEVideoCaptureResult);
                }
            });
        }
        com.tencent.aelight.camera.aioeditor.b.q(this.selectedCamera != 1 ? 2 : 1);
    }

    public String getCaptureDir() {
        xp.a aVar = this.aeCaptureParam;
        if (aVar != null) {
            return aVar.f448260n;
        }
        return null;
    }

    public int getEffectOrientation() {
        return this.orientation;
    }

    public MediaFormat getMediaFormat() {
        e eVar = this.hwVideoRecorder;
        if (eVar != null) {
            return eVar.i();
        }
        return null;
    }

    public int getSelectedCamera() {
        return this.selectedCamera;
    }

    public int getSmoothLevel() {
        return this.smoothLevel;
    }

    public int getSurfaceHeight() {
        return this.mSurfaceHeight;
    }

    public int getSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    public boolean hasTapEffect() {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        return (filterProcessBase instanceof AEFilterProcessTex) && ((AEFilterProcessTex) filterProcessBase).P() != null && ((AEFilterProcessTex) this.mFilterProcess).P().currentMaterialNeedTouchTriggerEvent();
    }

    public boolean hasTouchEffect() {
        return hasTapEffect();
    }

    public void init(xp.a aVar, AudioCapture audioCapture, com.tencent.aelight.camera.ae.a aVar2) {
        if (this.aeCaptureParam != null) {
            throw new RuntimeException("init is already called");
        }
        if (aVar != null) {
            this.cameraConfig = aVar2;
            this.mCurrentRatio = AEVideoStoryTopBarViewModel.Ratio.fromCode(aVar2.p());
            ms.a.a(TAG, "adjustRatio :" + this.mCurrentRatio);
            this.aeCaptureParam = aVar;
            if (ms.a.g()) {
                ms.a.a(TAG, "setCaptureParam : " + aVar);
            }
            this.hwVideoRecorder = new e();
            this.audioCapture = audioCapture;
            this.mAudioChangeCapture = new yp.a(this.aeCaptureParam.f448260n, CodecParam.mAudioSampleRate, this);
            if (this.isNeedVoiceEncode && this.audioCapture != null) {
                this.audioCapture.J(true, this.aeCaptureParam.f448260n + File.separator + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION);
            }
            SensorManager sensorManager = (SensorManager) getContext().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.sensorManager = sensorManager;
            this.mAccelerometer = SensorMonitor.getDefaultSensor(sensorManager, 1);
            this.fpsReporter.c();
            this.isInit = true;
            return;
        }
        throw new IllegalArgumentException("param captureParam is null");
    }

    public boolean isBeautyEnable() {
        return this.beautyEnable;
    }

    public boolean isFaceEffectEnable() {
        return this.faceEffectEnable;
    }

    public boolean isFilterEnable() {
        return this.filterEnable;
    }

    public boolean isRecording() {
        return this.recordingEnabled;
    }

    public boolean isSharpFaceEnable() {
        return this.sharpFaceEnable;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        ms.a.f(TAG, "[onAttachedToWindow]" + toString());
        super.onAttachedToWindow();
        ms.a.f(TAG, "[onAttachedToWindow] end");
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioCaptured(String str) {
        if (this.isNeedVoiceEncode || this.mAudioChangeCapture.e()) {
            return;
        }
        ms.a.c(TAG, "onAudioCaptured---filePath=" + str);
        AEVideoCaptureResult aEVideoCaptureResult = this.videoCaptureResult;
        aEVideoCaptureResult.audioDataFilePath = str;
        if (aEVideoCaptureResult.videoMp4FilePath != null) {
            finishCaptureVideo(aEVideoCaptureResult);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioChangeCaptured(String str) {
        if (this.mAudioChangeCapture.e()) {
            ms.a.c(TAG, "onAudioChangeCaptured---filePath=" + str);
            AEVideoCaptureResult aEVideoCaptureResult = this.videoCaptureResult;
            aEVideoCaptureResult.audioDataFilePath = str;
            if (aEVideoCaptureResult.videoMp4FilePath != null) {
                finishCaptureVideo(aEVideoCaptureResult);
            }
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioError(int i3) {
        if (!this.isNeedVoiceEncode || this.mAudioChangeCapture.e() || this.videoCaptureResult == null) {
            return;
        }
        ms.a.c(TAG, "onAudioError---errorCode=" + i3);
        AEVideoCaptureResult aEVideoCaptureResult = this.videoCaptureResult;
        aEVideoCaptureResult.audioDataFilePath = "";
        if (aEVideoCaptureResult.videoMp4FilePath != null) {
            finishCaptureVideo(aEVideoCaptureResult);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioFrames(byte[] bArr, int i3, int i16) {
        double d16 = 0.0d;
        for (short s16 : toShortArray(bArr)) {
            d16 += s16 * s16;
        }
        double log10 = Math.log10(d16 / r0.length) * 10.0d;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase instanceof AEFilterProcessTex) {
            ((AEFilterProcessTex) filterProcessBase).Y0((float) log10);
        }
        this.mAudioChangeCapture.c(bArr, i3, i16);
        this.voiceRecognizer.b(bArr, i3, i16);
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioInit() {
        if (this.audioCapture != null) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.13
                @Override // java.lang.Runnable
                public void run() {
                    AECameraGLSurfaceView.this.recoverAudioCapture();
                }
            });
        }
    }

    public void onCameraPreviewSizeChanged(int i3, int i16) {
        int i17;
        int i18;
        ms.a.f(TAG, "onCameraPreviewSizeChanged---cameraWidth=" + i3 + ", cameraHeight=" + i16 + ", mSurfaceWidth=" + this.mSurfaceWidth + ", mSurfaceHeight=" + this.mSurfaceHeight);
        int i19 = this.mSurfaceWidth;
        int i26 = this.mSurfaceHeight;
        this.videoWidth = i3;
        this.videoHeight = (int) (((double) i3) / (((double) i19) / ((double) i26)));
        if (this.isGIFMode) {
            int[] b16 = g.b(i3, i16, i19, i26, 1.0f);
            int[] h16 = g.h(640, b16[0], b16[1]);
            i17 = h16[0];
            i18 = h16[1];
            this.gifPreviewWidth = i17;
            this.gifPreviewHeight = i18;
            this.videoWidth = i17;
            this.videoHeight = i18;
        } else {
            initVideoSize(i3, i16);
            i17 = i3;
            i18 = i16;
        }
        if (this.mFilterProcess != null) {
            int maxWidth = getMaxWidth();
            if (i17 > maxWidth) {
                i18 = (int) (((maxWidth * 1.0f) / i17) * i18);
                i17 = maxWidth;
            }
            this.mFilterProcess.v(this.mSurfaceWidth, this.mSurfaceHeight, i3, i16, i17, i18);
            this.mCameraHeight = i16;
            this.mCameraWidth = i3;
            this.mPreviewHeight = i18;
            this.mPreviewWidth = i17;
            ms.a.f(TAG, "onCameraPreviewSizeChanged:" + this.mSurfaceWidth + "," + this.mSurfaceHeight + "," + i3 + "," + i16 + ",previewWidth:" + i17 + ",previewHeight:" + i18);
            this.aeGLSurfaceListener.onPreviewSizeChanged(i17, i18, this.mSurfaceWidth, this.mSurfaceHeight);
            this.mFilterProcess.w(this.videoWidth, this.videoHeight);
        }
        collectDebugResolutionInfo(i3, i16);
    }

    public void onCameraPreviewStarted() {
        this.fpsReporter.a();
        this.isFirstFrame = true;
    }

    public void onChangeCamera(int i3) {
        this.selectedCamera = i3;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null) {
            filterProcessBase.d(false);
        }
        this.fpsReporter.h(isFrontCamera());
        VideoReport.setPageParams(getContext(), "ae_front_camera", Integer.valueOf(i3));
    }

    public void onDestroy() {
        ms.a.c(TAG, "[onDestroy]");
        if (ms.a.h()) {
            ms.a.a(TAG, "### onDestroy, hashCode=" + this.mIdentityHashCode + " ###");
        }
        disableOrientationListen();
        this.mIsTryLocationPermission = false;
        com.tencent.aelight.camera.aioeditor.shortvideo.b bVar = this.voiceRecognizer;
        if (bVar != null) {
            bVar.a();
        }
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null) {
            filterProcessBase.d(true);
        }
        this.fpsReporter.d();
        e eVar = this.hwVideoRecorder;
        if (eVar != null) {
            eVar.n();
        }
        e eVar2 = this.hwVideoTestRecorder;
        if (eVar2 != null) {
            eVar2.n();
        }
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.7
            @Override // java.lang.Runnable
            public void run() {
                if (AECameraGLSurfaceView.this.aeExpressionRecognizer != null) {
                    AECameraGLSurfaceView.this.aeExpressionRecognizer.c();
                    AECameraGLSurfaceView.this.aeExpressionRecognizer = null;
                }
                AECameraGLSurfaceView.this.destroyFilterProcess();
            }
        });
        ms.a.c(TAG, "[onDestroy] end");
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        ms.a.c(TAG, "[onDetachedFromWindow]" + toString());
        super.onDetachedFromWindow();
        ms.a.c(TAG, "[onDetachedFromWindow] end");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        String str;
        String str2;
        if (this.isPaused) {
            ms.a.a(TAG, "[onDrawFrame] return because isPaused");
            preInflateInCircleCamera();
            return;
        }
        boolean z16 = this.mHaveFrame;
        if (this.logTillHaveFrame) {
            this.drawFrameCount++;
            if (z16) {
                str2 = "onDrawFrameReal-begin";
            } else {
                str2 = "onDrawFrameFake-begin" + this.drawFrameCount;
            }
            tq.b.h().o(str2);
        }
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase == null) {
            ms.a.a(TAG, "[onDrawFrame] return because mFilterProcess == null");
            return;
        }
        if (!(filterProcessBase instanceof AEFilterProcessTex) && !isRecording()) {
            if (this.isAIOCameraFirstInitForbidFilter) {
                if (!isFromAIO()) {
                    ms.a.a(TAG, "[onDrawFrame] initFilterProcess");
                    initFilterProcess();
                }
            } else {
                ms.a.a(TAG, "[onDrawFrame] initFilterProcess");
                initFilterProcess();
            }
        }
        if (this.logTillHaveFrame) {
            tq.b.h().o("FilterProcessInitFilters-begin");
        }
        this.mFilterProcess.g();
        if (this.logTillHaveFrame) {
            tq.b.h().o("FilterProcessInitFilters-end");
        }
        int[] s16 = this.mFilterProcess.s(this.mSurfaceWidth, this.mSurfaceHeight, this.isGIFMode);
        long currentTimeMillis = System.currentTimeMillis();
        this.frameCount = this.frameCount + 1;
        if (currentTimeMillis - this.startTime > 1000) {
            this.startTime = currentTimeMillis;
            this.frameCount = 0;
            QLog.d(TAG, 4, "fps:" + (((int) ((r5 * (currentTimeMillis - r6)) / 10)) * 0.01f));
        }
        if (isAEKitAvailable()) {
            AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) this.mFilterProcess;
            AEGLSurfaceListener aEGLSurfaceListener = this.aeGLSurfaceListener;
            if (aEGLSurfaceListener != null) {
                aEGLSurfaceListener.onDrawFrameWithEffect(this.selectedCamera, aEFilterProcessTex.P());
            }
            recordGifFrames(s16[1]);
        }
        if (this.preExtractFrame && !this.isGIFMode) {
            this.mFilterProcess.a(s16[1]);
        }
        drawToMediaCodec(s16[1], null, null);
        draw2TestMediaCodec(s16[1], null, null);
        if (this.mOnFrameDrawCallback != null) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (AECameraGLSurfaceView.this.mOnFrameDrawCallback != null) {
                        AECameraGLSurfaceView.this.mOnFrameDrawCallback.run();
                    }
                }
            });
        }
        this.fpsReporter.onDrawFrame();
        if (!this.firstFrameActionDone) {
            this.firstFrameActionDone = true;
            AEBaseReportParam.U().t0();
            com.tencent.aelight.camera.ae.report.b.b().g1();
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.h(this.debugInfoCallback, 5000L);
            }
            AEGLSurfaceListener aEGLSurfaceListener2 = this.aeGLSurfaceListener;
            if (aEGLSurfaceListener2 != null) {
                aEGLSurfaceListener2.onFirstFrameDone();
            }
        }
        if (this.logTillHaveFrame) {
            if (z16) {
                str = "onDrawFrameReal-end";
            } else {
                str = "onDrawFrameFake-end" + this.drawFrameCount;
            }
            tq.b.h().o(str);
            if (z16) {
                this.logTillHaveFrame = false;
                com.tencent.aelight.camera.ae.report.b.b().C1(tq.b.h().f(), tq.b.h().k(), tq.b.h().j(), "aio", false);
            }
        }
        if (z16 && this.isFirstFrame) {
            this.isFirstFrame = false;
            CaptureListener captureListener = this.captureListener;
            if (captureListener != null) {
                captureListener.reportFirstFrameShown();
            }
            this.fpsReporter.onFirstFrame();
            tq.b.h().b();
        }
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onEncodeAudioCaptured(String str) {
        if (!this.isNeedVoiceEncode || this.mAudioChangeCapture.e()) {
            return;
        }
        ms.a.c(TAG, "onEncodeAudioCaptured---filePath=" + str);
        AEVideoCaptureResult aEVideoCaptureResult = this.videoCaptureResult;
        aEVideoCaptureResult.audioDataFilePath = str;
        if (aEVideoCaptureResult.videoMp4FilePath != null) {
            finishCaptureVideo(aEVideoCaptureResult);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeError(int i3, Throwable th5) {
        ms.a.d(TAG, "encode error, code: " + i3, th5);
        this.videoCaptureResult.errorCode = i3;
        if (this.captureListener != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.16
                @Override // java.lang.Runnable
                public void run() {
                    AECameraGLSurfaceView.this.captureListener.onCaptureError(104);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFinish(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onEncodeFinish filePath = " + str);
        }
        if (this.isPaused && isFromAIO()) {
            QLog.d(TAG, 2, "onEncodeFinish But is Paused = " + str);
            if (this.audioCapture != null) {
                if (this.mAudioChangeCapture.e()) {
                    this.mAudioChangeCapture.j();
                    this.audioCapture.O();
                }
                this.audioCapture.O();
                return;
            }
            return;
        }
        AEVideoCaptureResult aEVideoCaptureResult = this.videoCaptureResult;
        aEVideoCaptureResult.videoMp4FilePath = str;
        if (this.audioCapture != null) {
            if (aEVideoCaptureResult.audioDataFilePath != null) {
                finishCaptureVideo(aEVideoCaptureResult);
                return;
            }
            if (this.mAudioChangeCapture.e()) {
                this.mAudioChangeCapture.j();
                this.audioCapture.O();
            }
            this.audioCapture.O();
            return;
        }
        String str2 = this.aeCaptureParam.f448260n + "/noaudio";
        FileUtils.createFileIfNotExits(str2);
        AEVideoCaptureResult aEVideoCaptureResult2 = this.videoCaptureResult;
        aEVideoCaptureResult2.audioDataFilePath = str2;
        finishCaptureVideo(aEVideoCaptureResult2);
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFrame() {
        this.videoCaptureResult.videoFrameCount++;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeStart() {
        this.videoCaptureResult.videoFrameCount = 0;
        if (this.audioCapture != null) {
            if (this.mAudioChangeCapture.e()) {
                this.mAudioChangeCapture.d();
            }
            this.audioCapture.N();
        }
        if (this.captureListener != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.15
                @Override // java.lang.Runnable
                public void run() {
                    AECameraGLSurfaceView.this.captureListener.onVideoCaptureStart();
                }
            });
        }
    }

    protected void onMediaCodecStopRecord() {
        if (this.isGIFMode) {
            this.gifRecordStartTimestamp = 0L;
            this.gifRecordFrameIndex = 0L;
            QLog.d(TAG, 4, "onMediaCodecStopRecord");
            if (this.aeExpressionRecognizer != null) {
                QLog.d(TAG, 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
                this.aeExpressionRecognizer.i(this.recommendTextCallback);
                this.aeExpressionRecognizer.g();
                this.aeExpressionRecognizer.h();
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        ms.a.c(TAG, "[onPause] hashCode=" + this.mIdentityHashCode + " ###");
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.6
            @Override // java.lang.Runnable
            public void run() {
                if (AECameraGLSurfaceView.this.aeExpressionRecognizer != null) {
                    AECameraGLSurfaceView.this.aeExpressionRecognizer.c();
                    AECameraGLSurfaceView.this.aeExpressionRecognizer = null;
                }
                AECameraGLSurfaceView.this.destroyFilterProcess();
            }
        });
        this.sensorManager.unregisterListener(this);
        this.isPaused = true;
        disableOrientationListen();
        if (this.superMethodPostSubThread) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.c
                @Override // java.lang.Runnable
                public final void run() {
                    AECameraGLSurfaceView.this.lambda$onPause$1();
                }
            }, 16, null, false);
        } else {
            super.onPause();
        }
        ms.a.c(TAG, "[onPause] end");
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.c
    public void onPhotoCaptured(final Bitmap bitmap) {
        mq.a.d().j(IPrefRecorder.MILESTONE_CAMERA_SHOOT_JUMP_AIO);
        final long currentTimeMillis = System.currentTimeMillis();
        final String str = this.aeCaptureParam.f448260n + "/" + currentTimeMillis + ".jpg";
        final boolean isFromAIO = isFromAIO();
        if (isFromAIO) {
            com.tencent.aelight.camera.aioeditor.takevideo.g.a(currentTimeMillis, bitmap, this.aeCaptureParam.f448260n);
            finishCapturePhoto(new AEPhotoCaptureResult(0, 0, str, null, currentTimeMillis, this.orientation));
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.14
            /* JADX WARN: Removed duplicated region for block: B:10:0x0066  */
            /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                AECameraGLSurfaceView aECameraGLSurfaceView;
                AEPhotoCaptureResult aEPhotoCaptureResult;
                FileUtils.createFileIfNotExits(str);
                File file = new File(str);
                try {
                    try {
                        BaseImageUtil.saveBitmapFileAsJPEG(bitmap, file);
                        BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), file.getAbsolutePath());
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        if (!isFromAIO) {
                            aECameraGLSurfaceView = AECameraGLSurfaceView.this;
                            aEPhotoCaptureResult = new AEPhotoCaptureResult(0, -1, str, null, currentTimeMillis, aECameraGLSurfaceView.orientation);
                        } else {
                            com.tencent.aelight.camera.aioeditor.takevideo.g.h(currentTimeMillis, false);
                        }
                    }
                    if (!isFromAIO) {
                        aECameraGLSurfaceView = AECameraGLSurfaceView.this;
                        aEPhotoCaptureResult = new AEPhotoCaptureResult(0, 0, str, null, currentTimeMillis, aECameraGLSurfaceView.orientation);
                        aECameraGLSurfaceView.finishCapturePhoto(aEPhotoCaptureResult);
                        if (!isFromAIO) {
                            com.tencent.aelight.camera.aioeditor.takevideo.g.g(currentTimeMillis);
                            return;
                        } else {
                            bitmap.recycle();
                            return;
                        }
                    }
                    com.tencent.aelight.camera.aioeditor.takevideo.g.h(currentTimeMillis, true);
                    if (!isFromAIO) {
                    }
                } catch (Throwable th5) {
                    if (isFromAIO) {
                        com.tencent.aelight.camera.aioeditor.takevideo.g.h(currentTimeMillis, false);
                    } else {
                        AECameraGLSurfaceView aECameraGLSurfaceView2 = AECameraGLSurfaceView.this;
                        aECameraGLSurfaceView2.finishCapturePhoto(new AEPhotoCaptureResult(0, -1, str, null, currentTimeMillis, aECameraGLSurfaceView2.orientation));
                    }
                    throw th5;
                }
            }
        }, 64, null, false);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.superMethodPostSubThread) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.b
                @Override // java.lang.Runnable
                public final void run() {
                    AECameraGLSurfaceView.this.lambda$onResume$0();
                }
            }, 16, null, false);
        } else {
            super.onResume();
        }
        this.isPaused = false;
        this.isAIOCameraFirstInitForbidFilter = isAIOCameraFirstInitForbidFilter();
        if (ms.a.h()) {
            ms.a.a(TAG, "### onResume, hashCode=" + this.mIdentityHashCode + " ###");
        }
        this.recordingEnabled = false;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null) {
            filterProcessBase.p(this.recordingEnabled);
        }
        com.tencent.aelight.camera.ae.camera.util.a aVar = this.mOrientationEventListener;
        if (aVar != null && aVar.canDetectOrientation()) {
            this.mOrientationEventListener.enable();
        }
        if (this.mPendingReqLocationPermission) {
            this.mPendingReqLocationPermission = false;
            this.mIsTryLocationPermission = true;
            reqLocationPermissionAndReqWMDict();
        }
        SensorMonitor.registerListener(this.sensorManager, this, this.mAccelerometer, 3);
    }

    protected void onSelectFaceEffect(VideoMaterial videoMaterial) {
        AEEffectListener aEEffectListener;
        if (isFaceEffectEnable() && (aEEffectListener = this.effectListener) != null) {
            aEEffectListener.onSelectFaceEffect(videoMaterial);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(final SensorEvent sensorEvent) {
        if (this.mFilterProcess instanceof AEFilterProcessTex) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AECameraGLSurfaceView.this.mFilterProcess != null) {
                        ((AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess).E0(sensorEvent);
                    }
                }
            });
        }
    }

    public void onStartCaptureCover() {
        AEVideoCaptureResult aEVideoCaptureResult = this.videoCaptureResult;
        if (aEVideoCaptureResult != null) {
            aEVideoCaptureResult.arkCoverStartFrame = aEVideoCaptureResult.videoFrameCount;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        ms.a.f(TAG, "[onSurfaceChanged] + BEGIN, width = " + i3 + ", height = " + i16);
        tq.b.h().o("onSurfaceChanged-begin");
        this.mSurfaceWidth = i3;
        this.mSurfaceHeight = i16;
        if (this.mFilterProcess != null) {
            int[] previewSize = getPreviewSize(i3, i16);
            this.mFilterProcess.r(getRatio());
            this.mFilterProcess.v(this.mSurfaceWidth, this.mSurfaceHeight, 0, 0, previewSize[0], previewSize[1]);
        }
        tq.b.h().o("onSurfaceChanged-end");
        ms.a.f(TAG, "[onSurfaceChanged] + END, width = " + i3 + ", height = " + i16);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        ms.a.f(TAG, "[onSurfaceCreated] + BEGIN");
        tq.b.h().o("onSurfaceCreated-begin");
        initFilterProcess();
        tq.b.h().o("onSurfaceCreated-end");
        ms.a.f(TAG, "[onSurfaceCreated] + END");
    }

    public void openAndUpdateBasicLips(final String str, final int i3, final int i16) {
        if (isBeautyEnable()) {
            queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.37
                @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
                public void run(AEFilterProcessTex aEFilterProcessTex) {
                    aEFilterProcessTex.b0(str, i3, i16);
                }
            });
        }
    }

    public void openAndUpdateBasicMultiply(final String str, final int i3) {
        if (isBeautyEnable()) {
            queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.35
                @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
                public void run(AEFilterProcessTex aEFilterProcessTex) {
                    aEFilterProcessTex.c0(str, i3);
                }
            });
        }
    }

    public void openAndUpdateBasicSoftLight(final String str, final int i3) {
        if (isBeautyEnable()) {
            queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.38
                @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
                public void run(AEFilterProcessTex aEFilterProcessTex) {
                    aEFilterProcessTex.d0(str, i3);
                }
            });
        }
    }

    public void openBeautyEnable(final boolean z16) {
        if (isBeautyEnable()) {
            queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.36
                @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
                public void run(AEFilterProcessTex aEFilterProcessTex) {
                    aEFilterProcessTex.e0(z16);
                }
            });
        }
    }

    public void openFaceThinEnable(final String str) {
        if (isBeautyEnable()) {
            queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.39
                @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
                public void run(AEFilterProcessTex aEFilterProcessTex) {
                    aEFilterProcessTex.f0(str);
                }
            });
        }
    }

    public void realQueueApplyMaterial(final VideoMaterial videoMaterial) {
        String str = this.mLastForceMaterialPath;
        final boolean z16 = str != null && str.equals(videoMaterial.getDataPath());
        this.mLastForceMaterialPath = null;
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.23
            @Override // java.lang.Runnable
            public void run() {
                ms.a.c(AECameraGLSurfaceView.TAG, "[setVideoMaterial] update material: " + videoMaterial.getId());
                if (AECameraGLSurfaceView.this.mFilterProcess instanceof AEFilterProcessTex) {
                    ((AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess).L0(videoMaterial, z16);
                }
            }
        });
        if (this.mMaterialAlpha >= 0) {
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.24
                @Override // java.lang.Runnable
                public void run() {
                    AECameraGLSurfaceView aECameraGLSurfaceView = AECameraGLSurfaceView.this;
                    aECameraGLSurfaceView.updateFenGeAlpha(aECameraGLSurfaceView.mMaterialAlpha);
                }
            }, 100L);
        }
    }

    public void recoveryMaterial() {
        if (TextUtils.isEmpty(this.mMaterialPath)) {
            return;
        }
        setLastForceMaterialPath(this.mMaterialPath);
        updateMaterial(this.mMaterialPath, this.mMaterialAlpha);
    }

    public void resetMaterialWhenRecord() {
        if (isAEKitAvailable() && this.mFilterProcess != null) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.27
                @Override // java.lang.Runnable
                public void run() {
                    AECameraGLSurfaceView.this.mFilterProcess.m();
                }
            });
        }
    }

    public void setAECaptureController(com.tencent.aelight.camera.ae.camera.ui.c cVar) {
        this.mController = cVar;
    }

    public void setAEKitInitListener(AEKitInitListener aEKitInitListener) {
        this.mAEKitInitListener = aEKitInitListener;
    }

    public void setAeEditMaterialSelectedListener(AEBottomListScrollView.a aVar) {
        this.aeEditMaterialSelectedListener = aVar;
    }

    public void setAeGLSurfaceListener(AEGLSurfaceListener aEGLSurfaceListener) {
        this.aeGLSurfaceListener = aEGLSurfaceListener;
    }

    public void setAiBeautyFaceListener(AEFilterProcessTex.d dVar) {
        this.aiBeautyFaceListener = dVar;
    }

    public void setAudioPause() {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase instanceof AEFilterProcessTex) {
            ((AEFilterProcessTex) filterProcessBase).p0();
        }
    }

    public void setAudioStart() {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase instanceof AEFilterProcessTex) {
            ((AEFilterProcessTex) filterProcessBase).q0();
        }
    }

    public void setBeautyEnable(boolean z16) {
        this.beautyEnable = z16;
    }

    public void setBeautyLevel(final int i3) {
        if (isAEKitAvailable() && isBeautyEnable()) {
            this.smoothLevel = i3;
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.32
                @Override // java.lang.Runnable
                public void run() {
                    AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess;
                    if (aEFilterProcessTex != null) {
                        aEFilterProcessTex.H0(i3);
                    }
                }
            });
            return;
        }
        ms.a.f(TAG, "[setBeautyLevel] level = " + i3 + ", isAEKitAvailable is false");
    }

    public void setBeautyOrTransformLevel(final BeautyRealConfig.TYPE type, final int i3) {
        if (isBeautyEnable()) {
            queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.34
                @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
                public void run(AEFilterProcessTex aEFilterProcessTex) {
                    aEFilterProcessTex.r0(type, i3);
                }
            });
        }
    }

    public void setBundlePath(final String str, final String str2) {
        if (this.mFilterProcess instanceof AEFilterProcessTex) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AECameraGLSurfaceView.this.mFilterProcess instanceof AEFilterProcessTex) {
                        ((AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess).P().setLightBundle(str, str2);
                    }
                }
            });
        }
    }

    public void setCaptureListener(CaptureListener captureListener) {
        this.captureListener = captureListener;
    }

    public void setCaptureRequest(ExtractFrameRequest extractFrameRequest) {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null) {
            filterProcessBase.o(extractFrameRequest);
        }
    }

    public void setCurrentRatio(AEVideoStoryTopBarViewModel.Ratio ratio) {
        this.mCurrentRatio = ratio;
    }

    public void setCustomMaterial(String str, String str2) {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase instanceof AEFilterProcessTex) {
            ((AEFilterProcessTex) filterProcessBase).s0(str, str2);
        }
    }

    public void setDynamicResolutionMode(boolean z16) {
        this.isDynamicResolutionMode = z16;
    }

    public void setFaceEffectEnable(boolean z16) {
        this.faceEffectEnable = z16;
    }

    public void setFaceEffectListener(AEEffectListener aEEffectListener) {
        this.effectListener = aEEffectListener;
    }

    public void setFilter(FilterCategoryItem filterCategoryItem) {
        FilterDesc b16;
        if (isAEKitAvailable() && isFilterEnable()) {
            AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) this.mFilterProcess;
            if (filterCategoryItem == null || (b16 = filterCategoryItem.b()) == null) {
                return;
            }
            String filterResPath = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
            if (!TextUtils.isEmpty(b16.resRootPath)) {
                filterResPath = b16.resRootPath;
            }
            String resFold = b16.getResFold(filterResPath);
            QQPtColorFilterInfo colorFilterInfo = QQPtColorFilter.getColorFilterInfo(resFold);
            if (colorFilterInfo != null) {
                String str = resFold + colorFilterInfo.getColorPng();
                if (new File(str).exists()) {
                    aEFilterProcessTex.V0(str);
                }
            }
        }
    }

    public void setFilterEnable(boolean z16) {
        this.filterEnable = z16;
    }

    public void setGenderTypeListener(AEGenderTypeListener aEGenderTypeListener) {
        this.genderTypeListener = aEGenderTypeListener;
    }

    public void setIsGIFMode(boolean z16) {
        this.fpsReporter.b(z16);
        this.isGIFMode = z16;
    }

    public void setIsVoiceNeedEncode(boolean z16) {
        this.isNeedVoiceEncode = z16;
    }

    public void setLastForceMaterialPath(String str) {
        this.mLastForceMaterialPath = str;
    }

    public void setLightNodePresetData(final String str, final String str2) {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.45
            @Override // java.lang.Runnable
            public void run() {
                if (AECameraGLSurfaceView.this.mFilterProcess instanceof AEFilterProcessTex) {
                    ((AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess).A0(str, str2);
                }
            }
        });
    }

    public void setMaterial(String str) {
        setMaterial(str, 100);
    }

    public void setPauseFilterChainWhenCapture(boolean z16) {
        this.pauseFilterChainWhenCapture = z16;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase == null || !(filterProcessBase instanceof AEFilterProcessTex)) {
            return;
        }
        ((AEFilterProcessTex) filterProcessBase).D0(z16);
    }

    public void setPreExtractFrame(boolean z16) {
        this.preExtractFrame = z16;
    }

    public void setRecommendTextCallback(a.b bVar) {
        this.recommendTextCallback = bVar;
    }

    public void setSharpFaceEnable(boolean z16) {
        this.sharpFaceEnable = z16;
    }

    public void setSharpFaceLevel(final int i3) {
        if (isAEKitAvailable() && isSharpFaceEnable()) {
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.33
                @Override // java.lang.Runnable
                public void run() {
                    AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess;
                    if (aEFilterProcessTex != null) {
                        aEFilterProcessTex.F0(i3);
                    }
                }
            });
        }
    }

    public void setStickerInnerLutFilterListener(AEFilterManager.MaterialInnerEffectListener materialInnerEffectListener) {
        this.stickerInnerLutFilterListener = materialInnerEffectListener;
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase == null || !(filterProcessBase instanceof AEFilterProcessTex)) {
            return;
        }
        ((AEFilterProcessTex) filterProcessBase).B0(materialInnerEffectListener);
    }

    public void setTapEvent(int i3, float f16, float f17) {
        queueEvent(new TapRunnable(i3, f16 / this.mSurfaceWidth, f17 / this.mSurfaceHeight));
    }

    public void setUseVideoOrientation(boolean z16) {
        this.useVideoOrientation = z16;
    }

    public void startCaptureTestVideo() {
        ms.a.f(TAG, "startCaptureVideo---recordingEnabled=" + this.recordingTestEnabled);
        int[] f16 = this.mFilterProcess.f();
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c("/sdcard/testVideoFilter.mp4", f16[0], f16[1], this.aeCaptureParam.f(), this.aeCaptureParam.g(), false, 0);
        this.encodeTestConfig = cVar;
        cVar.f312572q = this.aeCaptureParam.a();
        this.encodeTestConfig.f312573r = this.aeCaptureParam.d();
        this.recordingTestEnabled = true;
    }

    public void startCaptureVideoInGLThread() {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.29
            @Override // java.lang.Runnable
            public void run() {
                if (AECameraGLSurfaceView.this.mFilterProcess != null) {
                    AECameraGLSurfaceView.this.mFilterProcess.m();
                }
                AECameraGLSurfaceView.this.startCaptureVideo();
            }
        });
    }

    public void stopCaptureVideo() {
        ms.a.f(TAG, "stopCaptureVideo---recordingEnabled=" + this.recordingEnabled + ", recordingStatus=" + this.mRecordingStatus + ", isPaused=" + this.isPaused);
        if (this.recordingEnabled) {
            this.recordingEnabled = false;
            this.hasRecorded = true;
            FilterProcessBase filterProcessBase = this.mFilterProcess;
            if (filterProcessBase != null) {
                filterProcessBase.p(this.recordingEnabled);
            }
            if (this.mRecordingStatus == 0) {
                CaptureListener captureListener = this.captureListener;
                if (captureListener != null) {
                    captureListener.onCaptureError(102);
                    return;
                }
                return;
            }
            if (this.isPaused) {
                drawToMediaCodecForPause(0, null, null);
                if (this.captureListener == null || !isFromAIO()) {
                    return;
                }
                this.hwVideoRecorder.s();
                onMediaCodecStopRecord();
                this.mRecordingStatus = 0;
                this.captureListener.onCaptureError(105);
            }
        }
    }

    public void stopCaptureVideoInGLThread() {
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.30
            @Override // java.lang.Runnable
            public void run() {
                AECameraGLSurfaceView.this.stopCaptureVideo();
            }
        });
    }

    public void switchAIBeauty(boolean z16) {
        if (isAEKitAvailable()) {
            ((AEFilterProcessTex) this.mFilterProcess).N0(z16);
        }
    }

    public void switchSegment(boolean z16) {
        if (isAEKitAvailable()) {
            ((AEFilterProcessTex) this.mFilterProcess).O0(z16);
        }
    }

    public void switchSegmentFollowFace(boolean z16) {
        if (isAEKitAvailable()) {
            ((AEFilterProcessTex) this.mFilterProcess).P0(z16);
        }
    }

    public void updateCameraDeviceConfig(float f16, int i3) {
        if (this.mFilterProcess instanceof AEFilterProcessTex) {
            final DeviceCameraConfig deviceCameraConfig = new DeviceCameraConfig();
            deviceCameraConfig.cameraHorizontalFov = f16;
            deviceCameraConfig.cameraIndex = i3;
            queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AECameraGLSurfaceView.this.mFilterProcess != null) {
                        ((AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess).S0(deviceCameraConfig);
                    }
                }
            });
        }
    }

    public void updateFenGeAlpha(final int i3) {
        this.mMaterialAlpha = i3;
        queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.41
            @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
            public void run(AEFilterProcessTex aEFilterProcessTex) {
                aEFilterProcessTex.T0(i3);
            }
        });
    }

    public void updateLutAlpha(final float f16) {
        queueAEKitAction(new AEKitAction() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.40
            @Override // com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.AEKitAction
            public void run(AEFilterProcessTex aEFilterProcessTex) {
                aEFilterProcessTex.U0(f16);
            }
        });
    }

    public void updateTouchEvent(MotionEvent motionEvent) {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase instanceof AEFilterProcessTex) {
            ((AEFilterProcessTex) filterProcessBase).X0(motionEvent, getWidth(), getHeight());
        }
    }

    private int[] getPreviewSize(int i3, int i16) {
        int[] iArr = {i3, i16};
        if (this.isGIFMode) {
            int[] b16 = g.b(i3, i16, this.mSurfaceWidth, this.mSurfaceHeight, 1.0f);
            return g.h(640, b16[0], b16[1]);
        }
        int maxWidth = getMaxWidth();
        if (i16 > maxWidth) {
            i16 = (int) (((maxWidth * 1.0f) / i3) * i16);
            i3 = maxWidth;
        }
        iArr[0] = i3;
        iArr[1] = i16;
        return iArr;
    }

    private void initEGL() {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        setEGLContextFactory(new GLSurfaceView.EGLContextFactory() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.5
            @Override // android.opengl.GLSurfaceView.EGLContextFactory
            public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
                ms.a.c(AECameraGLSurfaceView.TAG, "[EGLContext] destroyContext start");
                if (eGLDisplay == null) {
                    ms.a.c(AECameraGLSurfaceView.TAG, "EGLDisplay is null.");
                }
                egl10.eglDestroyContext(eGLDisplay, eGLContext);
                ms.a.c(AECameraGLSurfaceView.TAG, "[EGLContext] destroyContext finish");
            }

            private EGLContext createEGLContextSafely(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i3) {
                int[] iArr = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, i3, 12344};
                if (eGLContext == null) {
                    eGLContext = EGL10.EGL_NO_CONTEXT;
                }
                try {
                    return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
                } catch (Exception e16) {
                    ms.a.d(AECameraGLSurfaceView.TAG, "create egl context fail with eglVersion = " + i3 + " shareContext = " + eGLContext, e16);
                    return EGL10.EGL_NO_CONTEXT;
                }
            }

            @Override // android.opengl.GLSurfaceView.EGLContextFactory
            public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
                EGLContext createEGLContextSafely = createEGLContextSafely(egl10, eGLDisplay, eGLConfig, null, 3);
                if (createEGLContextSafely == null || createEGLContextSafely == EGL10.EGL_NO_CONTEXT) {
                    createEGLContextSafely = createEGLContextSafely(egl10, eGLDisplay, eGLConfig, null, 2);
                }
                int[] iArr = new int[1];
                egl10.eglQueryContext(eGLDisplay, createEGLContextSafely, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr);
                if (QLog.isColorLevel()) {
                    QLog.d(AECameraGLSurfaceView.TAG, 2, "[EGLContext] createContext, client version " + iArr[0]);
                }
                AECameraGLSurfaceView.this.eglContextVersion = iArr[0];
                ms.a.c(AECameraGLSurfaceView.TAG, "[EGLContext] createContext finish");
                return createEGLContextSafely;
            }
        });
        setPreserveEGLContextOnPause(false);
        setRenderer(this);
        setRenderMode(0);
        preAction();
    }

    void frameToMediaCodecVideo(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        if (this.recordingEnabled && this.encodeConfig != null) {
            int i17 = this.mRecordingStatus;
            if (i17 == 0) {
                if (this.audioCapture != null && (getContext() instanceof Activity)) {
                    this.audioCapture.B((Activity) getContext());
                }
                this.encodeConfig.d(EGL14.eglGetCurrentContext());
                if (aq.d.f26717a.g()) {
                    ms.a.f(TAG, "useEGLContextVersion---Build.MODEL=" + DeviceInfoMonitor.getModel());
                    this.encodeConfig.c(this.eglContextVersion);
                }
                this.hwVideoRecorder.o();
                this.hwVideoRecorder.q(this.encodeConfig, this);
                this.mRecordingStatus = 1;
            } else if (i17 != 1) {
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
            this.hwVideoRecorder.h(i3, i16, fArr, fArr2, j3);
            return;
        }
        int i18 = this.mRecordingStatus;
        if (i18 != 0) {
            if (i18 == 1) {
                this.hwVideoRecorder.s();
                onMediaCodecStopRecord();
                this.mRecordingStatus = 0;
            } else {
                throw new RuntimeException("unknown status " + this.mRecordingStatus);
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mHaveFrame = true;
        if (!this.onFrameAvailableLogged) {
            this.onFrameAvailableLogged = true;
            tq.b.h().o("onFrameAvailable");
        }
        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AECameraGLSurfaceView.this.mFilterProcess != null) {
                    AECameraGLSurfaceView.this.mFilterProcess.t();
                }
            }
        });
        requestRender();
    }

    public void setMaterial(final String str, final int i3) {
        ms.a.f(TAG, "[setMaterial] in set materialPath:" + str);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20
            /* JADX WARN: Removed duplicated region for block: B:111:0x03cd  */
            /* JADX WARN: Removed duplicated region for block: B:120:0x03fa  */
            /* JADX WARN: Removed duplicated region for block: B:128:0x0439  */
            /* JADX WARN: Removed duplicated region for block: B:131:0x0446  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                AudioCapture audioCapture;
                AudioCapture audioCapture2;
                if (Looper.myLooper() == null) {
                    ms.a.c(AECameraGLSurfaceView.TAG, "[setMaterial] Looper.myLooper() == null");
                    Looper.prepare();
                }
                ms.a.f(AECameraGLSurfaceView.TAG, "[setMaterial] 2 in set materialPath:" + str);
                AECameraGLSurfaceView aECameraGLSurfaceView = AECameraGLSurfaceView.this;
                aECameraGLSurfaceView.mIsMaterialSame = !TextUtils.isEmpty(aECameraGLSurfaceView.mMaterialPath) && !TextUtils.isEmpty(str) && AECameraGLSurfaceView.this.mMaterialPath.equals(str) && AECameraGLSurfaceView.this.mLastMateralApplySuccess;
                AECameraGLSurfaceView.this.mMaterialPath = str;
                AEEffectListener aEEffectListener = AECameraGLSurfaceView.this.effectListener;
                if (aEEffectListener != null) {
                    aEEffectListener.onHidePagTip();
                    AECameraGLSurfaceView.this.effectListener.onHideNormalTip();
                }
                if (!AECameraGLSurfaceView.this.isRecording() && AECameraGLSurfaceView.this.isAEKitAvailable()) {
                    String str2 = str;
                    final AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) AECameraGLSurfaceView.this.mFilterProcess;
                    if (TextUtils.isEmpty(str2)) {
                        if (aEFilterProcessTex != null && aEFilterProcessTex.S() != null) {
                            AEResUtil.g(AEResUtil.F(aEFilterProcessTex.S()), false);
                        }
                        AECameraGLSurfaceView.this.fpsReporter.g(null);
                        if (aEFilterProcessTex != null) {
                            aEFilterProcessTex.U = true;
                        }
                        AECameraGLSurfaceView.this.onSelectFaceEffect(null);
                        AECameraGLSurfaceView.this.needFace = false;
                        AECameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AEFilterProcessTex aEFilterProcessTex2 = aEFilterProcessTex;
                                if (aEFilterProcessTex2 != null) {
                                    aEFilterProcessTex2.K0(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
                                }
                            }
                        });
                        AECameraGLSurfaceView.this.setTipsHandler(aEFilterProcessTex);
                        AECameraGLSurfaceView.this.voiceRecognizer.a();
                        AECameraGLSurfaceView.this.mLastVideoMaterial = null;
                        ms.a.c(AECameraGLSurfaceView.TAG, "[setMaterial] materialPath:" + str2);
                        AECameraGLSurfaceView.this.mLastMateralApplySuccess = false;
                        return;
                    }
                    if (!new File(str2).exists()) {
                        str2 = str2 + "Android";
                    }
                    if (!new File(str2).exists()) {
                        AECameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aEFilterProcessTex.K0(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
                            }
                        });
                        ms.a.c(AECameraGLSurfaceView.TAG, "[setMaterial] materialPath not exist");
                        AECameraGLSurfaceView.this.mLastMateralApplySuccess = false;
                        return;
                    }
                    AECameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20.3
                        @Override // java.lang.Runnable
                        public void run() {
                            aEFilterProcessTex.A0(LightConstants.BeautyConfigKey.MAKE_UP_DEFAULT_STRENGTH, Double.toString((i3 * 1.0d) / 100.0d));
                        }
                    });
                    VideoMaterial loadLightAsset = VideoMaterial.loadLightAsset(str);
                    if (loadLightAsset != null) {
                        ms.a.f(AECameraGLSurfaceView.TAG, "lightSDK material," + loadLightAsset.getId() + "," + str);
                    }
                    if (loadLightAsset == null) {
                        AECameraGLSurfaceView.this.showToast(HardCodeUtil.qqStr(R.string.f169890y53));
                        AECameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20.4
                            @Override // java.lang.Runnable
                            public void run() {
                                aEFilterProcessTex.K0(VideoMaterial.loadLightAsset(LightNode.getEmptyMaterialPath()));
                            }
                        });
                        ms.a.c(AECameraGLSurfaceView.TAG, "[setMaterial] videoMaterial null");
                        AECameraGLSurfaceView.this.mLastMateralApplySuccess = false;
                        return;
                    }
                    AECameraGLSurfaceView.this.fpsReporter.g(loadLightAsset);
                    if (AEMaterialManager.U(loadLightAsset)) {
                        ms.a.a("PreCheckAERes", "[setMaterial] set special template");
                        if (AEResUtil.U(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
                            ms.a.a("PreCheckAERes", "[setMaterial] version check success");
                            ms.a.a("PreCheckAERes", "[setMaterial] peakLoadStatus = " + d.t());
                            if (d.f(loadLightAsset)) {
                                ms.a.a("PreCheckAERes", "[setMaterial] so load success");
                                List<String> D = AEResUtil.D(loadLightAsset);
                                if ((D == null || D.isEmpty()) ? false : true) {
                                    AEResUtil.g(D, true);
                                    ms.a.f(AECameraGLSurfaceView.TAG, "[setMaterial] need download extra bundles");
                                    AECameraGLSurfaceView.this.mLastMateralApplySuccess = false;
                                    return;
                                }
                            } else {
                                ms.a.c("PreCheckAERes", "[setMaterial] so load failed");
                            }
                        } else {
                            ms.a.c("PreCheckAERes", "[setMaterial] version check failed");
                        }
                    } else {
                        ms.a.f(AECameraGLSurfaceView.TAG, "not special material.");
                    }
                    if (loadLightAsset.isWatermarkMaterial() && AECameraGLSurfaceView.this.needLocation(loadLightAsset) && !AECameraGLSurfaceView.this.isFromARCake()) {
                        if (!AECameraGLSurfaceView.this.mIsTryLocationPermission) {
                            if (AECameraGLSurfaceView.this.isPaused) {
                                AECameraGLSurfaceView.this.mPendingReqLocationPermission = true;
                                ms.a.f(AECameraGLSurfaceView.TAG, "updateWMProps requestLocationPermission true, but is paused, skip");
                            } else {
                                AECameraGLSurfaceView.this.mPendingReqLocationPermission = false;
                                AECameraGLSurfaceView.this.mIsTryLocationPermission = true;
                                ms.a.f(AECameraGLSurfaceView.TAG, "updateWMProps requestLocationPermission true");
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AECameraGLSurfaceView.this.reqLocationPermissionAndReqWMDict();
                                    }
                                });
                            }
                        } else if (AECameraGLSurfaceView.this.checkLocationPermissionGranted()) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    AECameraGLSurfaceView.this.requestWMDict();
                                }
                            });
                        }
                    }
                    AEMaterialMetaData J = AEMaterialManager.J();
                    if (J != null) {
                        boolean isEditableWatermark = loadLightAsset.isEditableWatermark();
                        J.editablewatermark = isEditableWatermark;
                        ms.a.f(AECameraGLSurfaceView.TAG, "editable id: " + J.f69050id + " enable: " + isEditableWatermark);
                    }
                    if (AEMaterialManager.H() != null) {
                        AEMaterialMetaData H = AEMaterialManager.H();
                        boolean isEditableWatermark2 = loadLightAsset.isEditableWatermark();
                        H.editablewatermark = isEditableWatermark2;
                        if (AECameraGLSurfaceView.this.aeEditMaterialSelectedListener != null) {
                            ms.a.f(AECameraGLSurfaceView.TAG, "editable id: " + H.f69050id + " enable: " + isEditableWatermark2);
                            AECameraGLSurfaceView.this.aeEditMaterialSelectedListener.f(isEditableWatermark2);
                        }
                    }
                    if (AECameraGLSurfaceView.this.mAudioChangeCapture != null && loadLightAsset.getLightAsset() != null) {
                        AECameraGLSurfaceView aECameraGLSurfaceView2 = AECameraGLSurfaceView.this;
                        if (aECameraGLSurfaceView2.audioCapture != null) {
                            aECameraGLSurfaceView2.mAudioChangeCapture.i(loadLightAsset.needVoiceChange(), loadLightAsset.getLightAsset().getVoiceKind(), loadLightAsset.getLightAsset().getVoiceEnvironment());
                            if (!AECameraGLSurfaceView.this.isNeedVoiceEncode || loadLightAsset.needVoiceChange()) {
                                if (AECameraGLSurfaceView.this.isNeedVoiceEncode && loadLightAsset.needVoiceChange()) {
                                    String str3 = AECameraGLSurfaceView.this.aeCaptureParam.f448260n + File.separator + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION;
                                    AECameraGLSurfaceView.this.audioCapture.J(false, null);
                                    AECameraGLSurfaceView.this.mAudioChangeCapture.h(true, str3);
                                } else {
                                    AECameraGLSurfaceView.this.mAudioChangeCapture.h(false, null);
                                }
                            } else {
                                AECameraGLSurfaceView.this.audioCapture.J(true, AECameraGLSurfaceView.this.aeCaptureParam.f448260n + File.separator + System.currentTimeMillis() + DefaultHlsExtractorFactory.AAC_FILE_EXTENSION);
                                AECameraGLSurfaceView.this.mAudioChangeCapture.h(false, null);
                            }
                        }
                    }
                    if (loadLightAsset.isAudio2textMaterial()) {
                        AECameraGLSurfaceView aECameraGLSurfaceView3 = AECameraGLSurfaceView.this;
                        if (aECameraGLSurfaceView3.audioCapture != null) {
                            aECameraGLSurfaceView3.voiceRecognizer.c(AECameraGLSurfaceView.this.getContext(), AECameraGLSurfaceView.this.audioCapture);
                            z16 = loadLightAsset.getLightAsset() == null && loadLightAsset.getLightAsset().needVoiceDecibel();
                            audioCapture = AECameraGLSurfaceView.this.audioCapture;
                            if (audioCapture != null) {
                                audioCapture.K(z16);
                            }
                            if (z16 && !loadLightAsset.isAudio2textMaterial() && (audioCapture2 = AECameraGLSurfaceView.this.audioCapture) != null) {
                                audioCapture2.D();
                            }
                            AECameraGLSurfaceView.this.needFace = loadLightAsset.needFaceInfo();
                            AECameraGLSurfaceView.this.onSelectFaceEffect(loadLightAsset);
                            AECameraGLSurfaceView.this.setTipsHandler(aEFilterProcessTex);
                            if (loadLightAsset.isEditableWatermark()) {
                                if (AECameraGLSurfaceView.this.mLastVideoMaterial != null && AECameraGLSurfaceView.this.mLastVideoMaterial.getId().equals(loadLightAsset.getId())) {
                                    r3 = false;
                                }
                                ms.a.f(AECameraGLSurfaceView.TAG, "[setMaterial] isWatermarkEditable case, applyMaterial=" + r3);
                            }
                            AECameraGLSurfaceView.this.mLastMateralApplySuccess = r3;
                            AECameraGLSurfaceView.this.mLastVideoMaterial = loadLightAsset;
                            if (r3) {
                                AECameraGLSurfaceView.this.checkChangeCameraAndApplyMaterial(loadLightAsset);
                            }
                            if (AECameraGLSurfaceView.this.isFromARCake()) {
                                AECameraGLSurfaceView.this.queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.20.7
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        String l3 = AEARCakeMaterialManager.i().l();
                                        aEFilterProcessTex.M0(l3);
                                        ms.a.f(AECameraGLSurfaceView.TAG, "apply ar cake watermark text: " + l3);
                                    }
                                });
                            }
                            if (AEDashboardUtil.x() || TextUtils.isEmpty(str)) {
                                return;
                            }
                            AEDashboardUtil.h(AECameraGLSurfaceView.this.debugInfoCallback, 1500L);
                            return;
                        }
                    }
                    AECameraGLSurfaceView.this.voiceRecognizer.a();
                    if (loadLightAsset.getLightAsset() == null) {
                    }
                    audioCapture = AECameraGLSurfaceView.this.audioCapture;
                    if (audioCapture != null) {
                    }
                    if (z16) {
                        audioCapture2.D();
                    }
                    AECameraGLSurfaceView.this.needFace = loadLightAsset.needFaceInfo();
                    AECameraGLSurfaceView.this.onSelectFaceEffect(loadLightAsset);
                    AECameraGLSurfaceView.this.setTipsHandler(aEFilterProcessTex);
                    if (loadLightAsset.isEditableWatermark()) {
                    }
                    AECameraGLSurfaceView.this.mLastMateralApplySuccess = r3;
                    AECameraGLSurfaceView.this.mLastVideoMaterial = loadLightAsset;
                    if (r3) {
                    }
                    if (AECameraGLSurfaceView.this.isFromARCake()) {
                    }
                    if (AEDashboardUtil.x()) {
                        return;
                    } else {
                        return;
                    }
                }
                r3 = d.n() ? true : d.u();
                if (AECameraGLSurfaceView.this.isPaused && r3) {
                    AEFilterProcessTex.x0(AECameraGLSurfaceView.this.mIdentityHashCode, TextUtils.isEmpty(str) ? null : VideoSDKMaterialParser.parseVideoMaterial(str, null));
                }
                AECameraGLSurfaceView.this.mLastMateralApplySuccess = false;
                ms.a.c(AECameraGLSurfaceView.TAG, "[setMaterial]isRecording" + AECameraGLSurfaceView.this.isRecording());
                ms.a.c(AECameraGLSurfaceView.TAG, "[setMaterial]isAEKitAvailable" + AECameraGLSurfaceView.this.isAEKitAvailable());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void capturePhotoByAEKit() {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase != null) {
            filterProcessBase.n(true, this.orientation, this);
        } else {
            this.captureListener.onCaptureError(105);
        }
        requestRender();
    }

    private void recordGifFrames(int i3) {
        if (i3 <= 0 || !isRecordingGIF() || this.gifRecordStartTimestamp <= 0) {
            return;
        }
        AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) this.mFilterProcess;
        if (this.aeExpressionRecognizer == null) {
            ms.a.a(TAG, "recording gif, aeExpressionRecognizer == null, create it");
            com.tencent.aelight.camera.ae.gif.a aVar = new com.tencent.aelight.camera.ae.gif.a();
            this.aeExpressionRecognizer = aVar;
            aVar.f();
        }
        long elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.gifRecordStartTimestamp) / 1000000;
        int e16 = this.aeExpressionRecognizer.e();
        ms.a.a(TAG, "recording gif, aeExpressionRecognizer.getFrameCount() == " + e16);
        if (e16 >= 3 || ((float) elapsedRealtimeNanos) <= (e16 + 0.5f) * 1000.0f || !aEFilterProcessTex.O()) {
            return;
        }
        this.aeExpressionRecognizer.b(i3, aEFilterProcessTex.T().getAllFacePoints().get(0), this.gifPreviewWidth, this.gifPreviewHeight);
    }

    public void setMaterialMetaData(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData != null && !aEMaterialMetaData.equals(AEMaterialMetaData.MATERIAL_NONE)) {
            String localPath = aEMaterialMetaData.getLocalPath();
            int i3 = 100;
            if (!TextUtils.isEmpty(aEMaterialMetaData.f69050id) && aEMaterialMetaData.f69050id.startsWith("video_makeup_")) {
                i3 = aEMaterialMetaData.cosmeticSlidingValue;
            }
            updateMaterial(localPath, i3);
            return;
        }
        setMaterial(null);
    }

    private void drawToMediaCodecGif(int i3, int i16, float[] fArr, float[] fArr2, long j3) {
        FilterProcessBase filterProcessBase = this.mFilterProcess;
        if (filterProcessBase == null) {
            return;
        }
        AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) filterProcessBase;
        if (this.gifRecordStartTimestamp == 0) {
            QLog.d(TAG, 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
            this.gifRecordStartTimestamp = j3;
            AEGIFChunkPreviewFragment.N = new ArrayList();
        }
        int m06 = aEFilterProcessTex.m0(i16);
        long j16 = (j3 - this.gifRecordStartTimestamp) / 1000000;
        long j17 = this.gifRecordFrameIndex;
        if (j16 > GIF_SKIP_FRAME_INTERVAL * j17) {
            QLog.d(TAG, 4, "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(j17));
            this.gifRecordFrameIndex++;
            if (aEFilterProcessTex.T() != null) {
                AEGIFChunkPreviewFragment.N.add(aEFilterProcessTex.T());
            }
            frameToMediaCodecVideo(i3, m06, fArr, fArr2, (long) (j3 / 1.5d));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.tencent.aelight.camera.ae.camera.ui.c cVar;
        boolean z16 = false;
        if (motionEvent == null) {
            return false;
        }
        if (isAEKitAvailable() && (cVar = this.mController) != null) {
            if (cVar instanceof AECaptureController) {
                z16 = ((AECaptureController) cVar).k();
            } else if (cVar instanceof LSCaptureController) {
                z16 = ((LSCaptureController) cVar).k();
            }
            if (z16) {
                return super.onTouchEvent(motionEvent);
            }
            final AEFilterProcessTex aEFilterProcessTex = (AEFilterProcessTex) this.mFilterProcess;
            if (aEFilterProcessTex.a0()) {
                final float x16 = motionEvent.getX();
                final float y16 = motionEvent.getY();
                final int screenWidth = LightDeviceUtils.getScreenWidth(AEModule.getContext());
                int action = motionEvent.getAction();
                if (action == 0) {
                    PointF pointF = this.mTouchStartPoint;
                    pointF.x = x16;
                    pointF.y = y16;
                    queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.42
                        @Override // java.lang.Runnable
                        public void run() {
                            aEFilterProcessTex.C(new PointF(x16, y16), screenWidth);
                        }
                    });
                } else if (action == 1) {
                    queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.44
                        @Override // java.lang.Runnable
                        public void run() {
                            aEFilterProcessTex.C(new PointF(x16, y16), screenWidth);
                        }
                    });
                } else if (action == 2) {
                    PointF pointF2 = this.mTouchStartPoint;
                    if (getDist(pointF2.x, pointF2.y, x16, y16) > screenWidth * 0.05f) {
                        queueEvent(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.43
                            @Override // java.lang.Runnable
                            public void run() {
                                aEFilterProcessTex.C(new PointF(x16, y16), screenWidth);
                            }
                        });
                    }
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void draw2TestMediaCodec(int i3, float[] fArr, float[] fArr2) {
        if (i3 <= 0) {
            return;
        }
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (this.recordingTestEnabled && this.encodeTestConfig != null) {
            if (this.hwVideoTestRecorder == null) {
                this.hwVideoTestRecorder = new e();
            }
            int i16 = this.mRecordingTestStatus;
            if (i16 == 0) {
                if (this.audioCapture != null && (getContext() instanceof Activity)) {
                    this.audioCapture.B((Activity) getContext());
                }
                this.encodeTestConfig.d(EGL14.eglGetCurrentContext());
                this.hwVideoTestRecorder.o();
                this.hwVideoTestRecorder.q(this.encodeTestConfig, new com.tencent.mobileqq.videocodec.mediacodec.recorder.c() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.31
                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeError(int i17, Throwable th5) {
                        QLog.e(AECameraGLSurfaceView.TAG, 4, "Test Video  onEncodeError:" + i17 + "," + th5.getMessage());
                    }

                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeFinish(String str) {
                        QLog.i(AECameraGLSurfaceView.TAG, 4, "Test Video onEncodeFinish:" + str);
                    }

                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeStart() {
                        QLog.i(AECameraGLSurfaceView.TAG, 4, "Test Video onEncodeStart.");
                    }

                    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
                    public void onEncodeFrame() {
                    }
                });
                this.mRecordingTestStatus = 1;
            } else if (i16 != 1) {
                throw new RuntimeException("unknown test status " + this.mRecordingTestStatus);
            }
            this.hwVideoTestRecorder.h(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, elapsedRealtimeNanos);
            return;
        }
        int i17 = this.mRecordingTestStatus;
        if (i17 != 0) {
            if (i17 == 1) {
                this.hwVideoTestRecorder.s();
                onMediaCodecStopRecord();
                this.mRecordingTestStatus = 0;
            } else {
                throw new RuntimeException("unknown test . status " + this.mRecordingTestStatus);
            }
        }
    }

    private void drawToMediaCodec(int i3, float[] fArr, float[] fArr2) {
        if (i3 <= 0) {
            return;
        }
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (isAEKitAvailable() && isRecordingGIF()) {
            drawToMediaCodecGif(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, elapsedRealtimeNanos);
        } else {
            frameToMediaCodecVideo(GLSLRender.GL_TEXTURE_2D, i3, fArr, fArr2, elapsedRealtimeNanos);
        }
    }

    private float getDist(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        return (float) Math.sqrt((f26 * f26) + (f27 * f27));
    }

    @Override // com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex.c
    public void onCaptureError(int i3) {
    }

    @Override // com.tencent.mobileqq.videocodec.audio.AudioCapture.b
    public void onAudioUnInit() {
    }

    public AECameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTryCheckCount = 0;
        this.mCameraTexture = 0;
        this.isFirstNonFilter = false;
        this.mSurfaceWidth = 320;
        this.mSurfaceHeight = 480;
        this.mCameraWidth = 0;
        this.mCameraHeight = 0;
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        this.pauseFilterChainWhenCapture = true;
        this.smoothLevel = 0;
        this.isInit = false;
        this.isNeedVoiceEncode = false;
        this.beautyEnable = true;
        this.sharpFaceEnable = true;
        this.filterEnable = true;
        this.faceEffectEnable = true;
        this.orientation = 90;
        this.activityOrientation = 0;
        this.isFirstFrame = true;
        this.mHaveFrame = false;
        this.logTillHaveFrame = true;
        this.drawFrameCount = 0;
        this.onFrameAvailableLogged = false;
        this.isAIOCameraFirstInitForbidFilter = true;
        this.isPaused = true;
        this.lastDetected = false;
        this.notDetectedTimes = 0;
        this.needFace = false;
        this.isGIFMode = false;
        this.gifRecordStartTimestamp = 0L;
        this.gifRecordFrameIndex = 0L;
        this.fpsReporter = new tq.a();
        this.voiceRecognizer = new com.tencent.aelight.camera.aioeditor.shortvideo.b();
        this.mIsTryLocationPermission = false;
        this.mPendingReqLocationPermission = false;
        this.hasRecorded = false;
        this.useVideoOrientation = true;
        this.mLastVideoMaterial = null;
        this.mMaterialPath = null;
        this.mIsMaterialSame = false;
        this.mLastMateralApplySuccess = false;
        this.mMaterialAlpha = -1;
        this.mLastForceMaterialPath = null;
        this.frameCount = 0;
        this.startTime = System.currentTimeMillis();
        this.selectedCamera = 2;
        this.mTouchStartPoint = new PointF(0.0f, 0.0f);
        tq.b.h().o("glSurfaceViewConstruct-begin");
        initEGL();
        this.mIdentityHashCode = System.identityHashCode(this);
        tq.b.h().o("glSurfaceViewConstruct-end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String lightSdkAssetError2String(int i3) {
        int i16;
        if (i3 != -800 && i3 != -700 && i3 != -600) {
            if (i3 == -500) {
                i16 = R.string.y6p;
            } else if (i3 == -400) {
                i16 = R.string.y6q;
            } else if (i3 != -300 && i3 != -200) {
                i16 = i3 != -100 ? i3 != 0 ? R.string.y6r : 0 : R.string.y6j;
            }
            if (i16 == 0) {
                return HardCodeUtil.qqStr(i16);
            }
            return null;
        }
        i16 = R.string.y6k;
        if (i16 == 0) {
        }
    }

    private void collectDebugResolutionInfo(int i3, int i16) {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
