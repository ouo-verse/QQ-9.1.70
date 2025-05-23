package com.tencent.gdt.tangram.ad.qzone.embedded;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.commoncode.module.videorecommend.ui.QzoneVideoRecommendActivity;
import com.qzone.detail.ui.activity.QzoneDetailActivity;
import com.qzone.feed.ui.activity.QZoneFriendFeedFragment;
import com.qzone.feed.ui.activity.QZoneMyFeedFragment;
import com.qzone.preview.QZoneAdvertiseVideoFloatActivity;
import com.qzone.preview.QZoneEncourageAdvActivity;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.util.SystemTools;
import com.tencent.gdt.tangram.ad.AdArea;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import com.tencent.gdt.tangram.ad.qzone.d;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.AdActionTangram;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.c;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.f;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.g;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.h;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.i;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.j;
import com.tencent.gdt.tangram.ad.qzone.embedded.action.k;
import com.tencent.gdt.tangram.statistics.qzone.embedded.AdReporter;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QZoneConfigHelper;
import java.net.URL;
import org.json.JSONObject;
import yl0.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f108428a = "com.tencent.gdt.tangram.ad.qzone.embedded.b";

    public static boolean a(String str, yl0.a aVar) {
        return aVar.h() != null && aVar.h().c() && k(str);
    }

    public static boolean b(BusinessFeedData businessFeedData) {
        return j(new com.tencent.gdt.tangram.ad.qzone.b(businessFeedData).b());
    }

    public static boolean c(BusinessFeedData businessFeedData) {
        if (!businessFeedData.isDeepLink()) {
            d.b(f108428a, "is not deepLink");
        }
        boolean d16 = dm0.a.d(GdtFeedUtilForQZone.l(), new com.tencent.gdt.tangram.ad.qzone.b(businessFeedData).b(), new com.tencent.gdt.tangram.ad.qzone.b(businessFeedData).c());
        d.b(f108428a, "canLauchAppWithShema =" + d16);
        return d16;
    }

    public static boolean d(BusinessFeedData businessFeedData, int i3, int i16) {
        return GdtFeedUtilForQZone.c(businessFeedData) && !l(i3, i16) && new com.tencent.gdt.tangram.ad.qzone.b(businessFeedData).m();
    }

    public static zl0.a e(AdClickData adClickData, yl0.a aVar) {
        BaseVideo n3;
        BusinessFeedData m3 = adClickData.m();
        if (m3.getFeedCommInfo().needPopupGdtTable) {
            return null;
        }
        int id5 = aVar.a().getId();
        int id6 = aVar.a().getScene().getId();
        Object j3 = adClickData.j();
        com.tencent.gdt.tangram.ad.qzone.b bVar = new com.tencent.gdt.tangram.ad.qzone.b(m3);
        int a16 = bVar.a(id5, j3);
        if ((m3.isMiniAppGdtAdv() || ((m3.isGdt585AdVideo() && GdtFeedUtilForQZone.o(m3)) || m3.isImaxVideoAdv())) && id5 != 0 && adClickData.l() != null && adClickData.l() != FeedElement.DROPDOWN_BUTTON && (n3 = GdtFeedUtilForQZone.n(adClickData.p())) != null && n3.getState() != 3 && id5 == 6) {
            n3.doPlayVideo();
            aVar.a().setId(0);
            return null;
        }
        if (a16 == 62 && id5 == 5) {
            return new k(adClickData, aVar);
        }
        if (r(m3, a16, id6, id5)) {
            return new AdActionTangram(adClickData, aVar);
        }
        if (m3.isMiniAppGdtAdv() && id5 != 0) {
            return new j(adClickData, aVar);
        }
        if (bVar.i() == 4) {
            if (adClickData.o() == 8) {
                return new AdActionTangram(adClickData, aVar);
            }
            return f(adClickData, aVar);
        }
        if (a16 == 2) {
            if (c(adClickData.m())) {
                return new c(adClickData, aVar, true);
            }
            return new i(adClickData, aVar);
        }
        if (a16 == 5) {
            return new g(adClickData, aVar);
        }
        if (a16 == 21) {
            return new f(adClickData, aVar);
        }
        if (a16 == 46) {
            if (adClickData.m().cellCanvas != null) {
                adClickData.m().cellCanvas = null;
            }
            return new AdActionTangram(adClickData, aVar);
        }
        if (a16 != 54) {
            d.c(f108428a, "getAdAction error");
            return null;
        }
        return new h(adClickData, aVar);
    }

    public static int g(Object obj) {
        if (obj instanceof QZoneFriendFeedFragment) {
            return 0;
        }
        if (obj instanceof QzoneDetailActivity) {
            return 2;
        }
        if (obj instanceof QZoneMyFeedFragment) {
            return 3;
        }
        if (obj instanceof QzoneVideoRecommendActivity) {
            return 1;
        }
        if (obj instanceof QZoneAdvertiseVideoFloatActivity) {
            return 6;
        }
        return obj instanceof QZoneEncourageAdvActivity ? 7 : -1;
    }

    public static String h(AdClickData adClickData) {
        if (adClickData != null && adClickData.m() != null) {
            if (adClickData.m().getOperationInfoV2().isWeishiGdtTangramAdv) {
                return "biz_src_jc_gzh_weishi";
            }
            if (adClickData.o() == 7) {
                return "biz_src_webgames";
            }
        }
        return "biz_src_jc_qzone";
    }

    public static String i(BusinessFeedData businessFeedData, AdArea adArea) {
        String str = businessFeedData.getOperationInfo().actionUrl;
        boolean z16 = false;
        boolean z17 = AppNetConnInfo.isWifiConn() && adArea.getScene().getId() == 2;
        if (AppNetConnInfo.isWifiConn() && (adArea.getScene().getId() == 1 || adArea.getScene().getId() == 8)) {
            z16 = true;
        }
        if (!TextUtils.isEmpty(str) && ((adArea.getId() == 8 || z17 || z16) && !str.contains("&auto_download=1"))) {
            str = str + "&auto_download=1";
        }
        if (!businessFeedData.getOperationInfo().yingYongBao) {
            str = GdtFeedUtilForQZone.b(str);
        }
        d.b(f108428a, "downloadUrl =" + str);
        return str;
    }

    public static boolean j(String str) {
        return SystemTools.a(BaseApplication.getContext(), str);
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            d.b(f108428a, "clickUrl is null");
            return false;
        }
        try {
            String host = new URL(str).getHost();
            for (String str2 : QZoneConfigHelper.U().split("#")) {
                if (host.equals(str2)) {
                    d.b(f108428a, "isClickCgiUrl true");
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        d.b(f108428a, "is not ClickCgiUrl");
        return false;
    }

    private static boolean l(int i3, int i16) {
        if (i16 == 8 && i3 == 8) {
            return true;
        }
        return false;
    }

    private static boolean m(AdClickData adClickData, yl0.a aVar) {
        return (aVar.h() instanceof f) && adClickData.o() == -1;
    }

    public static Boolean n(yl0.a aVar, AdClickData adClickData) {
        BusinessFeedData m3 = adClickData.m();
        boolean z16 = !m3.isGdt185AdVideo() || (!m3.isAppAd() && ((!m3.isDeepLink() || m3.isAppAd() || c(m3)) && (m3.isDeepLink() || m3.isAppAd()))) || m3.isMiniAppGdtAdv() || new com.tencent.gdt.tangram.ad.qzone.b(m3).a(aVar.a().getId(), null) == 3 || aVar.a().getScene().getId() == 8;
        if (m3.isGdt185AdVideo() && m3.isMiniAppGdtAdv() && adClickData.o() == 0 && adClickData.l() == FeedElement.AUTO_VIDEO_CLICK) {
            z16 = false;
        }
        return Boolean.valueOf((m3.isDeepLink() && !m3.isAppAd() && adClickData.l() == FeedElement.AUTO_VIDEO) ? false : z16);
    }

    public static boolean o(yl0.a aVar, AdClickData adClickData) {
        BusinessFeedData m3 = adClickData.m();
        int id5 = aVar.a().getId();
        View p16 = adClickData.p();
        FeedElement l3 = adClickData.l();
        Context e16 = com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k());
        if (!n(aVar, adClickData).booleanValue()) {
            return false;
        }
        com.tencent.gdt.tangram.ad.qzone.b bVar = new com.tencent.gdt.tangram.ad.qzone.b(m3);
        if (id5 == 0 || ((m3.isBrandUgcAdvFeeds() && !q(aVar, adClickData)) || !com.qzone.common.business.service.a.shouldReportDownloadImClick(p16, id5, m3, e16) || (!(aVar.h() == null || aVar.h().d() || bVar.a(id5, null) == 3) || m(adClickData, aVar) || ((l3 == FeedElement.VISIT && m3.getCellBottomRecomm() == null && m3.isBrandUgcAdvFeeds()) || (m3.isMyMediaCardAdvFeed() && l3 != FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV))))) {
            return false;
        }
        if (m3.isGdt185AdVideo() && bVar.a(id5, null) == 49 && (!m3.isDeepLink() || m3.isAppAd())) {
            return false;
        }
        if (m3.getRecommAction() == null || TextUtils.isEmpty(m3.getRecommAction().currency_pass_field)) {
            return true;
        }
        try {
            return new JSONObject(m3.getRecommAction().currency_pass_field).optInt(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) != 3;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return true;
        }
    }

    public static boolean p(yl0.a aVar, AdClickData adClickData) {
        BusinessFeedData m3 = adClickData.m();
        int id5 = aVar.a().getId();
        return n(aVar, adClickData).booleanValue() && com.qzone.common.business.service.a.shouldReportDownloadImClick(adClickData.p(), id5, m3, com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k())) && id5 != 0 && !m(adClickData, aVar) && (!m3.isBrandUgcAdvFeeds() || q(aVar, adClickData)) && (!m3.isMyMediaCardAdvFeed() || id5 == 31);
    }

    private static boolean q(yl0.a aVar, AdClickData adClickData) {
        int id5 = aVar.a().getScene().getId();
        if (id5 != 2 && id5 != 3) {
            return id5 == 1 ? adClickData.n() != 1 || aVar.a().getId() == 31 || aVar.a().getId() == 8 : id5 == 0;
        }
        FeedElement l3 = adClickData.l();
        BusinessFeedData m3 = adClickData.m();
        if (id5 == 2 && aVar.a().getId() == 8) {
            return true;
        }
        return (m3.getCellBottomRecomm() != null && m3.getCellBottomRecomm().anonymity == CellBottomRecomm.TYPE_ADV && (l3 == FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV || l3 == FeedElement.VISIT)) || l3 == FeedElement.CONTENT_EXTERNAL_URL_CLICK;
    }

    public static boolean r(BusinessFeedData businessFeedData, int i3, int i16, int i17) {
        int i18;
        new JSONObject();
        if (businessFeedData != null && businessFeedData.getRecommAction() != null && !TextUtils.isEmpty(businessFeedData.getRecommAction().currency_pass_field)) {
            try {
                i18 = new JSONObject(businessFeedData.getRecommAction().currency_pass_field).optInt(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            return businessFeedData == null && i3 != 54 && !(i16 == 8 && businessFeedData.isAppAd() && i17 == 8) && ((i3 != -1 || ((i18 <= 3 && i18 >= 3) || i17 == 36)) && i3 != 49 && (!businessFeedData.isBrandUgcAdvFeeds() || i17 == 31 || i17 == 29));
        }
        i18 = 0;
        if (businessFeedData == null) {
        }
    }

    public static void s(BusinessFeedData businessFeedData, AdArea adArea, boolean z16, String str, boolean z17) {
        if (businessFeedData != null && (businessFeedData.isGDTAdvFeed() || businessFeedData.getCellCornerAdv() != null || businessFeedData.isWindowAd())) {
            e a16 = yl0.g.a(businessFeedData, adArea, z16, str, z17);
            AdReporter.e(businessFeedData, a16);
            d.b(f108428a, " impression is report:" + businessFeedData.toString());
            if (a16.i()) {
                return;
            }
            vo.b.m(false, businessFeedData);
            return;
        }
        d.c(f108428a, " impression is error data:" + businessFeedData);
    }

    private static zl0.a f(AdClickData adClickData, yl0.a aVar) {
        BusinessFeedData m3 = adClickData.m();
        int id5 = aVar.a().getId();
        int o16 = adClickData.o();
        Object j3 = adClickData.j();
        View p16 = adClickData.p();
        Context e16 = com.tencent.gdt.tangram.ad.qzone.c.e(adClickData.k());
        com.tencent.gdt.tangram.ad.qzone.b bVar = new com.tencent.gdt.tangram.ad.qzone.b(m3);
        if (bVar.i() != 4 && !c(m3)) {
            d.b(f108428a, "is not app ad");
            return null;
        }
        int a16 = bVar.a(id5, j3);
        String str = f108428a;
        d.b(str, "actionType = " + a16);
        String b16 = bVar.b();
        boolean z16 = (m3.isDeepLink() && a16 != -1 && m3.isAppAd()) ? false : true;
        if (z16 && m3.isDeepLink() && a16 != -1 && (com.qzone.common.business.service.a.shouldReportDeepLinkEffect(p16, id5, m3, e16) || j(b16))) {
            AdReporter.d(adClickData.m().getGdtEffectCGIUrl(), adClickData.m().getOperationInfoV2().cookie.get(3), bm0.a.f28647a);
        }
        if (TextUtils.isEmpty(b16)) {
            AdReporter.d(m3.getGdtEffectCGIUrl(), m3.getOperationInfoV2().cookie.get(3), bm0.a.f28651e);
        }
        if (j(b16)) {
            d.b(str, "app is installed");
            if (z16 && m3.isDeepLink() && a16 != -1 && !m3.isAppAd()) {
                AdReporter.d(m3.getGdtEffectCGIUrl(), m3.getOperationInfoV2().cookie.get(3), bm0.a.f28649c);
            }
            if (a16 != 2 && a16 != 22 && a16 != 46 && a16 != 54) {
                return null;
            }
            if (c(m3)) {
                return new c(adClickData, aVar, false);
            }
            if (b(m3)) {
                return new com.tencent.gdt.tangram.ad.qzone.embedded.action.b(adClickData, aVar);
            }
            return null;
        }
        if ((z16 || j(b16)) && m3.isDeepLink() && a16 != -1 && com.qzone.common.business.service.a.shouldReportDeepLinkEffect(p16, id5, m3, e16)) {
            AdReporter.d(m3.getGdtEffectCGIUrl(), m3.getOperationInfoV2().cookie.get(3), bm0.a.f28650d);
        }
        d.b(str, "app is not installed");
        if (a16 == 2) {
            if (l(id5, o16)) {
                return new com.tencent.gdt.tangram.ad.qzone.embedded.action.a(adClickData, aVar);
            }
            return new i(adClickData, aVar);
        }
        if (a16 == 22) {
            if (l(id5, o16)) {
                return new com.tencent.gdt.tangram.ad.qzone.embedded.action.a(adClickData, aVar);
            }
            if (d(m3, id5, o16)) {
                return new com.tencent.gdt.tangram.ad.qzone.embedded.action.d(adClickData, aVar);
            }
            return new com.tencent.gdt.tangram.ad.qzone.embedded.action.e(adClickData, aVar);
        }
        if (a16 != 46) {
            if (a16 != 54) {
                return null;
            }
            return new h(adClickData, aVar);
        }
        if (l(id5, o16)) {
            return new com.tencent.gdt.tangram.ad.qzone.embedded.action.a(adClickData, aVar);
        }
        adClickData.m().cellCanvas = null;
        return new AdActionTangram(adClickData, aVar);
    }
}
