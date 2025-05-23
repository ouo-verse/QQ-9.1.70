package com.tencent.qqnt.report;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J!\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/report/TroopCMDReport;", "Ljava/io/Serializable;", "", "b", "", "a", "", "requestErrorCode", "logicErrorCode", "", "doReport", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "", "cmdName", "Ljava/lang/String;", "troopUin", "from", "startTime", "J", "", "isReported", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopCMDReport implements Serializable {
    static IPatchRedirector $redirector_;

    @Nullable
    private final String cmdName;

    @Nullable
    private final String from;
    private boolean isReported;
    private final long startTime;

    @Nullable
    private final String troopUin;

    public TroopCMDReport(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.cmdName = str;
        this.troopUin = str2;
        this.from = str3;
        this.startTime = a();
    }

    private final long a() {
        return SystemClock.uptimeMillis();
    }

    private final double b() {
        return com.tencent.mobileqq.troop.config.b.f294691a.c("102675", "troop_cmd_sampling_rate", 0.0d);
    }

    public final void doReport(@Nullable Integer requestErrorCode, @Nullable Integer logicErrorCode) {
        boolean b16;
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            b16 = e.b();
            if (b16 && !this.isReported) {
                double b17 = b();
                int i16 = 0;
                if (Math.random() < b17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                HashMap hashMap = new HashMap();
                String str = this.cmdName;
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                hashMap.put("cmd_name", str);
                String str3 = this.troopUin;
                if (str3 == null) {
                    str3 = "";
                }
                hashMap.put("troop_uin", str3);
                String str4 = this.from;
                if (str4 != null) {
                    str2 = str4;
                }
                hashMap.put("from", str2);
                if (requestErrorCode != null) {
                    i3 = requestErrorCode.intValue();
                } else {
                    i3 = 0;
                }
                hashMap.put("cmd_req_error_code", Integer.valueOf(i3));
                if (logicErrorCode != null) {
                    i16 = logicErrorCode.intValue();
                }
                hashMap.put("cmd_logic_error_code", Integer.valueOf(i16));
                hashMap.put("time_cost_total", Long.valueOf(a() - this.startTime));
                if (z16) {
                    ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("troop_cmd_report", hashMap);
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopCMDReport", 4, "[doReport] needReport:" + z16 + ",samplingRate:" + b17 + ", troop_cmd_report - " + hashMap);
                }
                this.isReported = true;
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) requestErrorCode, (Object) logicErrorCode);
    }

    public /* synthetic */ TroopCMDReport(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
