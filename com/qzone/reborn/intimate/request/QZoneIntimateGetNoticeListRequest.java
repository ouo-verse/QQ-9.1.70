package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$GetNoticeListReq;
import qzone.QZIntimateSpaceReader$GetNoticeListRsp;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateGetNoticeListRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "attachInfo", "", "commonExt", "Lqzone/QZoneBaseCommon$StCommonExt;", "(Ljava/lang/String;Lqzone/QZoneBaseCommon$StCommonExt;)V", "mGetNoticeListReq", "Lqzone/QZIntimateSpaceReader$GetNoticeListReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateGetNoticeListRequest extends QZoneIntimateBaseRequest {
    private QZIntimateSpaceReader$GetNoticeListReq mGetNoticeListReq;

    public QZoneIntimateGetNoticeListRequest(String str, QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt) {
        QZIntimateSpaceReader$GetNoticeListReq qZIntimateSpaceReader$GetNoticeListReq = new QZIntimateSpaceReader$GetNoticeListReq();
        this.mGetNoticeListReq = qZIntimateSpaceReader$GetNoticeListReq;
        if (str != null) {
            qZIntimateSpaceReader$GetNoticeListReq.attach_info.set(str);
        }
        if (qZoneBaseCommon$StCommonExt != null) {
            this.mGetNoticeListReq.ext.set(qZoneBaseCommon$StCommonExt);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZIntimateSpaceReader$GetNoticeListRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceReader$GetNoticeListRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_commreader.FeedReader.GetNoticeList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetNoticeListReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetNoticeListReq.toByteArray()");
        return byteArray;
    }
}
