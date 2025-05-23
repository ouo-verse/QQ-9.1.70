package com.qzone.reborn.intimate.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceRedDotReader$GetRedPointsReq;
import qzone.QZIntimateSpaceRedDotReader$GetRedPointsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u001d\u0010\u000e\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/request/QZoneIntimateRedDotReaderRequest;", "T", "Lcom/qzone/reborn/intimate/request/QZoneIntimateBaseRequest;", "lastEnterTime", "", "needEnterInfo", "", "sceneType", "", "friendUin", "", "(JZILjava/lang/String;)V", "mGetRedPointsRequest", "Lqzone/QZIntimateSpaceRedDotReader$GetRedPointsReq;", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneIntimateRedDotReaderRequest<T> extends QZoneIntimateBaseRequest {
    private QZIntimateSpaceRedDotReader$GetRedPointsReq mGetRedPointsRequest;

    public QZoneIntimateRedDotReaderRequest(long j3, boolean z16, int i3, String friendUin) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        QZIntimateSpaceRedDotReader$GetRedPointsReq qZIntimateSpaceRedDotReader$GetRedPointsReq = new QZIntimateSpaceRedDotReader$GetRedPointsReq();
        this.mGetRedPointsRequest = qZIntimateSpaceRedDotReader$GetRedPointsReq;
        qZIntimateSpaceRedDotReader$GetRedPointsReq.last_enter_time.set(j3);
        this.mGetRedPointsRequest.need_entrance_info.set(z16);
        this.mGetRedPointsRequest.scene.set(i3);
        this.mGetRedPointsRequest.frd_uin.set(friendUin);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZIntimateSpaceRedDotReader$GetRedPointsRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZIntimateSpaceRedDotReader$GetRedPointsRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "IntimateSpace.trpc.qzone.intimate_space_reddotreader.ReddotReader.GetRedPoints";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mGetRedPointsRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mGetRedPointsRequest.toByteArray()");
        return byteArray;
    }
}
