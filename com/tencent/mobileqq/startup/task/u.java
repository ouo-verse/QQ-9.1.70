package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.util.notification.NotificationReportControllerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/startup/task/u;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "b", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class u extends NtTask {
    static IPatchRedirector $redirector_;

    public u() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b() {
        try {
            NotificationReportControllerImpl notificationReportControllerImpl = new NotificationReportControllerImpl();
            NotificationReportUtil.setReport(notificationReportControllerImpl);
            com.tencent.mobileqq.managers.d.e(notificationReportControllerImpl);
        } catch (Throwable th5) {
            QLog.e("initNotificationReport", 1, "initNotificationReport throws e", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        MobileQQ.sMobileQQ.ensureInitProperty();
        ea.N1(MobileQQ.sMobileQQ);
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.vfs.b i3 = com.tencent.mobileqq.vfs.b.i();
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        com.tencent.mobileqq.vfs.a a16 = com.tencent.mobileqq.vfs.a.a();
        if (MobileQQ.sProcessId == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        i3.h(baseApplicationImpl, a16, z16, false);
        if (1 == MobileQQ.sProcessId) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.startup.task.t
                @Override // java.lang.Runnable
                public final void run() {
                    u.c();
                }
            });
        }
        b();
    }
}
