package com.qq.e.comm.plugin.tangramsplash;

import android.text.TextUtils;
import com.qq.e.comm.StubVisitor;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.SplashCustomSettingListener;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.tg.splash.SplashDownloadRes;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f39809a;

    c() {
    }

    public static c a() {
        if (f39809a == null) {
            synchronized (c.class) {
                if (f39809a == null) {
                    f39809a = new c();
                }
            }
        }
        return f39809a;
    }

    public void b() {
        if (SDKStatus.getSDKVersionCode() >= 160) {
            StubVisitor.getInstance().preRequestDNS();
        }
    }

    public boolean a(List<r> list, final boolean z16) {
        if (SDKStatus.getSDKVersionCode() < 70 || !com.qq.e.comm.plugin.j.c.a("nameFileByVideoMD5", 1, 1) || GlobalSetting.getSplashCustomSettingListener() == null) {
            return false;
        }
        SplashCustomSettingListener.DownloadCallback downloadCallback = new SplashCustomSettingListener.DownloadCallback() { // from class: com.qq.e.comm.plugin.tangramsplash.c.1
            @Override // com.qq.e.comm.pi.SplashCustomSettingListener.DownloadCallback
            public void onFailed(SplashDownloadRes splashDownloadRes) {
                String str;
                if (SDKStatus.getSDKVersionCode() >= 80) {
                    str = splashDownloadRes.getCl();
                } else {
                    str = null;
                }
                String str2 = str;
                if (splashDownloadRes.getType() == 1) {
                    com.qq.e.comm.plugin.tangramsplash.c.e.a().a(splashDownloadRes.getUrl(), splashDownloadRes.getName(), true, 1, z16, splashDownloadRes.getPosid(), null, str2, false, -1L, -1L, null);
                } else {
                    com.qq.e.comm.plugin.tangramsplash.c.e.a().a(splashDownloadRes.getUrl(), splashDownloadRes.getName(), true, 2, z16, splashDownloadRes.getPosid(), null, str2, false, -1L, -1L, null);
                }
            }

            @Override // com.qq.e.comm.pi.SplashCustomSettingListener.DownloadCallback
            public void onCanceled() {
            }

            @Override // com.qq.e.comm.pi.SplashCustomSettingListener.DownloadCallback
            public void onComplete() {
            }

            @Override // com.qq.e.comm.pi.SplashCustomSettingListener.DownloadCallback
            public void onPaused() {
            }

            @Override // com.qq.e.comm.pi.SplashCustomSettingListener.DownloadCallback
            public void onStarted() {
            }

            @Override // com.qq.e.comm.pi.SplashCustomSettingListener.DownloadCallback
            public void onProgress(long j3, long j16, int i3) {
            }
        };
        HashMap<String, SplashDownloadRes> hashMap = new HashMap<>();
        for (r rVar : list) {
            a(rVar, hashMap, z16, downloadCallback);
            if (rVar.bI() != null && rVar.bI().size() > 0) {
                Iterator<r.a> it = rVar.bI().iterator();
                while (it.hasNext()) {
                    rVar.a(it.next());
                    a(rVar, hashMap, z16, downloadCallback);
                }
            }
        }
        return StubVisitor.getInstance().setSplashCustomDownloaderListener(new ArrayList(hashMap.values()));
    }

    private void a(r rVar, HashMap<String, SplashDownloadRes> hashMap, boolean z16, SplashCustomSettingListener.DownloadCallback downloadCallback) {
        File a16;
        SplashDownloadRes a17;
        if (rVar == null || hashMap == null) {
            return;
        }
        if (!TextUtils.isEmpty(rVar.s()) && !TextUtils.isEmpty(rVar.h()) && (a17 = com.qq.e.comm.plugin.tangramsplash.d.a.a((a16 = at.a(1, rVar.s(), rVar.h())), rVar, downloadCallback)) != null) {
            hashMap.put(a16.getAbsolutePath(), a17);
        }
        if (TextUtils.isEmpty(rVar.s()) || TextUtils.isEmpty(rVar.x()) || rVar.w() != 1) {
            return;
        }
        File a18 = at.a(2, rVar.s(), TextUtils.isEmpty(rVar.bt()) ? rVar.x() : rVar.bt());
        SplashDownloadRes a19 = com.qq.e.comm.plugin.tangramsplash.d.a.a(a18, rVar, downloadCallback);
        if (a19 != null) {
            hashMap.put(a18.getAbsolutePath(), a19);
        }
    }
}
