package com.tencent.biz.richframework.util;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/richframework/util/RFWDeviceUtil;", "", "", "isHuaWei", "isHonor", "isXiaoMi", "isX86Emulator$delegate", "Lkotlin/Lazy;", "isX86Emulator", "()Z", "", "cpuAbiName$delegate", "getCpuAbiName", "()Ljava/lang/String;", "cpuAbiName", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWDeviceUtil {

    @NotNull
    public static final RFWDeviceUtil INSTANCE = new RFWDeviceUtil();

    /* renamed from: cpuAbiName$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy cpuAbiName;

    /* renamed from: isX86Emulator$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy isX86Emulator;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.biz.richframework.util.RFWDeviceUtil$isX86Emulator$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                boolean contains$default;
                boolean contains$default2;
                String model = DeviceInfoMonitor.getModel();
                Intrinsics.checkNotNullExpressionValue(model, "Build.MODEL");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) model, (CharSequence) "Android SDK built for x86", false, 2, (Object) null);
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) RFWDeviceUtil.INSTANCE.getCpuAbiName(), (CharSequence) ResourceAttributes.HostArchValues.X86, false, 2, (Object) null);
                if (contains$default2) {
                    return true;
                }
                return contains$default;
            }
        });
        isX86Emulator = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.biz.richframework.util.RFWDeviceUtil$cpuAbiName$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str;
                Object invoke;
                try {
                    invoke = SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI);
                } catch (Exception e16) {
                    RFWLog.e("RFWDeviceUtil", RFWLog.USR, "[getCpuAbiName] error:", e16.getMessage());
                    str = "";
                }
                if (invoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                str = (String) invoke;
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String str2 = Build.CPU_ABI;
                Intrinsics.checkNotNullExpressionValue(str2, "Build.CPU_ABI");
                return str2;
            }
        });
        cpuAbiName = lazy2;
    }

    RFWDeviceUtil() {
    }

    @NotNull
    public final String getCpuAbiName() {
        return (String) cpuAbiName.getValue();
    }

    public final boolean isHonor() {
        String str = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str, "Build.BRAND");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        if (str != null) {
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return Intrinsics.areEqual(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, upperCase);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean isHuaWei() {
        String str = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str, "Build.BRAND");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        if (str != null) {
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return Intrinsics.areEqual("HUAWEI", upperCase);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean isX86Emulator() {
        return ((Boolean) isX86Emulator.getValue()).booleanValue();
    }

    public final boolean isXiaoMi() {
        String str = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str, "Build.BRAND");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        if (str != null) {
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return Intrinsics.areEqual("XIAOMI", upperCase);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
