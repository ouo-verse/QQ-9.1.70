package com.tencent.mobileqq.microapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class b extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniAppInterface f246025a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MiniAppInterface miniAppInterface) {
        this.f246025a = miniAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) miniAppInterface);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BaseApplicationImpl baseApplicationImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            if (QLog.isColorLevel()) {
                QLog.w("MiniAppInterface", 2, "accountReceiver.onReceive broacast action=" + action);
            }
            if (!"com.tencent.process.exit".equals(action) && !NewIntent.ACTION_ACCOUNT_CHANGED.equals(action) && !NewIntent.ACTION_ACCOUNT_KICKED.equals(action) && !NewIntent.ACTION_ACCOUNT_EXPIRED.equals(action) && !NewIntent.ACTION_LOGOUT.equals(action)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("mqq.intent.action.EXIT_");
                baseApplicationImpl = this.f246025a.app;
                sb5.append(baseApplicationImpl.getPackageName());
                if (!sb5.toString().equals(action)) {
                    return;
                }
            }
            this.f246025a.exitProcess();
        }
    }
}
