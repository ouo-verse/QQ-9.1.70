package com.tencent.qqnt.report;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/report/f;", "Lcom/tencent/qqnt/report/o;", "", "b", "", "c", "d", "", "troopSize", "g", tl.h.F, "f", "e", "J", "startTime", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Ljava/util/concurrent/ConcurrentHashMap;", "getParams", "()Ljava/util/concurrent/ConcurrentHashMap;", "params", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f extends o {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> params;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.startTime = c();
            this.params = new ConcurrentHashMap<>();
        }
    }

    private final void b() {
        boolean d16;
        d16 = TroopListReportKt.d();
        if (!d16) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopListReport", 4, "[doReport] not open");
                return;
            }
            return;
        }
        this.params.put("is_switch_back", Integer.valueOf(a() ? 1 : 0));
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("troop_list_init_time_cost_nt", this.params);
        if (QLog.isDebugVersion()) {
            QLog.d("TroopListReport", 4, "[doReport] troop_list_init_time_cost_nt - " + this.params);
        }
    }

    private final long c() {
        return SystemClock.uptimeMillis();
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.params.put("time_cost_init_on_nt_created", Long.valueOf(c() - this.startTime));
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.params.put("time_cost_cache_ready", Long.valueOf(c() - this.startTime));
            b();
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.params.put("time_cost_nt_group_list_init", Long.valueOf(c() - this.startTime));
        }
    }

    public final void g(int troopSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, troopSize);
            return;
        }
        this.params.put("troop_count", Integer.valueOf(troopSize));
        this.params.put("time_cost_nt_notify", Long.valueOf(c() - this.startTime));
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.params.get("time_cost_post_task") == null) {
            this.params.put("time_cost_post_task", Long.valueOf(c() - this.startTime));
        }
    }
}
