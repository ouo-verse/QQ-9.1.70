package com.tencent.qq.minibox.api.metadream;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u00a6\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0091\u0001\u0010\u0006\u001a\u008c\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J7\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052%\u0010\u0019\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&JG\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH&J \u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001eH&\u00a8\u0006'"}, d2 = {"Lcom/tencent/qq/minibox/api/metadream/IMiniBoxUseMiniGameAbilityApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addDownloadListener", "", VirtualAppProxy.KEY_GAME_ID, "", "listener", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "progress", "", "downloadSize", VirtualAppProxy.KEY_PKG_SIZE, "msg", "getMiniBoxVADownloadTipsDelegate", "Lcom/tencent/qq/minibox/api/metadream/IMiniBoxVADownloadTipsDelegate;", "hostContext", "Landroid/content/Context;", "gameActivity", "Landroid/app/Activity;", "queryCanUpdateVA", "appId", "callback", "Lkotlin/Function1;", "removeDownloadListener", "restartVirtualApp", "versionCode", "", "success", "startDownload", "needInstall", NotificationCompat.GROUP_KEY_SILENT, "stopUpdate", "updateWifiAutoUpdateFlag", PushClientConstants.TAG_PKG_NAME, "allowWifiAutoUpdate", "minibox-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IMiniBoxUseMiniGameAbilityApi extends QRouteApi {
    void addDownloadListener(@Nullable String gameId, @Nullable Function6<? super String, ? super Integer, ? super Integer, ? super Long, ? super Long, ? super String, Unit> listener);

    @Nullable
    IMiniBoxVADownloadTipsDelegate getMiniBoxVADownloadTipsDelegate(@NotNull Context hostContext, @NotNull Activity gameActivity);

    void queryCanUpdateVA(@NotNull String appId, @Nullable Function1<? super String, Unit> callback);

    void removeDownloadListener(@Nullable String gameId);

    void restartVirtualApp(@NotNull String appId, @NotNull String gameId, @Nullable String versionCode, @Nullable Function1<? super Boolean, Unit> listener);

    void startDownload(@NotNull String gameId, boolean needInstall, boolean silent);

    void stopUpdate(@NotNull String gameId);

    void updateWifiAutoUpdateFlag(@NotNull String pkgName, boolean allowWifiAutoUpdate);
}
