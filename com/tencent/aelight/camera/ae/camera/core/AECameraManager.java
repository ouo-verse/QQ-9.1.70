package com.tencent.aelight.camera.ae.camera.core;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy;
import com.tencent.aelight.camera.ae.flashshow.util.f;
import com.tencent.aelight.camera.ae.flashshow.util.g;
import com.tencent.aelight.camera.ae.flashshow.util.h;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.cameraextend.a;
import com.tencent.qqcamerakit.common.d;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECameraManager extends com.tencent.qqcamerakit.capture.b implements d {
    private static final int MAX_RETRY_TIMES = 3;
    private static final int STATE_CLOSED = 0;
    private static final int STATE_OPENED = 2;
    private static final int STATE_OPEN_REQUESTING = 1;
    private static final int STATE_PREVIEWING = 4;
    private static final int STATE_PREVIEW_REQUESTING = 3;
    private static final String TAG = "AECameraManager";
    private String SPECIAL_DEVICE_FOR_GREEN_SCREEN;
    private int activityOrientation;
    private xp.a aeCaptureParam;
    private AudioCapture audioCapture;
    private final Handler cameraManagerHandler;
    private int cameraPreviewHeight;
    private int cameraPreviewWidth;
    private final com.tencent.aelight.camera.ae.camera.testpkg.b cameraProxy;
    private final AtomicInteger cameraState;
    private h darkModeChecker;
    private boolean darkModeEnable;
    private int darkModeHeight;
    private h.a darkModeListener;
    private int darkModeWidth;
    private View flashMask;
    private boolean flashSwitcher;
    private com.tencent.qqcamerakit.capture.cameraextend.a focusOperator;
    private boolean gotFirstPreviewData;
    private volatile boolean isCameraRealOpened;
    private boolean isDynamicResolutionMode;
    private int lastBrightMode;
    private int lastBrightness;
    private Object mCameraParametersOrCharacteristics;
    private CameraManagerListener mListener;
    private Matrix mScreenToCameraMatrix;
    private boolean manualFocused;
    private boolean restoreBright;
    private int retryCount;
    private int selectedCamera;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface CameraManagerListener {
        void onCameraPreviewSizeChanged(int i3, int i16);

        void onCameraPreviewStarted();

        void onCameraReadyToPreview();

        void onCameraStarted(boolean z16, String str);

        void onRetryOpenCamera();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface CameraOpenCallback {
        void onOpenResult(int i3, boolean z16);
    }

    public AECameraManager() {
        com.tencent.aelight.camera.ae.camera.testpkg.b aVar;
        if (eq.a.i()) {
            aVar = new VideoCameraProxy();
        } else {
            aVar = new com.tencent.aelight.camera.ae.camera.testpkg.a();
        }
        this.cameraProxy = aVar;
        this.mScreenToCameraMatrix = new Matrix();
        this.activityOrientation = 0;
        this.SPECIAL_DEVICE_FOR_GREEN_SCREEN = "Xiaomi;Redmi Note 8 Pro";
        this.isDynamicResolutionMode = false;
        this.manualFocused = false;
        this.flashSwitcher = false;
        this.restoreBright = false;
        this.selectedCamera = 1;
        this.mCameraParametersOrCharacteristics = null;
        this.cameraState = new AtomicInteger(0);
        this.isCameraRealOpened = false;
        this.gotFirstPreviewData = false;
        this.retryCount = 0;
        if (!f.a()) {
            this.selectedCamera = 2;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AECameraManagerHandlerThread");
        baseHandlerThread.start();
        this.cameraManagerHandler = new Handler(baseHandlerThread.getLooper());
        this.focusOperator = new com.tencent.qqcamerakit.capture.cameraextend.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCameraCreated() {
        return this.cameraState.get() >= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCameraPreviewing() {
        return this.cameraState.get() >= 3;
    }

    private boolean isSpecialDeviceForGreenScreen() {
        return this.SPECIAL_DEVICE_FOR_GREEN_SCREEN.equals(Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel());
    }

    private void onCameraSizeSelected(com.tencent.qqcamerakit.capture.d dVar) {
        int i3 = dVar.f344912b;
        this.cameraPreviewWidth = i3;
        int i16 = dVar.f344911a;
        this.cameraPreviewHeight = i16;
        CameraManagerListener cameraManagerListener = this.mListener;
        if (cameraManagerListener != null) {
            cameraManagerListener.onCameraPreviewSizeChanged(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCameraInternal(CameraOpenCallback cameraOpenCallback) {
        ms.a.f(TAG, "openCameraInternal---cameraCreated=" + isCameraCreated());
        try {
            if (isCameraCreated()) {
                ms.a.c(TAG, "openCameraInternal---camera already created, recreate camera without close camera first");
                if (cameraOpenCallback != null) {
                    return;
                } else {
                    return;
                }
            }
            this.cameraProxy.o(this);
            this.cameraProxy.m(this.selectedCamera);
            this.cameraState.set(2);
            ms.a.f(TAG, "openCameraInternal---cameraCreated normally");
            AECameraConstants.sCurrentCamera = this.selectedCamera;
            tq.b.h().o("openCamera-end");
            if (cameraOpenCallback != null) {
                cameraOpenCallback.onOpenResult(this.selectedCamera, isCameraCreated());
            }
        } finally {
            if (cameraOpenCallback != null) {
                cameraOpenCallback.onOpenResult(this.selectedCamera, isCameraCreated());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realStartPreview(SurfaceTexture surfaceTexture, i iVar) {
        ms.a.f(TAG, "realStartPreview---ENTER, previewTexture=" + surfaceTexture + ", previewSize=" + iVar);
        this.cameraState.set(3);
        this.aeCaptureParam.n(iVar.f185860a);
        this.aeCaptureParam.m(iVar.f185861b);
        this.cameraProxy.l(new com.tencent.qqcamerakit.capture.d(iVar.f185860a, iVar.f185861b), new com.tencent.qqcamerakit.capture.d(iVar.f185860a, iVar.f185861b), new com.tencent.qqcamerakit.capture.d(iVar.f185860a, iVar.f185861b), 30, "continuous-video", 3, 0);
        this.cameraProxy.r(surfaceTexture, this);
        this.cameraState.set(4);
        CameraManagerListener cameraManagerListener = this.mListener;
        if (cameraManagerListener != null) {
            cameraManagerListener.onCameraPreviewStarted();
        }
        ms.a.f(TAG, "realStartPreview---EXIT");
        tq.b.h().o("startCameraPreview-end");
    }

    private void setAeCaptureParam(xp.a aVar) {
        this.aeCaptureParam = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCameraInternal(boolean z16) {
        ms.a.f(TAG, "stopCameraInternal---ENTER, cameraCreated=" + isCameraCreated() + ", forceStop=" + z16);
        this.isCameraRealOpened = false;
        if (!z16 && !isCameraCreated()) {
            ms.a.c(TAG, "stopCameraInternal---EXIT, not created, do nothing");
            return;
        }
        this.cameraProxy.j(false);
        this.cameraProxy.a(false);
        this.cameraState.set(0);
        AudioCapture audioCapture = this.audioCapture;
        if (audioCapture != null) {
            audioCapture.y();
        }
        this.cameraProxy.d(this);
        setCameraManagerListener(null);
        ms.a.f(TAG, "stopCameraInternal---EXIT, normally");
    }

    private void turnFrontFlash(Activity activity, boolean z16) {
        boolean z17;
        if (Settings.System.canWrite(activity)) {
            z17 = true;
        } else {
            if (activity != null && activity.checkSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                DialogUtil.showWriteSetting(activity, null, null);
            }
            z17 = false;
        }
        if (!z17) {
            ms.a.c(TAG, "can not grant permission");
            return;
        }
        if (z16) {
            if (this.flashMask == null) {
                this.flashMask = new View(activity);
            }
            this.flashMask.setBackgroundColor(-1);
            this.flashMask.setAlpha(0.7f);
            if (this.flashMask.getParent() != null) {
                ((ViewGroup) this.flashMask.getParent()).removeView(this.flashMask);
            }
            activity.addContentView(this.flashMask, new ViewGroup.LayoutParams(-1, -1));
            try {
                this.lastBrightMode = Settings.System.getInt(activity.getContentResolver(), "screen_brightness_mode");
                Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", 0);
                this.lastBrightness = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
                Settings.System.putInt(activity.getContentResolver(), "screen_brightness", 255);
                this.restoreBright = true;
                return;
            } catch (Exception e16) {
                this.lastBrightMode = 1;
                this.lastBrightness = 100;
                if (ms.a.g()) {
                    ms.a.d(TAG, "turn FrontFlash Error ", e16);
                    e16.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (this.restoreBright) {
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness", this.lastBrightness);
            Settings.System.putInt(activity.getContentResolver(), "screen_brightness_mode", this.lastBrightMode);
            this.restoreBright = false;
        }
        View view = this.flashMask;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.flashMask.getParent()).removeView(this.flashMask);
    }

    public void cameraStopPreview() {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.6
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f(AECameraManager.TAG, "cameraStopPreview---ENTER");
                if (!AECameraManager.this.isCameraPreviewing()) {
                    ms.a.c(AECameraManager.TAG, "cameraStopPreview---EXIT, is not previewing");
                } else {
                    AECameraManager.this.cameraProxy.j(false);
                    AECameraManager.this.cameraState.set(2);
                }
            }
        });
    }

    public void capturePhoto(final File file, int i3, final c.b bVar, final i iVar) {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.7
            @Override // java.lang.Runnable
            public void run() {
                AECameraManager.this.cameraProxy.p(new com.tencent.qqcamerakit.capture.d(iVar.b(), iVar.a()), AECameraManager.this.manualFocused, file.getPath(), AECameraManager.this.activityOrientation, bVar);
            }
        });
    }

    public void changeCamera(final int i3, final CameraOpenCallback cameraOpenCallback) {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.4
            @Override // java.lang.Runnable
            public void run() {
                ms.a.f(AECameraManager.TAG, "[cameraManagerHandler] changeCamera " + i3);
                int i16 = i3;
                if (i16 != 2 && i16 != 1) {
                    ms.a.c(AECameraManager.TAG, "[cameraManagerHandler] changeCamera invalid camera: " + i3);
                    cameraOpenCallback.onOpenResult(AECameraManager.this.selectedCamera, AECameraManager.this.isCameraCreated());
                    return;
                }
                if (AECameraManager.this.selectedCamera != i3 && AECameraManager.this.isCameraCreated()) {
                    ms.a.f(AECameraManager.TAG, "[cameraManagerHandler] changeCamera, firstly close last camera: " + AECameraManager.this.selectedCamera);
                    AECameraManager.this.stopCameraInternal(false);
                }
                AECameraManager.this.selectedCamera = i3;
                AECameraManager.this.openCameraInternal(cameraOpenCallback);
            }
        });
    }

    public int getActivityOrientation() {
        return this.activityOrientation;
    }

    public int getAnotherCamera() {
        return (this.selectedCamera + 1) % 2;
    }

    public String getDefaultFocusMode() {
        if (ms.a.g()) {
            ms.a.f(TAG, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
        }
        Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
        return "continuous-picture";
    }

    public float getHorizontalViewAngle() {
        if (this.mCameraParametersOrCharacteristics == null) {
            this.mCameraParametersOrCharacteristics = this.cameraProxy.g();
        }
        Object obj = this.mCameraParametersOrCharacteristics;
        if (obj instanceof CameraCharacteristics) {
            ms.a.f(TAG, "[CAMERA TYPE]:camera2");
            CameraCharacteristics cameraCharacteristics = (CameraCharacteristics) this.mCameraParametersOrCharacteristics;
            SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            if (fArr == null || fArr.length <= 0) {
                return -1.0f;
            }
            return (float) (((Math.atan(sizeF.getWidth() / (fArr[0] * 2.0f)) * 2.0d) * 180.0d) / 3.141592653589793d);
        }
        if (!(obj instanceof Camera.Parameters)) {
            return -1.0f;
        }
        ms.a.f(TAG, "[CAMERA TYPE]:camera1");
        return ((Camera.Parameters) this.mCameraParametersOrCharacteristics).getHorizontalViewAngle();
    }

    public int getSelectedCamera() {
        return this.selectedCamera;
    }

    public void init(xp.a aVar) {
        this.darkModeChecker = new h();
        setAeCaptureParam(aVar);
        int e16 = aVar.e();
        this.selectedCamera = e16;
        if (e16 != 1 || f.a()) {
            return;
        }
        this.selectedCamera = 2;
    }

    public boolean isFlashEnabled() {
        return this.flashSwitcher;
    }

    public boolean isFrontCamera() {
        return this.selectedCamera == 1;
    }

    public boolean isSupportCamera2() {
        return com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b;
    }

    @Override // com.tencent.qqcamerakit.common.d
    public void notify(int i3, int i16, String str, Object... objArr) {
        int i17;
        CameraManagerListener cameraManagerListener;
        CameraManagerListener cameraManagerListener2;
        tq.b.h().n(TAG, "\u3010CameraProxy notify\u3011eventId=" + i3 + ", args=" + Arrays.toString(objArr));
        if (i3 == 1) {
            if (i16 == 0) {
                this.isCameraRealOpened = true;
                CameraManagerListener cameraManagerListener3 = this.mListener;
                if (cameraManagerListener3 != null) {
                    cameraManagerListener3.onCameraReadyToPreview();
                    ms.a.c(TAG, "\u3010Camera Open Success\u3011EVENT_CREATE_CAMERA:");
                    return;
                }
                return;
            }
            this.isCameraRealOpened = false;
            if (objArr != null && objArr.length != 0) {
                Object obj = objArr[0];
                if (!(obj instanceof String) || (cameraManagerListener = this.mListener) == null) {
                    return;
                }
                cameraManagerListener.onCameraStarted(false, (String) obj);
                ms.a.c(TAG, "\u3010Camera Open Error\u3011EVENT_CREATE_CAMERA:" + objArr[0]);
                return;
            }
            ms.a.c(TAG, "[Performance2]\u3010Camera Open Error\u3011EVENT_CREATE_CAMERA:" + i16);
            CameraManagerListener cameraManagerListener4 = this.mListener;
            if (cameraManagerListener4 == null || (i17 = this.retryCount) >= 3) {
                return;
            }
            this.retryCount = i17 + 1;
            cameraManagerListener4.onRetryOpenCamera();
            return;
        }
        if (i3 != 2) {
            if (i3 != 11) {
                return;
            }
            if (objArr != null && objArr.length <= 0) {
                ms.a.c(TAG, "onDispatchThreadException---" + i3 + "errorMsg" + str);
                return;
            }
            Exception exc = (Exception) objArr[0];
            if (exc != null) {
                ms.a.d(TAG, "onDispatchThreadException---" + exc.getMessage(), exc);
                return;
            }
            ms.a.c(TAG, "onDispatchThreadException---" + i3);
            return;
        }
        if (objArr == null) {
            ms.a.f(TAG, "\u3010Camera Open Failed\u3011EVENT_SET_CAMERA_PARAM");
            return;
        }
        if (objArr.length <= 0) {
            ms.a.f(TAG, "\u3010Camera Open Success\u3011EVENT_SET_CAMERA_PARAM");
            return;
        }
        Object obj2 = objArr[0];
        if (obj2 instanceof com.tencent.qqcamerakit.capture.d) {
            onCameraSizeSelected((com.tencent.qqcamerakit.capture.d) obj2);
            CameraManagerListener cameraManagerListener5 = this.mListener;
            if (cameraManagerListener5 != null) {
                cameraManagerListener5.onCameraStarted(true, "");
                ms.a.f(TAG, "\u3010Camera Open Success\u3011EVENT_SET_CAMERA_PARAM");
            }
            if (objArr.length >= 2) {
                Object obj3 = objArr[1];
                if (obj3 instanceof com.tencent.qqcamerakit.capture.d) {
                    com.tencent.qqcamerakit.capture.d dVar = (com.tencent.qqcamerakit.capture.d) obj3;
                    this.darkModeWidth = dVar.f344911a;
                    this.darkModeHeight = dVar.f344912b;
                    return;
                }
                return;
            }
            return;
        }
        if (!(obj2 instanceof String) || (cameraManagerListener2 = this.mListener) == null) {
            return;
        }
        cameraManagerListener2.onCameraStarted(false, (String) obj2);
        ms.a.c(TAG, "\u3010Camera Open Error\u3011EVENT_SET_CAMERA_PARAM:" + objArr[0]);
    }

    @Override // com.tencent.qqcamerakit.capture.b
    public void onPreviewFrame(byte[] bArr, Camera camera2) {
        int i3;
        if (!this.gotFirstPreviewData) {
            this.gotFirstPreviewData = true;
            tq.b.h().o("onCameraPreviewFrameData");
        }
        if (this.darkModeEnable) {
            int i16 = this.cameraPreviewWidth;
            int i17 = this.cameraPreviewHeight;
            int i18 = this.darkModeWidth;
            if (i18 > 0 && (i3 = this.darkModeHeight) > 0) {
                i17 = i18;
                i16 = i3;
            }
            this.darkModeChecker.a(bArr, i16, i17, this.darkModeListener);
        }
    }

    public void openCamera(final CameraOpenCallback cameraOpenCallback) {
        tq.b.h().o("openCamera-begin");
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.1
            @Override // java.lang.Runnable
            public void run() {
                AECameraManager.this.openCameraInternal(cameraOpenCallback);
            }
        });
    }

    public void refreshDarkModeTimer() {
        h hVar = this.darkModeChecker;
        if (hVar != null) {
            hVar.b();
        }
    }

    public void release() {
        AudioCapture audioCapture = this.audioCapture;
        if (audioCapture != null) {
            audioCapture.F();
            this.audioCapture = null;
        }
    }

    public void requestCameraFocus(final float f16, final float f17, final int i3, final int i16) {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.8
            @Override // java.lang.Runnable
            public void run() {
                if (AECameraManager.this.focusOperator == null) {
                    return;
                }
                a.C9360a c9360a = new a.C9360a();
                c9360a.f344870a = f16;
                c9360a.f344871b = f17;
                c9360a.f344872c = i3;
                c9360a.f344873d = i16;
                c9360a.f344874e = g.e(AECameraManager.this.activityOrientation);
                AECameraManager.this.cameraProxy.q(AECameraManager.this.mScreenToCameraMatrix, new c.a() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.8.1
                    @Override // com.tencent.qqcamerakit.capture.c.a
                    public void onAutoFocusCallback(boolean z16) {
                        if (ms.a.g()) {
                            ms.a.a(AECameraManager.TAG, "onAutoFocusCallback single tap focus " + z16);
                        }
                        if (z16) {
                            AECameraManager.this.manualFocused = true;
                        }
                    }
                }, c9360a.f344874e, c9360a.f344872c, c9360a.f344873d, c9360a.f344870a, c9360a.f344871b);
            }
        });
    }

    public boolean requestFocusBeforeTakePicture() {
        return this.flashSwitcher && !this.manualFocused;
    }

    public void setActivityOrientation(int i3) {
        this.activityOrientation = i3;
    }

    public void setAudioCapture(AudioCapture audioCapture) {
        this.audioCapture = audioCapture;
    }

    public void setCameraManagerListener(CameraManagerListener cameraManagerListener) {
        ms.a.f(TAG, "### setCameraManagerListener--- listener=" + cameraManagerListener);
        this.mListener = cameraManagerListener;
    }

    public void setDarkModeChecker(h hVar) {
        this.darkModeChecker = hVar;
    }

    public void setDarkModeEnable(boolean z16) {
        this.darkModeEnable = z16;
    }

    public void setDarkModeListener(h.a aVar) {
        this.darkModeListener = aVar;
    }

    public void setDynamicResolutionMode(boolean z16) {
        this.isDynamicResolutionMode = z16;
    }

    public void setFocusModeRecording() {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.11
            @Override // java.lang.Runnable
            public void run() {
                AECameraManager.this.cameraProxy.b();
            }
        });
    }

    public void setFocusOperatorMatrix(int i3, int i16, int i17, int i18) {
        com.tencent.qqcamerakit.capture.cameraextend.a aVar = this.focusOperator;
        if (aVar != null) {
            this.mScreenToCameraMatrix = aVar.d(i16, i3, i17, i18, this.selectedCamera);
        }
    }

    public void setZoom(final float f16) {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.10
            @Override // java.lang.Runnable
            public void run() {
                AECameraManager.this.cameraProxy.setZoom(f16);
            }
        });
    }

    public void startCameraPreview(final SurfaceTexture surfaceTexture, final i iVar) {
        ms.a.f(TAG, "startCameraPreview ENTER---previewTexture=" + surfaceTexture + ", previewSize=" + iVar);
        if (surfaceTexture == null || iVar == null || Math.min(iVar.f185860a, iVar.f185861b) <= 0) {
            return;
        }
        tq.b.h().o("startCameraPreview-begin");
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (AECameraManager.this.isCameraCreated()) {
                    if (!AECameraManager.this.isCameraPreviewing()) {
                        if (AECameraManager.this.isCameraRealOpened) {
                            AECameraManager.this.realStartPreview(surfaceTexture, iVar);
                            return;
                        } else {
                            ms.a.c(AECameraManager.TAG, "startCameraPreview EXIT: camera isCameraRealOpened false");
                            return;
                        }
                    }
                    ms.a.c(AECameraManager.TAG, "startCameraPreview EXIT: camera is already previewing");
                    return;
                }
                ms.a.c(AECameraManager.TAG, "startCameraPreview EXIT: camera NOT created");
            }
        });
    }

    public void stopCamera(final boolean z16) {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.2
            @Override // java.lang.Runnable
            public void run() {
                AECameraManager.this.stopCameraInternal(z16);
            }
        });
    }

    public void stopRecordVideo() {
        this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.9
            @Override // java.lang.Runnable
            public void run() {
                AECameraManager.this.cameraProxy.e();
            }
        });
    }

    public void switchFlash(boolean z16) {
        this.flashSwitcher = z16;
        com.tencent.aelight.camera.ae.flashshow.util.a.d(z16);
    }

    public void toggleCamera(final CameraOpenCallback cameraOpenCallback) {
        if (!f.a()) {
            ms.a.c(TAG, "toggleCamera---front camera not exists, not support toggle");
            cameraOpenCallback.onOpenResult(this.selectedCamera, false);
        } else {
            this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.3
                @Override // java.lang.Runnable
                public void run() {
                    AECameraManager.this.stopCameraInternal(false);
                    if (AECameraManager.this.selectedCamera == 1) {
                        AECameraManager.this.selectedCamera = 2;
                    } else {
                        AECameraManager.this.selectedCamera = 1;
                    }
                    AECameraConstants.sCurrentCamera = AECameraManager.this.selectedCamera;
                    AECameraManager.this.manualFocused = false;
                    QmcfManager.getInstance().setCameraMode(AECameraManager.this.selectedCamera);
                    AECameraManager.this.openCameraInternal(cameraOpenCallback);
                }
            });
        }
    }

    public void turnFlash(Activity activity, boolean z16) {
        ms.a.a(TAG, "turnFlash" + z16 + " selectedCamera " + this.selectedCamera);
        if (this.selectedCamera == 1) {
            turnFrontFlash(activity, z16);
        } else {
            this.cameraProxy.f(z16);
        }
    }

    @Override // com.tencent.qqcamerakit.capture.b
    public void onPreviewFrame(Image image) {
        int i3;
        super.onPreviewFrame(image);
        if (!this.gotFirstPreviewData) {
            this.gotFirstPreviewData = true;
            tq.b.h().o("onCameraPreviewFrameData");
        }
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        if (this.darkModeEnable) {
            int i16 = this.cameraPreviewWidth;
            int i17 = this.cameraPreviewHeight;
            int i18 = this.darkModeWidth;
            if (i18 > 0 && (i3 = this.darkModeHeight) > 0) {
                i17 = i18;
                i16 = i3;
            }
            this.darkModeChecker.a(bArr, i16, i17, this.darkModeListener);
        }
    }

    public void setSelectedCamera(final int i3) {
        if (i3 == 2 || i3 == 1) {
            if (i3 != 1 || f.a()) {
                this.cameraManagerHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.core.AECameraManager.12
                    @Override // java.lang.Runnable
                    public void run() {
                        AECameraManager.this.selectedCamera = i3;
                    }
                });
            }
        }
    }
}
