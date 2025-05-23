package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ar extends f {
    static IPatchRedirector $redirector_;

    public ar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Intent intent, Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        UpgradeDetailActivity.Y2(activity, (UpgradeDetailWrapper) intent.getParcelableExtra(UpgradeDetailWrapper.class.getSimpleName()), true, false, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void d(final Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        final Intent intent = activity.getIntent();
        com.tencent.mobileqq.upgrade.m.O(activity, intent.getStringExtra("StrNewTitle"), intent.getStringExtra("StrVersion"), intent.getStringExtra("StrUpgradeDesc"), HardCodeUtil.qqStr(R.string.rya), null, new View.OnClickListener() { // from class: com.tencent.mobileqq.loginregister.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ar.c(intent, activity, view);
            }
        }, null).show();
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public void j(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        if (bundle == null) {
            QLog.e("UpdateLoginAction", 1, "onLoginActivityCreate bundle is null");
        } else if (bundle.getBoolean("reason_for_upgrade", false)) {
            try {
                d(activity);
            } catch (Throwable th5) {
                QLog.e("UpdateLoginAction", 1, "onLoginActivityCreate fail", th5);
            }
        }
    }
}
