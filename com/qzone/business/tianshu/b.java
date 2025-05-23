package com.qzone.business.tianshu;

import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public TianShuAccess.AdItem f44856a;

    private TianShuAccess.RspEntry d(List<TianShuAccess.RspEntry> list) {
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        if (c() != null) {
            Iterator<Integer> it = c().iterator();
            while (it.hasNext()) {
                TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(it.next().intValue()));
                if (h(rspEntry2)) {
                    QLog.w("BaseTianShuBubbleHelper", 1, "get valid entry:" + rspEntry2);
                    return rspEntry2;
                }
            }
            return null;
        }
        TianShuAccess.RspEntry rspEntry3 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(b()));
        if (!h(rspEntry3)) {
            return null;
        }
        QLog.w("BaseTianShuBubbleHelper", 1, "get valid entry:" + rspEntry3);
        return rspEntry3;
    }

    public void a() {
        List<Integer> c16;
        QZoneTianShuAdManager e16 = QZoneTianShuAdManager.e();
        if (c() == null) {
            c16 = Collections.singletonList(Integer.valueOf(b()));
        } else {
            c16 = c();
        }
        e16.m(c16, new TianShuGetAdvCallback() { // from class: com.qzone.business.tianshu.a
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                b.this.e(z16, getAdsRsp);
            }
        });
    }

    abstract int b();

    abstract List<Integer> c();

    abstract void f(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> g() {
        HashMap<String, String> hashMap = new HashMap<>();
        TianShuAccess.AdItem adItem = this.f44856a;
        if (adItem != null && adItem.argList.get() != null) {
            for (TianShuAccess.MapEntry mapEntry : this.f44856a.argList.get()) {
                String str = mapEntry.key.get();
                String str2 = mapEntry.value.get();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    hashMap.put(str, str2);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        if (z16) {
            QLog.d("BaseTianShuBubbleHelper", 1, "handleBubbleResponse start");
            List<TianShuAccess.RspEntry> list = getAdsRsp.mapAds.has() ? getAdsRsp.mapAds.get() : null;
            if (list == null) {
                QLog.w("BaseTianShuBubbleHelper", 1, "handleBubbleResponse rspEntries is null");
                return;
            }
            TianShuAccess.RspEntry d16 = d(list);
            if (d16 == null) {
                QLog.w("BaseTianShuBubbleHelper", 1, "no invalid rspEntry: " + list);
                return;
            }
            this.f44856a = d16.value.lst.get(0);
            f(d16.key.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        return (rspEntry == null || (adPlacementInfo = rspEntry.value) == null || adPlacementInfo.lst.size() == 0 || rspEntry.value.lst.get(0) == null || rspEntry.value.lst.get(0).argList == null || rspEntry.value.lst.get(0).argList.get() == null) ? false : true;
    }
}
