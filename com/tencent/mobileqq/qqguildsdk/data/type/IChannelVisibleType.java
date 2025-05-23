package com.tencent.mobileqq.qqguildsdk.data.type;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface IChannelVisibleType {
    public static final int ALL = 1;
    public static final int INVALID = 0;
    public static final int SPECIFIED = 2;

    @Deprecated
    public static final int VISIBLE_ADMIN_ONLY = 2;

    @Deprecated
    public static final int VISIBLE_ALL = 1;

    @Deprecated
    public static final int VISIBLE_INVALID = -1;

    @Deprecated
    public static final int VISIBLE_SPECIFIED = 2;
}
