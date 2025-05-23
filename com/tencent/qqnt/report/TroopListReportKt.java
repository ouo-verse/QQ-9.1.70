package com.tencent.qqnt.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.report.TroopListReportKt$accountChangeCallback$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0007*\u0001\u0005\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"", "d", "a", "Ljava/lang/Boolean;", "IS_REPORT_OPEN", "com/tencent/qqnt/report/TroopListReportKt$accountChangeCallback$2$a", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/qqnt/report/TroopListReportKt$accountChangeCallback$2$a;", "accountChangeCallback", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopListReportKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static Boolean f361924a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f361925b;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62727);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopListReportKt$accountChangeCallback$2.INSTANCE);
            f361925b = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    private static final TroopListReportKt$accountChangeCallback$2.a c() {
        return (TroopListReportKt$accountChangeCallback$2.a) f361925b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d() {
        if (f361924a == null) {
            d.f361946d.a(c());
            f361924a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102826", false));
        }
        Boolean bool = f361924a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
