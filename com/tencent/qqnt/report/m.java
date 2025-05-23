package com.tencent.qqnt.report;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\u000b\u001a\u00020\nJ/\u0010\u0010\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R#\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/report/m;", "Lcom/tencent/qqnt/report/o;", "", "isWriteCmd", "", "cmdName", "", "e", "", "d", "", "f", "", "requestErrorCode", "logicErrorCode", "errorMsg", "b", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/String;", "troopUin", "from", "g", "Z", "forceNet", tl.h.F, "i", "J", "startTime", "j", "isReported", "Ljava/util/concurrent/ConcurrentHashMap;", "", "k", "Ljava/util/concurrent/ConcurrentHashMap;", "getParams", "()Ljava/util/concurrent/ConcurrentHashMap;", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class m extends o {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String cmdName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String from;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean forceNet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean isWriteCmd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isReported;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Object> params;

    public /* synthetic */ m(String str, String str2, String str3, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, str3, (i3 & 8) != 0 ? true : z16, (i3 & 16) != 0 ? false : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
    }

    public static /* synthetic */ void c(m mVar, Integer num, Integer num2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num2 = 0;
        }
        if ((i3 & 4) != 0) {
            str = "";
        }
        mVar.b(num, num2, str);
    }

    private final long d() {
        return SystemClock.uptimeMillis();
    }

    private final double e(boolean isWriteCmd, String cmdName) {
        boolean n3;
        double d16;
        boolean z16;
        double d17;
        ConcurrentHashMap concurrentHashMap;
        double d18;
        boolean p16;
        double d19;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        double d26;
        boolean z17;
        double d27;
        n3 = TroopNTCMDReportKt.n();
        double d28 = 1.0d;
        if (n3) {
            return 1.0d;
        }
        boolean z18 = true;
        if (isWriteCmd) {
            d26 = TroopNTCMDReportKt.f361933f;
            if (d26 == -1.0d) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                d27 = TroopNTCMDReportKt.f361933f;
                return d27;
            }
        }
        if (cmdName != null) {
            concurrentHashMap2 = TroopNTCMDReportKt.f361931d;
            if (concurrentHashMap2.containsKey(cmdName)) {
                concurrentHashMap3 = TroopNTCMDReportKt.f361931d;
                Double d29 = (Double) concurrentHashMap3.get(cmdName);
                if (d29 == null) {
                    return -1.0d;
                }
                return d29.doubleValue();
            }
        }
        if (isWriteCmd) {
            p16 = TroopNTCMDReportKt.p();
            if (!p16) {
                d28 = com.tencent.mobileqq.troop.config.b.f294691a.c("102686", "troop_write_cmd_sampling_rate", 0.0d);
            }
            TroopNTCMDReportKt.f361933f = d28;
            d19 = TroopNTCMDReportKt.f361933f;
            return d19;
        }
        if (cmdName != null) {
            d16 = com.tencent.mobileqq.troop.config.b.f294691a.c("102686", cmdName, -1.0d);
        } else {
            d16 = -1.0d;
        }
        if (d16 == -1.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d18 = TroopNTCMDReportKt.f361932e;
            if (d18 != -1.0d) {
                z18 = false;
            }
            if (z18) {
                TroopNTCMDReportKt.f361932e = com.tencent.mobileqq.troop.config.b.f294691a.c("102686", "troop_cmd_sampling_rate", 0.0d);
            }
            d17 = TroopNTCMDReportKt.f361932e;
        } else {
            d17 = d16;
        }
        if (cmdName != null) {
            concurrentHashMap = TroopNTCMDReportKt.f361931d;
            concurrentHashMap.put(cmdName, Double.valueOf(d17));
        }
        return d17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r0 == false) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(@Nullable Integer requestErrorCode, @Nullable Integer logicErrorCode, @Nullable String errorMsg) {
        boolean o16;
        byte b16;
        boolean z16;
        int i3;
        Boolean bool;
        Boolean bool2;
        boolean p16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, requestErrorCode, logicErrorCode, errorMsg);
            return;
        }
        if (this.isReported) {
            return;
        }
        int i16 = 0;
        if (this.isWriteCmd) {
            p16 = TroopNTCMDReportKt.p();
        }
        o16 = TroopNTCMDReportKt.o();
        if (!o16) {
            b16 = false;
            if (b16 != false) {
                if (QLog.isDebugVersion()) {
                    String str = this.cmdName;
                    bool = TroopNTCMDReportKt.f361928a;
                    bool2 = TroopNTCMDReportKt.f361929b;
                    QLog.d("TroopNTCMDReport", 4, "[doReport] skip cmd report, cmd:" + str + "\uff0copen:" + bool + ", writeOpen:" + bool2);
                    return;
                }
                return;
            }
            double e16 = e(this.isWriteCmd, this.cmdName);
            if (Math.random() < e16) {
                z16 = true;
            } else {
                z16 = false;
            }
            ConcurrentHashMap<String, Object> concurrentHashMap = this.params;
            if (requestErrorCode != null) {
                i3 = requestErrorCode.intValue();
            } else {
                i3 = 0;
            }
            concurrentHashMap.put("cmd_req_error_code", Integer.valueOf(i3));
            ConcurrentHashMap<String, Object> concurrentHashMap2 = this.params;
            if (errorMsg == null) {
                errorMsg = "";
            }
            concurrentHashMap2.put("cmd_req_error_msg", errorMsg);
            ConcurrentHashMap<String, Object> concurrentHashMap3 = this.params;
            if (logicErrorCode != null) {
                i16 = logicErrorCode.intValue();
            }
            concurrentHashMap3.put("cmd_logic_error_code", Integer.valueOf(i16));
            this.params.put("time_cost_total", Long.valueOf(d() - this.startTime));
            this.params.put("is_switch_back", Integer.valueOf(a() ? 1 : 0));
            if (z16) {
                ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("troop_cmd_report_with_nt", this.params);
            }
            if (QLog.isDebugVersion()) {
                QLog.d("TroopNTCMDReport", 4, "[doReport] needReport:" + z16 + ",samplingRate:" + e16 + ", troop_cmd_report_with_nt - " + this.params);
            }
            this.isReported = true;
            return;
        }
        b16 = true;
        if (b16 != false) {
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.params.put("time_cost_nt", Long.valueOf(d() - this.startTime));
        }
    }

    public m(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.cmdName = str;
        this.troopUin = str2;
        this.from = str3;
        this.forceNet = z16;
        this.isWriteCmd = z17;
        this.startTime = d();
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("cmd_name", str == null ? "" : str);
        concurrentHashMap.put("troop_uin", str2 == null ? "" : str2);
        concurrentHashMap.put("from", str3 == null ? "" : str3);
        concurrentHashMap.put("req_is_net", Integer.valueOf(z16 ? 1 : 0));
        concurrentHashMap.put("key_is_write", Integer.valueOf(z17 ? 1 : 0));
        this.params = concurrentHashMap;
    }
}
