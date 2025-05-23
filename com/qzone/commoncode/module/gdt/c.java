package com.qzone.commoncode.module.gdt;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f46205b;

    /* renamed from: a, reason: collision with root package name */
    private volatile HashMap<String, d> f46206a;

    c() {
    }

    private static void c(HashMap<String, d> hashMap, List<GdtAdFeedUtil.CarouselCardInfo> list, d dVar) {
        if (list != null && !list.isEmpty()) {
            for (GdtAdFeedUtil.CarouselCardInfo carouselCardInfo : list) {
                if (carouselCardInfo == null) {
                    QZLog.e("GdtVideoPCDNManagerForQZone", "[addCarouselCardInfoList] error, carouselCardInfo is null");
                } else {
                    e(hashMap, carouselCardInfo.videoUrl, dVar);
                }
            }
            return;
        }
        QZLog.e("GdtVideoPCDNManagerForQZone", "[addCarouselCardInfoList] error, carouselCardInfoList is null");
    }

    private static void d(HashMap<String, d> hashMap, BusinessFeedData businessFeedData) {
        GdtAd E = GdtFeedUtilForQZone.E(businessFeedData);
        if (E == null) {
            return;
        }
        d dVar = new d(E);
        QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[addFeedData] aid:%d enablePCDN:%b emergencyTimeSeconds:%d safePlayTimeSeconds:%d preloadDurationSeconds:%d", Long.valueOf(E.getAId()), Boolean.valueOf(dVar.f46207a), Integer.valueOf(dVar.f46208b), Integer.valueOf(dVar.f46209c), Integer.valueOf(dVar.f46210d)));
        if (!dVar.a()) {
            QZLog.e("GdtVideoPCDNManagerForQZone", "[addFeedData] error, data is not valid");
        } else if (GdtAdFeedUtil.isCarouselCard(businessFeedData)) {
            c(hashMap, businessFeedData.getAdData().getCarouselCardInfoList(), dVar);
        } else {
            e(hashMap, E.getVideoUrl(), dVar);
        }
    }

    private static void e(HashMap<String, d> hashMap, String str, d dVar) {
        if (TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[addParams] videoUrl:%s", str));
        hashMap.put(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, d> f(List<BusinessFeedData> list) {
        if (list != null && !list.isEmpty()) {
            QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[createMap] size:%d", Integer.valueOf(list.size())));
            HashMap<String, d> hashMap = new HashMap<>();
            for (int i3 = 0; i3 < list.size(); i3++) {
                d(hashMap, list.get(i3));
            }
            return hashMap;
        }
        QZLog.e("GdtVideoPCDNManagerForQZone", "[createMap] error, feedDataList is null");
        return new HashMap<>();
    }

    public static c g() {
        if (f46205b == null) {
            synchronized (c.class) {
                if (f46205b == null) {
                    f46205b = new c();
                }
            }
        }
        return f46205b;
    }

    private d h(String str) {
        if (TextUtils.isEmpty(str)) {
            QZLog.e("GdtVideoPCDNManagerForQZone", "[getParams] error, videoUrl is null");
            return null;
        }
        if (this.f46206a == null) {
            QZLog.e("GdtVideoPCDNManagerForQZone", "[getParams] error, map is null");
            return null;
        }
        QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[getParams] videoUrl:%s", str));
        return this.f46206a.get(str);
    }

    public void i(ISuperPlayer iSuperPlayer, SuperPlayerVideoInfo superPlayerVideoInfo, SuperPlayerOption superPlayerOption) {
        if (iSuperPlayer != null && superPlayerVideoInfo != null && superPlayerOption != null) {
            String playUrl = superPlayerVideoInfo.getPlayUrl();
            QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[injectExtraParam] videoUrl:%s", playUrl));
            if (TextUtils.isEmpty(playUrl)) {
                QZLog.e("GdtVideoPCDNManagerForQZone", "[injectExtraParam] error, videoUrl is null");
                return;
            }
            d h16 = h(playUrl);
            if (h16 == null) {
                QZLog.e("GdtVideoPCDNManagerForQZone", "[injectExtraParam] error, not ad");
                return;
            }
            if (!h16.a()) {
                QZLog.e("GdtVideoPCDNManagerForQZone", "[injectExtraParam] error, params is not valid");
                return;
            }
            QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[injectExtraParam] enablePCDN:%b emergencyTimeSeconds:%d safePlayTimeSeconds:%d preloadDurationSeconds:%d", Boolean.valueOf(h16.f46207a), Integer.valueOf(h16.f46208b), Integer.valueOf(h16.f46209c), Integer.valueOf(h16.f46210d)));
            boolean z16 = h16.f46207a;
            if (z16) {
                SuperPlayerDownOption superPlayerDownOption = superPlayerOption.superPlayerDownOption;
                superPlayerDownOption.pcdnChargeId = "pcdn_ad_qqkj";
                superPlayerDownOption.enablePcdn = z16;
                int i3 = h16.f46208b;
                int i16 = h16.f46209c;
                int i17 = h16.f46210d;
                iSuperPlayer.setBusinessDownloadStrategy(i3, i16, i17, i17);
                return;
            }
            return;
        }
        QZLog.e("GdtVideoPCDNManagerForQZone", "[injectExtraParam] error");
    }

    public void j(SuperPlayerVideoInfo superPlayerVideoInfo, AtomicLong atomicLong, AtomicLong atomicLong2, SuperPlayerDownOption superPlayerDownOption) {
        if (superPlayerVideoInfo != null && superPlayerDownOption != null && atomicLong != null) {
            String playUrl = superPlayerVideoInfo.getPlayUrl();
            QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[injectPreloadParam] videoUrl:%s", playUrl));
            if (TextUtils.isEmpty(playUrl)) {
                QZLog.e("GdtVideoPCDNManagerForQZone", "[injectPreloadParam] error, videoUrl is null");
                return;
            }
            d h16 = h(playUrl);
            if (h16 == null) {
                QZLog.e("GdtVideoPCDNManagerForQZone", "[injectPreloadParam] error, not ad");
                return;
            }
            if (!h16.a()) {
                QZLog.e("GdtVideoPCDNManagerForQZone", "[injectPreloadParam] error, params is not valid");
                return;
            }
            QZLog.i("GdtVideoPCDNManagerForQZone", String.format("[injectPreloadParam] enablePCDN:%b emergencyTimeSeconds:%d safePlayTimeSeconds:%d preloadDurationSeconds:%d", Boolean.valueOf(h16.f46207a), Integer.valueOf(h16.f46208b), Integer.valueOf(h16.f46209c), Integer.valueOf(h16.f46210d)));
            boolean z16 = h16.f46207a;
            if (z16) {
                superPlayerDownOption.pcdnChargeId = "pcdn_ad_qqkj";
                superPlayerDownOption.enablePcdn = z16;
                atomicLong.set(h16.f46210d * 1000);
                return;
            }
            return;
        }
        QZLog.e("GdtVideoPCDNManagerForQZone", "[injectPreloadParam] error");
    }
}
