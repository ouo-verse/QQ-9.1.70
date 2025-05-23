package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.ar.arengine.ARReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARNativeBridge {
    public static final int ANIMATION_TYPE_MAIN = 3;
    public static final int ANIMATION_TYPE_SWIPE_LEFT = 1;
    public static final int ANIMATION_TYPE_SWIPE_RIGHT = 2;
    private static boolean globalInitialized = false;
    private static boolean loadSoSuccess = false;
    private static boolean needCheckMd5 = true;
    public static int sIdCount;

    /* renamed from: id, reason: collision with root package name */
    public int f196808id;
    public ARGLSurfaceView mAttached;
    public ActionCallback sActionCallback;
    public String basePath = null;
    public int mCurrentActiveId = 0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface ARCardAnimationCallback {
        void onAnimationComplete(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface ARWorldCupCallback {
        void nativeCallBack(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface ActionCallback {
        public static final int ACTION_ANIM_END_ERROR = 0;
        public static final int ACTION_ANIM_END_SUCCESSFULLY = 1;
        public static final int ACTION_ANIM_INTERRUPTED = 2;

        void callback(int i3, String str, int i16, String str2);
    }

    public ARNativeBridge() {
        initSoEnvirontMent();
        int i3 = sIdCount;
        sIdCount = i3 + 1;
        this.f196808id = i3;
    }

    private static boolean initSoEnvirontMent() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean d16 = ArNativeSoLoader.d("ArMapEngine800Arch64", needCheckMd5);
        needCheckMd5 = !d16;
        boolean z16 = false;
        if (!d16) {
            return false;
        }
        if (!globalInitialized) {
            globalInitialized = true;
            try {
                if (ArNativeSoLoader.f("ArMapEngine800Arch64") == 0) {
                    z16 = true;
                }
                loadSoSuccess = z16;
            } catch (Throwable unused) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine", 2, "initSoEnvirontMent loadSoSuccess = " + loadSoSuccess);
        }
        ARReport.c().n(System.currentTimeMillis() - currentTimeMillis, loadSoSuccess);
        return loadSoSuccess;
    }

    public static boolean loadNativeLibrary() {
        return initSoEnvirontMent();
    }

    private native void nativeConfig(String str, String str2);

    private native void nativeCreateEngine();

    private native String nativeGetConfig(String str);

    private native void nativeOnDestroy();

    private native void nativeOnDrawFrame(float[] fArr, float[] fArr2);

    private native void nativeOnPause();

    private native void nativeOnResume();

    private native void nativeSetupScene(int i3, int i16, ArrayList<String> arrayList);

    public static void qqColorLog(int i3, String str, String str2) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && QLog.isColorLevel()) {
                    QLog.e(str, 2, str2);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w(str, 2, str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    private static native void setAssetManager(AssetManager assetManager, String str);

    public void fNativeDoActionCallback(int i3, String str, int i16, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine", 2, "fNativeDoActionCallback action=" + i3 + ", params=" + str + ", callbackId=" + i16 + ", result=" + str2);
        }
        ActionCallback actionCallback = this.sActionCallback;
        if (actionCallback != null) {
            actionCallback.callback(i3, str, i16, str2);
        }
    }

    public String getConfig(String str) {
        return "";
    }

    public int getIndentification() {
        int i3 = this.mCurrentActiveId + 1;
        this.mCurrentActiveId = i3;
        return i3;
    }

    public native float getRotateDegree();

    public void handleDrawFrame(float[] fArr, float[] fArr2) {
        if (!loadSoSuccess) {
            return;
        }
        try {
            nativeOnDrawFrame(fArr, fArr2);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public void handleOnSurfaceCreate(ArrayList<String> arrayList, int i3, int i16) {
        if (!loadSoSuccess) {
            return;
        }
        try {
            nativeSetupScene(i3, i16, arrayList);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public boolean isLoadSoSuccess() {
        return loadSoSuccess;
    }

    public void nativeCreateEngine(long j3, String str, Context context, AssetManager assetManager, String str2, int i3, int i16) {
        nativeCreateEngineBusiness(j3, str, context, assetManager, str2, i3, i16, -1);
    }

    public void nativeCreateEngineBusiness(long j3, String str, Context context, AssetManager assetManager, String str2, int i3, int i16, int i17) {
        try {
            native_CreateEngineBusiness(j3, str, context, assetManager, str2, i3, i16, i17);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public void nativeDestroyCertainEngine(long j3) {
        try {
            native_destroyCertainEngine(j3);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public void nativeOnDrawFrame(long j3, float[] fArr, float[] fArr2) {
        try {
            native_onDrawFrame(j3, fArr, fArr2);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public void nativePause(long j3) {
        try {
            native_pause(j3);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public native void nativePreLoadTransferDoorAnd360Ball();

    public void nativeResume(long j3) {
        try {
            native_resume(j3);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public native void native_CreateEngine(long j3, String str, Context context, AssetManager assetManager, String str2, int i3, int i16);

    public native void native_CreateEngineBusiness(long j3, String str, Context context, AssetManager assetManager, String str2, int i3, int i16, int i17);

    public native void native_changeBigScreenTextureID(int i3);

    public native void native_cleanWorldCupSparks();

    public native void native_destroyCertainEngine(long j3);

    public native void native_enterTransferDoor(int i3);

    public native void native_exit();

    public native int native_getNativeGameStatus();

    public native void native_hiddenBigScreen();

    public native void native_insertWorldCupSpark(int[] iArr, int[] iArr2, int[] iArr3);

    public native void native_onDrawFrame(long j3, float[] fArr, float[] fArr2);

    public native long native_onOrientationChanged(int i3);

    public native void native_onSensorChanged(float f16, float f17, float f18, long j3, int i3);

    public native void native_onSurfaceChanged(long j3, int i3, int i16);

    public native void native_onTouchBegin(int i3, float f16, float f17, int i16, long j3, long j16);

    public native void native_onTouchCancel(int[] iArr, float[] fArr, float[] fArr2, long j3, long j16);

    public native void native_onTouchEnd(int i3, float f16, float f17, int i16, long j3, long j16);

    public native void native_onTouchMove(int[] iArr, float[] fArr, float[] fArr2, long j3, long j16);

    public native void native_pause(long j3);

    public native void native_playARCardAnimation(int i3);

    public native void native_resume(long j3);

    public native void native_setARCardAnimationCallback(ARCardAnimationCallback aRCardAnimationCallback);

    public native void native_setARCardQuaternion(float f16, float f17, float f18, float f19);

    public native void native_setARCardVideoCover(String str);

    public native void native_setARCardVideoMatrix(float[] fArr);

    public native void native_setARCardVideoTexture(int i3, int i16, int i17);

    public native void native_setARCardVideoYUVTexture(int i3);

    public native void native_setARWorldCupCallBack(ARWorldCupCallback aRWorldCupCallback);

    public native void native_setARWorldCupQuaternion(float f16, float f17, float f18, float f19);

    public native void native_setBigScreenImageTexture(int i3);

    public native void native_setBigScreenInfo(float f16, float f17, float f18, float f19, float f26);

    public native void native_setBinHaiState(Activity activity, ARNativeBridge aRNativeBridge, int i3, int i16, String str);

    public native void native_setFullScreenMatrix(int i3, float[] fArr);

    public native void native_setGuideFullScreenVideo(int i3, int i16, int i17);

    public native void native_setRecogRes(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, int i18);

    public native void native_startTranversalAnimation();

    public native void native_switchGameStatusWithNoParams(int i3);

    public native void native_switchGameStatusWithVideoId(int i3, int i16);

    public native void native_updateBallTanslateFromVideoTime(int i3);

    public native void native_updateBallTanslateFromXYZ(float f16, float f17, float f18);

    public native void native_zoomOutWorldCupSparks();

    public void nativeonSurfaceChanged(long j3, int i3, int i16) {
        try {
            native_onSurfaceChanged(j3, i3, i16);
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public native void setARCoreSupport(int i3);

    public native void setPreLoadTransferDoorFlags();

    public void setupActionCallback(ActionCallback actionCallback) {
        this.sActionCallback = actionCallback;
    }

    public native void updateCameraTranslate(float[] fArr, float[] fArr2);

    public ARNativeBridge(ARGLSurfaceView aRGLSurfaceView) {
        this.mAttached = aRGLSurfaceView;
    }

    public void createEngine() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void config(String str, String str2) {
    }
}
