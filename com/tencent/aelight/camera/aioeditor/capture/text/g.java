package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends DynamicTextItem {
    private int A;
    private TextPaint B;
    StaticLayout C;
    Resources D;
    private RectF E;
    private float F;
    float G;
    float H;
    float I;
    float J;
    private InputFilter K;

    /* renamed from: p, reason: collision with root package name */
    ArrayList<f> f67028p;

    /* renamed from: q, reason: collision with root package name */
    f f67029q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f67030r;

    /* renamed from: s, reason: collision with root package name */
    private TextPaint f67031s;

    /* renamed from: t, reason: collision with root package name */
    boolean f67032t;

    /* renamed from: u, reason: collision with root package name */
    private int f67033u;

    /* renamed from: v, reason: collision with root package name */
    private int f67034v;

    /* renamed from: w, reason: collision with root package name */
    boolean f67035w;

    /* renamed from: x, reason: collision with root package name */
    private int f67036x;

    /* renamed from: y, reason: collision with root package name */
    private int f67037y;

    /* renamed from: z, reason: collision with root package name */
    private int f67038z;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends EditTextDialog.j {
        a(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j
        public int a(CharSequence charSequence) {
            return 0;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int i19;
            int i26;
            String replaceAll = charSequence.subSequence(i3, i16).toString().replaceAll("\n", "");
            boolean z16 = i16 - i3 != replaceAll.length();
            if (z16) {
                i26 = replaceAll.length();
                i19 = 0;
            } else {
                replaceAll = charSequence;
                i19 = i3;
                i26 = i16;
            }
            CharSequence filter = super.filter(replaceAll, i19, i26, spanned, i17, i18);
            return (filter == null && z16) ? replaceAll : filter;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<f> f67040a;

        /* renamed from: b, reason: collision with root package name */
        Typeface f67041b;

        /* renamed from: c, reason: collision with root package name */
        int f67042c;

        /* renamed from: d, reason: collision with root package name */
        boolean f67043d;

        /* renamed from: e, reason: collision with root package name */
        float f67044e;

        /* renamed from: f, reason: collision with root package name */
        float f67045f;

        /* renamed from: g, reason: collision with root package name */
        float f67046g;

        /* renamed from: h, reason: collision with root package name */
        int f67047h;

        /* renamed from: i, reason: collision with root package name */
        boolean f67048i;

        /* renamed from: j, reason: collision with root package name */
        float f67049j;

        /* renamed from: k, reason: collision with root package name */
        int f67050k;

        public b() {
            ArrayList<f> arrayList = new ArrayList<>();
            this.f67040a = arrayList;
            this.f67041b = null;
            this.f67043d = false;
            this.f67044e = 0.0f;
            this.f67045f = 0.0f;
            this.f67046g = 0.0f;
            this.f67047h = 0;
            this.f67048i = false;
            this.f67049j = 0.0f;
            this.f67050k = 0;
            arrayList.clear();
        }

        public void a(f fVar) {
            this.f67040a.add(fVar);
        }

        public g b(int i3, List<String> list) {
            g gVar = new g(i3, list);
            gVar.f67028p.clear();
            gVar.f67028p.addAll(this.f67040a);
            Typeface typeface = this.f67041b;
            if (typeface != null) {
                gVar.W(typeface);
            }
            gVar.T(this.f67042c);
            if (this.f67043d) {
                gVar.V(this.f67044e, this.f67045f, this.f67046g, this.f67047h);
            }
            gVar.U(this.f67048i, this.f67049j, this.f67050k);
            if (!list.isEmpty()) {
                gVar.M(0, list.get(0));
            }
            return gVar;
        }

        public void c(int i3) {
            this.f67042c = i3;
        }

        public void d(Typeface typeface) {
            this.f67041b = typeface;
        }
    }

    public g(int i3, List<String> list) {
        super(i3, list);
        this.f67028p = new ArrayList<>();
        this.f67029q = null;
        this.f67030r = null;
        this.f67031s = null;
        this.f67032t = false;
        this.f67033u = 0;
        this.f67034v = 0;
        this.f67035w = false;
        this.f67036x = 0;
        this.f67037y = 0;
        this.f67038z = 0;
        this.A = 0;
        this.B = null;
        this.E = new RectF();
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = null;
        this.D = BaseApplication.getContext().getResources();
        TextPaint textPaint = new TextPaint();
        this.f67031s = textPaint;
        textPaint.setAntiAlias(true);
        this.f67031s.setColor(-16777216);
        Paint paint = new Paint();
        this.f67030r = paint;
        paint.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.B = textPaint2;
        textPaint2.setAntiAlias(true);
        this.B.setStyle(Paint.Style.FILL_AND_STROKE);
        this.B.setStrokeJoin(Paint.Join.ROUND);
        this.B.setColor(-16777216);
        this.B.setStrokeWidth(BaseAIOUtils.f(3.0f, BaseApplication.getContext().getResources()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z16, float f16, int i3) {
        this.f67032t = z16;
        if (z16) {
            this.f67033u = BaseAIOUtils.f(f16, BaseApplication.getContext().getResources());
            this.f67034v = i3;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        canvas.save();
        canvas.drawBitmap(this.f67029q.f67016i, 0.0f, 0.0f, this.f67030r);
        StaticLayout staticLayout = this.f66898k;
        if (staticLayout != null) {
            this.I = super.x(staticLayout);
            float height = this.f66898k.getHeight();
            this.J = height;
            f fVar = this.f67029q;
            float f16 = fVar.f67012e + ((fVar.f67010c - this.I) / 2.0f);
            this.G = f16;
            float f17 = fVar.f67013f + ((fVar.f67011d - height) / 2.0f);
            this.H = f17;
            canvas.translate(f16, f17);
            if (this.f67032t) {
                this.B.setStrokeWidth(this.f67033u);
                this.B.setColor(this.f67034v);
                this.C.draw(canvas);
            }
            if (this.f67035w) {
                this.B.setStrokeWidth(this.f67036x);
                this.B.setColor(this.A);
                canvas.translate(this.f67037y, this.f67038z);
                this.C.draw(canvas);
                canvas.translate(-this.f67037y, -this.f67038z);
            }
            this.f66898k.draw(canvas);
            if (super.H(0)) {
                RectF rectF = this.E;
                float f18 = this.F;
                rectF.left = 0.0f - f18;
                rectF.top = 0.0f - f18;
                rectF.right = this.I + (f18 * 2.0f);
                rectF.bottom = this.J + (f18 * 2.0f);
                canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
            }
        }
        canvas.restore();
    }

    public void T(int i3) {
        this.f67031s.setColor(i3);
    }

    public void W(Typeface typeface) {
        this.f67031s.setTypeface(typeface);
        this.B.setTypeface(typeface);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int h() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67029q.f67016i.getHeight();
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
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f67029q.f67016i.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(float f16, float f17, float f18, int i3) {
        this.f67035w = true;
        this.A = i3;
        this.f67036x = BaseAIOUtils.f(f16, BaseApplicationImpl.getApplication().getResources());
        this.f67037y = BaseAIOUtils.f(f17, BaseApplicationImpl.getApplication().getResources());
        this.f67038z = BaseAIOUtils.f(f18, BaseApplicationImpl.getApplication().getResources());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "  ";
        }
        String e16 = e(10, k3);
        Point[] pointArr = new Point[this.f67028p.size()];
        float[] fArr = new float[this.f67028p.size()];
        boolean[] zArr = new boolean[this.f67028p.size()];
        StaticLayout[] staticLayoutArr = new StaticLayout[this.f67028p.size()];
        StaticLayout[] staticLayoutArr2 = new StaticLayout[this.f67028p.size()];
        int[] iArr = new int[this.f67028p.size()];
        boolean z16 = 0;
        int i16 = 0;
        while (i16 < this.f67028p.size()) {
            pointArr[i16] = new Point(z16, z16);
            f fVar = this.f67028p.get(i16);
            zArr[i16] = z16;
            int i17 = i16;
            zArr[i17] = S(fVar.f67010c, fVar.f67011d, fVar.f67015h, fVar.f67014g, e16, fVar.f67008a, fVar.f67018k, pointArr[i16]);
            StaticLayout staticLayout = this.f66898k;
            staticLayoutArr[i17] = staticLayout;
            staticLayoutArr2[i17] = this.C;
            fArr[i17] = staticLayout.getPaint().getTextSize();
            i16 = i17 + 1;
            iArr = iArr;
            z16 = z16;
        }
        boolean z17 = z16;
        int[] iArr2 = iArr;
        float[] fArr2 = new float[this.f67028p.size()];
        for (?? r75 = z16; r75 < this.f67028p.size(); r75++) {
            f fVar2 = this.f67028p.get(r75);
            this.f67031s.setTextSize(fArr[r75]);
            this.B.setTextSize(fArr[r75]);
            iArr2[r75] = staticLayoutArr[r75].getLineCount();
            if (zArr[r75]) {
                fArr2[r75] = (super.x(staticLayoutArr[r75]) * staticLayoutArr[r75].getHeight()) / (BaseAIOUtils.f(fVar2.f67010c, this.D) * BaseAIOUtils.f(fVar2.f67011d, this.D));
            } else {
                fArr2[r75] = 0.0f;
            }
            if (QLog.isColorLevel()) {
                QLog.i("BasicTextRegionTextItem", 2, "scale:" + fArr2[r75] + " index:" + r75);
            }
        }
        int size = this.f67028p.size() - 1;
        for (int size2 = this.f67028p.size() - 1; size2 >= 0; size2--) {
            boolean z18 = zArr[size2];
            if (!z18 || !zArr[size]) {
                if (fArr2[size2] > fArr2[size]) {
                    if ((z18 && zArr[size] && iArr2[size2] > iArr2[size]) ? true : z17) {
                    }
                }
            }
            size = size2;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BasicTextRegionTextItem", 2, "curIndex:" + size);
        }
        this.f67029q = this.f67028p.get(size);
        this.f66898k = staticLayoutArr[size];
        this.C = staticLayoutArr2[size];
        this.f67031s.setTextSize(fArr[size]);
        this.B.setTextSize(fArr[size]);
    }

    private boolean S(int i3, int i16, int i17, int i18, String str, int i19, int i26, Point point) {
        boolean z16;
        for (int i27 = i17; i27 >= i18; i27--) {
            float f16 = i27;
            this.f67031s.setTextSize(f16);
            this.B.setTextSize(f16);
            StaticLayout a16 = ag.a(str, 0, str.length(), this.f67031s, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, i26);
            StaticLayout a17 = ag.a(str, 0, str.length(), this.B, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, null, 0, i26);
            this.f66898k = a16;
            this.C = a17;
            if (a16.getLineCount() > 1) {
                z16 = a16.getLineVisibleEnd(1) >= str.length();
                if (QLog.isColorLevel()) {
                    QLog.d("BasicTextRegionTextItem", 2, "[" + str.length() + "," + i19 + "," + a16.getLineEnd(0));
                }
                if (str.length() >= i19 && a16.getLineEnd(0) < i19) {
                    z16 = false;
                }
            } else {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BasicTextRegionTextItem", 2, "==>" + a16.getHeight() + " ==>" + i16 + " ==>" + i27 + " ==>" + i18);
            }
            if (a16.getHeight() > i16) {
                z16 = false;
            }
            if (z16) {
                point.set((int) (i3 - super.x(a16)), (int) (i16 - a16.getHeight()));
                return true;
            }
            point.set(0, 0);
        }
        return false;
    }
}
