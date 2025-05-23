package com.tencent.liteav.videobase.videobase;

import android.view.TextureView;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.ui.AndroidViewEventListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.Method;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class TXCCloudVideoViewMethodInvoker {
    private static final String TAG = "TXCCloudVideoViewMethodInvoker";

    public static void addView(TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        callMethod(tXCloudVideoView, "addViewInternal", new Class[]{TextureView.class}, textureView);
    }

    private static Object callMethod(TXCloudVideoView tXCloudVideoView, String str, Class<?>[] clsArr, Object... objArr) {
        if (tXCloudVideoView == null) {
            LiteavLog.w(TAG, str + ",TXCloudVideoView is null.");
            return null;
        }
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(tXCloudVideoView, objArr);
        } catch (Throwable th5) {
            LiteavLog.e(TAG, str + ",Exception:", th5);
            return null;
        }
    }

    public static Object getGLContextFromView(DisplayTarget displayTarget) {
        if (displayTarget != null && displayTarget.getTXCloudVideoView() != null) {
            return displayTarget.getTXCloudVideoView().getOpenGLContext();
        }
        return null;
    }

    public static TextureView getTextureViewSetByUser(TXCloudVideoView tXCloudVideoView) {
        Object callMethod = callMethod(tXCloudVideoView, "getTextureViewSetByUser", null, new Object[0]);
        if (!(callMethod instanceof TextureView)) {
            return null;
        }
        return (TextureView) callMethod;
    }

    public static void removeDeprecatedViews(TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        callMethod(tXCloudVideoView, "removeDeprecatedViews", new Class[]{TextureView.class}, textureView);
    }

    public static void removeView(TXCloudVideoView tXCloudVideoView, TextureView textureView, boolean z16) {
        callMethod(tXCloudVideoView, "removeViewInternal", new Class[]{TextureView.class, Boolean.TYPE}, textureView, Boolean.valueOf(z16));
    }

    public static void setAndroidViewEventListener(TXCloudVideoView tXCloudVideoView, AndroidViewEventListener androidViewEventListener) {
        callMethod(tXCloudVideoView, "setAndroidViewEventListener", new Class[]{AndroidViewEventListener.class}, androidViewEventListener);
    }

    public static void setBackgroundColorForInternalView(TXCloudVideoView tXCloudVideoView, int i3) {
        callMethod(tXCloudVideoView, "setBackgroundColorForInternalView", new Class[]{Integer.TYPE}, Integer.valueOf(i3));
    }

    public static void setTouchToFocusEnabled(TXCloudVideoView tXCloudVideoView, boolean z16) {
        callMethod(tXCloudVideoView, "setTouchToFocusEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
    }

    public static void setZoomEnabled(TXCloudVideoView tXCloudVideoView, boolean z16) {
        callMethod(tXCloudVideoView, "setZoomEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
    }

    public static void showFocusView(TXCloudVideoView tXCloudVideoView, int i3, int i16, int i17, int i18) {
        Class cls = Integer.TYPE;
        callMethod(tXCloudVideoView, "showFocusView", new Class[]{cls, cls, cls, cls}, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
    }
}
