package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public abstract class RenderViewHelperInterface {
    private static final String TAG = "RenderViewHelperInterface";

    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119514a;

        static {
            int[] iArr = new int[DisplayTarget.a.values().length];
            f119514a = iArr;
            try {
                iArr[DisplayTarget.a.SURFACEVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119514a[DisplayTarget.a.TEXTUREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119514a[DisplayTarget.a.SURFACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119514a[DisplayTarget.a.TXCLOUDVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface RenderViewListener {
        void onRequestRedraw(Bitmap bitmap);

        void onSurfaceChanged(Surface surface, boolean z16);

        void onSurfaceDestroy();
    }

    public static RenderViewHelperInterface create(DisplayTarget displayTarget, RenderViewListener renderViewListener) {
        Surface surface;
        TextureView textureView;
        SurfaceView surfaceView;
        TXCloudVideoView tXCloudVideoView;
        if (displayTarget != null && displayTarget.getType() != null) {
            int i3 = AnonymousClass1.f119514a[displayTarget.getType().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            surface = null;
                            tXCloudVideoView = null;
                        } else {
                            TXCloudVideoView tXCloudVideoView2 = displayTarget.getTXCloudVideoView();
                            if (tXCloudVideoView2 == null) {
                                LiteavLog.w(TAG, "txCloudVideoView is null.");
                                surfaceView = null;
                                textureView = null;
                                tXCloudVideoView = tXCloudVideoView2;
                                surface = null;
                            } else {
                                SurfaceView surfaceView2 = tXCloudVideoView2.getSurfaceView();
                                textureView = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView2);
                                surfaceView = surfaceView2;
                                tXCloudVideoView = tXCloudVideoView2;
                                surface = null;
                            }
                        }
                    } else {
                        surface = displayTarget.getSurface();
                        tXCloudVideoView = null;
                    }
                    surfaceView = tXCloudVideoView;
                    textureView = surfaceView;
                } else {
                    surface = null;
                    tXCloudVideoView = null;
                    textureView = displayTarget.getTextureView();
                    surfaceView = null;
                }
            } else {
                surface = null;
                textureView = null;
                surfaceView = displayTarget.getSurfaceView();
                tXCloudVideoView = null;
            }
            if (surfaceView != null) {
                return new e(surfaceView, renderViewListener);
            }
            if (textureView != null) {
                return new j(textureView, renderViewListener);
            }
            if (surface != null) {
                return new a(surface, renderViewListener);
            }
            if (tXCloudVideoView != null) {
                return new j(tXCloudVideoView, renderViewListener);
            }
            LiteavLog.w(TAG, "RenderViewHelper not created. displayTarget=".concat(String.valueOf(displayTarget)));
            return null;
        }
        LiteavLog.w(TAG, "displayTarget or type is null. displayTarget=".concat(String.valueOf(displayTarget)));
        return null;
    }

    public static GLConstants.GLScaleType createScaleType(int i3) {
        return GLConstants.GLScaleType.a(i3);
    }

    public static void releaseSurface(Surface surface) {
        if (surface != null) {
            surface.release();
        }
    }

    public static void setBackgroundColor(DisplayTarget displayTarget, int i3) {
        TXCloudVideoView tXCloudVideoView;
        if (displayTarget != null && displayTarget.getType() != null) {
            if (AnonymousClass1.f119514a[displayTarget.getType().ordinal()] == 4 && (tXCloudVideoView = displayTarget.getTXCloudVideoView()) != null) {
                TXCCloudVideoViewMethodInvoker.setBackgroundColorForInternalView(tXCloudVideoView, i3);
                return;
            }
            return;
        }
        LiteavLog.w(TAG, "displayTarget or type is null. displayTarget=".concat(String.valueOf(displayTarget)));
    }

    public abstract void checkViewAvailability();

    public abstract void enableNonUniformScale(boolean z16);

    public abstract Matrix getTransformMatrix(int i3, int i16);

    public abstract boolean isUsingTextureView();

    public abstract void release(boolean z16);

    public abstract void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i3, int i16, boolean z16);
}
