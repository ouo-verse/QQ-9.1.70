package com.tencent.biz.qqcircle.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface QCircleAlbumItemType {
    public static final int ELE_ITEM_TYPE_ICON = 2;
    public static final int ELE_ITEM_TYPE_PRAISE = 4;
    public static final int ELE_ITEM_TYPE_PUSH = 5;
    public static final int ELE_ITEM_TYPE_TEXT = 3;
    public static final int ELE_TYPE_CONTAINER = 1;
}
