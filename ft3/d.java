package ft3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements c {

    /* renamed from: b, reason: collision with root package name */
    b f400602b;

    /* renamed from: c, reason: collision with root package name */
    String f400603c;

    /* renamed from: d, reason: collision with root package name */
    String f400604d;

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f400601a = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    boolean f400605e = false;

    @Override // ft3.c
    public c a(String str) {
        this.f400604d = str;
        return this;
    }

    @Override // ft3.c
    public c addKeyValue(String str, int i3) {
        this.f400601a.put(str, String.valueOf(i3));
        return this;
    }

    @Override // ft3.c
    public c b(String str) {
        this.f400603c = str;
        this.f400601a.put("page", str);
        return this;
    }

    @Override // ft3.c
    public Map getData() {
        return this.f400601a;
    }

    @Override // ft3.c
    public void send() {
        if (this.f400602b == null) {
            this.f400602b = new a();
        }
        this.f400602b.a(this.f400604d, this.f400601a, this.f400605e);
    }

    @Override // ft3.c
    public c addKeyValue(String str, long j3) {
        this.f400601a.put(str, String.valueOf(j3));
        return this;
    }

    @Override // ft3.c
    public c addKeyValue(String str, String str2) {
        this.f400601a.put(str, str2);
        return this;
    }
}
