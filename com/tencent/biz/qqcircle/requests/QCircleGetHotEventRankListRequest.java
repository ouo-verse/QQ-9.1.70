package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.beans.HotEventInfo;
import com.tencent.biz.qqcircle.beans.QCircleHotEventRankInitBean;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$GetHotTagRankPageReq;
import feedcloud.FeedCloudRead$GetHotTagRankPageRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u001b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001f\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QCircleGetHotEventRankListRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "T", "rspData", "decode", "([B)Ljava/lang/Object;", "", "getCmdName", "feedAttachInfoStr", "Ljava/lang/String;", "Lcom/tencent/biz/qqcircle/beans/QCircleHotEventRankInitBean;", "initBean", "Lcom/tencent/biz/qqcircle/beans/QCircleHotEventRankInitBean;", "<init>", "(Ljava/lang/String;Lcom/tencent/biz/qqcircle/beans/QCircleHotEventRankInitBean;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QCircleGetHotEventRankListRequest extends QCircleBaseRequest {

    @Nullable
    private final String feedAttachInfoStr;

    @NotNull
    private final QCircleHotEventRankInitBean initBean;

    public /* synthetic */ QCircleGetHotEventRankListRequest(String str, QCircleHotEventRankInitBean qCircleHotEventRankInitBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, qCircleHotEventRankInitBean);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudRead$GetHotTagRankPageRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] rspData) {
        ?? r06 = (T) new FeedCloudRead$GetHotTagRankPageRsp();
        try {
            r06.mergeFrom(rspData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QCircleGetHotEventRankListRequest", 1, e16, new Object[0]);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetHotTagRankPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        boolean z16;
        FeedCloudRead$GetHotTagRankPageReq feedCloudRead$GetHotTagRankPageReq = new FeedCloudRead$GetHotTagRankPageReq();
        String str = this.feedAttachInfoStr;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            feedCloudRead$GetHotTagRankPageReq.feedAttachInfo.set(this.feedAttachInfoStr);
        }
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        HotEventInfo hotEventInfo = this.initBean.getHotEventInfo();
        if (hotEventInfo != null) {
            Intrinsics.checkNotNullExpressionValue(hotEventInfo, "hotEventInfo");
            PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField = feedCloudCommon$StCommonExt.mapInfo;
            Intrinsics.checkNotNullExpressionValue(pBRepeatMessageField, "extInfo.mapInfo");
            PbExtKt.b(pBRepeatMessageField, hotEventInfo);
        }
        feedCloudRead$GetHotTagRankPageReq.extInfo.set(feedCloudCommon$StCommonExt);
        byte[] byteArray = feedCloudRead$GetHotTagRankPageReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "GetHotTagRankPageReq()\n \u2026 }\n        .toByteArray()");
        return byteArray;
    }

    public QCircleGetHotEventRankListRequest(@Nullable String str, @NotNull QCircleHotEventRankInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.feedAttachInfoStr = str;
        this.initBean = initBean;
    }
}
