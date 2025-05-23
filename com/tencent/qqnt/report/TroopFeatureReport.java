package com.tencent.qqnt.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.report.TroopFeatureReport$accountChangeCallback$2;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u0002R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/report/TroopFeatureReport;", "", "", "e", "", "pageName", "", "f", "forceReport", "b", "Ljava/lang/Boolean;", "isReportOpen", "com/tencent/qqnt/report/TroopFeatureReport$accountChangeCallback$2$a", "c", "Lkotlin/Lazy;", "d", "()Lcom/tencent/qqnt/report/TroopFeatureReport$accountChangeCallback$2$a;", "accountChangeCallback", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopFeatureReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final TroopFeatureReport f361921a;

    /* renamed from: b, reason: from kotlin metadata */
    @Nullable
    private static Boolean isReportOpen;

    /* renamed from: c, reason: from kotlin metadata */
    @NotNull
    private static final Lazy accountChangeCallback;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f361921a = new TroopFeatureReport();
        lazy = LazyKt__LazyJVMKt.lazy(TroopFeatureReport$accountChangeCallback$2.INSTANCE);
        accountChangeCallback = lazy;
    }

    TroopFeatureReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(TroopFeatureReport troopFeatureReport, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        troopFeatureReport.b(str, z16);
    }

    private final TroopFeatureReport$accountChangeCallback$2.a d() {
        return (TroopFeatureReport$accountChangeCallback$2.a) accountChangeCallback.getValue();
    }

    private final boolean e() {
        if (isReportOpen == null) {
            d.f361946d.a(d());
            isReportOpen = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105588", false));
        }
        Boolean bool = isReportOpen;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void b(@Nullable String pageName, boolean forceReport) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, pageName, Boolean.valueOf(forceReport));
            return;
        }
        if (!e() && !forceReport) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopFeatureReport", 4, "[doReport] skip");
                return;
            }
            return;
        }
        ITroopBeaconReporter iTroopBeaconReporter = (ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class);
        HashMap hashMap = new HashMap();
        if (pageName == null) {
            str = "";
        } else {
            str = pageName;
        }
        hashMap.put("troop_feature_page_name", str);
        Unit unit = Unit.INSTANCE;
        iTroopBeaconReporter.report("troop_feature_report", hashMap);
        if (QLog.isDebugVersion()) {
            QLog.d("TroopFeatureReport", 4, "[doReport] pageName:" + pageName);
        }
    }

    public final void f(@Nullable String pageName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pageName);
        } else {
            b(pageName, true);
        }
    }
}
