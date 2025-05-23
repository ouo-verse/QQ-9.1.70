package com.tencent.biz.pubaccount.weishi.net;

import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static String f80972a = "1522415138827987";

    /* renamed from: b, reason: collision with root package name */
    public static int f80973b;

    /* renamed from: c, reason: collision with root package name */
    public static String f80974c;

    /* renamed from: d, reason: collision with root package name */
    public static String f80975d;

    /* renamed from: e, reason: collision with root package name */
    public static int f80976e;

    static {
        int a16 = a();
        f80973b = a16 == -1 ? 760 : a16;
        QZLog.d("WeishiHeaderConst", 4, "appversion:" + a16);
        f80973b = 760;
        f80974c = "";
        f80975d = "";
        f80976e = 0;
    }

    static int a() {
        String qua3 = QUA.getQUA3();
        int indexOf = qua3.indexOf(".");
        int lastIndexOf = qua3.lastIndexOf(".");
        if (lastIndexOf <= indexOf || lastIndexOf - indexOf != 2 || indexOf <= 1) {
            return -1;
        }
        try {
            return Integer.parseInt(qua3.substring(indexOf - 1, lastIndexOf + 2).replace(".", ""));
        } catch (Throwable unused) {
            return -1;
        }
    }
}
