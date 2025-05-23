package com.tencent.qq.minibox.api;

import android.content.Context;
import android.os.Bundle;
import bs3.b;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&JH\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0016\u001a\u00020\u0011H&J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\bH&J\b\u0010\u0019\u001a\u00020\u0014H&J\b\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001c\u001a\u00020\bH&J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010\u001d\u001a\u00020\u0004H&J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0004H&J\b\u0010#\u001a\u00020\"H&J\"\u0010(\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&H&J\f\u0010*\u001a\u0006\u0012\u0002\b\u00030)H&J\u0010\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0004H&J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\bH&J.\u00105\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000f2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0004012\u0006\u00104\u001a\u000203H&J\u0012\u00106\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&J\u001e\u00109\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004082\u0006\u00107\u001a\u00020\u0004H&J$\u0010=\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u00107\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010\u0004H&J\b\u0010>\u001a\u00020\bH&J\b\u0010?\u001a\u00020\bH&\u00a8\u0006@"}, d2 = {"Lcom/tencent/qq/minibox/api/IMiniBoxService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmqq/app/MobileQQ;", "app", "", "procName", "Lmqq/app/AppRuntime;", "createAppInterface", "", "isMiniBoxFeatureSwitchEnable", "isMiniBoxSystemInstallSwitchEnable", "isNativeCrashed", "crashType", "crashAddress", "crashStack", "", "nativeSICODE", "", "crashTime", "processName", "", "reportCrash", "getAllCacheSize", "isDeleteFile", "clearAllCache", "clearMMKVCache", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getMiniBoxIPCModule", "isMiniBoxNoticeSwitchEnanle", "toggleName", "", "getToggleParams", "moduleName", "isMiniBoxHippyModule", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getHippyModuleProvider", "pid", "action", "Landroid/os/Bundle;", "params", "notifyClient", "Ljava/lang/Class;", "getJumpParserClass", "dexVersion", "isMatchVAPlugin", "clearDir", "updatePlugin", "defaultAvailable", "timeout", "", "crashStackRules", "Lbs3/b;", "checkListener", "checkMiniBoxAvailable", "checkIsAvailableCrash", "appId", "Lkotlin/Pair;", "isDexBlockApp", "Landroid/content/Context;", "context", "oldDexVersion", "checkAndClearDexCrashRecord", "isForceLaunchLocal", "isMountServiceHookFailed", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IMiniBoxService extends QRouteApi {
    void checkAndClearDexCrashRecord(@Nullable Context context, @NotNull String appId, @Nullable String oldDexVersion);

    void checkIsAvailableCrash(@Nullable String crashStack);

    void checkMiniBoxAvailable(boolean defaultAvailable, int timeout, @NotNull List<String> crashStackRules, @NotNull b checkListener);

    void clearAllCache(boolean isDeleteFile);

    void clearMMKVCache();

    @Nullable
    AppRuntime createAppInterface(@Nullable MobileQQ app, @Nullable String procName);

    long getAllCacheSize();

    @NotNull
    HippyAPIProvider getHippyModuleProvider();

    @NotNull
    Class<?> getJumpParserClass();

    @NotNull
    QIPCModule getMiniBoxIPCModule();

    @NotNull
    Map<String, String> getToggleParams(@NotNull String toggleName);

    @NotNull
    Pair<Boolean, String> isDexBlockApp(@NotNull String appId);

    boolean isForceLaunchLocal();

    boolean isMatchVAPlugin(@NotNull String dexVersion);

    boolean isMiniBoxFeatureSwitchEnable();

    boolean isMiniBoxHippyModule(@NotNull String moduleName);

    boolean isMiniBoxNoticeSwitchEnanle();

    boolean isMiniBoxSystemInstallSwitchEnable();

    boolean isMountServiceHookFailed();

    void notifyClient(int pid, @NotNull String action, @Nullable Bundle params);

    void reportCrash(boolean isNativeCrashed, @Nullable String crashType, @Nullable String crashAddress, @Nullable String crashStack, int nativeSICODE, long crashTime, @Nullable String processName);

    void updatePlugin(boolean clearDir);
}
