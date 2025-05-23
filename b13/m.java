package b13;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.vas.api.IEmoticonSpanApi;
import com.tencent.mobileqq.vas.font.drawable.ETDrawable;
import com.tencent.mobileqq.vas.font.manager.FontInfoManager;
import com.tencent.mobileqq.vas.font.report.VasFontReporter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.CharCompanionObject;
import m.e;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m extends m.e implements e.a {

    /* renamed from: i0, reason: collision with root package name */
    public static boolean f27710i0 = false;
    protected int A;
    protected int B;
    protected int[] C;
    protected int D;
    protected Paint H;
    protected Path I;
    private long K;
    private SparseIntArray M;
    private ArrayList<Integer> N;
    private int[] O;
    private boolean P;
    private int Q;
    private Paint R;
    private Paint S;
    private List<m.f> T;
    private List<m.f> U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f27711a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f27712b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f27713c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f27714d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f27715e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f27716f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f27717g0;

    /* renamed from: h0, reason: collision with root package name */
    private a f27718h0;

    /* renamed from: i, reason: collision with root package name */
    protected ETDrawable f27719i;

    /* renamed from: j, reason: collision with root package name */
    protected Canvas f27720j;

    /* renamed from: k, reason: collision with root package name */
    protected Canvas f27721k;

    /* renamed from: l, reason: collision with root package name */
    protected List<List<m.f>> f27722l;

    /* renamed from: m, reason: collision with root package name */
    protected List<m.f> f27723m;

    /* renamed from: n, reason: collision with root package name */
    protected int f27724n;

    /* renamed from: o, reason: collision with root package name */
    protected int f27725o;

    /* renamed from: p, reason: collision with root package name */
    protected int f27726p;

    /* renamed from: q, reason: collision with root package name */
    protected int f27727q;

    /* renamed from: r, reason: collision with root package name */
    protected int f27728r;

    /* renamed from: s, reason: collision with root package name */
    protected int f27729s;

    /* renamed from: t, reason: collision with root package name */
    protected int[] f27730t;

    /* renamed from: u, reason: collision with root package name */
    protected int[] f27731u;

    /* renamed from: v, reason: collision with root package name */
    protected int[] f27732v;

    /* renamed from: w, reason: collision with root package name */
    protected int[] f27733w;

    /* renamed from: x, reason: collision with root package name */
    protected int[] f27734x;

    /* renamed from: y, reason: collision with root package name */
    protected int f27735y;

    /* renamed from: z, reason: collision with root package name */
    protected int f27736z;
    protected boolean E = false;
    protected Paint F = new Paint();
    protected int[] G = new int[2];
    private IEmoticonSpanApi J = IEmoticonSpanApi.INSTANCE.a();
    private int[] L = new int[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a implements Comparator<CharacterStyle> {

        /* renamed from: d, reason: collision with root package name */
        Spanned f27737d;

        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(CharacterStyle characterStyle, CharacterStyle characterStyle2) {
            Spanned spanned = this.f27737d;
            if (spanned == null) {
                return 0;
            }
            int spanStart = spanned.getSpanStart(characterStyle);
            int spanStart2 = this.f27737d.getSpanStart(characterStyle2);
            if (spanStart == spanStart2) {
                int spanEnd = this.f27737d.getSpanEnd(characterStyle);
                int spanEnd2 = this.f27737d.getSpanEnd(characterStyle2);
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

        public void b(Spanned spanned) {
            this.f27737d = spanned;
        }
    }

    public m(ETDrawable eTDrawable, ETFont eTFont) {
        this.f27719i = eTDrawable;
        this.f415892e = eTFont;
        Q();
        this.f27718h0 = new a();
        this.F.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private void B(Canvas canvas, m.f fVar) {
        int i3;
        Bitmap b16;
        int i16 = fVar.f415899d;
        if (i16 > 0 && (i3 = fVar.f415900e) > 0) {
            ETFont eTFont = this.f415892e;
            BitmapShader c16 = m.b.c(eTFont.mFontId, eTFont.mComboIndex, i16, i3);
            if (c16 == null) {
                Bitmap createBitmap = Bitmap.createBitmap(fVar.f415899d, fVar.f415900e, Bitmap.Config.ARGB_8888);
                b16 = Bitmap.createBitmap(fVar.f415899d, fVar.f415900e, Bitmap.Config.ARGB_8888);
                m.c e16 = m.c.e();
                ETFont eTFont2 = this.f415892e;
                int c17 = e16.c(eTFont2.mFontId, createBitmap, b16, eTFont2.mComboIndex);
                if (c17 != 0) {
                    if (c17 != 1) {
                        if (c17 == 2) {
                            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                            c16 = new BitmapShader(createBitmap, tileMode, tileMode);
                            ETFont eTFont3 = this.f415892e;
                            m.b.m(eTFont3.mFontId, eTFont3.mComboIndex, fVar.f415899d, fVar.f415900e, c16);
                            ETFont eTFont4 = this.f415892e;
                            m.b.l(eTFont4.mFontId, eTFont4.mComboIndex, fVar.f415899d, fVar.f415900e, b16);
                        }
                    } else {
                        Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                        c16 = new BitmapShader(createBitmap, tileMode2, tileMode2);
                        ETFont eTFont5 = this.f415892e;
                        m.b.m(eTFont5.mFontId, eTFont5.mComboIndex, fVar.f415899d, fVar.f415900e, c16);
                        b16.recycle();
                    }
                } else {
                    createBitmap.recycle();
                    b16.recycle();
                }
                b16 = null;
            } else {
                ETFont eTFont6 = this.f415892e;
                b16 = m.b.b(eTFont6.mFontId, eTFont6.mComboIndex, fVar.f415899d, fVar.f415900e);
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(fVar.f415899d, fVar.f415900e, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = this.f27721k;
            if (canvas2 == null) {
                this.f27721k = new Canvas(createBitmap2);
            } else {
                canvas2.setBitmap(createBitmap2);
            }
            if (b16 != null) {
                this.f27721k.drawBitmap(b16, 0.0f, 0.0f, (Paint) null);
            }
            if (c16 != null) {
                this.S.setShader(c16);
            }
            this.S.setTextSize(fVar.f415900e);
            if (!TextUtils.isEmpty(fVar.f415898c)) {
                this.f27721k.drawText(fVar.f415898c, 0.0f, (int) ((fVar.f415900e / 2.0f) - ((this.S.descent() + this.S.ascent()) / 2.0f)), this.S);
            } else {
                this.f27721k.drawText(String.valueOf(fVar.f415897b), 0.0f, (int) ((fVar.f415900e / 2.0f) - ((this.S.descent() + this.S.ascent()) / 2.0f)), this.S);
            }
            canvas.drawBitmap(createBitmap2, fVar.f415901f, fVar.f415902g, this.S);
            createBitmap2.recycle();
        }
    }

    private boolean D(CharacterStyle characterStyle, int i3, int i16, int i17, boolean z16) {
        int i18;
        int i19;
        if (this.J.isEmoticonSpan(characterStyle)) {
            Rect rect = this.J.getRect(characterStyle);
            if (rect == null) {
                return false;
            }
            i19 = rect.width();
            i18 = rect.height();
        } else if (characterStyle instanceof y03.d) {
            y03.d dVar = (y03.d) characterStyle;
            i19 = dVar.b();
            i18 = dVar.a();
        } else {
            i18 = 0;
            i19 = 0;
        }
        m.f I = I();
        I.f415897b = CharCompanionObject.MAX_VALUE;
        I.f415904i = false;
        I.f415899d = i19;
        I.f415900e = i18;
        I.f415905j = characterStyle;
        I.f415896a = i17;
        int i26 = this.f27713c0;
        if (i26 < i19) {
            this.Y = Math.max(this.X, this.Y);
            int i27 = I.f415899d;
            this.X = i27;
            int i28 = this.Z + 1;
            this.Z = i28;
            I.f415901f = 0;
            I.f415903h = i28;
            this.f27715e0 = i27;
            this.f27713c0 = this.f27714d0 - i27;
            this.f27722l.add(this.T);
            ArrayList arrayList = new ArrayList();
            this.T = arrayList;
            arrayList.add(I);
            this.f27723m.add(I);
        } else {
            this.X += i19;
            int i29 = this.f27715e0;
            I.f415901f = i29;
            I.f415903h = this.Z;
            this.f27713c0 = i26 - i19;
            this.f27715e0 = i29 + i19;
            this.T.add(I);
            this.f27723m.add(I);
        }
        int i36 = this.f27715e0;
        if (i36 > this.Q) {
            this.Q = i36;
        }
        int i37 = this.f27711a0 + 1;
        this.f27711a0 = i37;
        int i38 = this.f27712b0;
        if (i38 > 0 && i37 >= i38) {
            this.f27722l.add(this.T);
            return true;
        }
        if (z16) {
            this.f27722l.add(this.T);
        }
        return false;
    }

    private boolean E(CharSequence charSequence, int i3, int i16, int i17, boolean z16, int i18) {
        int i19;
        int i26;
        boolean z17;
        int i27;
        float f16;
        int i28;
        float f17;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int length = charSequence.length();
        int i46 = 0;
        while (i46 < length) {
            char charAt = charSequence.charAt(i46);
            m.f I = I();
            if (charAt == '\n') {
                I.f415904i = false;
                I.f415896a = i17;
                I.f415899d = 0;
                I.f415900e = i18;
                I.f415897b = charAt;
                I.f415901f = this.f27715e0;
                int i47 = this.Z;
                I.f415903h = i47;
                this.f27713c0 = this.f27714d0;
                this.Z = i47 + 1;
                this.f27715e0 = 0;
                this.Y = Math.max(this.X, this.Y);
                this.X = 0;
                this.T.add(I);
                this.f27722l.add(this.T);
                this.T = new ArrayList();
            } else {
                if (this.M.size() > 0 && (i39 = this.M.get((i38 = i3 + i46))) > 0) {
                    i19 = 0;
                    for (int i48 = 0; i48 < i39; i48++) {
                        i19 += this.O[i38 + i48];
                    }
                } else {
                    i19 = 0;
                }
                if (i17 == 1 && i46 == 0) {
                    i26 = 0;
                    for (int i49 = 0; i49 < length; i49++) {
                        int i56 = i3 + i49;
                        int[] iArr = this.O;
                        if (i56 < iArr.length) {
                            i37 = iArr[i56];
                        } else {
                            i37 = i16;
                        }
                        i26 += i37;
                    }
                } else {
                    i26 = 0;
                }
                int i57 = i3 + i46;
                I.f415904i = this.N.contains(Integer.valueOf(i57));
                I.f415896a = i17;
                if ('\ud800' <= charAt && charAt <= '\udfff') {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && (i36 = i46 + 1) < charSequence.length()) {
                    I.f415898c = charSequence.subSequence(i46, i46 + 2).toString();
                    float[] fArr = new float[2];
                    Paint paint = this.f27719i.getPaint();
                    String str = I.f415898c;
                    paint.getTextWidths(str, 0, str.length(), fArr);
                    f17 = fArr[0];
                    i28 = i36;
                    i27 = i16;
                } else {
                    int[] iArr2 = this.O;
                    if (i57 < iArr2.length) {
                        f16 = iArr2[i57];
                        i27 = i16;
                    } else {
                        i27 = i16;
                        f16 = i27;
                    }
                    float f18 = f16;
                    i28 = i46;
                    f17 = f18;
                }
                int i58 = (int) f17;
                I.f415899d = i58;
                if (I.f415904i) {
                    i29 = i27;
                } else {
                    i29 = i18;
                }
                I.f415900e = i29;
                I.f415897b = charAt;
                int i59 = this.f27713c0;
                if (i59 >= i58 && ((i59 >= i19 || this.f27715e0 == 0) && (i59 >= i26 || this.f27715e0 == 0))) {
                    this.X += i58;
                    int i65 = this.f27715e0;
                    I.f415901f = i65;
                    I.f415903h = this.Z;
                    this.f27713c0 = i59 - i58;
                    this.f27715e0 = i65 + i58;
                    this.T.add(I);
                } else {
                    this.Y = Math.max(this.X, this.Y);
                    int i66 = I.f415899d;
                    this.X = i66;
                    int i67 = this.Z + 1;
                    this.Z = i67;
                    I.f415901f = 0;
                    I.f415903h = i67;
                    this.f27715e0 = i66;
                    this.f27713c0 = this.f27714d0 - i66;
                    this.f27722l.add(this.T);
                    ArrayList arrayList = new ArrayList();
                    this.T = arrayList;
                    arrayList.add(I);
                }
                int i68 = this.f27715e0;
                if (i68 > this.Q) {
                    this.Q = i68;
                }
                int i69 = this.f27711a0 + 1;
                this.f27711a0 = i69;
                int i75 = this.f27712b0;
                if (i75 > 0 && i69 >= i75) {
                    this.f27722l.add(this.T);
                    return true;
                }
                i46 = i28;
            }
            this.f27723m.add(I);
            if (i46 == length - 1 && z16) {
                this.f27722l.add(this.T);
            }
            i46++;
        }
        return false;
    }

    private boolean F(RelativeSizeSpan relativeSizeSpan, CharSequence charSequence, int i3, int i16, int i17, boolean z16, int i18) {
        int i19;
        int i26;
        float f16;
        int i27;
        int i28;
        int i29;
        float sizeChange = relativeSizeSpan.getSizeChange();
        int length = charSequence.length();
        for (int i36 = 0; i36 < length; i36++) {
            char charAt = charSequence.charAt(i36);
            m.f I = I();
            if (charAt == '\n') {
                I.f415904i = false;
                I.f415896a = i17;
                I.f415899d = 0;
                I.f415900e = i18;
                I.f415897b = charAt;
                I.f415901f = this.f27715e0;
                int i37 = this.Z;
                I.f415903h = i37;
                this.f27713c0 = this.f27714d0;
                this.Z = i37 + 1;
                this.f27715e0 = 0;
                this.Y = Math.max(this.X, this.Y);
                this.X = 0;
                this.T.add(I);
                this.f27722l.add(this.T);
                this.T = new ArrayList();
            } else {
                if (this.M.size() > 0 && (i29 = this.M.get((i28 = i3 + i36))) > 0) {
                    i19 = 0;
                    for (int i38 = 0; i38 < i29; i38++) {
                        i19 += this.O[i28 + i38];
                    }
                } else {
                    i19 = 0;
                }
                int i39 = i3 + i36;
                int[] iArr = this.O;
                if (i39 < iArr.length) {
                    f16 = iArr[i39];
                    i26 = i16;
                } else {
                    i26 = i16;
                    f16 = i26 * sizeChange;
                }
                boolean contains = this.N.contains(Integer.valueOf(i39));
                I.f415904i = contains;
                I.f415896a = i17;
                int i46 = (int) f16;
                I.f415899d = i46;
                if (contains) {
                    i27 = i26;
                } else {
                    i27 = i18;
                }
                I.f415900e = (int) (i27 * sizeChange);
                I.f415897b = charAt;
                int i47 = this.f27713c0;
                if (i47 >= i46 && (i47 >= i19 || this.f27715e0 == 0)) {
                    this.X += i46;
                    int i48 = this.f27715e0;
                    I.f415901f = i48;
                    I.f415903h = this.Z;
                    this.f27713c0 = i47 - i46;
                    this.f27715e0 = i48 + i46;
                    this.T.add(I);
                } else {
                    this.Y = Math.max(this.X, this.Y);
                    int i49 = I.f415899d;
                    this.X = i49;
                    int i56 = this.Z + 1;
                    this.Z = i56;
                    I.f415901f = 0;
                    I.f415903h = i56;
                    this.f27715e0 = i49;
                    this.f27713c0 = this.f27714d0 - i49;
                    this.f27722l.add(this.T);
                    ArrayList arrayList = new ArrayList();
                    this.T = arrayList;
                    arrayList.add(I);
                }
                int i57 = this.f27715e0;
                if (i57 > this.Q) {
                    this.Q = i57;
                }
                int i58 = this.f27711a0 + 1;
                this.f27711a0 = i58;
                int i59 = this.f27712b0;
                if (i59 > 0 && i58 >= i59) {
                    this.f27722l.add(this.T);
                    return true;
                }
            }
            this.f27723m.add(I);
            if (i36 == length - 1 && z16) {
                this.f27722l.add(this.T);
            }
        }
        return false;
    }

    private void H(CharSequence charSequence, int i3, int[] iArr, int i16, boolean z16) {
        for (int i17 = 0; i17 < i3; i17++) {
            char charAt = charSequence.charAt(i17);
            iArr[i17] = charAt;
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                if (!z16) {
                    z16 = true;
                    i16 = i17;
                } else if (i17 == i3 - 1) {
                    this.M.put(i16, i3 - i16);
                    z16 = false;
                }
            } else if (z16) {
                this.M.put(i16, i17 - i16);
                z16 = false;
            }
        }
    }

    private m.f I() {
        if (this.U.isEmpty()) {
            return new m.f();
        }
        return this.U.remove(0);
    }

    private void J(int i3, int i16) {
        if (i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            this.f27728r = this.f27719i.getETMaxWidth().intValue();
        } else {
            this.f27728r = Math.min(this.f27719i.getETMaxWidth().intValue(), i16);
        }
    }

    private void K(int i3, int[] iArr, int i16) {
        for (int i17 = 0; i17 < i3; i17++) {
            int i18 = this.O[i17];
            if (i18 <= 0) {
                float measureText = this.f27719i.getPaint().measureText(String.valueOf((char) iArr[i17]));
                if (measureText <= 0.0f) {
                    measureText = i16;
                }
                i18 = (int) ((measureText * m.b.d(this.f415892e.mFontId)) / m.b.i(this.f415892e.mFontId));
                this.N.add(Integer.valueOf(i17));
            }
            this.O[i17] = i18;
        }
    }

    private boolean M(CharSequence charSequence, int i3, int i16, CharacterStyle characterStyle, int i17, int i18, boolean z16) {
        if (characterStyle instanceof ClickableSpan) {
            if (E(com.etrump.mixlayout.e.B(charSequence, i17, i18), i17, i3, 1, z16, i16)) {
                return true;
            }
            return false;
        }
        if (!this.J.isEmoticonSpan(characterStyle) && !(characterStyle instanceof y03.d)) {
            if (characterStyle instanceof RelativeSizeSpan) {
                if (F((RelativeSizeSpan) characterStyle, com.etrump.mixlayout.e.B(charSequence, i17, i18), i17, i3, 3, z16, i16)) {
                    return true;
                }
                return false;
            }
            m.d.a("FontAnimDrawable.FounderColorLayout", "Un Know CharacterStyle   start:" + i17 + "  end:" + i18);
            return false;
        }
        if (D(characterStyle, i17, i18, 2, z16)) {
            return true;
        }
        return false;
    }

    private void N(CharacterStyle[] characterStyleArr, Spanned spanned) {
        for (CharacterStyle characterStyle : characterStyleArr) {
            if (characterStyle instanceof RelativeSizeSpan) {
                int spanEnd = spanned.getSpanEnd(characterStyle);
                float sizeChange = ((RelativeSizeSpan) characterStyle).getSizeChange();
                for (int spanStart = spanned.getSpanStart(characterStyle); spanStart < spanEnd; spanStart++) {
                    this.O[spanStart] = (int) (r5[spanStart] * sizeChange);
                }
            }
        }
    }

    private void O(CharSequence charSequence, int i3, CharacterStyle[] characterStyleArr, Spanned spanned, int i16) {
        boolean z16;
        if (spanned != null && characterStyleArr != null && characterStyleArr.length > 0) {
            N(characterStyleArr, spanned);
            int i17 = 0;
            int i18 = 0;
            while (i18 < characterStyleArr.length) {
                CharacterStyle characterStyle = characterStyleArr[i18];
                int spanStart = spanned.getSpanStart(characterStyle);
                int spanEnd = spanned.getSpanEnd(characterStyle);
                if (spanEnd == spanned.length()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!x(charSequence, i3, i16, i17, spanStart, spanEnd) && !M(charSequence, i3, i16, characterStyle, spanStart, spanEnd, z16)) {
                    if (i18 == characterStyleArr.length - 1 && !z16) {
                        if (E(com.etrump.mixlayout.e.B(charSequence, spanEnd, spanned.length()), spanEnd, i3, 0, true, i16)) {
                            return;
                        }
                    }
                    i18++;
                    i17 = spanEnd;
                } else {
                    return;
                }
            }
            return;
        }
        E(charSequence, 0, i3, 0, true, i16);
    }

    private int P(int i3, int i16, int i17, float f16) {
        int i18;
        int i19;
        int size = this.f27722l.size();
        for (int i26 = 0; i26 < size && i26 < i17; i26++) {
            List<m.f> list = this.f27722l.get(i26);
            if (R(list)) {
                i18 = i16 + i3;
                if (i26 != size - 1) {
                    i19 = this.A;
                    i16 = i18 + i19;
                }
                i19 = 0;
                i16 = i18 + i19;
            } else {
                this.f27736z = Math.max(this.f27736z, list.size());
                int size2 = list.size();
                int i27 = 0;
                for (int i28 = 0; i28 < size2; i28++) {
                    int i29 = list.get(i28).f415900e;
                    if (i29 > i27) {
                        i27 = i29;
                    }
                }
                int size3 = list.size();
                for (int i36 = 0; i36 < size3; i36++) {
                    m.f fVar = list.get(i36);
                    int i37 = fVar.f415900e;
                    fVar.f415902g = ((i27 - i37) + i16) - ((int) ((1.0f - (i37 / i27)) * f16));
                }
                i18 = i16 + i27;
                if (i26 != size - 1) {
                    i19 = this.A;
                    i16 = i18 + i19;
                }
                i19 = 0;
                i16 = i18 + i19;
            }
        }
        return i16;
    }

    private void Q() {
        if (this.P) {
            return;
        }
        this.P = true;
        if (this.f27723m == null) {
            this.f27723m = new ArrayList();
        }
        if (this.T == null) {
            this.T = new ArrayList();
        }
        if (this.f27722l == null) {
            this.f27722l = new ArrayList();
        }
        if (this.U == null) {
            this.U = new ArrayList();
        }
        if (this.V <= 0 || this.W <= 0) {
            DisplayMetrics displayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
            this.V = displayMetrics.widthPixels;
            this.W = displayMetrics.heightPixels;
        }
        if (this.R == null) {
            Paint paint = new Paint(1);
            this.R = paint;
            paint.setDither(true);
            this.R.setFilterBitmap(true);
            this.R.setStyle(Paint.Style.FILL);
        }
        if (this.S == null) {
            Paint paint2 = new Paint(1);
            this.S = paint2;
            paint2.setDither(true);
            this.S.setFilterBitmap(true);
        }
        if (this.N == null) {
            this.N = new ArrayList<>();
        }
        if (this.M == null) {
            this.M = new SparseIntArray();
        }
        if (this.H == null) {
            Paint paint3 = new Paint(1);
            this.H = paint3;
            paint3.setDither(true);
            this.H.setFilterBitmap(true);
            this.H.setStyle(Paint.Style.FILL);
        }
        this.I = new Path();
    }

    private boolean R(List<m.f> list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.f415894g = 0;
        m.c e16 = m.c.e();
        ETFont eTFont = this.f415892e;
        e16.j(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b);
        int[] iArr = this.f415889b;
        int i3 = iArr[0];
        this.f415890c = i3;
        int i16 = iArr[1];
        this.f415891d = i16;
        if (i3 > 0 && i16 > 0) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f415894g = 0;
        this.f415892e.mShouldDisplayAnimation = false;
        Y();
        this.f27719i.X();
        this.f27719i.g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(int i3) {
        if (i3 > this.f415894g) {
            this.f415894g = i3;
            Y();
            this.f27719i.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(ValueAnimator valueAnimator) {
        final int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue >= this.f415890c) {
            this.f415893f.cancel();
            FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.U();
                }
            });
        } else if (intValue > this.f415894g) {
            FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.V(intValue);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue >= this.f415890c) {
            this.f415893f.cancel();
            this.f415894g = 0;
            this.f415892e.mShouldDisplayAnimation = false;
            this.f27719i.X();
            this.f27719i.g0();
            return;
        }
        if (intValue > this.f415894g) {
            this.f415894g = intValue;
            this.f27719i.X();
        }
    }

    private void u() {
        if (this.f415892e != null && !S() && this.f27730t != null) {
            if (m.b.h(this.f415892e.mFontId) < 3) {
                m.d.a("FontAnimDrawable.FounderColorLayout", "\u5f53\u524d\u5b57\u4f53\u672a\u52a0\u8f7d\u6216\u4e0d\u652f\u6301\u52a8\u753b..." + this.f415892e.mFontPath);
                return;
            }
            int i3 = this.f27735y;
            if (i3 > 0 && i3 <= 5 && !this.E) {
                ValueAnimator valueAnimator = this.f415893f;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    return;
                }
                if (this.f415890c > 0 && this.f415891d > 0) {
                    c();
                    return;
                } else {
                    FontInfoManager.INSTANCE.b().getMFontHandler().post(new Runnable() { // from class: b13.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            m.this.T();
                        }
                    });
                    return;
                }
            }
            m.d.a("FontAnimDrawable.FounderColorLayout", "0\u884c\u6216\u8d85\u8fc75\u884c\u4e0d\u652f\u6301\u64ad\u653e\u52a8\u753b..." + this.f415892e.mFontPath);
        }
    }

    @TargetApi(16)
    private void v(int i3, int i16, CharSequence charSequence) {
        CharacterStyle[] characterStyleArr;
        Spanned spanned;
        Q();
        J(View.MeasureSpec.getMode(i3), View.MeasureSpec.getSize(i3));
        this.f27729s = 0;
        this.Q = 0;
        this.X = 0;
        this.Y = 0;
        this.f27711a0 = 0;
        this.f27712b0 = 0;
        this.f27713c0 = 0;
        this.Z = 1;
        this.f27715e0 = 0;
        Rect rect = new Rect();
        this.f27719i.getPadding(rect);
        int i17 = rect.left;
        this.f27724n = i17;
        int i18 = rect.right;
        this.f27725o = i18;
        this.f27726p = rect.top;
        this.f27727q = rect.bottom;
        this.f27714d0 = (this.f27728r - i17) - i18;
        this.f27712b0 = this.f27719i.getMaxEms().intValue();
        this.f27713c0 = this.f27714d0;
        this.f27722l.clear();
        this.T.clear();
        int size = this.U.size();
        int length = charSequence.length();
        if (size < length && !this.f27723m.isEmpty()) {
            while (size < length) {
                if (!this.f27723m.isEmpty()) {
                    this.U.add(this.f27723m.remove(0));
                }
                size++;
            }
        }
        this.f27723m.clear();
        this.M.clear();
        this.N.clear();
        this.O = new int[length];
        int[] iArr = new int[length];
        H(charSequence, length, iArr, 0, false);
        float textSize = this.f27719i.getTextSize();
        int i19 = (int) textSize;
        m.c.e().f(this.f415892e.mFontId, iArr, i19, this.O);
        K(length, iArr, i19);
        if (charSequence instanceof Spanned) {
            Spanned spanned2 = (Spanned) charSequence;
            CharacterStyle[] characterStyleArr2 = (CharacterStyle[]) spanned2.getSpans(0, spanned2.length(), CharacterStyle.class);
            this.f27718h0.b(spanned2);
            Arrays.sort(characterStyleArr2, this.f27718h0);
            spanned = spanned2;
            characterStyleArr = characterStyleArr2;
        } else {
            characterStyleArr = null;
            spanned = null;
        }
        this.A = (int) ((m.b.j(this.f415892e.mFontId) * textSize) / m.b.i(this.f415892e.mFontId));
        O(charSequence, i19, characterStyleArr, spanned, (int) ((textSize * m.b.d(this.f415892e.mFontId)) / m.b.i(this.f415892e.mFontId)));
        int intValue = this.f27719i.getMaxLines().intValue();
        float f16 = this.f27719i.getPaint().getFontMetrics().bottom;
        this.f27736z = 0;
        this.f27735y = this.f27722l.size();
        int P = P(i19, 0, intValue, f16);
        int i26 = this.Q;
        if (i26 < this.f27714d0) {
            this.f27728r = i26 + this.f27724n + this.f27725o;
        }
        this.f27729s = P + this.f27727q + this.f27726p;
        b0();
    }

    private boolean x(CharSequence charSequence, int i3, int i16, int i17, int i18, int i19) {
        if (i18 > i17 && i19 > i18 && E(com.etrump.mixlayout.e.B(charSequence, i17, i18), i17, i3, 0, false, i16)) {
            return true;
        }
        return false;
    }

    private boolean y(Canvas canvas) {
        int i3;
        if (!w()) {
            return false;
        }
        z(canvas);
        int h16 = m.b.h(this.f415892e.mFontId);
        if (this.f415892e.mShouldDisplayAnimation && !this.E && h16 == 3 && (i3 = this.f27735y) > 0 && i3 < 6) {
            A();
            canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
            if (this.f415894g == 0) {
                o();
            }
            if (m.c.f415878f && this.f415894g == 0) {
                a0("drawAnimationText.....");
            }
            return true;
        }
        if (!this.E && h16 == 5) {
            A();
            canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
        if (currentTimeMillis > 250) {
            VasFontReporter.INSTANCE.report(this.f415892e.mFontId, currentTimeMillis, "FastColorFontHelper.getInstance().renderSeriesColorWordBitmap", this.f27719i.getText().toString());
        }
        A();
        canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        int textSize = this.f27719i.getTextSize() / 15;
        Canvas canvas = this.f27720j;
        if (canvas == null) {
            this.f27720j = new Canvas(this.f415888a);
        } else {
            canvas.setBitmap(this.f415888a);
        }
        int size = this.f27723m.size();
        for (int i3 = 0; i3 < size; i3++) {
            m.f fVar = this.f27723m.get(i3);
            int i16 = fVar.f415896a;
            if (i16 != 1) {
                if (i16 == 2) {
                    this.f27720j.drawRect(fVar.f415901f, fVar.f415902g, r6 + fVar.f415899d, r7 + fVar.f415900e, this.F);
                    if (this.J.isEmoticonSpan(fVar.f415905j)) {
                        IEmoticonSpanApi iEmoticonSpanApi = this.J;
                        CharacterStyle characterStyle = fVar.f415905j;
                        Canvas canvas2 = this.f27720j;
                        float f16 = fVar.f415901f;
                        int i17 = fVar.f415902g;
                        int i18 = fVar.f415900e;
                        iEmoticonSpanApi.draw(characterStyle, canvas2, null, 0, 0, f16, i17, i17 + i18, i17 + i18, this.f27719i.getPaint());
                    } else {
                        CharacterStyle characterStyle2 = fVar.f415905j;
                        if (characterStyle2 instanceof y03.d) {
                            y03.d dVar = (y03.d) characterStyle2;
                            dVar.C = false;
                            Canvas canvas3 = this.f27720j;
                            float f17 = fVar.f415901f;
                            int i19 = fVar.f415902g;
                            dVar.draw(canvas3, null, 0, 0, f17, i19, i19, i19 + fVar.f415900e, this.f27719i.getPaint());
                        }
                    }
                }
            } else {
                this.f27720j.drawBitmap(L(fVar.f415899d, textSize), fVar.f415901f, (fVar.f415902g + fVar.f415900e) - textSize, this.f27719i.getPaint());
            }
            if (fVar.f415904i) {
                B(this.f27720j, fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-256);
        paint.setStrokeWidth(1.0f);
        for (int i3 = 0; i3 < this.f27730t.length; i3++) {
            int i16 = this.f27724n;
            int i17 = this.f27731u[i3];
            int i18 = this.f27726p;
            int i19 = this.f27732v[i3];
            canvas.drawRect(i16 + i17, i18 + i19, i16 + i17 + this.f27733w[i3], i18 + i19 + this.f27734x[i3], paint);
        }
    }

    public ArrayList<Rect> G() {
        if (this.f27731u == null) {
            return null;
        }
        ArrayList<Rect> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f27731u.length; i3++) {
            int i16 = this.f27731u[i3];
            int i17 = this.f27732v[i3];
            arrayList.add(new Rect(i16, i17, this.f27733w[i3] + i16, this.f27734x[i3] + i17));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap L(int i3, int i16) {
        int i17;
        ETFont eTFont = this.f415892e;
        Bitmap k3 = m.b.k(eTFont.mFontId, eTFont.mComboIndex, i3, i16);
        if (k3 == null) {
            int i18 = 1;
            if (i3 > 0) {
                i17 = i3;
            } else {
                i17 = 1;
            }
            if (i16 > 0) {
                i18 = i16;
            }
            k3 = Bitmap.createBitmap(i17, i18, Bitmap.Config.ARGB_8888);
            m.c.e().b(this.f415892e.mFontId, k3, null);
            ETFont eTFont2 = this.f415892e;
            m.b.u(eTFont2.mFontId, eTFont2.mComboIndex, i3, i16, k3);
            if (m.c.f415878f) {
                m.d.b("FontAnimDrawable.FounderColorLayout", "create new under line bitmap.... width:" + i3 + "  height:" + i16);
            }
        }
        return k3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean S() {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3 = this.f27728r;
        int i16 = this.f27724n;
        int i17 = this.f27725o;
        boolean z19 = true;
        if ((i3 - i16) - i17 <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z26 = z16 | false;
        int i18 = this.f27729s;
        int i19 = this.f27726p;
        int i26 = this.f27727q;
        if ((i18 - i19) - i26 <= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z27 = z26 | z17;
        if ((i3 - i16) - i17 > this.V) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean z28 = z18 | z27;
        if ((i18 - i19) - i26 <= this.W) {
            z19 = false;
        }
        return z28 | z19;
    }

    protected void Y() {
        int i3;
        int h16 = m.b.h(this.f415892e.mFontId);
        if (this.f415892e.mShouldDisplayAnimation && !this.E && h16 == 3 && (i3 = this.f27735y) > 0 && i3 < 6) {
            m.c e16 = m.c.e();
            ETFont eTFont = this.f415892e;
            e16.j(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b);
        } else if (!this.E && h16 == 5) {
            m.c e17 = m.c.e();
            ETFont eTFont2 = this.f415892e;
            e17.m(eTFont2.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, eTFont2.mComboIndex);
        } else {
            this.C = new int[0];
            m.c.e().l(this.f415892e.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.B, this.C, this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Z() {
        int size;
        if (!f((this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q) || (size = this.f27723m.size()) <= 0) {
            return false;
        }
        int i3 = this.f27716f0;
        if (i3 != size) {
            this.f27730t = new int[size];
        }
        if (i3 < size || i3 - size > 100) {
            this.f27731u = new int[size];
            this.f27732v = new int[size];
            this.f27733w = new int[size];
            this.f27734x = new int[size];
        }
        this.f27716f0 = size;
        this.E = true;
        for (int i16 = 0; i16 < size; i16++) {
            m.f fVar = this.f27723m.get(i16);
            this.f27730t[i16] = fVar.f415897b;
            this.f27731u[i16] = fVar.f415901f;
            this.f27732v[i16] = fVar.f415902g;
            this.f27733w[i16] = fVar.f415899d;
            this.f27734x[i16] = fVar.f415900e;
            if (fVar.f415896a != 2) {
                this.E = false;
            }
        }
        return true;
    }

    @Override // m.e.a
    public void a(int i3, int i16) {
        this.I.reset();
        int size = this.f27723m.size();
        for (int i17 = 0; i17 < size; i17++) {
            if (i17 >= i3 && i17 < i16) {
                m.f fVar = this.f27723m.get(i17);
                Path path = this.I;
                int i18 = this.f27724n;
                int i19 = fVar.f415901f;
                int i26 = this.f27726p;
                int i27 = fVar.f415902g;
                path.addRect(i18 + i19, i26 + i27, i18 + i19 + fVar.f415899d, i26 + i27 + fVar.f415900e, Path.Direction.CW);
            }
        }
        this.f27719i.X();
    }

    @Override // m.e.a
    public int b(int i3, int i16) {
        this.f27719i.J(this.G);
        int[] iArr = this.G;
        int i17 = i3 - iArr[0];
        int i18 = i16 - iArr[1];
        int i19 = 0;
        for (int i26 = 0; i26 < this.f27722l.size(); i26++) {
            List<m.f> list = this.f27722l.get(i26);
            int i27 = Integer.MIN_VALUE;
            for (m.f fVar : list) {
                int i28 = this.f27726p + fVar.f415902g + fVar.f415900e;
                if (i28 > i27) {
                    i27 = i28;
                }
            }
            if (i27 < i18 && i26 != this.f27722l.size() - 1) {
                i19 += list.size();
            } else {
                for (int i29 = 0; i29 < list.size(); i29++) {
                    m.f fVar2 = list.get(i29);
                    if (i17 <= this.f27724n + fVar2.f415901f + fVar2.f415899d) {
                        return i19 + i29;
                    }
                }
                return i19 + list.size();
            }
        }
        return -1;
    }

    public void b0() {
        if (!FontInfoManager.INSTANCE.a() || !w()) {
            return;
        }
        d();
        Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // m.e
    public void e() {
        super.e();
        if (FontInfoManager.INSTANCE.a()) {
            this.f415893f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b13.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    m.this.W(valueAnimator);
                }
            });
        } else {
            this.f415893f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b13.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    m.this.X(valueAnimator);
                }
            });
        }
    }

    @Override // m.e.a
    public void h() {
        this.I.reset();
        this.f27719i.X();
    }

    @Override // m.e.a
    public void i(int i3, int[] iArr, boolean z16) {
        if (!z16) {
            i3--;
        }
        if (i3 >= this.f27723m.size()) {
            i3 = this.f27723m.size() - 1;
            z16 = false;
        }
        if (i3 < 0) {
            return;
        }
        this.f27719i.J(iArr);
        m.f fVar = this.f27723m.get(i3);
        if (z16) {
            iArr[0] = iArr[0] + this.f27724n + fVar.f415901f;
            iArr[1] = iArr[1] + this.f27726p + fVar.f415902g + fVar.f415900e;
        } else {
            iArr[0] = iArr[0] + this.f27724n + fVar.f415901f + fVar.f415899d;
            iArr[1] = iArr[1] + this.f27726p + fVar.f415902g + fVar.f415900e;
        }
    }

    @Override // m.e
    public boolean j(Canvas canvas) {
        int i3;
        if (FontInfoManager.INSTANCE.a()) {
            return y(canvas);
        }
        if (S()) {
            a0("FounderColorLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8\uff01");
            return false;
        }
        if (!Z()) {
            a0("FounderColorLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return false;
        }
        List<List<m.f>> list = this.f27722l;
        if (list != null && !list.isEmpty()) {
            if (this.f27730t.length <= 0) {
                a0("FounderColorLayout::onDraw \u5b57\u6570\u4e3a\u96f6\uff01");
                return false;
            }
            d();
            z(canvas);
            System.nanoTime();
            int h16 = m.b.h(this.f415892e.mFontId);
            if (this.f415892e.mShouldDisplayAnimation && !this.E && h16 == 3 && (i3 = this.f27735y) > 0 && i3 < 6) {
                m.c e16 = m.c.e();
                ETFont eTFont = this.f415892e;
                e16.j(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b);
                int[] iArr = this.f415889b;
                this.f415890c = iArr[0];
                this.f415891d = iArr[1];
                A();
                canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
                if (this.f415894g == 0) {
                    o();
                }
                if (m.c.f415878f && this.f415894g == 0) {
                    a0("drawAnimationText.....");
                    return true;
                }
                return true;
            }
            if (!this.E && h16 == 5) {
                m.c e17 = m.c.e();
                ETFont eTFont2 = this.f415892e;
                e17.m(eTFont2.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, eTFont2.mComboIndex);
                A();
                canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
                return true;
            }
            this.C = new int[0];
            long currentTimeMillis = System.currentTimeMillis();
            m.c.e().l(this.f415892e.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.B, this.C, this.D);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 250) {
                VasFontReporter.INSTANCE.report(this.f415892e.mFontId, currentTimeMillis2, "FastColorFontHelper.getInstance().renderSeriesColorWordBitmap", this.f27719i.getText().toString());
            }
            A();
            canvas.drawBitmap(this.f415888a, this.f27724n, this.f27726p, (Paint) null);
            return true;
        }
        a0("FounderColorLayout::onDraw \u884c\u6570\u4e3a\u96f6\uff01");
        return false;
    }

    @Override // m.e
    public int[] k(int i3, int i16, long j3, boolean z16, ETFont eTFont) throws Exception {
        ETFont eTFont2;
        if (this.K == j3 && this.f27717g0 == z16 && (eTFont2 = this.f415892e) != null && eTFont2.equals(eTFont) && this.f27719i.getCacheMeasureResult()) {
            return this.L;
        }
        if (this.K != j3) {
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
        this.K = j3;
        this.f27717g0 = z16;
        ETFont eTFont4 = new ETFont(-1, null, 0.0f);
        this.f415892e = eTFont4;
        eTFont4.copy(eTFont);
        this.L[0] = View.MeasureSpec.getSize(i3);
        this.L[1] = View.MeasureSpec.getSize(i16);
        ETFont eTFont5 = this.f415892e;
        if (eTFont5 != null && !TextUtils.isEmpty(eTFont5.mFontPath)) {
            CharSequence text = this.f27719i.getText();
            if (TextUtils.isEmpty(text)) {
                return this.L;
            }
            try {
                v(i3, i16, text);
                if (S()) {
                    return this.L;
                }
                int[] iArr = this.L;
                iArr[0] = this.f27728r;
                iArr[1] = this.f27729s;
                return iArr;
            } catch (Exception unused) {
                this.L[0] = -1;
                return this.L;
            }
        }
        return this.L;
    }

    @Override // m.e
    public void l() {
        super.l();
        this.f27720j = null;
        this.f27721k = null;
    }

    @Override // m.e
    public void o() {
        if (FontInfoManager.INSTANCE.a()) {
            u();
            return;
        }
        if (this.f415892e != null && !S() && this.f27730t != null) {
            if (m.b.h(this.f415892e.mFontId) < 3) {
                m.d.a("FontAnimDrawable.FounderColorLayout", "\u5f53\u524d\u5b57\u4f53\u672a\u52a0\u8f7d\u6216\u4e0d\u652f\u6301\u52a8\u753b..." + this.f415892e.mFontPath);
                return;
            }
            int i3 = this.f27735y;
            if (i3 > 0 && i3 <= 5 && !this.E) {
                ValueAnimator valueAnimator = this.f415893f;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    return;
                }
                if (this.f415890c > 0 && this.f415891d > 0) {
                    c();
                    return;
                }
                this.f415894g = 0;
                m.c e16 = m.c.e();
                ETFont eTFont = this.f415892e;
                e16.j(eTFont.mFontId, this.f27730t, this.f27731u, this.f27732v, this.f27733w, this.f27734x, this.f415888a, null, (this.f27728r - this.f27724n) - this.f27725o, (this.f27729s - this.f27726p) - this.f27727q, this.f27735y, this.f27736z, this.A, eTFont.mAnimationId, this.f415894g, this.f415889b);
                int[] iArr = this.f415889b;
                int i16 = iArr[0];
                this.f415890c = i16;
                int i17 = iArr[1];
                this.f415891d = i17;
                if (i16 > 0 && i17 > 0) {
                    c();
                    return;
                }
                m.d.a("FontAnimDrawable.FounderColorLayout", "StartAnimation......\u52a8\u753b\u5e27\u6570\u548c\u5e27\u95f4\u9694\u6570\u636e\u5f02\u5e38 animInfo:" + Arrays.toString(this.f415889b));
                return;
            }
            m.d.a("FontAnimDrawable.FounderColorLayout", "0\u884c\u6216\u8d85\u8fc75\u884c\u4e0d\u652f\u6301\u64ad\u653e\u52a8\u753b..." + this.f415892e.mFontPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w() {
        if (S()) {
            a0("StrikingLayout::onDraw view\u5bbd\u9ad8\u4e3a0\u6216\u8d85\u8fc7\u5c4f\u5e55\u5c3a\u5bf8\uff01");
            return false;
        }
        if (!Z()) {
            a0("StrikingLayout::onDraw \u521b\u5efabitmap\u5931\u8d25\uff01");
            return false;
        }
        List<List<m.f>> list = this.f27722l;
        if (list != null && !list.isEmpty()) {
            if (this.f27730t.length <= 0) {
                a0("StrikingLayout::onDraw \u884c\u6570\u4e3a\u96f6\uff01");
                return false;
            }
            return true;
        }
        a0("StrikingLayout::onDraw \u884c\u6570\u4e3a\u96f6\uff01");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(Canvas canvas) {
        if (!this.f27719i.getHasSelected()) {
            return;
        }
        this.H.setColor(this.f27719i.getHighlightBackgroundColor());
        canvas.drawPath(this.I, this.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0(String str) {
    }
}
