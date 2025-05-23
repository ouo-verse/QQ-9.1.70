package com.tencent.mobileqq.winkpublish.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes21.dex */
public @interface IToastStatusType {
    public static final int TOAST_STATUS_NO_POP = 1;
    public static final int TOAST_STATUS_POPPED = 2;
    public static final int TOAST_STATUS_UN_DEFINED = 0;
}
