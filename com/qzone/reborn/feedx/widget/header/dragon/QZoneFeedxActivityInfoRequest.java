package com.qzone.reborn.feedx.widget.header.dragon;

import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QzoneActivityPB$ReadUserActivityInfoReq;
import qzone.QzoneActivityPB$ReadUserActivityInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedx/widget/header/dragon/QZoneFeedxActivityInfoRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "()V", "mActivityInfoReq", "Lqzone/QzoneActivityPB$ReadUserActivityInfoReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFeedxActivityInfoRequest extends QZoneBaseRequest {
    private QzoneActivityPB$ReadUserActivityInfoReq mActivityInfoReq = new MessageMicro<QzoneActivityPB$ReadUserActivityInfoReq>() { // from class: qzone.QzoneActivityPB$ReadUserActivityInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QzoneActivityPB$ReadUserActivityInfoReq.class);
    };

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QzoneActivityPB$ReadUserActivityInfoRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QzoneActivityPB$ReadUserActivityInfoRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.qzone_activity.QzoneActivityRead.ReadUserActivityInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mActivityInfoReq.toByteArray()");
        return byteArray;
    }
}
