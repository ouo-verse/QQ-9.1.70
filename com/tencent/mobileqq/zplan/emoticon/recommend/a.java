package com.tencent.mobileqq.zplan.emoticon.recommend;

import android.os.Build;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ad;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import t74.c;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/recommend/a;", "", "", "c", "a", "d", "e", "b", "Lcom/tencent/sqshow/utils/featureswitch/model/ad;", "Lcom/tencent/sqshow/utils/featureswitch/model/ad;", DownloadInfo.spKey_Config, "", "D", "memory", "", "I", "apiLevel", "", "Ljava/lang/String;", "model", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f333316a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ad config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static double memory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int apiLevel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String model;

    static {
        ad adVar = (ad) ZPlanQQMC.INSTANCE.getConfig("zplan_recommend_record_config", new ad());
        config = adVar;
        memory = -1.0d;
        apiLevel = -1;
        QLog.i("RecommendDeviceChecker", 1, "RecommendDeviceChecker, config: " + adVar);
    }

    a() {
    }

    private final boolean a() {
        if (apiLevel < 0) {
            int i3 = Build.VERSION.SDK_INT;
            apiLevel = i3;
            QLog.i("RecommendDeviceChecker", 1, "RecommendDeviceChecker, apiLevel: " + i3);
        }
        return apiLevel >= config.getApiLevel();
    }

    private final boolean c() {
        if (memory < 0.0d) {
            double ceil = Math.ceil(c.b() / 1024.0d);
            memory = ceil;
            QLog.i("RecommendDeviceChecker", 1, "RecommendDeviceChecker, memory: " + ceil);
        }
        return memory >= ((double) config.getMemory());
    }

    private final boolean d() {
        boolean equals;
        String str = model;
        if (str == null || str.length() == 0) {
            String model2 = DeviceInfoMonitor.getModel();
            model = model2;
            QLog.i("RecommendDeviceChecker", 1, "RecommendDeviceChecker, model: " + model2);
        }
        Iterator<String> it = config.d().iterator();
        while (it.hasNext()) {
            equals = StringsKt__StringsJVMKt.equals(model, it.next(), true);
            if (equals) {
                return false;
            }
        }
        return true;
    }

    public final boolean b() {
        return config.getEnable();
    }

    public final boolean e() {
        AppRuntime peekAppRuntime;
        try {
            if (!b() || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
                return false;
            }
            ZplanDataRepository zplanDataRepository = ZplanDataRepository.f334898a;
            String currentUin = peekAppRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
            if (ZplanDataRepository.l(zplanDataRepository, currentUin, false, 2, null).hasCustomDressUp() && a() && d()) {
                return c();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
