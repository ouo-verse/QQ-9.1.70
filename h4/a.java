package h4;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f404273a = new a();

    /* compiled from: P */
    /* renamed from: h4.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10411a {

        /* renamed from: a, reason: collision with root package name */
        public String f404274a;

        /* renamed from: b, reason: collision with root package name */
        public String f404275b;

        /* renamed from: c, reason: collision with root package name */
        public String f404276c;

        /* renamed from: d, reason: collision with root package name */
        public String f404277d;

        /* renamed from: e, reason: collision with root package name */
        public int f404278e;
    }

    a() {
    }

    public static a c() {
        return f404273a;
    }

    private TianShuAccess.RspEntry d(TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.RspEntry> list = getAdsRsp.mapAds.get();
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        return (TianShuAccess.RspEntry) hashMap.get(744);
    }

    private C10411a e(TianShuAccess.RspEntry rspEntry) {
        List<TianShuAccess.MapEntry> list = rspEntry.value.lst.get(0).argList.get();
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        C10411a c10411a = new C10411a();
        c10411a.f404274a = (String) hashMap.get("type");
        c10411a.f404276c = (String) hashMap.get("pic");
        c10411a.f404275b = (String) hashMap.get("url");
        c10411a.f404277d = (String) hashMap.get("content");
        c10411a.f404278e = rspEntry.value.lst.get(0).iAdId.get();
        if (TextUtils.isEmpty(c10411a.f404276c) || TextUtils.isEmpty(c10411a.f404275b) || TextUtils.isEmpty(c10411a.f404277d)) {
            return null;
        }
        return c10411a;
    }

    public void f(TianShuGetAdvCallback tianShuGetAdvCallback) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 744;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(arrayList, tianShuGetAdvCallback);
    }

    public void g(int i3, C10411a c10411a) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            str = "";
        } else {
            str = runtime.getAccount();
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.64";
        tianShuReportData.mPageId = "tianshu.64";
        tianShuReportData.mItemId = c10411a.f404278e + "";
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    private boolean a(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        return rspEntry == null || (adPlacementInfo = rspEntry.value) == null || adPlacementInfo.lst.size() == 0 || rspEntry.value.lst.get(0) == null || rspEntry.value.lst.get(0).argList == null || rspEntry.value.lst.get(0).argList.get() == null || rspEntry.value.lst.get(0).iAdId == null;
    }

    public C10411a b(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        if (!z16 || getAdsRsp == null || !getAdsRsp.mapAds.has()) {
            return null;
        }
        TianShuAccess.RspEntry d16 = d(getAdsRsp);
        if (a(d16)) {
            return null;
        }
        C10411a e16 = e(d16);
        if (e16 != null && !TextUtils.isEmpty(e16.f404276c)) {
            URLDrawable.getDrawable(e16.f404276c, URLDrawable.URLDrawableOptions.obtain()).startDownload();
        }
        return e16;
    }
}
