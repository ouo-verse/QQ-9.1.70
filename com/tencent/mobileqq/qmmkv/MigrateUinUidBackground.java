package com.tencent.mobileqq.qmmkv;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.friend.utils.MMKForUinUid;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001b\u0010$\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0018\u0010\u001bR\u001b\u0010&\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b\u0011\u0010\u0014\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/MigrateUinUidBackground;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "l", "", "tick", "j", "d", "g", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "e", "J", "getBackgroundTs", "()J", "setBackgroundTs", "(J)V", "backgroundTs", "f", "Z", "getChecked", "()Z", "setChecked", "(Z)V", "checked", tl.h.F, "isMigrating", "setMigrating", "i", "Lkotlin/Lazy;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "delayMs", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MigrateUinUidBackground implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final MigrateUinUidBackground f261987d = new MigrateUinUidBackground();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile long backgroundTs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean checked;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isMigrating;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy switch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy delayMs;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qmmkv.MigrateUinUidBackground$switch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("mmkv_migrate_uinuid", false));
            }
        });
        switch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.qmmkv.MigrateUinUidBackground$delayMs$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeInt("mmkv_migrate_uinuid_delay", 5) * 1000);
            }
        });
        delayMs = lazy2;
    }

    MigrateUinUidBackground() {
    }

    private final void d() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (MMKForUinUid.g()) {
                if (QLog.isColorLevel()) {
                    QLog.i("MMKForUinUid", 1, "migrate check return");
                    return;
                }
                return;
            }
            isMigrating = true;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
            from.encodeLong("last_uinuid_migrate_ts_key", elapsedRealtime);
            StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "actMMKVMigrateUinUidReport", MMKForUinUid.h(hashMap), 0L, 0L, hashMap, "");
            from.removeKey("last_uinuid_migrate_ts_key");
            isMigrating = false;
        } catch (Throwable th5) {
            QLog.e("MMKForUinUid", 1, "migrate exception: " + th5.getMessage(), th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MigrateUinUidBackground this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MigrateUinUidBackground migrateUinUidBackground = f261987d;
        boolean z16 = true;
        if (migrateUinUidBackground.f() && !MMKForUinUid.g()) {
            migrateUinUidBackground.l();
            MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
            if (from.totalSize() < 33554432 && from.actualSize() < 16777216) {
                z16 = false;
            }
            if (z16) {
                GuardManagerCallbackDispatcher.registerCallBack(this$0);
                return;
            }
            return;
        }
        QLog.d("MigrateUinUidBackground", 1, "init switch off or hasMigrated, return");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        f261987d.j(0L);
    }

    private final void j(long tick) {
        if (!checked && SystemClock.elapsedRealtime() - backgroundTs >= e()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MigrateUinUidBackground", 2, "onBackgroundTimeTick " + tick + " delayMs:" + e());
            }
            checked = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.o
                @Override // java.lang.Runnable
                public final void run() {
                    MigrateUinUidBackground.k(MigrateUinUidBackground.this);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MigrateUinUidBackground this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (backgroundTs != 0) {
            f261987d.d();
            if (MMKForUinUid.g()) {
                GuardManagerCallbackDispatcher.unregisterCallBack(this$0);
            }
        }
    }

    private final void l() {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        MMKVOptionEntity from = QMMKV.from(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("last_uinuid_report_ts_key", 0L);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - decodeLong;
        if (j3 > 86400000 || j3 < 0) {
            if (!isMigrating && from.decodeLong("last_uinuid_migrate_ts_key", 0L) > 0) {
                from.removeKey("last_uinuid_migrate_ts_key");
                long j16 = from.totalSize();
                long actualSize = from.actualSize();
                long count = from.count();
                hashMap.put("fileSize", String.valueOf(j16));
                hashMap.put("actualSize", String.valueOf(actualSize));
                hashMap.put("keyCount", String.valueOf(count));
                z16 = false;
            } else {
                z16 = true;
            }
            StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "actMMKVNotMigrateUinUidReport", z16, 0L, 0L, hashMap, "");
            from.encodeLong("last_uinuid_report_ts_key", elapsedRealtime);
        }
    }

    public final long e() {
        return ((Number) delayMs.getValue()).longValue();
    }

    public final boolean f() {
        return ((Boolean) switch.getValue()).booleanValue();
    }

    public final void g() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.q
            @Override // java.lang.Runnable
            public final void run() {
                MigrateUinUidBackground.h(MigrateUinUidBackground.this);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        backgroundTs = SystemClock.elapsedRealtime();
        checked = false;
        if (QLog.isDevelopLevel()) {
            QLog.d("MigrateUinUidBackground", 2, "onApplicationBackground");
        }
        if (e() < 12000 && e() > 0) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.p
                @Override // java.lang.Runnable
                public final void run() {
                    MigrateUinUidBackground.i();
                }
            }, 16, null, false, e());
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        backgroundTs = 0L;
        if (QLog.isDevelopLevel()) {
            QLog.d("MigrateUinUidBackground", 2, "onApplicationForeground");
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
        j(tick);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
        j(tick);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
