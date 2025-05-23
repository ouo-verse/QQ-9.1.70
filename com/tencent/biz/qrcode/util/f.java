package com.tencent.biz.qrcode.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static long f95059a;

    public static boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aigc_qrcode_card", false);
    }

    public static synchronized boolean b() {
        synchronized (f.class) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - f95059a;
            if (0 < j3 && j3 < 1000) {
                return true;
            }
            f95059a = currentTimeMillis;
            return false;
        }
    }

    public static void c(Intent intent, Context context) {
        if (b()) {
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtras(intent);
        intent2.addFlags(268435456);
        QPublicFragmentActivity.start(context, intent2, QRDisplayMyCardFragment.class);
    }
}
