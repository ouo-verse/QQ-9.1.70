package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneTopEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.SetTopFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.UnsetTopFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedOperateService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedWriteService;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedTopManager;", "", "()V", "writeService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedOperateService;", "setFeedTop", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/SetTopFeedRsp;", "setFeedTopAndNotify", "setFeedUnTopAndNotify", "unsetTopFeedTop", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/UnsetTopFeedRsp;", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedTopManager {
    public static final int $stable = 8;
    private QzoneFeedOperateService writeService = new QzoneFeedOperateService();

    public final void setFeedTop(final CommonUnionID unionId, final DataCallback<SetTopFeedRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "setFeedTop, unionId: " + unionId);
        this.writeService.setFeedTop(unionId, new DataCallback<SetTopFeedRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedTopManager$setFeedTop$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(SetTopFeedRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                this.setFeedTopAndNotify(unionId);
            }
        });
    }

    public final void setFeedTopAndNotify(CommonUnionID unionId) {
        QzoneEventBus.INSTANCE.postEvent(new QzoneTopEvent(QzoneDataUpdateAction.SET_TOP, unionId));
    }

    public final void setFeedUnTopAndNotify(CommonUnionID unionId) {
        QzoneEventBus.INSTANCE.postEvent(new QzoneTopEvent(QzoneDataUpdateAction.SET_UN_TOP, unionId));
    }

    public final void unsetTopFeedTop(final CommonUnionID unionId, final DataCallback<UnsetTopFeedRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "unsetTopFeedTop, unionId: " + unionId);
        this.writeService.unsetTopFeedTop(unionId, new DataCallback<UnsetTopFeedRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedTopManager$unsetTopFeedTop$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(UnsetTopFeedRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                this.setFeedUnTopAndNotify(unionId);
            }
        });
    }
}
