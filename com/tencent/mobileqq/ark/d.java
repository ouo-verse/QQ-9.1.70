package com.tencent.mobileqq.ark;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f199363d;

    static {
        l91.a.b(true);
    }

    public d(QQAppInterface qQAppInterface) {
        QLog.i("ArkApp", 1, "ArkAppCenter.init");
        this.f199363d = qQAppInterface;
    }

    public static void a(Intent intent) {
        b(intent, null);
    }

    public static void b(Intent intent, String str) {
        if (intent != null) {
            if (TextUtils.isEmpty(str)) {
                str = "biz_src_jc_ark";
            }
            intent.putExtra("big_brother_source_key", str);
        }
    }

    public static void c(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("big_brother_source_key", "biz_src_jc_ark");
        }
    }

    @Deprecated
    public static void d(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
