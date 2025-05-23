package com.qzone.personalize.business;

import android.text.TextUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import yo.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f49172d = new ConcurrentHashMap<>(128);

    /* renamed from: e, reason: collision with root package name */
    private static final String f49173e;

    /* renamed from: f, reason: collision with root package name */
    private static double f49174f;

    /* renamed from: g, reason: collision with root package name */
    private static a f49175g;

    /* renamed from: a, reason: collision with root package name */
    private Lock f49176a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f49177b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f49178c;

    static {
        int i3 = u5.a.f438266d;
        if (i3 >= 560) {
            f49173e = "1242x90";
            f49174f = 0.07246376811594203d;
        } else if (i3 >= 480) {
            f49173e = "960x90";
            f49174f = 0.09375d;
        } else if (i3 >= 320) {
            f49173e = "640x60";
            f49174f = 0.09375d;
        } else if (i3 >= 240) {
            f49173e = "480x46";
            f49174f = 0.09375d;
        } else {
            f49173e = "320x30";
            f49174f = 0.09375d;
        }
        f49175g = null;
    }

    a() {
        c();
    }

    public static String a(String str) {
        String str2 = null;
        if (str.equals("-1")) {
            return null;
        }
        String str3 = f49172d.get(str);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        try {
            String j3 = f.j(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FEED_SKIN_URL, "https://qzonestyle.gtimg.cn/qzone/space_item/feeds/org/{low_id}/{id}/{resolution}_v2.png#kp=1"), "{low_id}", Integer.parseInt(str) % 16), "{id}", Integer.parseInt(str)), "{resolution}", f49173e);
            if (QZLog.isColorLevel()) {
                QZLog.d("FeedSkinDataManager", 2, "@newcard getFeedSkinUrlById url = " + j3);
            }
            str2 = j3;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str2)) {
            f49172d.put(str, str2);
        }
        return str2;
    }

    public static a b() {
        if (f49175g == null) {
            synchronized (a.class) {
                if (f49175g == null) {
                    f49175g = new a();
                }
            }
        }
        return f49175g;
    }

    private void c() {
        this.f49176a = new ReentrantLock();
        this.f49178c = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FEED_SKIN_ENABLE, true);
    }

    public boolean d() {
        return this.f49178c;
    }

    public void e() {
        this.f49178c = LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_FEED_SKIN_ENABLE, true);
    }

    public void f(boolean z16) {
        this.f49177b = z16;
    }
}
