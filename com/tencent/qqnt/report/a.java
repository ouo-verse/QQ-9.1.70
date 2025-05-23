package com.tencent.qqnt.report;

import android.os.SystemClock;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u00010B\u000f\u0012\u0006\u0010-\u001a\u00020\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\u0019\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001cH\u0004R\u0014\u0010\u001f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\"\u0010$\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001e\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010)R\u0016\u0010,\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/report/a;", "Lcom/tencent/qqnt/report/o;", "", "", "g", "", "d", "", "e", "f", "", "size", "", DomainData.DOMAIN_NAME, "(Ljava/lang/Integer;)V", "errCode", "errorMsg", "j", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "mergeUinListSize", "mergeMills", "i", "key", "value", "l", "b", "", "c", "J", "startTime", "getCallNtTime", "()J", "setCallNtTime", "(J)V", "callNtTime", "getCallExtDBTime", "setCallExtDBTime", "callExtDBTime", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "params", "Z", "hasReported", "from", "<init>", "(Ljava/lang/String;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a extends o {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile long callNtTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile long callExtDBTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> params;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasReported;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/report/a$a;", "", "", "DEFAULT_RATE", "D", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.report.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) from);
            return;
        }
        this.startTime = d();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("from", from);
        this.params = concurrentHashMap;
    }

    private final long d() {
        return SystemClock.uptimeMillis();
    }

    private final double g() {
        return com.tencent.mobileqq.troop.config.b.f294691a.c("102125", f(), 0.0d);
    }

    public static /* synthetic */ void k(a aVar, Integer num, Integer num2, String str, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                num2 = 0;
            }
            if ((i3 & 4) != 0) {
                str = "";
            }
            aVar.j(num, num2, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNtCallback");
    }

    public static /* synthetic */ void o(a aVar, Integer num, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                num = null;
            }
            aVar.n(num);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startCallNT");
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (TroopMemberReportKt.c() && !this.hasReported) {
            boolean z16 = true;
            this.hasReported = true;
            double g16 = g();
            if (Math.random() >= g16) {
                z16 = false;
            }
            String e16 = e();
            this.params.put("time_cost_total", Long.valueOf(d() - this.startTime));
            this.params.put("is_switch_back", Integer.valueOf(c(a())));
            if (z16) {
                ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report(e16, this.params);
            }
            if (QLog.isDebugVersion()) {
                QLog.d("TroopMemberReport", 4, "[doReport] needReport:" + z16 + ",samplingRate:" + g16 + ", " + e16 + " - " + this.params);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c(boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null) {
            return value ? 1 : 0;
        }
        if (iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, value)).intValue();
        }
        return value ? 1 : 0;
    }

    @NotNull
    public abstract String e();

    @NotNull
    public abstract String f();

    public final void h(int size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, size);
        } else {
            l("time_cost_ext_db", Long.valueOf(com.tencent.rdelivery.reshub.report.d.a() - this.callExtDBTime));
            l("count_ext_rsp", Integer.valueOf(size));
        }
    }

    public final void i(int mergeUinListSize, int mergeMills) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(mergeUinListSize), Integer.valueOf(mergeMills));
            return;
        }
        l("troop_member_merge_ready_mills", Long.valueOf(d()));
        l("troop_member_merge_uin_size", Integer.valueOf(mergeUinListSize));
        l("troop_member_merge_mills", Integer.valueOf(mergeMills));
    }

    public final void j(@Nullable Integer size, @Nullable Integer errCode, @Nullable String errorMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, size, errCode, errorMsg);
            return;
        }
        int i16 = 0;
        if (size != null) {
            i3 = size.intValue();
        } else {
            i3 = 0;
        }
        l("count_rsp", Integer.valueOf(i3));
        if (errCode != null) {
            i16 = errCode.intValue();
        }
        l("req_err_code", Integer.valueOf(i16));
        if (errorMsg == null) {
            errorMsg = "";
        }
        l("req_err_msg", errorMsg);
        l("time_cost_nt", Long.valueOf(com.tencent.rdelivery.reshub.report.d.a() - this.callNtTime));
    }

    public void l(@NotNull String key, @NotNull Object value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) key, value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.params.put(key, value);
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.callExtDBTime = com.tencent.rdelivery.reshub.report.d.a();
        }
    }

    public final void n(@Nullable Integer size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) size);
            return;
        }
        this.callNtTime = com.tencent.rdelivery.reshub.report.d.a();
        if (size != null) {
            l("count_req", Integer.valueOf(size.intValue()));
        }
    }
}
