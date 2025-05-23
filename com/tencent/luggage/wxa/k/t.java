package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t extends o {

    /* renamed from: g, reason: collision with root package name */
    public static final String f131362g = "t";

    /* renamed from: d, reason: collision with root package name */
    public final TextureView f131363d;

    /* renamed from: e, reason: collision with root package name */
    public int f131364e;

    /* renamed from: f, reason: collision with root package name */
    public int f131365f;

    public t(Context context, ViewGroup viewGroup) {
        this.f131365f = viewGroup.getMeasuredHeight();
        TextureView textureView = (TextureView) View.inflate(context, R.layout.hsl, viewGroup).findViewById(R.id.jjj);
        this.f131363d = textureView;
        textureView.setSurfaceTextureListener(new a(viewGroup));
    }

    @Override // com.tencent.luggage.wxa.k.o
    public Class c() {
        return SurfaceTexture.class;
    }

    @Override // com.tencent.luggage.wxa.k.o
    public Surface d() {
        return new Surface(this.f131363d.getSurfaceTexture());
    }

    @Override // com.tencent.luggage.wxa.k.o
    public View g() {
        return this.f131363d;
    }

    @Override // com.tencent.luggage.wxa.k.o
    public boolean i() {
        if (this.f131363d.getSurfaceTexture() != null) {
            return true;
        }
        return false;
    }

    public final void k() {
        float[] fArr;
        Matrix matrix = new Matrix();
        int i3 = this.f131364e;
        if (i3 % 180 == 90) {
            float h16 = h();
            float b16 = b();
            float[] fArr2 = {0.0f, 0.0f, h16, 0.0f, 0.0f, b16, h16, b16};
            if (this.f131364e == 90) {
                fArr = new float[]{0.0f, b16, 0.0f, 0.0f, h16, b16, h16, 0.0f};
            } else {
                fArr = new float[]{h16, 0.0f, h16, b16, 0.0f, 0.0f, 0.0f, b16};
            }
            matrix.setPolyToPoly(fArr2, 0, fArr, 0, 4);
        } else if (i3 == 180) {
            matrix.postRotate(180.0f, h() / 2, b() / 2);
        }
        matrix.postTranslate(0.0f, (-(this.f131363d.getHeight() - this.f131365f)) >> 1);
        this.f131363d.setTransform(matrix);
    }

    @Override // com.tencent.luggage.wxa.k.o
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public SurfaceTexture f() {
        return this.f131363d.getSurfaceTexture();
    }

    @Override // com.tencent.luggage.wxa.k.o
    public void a(int i3, int i16) {
        this.f131363d.getSurfaceTexture().setDefaultBufferSize(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.k.o
    public void a(int i3) {
        this.f131364e = i3;
        k();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements TextureView.SurfaceTextureListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f131366a;

        public a(ViewGroup viewGroup) {
            this.f131366a = viewGroup;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            f.a(t.f131362g, "onSurfaceTextureAvailable, width = %d, height = %d", Integer.valueOf(i3), Integer.valueOf(i16));
            t.this.b(i3, i16);
            t.this.f131365f = this.f131366a.getMeasuredHeight();
            t.this.k();
            t.this.a();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            f.c(t.f131362g, "onSurfaceTextureDestroyed");
            t.this.b(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            f.a(t.f131362g, "onSurfaceTextureSizeChanged, width = %d, height = %d", Integer.valueOf(i3), Integer.valueOf(i16));
            t.this.b(i3, i16);
            t.this.f131365f = this.f131366a.getMeasuredHeight();
            t.this.k();
            t.this.a();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
