package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionID;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUnionIDKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUserKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.SetFeedPrivateRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.SetTopFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.UnsetTopFeedRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetUncareRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.UnionID;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.DeleteFeedRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.SetFeedPrivateRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.SetTopFeedRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.SetUncareRequest;
import com.tencent.hippykotlin.demo.pages.qzone.feeds.req.UnsetTopFeedRequest;
import com.tencent.kuikly.core.log.KLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\fJ\u001c\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\fJ\u001c\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00170\fJ\u001c\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneFeedOperateService;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "()V", "deleteFeed", "", CommonConstant.KEY_UNION_ID, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUnionID;", "delOpts", "", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteOption;", "dataCallback", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteFeedRsp;", "getLogTag", "", "setFeedPrivate", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/SetFeedPrivateRsp;", "setFeedTop", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/SetTopFeedRsp;", "setUncare", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonUser;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/SetUncareRsp;", "unsetTopFeedTop", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/UnsetTopFeedRsp;", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneFeedOperateService extends QzoneBaseService {
    public static final int $stable = 0;

    public final void deleteFeed(CommonUnionID unionId, List<Integer> delOpts, DataCallback<DeleteFeedRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "deleteFeed, unionId: " + unionId);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new DeleteFeedRequest(CommonUnionIDKt.toPb(unionId), delOpts), dataCallback, null, 4, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService
    public String getLogTag() {
        return "QzoneFeedOperateService";
    }

    public final void setFeedPrivate(CommonUnionID unionId, DataCallback<SetFeedPrivateRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "setFeedPrivate, unionId: " + unionId);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new SetFeedPrivateRequest(CommonUnionIDKt.toPb(unionId)), dataCallback, null, 4, null);
    }

    public final void setFeedTop(CommonUnionID unionId, DataCallback<SetTopFeedRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "setFeedTop, unionId: " + unionId);
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new SetTopFeedRequest(CommonUnionIDKt.toPb(unionId)), dataCallback, null, 4, null);
    }

    public final void setUncare(CommonUser user, DataCallback<SetUncareRsp> dataCallback) {
        List mutableListOf;
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "SetUncare, user: " + user);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(CommonUserKt.toPbNonNull(user));
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new SetUncareRequest(null, mutableListOf), dataCallback, null, 4, null);
    }

    public final void unsetTopFeedTop(CommonUnionID unionId, DataCallback<UnsetTopFeedRsp> dataCallback) {
        KLog.INSTANCE.i(QzoneFeedWriteService.TAG, "unsetTopFeedTop, unionId: " + unionId);
        UnionID pb5 = CommonUnionIDKt.toPb(unionId);
        MapsKt__MapsKt.emptyMap();
        QzoneBaseService.sendQzoneRequest$qecommerce_biz_release$default(this, new UnsetTopFeedRequest(null, pb5), dataCallback, null, 4, null);
    }
}
