package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetUpdateFeedRsp;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetUpdateFeedRequest;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u00a2\u0006\u0002\b\u000bJ%\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u00a2\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedUpdateService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "fetchRealFeed", "", "clientKey", "", "attachInfo", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetUpdateFeedRsp;", "fetchRealFeed$qecommerce_biz_release", "fetchUpdateFeed", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "fetchUpdateFeed$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedUpdateService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QzoneFeedUpdateService";

    public final void fetchRealFeed$qecommerce_biz_release(String clientKey, String attachInfo, DataCallback<GetUpdateFeedRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, QUISkinImage$$ExternalSyntheticOutline0.m("fetchRealFeed clientKey: ", clientKey, ", attachInfo: ", attachInfo));
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneGetUpdateFeedRequest(null, clientKey, attachInfo, 1), dataCallback, null, 4, null);
    }

    public final void fetchUpdateFeed$qecommerce_biz_release(CommonUnionID unionId, DataCallback<GetUpdateFeedRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "fetchUpdateFeed unionId: " + unionId);
        String str = null;
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneGetUpdateFeedRequest(CommonUnionIDKt.toPb(unionId), str, str, 6), dataCallback, null, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }
}
