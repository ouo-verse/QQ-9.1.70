package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkMultiExportAPI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneStateStoreApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QzoneMainRuntime extends ToolRuntimeBase {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private static MobileQQ appContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            TAG = "QzoneMainRuntime";
        }
    }

    public QzoneMainRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "qzone";
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean hasRunningTask = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).hasRunningTask();
        boolean hasPublishRunningTask = ((IQzoneStateStoreApi) QRoute.api(IQzoneStateStoreApi.class)).hasPublishRunningTask();
        QLog.e(TAG, 1, "highPriorityWhenBackground | hasWinkVideoTask:" + hasRunningTask + " | hasPublishRunningTask:" + hasPublishRunningTask);
        if (hasRunningTask || hasPublishRunningTask) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!QzoneConfig.getInstance().getConfig("QZoneSetting", "secondary_enable_kill_idle_qzone_process", true)) {
            return false;
        }
        boolean hasRunningTask = ((IWinkMultiExportAPI) QRoute.api(IWinkMultiExportAPI.class)).hasRunningTask();
        boolean hasPublishRunningTask = ((IQzoneStateStoreApi) QRoute.api(IQzoneStateStoreApi.class)).hasPublishRunningTask();
        int activityCount = Foreground.getActivityCount();
        QLog.e(TAG, 1, "highPriorityWhenBackground | hasWinkVideoTask:" + hasRunningTask + " | hasPublishRunningTask:" + hasPublishRunningTask + " | hasActivityCount:" + activityCount);
        if (!hasRunningTask && !hasPublishRunningTask && activityCount <= 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pluginsdk.PluginRuntime, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        QLog.i(TAG, 1, "QzoneMainRuntime onCreate");
        super.onCreate(bundle);
        appContext = getApplication();
        getAppRuntime("qzone_plugin.apk");
        getAppRuntime("qq_live_qzone");
    }

    @Override // mqq.app.AppRuntime
    protected AppRuntime onGetSubRuntime(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "QzoneMainRuntime.onGetSubRuntime() moduleId " + str);
        }
        if (str.equals("qzone_plugin.apk")) {
            return QZoneHelper.createQZoneAppInterface(BaseApplicationImpl.getApplication(), MobileQQ.processName);
        }
        return null;
    }
}
