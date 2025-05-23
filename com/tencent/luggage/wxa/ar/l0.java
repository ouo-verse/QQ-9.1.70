package com.tencent.luggage.wxa.ar;

import android.text.TextUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l0 {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f121734a;

        /* renamed from: b, reason: collision with root package name */
        public List f121735b;

        public b() {
        }

        public boolean a(double d16) {
            List<k0> list = this.f121735b;
            if (list == null) {
                return false;
            }
            for (k0 k0Var : list) {
                if (k0Var.f121704a <= d16 && k0Var.f121705b >= d16) {
                    if (v0.d() >= k0Var.a(d16) * 10000.0d) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static String a(String str) {
        return a(str, a0.a());
    }

    public static String a(String str, double d16) {
        for (String str2 : TextUtils.split(str, "]")) {
            if (!TextUtils.isEmpty(str2)) {
                String trim = str2.trim();
                if (trim.startsWith(";")) {
                    trim = trim.substring(1);
                }
                int indexOf = trim.indexOf(91);
                String substring = trim.substring(0, indexOf);
                List b16 = k0.b(trim.substring(indexOf + 1));
                b bVar = new b();
                bVar.f121734a = substring;
                bVar.f121735b = b16;
                if (bVar.a(d16)) {
                    return substring;
                }
            }
        }
        return "";
    }
}
