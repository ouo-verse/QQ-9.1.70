package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i extends g {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public void e(Activity activity, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) appRuntime);
            return;
        }
        if (appRuntime instanceof QQAppInterface) {
            ThemeUiPlugin.destroy((QQAppInterface) appRuntime);
        }
        ChatBackgroundManager.d();
        ImageCacheHelper.f98636a.e();
        if (QQPlayerService.s0()) {
            Intent intent = new Intent();
            intent.setAction("qqplayer_exit_action");
            activity.sendBroadcast(intent);
        }
    }
}
