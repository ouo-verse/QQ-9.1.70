package com.tencent.biz.subscribe.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f96300a;

    public static SharedPreferences a(Context context) {
        if (f96300a == null) {
            if (context == null) {
                QLog.e("SubscribeSpUtil", 2, "getPreference error, context is null");
                return null;
            }
            f96300a = context.getSharedPreferences("biz_subscribe", 0);
        }
        return f96300a;
    }
}
