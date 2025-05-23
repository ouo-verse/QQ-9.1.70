package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class e0 {
    private i a(int i3) {
        String str;
        if (i3 != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private i b(int i3) {
        String str;
        if ((i3 & 4) != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private boolean e() {
        g1 b16 = s.c().b();
        if (TextUtils.isEmpty(b16.l())) {
            b16.h(o.a());
        }
        return !TextUtils.isEmpty(b16.l());
    }

    private String f() {
        g1 b16 = s.c().b();
        if (TextUtils.isEmpty(b16.i())) {
            b16.e(x0.c());
        }
        return b16.i();
    }

    public abstract String a();

    public abstract String a(String str);

    public abstract String b();

    public abstract String c();

    public abstract int d();

    public i a(Context context) {
        String c16 = c();
        if (!TextUtils.isEmpty(c16)) {
            return new i(d0.UDID, c16);
        }
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            return new i(d0.IMEI, a16);
        }
        boolean e16 = e();
        String b16 = b();
        return !TextUtils.isEmpty(b16) ? e16 ? new i(d0.SN, b16) : new i(d0.UDID, a(b16)) : e16 ? a(d()) : b(d());
    }
}
