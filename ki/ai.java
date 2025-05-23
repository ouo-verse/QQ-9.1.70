package ki;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.ClientFeed;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetFeedByIdCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetFeedByIdReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetFeedByIdRsp;
import com.tencent.richframework.thread.RFWThreadManager;
import ki.ai;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lki/ai;", "", "", "groupId", "feedId", "albumId", "batchId", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "dataCallback", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name */
    public static final ai f412446a = new ai();

    ai() {
    }

    public void a(String groupId, String feedId, String albumId, String batchId, n.a<BusinessFeedData> dataCallback) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(batchId, "batchId");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        NTGetFeedByIdReq nTGetFeedByIdReq = new NTGetFeedByIdReq();
        nTGetFeedByIdReq.qunId = groupId;
        nTGetFeedByIdReq.feedId = feedId;
        nTGetFeedByIdReq.albumId = albumId;
        nTGetFeedByIdReq.batchId = batchId;
        if (b16 != null) {
            b16.getFeedById(nTGetFeedByIdReq, new a(dataCallback));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ki/ai$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceGetFeedByIdCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/NTGetFeedByIdRsp;", "response", "", "onGetFeedById", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements IAlbumServiceGetFeedByIdCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<BusinessFeedData> f412447a;

        a(n.a<BusinessFeedData> aVar) {
            this.f412447a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(NTGetFeedByIdRsp nTGetFeedByIdRsp, n.a dataCallback) {
            Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
            int i3 = nTGetFeedByIdRsp.result;
            if (i3 == 0) {
                yh.a aVar = yh.a.f450323a;
                ClientFeed clientFeed = nTGetFeedByIdRsp.feed;
                Intrinsics.checkNotNullExpressionValue(clientFeed, "response.feed");
                BusinessFeedData c16 = aVar.c(clientFeed, nTGetFeedByIdRsp.ext);
                long j3 = nTGetFeedByIdRsp.result;
                String str = nTGetFeedByIdRsp.errMs;
                Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
                dataCallback.onSuccess(c16, j3, str, true);
                return;
            }
            dataCallback.onFailure(i3, nTGetFeedByIdRsp.errMs);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetFeedByIdCallback
        public void onGetFeedById(final NTGetFeedByIdRsp response) {
            if (response == null) {
                return;
            }
            RFWLog.e("GroupAlbumRequestFeedRepo", RFWLog.USR, "IAlbumServiceGetFeedByIdCallback trace:" + response.traceid + " ret:" + response.result + "  err\uff1a" + response.errMs);
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final n.a<BusinessFeedData> aVar = this.f412447a;
            rFWThreadManager.runOnUiThread(new Runnable() { // from class: ki.ah
                @Override // java.lang.Runnable
                public final void run() {
                    ai.a.b(NTGetFeedByIdRsp.this, aVar);
                }
            });
        }
    }
}
