package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes19.dex */
public class be {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;
        public static int A;
        public static int B;
        public static int C;
        public static int D;

        /* renamed from: a, reason: collision with root package name */
        public static int f302114a;

        /* renamed from: b, reason: collision with root package name */
        public static int f302115b;

        /* renamed from: c, reason: collision with root package name */
        public static int f302116c;

        /* renamed from: d, reason: collision with root package name */
        public static int f302117d;

        /* renamed from: e, reason: collision with root package name */
        public static int f302118e;

        /* renamed from: f, reason: collision with root package name */
        public static int f302119f;

        /* renamed from: g, reason: collision with root package name */
        public static int f302120g;

        /* renamed from: h, reason: collision with root package name */
        public static int f302121h;

        /* renamed from: i, reason: collision with root package name */
        public static int f302122i;

        /* renamed from: j, reason: collision with root package name */
        public static int f302123j;

        /* renamed from: k, reason: collision with root package name */
        public static int f302124k;

        /* renamed from: l, reason: collision with root package name */
        public static int f302125l;

        /* renamed from: m, reason: collision with root package name */
        public static int f302126m;

        /* renamed from: n, reason: collision with root package name */
        public static int f302127n;

        /* renamed from: o, reason: collision with root package name */
        public static int f302128o;

        /* renamed from: p, reason: collision with root package name */
        public static int f302129p;

        /* renamed from: q, reason: collision with root package name */
        public static int f302130q;

        /* renamed from: r, reason: collision with root package name */
        public static int f302131r;

        /* renamed from: s, reason: collision with root package name */
        public static int f302132s;

        /* renamed from: t, reason: collision with root package name */
        public static int f302133t;

        /* renamed from: u, reason: collision with root package name */
        public static int f302134u;

        /* renamed from: v, reason: collision with root package name */
        public static int f302135v;

        /* renamed from: w, reason: collision with root package name */
        public static int f302136w;

        /* renamed from: x, reason: collision with root package name */
        public static int f302137x;

        /* renamed from: y, reason: collision with root package name */
        public static int f302138y;

        /* renamed from: z, reason: collision with root package name */
        public static int f302139z;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29641);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f302114a = 0;
            f302115b = 1;
            f302116c = 2;
            f302117d = 3;
            f302118e = 1;
            f302119f = 2;
            f302120g = 3;
            f302121h = 4;
            f302122i = 5;
            f302123j = 6;
            f302124k = 7;
            f302125l = 8;
            f302126m = 101;
            f302127n = 102;
            f302128o = 103;
            f302129p = 104;
            f302130q = 105;
            f302131r = 106;
            f302132s = 107;
            f302133t = 108;
            f302134u = 109;
            f302135v = 111;
            f302136w = 112;
            f302137x = 113;
            f302138y = 114;
            f302139z = 100;
            A = -99;
            B = -98;
            C = -97;
            D = -36;
        }
    }

    public static final void a(String str, String... strArr) {
        String[] strArr2 = {"", "", "", ""};
        if (strArr != null && strArr.length <= 4) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                strArr2[i3] = strArr[i3];
            }
        }
        b("page_exp", str, strArr2[0], strArr2[1], strArr2[2], strArr2[3]);
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6) {
        eu.j(str, str2, str3, str4, str5, str6);
    }

    public static final void c() {
        b("gfile", "gfile_download", "", "", "", "");
    }

    public static final void d(int i3, int i16) {
        e(i3, i16, "");
    }

    public static final void e(int i3, int i16, String str) {
        String str2 = "" + i3;
        String str3 = "" + i16;
        b("gfile", "gfile_download_result", str2, str3, "" + NetworkUtil.getNetworkType(BaseApplication.getContext()), str);
    }

    public static final void f() {
        b("gfile", "gfile_upload", "", "", "", "");
    }

    public static final void g(int i3, int i16) {
        String str = "" + i3;
        String str2 = "" + i16;
        b("gfile", "gfile_upload_result", str, str2, "" + NetworkUtil.getNetworkType(BaseApplication.getContext()), "");
    }

    public static final void h(int i3, int i16, String str) {
        String str2 = "" + i3;
        String str3 = "" + i16;
        b("gfile", "gfile_upload_result", str2, str3, "" + NetworkUtil.getNetworkType(BaseApplication.getContext()), str);
    }
}
