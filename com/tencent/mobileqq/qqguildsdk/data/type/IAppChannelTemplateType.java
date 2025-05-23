package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IAppChannelTemplateType {
    public static final int DEFAULT_TEMPLATE_ID = 1;
    public static final int PLAY_TEMPLATE_ID = 2;
    public static final int UNSPECIFIED = 0;
}
