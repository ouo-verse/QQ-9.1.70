package lv2;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f415625a;

    /* renamed from: b, reason: collision with root package name */
    private String f415626b;

    /* renamed from: c, reason: collision with root package name */
    private String f415627c;

    /* renamed from: d, reason: collision with root package name */
    private String f415628d;

    /* renamed from: e, reason: collision with root package name */
    private String f415629e;

    /* renamed from: f, reason: collision with root package name */
    private String f415630f;

    /* renamed from: g, reason: collision with root package name */
    private String f415631g;

    /* renamed from: h, reason: collision with root package name */
    private String f415632h;

    /* renamed from: i, reason: collision with root package name */
    private String f415633i;

    /* compiled from: P */
    /* renamed from: lv2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C10749b {

        /* renamed from: a, reason: collision with root package name */
        private static b f415634a = new b();
    }

    public static b c() {
        return C10749b.f415634a;
    }

    private void i(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = "";
        if (str == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
        } else {
            try {
                str2 = "";
                str3 = str2;
                str4 = str3;
                str5 = str4;
                str6 = str5;
                for (String str9 : str.split(";")) {
                    try {
                        String[] split = str9.split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split.length == 2 && (str7 = split[0]) != null) {
                            String trim = str7.trim();
                            String trim2 = split[1].trim();
                            if (trim.equals("skey")) {
                                str8 = trim2;
                            } else if (trim.equals("openid")) {
                                str2 = trim2;
                            } else if (trim.equals("open_openid")) {
                                str3 = trim2;
                            } else if (trim.equals(AdParam.CONSUMERID)) {
                                str4 = trim2;
                            } else if (trim.equals("appid")) {
                                str5 = trim2;
                            } else if (trim.equals("open_appid")) {
                                str6 = trim2;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        n.b("QAdUserInfoManager", th.getMessage());
                        p(str8);
                        m(str2);
                        o(str3);
                        k(str4);
                        j(str5);
                        n(str6);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                str2 = "";
                str3 = str2;
                str4 = str3;
                str5 = str4;
                str6 = str5;
            }
        }
        p(str8);
        m(str2);
        o(str3);
        k(str4);
        j(str5);
        n(str6);
    }

    private void n(String str) {
        this.f415633i = str;
    }

    public String a() {
        return this.f415630f;
    }

    public String b() {
        return this.f415629e;
    }

    public String d() {
        return this.f415628d;
    }

    public String e() {
        return this.f415633i;
    }

    public String f() {
        return this.f415627c;
    }

    public String g() {
        return this.f415625a;
    }

    public String h() {
        return this.f415626b;
    }

    public void j(String str) {
        this.f415630f = str;
    }

    public void k(String str) {
        this.f415629e = str;
    }

    public void l(String str) {
        this.f415631g = str;
        i(str);
    }

    public void m(String str) {
        this.f415628d = str;
    }

    public void o(String str) {
        this.f415627c = str;
    }

    public void p(String str) {
        this.f415632h = str;
    }

    public void q(String str) {
        this.f415625a = str;
    }

    b() {
        this.f415625a = "";
        this.f415626b = "";
        this.f415627c = "";
        this.f415628d = "";
        this.f415629e = "";
        this.f415630f = "";
        this.f415632h = "";
        this.f415633i = "";
    }
}
