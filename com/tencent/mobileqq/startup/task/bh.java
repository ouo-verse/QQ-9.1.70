package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.startup.task.NtTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/bh;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "a", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "runOnMainThread", "blockUntilFinish", "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class bh extends NtTask {
    static IPatchRedirector $redirector_;

    public bh() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        if (MobileQQ.sProcessId != 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return a();
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            ((IQCircleClassApi) QRoute.api(IQCircleClassApi.class)).initDelegate();
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean runOnMainThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return a();
    }
}
