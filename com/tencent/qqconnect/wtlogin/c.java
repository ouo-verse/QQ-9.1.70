package com.tencent.qqconnect.wtlogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginregister.v;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.open.agent.util.g;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("LoginHelper", 1, "clearProgressDialog appRuntime is not AppInterface");
            return;
        }
        MqqHandler handler = ((AppInterface) appRuntime).getHandler(v.class);
        if (handler != null) {
            handler.sendEmptyMessage(2001);
        }
    }

    @Deprecated
    public static void b(Context context) {
        d(context, 0);
    }

    public static void c(Activity activity, QQAppInterface qQAppInterface) {
        ThemeUiPlugin.destroy(qQAppInterface);
        ChatBackgroundManager.d();
        b(qQAppInterface.getApp());
        qQAppInterface.logout(true);
        ImageCacheHelper.f98636a.e();
        if (QQPlayerService.s0() && activity != null) {
            Intent intent = new Intent();
            intent.setAction("qqplayer_exit_action");
            activity.sendBroadcast(intent);
        }
        if (qQAppInterface.getCurrentAccountUin() != null) {
            AutoLoginUtil.setAutoLogin(qQAppInterface.getCurrentAccountUin(), false);
        }
    }

    @Deprecated
    public static void d(Context context, int i3) {
        if (context != null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("clear_unread_count_after_log_out", false)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("unreadcount", 4).edit();
            edit.putInt("unread", i3);
            edit.commit();
        }
    }

    public static void e(String str, String str2, String str3, EIPCResultCallback eIPCResultCallback) {
        if (eIPCResultCallback == null) {
            QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk callback is null");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk");
            Bundle bundle = new Bundle();
            bundle.putString("uin", str);
            bundle.putString("passwd", str2);
            bundle.putString("appid", str3);
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:openSdk", "ae_camera_get_info_client", "action_to_wt_login", bundle, eIPCResultCallback);
            return;
        }
        QLog.d("LoginHelper", 1, "toWtLoginOnOpenSdk appId=", str3, ", uin=", g.C(str));
        Bundle bundle2 = new Bundle();
        bundle2.putString("uin", str);
        bundle2.putInt("key_sso_ret", 1007);
        eIPCResultCallback.onCallback(EIPCResult.createResult(-102, bundle2));
    }
}
