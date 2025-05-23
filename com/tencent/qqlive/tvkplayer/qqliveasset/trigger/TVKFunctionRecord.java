package com.tencent.qqlive.tvkplayer.qqliveasset.trigger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKFunctionRecord {

    @Nullable
    private final Object[] mArgs;

    @NonNull
    private final TVKQQLiveAssetPlayerContext mAssetPlayerContext;

    @NonNull
    private final ITVKFunction mFunction;

    @NonNull
    private final Method mMethod;

    public TVKFunctionRecord(@NonNull ITVKFunction iTVKFunction, @NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mFunction = iTVKFunction;
        this.mMethod = iTVKFunction.getCurrentTriggerMethod();
        this.mArgs = iTVKFunction.getCurrentTriggerArgs();
    }

    @Nullable
    public Object[] getArgs() {
        return this.mArgs;
    }

    @NonNull
    public TVKQQLiveAssetPlayerContext getAssetPlayerContext() {
        return this.mAssetPlayerContext;
    }

    @NonNull
    public ITVKFunction getFunction() {
        return this.mFunction;
    }

    @NonNull
    public Method getMethod() {
        return this.mMethod;
    }

    public TVKFunctionRecord(@NonNull ITVKFunction iTVKFunction, @NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, @Nullable Object[] objArr) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mFunction = iTVKFunction;
        this.mMethod = method;
        this.mArgs = objArr;
    }
}
