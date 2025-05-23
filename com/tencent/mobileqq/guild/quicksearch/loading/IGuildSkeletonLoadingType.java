package com.tencent.mobileqq.guild.quicksearch.loading;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes14.dex */
public @interface IGuildSkeletonLoadingType {
    public static final int FEED = 3;
    public static final int LINE_1DP = 1;
    public static final int MSG = 2;
}
