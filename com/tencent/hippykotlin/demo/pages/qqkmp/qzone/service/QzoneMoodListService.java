package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetShuoshuoListRsp;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetShuoShuoListRequest;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000\u00a2\u0006\u0002\b\fJ\b\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneMoodListService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "fetchMoodListFeed", "", "hostUin", "", "attachInfo", "cacheKey", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetShuoshuoListRsp;", "fetchMoodListFeed$qecommerce_biz_release", "getLogTag", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneMoodListService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QzoneMoodListService";

    public final void fetchMoodListFeed$qecommerce_biz_release(String hostUin, String attachInfo, String cacheKey, DataCallback<GetShuoshuoListRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, QUISkinImage$$ExternalSyntheticOutline0.m("fetchMoodListFeed hostUin: ", hostUin, ", attachInfo: ", attachInfo));
        sendQzoneRequest$qecommerce_biz_release(new QzoneGetShuoShuoListRequest(hostUin, attachInfo), dataCallback, cacheKey);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public static /* synthetic */ void fetchMoodListFeed$qecommerce_biz_release$default(QzoneMoodListService qzoneMoodListService, String str, String str2, String str3, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        qzoneMoodListService.fetchMoodListFeed$qecommerce_biz_release(str, str2, str3, dataCallback);
    }
}
