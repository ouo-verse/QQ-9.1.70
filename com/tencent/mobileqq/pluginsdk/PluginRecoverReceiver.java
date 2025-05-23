package com.tencent.mobileqq.pluginsdk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PluginRecoverReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_ = null;
    private static final String INTENT_ACTION_EXCEPTION_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED";
    private static final String INTENT_KEY_PLUGIN_ID = "pluginId";
    private static final int PRIORITY_PROCESS_PLUGIN = 100;
    private static final int PRIORITY_PROCESS_QQ = 50;
    private static final String TAG = "PluginRecoverReceiver";
    private static final Set<String> sCarePluginIds;
    boolean isMobileQQProcess;
    String processName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14599);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sCarePluginIds = new HashSet();
        }
    }

    public PluginRecoverReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void addCarePluginId(String str) {
        Set<String> set = sCarePluginIds;
        if (!set.contains(str)) {
            set.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void broadcast(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(INTENT_ACTION_EXCEPTION_STARTUP_FAILED);
        intent.putExtra(INTENT_KEY_PLUGIN_ID, str);
        intent.setPackage(context.getPackageName());
        context.sendOrderedBroadcast(intent, null);
    }

    public static PluginRecoverReceiver register(Application application, PluginRecoverReceiver pluginRecoverReceiver) {
        String str = MobileQQ.processName;
        IntentFilter intentFilter = new IntentFilter(INTENT_ACTION_EXCEPTION_STARTUP_FAILED);
        boolean equals = TextUtils.equals(application.getPackageName(), str);
        if (equals) {
            intentFilter.setPriority(50);
        } else {
            intentFilter.setPriority(100);
        }
        pluginRecoverReceiver.isMobileQQProcess = equals;
        pluginRecoverReceiver.processName = str;
        try {
            application.registerReceiver(pluginRecoverReceiver, intentFilter);
            return pluginRecoverReceiver;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (INTENT_ACTION_EXCEPTION_STARTUP_FAILED.equals(intent.getAction()) && TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            String stringExtra = intent.getStringExtra(INTENT_KEY_PLUGIN_ID);
            QLog.d(TAG, 1, "onReceive =  pluginID = " + stringExtra + ", isQQMobileProcess = " + this.isMobileQQProcess + ", processName = " + this.processName);
            if (this.isMobileQQProcess) {
                if (!sCarePluginIds.contains(stringExtra)) {
                    onRecver(stringExtra);
                }
            } else if (sCarePluginIds.contains(stringExtra)) {
                PluginRuntime runtime = PluginRuntime.getRuntime();
                if (runtime != null && runtime.getRunningModuleSize() > 1) {
                    onRecver(stringExtra);
                    return;
                }
                QLog.d(TAG, 1, "kill Process =  pluginID = " + stringExtra + ", ");
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }
    }

    protected void onRecver(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }
}
