package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOJumpActionImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOJumpAction;", "Landroid/content/Context;", "context", "", "url", "Lgv3/a;", "aioAbility", "", "tryParserUrlWithAIOAbility", "doUrlAction", "", "openBrowser", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "openBrowserWithParam", "isMiniAppUrl", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "preLoadBrowser", "jumpAccountOnlineStateActivity", "openBrowserDelegate", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOJumpActionImpl implements IAIOJumpAction {
    private static final int REQUEST_CODE_ONLINE_STATUS = 0;
    public static final String TAG = "AIOJumpActionImpl";
    private static final String VAS_TRAN_BG_URL_KEY = "https://h5.vip.qq.com/p/pay";

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean doUrlAction(Context context, String url, gv3.a aioAbility) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        BaseQQAppInterface baseQQAppInterface = waitAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) waitAppRuntime : null;
        if (!(url.length() == 0) && baseQQAppInterface != null) {
            if (tryParserUrlWithAIOAbility(context, url, aioAbility)) {
                return true;
            }
            com.tencent.mobileqq.utils.ax c16 = bi.c(baseQQAppInterface, context, url);
            if (c16 != null) {
                return c16.b();
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean isMiniAppUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(url);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void jumpAccountOnlineStateActivity(Context context) {
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d(TAG, 1, "[jumpAccountOnlineStateActivity]");
        if ((context instanceof Activity) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            Intent intent = new Intent();
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026ava, ProcessConstant.ALL)");
            if (com.tencent.mobileqq.chat.autoreply.a.a(((IOnlineStatusService) runtimeService).getOnlineStatus())) {
                intent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.away);
            }
            intent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
            intent.putExtra("KEY_ENTRANCE", 1);
            ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).startAccountOnlineStateActivity((Activity) context, intent, 0);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void openBrowser(Context context, String url) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url) || ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).shouldInterceptForRobotProfile(context, url)) {
            return;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, VAS_TRAN_BG_URL_KEY, false, 2, null);
        if (startsWith$default) {
            Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", url);
            intent.setData(Uri.parse(url));
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("url", url);
        RouteUtils.startActivity(context, intent2, RouterConstants.UI_ROUTE_BROWSER);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void openBrowserDelegate(Context context, String url, Bundle extraData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
        intent.putExtra("url", url);
        intent.putExtras(extraData);
        if (context instanceof Application) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void openBrowserWithParam(Context context, String url, Bundle extraData) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        if (TextUtils.isEmpty(url) || ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).shouldInterceptForRobotProfile(context, url)) {
            return;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, VAS_TRAN_BG_URL_KEY, false, 2, null);
        if (startsWith$default) {
            Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("url", url);
            intent.setData(Uri.parse(url));
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            intent.putExtras(extraData);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("url", url);
        intent2.putExtras(extraData);
        RouteUtils.startActivity(context, intent2, RouterConstants.UI_ROUTE_BROWSER);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean openMiniApp(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, url, 2016, null);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public void preLoadBrowser(BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
    }

    private final boolean tryParserUrlWithAIOAbility(Context context, String url, gv3.a aioAbility) {
        return aioAbility != null && com.tencent.mobileqq.troop.essencemsg.graytip.a.INSTANCE.a(url, aioAbility);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOJumpAction
    public boolean doUrlAction(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        return doUrlAction(context, url, null);
    }
}
