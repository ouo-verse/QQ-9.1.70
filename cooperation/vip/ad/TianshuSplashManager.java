package cooperation.vip.ad;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.vassplash.common.VasSplashCacheManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import o43.a;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TianshuSplashManager {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f391074a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class TianShuGetSplashCallback implements TianShuGetAdvCallback {

        /* renamed from: d, reason: collision with root package name */
        public String f391075d;

        public TianShuGetSplashCallback(String str) {
            this.f391075d = str;
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(final boolean z16, final TianShuAccess.GetAdsRsp getAdsRsp) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: cooperation.vip.ad.TianshuSplashManager.TianShuGetSplashCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    TianShuAccess.GetAdsRsp getAdsRsp2;
                    QLog.i("QSplash@TianshuSplashManager", 1, "TianShuGetSplashCallback  onGetAdvs  | result = " + z16 + " | getAdsRsp = " + getAdsRsp + " | reqType = " + TianShuGetSplashCallback.this.f391075d + " | hashcode = " + TianShuGetSplashCallback.this.hashCode());
                    if (z16 && (getAdsRsp2 = getAdsRsp) != null) {
                        TianShuGetSplashCallback tianShuGetSplashCallback = TianShuGetSplashCallback.this;
                        TianshuSplashManager.this.k(getAdsRsp2, tianShuGetSplashCallback.f391075d);
                    }
                    cooperation.vip.ad.license.g.g().o(5, TianShuGetSplashCallback.this.f391075d);
                }
            }, 500L);
        }
    }

    public TianshuSplashManager(QQAppInterface qQAppInterface) {
        this.f391074a = new WeakReference<>(qQAppInterface);
    }

    private HashMap<String, String> a(TianShuAccess.AdItem adItem) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            hashMap.put(mapEntry.key.get(), mapEntry.value.get());
        }
        hashMap.put(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO, adItem.traceinfo.get());
        hashMap.put("adId", adItem.iAdId.get() + "");
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static o43.a b(TianShuAccess.AdItem adItem, QQAppInterface qQAppInterface, String str) {
        int i3;
        String str2;
        int y16;
        int y17;
        int y18;
        int i16;
        String str3;
        int i17;
        String str4;
        int i18;
        int y19;
        if (adItem == null || qQAppInterface == null) {
            return null;
        }
        SplashADUtil.z(qQAppInterface.getApp(), com.tencent.mobileqq.vassplash.common.c.z(str));
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            hashMap.put(mapEntry.key.get(), mapEntry.value.get());
        }
        if (QLog.isDebugVersion()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                QLog.i("QSplash@TianshuSplashManager", 1, ((String) entry.getKey()) + " = " + ((String) entry.getValue()));
            }
        }
        a.C10882a c10882a = new a.C10882a();
        String str5 = (String) hashMap.get("showStartTime");
        String str6 = (String) hashMap.get("showEndTime");
        String str7 = (String) hashMap.get("resourceType");
        String str8 = adItem.traceinfo.get();
        if (str7 != null) {
            i3 = com.tencent.mobileqq.vassplash.common.c.y(str7);
            if (i3 == 0) {
                str2 = (String) hashMap.get("imageURL");
            } else if (i3 == 1) {
                str2 = (String) hashMap.get("gifURL");
            } else if (i3 == 2) {
                str2 = (String) hashMap.get("videoURL");
            } else if (i3 == 3) {
                str2 = (String) hashMap.get("pagUrl");
            }
            int y26 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("androidMinimumMemorySize"));
            y16 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("androidMinimumOSVersion"));
            y17 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("linkType"));
            int y27 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("thirdPartyReportPlatform"));
            int y28 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("showPriority"));
            String str9 = (String) hashMap.get("bannertype");
            y18 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("shouldShowAdMark"));
            if (y16 == 0 || y26 != 0) {
                i16 = y18;
                str3 = str8;
                i17 = 1;
            } else {
                i16 = y18;
                str3 = str8;
                i17 = 0;
            }
            String str10 = (String) hashMap.get("linkURL");
            String str11 = (String) hashMap.get("rewardLinkURL");
            if (y17 != 1) {
                i18 = y17;
                str4 = str2;
                if (!TextUtils.isEmpty(str10) && !str10.startsWith("http")) {
                    str10 = "https://" + str10;
                }
                if (!TextUtils.isEmpty(str11) && !str11.startsWith("http")) {
                    str11 = "https://" + str11;
                }
            } else {
                str4 = str2;
                i18 = y17;
            }
            String str12 = (String) hashMap.get("entryText");
            String str13 = (String) hashMap.get("entryColor");
            String str14 = (String) hashMap.get("entryBgColor");
            y19 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("btnResourceType"));
            String str15 = (String) hashMap.get("btnShowURL");
            if (y19 == 2) {
                QLog.i("QSplash@TianshuSplashManager", 1, "DYNAMIC_IMG NOT support, convert it into default mode.");
                y19 = 0;
            }
            int y29 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("shakebtn"));
            String str16 = (String) hashMap.get("shaketitle");
            String str17 = (String) hashMap.get("shakedesc");
            String str18 = (String) hashMap.get("shakecirclebgcolor");
            float floatValue = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("acceleration")).floatValue();
            int y36 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("trigger"));
            float floatValue2 = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("xaxis")).floatValue();
            float floatValue3 = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("yaxis")).floatValue();
            float floatValue4 = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("zaxis")).floatValue();
            int y37 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("wriggleAngle"));
            int y38 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("reverseAngle"));
            List<String> g16 = g(hashMap);
            List<String> f16 = f(hashMap);
            int i19 = y19;
            String str19 = str11;
            long y39 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("splashDuration")) * 1000;
            boolean p16 = com.tencent.mobileqq.vassplash.common.c.p(i17, y26, y16);
            int y46 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("sensitivity"));
            String str20 = (String) hashMap.get("entry_bg_end_color");
            String str21 = (String) hashMap.get("entry_bg_press_color");
            int y47 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("hotzone_height"));
            int y48 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("track_switch"));
            String valueOf = String.valueOf(hashMap.get("arrow_display"));
            String valueOf2 = String.valueOf(hashMap.get("arrow_display_end"));
            String valueOf3 = String.valueOf(hashMap.get("splash_logo"));
            String valueOf4 = String.valueOf(hashMap.get("app_schema"));
            int y49 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("network_switch"));
            String valueOf5 = String.valueOf(hashMap.get("slide_icon"));
            int y55 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("detect_angle"));
            int y56 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("isAdSplash"));
            boolean z16 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("isGreetingSplash")) != 1;
            String valueOf6 = String.valueOf(hashMap.get("greetingUin"));
            String valueOf7 = String.valueOf(hashMap.get("greetingNick"));
            String valueOf8 = String.valueOf(hashMap.get("greetingNickColor"));
            String valueOf9 = String.valueOf(hashMap.get("greetingDescUrl"));
            int y57 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("flip_card_angle"));
            String valueOf10 = String.valueOf(hashMap.get("jump_tips_text"));
            String valueOf11 = String.valueOf(hashMap.get("flip_card_logo"));
            c10882a.g0(str).b(adItem.iAdId.get() + "").d(str5).k(str6).g(i3).j(str4).B(i18).z(str10).A(str19).C(p16).r(g16).D(y28).q(y27).F(str3).E("").P(i16).c(str9).o(str12).p(str13).i(y49).l(str14).m(i19).n(str15).H(y29).K(str16).J(str17).I(str18).G(floatValue).L(y36).M(floatValue2).N(floatValue3).O(floatValue4).f(f16).S(y39).V(valueOf).W(valueOf2).c0(y46).d0(y48).b0(y47).a0(str21).Z(str20).T(valueOf3).y(valueOf4).Q(valueOf5).h(y55).x(y56).e0(y37).f0(y38).s(y57).t(valueOf10).u(valueOf11).v(String.valueOf(hashMap.get("flip_card_product"))).w(z16, valueOf6, valueOf7, valueOf8, valueOf9);
            QLog.i("QSplash@TianshuSplashManager", 1, "id:" + adItem.iAdId.get() + ",entryBtnType:" + i19 + ",btnUrl:" + str15);
            return c10882a.a();
        }
        i3 = -1;
        str2 = "";
        int y262 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("androidMinimumMemorySize"));
        y16 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("androidMinimumOSVersion"));
        y17 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("linkType"));
        int y272 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("thirdPartyReportPlatform"));
        int y282 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("showPriority"));
        String str92 = (String) hashMap.get("bannertype");
        y18 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("shouldShowAdMark"));
        if (y16 == 0) {
        }
        i16 = y18;
        str3 = str8;
        i17 = 1;
        String str102 = (String) hashMap.get("linkURL");
        String str112 = (String) hashMap.get("rewardLinkURL");
        if (y17 != 1) {
        }
        String str122 = (String) hashMap.get("entryText");
        String str132 = (String) hashMap.get("entryColor");
        String str142 = (String) hashMap.get("entryBgColor");
        y19 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("btnResourceType"));
        String str152 = (String) hashMap.get("btnShowURL");
        if (y19 == 2) {
        }
        int y292 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("shakebtn"));
        String str162 = (String) hashMap.get("shaketitle");
        String str172 = (String) hashMap.get("shakedesc");
        String str182 = (String) hashMap.get("shakecirclebgcolor");
        float floatValue5 = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("acceleration")).floatValue();
        int y362 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("trigger"));
        float floatValue22 = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("xaxis")).floatValue();
        float floatValue32 = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("yaxis")).floatValue();
        float floatValue42 = com.tencent.mobileqq.vassplash.common.c.x((String) hashMap.get("zaxis")).floatValue();
        int y372 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("wriggleAngle"));
        int y382 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("reverseAngle"));
        List<String> g162 = g(hashMap);
        List<String> f162 = f(hashMap);
        int i192 = y19;
        String str192 = str112;
        long y392 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("splashDuration")) * 1000;
        boolean p162 = com.tencent.mobileqq.vassplash.common.c.p(i17, y262, y16);
        int y462 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("sensitivity"));
        String str202 = (String) hashMap.get("entry_bg_end_color");
        String str212 = (String) hashMap.get("entry_bg_press_color");
        int y472 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("hotzone_height"));
        int y482 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("track_switch"));
        String valueOf12 = String.valueOf(hashMap.get("arrow_display"));
        String valueOf22 = String.valueOf(hashMap.get("arrow_display_end"));
        String valueOf32 = String.valueOf(hashMap.get("splash_logo"));
        String valueOf42 = String.valueOf(hashMap.get("app_schema"));
        int y492 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("network_switch"));
        String valueOf52 = String.valueOf(hashMap.get("slide_icon"));
        int y552 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("detect_angle"));
        int y562 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("isAdSplash"));
        if (com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("isGreetingSplash")) != 1) {
        }
        String valueOf62 = String.valueOf(hashMap.get("greetingUin"));
        String valueOf72 = String.valueOf(hashMap.get("greetingNick"));
        String valueOf82 = String.valueOf(hashMap.get("greetingNickColor"));
        String valueOf92 = String.valueOf(hashMap.get("greetingDescUrl"));
        int y572 = com.tencent.mobileqq.vassplash.common.c.y((String) hashMap.get("flip_card_angle"));
        String valueOf102 = String.valueOf(hashMap.get("jump_tips_text"));
        String valueOf112 = String.valueOf(hashMap.get("flip_card_logo"));
        c10882a.g0(str).b(adItem.iAdId.get() + "").d(str5).k(str6).g(i3).j(str4).B(i18).z(str102).A(str192).C(p162).r(g162).D(y282).q(y272).F(str3).E("").P(i16).c(str92).o(str122).p(str132).i(y492).l(str142).m(i192).n(str152).H(y292).K(str162).J(str172).I(str182).G(floatValue5).L(y362).M(floatValue22).N(floatValue32).O(floatValue42).f(f162).S(y392).V(valueOf12).W(valueOf22).c0(y462).d0(y482).b0(y472).a0(str212).Z(str202).T(valueOf32).y(valueOf42).Q(valueOf52).h(y552).x(y562).e0(y372).f0(y382).s(y572).t(valueOf102).u(valueOf112).v(String.valueOf(hashMap.get("flip_card_product"))).w(z16, valueOf62, valueOf72, valueOf82, valueOf92);
        QLog.i("QSplash@TianshuSplashManager", 1, "id:" + adItem.iAdId.get() + ",entryBtnType:" + i192 + ",btnUrl:" + str152);
        return c10882a.a();
    }

    private boolean c(TianShuAccess.GetAdsRsp getAdsRsp) {
        String str;
        if (getAdsRsp == null) {
            return false;
        }
        QLog.d("QSplash@TianshuSplashManager", 1, "filterSdkVersion | rsp.ctrlInfo.size = " + getAdsRsp.ctrlInfo.size());
        Iterator<TianShuAccess.MapEntry> it = getAdsRsp.ctrlInfo.get().iterator();
        while (true) {
            if (it.hasNext()) {
                TianShuAccess.MapEntry next = it.next();
                if (TextUtils.equals(next.key.get(), "filterSdkVersion")) {
                    str = next.value.get();
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.d("QSplash@TianshuSplashManager", 1, "filterSdkVersion   | versionJson = " + str + " | currentVersion = " + Build.VERSION.SDK_INT);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(Integer.valueOf(jSONArray.optInt(i3)));
            }
            if (arrayList.size() <= 0 || !arrayList.contains(Integer.valueOf(Build.VERSION.SDK_INT))) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("QSplash@TianshuSplashManager", 1, "filterSdkVersion e = " + e16.getMessage());
            return false;
        }
    }

    private static List<TianShuAccess.AdItem> d(TianShuAccess.RspEntry rspEntry) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        ArrayList arrayList = new ArrayList();
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && adPlacementInfo.lst.size() != 0) {
            Iterator<TianShuAccess.AdItem> it = rspEntry.value.lst.get().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().get());
            }
        }
        return arrayList;
    }

    private QQAppInterface e() {
        WeakReference<QQAppInterface> weakReference = this.f391074a;
        if (weakReference == null) {
            QLog.e("QSplash@TianshuSplashManager", 1, "getApp  appWR == null");
            return null;
        }
        QQAppInterface qQAppInterface = weakReference.get();
        if (qQAppInterface == null) {
            QLog.e("QSplash@TianshuSplashManager", 1, "getApp  appInterface == null");
        }
        return qQAppInterface;
    }

    private static List<String> f(HashMap<String, String> hashMap) {
        String str = "";
        if (hashMap == null) {
            return Arrays.asList("", "", "", "", "");
        }
        String str2 = hashMap.get("thirdPartyReportURLForClick");
        String str3 = hashMap.get("thirdPartyReportURLForClick1");
        String str4 = hashMap.get("thirdPartyReportURLForClick2");
        String str5 = hashMap.get("thirdPartyReportURLForClick3");
        String str6 = hashMap.get("thirdPartyReportURLForClick4");
        ArrayList arrayList = new ArrayList(5);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        arrayList.add(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        arrayList.add(str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        arrayList.add(str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        arrayList.add(str5);
        if (!TextUtils.isEmpty(str6)) {
            str = str6;
        }
        arrayList.add(str);
        return arrayList;
    }

    private static List<String> g(HashMap<String, String> hashMap) {
        String str = "";
        if (hashMap == null) {
            return Arrays.asList("", "", "", "", "");
        }
        String str2 = hashMap.get("thirdPartyReportURLForExposure");
        String str3 = hashMap.get("thirdPartyReportURLForExposure1");
        String str4 = hashMap.get("thirdPartyReportURLForExposure2");
        String str5 = hashMap.get("thirdPartyReportURLForExposure3");
        String str6 = hashMap.get("thirdPartyReportURLForExposure4");
        ArrayList arrayList = new ArrayList(5);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        arrayList.add(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        arrayList.add(str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        arrayList.add(str4);
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        arrayList.add(str5);
        if (!TextUtils.isEmpty(str6)) {
            str = str6;
        }
        arrayList.add(str);
        return arrayList;
    }

    public static List<TianShuAdPosItemData> h() {
        ArrayList arrayList = new ArrayList();
        if (TianShuManager.isRequestEnable(510)) {
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 5;
            tianShuAdPosItemData.mPosId = 510;
            arrayList.add(tianShuAdPosItemData);
            QLog.d("QSplash@TianshuSplashManager", 1, "getRequestList  isRequestEnable true, UNION_SPLASH_ID");
        }
        if (TianShuManager.isRequestEnable(716)) {
            TianShuAdPosItemData tianShuAdPosItemData2 = new TianShuAdPosItemData();
            tianShuAdPosItemData2.mNeedCnt = 5;
            tianShuAdPosItemData2.mPosId = 716;
            arrayList.add(tianShuAdPosItemData2);
            QLog.d("QSplash@TianshuSplashManager", 1, "getRequestList  isRequestEnable true, CUSTOM_SPLASH_ID");
        }
        return arrayList;
    }

    private List<o43.a> i(List<TianShuAccess.AdItem> list) {
        QQAppInterface e16 = e();
        if (e16 == null) {
            QLog.e("QSplash@TianshuSplashManager", 1, "handleCustomSplash  app == null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TianShuAccess.AdItem> it = list.iterator();
        while (it.hasNext()) {
            o43.a b16 = b(it.next(), e16, e16.getCurrentUin());
            if (b16 == null) {
                QLog.e("QSplash@TianshuSplashManager", 1, "handleCustomSplash   itemTmp == null");
            } else {
                QLog.d("QSplash@TianshuSplashManager", 1, "handleCustomSplash item:" + b16);
                arrayList.add(b16);
            }
        }
        return arrayList;
    }

    private List<o43.a> j(List<TianShuAccess.AdItem> list) {
        QQAppInterface e16 = e();
        if (e16 == null) {
            QLog.e("QSplash@TianshuSplashManager", 1, "handleUnionSplash  app == null");
            return null;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (TianShuAccess.AdItem adItem : list) {
                o43.a b16 = b(adItem, e16, e16.getCurrentUin());
                if (b16 == null) {
                    QLog.e("QSplash@TianshuSplashManager", 1, "handleUnionSplash  itemTmp == null");
                } else {
                    QLog.d("QSplash@TianshuSplashManager", 1, "handleUnionSplash item:" + b16);
                    arrayList.add(b16);
                    j15.a d16 = j15.a.d(a(adItem), b16.f421955t);
                    cooperation.vip.qqbanner.manager.a.e().l(e16, d16);
                    if (d16 != null) {
                        d16.j(e16.getCurrentUin());
                    }
                }
            }
            return arrayList;
        }
        QLog.e("QSplash@TianshuSplashManager", 1, "handleUnionSplash  adItemList is empty");
        return null;
    }

    private void n(Map<Integer, TianShuAccess.RspEntry> map) {
        if (map != null && map.size() != 0) {
            TianShuAccess.RspEntry rspEntry = map.get(510);
            TianShuAccess.RspEntry rspEntry2 = map.get(716);
            List<TianShuAccess.AdItem> d16 = d(rspEntry);
            d16.addAll(d(rspEntry2));
            for (TianShuAccess.AdItem adItem : d16) {
                w.q(adItem.iAdId.get() + "", 149, adItem.traceinfo.get());
            }
        }
    }

    private void o(List<o43.a> list) {
        if (bl.b(list)) {
            com.tencent.mobileqq.splashad.l.f288780d.g(1);
            return;
        }
        Iterator<o43.a> it = list.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            try {
                long parseLong = Long.parseLong(it.next().f421927c);
                if (j3 == 0 || parseLong < j3) {
                    j3 = parseLong;
                }
            } catch (NumberFormatException e16) {
                QLog.w("QSplash@TianshuSplashManager", 1, "saveTianShuSplashBeginTimeLabel  e = " + e16);
            }
        }
        if (j3 == 0) {
            return;
        }
        com.tencent.mobileqq.splashad.l.f288780d.n(1, j3);
        QLog.i("QSplash@TianshuSplashManager", 1, "saveTianShuSplashBeginTimeLabel   beginTime = " + j3);
    }

    public void k(TianShuAccess.GetAdsRsp getAdsRsp, String str) {
        List<TianShuAccess.RspEntry> list;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        TianShuAccess.AdPlacementInfo adPlacementInfo2;
        QQAppInterface e16 = e();
        if (e16 == null) {
            QLog.e("QSplash@TianshuSplashManager", 1, "handlerTianshuAdRsp  app == null, reqType = " + str);
            return;
        }
        if (getAdsRsp.mapAds.has()) {
            list = getAdsRsp.mapAds.get();
        } else {
            list = null;
        }
        if (list == null) {
            QLog.e("QSplash@TianshuSplashManager", 1, "handlerTianshuAdRsp  rspEntries == null");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handlerTianshuAdRsp  rspEntries.size = ");
        sb5.append(list.size());
        sb5.append("\n");
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry != null && rspEntry.key.has()) {
                int i3 = rspEntry.key.get();
                hashMap.put(Integer.valueOf(i3), rspEntry);
                TianShuManager.saveNextRequestTime(rspEntry);
                sb5.append("handlerTianshuAdRsp , rsp targetEntries, key = ");
                sb5.append(i3);
                sb5.append("\n");
            }
        }
        if (c(getAdsRsp)) {
            sb5.append("handlerTianshuAdRsp  filter success\n");
            n(hashMap);
            VasSplashCacheManager.b(e16.getCurrentUin());
            QLog.w("QSplash@TianshuSplashManager", 1, sb5.toString());
            return;
        }
        ArrayList arrayList = new ArrayList();
        TianShuAccess.RspEntry rspEntry2 = hashMap.get(510);
        if (rspEntry2 != null && (adPlacementInfo2 = rspEntry2.value) != null && adPlacementInfo2.lst.size() > 0) {
            List<o43.a> j3 = j(rspEntry2.value.lst.get());
            if (!bl.b(j3)) {
                arrayList.addAll(j3);
            }
        }
        TianShuAccess.RspEntry rspEntry3 = hashMap.get(716);
        if (rspEntry3 != null && (adPlacementInfo = rspEntry3.value) != null && adPlacementInfo.lst.size() > 0) {
            List<o43.a> i16 = i(rspEntry3.value.lst.get());
            if (!bl.b(i16)) {
                arrayList.addAll(i16);
            }
        }
        sb5.append("handlerTianshuAdRsp  ");
        sb5.append(" | splashItemList.size = ");
        sb5.append(arrayList.size());
        QLog.i("QSplash@TianshuSplashManager", 1, sb5.toString());
        VasSplashCacheManager.e(e16, e16.getCurrentUin(), arrayList);
        o(arrayList);
    }

    public void l(QQAppInterface qQAppInterface) {
        this.f391074a = new WeakReference<>(qQAppInterface);
    }

    public void m() {
        this.f391074a = null;
    }

    public void p(String str) {
        QLog.i("QSplash@TianshuSplashManager", 1, "sendTianshuSplashRequest  | reqType = " + str + " | enableTalkBack = " + AppSetting.f99565y);
        if (AppSetting.f99565y) {
            return;
        }
        TianShuManager.getInstance().requestAdv(h(), new TianShuGetSplashCallback(str));
    }
}
