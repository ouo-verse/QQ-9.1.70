package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzonePermissionEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.SetFeedPrivateRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedOperateService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedWriteService;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedPermissionManager;", "", "()V", "writeService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedOperateService;", "buildFakeCellPermission", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "setFeedPrivate", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/SetFeedPrivateRsp;", "setFeedPrivateAndNotify", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedPermissionManager {
    public static final int $stable = 8;
    private QzoneFeedOperateService writeService = new QzoneFeedOperateService();

    private final CommonCellPermission buildFakeCellPermission() {
        CommonCellPermission commonCellPermission = new CommonCellPermission();
        commonCellPermission.setIcon("qui_lock");
        commonCellPermission.setDesc("\u4ec5\u81ea\u5df1\u53ef\u89c1");
        return commonCellPermission;
    }

    public final void setFeedPrivate(final CommonUnionID unionId, final DataCallback<SetFeedPrivateRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "setFeedPrivate, unionId: " + unionId);
        this.writeService.setFeedPrivate(unionId, new DataCallback<SetFeedPrivateRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedPermissionManager$setFeedPrivate$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                dataCallback.onFailure(errorCode, errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(SetFeedPrivateRsp t16, long retCode, String msg2, boolean isFinish) {
                dataCallback.onSuccess(t16, retCode, msg2, isFinish);
                this.setFeedPrivateAndNotify(unionId);
            }
        });
    }

    public final void setFeedPrivateAndNotify(CommonUnionID unionId) {
        QzoneEventBus.INSTANCE.postEvent(new QzonePermissionEvent(QzoneDataUpdateAction.MODIFY_PERMISSION, unionId, buildFakeCellPermission()));
    }
}
