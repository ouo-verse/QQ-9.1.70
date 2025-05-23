package com.tencent.ecommerce.base.miniapp.api;

import android.content.Context;
import android.os.Bundle;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0016\u0017J\b\u0010\u0002\u001a\u00020\u0003H&J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH&J2\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "", "canOpenQQMiniApp", "", "launchQQMinAppByAppId", "", "context", "Landroid/content/Context;", "appId", "", "path", "version", "listener", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$LaunchListener;", "launchQQMiniAppByUrl", QZoneDTLoginReporter.SCHEMA, "miniAppListener", "launchWxMiniApp", "userName", "preloadMiniApp", "type", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$MiniAppType;", "LaunchListener", "MiniAppType", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECMiniAppLauncher {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$LaunchListener;", "", "onLaunchResult", "", "isSuccess", "", "bundle", "Landroid/os/Bundle;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface LaunchListener {
        void onLaunchResult(boolean isSuccess, @Nullable Bundle bundle);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$MiniAppType;", "", "(Ljava/lang/String;I)V", "QQ", "WX", "ALL", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public enum MiniAppType {
        QQ,
        WX,
        ALL
    }

    boolean canOpenQQMiniApp();

    void launchQQMinAppByAppId(@NotNull Context context, @NotNull String appId, @NotNull String path, @NotNull String version, @NotNull LaunchListener listener);

    void launchQQMiniAppByUrl(@NotNull Context context, @NotNull String schema, @NotNull LaunchListener miniAppListener);

    void launchWxMiniApp(@NotNull Context context, @NotNull String appId, @NotNull String userName, @NotNull String path, @NotNull LaunchListener listener);

    void preloadMiniApp(@NotNull MiniAppType type);
}
