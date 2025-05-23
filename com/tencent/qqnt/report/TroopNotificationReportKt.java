package com.tencent.qqnt.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.report.TroopNotificationReportKt$accountChangeCallback$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\t\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"", "f", "a", "Ljava/lang/Boolean;", "IS_REPORT_OPEN", "", "b", "Ljava/lang/Double;", "LOCAL_SAMPLE_RATE", "com/tencent/qqnt/report/TroopNotificationReportKt$accountChangeCallback$2$a", "c", "Lkotlin/Lazy;", "e", "()Lcom/tencent/qqnt/report/TroopNotificationReportKt$accountChangeCallback$2$a;", "accountChangeCallback", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopNotificationReportKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @Nullable
    private static Boolean f361934a;

    /* renamed from: b */
    @Nullable
    private static Double f361935b;

    /* renamed from: c */
    @NotNull
    private static final Lazy f361936c;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62820);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopNotificationReportKt$accountChangeCallback$2.INSTANCE);
            f361936c = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    public static final /* synthetic */ Double a() {
        return f361935b;
    }

    public static final /* synthetic */ boolean b() {
        return f();
    }

    public static final /* synthetic */ void d(Double d16) {
        f361935b = d16;
    }

    private static final TroopNotificationReportKt$accountChangeCallback$2.a e() {
        return (TroopNotificationReportKt$accountChangeCallback$2.a) f361936c.getValue();
    }

    public static final boolean f() {
        if (f361934a == null) {
            d.f361946d.a(e());
            f361934a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105697", false));
        }
        Boolean bool = f361934a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
