package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi.request.GetFeedDetailRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/d;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/e;", "param", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J*\u0010\t\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014\u00a8\u0006\u0011"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/data/d$a", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stSimpleGetFeedDetailRsp;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "data", "", "f", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "a", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stSimpleGetFeedDetailRsp, j> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kz.a<j> f81984a;

        a(kz.a<j> aVar) {
            this.f81984a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j errorInfo) {
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j errorInfo) {
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
            super.b(errorInfo);
            this.f81984a.onFailure(errorInfo.a(), errorInfo.b());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public j c(com.tencent.biz.pubaccount.weishi.net.common.g<stSimpleGetFeedDetailRsp> request, stSimpleGetFeedDetailRsp rsp, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            j f16 = i.f(rsp.feed);
            Intrinsics.checkNotNullExpressionValue(f16, "convertStSimpleMetaFeed(rsp.feed)");
            return f16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(j data) {
            super.d(data);
            this.f81984a.onSuccess(data);
        }
    }

    public final void a(e param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new GetFeedDetailRequest(param.getFeedId(), param.getScene(), param.d())).b(new a(param.b()));
    }
}
