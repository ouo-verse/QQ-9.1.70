package com.tencent.mobileqq.startup.task;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aq extends NtTask {
    static IPatchRedirector $redirector_;

    public aq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        com.tencent.mobileqq.qmmkv.n.f262021a.d(true);
        try {
            com.tencent.mobileqq.qmmkv.y.INSTANCE.j();
        } catch (Throwable th5) {
            QLog.w("qmmkv_MMKVMonitorTask", 1, th5.getMessage(), th5);
        }
    }
}
