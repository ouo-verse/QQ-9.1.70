package com.tencent.mobileqq.troop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/l;", "", "", "b", "", "troopUin", "", "a", "Ljava/lang/Boolean;", "isReadableReportOpen", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f297714a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean isReadableReportOpen;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23165);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f297714a = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        if (isReadableReportOpen == null) {
            isReadableReportOpen = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105467", false));
        }
        Boolean bool = isReadableReportOpen;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void a(@Nullable String troopUin) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
            return;
        }
        if (!b()) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopReadableBlockReport", 4, "[doReport] skip");
                return;
            }
            return;
        }
        ITroopBeaconReporter iTroopBeaconReporter = (ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class);
        HashMap hashMap = new HashMap();
        if (troopUin == null) {
            str = "";
        } else {
            str = troopUin;
        }
        hashMap.put("troop_uin", str);
        Unit unit = Unit.INSTANCE;
        iTroopBeaconReporter.report("troop_readable_block_report", hashMap);
        if (QLog.isDebugVersion()) {
            QLog.d("TroopReadableBlockReport", 4, "[doReport] troopUin:" + troopUin);
        }
    }
}
