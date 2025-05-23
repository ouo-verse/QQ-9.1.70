package com.tencent.biz.pubaccount.weishi.report;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi.util.bb;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f81532a = {1, 2, 9, 12, 10007};

    /* renamed from: b, reason: collision with root package name */
    private static SparseArray<String> f81533b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private static String f81534c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f81535d = "";

    public static void a(int i3, String str) {
        f81533b.put(i3, str);
    }

    public static boolean b(String str) {
        return TextUtils.equals(str, WSPublicAccReport.SOP_NAME_VIDEO_PLAY) || TextUtils.equals(str, "collection_videoplay") || TextUtils.equals(str, "feeds_fullscreen");
    }

    public static void c() {
        f81533b.clear();
    }

    public static void d() {
        f81534c = "";
    }

    public static int e(boolean z16) {
        if (e.f81529d == 1 || e.f81530e == 1 || z16 || e.f81528c) {
            return 1;
        }
        if (e.f81529d == 2 || e.f81530e == 2) {
            return 2;
        }
        return (e.f81529d == 3 || e.f81530e == 3) ? 3 : 0;
    }

    public static String f() {
        return f81535d;
    }

    public static String g(int i3) {
        String str = f81533b.get(i3);
        return !TextUtils.isEmpty(str) ? str : "";
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            str = i();
        }
        return TextUtils.isEmpty(str) ? com.tencent.biz.pubaccount.weishi.config.experiment.b.h().v() : str;
    }

    private static String i() {
        for (int i3 : f81532a) {
            String x16 = bb.x(i3);
            if (!TextUtils.isEmpty(x16)) {
                return x16;
            }
        }
        return "";
    }

    public static String j() {
        return f81534c;
    }

    public static void k(String str) {
        f81535d = str;
    }

    public static void l(String str) {
        f81534c = str;
    }
}
