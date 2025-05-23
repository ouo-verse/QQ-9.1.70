package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l implements Manager {

    /* renamed from: d, reason: collision with root package name */
    int f179751d;

    /* renamed from: e, reason: collision with root package name */
    int f179752e;

    /* renamed from: f, reason: collision with root package name */
    Set<String> f179753f = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    boolean f179754h = false;

    public static l a(QQAppInterface qQAppInterface) {
        l lVar = (l) qQAppInterface.getManager(QQManagerFactory.PHOTOLIST_CONFIG_MANAGER);
        lVar.c(qQAppInterface);
        return lVar;
    }

    public static int b(Context context, String str) {
        return context.getSharedPreferences("PhotoListConfig" + str, 0).getInt("k_version", 0);
    }

    @TargetApi(14)
    private synchronized void c(QQAppInterface qQAppInterface) {
        if (!this.f179754h) {
            this.f179754h = true;
            SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences("PhotoListConfig" + qQAppInterface.getCurrentAccountUin(), 0);
            this.f179751d = sharedPreferences.getInt("k_s", 0);
            this.f179752e = sharedPreferences.getInt("k_w", 0);
            this.f179753f = sharedPreferences.getStringSet("k_b_l", null);
            QLog.i("PhotoListConfig", 1, "init size:" + this.f179751d + " width:" + this.f179752e + " black:" + this.f179753f);
        }
    }

    public static void d(Context context, String str, int i3) {
        context.getSharedPreferences("PhotoListConfig" + str, 0).edit().putInt("k_version", i3).apply();
    }

    @TargetApi(14)
    public synchronized void e(QQAppInterface qQAppInterface, int i3, int i16, Set<String> set) {
        this.f179751d = i3;
        this.f179752e = i16;
        this.f179753f = set;
        qQAppInterface.getApp().getSharedPreferences("PhotoListConfig" + qQAppInterface.getCurrentAccountUin(), 0).edit().putInt("k_s", i3).putInt("k_w", i16).putStringSet("k_b_l", set).apply();
        QLog.i("PhotoListConfig", 1, "updateConfig size:" + this.f179751d + " width:" + this.f179752e + " black:" + set);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
