package com.tencent.luggage.wxa.tn;

import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f141695a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f141696b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f141697c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static boolean a(String str) {
        if (!c(str) && !b(str)) {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        return f141697c.matcher(str).matches();
    }

    public static boolean c(String str) {
        return f141696b.matcher(str).matches();
    }
}
