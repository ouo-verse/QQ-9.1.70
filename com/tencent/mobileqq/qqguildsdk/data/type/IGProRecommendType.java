package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGProRecommendType {
    public static final int GUILD_ESSENCE = 1;
    public static final int GUILD_HOP = 3;
    public static final int GUILD_TOP = 2;
    public static final int INVALID = 0;
}
