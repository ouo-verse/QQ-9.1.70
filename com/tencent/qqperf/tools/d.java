package com.tencent.qqperf.tools;

import android.os.Build;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqperf/tools/d;", "", "", "b", "", "d", "a", "", "c", "I", "deviceLevel", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f363413a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int deviceLevel;

    d() {
    }

    @JvmStatic
    @NotNull
    public static final String b() {
        int a16 = f363413a.a();
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 != 3) {
                    return "Unknown";
                }
                return "Low";
            }
            return "Middle";
        }
        return "High";
    }

    private final int d() {
        int i3;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int i16 = fromV2.getInt("deviceLevel", 0);
        if (i16 == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long m3 = ah.m();
            float f16 = 1024;
            float c16 = ((((float) m.c()) / f16) / f16) / f16;
            int i17 = Build.VERSION.SDK_INT;
            if (i17 >= 31 && m3 >= 2400000 && c16 > 7.0f) {
                i3 = 1;
            } else if (i17 >= 28 && c16 > 4.0f) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            QLog.d("DeviceLevelUtil", 1, "GetDeviceLevel:" + i3 + ", cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", freq:" + m3 + ", memory:" + c16);
            fromV2.putInt("deviceLevel", i3);
            return i3;
        }
        return i16;
    }

    public final int a() {
        if (deviceLevel == 0) {
            deviceLevel = d();
            if (QLog.isColorLevel()) {
                QLog.d("DeviceLevelUtil", 2, "getDeviceLevel:" + deviceLevel);
            }
        }
        return deviceLevel;
    }

    public final boolean c() {
        if (a() == 3) {
            if (com.tencent.mobileqq.startup.a.f289673n >= QQPerfConfigLoader.f257603a.b().c().d()) {
                return true;
            }
            return false;
        }
        if (com.tencent.mobileqq.startup.a.f289673n >= QQPerfConfigLoader.f257603a.b().c().d() / 2) {
            return true;
        }
        return false;
    }
}
