package com.tencent.state.square;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/SquareLogger;", "", "d", "", "tag", "", "message", "e", "throwable", "", "i", "isColorLevel", "", "w", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface SquareLogger {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void e$default(SquareLogger squareLogger, String str, String str2, Throwable th5, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    th5 = null;
                }
                squareLogger.e(str, str2, th5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }
    }

    void d(@NotNull String tag, @Nullable String message);

    void e(@NotNull String tag, @Nullable String message, @Nullable Throwable throwable);

    void i(@NotNull String tag, @Nullable String message);

    boolean isColorLevel();

    void w(@NotNull String tag, @Nullable String message);
}
