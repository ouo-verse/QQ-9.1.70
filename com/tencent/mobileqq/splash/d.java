package com.tencent.mobileqq.splash;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static long a() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeLong(account + g.a() + "ams_hot_splash_download_nonvideo_time_key", 0L);
    }

    public static long b() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeLong(account + g.a() + "ams_hot_splash_download_video_time_key", 0L);
    }

    public static void c() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        String str = account + g.a() + "ams_hot_splash_download_nonvideo_time_key";
        from.encodeLong(str, from.decodeLong(str, 0L) + 1);
    }

    public static void d() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        String str = account + g.a() + "ams_hot_splash_download_video_time_key";
        from.encodeLong(str, from.decodeLong(str, 0L) + 1);
    }
}
