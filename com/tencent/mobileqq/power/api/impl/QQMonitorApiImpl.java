package com.tencent.mobileqq.power.api.impl;

import android.content.Context;
import com.tencent.mobileqq.power.a;
import com.tencent.mobileqq.power.api.IQQMonitorApi;
import com.tencent.mobileqq.power.b;
import com.tencent.mobileqq.power.cpu.CpuMonitorManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/power/api/impl/QQMonitorApiImpl;", "Lcom/tencent/mobileqq/power/api/IQQMonitorApi;", "Landroid/content/Context;", "context", "", "startVivoMonitor", "stopVivoMonitor", "startCpuMonitor", "stopCpuMonitor", "", "avgCpuUsage", "startFrontCpuMonitor", "Lcom/tencent/mobileqq/power/a;", "callback", "getCpuData", "stopFrontCpuMonitor", "reportCpuMonitor", "", "tag", "url", "path", "reportNetUrl", "", "Lcom/tencent/mobileqq/power/b;", "data", "reportNetFlow", "<init>", "()V", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQMonitorApiImpl implements IQQMonitorApi {
    static IPatchRedirector $redirector_;

    public QQMonitorApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void getCpuData(@Nullable a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
        } else {
            CpuMonitorManager.f259424a.a(callback);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void reportCpuMonitor(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        } else if (context != null) {
            CpuMonitorManager.f259424a.g(context);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void reportNetFlow(@NotNull List<? extends b> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.mobileqq.power.net.a.f259462a.d(data);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void reportNetUrl(@Nullable String tag, @Nullable String url, @Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tag, url, path);
        } else {
            com.tencent.mobileqq.power.net.a.f259462a.e(tag, url, path);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void startCpuMonitor(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else if (context != null) {
            CpuMonitorManager.f259424a.e(context);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void startFrontCpuMonitor(double avgCpuUsage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Double.valueOf(avgCpuUsage));
        } else {
            CpuMonitorManager.f259424a.f(avgCpuUsage);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void startVivoMonitor(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else if (context != null) {
            com.tencent.mobileqq.power.vivo.a.f259465a.a(context);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void stopCpuMonitor(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else if (context != null) {
            CpuMonitorManager.f259424a.h(context);
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void stopFrontCpuMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            CpuMonitorManager.f259424a.i();
        }
    }

    @Override // com.tencent.mobileqq.power.api.IQQMonitorApi
    public void stopVivoMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            gy3.a.a();
        }
    }
}
