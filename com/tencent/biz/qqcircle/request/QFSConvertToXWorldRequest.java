package com.tencent.biz.qqcircle.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudConvertidClient$ConvertToXWorldReq;
import feedcloud.FeedCloudConvertidClient$ConvertToXWorldRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/request/QFSConvertToXWorldRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "feedId", "", "(Ljava/lang/String;)V", "mConvertFeedDetailReq", "Lfeedcloud/FeedCloudConvertidClient$ConvertToXWorldReq;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QFSConvertToXWorldRequest extends QCircleBaseRequest {

    @NotNull
    private FeedCloudConvertidClient$ConvertToXWorldReq mConvertFeedDetailReq;

    public QFSConvertToXWorldRequest(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        FeedCloudConvertidClient$ConvertToXWorldReq feedCloudConvertidClient$ConvertToXWorldReq = new FeedCloudConvertidClient$ConvertToXWorldReq();
        this.mConvertFeedDetailReq = feedCloudConvertidClient$ConvertToXWorldReq;
        feedCloudConvertidClient$ConvertToXWorldReq.id_type.set(1);
        this.mConvertFeedDetailReq.ids.add(feedId);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudConvertidClient$ConvertToXWorldRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new FeedCloudConvertidClient$ConvertToXWorldRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.feeds_import.ConvertidClient.ConvertToXWorld";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.mConvertFeedDetailReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mConvertFeedDetailReq.toByteArray()");
        return byteArray;
    }
}
