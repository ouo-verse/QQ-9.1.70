package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.MD5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class IPluginProxyComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String ACTION_QQPROCESS_EXIT = "com.tencent.process.exit";
    private static BroadcastReceiver sAccountReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class AccountReceiver extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        AccountReceiver() {
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
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginRuntime.AccountReceiver.onReceive: " + action);
                }
                if (context.getPackageName().equals(MobileQQ.processName)) {
                    return;
                }
                if (NewIntent.ACTION_ACCOUNT_CHANGED.equals(action)) {
                    intent.getStringExtra("account");
                    return;
                }
                if (!NewIntent.ACTION_LOGOUT.equals(action)) {
                    if (!("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName()).equals(action)) {
                        return;
                    }
                }
                IPluginProxyComponent.exitProcess(intent.getStringExtra("K_EXCEP"));
            }
        }
    }

    IPluginProxyComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static void exitProcess(String str) {
        if (DebugHelper.sDebug) {
            DebugHelper.log("PluginRuntime.exitProcess");
        }
        try {
            Iterator<WeakReference<IPluginActivity>> it = PluginStatic.getActivitys().iterator();
            while (it.hasNext()) {
                IPluginActivity iPluginActivity = it.next().get();
                if (iPluginActivity != null) {
                    iPluginActivity.IFinish();
                }
            }
        } catch (Exception unused) {
        }
        String str2 = MobileQQ.processName;
        if (!TextUtils.isEmpty(str2)) {
            Intent intent = new Intent("com.tencent.process.exit");
            intent.putExtra("K_EXCEP", str);
            intent.putExtra("exit_type", 0);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str2);
            intent.putStringArrayListExtra("procNameList", arrayList);
            intent.putExtra("verify", getLocalVerify(arrayList, false));
            MobileQQ.getMobileQQ().sendBroadcast(intent);
        }
    }

    private static String getLocalVerify(ArrayList<String> arrayList, boolean z16) {
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            sb5.append(time.minute - 1);
        } else {
            sb5.append(time.minute);
        }
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerAccountReceiverIfNeccessary() {
        if (sAccountReceiver == null) {
            sAccountReceiver = new AccountReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            intentFilter.addAction(NewIntent.ACTION_LOGOUT);
            intentFilter.addAction("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName());
            try {
                MobileQQ.getMobileQQ().registerReceiver(sAccountReceiver, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    static void unregisterAccountReceiverIfNeccessary() {
        if (sAccountReceiver != null) {
            MobileQQ.getMobileQQ().unregisterReceiver(sAccountReceiver);
            sAccountReceiver = null;
        }
    }
}
