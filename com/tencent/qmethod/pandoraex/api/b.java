package com.tencent.qmethod.pandoraex.api;

import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.api.v;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f343877j = new com.tencent.qmethod.pandoraex.core.w(40);

    /* renamed from: a, reason: collision with root package name */
    public String f343878a;

    /* renamed from: b, reason: collision with root package name */
    public String f343879b;

    /* renamed from: d, reason: collision with root package name */
    public String f343881d;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, v> f343880c = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public boolean f343882e = false;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public boolean f343883f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f343884g = false;

    /* renamed from: h, reason: collision with root package name */
    public int f343885h = 1;

    /* renamed from: i, reason: collision with root package name */
    public c f343886i = null;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f343887a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f343888b = null;

        /* renamed from: c, reason: collision with root package name */
        private boolean f343889c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f343890d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f343891e = false;

        /* renamed from: f, reason: collision with root package name */
        private int f343892f = 1;

        /* renamed from: g, reason: collision with root package name */
        private c f343893g = null;

        /* renamed from: h, reason: collision with root package name */
        public final Map<String, v> f343894h = new ConcurrentHashMap();

        /* renamed from: i, reason: collision with root package name */
        public String f343895i = null;

        public a a(v vVar) {
            String str;
            if (vVar != null && (str = vVar.f343990a) != null) {
                this.f343894h.put(str, vVar);
            }
            return this;
        }

        public b b() {
            b bVar = new b();
            bVar.f343878a = this.f343887a;
            bVar.f343879b = this.f343888b;
            bVar.f343882e = this.f343889c;
            bVar.f343883f = this.f343890d;
            bVar.f343884g = this.f343891e;
            bVar.f343885h = this.f343892f;
            bVar.f343886i = this.f343893g;
            bVar.f343880c.putAll(this.f343894h);
            bVar.f343881d = this.f343895i;
            return bVar;
        }

        public a c(c cVar) {
            this.f343893g = cVar;
            if (cVar != null) {
                return a(new v.a().g("high_freq").i("normal").c(cVar).a());
            }
            return this;
        }

        public a d(boolean z16) {
            String str;
            this.f343890d = z16;
            if (z16) {
                str = "cache_only";
            } else {
                str = "normal";
            }
            return a(new v.a().g("back").i(str).a());
        }

        public a e(boolean z16) {
            this.f343891e = z16;
            return this;
        }

        public a f(String str) {
            this.f343887a = str;
            return this;
        }

        public a g(int i3) {
            this.f343892f = i3;
            return this;
        }

        public a h(String str) {
            this.f343895i = str;
            return this;
        }

        public a i(String str) {
            this.f343888b = str;
            return this;
        }
    }

    public static b a(b bVar) {
        b bVar2 = new b();
        bVar2.f343878a = bVar.f343878a;
        bVar2.f343879b = bVar.f343879b;
        bVar2.f343881d = bVar.f343881d;
        bVar2.f343880c.putAll(bVar.f343880c);
        for (v vVar : bVar.f343880c.values()) {
            bVar2.f343880c.put(vVar.f343990a, v.a(vVar));
        }
        bVar2.f343882e = bVar.f343882e;
        bVar2.f343883f = bVar.f343883f;
        bVar2.f343884g = bVar.f343884g;
        bVar2.f343885h = bVar.f343885h;
        return bVar2;
    }

    public static String b(String str, String str2) {
        return c(str, str2, null);
    }

    public static String c(String str, String str2, String str3) {
        ThreadLocal<StringBuilder> threadLocal = f343877j;
        StringBuilder sb5 = threadLocal.get();
        if (sb5 == null) {
            sb5 = new StringBuilder();
        }
        sb5.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb5.append("/");
            sb5.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append("/");
            sb5.append(str3);
        }
        String sb6 = sb5.toString();
        threadLocal.remove();
        return sb6;
    }

    public void d(b bVar) {
        this.f343882e = bVar.f343882e;
        this.f343883f = bVar.f343883f;
        this.f343884g = bVar.f343884g;
        this.f343885h = bVar.f343885h;
        this.f343880c.putAll(bVar.f343880c);
        this.f343881d = bVar.f343881d;
    }

    public String toString() {
        return "Config{module[" + this.f343878a + "], systemApi[" + this.f343879b + "], rules[" + this.f343880c + "], specialPage[" + this.f343881d + "], isBanAccess[" + this.f343882e + "], isBanBackgroundAccess[" + this.f343883f + "], isReportRealTime[" + this.f343884g + "], reportSampleRate[" + this.f343885h + "], configHighFrequency[" + this.f343886i + "}";
    }
}
