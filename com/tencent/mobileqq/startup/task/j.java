package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.startup.task.NtTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/j;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "a", "b", "Landroid/content/Context;", "context", "c", "d", TencentLocation.RUN_MODE, "<init>", "()V", "startup_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class j extends NtTask {
    static IPatchRedirector $redirector_;

    public j() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        com.tencent.mobileqq.config.aq.f202313a = "N";
        com.tencent.mobileqq.config.aq.f202314b = AppSetting.f99551k;
        com.tencent.mobileqq.config.aq.f202315c = true;
        com.tencent.mobileqq.config.aq.f202316d = false;
        com.tencent.mobileqq.config.aq.f202317e = false;
        com.tencent.mobileqq.config.aq.f202318f = true;
    }

    private final void b() {
        ThreadSetting.isPublicVersion = true;
        ThreadSetting.isGrayVersion = false;
        ThreadSetting.isDebugVersion = false;
        ThreadSetting.revision = AppSetting.f99543c;
        ThreadSetting.sProcessId = MobileQQ.sProcessId;
        ThreadSetting.PROCESS_QQ = 1;
        ThreadSetting.CLR = 2;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        a();
        b();
        d();
        SoLoadCore.setIsCpu64Bit(true);
        GlobalDisplayMetricsManager.adjustDisplayMetrics(context);
        FontSettingManager.resetFontIfNeeded(context, false, true);
        LocaleManager.initializeAppLocale(context);
        c(context);
    }

    private final void d() {
    }

    private final void c(Context context) {
    }
}
