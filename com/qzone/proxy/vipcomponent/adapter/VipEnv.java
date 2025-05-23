package com.qzone.proxy.vipcomponent.adapter;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.component.d;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.util.ToastUtil;
import com.qzone.util.ar;
import com.tencent.ads.data.AdParam;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.vipcomponent.util.b;
import java.util.List;
import org.json.JSONObject;
import z5.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipEnv {
    public static final String TAG = "VipEnv";
    public static final int TYPE_BUTTON_NEG = 1;
    public static final int TYPE_BUTTON_POS = 0;

    public static void ReportQzoneVipEntrnce(String str) {
        MonitorManager.f().j(1, 0, "\u547c\u8d77\u9ec4\u94bb\u652f\u4ed8\u6d41\u7a0b", " aid" + str);
    }

    private static String a(int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (i3 == -1) {
            return getContext().getResources().getString(R.string.gic);
        }
        if (i3 == 2) {
            return getContext().getResources().getString(R.string.gid);
        }
        if (i3 != 3) {
            return "";
        }
        return getContext().getResources().getString(R.string.gib);
    }

    public static Dialog createLoadingDialog(Context context, String str) {
        return new d(context, str);
    }

    public static String createPF(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return "qq_m_qq-2013-" + str.replaceAll("-", "_") + "-2013-" + str2.replaceAll("-", "_");
        }
        return "";
    }

    public static String formatAid(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String replace = str.replace("-", "_");
        if (replace.contains("_")) {
            return replace;
        }
        return "jhan_" + replace;
    }

    public static Intent generateYellowPayParams(Context context, String str, String str2, String str3, String str4, long j3, int i3, int i16, boolean z16, int i17, boolean z17, int i18, String str5, String str6) {
        Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(BaseApplication.getContext());
        try {
            String str7 = getLoginUin() + "";
            String str8 = j3 + "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("offerId", str);
            jSONObject.put("userId", str7);
            jSONObject.put("skey", LoginData.getInstance().getSkey());
            jSONObject.put("serviceCode", str5);
            jSONObject.put("serviceName", str6);
            jSONObject.put(WadlProxyConsts.CHANNEL, "");
            jSONObject.put("uint", context.getResources().getString(R.string.f173053gq2));
            jSONObject.put("openMonth", i16);
            jSONObject.put("isCanChange", z16);
            jSONObject.put("aid", str2);
            jSONObject.put(AdParam.PF, createPF(QUA.getQUA3(), str2));
            if (!str8.equals(str7) && !str8.equals("0")) {
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, str8);
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, "uin");
            }
            jSONObject.put(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, "");
            jSONObject.put("other", "");
            Bundle bundle = new Bundle();
            bundle.putInt("pay_requestcode", 4);
            bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
            payBridgeIntent.putExtras(bundle);
        } catch (Exception e16) {
            b.b(TAG, e16.getMessage());
        }
        MonitorManager.f().j(1, 1, "\u547c\u8d77\u7c73\u5927\u5e08\u652f\u4ed8", " aid " + str2);
        return payBridgeIntent;
    }

    public static Looper getBackGroundLopper() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getLooper();
    }

    public static Context getContext() {
        return BaseApplication.getContext();
    }

    public static String getCurrentProName() {
        int myPid = Process.myPid();
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return " null ";
            }
            return " null ";
        } catch (Exception e16) {
            QZLog.e(TAG, "getCurrentProName exception " + e16);
            return " null ";
        }
    }

    public static float getDensity() {
        return ar.i();
    }

    public static String getDialogBtStr(Dialog dialog, int i3) {
        TextView btnLeft;
        if (dialog instanceof QQCustomDialog) {
            QQCustomDialog qQCustomDialog = (QQCustomDialog) dialog;
            if (i3 == 0) {
                btnLeft = qQCustomDialog.getBtnight();
            } else {
                btnLeft = qQCustomDialog.getBtnLeft();
            }
            if (btnLeft != null) {
                try {
                    return btnLeft.getText().toString();
                } catch (Exception unused) {
                }
            }
        }
        return "";
    }

    public static String getDiamondPayPageUrl() {
        return "";
    }

    public static int getLocalConfigInt(String str, int i3) {
        return u5.b.G(str, i3);
    }

    public static long getLocalConfigLong(String str, long j3) {
        return u5.b.I(str, j3);
    }

    public static long getLoginUin() {
        return LoginData.getInstance().getUin();
    }

    public static SharedPreferences getMultiProSp(String str) {
        return VasMMKV.getVipInfo(BaseApplicationImpl.getApplication(), str);
    }

    public static String getNewH5PayUrl() {
        return QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_VIP_PAYMENT, "https://h5.qzone.qq.com/payDialog/index/{openUin}/{openMonth}/{openVipType}?_wv=16781315&aid={aid}&_wwv=1");
    }

    public static String getNickName() {
        return LoginData.getInstance().getNickName("");
    }

    public static String getOpenStarVipUrl() {
        return QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_STAR_VIP_PAY_URL, "https://h5.qzone.qq.com/payDialog/index/{openUin}/{openMonth}/{openVipType}?_wv=16781315&aid={aid}&_wwv=1");
    }

    public static String getQUA() {
        return QUA.getQUA3();
    }

    public static String getReferId(Context context) {
        return "";
    }

    public static boolean isIndepend() {
        return false;
    }

    public static boolean isNetworkAvailable() {
        return NetworkState.isNetSupport();
    }

    public static boolean isYellowPayInBlackList() {
        return false;
    }

    public static void openVipClickReport(String str) {
        if ("jhan_simipinglun".equals(str)) {
            ClickReport.q("357", "2", "1", true);
        } else if ("jhan_similiuyan".equals(str)) {
            ClickReport.q("357", "3", "1", true);
        } else if ("jhan_guajian".equals(str)) {
            ClickReport.q("328", "11", "6", true);
        }
    }

    public static void putLocalConfigInt(String str, int i3) {
        u5.b.q0(str, i3);
    }

    public static void putLocalConfigLong(String str, long j3) {
        u5.b.s0(str, j3);
    }

    public static void refreshAllVipInfo() {
        a.f().q(LoginData.getInstance().getUin(), null);
    }

    public static void refreshYellowDiamondInfo() {
        MonitorManager.f().j(1, 3, "\u9ec4\u94bb\u652f\u4ed8\u6210\u529f", "\u91cd\u65b0\u8bf7\u6c42\u540e\u53f0\u7528\u6237\u4fe1\u606f");
        a.f().q(LoginData.getInstance().getUin(), null);
    }

    public static void reportBySdk() {
        ClickReport.q("328", "8", "", true);
    }

    public static void reportOpenQZoneVipResult(int i3, String str) {
        MonitorManager.f().j(1, 2, "\u9ec4\u94bb\u652f\u4ed8\u7ed3\u679c\u56de\u8c03", "result code " + i3 + " result Msg " + str);
        AccManager.reportOpenQZoneVipResult(i3, str);
        if (2 == i3) {
            ClickReport.q("328", "1", "2", true);
        }
    }

    public static void reportToH5PayPage() {
        ClickReport.q("45", "9", "", true);
    }

    public static void setDialogMsg(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, Dialog dialog) {
        if (dialog instanceof QQCustomDialog) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getDialogBtStr(dialog, 0);
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = getDialogBtStr(dialog, 1);
            }
            QQCustomDialog qQCustomDialog = (QQCustomDialog) dialog;
            qQCustomDialog.setMessage(str);
            qQCustomDialog.setPositiveButton(str2, onClickListener);
            qQCustomDialog.setNegativeButton(str3, onClickListener2);
        }
    }

    public static void showToast(Context context, int i3, String str) {
        ToastUtil.t(str, i3, BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height), 3);
    }

    public static final int strToInt(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public static void toH5PayPage(Context context, String str, int i3, boolean z16) {
        MonitorManager.f().j(1, 1, "H5\u652f\u4ed8\u6d6e\u5c42 ", " \u9875\u9762URL" + str);
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, z16);
        yo.d.p(context, str, i3, bundle, null, null);
    }

    public static void toTransparentWeb(Context context, String str, int i3, boolean z16) {
        new Bundle().putBoolean(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, z16);
        yo.d.p(context, str, -10000, null, null, null);
    }

    public static void toBrowser(Context context, String str) {
        yo.d.d(str, context, null);
    }

    public static Dialog getAlertDialog(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, str2, str, str3, str4, onClickListener, onClickListener2);
        createCustomDialog.setOnCancelListener(onCancelListener);
        return createCustomDialog;
    }

    public static void payResultReport(String str, int i3, String str2, int i16, int i17) {
        if (i3 != 0) {
            r5.b.F().K(str, i3 == 0 ? 0 : i16 != 0 ? 1 : i17 != 0 ? 2 : -1, i3, a(i3, str2));
        }
    }

    public static void enableRedirectWhenPayVip(boolean z16) {
    }

    public static void reportAfterClickOpen(String str) {
    }

    public static void reportOpenMidsVipDialog() {
    }

    public static void reportOpenVipEntrance(String str) {
    }

    public static void reportOpenVipH5() {
    }

    public static void reportOpenVipH5DialogShow() {
    }

    public static void reportOpenVipOldDialogShow() {
    }

    public static void reportVipDialogCannel(String str) {
    }

    public static void reportVipDialogOpen(String str) {
    }

    public static void updateVipFakeStatus(Intent intent) {
    }

    public static void reportCheckYellowVip2MM(int i3, boolean z16, int i16) {
    }
}
