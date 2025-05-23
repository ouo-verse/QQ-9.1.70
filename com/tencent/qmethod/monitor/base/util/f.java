package com.tencent.qmethod.monitor.base.util;

import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\fH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/f;", "", "", "key", "", "b", "c", "value", "", "f", "d", "g", "", "a", "e", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f343536a = new f();

    f() {
    }

    @JvmStatic
    public static final boolean a(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        Boolean d16 = r.d(aVar.g().getContext(), key);
        if (aVar.g().getDebug()) {
            o.a("StorageUtil", "get key=" + key + " value=" + d16);
        }
        Intrinsics.checkExpressionValueIsNotNull(d16, "PandoraExStorage.getBool\u2026)\n            }\n        }");
        return d16.booleanValue();
    }

    @JvmStatic
    public static final long b(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        Long g16 = r.g(aVar.g().getContext(), key);
        if (aVar.g().getDebug()) {
            o.a("StorageUtil", "get key=" + key + " value=" + g16);
        }
        Intrinsics.checkExpressionValueIsNotNull(g16, "PandoraExStorage.getLong\u2026)\n            }\n        }");
        return g16.longValue();
    }

    @JvmStatic
    public static final long c(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        long b16 = b(key);
        f(key, 0L);
        return b16;
    }

    @JvmStatic
    @Nullable
    public static final String d(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        String j3 = r.j(aVar.g().getContext(), key);
        if (aVar.g().getDebug()) {
            o.a("StorageUtil", "get key=" + key + " value=" + j3);
        }
        return j3;
    }

    @JvmStatic
    public static final void e(@NotNull String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        if (!r.m(aVar.g().getContext(), key, Boolean.valueOf(value))) {
            o.a("StorageUtil", "save fail for key=" + key);
            return;
        }
        if (aVar.g().getDebug()) {
            o.a("StorageUtil", "save success for key=" + key + ", value=" + value);
        }
    }

    @JvmStatic
    public static final void f(@NotNull String key, long value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        if (!r.o(aVar.g().getContext(), key, Long.valueOf(value))) {
            o.a("StorageUtil", "save fail for key=" + key);
            return;
        }
        if (aVar.g().getDebug()) {
            o.a("StorageUtil", "save success for key=" + key + ", value=" + value);
        }
    }

    @JvmStatic
    public static final void g(@NotNull String key, @NotNull String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        if (!r.p(aVar.g().getContext(), key, value)) {
            o.a("StorageUtil", "save fail for key=" + key);
            return;
        }
        if (aVar.g().getDebug()) {
            o.a("StorageUtil", "save success for key=" + key + ", value=" + value);
        }
    }
}
