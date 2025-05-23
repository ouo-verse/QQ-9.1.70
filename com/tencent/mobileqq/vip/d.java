package com.tencent.mobileqq.vip;

import MQQ.PopupImgInfo;
import MQQ.ToastImgInfo;
import MQQ.TrafficResultInfo;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Boolean> f312929a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f312930a;

        /* renamed from: b, reason: collision with root package name */
        public String f312931b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f312930a = 1;
                this.f312931b = "";
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void callback(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f312929a = new ConcurrentHashMap<>();
        }
    }

    private static void a(String str, boolean z16, VasMMKVProxy vasMMKVProxy, a aVar) {
        String str2;
        int decodeInt = vasMMKVProxy.decodeInt("popupRateType", 0);
        if (decodeInt != 0 && decodeInt != 1) {
            aVar.f312930a = 4;
            return;
        }
        int decodeInt2 = vasMMKVProxy.decodeInt("popupRate", 0) * 1000;
        if (vasMMKVProxy.decodeInt(KingCardJsPlugin.BUSINESS_NAME, 0) != 1 && vasMMKVProxy.decodeInt(KingCardJsPlugin.BUSINESS_NAME, 0) != 1 && vasMMKVProxy.decodeInt("kingCard2", 0) != 1) {
            aVar.f312930a = 2;
        } else {
            aVar.f312930a = 3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            str2 = "lastTipTime_";
        } else {
            str2 = "lastDialogTime_";
        }
        sb5.append(str2);
        sb5.append(str);
        String sb6 = sb5.toString();
        if (currentTimeMillis - vasMMKVProxy.decodeLong(sb6, 0L) < decodeInt2) {
            aVar.f312930a = 4;
        }
        if (aVar.f312930a != 4) {
            vasMMKVProxy.encodeLong(sb6, currentTimeMillis);
        }
    }

    private static void b(String str, boolean z16, VasMMKVProxy vasMMKVProxy, a aVar) {
        if (z16) {
            String decodeString = vasMMKVProxy.decodeString("toastText", "");
            ConcurrentHashMap<String, Boolean> concurrentHashMap = f312929a;
            if (concurrentHashMap.containsKey(str)) {
                decodeString = vasMMKVProxy.decodeString("shortToastText", "");
            } else {
                concurrentHashMap.put(str, Boolean.TRUE);
            }
            QQToast.makeText(BaseApplication.getContext(), 2, decodeString, vasMMKVProxy.decodeInt("toastShowTime", 2) * 1000).show();
        }
        aVar.f312930a = 1;
    }

    public static String c(String str) {
        String str2;
        String str3;
        VasMMKVProxy kingCard = VasMMKV.getKingCard(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        String decodeString = kingCard.decodeString("guideUrl", "");
        if (TextUtils.isEmpty(decodeString)) {
            decodeString = "https://mc.vip.qq.com/wkcenter/index?_wv=3&_nav_alpha=0&_wvx=3";
        }
        if (kingCard.decodeInt("kingCardSdk", 0) != 1 && kingCard.decodeInt(KingCardJsPlugin.BUSINESS_NAME, 0) != 1 && kingCard.decodeInt("kingCard2", 0) != 1) {
            str2 = "open";
        } else {
            str2 = "update";
        }
        if (!decodeString.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = (decodeString + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + "source=" + str + "&type=" + str2;
        } else {
            str3 = decodeString + "&source=" + str + "&type=" + str2;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CUKingCardHelper", 2, "open guide url: " + str3);
        }
        return str3;
    }

    public static int d() {
        return e.a();
    }

    public static a e(String str, boolean z16, boolean z17) {
        VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P1", str, 1, 0, 0, "", "", "");
        VasMMKVProxy kingCard = VasMMKV.getKingCard(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        a aVar = new a();
        aVar.f312931b = c(str);
        if (!kingCard.decodeBool("guideEnable", false)) {
            QLog.i("CUKingCardHelper", 2, "not in CUKing Card gray uin!");
            aVar.f312930a = 4;
        } else if (kingCard.decodeInt("guideToastOpen", 0) == 1) {
            b(str, z17, kingCard, aVar);
        } else if (kingCard.decodeInt("guidePopupOpen", 0) == 1) {
            a(str, z16, kingCard, aVar);
        } else {
            aVar.f312930a = 4;
        }
        f(str, aVar);
        return aVar;
    }

    private static void f(String str, a aVar) {
        String str2;
        int i3 = aVar.f312930a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    str2 = "P3";
                } else {
                    str2 = "P4";
                }
            } else {
                str2 = "P2";
            }
        } else {
            str2 = "P5";
        }
        VasWebviewUtil.reportCommercialDrainage("", "wkclub", str2, str, 1, 0, 0, "", "", "");
    }

    public static void g(TrafficResultInfo trafficResultInfo, Bundle bundle) {
        if (trafficResultInfo == null) {
            QLog.e("CUKingCardHelper", 1, "saveCUKingInfo error : trafficInfo = null");
            return;
        }
        if (trafficResultInfo.bUpdate == 0) {
            QLog.e("CUKingCardHelper", 1, "bUpdate=" + trafficResultInfo.bUpdate + " it do not need to update CUKing info");
            return;
        }
        h(trafficResultInfo, bundle);
    }

    private static void h(TrafficResultInfo trafficResultInfo, Bundle bundle) {
        boolean z16;
        boolean z17;
        boolean z18 = bundle.getBoolean(VipInfoHandler.H);
        boolean z19 = bundle.getBoolean(VipInfoHandler.I);
        String string = bundle.getString(VipInfoHandler.J);
        String string2 = bundle.getString(VipInfoHandler.K);
        VasMMKVProxy kingCard = VasMMKV.getKingCard(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        if (z18) {
            QLog.i("CUKingCardHelper", 2, "Save CUKing Card Order State, State1: " + trafficResultInfo.iWkOrderState1);
            kingCard.encodeInt(KingCardJsPlugin.BUSINESS_NAME, trafficResultInfo.iWkOrderState1);
            if (TextUtils.isEmpty(string)) {
                string = "";
            }
            kingCard.encodeString("imsiOne", string);
            kingCard.encodeLong("kingCardLastRequest", System.currentTimeMillis() / 1000);
        }
        if (z19) {
            QLog.i("CUKingCardHelper", 2, "Save CUKing Card Order State, State2: " + trafficResultInfo.iWkOrderState2);
            kingCard.encodeInt("kingCard2", trafficResultInfo.iWkOrderState2);
            if (TextUtils.isEmpty(string2)) {
                string2 = "";
            }
            kingCard.encodeString("imsiTwo", string2);
            kingCard.encodeLong("kingCardLastRequest", System.currentTimeMillis() / 1000);
        }
        if (trafficResultInfo.iDrawerEnable == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        kingCard.encodeBool("drawerEnable", z16);
        if (trafficResultInfo.iGuideEnable == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        kingCard.encodeBool("guideEnable", z17);
        kingCard.encodeString("drawerText", trafficResultInfo.sDrawerText);
        kingCard.encodeString("drawerTextID", String.valueOf(trafficResultInfo.iDrawerTextId));
        kingCard.encodeString("drawerUrl", trafficResultInfo.sDrawerUrl);
        QLog.i("CUKingCardHelper", 1, "saveCUKingInfo, sDrawerText=" + trafficResultInfo.sDrawerText + " sDrawerUrl=" + trafficResultInfo.sDrawerUrl + " iDrawerEnable=" + trafficResultInfo.iDrawerEnable + " iGuideEnable=" + trafficResultInfo.iGuideEnable);
        kingCard.encodeString("guideUrl", trafficResultInfo.sGuideUrl);
        kingCard.encodeString("sDrawerTextRuleID", trafficResultInfo.sDrawerTextRuleID);
        kingCard.encodeInt("kingCardRequestInterval", trafficResultInfo.iImsiInterval);
        if (trafficResultInfo.popInfo != null) {
            int decodeInt = kingCard.decodeInt("popup_version_v2", 0);
            PopupImgInfo popupImgInfo = trafficResultInfo.popInfo;
            kingCard.encodeInt("guidePopupOpen", popupImgInfo.iOpen);
            kingCard.encodeInt("popupRate", popupImgInfo.iRate);
            kingCard.encodeInt("popupRateType", popupImgInfo.iRateType);
            if (decodeInt != popupImgInfo.iPopupVer) {
                kingCard.encodeString("guidePopupText_v2", popupImgInfo.sPopupText);
                kingCard.encodeString("guideJumpText_v2", popupImgInfo.sRedirectText);
                kingCard.encodeString("guideContinueText_v2", popupImgInfo.sContinueText);
                kingCard.encodeString("guidePopupImgUrl_v2", popupImgInfo.sPopupImgUrl);
                kingCard.encodeInt("popup_version_v2", popupImgInfo.iPopupVer);
            }
            QLog.i("CUKingCardHelper", 2, "saveCUKingInfo, popup open : " + popupImgInfo.iOpen + " ver:" + popupImgInfo.iPopupVer);
        }
        if (trafficResultInfo.toasInfo != null) {
            int decodeInt2 = kingCard.decodeInt("toast_version", 0);
            ToastImgInfo toastImgInfo = trafficResultInfo.toasInfo;
            kingCard.encodeInt("guideToastOpen", toastImgInfo.iOpen);
            kingCard.encodeInt("toastShowTime", toastImgInfo.iShowTime);
            if (decodeInt2 != toastImgInfo.iToastVer) {
                kingCard.encodeString("toastText", toastImgInfo.sText);
                kingCard.encodeString("shortToastText", toastImgInfo.sShortText);
                kingCard.encodeInt("toast_version", toastImgInfo.iToastVer);
            }
            QLog.i("CUKingCardHelper", 2, "saveCUKingInfo, toast open : " + toastImgInfo.iOpen + " ver:" + toastImgInfo.iToastVer);
        }
    }

    public static boolean i(Activity activity, int i3, b bVar, String str) {
        if (activity != null && !activity.isFinishing()) {
            a e16 = e(str, false, true);
            if (QLog.isColorLevel()) {
                QLog.i("CUKingCardHelper", 2, "shouldOverrideDialog, popUpType: " + e16.f312930a);
            }
            int i16 = e16.f312930a;
            if (i16 == 4) {
                return true;
            }
            if (i16 == 1) {
                if (bVar != null) {
                    bVar.callback(2);
                }
                return false;
            }
            new c(activity, bVar, i3, str, e16.f312930a).show();
        }
        return false;
    }
}
