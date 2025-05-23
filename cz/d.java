package cz;

import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi.util.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R(\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcz/d;", "", "Lcz/b;", "listener", "", "b", "LUserGrowth/stPublisherRsp;", "<set-?>", "LUserGrowth/stPublisherRsp;", "c", "()LUserGrowth/stPublisherRsp;", "publisherInfo", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f392425a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static stPublisherRsp publisherInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"cz/d$a", "Lcz/b;", "LUserGrowth/stPublisherRsp;", "rsp", "", "a", "", "code", "", "errMsg", "onFailure", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f392427a;

        a(b bVar) {
            this.f392427a = bVar;
        }

        @Override // cz.b
        public void a(stPublisherRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            d.publisherInfo = rsp;
            b bVar = this.f392427a;
            if (bVar != null) {
                bVar.a(rsp);
            }
        }

        @Override // cz.b
        public void onFailure(int code, String errMsg) {
            b bVar = this.f392427a;
            if (bVar != null) {
                bVar.onFailure(code, errMsg);
            }
        }
    }

    d() {
    }

    public final void b(b listener) {
        x.j("WSPublisherHelper", "[WSPublisherHelper.kt][fetchPublisherInfo]");
        new c().a(new a(listener));
    }

    public final stPublisherRsp c() {
        return publisherInfo;
    }
}
