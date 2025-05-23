package com.tencent.mobileqq.wink.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import qshadow.AIFacePtaData$ZPlanV2Reply;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IZplanAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "byteArray", "", "gender", "", "seq", "Li83/f;", "Lqshadow/AIFacePtaData$ZPlanV2Reply;", "listener", "", "requestAIFace", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZplanAPI extends QRouteApi {
    void requestAIFace(@NotNull byte[] byteArray, @NotNull String gender, int seq, @NotNull i83.f<AIFacePtaData$ZPlanV2Reply> listener);
}
