package com.tencent.qmethod.pandoraex.api;

import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public String f343990a;

    /* renamed from: b, reason: collision with root package name */
    public String f343991b;

    /* renamed from: c, reason: collision with root package name */
    public c f343992c;

    /* renamed from: d, reason: collision with root package name */
    public long f343993d;

    /* renamed from: e, reason: collision with root package name */
    public long f343994e;

    /* renamed from: f, reason: collision with root package name */
    public int f343995f;

    /* renamed from: g, reason: collision with root package name */
    public Set<String> f343996g;

    /* renamed from: h, reason: collision with root package name */
    public Set<String> f343997h;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private c f344000c;

        /* renamed from: e, reason: collision with root package name */
        private long f344002e;

        /* renamed from: a, reason: collision with root package name */
        private String f343998a = "normal";

        /* renamed from: b, reason: collision with root package name */
        private String f343999b = "normal";

        /* renamed from: d, reason: collision with root package name */
        private long f344001d = 0;

        /* renamed from: f, reason: collision with root package name */
        private int f344003f = 0;

        /* renamed from: g, reason: collision with root package name */
        private final Set<String> f344004g = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        private final Set<String> f344005h = new HashSet();

        public v a() {
            v vVar = new v();
            vVar.f343990a = this.f343998a;
            vVar.f343991b = this.f343999b;
            vVar.f343992c = this.f344000c;
            vVar.f343993d = this.f344001d;
            vVar.f343994e = this.f344002e;
            vVar.f343995f = this.f344003f;
            vVar.f343996g = this.f344004g;
            vVar.f343997h = this.f344005h;
            return vVar;
        }

        public a b(long j3) {
            this.f344001d = j3;
            return this;
        }

        public a c(c cVar) {
            this.f344000c = cVar;
            return this;
        }

        public a d(Set<String> set) {
            this.f344005h.clear();
            this.f344005h.addAll(set);
            return this;
        }

        public a e(Set<String> set) {
            this.f344004g.clear();
            this.f344004g.addAll(set);
            return this;
        }

        public a f(int i3) {
            this.f344003f = i3;
            return this;
        }

        public a g(String str) {
            this.f343998a = str;
            return this;
        }

        public a h(long j3) {
            this.f344002e = j3;
            return this;
        }

        public a i(String str) {
            this.f343999b = str;
            return this;
        }
    }

    public v() {
        this.f343990a = "normal";
        this.f343991b = "normal";
        this.f343993d = 0L;
        this.f343995f = 0;
        this.f343996g = new HashSet();
        this.f343997h = new HashSet();
    }

    public static v a(v vVar) {
        v vVar2 = new v(vVar.f343990a, vVar.f343991b);
        vVar2.f343993d = vVar.f343993d;
        vVar2.f343994e = vVar.f343994e;
        vVar2.f343995f = vVar.f343995f;
        c cVar = vVar.f343992c;
        if (cVar != null) {
            vVar2.f343992c = new c(cVar.f343898c, cVar.f343897b);
        }
        if (vVar.f343996g != null) {
            vVar2.f343996g.clear();
            vVar2.f343996g.addAll(vVar.f343996g);
        }
        if (vVar.f343997h != null) {
            vVar2.f343997h.clear();
            vVar2.f343997h.addAll(vVar.f343997h);
        }
        return vVar2;
    }

    public String toString() {
        return "Rule{scene[" + this.f343990a + "], strategy[" + this.f343991b + "], highFreq[" + this.f343992c + "], cacheTime[" + this.f343993d + "], silenceTime[" + this.f343994e + "], reportRate[" + this.f343995f + "], legalPage[" + this.f343996g + "], illegalPage[" + this.f343997h + "]}";
    }

    public v(String str, String str2) {
        this.f343990a = "normal";
        this.f343991b = "normal";
        this.f343993d = 0L;
        this.f343995f = 0;
        this.f343996g = new HashSet();
        this.f343997h = new HashSet();
        this.f343990a = str;
        this.f343991b = str2;
    }
}
