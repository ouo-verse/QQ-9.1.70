package com.tencent.gamematrix.gmcg.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface GmCgGameTimeInfoType {
    public static final int TypeAccountLess5Mins = 4;
    public static final int TypeFreeTimeOut = 3;
    public static final int TypeLessFiveMins = 2;
    public static final int TypeLessTenMins = 1;
    public static final int TypeTotalLess15Mins = 5;
}
