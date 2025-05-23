package com.tencent.mobileqq.app.identity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface IdentityState {
    public static final int ABTEST = 5;
    public static final int AUTHENTICATED = 0;
    public static final int CANCEL = 3;
    public static final int EXCEEDED = 1;
    public static final int LIMITATIONS = 2;
    public static final int STRATEGY = 4;
}
