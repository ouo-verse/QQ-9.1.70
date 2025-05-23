package com.tencent.mobileqq.mini.util;

import NS_COMM.COMM;
import NS_MINI_AD.MiniAppAd$ContextInfo;
import NS_MINI_AD.MiniAppAd$DebugInfo;
import NS_MINI_AD.MiniAppAd$DeviceInfo;
import NS_MINI_AD.MiniAppAd$Location;
import NS_MINI_AD.MiniAppAd$PositionExt;
import NS_MINI_AD.MiniAppAd$PositionInfo;
import NS_MINI_AD.MiniAppAd$ShareInfo;
import NS_MINI_AD.MiniAppAd$SpecifiedAdsItem;
import NS_MINI_AD.MiniAppAd$StGetAdReq;
import NS_MINI_AD.MiniAppAd$UserInfo;
import NS_MINI_INTERFACE.INTERFACE$DeviceInfo;
import NS_MINI_INTERFACE.INTERFACE$Location;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AdUtils {
    public static final int AD_EXPOSURE_EXP_ID = 95807;
    public static final String AD_GDT_COOKIE_PRE = "gdt_cookie";
    public static final int AD_REWARD_SHOW_TIME_EXP_ID = 103300;
    public static final int DEVICE_ORIENTATION_LANDSCAPE = 90;
    public static final int DEVICE_ORIENTATION_PORTRAIT = 0;
    public static final String KEY_AD_STYLE_TYPE = "key_ad_style_type";
    public static final String MINI_BUSINESS_ID = "e8d69a";
    private static final float RATIO_MIN_SCREEN = 0.71f;
    private static final String TAG = "AdUtils";

    AdUtils() {
    }

    public static String appendToJson(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(str2, str3);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "appendAdStyleToJson error" + e16);
            return str;
        }
    }

    public static List<GdtAd> convertJson2GdtAds(String str) {
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list;
        ArrayList arrayList = new ArrayList();
        try {
            list = ((qq_ad_get.QQAdGetRsp) qq_ad_get.QQAdGetRsp.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp(), new JSONObject(str)))).pos_ads_info.get();
        } catch (Exception e16) {
            GdtLog.e(TAG, "convertJson2GdtAds", e16);
        }
        if (list != null && !list.isEmpty()) {
            arrayList.clear();
            Iterator<qq_ad_get.QQAdGetRsp.PosAdInfo> it = list.iterator();
            while (it.hasNext()) {
                List<qq_ad_get.QQAdGetRsp.AdInfo> list2 = it.next().ads_info.get();
                if (list2 != null && !list2.isEmpty()) {
                    Iterator<qq_ad_get.QQAdGetRsp.AdInfo> it5 = list2.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(new GdtAd(it5.next()));
                    }
                }
                GdtLog.e(TAG, "convertJson2GdtAds() adInfos.isEmpty");
            }
            GdtLog.d(TAG, "convertJson2GdtAds() result = [" + Arrays.toString(arrayList.toArray()) + "]");
            return arrayList;
        }
        GdtLog.e(TAG, "convertJson2GdtAds() posAdInfos.isEmpty");
        return arrayList;
    }

    public static MiniAppAd$StGetAdReq createAdRequest(Context context, long j3, String str, String str2, int i3, int i16, int i17, String str3, String str4, String str5, String str6, String str7, int i18, int i19, List<MiniAppAd$SpecifiedAdsItem> list) {
        MiniAppAd$UserInfo miniAppAd$UserInfo = new MiniAppAd$UserInfo();
        miniAppAd$UserInfo.f24939qq.set(j3);
        MiniAppAd$PositionInfo miniAppAd$PositionInfo = new MiniAppAd$PositionInfo();
        MiniAppAd$PositionExt miniAppAd$PositionExt = new MiniAppAd$PositionExt();
        miniAppAd$PositionExt.sub_position_id.set(str, true);
        MiniAppAd$ShareInfo miniAppAd$ShareInfo = new MiniAppAd$ShareInfo();
        miniAppAd$ShareInfo.share_rate.set(i3);
        miniAppAd$PositionExt.share_info.set(miniAppAd$ShareInfo);
        miniAppAd$PositionExt.deep_link_version.set(1, true);
        if (i19 != 0) {
            miniAppAd$PositionExt.get_ad_type.set(i19, true);
            if (i19 == 2 && list != null && list.size() > 0) {
                miniAppAd$PositionExt.specified_ads.addAll(list);
            }
        }
        miniAppAd$PositionInfo.ad_count.set(i18, true);
        miniAppAd$PositionInfo.pos_ext.set(miniAppAd$PositionExt, true);
        MiniAppAd$DeviceInfo deviceInfo = getDeviceInfo(context, i17);
        MiniAppAd$ContextInfo miniAppAd$ContextInfo = new MiniAppAd$ContextInfo();
        MiniAppAd$DebugInfo miniAppAd$DebugInfo = new MiniAppAd$DebugInfo();
        MiniAppAd$StGetAdReq miniAppAd$StGetAdReq = new MiniAppAd$StGetAdReq();
        miniAppAd$StGetAdReq.user_info.set(miniAppAd$UserInfo);
        miniAppAd$StGetAdReq.position_info.add(miniAppAd$PositionInfo);
        miniAppAd$StGetAdReq.device_info.set(deviceInfo);
        miniAppAd$StGetAdReq.context_info.set(miniAppAd$ContextInfo);
        miniAppAd$StGetAdReq.debug_info.set(miniAppAd$DebugInfo);
        miniAppAd$StGetAdReq.appid.set(str2);
        miniAppAd$StGetAdReq.ad_type.set(i16);
        miniAppAd$StGetAdReq.gdt_cookie.set(str3);
        miniAppAd$StGetAdReq.extInfo.mapInfo.add(newEntry("queryData", str4));
        miniAppAd$StGetAdReq.extInfo.mapInfo.add(newEntry("reportData", str5));
        miniAppAd$StGetAdReq.extInfo.mapInfo.add(newEntry("refer", str6));
        miniAppAd$StGetAdReq.extInfo.mapInfo.add(newEntry("via", str7));
        miniAppAd$StGetAdReq.client_mod.set(GdtDeviceInfoHelper.getClientMode());
        return miniAppAd$StGetAdReq;
    }

    public static MiniAppAd$DeviceInfo getDeviceInfo(Context context, int i3) {
        GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
        params.supportOpenMotiveAd = true;
        long currentTimeMillis = System.currentTimeMillis();
        GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(context, params);
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = create != null ? create.deviceInfo : null;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("get deviceInfo cost\uff1a");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        sb5.append(", result = ");
        sb5.append(deviceInfo != null);
        QLog.i(TAG, 2, sb5.toString());
        MiniAppAd$DeviceInfo miniAppAd$DeviceInfo = new MiniAppAd$DeviceInfo();
        if (deviceInfo != null) {
            miniAppAd$DeviceInfo.muid.set(deviceInfo.muid.get());
            miniAppAd$DeviceInfo.muid_type.set(deviceInfo.muid_type.get());
            miniAppAd$DeviceInfo.conn.set(deviceInfo.conn.get());
            miniAppAd$DeviceInfo.carrier_code.set(deviceInfo.carrier_code.get());
            miniAppAd$DeviceInfo.os_ver.set(deviceInfo.os_ver.get());
            miniAppAd$DeviceInfo.qq_ver.set(deviceInfo.qq_ver.get());
            miniAppAd$DeviceInfo.os_type.set(deviceInfo.os_type.get());
            miniAppAd$DeviceInfo.manufacturer.set(deviceInfo.manufacturer.get());
            miniAppAd$DeviceInfo.device_brand_and_model.set(deviceInfo.device_brand_and_model.get());
            miniAppAd$DeviceInfo.qadid.set(deviceInfo.qadid.get());
            miniAppAd$DeviceInfo.app_version_id.set(deviceInfo.app_version_id.get());
            miniAppAd$DeviceInfo.device_orientation.set(i3);
            miniAppAd$DeviceInfo.brand.set(deviceInfo.brand.get());
            if (deviceInfo.taid_ticket.has()) {
                miniAppAd$DeviceInfo.taid_ticket.set(deviceInfo.taid_ticket.get());
            }
            if (deviceInfo.aid_ticket.has()) {
                miniAppAd$DeviceInfo.aid_ticket.set(deviceInfo.aid_ticket.get());
            }
            if (deviceInfo.client_ipv4.has()) {
                miniAppAd$DeviceInfo.client_ipv4.set(deviceInfo.client_ipv4.get());
            }
            if (deviceInfo.location.has() && deviceInfo.location.coordinates_type.has() && deviceInfo.location.latitude.has() && deviceInfo.location.longitude.has()) {
                MiniAppAd$Location miniAppAd$Location = new MiniAppAd$Location();
                miniAppAd$Location.coordinates_type.set(deviceInfo.location.coordinates_type.get());
                miniAppAd$Location.latitude.set(deviceInfo.location.latitude.get());
                miniAppAd$Location.longitude.set(deviceInfo.location.longitude.get());
                miniAppAd$DeviceInfo.location.set(miniAppAd$Location);
            }
            String str = deviceInfo.device_ext.get();
            if (!TextUtils.isEmpty(str)) {
                miniAppAd$DeviceInfo.device_ext.set(str);
            }
            QLog.i(TAG, 1, "oaid = " + deviceInfo.oaid.get() + ", taid_ticket = " + deviceInfo.taid_ticket.get() + ", aid_ticket = " + deviceInfo.aid_ticket.get() + ", client_ipv4 = " + deviceInfo.client_ipv4.get());
        }
        return miniAppAd$DeviceInfo;
    }

    private static String getGdtCookieSpKey(int i3) {
        return "gdt_cookie_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + i3;
    }

    public static Pair<Integer, Integer> getScreenSize(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public static String getSpAdGdtCookie(int i3) {
        return StorageUtil.getPreference().getString(getGdtCookieSpKey(i3), "");
    }

    public static String getValueFromJson(String str, String str2) {
        try {
            return new JSONObject(str).optString(str2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "appendAdStyleToJson error" + e16);
            return "";
        }
    }

    public static boolean isFolderScreenOpenMode(Context context) {
        int intValue = ((Integer) getScreenSize(context).first).intValue();
        int intValue2 = ((Integer) getScreenSize(context).second).intValue();
        boolean z16 = false;
        if (intValue > 0 && intValue2 > 0) {
            float f16 = (intValue * 1.0f) / intValue2;
            if (f16 >= RATIO_MIN_SCREEN && f16 <= 1.4084507f) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[isFolderScreenOpenMode] " + z16 + ",curRatio:" + f16);
            }
        }
        return z16;
    }

    public static COMM.Entry newEntry(String str, String str2) {
        COMM.Entry entry = new COMM.Entry();
        if (str != null) {
            entry.key.set(str);
        }
        if (str2 != null) {
            entry.value.set(str2);
        }
        return entry;
    }

    public static int parseToInt(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseToInt error" + e16);
            return i3;
        }
    }

    public static String getFileSuffixByUrl(String str) {
        String str2;
        int lastIndexOf;
        int i3;
        try {
            str = new URL(str).getPath();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getFileSuffixByUrl error", e16);
        }
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) != -1 && (i3 = lastIndexOf + 1) < str.length()) {
            str2 = str.substring(i3);
        } else {
            str2 = "";
        }
        return "." + str2;
    }

    public static List<AdProxy.ExpParam> getExpParam(GdtAd gdtAd) {
        if (gdtAd == null) {
            return null;
        }
        try {
            List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap = gdtAd.getExpMap();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < expMap.size(); i3++) {
                arrayList.add(new AdProxy.ExpParam(expMap.get(i3).key.get(), expMap.get(i3).value.get()));
            }
            return arrayList;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "exp_map error" + th5);
            return null;
        }
    }

    public static String getExpValueByKey(GdtAd gdtAd, int i3) {
        if (gdtAd != null) {
            try {
                List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap = gdtAd.getExpMap();
                for (int i16 = 0; i16 < expMap.size(); i16++) {
                    if (expMap.get(i16).key.get() == i3) {
                        return expMap.get(i16).value.get();
                    }
                }
                return "";
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "exp_map error" + th5);
                return "";
            }
        }
        return "";
    }

    public static int getRewardVideoShowTimeFromExp(GdtAd gdtAd) {
        String expValueByKey = getExpValueByKey(gdtAd, 103300);
        QLog.i(TAG, 1, "getRewardVideoShowTimeFromExp = " + expValueByKey);
        if (TextUtils.isEmpty(expValueByKey)) {
            return -1;
        }
        try {
            return Integer.valueOf(expValueByKey).intValue();
        } catch (NumberFormatException e16) {
            QLog.i(TAG, 1, "getRewardVideoShowTimeFromExp error", e16);
            return -1;
        }
    }

    public static boolean isHitExp(GdtAd gdtAd, int i3) {
        if (gdtAd == null) {
            return false;
        }
        try {
            List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap = gdtAd.getExpMap();
            for (int i16 = 0; i16 < expMap.size(); i16++) {
                if (expMap.get(i16).key.get() == i3 && expMap.get(i16).value.get().equals("1")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "exp_map error" + th5);
            return false;
        }
    }

    public static MiniAppAd$StGetAdReq createAdRequest(Context context, long j3, String str, String str2, int i3, int i16, int i17, String str3, String str4, String str5, String str6, String str7) {
        return createAdRequest(context, j3, str, str2, i3, i16, i17, str3, str4, str5, str6, str7, 1);
    }

    public static MiniAppAd$StGetAdReq createAdRequest(Context context, long j3, String str, String str2, int i3, int i16, int i17, String str3, String str4, String str5, String str6, String str7, int i18) {
        return createAdRequest(context, j3, str, str2, i3, i16, i17, str3, str4, str5, str6, str7, i18, 0, null);
    }

    public static INTERFACE$DeviceInfo getDeviceInfo(Context context) {
        GdtDeviceInfoHelper.Params params = new GdtDeviceInfoHelper.Params();
        params.supportOpenMotiveAd = true;
        GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(context, params);
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = create != null ? create.deviceInfo : null;
        INTERFACE$DeviceInfo iNTERFACE$DeviceInfo = new INTERFACE$DeviceInfo();
        if (deviceInfo != null) {
            iNTERFACE$DeviceInfo.muid.set(deviceInfo.muid.get());
            iNTERFACE$DeviceInfo.muid_type.set(deviceInfo.muid_type.get());
            iNTERFACE$DeviceInfo.conn.set(deviceInfo.conn.get());
            iNTERFACE$DeviceInfo.carrier_code.set(deviceInfo.carrier_code.get());
            iNTERFACE$DeviceInfo.os_ver.set(deviceInfo.os_ver.get());
            iNTERFACE$DeviceInfo.qq_ver.set(deviceInfo.qq_ver.get());
            iNTERFACE$DeviceInfo.os_type.set(deviceInfo.os_type.get());
            iNTERFACE$DeviceInfo.manufacturer.set(deviceInfo.manufacturer.get());
            iNTERFACE$DeviceInfo.device_brand_and_model.set(deviceInfo.device_brand_and_model.get());
            iNTERFACE$DeviceInfo.qadid.set(deviceInfo.qadid.get());
            iNTERFACE$DeviceInfo.app_version_id.set(deviceInfo.app_version_id.get());
            iNTERFACE$DeviceInfo.device_orientation.set(0);
            if (deviceInfo.taid_ticket.has()) {
                iNTERFACE$DeviceInfo.taid_ticket.set(deviceInfo.taid_ticket.get());
            }
            if (deviceInfo.aid_ticket.has()) {
                iNTERFACE$DeviceInfo.aid_ticket.set(deviceInfo.aid_ticket.get());
            }
            if (deviceInfo.client_ipv4.has()) {
                iNTERFACE$DeviceInfo.client_ipv4.set(deviceInfo.client_ipv4.get());
            }
            if (deviceInfo.location.has() && deviceInfo.location.coordinates_type.has() && deviceInfo.location.latitude.has() && deviceInfo.location.longitude.has()) {
                INTERFACE$Location iNTERFACE$Location = new INTERFACE$Location();
                iNTERFACE$Location.coordinates_type.set(deviceInfo.location.coordinates_type.get());
                iNTERFACE$Location.latitude.set(deviceInfo.location.latitude.get());
                iNTERFACE$Location.longitude.set(deviceInfo.location.longitude.get());
                iNTERFACE$DeviceInfo.location.set(iNTERFACE$Location);
            }
            QLog.d(TAG, 1, "oaid = " + deviceInfo.oaid.get() + ", taid_ticket = " + deviceInfo.taid_ticket.get() + ", aid_ticket = " + deviceInfo.aid_ticket.get() + ", client_ipv4 = " + deviceInfo.client_ipv4.get());
        }
        return iNTERFACE$DeviceInfo;
    }
}
