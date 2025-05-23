package com.tencent.qqlive.tvkplayer.qqliveasset.trigger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKMethodMatcher {

    @Nullable
    private final ITVKArgsMatcher mArgsMatcher;

    @NonNull
    private final Method mMethod;

    @Nullable
    private final ITVKStateMatcher mStateMatcher;

    public TVKMethodMatcher(@NonNull Method method, @Nullable ITVKArgsMatcher iTVKArgsMatcher, @Nullable ITVKStateMatcher iTVKStateMatcher) {
        this.mMethod = method;
        this.mArgsMatcher = iTVKArgsMatcher;
        this.mStateMatcher = iTVKStateMatcher;
    }

    private static String getParamTypeNameWithIndex(@NonNull Method method, int i3) {
        if (i3 >= method.getParameterTypes().length) {
            return "";
        }
        return method.getParameterTypes()[i3].getName();
    }

    public static boolean isSameMethod(@NonNull Method method, @NonNull Method method2) {
        if (!method.getName().equals(method2.getName()) || method.getParameterTypes().length != method2.getParameterTypes().length) {
            return false;
        }
        int length = method.getParameterTypes().length;
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                if (!getParamTypeNameWithIndex(method, i3).equals(getParamTypeNameWithIndex(method2, i3))) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Nullable
    public ITVKStateMatcher getStateMatcher() {
        return this.mStateMatcher;
    }

    public boolean isMatch(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, @Nullable Object... objArr) {
        ITVKArgsMatcher iTVKArgsMatcher;
        if (isSameMethod(this.mMethod, method) && ((iTVKArgsMatcher = this.mArgsMatcher) == null || iTVKArgsMatcher.isMatch(tVKQQLiveAssetPlayerContext, objArr))) {
            return true;
        }
        return false;
    }
}
