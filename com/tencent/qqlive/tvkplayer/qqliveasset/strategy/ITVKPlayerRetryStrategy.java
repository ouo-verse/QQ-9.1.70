package com.tencent.qqlive.tvkplayer.qqliveasset.strategy;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes23.dex */
public interface ITVKPlayerRetryStrategy {
    public static final int RETRY_ACTION_CALL_ERROR = 1;
    public static final int RETRY_ACTION_DECREASE_DEFINITION = 2;
    public static final int RETRY_ACTION_DISABLE_FEATURE = 3;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface RetryAction {
    }

    /* loaded from: classes23.dex */
    public static class RetryActionRet {

        @Nullable
        private final Object mExtra;
        private final int mRetryAction;

        public RetryActionRet(int i3, @Nullable Object obj) {
            this.mRetryAction = i3;
            this.mExtra = obj;
        }

        @Nullable
        public Object getExtra() {
            return this.mExtra;
        }

        public int getRetryAction() {
            return this.mRetryAction;
        }
    }

    RetryActionRet getRetryActionForPlayerError(int i3, int i16, int i17);
}
