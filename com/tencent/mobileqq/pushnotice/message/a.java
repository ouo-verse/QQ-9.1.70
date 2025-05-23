package com.tencent.mobileqq.pushnotice.message;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a implements h {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Intent intent, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) appRuntime);
            return;
        }
        String stringExtra = intent.getStringExtra("jumptype");
        i.l(appRuntime, stringExtra);
        if ("57619".equals(stringExtra)) {
            com.tencent.qqnt.trace.j.f362346a.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Intent) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.putExtra("open_chatfragment", true);
        intent.putExtra("fromThirdPush", true);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        intent.putExtra(AppOpenConstants.Key.THIRD_PUSH_START_ACTIVITY_TIME, currentTimeMillis);
        i.n(context, intent);
        QLog.i("BaseMessagePushHandler", 1, "[openSplashActivity] time=" + currentTimeMillis + " intent=" + intent.getExtras());
    }
}
