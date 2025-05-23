package com.tencent.qqlive.tvkplayer.qqliveasset.trigger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes23.dex */
public interface ITVKPlayerTrigger {

    /* loaded from: classes23.dex */
    public static class FunctionStateMatcher {

        @Nullable
        private final ITVKFunction mFunction;

        @Nullable
        private final ITVKStateMatcher mStateMatcher;

        public FunctionStateMatcher(@Nullable ITVKFunction iTVKFunction, @Nullable ITVKStateMatcher iTVKStateMatcher) {
            this.mFunction = iTVKFunction;
            this.mStateMatcher = iTVKStateMatcher;
        }

        @Nullable
        public ITVKFunction getFunction() {
            return this.mFunction;
        }

        @Nullable
        public ITVKStateMatcher getStateMatcher() {
            return this.mStateMatcher;
        }
    }

    @Nullable
    Object executeFunction(@NonNull ITVKFunction iTVKFunction, @NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception;

    @NonNull
    List<ITVKFunction> findConsumeNotificationFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr);

    FunctionStateMatcher findExecuteFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr);

    @Nullable
    ITVKFunction findTakeOverFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr);

    void reset();
}
