package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleYuhengActivity$CheckPrizeReq;
import qqcircle.QQCircleYuhengActivity$CheckPrizeRsp;
import qqcircle.QQCircleYuhengActivity$YuhengInfo;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u0004J\b\u0010\r\u001a\u00020\bH\u0014J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/request/QFSActivityCheckPrizeReq;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "()V", "req", "Lqqcircle/QQCircleYuhengActivity$CheckPrizeReq;", "decode", "T", "byteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getReq", "getRequestByteData", "setYuhengInfo", "", "yuhengInfo", "Lqqcircle/QQCircleYuhengActivity$YuhengInfo;", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSActivityCheckPrizeReq extends QCircleBaseRequest {

    @NotNull
    private final QQCircleYuhengActivity$CheckPrizeReq req = new QQCircleYuhengActivity$CheckPrizeReq();

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qqcircle.QQCircleYuhengActivity$CheckPrizeRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] byteArray) {
        ?? r06 = (T) new QQCircleYuhengActivity$CheckPrizeRsp();
        try {
            r06.mergeFrom(byteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.yuhengactivity.DrawAccessSvr.CheckPrize";
    }

    @NotNull
    public final QQCircleYuhengActivity$CheckPrizeReq getReq() {
        return this.req;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.req.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }

    public final void setYuhengInfo(@NotNull QQCircleYuhengActivity$YuhengInfo yuhengInfo) {
        List<QQCircleYuhengActivity$YuhengInfo> mutableListOf;
        Intrinsics.checkNotNullParameter(yuhengInfo, "yuhengInfo");
        PBRepeatMessageField<QQCircleYuhengActivity$YuhengInfo> pBRepeatMessageField = this.req.infos;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(yuhengInfo);
        pBRepeatMessageField.set(mutableListOf);
    }
}
