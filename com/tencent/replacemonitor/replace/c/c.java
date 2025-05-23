package com.tencent.replacemonitor.replace.c;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
public class c implements f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f364894a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10368);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MonitorStep.values().length];
            f364894a = iArr;
            try {
                iArr[MonitorStep.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f364894a[MonitorStep.BEFORE_INSTALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f364894a[MonitorStep.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f364894a[MonitorStep.AFTER_INSTALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public c() {
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
        r.b(ReplaceMonitor.WASH_TAG, "FileSizeMonitorAction>>" + monitorTask.appName + "\u5f00\u59cb\u901a\u8fc7FileSize\u6bd4\u8f83\u68c0\u6d4b\u6d17\u5305 step = " + monitorStep);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(monitorStep);
        sb5.append("\u901a\u8fc7filesize\u68c0\u6d4b\u901a\u8fc7");
        MonitorResult monitorResult = new MonitorResult(monitorStep, 0, sb5.toString(), a());
        if (TextUtils.isEmpty(monitorTask.filePath)) {
            monitorResult.resultMsg = monitorStep + " \u901a\u8fc7filesize\u68c0\u6d4b\u901a\u8fc7\uff0c\u56e0\u4e3atask.filePath\u4e3a\u7a7a\uff0c task.filePath = " + monitorTask.filePath;
        }
        int i3 = a.f364894a[monitorStep.ordinal()];
        if (i3 == 1 || i3 == 2) {
            a(monitorTask, monitorStep, monitorResult, monitorTask.filePath);
        } else if (i3 == 3 || i3 == 4) {
            a(monitorTask, monitorStep, monitorResult, monitorTask.installDir);
        }
        return monitorResult;
    }

    private void a(MonitorTask monitorTask, MonitorStep monitorStep, MonitorResult monitorResult, String str) {
        r.b(ReplaceMonitor.WASH_TAG, "FileSizeMonitorAction>>commonFileSizeCheck " + monitorTask.appName + " task.fileSize = " + monitorTask.fileSize + " filePath = " + str);
        if (!TextUtils.isEmpty(str) && monitorTask.fileSize > 0) {
            File file = new File(str);
            if (file.exists()) {
                r.b(ReplaceMonitor.WASH_TAG, "FileSizeMonitorAction>>commonFileSizeCheck " + monitorTask.appName + " task.fileSize = " + monitorTask.fileSize + " file.length() = " + file.length());
                if (file.length() != monitorTask.fileSize) {
                    monitorResult.resultCode = 1;
                    monitorResult.resultMsg = monitorStep + "\u901a\u8fc7filesize\u68c0\u6d4b\u5230\u6d17\u5305";
                    monitorResult.replaceTime = file.lastModified();
                    monitorResult.replacedFileSize = file.length();
                    if (monitorTask.appType == 3) {
                        try {
                            monitorResult.replaceChannelId = com.tencent.dlsdk.yybutil.apkchannel.a.a(str);
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    PackageInfo b16 = j.b(monitorTask.packageName);
                    if (monitorStep == MonitorStep.DOWNLOADING || monitorStep == MonitorStep.BEFORE_INSTALL) {
                        b16 = j.a(str);
                    }
                    if (b16 != null) {
                        monitorResult.replacedPkgName = b16.packageName;
                        monitorResult.replacedVersionCode = b16.versionCode;
                        if (monitorStep == MonitorStep.INSTALLING || monitorStep == MonitorStep.AFTER_INSTALL) {
                            monitorResult.replaceTime = b16.lastUpdateTime;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            monitorResult.resultMsg = monitorStep + " FileSize\u68c0\u6d4b\u672a\u627e\u5230\u6587\u4ef6";
            return;
        }
        monitorResult.resultMsg = monitorStep + " filePath is " + str + " fileSize is " + monitorTask.fileSize;
    }

    public MonitorType a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? MonitorType.BY_FILE_SIZE : (MonitorType) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
