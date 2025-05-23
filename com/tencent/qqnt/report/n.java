package com.tencent.qqnt.report;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/report/n;", "Lcom/tencent/qqnt/report/o;", "", "c", "", "d", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "b", "", "Ljava/lang/String;", "from", "", "I", "category", "f", "dataSize", "g", "templateSize", tl.h.F, "J", "startTime", "Ljava/util/concurrent/ConcurrentHashMap;", "", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "getParams", "()Ljava/util/concurrent/ConcurrentHashMap;", "params", "<init>", "(Ljava/lang/String;III)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class n extends o {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String from;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int category;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int dataSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int templateSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> params;

    public /* synthetic */ n(String str, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i18 & 2) != 0 ? -1 : i3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? 0 : i17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), defaultConstructorMarker);
    }

    private final long c() {
        return SystemClock.uptimeMillis();
    }

    private final double d() {
        if (TroopNotificationReportKt.a() == null) {
            TroopNotificationReportKt.d(Double.valueOf(com.tencent.mobileqq.troop.config.b.f294691a.c("105697", "local_sampling_rate", 0.0d)));
        }
        Double a16 = TroopNotificationReportKt.a();
        if (a16 == null) {
            return 0.0d;
        }
        return a16.doubleValue();
    }

    public final void b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!TroopNotificationReportKt.b()) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopNotificationReport", 4, "[doReport] not open");
                return;
            }
            return;
        }
        this.params.put("is_switch_back", Integer.valueOf(a() ? 1 : 0));
        this.params.put("time_cost_total", Long.valueOf(c() - this.startTime));
        double d16 = d();
        double random = Math.random();
        if (random >= d16 && !this.params.containsKey("notify_exception")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("troop_notification_data_report", this.params);
        }
        if (QLog.isDebugVersion()) {
            QLog.d("TroopNotificationReport", 4, "[doReport] needReport:" + z16 + ", localRandom:" + random + ", samplingRate:" + d16 + ", troop_notification_data_report - " + this.params);
        }
    }

    public final void e(@NotNull Exception e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) e16);
        } else {
            Intrinsics.checkNotNullParameter(e16, "e");
            this.params.put("notify_exception", e16.toString());
        }
    }

    public n(@NotNull String from, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(from, "from");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, from, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.from = from;
        this.category = i3;
        this.dataSize = i16;
        this.templateSize = i17;
        this.startTime = c();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("from", from);
        concurrentHashMap.put("notify_category", Integer.valueOf(i3));
        concurrentHashMap.put("notify_msg_count", Integer.valueOf(i16));
        concurrentHashMap.put("notify_template_count", Integer.valueOf(i17));
        this.params = concurrentHashMap;
    }
}
