package com.tencent.ecommerce.base.miniapp.api;

import android.content.Context;
import com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/miniapp/api/a;", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$MiniAppType;", "type", "", "preloadMiniApp", "Landroid/content/Context;", "context", "", "appId", "path", "version", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$LaunchListener;", "listener", "launchQQMinAppByAppId", QZoneDTLoginReporter.SCHEMA, "miniAppListener", "launchQQMiniAppByUrl", "", "canOpenQQMiniApp", "userName", "launchWxMiniApp", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECMiniAppLauncher {
    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public boolean canOpenQQMiniApp() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void preloadMiniApp(@NotNull IECMiniAppLauncher.MiniAppType type) {
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void launchQQMiniAppByUrl(@NotNull Context context, @NotNull String schema, @NotNull IECMiniAppLauncher.LaunchListener miniAppListener) {
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void launchQQMinAppByAppId(@NotNull Context context, @NotNull String appId, @NotNull String path, @NotNull String version, @NotNull IECMiniAppLauncher.LaunchListener listener) {
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void launchWxMiniApp(@NotNull Context context, @NotNull String appId, @NotNull String userName, @NotNull String path, @NotNull IECMiniAppLauncher.LaunchListener listener) {
    }
}
