package cz;

import UserGrowth.stPublisherRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.GetPublisherRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcz/c;", "", "Lcz/b;", "listener", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {
    public final void a(b listener) {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new GetPublisherRequest()).b(new a(listener));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J,\u0010\b\u001a\u00020\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\u000f"}, d2 = {"cz/c$a", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stPublisherRsp;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stPublisherRsp, stPublisherRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f392424a;

        a(b bVar) {
            this.f392424a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            super.b(errorInfo);
            b bVar = this.f392424a;
            if (bVar != null) {
                bVar.onFailure(errorInfo != null ? errorInfo.a() : -1, errorInfo != null ? errorInfo.b() : null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stPublisherRsp c(g<stPublisherRsp> request, stPublisherRsp rsp, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            return rsp;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stPublisherRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            super.d(rsp);
            b bVar = this.f392424a;
            if (bVar != null) {
                bVar.a(rsp);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
        }
    }
}
