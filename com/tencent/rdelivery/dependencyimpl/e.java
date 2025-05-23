package com.tencent.rdelivery.dependencyimpl;

import android.util.Log;
import com.tencent.rdelivery.dependency.AbsLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rdelivery/dependencyimpl/e;", "Lcom/tencent/rdelivery/dependency/AbsLog;", "", "tag", "Lcom/tencent/rdelivery/dependency/AbsLog$Level;", "logLevel", "msg", "", "b", "", "throwable", "c", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class e extends AbsLog {
    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void b(@Nullable String tag, @NotNull AbsLog.Level logLevel, @Nullable String msg2) {
        Intrinsics.checkParameterIsNotNull(logLevel, "logLevel");
        int i3 = d.f364238a[logLevel.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            Log.e(tag, msg2);
                            return;
                        }
                        return;
                    }
                    Log.w(tag, msg2);
                    return;
                }
                Log.i(tag, msg2);
                return;
            }
            Log.d(tag, msg2);
            return;
        }
        Log.v(tag, msg2);
    }

    @Override // com.tencent.rdelivery.dependency.AbsLog
    public void c(@Nullable String tag, @NotNull AbsLog.Level logLevel, @Nullable String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(logLevel, "logLevel");
        int i3 = d.f364239b[logLevel.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            Log.e(tag, msg2, throwable);
                            return;
                        }
                        return;
                    }
                    Log.w(tag, msg2, throwable);
                    return;
                }
                Log.i(tag, msg2, throwable);
                return;
            }
            Log.d(tag, msg2, throwable);
            return;
        }
        Log.v(tag, msg2, throwable);
    }
}
