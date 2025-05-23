package com.tencent.tgpa.lite.f;

import com.tencent.tgpa.lite.PrivacyDataCallback;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f375961a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f375962b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f375963c = "https://cloud.tgpa.qq.com";

    /* renamed from: d, reason: collision with root package name */
    private static PrivacyDataCallback f375964d;

    public static String a() {
        return d() ? "https://testcloud.tgpa.qq.com" : f375963c;
    }

    public static PrivacyDataCallback b() {
        return f375964d;
    }

    public static String c() {
        return f375962b;
    }

    public static boolean d() {
        return f375961a;
    }

    public static void a(PrivacyDataCallback privacyDataCallback) {
        f375964d = privacyDataCallback;
    }

    public static void b(String str) {
        f375962b = str;
    }

    public static void a(String str) {
        f375963c = str;
    }

    public static void a(boolean z16) {
        f375961a = z16;
    }
}
