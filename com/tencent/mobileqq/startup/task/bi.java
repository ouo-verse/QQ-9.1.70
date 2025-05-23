package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import eipc.EIPCContentProvider;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bi;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "a", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bi extends NtTask {
    static IPatchRedirector $redirector_;

    public bi() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIPCInitTask", 2, "tryConnect");
        }
        try {
            Class<?> loadClass = MobileQQ.sMobileQQ.getClassLoader().loadClass("com.tencent.mobileqq.qipc.QIPCEnvironmentInit");
            Intrinsics.checkNotNullExpressionValue(loadClass, "sMobileQQ\n              \u2026ipc.QIPCEnvironmentInit\")");
            Method declaredMethod = loadClass.getDeclaredMethod("initEnvironment", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e16) {
            QLog.e("QIPCInitTask", 2, "tryConnect exception:", e16);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (MobileQQ.sProcessId == 1) {
            EIPCContentProvider.sIsDexInjectFinish = true;
            ThreadRegulator.d().e();
        }
        if (MobileQQ.sProcessId != 4) {
            a();
        }
    }
}
