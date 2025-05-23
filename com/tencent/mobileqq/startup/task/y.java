package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.lifecycle.UECActivityLifeCycle;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/task/y;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "", "blockUntilFinish", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class y extends NtTask {
    static IPatchRedirector $redirector_;

    public y() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, MobileQQ.processName)) {
            QLog.d("GuardInitTask", 1, "return at " + MobileQQ.processName);
            return;
        }
        Foreground.init(MobileQQ.sMobileQQ, ThreadManagerV2.getSubThreadLooper(), MobileQQ.processName);
        if (Intrinsics.areEqual("Success", MobileQQ.sInjectResult) && PrivacyPolicyHelper.isUserAllow()) {
            Foreground.addActivityLifeCallback(new UECActivityLifeCycle(MobileQQ.sMobileQQ, ThreadManagerV2.getSubThreadLooper(), MobileQQ.processName));
        }
        if (GuardManager.sInstance == null && Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, MobileQQ.processName)) {
            GuardManager.sInstance = new GuardManager(MobileQQ.sMobileQQ, 0);
        }
    }
}
