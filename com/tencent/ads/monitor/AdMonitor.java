package com.tencent.ads.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ads.data.AdInfo;
import com.tencent.ads.data.AdItem;
import com.tencent.ads.monitor.AdMonitorEvent;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdMonitor implements AdMonitorEvent {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61638a = "AdMonitor";

    /* renamed from: f, reason: collision with root package name */
    private static String f61639f;

    /* renamed from: g, reason: collision with root package name */
    private static String f61640g;

    /* renamed from: h, reason: collision with root package name */
    private static String f61641h;

    /* renamed from: i, reason: collision with root package name */
    private static String f61642i;

    /* renamed from: b, reason: collision with root package name */
    private String f61643b;

    /* renamed from: c, reason: collision with root package name */
    private String f61644c;

    /* renamed from: d, reason: collision with root package name */
    private String f61645d;

    /* renamed from: e, reason: collision with root package name */
    private String f61646e;

    /* renamed from: j, reason: collision with root package name */
    private int f61647j;

    /* renamed from: k, reason: collision with root package name */
    private long f61648k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f61649l;

    /* renamed from: m, reason: collision with root package name */
    private long f61650m;

    /* renamed from: n, reason: collision with root package name */
    private AdInfo f61651n;

    /* renamed from: o, reason: collision with root package name */
    private AdItem f61652o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f61653p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdMonitor(String str) {
        this.f61643b = str;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("reqId is must be not null !!!");
        }
    }

    private long a(AdItem adItem) {
        AdInfo adInfo;
        if (adItem != null && (adInfo = this.f61651n) != null && adInfo.getAdItemArray() != null && this.f61651n.getAdItemArray().length != 0) {
            int i3 = 0;
            for (AdItem adItem2 : this.f61651n.getAdItemArray()) {
                if (adItem2.getOid() != null && adItem2.getOid().equals(adItem.getOid())) {
                    return i3;
                }
                i3 += adItem2.getDuration();
            }
            return 0L;
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0091, code lost:
    
        if (getCurrentAdItemIndex() == 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(boolean z16) {
        AdInfo adInfo = this.f61651n;
        a(((adInfo == null || adInfo.getAdItemArray() == null || this.f61651n.getAdItemArray().length != 0) && z16) ? false : true);
        long j3 = this.f61650m;
        if (j3 > 0) {
            b.a(this, this.f61652o, j3 - a(this.f61652o), true, !z16);
        }
        AdInfo adInfo2 = this.f61651n;
        AdItem adItem = (adInfo2 == null || adInfo2.getAdItemArray() == null || this.f61651n.getAdItemArray().length <= 0) ? null : this.f61651n.getAdItemArray()[0];
        int i3 = this.f61647j;
        Log.d("AdStepPing", "doStepPing: " + i3);
        if (i3 > 0) {
            if (i3 != 200 && i3 != 201) {
                if (i3 != 207) {
                    if (i3 != 208 && i3 != 300 && i3 != 301 && i3 != 605) {
                        switch (i3) {
                        }
                    }
                }
            }
            com.tencent.ads.monitor.a.a.a(this, adItem, i3);
        }
        AdMonitorManager.remove(this);
    }

    public static String getAppVersion() {
        return f61639f;
    }

    public static String getImei() {
        return f61641h;
    }

    public static String getMac() {
        return f61642i;
    }

    public static String getUin() {
        return f61640g;
    }

    public static String getUserCookie(String str) {
        com.tencent.ads.service.b.a();
        String a16 = com.tencent.ads.service.b.a(str);
        Log.i(f61638a, "getUserCookie : " + str);
        Log.d(f61638a, "cookie : " + a16);
        return a16;
    }

    public static void saveCookiePersistent(String str) {
        Log.i(f61638a, "saveCookiePersistent: " + str);
        try {
            new Thread(new a(str)).start();
        } catch (Throwable th5) {
            Log.e(f61638a, th5.getMessage());
        }
    }

    public static void setAppVersion(String str) {
        f61639f = str;
    }

    public static void setImei(String str) {
        f61641h = str;
    }

    public static void setMac(String str) {
        f61642i = str;
    }

    public static void setUin(String str) {
        f61640g = str;
    }

    public static void setUserCookie(String str) {
        Log.i(f61638a, "setUserCookie : " + str);
        saveCookiePersistent(str);
    }

    public String getAId() {
        AdInfo adInfo = this.f61651n;
        if (adInfo != null) {
            return adInfo.getAid();
        }
        return "";
    }

    public AdInfo getAdInfo() {
        return this.f61651n;
    }

    public synchronized boolean getAndSetIsReport(boolean z16) {
        boolean z17;
        z17 = this.f61653p;
        this.f61653p = z16;
        return z17;
    }

    public String getCoverId() {
        return this.f61645d;
    }

    public int getCurrentAdItemIndex() {
        AdInfo adInfo = this.f61651n;
        if (adInfo != null && adInfo.getAdItemArray() != null && this.f61652o != null) {
            for (int i3 = 0; i3 < this.f61651n.getAdItemArray().length; i3++) {
                if (this.f61651n.getAdItemArray()[i3].getOid().equals(this.f61652o.getOid())) {
                    return i3;
                }
            }
        }
        return 0;
    }

    public long getPlayedTime() {
        return this.f61650m;
    }

    public String getRequestId() {
        return this.f61643b;
    }

    public String getTpId() {
        return this.f61646e;
    }

    public String getVideoId() {
        return this.f61644c;
    }

    public boolean isAdRequestStarted() {
        return this.f61648k > 0;
    }

    public boolean isReported() {
        return this.f61653p;
    }

    public boolean isTrueView() {
        return this.f61649l;
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdClick(String str) {
        Log.i(f61638a, "onAdClick : oid[" + str + "]");
        AdItem a16 = a(str);
        if (a16 != null) {
            b.a(a16.getReportClickItems());
            return;
        }
        Log.w(f61638a, "onAdClick : can't find adItem with oid[" + str + "]");
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdItemPlayFinish(String str) {
        Log.i(f61638a, "onAdItemPlayFinish : oid[" + str + "]");
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdItemWillPlay(String str) {
        Log.i(f61638a, "onAdItemWillPlay : oid[" + str + "]");
        AdItem a16 = a(str);
        if (a16 != null) {
            this.f61652o = a16;
        } else {
            Log.w(f61638a, "onAdItemWillPlay : can't find adItem with oid[" + str + "]");
        }
        a(false);
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdPlayFinish() {
        Log.i(f61638a, "onAdPlayFinish");
        if (this.f61653p) {
            Log.w(f61638a, "onAdPlayFinish : You only need to call once #onAdPlaySkip or #onAdPlayFinish.");
        } else {
            this.f61653p = true;
            b(false);
        }
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdPlaySkip(AdMonitorEvent.SkipCause skipCause) {
        Log.i(f61638a, "onAdPlaySkip : " + skipCause);
        if (this.f61653p) {
            Log.w(f61638a, "onAdPlaySkip : You only need to call once #onAdPlaySkip or #onAdPlayFinish.");
            return;
        }
        this.f61653p = true;
        if (skipCause == AdMonitorEvent.SkipCause.USER_RETURN) {
            if (this.f61650m == 0) {
                setErrorCode(208);
            }
        } else if (skipCause == AdMonitorEvent.SkipCause.PLAY_STUCK || skipCause == AdMonitorEvent.SkipCause.PLAY_FAILED) {
            setErrorCode(204);
        }
        b(true);
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdPlaying(long j3) {
        Log.i(f61638a, "onAdPlaying : time[" + j3 + "]");
        this.f61650m = j3;
        AdItem adItem = this.f61652o;
        if (adItem != null) {
            b.a(this, this.f61652o, j3 - a(adItem), false, false);
        }
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdRequestFinish(String str) {
        Log.i(f61638a, "onAdRequestFinish");
        Log.d(f61638a, "resp : " + str);
        this.f61651n = new AdInfo(str);
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onAdRequestStart() {
        Log.i(f61638a, "onAdRequestStart");
        this.f61648k = SystemClock.elapsedRealtime();
    }

    @Override // com.tencent.ads.monitor.AdMonitorEvent
    public void onException(Throwable th5, String str) {
        Log.e(f61638a, "onException: " + str, th5);
        b.a(th5, str);
    }

    public void setAdInfo(AdInfo adInfo) {
        this.f61651n = adInfo;
    }

    public void setCoverId(String str) {
        this.f61645d = str;
    }

    public void setErrorCode(int i3) {
        this.f61647j = i3;
    }

    public void setTpId(String str) {
        this.f61646e = str;
    }

    public void setVideoId(String str) {
        this.f61644c = str;
    }

    private AdItem a(String str) {
        AdInfo adInfo = this.f61651n;
        if (adInfo == null || adInfo.getAdItemArray() == null) {
            return null;
        }
        for (AdItem adItem : this.f61651n.getAdItemArray()) {
            if (adItem.getOid().equals(str)) {
                return adItem;
            }
        }
        return null;
    }

    private void a(boolean z16) {
        AdInfo adInfo = this.f61651n;
        if (adInfo == null || adInfo.getAdEmptyItemList() == null || this.f61651n.getAdEmptyItemList().size() == 0) {
            return;
        }
        if (z16) {
            Log.i(f61638a, "doEmptyPing ping all: " + this.f61651n.getAdEmptyItemList().size());
            Iterator it = this.f61651n.getAdEmptyItemList().iterator();
            while (it.hasNext()) {
                b.a(this, (AdItem) it.next());
            }
            this.f61651n.getAdEmptyItemList().clear();
            return;
        }
        AdItem adItem = this.f61652o;
        if (adItem != null) {
            int lcount = adItem.getLcount();
            String type = this.f61652o.getType();
            Iterator it5 = this.f61651n.getAdEmptyItemList().iterator();
            while (it5.hasNext()) {
                AdItem adItem2 = (AdItem) it5.next();
                int lcount2 = adItem2.getLcount();
                if (type.equals(adItem2.getType()) && lcount2 < lcount) {
                    b.a(this, adItem2);
                    it5.remove();
                }
            }
        }
    }
}
