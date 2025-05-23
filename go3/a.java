package go3;

import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.now.pkgame.pkgame.sei.Pos;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f402738a;

    /* renamed from: b, reason: collision with root package name */
    private final String f402739b;

    /* renamed from: c, reason: collision with root package name */
    private Pos f402740c;

    /* renamed from: d, reason: collision with root package name */
    private i f402741d;

    /* renamed from: e, reason: collision with root package name */
    private long f402742e = 0;

    public a(String str) {
        this.f402739b = str;
    }

    public long a() {
        return this.f402742e;
    }

    public Pos b() {
        return this.f402740c;
    }

    public long c() {
        return this.f402738a;
    }

    public i d() {
        return this.f402741d;
    }

    public boolean e() {
        if (this.f402739b == "on") {
            return true;
        }
        return false;
    }

    public void f(long j3) {
        this.f402742e = j3;
    }

    public void g(Pos pos) {
        this.f402740c = pos;
    }

    public void h(long j3) {
        this.f402738a = j3;
    }

    public void i(i iVar) {
        this.f402741d = iVar;
    }

    public String toString() {
        return "LinkMicBean{roomId=" + this.f402738a + ", linkMicState='" + this.f402739b + "'}";
    }
}
