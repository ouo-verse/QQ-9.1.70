package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IAppChnnJumpType {
    public static final int JUMP_TYPE_APPLETS = 3;
    public static final int JUMP_TYPE_FUTURE = 5;
    public static final int JUMP_TYPE_H5 = 2;
    public static final int JUMP_TYPE_HIPPY = 4;
    public static final int JUMP_TYPE_NATIVE = 1;
    public static final int JUMP_TYPE_USELESS = 0;
}
