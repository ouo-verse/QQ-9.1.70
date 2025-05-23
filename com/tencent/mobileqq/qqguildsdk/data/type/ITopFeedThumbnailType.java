package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface ITopFeedThumbnailType {
    public static final int THUMBNAIL_TYPE_IMG = 1;
    public static final int THUMBNAIL_TYPE_RESERVE = 0;
    public static final int THUMBNAIL_TYPE_VIDEO = 2;
}
