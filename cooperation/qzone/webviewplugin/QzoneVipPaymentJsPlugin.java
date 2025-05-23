package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.module.vipcomponent.ui.VipBusinessManager;
import com.tencent.ads.data.AdParam;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.vip.manager.MonitorManager;
import java.util.Map;
import mqq.manager.TicketManager;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneVipPaymentJsPlugin extends QzoneInternalWebViewPlugin {
    public static final String KEY_DISCOUNTID = "discountId";
    public static final String KEY_OTHER = "other";
    public static final String KEY_PRELOAD_QZONE = "preloadQzone";
    public static final String KEY_PROVIDETYPE = "provideType";
    public static final String KEY_PROVIDEUIN = "provideUin";
    public static final String KEY_QZONE_VIP_OPEN_BACK_NEED_CHECK_VIPINFO = "key_qzone_vip_open_back_need_check_vipinfo";
    public static final String NAMESPACE = "Qzone";
    private static final String NORMAL_VIP = "1";
    public static final int OPEN_WHAT_SET_NAVI_DECO = 7;
    private static final byte RESULT_CODE_OPEN_VIP = 16;
    public static final String SET_ACTIVITY_NAME = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
    public static final String SET_NAVI_DECO = "SetNaviDeco";
    private static final String SUPER_VIP = "2";
    private static final String TAG = "QzoneVipPaymentJsPlugin";
    private String payCallback = null;

    private String createPF(String str, String str2) {
        return "qq_m_qq-2013-" + str.replaceAll("-", "_") + "-2013-" + str2.replaceAll("-", "_");
    }

    private int generateRequestCode(int i3) {
        WebViewPlugin.b bVar = this.parentPlugin.mRuntime;
        y d16 = bVar.d(bVar.a());
        return d16 instanceof af ? ((af) d16).switchRequestCode(this.parentPlugin, (byte) i3) : i3;
    }

    private void gotoVipPayment(String str, String str2, String str3, boolean z16, String str4) {
        AppInterface b16;
        String str5;
        String str6;
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing() || (b16 = this.parentPlugin.mRuntime.b()) == null) {
            return;
        }
        Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(BaseApplication.getContext());
        String e16 = ff.e(str4);
        String string = a16.getString(R.string.f173052gq1);
        String string2 = a16.getString(R.string.f173053gq2);
        if ("1".equals(str3)) {
            string = a16.getString(R.string.f173052gq1);
            str5 = VipBusinessManager.COMM_VIP_SERVICE_CODE;
            str6 = VipBusinessManager.COMM_VIP_OFFER_ID;
        } else if (!"2".equals(str3)) {
            str5 = "";
            str6 = str5;
        } else {
            string = a16.getString(R.string.ggl);
            str5 = VipBusinessManager.SPECIAL_VIP_SERVICE_CODE;
            str6 = VipBusinessManager.SPECIAL_VIP_OFFER_ID;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("offerId", str6);
            TicketManager ticketManager = (TicketManager) b16.getManager(2);
            String account = b16.getAccount();
            jSONObject.put("userId", account);
            jSONObject.put("skey", VasSkey.getSkey(ticketManager, account));
            jSONObject.put("serviceCode", str5);
            jSONObject.put("serviceName", string);
            jSONObject.put(WadlProxyConsts.CHANNEL, "");
            jSONObject.put("uint", string2);
            jSONObject.put("openMonth", str2);
            jSONObject.put("isCanChange", false);
            jSONObject.put("autoPay", z16);
            jSONObject.put("aid", e16);
            jSONObject.put(AdParam.PF, createPF(QUA.getQUA3(), e16));
            if (!str.equals(b16.getCurrentAccountUin()) && !str.equals("0")) {
                jSONObject.put(KEY_PROVIDEUIN, str);
                jSONObject.put(KEY_PROVIDETYPE, "uin");
            }
            jSONObject.put(KEY_DISCOUNTID, "");
            jSONObject.put("other", "");
            Bundle bundle = new Bundle();
            bundle.putInt("pay_requestcode", 4);
            bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
            payBridgeIntent.putExtras(bundle);
            this.parentPlugin.startActivityForResult(payBridgeIntent, (byte) 16);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    private void onPayClose() {
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        if (VasNormalToggle.VAS_BUG_115859888.isEnable(true)) {
            a16.setResult(0);
        }
        a16.finish();
    }

    private void payVipDirectly(String str, String str2) {
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 == null || a16.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            gotoVipPayment(jSONObject.optString("openUin"), jSONObject.optString("openMonth"), jSONObject.optString("openVipType"), jSONObject.getBoolean("isAuto"), jSONObject.optString("aid"));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        MonitorManager.f().j(1, 2, "native \u652f\u4ed8", "js \u56de\u8c03 native \u652f\u4ed8" + str);
        this.payCallback = str2;
        if (this.parentPlugin.mRuntime.b() == null) {
            return;
        }
        String account = this.parentPlugin.mRuntime.b().getAccount();
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.setActionType("328");
        reportInfo.setToUin(Long.parseLong(account));
        reportInfo.setSubactionType("10");
        reportInfo.setReserves("1");
        QZoneClickReport.startReportImediately(account, reportInfo);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin;
        if (!str2.equals("Qzone") || (webViewPlugin = this.parentPlugin) == null || webViewPlugin.mRuntime == null) {
            return false;
        }
        VasCommonReporter.getHistoryFeature("Qzone_jsb").setValue2(str3);
        if (str3.equals("payVipDirectly") && strArr != null && strArr.length >= 1) {
            try {
                payVipDirectly(strArr[0], new JSONObject(strArr[0]).optString("callback"));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return true;
        }
        if (!str3.equals("closePayDialog") && !str3.equals("closeFloatingWebView")) {
            if (str3.equals("SetNaviDeco")) {
                if (strArr != null && !TextUtils.isEmpty(strArr[0])) {
                    Intent intent = new Intent();
                    QzonePluginProxyActivity.setActivityNameToIntent(intent, "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity");
                    intent.putExtra("open_what", 7);
                    intent.putExtra("navi_deco", strArr[0]);
                    WebViewPlugin.b bVar = this.parentPlugin.mRuntime;
                    if (bVar != null && bVar.a() != null && this.parentPlugin.mRuntime.b() != null) {
                        QzonePluginProxyActivity.launchPluingActivityForResult(this.parentPlugin.mRuntime.a(), this.parentPlugin.mRuntime.b().getAccount(), intent, generateRequestCode(9));
                    }
                }
                return true;
            }
            if (!KEY_PRELOAD_QZONE.equals(str3)) {
                return false;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                    if (application == null || application.getRuntime() == null) {
                        return;
                    }
                    QZoneHelper.preloadQzone(application, application.getRuntime().getAccount(), "h5");
                }
            });
            return true;
        }
        onPayClose();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(Intent intent, byte b16, int i3) {
        WebViewPlugin.b bVar;
        boolean z16;
        Bundle extras;
        super.onActivityResult(intent, b16, i3);
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null && (bVar = webViewPlugin.mRuntime) != null) {
            Activity a16 = bVar.a();
            if (a16 == null || a16.isFinishing() || b16 != 16) {
                return;
            }
            String str = "";
            if (intent != null && (extras = intent.getExtras()) != null) {
                a16.setResult(i3, intent);
                str = extras.getString("result");
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i16 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                    String string = jSONObject.getString("resultMsg");
                    int i17 = jSONObject.getInt("payState");
                    int i18 = jSONObject.getInt("provideState");
                    if (!TextUtils.isEmpty(this.payCallback)) {
                        this.parentPlugin.callJs(this.payCallback, str);
                    }
                    onPay(a16, i16, string, i17, i18, intent);
                    z16 = false;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                MonitorManager.f().j(1, 3, "\u7c73\u5927\u5e08\u652f\u4ed8\u7ed3\u679c\u56de\u8c03", " \u56de\u8c03\u9ec4\u94bb\u7ed3\u679c\u901a\u77e5js " + str);
                if (z16) {
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("key_qzone_vip_open_back_need_check_vipinfo", false);
                a16.setResult(0, intent2);
                a16.finish();
                return;
            }
            z16 = true;
            MonitorManager.f().j(1, 3, "\u7c73\u5927\u5e08\u652f\u4ed8\u7ed3\u679c\u56de\u8c03", " \u56de\u8c03\u9ec4\u94bb\u7ed3\u679c\u901a\u77e5js " + str);
            if (z16) {
            }
        } else {
            QLog.e(TAG, 1, "parentPlugin.mRuntime null, requestCode:", Byte.valueOf(b16), " resultCode", Integer.valueOf(i3));
        }
    }

    private void onPay(Activity activity, int i3, String str, int i16, int i17, Intent intent) {
        if (i3 == -5) {
            activity.finish();
            return;
        }
        if (i3 != 0) {
            if (i3 != 2) {
                if (intent == null) {
                    intent = new Intent();
                }
                intent.putExtra("key_qzone_vip_open_back_need_check_vipinfo", false);
                activity.setResult(0, intent);
                activity.finish();
                return;
            }
            activity.setResult(0, intent);
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 != 8589934595L || map == null) {
            return false;
        }
        ((Integer) map.get("errorCode")).intValue();
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.e(TAG, 2, "VasWebReport:EVENT_LOAD_ERROR");
        return false;
    }
}
