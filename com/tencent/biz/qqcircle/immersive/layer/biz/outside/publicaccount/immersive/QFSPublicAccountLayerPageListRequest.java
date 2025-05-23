package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.an;
import com.tencent.biz.qqcircle.immersive.utils.j;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import z20.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/QFSPublicAccountLayerPageListRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getCmdName", "", "getRequestByteData", "T", "rspData", "decode", "([B)Ljava/lang/Object;", "getType", "getRefer", "", "rsp", "", "getCount", "getInfo", "getServiceName", "getMethodName", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "bean", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "", "isRefresh", "Z", "()Z", "isImmersiveFromStaggered", "cmd", "Ljava/lang/String;", "Lfeedcloud/FeedCloudRead$StGetFeedListReq;", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudRead$StGetFeedListReq;", "attachInfo", "Lfeedcloud/FeedCloudCommon$StCommonExt;", "extInfo", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;ZLjava/lang/String;Lfeedcloud/FeedCloudCommon$StCommonExt;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
final class QFSPublicAccountLayerPageListRequest extends QCircleBaseRequest {

    @NotNull
    private final QCircleInitBean bean;

    @NotNull
    private final String cmd;
    private final boolean isImmersiveFromStaggered;
    private final boolean isRefresh;

    @NotNull
    private final FeedCloudRead$StGetFeedListReq request;

    public QFSPublicAccountLayerPageListRequest(@NotNull QCircleInitBean bean, boolean z16, @Nullable String str, @NotNull FeedCloudCommon$StCommonExt extInfo) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        this.bean = bean;
        this.isRefresh = z16;
        boolean z17 = false;
        boolean z18 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.h(bean) || an.d(bean);
        this.isImmersiveFromStaggered = z18;
        this.cmd = z18 ? "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountSecondaryPageFeeds" : QCircleTabGetFeedListRequest.CMD_GET_FEED_LIST;
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        FeedCloudMeta$StFeed firstFeed = QCirclePluginUtil.getSimpleFeed(bean.getFeed());
        boolean z19 = z18 || com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.k(bean);
        if (str == null && !z16) {
            z17 = true;
        }
        Intrinsics.checkNotNullExpressionValue(firstFeed, "firstFeed");
        QLog.i("QFSPublicAccountLayerPageListRequest", 1, "isFirstReq:" + z17 + ", shouldRequestSpecificFeed=" + z19 + " firstFeed=" + com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.i(firstFeed));
        feedCloudRead$StGetFeedListReq.extInfo.set(extInfo);
        if (z17 && z19) {
            feedCloudRead$StGetFeedListReq.feed.set(firstFeed);
            feedCloudRead$StGetFeedListReq.feed.busiTranparent.set(bean.getFeed().busiTranparent.get());
        }
        QCircleExtraTypeInfo extraTypeInfo = bean.getExtraTypeInfo();
        if (extraTypeInfo != null) {
            Intrinsics.checkNotNullExpressionValue(extraTypeInfo, "extraTypeInfo");
            feedCloudRead$StGetFeedListReq.source.set(extraTypeInfo.sourceType);
        }
        if (str != null) {
            feedCloudRead$StGetFeedListReq.feedAttchInfo.set(str);
        }
        QQCircleFeedBase$StFeedListBusiReqData bizData = bean.getFeedListBusiReq();
        if (!z16 && z19) {
            bizData.detailFeed.set(firstFeed);
            Intrinsics.checkNotNullExpressionValue(bizData, "bizData");
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.l(bean, bizData);
        }
        String x26 = uq3.c.x2();
        Intrinsics.checkNotNullExpressionValue(x26, "getNewLayerMode()");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(x26);
        if (intOrNull != null) {
            bizData.pageLayoutType.set(intOrNull.intValue());
        }
        PBBytesField pBBytesField = feedCloudRead$StGetFeedListReq.adres;
        j jVar = j.f90213a;
        String str2 = bizData.entrySchema.get();
        Intrinsics.checkNotNullExpressionValue(str2, "bizData.entrySchema.get()");
        pBBytesField.set(jVar.l(str2, bean.getExtraTypeInfo().sourceType));
        feedCloudRead$StGetFeedListReq.busiReqData.set(ByteStringMicro.copyFrom(bizData.toByteArray()));
        cq.f92752a.b(feedCloudRead$StGetFeedListReq);
        this.request = feedCloudRead$StGetFeedListReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudRead$StGetFeedListRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] rspData) {
        ?? r06 = (T) new FeedCloudRead$StGetFeedListRsp();
        try {
            r06.mergeFrom(rspData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSPublicAccountLayerPageListRequest", 1, "decode error, e=" + e16.getMessage(), e16);
        }
        return r06;
    }

    @NotNull
    public final QCircleInitBean getBean() {
        return this.bean;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName, reason: from getter */
    public String getCmd() {
        return this.cmd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    public int getCount(@Nullable Object rsp) {
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
        if ((rsp instanceof FeedCloudRead$StGetFeedListRsp) && (pBRepeatMessageField = ((FeedCloudRead$StGetFeedListRsp) rsp).vecFeed) != null) {
            return pBRepeatMessageField.get().size();
        }
        return super.getCount(rsp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    @Nullable
    public String getInfo() {
        HashMap<String, String> schemeAttrs = this.bean.getSchemeAttrs();
        if (schemeAttrs != null && schemeAttrs.size() > 0) {
            return schemeAttrs.get("xsj_main_entrance");
        }
        return super.getInfo();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public String getMethodName() {
        if (!h.b()) {
            String methodName = super.getMethodName();
            Intrinsics.checkNotNullExpressionValue(methodName, "super.getMethodName()");
            return methodName;
        }
        if (TextUtils.equals(this.cmd, "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountSecondaryPageFeeds")) {
            Object obj = com.tencent.biz.qqcircle.requests.a.b("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountSecondaryPageFeeds").second;
            Intrinsics.checkNotNullExpressionValue(obj, "getServiceMethod(\n      \u2026ONDARY_PAGE_FEEDS).second");
            return (String) obj;
        }
        String methodName2 = super.getMethodName();
        Intrinsics.checkNotNullExpressionValue(methodName2, "super.getMethodName()");
        return methodName2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    @Nullable
    public String getRefer() {
        if ((!this.isRefresh && TextUtils.isEmpty(this.request.feedAttchInfo.get())) || this.isRefresh) {
            return "1";
        }
        return "0";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public String getServiceName() {
        if (!h.b()) {
            String serviceName = super.getServiceName();
            Intrinsics.checkNotNullExpressionValue(serviceName, "super.getServiceName()");
            return serviceName;
        }
        if (TextUtils.equals(this.cmd, "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountSecondaryPageFeeds")) {
            Object obj = com.tencent.biz.qqcircle.requests.a.b("FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountSecondaryPageFeeds").first;
            Intrinsics.checkNotNullExpressionValue(obj, "getServiceMethod(\n      \u2026CONDARY_PAGE_FEEDS).first");
            return (String) obj;
        }
        String serviceName2 = super.getServiceName();
        Intrinsics.checkNotNullExpressionValue(serviceName2, "super.getServiceName()");
        return serviceName2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest
    @Nullable
    public String getType() {
        return String.valueOf(this.request.source.get());
    }

    /* renamed from: isRefresh, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }
}
