package nw2;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f421455a;

    /* renamed from: b, reason: collision with root package name */
    private int f421456b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f421457c;

    /* renamed from: d, reason: collision with root package name */
    private long f421458d;

    /* renamed from: e, reason: collision with root package name */
    private String f421459e;

    /* renamed from: f, reason: collision with root package name */
    private int f421460f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f421461g = new HashMap();

    public String a() {
        return this.f421459e;
    }

    public long b() {
        return this.f421458d;
    }

    public int c() {
        return this.f421456b;
    }

    public String d() {
        return this.f421455a;
    }

    public Map<String, String> e() {
        return this.f421461g;
    }

    public boolean f() {
        return this.f421457c;
    }

    public a g(int i3) {
        this.f421460f = i3;
        return this;
    }

    public a h(String str) {
        this.f421459e = str;
        return this;
    }

    public a i(long j3) {
        this.f421458d = j3;
        return this;
    }

    public a j(int i3) {
        this.f421456b = i3;
        return this;
    }

    public a k(String str) {
        this.f421455a = str;
        return this;
    }

    public a l(boolean z16) {
        this.f421457c = z16;
        return this;
    }

    public a m(Map<String, String> map) {
        this.f421461g.clear();
        if (map != null) {
            this.f421461g.putAll(map);
        }
        return this;
    }
}
