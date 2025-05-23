package com.tencent.biz.qqcircle.requests;

import com.squareup.wire.internal.Internal;
import com.tencent.qphone.base.util.QLog;
import feedcloud.RightFlag;
import feedcloud.SetRightInfoReq;
import feedcloud.SetRightInfoRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/requests/QFSSetRightInfoRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "feed_Id", "Ljava/lang/String;", "getFeed_Id", "()Ljava/lang/String;", "", "rightFlag", "I", "getRightFlag", "()I", "", "uidList", "Ljava/util/List;", "getUidList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSSetRightInfoRequest extends QCircleBaseRequest {

    @NotNull
    private final String feed_Id;
    private final int rightFlag;

    @Nullable
    private final List<String> uidList;

    public QFSSetRightInfoRequest(@NotNull String feed_Id, int i3, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(feed_Id, "feed_Id");
        this.feed_Id = feed_Id;
        this.rightFlag = i3;
        this.uidList = list;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            return (T) SetRightInfoRsp.ADAPTER.decode(bytes);
        } catch (Exception e16) {
            QLog.e("QFSSetRightInfoRequest", 1, "decode, error ", e16);
            return (T) new SetRightInfoRsp.a().build();
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.comment_right.CommentRight.SetRightInfo";
    }

    @NotNull
    public final String getFeed_Id() {
        return this.feed_Id;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        SetRightInfoReq.a c16 = new SetRightInfoReq.a().b(this.feed_Id).c(RightFlag.fromValue(this.rightFlag));
        List<String> list = this.uidList;
        if (list != null) {
            list.isEmpty();
            c16.d(Internal.copyOf(this.uidList));
        }
        return c16.build().encode();
    }

    public final int getRightFlag() {
        return this.rightFlag;
    }

    @Nullable
    public final List<String> getUidList() {
        return this.uidList;
    }
}
