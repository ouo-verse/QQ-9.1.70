package com.tencent.biz.qqcircle.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface QCircleBannerType {
    public static final int BANNER_TYPE_ALBUM = 1;
    public static final int BANNER_TYPE_FREE_FLOW = 2;
}
