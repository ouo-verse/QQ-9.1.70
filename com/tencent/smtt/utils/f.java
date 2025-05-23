package com.tencent.smtt.utils;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static f f369744b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, String> f369745a;

    f() {
        HashMap hashMap = new HashMap();
        this.f369745a = hashMap;
        hashMap.put(325, "if NoSuchMethodError, please check the Class in base.apk which is conflict with x5.");
        hashMap.put(326, "your CPU is i686|mips|x86_64? sorry X5 is not support them.");
        hashMap.put(402, "QbSdk.forceSysWebView() has been called! Check it.");
        hashMap.put(404, "try to restart your app.");
    }

    public static f a() {
        if (f369744b == null) {
            f369744b = new f();
        }
        return f369744b;
    }

    public String a(int i3) {
        if (i3 >= 303 && i3 <= 324) {
            return "Core has some problem, try to reinstall the app.";
        }
        try {
            return this.f369745a.get(Integer.valueOf(i3));
        } catch (Exception unused) {
            return "Unexpected load error.";
        }
    }
}
