package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB/\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u001f\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/GetStaggeredListReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getCmdName", "", "getRequestByteKey", "getRequestByteData", "T", "rspData", "decode", "([B)Ljava/lang/Object;", "getServiceName", "getMethodName", "", "sourceType", "I", "transInfo", "[B", "Lfeedcloud/FeedCloudRead$StGetFeedListReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudRead$StGetFeedListReq;", "attachInfo", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$RequestType;", "requestType", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "<init>", "(Ljava/lang/String;Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/QFSPublicAccountStaggeredRepo$RequestType;Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;[B)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class GetStaggeredListReq extends QCircleBaseRequest {

    @NotNull
    public static final String CMD = "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountFeeds";

    @NotNull
    private final FeedCloudRead$StGetFeedListReq request;
    private final int sourceType;

    @Nullable
    private final byte[] transInfo;

    public /* synthetic */ GetStaggeredListReq(String str, QFSPublicAccountStaggeredRepo.RequestType requestType, QCircleInitBean qCircleInitBean, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, requestType, qCircleInitBean, (i3 & 8) != 0 ? null : bArr);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudRead$StGetFeedListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] rspData) {
        ?? r06 = (T) new FeedCloudRead$StGetFeedListRsp();
        try {
            r06.mergeFrom(rspData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("GetStaggeredListReq", 1, "decode error, e=" + e16.getMessage(), e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String getCmd() {
        return CMD;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public String getMethodName() {
        if (z20.h.b()) {
            Object obj = com.tencent.biz.qqcircle.requests.a.b(getCmd()).second;
            Intrinsics.checkNotNullExpressionValue(obj, "getServiceMethod(cmdName).second");
            return (String) obj;
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public byte[] getRequestByteKey() {
        return get$pbReqBytes();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public String getServiceName() {
        if (z20.h.b()) {
            Object obj = com.tencent.biz.qqcircle.requests.a.b(getCmd()).first;
            Intrinsics.checkNotNullExpressionValue(obj, "getServiceMethod(cmdName).first");
            return (String) obj;
        }
        return "";
    }

    public GetStaggeredListReq(@Nullable String str, @NotNull QFSPublicAccountStaggeredRepo.RequestType requestType, @NotNull QCircleInitBean initBean, @Nullable byte[] bArr) {
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        int i3 = an.d(initBean) ? 85 : 74;
        this.sourceType = i3;
        this.transInfo = bArr;
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        feedCloudRead$StGetFeedListReq.listNum.set(10);
        feedCloudRead$StGetFeedListReq.from.set(0);
        feedCloudRead$StGetFeedListReq.source.set(i3);
        if (str != null) {
            feedCloudRead$StGetFeedListReq.feedAttchInfo.set(str);
        }
        FeedCloudMeta$StFeed simpleFeed = QCirclePluginUtil.getSimpleFeed(initBean.getFeed());
        QLog.i("GetStaggeredListReq", 1, "firstFeed=" + ((simpleFeed == null || (pBStringField = simpleFeed.f398449id) == null) ? null : pBStringField.get()));
        if (simpleFeed != null && requestType == QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH) {
            feedCloudRead$StGetFeedListReq.feed.set(simpleFeed);
            feedCloudRead$StGetFeedListReq.feed.busiTranparent.set(simpleFeed.busiTranparent.get());
        }
        QQCircleFeedBase$StFeedListBusiReqData bizData = initBean.getFeedListBusiReq();
        if (requestType != QFSPublicAccountStaggeredRepo.RequestType.REFRESH) {
            bizData.detailFeed.set(simpleFeed);
            Intrinsics.checkNotNullExpressionValue(bizData, "bizData");
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.l(initBean, bizData);
        }
        PBBytesField pBBytesField = feedCloudRead$StGetFeedListReq.adres;
        com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
        String str2 = bizData.entrySchema.get();
        Intrinsics.checkNotNullExpressionValue(str2, "bizData.entrySchema.get()");
        pBBytesField.set(jVar.l(str2, an.d(initBean) ? 1002 : i3));
        feedCloudRead$StGetFeedListReq.busiReqData.set(ByteStringMicro.copyFrom(bizData.toByteArray()));
        an.f(feedCloudRead$StGetFeedListReq.extInfo, bArr);
        cq.f92752a.b(feedCloudRead$StGetFeedListReq);
        this.request = feedCloudRead$StGetFeedListReq;
    }
}
