package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellForwardInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneEventBus;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.event.QzoneForwardFeedEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ForwardFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneFeedWriteService;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneFakeDataUtil;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.log.KLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002JN\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedForwardManager;", "", "()V", "writeService", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedWriteService;", "forwardFeed", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "extendInfo", "", "", "reason", "withCmt", "", "from", "", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ForwardFeedRsp;", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedForwardManager {
    private QzoneFeedWriteService writeService = new QzoneFeedWriteService();

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneFeedForwardManager$Companion;", "", "()V", "buildFakeCellForwardInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellForwardInfo;", "curCellForwardInfo", "updateStatusAndNotify", "", "commonFeed", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void updateStatusAndNotify(CommonFeed commonFeed) {
            CommonUnionID unionId;
            CommonCellForwardInfo buildFakeCellForwardInfo = buildFakeCellForwardInfo(commonFeed.getCellForwardInfo());
            CommonCellCommon cellCommon = commonFeed.getCellCommon();
            if (cellCommon == null || (unionId = cellCommon.getUnionId()) == null) {
                return;
            }
            QzoneEventBus.INSTANCE.postEvent(new QzoneForwardFeedEvent(QzoneDataUpdateAction.FORWARD_FEED, unionId, buildFakeCellForwardInfo));
        }

        Companion() {
        }

        public final CommonCellForwardInfo buildFakeCellForwardInfo(CommonCellForwardInfo curCellForwardInfo) {
            Object obj;
            if (curCellForwardInfo == null) {
                curCellForwardInfo = new CommonCellForwardInfo();
            }
            Iterator<T> it = curCellForwardInfo.getForwardList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((CommonUser) obj).getUin(), QZoneComposePlatformModule.Companion.getUin())) {
                    break;
                }
            }
            if (((CommonUser) obj) == null) {
                curCellForwardInfo.setRetweetCount(curCellForwardInfo.getRetweetCount() + 1);
                curCellForwardInfo.getForwardList().add(0, QzoneFakeDataUtil.INSTANCE.buildMasterUser());
            }
            return curCellForwardInfo;
        }
    }

    public final void forwardFeed(final CommonFeed commonFeed, Map<String, String> extendInfo, String reason, boolean withCmt, int from, final DataCallback<ForwardFeedRsp> dataCallback) {
        if (commonFeed == null) {
            KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "forwardFeed error, commonFeed is null");
            if (dataCallback != null) {
                dataCallback.onFailure(QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR, "commonFeed is null");
                return;
            }
            return;
        }
        CommonCellCommon cellCommon = commonFeed.getCellCommon();
        this.writeService.forwardFeed(cellCommon != null ? cellCommon.getUnionId() : null, extendInfo, reason, withCmt, from, new DataCallback<ForwardFeedRsp>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFeedForwardManager$forwardFeed$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                DataCallback<ForwardFeedRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onFailure(errorCode, errorMsg);
                }
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onSuccess(ForwardFeedRsp rsp, long retCode, String msg2, boolean isFinish) {
                DataCallback<ForwardFeedRsp> dataCallback2 = dataCallback;
                if (dataCallback2 != null) {
                    dataCallback2.onSuccess(rsp, retCode, msg2, isFinish);
                }
                QzoneFeedForwardManager.INSTANCE.updateStatusAndNotify(commonFeed);
            }
        });
    }

    public static /* synthetic */ void forwardFeed$default(QzoneFeedForwardManager qzoneFeedForwardManager, CommonFeed commonFeed, Map map, String str, boolean z16, int i3, DataCallback dataCallback, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            dataCallback = null;
        }
        qzoneFeedForwardManager.forwardFeed(commonFeed, map, str, z16, i3, dataCallback);
    }
}
