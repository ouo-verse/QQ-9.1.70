package com.qq.e.tg.splash;

import android.text.TextUtils;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.ArrayUtilStub;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class TGSplashBackupOrderHolder {

    /* renamed from: a, reason: collision with root package name */
    private static volatile TGSplashBackupOrderHolder f40783a;

    /* renamed from: b, reason: collision with root package name */
    private volatile TGSplashPreCacheResult f40784b;

    /* renamed from: c, reason: collision with root package name */
    private volatile TGSplashPreCacheResult f40785c;

    /* renamed from: d, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, List<PreCacheSplashAd>> f40786d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f40787e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final Object f40788f = new Object();

    TGSplashBackupOrderHolder() {
    }

    public static TGSplashBackupOrderHolder getInstance() {
        if (f40783a == null) {
            synchronized (TGSplashBackupOrderHolder.class) {
                if (f40783a == null) {
                    f40783a = new TGSplashBackupOrderHolder();
                }
            }
        }
        return f40783a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PreCacheSplashAd a() {
        if (this.f40784b != null) {
            return this.f40784b.getPreCacheSplashAd();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashBackupOrderHolder.2
            @Override // java.lang.Runnable
            public void run() {
                if (TGSplashBackupOrderHolder.this.f40786d != null) {
                    TGSplashBackupOrderHolder.this.f40786d.clear();
                }
            }
        });
        synchronized (this.f40787e) {
            if (this.f40784b != null) {
                this.f40784b = null;
            }
        }
        synchronized (this.f40788f) {
            if (this.f40785c != null) {
                this.f40785c = null;
            }
        }
    }

    public final void cacheBackupOrder(PreCacheSplashAd preCacheSplashAd) {
        if (preCacheSplashAd == null) {
            GDTLogger.e("TGSplashBackupOrderHolder [cacheBackupOrder] error null data");
            return;
        }
        synchronized (this.f40787e) {
            this.f40784b = new TGSplashPreCacheResult();
            this.f40784b.setPreCacheSplashAd(preCacheSplashAd);
        }
    }

    public final void cacheEmptyOrder(PreCacheSplashAd preCacheSplashAd) {
        if (preCacheSplashAd == null) {
            GDTLogger.e("TGSplashBackupOrderHolder [cacheEmptyOrder] error null data");
            return;
        }
        synchronized (this.f40788f) {
            this.f40785c = new TGSplashPreCacheResult();
            this.f40785c.setPreCacheSplashAd(preCacheSplashAd);
        }
    }

    public final void cacheOrderListByDate(final List<PreCacheSplashAd> list, final String str) {
        if (!ArrayUtilStub.isNullOrEmpty(list) && !TextUtils.isEmpty(str)) {
            GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashBackupOrderHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(str, list);
                    if (TGSplashBackupOrderHolder.this.f40786d == null) {
                        TGSplashBackupOrderHolder.this.f40786d = concurrentHashMap;
                    } else {
                        TGSplashBackupOrderHolder.this.f40786d.putAll(concurrentHashMap);
                    }
                }
            });
        } else {
            GDTLogger.e("TGSplashBackupOrderHolder [cacheOrderListByDate] error null data");
        }
    }

    public final TGSplashPreCacheResult getBackupSplashPreCacheResult() {
        if (this.f40784b != null && this.f40784b.getPreCacheSplashAd() != null) {
            synchronized (this.f40787e) {
                if (this.f40784b != null && this.f40784b.getPreCacheSplashAd() != null) {
                    boolean isInEnableTime = this.f40784b.getPreCacheSplashAd().isInEnableTime();
                    GDTLogger.i("TGSplashBackupOrderHolder [getBackupSplashPreCacheResult] isInEnableTime :" + isInEnableTime);
                    if (!isInEnableTime) {
                        return null;
                    }
                    return this.f40784b;
                }
                GDTLogger.e("TGSplashBackupOrderHolder [getBackupSplashPreCacheResult] error null data");
                return null;
            }
        }
        GDTLogger.e("TGSplashBackupOrderHolder [getBackupSplashPreCacheResult] error null data");
        return null;
    }

    public final PreCacheSplashAd getCachedEmptyOrder() {
        if (this.f40785c != null && this.f40785c.getPreCacheSplashAd() != null) {
            synchronized (this.f40788f) {
                if (this.f40785c != null && this.f40785c.getPreCacheSplashAd() != null) {
                    return this.f40785c.getPreCacheSplashAd();
                }
                GDTLogger.e("TGSplashBackupOrderHolder [getEmptyOrder] error null data");
                return null;
            }
        }
        GDTLogger.e("TGSplashBackupOrderHolder [getEmptyOrder] error null data");
        return null;
    }

    public final List<PreCacheSplashAd> getCachedOrdersByDate(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "TGSplashBackupOrderHolder [getCachedOrdersByDate] error isEmpty(date)";
        } else {
            ConcurrentHashMap<String, List<PreCacheSplashAd>> concurrentHashMap = this.f40786d;
            if (concurrentHashMap == null) {
                str2 = "TGSplashBackupOrderHolder [getCachedOrdersByDate] error mOrdersByDate null";
            } else {
                return concurrentHashMap.get(str);
            }
        }
        GDTLogger.e(str2);
        return null;
    }
}
