package com.tencent.mobileqq.zplan.minixwconnected;

import android.os.Build;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.an;
import com.tencent.sqshow.utils.featureswitch.model.ao;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\u0006R\u001b\u0010\u000f\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/MiniHomeConnectedWhiteList;", "", "", "f", "Lcom/tencent/sqshow/utils/featureswitch/model/an;", DownloadInfo.spKey_Config, "", "b", "c", "e", "d", "a", "Lkotlin/Lazy;", tl.h.F, "()Lcom/tencent/sqshow/utils/featureswitch/model/an;", "xwConnectCfg", "Lcom/tencent/sqshow/utils/featureswitch/model/ao;", "g", "()Lcom/tencent/sqshow/utils/featureswitch/model/ao;", "xwConfigEnable", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectedWhiteList {

    /* renamed from: a, reason: collision with root package name */
    public static final MiniHomeConnectedWhiteList f334443a = new MiniHomeConnectedWhiteList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy xwConnectCfg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy xwConfigEnable;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<an>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedWhiteList$xwConnectCfg$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final an invoke() {
                return ZPlanQQMC.INSTANCE.getXWConnectConfig();
            }
        });
        xwConnectCfg = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ao>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.MiniHomeConnectedWhiteList$xwConfigEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ao invoke() {
                return ZPlanQQMC.INSTANCE.enableXWConnect();
            }
        });
        xwConfigEnable = lazy2;
    }

    MiniHomeConnectedWhiteList() {
    }

    private final boolean b(an config) {
        int i3 = Build.VERSION.SDK_INT;
        boolean z16 = i3 >= config.getApiLevel();
        QLog.w("MiniHomeConnectedWhiteList", 1, "enableFilamentApiLevel " + z16 + ", apiLevel: " + i3 + ", apiLevelLimit: " + config.getApiLevel());
        return z16;
    }

    private final boolean c(an config) {
        boolean equals;
        String model = DeviceInfoMonitor.getModel();
        QLog.w("MiniHomeConnectedWhiteList", 1, "enableFilamentModel, model: " + model);
        Iterator<String> it = config.d().iterator();
        while (it.hasNext()) {
            equals = StringsKt__StringsJVMKt.equals(model, it.next(), true);
            if (equals) {
                return false;
            }
        }
        return true;
    }

    private final boolean d(an config) {
        boolean contains;
        List<String> b16 = config.b();
        if (b16.isEmpty()) {
            return true;
        }
        String b17 = t74.d.f435534a.b();
        int size = b16.size();
        for (int i3 = 0; i3 < size; i3++) {
            contains = StringsKt__StringsKt.contains((CharSequence) b17, (CharSequence) b16.get(i3), true);
            if (contains) {
                QLog.w("MiniHomeConnectedWhiteList", 1, "GPU: " + b17 + " unavailable.");
                return false;
            }
        }
        return true;
    }

    private final boolean e(an config) {
        try {
            double ceil = Math.ceil(t74.c.b() / 1024.0d);
            float memory = config.getMemory();
            if (ceil >= memory) {
                return true;
            }
            QLog.w("MiniHomeConnectedWhiteList", 1, "enableXWConnectFilament false, deviceMemory: " + ceil + ", memoryLimit: " + memory);
            return false;
        } catch (Exception e16) {
            QLog.e("MiniHomeConnectedWhiteList", 1, "enableFilamentWithMemory error", e16);
            return false;
        }
    }

    private final int f() {
        QLog.w("MiniHomeConnectedWhiteList", 1, "ZPlanXWConnectCfg result=" + h());
        if (!b(h())) {
            QLog.w("MiniHomeConnectedWhiteList", 1, "enableXWConnectFilament false, reason: api level limit.");
            return -1;
        }
        if (!c(h())) {
            QLog.w("MiniHomeConnectedWhiteList", 1, "enableXWConnectFilament false, reason: model limit.");
            return -2;
        }
        if (!e(h())) {
            QLog.w("MiniHomeConnectedWhiteList", 1, "enableXWConnectFilament false, reason: memory limit.");
            return -3;
        }
        if (d(h())) {
            return 0;
        }
        QLog.w("MiniHomeConnectedWhiteList", 1, "enableXWConnectFilament false, reason: GPU limit.");
        return -4;
    }

    private final ao g() {
        return (ao) xwConfigEnable.getValue();
    }

    private final an h() {
        return (an) xwConnectCfg.getValue();
    }

    public final boolean a() {
        QLog.w("MiniHomeConnectedWhiteList", 1, "xwConfigEnable value=" + g().getEnable());
        if (!g().getEnable()) {
            return false;
        }
        int f16 = f();
        QLog.w("MiniHomeConnectedWhiteList", 1, "MiniHomeConnectedWhiteList enable=" + f16);
        if (f16 >= 0) {
            return true;
        }
        QLog.w("MiniHomeConnectedWhiteList", 1, "MiniHomeConnectedWhiteList baseCfgRet value false.");
        return false;
    }
}
