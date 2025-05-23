package com.tencent.qmethod.monitor.base.defaultImpl;

import android.util.Log;
import com.tencent.qmethod.pandoraex.api.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/base/defaultImpl/e;", "Lcom/tencent/qmethod/pandoraex/api/j;", "", "tag", "msg", "", "i", "", "throwable", "d", "e", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class e implements j {
    @Override // com.tencent.qmethod.pandoraex.api.j
    public void d(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        Log.d(tag, msg2);
    }

    @Override // com.tencent.qmethod.pandoraex.api.j
    public void e(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        Log.e(tag, msg2);
    }

    @Override // com.tencent.qmethod.pandoraex.api.j
    public void i(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        Log.i(tag, msg2);
    }

    @Override // com.tencent.qmethod.pandoraex.api.j
    public void d(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        Log.d(tag, msg2, throwable);
    }

    @Override // com.tencent.qmethod.pandoraex.api.j
    public void e(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        Log.e(tag, msg2, throwable);
    }

    @Override // com.tencent.qmethod.pandoraex.api.j
    public void i(@NotNull String tag, @NotNull String msg2, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        Log.i(tag, msg2, throwable);
    }
}
