package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import c45.a;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFriendFeedPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.GetFriendFeedPageHeadRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.GetFriendFeedsRequest;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J9\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFriendFeedService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "", "attachInfo", "Lc45/a;", "advReqExtend", "cacheKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFeedsRsp;", "dataCallback", "", "fetchFriendFeed$qecommerce_biz_release", "(Ljava/lang/String;Lc45/a;Ljava/lang/String;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;)V", "fetchFriendFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;", "fetchFriendFeedHead$qecommerce_biz_release", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;)V", "fetchFriendFeedHead", "getLogTag", "<init>", "()V", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFriendFeedService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QzoneFriendFeedService";

    public final void fetchFriendFeed$qecommerce_biz_release(String attachInfo, a advReqExtend, String cacheKey, DataCallback<GetFeedsRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "requestFriendFeed attachInfo: " + attachInfo);
        sendQzoneRequest$qecommerce_biz_release(new GetFriendFeedsRequest(null, attachInfo, advReqExtend), dataCallback, cacheKey);
    }

    public final void fetchFriendFeedHead$qecommerce_biz_release(DataCallback<GetFriendFeedPageHeadRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "fetchFriendFeedHead info");
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new GetFriendFeedPageHeadRequest(null, ""), dataCallback, null, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public static /* synthetic */ void fetchFriendFeed$qecommerce_biz_release$default(QzoneFriendFeedService qzoneFriendFeedService, String str, a aVar, String str2, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        qzoneFriendFeedService.fetchFriendFeed$qecommerce_biz_release(str, aVar, str2, dataCallback);
    }
}
