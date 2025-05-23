package com.tencent.qmethod.monitor.base.util;

import com.tencent.qmethod.monitor.utils.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/d;", "", "", "strategyType", "Lcom/tencent/qmethod/monitor/utils/d;", "a", "", "key", "limit", "", "b", "", "d", "e", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f343534a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qmethod/monitor/base/util/d$a", "Lcom/tencent/qmethod/monitor/utils/d;", "", "key", "", "limitCount", "", "b", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a implements com.tencent.qmethod.monitor.utils.d {
        a() {
        }

        @Override // com.tencent.qmethod.monitor.utils.d
        public boolean a(@NotNull String key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return false;
        }

        @Override // com.tencent.qmethod.monitor.utils.d
        public boolean b(@NotNull String key, int limitCount) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return true;
        }

        @Override // com.tencent.qmethod.monitor.utils.d
        public boolean c(@NotNull String key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return d.a.a(this, key);
        }
    }

    d() {
    }

    private final com.tencent.qmethod.monitor.utils.d a(int strategyType) {
        if (strategyType != 1) {
            if (strategyType != 2) {
                if (strategyType != 3) {
                    return new a();
                }
                return com.tencent.qmethod.monitor.utils.b.f343873c;
            }
            return com.tencent.qmethod.monitor.utils.c.f343875a;
        }
        return com.tencent.qmethod.monitor.utils.a.f343870a;
    }

    public static /* synthetic */ boolean c(d dVar, int i3, String str, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 1;
        }
        return dVar.b(i3, str, i16);
    }

    public final boolean b(int strategyType, @NotNull String key, int limit) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return a(strategyType).b(key, limit);
    }

    public final void d(int strategyType, @NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        a(strategyType).a(key);
    }

    public final void e(int strategyType, @NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        a(strategyType).c(key);
    }
}
