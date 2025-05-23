package com.tencent.qqnt.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.report.TroopMemberReportKt$accountChangeCallback$2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0006*\u0001\u0005\u001a\u0006\u0010\u0001\u001a\u00020\u0000\"\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u001b\u0010\t\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"", "c", "a", "Ljava/lang/Boolean;", "IS_REPORT_OPEN", "com/tencent/qqnt/report/TroopMemberReportKt$accountChangeCallback$2$a", "b", "Lkotlin/Lazy;", "()Lcom/tencent/qqnt/report/TroopMemberReportKt$accountChangeCallback$2$a;", "accountChangeCallback", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopMemberReportKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static Boolean f361926a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f361927b;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62780);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopMemberReportKt$accountChangeCallback$2.INSTANCE);
            f361927b = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    private static final TroopMemberReportKt$accountChangeCallback$2.a b() {
        return (TroopMemberReportKt$accountChangeCallback$2.a) f361927b.getValue();
    }

    public static final boolean c() {
        if (f361926a == null) {
            d.f361946d.a(b());
            f361926a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102125", false));
        }
        Boolean bool = f361926a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
