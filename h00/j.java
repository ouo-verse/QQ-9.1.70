package h00;

import UserGrowth.stSchema;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j implements c {

    /* renamed from: a, reason: collision with root package name */
    private Context f403975a;

    /* renamed from: b, reason: collision with root package name */
    private stSchema f403976b;

    /* renamed from: c, reason: collision with root package name */
    private WSDownloadParams f403977c;

    /* renamed from: d, reason: collision with root package name */
    private b f403978d;

    /* renamed from: e, reason: collision with root package name */
    private MiniAppLaunchListener f403979e;

    /* renamed from: f, reason: collision with root package name */
    private OuterInterceptManager.a f403980f;

    /* renamed from: i, reason: collision with root package name */
    private Object f403983i;

    /* renamed from: l, reason: collision with root package name */
    private boolean f403986l;

    /* renamed from: j, reason: collision with root package name */
    private boolean f403984j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f403985k = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f403987m = false;

    /* renamed from: g, reason: collision with root package name */
    private j00.a f403981g = new j00.b();

    /* renamed from: h, reason: collision with root package name */
    private j00.a f403982h = new j00.c();

    public j(Context context) {
        this.f403975a = context;
    }

    @Override // h00.c
    public Object a() {
        return this.f403983i;
    }

    @Override // h00.c
    public boolean b() {
        return this.f403987m;
    }

    @Override // h00.c
    public MiniAppLaunchListener c() {
        return this.f403979e;
    }

    @Override // h00.c
    public b d() {
        return this.f403978d;
    }

    @Override // h00.c
    public boolean e() {
        return this.f403984j;
    }

    @Override // h00.c
    public OuterInterceptManager.a f() {
        return this.f403980f;
    }

    @Override // h00.c
    public stSchema g() {
        return this.f403976b;
    }

    @Override // h00.c
    public Context getContext() {
        return this.f403975a;
    }

    public boolean h() {
        j00.a aVar;
        if (this.f403975a != null && this.f403976b != null) {
            if (this.f403985k) {
                aVar = this.f403981g;
            } else {
                aVar = this.f403982h;
            }
            a a16 = aVar.a(this);
            if (a16 != null) {
                return a16.a();
            }
            return true;
        }
        x.f("WSStSchemaJumpManager", "[WSStSchemaJumpManager.java][processStSchemaClickAction] mContext:" + this.f403975a + ", mStSchema" + this.f403976b);
        return false;
    }

    public j i(WSDownloadParams wSDownloadParams) {
        this.f403977c = wSDownloadParams;
        return this;
    }

    public j j(Object obj) {
        this.f403983i = obj;
        return this;
    }

    public j k(boolean z16) {
        this.f403986l = z16;
        return this;
    }

    public j l(boolean z16) {
        this.f403985k = z16;
        return this;
    }

    public j m(b bVar) {
        this.f403978d = bVar;
        return this;
    }

    public j n(boolean z16) {
        this.f403984j = z16;
        return this;
    }

    public j o(stSchema stschema) {
        this.f403976b = stschema;
        return this;
    }

    public j p(boolean z16) {
        this.f403987m = z16;
        return this;
    }
}
