package com.tencent.liteav.videoproducer2.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.video.ScreenCaptureService;
import com.tencent.rtmp.video.VirtualDisplayWrapper;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class NativeScreenCapture {
    private static final String TAG = "NativeScreenCapture";
    static boolean sIsCaptureClassExist = false;
    static boolean sIsCheck = false;
    private NativeScreenCaptureListener mListener;
    private MediaProjection mMediaProjection;
    private j mScreenCaptureBridge;
    private Surface mSurface;

    public NativeScreenCapture(Surface surface, MediaProjection mediaProjection, NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.mSurface = surface;
        this.mMediaProjection = mediaProjection;
        this.mListener = nativeScreenCaptureListener;
    }

    private static boolean checkIfScreenCaptureClassExist() {
        boolean z16;
        if (sIsCheck) {
            return sIsCaptureClassExist;
        }
        try {
            int i3 = ScreenCaptureService.f368817d;
            try {
                LiteavLog.i(TAG, "Detect screen capture class!");
                z16 = true;
            } catch (ClassNotFoundException unused) {
                z16 = true;
                LiteavLog.e(TAG, "Detect screen capture class failed!");
                sIsCaptureClassExist = z16;
                sIsCheck = true;
                return z16;
            }
        } catch (ClassNotFoundException unused2) {
            z16 = false;
        }
        sIsCaptureClassExist = z16;
        sIsCheck = true;
        return z16;
    }

    public void startVirtualDisplaySync(int i3, int i16) {
        if (!checkIfScreenCaptureClassExist()) {
            this.mListener.onClassNotFound();
            return;
        }
        if (this.mScreenCaptureBridge == null) {
            this.mScreenCaptureBridge = new j(this.mSurface, i3, i16, this.mMediaProjection, this.mListener);
        }
        this.mScreenCaptureBridge.a();
    }

    public void stopVirtualDisplaySync() {
        if (!checkIfScreenCaptureClassExist()) {
            this.mListener.onClassNotFound();
            return;
        }
        j jVar = this.mScreenCaptureBridge;
        if (jVar != null) {
            jVar.b();
            this.mScreenCaptureBridge = null;
        }
    }

    public void updateVirtualDisplaySync(int i3, int i16) {
        VirtualDisplayWrapper virtualDisplayWrapper;
        if (!checkIfScreenCaptureClassExist()) {
            this.mListener.onClassNotFound();
            return;
        }
        j jVar = this.mScreenCaptureBridge;
        if (jVar == null) {
            LiteavLog.e(TAG, "Must start first!");
            return;
        }
        jVar.f119745a = i3;
        jVar.f119746b = i16;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (virtualDisplayWrapper = jVar.f119747c) != null) {
            virtualDisplayWrapper.resize(i3, i16);
        } else {
            jVar.b();
            jVar.a();
        }
    }
}
