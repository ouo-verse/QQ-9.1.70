package cooperation.vip.ad;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private volatile WeakReference<QQAppInterface> f391175a;

    public j(QQAppInterface qQAppInterface) {
        this.f391175a = new WeakReference<>(qQAppInterface);
    }

    private HashMap<String, String> b(TianShuAccess.AdItem adItem) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            hashMap.put(mapEntry.key.get(), mapEntry.value.get());
        }
        hashMap.put(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO, adItem.traceinfo.get());
        hashMap.put("adId", adItem.iAdId.get() + "");
        return hashMap;
    }

    private QQAppInterface c() {
        if (this.f391175a == null) {
            QLog.e("TianshuBannerManager", 1, "getApp  appWR == null");
            return null;
        }
        QQAppInterface qQAppInterface = this.f391175a.get();
        if (qQAppInterface == null) {
            QLog.e("TianshuBannerManager", 1, "getApp  appInterface == null");
        }
        return qQAppInterface;
    }

    public static List<TianShuAdPosItemData> d() {
        ArrayList arrayList = new ArrayList();
        if (TianShuManager.isRequestEnable(715)) {
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 5;
            tianShuAdPosItemData.mPosId = 715;
            arrayList.add(tianShuAdPosItemData);
        }
        return arrayList;
    }

    private void e(List<TianShuAccess.AdItem> list) {
        if (list != null && !list.isEmpty()) {
            HashMap<String, String> b16 = b(list.get(0));
            j15.a d16 = j15.a.d(b16, b16.get("bannertype"));
            a(d16);
            cooperation.vip.qqbanner.manager.a.e().o(c(), d16);
            return;
        }
        BannerManager.l().D(VasADBannerProcessor.f185279h, 3001);
    }

    public static boolean g(QQAppInterface qQAppInterface) {
        i15.b l3;
        if (qQAppInterface != null) {
            j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(qQAppInterface.getAccount());
            if ((g16 instanceof j15.b) && (l3 = ((j15.b) g16).l()) != null) {
                return l3.f407058l;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(j15.a aVar) {
        boolean z16;
        QQAppInterface c16 = c();
        if (c16 == null) {
            return;
        }
        j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(c16.getAccount());
        if (aVar != null && g16 != null) {
            if (aVar.f() != null && g16.f() != null) {
                String str = aVar.f().f407076g;
                String str2 = g16.f().f407076g;
                if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                    z16 = true;
                    if (!z16) {
                        BannerManager.l().D(VasADBannerProcessor.f185279h, 3001);
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
    }

    public void f(Map<Integer, TianShuAccess.RspEntry> map) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        TianShuAccess.RspEntry rspEntry = map.get(715);
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && adPlacementInfo.lst.size() > 0) {
            e(rspEntry.value.lst.get());
        }
    }

    public void h(QQAppInterface qQAppInterface) {
        this.f391175a = new WeakReference<>(qQAppInterface);
    }

    public void i() {
        this.f391175a = null;
    }
}
