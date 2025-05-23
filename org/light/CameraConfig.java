package org.light;

import android.opengl.GLES20;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.filter.GLSLRender;
import org.light.bean.ExposureInfo;
import org.light.utils.LightGLUtils;
import org.light.utils.Renderer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CameraConfig extends Config {
    private static final String TAG = "CameraConfig";
    private float lastXAxis;
    DeviceCameraOrientation recognizedOrientation;
    private float eps = 3.0f;
    private NativeBuffer nativeBuffer = null;
    private Renderer sdkInputRenderer = null;
    private int currentCameraTexture = -1;
    private int currentCameraTextureWidth = -1;
    private int currentCameraTextureHeight = -1;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum DeviceCameraOrientation {
        ROTATION_0,
        ROTATION_90,
        ROTATION_180,
        ROTATION_270
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum ImageOrigin {
        TopLeft,
        BottomLeft
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface ManualExposureCallback {
        void onChangeExposureInfo(ExposureInfo exposureInfo);

        void onFetchExposureInfo(ExposureInfo exposureInfo);
    }

    public static CameraConfig make() {
        return nativeMake();
    }

    private native void nativeCameraSwitched(int i3);

    public static native CameraConfig nativeMake();

    private native void nativeSensorOrientationChanged(DeviceCameraOrientation deviceCameraOrientation);

    private native void nativeSetAutoTestMode(boolean z16);

    private native void nativeSetManualExposureCallback(ManualExposureCallback manualExposureCallback);

    private native void nativeSetRawInputForAR(byte[] bArr, int i3, int i16, long j3);

    private void restoreCameraTexture(int i3, int i16, int i17) {
        this.sdkInputRenderer.setForHardwareBuffer(true);
        this.sdkInputRenderer.draw(i3, this.nativeBuffer.getBindTexture(), i16, i17);
        GLES20.glFlush();
        LightGLUtils.deleteTexture(i3);
    }

    private int saveCameraTexture(int i3, int i16, int i17) {
        int createTexture = LightGLUtils.createTexture(GLSLRender.GL_TEXTURE_2D);
        this.sdkInputRenderer.setForHardwareBuffer(false);
        this.sdkInputRenderer.draw(i3, createTexture, i16, i17);
        GLES20.glFlush();
        return createTexture;
    }

    public void cameraSwitched(int i3) {
        nativeCameraSwitched(i3);
    }

    public native void nativeSetCameraTexture(int i3, int i16, int i17, DeviceCameraOrientation deviceCameraOrientation, ImageOrigin imageOrigin);

    @Override // org.light.Config
    public void performFinalize() {
        Renderer renderer = this.sdkInputRenderer;
        if (renderer != null) {
            renderer.release();
            this.sdkInputRenderer = null;
        }
        NativeBuffer nativeBuffer = this.nativeBuffer;
        if (nativeBuffer != null) {
            LightGLUtils.deleteTexture(nativeBuffer.getBindTexture());
            this.nativeBuffer.release();
            this.nativeBuffer = null;
        }
        super.performFinalize();
    }

    public void sensorOrientationChanged(DeviceCameraOrientation deviceCameraOrientation) {
        nativeSensorOrientationChanged(deviceCameraOrientation);
    }

    public void setAutoTestMode(boolean z16) {
        nativeSetAutoTestMode(z16);
    }

    public void setCameraTexture(int i3, int i16, int i17) {
        setCameraTexture(i3, i16, i17, DeviceCameraOrientation.ROTATION_0);
    }

    public void setManualExposureCallback(ManualExposureCallback manualExposureCallback) {
        nativeSetManualExposureCallback(manualExposureCallback);
    }

    public void setRawInputForAR(byte[] bArr, int i3, int i16, long j3) {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000000;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j16 = elapsedRealtimeNanos - uptimeMillis;
        if (Math.abs(elapsedRealtimeNanos - j3) > Math.abs(uptimeMillis - j3)) {
            j3 += j16;
        }
        nativeSetRawInputForAR(bArr, i3, i16, j3);
    }

    public void sensorOrientationChanged(int i3, int i16) {
        DeviceCameraOrientation deviceCameraOrientation = DeviceCameraOrientation.ROTATION_0;
        if (Math.abs(i16) > Math.abs(i3)) {
            if (i16 <= 1 && i16 < -1) {
                deviceCameraOrientation = DeviceCameraOrientation.ROTATION_180;
            }
        } else if (i3 > 1) {
            deviceCameraOrientation = DeviceCameraOrientation.ROTATION_90;
        } else if (i3 < -1) {
            deviceCameraOrientation = DeviceCameraOrientation.ROTATION_270;
        }
        if (this.recognizedOrientation != deviceCameraOrientation) {
            float f16 = i3;
            if (Math.abs(f16 - this.lastXAxis) > this.eps || Math.abs(i16 - this.lastXAxis) > this.eps) {
                Log.d(TAG, "orientation is changed from" + this.recognizedOrientation + " to " + deviceCameraOrientation + ", and current XAxis:" + i3);
                this.lastXAxis = f16;
                this.recognizedOrientation = deviceCameraOrientation;
                sensorOrientationChanged(deviceCameraOrientation);
            }
        }
    }

    public void setCameraTexture(int i3, int i16, int i17, DeviceCameraOrientation deviceCameraOrientation) {
        setCameraTexture(i3, i16, i17, deviceCameraOrientation, ImageOrigin.BottomLeft);
    }

    public void setCameraTexture(int i3, int i16, int i17, DeviceCameraOrientation deviceCameraOrientation, ImageOrigin imageOrigin) {
        setCameraTexture(i3, i16, i17, deviceCameraOrientation, imageOrigin, false);
    }

    public void setCameraTexture(int i3, int i16, int i17, DeviceCameraOrientation deviceCameraOrientation, ImageOrigin imageOrigin, boolean z16) {
        nativeSetCameraTexture(i3, i16, i17, deviceCameraOrientation, imageOrigin);
    }
}
