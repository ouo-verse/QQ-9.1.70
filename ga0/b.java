package ga0;

import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public TianShuAccess.AdItem f401605a;

    /* renamed from: b, reason: collision with root package name */
    private long f401606b;

    private TianShuAccess.RspEntry g(List<TianShuAccess.RspEntry> list) {
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
                if (k(rspEntry2)) {
                    QLog.w(d(), 1, "get valid entry:" + rspEntry2);
                    return rspEntry2;
                }
            }
            return null;
        }
        TianShuAccess.RspEntry rspEntry3 = (TianShuAccess.RspEntry) hashMap.get(Integer.valueOf(b()));
        if (k(rspEntry3)) {
            QLog.w(d(), 1, "get valid entry:" + rspEntry3);
            return rspEntry3;
        }
        return null;
    }

    public void a() {
        List<Integer> c16;
        int e16 = e();
        if (e16 > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f401606b < e16) {
                QLog.e(d(), 1, "fast fetchData");
                return;
            }
            this.f401606b = currentTimeMillis;
        }
        d b16 = d.b();
        if (c() == null) {
            c16 = Collections.singletonList(Integer.valueOf(b()));
        } else {
            c16 = c();
        }
        b16.e(c16, new TianShuGetAdvCallback() { // from class: ga0.a
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                b.this.h(z16, getAdsRsp);
            }
        });
    }

    abstract int b();

    abstract List<Integer> c();

    protected abstract String d();

    protected abstract int e();

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, String> f(List<TianShuAccess.MapEntry> list) {
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list;
        if (!z16) {
            QLog.d(d(), 1, "handleBubbleResponse error");
            return;
        }
        QLog.d(d(), 1, "handleBubbleResponse start");
        if (getAdsRsp.mapAds.has()) {
            list = getAdsRsp.mapAds.get();
        } else {
            list = null;
        }
        if (list == null) {
            i();
            QLog.w(d(), 1, "handleBubbleResponse rspEntries is null");
            return;
        }
        TianShuAccess.RspEntry g16 = g(list);
        if (g16 == null) {
            i();
            QLog.w(d(), 1, "no invalid rspEntry: " + list);
            return;
        }
        this.f401605a = g16.value.lst.get(0);
        j(g16.key.get());
    }

    abstract void i();

    abstract void j(int i3);

    protected boolean k(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        if (rspEntry == null || (adPlacementInfo = rspEntry.value) == null || adPlacementInfo.lst.size() == 0 || rspEntry.value.lst.get(0) == null || rspEntry.value.lst.get(0).argList == null || rspEntry.value.lst.get(0).argList.get() == null) {
            return false;
        }
        return true;
    }
}
