package com.tencent.mobileqq.tvideo.account.tenvideo.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes19.dex */
public @interface VideoLoginConstants$VBRefreshPriority {
    public static final int PRIORITY_MANUAL = 0;
    public static final int PRIORITY_REFRESH_FOR_LOCAL = 3;
    public static final int PRIORITY_SERVICE_AUTO = 2;
    public static final int PRIORITY_USER_AUTO = 1;
}
