package cooperation.vip.ad;

import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
class TianshuRenewalsBarManager$TianshuGetRenewalsBarCallback$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ TianShuAccess.GetAdsRsp f391073d;

    @Override // java.lang.Runnable
    public void run() {
        List<TianShuAccess.RspEntry> list;
        if (this.f391073d.mapAds.has()) {
            list = this.f391073d.mapAds.get();
        } else {
            list = null;
        }
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        throw null;
    }
}
