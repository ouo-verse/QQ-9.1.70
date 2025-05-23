package com.tencent.open.agent.report;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.open.agent.util.t;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J>\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007R\u001b\u0010\u0011\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/open/agent/report/SSOSendReporter;", "", "", "uin", "cmd", "", "isOidbSSODowngrade", "", "b", "result", "", "code", "errMsg", "c", "Lkotlin/Lazy;", "a", "()Z", "functionSwitch", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class SSOSendReporter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SSOSendReporter f340516a = new SSOSendReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy functionSwitch;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.agent.report.SSOSendReporter$functionSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_sso_send_report_feature_switch", true);
                t.f("SSOSendReporter", "functionSwitch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        functionSwitch = lazy;
    }

    SSOSendReporter() {
    }

    private final boolean a() {
        return ((Boolean) functionSwitch.getValue()).booleanValue();
    }

    @JvmStatic
    public static final void b(@Nullable String uin, @Nullable String cmd, boolean isOidbSSODowngrade) {
        if (!f340516a.a()) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (cmd == null) {
                cmd = "unknown";
            }
            hashMap.put("cmd", cmd);
            hashMap.put("isDowngrade", String.valueOf(isOidbSSODowngrade));
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "currentAccountUin");
            hashMap.put(AlbumCacheData.LOGINUIN, currentAccountUin);
            if (uin == null) {
                uin = "unknown";
            }
            QQBeaconReport.report(uin, "openSdkSSOSend", hashMap);
        } catch (Exception e16) {
            t.d("SSOSendReporter", "reportSSOSend exception: ", e16);
        }
    }

    @JvmStatic
    public static final void c(@Nullable String uin, @Nullable String cmd, boolean isOidbSSODowngrade, boolean result, int code, @Nullable String errMsg) {
        if (!f340516a.a()) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (cmd == null) {
                cmd = "unknown";
            }
            hashMap.put("cmd", cmd);
            hashMap.put("isDowngrade", String.valueOf(isOidbSSODowngrade));
            hashMap.put("isSuccess", String.valueOf(result));
            hashMap.put("errCode", String.valueOf(code));
            if (errMsg == null) {
                errMsg = "";
            }
            hashMap.put("errMsg", errMsg);
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
            hashMap.put(AlbumCacheData.LOGINUIN, currentAccountUin);
            if (uin == null) {
                uin = "unknown";
            }
            QQBeaconReport.report(uin, "openSdkSSOSendResult", hashMap);
        } catch (Exception e16) {
            t.d("SSOSendReporter", "reportSSOSendResult exception: ", e16);
        }
    }
}
