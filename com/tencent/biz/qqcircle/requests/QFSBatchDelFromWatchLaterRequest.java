package com.tencent.biz.qqcircle.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWatchlater$BatchDelFromWatchLaterReq;
import feedcloud.FeedCloudWatchlater$BatchDelFromWatchLaterRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSBatchDelFromWatchLaterRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "delMode", "", "attachInfo", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "feedIdList", "", "", "(ILcom/tencent/mobileqq/pb/ByteStringMicro;Ljava/util/List;)V", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudWatchlater$BatchDelFromWatchLaterReq;", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QFSBatchDelFromWatchLaterRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudWatchlater$BatchDelFromWatchLaterReq request;

    public QFSBatchDelFromWatchLaterRequest(int i3, @Nullable ByteStringMicro byteStringMicro, @Nullable List<String> list) {
        FeedCloudWatchlater$BatchDelFromWatchLaterReq feedCloudWatchlater$BatchDelFromWatchLaterReq = new FeedCloudWatchlater$BatchDelFromWatchLaterReq();
        this.request = feedCloudWatchlater$BatchDelFromWatchLaterReq;
        feedCloudWatchlater$BatchDelFromWatchLaterReq.del_mode.set(i3);
        if (byteStringMicro == null) {
            feedCloudWatchlater$BatchDelFromWatchLaterReq.attach_info.set(ByteStringMicro.EMPTY);
        } else {
            feedCloudWatchlater$BatchDelFromWatchLaterReq.attach_info.set(byteStringMicro);
        }
        if (list != null) {
            feedCloudWatchlater$BatchDelFromWatchLaterReq.feed_id_list.set(list);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudWatchlater$BatchDelFromWatchLaterRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new MessageMicro<FeedCloudWatchlater$BatchDelFromWatchLaterRsp>() { // from class: feedcloud.FeedCloudWatchlater$BatchDelFromWatchLaterRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudWatchlater$BatchDelFromWatchLaterRsp.class);
        };
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSBatchDelFromWatchLaterRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.watchlater.WatchLater.BatchDelFromWatchLater";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
