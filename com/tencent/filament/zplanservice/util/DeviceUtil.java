package com.tencent.filament.zplanservice.util;

import android.content.Context;
import com.tencent.zplan.device.config.DeviceLevel;
import dl0.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/filament/zplanservice/util/DeviceUtil;", "", "Landroid/content/Context;", "context", "", "d", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldl0/i;", "a", "Lkotlin/Lazy;", "g", "()Ldl0/i;", "systemInfoProxy", "Ldl0/e;", "b", "f", "()Ldl0/e;", "mmkvProxy", "", "c", "e", "()Ljava/lang/String;", "mmkvKeyDeviceLevel", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class DeviceUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy systemInfoProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mmkvProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mmkvKeyDeviceLevel;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final DeviceUtil f106440d = new DeviceUtil();

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.filament.zplanservice.util.DeviceUtil$systemInfoProxy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final i invoke() {
                return (i) fl0.a.f399763a.a(i.class);
            }
        });
        systemInfoProxy = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<dl0.e>() { // from class: com.tencent.filament.zplanservice.util.DeviceUtil$mmkvProxy$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final dl0.e invoke() {
                return (dl0.e) fl0.a.f399763a.a(dl0.e.class);
            }
        });
        mmkvProxy = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.filament.zplanservice.util.DeviceUtil$mmkvKeyDeviceLevel$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                i g16;
                g16 = DeviceUtil.f106440d.g();
                return "device_level_" + (g16 != null ? g16.a() : null);
            }
        });
        mmkvKeyDeviceLevel = lazy3;
    }

    DeviceUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        return (String) mmkvKeyDeviceLevel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final dl0.e f() {
        return (dl0.e) mmkvProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i g() {
        return (i) systemInfoProxy.getValue();
    }

    @Nullable
    public final Object d(@NotNull Context context, @NotNull Continuation<? super Integer> continuation) {
        int level;
        Integer boxInt;
        dl0.e f16 = f();
        if (f16 != null && (boxInt = Boxing.boxInt(f16.getInt(e(), DeviceLevel.UNKNOWN.getLevel()))) != null) {
            level = boxInt.intValue();
        } else {
            level = DeviceLevel.UNKNOWN.getLevel();
        }
        DeviceLevel deviceLevel = DeviceLevel.UNKNOWN;
        if (level != deviceLevel.getLevel()) {
            return Boxing.boxInt(level);
        }
        DeviceLevel a16 = com.tencent.zplan.device.config.a.f385299b.a();
        if (a16 != deviceLevel) {
            dl0.e f17 = f();
            if (f17 != null) {
                f17.setInt(e(), a16.getLevel());
            }
            return Boxing.boxInt(a16.getLevel());
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new DeviceUtil$getDeviceLevel$2(context, null), continuation);
    }
}
