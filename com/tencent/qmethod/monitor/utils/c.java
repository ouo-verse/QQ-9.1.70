package com.tencent.qmethod.monitor.utils;

import com.tencent.qmethod.monitor.base.util.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qmethod/monitor/utils/c;", "Lcom/tencent/qmethod/monitor/utils/d;", "", "key", "d", "e", "", "limitCount", "", "b", "a", "c", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f343875a = new c();

    c() {
    }

    private final String d(String key) {
        return key + "_24hours_count";
    }

    private final String e(String key) {
        return key + "_24hours_time";
    }

    @Override // com.tencent.qmethod.monitor.utils.d
    public boolean a(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (DateUtilKt.b(f.b(e(key)))) {
            f.f(d(key), f.b(d(key)) + 1);
            return true;
        }
        f.f(d(key), 1L);
        f.f(e(key), System.currentTimeMillis());
        return true;
    }

    @Override // com.tencent.qmethod.monitor.utils.d
    public boolean b(@NotNull String key, int limitCount) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (DateUtilKt.b(f.b(e(key)))) {
            if (f.b(d(key)) >= limitCount) {
                return true;
            }
        } else if (limitCount <= 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qmethod.monitor.utils.d
    public boolean c(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (DateUtilKt.b(f.b(e(key)))) {
            long b16 = f.b(d(key)) - 1;
            String d16 = d(key);
            if (b16 <= 0) {
                b16 = 0;
            }
            f.f(d16, b16);
            return true;
        }
        return false;
    }
}
