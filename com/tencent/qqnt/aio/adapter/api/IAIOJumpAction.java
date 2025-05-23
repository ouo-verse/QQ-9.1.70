package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOJumpAction;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "url", "Lgv3/a;", "aioAbility", "", "doUrlAction", "", "openBrowser", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "preLoadBrowser", "jumpAccountOnlineStateActivity", "isMiniAppUrl", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "openBrowserWithParam", "openBrowserDelegate", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOJumpAction extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static void a(@NotNull IAIOJumpAction iAIOJumpAction, @NotNull Context context, @NotNull String url, @NotNull Bundle extraData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
        }
    }

    boolean doUrlAction(@NotNull Context context, @NotNull String url);

    boolean doUrlAction(@NotNull Context context, @NotNull String url, @Nullable gv3.a aioAbility);

    boolean isMiniAppUrl(@NotNull String url);

    void jumpAccountOnlineStateActivity(@NotNull Context context);

    void openBrowser(@NotNull Context context, @NotNull String url);

    void openBrowserDelegate(@NotNull Context context, @NotNull String url, @NotNull Bundle extraData);

    void openBrowserWithParam(@NotNull Context context, @NotNull String url, @NotNull Bundle extraData);

    boolean openMiniApp(@NotNull Context context, @NotNull String url);

    void preLoadBrowser(@NotNull BaseQQAppInterface app);
}
