package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$ClearReddotReq;
import qzone.QZIntimateSpaceReader$ClearReddotRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateClearRedDotRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "pageType", "", "(I)V", "mIntimateSpaceClearReddotReq", "Lqzone/QZIntimateSpaceReader$ClearReddotReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateClearRedDotRequest extends QZoneIntimateBaseRequest {
    private QZIntimateSpaceReader$ClearReddotReq mIntimateSpaceClearReddotReq;

    public QZoneIntimateClearRedDotRequest(int i3) {
        QZIntimateSpaceReader$ClearReddotReq qZIntimateSpaceReader$ClearReddotReq = new QZIntimateSpaceReader$ClearReddotReq();
        qZIntimateSpaceReader$ClearReddotReq.page_type.set(i3);
        this.mIntimateSpaceClearReddotReq = qZIntimateSpaceReader$ClearReddotReq;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceReader$ClearReddotRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QZIntimateSpaceReader$ClearReddotRsp>() { // from class: qzone.QZIntimateSpaceReader$ClearReddotRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QZIntimateSpaceReader$ClearReddotRsp.class);
        };
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_commreader.CommReader.ClearReddot";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mIntimateSpaceClearReddotReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mIntimateSpaceClearReddotReq.toByteArray()");
        return byteArray;
    }
}
