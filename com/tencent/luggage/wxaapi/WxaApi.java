package com.tencent.luggage.wxaapi;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface WxaApi {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum MiniGameRenderMode {
        SurfaceView,
        TextureView
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public static WxaApi a(@NotNull Context context, @NotNull String str, int i3) {
            com.tencent.luggage.wxa.q7.s d16 = s.d.f138074a.d();
            if (d16 == null) {
                Objects.requireNonNull(context);
                Objects.requireNonNull(str);
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                return new com.tencent.luggage.wxa.q7.s(context, str, i3, false);
            }
            return d16;
        }
    }

    void addLaunchWxaAppPerformanceMetricsListener(@NonNull c cVar);

    void addWxaAppCloseEventListener(@Nullable k kVar);

    void checkAuthState(@Nullable h hVar);

    void clearAuth();

    @NotNull
    com.tencent.luggage.wxaapi.a getDebugApi();

    WxaExtendApiJSBridge getExtendApiJSBridge();

    @NotNull
    String getSDKVersion();

    int getSDKVersionInt();

    @NotNull
    String getTdiUserId();

    boolean handleIntent(@Nullable Context context, @Nullable Intent intent);

    @NotNull
    InitDynamicPkgResult initDynamicPkg(@NotNull String str);

    long launchByQRRawData(@Nullable Context context, @NotNull String str, @Nullable Map<String, Object> map, @Nullable d dVar);

    long launchByUsername(@Nullable Context context, @NotNull String str, int i3, @Nullable String str2, @Nullable Map<String, Object> map, @Nullable b bVar);

    long launchWxaApp(@Nullable Context context, @NotNull String str, int i3, @Nullable String str2, @Nullable Map<String, Object> map, @Nullable d dVar);

    void preloadWxaProcessEnv(int i3, @Nullable g gVar);

    @Nullable
    r queryWxaProfileForAppId(String str);

    void requestUploadLogFiles(int i3, int i16, @Nullable j jVar);

    void sendAuth(@Nullable i iVar);

    void sendCombineAuth(@Nullable SendAuth.Req req, @Nullable IWXAPIEventHandler iWXAPIEventHandler, @Nullable i iVar);

    void setDebugLogImpl(@Nullable q qVar);

    void setSystemPropertiesExtensionImpl(@Nullable s sVar);

    void setWxaAppActionSheetDelegate(@Nullable WxaAppCustomActionSheetDelegate wxaAppCustomActionSheetDelegate);

    void setWxaProcessMaxCount(int i3);

    void setWxaSensitiveApiInvokeHandler(@NonNull u uVar);

    void updateDeviceInfo(@Nullable String str, @Nullable String str2, @Nullable String str3);

    void updateTuringAIDTicket(@Nullable String str);

    void updateTuringOAID(@Nullable String str);
}
