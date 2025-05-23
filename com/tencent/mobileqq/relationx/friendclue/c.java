package com.tencent.mobileqq.relationx.friendclue;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a() {
        boolean z16;
        b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("friend_clue_config");
        if (bVar != null) {
            z16 = bVar.f280733d;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendClueConfigHelper", 2, String.format("isIsNeedShow isNeedShow=%s", Boolean.valueOf(z16)));
        }
        return z16;
    }

    public void b(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) str);
            return;
        }
        String format = String.format("%s?uin=%s", "https://ti.qq.com/friends/recall", str);
        if (QLog.isDevelopLevel()) {
            QLog.d("FriendClueConfigHelper", 1, String.format("openQQBrowser url=%s", format));
        }
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", format);
            intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT, true);
            intent.putExtra(QQBrowserActivity.IS_WRAP_CONTENT, true);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
            if (w.a(1000L)) {
                activity.startActivity(intent);
            }
        }
    }
}
