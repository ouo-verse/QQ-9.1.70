package com.tencent.mobileqq.wink.ai.imagetext;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.QZoneAutoTexting$QueryTextingResultReq;
import qshadow.QZoneAutoTexting$QueryTextingResultRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/ai/imagetext/WinkAIQueryImageTextResultRequest;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lqshadow/QZoneAutoTexting$QueryTextingResultReq;", "req$delegate", "Lkotlin/Lazy;", "getReq", "()Lqshadow/QZoneAutoTexting$QueryTextingResultReq;", "req", "", "textIds", "<init>", "(Ljava/util/List;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIQueryImageTextResultRequest extends QCircleBaseRequest {

    /* renamed from: req$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy req;

    public WinkAIQueryImageTextResultRequest(@NotNull final List<String> textIds) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(textIds, "textIds");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneAutoTexting$QueryTextingResultReq>() { // from class: com.tencent.mobileqq.wink.ai.imagetext.WinkAIQueryImageTextResultRequest$req$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QZoneAutoTexting$QueryTextingResultReq invoke() {
                QZoneAutoTexting$QueryTextingResultReq qZoneAutoTexting$QueryTextingResultReq = new QZoneAutoTexting$QueryTextingResultReq();
                qZoneAutoTexting$QueryTextingResultReq.textIds.set(textIds);
                return qZoneAutoTexting$QueryTextingResultReq;
            }
        });
        this.req = lazy;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [qshadow.QZoneAutoTexting$QueryTextingResultRsp, T, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QZoneAutoTexting$QueryTextingResultRsp();
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
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_query_texting_result";
    }

    @NotNull
    public final QZoneAutoTexting$QueryTextingResultReq getReq() {
        return (QZoneAutoTexting$QueryTextingResultReq) this.req.getValue();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = getReq().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
