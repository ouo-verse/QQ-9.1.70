package com.tencent.biz.qqcircle.immersive.redpacket.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudDatacard$GetRedPocketNumberReq;
import feedcloud.FeedCloudDatacard$GetRedPocketNumberRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSGetRedPacketNumRequest;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "bytes", "decode", "([B)Ljava/lang/Object;", "Lfeedcloud/FeedCloudDatacard$GetRedPocketNumberReq;", "req", "Lfeedcloud/FeedCloudDatacard$GetRedPocketNumberReq;", "<init>", "(Lfeedcloud/FeedCloudDatacard$GetRedPocketNumberReq;)V", "Companion", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSGetRedPacketNumRequest extends QCircleBaseRequest {

    @NotNull
    private final FeedCloudDatacard$GetRedPocketNumberReq req;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSGetRedPacketNumRequest$a;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest$a;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/request/QFSGetRedPacketNumRequest;", "e", "Lfeedcloud/FeedCloudDatacard$GetRedPocketNumberReq;", "c", "Lfeedcloud/FeedCloudDatacard$GetRedPocketNumberReq;", "getReq", "()Lfeedcloud/FeedCloudDatacard$GetRedPocketNumberReq;", "req", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QCircleBaseRequest.a<QFSGetRedPacketNumRequest> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FeedCloudDatacard$GetRedPocketNumberReq req = new MessageMicro<FeedCloudDatacard$GetRedPocketNumberReq>() { // from class: feedcloud.FeedCloudDatacard$GetRedPocketNumberReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], FeedCloudDatacard$GetRedPocketNumberReq.class);
        };

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        @NotNull
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSGetRedPacketNumRequest b() {
            return new QFSGetRedPacketNumRequest(this.req);
        }
    }

    public QFSGetRedPacketNumRequest(@NotNull FeedCloudDatacard$GetRedPocketNumberReq req) {
        Intrinsics.checkNotNullParameter(req, "req");
        this.req = req;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, feedcloud.FeedCloudDatacard$GetRedPocketNumberRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] bytes) {
        ?? r06 = (T) new FeedCloudDatacard$GetRedPocketNumberRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QFSGetRedPacketNumRequest", 1, "decode, error ", e16);
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.datacard.RedPocket.GetRedPocketNumber";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
