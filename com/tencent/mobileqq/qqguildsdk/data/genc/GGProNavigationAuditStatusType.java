package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes17.dex */
public @interface GGProNavigationAuditStatusType {
    public static final int MANUAL_AUDITING = 4;
    public static final int MANUAL_AUDIT_FAIL = 6;
    public static final int MANUAL_AUDIT_SUCCESS = 5;
    public static final int SECURITY_AUDITING = 2;
    public static final int SECURITY_AUDIT_FAIL = 3;
    public static final int UN_KNOW = 0;
    public static final int WAIT_AUDIT = 1;
}
