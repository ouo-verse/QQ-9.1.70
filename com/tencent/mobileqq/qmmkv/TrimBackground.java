package com.tencent.mobileqq.qmmkv;

import android.os.SystemClock;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0002J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/TrimBackground;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "g", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "kv", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "j", "", "d", "", "tick", tl.h.F, "e", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "J", "getBackgroundTs", "()J", "setBackgroundTs", "(J)V", "backgroundTs", "f", "Z", "getChecked", "()Z", "setChecked", "(Z)V", "checked", "Lkotlin/Lazy;", "c", "mmkvTrimWhenIdleSwitch", "<init>", "()V", "qq-injector-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class TrimBackground implements IGuardInterface {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final TrimBackground f261998d = new TrimBackground();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile long backgroundTs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean checked;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mmkvTrimWhenIdleSwitch;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qmmkv.TrimBackground$mmkvTrimWhenIdleSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
            
                if (((com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager.class)).isSwitchOn("mmkv_trim_when_idle_switch", false) != false) goto L6;
             */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean invoke() {
                boolean z16;
                if (!AppSetting.s()) {
                    z16 = false;
                }
                z16 = true;
                QLog.d("TrimBackground", 1, "init mmkvTrimWhenIdleSwitch = " + z16);
                return Boolean.valueOf(z16);
            }
        });
        mmkvTrimWhenIdleSwitch = lazy;
    }

    TrimBackground() {
    }

    private final Set<MMKVOptionEntity> d() {
        HashSet hashSet;
        try {
            Field declaredField = QMMKV.class.getDeclaredField("mmapName2Entity");
            Intrinsics.checkNotNullExpressionValue(declaredField, "qmmkvClass.getDeclaredField(\"mmapName2Entity\")");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<kotlin.String, com.tencent.mobileqq.qmmkv.MMKVOptionEntity>");
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj;
            if (QLog.isDevelopLevel()) {
                QLog.d("TrimBackground", 4, "getOpenedMmkvs " + concurrentHashMap.size() + MsgSummary.STR_COLON + concurrentHashMap.keySet());
            }
            Collection values = concurrentHashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "map.values");
            hashSet = CollectionsKt___CollectionsKt.toHashSet(values);
            return hashSet;
        } catch (IllegalAccessException e16) {
            QLog.e("TrimBackground", 1, "getOpenedMmkvs exception ", e16.getMessage(), e16);
            QLog.e("TrimBackground", 1, "getOpenedMmkvs failed. ");
            return null;
        } catch (NoSuchFieldException e17) {
            QLog.e("TrimBackground", 1, "getOpenedMmkvs exception ", e17.getMessage(), e17);
            QLog.e("TrimBackground", 1, "getOpenedMmkvs failed. ");
            return null;
        } catch (Exception e18) {
            QLog.e("TrimBackground", 1, "getOpenedMmkvs exception ", e18.getMessage(), e18);
            QLog.e("TrimBackground", 1, "getOpenedMmkvs failed. ");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TrimBackground this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f261998d.c()) {
            GuardManagerCallbackDispatcher.registerCallBack(this$0);
        }
    }

    private final void g() {
        boolean z16;
        int i3;
        Set<MMKVOptionEntity> d16 = d();
        if (d16 == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(1024);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<MMKVOptionEntity> it = d16.iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            MMKVOptionEntity next = it.next();
            if (backgroundTs == 0) {
                break;
            }
            try {
                j(next, sb5);
            } catch (Throwable th5) {
                QLog.e("TrimBackground", 1, th5.getMessage(), th5);
            }
        }
        if (backgroundTs != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        if (i3 != 0) {
            QMMKV.from(BaseApplication.context, "common_mmkv_configurations").encodeLong("TrimBackground_ts", elapsedRealtime2);
        }
        if (sb5.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            HashMap<String, String> hashMap = new HashMap<>();
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            hashMap.put("data", sb6);
            hashMap.put("complete", String.valueOf(i3));
            hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(elapsedRealtime2 - elapsedRealtime));
            StatisticCollector.getInstance(BaseApplication.context).collectPerformance(null, "actMMKVTrimReport", true, 0L, 0L, hashMap, "");
        }
    }

    private final void h(long tick) {
        if (c() && !checked && SystemClock.elapsedRealtime() - backgroundTs >= 180000) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TrimBackground", 2, "onBackgroundTimeTick " + tick);
            }
            checked = true;
            long elapsedRealtime = SystemClock.elapsedRealtime() - QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeLong("TrimBackground_ts", 0L);
            boolean z16 = false;
            if (0 <= elapsedRealtime && elapsedRealtime < 3600000) {
                z16 = true;
            }
            if (z16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TrimBackground", 2, "onBackgroundTimeTick return by time interval.");
                    return;
                }
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.ab
                @Override // java.lang.Runnable
                public final void run() {
                    TrimBackground.i();
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        boolean z16;
        if (backgroundTs != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            f261998d.g();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (backgroundTs != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("TrimBackground", 1, "trim cost: " + currentTimeMillis2 + "ms completed:" + z16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
    
        if ((r14 / r12) <= 0.3499999940395355d) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(MMKVOptionEntity kv5, StringBuilder sb5) {
        String str;
        String mmapId = kv5.mmapId();
        if (!kv5.isAccessible()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TrimBackground", 4, "mmkvTrim [" + mmapId + "] skip cause of not accessible.");
                return;
            }
            return;
        }
        long decodeLong = kv5.decodeLong("TrimBackground_ts_single", 0L);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - decodeLong;
        boolean z16 = false;
        if (0 <= j3 && j3 < 86400000) {
            z16 = true;
        }
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TrimBackground", 4, "trimFile [" + mmapId + "] skip cause of time interval.");
                return;
            }
            return;
        }
        long j16 = kv5.totalSize();
        if (j16 >= VasBusiness.CHAT_FONT_SWITCH) {
            long j17 = kv5.totalSize();
            long actualSize = j17 - kv5.actualSize();
            if (actualSize > 0) {
                str = "TrimBackground";
            } else {
                str = "TrimBackground";
            }
            if (actualSize < 67108864) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(str, 1, "trimFile [" + mmapId + "] size:" + j17 + " expand: " + actualSize + " no need to trim. ");
                    return;
                }
                return;
            }
            kv5.trim();
            long j18 = kv5.totalSize();
            QLog.w(str, 1, "trimFile [" + mmapId + "] [" + j17 + " -> " + j18 + "] expand:" + actualSize + " " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
            sb5.append(mmapId);
            sb5.append(",");
            sb5.append(j17);
            sb5.append(",");
            sb5.append(j18);
            sb5.append("|");
            kv5.encodeLong("TrimBackground_ts_single", elapsedRealtime);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TrimBackground", 1, "trimFile [" + mmapId + "] " + (j16 >>> 20) + " Mb ignore.");
        }
    }

    public final boolean c() {
        return ((Boolean) mmkvTrimWhenIdleSwitch.getValue()).booleanValue();
    }

    public final void e() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qmmkv.aa
            @Override // java.lang.Runnable
            public final void run() {
                TrimBackground.f(TrimBackground.this);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        backgroundTs = SystemClock.elapsedRealtime();
        checked = false;
        if (QLog.isDevelopLevel()) {
            QLog.d("TrimBackground", 2, "onApplicationBackground");
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        backgroundTs = 0L;
        if (QLog.isDevelopLevel()) {
            QLog.d("TrimBackground", 2, "onApplicationForeground");
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long tick) {
        h(tick);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long tick) {
        h(tick);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long tick) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean isEnabled) {
    }
}
