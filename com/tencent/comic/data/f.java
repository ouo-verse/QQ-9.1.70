package com.tencent.comic.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f99344a;

    /* renamed from: b, reason: collision with root package name */
    public static String f99345b;

    /* renamed from: c, reason: collision with root package name */
    public static String f99346c;

    /* renamed from: d, reason: collision with root package name */
    public static String f99347d;

    /* renamed from: e, reason: collision with root package name */
    public static String f99348e;

    /* renamed from: f, reason: collision with root package name */
    public static String f99349f;

    /* renamed from: g, reason: collision with root package name */
    public static String f99350g;

    /* renamed from: h, reason: collision with root package name */
    public static String f99351h;

    /* renamed from: i, reason: collision with root package name */
    public static String f99352i;

    /* renamed from: j, reason: collision with root package name */
    public static String f99353j;

    /* renamed from: k, reason: collision with root package name */
    public static String f99354k;

    /* renamed from: l, reason: collision with root package name */
    public static d f99355l;

    /* renamed from: m, reason: collision with root package name */
    public static AtomicReference<String> f99356m;

    /* renamed from: n, reason: collision with root package name */
    public static AtomicInteger f99357n;

    /* renamed from: o, reason: collision with root package name */
    public static AtomicInteger f99358o;

    /* renamed from: p, reason: collision with root package name */
    public static JSONObject f99359p;

    /* renamed from: q, reason: collision with root package name */
    public static BoodoHippyConfig f99360q;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f99361r;

    /* renamed from: s, reason: collision with root package name */
    public static String f99362s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f99344a = "";
        f99345b = "";
        f99346c = "";
        f99347d = "";
        f99348e = "";
        f99349f = "";
        f99350g = "0";
        f99351h = "";
        f99352i = "";
        f99353j = "";
        f99354k = "";
        f99355l = new d();
        f99356m = new AtomicReference<>("");
        f99357n = new AtomicInteger(0);
        f99358o = new AtomicInteger(0);
        f99359p = new JSONObject();
        f99361r = false;
        f99362s = "";
    }

    public static void a() {
        f99347d = "";
        f99348e = "";
        f99349f = "";
        f99350g = "0";
        f99351h = "NULL";
        f99355l.f99322a.clear();
        f99355l.f99323b.clear();
        f99353j = "";
    }
}
