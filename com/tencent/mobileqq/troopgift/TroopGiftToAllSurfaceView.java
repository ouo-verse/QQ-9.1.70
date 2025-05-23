package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.surfaceviewaction.action.a;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.a;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGiftToAllSurfaceView extends SpriteGLView {
    static IPatchRedirector $redirector_;
    private com.tencent.mobileqq.surfaceviewaction.gl.e K;
    private com.tencent.mobileqq.surfaceviewaction.gl.e L;
    private com.tencent.mobileqq.surfaceviewaction.gl.a M;
    private com.tencent.mobileqq.surfaceviewaction.gl.a N;
    private com.tencent.mobileqq.surfaceviewaction.gl.b P;
    private float Q;
    private e R;
    private int S;
    private String T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements FrameSprite.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FrameSprite.a f302794a;

        a(FrameSprite.a aVar) {
            this.f302794a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftToAllSurfaceView.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            FrameSprite.a aVar = this.f302794a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements a.InterfaceC8631a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftToAllSurfaceView.this);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (TroopGiftToAllSurfaceView.this.R.f302803e == 0) {
                TroopGiftToAllSurfaceView troopGiftToAllSurfaceView = TroopGiftToAllSurfaceView.this;
                troopGiftToAllSurfaceView.h(1, troopGiftToAllSurfaceView.L);
            } else {
                TroopGiftToAllSurfaceView troopGiftToAllSurfaceView2 = TroopGiftToAllSurfaceView.this;
                troopGiftToAllSurfaceView2.h(0, troopGiftToAllSurfaceView2.L);
            }
            if (TroopGiftToAllSurfaceView.this.L instanceof VideoSprite) {
                ((VideoSprite) TroopGiftToAllSurfaceView.this.L).T(TroopGiftToAllSurfaceView.this.T);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements a.InterfaceC8631a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftToAllSurfaceView.this);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.surfaceviewaction.action.h hVar = new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.g(400, TroopGiftToAllSurfaceView.this.Q, TroopGiftToAllSurfaceView.this.Q * 0.95f), new com.tencent.mobileqq.surfaceviewaction.action.g(400, TroopGiftToAllSurfaceView.this.Q * 0.95f, TroopGiftToAllSurfaceView.this.Q));
            hVar.f291164i = true;
            TroopGiftToAllSurfaceView.this.M.o(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements a.InterfaceC8631a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopGiftToAllSurfaceView.this);
            }
        }

        @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TroopGiftToAllSurfaceView troopGiftToAllSurfaceView = TroopGiftToAllSurfaceView.this;
                troopGiftToAllSurfaceView.r(troopGiftToAllSurfaceView.M);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f302799a;

        /* renamed from: b, reason: collision with root package name */
        public int f302800b;

        /* renamed from: c, reason: collision with root package name */
        public float f302801c;

        /* renamed from: d, reason: collision with root package name */
        public int f302802d;

        /* renamed from: e, reason: collision with root package name */
        public int f302803e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f302804f;

        /* renamed from: g, reason: collision with root package name */
        public int f302805g;

        /* renamed from: h, reason: collision with root package name */
        public int f302806h;

        /* renamed from: i, reason: collision with root package name */
        public int f302807i;

        /* renamed from: j, reason: collision with root package name */
        public String f302808j;

        /* renamed from: k, reason: collision with root package name */
        public String f302809k;

        /* renamed from: l, reason: collision with root package name */
        public int f302810l;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TroopGiftToAllSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public void C(a.InterfaceC8631a interfaceC8631a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) interfaceC8631a);
            return;
        }
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar = this.L;
        if (eVar != null) {
            eVar.o(new com.tencent.mobileqq.surfaceviewaction.action.e(500, 255, 0, 1));
        }
        com.tencent.mobileqq.surfaceviewaction.action.e eVar2 = new com.tencent.mobileqq.surfaceviewaction.action.e(500, 255, 0, 1);
        eVar2.e(interfaceC8631a);
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar3 = this.K;
        if (eVar3 != null) {
            eVar3.o(eVar2);
        }
        com.tencent.mobileqq.surfaceviewaction.gl.a aVar = this.M;
        if (aVar != null) {
            aVar.L(null);
            this.M.o(new com.tencent.mobileqq.surfaceviewaction.action.e(500, 255, 0, 1));
        }
        com.tencent.mobileqq.surfaceviewaction.gl.b bVar = this.P;
        if (bVar != null) {
            bVar.o(new com.tencent.mobileqq.surfaceviewaction.action.e(500, 255, 0, 1));
        }
        com.tencent.mobileqq.surfaceviewaction.gl.a aVar2 = this.N;
        if (aVar2 != null) {
            aVar2.o(new com.tencent.mobileqq.surfaceviewaction.action.e(500, 255, 0, 1));
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.M != null) {
            com.tencent.mobileqq.surfaceviewaction.action.e eVar = new com.tencent.mobileqq.surfaceviewaction.action.e(500, 255, 0);
            eVar.e(new d());
            this.M.o(eVar);
        }
    }

    public void E(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, String str, a.InterfaceC8634a interfaceC8634a, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bitmap, bitmap2, bitmap3, str, interfaceC8634a, eVar);
            return;
        }
        this.R = eVar;
        this.S = (eVar.f302800b * eVar.f302802d) / 100;
        this.Q = getResources().getDisplayMetrics().density / 2.0f;
        this.T = str;
        VideoSprite videoSprite = new VideoSprite(this, getContext(), true);
        videoSprite.Z = true;
        e eVar2 = this.R;
        videoSprite.f291153h = eVar2.f302799a / 2;
        videoSprite.f291154i = eVar2.f302800b / 2;
        this.L = videoSprite;
        G(bitmap, bitmap2, bitmap3, interfaceC8634a, eVar);
    }

    public void F(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, String[] strArr, a.InterfaceC8634a interfaceC8634a, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bitmap, bitmap2, bitmap3, strArr, interfaceC8634a, eVar);
            return;
        }
        this.R = eVar;
        this.S = (eVar.f302800b * eVar.f302802d) / 100;
        this.Q = getResources().getDisplayMetrics().density / 2.0f;
        FrameSprite frameSprite = new FrameSprite(this, strArr);
        this.L = frameSprite;
        e eVar2 = this.R;
        frameSprite.f291153h = eVar2.f302799a / 2;
        frameSprite.f291154i = eVar2.f302800b / 2;
        frameSprite.f291155m = eVar.f302801c;
        frameSprite.d0(eVar.f302810l);
        frameSprite.e0(true);
        G(bitmap, bitmap2, bitmap3, interfaceC8634a, eVar);
    }

    protected void G(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, a.InterfaceC8634a interfaceC8634a, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bitmap, bitmap2, bitmap3, interfaceC8634a, eVar);
            return;
        }
        if (!eVar.f302804f && bitmap != null) {
            Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(copy);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(eVar.f302807i);
            paint.setTextSize(34.0f);
            Matrix matrix = new Matrix();
            float width = 140.0f / bitmap2.getWidth();
            matrix.postScale(width, width);
            matrix.postTranslate((copy.getWidth() - (bitmap2.getWidth() * width)) / 2.0f, 154.0f);
            canvas.drawBitmap(bitmap2, matrix, paint);
            if (!TextUtils.isEmpty(eVar.f302809k) && !TextUtils.isEmpty(eVar.f302808j)) {
                float measureText = paint.measureText(eVar.f302809k);
                String str = eVar.f302809k;
                int i3 = 0;
                float f16 = 0.0f;
                for (int i16 = 0; i16 < eVar.f302808j.length(); i16++) {
                    f16 += paint.measureText("" + eVar.f302808j.charAt(i16));
                    if (f16 + measureText > 475.0f) {
                        break;
                    }
                    i3++;
                }
                if (i3 > 0) {
                    str = i3 == eVar.f302808j.length() ? eVar.f302808j + str : eVar.f302808j.substring(0, i3) + MiniBoxNoticeInfo.APPNAME_SUFFIX + str;
                }
                canvas.drawText(str, (copy.getWidth() / 2) - (paint.measureText(str) / 2.0f), 359.2f, paint);
            }
            com.tencent.mobileqq.surfaceviewaction.gl.e eVar2 = new com.tencent.mobileqq.surfaceviewaction.gl.e(this, copy);
            this.K = eVar2;
            eVar2.f291153h = this.R.f302799a / 2;
            eVar2.f291154i = this.S;
            eVar2.f291155m = 0.0f;
            i(eVar2);
        }
        if (bitmap3 != null) {
            com.tencent.mobileqq.surfaceviewaction.gl.a aVar = new com.tencent.mobileqq.surfaceviewaction.gl.a((SpriteGLView) this, bitmap3, false);
            this.M = aVar;
            e eVar3 = this.R;
            aVar.J(eVar3.f302799a / 2, (eVar3.f302800b * eVar3.f302806h) / 100);
        }
        try {
            com.tencent.mobileqq.surfaceviewaction.gl.a aVar2 = new com.tencent.mobileqq.surfaceviewaction.gl.a((SpriteGLView) this, BitmapFactory.decodeResource(getResources(), R.drawable.bty), true);
            this.N = aVar2;
            aVar2.J(eVar.f302799a - al.a(getContext(), 40.0f), al.a(getContext(), 120.0f));
            this.N.L(interfaceC8634a);
            com.tencent.mobileqq.surfaceviewaction.gl.a aVar3 = this.N;
            aVar3.f291155m = 0.75f;
            i(aVar3);
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGiftToAllSurfaceView", 2, "decode closeButton failed");
            }
        }
    }

    public void H(FrameSprite.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (this.K != null) {
            float f16 = this.Q;
            float f17 = this.Q;
            float f18 = this.Q;
            this.K.o(new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.g(500, 0.0f, this.Q * 1.1f), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 1.1f * f16, f16 * 0.95f), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 0.95f * f17, f17 * 1.05f), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 1.05f * f18, f18 * 1.0f)));
        }
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar = this.L;
        if (eVar != null && (eVar instanceof FrameSprite)) {
            ((FrameSprite) eVar).f291230l0 = new a(aVar);
            ((FrameSprite) this.L).X(getContext(), this);
        } else if (eVar != null && (eVar instanceof VideoSprite)) {
            ((VideoSprite) eVar).X(aVar);
        }
        com.tencent.mobileqq.surfaceviewaction.action.b bVar = new com.tencent.mobileqq.surfaceviewaction.action.b(500);
        bVar.e(new b());
        com.tencent.mobileqq.surfaceviewaction.gl.e eVar2 = this.K;
        if (eVar2 != null) {
            eVar2.o(bVar);
        }
    }

    public void I(a.InterfaceC8634a interfaceC8634a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) interfaceC8634a);
            return;
        }
        com.tencent.mobileqq.surfaceviewaction.gl.a aVar = this.M;
        if (aVar != null) {
            aVar.L(interfaceC8634a);
            com.tencent.mobileqq.surfaceviewaction.gl.a aVar2 = this.M;
            aVar2.f291155m = 0.0f;
            i(aVar2);
            float f16 = this.Q;
            float f17 = this.Q;
            com.tencent.mobileqq.surfaceviewaction.action.h hVar = new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.g(500, 0.0f, this.Q * 1.1f), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 1.1f * f16, f16 * 0.88f), new com.tencent.mobileqq.surfaceviewaction.action.g(200, 0.88f * f17, f17));
            hVar.e(new c());
            this.M.o(hVar);
        }
    }

    public void J(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            t(new Runnable(str, i3, i16) { // from class: com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f302790d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f302791e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f302792f;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView$5$a */
                /* loaded from: classes19.dex */
                class a implements a.InterfaceC8631a {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.surfaceviewaction.action.a.InterfaceC8631a
                    public void a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            TroopGiftToAllSurfaceView.this.P.o(new com.tencent.mobileqq.surfaceviewaction.action.e(600, 0, 255), new com.tencent.mobileqq.surfaceviewaction.action.h(new com.tencent.mobileqq.surfaceviewaction.action.g(300, 0.0f, 1.2f), new com.tencent.mobileqq.surfaceviewaction.action.g(300, 1.2f, 1.0f)));
                        }
                    }
                }

                {
                    this.f302790d = str;
                    this.f302791e = i3;
                    this.f302792f = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopGiftToAllSurfaceView.this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    TroopGiftToAllSurfaceView troopGiftToAllSurfaceView = TroopGiftToAllSurfaceView.this;
                    troopGiftToAllSurfaceView.P = new com.tencent.mobileqq.surfaceviewaction.gl.b(troopGiftToAllSurfaceView, troopGiftToAllSurfaceView.getContext(), this.f302790d, this.f302791e, this.f302792f);
                    TroopGiftToAllSurfaceView.this.P.J(TroopGiftToAllSurfaceView.this.R.f302799a / 2, (TroopGiftToAllSurfaceView.this.R.f302800b * TroopGiftToAllSurfaceView.this.R.f302806h) / 100);
                    TroopGiftToAllSurfaceView troopGiftToAllSurfaceView2 = TroopGiftToAllSurfaceView.this;
                    troopGiftToAllSurfaceView2.i(troopGiftToAllSurfaceView2.P);
                    TroopGiftToAllSurfaceView.this.P.E = 0;
                    com.tencent.mobileqq.surfaceviewaction.action.b bVar = new com.tencent.mobileqq.surfaceviewaction.action.b(500);
                    bVar.e(new a());
                    TroopGiftToAllSurfaceView.this.P.o(bVar);
                }
            });
        }
    }
}
