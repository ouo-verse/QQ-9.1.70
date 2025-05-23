package com.tencent.mobileqq.qwallet.report.beacon;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nR#\u0010\u0012\u001a\n \u000e*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qwallet/report/beacon/QWalletTechBeaconReport;", "", "", "", "a", "eventCode", "", "params", "", "sampleRate", "", "forceReport", "", "d", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "b", "()Ljava/lang/String;", "qqVersion", "c", "uid", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletTechBeaconReport {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqVersion;

    public QWalletTechBeaconReport() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qwallet.report.beacon.QWalletTechBeaconReport$qqVersion$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return com.tencent.mobileqq.cooperation.a.c(BaseApplication.context);
            }
        });
        this.qqVersion = lazy;
        QQBeaconReport.start();
    }

    private final Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("kc_uid", c());
        String qqVersion = b();
        Intrinsics.checkNotNullExpressionValue(qqVersion, "qqVersion");
        linkedHashMap.put("kc_qq_version", qqVersion);
        linkedHashMap.put("kc_net_state", String.valueOf(NetConnInfoCenter.getSystemNetState()));
        linkedHashMap.put("kc_is_publish", "1");
        return linkedHashMap;
    }

    private final String b() {
        return (String) this.qqVersion.getValue();
    }

    private final String c() {
        String str;
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            str = firstSimpleAccount.getUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static /* synthetic */ void e(QWalletTechBeaconReport qWalletTechBeaconReport, String str, Map map, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 100;
        }
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        qWalletTechBeaconReport.d(str, map, i3, z16);
    }

    public final void d(@NotNull String eventCode, @Nullable Map<String, String> params, int sampleRate, boolean forceReport) {
        int random;
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        if (!forceReport) {
            random = RangesKt___RangesKt.random(new IntRange(0, 100), Random.INSTANCE);
            if (sampleRate < random) {
                QLog.d("QWalletTechBeaconReport", 2, "report beacon local: " + eventCode + ", " + params);
                return;
            }
        }
        QLog.d("QWalletTechBeaconReport", 2, "report beacon: " + eventCode + ", " + params);
        Map<String, String> a16 = a();
        if (params != null) {
            a16.putAll(params);
        }
        QQBeaconReport.reportWithAppKey("0DOU00P9LT4CEWFN", c(), eventCode, true, a16, true);
    }
}
