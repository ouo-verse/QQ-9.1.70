package com.tencent.luggage.wxa.qo;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.luggage.wxa.tn.w0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f138949a;

    /* renamed from: b, reason: collision with root package name */
    public int f138950b;

    /* renamed from: c, reason: collision with root package name */
    public EnumC6654a f138951c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qo.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6654a {
        MODE_CHINESE_AS_1,
        MODE_CHINESE_AS_2,
        MODE_CHINESE_AS_3
    }

    public a(int i3, EnumC6654a enumC6654a) {
        this.f138949a = true;
        this.f138950b = i3;
        this.f138951c = enumC6654a;
    }

    public static int a(char c16) {
        return c16 <= '\u007f' ? 1 : 2;
    }

    public static int b(String str) {
        if (w0.c(str)) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (charAt >= 0 && charAt <= '\u007f') {
                i3++;
            }
        }
        return str.length() - (a(str) + i3);
    }

    public static int c(String str) {
        if (w0.c(str)) {
            return 0;
        }
        return str.length();
    }

    public static int d(String str) {
        if (w0.c(str)) {
            return 0;
        }
        return str.length() + a(str) + b(str);
    }

    public static int e(String str) {
        if (w0.c(str)) {
            return 0;
        }
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += a(str.charAt(i16));
        }
        return a(i3);
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
        int a16;
        if (this.f138949a) {
            a16 = a(spanned.toString(), this.f138951c);
        } else {
            a16 = a(spanned.subSequence(0, i17).toString(), this.f138951c);
        }
        int a17 = a(charSequence.toString(), this.f138951c) + a16;
        int i19 = this.f138950b;
        if (a17 > i19) {
            for (int min = Math.min(i19 - a16, charSequence.length()); min > 0; min--) {
                if (a(charSequence.subSequence(0, min).toString(), this.f138951c) + a16 <= this.f138950b) {
                    return charSequence.subSequence(0, min);
                }
            }
            return "";
        }
        return charSequence;
    }

    public static int a(String str, EnumC6654a enumC6654a) {
        if (enumC6654a == EnumC6654a.MODE_CHINESE_AS_1) {
            return c(str);
        }
        if (enumC6654a == EnumC6654a.MODE_CHINESE_AS_2) {
            return d(str);
        }
        if (enumC6654a == EnumC6654a.MODE_CHINESE_AS_3) {
            return e(str);
        }
        return 0;
    }

    public a(int i3, EnumC6654a enumC6654a, boolean z16) {
        this.f138950b = i3;
        this.f138951c = enumC6654a;
        this.f138949a = z16;
    }

    public static int a(int i3) {
        if (i3 % 2 != 0) {
            return (i3 + 1) / 2;
        }
        return i3 / 2;
    }

    public static int a(String str) {
        if (w0.c(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
        int i3 = 0;
        while (matcher.find()) {
            for (int i16 = 0; i16 <= matcher.groupCount(); i16++) {
                i3++;
            }
        }
        return i3;
    }
}
