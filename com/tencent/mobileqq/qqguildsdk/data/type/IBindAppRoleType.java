package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IBindAppRoleType {
    public static final int APPROLE_BIND = 1;
    public static final int APPROLE_UNBIND = 2;
    public static final int APPROLE_UNKNOWN = 0;
}
