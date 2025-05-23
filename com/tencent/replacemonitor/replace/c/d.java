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
public class d implements f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f364895a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18284);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MonitorStep.values().length];
            f364895a = iArr;
            try {
                iArr[MonitorStep.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f364895a[MonitorStep.BEFORE_INSTALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f364895a[MonitorStep.INSTALLING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f364895a[MonitorStep.AFTER_INSTALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(MonitorTask monitorTask, String str, MonitorResult monitorResult, MonitorStep monitorStep) {
        r.b(ReplaceMonitor.WASH_TAG, "MD5MonitorAction>>checkMd5 " + monitorTask.appName + " task.fileMD5 = " + monitorTask.fileMd5 + " filePath = " + str);
        if (monitorTask.fileMd5 != null && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                String a16 = com.tencent.tmassistantbase.util.g.a(str);
                r.b(ReplaceMonitor.WASH_TAG, "MD5MonitorAction>>checkMd5 " + monitorTask.appName + " task.fileMD5 = " + monitorTask.fileMd5 + " file.md5() = " + a16);
                if (monitorTask.fileMd5.equals(a16)) {
                    monitorResult.resultCode = 0;
                    monitorResult.resultMsg = monitorStep + " MD5\u68c0\u6d4b\u901a\u8fc7";
                    return;
                }
                monitorResult.resultCode = 1;
                monitorResult.resultMsg = monitorStep + " \u901a\u8fc7MD5\u68c0\u6d4b\u53d1\u73b0\u6d17\u5305";
                monitorResult.replaceTime = file.lastModified();
                monitorResult.replacedFileSize = file.length();
                monitorResult.replaceFileMD5 = a16;
                if (monitorTask.appType == 3) {
                    try {
                        monitorResult.replaceChannelId = com.tencent.dlsdk.yybutil.apkchannel.a.a(str);
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                }
                PackageInfo a17 = j.a(monitorTask.filePath);
                if ((monitorStep == MonitorStep.INSTALLING || monitorStep == MonitorStep.AFTER_INSTALL) && (a17 = j.b(monitorTask.packageName)) != null) {
                    monitorResult.replaceTime = a17.lastUpdateTime;
                }
                if (a17 != null) {
                    monitorResult.replacedPkgName = a17.packageName;
                    monitorResult.replacedVersionCode = a17.versionCode;
                    return;
                }
                return;
            }
            monitorResult.resultMsg = monitorStep + " \u6267\u884cMD5\u68c0\u6d4b\u65f6\u53d1\u73b0\u6587\u4ef6\u4e0d\u5b58\u5728";
            return;
        }
        monitorResult.resultMsg = monitorStep + " \u6267\u884cMD5\u68c0\u67e5\u65f6fileMD5\u4e3a\u7a7a\u6216\u8005filePath\u4e3a\u7a7a";
    }

    @Override // com.tencent.replacemonitor.replace.c.f
    public MonitorResult a(MonitorTask monitorTask, MonitorStep monitorStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MonitorResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) monitorTask, (Object) monitorStep);
        }
        r.b(ReplaceMonitor.WASH_TAG, "MD5MonitorAction>>" + monitorTask.appName + "\u5f00\u59cb\u901a\u8fc7MD5\u6bd4\u8f83\u68c0\u6d4b\u6d17\u5305 step =" + monitorStep);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(monitorStep);
        sb5.append(" MD5\u68c0\u6d4b\u901a\u8fc7");
        MonitorResult monitorResult = new MonitorResult(monitorStep, 0, sb5.toString(), b());
        if (!TextUtils.isEmpty(monitorTask.fileMd5) && !TextUtils.isEmpty(monitorTask.filePath)) {
            int i3 = a.f364895a[monitorStep.ordinal()];
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3 || i3 == 4) {
                    c(monitorTask, monitorTask.installDir, monitorResult, monitorStep);
                }
            } else {
                c(monitorTask, monitorTask.filePath, monitorResult, monitorStep);
            }
        } else {
            monitorResult.resultMsg = monitorStep + " MD5\u68c0\u6d4b\u901a\u8fc7\uff0c\u56e0\u4e3atask.fileMd5 \u6216\u8005 task.filePath\u4e3a\u7a7a\uff0c task.fileMd5 = " + monitorTask.fileMd5 + " task.filePath = " + monitorTask.filePath;
        }
        return monitorResult;
    }

    public MonitorType b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MonitorType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return MonitorType.BY_FILE_MD5;
    }
}
