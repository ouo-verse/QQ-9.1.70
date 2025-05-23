package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IThirdAppInfoSceneType {
    public static final int THIRD_APP_SCENE_COMPLETE = 2;
    public static final int THIRD_APP_SCENE_SIMPLE = 1;
    public static final int THIRD_APP_SCENE_UNKNOWN = 0;
}
