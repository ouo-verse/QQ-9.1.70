package b13;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.vas.api.IEmoticonSpanApi;
import com.tencent.mobileqq.vas.font.drawable.ETDrawable;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.CharCompanionObject;
import m.e;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g extends m.e implements e.a {
    private Paint A;
    private ArrayList<Integer> B;
    private boolean C;
    private int[] D;
    private int E;
    private int F;
    private List<List<m.f>> G;
    private List<m.f> H;
    private List<m.f> I;
    private List<m.f> J;
    private int K;
    private int L;
    private int M;
    private int N;
    private b O;
    private int[] P;
    private int[] Q;
    private int R;
    private long S;
    private boolean T;

    /* renamed from: i, reason: collision with root package name */
    private final ETDrawable f27684i;

    /* renamed from: j, reason: collision with root package name */
    protected int f27685j;

    /* renamed from: k, reason: collision with root package name */
    protected int f27686k;

    /* renamed from: l, reason: collision with root package name */
    protected int f27687l;

    /* renamed from: m, reason: collision with root package name */
    protected int f27688m;

    /* renamed from: n, reason: collision with root package name */
    protected int[] f27689n;

    /* renamed from: o, reason: collision with root package name */
    protected int[] f27690o;

    /* renamed from: p, reason: collision with root package name */
    protected int[] f27691p;

    /* renamed from: q, reason: collision with root package name */
    protected int[] f27692q;

    /* renamed from: r, reason: collision with root package name */
    protected int[] f27693r;

    /* renamed from: s, reason: collision with root package name */
    protected int[] f27694s;

    /* renamed from: t, reason: collision with root package name */
    protected int[] f27695t;

    /* renamed from: v, reason: collision with root package name */
    protected Paint f27697v;

    /* renamed from: w, reason: collision with root package name */
    protected Path f27698w;

    /* renamed from: y, reason: collision with root package name */
    private Canvas f27700y;

    /* renamed from: z, reason: collision with root package name */
    private Canvas f27701z;

    /* renamed from: u, reason: collision with root package name */
    protected int[] f27696u = new int[2];

    /* renamed from: x, reason: collision with root package name */
    private int[] f27699x = new int[2];
    private IEmoticonSpanApi U = IEmoticonSpanApi.INSTANCE.a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            g gVar = g.this;
            if (intValue >= gVar.f415889b[0]) {
                gVar.f415893f.cancel();
                g.this.f415894g = 0;
                g gVar2 = g.this;
                gVar2.f415892e.mShouldDisplayAnimation = false;
                gVar2.f27684i.X();
                g.this.f27684i.g0();
                return;
            }
            if (intValue > gVar.f415894g) {
                g.this.f415894g = intValue;
                g.this.f27684i.X();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b implements Comparator<CharacterStyle> {

        /* renamed from: d, reason: collision with root package name */
        Spanned f27703d;

        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            Spanned spanned = this.f27703d;
            if (spanned == null) {
                return 0;
            }
            int spanStart = spanned.getSpanStart(characterStyle);
            int spanStart2 = this.f27703d.getSpanStart(characterStyle2);
            if (spanStart == spanStart2) {
                int spanEnd = this.f27703d.getSpanEnd(characterStyle);
                int spanEnd2 = this.f27703d.getSpanEnd(characterStyle2);
                if (spanEnd == spanEnd2) {
                    return 0;
                }
                if (spanEnd > spanEnd2) {
                    return 1;
                }
                return -1;
            }
            if (spanStart > spanStart2) {
                return 1;
            }
            return -1;
        }

        void b(Spanned spanned) {
            this.f27703d = spanned;
        }
    }

    public g(ETDrawable eTDrawable, ETFont eTFont) {
        this.f415892e = eTFont;
        this.f27684i = eTDrawable;
        this.O = new b();
        this.f415895h = new Canvas();
    }

    private void B() {
        Canvas canvas = this.f27701z;
        if (canvas == null) {
            this.f27701z = new Canvas(this.f415888a);
        } else {
            canvas.setBitmap(this.f415888a);
        }
        if (this.A == null) {
            Paint paint = new Paint();
            this.A = paint;
            paint.setColor(-16777216);
        }
        int i3 = 2;
        while (true) {
            int[] iArr = this.Q;
            if (i3 < iArr.length) {
                int i16 = iArr[i3];
                int i17 = iArr[i3 + 1];
                int i18 = iArr[i3 + 2];
                int i19 = iArr[i3 + 3];
                int i26 = iArr[i3 + 4];
                m.f fVar = this.I.get(i16);
                float f16 = i26;
                this.A.setTextSize(f16);
                this.f27701z.drawText(String.valueOf(fVar.f415897b), i17, i18 + ((f16 / 2.0f) - ((this.A.descent() + this.A.ascent()) / 2.0f)), this.A);
                i3 += 5;
            } else {
                return;
            }
        }
    }

    private int C(CharSequence charSequence, int i3, CharacterStyle[] characterStyleArr, Spanned spanned, int i16, int i17) {
        boolean z16;
        CharacterStyle characterStyle = characterStyleArr[i17];
        int spanStart = spanned.getSpanStart(characterStyle);
        int spanEnd = spanned.getSpanEnd(characterStyle);
        if (spanEnd == spanned.length()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (spanStart > i16 && spanEnd > spanStart) {
            E(null, com.etrump.mixlayout.e.B(charSequence, i16, spanStart), i16, i3, 0, this.R);
        }
        if (characterStyle instanceof ClickableSpan) {
            E(null, com.etrump.mixlayout.e.B(charSequence, spanStart, spanEnd), spanStart, i3, 1, this.R);
        } else if (!this.U.isEmoticonSpan(characterStyle) && !(characterStyle instanceof y03.d)) {
            if (characterStyle instanceof RelativeSizeSpan) {
                E((RelativeSizeSpan) characterStyle, com.etrump.mixlayout.e.B(charSequence, spanStart, spanEnd), spanStart, i3, 3, this.R);
            } else {
                m.d.a(g(), "Un Know CharacterStyle   start:" + spanStart + "  end:" + spanEnd);
            }
        } else {
            D(characterStyle);
        }
        if (i17 == characterStyleArr.length - 1 && !z16) {
            E(null, com.etrump.mixlayout.e.B(charSequence, spanEnd, spanned.length()), spanEnd, i3, 0, this.R);
        }
        return spanEnd;
    }

    private boolean D(CharacterStyle characterStyle) {
        int i3;
        int i16;
        if (this.U.isEmoticonSpan(characterStyle)) {
            Rect rect = this.U.getRect(characterStyle);
            if (rect == null) {
                return false;
            }
            i16 = rect.width();
            i3 = rect.height();
        } else if (characterStyle instanceof y03.d) {
            y03.d dVar = (y03.d) characterStyle;
            i16 = dVar.b();
            i3 = dVar.a();
        } else {
            i3 = 0;
            i16 = 0;
        }
        m.f H = H();
        H.f415897b = CharCompanionObject.MAX_VALUE;
        H.f415904i = false;
        H.f415899d = i16;
        H.f415900e = i3;
        H.f415905j = characterStyle;
        H.f415896a = 2;
        this.I.add(H);
        return true;
    }

    private boolean E(RelativeSizeSpan relativeSizeSpan, CharSequence charSequence, int i3, int i16, int i17, int i18) {
        float f16;
        if (relativeSizeSpan != null) {
            f16 = relativeSizeSpan.getSizeChange();
        } else {
            f16 = 1.0f;
        }
        int length = charSequence.length();
        for (int i19 = 0; i19 < length; i19++) {
            char charAt = charSequence.charAt(i19);
            int i26 = i3 + i19;
            int[] iArr = this.D;
            float f17 = i26 < iArr.length ? iArr[i26] : i16;
            if (f17 <= 0.0f) {
                f17 = i16;
            }
            int d16 = (int) ((f17 * m.b.d(this.f415892e.mFontId)) / m.b.i(this.f415892e.mFontId));
            m.f H = H();
            H.f415904i = false;
            H.f415896a = i17;
            H.f415897b = charAt;
            if (charAt == '\n') {
                H.f415899d = d16;
                H.f415900e = i18;
            } else {
                H.f415899d = (int) (d16 * f16);
                H.f415900e = (int) (i18 * f16);
            }
            this.I.add(H);
        }
        return true;
    }

    private void F(CharSequence charSequence, int i3, CharacterStyle[] characterStyleArr, Spanned spanned) {
        if (spanned != null && characterStyleArr.length > 0) {
            int i16 = 0;
            for (int i17 = 0; i17 < characterStyleArr.length; i17++) {
                i16 = C(charSequence, i3, characterStyleArr, spanned, i16, i17);
            }
            return;
        }
        E(null, charSequence, 0, i3, 0, this.R);
    }

    private m.f H() {
        if (this.J.isEmpty()) {
            return new m.f();
        }
        return this.J.remove(0);
    }

    private void J() {
        if (this.C) {
            return;
        }
        this.C = true;
        if (this.G == null) {
            this.G = new ArrayList();
        }
        if (this.I == null) {
            this.I = new ArrayList();
        }
        if (this.H == null) {
            this.H = new ArrayList();
        }
        if (this.J == null) {
            this.J = new ArrayList();
        }
        if (this.K <= 0 || this.L <= 0) {
            DisplayMetrics displayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
            this.K = displayMetrics.widthPixels;
            this.L = displayMetrics.heightPixels;
        }
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        Rect rect = new Rect();
        this.f27684i.getPadding(rect);
        this.f27685j = rect.left;
        this.f27686k = rect.right;
        this.f27687l = rect.top;
        this.f27688m = rect.bottom;
        if (this.f27697v == null) {
            Paint paint = new Paint(1);
            this.f27697v = paint;
            paint.setDither(true);
            this.f27697v.setFilterBitmap(true);
            this.f27697v.setStyle(Paint.Style.FILL);
        }
        this.f27698w = new Path();
    }

    private boolean K() {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3 = this.M;
        int i16 = this.f27685j;
        int i17 = this.f27686k;
        boolean z19 = true;
        if ((i3 - i16) - i17 <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z26 = z16 | false;
        int i18 = this.N;
        int i19 = this.f27687l;
        int i26 = this.f27688m;
        if ((i18 - i19) - i26 <= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z27 = z26 | z17;
        if ((i3 - i16) - i17 > this.K) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean z28 = z18 | z27;
        if ((i18 - i19) - i26 <= this.L) {
            z19 = false;
        }
        return z28 | z19;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        m.c e16 = m.c.e();
        ETFont eTFont = this.f415892e;
        e16.k(eTFont.mFontId, this.f27689n, this.f27690o, this.f27691p, this.f27692q, this.f27693r, this.P, this.E, this.R, this.F, eTFont.mAnimationId, this.f415894g, this.f415888a, this.f415889b, this.f415892e.mComboIndex);
        int[] iArr = this.f415889b;
        int i3 = iArr[0];
        this.f415890c = i3;
        int i16 = iArr[1];
        this.f415891d = i16;
        if (i3 > 0 && i16 > 0) {
            c();
            return;
        }
        m.d.a(g(), "StartAnimation......\u52a8\u753b\u5e27\u6570\u548c\u5e27\u95f4\u9694\u6570\u636e\u5f02\u5e38 animInfo:" + Arrays.toString(this.f415889b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f415894g = 0;
        this.f415892e.mShouldDisplayAnimation = false;
        v();
        this.f27684i.g0();
        this.f27684i.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(int i3) {
        if (i3 > this.f415894g) {
            this.f415894g = i3;
            v();
            this.f27684i.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(ValueAnimator valueAnimator) {
        final int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue >= this.f415890c) {
            this.f415893f.cancel();
            FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.M();
                }
            });
        } else if (intValue > this.f415894g) {
            FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.N(intValue);
                }
            });
        }
    }

    private void P() {
        for (int i3 = 0; i3 < this.f27689n.length; i3++) {
            m.f fVar = this.I.get(i3);
            if (this.P[i3] == 1) {
                this.B.add(Integer.valueOf(i3));
                fVar.f415904i = true;
            }
            if (this.f27694s[i3] >= this.G.size()) {
                for (int size = this.G.size(); size <= this.f27694s[i3]; size++) {
                    this.G.add(size, new ArrayList());
                }
            }
            List<m.f> list = this.G.get(this.f27694s[i3]);
            m.f H = H();
            int i16 = this.f27690o[i3];
            int i17 = this.f27692q[i3];
            H.f415901f = i16 - (i17 / 2);
            int i18 = this.f27691p[i3];
            int i19 = this.f27693r[i3];
            H.f415902g = i18 - (i19 / 2);
            H.f415899d = i17;
            H.f415900e = i19;
            H.f415897b = fVar.f415897b;
            H.f415904i = fVar.f415904i;
            H.f415905j = fVar.f415905j;
            H.f415896a = fVar.f415896a;
            this.H.add(H);
            list.add(this.f27695t[i3], H);
        }
    }

    private void Q() {
        int size = this.I.size();
        this.f27689n = new int[size];
        this.f27690o = new int[size];
        this.f27691p = new int[size];
        this.f27692q = new int[size];
        this.f27693r = new int[size];
        this.P = new int[size];
        this.f27694s = new int[size];
        this.f27695t = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            m.f fVar = this.I.get(i3);
            int[] iArr = this.f27689n;
            char c16 = fVar.f415897b;
            iArr[i3] = c16;
            this.f27690o[i3] = fVar.f415901f;
            this.f27691p[i3] = fVar.f415902g;
            this.f27692q[i3] = fVar.f415899d;
            this.f27693r[i3] = fVar.f415900e;
            int[] iArr2 = this.P;
            iArr2[i3] = 0;
            if (c16 == '\uffff') {
                iArr2[i3] = 2;
            }
            if (c16 == '\n') {
                iArr2[i3] = 3;
            }
        }
    }

    private boolean R() {
        this.B.clear();
        if (!f((this.M - this.f27685j) - this.f27686k, (this.N - this.f27687l) - this.f27688m) || this.I.size() <= 0) {
            return false;
        }
        int size = this.I.size();
        boolean z16 = true;
        for (int i3 = 0; i3 < size; i3++) {
            m.f fVar = this.I.get(i3);
            this.f27689n[i3] = fVar.f415897b;
            this.f27690o[i3] = fVar.f415901f;
            this.f27691p[i3] = fVar.f415902g;
            this.f27692q[i3] = fVar.f415899d;
            this.f27693r[i3] = fVar.f415900e;
            if (fVar.f415896a != 2) {
                z16 = false;
            }
        }
        if (z16) {
            return false;
        }
        return true;
    }

    private void u() {
        if (this.f415892e != null && !K()) {
            ValueAnimator valueAnimator = this.f415893f;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return;
            }
            if (m.c.f415878f) {
                m.d.b(g(), "StartAnimation......animInfo:" + Arrays.toString(this.f415889b));
            }
            this.f415894g = 0;
            if (this.f415890c > 0 && this.f415891d > 0) {
                c();
            } else {
                FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.L();
                    }
                });
            }
        }
    }

    private void v() {
        if (K()) {
            m.d.b(g(), "ExpressionLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8\uff01");
            return;
        }
        if (!R()) {
            m.d.b(g(), "ExpressionLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return;
        }
        d();
        m.c e16 = m.c.e();
        ETFont eTFont = this.f415892e;
        e16.k(eTFont.mFontId, this.f27689n, this.f27690o, this.f27691p, this.f27692q, this.f27693r, this.P, this.E, this.R, this.F, eTFont.mAnimationId, this.f415894g, this.f415888a, this.f415889b, this.f415892e.mComboIndex);
    }

    private float w(CharSequence charSequence, int i3) {
        this.D = new int[i3];
        int[] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = charSequence.charAt(i16);
        }
        float textSize = this.f27684i.getTextSize();
        int i17 = (int) textSize;
        m.c.e().f(this.f415892e.mFontId, iArr, i17, this.D);
        for (int i18 = 0; i18 < i3; i18++) {
            int i19 = this.D[i18];
            if (i19 <= 0) {
                float measureText = this.f27684i.getPaint().measureText(String.valueOf((char) iArr[i18]));
                if (measureText <= 0.0f) {
                    measureText = i17;
                }
                i19 = (int) ((measureText * m.b.d(this.f415892e.mFontId)) / m.b.i(this.f415892e.mFontId));
                this.B.add(Integer.valueOf(i18));
            }
            this.D[i18] = i19;
        }
        return textSize;
    }

    private void x(int i3, int i16, CharSequence charSequence) {
        Spanned spanned;
        CharacterStyle[] characterStyleArr;
        J();
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            this.M = this.f27684i.getETMaxWidth().intValue();
        } else {
            this.M = Math.min(this.f27684i.getETMaxWidth().intValue(), size);
        }
        this.F = (this.M - this.f27685j) - this.f27686k;
        this.N = 0;
        int length = charSequence.length();
        int size2 = this.J.size();
        if (size2 < length && !this.I.isEmpty()) {
            while (size2 < length) {
                if (!this.I.isEmpty()) {
                    this.J.add(this.I.remove(0));
                }
                size2++;
            }
        }
        this.I.clear();
        this.G.clear();
        this.H.clear();
        float w3 = w(charSequence, length);
        if (charSequence instanceof Spanned) {
            spanned = (Spanned) charSequence;
            characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, spanned.length(), CharacterStyle.class);
            this.O.b(spanned);
            Arrays.sort(characterStyleArr, this.O);
        } else {
            spanned = null;
            characterStyleArr = null;
        }
        this.E = (int) ((m.b.j(this.f415892e.mFontId) * w3) / m.b.i(this.f415892e.mFontId));
        this.R = (int) ((m.b.d(this.f415892e.mFontId) * w3) / m.b.i(this.f415892e.mFontId));
        F(charSequence, (int) w3, characterStyleArr, spanned);
        Q();
        m.c e16 = m.c.e();
        ETFont eTFont = this.f415892e;
        int[] a16 = e16.a(eTFont.mFontId, this.f27689n, this.f27690o, this.f27691p, this.f27692q, this.f27693r, this.P, this.f27694s, this.f27695t, this.E, this.R, this.F, eTFont.mAnimationId);
        this.Q = a16;
        if (a16 != null && a16.length >= 2) {
            this.M = a16[0] + this.f27685j + this.f27686k;
            this.N = a16[1] + this.f27687l + this.f27688m;
            P();
            T();
            return;
        }
        this.M = size;
        this.N = View.MeasureSpec.getSize(i16);
    }

    private boolean y(Canvas canvas) {
        if (K()) {
            m.d.b(g(), "ExpressionLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8\uff01");
            return false;
        }
        if (!R()) {
            m.d.b(g(), "ExpressionLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return false;
        }
        long nanoTime = System.nanoTime();
        B();
        A(canvas);
        z();
        canvas.drawBitmap(this.f415888a, this.f27685j, this.f27687l, (Paint) null);
        if (this.f415892e.mShouldDisplayAnimation && this.f415894g == 0) {
            o();
        }
        if (m.c.f415878f) {
            m.d.c(g(), nanoTime, "\u5b57\u6570\uff1a" + this.f27689n.length + "\n   \u5b57\u53f7\uff1a" + this.f27684i.getTextSize() + "px\n");
            S("ExpressionLayout::onDraw......");
            return true;
        }
        return true;
    }

    private void z() {
        int textSize = this.f27684i.getTextSize() / 15;
        Canvas canvas = this.f27700y;
        if (canvas == null) {
            this.f27700y = new Canvas(this.f415888a);
        } else {
            canvas.setBitmap(this.f415888a);
        }
        int size = this.I.size();
        for (int i3 = 0; i3 < size; i3++) {
            m.f fVar = this.I.get(i3);
            int i16 = this.f27692q[i3];
            int i17 = this.f27693r[i3];
            int i18 = this.f27690o[i3] - (i16 / 2);
            int i19 = this.f27691p[i3] - (i17 / 2);
            int i26 = fVar.f415896a;
            if (i26 != 1) {
                if (i26 == 2) {
                    if (this.U.isEmoticonSpan(fVar.f415905j)) {
                        int i27 = i19 + i17;
                        this.U.draw(fVar.f415905j, this.f27700y, null, 0, 0, i18, i19, i27, i27, this.f27684i.getPaint());
                    } else {
                        CharacterStyle characterStyle = fVar.f415905j;
                        if (characterStyle instanceof y03.d) {
                            y03.d dVar = (y03.d) characterStyle;
                            dVar.C = false;
                            dVar.draw(this.f27700y, null, 0, 0, i18, i19, i19, i19 + i17, this.f27684i.getPaint());
                        }
                    }
                }
            } else {
                this.f27700y.drawBitmap(I(i16, textSize), i18, (i19 + i17) - textSize, this.f27684i.getPaint());
            }
        }
    }

    protected void A(Canvas canvas) {
        if (!this.f27684i.getHasSelected()) {
            return;
        }
        this.f27697v.setColor(-256);
        canvas.drawPath(this.f27698w, this.f27697v);
    }

    public ArrayList<Rect> G() {
        if (this.f27690o == null) {
            return null;
        }
        ArrayList<Rect> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f27690o.length; i3++) {
            int i16 = this.f27690o[i3];
            int i17 = this.f27691p[i3];
            arrayList.add(new Rect(i16, i17, this.f27692q[i3] + i16, this.f27693r[i3] + i17));
        }
        return arrayList;
    }

    protected Bitmap I(int i3, int i16) {
        ETFont eTFont = this.f415892e;
        Bitmap k3 = m.b.k(eTFont.mFontId, eTFont.mComboIndex, i3, i16);
        if (k3 == null) {
            k3 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            m.c e16 = m.c.e();
            ETFont eTFont2 = this.f415892e;
            e16.c(eTFont2.mFontId, k3, null, eTFont2.mComboIndex);
            ETFont eTFont3 = this.f415892e;
            m.b.u(eTFont3.mFontId, eTFont3.mComboIndex, i3, i16, k3);
            if (m.c.f415878f) {
                m.d.b(g(), "create new under line bitmap.... width:" + i3 + "  height:" + i16);
            }
        }
        return k3;
    }

    void S(String str) {
        CharSequence charSequence;
        Integer valueOf;
        int length;
        int width;
        Long valueOf2;
        if (m.c.f415878f) {
            String g16 = g();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("\n  text:");
            ETFont eTFont = this.f415892e;
            Boolean bool = null;
            if (eTFont == null) {
                charSequence = null;
            } else {
                charSequence = eTFont.mText;
            }
            sb5.append((Object) charSequence);
            sb5.append("\n  fontId:");
            ETFont eTFont2 = this.f415892e;
            if (eTFont2 == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(eTFont2.mFontId);
            }
            sb5.append(valueOf);
            sb5.append("\n  chars.length:");
            int[] iArr = this.f27689n;
            if (iArr == null) {
                length = 0;
            } else {
                length = iArr.length;
            }
            sb5.append(length);
            sb5.append("\n  bitmapWidth:");
            Bitmap bitmap = this.f415888a;
            int i3 = -1;
            if (bitmap == null) {
                width = -1;
            } else {
                width = bitmap.getWidth();
            }
            sb5.append(width);
            sb5.append("\n  bitmapHeight:");
            Bitmap bitmap2 = this.f415888a;
            if (bitmap2 != null) {
                i3 = bitmap2.getHeight();
            }
            sb5.append(i3);
            sb5.append("\n  viewWidth:");
            sb5.append((this.M - this.f27685j) - this.f27686k);
            sb5.append("\n  viewHeight:");
            sb5.append((this.N - this.f27687l) - this.f27688m);
            sb5.append("\n  paddingLeft:");
            sb5.append(this.f27685j);
            sb5.append("\n  paddingRight:");
            sb5.append(this.f27686k);
            sb5.append("\n  paddingTop:");
            sb5.append(this.f27687l);
            sb5.append("\n  paddingBottom:");
            sb5.append(this.f27688m);
            sb5.append("\n  screenWidth:");
            sb5.append(this.K);
            sb5.append("\n  screenHeight:");
            sb5.append(this.L);
            sb5.append("\n  x[]:");
            sb5.append(Arrays.toString(this.f27690o));
            sb5.append("\n  y[]:");
            sb5.append(Arrays.toString(this.f27691p));
            sb5.append("\n  width[]:");
            sb5.append(Arrays.toString(this.f27692q));
            sb5.append("\n  height[]:");
            sb5.append(Arrays.toString(this.f27693r));
            sb5.append("\n  mAnimationId:");
            ETFont eTFont3 = this.f415892e;
            if (eTFont3 == null) {
                valueOf2 = null;
            } else {
                valueOf2 = Long.valueOf(eTFont3.mAnimationId);
            }
            sb5.append(valueOf2);
            sb5.append("\n  shouldDisplayAnimation:");
            ETFont eTFont4 = this.f415892e;
            if (eTFont4 != null) {
                bool = Boolean.valueOf(eTFont4.mShouldDisplayAnimation);
            }
            sb5.append(bool);
            sb5.append("\n  frameIndex:");
            sb5.append(this.f415894g);
            sb5.append("\n  animInfo:");
            sb5.append(Arrays.toString(this.f415889b));
            sb5.append("\n");
            m.d.b(g16, sb5.toString());
        }
    }

    public void T() {
        if (!FontInfoManager.INSTANCE.a()) {
            return;
        }
        if (K()) {
            m.d.b(g(), "ExpressionLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8\uff01");
            return;
        }
        if (!R()) {
            m.d.b(g(), "ExpressionLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return;
        }
        d();
        m.c e16 = m.c.e();
        ETFont eTFont = this.f415892e;
        e16.k(eTFont.mFontId, this.f27689n, this.f27690o, this.f27691p, this.f27692q, this.f27693r, this.P, this.E, this.R, this.F, eTFont.mAnimationId, this.f415894g, this.f415888a, this.f415889b, this.f415892e.mComboIndex);
    }

    @Override // m.e.a
    public void a(int i3, int i16) {
        this.f27698w.reset();
        int size = this.H.size();
        for (int i17 = 0; i17 < size; i17++) {
            if (i17 >= i3 && i17 < i16) {
                m.f fVar = this.H.get(i17);
                Path path = this.f27698w;
                int i18 = this.f27685j;
                int i19 = fVar.f415901f;
                int i26 = this.f27687l;
                int i27 = fVar.f415902g;
                path.addRect(i18 + i19, i26 + i27, i18 + i19 + fVar.f415899d, i26 + i27 + fVar.f415900e, Path.Direction.CW);
            }
        }
        this.f27684i.X();
    }

    @Override // m.e.a
    public int b(int i3, int i16) {
        this.f27684i.J(this.f27696u);
        int[] iArr = this.f27696u;
        int i17 = i3 - iArr[0];
        int i18 = i16 - iArr[1];
        int size = this.H.size();
        for (int i19 = 0; i19 < size; i19++) {
            m.f fVar = this.H.get(i19);
            int i26 = this.f27685j;
            int i27 = fVar.f415901f;
            int i28 = i26 + i27;
            int i29 = this.f27687l;
            int i36 = fVar.f415902g;
            int i37 = i29 + i36;
            int i38 = i26 + i27 + fVar.f415899d;
            int i39 = i29 + i36 + fVar.f415900e;
            if (i17 >= i28 && i17 <= i38 && i18 >= i37 && i18 <= i39) {
                return i19;
            }
        }
        int i46 = 0;
        for (int i47 = 0; i47 < this.G.size(); i47++) {
            List<m.f> list = this.G.get(i47);
            if (list != null && list.size() > 0) {
                int i48 = 0;
                for (m.f fVar2 : list) {
                    i48 += this.f27687l + fVar2.f415902g + fVar2.f415900e;
                }
                if (i48 / list.size() < i18 && i47 != this.G.size() - 1) {
                    i46 += list.size();
                } else {
                    for (int i49 = 0; i49 < list.size(); i49++) {
                        m.f fVar3 = list.get(i49);
                        if (i17 <= this.f27685j + fVar3.f415901f + fVar3.f415899d) {
                            return i46 + i49;
                        }
                    }
                    return i46 + list.size();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // m.e
    public void d() {
        if (this.f415895h == null) {
            this.f415895h = new Canvas();
        }
        this.f415895h.setBitmap(this.f415888a);
        this.f415895h.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // m.e
    public void e() {
        super.e();
        if (FontInfoManager.INSTANCE.a()) {
            this.f415893f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b13.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    g.this.O(valueAnimator);
                }
            });
        } else {
            this.f415893f.addUpdateListener(new a());
        }
    }

    @Override // m.e.a
    public void h() {
        this.f27698w.reset();
        this.f27684i.X();
    }

    @Override // m.e.a
    public void i(int i3, int[] iArr, boolean z16) {
        if (!z16) {
            i3--;
        }
        if (i3 >= this.H.size()) {
            i3 = this.H.size() - 1;
        }
        if (i3 < 0) {
            return;
        }
        this.f27684i.J(iArr);
        m.f fVar = this.H.get(i3);
        if (z16) {
            iArr[0] = iArr[0] + this.f27685j + fVar.f415901f;
            iArr[1] = iArr[1] + this.f27687l + fVar.f415902g + fVar.f415900e;
        } else {
            iArr[0] = iArr[0] + this.f27685j + fVar.f415901f + fVar.f415899d;
            iArr[1] = iArr[1] + this.f27687l + fVar.f415902g + fVar.f415900e;
        }
    }

    @Override // m.e
    public boolean j(Canvas canvas) {
        if (FontInfoManager.INSTANCE.a()) {
            return y(canvas);
        }
        if (K()) {
            m.d.b(g(), "ExpressionLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8\uff01");
            return false;
        }
        if (!R()) {
            m.d.b(g(), "ExpressionLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return false;
        }
        d();
        long nanoTime = System.nanoTime();
        B();
        m.c e16 = m.c.e();
        ETFont eTFont = this.f415892e;
        e16.k(eTFont.mFontId, this.f27689n, this.f27690o, this.f27691p, this.f27692q, this.f27693r, this.P, this.E, this.R, this.F, eTFont.mAnimationId, this.f415894g, this.f415888a, this.f415889b, this.f415892e.mComboIndex);
        A(canvas);
        z();
        canvas.drawBitmap(this.f415888a, this.f27685j, this.f27687l, (Paint) null);
        if (this.f415892e.mShouldDisplayAnimation && this.f415894g == 0) {
            o();
        }
        if (m.c.f415878f) {
            m.d.c(g(), nanoTime, "\u5b57\u6570\uff1a" + this.f27689n.length + "\n   \u5b57\u53f7\uff1a" + this.f27684i.getTextSize() + "px\n");
            S("ExpressionLayout::onDraw......");
            return true;
        }
        return true;
    }

    @Override // m.e
    public int[] k(int i3, int i16, long j3, boolean z16, ETFont eTFont) throws Exception {
        ETFont eTFont2;
        if (this.S == j3 && this.T == z16 && (eTFont2 = this.f415892e) != null && eTFont2.equals(eTFont) && this.f27684i.getCacheMeasureResult()) {
            return this.f27699x;
        }
        if (this.S != j3) {
            ETFont eTFont3 = this.f415892e;
            if (eTFont3 != null) {
                eTFont3.mShouldDisplayAnimation = false;
            }
            ValueAnimator valueAnimator = this.f415893f;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.f415894g = 0;
        }
        this.S = j3;
        this.T = z16;
        ETFont eTFont4 = new ETFont(-1, null, 0.0f);
        this.f415892e = eTFont4;
        eTFont4.copy(eTFont);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        ETFont eTFont5 = this.f415892e;
        if (eTFont5 != null && !TextUtils.isEmpty(eTFont5.mFontPath)) {
            CharSequence text = this.f27684i.getText();
            if (TextUtils.isEmpty(text)) {
                int[] iArr = this.f27699x;
                iArr[0] = size;
                iArr[1] = size2;
                return iArr;
            }
            long nanoTime = System.nanoTime();
            try {
                x(i3, i16, text);
                long nanoTime2 = System.nanoTime();
                if (m.c.f415878f) {
                    m.d.b(g(), "\u5b57\u6570\uff1a" + text.length() + "   \u5b57\u53f7\uff1a" + this.f27684i.getTextSize() + "px   \u6392\u7248\u8017\u65f6\uff1a" + (((float) (nanoTime2 - nanoTime)) / 1000000.0f) + "ms");
                }
                if (K()) {
                    int[] iArr2 = this.f27699x;
                    iArr2[0] = size;
                    iArr2[1] = size2;
                    return iArr2;
                }
                int[] iArr3 = this.f27699x;
                iArr3[0] = this.M;
                iArr3[1] = this.N;
                return iArr3;
            } catch (Exception unused) {
                this.f27699x[0] = -1;
                return this.f27699x;
            }
        }
        int[] iArr4 = this.f27699x;
        iArr4[0] = size;
        iArr4[1] = size2;
        return iArr4;
    }

    @Override // m.e
    public void l() {
        super.l();
        this.f27700y = null;
        this.f27701z = null;
        this.f415895h = null;
        Paint paint = this.A;
        if (paint != null) {
            paint.reset();
            this.A = null;
        }
        Paint paint2 = this.f27697v;
        if (paint2 != null) {
            paint2.reset();
        }
        Path path = this.f27698w;
        if (path != null) {
            path.reset();
        }
    }

    @Override // m.e
    public void o() {
        if (FontInfoManager.INSTANCE.a()) {
            u();
            return;
        }
        if (this.f415892e != null && !K()) {
            ValueAnimator valueAnimator = this.f415893f;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return;
            }
            if (m.c.f415878f) {
                m.d.b(g(), "StartAnimation......animInfo:" + Arrays.toString(this.f415889b));
            }
            this.f415894g = 0;
            if (this.f415890c > 0 && this.f415891d > 0) {
                c();
                return;
            }
            m.c e16 = m.c.e();
            ETFont eTFont = this.f415892e;
            e16.k(eTFont.mFontId, this.f27689n, this.f27690o, this.f27691p, this.f27692q, this.f27693r, this.P, this.E, this.R, this.F, eTFont.mAnimationId, this.f415894g, this.f415888a, this.f415889b, this.f415892e.mComboIndex);
            if (this.f415890c > 0 && this.f415891d > 0) {
                c();
                return;
            }
            m.d.a(g(), "StartAnimation......\u52a8\u753b\u5e27\u6570\u548c\u5e27\u95f4\u9694\u6570\u636e\u5f02\u5e38 animInfo:" + Arrays.toString(this.f415889b));
        }
    }
}
