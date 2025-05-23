package com.tencent.qqnt.report;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.report.TroopNTCMDReportKt$accountChangeCallback$2;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\t*\u0001\t\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0000H\u0002\u001a\b\u0010\u0003\u001a\u00020\u0000H\u0002\"\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0018\u0010\b\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\" \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"", "o", "p", DomainData.DOMAIN_NAME, "a", "Ljava/lang/Boolean;", "IS_REPORT_OPEN", "b", "IS_REPORT_WIRTE_OPEN", "com/tencent/qqnt/report/TroopNTCMDReportKt$accountChangeCallback$2$a", "c", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/report/TroopNTCMDReportKt$accountChangeCallback$2$a;", "accountChangeCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "sampleRateMap", "e", "D", "cmdSimpleRate", "f", "cmdWriteSimpleRate", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopNTCMDReportKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static Boolean f361928a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static Boolean f361929b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy f361930c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, Double> f361931d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile double f361932e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile double f361933f;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62792);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopNTCMDReportKt$accountChangeCallback$2.INSTANCE);
            f361930c = lazy;
            f361931d = new ConcurrentHashMap<>();
            f361932e = -1.0d;
            f361933f = -1.0d;
            return;
        }
        redirector.redirect((short) 1);
    }

    private static final TroopNTCMDReportKt$accountChangeCallback$2.a m() {
        return (TroopNTCMDReportKt$accountChangeCallback$2.a) f361930c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o() {
        if (n()) {
            return true;
        }
        if (f361928a == null) {
            d.f361946d.a(m());
            f361928a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102686", false));
        }
        Boolean bool = f361928a;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p() {
        if (n()) {
            return true;
        }
        if (f361929b == null) {
            d.f361946d.a(m());
            f361929b = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103036", false));
        }
        Boolean bool = f361929b;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
