package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.action.a;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.util.x;

/* loaded from: classes19.dex */
public class TroopGiftToPersonalSurfaceView extends SpriteGLView {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.surfaceviewaction.gl.e K;
    private com.tencent.mobileqq.surfaceviewaction.gl.e L;
    private com.tencent.mobileqq.surfaceviewaction.gl.e[] M;
    private com.tencent.mobileqq.surfaceviewaction.gl.e N;
    private int P;
    protected int Q;
    protected int R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a implements FrameSprite.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameSprite.a f302811a;

        /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        class C8841a implements a.InterfaceC8631a {
            static IPatchRedirector $redirector_;

            C8841a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                FrameSprite.a aVar = a.this.f302811a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        a(FrameSprite.a aVar) {
            this.f302811a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftToPersonalSurfaceView.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TroopGiftToPersonalSurfaceView.this.w(0, new C8841a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements FrameSprite.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameSprite.a f302814a;

        /* loaded from: classes19.dex */
        class a implements a.InterfaceC8631a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                FrameSprite.a aVar = b.this.f302814a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        b(FrameSprite.a aVar) {
            this.f302814a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftToPersonalSurfaceView.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TroopGiftToPersonalSurfaceView.this.w(0, new a());
            }
        }
    }

    public TroopGiftToPersonalSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    private Bitmap v(Bitmap bitmap, int i3, int i16) {
        int c16 = x.c(getContext(), 4.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Canvas canvas2 = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            paint.setAntiAlias(true);
            canvas2.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas2.drawBitmap(bitmap, rect, rect, paint);
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            paint2.setAntiAlias(true);
            canvas.drawCircle(createBitmap.getWidth() / 2, createBitmap.getHeight() / 2, createBitmap.getWidth() / 2, paint2);
            Matrix matrix = new Matrix();
            matrix.postScale((i3 - c16) / createBitmap2.getWidth(), (i16 - c16) / createBitmap2.getHeight());
            float f16 = c16 / 2;
            matrix.postTranslate(f16, f16);
            canvas.drawBitmap(createBitmap2, matrix, paint2);
            Paint paint3 = new Paint();
            paint3.setColor(-16777216);
            paint3.setAlpha(43);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setAntiAlias(true);
            paint3.setStrokeWidth(x.c(getContext(), 1.0f));
            canvas.drawCircle(createBitmap.getWidth() / 2, createBitmap.getHeight() / 2, createBitmap.getWidth() / 2, paint3);
            createBitmap2.recycle();
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public void setHeadPositionY(int i3, int i16, float f16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        this.Q = i3;
        this.R = i16;
        int i18 = i3 / 6;
        if (i17 < i18) {
            i17 = i18;
        } else if (i17 + i18 > i16) {
            i17 = i16 - i18;
        }
        this.P = i17;
        this.N.J(i3 / 2, i16 / 2);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar = this.N;
        eVar.f291155m = f16;
        eVar.E = 255;
    }

    public void setReceiveHeadBitmap(Bitmap bitmap) {
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
        } else if (bitmap != null && (eVar = this.L) != null) {
            eVar.a(this, v(bitmap.copy(Bitmap.Config.ARGB_8888, false), x.c(getContext(), 70.0f), x.c(getContext(), 70.0f)));
        }
    }

    public void setResourceWithFps(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, String[] strArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bitmap, bitmap2, bitmap3, strArr, Integer.valueOf(i3));
            return;
        }
        FrameSprite frameSprite = new FrameSprite(this, strArr);
        this.N = frameSprite;
        frameSprite.d0(i3);
        i(this.N);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar = new com.tencent.mobileqq.surfaceviewaction.gl.e();
        this.K = eVar;
        i(eVar);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar2 = new com.tencent.mobileqq.surfaceviewaction.gl.e();
        this.L = eVar2;
        i(eVar2);
        this.K.f291155m = 0.0f;
        this.L.f291155m = 0.0f;
        this.M = new com.tencent.mobileqq.surfaceviewaction.gl.e[6];
        for (int i16 = 0; i16 < 6; i16++) {
            this.M[i16] = new com.tencent.mobileqq.surfaceviewaction.gl.e();
            com.tencent.mobileqq.surfaceviewaction.gl.e eVar3 = this.M[i16];
            eVar3.f291155m = 0.0f;
            i(eVar3);
        }
        if (bitmap != null) {
            this.K.a(this, v(bitmap.copy(Bitmap.Config.ARGB_8888, false), x.c(getContext(), 70.0f), x.c(getContext(), 70.0f)));
        }
        if (bitmap2 != null) {
            this.L.a(this, v(bitmap2.copy(Bitmap.Config.ARGB_8888, false), x.c(getContext(), 70.0f), x.c(getContext(), 70.0f)));
        }
        Texture texture = new Texture(this, bitmap3);
        for (int i17 = 0; i17 < 6; i17++) {
            this.M[i17].K(texture);
        }
    }

