package com.tencent.state.square;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/DefaultSquareLogger;", "Lcom/tencent/state/square/SquareLogger;", "()V", "d", "", "tag", "", "message", "e", "throwable", "", "i", "isColorLevel", "", "w", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareLogger implements SquareLogger {
    @Override // com.tencent.state.square.SquareLogger
    public void d(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (message != null) {
            Log.d(tag, message);
        }
    }

    @Override // com.tencent.state.square.SquareLogger
    public void e(@NotNull String tag, @Nullable String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (message != null) {
            if (throwable == null) {
                Log.e(tag, message);
            } else {
                Log.e(tag, message, throwable);
            }
        }
    }

    @Override // com.tencent.state.square.SquareLogger
    public void i(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (message != null) {
            Log.i(tag, message);
        }
    }

    @Override // com.tencent.state.square.SquareLogger
    public boolean isColorLevel() {
        return true;
    }

    @Override // com.tencent.state.square.SquareLogger
    public void w(@NotNull String tag, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (message != null) {
            Log.w(tag, message);
        }
    }
}
