package com.tencent.aelight.camera.ae.config.request;

import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qshadow.QShadowMaterialGeneralService$MaterialGeneralSrvReq;
import qshadow.QShadowMaterialGeneralService$MaterialGeneralSrvRsp;
import qshadow.QShadowMaterialGeneralService$ParamEntry;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aelight/camera/ae/config/request/CameraMaterialGeneralServiceReq;", "Lcom/tencent/mobileqq/qcircle/api/requests/QCircleBaseRequest;", "func_name", "", "params_entry", "Lqshadow/QShadowMaterialGeneralService$ParamEntry;", "(Ljava/lang/String;Lqshadow/QShadowMaterialGeneralService$ParamEntry;)V", "req", "Lqshadow/QShadowMaterialGeneralService$MaterialGeneralSrvReq;", "getReq", "()Lqshadow/QShadowMaterialGeneralService$MaterialGeneralSrvReq;", "req$delegate", "Lkotlin/Lazy;", "decode", "T", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "aelight_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public final class CameraMaterialGeneralServiceReq extends QCircleBaseRequest {

    /* renamed from: req$delegate, reason: from kotlin metadata */
    private final Lazy req;

    public CameraMaterialGeneralServiceReq(final String func_name, final QShadowMaterialGeneralService$ParamEntry params_entry) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(func_name, "func_name");
        Intrinsics.checkNotNullParameter(params_entry, "params_entry");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QShadowMaterialGeneralService$MaterialGeneralSrvReq>() { // from class: com.tencent.aelight.camera.ae.config.request.CameraMaterialGeneralServiceReq$req$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QShadowMaterialGeneralService$MaterialGeneralSrvReq invoke() {
                QShadowMaterialGeneralService$MaterialGeneralSrvReq qShadowMaterialGeneralService$MaterialGeneralSrvReq = new QShadowMaterialGeneralService$MaterialGeneralSrvReq();
                String str = func_name;
                QShadowMaterialGeneralService$ParamEntry qShadowMaterialGeneralService$ParamEntry = params_entry;
                qShadowMaterialGeneralService$MaterialGeneralSrvReq.srv_func_name.set(str);
                qShadowMaterialGeneralService$MaterialGeneralSrvReq.params.add(qShadowMaterialGeneralService$ParamEntry);
                return qShadowMaterialGeneralService$MaterialGeneralSrvReq;
            }
        });
        this.req = lazy;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.tencent.mobileqq.pb.MessageMicro, qshadow.QShadowMaterialGeneralService$MaterialGeneralSrvRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        ?? r06 = (T) new QShadowMaterialGeneralService$MaterialGeneralSrvRsp();
        try {
            r06.mergeFrom(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return r06;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "trpc.shadow_qq.trpc_gateway.TrpcGateway.sso_material_general_srv";
    }

    public final QShadowMaterialGeneralService$MaterialGeneralSrvReq getReq() {
        return (QShadowMaterialGeneralService$MaterialGeneralSrvReq) this.req.getValue();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        byte[] byteArray = getReq().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "req.toByteArray()");
        return byteArray;
    }
}
