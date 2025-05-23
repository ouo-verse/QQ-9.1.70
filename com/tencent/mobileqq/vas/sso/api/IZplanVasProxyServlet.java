package com.tencent.mobileqq.vas.sso.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JP\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/sso/api/IZplanVasProxyServlet;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/AppInterface;", "app", "", "service", "method", "", "reqData", "", "extData", "Le33/a;", "observerVas", "", "source", "", "sendVasProxyRequest", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IZplanVasProxyServlet extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        public static /* synthetic */ void a(IZplanVasProxyServlet iZplanVasProxyServlet, AppInterface appInterface, String str, String str2, byte[] bArr, Map map, e33.a aVar, int i3, int i16, Object obj) {
            int i17;
            if (obj == null) {
                if ((i16 & 64) != 0) {
                    i17 = 0;
                } else {
                    i17 = i3;
                }
                iZplanVasProxyServlet.sendVasProxyRequest(appInterface, str, str2, bArr, map, aVar, i17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendVasProxyRequest");
        }
    }

    void sendVasProxyRequest(@Nullable AppInterface app, @NotNull String service, @NotNull String method, @NotNull byte[] reqData, @NotNull Map<String, String> extData, @NotNull e33.a observerVas, int source);
}
