package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IAddFriendVerifyType {
    public static final int ADD_ANSWER = 3;
    public static final int ADD_ANSWER_VERIFY = 4;
    public static final int ADD_VERIFY_NEED = 1;
    public static final int ADD_VERIFY_NO = 0;
    public static final int ADD_VERIFY_REFUSE = 2;
}
