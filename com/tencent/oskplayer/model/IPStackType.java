package com.tencent.oskplayer.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes22.dex */
public @interface IPStackType {
    public static final int DUAL = 3;
    public static final int IPV4 = 1;
    public static final int IPV6 = 2;
    public static final int NONE = 0;
    public static final int NOT_SET = -1;
}
