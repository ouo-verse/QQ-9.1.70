package lk0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.BidiFormatter;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexAlign;
import com.tencent.ecommerce.richtext.ui.dom.style.FlexNode;
import com.tencent.ecommerce.richtext.ui.dom.style.font.TextDecoration;
import com.tencent.ecommerce.richtext.ui.dom.style.l;
import com.tencent.ecommerce.richtext.ui.dom.style.n;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends lk0.b {
    private static final Canvas D0 = new Canvas();
    private boolean B0;

    /* renamed from: c0, reason: collision with root package name */
    @Nullable
    private Layout f414910c0;

    /* renamed from: h0, reason: collision with root package name */
    private Spanned f414915h0;

    /* renamed from: i0, reason: collision with root package name */
    private CharSequence f414916i0;

    /* renamed from: j0, reason: collision with root package name */
    private Spanned f414917j0;

    /* renamed from: m0, reason: collision with root package name */
    private WeakReference<f> f414920m0;

    /* renamed from: t0, reason: collision with root package name */
    private Layout.Alignment f414927t0;

    /* renamed from: u0, reason: collision with root package name */
    private String f414928u0;

    /* renamed from: w0, reason: collision with root package name */
    private TextUtils.TruncateAt f414930w0;

    /* renamed from: x0, reason: collision with root package name */
    private Paint.Align f414931x0;

    /* renamed from: a0, reason: collision with root package name */
    private TextPaint f414908a0 = new TextPaint();

    /* renamed from: b0, reason: collision with root package name */
    private boolean f414909b0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private float f414911d0 = Float.NaN;

    /* renamed from: e0, reason: collision with root package name */
    private AtomicReference<Layout> f414912e0 = new AtomicReference<>();

    /* renamed from: f0, reason: collision with root package name */
    private boolean f414913f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private List<g> f414914g0 = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    public boolean f414918k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private List<i> f414919l0 = new ArrayList();

    /* renamed from: n0, reason: collision with root package name */
    private int f414921n0 = -16777216;

    /* renamed from: o0, reason: collision with root package name */
    private int f414922o0 = -1;

    /* renamed from: p0, reason: collision with root package name */
    private int f414923p0 = -1;

    /* renamed from: q0, reason: collision with root package name */
    private int f414924q0 = -1;

    /* renamed from: r0, reason: collision with root package name */
    private int f414925r0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    private TextDecoration f414926s0 = TextDecoration.NONE;

    /* renamed from: v0, reason: collision with root package name */
    private int f414929v0 = -1;

    /* renamed from: y0, reason: collision with root package name */
    private int f414932y0 = com.tencent.ecommerce.richtext.ui.dom.style.g.i(3);

    /* renamed from: z0, reason: collision with root package name */
    private int f414933z0 = -1;
    private int A0 = -16777216;
    public FlexNode.a C0 = new a();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements FlexNode.a {
        a() {
        }

        @Override // com.tencent.ecommerce.richtext.ui.dom.style.FlexNode.a
        public void a(FlexNode flexNode, float f16, n nVar) {
            boolean z16;
            d dVar = (d) flexNode;
            if (com.tencent.ecommerce.richtext.ui.dom.style.f.a(f16)) {
                f16 = flexNode.f105336e.f105405r;
            }
            if (f16 > 0.0f && flexNode.n() != null && dVar.f414927t0 == Layout.Alignment.ALIGN_CENTER) {
                z16 = l.a(f16, flexNode.n().j());
            } else {
                z16 = false;
            }
            dVar.f414909b0 = true;
            float Y0 = dVar.Y0(dVar.f414908a0, f16, z16);
            if (Y0 > 0.0f && (dVar.f414916i0 != null || d.this.f414915h0 != null)) {
                dVar.f414910c0 = dVar.O0(Y0, true, null);
                dVar.f414911d0 = dVar.f414910c0.getWidth();
                int height = dVar.f414910c0.getHeight();
                if (!d.this.B0) {
                    height += 5;
                }
                nVar.f105418b = height;
                nVar.f105417a = dVar.f414911d0;
                return;
            }
            nVar.f105418b = 0.0f;
            nVar.f105417a = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f414935a;

        static {
            int[] iArr = new int[TextDecoration.values().length];
            f414935a = iArr;
            try {
                iArr[TextDecoration.LINETHROUGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f414935a[TextDecoration.UNDERLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f414935a[TextDecoration.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d() {
        this.f414908a0.setFlags(1);
        F(this.C0);
    }

    private void K0(int i3, int i16, String str) {
        int style;
        Typeface typeface = this.f414908a0.getTypeface();
        int i17 = 0;
        if (typeface == null) {
            style = 0;
        } else {
            style = typeface.getStyle();
        }
        if (i16 == 1 || ((style & 1) != 0 && i16 == -1)) {
            i17 = 1;
        }
        if (i3 == 2 || ((2 & style) != 0 && i3 == -1)) {
            i17 |= 2;
        }
        dk0.d a16 = fk0.d.c().a();
        if (a16 == null || !a16.b(this.f414908a0, str, i17)) {
            if (str != null) {
                typeface = V0(str, i17);
            }
            if (typeface != null) {
                this.f414908a0.setTypeface(Typeface.create(typeface, i17));
            } else {
                this.f414908a0.setTypeface(Typeface.defaultFromStyle(i17));
            }
        }
    }

    private SpannableString L0(g gVar) {
        SpannableString spannableString = new SpannableString(" ");
        if ("text".equals(gVar.f414937d)) {
            SpannableString spannableString2 = new SpannableString(gVar.f414938e);
            h hVar = gVar.f414940h;
            if (hVar != null && hVar.containsKey("fontSize")) {
                spannableString2.setSpan(new AbsoluteSizeSpan(hVar.t(i0())), 0, spannableString2.length(), 33);
            } else if (this.f414922o0 != -1) {
                spannableString2.setSpan(new AbsoluteSizeSpan(this.f414922o0), 0, spannableString2.length(), 33);
            }
            int i3 = this.f414921n0;
            if (hVar != null && hVar.containsKey("color")) {
                i3 = com.tencent.ecommerce.richtext.utils.a.c(hVar.U());
            }
            spannableString2.setSpan(new ForegroundColorSpan(i3), 0, spannableString2.length(), 33);
            if (hVar != null && hVar.containsKey(NodeProps.LINE_HEIGHT)) {
                spannableString2.setSpan(new j(hVar.A(i0())), 0, spannableString2.length(), 33);
            } else {
                int i16 = this.f414923p0;
                if (i16 != -1) {
                    spannableString2.setSpan(new j(i16), 0, spannableString2.length(), 33);
                } else if (hVar != null && hVar.t(i0()) > 0) {
                    spannableString2.setSpan(new j(hVar.t(i0())), 0, spannableString2.length(), 33);
                }
            }
            if (hVar != null && hVar.containsKey("fontWeight")) {
                spannableString2.setSpan(new StyleSpan(hVar.v()), 0, spannableString2.length(), 33);
            }
            return spannableString2;
        }
        h hVar2 = gVar.f414940h;
        try {
            int[] T0 = T0(hVar2);
            i iVar = new i(1, T0[0], T0[1], gVar.D, hVar2, W0());
            this.f414919l0.add(iVar);
            spannableString.setSpan(iVar, 0, spannableString.length(), 33);
            iVar.j(gVar.f414939f);
        } catch (Exception unused) {
        }
        return spannableString;
    }

    private void M0() {
        int i3 = b.f414935a[this.f414926s0.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f414908a0.setUnderlineText(false);
                    this.f414908a0.setStrikeThruText(false);
                    return;
                }
                return;
            }
            this.f414908a0.setUnderlineText(true);
            this.f414908a0.setStrikeThruText(false);
            return;
        }
        this.f414908a0.setUnderlineText(false);
        this.f414908a0.setStrikeThruText(true);
    }

    private void N0() {
        if (this.f414922o0 == -1) {
            this.f414922o0 = (int) com.tencent.ecommerce.richtext.ui.dom.style.g.b("12dp", i0());
        }
        this.f414908a0.setTextSize(this.f414922o0);
        this.f414908a0.setColor(this.f414921n0);
        int i3 = this.f414933z0;
        if (i3 != -1) {
            this.f414908a0.setLetterSpacing(i3 / this.f414922o0);
        }
        M0();
        K0(this.f414925r0, this.f414924q0, this.f414928u0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Layout O0(float f16, boolean z16, @Nullable Layout layout) {
        StaticLayout staticLayout;
        Spanned spanned;
        Spanned spanned2;
        int lineStart;
        int lineEnd;
        float Y0 = Y0(this.f414908a0, f16, z16);
        if (!l.a(this.f414911d0, Y0) || layout == null) {
            Object obj = g0().get("direction");
            if (obj != null) {
                obj.equals("rtl");
            }
            if (j1()) {
                if (this.f414913f0) {
                    spanned2 = this.f414915h0;
                } else {
                    spanned2 = this.f414917j0;
                }
                staticLayout = Q0(spanned2, (int) Math.ceil(Y0));
            } else {
                if (this.f414913f0) {
                    spanned = this.f414915h0;
                } else {
                    spanned = this.f414917j0;
                }
                staticLayout = new StaticLayout(spanned, this.f414908a0, (int) Math.ceil(Y0), this.f414927t0, 1.0f, this.f414932y0, false);
            }
            layout = staticLayout;
        }
        int i3 = this.f414929v0;
        if (i3 != -1 && i3 > 0 && i3 < layout.getLineCount() && (lineStart = layout.getLineStart(this.f414929v0 - 1)) < (lineEnd = layout.getLineEnd(this.f414929v0 - 1))) {
            if (g0().containsKey("lineBreakMargin")) {
                return R0(Y0);
            }
            return Z0(lineStart, lineEnd, Y0);
        }
        return layout;
    }

    private StaticLayout Q0(CharSequence charSequence, int i3) {
        StaticLayout.Builder includePad = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f414908a0, (int) Math.ceil(i3)).setAlignment(this.f414927t0).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setLineSpacing(this.f414932y0, 1.0f).setIncludePad(false);
        int i16 = this.f414929v0;
        if (i16 != -1) {
            includePad.setMaxLines(i16).setEllipsize(TextUtils.TruncateAt.END);
        }
        return includePad.build();
    }

    private StaticLayout R0(float f16) {
        Spanned spanned;
        float f17;
        boolean z16 = this.f414913f0;
        if (z16) {
            spanned = this.f414915h0;
        } else {
            spanned = this.f414917j0;
        }
        if (!z16) {
            Rect rect = new Rect();
            this.f414908a0.getTextBounds("\u2026", 0, 1, rect);
            f17 = rect.width();
        } else {
            f17 = 0.0f;
        }
        return new StaticLayout(new SpannableStringBuilder(TextUtils.ellipsize(spanned, this.f414908a0, ((this.f414929v0 * f16) - f17) - com.tencent.ecommerce.richtext.utils.e.j(g0().get("lineBreakMargin")), TextUtils.TruncateAt.END)), this.f414908a0, (int) Math.ceil(f16), this.f414927t0, 1.0f, this.f414932y0, false);
    }

    private g S0(JSONObject jSONObject, int i3) {
        Object obj;
        g gVar = new g(this.F, i3);
        try {
            if (jSONObject.has("type")) {
                String string = jSONObject.getString("type");
                gVar.f414937d = string;
                if ("text".equals(string)) {
                    String string2 = jSONObject.getString("value");
                    if (TextDirectionHeuristics.FIRSTSTRONG_RTL.isRtl(string2, 0, string2.length())) {
                        string2 = BidiFormatter.getInstance().unicodeWrap(string2.toString(), TextDirectionHeuristics.LTR);
                    }
                    dk0.d a16 = fk0.d.c().a();
                    if (a16 != null) {
                        gVar.f414938e = a16.d(string2, this.f414922o0, (int) com.tencent.ecommerce.richtext.utils.e.i(g0().get("emojiSize"), -1.0f));
                    } else {
                        gVar.f414938e = string2;
                    }
                } else if ("image".equals(gVar.f414937d)) {
                    gVar.f414939f = jSONObject.getString("src");
                    gVar.D = com.tencent.ecommerce.richtext.utils.e.p(jSONObject.opt("resize"), "");
                }
                if (jSONObject.has("style")) {
                    gVar.f414940h = new h(jSONObject.getJSONObject("style"));
                }
                if (jSONObject.has(LinkReportConstant$GlobalKey.EVENTS) && (obj = jSONObject.get(LinkReportConstant$GlobalKey.EVENTS)) != null && (obj instanceof JSONArray)) {
                    JSONArray jSONArray = (JSONArray) obj;
                    int length = jSONArray.length();
                    for (int i16 = 0; i16 < length; i16++) {
                        gVar.C.add(jSONArray.get(i16).toString());
                    }
                }
                return gVar;
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    private int[] T0(h hVar) {
        int[] iArr = new int[2];
        int Z = (int) hVar.Z(i0());
        int w3 = (int) hVar.w(i0());
        if (Z <= 0) {
            Z = g0().t(i0());
        }
        if (w3 <= 0) {
            w3 = g0().t(i0());
        }
        iArr[0] = Z;
        iArr[1] = w3;
        return iArr;
    }

    public static Typeface V0(String str, int i3) {
        return Typeface.create(str, i3);
    }

    private f W0() {
        WeakReference<f> weakReference = this.f414920m0;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private StaticLayout Z0(int i3, int i16, float f16) {
        SpannableStringBuilder spannableStringBuilder;
        if (i3 > 0) {
            if (this.f414913f0) {
                spannableStringBuilder = new SpannableStringBuilder(this.f414915h0.subSequence(0, i16));
            } else {
                spannableStringBuilder = new SpannableStringBuilder(this.f414917j0.subSequence(0, i3));
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
        if (this.f414913f0) {
            if (this.f414915h0.length() > i16 && this.f414930w0 != null) {
                spannableStringBuilder = new SpannableStringBuilder(this.f414915h0.subSequence(0, i16 - 1));
                spannableStringBuilder.append((CharSequence) c1("\u2026", this.A0));
            }
        } else {
            spannableStringBuilder.append((CharSequence) f1(new SpannableStringBuilder(this.f414917j0.subSequence(i3, i16)), this.f414908a0, (int) Math.ceil(f16), TextUtils.TruncateAt.END));
        }
        return new StaticLayout(spannableStringBuilder, this.f414908a0, (int) Math.ceil(f16), this.f414927t0, 1.0f, this.f414932y0, false);
    }

    private SpannableString c1(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i3), 0, spannableString.length(), 33);
            return spannableString;
        }
        return new SpannableString("\u2026");
    }

    @NonNull
    private Spanned f1(@Nullable Editable editable, @NonNull TextPaint textPaint, int i3, @Nullable TextUtils.TruncateAt truncateAt) {
        SpannedString spannedString = new SpannedString("");
        if (!TextUtils.isEmpty(editable) && editable.length() > 0) {
            if (truncateAt != null) {
                editable.append("\u2026");
                for (Object obj : editable.getSpans(0, editable.length(), Object.class)) {
                    int spanStart = editable.getSpanStart(obj);
                    int spanEnd = editable.getSpanEnd(obj);
                    if (spanStart == 0 && spanEnd == editable.length() - 1) {
                        editable.removeSpan(obj);
                        editable.setSpan(obj, 0, editable.length(), editable.getSpanFlags(obj));
                    }
                }
            }
            while (editable.length() > 1) {
                int length = editable.length() - 1;
                if (truncateAt != null) {
                    length--;
                }
                editable.delete(length, length + 1);
                if (new StaticLayout(editable, textPaint, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, this.f414932y0, false).getLineCount() <= 1) {
                    return editable;
                }
            }
        }
        return spannedString;
    }

    private void g1() {
        Object obj;
        Z();
        if (this.Q.containsKey("value")) {
            Object obj2 = this.Q.get("value");
            if (obj2 != null) {
                if (obj2 instanceof JSONArray) {
                    this.f414913f0 = true;
                    try {
                        JSONArray jSONArray = (JSONArray) obj2;
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            g S0 = S0(jSONArray.getJSONObject(i3), i3);
                            if (S0 != null) {
                                this.f414914g0.add(S0);
                                spannableStringBuilder.append((CharSequence) L0(S0));
                            }
                        }
                        spannableStringBuilder.append((CharSequence) new SpannableString(" "));
                        this.f414915h0 = spannableStringBuilder;
                    } catch (JSONException unused) {
                    }
                } else {
                    if (TextDirectionHeuristics.FIRSTSTRONG_RTL.isRtl(obj2.toString(), 0, obj2.toString().length())) {
                        obj2 = BidiFormatter.getInstance().unicodeWrap(obj2.toString());
                    }
                    this.f414916i0 = obj2.toString();
                    this.f414917j0 = P0(obj2.toString());
                }
            } else {
                Object obj3 = this.Q.get("content");
                if (obj3 != null) {
                    String obj4 = obj3.toString();
                    this.f414916i0 = obj4;
                    this.f414917j0 = P0(obj4);
                }
            }
        }
        if (this.Q.containsKey("values") && (obj = this.Q.get("values")) != null && (obj instanceof JSONArray)) {
            this.f414913f0 = true;
            try {
                JSONArray jSONArray2 = (JSONArray) obj;
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    g S02 = S0(jSONArray2.getJSONObject(i16), i16);
                    if (S02 != null) {
                        this.f414914g0.add(S02);
                        spannableStringBuilder2.append((CharSequence) L0(S02));
                    }
                }
                spannableStringBuilder2.append((CharSequence) new SpannableString(" "));
                this.f414915h0 = spannableStringBuilder2;
            } catch (JSONException unused2) {
            }
        }
    }

    private boolean j1() {
        if (!Z().containsKey("useNewTextLayout")) {
            return true;
        }
        return com.tencent.ecommerce.richtext.utils.e.f(Z().get("key"));
    }

    private boolean k1(Layout layout) {
        try {
            layout.draw(D0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @NonNull
    protected Spanned P0(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            dk0.d a16 = fk0.d.c().a();
            if (a16 != null) {
                charSequence = a16.d(charSequence.toString(), this.f414922o0, (int) com.tencent.ecommerce.richtext.utils.e.i(g0().get("emojiSize"), -1.0f));
            }
            SpannableString spannableString = new SpannableString(charSequence);
            h1(spannableString, 17);
            return spannableString;
        }
        return new SpannableString("");
    }

    public int U0() {
        return this.f414932y0;
    }

    float X0(TextPaint textPaint, float f16, boolean z16) {
        if (this.f414915h0 == null) {
            if (z16) {
                return f16;
            }
            return 0.0f;
        }
        if (!z16 || n().d() == FlexAlign.CENTER) {
            float desiredWidth = Layout.getDesiredWidth(this.f414915h0, textPaint);
            if (com.tencent.ecommerce.richtext.ui.dom.style.f.a(f16) || desiredWidth < f16) {
                return desiredWidth;
            }
            return f16;
        }
        return f16;
    }

    float Y0(TextPaint textPaint, float f16, boolean z16) {
        if (this.f414913f0) {
            return X0(textPaint, f16, z16);
        }
        CharSequence charSequence = this.f414916i0;
        if (charSequence == null) {
            if (z16) {
                return f16;
            }
            return 0.0f;
        }
        if (!z16) {
            float desiredWidth = Layout.getDesiredWidth(charSequence, textPaint);
            if (com.tencent.ecommerce.richtext.ui.dom.style.f.a(f16) || desiredWidth < f16) {
                return desiredWidth;
            }
            return f16;
        }
        return f16;
    }

    public boolean a1() {
        return this.f414913f0;
    }

    public void b1() {
        float b16 = e.b(this);
        if (b16 > 0.0f) {
            if (this.f414916i0 == null && this.f414915h0 == null) {
                this.f414911d0 = 0.0f;
                return;
            }
            this.f414910c0 = O0(b16, true, this.f414910c0);
            this.f414911d0 = r0.getWidth();
        }
    }

    public void d1(f fVar) {
        this.f414920m0 = new WeakReference<>(fVar);
        Iterator<i> it = this.f414919l0.iterator();
        while (it.hasNext()) {
            it.next().m(fVar);
        }
        this.f414919l0.clear();
    }

    @Override // lk0.b
    public Object e0() {
        this.f414912e0.get();
        return this.f414912e0.get();
    }

    public void e1() {
        Layout layout = this.f414910c0;
        if (layout != null) {
            this.f414912e0.set(layout);
            this.f414910c0 = null;
            this.f414908a0 = new TextPaint(this.f414908a0);
        }
        this.f414909b0 = false;
    }

    protected void h1(Spannable spannable, int i3) {
        int i16 = this.f414923p0;
        if (i16 != -1) {
            spannable.setSpan(new j(i16), 0, spannable.length(), i3);
        }
    }

    public void i1() {
        x0(g0());
        g1();
    }

    @Override // lk0.b
    public void l0() {
        if (this.f414909b0) {
            if (this.f414910c0 != null && !l.a(e.b(this), this.f414911d0)) {
                b1();
            }
        } else {
            i1();
            b1();
        }
        this.f414909b0 = false;
        Layout layout = this.f414910c0;
        if (layout != null && !layout.equals(this.f414912e0.get()) && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            k1(this.f414910c0);
        }
        e1();
        super.l0();
    }

    @Override // lk0.b
    public void m0() {
        y0();
        this.f414909b0 = false;
        i1();
        if (o()) {
            n0();
        }
        super.c();
        super.m0();
    }

    @Override // lk0.b
    public void q0(JSONObject jSONObject) {
        super.q0(jSONObject);
        this.B0 = com.tencent.ecommerce.richtext.utils.e.f(Z().get("fixTextNotCenter"));
    }

    @Override // lk0.b, com.tencent.ecommerce.richtext.ui.dom.style.FlexNode
    public String toString() {
        String str;
        String str2 = "ref:" + f0() + " ; ";
        if (!TextUtils.isEmpty(this.f414916i0)) {
            str = str2 + "mText:" + ((Object) this.f414916i0) + " ; ";
        } else if (!TextUtils.isEmpty(this.f414915h0)) {
            str = str2 + "mSpanned:" + ((Object) this.f414915h0) + "; ";
        } else {
            str = str2 + "mSpanned == null  && mText = null ; ";
        }
        return ((str + "mSpanned :" + ((Object) this.f414915h0) + "; ") + "isRichText :" + this.f414913f0 + "; ") + "mTextPaint :" + this.f414908a0 + "; ";
    }

    @Override // lk0.b
    public void w0(Map<String, Object> map) {
        e1();
        super.w0(map);
    }

    @Override // lk0.b
    public void x0(Map<String, Object> map) {
        super.x0(map);
        if (map.size() == 0) {
            N0();
            return;
        }
        h g06 = g0();
        int i06 = i0();
        if (g06.containsKey("lines")) {
            int C = g06.C();
            if (C <= 0) {
                C = -1;
            }
            this.f414929v0 = C;
        }
        this.f414922o0 = g06.t(i0());
        if (g06.containsKey("ellipsisColor") && !TextUtils.isEmpty(g06.p())) {
            this.A0 = com.tencent.ecommerce.richtext.utils.a.c(g06.p());
        }
        if (g06.containsKey("fontWeight")) {
            this.f414924q0 = g06.v();
        }
        if (g06.containsKey("fontStyle")) {
            this.f414925r0 = g06.u();
        }
        if (g06.containsKey("color") && !TextUtils.isEmpty(g06.U())) {
            this.f414921n0 = com.tencent.ecommerce.richtext.utils.a.c(g06.U());
        }
        if (g06.containsKey(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
            this.f414926s0 = g06.V();
        }
        if (g06.containsKey("fontFamily")) {
            this.f414928u0 = g06.s();
        }
        this.f414927t0 = g06.T();
        this.f414930w0 = g06.W();
        this.f414931x0 = g06.X();
        int A = g06.A(i06);
        if (A != -1) {
            this.f414923p0 = A + ((int) this.f105336e.f105399l.a(1)) + ((int) this.f105336e.f105399l.a(3));
        } else {
            this.f414923p0 = this.f414922o0;
        }
        int B = g06.B(i06);
        if (B != -1) {
            this.f414932y0 = B;
        }
        int z16 = g06.z(i06);
        if (z16 != -1) {
            this.f414933z0 = z16;
        }
        N0();
    }
}
