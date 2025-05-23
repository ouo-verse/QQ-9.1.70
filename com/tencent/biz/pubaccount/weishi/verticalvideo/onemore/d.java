package com.tencent.biz.pubaccount.weishi.verticalvideo.onemore;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSOneMoreFeedRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/d;", "", "", "feedId", "Lkotlin/Function1;", "LUserGrowth/stSimpleMetaFeed;", "", "callback", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String feedId, Function1<? super stSimpleMetaFeed, Unit> callback) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (feedId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(feedId);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    callback.invoke(null);
                    return;
                } else {
                    com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSOneMoreFeedRequest(16, feedId)).b(new b(callback));
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J0\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/onemore/d$b", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stSimpleGetFeedListRsp;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends com.tencent.biz.pubaccount.weishi.net.common.b<stSimpleGetFeedListRsp, stSimpleGetFeedListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<stSimpleMetaFeed, Unit> f82221a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super stSimpleMetaFeed, Unit> function1) {
            this.f82221a = function1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            super.b(errorInfo);
            x.j("WSOneMoreFeedFetcher", "request failed. errorCode = " + (errorInfo != null ? Integer.valueOf(errorInfo.a()) : null) + ", errorMsg = " + (errorInfo != null ? errorInfo.b() : null));
            this.f82221a.invoke(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stSimpleGetFeedListRsp rsp) {
            ArrayList<stSimpleMetaFeed> arrayList;
            ArrayList<stSimpleMetaFeed> arrayList2;
            super.d(rsp);
            stSimpleMetaFeed stsimplemetafeed = (rsp == null || (arrayList2 = rsp.feeds) == null || arrayList2.size() <= 0) ? null : arrayList2.get(0);
            x.j("WSOneMoreFeedFetcher", "request success. size = " + ((rsp == null || (arrayList = rsp.feeds) == null) ? null : Integer.valueOf(arrayList.size())) + ", feedId = " + (stsimplemetafeed != null ? stsimplemetafeed.f25129id : null) + ", desc = " + (stsimplemetafeed != null ? stsimplemetafeed.feed_desc : null));
            this.f82221a.invoke(stsimplemetafeed);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stSimpleGetFeedListRsp c(g<stSimpleGetFeedListRsp> request, stSimpleGetFeedListRsp rsp, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            return rsp;
        }
    }
}
