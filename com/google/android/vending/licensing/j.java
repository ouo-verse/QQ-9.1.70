package com.google.android.vending.licensing;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public int f34647a;

    /* renamed from: b, reason: collision with root package name */
    public int f34648b;

    /* renamed from: c, reason: collision with root package name */
    public String f34649c;

    /* renamed from: d, reason: collision with root package name */
    public String f34650d;

    /* renamed from: e, reason: collision with root package name */
    public String f34651e;

    /* renamed from: f, reason: collision with root package name */
    public long f34652f;

    /* renamed from: g, reason: collision with root package name */
    public String f34653g;

    public static j a(String str) {
        int indexOf = str.indexOf(58);
        String str2 = "";
        if (-1 != indexOf) {
            String substring = str.substring(0, indexOf);
            if (indexOf < str.length()) {
                str2 = str.substring(indexOf + 1);
            }
            str = substring;
        }
        String[] split = TextUtils.split(str, Pattern.quote("|"));
        if (split.length >= 6) {
            j jVar = new j();
            jVar.f34653g = str2;
            jVar.f34647a = Integer.parseInt(split[0]);
            jVar.f34648b = Integer.parseInt(split[1]);
            jVar.f34649c = split[2];
            jVar.f34650d = split[3];
            jVar.f34651e = split[4];
            jVar.f34652f = Long.parseLong(split[5]);
            return jVar;
        }
        throw new IllegalArgumentException("Wrong number of fields.");
    }

    public String toString() {
        return TextUtils.join("|", new Object[]{Integer.valueOf(this.f34647a), Integer.valueOf(this.f34648b), this.f34649c, this.f34650d, this.f34651e, Long.valueOf(this.f34652f)});
    }
}
