package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneCardJsHandleLogic {
    public static final String CARDDECORATE_SP_KEY = "key_personalize_prefix_18";
    public static final String CARDTAG = "QZoneCardLogic";
    public static final String KEY_PERSONALIZE_PREFIX = "key_personalize_prefix";
    public static final String TAG = "QZoneCardJsHandleLogicQZonePersonalizePlugin";

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleDownCardMethod(WebViewPlugin.b bVar, String... strArr) {
        String str;
        String str2 = "";
        if (strArr == null || strArr.length <= 0) {
            str = "";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                str = jSONObject.getString("cardid");
                try {
                    str2 = jSONObject.getString("cardurl");
                } catch (JSONException e16) {
                    e = e16;
                    e.printStackTrace();
                    if (QLog.isDevelopLevel()) {
                    }
                    Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
                    Bundle bundle = new Bundle();
                    bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_DOWNLOADCARD);
                    bundle.putString("cardDownloadUrl", str2);
                    intent.putExtras(bundle);
                    QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
                }
            } catch (JSONException e17) {
                e = e17;
                str = "";
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QZoneCardLogic.QZoneCardJsHandleLogicQZonePersonalizePlugin", 4, "handleDownCardMethod js give download cardurl is: " + str2 + "\t cardid:" + str);
        }
        Intent intent2 = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
        Bundle bundle2 = new Bundle();
        bundle2.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_DOWNLOADCARD);
        bundle2.putString("cardDownloadUrl", str2);
        intent2.putExtras(bundle2);
        QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0245  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleSetSkinFinish(WebViewPlugin webViewPlugin, WebViewPlugin.b bVar, String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        int i3;
        long j3;
        int i16;
        boolean z16;
        int i17;
        int i18;
        int i19;
        String str18;
        JSONException jSONException;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        boolean z17;
        int i26;
        int i27;
        long j16;
        int i28;
        JSONObject jSONObject;
        int optInt;
        String str28;
        int optInt2;
        if (strArr == null || strArr.length <= 0) {
            str = "sSkinType";
            str2 = "isAfter785";
            str3 = "iFrameRate";
            str4 = "strFrameZip";
            str5 = "gradientColorEnd";
            str6 = "gradientColorBegin";
            str7 = "bgColor";
            str8 = "";
            str9 = str8;
            str10 = str9;
            str11 = str10;
            str12 = str11;
            str13 = str12;
            str14 = str13;
            str15 = str14;
            str16 = str15;
            str17 = str16;
            i3 = 0;
            j3 = 0;
            i16 = 0;
            z16 = false;
            i17 = 0;
            i18 = 0;
        } else {
            try {
                jSONObject = new JSONObject(strArr[0]);
                str19 = jSONObject.getString("result");
                try {
                    str20 = jSONObject.getString("sPicUrl");
                } catch (JSONException e16) {
                    str = "sSkinType";
                    jSONException = e16;
                    str8 = "";
                    str20 = str8;
                    str21 = str20;
                    str22 = str21;
                    str23 = str22;
                    str24 = str23;
                    str25 = str24;
                    str26 = str25;
                    str27 = str26;
                    i16 = 0;
                    z17 = false;
                    i26 = 0;
                    i27 = 0;
                    j16 = 0;
                    i28 = i27;
                    jSONException.printStackTrace();
                    str6 = "gradientColorBegin";
                    str14 = str24;
                    str15 = str25;
                    str16 = str26;
                    str17 = str27;
                    String str29 = str20;
                    str2 = "isAfter785";
                    i3 = i26;
                    str13 = str19;
                    z16 = z17;
                    str12 = str21;
                    i17 = i28;
                    str3 = "iFrameRate";
                    str9 = str29;
                    long j17 = j16;
                    str4 = "strFrameZip";
                    str5 = "gradientColorEnd";
                    str10 = str22;
                    j3 = j17;
                    i18 = 0;
                    String str30 = str23;
                    str7 = "bgColor";
                    str11 = str30;
                    String str31 = str11;
                    if (QLog.isDevelopLevel()) {
                    }
                    if (str13.equals("success")) {
                    }
                }
            } catch (JSONException e17) {
                str = "sSkinType";
                jSONException = e17;
                str8 = "";
                str19 = str8;
                str20 = str19;
            }
            try {
                str21 = jSONObject.getString("sSkinId");
                try {
                    optInt = jSONObject.optInt("sSkinType");
                    str = "sSkinType";
                } catch (JSONException e18) {
                    str = "sSkinType";
                    jSONException = e18;
                    str8 = "";
                    str22 = str8;
                    str23 = str22;
                    str24 = str23;
                    str25 = str24;
                    str26 = str25;
                    str27 = str26;
                    i16 = 0;
                    z17 = false;
                    i26 = 0;
                    i27 = 0;
                    j16 = 0;
                    i28 = i27;
                    jSONException.printStackTrace();
                    str6 = "gradientColorBegin";
                    str14 = str24;
                    str15 = str25;
                    str16 = str26;
                    str17 = str27;
                    String str292 = str20;
                    str2 = "isAfter785";
                    i3 = i26;
                    str13 = str19;
                    z16 = z17;
                    str12 = str21;
                    i17 = i28;
                    str3 = "iFrameRate";
                    str9 = str292;
                    long j172 = j16;
                    str4 = "strFrameZip";
                    str5 = "gradientColorEnd";
                    str10 = str22;
                    j3 = j172;
                    i18 = 0;
                    String str302 = str23;
                    str7 = "bgColor";
                    str11 = str302;
                    String str312 = str11;
                    if (QLog.isDevelopLevel()) {
                    }
                    if (str13.equals("success")) {
                    }
                }
                try {
                    boolean optBoolean = jSONObject.optBoolean("isAfter785", false);
                    try {
                        String optString = jSONObject.optString(AvatarCacheData.STRTRACEINFO);
                        try {
                            str22 = jSONObject.optString("title");
                            try {
                                j16 = jSONObject.optLong("uiSettleTime");
                                try {
                                    int optInt3 = jSONObject.optInt(FacadeCacheData.f47632VIP);
                                    try {
                                        str23 = jSONObject.optString("musicurl");
                                        try {
                                            str28 = optString;
                                            boolean z18 = jSONObject.optInt("need_jump") == 1;
                                            if (optInt != 392) {
                                                str24 = "";
                                                str25 = str24;
                                                str26 = str25;
                                                str27 = str26;
                                                optInt2 = 0;
                                            } else {
                                                try {
                                                    str20 = jSONObject.optString("bgPic");
                                                    str24 = jSONObject.optString("bgColor");
                                                } catch (JSONException e19) {
                                                    e = e19;
                                                    i26 = optInt;
                                                    str24 = "";
                                                    str25 = str24;
                                                }
                                                try {
                                                    str25 = jSONObject.optString("gradientColorBegin");
                                                } catch (JSONException e26) {
                                                    e = e26;
                                                    i26 = optInt;
                                                    str25 = "";
                                                    str26 = str25;
                                                    str27 = str26;
                                                    z17 = z18;
                                                    i16 = optInt3;
                                                    jSONException = e;
                                                    str8 = str28;
                                                    i28 = optBoolean;
                                                    jSONException.printStackTrace();
                                                    str6 = "gradientColorBegin";
                                                    str14 = str24;
                                                    str15 = str25;
                                                    str16 = str26;
                                                    str17 = str27;
                                                    String str2922 = str20;
                                                    str2 = "isAfter785";
                                                    i3 = i26;
                                                    str13 = str19;
                                                    z16 = z17;
                                                    str12 = str21;
                                                    i17 = i28;
                                                    str3 = "iFrameRate";
                                                    str9 = str2922;
                                                    long j1722 = j16;
                                                    str4 = "strFrameZip";
                                                    str5 = "gradientColorEnd";
                                                    str10 = str22;
                                                    j3 = j1722;
                                                    i18 = 0;
                                                    String str3022 = str23;
                                                    str7 = "bgColor";
                                                    str11 = str3022;
                                                    String str3122 = str11;
                                                    if (QLog.isDevelopLevel()) {
                                                    }
                                                    if (str13.equals("success")) {
                                                    }
                                                }
                                                try {
                                                    str26 = jSONObject.optString("gradientColorEnd");
                                                    try {
                                                        str27 = jSONObject.optString("strFrameZip");
                                                    } catch (JSONException e27) {
                                                        e = e27;
                                                        i26 = optInt;
                                                        str27 = "";
                                                    }
                                                    try {
                                                        optInt2 = jSONObject.optInt("iFrameRate");
                                                    } catch (JSONException e28) {
                                                        e = e28;
                                                        i26 = optInt;
                                                        z17 = z18;
                                                        i16 = optInt3;
                                                        jSONException = e;
                                                        str8 = str28;
                                                        i28 = optBoolean;
                                                        jSONException.printStackTrace();
                                                        str6 = "gradientColorBegin";
                                                        str14 = str24;
                                                        str15 = str25;
                                                        str16 = str26;
                                                        str17 = str27;
                                                        String str29222 = str20;
                                                        str2 = "isAfter785";
                                                        i3 = i26;
                                                        str13 = str19;
                                                        z16 = z17;
                                                        str12 = str21;
                                                        i17 = i28;
                                                        str3 = "iFrameRate";
                                                        str9 = str29222;
                                                        long j17222 = j16;
                                                        str4 = "strFrameZip";
                                                        str5 = "gradientColorEnd";
                                                        str10 = str22;
                                                        j3 = j17222;
                                                        i18 = 0;
                                                        String str30222 = str23;
                                                        str7 = "bgColor";
                                                        str11 = str30222;
                                                        String str31222 = str11;
                                                        if (QLog.isDevelopLevel()) {
                                                        }
                                                        if (str13.equals("success")) {
                                                        }
                                                    }
                                                } catch (JSONException e29) {
                                                    e = e29;
                                                    i26 = optInt;
                                                    str26 = "";
                                                    str27 = str26;
                                                    z17 = z18;
                                                    i16 = optInt3;
                                                    jSONException = e;
                                                    str8 = str28;
                                                    i28 = optBoolean;
                                                    jSONException.printStackTrace();
                                                    str6 = "gradientColorBegin";
                                                    str14 = str24;
                                                    str15 = str25;
                                                    str16 = str26;
                                                    str17 = str27;
                                                    String str292222 = str20;
                                                    str2 = "isAfter785";
                                                    i3 = i26;
                                                    str13 = str19;
                                                    z16 = z17;
                                                    str12 = str21;
                                                    i17 = i28;
                                                    str3 = "iFrameRate";
                                                    str9 = str292222;
                                                    long j172222 = j16;
                                                    str4 = "strFrameZip";
                                                    str5 = "gradientColorEnd";
                                                    str10 = str22;
                                                    j3 = j172222;
                                                    i18 = 0;
                                                    String str302222 = str23;
                                                    str7 = "bgColor";
                                                    str11 = str302222;
                                                    String str312222 = str11;
                                                    if (QLog.isDevelopLevel()) {
                                                    }
                                                    if (str13.equals("success")) {
                                                    }
                                                }
                                            }
                                            str13 = str19;
                                            str14 = str24;
                                            str15 = str25;
                                            str16 = str26;
                                            str17 = str27;
                                            z16 = z18;
                                            i16 = optInt3;
                                            str6 = "gradientColorBegin";
                                            int i29 = optInt2;
                                            str8 = str28;
                                            i18 = i29;
                                            String str32 = str20;
                                            str2 = "isAfter785";
                                            i3 = optInt;
                                            str12 = str21;
                                            i17 = optBoolean ? 1 : 0;
                                            str3 = "iFrameRate";
                                            str9 = str32;
                                            str4 = "strFrameZip";
                                            str5 = "gradientColorEnd";
                                            str10 = str22;
                                            j3 = j16;
                                            str7 = "bgColor";
                                            str11 = str23;
                                        } catch (JSONException e36) {
                                            e = e36;
                                            str28 = optString;
                                            i26 = optInt;
                                            str24 = "";
                                            str25 = str24;
                                            str26 = str25;
                                            str27 = str26;
                                            i16 = optInt3;
                                            z17 = false;
                                            jSONException = e;
                                            str8 = str28;
                                            i28 = optBoolean;
                                            jSONException.printStackTrace();
                                            str6 = "gradientColorBegin";
                                            str14 = str24;
                                            str15 = str25;
                                            str16 = str26;
                                            str17 = str27;
                                            String str2922222 = str20;
                                            str2 = "isAfter785";
                                            i3 = i26;
                                            str13 = str19;
                                            z16 = z17;
                                            str12 = str21;
                                            i17 = i28;
                                            str3 = "iFrameRate";
                                            str9 = str2922222;
                                            long j1722222 = j16;
                                            str4 = "strFrameZip";
                                            str5 = "gradientColorEnd";
                                            str10 = str22;
                                            j3 = j1722222;
                                            i18 = 0;
                                            String str3022222 = str23;
                                            str7 = "bgColor";
                                            str11 = str3022222;
                                            String str3122222 = str11;
                                            if (QLog.isDevelopLevel()) {
                                            }
                                            if (str13.equals("success")) {
                                            }
                                        }
                                    } catch (JSONException e37) {
                                        e = e37;
                                        str28 = optString;
                                        i26 = optInt;
                                        str23 = "";
                                        str24 = str23;
                                    }
                                } catch (JSONException e38) {
                                    str28 = optString;
                                    jSONException = e38;
                                    i26 = optInt;
                                    str23 = "";
                                    str24 = str23;
                                    str25 = str24;
                                    str26 = str25;
                                    str27 = str26;
                                    i16 = 0;
                                    z17 = false;
                                }
                            } catch (JSONException e39) {
                                str28 = optString;
                                jSONException = e39;
                                i26 = optInt;
                                str23 = "";
                                str24 = str23;
                                str25 = str24;
                                str26 = str25;
                                str27 = str26;
                                i16 = 0;
                                z17 = false;
                                j16 = 0;
                                str8 = str28;
                                i28 = optBoolean;
                                jSONException.printStackTrace();
                                str6 = "gradientColorBegin";
                                str14 = str24;
                                str15 = str25;
                                str16 = str26;
                                str17 = str27;
                                String str29222222 = str20;
                                str2 = "isAfter785";
                                i3 = i26;
                                str13 = str19;
                                z16 = z17;
                                str12 = str21;
                                i17 = i28;
                                str3 = "iFrameRate";
                                str9 = str29222222;
                                long j17222222 = j16;
                                str4 = "strFrameZip";
                                str5 = "gradientColorEnd";
                                str10 = str22;
                                j3 = j17222222;
                                i18 = 0;
                                String str30222222 = str23;
                                str7 = "bgColor";
                                str11 = str30222222;
                                String str31222222 = str11;
                                if (QLog.isDevelopLevel()) {
                                }
                                if (str13.equals("success")) {
                                }
                            }
                        } catch (JSONException e46) {
                            str28 = optString;
                            jSONException = e46;
                            i26 = optInt;
                            str22 = "";
                            str23 = str22;
                        }
                    } catch (JSONException e47) {
                        jSONException = e47;
                        i26 = optInt;
                        str8 = "";
                        str22 = str8;
                        str23 = str22;
                        str24 = str23;
                        str25 = str24;
                        str26 = str25;
                        str27 = str26;
                        i16 = 0;
                        z17 = false;
                        i27 = optBoolean;
                        j16 = 0;
                        i28 = i27;
                        jSONException.printStackTrace();
                        str6 = "gradientColorBegin";
                        str14 = str24;
                        str15 = str25;
                        str16 = str26;
                        str17 = str27;
                        String str292222222 = str20;
                        str2 = "isAfter785";
                        i3 = i26;
                        str13 = str19;
                        z16 = z17;
                        str12 = str21;
                        i17 = i28;
                        str3 = "iFrameRate";
                        str9 = str292222222;
                        long j172222222 = j16;
                        str4 = "strFrameZip";
                        str5 = "gradientColorEnd";
                        str10 = str22;
                        j3 = j172222222;
                        i18 = 0;
                        String str302222222 = str23;
                        str7 = "bgColor";
                        str11 = str302222222;
                        String str312222222 = str11;
                        if (QLog.isDevelopLevel()) {
                        }
                        if (str13.equals("success")) {
                        }
                    }
                } catch (JSONException e48) {
                    jSONException = e48;
                    i26 = optInt;
                    str8 = "";
                    str22 = str8;
                    str23 = str22;
                    str24 = str23;
                    str25 = str24;
                    str26 = str25;
                    str27 = str26;
                    i16 = 0;
                    z17 = false;
                    i27 = 0;
                    j16 = 0;
                    i28 = i27;
                    jSONException.printStackTrace();
                    str6 = "gradientColorBegin";
                    str14 = str24;
                    str15 = str25;
                    str16 = str26;
                    str17 = str27;
                    String str2922222222 = str20;
                    str2 = "isAfter785";
                    i3 = i26;
                    str13 = str19;
                    z16 = z17;
                    str12 = str21;
                    i17 = i28;
                    str3 = "iFrameRate";
                    str9 = str2922222222;
                    long j1722222222 = j16;
                    str4 = "strFrameZip";
                    str5 = "gradientColorEnd";
                    str10 = str22;
                    j3 = j1722222222;
                    i18 = 0;
                    String str3022222222 = str23;
                    str7 = "bgColor";
                    str11 = str3022222222;
                    String str3122222222 = str11;
                    if (QLog.isDevelopLevel()) {
                    }
                    if (str13.equals("success")) {
                    }
                }
            } catch (JSONException e49) {
                str = "sSkinType";
                jSONException = e49;
                str8 = "";
                str21 = str8;
                str22 = str21;
                str23 = str22;
                str24 = str23;
                str25 = str24;
                str26 = str25;
                str27 = str26;
                i16 = 0;
                z17 = false;
                i26 = 0;
                i27 = 0;
                j16 = 0;
                i28 = i27;
                jSONException.printStackTrace();
                str6 = "gradientColorBegin";
                str14 = str24;
                str15 = str25;
                str16 = str26;
                str17 = str27;
                String str29222222222 = str20;
                str2 = "isAfter785";
                i3 = i26;
                str13 = str19;
                z16 = z17;
                str12 = str21;
                i17 = i28;
                str3 = "iFrameRate";
                str9 = str29222222222;
                long j17222222222 = j16;
                str4 = "strFrameZip";
                str5 = "gradientColorEnd";
                str10 = str22;
                j3 = j17222222222;
                i18 = 0;
                String str30222222222 = str23;
                str7 = "bgColor";
                str11 = str30222222222;
                String str31222222222 = str11;
                if (QLog.isDevelopLevel()) {
                }
                if (str13.equals("success")) {
                }
            }
        }
        String str312222222222 = str11;
        if (QLog.isDevelopLevel()) {
            str18 = "musicurl";
            StringBuilder sb5 = new StringBuilder();
            i19 = i3;
            sb5.append("handleSetSkinFinish result:");
            sb5.append(str13);
            sb5.append("js give cardurl is: ");
            sb5.append(str9);
            sb5.append("\t cardid:");
            sb5.append(str12);
            QLog.d("QZoneCardLogic.QZoneCardJsHandleLogicQZonePersonalizePlugin", 4, sb5.toString());
        } else {
            i19 = i3;
            str18 = "musicurl";
        }
        if (str13.equals("success")) {
            Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
            Bundle bundle = new Bundle();
            bundle.putString("sSkinId", str12);
            String str33 = str12;
            bundle.putLong("lUin", 0L);
            bundle.putString("sPicUrl", str9);
            bundle.putLong("lTime", j3);
            bundle.putString("desc", "");
            bundle.putString("title", str10);
            bundle.putInt(FacadeCacheData.f47632VIP, i16);
            bundle.putString(AvatarCacheData.STRTRACEINFO, str8);
            int i36 = i19;
            bundle.putInt(str, i36);
            bundle.putString(str18, str312222222222);
            bundle.putString(str7, str14);
            bundle.putString(str6, str15);
            bundle.putString(str5, str16);
            bundle.putString(str4, str17);
            bundle.putInt(str3, i18);
            bundle.putInt(str2, i17);
            bundle.putString("cmd", QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_SETCARDFINISH);
            intent.putExtras(bundle);
            if (QLog.isDevelopLevel()) {
                QLog.d("QZoneCardLogic.QZoneCardJsHandleLogicQZonePersonalizePlugin", 4, "handleSetSkinFinish broadcast actionString: " + intent.getAction() + "to qzone process,card lTime:" + j3 + ",type:" + i36 + ",musicurl:" + str312222222222);
            }
            QLog.i("@newcard", 1, "handleSetSkinFinish, newcard id:" + str33);
            QZoneHelper.forwardToQzoneTransluentActivity(bVar.a(), QZoneHelper.UserInfo.getInstance(), intent);
            LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_18", 0, Long.valueOf(bVar.b().getCurrentAccountUin()).longValue());
            VasLogReporter.getQzoneFeedsCard().report("CARDDECORATE_SP_KEY switch open, id:" + str33);
            if (z16) {
                QZoneHelper.forwardToUserHome(bVar.a(), QZoneHelper.UserInfo.getInstance(), bVar.b().getAccount(), 0, 0, 256);
            }
        }
    }
}
