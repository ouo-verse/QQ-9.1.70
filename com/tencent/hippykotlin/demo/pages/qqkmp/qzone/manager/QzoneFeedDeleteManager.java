package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneDeleteEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedOperateService;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedDeleteManager;", "", "()V", "operateService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedOperateService;", "deleteFeed", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "delOpts", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteOption;", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteFeedRsp;", "removeFeedFromList", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedDeleteManager {
    public static final int $stable = 8;
    private QzoneFeedOperateService operateService = new QzoneFeedOperateService();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final void deleteFeed(final CommonFeed commonFeed, List<Integer> delOpts, final DataCallback<DeleteFeedRsp> dataCallback) {
        CommonCellCommon cellCommon;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? unionId = (commonFeed == null || (cellCommon = commonFeed.getCellCommon()) == null) ? 0 : cellCommon.getUnionId();
        objectRef.element = unionId;
        if (unionId == 0) {
            KLog.INSTANCE.d(QzoneMainPageFeedManager.TAG, "deleteFeed fail: unionID is null");
        } else {
            this.operateService.deleteFeed(unionId, delOpts, new DataCallback<DeleteFeedRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedDeleteManager$deleteFeed$1
                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onFailure(long errorCode, String errorMsg) {
                    KLog.INSTANCE.d(QzoneMainPageFeedManager.TAG, "deleteFeed fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                    DataCallback<DeleteFeedRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onFailure(errorCode, errorMsg);
                    }
                }

                @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
                public void onSuccess(DeleteFeedRsp t16, long retCode, String msg2, boolean isFinish) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteFeed success, unionID: ");
                    m3.append(objectRef.element);
                    kLog.d(QzoneMainPageFeedManager.TAG, m3.toString());
                    QzoneEventBus.INSTANCE.postEvent(new QzoneDeleteEvent(commonFeed));
                    DataCallback<DeleteFeedRsp> dataCallback2 = dataCallback;
                    if (dataCallback2 != null) {
                        dataCallback2.onSuccess(t16, retCode, msg2, isFinish);
                    }
                }
            });
        }
    }

    public final void removeFeedFromList(CommonFeed commonFeed) {
        QzoneEventBus.INSTANCE.postEvent(new QzoneDeleteEvent(commonFeed));
    }
}
