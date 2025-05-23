package com.tencent.gamecenter.wadl.util;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class i {
    public static float a(long j3) {
        return Math.round((((float) j3) / 1048576.0f) * 100.0f) / 100.0f;
    }

    public static boolean b() {
        return ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ);
    }

    public static PendingIntent c(String str) {
        Intent createBrowserIntent = GameCenterUtil.createBrowserIntent(str);
        return PendingIntent.getActivity(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), createBrowserIntent, 201326592);
    }

    public static PendingIntent d(WadlResult wadlResult) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse("mqqapi://gamecenter/install"));
        intent.putExtra("key_event_id", 2);
        intent.putExtra(WadlProxyConsts.PARAM_DOWNLOAD_RESULT, wadlResult);
        intent.addFlags(268435456);
        return PendingIntent.getActivity(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    public static PendingIntent e(String str, String str2, String str3, int i3, int i16, String str4) {
        if (TextUtils.isEmpty(str4)) {
            str4 = WadlProxyConsts.DEFAULT_MGR_URL;
        }
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_GAME_CENTER_ACTION);
        intent.putExtra("key_event_id", 3);
        intent.putExtra("actionFrom", 4);
        intent.putExtra("appid", str);
        intent.putExtra("packageName", str2);
        intent.putExtra(WadlProxyConsts.KEY_LOCAL_APK_PATH, str3);
        intent.putExtra("downloadType", i3);
        intent.putExtra("actionType", i16);
        intent.putExtra(WadlProxyConsts.KEY_JUMP_URL, str4);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    public static PendingIntent f(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse("mqqapi://gamecenter/install"));
        intent.putExtra("key_event_id", 3);
        intent.putExtra(WadlProxyConsts.KEY_JUMP_URL, str);
        intent.addFlags(268435456);
        return PendingIntent.getActivity(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    public static PendingIntent g(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse("mqqapi://gamecenter/install"));
        intent.putExtra("key_event_id", 1);
        intent.putExtra(WadlProxyConsts.KEY_JUMP_URL, str);
        intent.addFlags(268435456);
        return PendingIntent.getActivity(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    public static int h() {
        return p03.a.q(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).d("key_encode_switch_value", 0);
    }

    public static boolean i() {
        return QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeBool("key_first_close_cfg", true);
    }

    public static boolean j(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static String k(long j3) {
        String str;
        float f16 = ((float) j3) / 1048576.0f;
        if (f16 < 1024.0f) {
            str = "MB";
        } else {
            f16 /= 1024.0f;
            str = "GB";
        }
        return (Math.round(f16 * 100.0f) / 100.0f) + str;
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put("ext12", str2);
            jSONObject.put("ext11", str);
            jSONObject.put("ext1", str4);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, str3);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str5);
            jSONObject.put("ext4", str6);
            jSONObject.put("ext2", str7);
            jSONObject.put("ext6", str8);
            jSONObject.put("ext8", str9);
            jSONObject.put(WadlReportBuilder.TableElem.GAME_APPID, str10);
            jSONObject.put("ext25", str11);
            jSONObject.put("ad_id", str12);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e("Wadl_WadlDownloadUtil", 1, "[startReport] errors:" + e16.getMessage());
        }
    }

    public static void m(int i3, Bundle bundle) {
        Intent intent = new Intent(WadlProxyConsts.ACTION_GAME_CENTER_MAIN_PROCESS_ACTION);
        intent.setPackage(MobileQQ.sMobileQQ.getPackageName());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("key_event_id", i3);
        MobileQQ.sMobileQQ.sendBroadcast(intent);
    }

    public static void n() {
        QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").encodeBool("key_first_close_cfg", false);
    }

    public static void o(int i3) {
        p03.a.q(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).i("key_encode_switch_value", i3);
    }
}
