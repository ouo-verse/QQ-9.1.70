package com.tencent.mobileqq.msf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import mqq.app.NewIntent;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFAccountChangeRegisterTask extends NtTask {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_ACCOUNT = "account";
    public static final String MSF_DEFAULT_UIN = "10000";
    private static final String TAG = "MSFAccountReceiver";
    private static final BroadcastReceiver receiver;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    if (intent == null) {
                        QLog.e(MSFAccountChangeRegisterTask.TAG, 1, "onReceive null action broadcast");
                        return;
                    }
                    QLog.i(MSFAccountChangeRegisterTask.TAG, 1, "onReceive action = " + intent.getAction());
                    String action = intent.getAction();
                    action.hashCode();
                    if (action.equals(NewIntent.ACTION_LOGOUT)) {
                        MSFAccountChangeRegisterTask.notifyAccountChange(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
                    } else if (action.equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                        MSFAccountChangeRegisterTask.notifyAccountChange(intent.getStringExtra("account"));
                    }
                }
            };
        }
    }

    public MSFAccountChangeRegisterTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ArrayList<String> getActions() {
        return new ArrayList<>(Arrays.asList(NewIntent.ACTION_ACCOUNT_CHANGED, NewIntent.ACTION_LOGOUT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyAccountChange(String str) {
        QLog.d(TAG, 1, "notifyAccountChange, account: " + LogUtil.getSafePrintUin(str));
        CrashReport.setUserId(BaseApplication.getContext(), str);
        QQBeaconReport.setUserId(str);
    }

    void registerAccountReceiver(@NonNull Context context) {
        IntentFilter intentFilter = new IntentFilter();
        Iterator<String> it = getActions().iterator();
        while (it.hasNext()) {
            intentFilter.addAction(it.next());
        }
        context.registerReceiver(receiver, intentFilter);
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            registerAccountReceiver(context);
        }
    }
}
