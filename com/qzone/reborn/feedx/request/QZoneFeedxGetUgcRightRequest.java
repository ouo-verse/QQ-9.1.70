package com.qzone.reborn.feedx.request;

import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneRightAccess$GetUgcRightReq;
import qzone.QZoneRightAccess$GetUgcRightRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001d\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/feedx/request/QZoneFeedxGetUgcRightRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "appid", "", "ugcid", "", QQWinkConstants.FEEDTIME, "", "(ILjava/lang/String;J)V", "mGetUgcRightRequest", "Lqzone/QZoneRightAccess$GetUgcRightReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFeedxGetUgcRightRequest extends QZoneBaseRequest {
    private QZoneRightAccess$GetUgcRightReq mGetUgcRightRequest;

    public QZoneFeedxGetUgcRightRequest(int i3, String str, long j3) {
        QZoneRightAccess$GetUgcRightReq qZoneRightAccess$GetUgcRightReq = new QZoneRightAccess$GetUgcRightReq();
        this.mGetUgcRightRequest = qZoneRightAccess$GetUgcRightReq;
        qZoneRightAccess$GetUgcRightReq.appid.set(i3);
        this.mGetUgcRightRequest.ugcid.set(str == null ? "" : str);
        this.mGetUgcRightRequest.feed_time.set(j3);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZoneRightAccess$GetUgcRightRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZoneRightAccess$GetUgcRightRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.rightaccess.Right.GetUgcRight";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetUgcRightRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetUgcRightRequest.toByteArray()");
        return byteArray;
    }
}
