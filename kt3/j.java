package kt3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    private int f412996c;

    /* renamed from: d, reason: collision with root package name */
    private long f412997d;

    /* renamed from: e, reason: collision with root package name */
    private long f412998e;

    /* renamed from: j, reason: collision with root package name */
    private String f413003j;

    /* renamed from: k, reason: collision with root package name */
    private String f413004k;

    /* renamed from: l, reason: collision with root package name */
    private String f413005l;

    /* renamed from: m, reason: collision with root package name */
    private String f413006m;

    /* renamed from: n, reason: collision with root package name */
    private String f413007n;

    /* renamed from: o, reason: collision with root package name */
    private String f413008o;

    /* renamed from: a, reason: collision with root package name */
    private String f412994a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f412995b = "";

    /* renamed from: f, reason: collision with root package name */
    private long f412999f = 0;

    /* renamed from: g, reason: collision with root package name */
    private transient Map<String, Object> f413000g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f413001h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f413002i = new HashMap();

    public Map<String, Object> a() {
        return this.f413000g;
    }

    public Map<String, String> b() {
        return this.f413001h;
    }

    public Map<String, String> c() {
        return this.f413002i;
    }

    public String d() {
        return this.f412995b;
    }

    public String e() {
        return this.f413007n;
    }

    public int f() {
        return this.f412996c;
    }

    public String g() {
        return this.f413003j;
    }

    public String h() {
        return this.f413008o;
    }

    public String i() {
        return this.f412994a;
    }

    public long j() {
        return this.f412997d;
    }

    public long k() {
        return this.f412998e;
    }

    public void l(Map<String, Object> map) {
        if (map != null) {
            this.f413000g.clear();
            this.f413000g.putAll(map);
        }
    }

    public void m(String str) {
        this.f412995b = str;
    }

    public void n(String str) {
        this.f413007n = str;
    }

    public void o(int i3) {
        this.f412996c = i3;
    }

    public void p(long j3) {
        this.f412999f = j3;
    }

    public void q(String str) {
        this.f412994a = str;
    }

    public void r(long j3) {
        this.f412997d = j3;
    }

    public void s(long j3) {
        this.f412998e = j3;
    }

    public String toString() {
        return (((((((((("mVid = " + this.f412994a) + ", mCid = " + this.f412995b) + ", mPlayType = " + this.f412996c) + ", mVideoDuration = " + this.f412997d) + ", mSkipEndMilsec = " + this.f412999f) + ", mSecondPlayVid = " + this.f413003j) + ", mNextVid = " + this.f413004k) + ", mNextCid = " + this.f413005l) + ", mPlayMode = " + this.f413006m) + ", mFlowId = " + this.f413007n) + ", mSessionid = " + this.f413008o;
    }
}
