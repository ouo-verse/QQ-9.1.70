package com.tencent.qqmini.miniapp.widget.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.lifecycle.c;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qqmini.miniapp.util.CameraCompatibleList;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GlCameraHolderSurfaceView extends GlCameraSurfaceView implements Camera.AutoFocusCallback, Camera.PreviewCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor EXECUTOR = ProxyExecutors.newSingleThreadExecutor();
    private static final String TAG = "GlCameraHolderSurfaceVi";
    protected Integer backCameraId;

    /* renamed from: camera, reason: collision with root package name */
    protected Camera f346338camera;
    protected Camera.Size cameraSize;
    private String flashMode;
    protected Integer frontCameraId;
    protected boolean isBackCameraNow;
    protected boolean isScanMode;
    protected SurfaceTexture mPreviewSt;
    private final AtomicReference<Runnable> task;

    public GlCameraHolderSurfaceView(Context context) {
        super(context);
        this.task = new AtomicReference<>();
    }

    private boolean canFocus() {
        return !CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_NOT_FOCUS_MODEL);
    }

    private void getCameraInfo() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            int i16 = cameraInfo.facing;
            if (i16 == 1) {
                this.frontCameraId = Integer.valueOf(i3);
            } else if (i16 == 0) {
                this.backCameraId = Integer.valueOf(i3);
            }
            if (this.frontCameraId != null && this.backCameraId != null) {
                return;
            }
        }
    }

    private String getDefaultFocusMode() {
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            return "continuous-picture";
        }
        return "continuous-video";
    }

    private boolean isSupportFocus(String str) {
        List<String> list;
        try {
            Camera.Parameters parameters = this.f346338camera.getParameters();
            if (parameters != null) {
                list = parameters.getSupportedFocusModes();
            } else {
                list = null;
            }
        } catch (Exception unused) {
        }
        if (list == null) {
            return false;
        }
        if (!list.contains(str)) {
            return false;
        }
        return true;
    }

    private void setParamsFocusMode(String str) {
        if (!canFocus()) {
            return;
        }
        try {
            this.f346338camera.cancelAutoFocus();
        } catch (Exception e16) {
            QMLog.i(TAG, "setParamsFocusMode", e16);
        }
        Camera.Parameters parameters = this.f346338camera.getParameters();
        if (parameters == null) {
            return;
        }
        String focusMode = parameters.getFocusMode();
        if ((focusMode != null && focusMode.equals(str)) || !isSupportFocus(str)) {
            return;
        }
        parameters.setFocusMode(str);
        try {
            this.f346338camera.setParameters(parameters);
        } catch (Exception e17) {
            QMLog.i(TAG, "setParamsFocusMode", e17);
        }
    }

    protected Camera.Size getSameSize(List<Camera.Size> list, List<Camera.Size> list2, List<Camera.Size> list3) {
        if (list == null) {
            list = Collections.emptyList();
        }
        if (list2 == null) {
            list2 = Collections.emptyList();
        }
        if (list3 == null) {
            list3 = Collections.emptyList();
        }
        HashSet hashSet = new HashSet(list);
        HashSet hashSet2 = new HashSet(list3);
        Camera.Size size = null;
        int i3 = -1;
        Camera.Size size2 = null;
        for (Camera.Size size3 : list2) {
            if (hashSet.contains(size3) && hashSet2.contains(size3)) {
                int i16 = size3.width;
                int i17 = i16 * 9;
                int i18 = size3.height;
                if (i17 == i18 * 16 && (size == null || i16 * i18 > size.width * size.height)) {
                    size = size3;
                }
                int i19 = i16 * i18;
                if (i19 > i3) {
                    size2 = size3;
                    i3 = i19;
                }
            }
        }
        if (size != null) {
            return size;
        }
        return size2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.miniapp.widget.camera.GlCameraSurfaceView
    public void init() {
        super.init();
        getCameraInfo();
        setBackgroundColor(0);
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z16, Camera camera2) {
        setParamsFocusMode(getDefaultFocusMode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.miniapp.widget.camera.GlCameraSurfaceView
    public void onCameraSurfaceCreate(SurfaceTexture surfaceTexture) {
        Camera camera2;
        super.onCameraSurfaceCreate(surfaceTexture);
        this.mPreviewSt = null;
        if (surfaceTexture != null && (camera2 = this.f346338camera) != null) {
            try {
                camera2.setPreviewTexture(surfaceTexture);
                this.mPreviewSt = surfaceTexture;
            } catch (IOException e16) {
                Log.w(TAG, "onSurfaceCreate: ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCodeRead(String str) {
        Log.i(TAG, "onCodeRead: " + str + " " + this.isScanMode);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(final byte[] bArr, Camera camera2) {
        if (this.isScanMode && this.task.get() == null) {
            System.nanoTime();
            Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.camera.GlCameraHolderSurfaceView.1
                @Override // java.lang.Runnable
                public void run() {
                    Camera.Size size;
                    int i3;
                    Log.d(GlCameraHolderSurfaceView.TAG, "run: execute");
                    byte[] bArr2 = new byte[bArr.length];
                    int i16 = 0;
                    while (true) {
                        size = GlCameraHolderSurfaceView.this.cameraSize;
                        i3 = size.height;
                        if (i16 >= i3) {
                            break;
                        }
                        int i17 = 0;
                        while (true) {
                            Camera.Size size2 = GlCameraHolderSurfaceView.this.cameraSize;
                            int i18 = size2.width;
                            if (i17 < i18) {
                                int i19 = size2.height;
                                bArr2[(((i17 * i19) + i19) - i16) - 1] = bArr[(i18 * i16) + i17];
                                i17++;
                            }
                        }
                        i16++;
                    }
                    int i26 = size.width;
                    try {
                        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                        if (channelProxy != null) {
                            String decodeQR = channelProxy.decodeQR(bArr2, i3, i26, 0, 0, i3, i26);
                            if (!TextUtils.isEmpty(decodeQR)) {
                                GlCameraHolderSurfaceView.this.onCodeRead(decodeQR);
                            }
                        }
                    } catch (Exception e16) {
                        QMLog.e(GlCameraHolderSurfaceView.TAG, "decode error", e16);
                    }
                    GlCameraHolderSurfaceView.this.task.set(null);
                }
            };
            if (c.a(this.task, null, runnable)) {
                EXECUTOR.execute(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseCamera() {
        Camera camera2 = this.f346338camera;
        if (camera2 == null) {
            return;
        }
        camera2.stopPreview();
        this.f346338camera.setPreviewCallback(null);
        try {
            this.f346338camera.setPreviewDisplay(null);
        } catch (IOException e16) {
            Log.w(TAG, "releaseCamera: ", e16);
        }
        try {
            this.f346338camera.setPreviewTexture(null);
        } catch (IOException e17) {
            Log.w(TAG, "releaseCamera: ", e17);
        }
        try {
            this.f346338camera.setPreviewDisplay(null);
        } catch (IOException e18) {
            Log.w(TAG, "releaseCamera: ", e18);
        }
        this.f346338camera.release();
        this.f346338camera = null;
    }

    public void setFlashMode(String str) {
        this.flashMode = str;
    }

    public void setMode(String str) {
        this.isScanMode = "scanCode".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupCamera(int i3) {
        boolean z16;
        int i16;
        if (i3 == this.backCameraId.intValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isBackCameraNow = z16;
        this.f346338camera = CameraMonitor.open(i3);
        if (CameraCompatibleList.isFoundProduct(CameraCompatibleList.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL)) {
            i16 = 270;
        } else {
            i16 = 90;
        }
        this.f346338camera.setDisplayOrientation(i16);
        Camera.Parameters parameters = this.f346338camera.getParameters();
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            supportedFocusModes = Collections.emptyList();
        }
        if (supportedFocusModes.contains("continuous-picture")) {
            Log.i(TAG, "setupCamera: set focus continuous-picture");
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("auto")) {
            Log.i(TAG, "setupCamera: set focus auto");
            parameters.setFocusMode("auto");
        }
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Camera.Size sameSize = getSameSize(supportedPreviewSizes, parameters.getSupportedVideoSizes(), parameters.getSupportedPictureSizes());
        this.cameraSize = sameSize;
        if (sameSize == null && supportedPreviewSizes != null) {
            sameSize = supportedPreviewSizes.get(0);
        }
        if (sameSize != null) {
            parameters.setPreviewSize(sameSize.width, sameSize.height);
            parameters.setPictureSize(sameSize.width, sameSize.height);
        }
        if (this.isBackCameraNow) {
            parameters.setFlashMode(this.flashMode);
        }
        this.f346338camera.setParameters(parameters);
        this.f346338camera.setPreviewCallback(this);
    }

    public void startPreview() {
        this.f346338camera.startPreview();
        try {
            this.f346338camera.cancelAutoFocus();
            this.f346338camera.autoFocus(this);
        } catch (Throwable th5) {
            Log.w(TAG, "startPreview: failed auto focus mode", th5);
        }
    }

    public void stopPreview() {
        Camera camera2 = this.f346338camera;
        if (camera2 != null) {
            camera2.stopPreview();
        }
    }

    public void updateFlashMode() {
        Camera camera2 = this.f346338camera;
        if (camera2 == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera2.getParameters();
            parameters.setFlashMode(this.flashMode);
            this.f346338camera.setParameters(parameters);
        } catch (Throwable th5) {
            QMLog.e(TAG, "updateFlashMode exception!", th5);
        }
    }

    public GlCameraHolderSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.task = new AtomicReference<>();
    }
}
