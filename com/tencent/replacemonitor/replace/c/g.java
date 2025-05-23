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
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g implements f {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.replacemonitor.replace.c.f
    public MonitorResult a(MonitorTask monitorTask, MonitorStep monitorStep) {
        PackageInfo b16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonitorResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) monitorTask, (Object) monitorStep);
        }
        r.b(ReplaceMonitor.WASH_TAG, "VersionCodeMonitorAction>>" + monitorTask.appName + "\u5f00\u59cb\u901a\u8fc7VersionCode\u6bd4\u8f83\u68c0\u6d4b\u6d17\u5305 step = " + monitorStep);
        if ((monitorStep == MonitorStep.INSTALLING || monitorStep == MonitorStep.AFTER_INSTALL) && (b16 = j.b(monitorTask.packageName)) != null && (i3 = monitorTask.versionCode) > 0 && i3 > b16.versionCode) {
            MonitorResult monitorResult = new MonitorResult(monitorStep, 1, "\u901a\u8fc7\u7248\u672c\u53f7\u5bf9\u6bd4\u53d1\u73b0\u5b89\u88c5\u4e86\u7248\u672c\u53f7\u66f4\u4f4e\u7684\u5305\uff0c\u786e\u8ba4\u6d17\u5305", b());
            monitorResult.replaceTime = b16.lastUpdateTime;
            monitorResult.replacedPkgName = b16.packageName;
            monitorResult.replacedVersionCode = b16.versionCode;
            if (!TextUtils.isEmpty(b16.applicationInfo.sourceDir)) {
                File file = new File(b16.applicationInfo.sourceDir);
                if (file.exists()) {
                    monitorResult.replacedFileSize = file.length();
                }
            }
            if (monitorTask.appType == 3) {
                try {
                    monitorResult.replaceChannelId = com.tencent.dlsdk.yybutil.apkchannel.a.a(b16.applicationInfo.sourceDir);
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            return monitorResult;
        }
        return new MonitorResult(monitorStep, 0, "\u7248\u672c\u53f7\u6d17\u5305\u68c0\u6d4b\u901a\u8fc7", b());
    }

    public MonitorType b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MonitorType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MonitorType.BY_VERSION_CODE;
    }
}
