package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Process;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.q;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public abstract class CameraControllerInterface {
    public static final int CAMERA_ERROR_DEVICE = 4;
    public static final int CAMERA_ERROR_DISABLED = 2;
    public static final int CAMERA_ERROR_OCCUPIED = 1;
    public static final int CAMERA_ERROR_SERVER_DIED = 3;
    public static final int CAMERA_ERROR_UNKNOWN = 0;
    private static final String TAG = "CameraControllerInterface";

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoproducer.capture.CameraControllerInterface$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119575a;

        static {
            int[] iArr = new int[a.values().length];
            f119575a = iArr;
            try {
                iArr[a.CAMERA_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119575a[a.CAMERA_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum a {
        MOCK(0),
        CAMERA_1(1),
        CAMERA_2(2);

        private final int mValue;

        a(int i3) {
            this.mValue = i3;
        }

        public static a a(int i3) {
            for (a aVar : values()) {
                if (aVar.mValue == i3) {
                    return aVar;
                }
            }
            return CAMERA_1;
        }
    }

    public static CameraControllerInterface createCameraController(int i3, final Handler handler) {
        CameraControllerInterface aVar;
        a a16 = a.a(i3);
        if (AnonymousClass1.f119575a[a16.ordinal()] != 1) {
            aVar = new com.tencent.liteav.videoproducer.capture.a.a();
        } else {
            handler.getClass();
            aVar = new com.tencent.liteav.videoproducer.capture.b.a(new q(handler) { // from class: com.tencent.liteav.videoproducer.capture.a

                /* renamed from: a, reason: collision with root package name */
                private final Handler f119583a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f119583a = handler;
                }

                @Override // com.tencent.liteav.base.util.q
                public final void a(Runnable runnable) {
                    this.f119583a.post(runnable);
                }
            });
        }
        LiteavLog.i(TAG, "createCameraController, CameraAPIType:" + a16 + ", return camera controller: " + aVar);
        return aVar;
    }

    public static boolean hasCameraPermission() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || LiteavSystemInfo.getSystemOSVersionInt() < 23 || applicationContext.checkPermission(QQPermissionConstants.Permission.CAMERA, Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public abstract void enableCameraFpsCorrectionLogic(boolean z16);

    public abstract void enableTapToFocus(boolean z16);

    public abstract k getCameraSystemRotation();

    public abstract int getCameraSystemRotationValue();

    public abstract int getMaxZoom();

    public abstract Size getPreviewSize();

    public abstract boolean isCameraAutoFocusFaceModeSupported();

    public abstract boolean isCameraFocusPositionInPreviewSupported();

    public abstract boolean isCurrentPreviewSizeAspectRatioMatch(int i3, int i16, boolean z16);

    public abstract boolean isTorchSupported();

    public abstract boolean isZoomSupported();

    public abstract void setCameraRotationCorrectionValue(int i3);

    public abstract void setExposureCompensation(float f16);

    public abstract void setZoom(float f16);

    public abstract void startAutoFocusAtPosition(int i3, int i16);

    public abstract boolean startCapture(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, CameraEventCallback cameraEventCallback);

    public abstract void stopCapture();

    public abstract void turnOnTorch(boolean z16);
}
