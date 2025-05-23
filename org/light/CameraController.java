package org.light;

import android.graphics.PointF;
import android.os.SystemClock;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.light.bean.ArFrameInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CameraController extends Controller {
    private static final String TAG = "CameraController";

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum CameraViewType {
        BODY,
        HEAD
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface CmShowCallback {
        void callback();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum DisplayType {
        NONE,
        ALL,
        HEAD
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface FilaPositionCallback {
        void onGetResult(float[] fArr);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface HitTestFilaCallback {
        void onGetResult(long[] jArr);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum MorphType {
        BASIC,
        MIDDLE,
        ALL
    }

    private native void nativeGetFilamentAssetPosition(FilaPositionCallback filaPositionCallback);

    private native void nativeGetHitTestFilamentAssets(float[] fArr, HitTestFilaCallback hitTestFilaCallback);

    private native void nativePause3DAnimation();

    private native void nativeRegister3DAnimation(List<String> list);

    private native void nativeRelease();

    private native void nativeResume3DAnimation();

    private native void nativeRotateArModelToFront(int i3);

    private native void nativeSetARFrameInfo(ArFrameInfo arFrameInfo);

    private native void nativeSetHitTestAfterUnprojection(float[] fArr);

    private native void nativeSetSegmentationFastMode(boolean z16);

    private native void nativeUpdateCameraTextureTimestamp(long j3);

    private native void nativeUpdateTouchEvent(int i3, long j3, long j16, int i16, float[][] fArr, int i17, int i18);

    private native void nativeUpdateTouchRotate(float[] fArr);

    private native void nativeUpdateTouchScale(float f16);

    private native void nativeUpdateViewParams(float[] fArr, float[] fArr2, float f16);

    private native void nativeUpdateVoiceDecibel(float f16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.Controller
    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public void getFilamentAssetPosition(FilaPositionCallback filaPositionCallback) {
        nativeGetFilamentAssetPosition(filaPositionCallback);
    }

    public void getHitTestFilamentAssets(float[] fArr, HitTestFilaCallback hitTestFilaCallback) {
        nativeGetHitTestFilamentAssets(fArr, hitTestFilaCallback);
    }

    public void pause3DAnimation() {
        nativePause3DAnimation();
    }

    public void register3DAnimation(List<String> list) {
        nativeRegister3DAnimation(list);
    }

    public void release() {
        if (this.nativeHandle != 0) {
            nativeRelease();
        }
    }

    public void resume3DAnimation() {
        nativeResume3DAnimation();
    }

    public void rotateArModelToFront(int i3) {
        nativeRotateArModelToFront(i3);
    }

    public void setARFrameInfo(ArFrameInfo arFrameInfo) {
        nativeSetARFrameInfo(arFrameInfo);
    }

    public void setHitTestAfterUnprojection(float[] fArr) {
        nativeSetHitTestAfterUnprojection(fArr);
    }

    public native void setKapuAnimation(String str, CmShowCallback cmShowCallback);

    public native void setKapuCameraViewType(CameraViewType cameraViewType);

    public native void setKapuDisplayType(DisplayType displayType);

    public native void setKapuModel(HashMap<String, String> hashMap, String str, CmShowCallback cmShowCallback);

    public void setSegmentationFastMode(boolean z16) {
        nativeSetSegmentationFastMode(z16);
    }

    @Override // org.light.Controller
    public int type() {
        return 1;
    }

    public void updateCameraTextureTimestamp(long j3) {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000000;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j16 = elapsedRealtimeNanos - uptimeMillis;
        if (Math.abs(elapsedRealtimeNanos - j3) > Math.abs(uptimeMillis - j3)) {
            j3 += j16;
        }
        nativeUpdateCameraTextureTimestamp(j3);
    }

    public native void updateKapuMorph(MorphType morphType);

    public void updateTouchEvent(int i3, long j3, long j16, ArrayList<PointF> arrayList, int i16, int i17) {
        int size = arrayList.size();
        if (size <= 0) {
            return;
        }
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, size, 2);
        for (int i18 = 0; i18 < size; i18++) {
            fArr[i18][0] = arrayList.get(i18).x;
            fArr[i18][1] = arrayList.get(i18).y;
        }
        nativeUpdateTouchEvent(i3, j3, j16, size, fArr, i16, i17);
    }

    public void updateTouchRotate(float[] fArr) {
        nativeUpdateTouchRotate(fArr);
    }

    public void updateTouchScale(float f16) {
        nativeUpdateTouchScale(f16);
    }

    public void updateViewParams(float[] fArr, float[] fArr2, float f16) {
        nativeUpdateViewParams(fArr, fArr2, f16);
    }

    public void updateVoiceDecibel(float f16) {
        nativeUpdateVoiceDecibel(f16);
    }
}
