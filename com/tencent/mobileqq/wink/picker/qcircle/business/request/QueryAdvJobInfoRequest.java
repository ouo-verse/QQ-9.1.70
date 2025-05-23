package com.tencent.mobileqq.wink.picker.qcircle.business.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq;
import qqcircle.QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001f\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/business/request/QueryAdvJobInfoRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "Lqqcircle/QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq;", "getRequest", "", "getRequestByteData", "", "getCmdName", "MessageMicro", "bytes", "decode", "([B)Ljava/lang/Object;", "mRequest", "Lqqcircle/QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq;", "getMRequest", "()Lqqcircle/QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq;", "setMRequest", "(Lqqcircle/QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq;)V", "<init>", "()V", "Companion", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QueryAdvJobInfoRequest extends QCircleBaseRequest {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static final String f324970d = Reflection.getOrCreateKotlinClass(QueryAdvJobInfoRequest.class).getSimpleName();

    @NotNull
    private QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq mRequest = new QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq();

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.pb.MessageMicro, qqcircle.QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp, MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <MessageMicro> MessageMicro decode(@Nullable byte[] bytes) {
        ?? r06 = (MessageMicro) new QQCircleCreatorAdvSvr$StQueryAdvJobInfoRsp();
        try {
            r06.mergeFrom(bytes);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            QLog.e(f324970d, 4, "decode rsp error: " + e16.getMessage());
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.videocircle.creatoradvsvr.CreatorAdvSvr.QueryAdvJobInfo";
    }

    @NotNull
    public final QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq getMRequest() {
        return this.mRequest;
    }

    @NotNull
    public final QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq getRequest() {
        return this.mRequest;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        byte[] byteArray = this.mRequest.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "mRequest.toByteArray()");
        return byteArray;
    }

    public final void setMRequest(@NotNull QQCircleCreatorAdvSvr$StQueryAdvJobInfoReq qQCircleCreatorAdvSvr$StQueryAdvJobInfoReq) {
        Intrinsics.checkNotNullParameter(qQCircleCreatorAdvSvr$StQueryAdvJobInfoReq, "<set-?>");
        this.mRequest = qQCircleCreatorAdvSvr$StQueryAdvJobInfoReq;
    }
}
