package com.tencent.luggage.wxa.oq;

import android.content.Context;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.luggage.wxa.eb.d;
import com.tencent.luggage.wxa.k.f;
import com.tencent.luggage.wxa.lb.b;
import com.tencent.mm.plugin.mmsight.model.MMSightCameraFrameDataCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.lb.a {

    /* renamed from: g, reason: collision with root package name */
    public Context f137084g;

    /* renamed from: h, reason: collision with root package name */
    public Surface f137085h;

    /* renamed from: i, reason: collision with root package name */
    public int f137086i;

    /* renamed from: j, reason: collision with root package name */
    public int f137087j;

    /* renamed from: k, reason: collision with root package name */
    public b f137088k;

    /* renamed from: l, reason: collision with root package name */
    public String f137089l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context mContext, Surface surface, int i3, int i16) {
        super(mContext, null);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.f137084g = mContext;
        this.f137085h = surface;
        this.f137086i = i3;
        this.f137087j = i16;
        this.f137089l = "MicroMsg.CameraPreviewSurfaceRenderView";
        this.f137088k = new b();
    }

    @Override // com.tencent.luggage.wxa.lb.d
    public void a(Function0 r16) {
        Intrinsics.checkNotNullParameter(r16, "r");
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.a(r16);
        }
    }

    public void b() {
        f.c(this.f137089l, "tryStopCameraPreview");
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.h();
        }
    }

    @Override // com.tencent.luggage.wxa.lb.a
    @Nullable
    public EGLContext getEGLContext() {
        b bVar = this.f137088k;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.lb.a
    @Nullable
    public MMSightCameraFrameDataCallback getFrameDataCallback() {
        b bVar = this.f137088k;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @NotNull
    public final Context getMContext() {
        return this.f137084g;
    }

    public final int getMHeight() {
        return this.f137087j;
    }

    public final int getMWidth() {
        return this.f137086i;
    }

    @Override // com.tencent.luggage.wxa.lb.a
    @Nullable
    public d getPreviewTexture() {
        b bVar = this.f137088k;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    @NotNull
    public final Surface getSurface() {
        return this.f137085h;
    }

    @Override // android.opengl.GLSurfaceView, com.tencent.luggage.wxa.lb.d
    public void requestRender() {
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.requestRender();
        }
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.f137084g = context;
    }

    public final void setMHeight(int i3) {
        this.f137087j = i3;
    }

    public final void setMWidth(int i3) {
        this.f137086i = i3;
    }

    @Override // com.tencent.luggage.wxa.lb.a
    public void setOnDrawListener(@Nullable Function1<? super d, Unit> function1) {
        f.c(this.f137089l, "setOnDrawListener");
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.a(function1);
        }
    }

    public final void setSurface(@NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "<set-?>");
        this.f137085h = surface;
    }

    public void a(com.tencent.luggage.wxa.kb.a cameraConfig) {
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        f.c(this.f137089l, "updateCameraConfig:" + cameraConfig);
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.a(cameraConfig);
        }
    }

    public void a(Function1 function1) {
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.b(function1);
        }
    }

    public void a(com.tencent.luggage.wxa.fb.a renderer, boolean z16) {
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.a(renderer, false);
        }
        b bVar2 = this.f137088k;
        if (bVar2 != null) {
            bVar2.a(this.f137085h, this.f137086i, this.f137087j);
        }
        b bVar3 = this.f137088k;
        if (bVar3 != null) {
            bVar3.b(this.f137085h, this.f137086i, this.f137087j);
        }
        b bVar4 = this.f137088k;
        if (bVar4 != null) {
            bVar4.b(this.f137085h);
        }
    }

    public void a() {
        b bVar = this.f137088k;
        if (bVar != null) {
            bVar.a(this.f137085h);
        }
        b bVar2 = this.f137088k;
        if (bVar2 != null) {
            bVar2.g();
        }
        this.f137088k = null;
    }
}
