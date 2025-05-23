package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IDirectMsgUserTestGroup {
    public static final int CONTROL_GROUP = 0;
    public static final int TEST_GROUP_1 = 1;
    public static final int TEST_GROUP_2 = 2;
}
