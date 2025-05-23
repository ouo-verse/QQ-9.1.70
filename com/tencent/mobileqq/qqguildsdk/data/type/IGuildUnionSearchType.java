package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGuildUnionSearchType {
    public static final int ALL = 0;
    public static final int FEED = 2;
    public static final int GUILD = 1;
    public static final int LIVE = 3;
    public static final int SCHEDULE = 4;
}
