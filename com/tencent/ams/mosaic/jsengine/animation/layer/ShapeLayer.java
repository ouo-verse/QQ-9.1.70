package com.tencent.ams.mosaic.jsengine.animation.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.ShapeLayer;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ShapeLayer extends LayerBase<h> implements ShapeComponent {
    static IPatchRedirector $redirector_;
    private final List<b> S;
    private final Path T;
    private float U;
    private float V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f70739a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23707);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GradientDrawable.Orientation.values().length];
            f70739a = iArr;
            try {
                iArr[GradientDrawable.Orientation.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70739a[GradientDrawable.Orientation.TR_BL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f70739a[GradientDrawable.Orientation.RIGHT_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f70739a[GradientDrawable.Orientation.BR_TL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f70739a[GradientDrawable.Orientation.BOTTOM_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f70739a[GradientDrawable.Orientation.BL_TR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f70739a[GradientDrawable.Orientation.LEFT_RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f70739a[GradientDrawable.Orientation.TL_BR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        RectF f70740a;

        /* renamed from: b, reason: collision with root package name */
        float f70741b;

        /* renamed from: c, reason: collision with root package name */
        float f70742c;

        public c(RectF rectF, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, rectF, Float.valueOf(f16), Float.valueOf(f17));
                return;
            }
            this.f70740a = rectF;
            this.f70741b = f16;
            this.f70742c = f17;
        }

        public float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            float f16 = this.f70742c - this.f70741b;
            if (f16 < 0.0f) {
                return f16 + 360.0f;
            }
            return f16;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "AddArc{rect=" + this.f70740a + ", startAngle=" + this.f70741b + ", endAngle=" + this.f70742c + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f70743a;

        /* renamed from: b, reason: collision with root package name */
        float f70744b;

        /* renamed from: c, reason: collision with root package name */
        float f70745c;

        /* renamed from: d, reason: collision with root package name */
        float f70746d;

        /* renamed from: e, reason: collision with root package name */
        float f70747e;

        /* renamed from: f, reason: collision with root package name */
        float f70748f;

        public d(float f16, float f17, float f18, float f19, float f26, float f27) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27));
                return;
            }
            this.f70743a = f16;
            this.f70744b = f17;
            this.f70745c = f18;
            this.f70746d = f19;
            this.f70747e = f26;
            this.f70748f = f27;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "AddCurve{x=" + this.f70743a + ", y=" + this.f70744b + ", p1x=" + this.f70745c + ", p1y=" + this.f70746d + ", p2x=" + this.f70747e + ", p2y=" + this.f70748f + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f70749a;

        /* renamed from: b, reason: collision with root package name */
        float f70750b;

        public e(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17));
            } else {
                this.f70749a = f16;
                this.f70750b = f17;
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "AddLine{x=" + this.f70749a + ", y=" + this.f70750b + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class f implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f70751a;

        /* renamed from: b, reason: collision with root package name */
        float f70752b;

        /* renamed from: c, reason: collision with root package name */
        float f70753c;

        /* renamed from: d, reason: collision with root package name */
        float f70754d;

        public f(float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.f70751a = f16;
            this.f70752b = f17;
            this.f70753c = f18;
            this.f70754d = f19;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "AddQuad{x=" + this.f70751a + ", y=" + this.f70752b + ", p1x=" + this.f70753c + ", p1y=" + this.f70754d + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class g implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f70755a;

        /* renamed from: b, reason: collision with root package name */
        float f70756b;

        public g(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17));
            } else {
                this.f70755a = f16;
                this.f70756b = f17;
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "MoveTo{x=" + this.f70755a + ", y=" + this.f70756b + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class h extends AnimatorLayer {
        static IPatchRedirector $redirector_;
        private final Paint C;

        /* renamed from: d, reason: collision with root package name */
        private volatile int f70757d;

        /* renamed from: e, reason: collision with root package name */
        private volatile float f70758e;

        /* renamed from: f, reason: collision with root package name */
        private volatile int f70759f;

        /* renamed from: h, reason: collision with root package name */
        private volatile int f70760h;

        /* renamed from: i, reason: collision with root package name */
        private volatile Paint.Cap f70761i;

        /* renamed from: m, reason: collision with root package name */
        private Path f70762m;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShapeLayer.this);
                return;
            }
            this.f70757d = 0;
            this.f70759f = 0;
            Paint paint = new Paint();
            this.C = paint;
            this.mPaint.setStyle(Paint.Style.FILL);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void g() {
            Path path = this.f70762m;
            if (path != null) {
                path.reset();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void h(Path path, List<b> list) {
            if (path != null && list != null) {
                path.reset();
                Iterator<b> it = list.iterator();
                while (it.hasNext()) {
                    ShapeLayer.this.h(path, it.next());
                }
                this.f70762m = path;
                list.clear();
            }
        }

        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (isStartDraw()) {
                postTaskOnRenderThread(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.animation.layer.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShapeLayer.h.this.g();
                    }
                }, false);
            } else {
                g();
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
        public void draw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
                return;
            }
            Path path = this.f70762m;
            if (path != null) {
                ShapeLayer.this.c(canvas);
                canvas.translate(ShapeLayer.this.U + this.mDistanceX, ShapeLayer.this.V + this.mDistanceY);
                canvas.scale(this.mScaleX, this.mScaleY, getPx(), getPy());
                if (this.f70757d != 0 || this.mPaint.getShader() != null) {
                    canvas.drawPath(path, this.mPaint);
                }
                if (this.f70758e > 0.0f && this.f70759f != 0) {
                    this.C.setColor(this.f70759f);
                    this.C.setAlpha(this.f70760h);
                    this.C.setStrokeWidth(this.f70758e);
                    if (this.f70761i != null) {
                        this.C.setStrokeCap(this.f70761i);
                    }
                    canvas.drawPath(path, this.C);
                }
                ShapeLayer.this.b(canvas);
            }
        }

        public void f(final Path path, final List<b> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) path, (Object) list);
            } else if (isStartDraw()) {
                postTaskOnRenderThread(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.animation.layer.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShapeLayer.h.this.h(path, list);
                    }
                }, false);
            } else {
                h(path, list);
            }
        }

        public void i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
                return;
            }
            this.f70757d = MosaicUtils.P(str, 0);
            this.mPaint.setColor(this.f70757d);
            this.mPaint.setAlpha(Color.alpha(this.f70757d));
        }

        public void j(String str) {
            float f16;
            float f17;
            float f18;
            float f19;
            float f26;
            float f27;
            float f28;
            float f29;
            float f36;
            float f37;
            float f38;
            float f39;
            float f46;
            float f47;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
                return;
            }
            BasicComponent.d dVar = new BasicComponent.d(str);
            int[] c16 = dVar.c();
            if (c16 != null && c16.length > 0) {
                float[] fArr = {getX(), getY()};
                float[] fArr2 = {getX() + getWidth(), getY()};
                float[] fArr3 = {getX(), getY() + getHeight()};
                float[] fArr4 = {getX() + getWidth(), getY() + getHeight()};
                switch (a.f70739a[dVar.g().ordinal()]) {
                    case 1:
                        f16 = fArr[0];
                        f17 = fArr[1];
                        f18 = fArr3[0];
                        f19 = fArr3[1];
                        f26 = f18;
                        f27 = f19;
                        f38 = f16;
                        f39 = f17;
                        break;
                    case 2:
                        f16 = fArr2[0];
                        f17 = fArr2[1];
                        f18 = fArr3[0];
                        f19 = fArr3[1];
                        f26 = f18;
                        f27 = f19;
                        f38 = f16;
                        f39 = f17;
                        break;
                    case 3:
                        f28 = fArr2[0];
                        f29 = fArr2[1];
                        f36 = fArr[0];
                        f37 = fArr[1];
                        f27 = f37;
                        f26 = f36;
                        f39 = f29;
                        f38 = f28;
                        break;
                    case 4:
                        f38 = fArr4[0];
                        float f48 = fArr4[1];
                        float f49 = fArr[0];
                        f27 = fArr[1];
                        f26 = f49;
                        f39 = f48;
                        break;
                    case 5:
                        f28 = fArr3[0];
                        f29 = fArr3[1];
                        f36 = fArr[0];
                        f37 = fArr[1];
                        f27 = f37;
                        f26 = f36;
                        f39 = f29;
                        f38 = f28;
                        break;
                    case 6:
                        f16 = fArr3[0];
                        f17 = fArr3[1];
                        f46 = fArr2[0];
                        f47 = fArr2[1];
                        f27 = f47;
                        f26 = f46;
                        f38 = f16;
                        f39 = f17;
                        break;
                    case 7:
                        f16 = fArr[0];
                        f17 = fArr[1];
                        f46 = fArr2[0];
                        f47 = fArr2[1];
                        f27 = f47;
                        f26 = f46;
                        f38 = f16;
                        f39 = f17;
                        break;
                    case 8:
                        f38 = fArr[0];
                        f17 = fArr[1];
                        float f56 = fArr4[0];
                        f27 = fArr4[1];
                        f26 = f56;
                        f39 = f17;
                        break;
                    default:
                        f38 = 0.0f;
                        f39 = 0.0f;
                        f26 = 0.0f;
                        f27 = 0.0f;
                        break;
                }
                this.mPaint.setShader(new LinearGradient(f38, f39, f26, f27, c16, dVar.h(), Shader.TileMode.MIRROR));
            }
        }

        public void k(int i3) {
            Paint.Cap cap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
                return;
            }
            if (i3 == 0) {
                cap = Paint.Cap.BUTT;
            } else if (i3 == 1) {
                cap = Paint.Cap.ROUND;
            } else if (i3 == 2) {
                cap = Paint.Cap.SQUARE;
            } else {
                cap = null;
            }
            this.f70761i = cap;
        }

        public void l(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            int P = MosaicUtils.P(str, 0);
            this.f70759f = P;
            this.f70760h = Color.alpha(P);
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
        public void postProgress(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            }
        }

        public void setStrokeWidth(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            } else {
                this.f70758e = f16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class i implements b {
        static IPatchRedirector $redirector_;

        public i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ShapeClose";
        }
    }

    public ShapeLayer(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.S = new CopyOnWriteArrayList();
            this.T = new Path();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Path path, b bVar) {
        if (path != null && bVar != null) {
            if (bVar instanceof g) {
                g gVar = (g) bVar;
                path.moveTo(gVar.f70755a, gVar.f70756b);
                return;
            }
            if (bVar instanceof e) {
                e eVar = (e) bVar;
                path.lineTo(eVar.f70749a, eVar.f70750b);
                return;
            }
            if (bVar instanceof c) {
                c cVar = (c) bVar;
                float a16 = cVar.a();
                if (a16 >= 360.0f) {
                    path.addArc(cVar.f70740a, cVar.f70741b, a16);
                    return;
                } else {
                    path.arcTo(cVar.f70740a, cVar.f70741b, a16);
                    return;
                }
            }
            if (bVar instanceof f) {
                f fVar = (f) bVar;
                path.quadTo(fVar.f70753c, fVar.f70754d, fVar.f70751a, fVar.f70752b);
            } else if (bVar instanceof d) {
                d dVar = (d) bVar;
                path.cubicTo(dVar.f70745c, dVar.f70746d, dVar.f70747e, dVar.f70748f, dVar.f70743a, dVar.f70744b);
            } else if (bVar instanceof i) {
                path.close();
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void addArc(float f16, float f17, float f18, float f19, float f26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26));
            return;
        }
        RectF rectF = new RectF();
        rectF.left = MosaicUtils.j(f16 - f18);
        rectF.top = MosaicUtils.j(f17 - f18);
        rectF.right = MosaicUtils.j(f16 + f18);
        rectF.bottom = MosaicUtils.j(f17 + f18);
        this.S.add(new c(rectF, f19, f26));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void addCubic(float f16, float f17, float f18, float f19, float f26, float f27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27));
        } else {
            this.S.add(new d(MosaicUtils.j(f16), MosaicUtils.j(f17), MosaicUtils.j(f18), MosaicUtils.j(f19), MosaicUtils.j(f26), MosaicUtils.j(f27)));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void addLine(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.S.add(new e(MosaicUtils.j(f16), MosaicUtils.j(f17)));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void addQuad(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            this.S.add(new f(MosaicUtils.j(f16), MosaicUtils.j(f17), MosaicUtils.j(f18), MosaicUtils.j(f19)));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void clean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            ((h) this.K).c();
            this.S.clear();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void finishPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            ((h) this.K).f(this.T, this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    @NonNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public h a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (h) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new h();
    }

    public Path getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Path) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.T;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void moveToPoint(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.S.add(new g(MosaicUtils.j(f16), MosaicUtils.j(f17)));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void setFillColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            ((h) this.K).i(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void setFillColorGradient(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            ((h) this.K).j(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    public void setFrame(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        super.setFrame(f16, f17, f18, f19);
        this.U = MosaicUtils.j(f16);
        this.V = MosaicUtils.j(f17);
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase, com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        super.setPosition(f16, f17);
        this.U = MosaicUtils.j(f16);
        this.V = MosaicUtils.j(f17);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void setStrokeCap(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            ((h) this.K).k(i3);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void setStrokeColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            ((h) this.K).l(str);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void setStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            ((h) this.K).setStrokeWidth(MosaicUtils.j(f16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.draw.ShapeComponent
    public void shapeClose() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.S.add(new i());
        }
    }
}