    public void setSendHeadBitmap(Bitmap bitmap) {
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        } else if (bitmap != null && (eVar = this.K) != null) {
            eVar.a(this, v(bitmap.copy(Bitmap.Config.ARGB_8888, false), x.c(getContext(), 70.0f), x.c(getContext(), 70.0f)));
        }
    }

    public void w(int i3, a.InterfaceC8631a interfaceC8631a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) interfaceC8631a);
            return;
        }
        int F = this.K.F();
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar = this.K;
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr = {new com.tencent.mobileqq.surfaceviewaction.action.b(i3), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 1.0f, 1.05f), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 1.05f, 0.0f)};
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar2 = this.K;
        float f16 = eVar2.f291153h;
        float f17 = eVar2.f291154i;
        int i16 = ((int) (F * 0.15f)) / 2;
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar3 = this.K;
        float f18 = eVar3.f291153h;
        float f19 = eVar3.f291154i;
        eVar.o(new com.tencent.mobileqq.surfaceviewaction.action.h(aVarArr), new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.b(i3), new com.tencent.mobileqq.surfaceviewaction.action.d(200, (int) f16, (int) f17, ((int) f16) - i16, (int) f17), new com.tencent.mobileqq.surfaceviewaction.action.d(200, (int) f18, (int) f19, ((int) f18) + i16 + F, (int) f19)));
        if (this.L.D() == null) {
            if (interfaceC8631a != null) {
                interfaceC8631a.a();
                return;
            }
            return;
        }
        com.tencent.mobileqq.surfaceviewaction.action.g gVar = new com.tencent.mobileqq.surfaceviewaction.action.g(200, 1.05f, 0.0f);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar4 = this.L;
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr2 = {new com.tencent.mobileqq.surfaceviewaction.action.b(i3), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 1.0f, 1.05f), gVar};
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar5 = this.L;
        float f26 = eVar5.f291153h;
        float f27 = eVar5.f291154i;
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar6 = this.L;
        float f28 = eVar6.f291153h;
        float f29 = eVar6.f291154i;
        eVar4.o(new com.tencent.mobileqq.surfaceviewaction.action.h(aVarArr2), new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.d(200, (int) f26, (int) f27, ((int) f26) + i16, (int) f27), new com.tencent.mobileqq.surfaceviewaction.action.d(200, (int) f28, (int) f29, (((int) f28) - i16) - F, (int) f29)));
        gVar.e(interfaceC8631a);
    }

    public void x(FrameSprite.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar = this.K;
        eVar.f291155m = 0.0f;
        this.L.f291155m = 0.0f;
        int F = eVar.F();
        this.K.J((this.Q / 2) - F, this.P);
        this.L.J((this.Q / 2) + F, this.P);
        int i3 = 0;
        int i16 = (F / 10) * 2;
        this.M[0].J((this.Q / 2) - F, this.P - i16);
        this.M[1].J((this.Q / 2) - F, this.P - r4);
        this.M[2].J((this.Q / 2) - F, this.P);
        int i17 = (F * 6) / 5;
        this.M[3].J((this.Q / 2) - i17, this.P + r4);
        this.M[4].J((this.Q / 2) - i17, this.P + i16);
        this.M[5].J((this.Q / 2) - F, this.P + i16);
        this.K.o(new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.g(200, 0.0f, 1.05f), new com.tencent.mobileqq.surfaceviewaction.action.g(150, 1.05f, 1.0f)));
        this.L.o(new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.b(200), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 0.0f, 1.05f), new com.tencent.mobileqq.surfaceviewaction.action.g(150, 1.05f, 1.0f)));
        float f16 = 9.0f / (this.L.f291153h - this.K.f291153h);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar2 = this.M[0];
        int i18 = F / 20;
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr = {new com.tencent.mobileqq.surfaceviewaction.action.b(500), new com.tencent.mobileqq.surfaceviewaction.action.c(600, (int) eVar2.f291153h, (int) eVar2.f291154i, (int) this.L.f291153h, i18, f16)};
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar3 = this.M[1];
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr2 = {new com.tencent.mobileqq.surfaceviewaction.action.b(700), new com.tencent.mobileqq.surfaceviewaction.action.c(600, (int) eVar3.f291153h, (int) eVar3.f291154i, (int) this.L.f291153h, i18, f16)};
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar4 = this.M[2];
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr3 = {new com.tencent.mobileqq.surfaceviewaction.action.b(600), new com.tencent.mobileqq.surfaceviewaction.action.c(600, (int) eVar4.f291153h, (int) eVar4.f291154i, (int) this.L.f291153h, i18, f16)};
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar5 = this.M[3];
        float f17 = 0.6f * f16;
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr4 = {new com.tencent.mobileqq.surfaceviewaction.action.b(900), new com.tencent.mobileqq.surfaceviewaction.action.c(600, (int) eVar5.f291153h, (int) eVar5.f291154i, (int) this.L.f291153h, i18, f17)};
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar6 = this.M[4];
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr5 = {new com.tencent.mobileqq.surfaceviewaction.action.b(800), new com.tencent.mobileqq.surfaceviewaction.action.c(600, (int) eVar6.f291153h, (int) eVar6.f291154i, (int) this.L.f291153h, i18, f17)};
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar7 = this.M[5];
        com.tencent.mobileqq.surfaceviewaction.action.a[] aVarArr6 = {new com.tencent.mobileqq.surfaceviewaction.action.h(aVarArr), new com.tencent.mobileqq.surfaceviewaction.action.h(aVarArr2), new com.tencent.mobileqq.surfaceviewaction.action.h(aVarArr3), new com.tencent.mobileqq.surfaceviewaction.action.h(aVarArr4), new com.tencent.mobileqq.surfaceviewaction.action.h(aVarArr5), new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.b(1000), new com.tencent.mobileqq.surfaceviewaction.action.c(600, (int) eVar7.f291153h, (int) eVar7.f291154i, (int) this.L.f291153h, i18, f16))};
        int i19 = 0;
        while (true) {
            com.tencent.mobileqq.surfaceviewaction.gl.e[] eVarArr = this.M;
            if (i19 >= eVarArr.length) {
                break;
            }
            com.tencent.mobileqq.surfaceviewaction.gl.e eVar8 = eVarArr[i19];
            eVar8.f291155m = 0.0f;
            eVar8.E = 255;
            eVar8.o(aVarArr6[i19], new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.b(1300), new com.tencent.mobileqq.surfaceviewaction.action.e(300, 255, 0)));
            i19++;
        }
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar9 = this.N;
        if (eVar9 != null && (eVar9 instanceof FrameSprite)) {
            ((FrameSprite) eVar9).f291230l0 = new a(aVar);
            ((FrameSprite) this.N).X(getContext(), this);
        } else if (eVar9 != null && (eVar9 instanceof VideoSprite)) {
            ((VideoSprite) eVar9).X(new b(aVar));
        }
        if (p()) {
            i(this.N);
            i(this.K);
            i(this.L);
            while (true) {
                com.tencent.mobileqq.surfaceviewaction.gl.e[] eVarArr2 = this.M;
                if (i3 < eVarArr2.length) {
                    i(eVarArr2[i3]);
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void setResourceWithFps(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bitmap, bitmap2, bitmap3, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        VideoSprite videoSprite = new VideoSprite(this, getContext(), true);
        this.N = videoSprite;
        videoSprite.T(str);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar = this.N;
        eVar.f291153h = i3 / 2;
        eVar.f291154i = i16 / 2;
        i(eVar);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar2 = new com.tencent.mobileqq.surfaceviewaction.gl.e();
        this.K = eVar2;
        i(eVar2);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar3 = new com.tencent.mobileqq.surfaceviewaction.gl.e();
        this.L = eVar3;
        i(eVar3);
        this.K.f291155m = 0.0f;
        this.L.f291155m = 0.0f;
        this.M = new com.tencent.mobileqq.surfaceviewaction.gl.e[6];
        for (int i17 = 0; i17 < 6; i17++) {
            this.M[i17] = new com.tencent.mobileqq.surfaceviewaction.gl.e();
            com.tencent.mobileqq.surfaceviewaction.gl.e eVar4 = this.M[i17];
            eVar4.f291155m = 0.0f;
            i(eVar4);
        }
        if (bitmap != null) {
            this.K.a(this, v(bitmap.copy(Bitmap.Config.ARGB_8888, false), x.c(getContext(), 70.0f), x.c(getContext(), 70.0f)));
        }
        if (bitmap2 != null) {
            this.L.a(this, v(bitmap2.copy(Bitmap.Config.ARGB_8888, false), x.c(getContext(), 70.0f), x.c(getContext(), 70.0f)));
        }
        Texture texture = new Texture(this, bitmap3);
        for (int i18 = 0; i18 < 6; i18++) {
            this.M[i18].K(texture);
        }
    }
}
