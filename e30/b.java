package e30;

import android.text.TextUtils;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class b extends a<FeedCloudMeta$StFeed> {

    /* renamed from: c, reason: collision with root package name */
    public b f395526c;

    /* renamed from: d, reason: collision with root package name */
    private String f395527d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f395528e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f395529f;

    /* renamed from: g, reason: collision with root package name */
    private final long f395530g;

    public b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        super(feedCloudMeta$StFeed);
        this.f395528e = false;
        this.f395529f = false;
        this.f395530g = System.currentTimeMillis();
    }

    public static FeedCloudMeta$StFeed h(Object obj) {
        if (obj instanceof FeedCloudMeta$StFeed) {
            return (FeedCloudMeta$StFeed) obj;
        }
        if (obj instanceof b) {
            return ((b) obj).g();
        }
        return null;
    }

    @Override // e30.a
    public Object b(String str) {
        b bVar = this.f395526c;
        if (bVar != null) {
            return bVar.b(str);
        }
        return super.b(str);
    }

    public long d() {
        return this.f395530g;
    }

    public FeedCloudMeta$StFeed e() {
        return (FeedCloudMeta$StFeed) super.a();
    }

    public String f() {
        return this.f395527d;
    }

    public FeedCloudMeta$StFeed g() {
        b bVar = this.f395526c;
        if (bVar != null) {
            return bVar.g();
        }
        return (FeedCloudMeta$StFeed) super.a();
    }

    public boolean i() {
        return this.f395528e;
    }

    public boolean j() {
        b bVar = this.f395526c;
        if (bVar != null) {
            return bVar.f395529f;
        }
        return this.f395529f;
    }

    public void k(boolean z16) {
        this.f395528e = z16;
    }

    public void l(boolean z16) {
        this.f395529f = z16;
    }

    public void m(b bVar) {
        if (bVar == this) {
            this.f395526c = null;
        } else {
            this.f395526c = bVar;
        }
    }

    public void n(String str) {
        this.f395527d = str;
    }

    public b o(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = this.f395526c;
        if (bVar != null) {
            bVar.o(str, obj);
            return this;
        }
        this.f395524a.put(str, obj);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b p() {
        d.a(this, (FeedCloudMeta$StFeed) this.f395525b);
        return this;
    }
}
