package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends RenderViewHelperInterface {

    /* renamed from: a, reason: collision with root package name */
    private final String f119523a;

    /* renamed from: b, reason: collision with root package name */
    private final CustomHandler f119524b;

    /* renamed from: c, reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f119525c;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceView f119526d;

    /* renamed from: e, reason: collision with root package name */
    private final Size f119527e;

    /* renamed from: f, reason: collision with root package name */
    private final Size f119528f;

    /* renamed from: g, reason: collision with root package name */
    private GLConstants.GLScaleType f119529g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f119530h;

    /* renamed from: i, reason: collision with root package name */
    private final SurfaceHolder.Callback f119531i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnLayoutChangeListener f119532j;

    public e(SurfaceView surfaceView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceViewRenderHelper_" + hashCode();
        this.f119523a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f119524b = customHandler;
        this.f119527e = new Size();
        this.f119528f = new Size();
        this.f119529g = null;
        this.f119530h = false;
        this.f119531i = new SurfaceHolder.Callback() { // from class: com.tencent.liteav.videoconsumer.renderer.e.1
            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
                if (surfaceHolder != null) {
                    LiteavLog.i(e.this.f119523a, "surfaceChanged,format=%d,Size(%dx%d)", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    e.this.a(surfaceHolder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (surfaceHolder != null) {
                    Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                    LiteavLog.i(e.this.f119523a, "surfaceCreated,Size(%dx%d)", Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
                    e.this.a(surfaceHolder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                LiteavLog.i(e.this.f119523a, "surfaceDestroyed");
                e.this.a();
            }
        };
        this.f119532j = new View.OnLayoutChangeListener() { // from class: com.tencent.liteav.videoconsumer.renderer.e.2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                if (e.this.f119530h) {
                    if (e.this.f119528f.width != view.getWidth() || e.this.f119528f.height != view.getHeight()) {
                        e.this.b();
                    }
                }
            }
        };
        this.f119525c = renderViewListener;
        if (surfaceView == null) {
            LiteavLog.w(str, "surfaceView is null.");
        } else {
            this.f119526d = surfaceView;
            customHandler.post(f.a(this, surfaceView));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(e eVar) {
        SurfaceView surfaceView = eVar.f119526d;
        if (surfaceView == null) {
            LiteavLog.i(eVar.f119523a, "view is not available when surfaceView is null");
            return;
        }
        Surface surface = surfaceView.getHolder().getSurface();
        boolean z16 = surface != null && surface.isValid();
        if (z16 && eVar.f119526d.getWidth() != 0 && eVar.f119526d.getHeight() != 0 && eVar.f119526d.isShown()) {
            return;
        }
        String str = eVar.f119523a;
        SurfaceView surfaceView2 = eVar.f119526d;
        LiteavLog.i(str, "%s is not available when isShown:%b, surface isValid:%b", surfaceView2, Boolean.valueOf(surfaceView2.isShown()), Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(e eVar) {
        LiteavLog.i(eVar.f119523a, "release,mSurfaceView=" + eVar.f119526d);
        if (eVar.f119526d == null) {
            return;
        }
        eVar.a();
        eVar.f119526d.getHolder().removeCallback(eVar.f119531i);
        eVar.f119526d = null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.f119524b.post(h.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final Matrix getTransformMatrix(int i3, int i16) {
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f, i3 / 2.0f, i16 / 2.0f);
        return matrix;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isUsingTextureView() {
        return false;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void release(boolean z16) {
        this.f119524b.post(g.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i3, int i16, boolean z16) {
        if (this.f119529g == gLScaleType && this.f119530h == z16) {
            Size size = this.f119527e;
            if (size.width == i3 && size.height == i16) {
                return;
            }
        }
        this.f119530h = z16;
        this.f119529g = gLScaleType;
        this.f119527e.set(i3, i16);
        if (this.f119530h) {
            this.f119524b.runOrPost(i.a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar, SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView.getHolder();
        if (holder.getSurface().isValid()) {
            Surface surface = holder.getSurface();
            Rect surfaceFrame = holder.getSurfaceFrame();
            LiteavLog.i(eVar.f119523a, "construct,surface=%s,Size(%dx%d)", surface, Integer.valueOf(surfaceFrame.width()), Integer.valueOf(surfaceFrame.height()));
            eVar.a(surface);
        } else {
            LiteavLog.i(eVar.f119523a, "construct,surfaceView not valid.");
        }
        holder.addCallback(eVar.f119531i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        r2 = 1.0d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        if (r0 == com.tencent.liteav.videobase.base.GLConstants.GLScaleType.CENTER_CROP) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        double d16;
        SurfaceView surfaceView = this.f119526d;
        if (surfaceView == null || !(surfaceView.getParent() instanceof TXCloudVideoView)) {
            return;
        }
        TXCloudVideoView tXCloudVideoView = (TXCloudVideoView) this.f119526d.getParent();
        Size size = new Size(tXCloudVideoView.getWidth(), tXCloudVideoView.getHeight());
        if (this.f119527e.isValid() && size.isValid()) {
            if (!this.f119528f.isValid()) {
                tXCloudVideoView.addOnLayoutChangeListener(this.f119532j);
            }
            this.f119528f.set(size);
            double aspectRatio = size.aspectRatio();
            double aspectRatio2 = this.f119527e.aspectRatio();
            double d17 = 1.0d;
            if (aspectRatio2 < aspectRatio) {
                GLConstants.GLScaleType gLScaleType = this.f119529g;
                if (gLScaleType != GLConstants.GLScaleType.FIT_CENTER) {
                }
                double d18 = aspectRatio2 / aspectRatio;
                d16 = 1.0d;
                d17 = d18;
            } else {
                GLConstants.GLScaleType gLScaleType2 = this.f119529g;
                if (gLScaleType2 != GLConstants.GLScaleType.FIT_CENTER) {
                }
                d16 = aspectRatio / aspectRatio2;
            }
            ViewGroup.LayoutParams layoutParams = this.f119526d.getLayoutParams();
            layoutParams.width = (int) (size.getWidth() * d17);
            layoutParams.height = (int) (size.getHeight() * d16);
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            this.f119526d.setLayoutParams(layoutParams);
            LiteavLog.i(this.f119523a, "adjust view size to %d*%d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface) {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f119525c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f119525c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void enableNonUniformScale(boolean z16) {
    }
}
