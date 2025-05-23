package com.tencent.mobileqq.msf.adapter;

import android.content.Context;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.msf.core.startup.MSFTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.startup.task.NtTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/msf/adapter/TestEnvManagerInitTaskAdapter;", "Lcom/tencent/qqnt/startup/task/NtTask;", "mMSFTask", "Lcom/tencent/mobileqq/msf/core/startup/MSFTask;", "(Lcom/tencent/mobileqq/msf/core/startup/MSFTask;)V", "blockUntilFinish", "", TencentLocation.RUN_MODE, "", "context", "Landroid/content/Context;", "runOnMainThread", "startup_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class TestEnvManagerInitTaskAdapter extends NtTask {
    static IPatchRedirector $redirector_;

    @NotNull
    private final MSFTask mMSFTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestEnvManagerInitTaskAdapter(@NotNull MSFTask mMSFTask) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(mMSFTask, "mMSFTask");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mMSFTask);
        } else {
            this.mMSFTask = mMSFTask;
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean blockUntilFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mMSFTask.blockUntilFinish();
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            this.mMSFTask.run(context);
        }
    }

    @Override // com.tencent.qqnt.startup.task.NtTask
    public boolean runOnMainThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mMSFTask.runOnMainThread();
    }
}
