package com.tencent.mobileqq.winkpublish.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes21.dex */
public @interface IDraftFromType {
    public static final int DRAFT_FROM_EDIT_PAGE = 4;
    public static final int DRAFT_FROM_PAUSE = 2;
    public static final int DRAFT_FROM_PUBLISH = 3;
    public static final int DRAFT_FROM_PUBLISH_PAGE = 5;
    public static final int DRAFT_FROM_SAVE = 1;
}
