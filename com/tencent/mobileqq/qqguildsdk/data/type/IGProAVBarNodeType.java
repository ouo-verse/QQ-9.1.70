package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProAVBarNodeType {
    public static final int BOX = 2000;
    public static final int CAMERA = 5;
    public static final int HAND_UP = 6;
    public static final int HAND_UP_LIST = 7;
    public static final int MIC = 1;
    public static final int SCREEN = 4;
    public static final int SOUND = 2;
    public static final int TEXT = 3;
    public static final int UNKNOWN = 0;
}
