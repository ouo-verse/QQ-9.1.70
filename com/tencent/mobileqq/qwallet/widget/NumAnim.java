package com.tencent.mobileqq.qwallet.widget;

import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.TextView;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes16.dex */
public class NumAnim implements Runnable {
    static DecimalFormat E = new DecimalFormat("0.00");
    static DecimalFormat F;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f279294e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f279295f;

    /* renamed from: h, reason: collision with root package name */
    private double[] f279296h;

    /* renamed from: i, reason: collision with root package name */
    private long f279297i;

    /* renamed from: d, reason: collision with root package name */
    SparseArray<Boolean> f279293d = new SparseArray<>();

    /* renamed from: m, reason: collision with root package name */
    private int f279298m = 0;
    b C = new a();
    long D = 0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements b {
        a() {
        }

        @Override // com.tencent.mobileqq.qwallet.widget.NumAnim.b
        public c a(double d16) {
            String str;
            if ((d16 < 1000.0d || d16 >= 10000.0d) && d16 >= 0.0d) {
                int i3 = (d16 > 1000.0d ? 1 : (d16 == 1000.0d ? 0 : -1));
            }
            String a16 = NumAnim.a(d16, true);
            if (d16 >= 10000.0d) {
                str = "\u4e07";
            } else {
                str = ".";
            }
            return new c(a16, 0, a16.indexOf(str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        c a(double d16);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f279300a;

        /* renamed from: b, reason: collision with root package name */
        int f279301b;

        /* renamed from: c, reason: collision with root package name */
        int f279302c;

        public c(String str, int i3, int i16) {
            this.f279300a = str;
            this.f279301b = i3;
            this.f279302c = i16;
            if (str != null && i3 <= str.length() && i16 <= str.length()) {
                return;
            }
            throw new IndexOutOfBoundsException("params invalid! valueStr:" + str + ", preffixLen:" + i3 + ", suffixIndex:" + i16);
        }
    }

    static {
        Locale locale = Locale.US;
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
        decimalFormatSymbols.setDecimalSeparator('.');
        E.setDecimalFormatSymbols(decimalFormatSymbols);
        E.setRoundingMode(RoundingMode.DOWN);
        F = new DecimalFormat("0.0");
        DecimalFormatSymbols decimalFormatSymbols2 = DecimalFormatSymbols.getInstance(locale);
        decimalFormatSymbols2.setDecimalSeparator('.');
        F.setDecimalFormatSymbols(decimalFormatSymbols2);
        F.setRoundingMode(RoundingMode.DOWN);
    }

    public NumAnim(TextView textView, TextView textView2) {
        this.f279294e = textView;
        this.f279295f = textView2;
    }

    public static String a(double d16, boolean z16) {
        boolean z17;
        double d17;
        String format;
        if (z16 && d16 >= 10000.0d) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            d17 = d16 / 10000.0d;
        } else {
            d17 = d16;
        }
        if (d16 >= 1000000.0d && d16 < 1.0E7d) {
            format = F.format(d17);
        } else if (d16 >= 1.0E7d) {
            format = ((int) d17) + "";
        } else {
            format = E.format(d17);
        }
        if (z17) {
            return format + "\u4e07";
        }
        return format;
    }

    public static double b(double d16) {
        if (d16 > 9.999999999E9d) {
            return 9.999999999E9d;
        }
        return d16;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3 = this.f279298m;
        double[] dArr = this.f279296h;
        if (i3 < dArr.length && this.C != null) {
            this.f279298m = i3 + 1;
            c a16 = this.C.a(b(dArr[i3]));
            if (a16 != null && !TextUtils.isEmpty(a16.f279300a)) {
                int i16 = a16.f279302c;
                String substring = a16.f279300a.substring(0, i16);
                String substring2 = a16.f279300a.substring(i16);
                this.f279294e.setText(substring);
                this.f279295f.setText(substring2);
                this.f279294e.setPadding((int) this.f279295f.getPaint().measureText(substring2), 0, 0, 0);
                this.f279294e.removeCallbacks(this);
                this.f279294e.postDelayed(this, this.f279297i);
            }
        }
        if (this.f279298m >= this.f279296h.length) {
            this.f279294e.removeCallbacks(this);
        }
    }
}
