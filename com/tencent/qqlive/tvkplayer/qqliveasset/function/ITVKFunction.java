package com.tencent.qqlive.tvkplayer.qqliveasset.function;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKFunction {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface FunctionType {
        public static final int TYPE_ACCOMPANY = 0;
        public static final int TYPE_INTERRUPT = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface TargetAssetType {
        public static final int TYPE_NESTED_M3U8 = 1;
        public static final int TYPE_REGULAR = 2;
        public static final int TYPE_UNIVERSAL = 0;
    }

    void cancel();

    boolean consumeNotification(@NonNull Method method, Object... objArr);

    Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception;

    Object[] getCurrentTriggerArgs();

    Method getCurrentTriggerMethod();

    @NonNull
    List<TVKMethodMatcher> getNotificationMatcherList();

    @NonNull
    List<TVKMethodMatcher> getTakeOverMethodMatcherList();

    int getTargetAssetType();

    @NonNull
    List<TVKMethodMatcher> getTriggerMatcherList() throws IllegalStateException;

    int getType();

    void reset();

    void setOnCompleteListener(ITVKOnFunctionCompleteListener iTVKOnFunctionCompleteListener);

    Object takeOverMethod(@NonNull Method method, Object... objArr);
}
