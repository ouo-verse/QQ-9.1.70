package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceWriter$StDelNoticeReq;
import qzone.QZIntimateSpaceWriter$StDelNoticeRsp;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateDeleteMessageRequest;", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "noticeId", "", "from", "", "extInfo", "Lqzone/QZoneBaseCommon$StCommonExt;", "(Ljava/lang/String;ILqzone/QZoneBaseCommon$StCommonExt;)V", "mDeleteMessageReq", "Lqzone/QZIntimateSpaceWriter$StDelNoticeReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateDeleteMessageRequest extends QZoneIntimateBaseRequest {
    private QZIntimateSpaceWriter$StDelNoticeReq mDeleteMessageReq;

    public QZoneIntimateDeleteMessageRequest(String noticeId, int i3, QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt) {
        Intrinsics.checkNotNullParameter(noticeId, "noticeId");
        QZIntimateSpaceWriter$StDelNoticeReq qZIntimateSpaceWriter$StDelNoticeReq = new QZIntimateSpaceWriter$StDelNoticeReq();
        this.mDeleteMessageReq = qZIntimateSpaceWriter$StDelNoticeReq;
        qZIntimateSpaceWriter$StDelNoticeReq.notice_id.set(noticeId);
        this.mDeleteMessageReq.ext_info.set(qZoneBaseCommon$StCommonExt);
        this.mDeleteMessageReq.from.set(i3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZIntimateSpaceWriter$StDelNoticeRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new MessageMicro<QZIntimateSpaceWriter$StDelNoticeRsp>() { // from class: qzone.QZIntimateSpaceWriter$StDelNoticeRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ext_info"}, new Object[]{null}, QZIntimateSpaceWriter$StDelNoticeRsp.class);
            public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
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
        return "IntimateSpace.trpc.qzone.intimate_space_commwriter.ComWriter.DelNotice";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mDeleteMessageReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mDeleteMessageReq.toByteArray()");
        return byteArray;
    }
}
