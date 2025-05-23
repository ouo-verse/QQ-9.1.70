package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeedKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneRefreshDetailFeedEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneUpdateListFeedEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.ClientFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetUpdateFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedUpdateService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedUpdateManager;", "", "()V", "fetchDetailFeed", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "fetchUpdateFeed", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedUpdateManager {
    public static final int $stable = 0;

    public final void fetchDetailFeed(CommonUnionID unionId) {
        KLog.INSTANCE.i(QzoneFeedUpdateService.TAG, "fetchUpdateFeed unionId: " + unionId);
        if (unionId != null) {
            QzoneEventBus.INSTANCE.postEvent(new QzoneRefreshDetailFeedEvent(unionId));
        }
    }

    public final void fetchUpdateFeed(final CommonUnionID unionId) {
        KLog.INSTANCE.i(QzoneFeedUpdateService.TAG, "fetchUpdateFeed unionId: " + unionId);
        new QzoneFeedUpdateService().fetchUpdateFeed$qecommerce_biz_release(unionId, new DataCallback<GetUpdateFeedRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedUpdateManager$fetchUpdateFeed$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUpdateFeed fail, unionId: ");
                m3.append(CommonUnionID.this);
                m3.append(", errorCode: ");
                m3.append(errorCode);
                m3.append(", errorMsg: ");
                m3.append(errorMsg);
                kLog.i(QzoneFeedUpdateService.TAG, m3.toString());
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(GetUpdateFeedRsp t16, long retCode, String msg2, boolean isFinish) {
                StFeed stFeed;
                ClientFeed clientFeed = t16.feed;
                CommonFeed commonFeed = (clientFeed == null || (stFeed = clientFeed.feed) == null) ? null : CommonFeedKt.toCommonFeed(stFeed);
                if (commonFeed != null) {
                    QzoneEventBus.INSTANCE.postEvent(new QzoneUpdateListFeedEvent(CommonFeedExtKt.getFeedUniqueKey(commonFeed), commonFeed));
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUpdateFeed success, unionId: ");
                    m3.append(CommonUnionID.this);
                    kLog.i(QzoneFeedUpdateService.TAG, m3.toString());
                    return;
                }
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUpdateFeed fail, unionId: ");
                m16.append(CommonUnionID.this);
                m16.append(", feed is null");
                kLog2.i(QzoneFeedUpdateService.TAG, m16.toString());
            }
        });
    }
}
