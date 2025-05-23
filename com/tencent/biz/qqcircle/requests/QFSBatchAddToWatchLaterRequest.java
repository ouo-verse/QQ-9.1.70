package com.tencent.biz.qqcircle.requests;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWatchlater$AddWatchLaterEntry;
import feedcloud.FeedCloudWatchlater$BatchAddToWatchLaterReq;
import feedcloud.FeedCloudWatchlater$BatchAddToWatchLaterRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSBatchAddToWatchLaterRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "watchLaterEntry", "", "Lfeedcloud/FeedCloudWatchlater$AddWatchLaterEntry;", "(Ljava/util/List;)V", Const.BUNDLE_KEY_REQUEST, "Lfeedcloud/FeedCloudWatchlater$BatchAddToWatchLaterReq;", "decode", "T", "bytes", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class QFSBatchAddToWatchLaterRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudWatchlater$BatchAddToWatchLaterReq request;

    public QFSBatchAddToWatchLaterRequest(@NotNull List<FeedCloudWatchlater$AddWatchLaterEntry> watchLaterEntry) {
        Intrinsics.checkNotNullParameter(watchLaterEntry, "watchLaterEntry");
        FeedCloudWatchlater$BatchAddToWatchLaterReq feedCloudWatchlater$BatchAddToWatchLaterReq = new FeedCloudWatchlater$BatchAddToWatchLaterReq();
        this.request = feedCloudWatchlater$BatchAddToWatchLaterReq;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(watchLaterEntry);
        feedCloudWatchlater$BatchAddToWatchLaterReq.feed_list.set(arrayList);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [feedcloud.FeedCloudWatchlater$BatchAddToWatchLaterRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new MessageMicro<FeedCloudWatchlater$BatchAddToWatchLaterRsp>() { // from class: feedcloud.FeedCloudWatchlater$BatchAddToWatchLaterRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudWatchlater$BatchAddToWatchLaterRsp.class);
        };
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSBatchAddToWatchLaterRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.watchlater.WatchLater.BatchAddToWatchLater";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = this.request.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "request.toByteArray()");
        return byteArray;
    }
}
