package com.tencent.state.square.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/api/ResultCallback;", "T", "", "onResultFailure", "", "error", "", "message", "", "onResultSuccess", "result", "(Ljava/lang/Object;)V", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ResultCallback<T> {
    void onResultFailure(int error, @Nullable String message);

    void onResultSuccess(T result);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onResultFailure$default(ResultCallback resultCallback, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = null;
                }
                resultCallback.onResultFailure(i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResultFailure");
        }

        public static <T> void onResultFailure(@NotNull ResultCallback<T> resultCallback, int i3, @Nullable String str) {
        }
    }
}
