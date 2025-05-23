package com.qzone.business.tianshu;

import com.qzone.common.account.LoginData;
import com.qzone.common.event.EventCenter;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTianShuAdManager {

    /* renamed from: a, reason: collision with root package name */
    static QZoneTianShuAdManager f44850a;

    /* renamed from: b, reason: collision with root package name */
    static final HashMap<String, Object> f44851b = new HashMap<>();

    public static QZoneTianShuAdManager e() {
        if (f44850a == null) {
            synchronized (QZoneTianShuAdManager.class) {
                if (f44850a == null) {
                    f44850a = new QZoneTianShuAdManager();
                }
            }
        }
        return f44850a;
    }

    private static List<TianShuAdPosItemData> f() {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = 640;
        arrayList.add(tianShuAdPosItemData);
        TianShuAdPosItemData tianShuAdPosItemData2 = new TianShuAdPosItemData();
        tianShuAdPosItemData2.mNeedCnt = 1;
        tianShuAdPosItemData2.mPosId = 638;
        arrayList.add(tianShuAdPosItemData2);
        return arrayList;
    }

    private List<TianShuAdPosItemData> g(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 1;
            tianShuAdPosItemData.mPosId = num.intValue();
            arrayList.add(tianShuAdPosItemData);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list = getAdsRsp.mapAds.has() ? getAdsRsp.mapAds.get() : null;
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        i(hashMap);
    }

    public void c() {
        f44851b.remove("640");
        if (com.qzone.proxy.feedcomponent.util.j.g()) {
            com.qzone.proxy.feedcomponent.util.j.e("QZoneTianShuAdManager", 1, "cleanDecoratorCacheData");
        }
    }

    public void d(int i3, String str) {
        k(i3, str, "tianshu.64");
    }

    public Object h(String str) {
        return f44851b.get(str);
    }

    public void k(int i3, String str, String str2) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        tianShuReportData.mTraceId = String.valueOf(LoginData.getInstance().getUin()) + util.base64_pad_url + currentTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mItemId = String.valueOf(str);
        tianShuReportData.mOperTime = currentTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = str2;
        tianShuReportData.mPageId = str2;
        tianShuReportData.mModuleId = "";
        TianShuManager.getInstance().report(tianShuReportData);
        com.qzone.proxy.feedcomponent.util.j.e("QZoneTianShuAdManager", 1, "report actionId :" + i3 + ", adId :" + str);
    }

    public void l() {
        TianShuManager.getInstance().requestAdv(f(), new TianShuGetAdvCallback() { // from class: com.qzone.business.tianshu.QZoneTianShuAdManager.1
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public void onGetAdvs(boolean z16, final TianShuAccess.GetAdsRsp getAdsRsp) {
                if (!z16 || getAdsRsp == null) {
                    return;
                }
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread, false).postDelayed(new Runnable() { // from class: com.qzone.business.tianshu.QZoneTianShuAdManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneTianShuAdManager.this.j(getAdsRsp);
                    }
                }, 500L);
            }
        });
    }

    public void m(List<Integer> list, TianShuGetAdvCallback tianShuGetAdvCallback) {
        TianShuManager.getInstance().requestAdv(g(list), tianShuGetAdvCallback);
    }

    private void b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        f44851b.put("640", hashMap);
        if (com.qzone.proxy.feedcomponent.util.j.g()) {
            com.qzone.proxy.feedcomponent.util.j.e("QZoneTianShuAdManager", 1, "cacheDecoratorData :" + hashMap);
        }
    }

    private void i(Map<Integer, TianShuAccess.RspEntry> map) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        TianShuAccess.RspEntry rspEntry = map.get(640);
        c();
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && !adPlacementInfo.lst.isEmpty()) {
            TianShuAccess.AdItem adItem = rspEntry.value.lst.get(0);
            if (adItem != null && !adItem.argList.isEmpty()) {
                HashMap<String, String> hashMap = new HashMap<>();
                for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
                    hashMap.put(mapEntry.key.get(), mapEntry.value.get());
                }
                hashMap.put("adId", adItem.iAdId.get() + "");
                b(hashMap);
                EventCenter.getInstance().post("TianShu", 1);
                return;
            }
            EventCenter.getInstance().post("TianShu", 1);
            return;
        }
        EventCenter.getInstance().post("TianShu", 1);
    }
}
