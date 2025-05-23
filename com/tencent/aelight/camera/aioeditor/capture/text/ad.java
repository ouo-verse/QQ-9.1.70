package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ad extends DynamicTextItem {
    public static final int L;
    public static final int M;
    public static final int N;
    private float A;
    ai B;
    ai C;
    ai D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    int J;
    private InputFilter K;

    /* renamed from: p, reason: collision with root package name */
    private TextPaint f66947p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f66948q;

    /* renamed from: r, reason: collision with root package name */
    private RectF f66949r;

    /* renamed from: s, reason: collision with root package name */
    private int f66950s;

    /* renamed from: t, reason: collision with root package name */
    private String f66951t;

    /* renamed from: u, reason: collision with root package name */
    private String f66952u;

    /* renamed from: v, reason: collision with root package name */
    private String f66953v;

    /* renamed from: w, reason: collision with root package name */
    private int f66954w;

    /* renamed from: x, reason: collision with root package name */
    private int f66955x;

    /* renamed from: y, reason: collision with root package name */
    private TextPaint f66956y;

    /* renamed from: z, reason: collision with root package name */
    private float f66957z;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends EditTextDialog.j {
        a(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j
        public int a(CharSequence charSequence) {
            if (ad.this.h() == 0) {
                return super.a(charSequence);
            }
            return 0;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            if (ad.this.h() == 0) {
                this.f68129d = 20;
            } else {
                this.f68129d = 18;
            }
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    static {
        Resources resources = BaseApplication.getContext().getResources();
        L = BaseAIOUtils.f(18.0f, resources);
        N = BaseAIOUtils.f(6.0f, resources);
        M = (resources.getDisplayMetrics().widthPixels - com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67981e0) - (zr.a.d() * 2);
    }

    public ad(int i3, List<String> list, Typeface typeface) {
        super(i3, list);
        this.f66948q = new RectF();
        this.f66949r = new RectF();
        this.f66950s = 0;
        this.f66951t = "jenny";
        this.f66952u = "05/09";
        this.f66953v = "by";
        this.f66954w = 0;
        this.f66955x = 0;
        this.G = 0;
        this.J = 0;
        this.K = null;
        TextPaint textPaint = new TextPaint();
        this.f66956y = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT);
        this.f66956y.setTextAlign(Paint.Align.CENTER);
        if (typeface == null) {
            this.f66956y.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.f66956y.setTypeface(typeface);
        }
        this.f66956y.setAntiAlias(true);
        this.f66956y.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f66956y.setTextSkewX(-0.15f);
        int f16 = BaseAIOUtils.f(41.0f, BaseApplication.getContext().getResources());
        this.G = f16;
        this.f66956y.setTextSize(f16);
        this.f66956y.setColor(-1);
        this.f66956y.setTextAlign(Paint.Align.LEFT);
        this.f66954w = BaseAIOUtils.f(34.0f, BaseApplication.getContext().getResources());
        this.f66955x = BaseAIOUtils.f(45.0f, BaseApplication.getContext().getResources());
        this.H = BaseAIOUtils.f(4.0f, BaseApplication.getContext().getResources());
        this.I = BaseAIOUtils.f(3.0f, BaseApplication.getContext().getResources());
        ai aiVar = new ai(0);
        this.D = aiVar;
        aiVar.k(new x(-1, this.H, this.I));
        TextPaint textPaint2 = new TextPaint();
        this.f66947p = textPaint2;
        textPaint2.setTextSkewX(-0.15f);
        if (typeface != null) {
            this.f66947p.setTypeface(typeface);
        }
        this.f66947p.setAntiAlias(true);
        this.f66947p.setStyle(Paint.Style.FILL_AND_STROKE);
        int f17 = BaseAIOUtils.f(19.0f, BaseApplication.getContext().getResources());
        this.F = f17;
        this.f66947p.setTextSize(f17);
        this.f66947p.setColor(-16777216);
        TextPaint textPaint3 = new TextPaint();
        if (typeface != null) {
            textPaint3.setTypeface(typeface);
        }
        this.f66952u = com.tencent.aelight.camera.aioeditor.capture.util.d.a();
        textPaint3.setAntiAlias(true);
        textPaint3.setTextSkewX(-0.15f);
        textPaint3.setStyle(Paint.Style.FILL_AND_STROKE);
        int f18 = BaseAIOUtils.f(23.0f, BaseApplication.getContext().getResources());
        this.E = f18;
        textPaint3.setTextSize(f18);
        textPaint3.setColor(-1);
        ai aiVar2 = new ai(0);
        this.C = aiVar2;
        aiVar2.k(new x(-16777216, this.H, this.I));
        this.C.i(this.f66952u, M, this.E, textPaint3);
        int size = list == null ? 0 : list.size();
        for (int i16 = 0; i16 < size; i16++) {
            M(i16, list.get(i16));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.A;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.K == null) {
            this.K = new a(20);
        }
        return this.K;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 2;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int t(float f16, float f17, float f18, float f19) {
        float w3 = f16 / w();
        RectF rectF = this.f66949r;
        RectF rectF2 = new RectF(rectF.left * w3, rectF.top * w3, rectF.right * w3, rectF.bottom * w3);
        RectF rectF3 = this.f66948q;
        RectF rectF4 = new RectF(rectF3.left * w3, rectF3.top * w3, rectF3.right * w3, rectF3.bottom * w3);
        PointF pointF = new PointF((-f16) / 2.0f, (-f17) / 2.0f);
        if (Q(f18, f19, rectF2, pointF)) {
            return 1;
        }
        return Q(f18, f19, rectF4, pointF) ? 0 : -1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int u(MotionEvent motionEvent, float f16, float f17, g.c cVar, zr.c cVar2) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (cVar != null) {
            return cVar2.p(cVar, x16, y16);
        }
        PointF pointF = new PointF((f16 - w()) / 2.0f, (f17 - m()) / 2.0f);
        if (Q(x16, y16, this.f66949r, pointF)) {
            return 1;
        }
        return Q(x16, y16, this.f66948q, pointF) ? 0 : -1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f66957z;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        this.J = 0;
        this.B.b(canvas, 0, 0);
        int g16 = ((int) (this.J + this.B.g())) + this.f66954w;
        this.J = g16;
        this.C.b(canvas, 0, g16);
        int g17 = ((int) (this.J + this.C.g())) + this.f66955x;
        this.J = g17;
        this.D.b(canvas, 0, g17);
        if (super.H(1)) {
            RectF rectF = this.f66949r;
            ai aiVar = this.D;
            rectF.set(aiVar.f(2, aiVar.c()));
            RectF rectF2 = this.f66949r;
            float f16 = rectF2.top;
            int i3 = this.J;
            rectF2.top = f16 + i3;
            rectF2.bottom += i3;
            canvas.drawRoundRect(rectF2, 6.0f, 6.0f, j());
        }
        this.J = (int) (this.J + this.D.g());
        if (super.H(0)) {
            this.f66949r.left = 0.0f;
            RectF rectF3 = this.f66948q;
            rectF3.top = 0.0f;
            rectF3.right = this.B.h();
            this.f66948q.bottom = this.B.g();
            canvas.drawRoundRect(this.f66948q, 6.0f, 6.0f, j());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        if (i3 < 0 || i3 >= o()) {
            return;
        }
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        this.f66950s = BaseAIOUtils.f(18.0f, BaseApplication.getContext().getResources());
        if (i3 == 0) {
            String str2 = " " + k3;
            ai aiVar = new ai(0);
            this.B = aiVar;
            aiVar.k(new x(-16777216, this.H, this.I));
            this.B.i(str2, M, this.G, this.f66956y);
            this.f66957z = Math.max(this.B.h(), this.C.h());
            this.f66957z = Math.max(this.D.h(), this.f66957z);
            this.A = this.B.g() + this.f66954w + this.C.g() + this.f66955x + this.D.g();
            return;
        }
        if (k3.length() > 18) {
            this.f66951t = k3.substring(0, 18);
        } else {
            this.f66951t = k3;
        }
        this.D.i(this.f66953v + "\n" + this.f66951t, M, this.F, this.f66947p);
    }

    private boolean Q(float f16, float f17, RectF rectF, PointF pointF) {
        if (rectF != null && pointF != null) {
            float f18 = rectF.left;
            float f19 = pointF.x;
            float f26 = rectF.top;
            float f27 = pointF.y;
            RectF rectF2 = new RectF(f18 + f19, f26 + f27, rectF.right + f19, rectF.bottom + f27);
            if (f16 > rectF2.left && f16 < rectF2.right && f17 > rectF2.top && f17 < rectF2.bottom) {
                return true;
            }
        }
        return false;
    }
}
