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
public class b implements f {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f364893a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19465);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MonitorStep.values().length];
            f364893a = iArr;
            try {
                iArr[MonitorStep.BEFORE_INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f364893a[MonitorStep.INSTALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f364893a[MonitorStep.AFTER_INSTALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b() {
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
        r.b(ReplaceMonitor.WASH_TAG, "ChannedlIdMonitorAction>>" + monitorTask.appName + "\u5f00\u59cb\u901a\u8fc7\u6e20\u9053\u53f7\u6bd4\u8f83\u68c0\u6d4b\u6d17\u5305 step = " + monitorStep);
        if (TextUtils.isEmpty(monitorTask.cpChannelId)) {
            return new MonitorResult(monitorStep, 0, "\u6e20\u9053\u53f7\u68c0\u6d4b\u6682\u65f6\u4e0d\u505a, task.cpChannelId is empty", a());
        }
        if (monitorTask.appType == 3) {
            int i3 = a.f364893a[monitorStep.ordinal()];
            if (i3 == 1) {
                return a(monitorTask, monitorTask.filePath, monitorTask.cpChannelId, monitorStep);
            }
            if (i3 == 2 || i3 == 3) {
                return a(monitorTask, monitorTask.installDir, monitorTask.cpChannelId, monitorStep);
            }
        }
        return new MonitorResult(monitorStep, 0, "\u6e20\u9053\u53f7\u68c0\u6d4b\u6682\u65f6\u4e0d\u505a", a());
    }

    public MonitorType a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? MonitorType.BY_CHANNEL_ID : (MonitorType) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    private MonitorResult a(MonitorTask monitorTask, String str, String str2, MonitorStep monitorStep) {
        r.b(ReplaceMonitor.WASH_TAG, "ChannedlIdMonitorAction>>checkByChannelId " + monitorTask.appName + " task.cpChannelId = " + str2 + " fileChannelId = " + str2 + " filePath =" + str);
        if (TextUtils.isEmpty(str)) {
            return new MonitorResult(monitorStep, 3, "\u901a\u8fc7\u6e20\u9053\u53f7\u68c0\u6d4b\u65f6\u53d1\u73b0filePath\u4e3a\u7a7a", a());
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                String a16 = com.tencent.dlsdk.yybutil.apkchannel.a.a(str);
                r.b(ReplaceMonitor.WASH_TAG, "ChannedlIdMonitorAction>>checkByChannelId " + monitorTask.appName + " task.cpChannelId = " + monitorTask.cpChannelId + " fileChannelId = " + a16);
                if (!TextUtils.isEmpty(a16) && !str2.equals(a16)) {
                    MonitorResult monitorResult = new MonitorResult(monitorStep, 1, "\u901a\u8fc7\u6e20\u9053\u53f7\u68c0\u6d4b\u53d1\u73b0\u6d17\u5305", a());
                    File file = new File(str);
                    long length = file.exists() ? file.length() : 0L;
                    monitorResult.replaceChannelId = a16;
                    monitorResult.replacedFileSize = length;
                    monitorResult.replaceTime = file.lastModified();
                    PackageInfo a17 = j.a(str);
                    MonitorStep monitorStep2 = MonitorStep.INSTALLING;
                    if (monitorStep == monitorStep2 || monitorStep == MonitorStep.AFTER_INSTALL) {
                        a17 = j.b(monitorTask.packageName);
                    }
                    if (a17 != null) {
                        monitorResult.replacedPkgName = a17.packageName;
                        monitorResult.replacedVersionCode = a17.versionCode;
                        if (monitorStep == monitorStep2 || monitorStep == MonitorStep.AFTER_INSTALL) {
                            monitorResult.replaceTime = a17.lastUpdateTime;
                        }
                    }
                    return monitorResult;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return new MonitorResult(monitorStep, 0, monitorStep + "\u6e20\u9053\u53f7\u68c0\u6d4b\u901a\u8fc7", a());
        }
        return new MonitorResult(monitorStep, 0, monitorStep + "task.cpChannelId\u4e3a\u7a7a", a());
    }
}
