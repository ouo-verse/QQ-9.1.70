package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRightQuestion;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRightQuestionKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUserKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsByTimeRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageFeedsRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ApplyVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ValidateQARsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.RemoveSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneApplyVisitRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneDeleteVisitRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetMainPageFeedsByTimeRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetMainPageFeedsRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneGetMainPageHeadRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneRemoveSpecialCareRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneSetSpecialCareRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.QzoneValidateQARequest;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000\u00a2\u0006\u0002\b\u000bJ3\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00110\tH\u0000\u00a2\u0006\u0002\b\u0012J7\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00160\tH\u0000\u00a2\u0006\u0002\b\u0017J?\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\n\u0010\u0019\u001a\u00060\u0010j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001c0\tH\u0000\u00a2\u0006\u0002\b\u001dJ#\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001f0\tH\u0000\u00a2\u0006\u0002\b J\b\u0010!\u001a\u00020\u0006H\u0016J)\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020&0\tH\u0000\u00a2\u0006\u0002\b'J)\u0010(\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020)0\tH\u0000\u00a2\u0006\u0002\b*J+\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020.0\tH\u0000\u00a2\u0006\u0002\b/\u00a8\u00061"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneMainPageFeedService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "applyVisit", "", "hostUin", "", "msg", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ApplyVisitRsp;", "applyVisit$qecommerce_biz_release", "deleteVisit", "vtime", "", "mod", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteVisitRsp;", "deleteVisit$qecommerce_biz_release", "fetchMainPageFeed", "attachInfo", "cacheKey", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageFeedsRsp;", "fetchMainPageFeed$qecommerce_biz_release", "fetchMainPageFeedByTime", "directType", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/DirectType;", "feedTime", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageFeedsByTimeRsp;", "fetchMainPageFeedByTime$qecommerce_biz_release", "fetchMainPageFeedHead", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "fetchMainPageFeedHead$qecommerce_biz_release", "getLogTag", "removeSpecialCare", "users", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/RemoveSpecialRsp;", "removeSpecialCare$qecommerce_biz_release", "setSpecialCare", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/SetSpecialRsp;", "setSpecialCare$qecommerce_biz_release", "validateQA", "qa", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRightQuestion;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ValidateQARsp;", "validateQA$qecommerce_biz_release", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneMainPageFeedService extends QzoneBaseService {
    public static final int $stable = 0;
    public static final String TAG = "QzoneMainPageFeedService";

    public final void applyVisit$qecommerce_biz_release(String hostUin, String msg2, DataCallback<ApplyVisitRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "applyVisit hostUin: " + hostUin);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneApplyVisitRequest(null, "", hostUin, msg2), dataCallback, null, 4, null);
    }

    public final void deleteVisit$qecommerce_biz_release(String hostUin, long vtime, int mod, DataCallback<DeleteVisitRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "deleteVisit hostUin: " + hostUin + ", vtime: " + vtime + ", mod: " + mod);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneDeleteVisitRequest(null, "", hostUin, vtime, mod), dataCallback, null, 4, null);
    }

    public final void fetchMainPageFeed$qecommerce_biz_release(String hostUin, String attachInfo, String cacheKey, DataCallback<GetMainPageFeedsRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, QUISkinImage$$ExternalSyntheticOutline0.m("requestMainPageFeed hostUin: ", hostUin, ", attachInfo: ", attachInfo));
        sendQzoneRequest$qecommerce_biz_release(new QzoneGetMainPageFeedsRequest(hostUin, attachInfo), dataCallback, cacheKey);
    }

    public final void fetchMainPageFeedByTime$qecommerce_biz_release(String hostUin, String attachInfo, int directType, long feedTime, DataCallback<GetMainPageFeedsByTimeRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, QUISkinImage$$ExternalSyntheticOutline0.m("fetchMainPageFeedByTime hostUin: ", hostUin, ", attachInfo: ", attachInfo));
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneGetMainPageFeedsByTimeRequest(null, "", hostUin, feedTime, directType, attachInfo), dataCallback, null, 4, null);
    }

    public final void fetchMainPageFeedHead$qecommerce_biz_release(String hostUin, DataCallback<GetMainPageHeadRsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "fetchMainPageFeedHead hostUin: " + hostUin);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneGetMainPageHeadRequest(null, "", hostUin), dataCallback, null, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return TAG;
    }

    public final void removeSpecialCare$qecommerce_biz_release(List<CommonUser> users, DataCallback<RemoveSpecialRsp> dataCallback) {
        int collectionSizeOrDefault;
        List mutableList;
        KLog.INSTANCE.i(TAG, "removeSpecialCare users: " + users);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(users, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = users.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonUserKt.toPbNonNull((CommonUser) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneRemoveSpecialCareRequest(null, mutableList), dataCallback, null, 4, null);
    }

    public final void setSpecialCare$qecommerce_biz_release(List<CommonUser> users, DataCallback<SetSpecialRsp> dataCallback) {
        int collectionSizeOrDefault;
        List mutableList;
        KLog.INSTANCE.i(TAG, "setSpecialCare users: " + users);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(users, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = users.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonUserKt.toPbNonNull((CommonUser) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneSetSpecialCareRequest(null, mutableList), dataCallback, null, 4, null);
    }

    public final void validateQA$qecommerce_biz_release(String hostUin, CommonRightQuestion qa5, DataCallback<ValidateQARsp> dataCallback) {
        KLog.INSTANCE.i(TAG, "validateQA hostUin: " + hostUin + ", qa: " + qa5);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new QzoneValidateQARequest(null, "", hostUin, CommonRightQuestionKt.toPb(qa5)), dataCallback, null, 4, null);
    }

    public static /* synthetic */ void fetchMainPageFeed$qecommerce_biz_release$default(QzoneMainPageFeedService qzoneMainPageFeedService, String str, String str2, String str3, DataCallback dataCallback, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = null;
        }
        qzoneMainPageFeedService.fetchMainPageFeed$qecommerce_biz_release(str, str2, str3, dataCallback);
    }
}
