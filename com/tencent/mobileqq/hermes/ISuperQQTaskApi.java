package com.tencent.mobileqq.hermes;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/hermes/ISuperQQTaskApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getEasterEggPart", "Lcom/tencent/biz/richframework/part/Part;", "hermes-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes8.dex */
public interface ISuperQQTaskApi extends QRouteApi {
    @NotNull
    Part getEasterEggPart();
}
