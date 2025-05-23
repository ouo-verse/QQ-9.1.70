package com.tencent.mobileqq.thirdsig.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/IOpenSigInjectService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "Lcom/tencent/mobileqq/thirdsig/api/a;", "callback", "", "commitOpenTicketToMsf", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IOpenSigInjectService extends QRouteApi {
    void commitOpenTicketToMsf(long uin, @NotNull a callback);
}
