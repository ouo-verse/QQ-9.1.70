package com.tencent.mobileqq.qqgift.callback;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IQQGiftRechargeCallback {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface RechargeCode {
    }

    Map<String, String> a();

    void b(boolean z16, int i3, String str);
}
