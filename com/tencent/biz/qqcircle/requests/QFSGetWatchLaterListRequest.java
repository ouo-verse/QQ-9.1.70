package com.tencent.biz.qqcircle.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWatchlater$GetWatchLaterListReq;
import feedcloud.FeedCloudWatchlater$GetWatchLaterListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSGetWatchLaterListRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "attachInfo", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudWatchlater$GetWatchLaterListReq;", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QFSGetWatchLaterListRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudWatchlater$GetWatchLaterListReq request;

    public QFSGetWatchLaterListRequest(@Nullable ByteStringMicro byteStringMicro) {
        FeedCloudWatchlater$GetWatchLaterListReq feedCloudWatchlater$GetWatchLaterListReq = new FeedCloudWatchlater$GetWatchLaterListReq();
        this.request = feedCloudWatchlater$GetWatchLaterListReq;
        if (byteStringMicro == null) {
            feedCloudWatchlater$GetWatchLaterListReq.attach_info.set(ByteStringMicro.EMPTY);
        } else {
            feedCloudWatchlater$GetWatchLaterListReq.attach_info.set(byteStringMicro);
        }
        feedCloudWatchlater$GetWatchLaterListReq.size.set(10);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudWatchlater$GetWatchLaterListRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new FeedCloudWatchlater$GetWatchLaterListRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSGetWatchLaterListRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.watchlater.WatchLater.GetWatchLaterList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
