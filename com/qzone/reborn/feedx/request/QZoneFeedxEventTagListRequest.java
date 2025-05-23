package com.qzone.reborn.feedx.request;

import com.qzone.reborn.base.QZoneBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneTagFeedList$GetTagFeedListReq;
import qzone.QZoneTagFeedList$GetTagFeedListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/feedx/request/QZoneFeedxEventTagListRequest;", "Lcom/qzone/reborn/base/QZoneBaseRequest;", "tagId", "", "attachInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "mEventTagListRequest", "Lqzone/QZoneTagFeedList$GetTagFeedListReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagListRequest extends QZoneBaseRequest {
    private QZoneTagFeedList$GetTagFeedListReq mEventTagListRequest;

    public QZoneFeedxEventTagListRequest(String tagId, String attachInfo) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        QZoneTagFeedList$GetTagFeedListReq qZoneTagFeedList$GetTagFeedListReq = new QZoneTagFeedList$GetTagFeedListReq();
        this.mEventTagListRequest = qZoneTagFeedList$GetTagFeedListReq;
        qZoneTagFeedList$GetTagFeedListReq.tag_id.set(tagId);
        this.mEventTagListRequest.attach_info.set(attachInfo);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qzone.QZoneTagFeedList$GetTagFeedListRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZoneTagFeedList$GetTagFeedListRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qzone.tagfeedlist.EventTag.GetTagFeedList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mEventTagListRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mEventTagListRequest.toByteArray()");
        return byteArray;
    }
}
