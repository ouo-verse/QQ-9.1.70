package com.qzone.reborn.feedx.request;

import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneTagFeedList$GetTagFeedListHeadReq;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/feedx/request/QZoneFeedxEventTagHeadRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "tagId", "", "(Ljava/lang/String;)V", "mHeadRequest", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagHeadRequest extends QZoneBaseRequest {
    private QZoneTagFeedList$GetTagFeedListHeadReq mHeadRequest;

    public QZoneFeedxEventTagHeadRequest(String tagId) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        QZoneTagFeedList$GetTagFeedListHeadReq qZoneTagFeedList$GetTagFeedListHeadReq = new QZoneTagFeedList$GetTagFeedListHeadReq();
        this.mHeadRequest = qZoneTagFeedList$GetTagFeedListHeadReq;
        qZoneTagFeedList$GetTagFeedListHeadReq.tag_id.set(tagId);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qzone.QZoneTagFeedList$GetTagFeedListHeadRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZoneTagFeedList$GetTagFeedListHeadRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.tagfeedlist.EventTag.GetTagFeedListHead";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mHeadRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mHeadRequest.toByteArray()");
        return byteArray;
    }
}
