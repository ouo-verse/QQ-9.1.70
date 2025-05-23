package com.qzone.commoncode.module.gdt;

import android.content.Intent;
import android.content.SharedPreferences;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.GdtPreLoadOfflinePackageService;

/* loaded from: classes39.dex */
public class GdtPreLoadOfflineHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final Long f46188a = 86400000L;

    /* renamed from: b, reason: collision with root package name */
    private static long f46189b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static com.tencent.mobileqq.hitrate.d f46190c = new com.tencent.mobileqq.hitrate.d("qz_outlink_ad", "com.tencent.mobileqq:qzone");

    private static boolean b() {
        long currentTimeMillis = System.currentTimeMillis() - f46189b;
        Long l3 = f46188a;
        if (currentTimeMillis < l3.longValue()) {
            return true;
        }
        SharedPreferences defaultGlobalPreference = PreferenceManager.getDefaultGlobalPreference(BaseApplication.getContext());
        return defaultGlobalPreference != null && System.currentTimeMillis() - defaultGlobalPreference.getLong("gdtPreLoadOfflinePackageUpdateTime", 0L) < l3.longValue();
    }

    public static void d(final BusinessFeedData businessFeedData) {
        if (businessFeedData.needPreloadOfflienPkg()) {
            ThreadManagerV2.post(new Runnable() { // from class: com.qzone.commoncode.module.gdt.GdtPreLoadOfflineHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtPreLoadOfflineHelper.c(BusinessFeedData.this.getOperationInfo().offlineResourceBid);
                }
            }, 2, null, true);
        }
    }

    private static void e() {
        if (PreferenceManager.getDefaultGlobalPreference(BaseApplication.getContext()) == null) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultGlobalPreference(BaseApplication.getContext()).edit();
        edit.putLong("gdtPreLoadOfflinePackageUpdateTime", System.currentTimeMillis());
        f46189b = System.currentTimeMillis();
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(long j3) {
        if (j3 == 0 || b()) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClass(BaseApplication.context, GdtPreLoadOfflinePackageService.class);
            intent.putExtra("url", "https://gdt.qq.com/2046?_bid=" + j3);
            BaseApplication.getContext().startService(intent);
            e();
            f46190c.a();
        } catch (Exception e16) {
            j.c(GdtPreLoadOfflineHelper.class.getSimpleName(), e16.getMessage());
        }
    }
}
