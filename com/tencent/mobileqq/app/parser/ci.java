package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ci extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ci(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) context);
        }
    }

    private void F() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e("QQOnlineStatusJumpAction", 2, "doAction action_name ", this.f307440e, " error, app runtime is null!");
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra("key_tab_name", Conversation.class.getName());
        intent.putExtra(Conversation.DIRECT_OPEN_ONLINE_STATUS_PANEL_PARAMS, this.f307441f);
        RouteUtils.startActivity(BaseApplication.getContext(), intent, RouterConstants.UI_ROUTER_SPLASH);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ("home".equals(this.f307440e)) {
            F();
            return true;
        }
        return true;
    }
}
