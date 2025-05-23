package com.tencent.biz.qqcircle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f91375a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f91376b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f91377c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile List<Integer> f91378d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends TypeToken<List<Integer>> {
        a() {
        }
    }

    public static boolean a() {
        if (!f91375a) {
            synchronized (l.class) {
                if (!f91375a) {
                    e();
                    f91375a = true;
                }
            }
        }
        return f91376b;
    }

    public static boolean b() {
        if (!f91375a) {
            synchronized (l.class) {
                if (!f91375a) {
                    e();
                    f91375a = true;
                }
            }
        }
        return f91377c;
    }

    public static int c() {
        List<Integer> d16 = d();
        if (d16 != null && d16.size() > 0) {
            return d16.get(d16.size() - 1).intValue();
        }
        return uq3.c.C3();
    }

    public static List<Integer> d() {
        if (!f91375a) {
            synchronized (l.class) {
                if (!f91375a) {
                    e();
                    f91375a = true;
                }
            }
        }
        return f91378d;
    }

    private static void e() {
        f91376b = uq3.k.a().c("qfs_push_v4_enable", false);
        f91377c = uq3.k.a().c("qfs_push_v5_enable", false);
        try {
            f91378d = (List) new Gson().fromJson(uq3.k.a().h("qfs_push_v4_push_choices", ""), new a().getType());
        } catch (Exception e16) {
            QLog.e("QFSPushConfigUtils", 1, "initExp exception:", e16);
        }
    }

    public static void f() {
        f91375a = false;
        f91376b = false;
        f91377c = false;
        f91378d = null;
    }
}
