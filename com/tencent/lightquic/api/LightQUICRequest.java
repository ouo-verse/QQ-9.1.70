package com.tencent.lightquic.api;

import com.tencent.lightquic.impl.LightQUICNative;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/lightquic/api/LightQUICRequest;", "", "engineId", "", "url", "", "ip", "headers", "", "callback", "Lcom/tencent/lightquic/api/IRequestCallback;", DownloadInfo.spKey_Config, "Lcom/tencent/lightquic/api/LightQUICRequestConfig;", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/tencent/lightquic/api/IRequestCallback;Lcom/tencent/lightquic/api/LightQUICRequestConfig;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "cancelRequest", "", "startRequest", "body", "", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class LightQUICRequest {
    static IPatchRedirector $redirector_;
    private final long requestId;

    public LightQUICRequest(long j3, @NotNull String url, @NotNull String ip5, @Nullable Map<String, String> map, @NotNull IRequestCallback callback, @Nullable LightQUICRequestConfig lightQUICRequestConfig) {
        Map<String, String> emptyMap;
        Map<String, String> map2;
        LightQUICRequestConfig lightQUICRequestConfig2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ip5, "ip");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), url, ip5, map, callback, lightQUICRequestConfig);
            return;
        }
        LightQUICNative lightQUICNative = LightQUICNative.INSTANCE;
        if (map == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
        if (lightQUICRequestConfig != null) {
            lightQUICRequestConfig2 = lightQUICRequestConfig;
        } else {
            lightQUICRequestConfig2 = new LightQUICRequestConfig(null, false, 0.0f, 0, 15, null);
        }
        this.requestId = lightQUICNative.createQUICRequest(j3, url, ip5, map2, callback, lightQUICRequestConfig2);
    }

    public final void cancelRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            LightQUICNative.INSTANCE.cancelRequest(this.requestId);
        }
    }

    public final void startRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            LightQUICNative.INSTANCE.startRequest(this.requestId);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void startRequest(@NotNull byte[] body) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) body);
        } else {
            Intrinsics.checkNotNullParameter(body, "body");
            LightQUICNative.INSTANCE.startRequestWithBody(this.requestId, body);
        }
    }
}
