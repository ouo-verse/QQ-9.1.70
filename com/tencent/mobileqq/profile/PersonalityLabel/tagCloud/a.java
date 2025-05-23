package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.graphics.Point;
import android.graphics.Typeface;
import android.text.BoringLayout;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name */
    static int f259967u;

    /* renamed from: v, reason: collision with root package name */
    private static final BoringLayout.Metrics f259968v;

    /* renamed from: a, reason: collision with root package name */
    boolean f259969a;

    /* renamed from: b, reason: collision with root package name */
    boolean f259970b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f259971c;

    /* renamed from: d, reason: collision with root package name */
    Layout f259972d;

    /* renamed from: e, reason: collision with root package name */
    List<CharSequence> f259973e;

    /* renamed from: f, reason: collision with root package name */
    List<Layout> f259974f;

    /* renamed from: g, reason: collision with root package name */
    Point f259975g;

    /* renamed from: h, reason: collision with root package name */
    Point f259976h;

    /* renamed from: i, reason: collision with root package name */
    float f259977i;

    /* renamed from: j, reason: collision with root package name */
    int f259978j;

    /* renamed from: k, reason: collision with root package name */
    int f259979k;

    /* renamed from: l, reason: collision with root package name */
    int f259980l;

    /* renamed from: m, reason: collision with root package name */
    TextPaint f259981m;

    /* renamed from: n, reason: collision with root package name */
    boolean f259982n;

    /* renamed from: o, reason: collision with root package name */
    boolean f259983o;

    /* renamed from: p, reason: collision with root package name */
    BoringLayout.Metrics f259984p;

    /* renamed from: q, reason: collision with root package name */
    float f259985q;

    /* renamed from: r, reason: collision with root package name */
    int f259986r;

    /* renamed from: s, reason: collision with root package name */
    int f259987s;

    /* renamed from: t, reason: collision with root package name */
    boolean f259988t;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73753);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f259968v = new BoringLayout.Metrics();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f259978j = -16777216;
        this.f259979k = 0;
        this.f259980l = 0;
        this.f259985q = 1.0f;
        this.f259986r = 0;
        this.f259987s = 0;
        this.f259988t = false;
        this.f259975g = new Point(-1, -1);
        this.f259976h = new Point(0, 0);
        TextPaint textPaint = new TextPaint(1);
        this.f259981m = textPaint;
        textPaint.setTypeface(Typeface.SANS_SERIF);
    }

    private static int a(Layout layout) {
        int i3 = 0;
        for (int i16 = 0; i16 < layout.getLineCount(); i16++) {
            i3 = Math.max((int) (layout.getLineMax(i16) + 0.5f), i3);
        }
        return i3;
    }

    private static CharSequence f(CharSequence charSequence) {
        StringBuilder sb5 = new StringBuilder(charSequence.length() * 2);
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            sb5.append(charSequence.charAt(i3));
            if (i3 != charSequence.length() - 1) {
                sb5.append('\n');
            }
        }
        return sb5.toString().subSequence(0, sb5.length());
    }

    public static void g(int i3) {
        f259967u = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int j(int i3) {
        int i16;
        int i17;
        int ceil;
        int i18;
        int i19;
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onMeasureHorizontal text:");
            sb5.append((Object) this.f259971c);
            sb5.append(" hasImg:");
            if (this.f259987s == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            sb5.append(" ems:");
            sb5.append(this.f259980l);
            QLog.i("Tag", 2, sb5.toString());
        }
        if (this.f259987s == 2) {
            i16 = this.f259980l;
        } else {
            i16 = 0;
        }
        if (b.g()) {
            i17 = 0;
        } else {
            i17 = i16;
        }
        int i26 = f259967u;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        BoringLayout.Metrics metrics = f259968v;
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(this.f259971c, this.f259981m, null);
        if (isBoring != null) {
            this.f259984p = isBoring;
        }
        if (isBoring != null && isBoring != metrics) {
            ceil = isBoring.width;
        } else {
            ceil = (int) Math.ceil(Layout.getDesiredWidth(this.f259971c, this.f259981m));
        }
        if (i17 > 0) {
            ceil = Math.min(ceil, c() * i17);
        }
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            int i27 = this.f259987s;
            if (i27 == 2) {
                ceil = Math.min(size - (i26 * 3), ceil);
            } else if (i27 == 1) {
                ceil = Math.min(size - (i26 * 2), ceil);
            } else {
                ceil = Math.min(size, ceil);
            }
        }
        int i28 = ceil;
        int max = Math.max(i28, 0);
        if (max <= 0) {
            return 0;
        }
        Layout h16 = h(max, isBoring, max, this.f259971c, 0.92f);
        this.f259972d = h16;
        if (i17 <= 0 && h16.getLineCount() > 1) {
            float f16 = this.f259977i * 0.8f;
            this.f259977i = f16;
            this.f259981m.setTextSize(f16);
            if (QLog.isColorLevel()) {
                QLog.i("Tag", 2, "onMeasureHorizontal maxEms=0 another round");
            }
            return j(i3);
        }
        if (i17 == 0 && this.f259972d.getLineCount() > 1) {
            if (max % c() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int c16 = max / c();
            if (QLog.isColorLevel()) {
                QLog.i("Tag", 2, "onMeasureHorizontal baseEms:" + c16 + " hasExtra:" + z16);
            }
            if (z16) {
                c16++;
            }
            i17 = c16;
        }
        while (i17 > 1 && this.f259972d.getLineCount() > 1) {
            i17--;
            if (QLog.isDebugVersion()) {
                QLog.i("Tag", 4, "onMeasureHorizontal ems--" + i17);
            }
            int c17 = i17 * c();
            if (c17 > i28) {
                break;
            }
            Layout h17 = h(c17, isBoring, c17, this.f259971c, 0.92f);
            if (h17.getLineCount() != this.f259972d.getLineCount()) {
                break;
            }
            this.f259972d = h17;
        }
        if (this.f259972d.getLineCount() >= 1) {
            i18 = a(this.f259972d);
            if (QLog.isColorLevel()) {
                QLog.i("Tag", 2, "onMeasureHorizontal want:" + max + " actual:" + i18);
            }
        } else {
            i18 = max;
        }
        int height = this.f259972d.getHeight() - this.f259986r;
        int i29 = this.f259987s;
        if (i29 == 1) {
            i19 = i26 * 2;
        } else {
            if (i29 == 2) {
                i19 = (i26 * 3) + height;
            }
            if (i18 <= size) {
                float f17 = this.f259977i * 0.8f;
                this.f259977i = f17;
                this.f259981m.setTextSize(f17);
                if (QLog.isColorLevel()) {
                    QLog.i("Tag", 2, "onMeasureHorizontal width oversize.another round " + ((Object) this.f259971c));
                }
                return j(i3);
            }
            if (i29 > 0) {
                this.f259976h.set(i18, height + (i26 * 2));
            } else {
                this.f259976h.set(i18, height);
            }
            if (QLog.isColorLevel()) {
                QLog.i("Tag", 2, "onMeasureHorizontal w:" + this.f259976h.x + " h:" + this.f259976h.y);
            }
            return this.f259976h.y;
        }
        i18 += i19;
        if (i18 <= size) {
        }
    }

    private int k(int i3) {
        int i16;
        int i17;
        int i18;
        if (QLog.isColorLevel()) {
            QLog.i("Tag", 2, "onMeasureVertical text:" + ((Object) this.f259971c));
        }
        if (this.f259987s == 2) {
            i16 = this.f259980l;
        } else {
            i16 = 0;
        }
        int i19 = f259967u;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (this.f259973e == null) {
            int i26 = 1;
            if (i16 > 0) {
                if (this.f259971c.length() % i16 > 0) {
                    i26 = 1 + (this.f259971c.length() / i16);
                } else {
                    i26 = this.f259971c.length() / i16;
                }
            }
            this.f259973e = new ArrayList(i26);
        }
        if (i16 > 0 && this.f259971c.length() > i16) {
            int length = this.f259971c.length() / i16;
            if (this.f259971c.length() % i16 > 0) {
                length++;
            }
            int min = Math.min(i16, (this.f259971c.length() / length) + (this.f259971c.length() % length));
            int i27 = 0;
            while (true) {
                if (i27 >= this.f259971c.length()) {
                    break;
                }
                int i28 = i27 + min;
                if (i28 >= this.f259971c.length()) {
                    List<CharSequence> list = this.f259973e;
                    CharSequence charSequence = this.f259971c;
                    list.add(charSequence.subSequence(i27, charSequence.length()));
                    break;
                }
                this.f259973e.add(this.f259971c.subSequence(i27, i28));
                i27 = i28;
            }
        } else {
            this.f259973e.add(this.f259971c);
        }
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            i17 = Integer.MAX_VALUE;
        } else {
            i17 = size - (i19 * 2);
        }
        int l3 = l(i17);
        int i29 = 0;
        for (int i36 = 0; i36 < this.f259974f.size(); i36++) {
            i29 = Math.max(this.f259974f.get(i36).getHeight(), i29);
        }
        int i37 = i29 - this.f259986r;
        int i38 = this.f259987s;
        if (i38 > 0) {
            if (i38 == 2) {
                i37 += l3;
                i18 = i19 * 3;
            } else {
                i18 = i19 * 2;
            }
            this.f259976h.set(l3 + (i19 * 2), i37 + i18);
        } else {
            this.f259976h.set(l3, i37);
        }
        if (QLog.isColorLevel()) {
            QLog.i("Tag", 2, "onMeasureVertical w:" + this.f259976h.x + " h:" + this.f259976h.y);
        }
        return this.f259976h.y;
    }

    private int l(int i3) {
        ArrayList arrayList = new ArrayList(this.f259973e.size());
        ArrayList arrayList2 = new ArrayList(this.f259973e.size());
        if (this.f259974f == null) {
            this.f259974f = new ArrayList(this.f259973e.size());
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.f259973e.size(); i17++) {
            CharSequence f16 = f(this.f259973e.get(i17));
            int ceil = (int) Math.ceil(Layout.getDesiredWidth(f16, this.f259981m));
            i16 += ceil;
            if ((i16 >= i3 && i17 < this.f259973e.size() - 1) || (i17 == this.f259973e.size() - 1 && i16 > i3)) {
                float f17 = this.f259977i * 0.5f;
                this.f259977i = f17;
                if (f17 < 1.0f) {
                    return i3;
                }
                this.f259981m.setTextSize(f17);
                return l(i3);
            }
            arrayList.add(Integer.valueOf(ceil));
            arrayList2.add(f16);
        }
        for (int i18 = 0; i18 < arrayList2.size(); i18++) {
            this.f259974f.add(h(((Integer) arrayList.get(i18)).intValue(), null, ((Integer) arrayList.get(i18)).intValue(), (CharSequence) arrayList2.get(i18), 0.87f));
        }
        return i16;
    }

    public Point b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Point) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (this.f259982n) {
            return new Point(0, 0);
        }
        Point point = this.f259975g;
        int i3 = point.x;
        Point point2 = this.f259976h;
        return new Point(i3 + ((int) (point2.x * 0.5f)), point.y + ((int) (point2.y * 0.5f)));
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f259981m.getFontMetricsInt(null);
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        Point point = this.f259976h;
        int i3 = point.x;
        int i16 = point.y;
        int i17 = f259967u;
        int i18 = this.f259987s;
        if (i18 == 2) {
            if (!this.f259970b) {
                return i16 - ((i3 - (i17 * 2)) + (i17 * 3));
            }
        } else if (i18 != 1) {
            return i16;
        }
        return i16 - (i17 * 2);
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        Point point = this.f259976h;
        int i3 = point.x;
        int i16 = point.y;
        int i17 = f259967u;
        int i18 = this.f259987s;
        if (i18 == 2) {
            if (this.f259970b) {
                return i3 - ((i16 - (i17 * 2)) + (i17 * 3));
            }
        } else if (i18 != 1) {
            return i3;
        }
        return i3 - (i17 * 2);
    }

    protected Layout h(int i3, BoringLayout.Metrics metrics, int i16, CharSequence charSequence, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Layout) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), metrics, Integer.valueOf(i16), charSequence, Float.valueOf(f16));
        }
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        if (charSequence instanceof Spannable) {
            return new DynamicLayout(charSequence, this.f259981m, i3, alignment, f16, 0.0f, false);
        }
        if (metrics == f259968v && (metrics = BoringLayout.isBoring(charSequence, this.f259981m, this.f259984p)) != null) {
            this.f259984p = metrics;
        }
        BoringLayout.Metrics metrics2 = metrics;
        if (metrics2 != null) {
            if (metrics2.width <= i3) {
                return BoringLayout.make(charSequence, this.f259981m, i3, alignment, f16, 0.0f, metrics2, false);
            }
            return new StaticLayout(charSequence, this.f259981m, i3, alignment, f16, 0.0f, false);
        }
        return new StaticLayout(charSequence, this.f259981m, i3, alignment, f16, 0.0f, false);
    }

    public int i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        this.f259986r = (int) ((this.f259981m.getFontMetricsInt().ascent - this.f259981m.getFontMetricsInt().top) * 0.5f);
        if (this.f259970b) {
            return j(i3);
        }
        return k(i3);
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f259975g.set(-1, -1);
        this.f259976h.set(0, 0);
        this.f259972d = null;
        List<Layout> list = this.f259974f;
        if (list != null) {
            list.clear();
        }
        List<CharSequence> list2 = this.f259973e;
        if (list2 != null) {
            list2.clear();
        }
    }

    public boolean n() {
        List<Layout> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!this.f259970b ? !((list = this.f259974f) == null || list.size() <= 0) : this.f259972d != null) {
            Point point = this.f259975g;
            if (point.x >= 0 && point.y >= 0) {
                Point point2 = this.f259976h;
                if (point2.x > 0 && point2.y > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "texts:" + this.f259971c + " w:" + this.f259976h.x + " h:" + this.f259976h.y + " textSize:" + this.f259977i + " cord.x:" + this.f259975g.x + " cord.y:" + this.f259975g.y;
    }
}
