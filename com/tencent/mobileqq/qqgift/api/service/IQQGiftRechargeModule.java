package com.tencent.mobileqq.qqgift.api.service;

import android.app.Activity;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import java.util.HashMap;
import nh2.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IQQGiftRechargeModule extends a {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public @interface RechargeSource {
    }

    void I(Activity activity, @RechargeSource int i3, boolean z16, IQQGiftRechargeCallback iQQGiftRechargeCallback);

    String U(String str);

    void a(int i3, boolean z16, int i16, String str);

    void d(long j3, long j16);

    void k(HashMap<String, String> hashMap);

    long s();

    long u();

    void y(IVasNativePayManager.PayObserver payObserver);
}
