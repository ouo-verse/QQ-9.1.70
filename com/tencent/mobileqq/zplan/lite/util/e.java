package com.tencent.mobileqq.zplan.lite.util;

import android.os.Build;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentBaseConfigParser;
import com.tencent.mobileqq.zplan.lite.util.ZPlanFilamentSceneConfigParser;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ah;
import com.tencent.sqshow.utils.featureswitch.model.z;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.lang.JoinPoint;
import tl.h;
import uk3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004J\u0014\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017J\u0014\u0010\u001b\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u001c\u001a\u00020\u0006R*\u0010#\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010)\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/util/e;", "", "Lcom/tencent/sqshow/utils/featureswitch/model/z;", DownloadInfo.spKey_Config, "", "scene", "", "d", "Lcom/tencent/sqshow/utils/featureswitch/model/ah;", h.F, "g", "Lwk3/h;", "k", "i", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "configApiLevel", "a", "", "", "configModelBlackList", "b", "", "configMemory", "e", "congfigGPUBlackList", "c", "f", "value", "Lwk3/h;", "getBaseConfig", "()Lwk3/h;", "o", "(Lwk3/h;)V", "baseConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/z;", "getSceneConfig", "()Lcom/tencent/sqshow/utils/featureswitch/model/z;", "p", "(Lcom/tencent/sqshow/utils/featureswitch/model/z;)V", "sceneConfig", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f333809a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static wk3.h baseConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static z sceneConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock lock;

    static {
        e eVar = new e();
        f333809a = eVar;
        baseConfig = new wk3.h();
        sceneConfig = new z();
        lock = new ReentrantLock();
        ZPlanFilamentBaseConfigParser.b bVar = (ZPlanFilamentBaseConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("enable_filament_base_config");
        if (bVar == null) {
            bVar = new ZPlanFilamentBaseConfigParser.b(null);
        }
        eVar.o(bVar.getBaseCfg());
        ZPlanFilamentSceneConfigParser.b bVar2 = (ZPlanFilamentSceneConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("enable_filament_scene_config");
        if (bVar2 == null) {
            bVar2 = new ZPlanFilamentSceneConfigParser.b(null);
        }
        eVar.p(bVar2.getSceneCfg());
    }

    e() {
    }

    private final boolean d(z config, int scene) {
        List<Integer> d16 = config.d();
        if (d16.size() == 0) {
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableFilamentOnScene false,scene: " + scene + ", enableScenes null or empty.");
            return false;
        }
        int size = d16.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (d16.get(i3).intValue() == scene) {
                return true;
            }
        }
        return false;
    }

    private final boolean g(ah config) {
        boolean contains;
        List<String> a16 = config.a();
        if (a16.isEmpty()) {
            return true;
        }
        String b16 = t74.d.f435534a.b();
        QLog.i("ZPlanFilamentSwitchUtil", 1, "enableSameStyleModel, gpuName: " + b16);
        int size = a16.size();
        for (int i3 = 0; i3 < size; i3++) {
            contains = StringsKt__StringsKt.contains((CharSequence) b16, (CharSequence) a16.get(i3), true);
            if (contains) {
                QLog.w("ZPlanFilamentSwitchUtil", 1, "GPU: " + b16 + " unavailable.");
                return false;
            }
        }
        return true;
    }

    private final boolean h(ah config) {
        boolean equals;
        String model = DeviceInfoMonitor.getModel();
        QLog.i("ZPlanFilamentSwitchUtil", 1, "enableSameStyleModel, model: " + model);
        Iterator<String> it = config.b().iterator();
        while (it.hasNext()) {
            equals = StringsKt__StringsJVMKt.equals(model, it.next(), true);
            if (equals) {
                QLog.w("ZPlanFilamentSwitchUtil", 1, "model: " + model + " unavailable.");
                return false;
            }
        }
        return true;
    }

    public final boolean a(int configApiLevel) {
        return Build.VERSION.SDK_INT >= configApiLevel;
    }

    public final boolean b(List<String> configModelBlackList) {
        boolean equals;
        Intrinsics.checkNotNullParameter(configModelBlackList, "configModelBlackList");
        String model = DeviceInfoMonitor.getModel();
        Iterator<String> it = configModelBlackList.iterator();
        while (it.hasNext()) {
            equals = StringsKt__StringsJVMKt.equals(model, it.next(), true);
            if (equals) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(List<String> congfigGPUBlackList) {
        boolean contains;
        Intrinsics.checkNotNullParameter(congfigGPUBlackList, "congfigGPUBlackList");
        if (congfigGPUBlackList.isEmpty()) {
            return true;
        }
        String b16 = t74.d.f435534a.b();
        int size = congfigGPUBlackList.size();
        for (int i3 = 0; i3 < size; i3++) {
            contains = StringsKt__StringsKt.contains((CharSequence) b16, (CharSequence) congfigGPUBlackList.get(i3), true);
            if (contains) {
                QLog.w("ZPlanFilamentSwitchUtil", 1, "GPU: " + b16 + " unavailable.");
                return false;
            }
        }
        return true;
    }

    public final boolean e(float configMemory) {
        try {
            double ceil = Math.ceil(t74.c.b() / 1024.0d);
            if (ceil >= configMemory) {
                return true;
            }
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableFilamentWithMemory false, deviceMemory: " + ceil + ", memoryLimit: " + configMemory);
            return false;
        } catch (Exception e16) {
            QLog.e("ZPlanFilamentSwitchUtil", 1, "enableFilamentWithMemory error", e16);
            return false;
        }
    }

    public final boolean f() {
        ah sameStyleConfig = ZPlanQQMC.INSTANCE.getSameStyleConfig();
        QLog.i("ZPlanFilamentSwitchUtil", 1, "enableSameStyleModel, config: " + sameStyleConfig);
        return h(sameStyleConfig) && g(sameStyleConfig);
    }

    public final boolean i(wk3.h config) {
        if (!g.f439121a.i()) {
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentScene false, reason: ZPlan unavailable.");
            return false;
        }
        if (k(config) >= 0) {
            return true;
        }
        QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentScene false, reason: enableZPlanFilamentBaseConfig false.");
        return false;
    }

    public final boolean m(int scene) {
        if (l(scene)) {
            return sceneConfig.getEnableJSApp();
        }
        return false;
    }

    public final boolean n(int scene) {
        if (!l(scene)) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ZPlanFilamentSwitchUtil", 1, "enableZPlanNativeAppFilament, scene: " + scene + ", " + sceneConfig.getEnableNativeApp());
        }
        return sceneConfig.getEnableNativeApp();
    }

    public final void o(wk3.h value) {
        Intrinsics.checkNotNullParameter(value, "value");
        baseConfig = value;
    }

    public final void p(z value) {
        Intrinsics.checkNotNullParameter(value, "value");
        sceneConfig = value;
    }

    public final int k(wk3.h config) {
        if (config == null) {
            config = baseConfig;
        }
        if (!a(config.getApiLevel())) {
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentBaseConfig false, reason: api level limit.");
            return -1;
        }
        if (!b(config.d())) {
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentBaseConfig false, reason: model limit.");
            return -2;
        }
        if (!e(config.getMemory())) {
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentBaseConfig false, reason: memory limit.");
            return -3;
        }
        if (c(config.b())) {
            return 0;
        }
        QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentBaseConfig false, reason: GPU limit.");
        return -4;
    }

    public final boolean l(int scene) {
        if (!j(this, null, 1, null)) {
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentScene false, scene: " + scene + ", reason: enableFilament false.");
            return false;
        }
        if (!sceneConfig.getEnableFilament()) {
            QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentScene false, scene: " + scene + ", reason: enableFilament false.");
            return false;
        }
        if (d(sceneConfig, scene)) {
            return true;
        }
        QLog.w("ZPlanFilamentSwitchUtil", 1, "enableZPlanFilamentScene false, scene: " + scene + ", reason: enableFilamentOnScene false.");
        return false;
    }

    public static /* synthetic */ boolean j(e eVar, wk3.h hVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hVar = null;
        }
        return eVar.i(hVar);
    }
}
