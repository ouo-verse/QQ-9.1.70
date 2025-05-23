package com.tencent.biz.qqcircle.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
/* loaded from: classes5.dex */
public @interface QFSSwitchDirectionType {
    public static final int BACKWARDS = 1;
    public static final int FORWARDS = 0;
}
