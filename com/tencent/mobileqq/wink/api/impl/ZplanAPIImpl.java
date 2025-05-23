package com.tencent.mobileqq.wink.api.impl;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.wink.api.IZplanAPI;
import com.tencent.mobileqq.wink.zplan.WinkAIFaceRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qshadow.AIFacePtaData$ZPlanV2Reply;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/ZplanAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IZplanAPI;", "", "byteArray", "", "gender", "", "seq", "Li83/f;", "Lqshadow/AIFacePtaData$ZPlanV2Reply;", "listener", "", "requestAIFace", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ZplanAPIImpl implements IZplanAPI {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAIFace$lambda$0(i83.f listener, BaseRequest baseRequest, boolean z16, long j3, String errMsg, Object obj) {
        AIFacePtaData$ZPlanV2Reply aIFacePtaData$ZPlanV2Reply;
        Intrinsics.checkNotNullParameter(listener, "$listener");
        w53.b.f("ZplanAPIImpl", "requestAIFace requestArk onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + errMsg);
        if (z16 && j3 == 0) {
            if (obj instanceof AIFacePtaData$ZPlanV2Reply) {
                aIFacePtaData$ZPlanV2Reply = (AIFacePtaData$ZPlanV2Reply) obj;
            } else {
                aIFacePtaData$ZPlanV2Reply = null;
            }
            listener.onSuccess(aIFacePtaData$ZPlanV2Reply);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        listener.a(j3, errMsg);
    }

    @Override // com.tencent.mobileqq.wink.api.IZplanAPI
    public void requestAIFace(@NotNull byte[] byteArray, @NotNull String gender, int seq, @NotNull final i83.f<AIFacePtaData$ZPlanV2Reply> listener) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(listener, "listener");
        VSNetworkHelper.getInstance().sendRequest(RFWApplication.getApplication(), new WinkAIFaceRequest(byteArray, gender, seq), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.api.impl.m
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                ZplanAPIImpl.requestAIFace$lambda$0(i83.f.this, baseRequest, z16, j3, str, obj);
            }
        });
    }
}
