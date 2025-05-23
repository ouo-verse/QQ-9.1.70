package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IGuildShareTargetType {
    public static final int COPY_LINK = 7;
    public static final int FRIEND = 1;

    /* renamed from: GROUP, reason: collision with root package name */
    public static final int f266741GROUP = 2;
    public static final int QZONE = 3;
    public static final int WX_FRIEND = 4;
    public static final int WX_GROUP = 5;
    public static final int WX_MOMENTS = 6;
}
