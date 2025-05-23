package com.tencent.replacemonitor.replace.c;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistantbase.util.j;
import com.tencent.tmassistantbase.util.r;
import java.io.File;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements f {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.replacemonitor.replace.c.f
    public MonitorResult a(MonitorTask monitorTask, MonitorStep monitorStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonitorResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) monitorTask, (Object) monitorStep);
        }
        r.b(ReplaceMonitor.WASH_TAG, "AppNameMonitorAction>>" + monitorTask.appName + "\u5f00\u59cb\u901a\u8fc7AppName\u6bd4\u8f83\u68c0\u6d4b\u6d17\u5305 step = " + monitorStep);
        if (monitorTask.appType != 2) {
            return new MonitorResult(monitorStep, 0, monitorStep + "\u975e\u8054\u8fd0\u6e38\u620f\u4e0d\u9700\u8981\u505a\u5e94\u7528\u540d\u68c0\u6d4b", a());
        }
        if ((monitorStep == MonitorStep.AFTER_INSTALL || monitorStep == MonitorStep.INSTALLING) && !j.a(monitorTask.packageName, monitorTask.versionCode)) {
            List<PackageInfo> c16 = j.c(monitorTask.appName);
            if (!com.tencent.tmassistantbase.util.b.a(c16)) {
                MonitorResult monitorResult = new MonitorResult(monitorStep, 1, monitorStep + "\u901a\u8fc7\u5e94\u7528\u540d\u79f0\u6bd4\u5bf9\u53d1\u73b0\u6d17\u5305", a());
                PackageInfo packageInfo = c16.get(0);
                monitorResult.replacedPkgName = packageInfo.packageName;
                monitorResult.replacedVersionCode = (long) packageInfo.versionCode;
                monitorResult.replaceTime = packageInfo.lastUpdateTime;
                String str = packageInfo.applicationInfo.sourceDir;
                monitorTask.installDir = str;
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(monitorTask.installDir);
                    if (file.exists()) {
                        monitorResult.replacedFileSize = file.length();
                    }
                }
                return monitorResult;
            }
        }
        return new MonitorResult(monitorStep, 0, monitorStep + "\u901a\u8fc7\u5e94\u7528\u540d\u79f0\u68c0\u6d4b\u901a\u8fc7", a());
    }

    public MonitorType a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? MonitorType.BY_APP_NAME : (MonitorType) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
