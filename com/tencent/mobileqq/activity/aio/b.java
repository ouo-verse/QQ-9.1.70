package com.tencent.mobileqq.activity.aio;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f178323a = false;

    public static SharedPreferences a(QQAppInterface qQAppInterface) {
        return qQAppInterface.getApp().getSharedPreferences("sp_aio_input_helper_" + qQAppInterface.getAccount(), 0);
    }

    public static void b() {
        f178323a = true;
        BaseApplication.getContext().getSharedPreferences("sp_upgrade", 0).edit().putBoolean("upgrade", true).commit();
    }
}
