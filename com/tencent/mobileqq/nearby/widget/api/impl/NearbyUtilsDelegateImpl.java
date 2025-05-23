package com.tencent.mobileqq.nearby.widget.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.nearby.m;
import com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyUtilsDelegateImpl implements INearbyUtilsDelegate {
    @Override // com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate
    public boolean equalsWithNullCheck(Object obj, Object obj2) {
        return m.a(obj, obj2);
    }

    @Override // com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate
    public boolean isNearbyModule() {
        return m.b();
    }

    @Override // com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate
    public boolean isNetworkConnected(Context context) {
        return m.c(context);
    }

    @Override // com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate
    public void printColorLevelLog(String str, Object... objArr) {
        m.d(str, objArr);
    }

    @Override // com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate
    public void printLog(String str, String str2, Object... objArr) {
        m.e(str, str2, objArr);
    }

    @Override // com.tencent.mobileqq.nearby.widget.api.INearbyUtilsDelegate
    public void startBindPhonePageForResult(Activity activity, int i3) {
        m.f(activity, i3);
    }
}
