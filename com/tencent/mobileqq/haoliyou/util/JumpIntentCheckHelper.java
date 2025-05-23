package com.tencent.mobileqq.haoliyou.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JumpIntentCheckHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String CONFIG_ENTRY_FILTER_INTENT_SWITCH = "jump_intent_filter_launched_from_history_switch";
    private static final String TAG = "JumpIntentCheckHelper";

    public JumpIntentCheckHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean filterLaunchedFromHistory(Context context) {
        Intent intent;
        boolean z16;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_ENTRY_FILTER_INTENT_SWITCH, true);
        QLog.i(TAG, 1, "needFilterInvalidIntent switch: " + isSwitchOn);
        if (!isSwitchOn || !(context instanceof Activity) || (intent = ((Activity) context).getIntent()) == null) {
            return false;
        }
        if ((intent.getFlags() & 1048576) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "needFilterInvalidIntent fromHistory: " + z16);
        if (z16) {
            try {
                QLog.i(TAG, 1, "filterLaunchedFromHistory fromHistory");
                context.startActivity(InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), MobileQQ.PACKAGE_NAME));
                return true;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "filterLaunchedFromHistory exception", e16);
            }
        }
        return false;
    }
}
