package com.tencent.state.service;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/service/ResultCallback;", "T", "", "onResultFailure", "", "error", "", "message", "", "prompt", "onResultSuccess", "result", "(Ljava/lang/Object;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface ResultCallback<T> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static <T> void onResultFailure(ResultCallback<T> resultCallback, int i3, String str) {
        }

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

        public static <T> void onResultFailure(ResultCallback<T> resultCallback, int i3, String str, String str2) {
            resultCallback.onResultFailure(i3, str);
        }

        public static /* synthetic */ void onResultFailure$default(ResultCallback resultCallback, int i3, String str, String str2, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = null;
                }
                if ((i16 & 4) != 0) {
                    str2 = null;
                }
                resultCallback.onResultFailure(i3, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResultFailure");
        }
    }

    void onResultFailure(int error, String message);

    void onResultFailure(int error, String message, String prompt);

    void onResultSuccess(T result);
}
