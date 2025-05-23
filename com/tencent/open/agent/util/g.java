package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ads.data.AdParam;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.util.k;
import com.tencent.open.ticket.OpenTicketHelper;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qconn.protofile.appType$LoginSig;
import com.tencent.qconn.protofile.appType$PassData;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g {
    public static String A(Context context, String str, String str2) {
        t.f("AuthorityUtil", "getOpenId uin = " + str + ", appid = " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return lq3.b.a(context, "uin_openid_store").getString(str2 + ":" + str, null);
    }

    public static String B(@NonNull Activity activity) {
        String str = "";
        for (int i3 = 0; i3 < 3; i3++) {
            str = activity.getCallingPackage();
            t.b("AuthorityUtil", "getPkgName=", str);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity == null) {
                t.f("AuthorityUtil", "getPkgName component=null");
            } else {
                str = callingActivity.getPackageName();
                t.b("AuthorityUtil", "getPkgName getPackageName=", str);
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return str;
    }

    public static String C(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "0";
            }
            return str.substring(str.length() - 4);
        } catch (Exception unused) {
            return "0";
        }
    }

    public static void D(AppRuntime appRuntime, final String str, final boolean z16, final u uVar) {
        t.b("AuthorityUtil", "getUse540TicketStatus");
        OpenTicketHelper.c(str, true, new u() { // from class: com.tencent.open.agent.util.e
            @Override // com.tencent.open.agent.util.u
            public final void onResult(boolean z17, String str2) {
                g.K(z16, uVar, str, z17, str2);
            }
        });
    }

    public static boolean E(String str, AppRuntime appRuntime) {
        if (TextUtils.isEmpty(str)) {
            t.e("AuthorityUtil", "getDA2 false, currentAccount empty");
            return false;
        }
        if (appRuntime == null) {
            t.e("AuthorityUtil", "getDA2 false appInterface is null");
            return false;
        }
        TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
        if (ticketManager == null) {
            t.e("AuthorityUtil", "getDA2 false TicketManager is null");
            return false;
        }
        Ticket d2Ticket = ticketManager.getD2Ticket(str);
        if (d2Ticket == null) {
            return false;
        }
        byte[] bArr = d2Ticket._sig;
        if (bArr != null && bArr.length != 0) {
            return true;
        }
        return false;
    }

    public static boolean F(Activity activity) {
        if (!(activity instanceof AuthorityActivity) && !(activity instanceof PublicFragmentActivityForOpenSDK)) {
            return false;
        }
        return true;
    }

    public static boolean G(String str) {
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            QLog.d("AuthorityUtil", 1, "isRequestBySSO loginByNt");
            return true;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102942", false);
        QLog.d("AuthorityUtil", 1, "isRequestBySSO switch: " + isSwitchOn);
        if (r().contains(str) && isSwitchOn) {
            return true;
        }
        return false;
    }

    public static boolean H(AppRuntime appRuntime, String str, boolean z16) {
        byte[] l3 = l(str, appRuntime, true);
        if (!z16 && l3 != null && E(str, appRuntime)) {
            t.b("AuthorityUtil", "isUse540Ticket use qq cache");
            return false;
        }
        if (l(str, appRuntime, false) != null) {
            t.b("AuthorityUtil", "isUse540Ticket use opensdk cache");
            return true;
        }
        t.b("AuthorityUtil", "isUse540Ticket use qq skey cache");
        return false;
    }

    public static void I(Context context) {
        Intent intent = new Intent();
        intent.putExtra(GesturePWDUnlockActivity.KEY_GESTURE_FROM_AUTHORITY, true);
        RouteUtils.startActivityForResult(context, intent, RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(u uVar, boolean z16, String str) {
        t.b("AuthorityUtil", "getUse540TicketStatus checkUser openSdk TicketReady result = " + z16);
        uVar.onResult(z16, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(boolean z16, final u uVar, String str, boolean z17, String str2) {
        t.b("AuthorityUtil", "getUse540TicketStatus checkUserMainTicketReady result = " + z17 + ", forceTo540 = " + z16);
        if (z17 && !z16) {
            uVar.onResult(false, "main account ticket success");
        } else {
            OpenTicketHelper.c(str, false, new u() { // from class: com.tencent.open.agent.util.f
                @Override // com.tencent.open.agent.util.u
                public final void onResult(boolean z18, String str3) {
                    g.J(u.this, z18, str3);
                }
            });
        }
    }

    public static JSONObject L(fp3.b bVar, long j3, long j16, long j17, boolean z16) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret", bVar.f400227a.get());
        jSONObject.put("openid", bVar.f400231e.get());
        jSONObject.put(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, bVar.f400229c.get());
        jSONObject.put("pay_token", bVar.f400232f.get());
        jSONObject.put("expires_in", bVar.f400230d.get());
        if (z16) {
            jSONObject.put("code", bVar.f400245s.get());
            jSONObject.put("proxy_code", bVar.f400244r.code.get());
            jSONObject.put("proxy_expires_in", bVar.f400244r.expires_in.get());
        }
        jSONObject.put(AdParam.PF, bVar.f400234h.get());
        jSONObject.put("pfkey", bVar.f400235i.get());
        jSONObject.put("msg", bVar.f400228b.get());
        if (bVar.f400238l.has()) {
            jSONObject.put("sendinstall", bVar.f400238l.get());
        }
        if (bVar.f400239m.has() && !TextUtils.isEmpty(bVar.f400239m.get())) {
            jSONObject.put("installwording", bVar.f400239m.get());
        }
        if (bVar.f400240n.has() && bVar.f400240n.size() > 0) {
            for (appType$PassData apptype_passdata : bVar.f400240n.get()) {
                jSONObject.put(apptype_passdata.key.get(), apptype_passdata.value.get());
            }
        }
        jSONObject.put("login_cost", j3);
        jSONObject.put("query_authority_cost", j16);
        jSONObject.put("authority_cost", j17);
        return jSONObject;
    }

    public static boolean M(Activity activity, Intent intent) {
        if (intent != null && activity != null) {
            if (!intent.getBooleanExtra("param_is_qr_code_login", false)) {
                return false;
            }
            t.b("AuthorityUtil", "onActivityResult qrcode finish");
            Intent intent2 = new Intent();
            intent2.putExtra("param_qr_code_url", intent.getStringExtra("param_qr_code_url"));
            intent2.putExtra("param_is_qr_code_login", true);
            activity.setResult(-1, intent2);
            activity.finish();
            return true;
        }
        t.b("AuthorityUtil", "onQrCodeLoginFinish activity invalid");
        return false;
    }

    public static JSONObject N(String str) {
        try {
            URL url = new URL(str.replace("auth://", "https://"));
            JSONObject j3 = j(new JSONObject(), url.getQuery());
            j(j3, url.getRef());
            return j3;
        } catch (Exception e16) {
            t.a("AuthorityUtil", "parseUrlToJson", e16);
            return new JSONObject();
        }
    }

    public static void O(String str) {
        R(null, str, null);
    }

    public static void P(AppRuntime appRuntime, String str, int i3, int i16, String[] strArr) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (strArr == null) {
            ReportController.o(appRuntime, "dc00898", "", "", str, str, i16, i3, "", "", "", "");
            return;
        }
        if (strArr.length == 4) {
            String str6 = strArr[0];
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            String str7 = strArr[1];
            if (str7 == null) {
                str3 = "";
            } else {
                str3 = str7;
            }
            String str8 = strArr[2];
            if (str8 == null) {
                str4 = "";
            } else {
                str4 = str8;
            }
            String str9 = strArr[3];
            if (str9 == null) {
                str5 = "";
            } else {
                str5 = str9;
            }
            ReportController.o(appRuntime, "dc00898", "", "", str, str, i16, i3, str2, str3, str4, str5);
            return;
        }
        t.e("AuthorityUtil", "reportT invalid param");
    }

    public static void Q(AppRuntime appRuntime, String str, int i3, String[] strArr) {
        P(appRuntime, str, i3, 0, strArr);
    }

    public static void R(AppRuntime appRuntime, String str, String[] strArr) {
        Q(appRuntime, str, 0, strArr);
    }

    public static void S(long j3, String str, String str2) {
        int i3;
        if (j3 == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        String h16 = hp3.b.e().h(str, true);
        t.f("AuthorityUtil", "reportAuthResult: dwopResult(" + i3 + ") appId(" + str + ") sdkv(" + str2 + ") permission(" + h16 + ")");
        Q(null, "0X800BA80", i3, new String[]{str, "", str2, h16});
    }

    public static void T(GatewayVerify$ReqBody gatewayVerify$ReqBody, String str) {
        gatewayVerify$ReqBody.msg_req_common_info.uint32_req_support_self_phone_check.set(1);
        gatewayVerify$ReqBody.msg_req_common_info.bool_req_support_diff_passwd_can_verify.set(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_req_support_connect_pskey.set(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_req_passwd_err_support_identity_verify.set(true);
        gatewayVerify$ReqBody.msg_req_common_info.bool_not_realname_forbid_login_low_version.set(true);
        gatewayVerify$ReqBody.msg_req_common_info.setHasFlag(true);
        gatewayVerify$ReqBody.msg_req_connect_login.str_connect_data.set("appid=" + str + "&sdkp=a");
        gatewayVerify$ReqBody.msg_req_connect_login.setHasFlag(true);
    }

    public static void U(PBStringField pBStringField) {
        pBStringField.set("support_110537=1&login_type=0");
    }

    public static void V(String str) {
        t.b("AuthorityUtil", "syncLoginAccount-", C(str));
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null) {
            if (allAccounts.size() >= 8) {
                t.b("AuthorityUtil", "syncLoginAccount-max count=", Integer.valueOf(allAccounts.size()));
                return;
            }
            Iterator<SimpleAccount> it = allAccounts.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getUin())) {
                    t.b("AuthorityUtil", "syncLoginAccount-exist!!!");
                    return;
                }
            }
        }
        ReportController.o(null, "dc00898", "", "", "0X800AC2F", "0X800AC2F", 0, 0, "", "", "", "");
        t.b("AuthorityUtil", "sync opensdk account 0X800AC2F uin=", C(str));
        MsfSdkUtils.addLoginSimpleAccount(str, false);
        MobileQQ.sMobileQQ.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
        QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_on_sso_add_account_success", null, null);
        List<SimpleAccount> allAccounts2 = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts2 != null) {
            Iterator<SimpleAccount> it5 = allAccounts2.iterator();
            while (it5.hasNext()) {
                t.b("AuthorityUtil", "after syncLoginAccount " + C(it5.next().getUin()));
            }
        }
    }

    public static byte[] W(MessageMicro messageMicro, boolean z16, com.tencent.open.model.a aVar) {
        byte[] byteArray = messageMicro.toByteArray();
        if (z16) {
            return OpenSdkVirtualUtil.f(byteArray, aVar);
        }
        return byteArray;
    }

    public static String X(Object... objArr) {
        if (objArr != null && objArr.length % 2 == 0) {
            int length = objArr.length;
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 0; i3 < length - 1; i3 += 2) {
                try {
                    jSONObject.put(String.valueOf(objArr[i3]), objArr[i3 + 1]);
                } catch (JSONException e16) {
                    t.a("AuthorityUtil", "JSONException", e16);
                }
            }
            return jSONObject.toString();
        }
        t.b("AuthorityUtil", "toJSONString invalid params");
        return "";
    }

    public static void Y(Activity activity) {
        int i3;
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            Resources resources = activity.getResources();
            if (isNowThemeIsNight) {
                i3 = R.color.black;
            } else {
                i3 = R.color.f158017al3;
            }
            int color = resources.getColor(i3);
            SystemBarCompact systemBarCompact = new SystemBarCompact(activity, true, color);
            systemBarCompact.setStatusBarColor(color);
            systemBarCompact.init();
        }
        String str = Build.MANUFACTURER + DeviceInfoMonitor.getModel();
        if (!str.equals("MeizuPRO 7-S") && !str.equalsIgnoreCase("MeizuM711C")) {
            ImmersiveUtils.trySetImmersiveStatusBar(activity.getWindow());
        } else {
            ImmersiveUtils.clearCoverForStatus(activity.getWindow(), true);
        }
        ImmersiveUtils.setStatusTextColor(!isNowThemeIsNight, activity.getWindow());
    }

    public static Bundle c(Object... objArr) {
        Bundle bundle = new Bundle();
        if (objArr == null) {
            return bundle;
        }
        int length = objArr.length;
        for (int i3 = 0; i3 < length - 1; i3 += 2) {
            Object obj = objArr[i3];
            if (obj != null) {
                int i16 = i3 + 1;
                if (objArr[i16] != null) {
                    bundle.putString(obj.toString(), objArr[i16].toString());
                }
            }
        }
        return bundle;
    }

    public static HashMap<String, String> d(String... strArr) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (strArr == null) {
            return hashMap;
        }
        int length = strArr.length;
        for (int i3 = 0; i3 < length - 1; i3 += 2) {
            hashMap.put(strArr[i3], strArr[i3 + 1]);
        }
        return hashMap;
    }

    public static String e(Bundle bundle, String[] strArr, String str) {
        String string = bundle.getString("key_proxy_appid");
        if (TextUtils.isEmpty(string)) {
            string = bundle.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID);
        }
        String string2 = bundle.getString("scope");
        if (TextUtils.isEmpty(string2)) {
            string2 = "all";
        }
        return "https://openmobile.qq.com/oauth2.0/m_authorize?_wv=16777218&status_os=" + Build.VERSION.RELEASE + "&client_id=" + string + "&format=json&switch=1&status_version=" + Build.VERSION.SDK + "&status_machine=" + DeviceInfoMonitor.getModel() + "&pf=openmobile_android&sdkp=a&sdkv=" + bundle.getString("sdkv") + "&sign=" + strArr[0] + "&time=" + strArr[1] + "&scope=" + string2 + "&style=qr&redirect_uri=auth%3A%2F%2Ftauth.qq.com%2F&display=mobile&response_type=token&loginfrom=" + str + "&cancel_display=1&_nav_txtclr=000000";
    }

    public static void f(String str, u uVar) {
        OpenTicketHelper.a(str, uVar);
    }

    public static void g(String str, u uVar) {
        OpenTicketHelper.d(str, uVar);
    }

    public static Bundle h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", Build.VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e()));
        bundle.putString("apn", com.tencent.open.base.a.b(com.tencent.open.adapter.a.f().e()));
        bundle.putString("model_name", DeviceInfoMonitor.getModel());
        bundle.putString("qq_ver", com.tencent.open.adapter.a.f().d());
        return bundle;
    }

    public static Bundle i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        bundle.putString("openid", str2);
        bundle.putString(TVKDataBinder.KEY_REPORT_TYPE, str3);
        bundle.putString("act_type", str4);
        bundle.putString("via", "2");
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("to_type", str11);
        bundle.putString("platform", "4");
        bundle.putString("app_type", Integer.toString(1));
        return bundle;
    }

    private static JSONObject j(JSONObject jSONObject, String str) {
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    split[0] = URLDecoder.decode(split[0]);
                    String decode = URLDecoder.decode(split[1]);
                    split[1] = decode;
                    jSONObject.put(split[0], decode);
                }
            }
        } catch (Exception e16) {
            t.d("AuthorityUtil", "JSONException", e16);
        }
        return jSONObject;
    }

    public static String k(Bundle bundle, String str) {
        if (bundle != null && str != null && !str.isEmpty()) {
            try {
                if (!Pattern.compile("sign=&time=\\d+&").matcher(str).find()) {
                    return str;
                }
                String string = bundle.getString("packagename");
                t.f("AuthorityUtil", "fixOpenAuthQrCodeLoginUrl thirdAppPackageName: " + string);
                if (string != null && !string.isEmpty()) {
                    String[] k3 = OpenSdkVirtualUtil.k(string);
                    if (k3.length != 3) {
                        return str;
                    }
                    if (TextUtils.isEmpty(k3[1])) {
                        return str;
                    }
                    String replaceFirst = str.replaceFirst("sign=&time=\\d+&", "sign=" + k3[1] + "&time=" + k3[2] + ContainerUtils.FIELD_DELIMITER);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("fixOpenAuthQrCodeLoginUrl replaceUrl: ");
                    sb5.append(replaceFirst);
                    t.b("AuthorityUtil", sb5.toString());
                    return replaceFirst;
                }
                return str;
            } catch (Exception e16) {
                t.d("AuthorityUtil", "fixOpenAuthQrCodeLoginUrl exception", e16);
            }
        }
        return str;
    }

    public static byte[] l(String str, AppRuntime appRuntime, boolean z16) {
        String openA2;
        String str2;
        if (TextUtils.isEmpty(str)) {
            t.e("AuthorityUtil", "getA2 false, currentAccount empty");
            return null;
        }
        if (appRuntime == null) {
            t.e("AuthorityUtil", "getA2 false appInterface is null");
            return null;
        }
        TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
        if (ticketManager == null) {
            t.e("AuthorityUtil", "getA2 false TicketManager is null");
            return null;
        }
        if (z16) {
            openA2 = ticketManager.getA2(str);
        } else {
            openA2 = ticketManager.getOpenA2(str);
        }
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            str2 = "host";
        } else {
            str2 = "opensdk";
        }
        sb5.append(str2);
        sb5.append(" getA2 uin=");
        sb5.append(C(str));
        sb5.append("  ");
        sb5.append(C(openA2));
        objArr[0] = sb5.toString();
        t.b("AuthorityUtil", objArr);
        if (TextUtils.isEmpty(openA2)) {
            return null;
        }
        return HexUtil.hexStr2Bytes(openA2);
    }

    public static void m(String str, boolean z16, i iVar) {
        OpenTicketHelper.f(str, z16, iVar);
    }

    public static String[] n(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("accList", null);
        if (string == null) {
            return null;
        }
        return string.split(",");
    }

    public static String o(Context context, String str, String str2) {
        String str3 = "";
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            String bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
            if (bytes2HexStr == null) {
                return "";
            }
            String lowerCase = bytes2HexStr.toLowerCase();
            t.f("AuthorityUtil", "-->getAppSignatureMD5, sign: " + lowerCase);
            messageDigest.reset();
            messageDigest.update((str + "_" + lowerCase + "_" + str2 + "").getBytes());
            str3 = HexUtil.bytes2HexStr(messageDigest.digest());
            messageDigest.reset();
            return str3;
        } catch (Exception e16) {
            t.g("AuthorityUtil", "Exception", e16);
            return str3;
        }
    }

    public static String p(fp3.b bVar, Resources resources, int i3) {
        String str;
        if (bVar != null) {
            str = bVar.f400228b.get();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return HardCodeUtil.qqStr(R.string.f171155cp4);
        }
        return str;
    }

    public static Bitmap q(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = SafeBitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return decodeStream;
        } catch (IOException e16) {
            t.e("AuthorityUtil", "-->getbitmap IOException, url = ", str, ", exception message : ", e16.getMessage());
            return null;
        } catch (Exception e17) {
            t.e("AuthorityUtil", "-->getbitmap Exception, url = ", str, ", exception message : ", e17.getMessage());
            return null;
        } catch (OutOfMemoryError unused) {
            t.e("AuthorityUtil", "-->getbitmap decodeStream oom, url = ", str);
            return null;
        }
    }

    public static List<String> r() {
        try {
            JSONObject jSONObject = new JSONObject(new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("102942", new byte[0])));
            QLog.d("AuthorityUtil", 1, "getCMDWhiteList white list: " + jSONObject);
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("cmdList")) {
                JSONArray jSONArray = jSONObject.getJSONArray("cmdList");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
            }
            return arrayList;
        } catch (JSONException e16) {
            QLog.e("AuthorityUtil", 1, "getCMDWhiteList error: " + e16);
            return new ArrayList();
        }
    }

    public static Bitmap s(Context context, Bitmap bitmap, int i3, int i16) {
        return BaseImageUtil.getCircleFaceBitmap(context, bitmap, i3, i16);
    }

    public static Bitmap t(Bitmap bitmap, int i3, int i16) {
        float f16 = MobileQQ.sMobileQQ.getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f17 = width;
            float f18 = i3;
            if (f17 < f16 * f18) {
                f16 = f17 / f18;
            }
        }
        int i17 = (int) (i3 * f16);
        return BaseImageUtil.getRoundedCornerBitmap(bitmap, i17, i17, (int) (i16 * f16));
    }

    public static byte[] u(String str) {
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        T(gatewayVerify$ReqBody, str);
        t.e("AuthorityUtil", "getConnectData appid=" + str + "&sdkp=a");
        return gatewayVerify$ReqBody.toByteArray();
    }

    public static byte[] v(String str) {
        GatewayVerify$ReqBody gatewayVerify$ReqBody = new GatewayVerify$ReqBody();
        T(gatewayVerify$ReqBody, str);
        gatewayVerify$ReqBody.msg_req_common_info.bool_req_support_connect_pskey.set(true);
        return gatewayVerify$ReqBody.toByteArray();
    }

    public static String w(List<String> list, Intent intent) {
        String str = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime.isLogin()) {
            str = waitAppRuntime.getAccount();
            t.b("AuthorityUtil", "--> getCurrentUin isLogin currentUin=", C(str));
        }
        if (str == null && list != null && !list.isEmpty()) {
            str = list.get(0);
            t.b("AuthorityUtil", "--> getCurrentUin sdkHistories currentUin=", C(str));
        }
        String l3 = c.l(intent, "login_success_uin");
        if (!TextUtils.isEmpty(l3) && !l3.equals(str)) {
            t.b("AuthorityUtil", "--> getCurrentUin set currentUin=", C(l3));
            return l3;
        }
        return str;
    }

    public static byte[] x(Bundle bundle, boolean z16, com.tencent.open.model.a aVar) {
        byte[] byteArray = bundle.getByteArray("data");
        boolean z17 = bundle.getBoolean("use_open_sdk_ticket", false);
        if (z16 && z17) {
            return byteArray;
        }
        if (z16) {
            return OpenSdkVirtualUtil.c(byteArray, aVar);
        }
        return byteArray;
    }

    public static Object[] y(AppRuntime appRuntime, String str, String str2, String str3) {
        Pair<String, appType$LoginSig> b16 = k.b(appRuntime, str, str2, str3);
        return new Object[]{b16.getFirst(), b16.getSecond()};
    }

    public static void z(AppRuntime appRuntime, String str, String str2, String str3, k.a aVar) {
        k.c(appRuntime, str, str2, str3, aVar);
    }
}
