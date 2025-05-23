package com.tencent.mobileqq.zootopia.sso.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td3.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014JZ\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&JZ\u0010\u0012\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/api/IZootopiaProxyServlet;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/AppInterface;", "app", "", "service", "method", "", "reqData", "", "extData", "Ltd3/a;", "observer", "", "source", "timeout", "", "sendZootopiaProxyRequest", "sendZootopiaProxyJsonRequest", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaProxyServlet extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f329285a;
    public static final int TIMEOUT = 10000;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zootopia/sso/api/IZootopiaProxyServlet$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a */
        static final /* synthetic */ Companion f329285a = new Companion();

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b {
        public static /* synthetic */ void a(IZootopiaProxyServlet iZootopiaProxyServlet, AppInterface appInterface, String str, String str2, byte[] bArr, Map map, a aVar, int i3, int i16, int i17, Object obj) {
            int i18;
            int i19;
            if (obj == null) {
                if ((i17 & 64) != 0) {
                    i18 = 0;
                } else {
                    i18 = i3;
                }
                if ((i17 & 128) != 0) {
                    i19 = 10000;
                } else {
                    i19 = i16;
                }
                iZootopiaProxyServlet.sendZootopiaProxyJsonRequest(appInterface, str, str2, bArr, map, aVar, i18, i19);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendZootopiaProxyJsonRequest");
        }

        public static /* synthetic */ void b(IZootopiaProxyServlet iZootopiaProxyServlet, AppInterface appInterface, String str, String str2, byte[] bArr, Map map, a aVar, int i3, int i16, int i17, Object obj) {
            int i18;
            int i19;
            if (obj == null) {
                if ((i17 & 64) != 0) {
                    i18 = 0;
                } else {
                    i18 = i3;
                }
                if ((i17 & 128) != 0) {
                    i19 = 10000;
                } else {
                    i19 = i16;
                }
                iZootopiaProxyServlet.sendZootopiaProxyRequest(appInterface, str, str2, bArr, map, aVar, i18, i19);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendZootopiaProxyRequest");
        }
    }

    void sendZootopiaProxyJsonRequest(@Nullable AppInterface app, @NotNull String service, @NotNull String method, @NotNull byte[] reqData, @NotNull Map<String, String> extData, @NotNull a observer, int source, int timeout);

    void sendZootopiaProxyRequest(@Nullable AppInterface app, @NotNull String service, @NotNull String method, @NotNull byte[] reqData, @NotNull Map<String, String> extData, @NotNull a observer, int source, int timeout);
}
