package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;
import kotlin.Metadata;
import mqq.app.MSFServlet;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IServletAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getNTCmd", "", "", "getPushMsgServlet", "Ljava/lang/Class;", "Lmqq/app/MSFServlet;", "setServletKernelInit", "", "kernel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IServletAPI extends QRouteApi {
    @NotNull
    Set<String> getNTCmd();

    @NotNull
    Class<? extends MSFServlet> getPushMsgServlet();

    void setServletKernelInit();
}
