package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class j extends RenderViewHelperInterface {

    /* renamed from: a, reason: collision with root package name */
    private final String f119540a;

    /* renamed from: b, reason: collision with root package name */
    private final CustomHandler f119541b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f119542c;

    /* renamed from: d, reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f119543d;

    /* renamed from: e, reason: collision with root package name */
    private final TXCloudVideoView f119544e;

    /* renamed from: f, reason: collision with root package name */
    private final Size f119545f;

    /* renamed from: g, reason: collision with root package name */
    private GLConstants.GLScaleType f119546g;

    /* renamed from: h, reason: collision with root package name */
    private TextureView f119547h;

    /* renamed from: i, reason: collision with root package name */
    private SurfaceTexture f119548i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f119549j;

    /* renamed from: k, reason: collision with root package name */
    private Matrix f119550k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f119551l;

    /* renamed from: m, reason: collision with root package name */
    private SurfaceTexture f119552m;

    /* renamed from: n, reason: collision with root package name */
    private final Size f119553n;

    /* renamed from: o, reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f119554o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.liteav.videoconsumer.renderer.j$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public final class AnonymousClass1 implements TextureView.SurfaceTextureListener {
        AnonymousClass1() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            LiteavLog.i(j.this.f119540a, "onSurfaceTextureAvailable, size:" + i3 + HippyTKDListViewAdapter.X + i16 + " surfaceTexture:" + surfaceTexture + " mSavedSurfaceTexture:" + j.this.f119548i);
            j.this.b(j.this.a(surfaceTexture));
            j jVar = j.this;
            jVar.b(jVar.f119547h);
            j.this.f119553n.width = i3;
            j.this.f119553n.height = i16;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            LiteavLog.i(j.this.f119540a, "onSurfaceTextureDestroyed surface:" + surfaceTexture + " mTextureView:" + j.this.f119547h);
            j.this.a();
            if (j.this.f119547h != null) {
                j.this.f119548i = surfaceTexture;
                return false;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            boolean z16;
            boolean z17 = false;
            LiteavLog.i(j.this.f119542c.a("surfaceSizeChanged"), j.this.f119540a, "onSurfaceTextureSizeChanged, size: %dx%d", Integer.valueOf(i3), Integer.valueOf(i16));
            j.this.b(surfaceTexture);
            j jVar = j.this;
            jVar.b(jVar.f119547h);
            if (j.this.f119553n.width > j.this.f119553n.height) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i3 > i16) {
                z17 = true;
            }
            if (z16 != z17) {
                j.i(j.this);
            }
            j.this.f119553n.width = i3;
            j.this.f119553n.height = i16;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (j.this.f119549j) {
                return;
            }
            j.l(j.this);
            j.this.f119541b.post(q.a(this));
        }
    }

    public j(TXCloudVideoView tXCloudVideoView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.f119540a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f119541b = customHandler;
        this.f119542c = new com.tencent.liteav.base.b.b();
        this.f119545f = new Size();
        this.f119546g = null;
        this.f119548i = null;
        this.f119549j = false;
        this.f119550k = new Matrix();
        this.f119551l = true;
        this.f119553n = new Size();
        this.f119554o = new AnonymousClass1();
        this.f119543d = renderViewListener;
        this.f119544e = tXCloudVideoView;
        if (tXCloudVideoView == null) {
            LiteavLog.w(str, "txCloudVideoView is null.");
            return;
        }
        LiteavLog.i(str, "construct,txCloudVideoView=".concat(String.valueOf(tXCloudVideoView)));
        TextureView textureView = new TextureView(tXCloudVideoView.getContext());
        this.f119547h = textureView;
        customHandler.post(k.a(this, tXCloudVideoView, textureView));
    }

    static /* synthetic */ void i(j jVar) {
        TextureView textureView;
        Bitmap bitmap;
        if (jVar.f119543d != null && (textureView = jVar.f119547h) != null && (bitmap = textureView.getBitmap()) != null) {
            jVar.f119543d.onRequestRedraw(bitmap);
        }
    }

    static /* synthetic */ boolean l(j jVar) {
        jVar.f119549j = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(j jVar) {
        TextureView textureView;
        TXCloudVideoView tXCloudVideoView = jVar.f119544e;
        if (tXCloudVideoView != null && (textureView = jVar.f119547h) != null) {
            TXCCloudVideoViewMethodInvoker.removeDeprecatedViews(tXCloudVideoView, textureView);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.f119541b.post(n.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final synchronized void enableNonUniformScale(boolean z16) {
        if (this.f119551l == z16) {
            return;
        }
        this.f119551l = z16;
        this.f119541b.post(p.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final Matrix getTransformMatrix(int i3, int i16) {
        Matrix matrix = new Matrix(this.f119550k);
        matrix.postScale(1.0f, -1.0f, i3 / 2.0f, i16 / 2.0f);
        return matrix;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final boolean isUsingTextureView() {
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void release(boolean z16) {
        this.f119541b.post(m.a(this, z16));
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final synchronized void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i3, int i16, boolean z16) {
        if (this.f119546g == gLScaleType) {
            Size size = this.f119545f;
            if (i3 == size.width && i16 == size.height) {
                return;
            }
        }
        this.f119546g = gLScaleType;
        this.f119545f.set(i3, i16);
        this.f119541b.runOrPost(o.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(j jVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        TXCCloudVideoViewMethodInvoker.addView(tXCloudVideoView, textureView);
        jVar.a(textureView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(j jVar) {
        TextureView textureView = jVar.f119547h;
        if (textureView == null) {
            LiteavLog.i(jVar.f119540a, "view is not available when textureView is null");
            return;
        }
        if (textureView.isAvailable() && jVar.f119547h.getWidth() != 0 && jVar.f119547h.getHeight() != 0 && jVar.f119547h.isShown()) {
            return;
        }
        String str = jVar.f119540a;
        TextureView textureView2 = jVar.f119547h;
        LiteavLog.i(str, "%s is not available when surface available:%b, isShown:%b", textureView2, Boolean.valueOf(textureView2.isAvailable()), Boolean.valueOf(jVar.f119547h.isShown()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(j jVar) {
        jVar.b(jVar.f119547h);
        jVar.c(jVar.f119547h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(j jVar, boolean z16) {
        LiteavLog.i(jVar.f119540a, "release,mTextureView=" + jVar.f119547h);
        if (jVar.f119547h == null) {
            return;
        }
        jVar.a();
        if (jVar.f119547h.getSurfaceTextureListener() == jVar.f119554o) {
            jVar.f119547h.setSurfaceTextureListener(null);
        }
        SurfaceTexture surfaceTexture = jVar.f119548i;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            jVar.f119548i = null;
        }
        if (jVar.f119544e != null) {
            LiteavLog.i(jVar.f119540a, "clearLastImage=" + z16 + ",mHasFirstFrameRendered=" + jVar.f119549j);
            TXCCloudVideoViewMethodInvoker.removeView(jVar.f119544e, jVar.f119547h, z16 | (jVar.f119549j ^ true));
        }
        jVar.f119547h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(TextureView textureView) {
        double d16;
        if (textureView == null) {
            return;
        }
        if (!this.f119551l) {
            Matrix matrix = new Matrix();
            this.f119550k = matrix;
            textureView.setTransform(matrix);
            textureView.postInvalidate();
            LiteavLog.i(this.f119542c.a("resetTextureViewRenderMatrix"), this.f119540a, "resetTextureViewRenderMatrix", new Object[0]);
            return;
        }
        Size size = new Size(textureView.getWidth(), textureView.getHeight());
        if (this.f119545f.isValid() && size.isValid()) {
            double aspectRatio = size.aspectRatio();
            double aspectRatio2 = this.f119545f.aspectRatio();
            double d17 = 1.0d;
            if (aspectRatio2 < aspectRatio) {
                GLConstants.GLScaleType gLScaleType = this.f119546g;
                if (gLScaleType != GLConstants.GLScaleType.FIT_CENTER) {
                    if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
                        d16 = aspectRatio / aspectRatio2;
                    }
                    d16 = 1.0d;
                }
                double d18 = aspectRatio2 / aspectRatio;
                d16 = 1.0d;
                d17 = d18;
            } else {
                GLConstants.GLScaleType gLScaleType2 = this.f119546g;
                if (gLScaleType2 != GLConstants.GLScaleType.FIT_CENTER) {
                    if (gLScaleType2 == GLConstants.GLScaleType.CENTER_CROP) {
                        double d182 = aspectRatio2 / aspectRatio;
                        d16 = 1.0d;
                        d17 = d182;
                    }
                    d16 = 1.0d;
                }
                d16 = aspectRatio / aspectRatio2;
            }
            Matrix matrix2 = new Matrix();
            matrix2.setScale((float) d17, (float) d16, size.width / 2.0f, size.height / 2.0f);
            if (!matrix2.equals(textureView.getTransform(new Matrix()))) {
                textureView.setTransform(matrix2);
                textureView.postInvalidate();
                LiteavLog.i(this.f119542c.a("updateTextureViewMatrix"), this.f119540a, "view: %s, scaleX: %.2f, scaleY: %.2f, frame: %s, view: %s", textureView, Double.valueOf(d17), Double.valueOf(d16), this.f119545f, size);
            }
            this.f119550k = matrix2;
        }
    }

    private synchronized void c(TextureView textureView) {
        if (textureView == null) {
            return;
        }
        if (!this.f119551l) {
            GLConstants.GLScaleType gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        }
        textureView.setOpaque(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(j jVar) {
        jVar.b(jVar.f119547h);
        jVar.c(jVar.f119547h);
    }

    public j(TextureView textureView, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "TextureViewRenderHelper_" + hashCode();
        this.f119540a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f119541b = customHandler;
        this.f119542c = new com.tencent.liteav.base.b.b();
        this.f119545f = new Size();
        this.f119546g = null;
        this.f119548i = null;
        this.f119549j = false;
        this.f119550k = new Matrix();
        this.f119551l = true;
        this.f119553n = new Size();
        this.f119554o = new AnonymousClass1();
        this.f119543d = renderViewListener;
        this.f119544e = null;
        if (textureView == null) {
            LiteavLog.w(str, "textureView is null.");
            return;
        }
        LiteavLog.i(str, "construct,textureView=".concat(String.valueOf(textureView)));
        this.f119547h = textureView;
        customHandler.post(l.a(this, textureView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView == null) {
            LiteavLog.w(this.f119540a, "setup,textureView is null.");
            return;
        }
        if (textureView.isAvailable()) {
            Size size = new Size(textureView.getWidth(), textureView.getHeight());
            LiteavLog.i(this.f119540a, "setup,textureView=" + textureView + "," + size);
            b(textureView.getSurfaceTexture());
        } else {
            LiteavLog.i(this.f119540a, "setup,textureView not available.");
            checkViewAvailability();
        }
        textureView.setSurfaceTextureListener(this.f119554o);
        b(textureView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SurfaceTexture a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f119548i;
        if (surfaceTexture2 != null && this.f119547h != null && !com.tencent.liteav.base.util.h.a(surfaceTexture, surfaceTexture2)) {
            try {
                this.f119547h.setSurfaceTexture(this.f119548i);
                surfaceTexture = this.f119548i;
            } catch (Throwable th5) {
                LiteavLog.e(this.f119540a, "error setting saved SurfaceTexture.", th5);
            }
            this.f119548i = null;
        }
        return surfaceTexture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SurfaceTexture surfaceTexture) {
        if (this.f119552m == surfaceTexture) {
            return;
        }
        this.f119552m = surfaceTexture;
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f119543d;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(new Surface(surfaceTexture), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f119552m = null;
        RenderViewHelperInterface.RenderViewListener renderViewListener = this.f119543d;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
    }
}
