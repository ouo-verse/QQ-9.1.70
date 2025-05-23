package com.tencent.mobileqq.pushnotice.message;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class j extends a {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Intent f(Context context, String str, String str2) {
        Intent intent = new Intent(context, ((IAssociatedAccountApi) QRoute.api(IAssociatedAccountApi.class)).getAssociatedAccountActivity());
        intent.putExtra("uin", str);
        intent.putExtra("uintype", 7000);
        intent.putExtra("fromThirdPush", true);
        intent.putExtra("subAccount", str);
        intent.putExtra("subAccountLatestNick", str2);
        intent.putExtra("finishAIO", true);
        return intent;
    }

    private String g(AppRuntime appRuntime, String str) {
        String latestUinNick = ((ISubAccountService) appRuntime.getRuntimeService(ISubAccountService.class, "")).getLatestUinNick(str);
        if (!TextUtils.isEmpty(latestUinNick)) {
            return latestUinNick;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean a(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent)).booleanValue();
        }
        return "57621".equals(intent.getStringExtra("jumptype"));
    }

    @Override // com.tencent.mobileqq.pushnotice.message.h
    public boolean b(Context context, Intent intent, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, intent, appRuntime)).booleanValue();
        }
        String stringExtra = intent.getStringExtra("binduin");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e("SubAccountAssistantPushHandler", 1, "bindUin is null");
            return true;
        }
        context.startActivity(f(context, stringExtra, g(appRuntime, stringExtra)));
        c(intent, appRuntime);
        return true;
    }
}
