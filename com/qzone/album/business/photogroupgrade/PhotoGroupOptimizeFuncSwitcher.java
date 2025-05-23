package com.qzone.album.business.photogroupgrade;

import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import common.config.service.b;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class PhotoGroupOptimizeFuncSwitcher {

    /* renamed from: a, reason: collision with root package name */
    private static int f42530a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f42531b = "LocalPhotoEventBannerUpload";

    /* renamed from: c, reason: collision with root package name */
    public static String f42532c = "LocalPhotoEventBannerGIFUpload";

    public static boolean a() {
        int i3 = f42530a;
        if (i3 > -1) {
            return i3 == 1;
        }
        int b16 = b.e().b("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_BANNAER_OPTI_SWITCHER, 0);
        f42530a = b16;
        return b16 == 1;
    }

    public static void b(final String str) {
        final HashMap hashMap = new HashMap();
        hashMap.put("value", String.valueOf(a() ? 1 : 0));
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.album.business.photogroupgrade.PhotoGroupOptimizeFuncSwitcher.1
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, true, 0L, 0L, hashMap, null);
            }
        });
    }
}
