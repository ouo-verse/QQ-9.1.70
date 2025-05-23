package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ca;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "", "blockUntilFinish", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ca extends NtTask {
    static IPatchRedirector $redirector_;

    public ca() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences b(String str, int i3) {
        return BaseApplicationImpl.sApplication.getSystemSharedPreferences(str, i3);
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferencesProxyManager.IAdapter iAdapter = new SharedPreferencesProxyManager.IAdapter() { // from class: com.tencent.mobileqq.startup.task.bz
            @Override // com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager.IAdapter
            public final SharedPreferences getSystemSharedPreferences(String str, int i3) {
                SharedPreferences b16;
                b16 = ca.b(str, i3);
                return b16;
            }
        };
        if (PrivacyPolicyHelper.isUserAllow()) {
            SharedPreferencesProxyManager.getInstance().init(context, iAdapter);
        } else {
            SharedPreferencesProxyManager.getInstance().init(context, MsfSdkUtils.getProcessNameIfNoPrivacyPolicy(context), iAdapter);
        }
        if (MobileQQ.sProcessId == 1) {
            SafeModeUtil.d(context);
        }
    }
}
