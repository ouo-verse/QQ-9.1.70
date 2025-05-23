package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends RenderViewHelperInterface {

    /* renamed from: a, reason: collision with root package name */
    private final String f119515a;

    /* renamed from: b, reason: collision with root package name */
    private final CustomHandler f119516b;

    /* renamed from: c, reason: collision with root package name */
    private final RenderViewHelperInterface.RenderViewListener f119517c;

    /* renamed from: d, reason: collision with root package name */
    private Surface f119518d;

    public a(Surface surface, RenderViewHelperInterface.RenderViewListener renderViewListener) {
        String str = "SurfaceRenderHelper_" + hashCode();
        this.f119515a = str;
        CustomHandler customHandler = new CustomHandler(Looper.getMainLooper());
        this.f119516b = customHandler;
        this.f119517c = renderViewListener;
        if (surface == null) {
            LiteavLog.w(str, "surface is null.");
        } else {
            this.f119518d = surface;
            customHandler.post(b.a(this, surface));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, Surface surface) {
        LiteavLog.i(aVar.f119515a, "construct,surface=".concat(String.valueOf(surface)));
        RenderViewHelperInterface.RenderViewListener renderViewListener = aVar.f119517c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceChanged(surface, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar) {
        LiteavLog.i(aVar.f119515a, "release,mSurface=" + aVar.f119518d);
        if (aVar.f119518d == null) {
            return;
        }
        RenderViewHelperInterface.RenderViewListener renderViewListener = aVar.f119517c;
        if (renderViewListener != null) {
            renderViewListener.onSurfaceDestroy();
        }
        aVar.f119518d = null;
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void checkViewAvailability() {
        this.f119516b.post(d.a(this));
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
        this.f119516b.post(c.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        Surface surface = aVar.f119518d;
        if (surface == null) {
            LiteavLog.i(aVar.f119515a, "view is not available when surface is null");
        } else {
            if (surface.isValid()) {
                return;
            }
            LiteavLog.i(aVar.f119515a, "view is not available when %s is not valid", aVar.f119518d);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void enableNonUniformScale(boolean z16) {
    }

    @Override // com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface
    public final void updateVideoFrameInfo(GLConstants.GLScaleType gLScaleType, int i3, int i16, boolean z16) {
    }
}
