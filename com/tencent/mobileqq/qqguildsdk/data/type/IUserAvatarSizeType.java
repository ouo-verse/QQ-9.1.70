package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IUserAvatarSizeType {
    public static final int AVATAR_SIZE_BIG = 1;
    public static final int AVATAR_SIZE_NOMAL = 0;
    public static final int AVATAR_SIZE_ORIG = 2;
    public static final int AVATAR_SIZE_SMALL = 3;
    public static final int AVATAR_SIZE_VERY_SMALL = 4;
}
