package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DataTableNameType;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import h44.OpenRobotProfileCardArgs;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x12b4.oidb_0x12b4$Req;
import tencent.im.oidb.cmd0x12b4.oidb_0x12b4$Rsp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.api.a f302187d;

        a(com.tencent.mobileqq.troop.api.a aVar) {
            this.f302187d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0 && bArr != null) {
                oidb_0x12b4$Rsp oidb_0x12b4_rsp = new oidb_0x12b4$Rsp();
                try {
                    oidb_0x12b4_rsp.mergeFrom(bArr);
                    this.f302187d.onResult(oidb_0x12b4_rsp.ark.get());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("RobotUtils", 1, "sendOIDBRequest fail", e16);
                    this.f302187d.onResult("");
                    return;
                }
            }
            QLog.e("RobotUtils", 1, "getShareRobotInfoFromServer result error! errorCode = " + i3);
            this.f302187d.onResult("");
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle c16 = c(context, str, str2);
            Intent intent = new Intent();
            intent.putExtras(c16);
            intent.setClass(context, ForwardRecentActivity.class);
            intent.putExtra("caller_name", context.getClass().getSimpleName());
            intent.putExtra("forward_source_business_type", -1);
            intent.putExtra("forward_source_sub_business_type", "");
            context.startActivity(intent);
            return;
        }
        QLog.e("RobotUtils", 1, "forwardRobotCard error ! robotUin = " + str + "arkInfo " + str2);
    }

    public static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Bundle d16 = d(context, str);
            Intent intent = new Intent();
            intent.putExtras(d16);
            intent.setClass(context, ForwardRecentActivity.class);
            intent.putExtra("caller_name", context.getClass().getSimpleName());
            intent.putExtra("forward_source_business_type", -1);
            intent.putExtra("forward_source_sub_business_type", "");
            context.startActivity(intent);
            return;
        }
        QLog.e("RobotUtils", 1, "forwardRobotList error ! arkInfo " + str);
    }

    public static Bundle c(Context context, String str, String str2) {
        String str3 = "";
        Bundle bundle = new Bundle();
        bundle.putString("robot_uin", str);
        bundle.putString("share_robot_card_ark_info", str2);
        bundle.putBoolean("k_dataline", false);
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putBoolean("only_single_selection", true);
        bundle.putInt("forward_type", 42);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 1);
        bundle.putBoolean(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("app", "");
            bundle.putString("forward_ark_app_name", optString);
            String optString2 = jSONObject.optString("view", "");
            bundle.putString("forward_ark_app_view", optString2);
            String optString3 = jSONObject.optString("ver", "");
            bundle.putString("forward_ark_app_ver", optString3);
            bundle.putString("forward_ark_app_prompt", jSONObject.optString("prompt", ""));
            bundle.putString("forward_ark_biz_src", jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC, ""));
            JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
            if (optJSONObject != null) {
                bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (optJSONObject2 != null) {
                str3 = optJSONObject2.toString();
                bundle.putString("forward_ark_app_meta", str3);
            }
            QQCustomArkDialogUtil.zipArgs(optString, optString2, optString3, str3, context.getResources().getDisplayMetrics().density, null, bundle);
        } catch (JSONException e16) {
            QLog.e("RobotUtils", 1, "getForwardRobotCardBundle error ! e = " + e16.getMessage());
        }
        return bundle;
    }

    public static Bundle d(Context context, String str) {
        String str2 = "";
        Bundle bundle = new Bundle();
        bundle.putString("share_robot_card_ark_info", str);
        bundle.putBoolean("k_dataline", false);
        bundle.putBoolean("is_ark_display_share", true);
        bundle.putBoolean("only_single_selection", true);
        bundle.putInt("forward_type", DataTableNameType.TABLE_SPORT_METADATA);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 1);
        bundle.putBoolean(IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE, false);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("app", "");
            bundle.putString("forward_ark_app_name", optString);
            String optString2 = jSONObject.optString("view", "");
            bundle.putString("forward_ark_app_view", optString2);
            String optString3 = jSONObject.optString("ver", "");
            bundle.putString("forward_ark_app_ver", optString3);
            bundle.putString("forward_ark_app_prompt", jSONObject.optString("prompt", ""));
            bundle.putString("forward_ark_biz_src", jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC, ""));
            JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
            if (optJSONObject != null) {
                bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (optJSONObject2 != null) {
                str2 = optJSONObject2.toString();
                bundle.putString("forward_ark_app_meta", str2);
            }
            QQCustomArkDialogUtil.zipArgs(optString, optString2, optString3, str2, context.getResources().getDisplayMetrics().density, null, bundle);
        } catch (JSONException e16) {
            QLog.e("RobotUtils", 1, "getForwardRobotListBundle error ! e = " + e16);
        }
        return bundle;
    }

    public static String e(String str) {
        String str2;
        if (str != null) {
            str2 = "gc=" + str + ContainerUtils.FIELD_DELIMITER;
        } else {
            str2 = "";
        }
        String str3 = "https://web.qun.qq.com/qunrobot/timingmessageedit?" + str2 + "r_uin=2854196310&f_id=41&type=2&slot=0&_wwv=128";
        if (QLog.isColorLevel()) {
            QLog.d("RobotUtils", 2, "url " + str3);
        }
        return str3;
    }

    public static String f(String str) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return com.tencent.mobileqq.utils.ac.g0((QQAppInterface) runtime, str, false);
        }
        return null;
    }

    public static void g(AppRuntime appRuntime, String str, com.tencent.mobileqq.troop.api.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            long parseLong = Long.parseLong(str);
            oidb_0x12b4$Req oidb_0x12b4_req = new oidb_0x12b4$Req();
            oidb_0x12b4_req.uin.set(parseLong);
            ProtoUtils.a(appRuntime, new a(aVar), oidb_0x12b4_req.toByteArray(), "OidbSvcTrpcTcp.0x12b4_0", 4788, 0);
        } catch (NumberFormatException unused) {
            QLog.e("RobotUtils", 1, "getShareRobotInfo error! robotUin = " + str);
            aVar.onResult("");
        }
    }

    public static String h(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String i3 = i(str2, "robot_uin");
            if (TextUtils.isEmpty(i3)) {
                return str2;
            }
            return ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).getWebRobotProfileUrl(i3, str);
        }
        return str2;
    }

    public static final String i(String str, String str2) {
        int indexOf;
        String[] split;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) > 0 && indexOf < str.length() && (split = str.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER)) != null && split.length != 0) {
            String str3 = str2 + ContainerUtils.KEY_VALUE_DELIMITER;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (!TextUtils.isEmpty(split[i3]) && split[i3].startsWith(str3)) {
                    return split[i3].substring(str3.length());
                }
            }
        }
        return null;
    }

    public static void j(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("RobotUtils", 2, "invokeRobotFunction, troopuin:" + str + " robotuin:" + str3 + " robotname:" + str4 + " offurl:" + str7 + " offtitle:" + str8 + " onurl:" + str5 + " ontitle:" + str6);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str8) || TextUtils.isEmpty(str7) || context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("troopuin", str);
        bundle.putString("robotuin", str3);
        bundle.putString("robotname", str4);
        bundle.putString("onurl", str5);
        bundle.putString("ontitle", str6);
        bundle.putString("offurl", str7);
        bundle.putString("offtitle", str8);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(context), null);
        if (i3 == 1) {
            m3.putExtra("uin", str);
            m3.putExtra("uintype", 1);
            m3.putExtra("uinname", str2);
        } else if (i3 == 0) {
            m3.putExtra("uin", str3);
            m3.putExtra("uintype", 1043);
            m3.putExtra("uinname", str4);
        }
        m3.putExtra(AppConstants.Key.KEY_INVOKE_TROOP_ROBOT_FUNCTION, bundle);
        m3.putExtra("isBack2Root", true);
        context.startActivity(m3);
    }

    public static boolean k(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals("com.tencent.contact.lua") || !((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).shouldInterceptForRobotProfileNotOpen(str2)) {
            return false;
        }
        return true;
    }

    public static boolean l(AppRuntime appRuntime, String str) {
        return ((ITroopRobotService) appRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str);
    }

    public static boolean m(String str, String str2, String str3, boolean z16) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface == null) {
            return false;
        }
        if (!l(qQAppInterface, str2)) {
            QLog.i("RobotUtils", 2, "notifyMemChange err" + str2);
            return false;
        }
        ((ct2.a) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a0(str, str2, str3, Boolean.valueOf(z16));
        return true;
    }

    public static void n(QBaseActivity qBaseActivity, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("RobotUtils", 2, "openGroupManagerBookCard with empty troopUin");
            return;
        }
        String e16 = e(str);
        Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", e16);
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
        if (com.tencent.mobileqq.webview.swift.ag.f314191a.containsKey("robotsummary")) {
            intent.putExtra("insertPluginsArray", new String[]{"robotsummary"});
        }
        qBaseActivity.startActivity(intent);
    }

    public static void o(Context context, String str, String str2) {
        p(context, str, str2, 0);
    }

    public static void p(Context context, String str, String str2, int i3) {
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, str2, str, i3, 0, null));
    }
}
