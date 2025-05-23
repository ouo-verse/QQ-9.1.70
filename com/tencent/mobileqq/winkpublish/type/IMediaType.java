package com.tencent.mobileqq.winkpublish.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes21.dex */
public @interface IMediaType {
    public static final int MEDIA_TYPE_CAMERA = 2;
    public static final int MEDIA_TYPE_IMAGE = 0;
    public static final int MEDIA_TYPE_NONE = -1;
    public static final int MEDIA_TYPE_VIDEO = 1;
}
