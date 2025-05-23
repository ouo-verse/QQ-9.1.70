package com.tencent.gamecenter.wadl.biz.jsplugin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameMMKVService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import nl0.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class WadlWebViewJsPlugin extends WebViewPlugin implements WadlProxyServiceCallBackInterface, g, nl0.c {

    /* renamed from: h, reason: collision with root package name */
    private static HashSet<String> f106842h;

    /* renamed from: d, reason: collision with root package name */
    private String f106843d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f106844e = "";

    /* renamed from: f, reason: collision with root package name */
    private Handler f106845f;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f106842h = hashSet;
        hashSet.add("LAST_SHOW_DIALOG_TIME");
        f106842h.add("LAST_TIME_B1");
        f106842h.add("LAST_TIME_B2");
        f106842h.add("LAST_TIME_B3");
        f106842h.add("LAST_TIME_B4");
        f106842h.add("LAST_TIME_B5");
        f106842h.add("LAST_TIME_B6");
        f106842h.add("LAST_TIME_B7");
        f106842h.add("LAST_TIME_B8");
    }

    public WadlWebViewJsPlugin() {
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
        WadlProxyServiceUtil.getProxyService().registerResCallBack(this);
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).addListener(this);
        this.f106845f = new Handler(Looper.getMainLooper());
    }

    private long A() {
        try {
            return Utils.z();
        } catch (Exception unused) {
            return 0L;
        }
    }

    private int D() {
        int cacheDualSwitch = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).getCacheDualSwitch();
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, "getDualSwitch switchValue=" + cacheDualSwitch);
        return cacheDualSwitch;
    }

    private void G(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = new JSONObject(str).getJSONArray("infolist");
        } catch (JSONException unused) {
            QLog.w("Wadl_WadlWebViewJsPlugin", 1, "getQueryDownloadAction exception");
            jSONArray = null;
        }
        if (jSONArray == null) {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused2) {
                QLog.w("Wadl_WadlWebViewJsPlugin", 1, "getQueryDownloadAction exception");
            }
        }
        if (jSONArray != null) {
            try {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = jSONArray.getJSONObject(i3).optString("appid");
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                if (arrayList.size() > 0) {
                    WadlProxyServiceUtil.getProxyService().doQueryAction(arrayList);
                }
            } catch (JSONException e16) {
                QLog.e("Wadl_WadlWebViewJsPlugin", 1, "getQueryDownloadAction exception", e16);
            }
        }
    }

    private String I() {
        HashSet<String> hashSet;
        String jSONArray;
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null) {
            hashSet = gVar.c();
        } else {
            hashSet = null;
        }
        if (hashSet != null) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONArray2.mo162put(it.next());
                }
                jSONArray = jSONArray2.toString();
            } catch (Throwable th5) {
                QLog.e("Wadl_WadlWebViewJsPlugin", 1, "getValidWebSsoCmds>>>", th5);
            }
            QLog.d("Wadl_WadlWebViewJsPlugin", 1, "getValidWebSsoCmds...cmdsJsonStr=" + jSONArray);
            return jSONArray;
        }
        jSONArray = "";
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, "getValidWebSsoCmds...cmdsJsonStr=" + jSONArray);
        return jSONArray;
    }

    private boolean O() {
        return MobileQQ.sMobileQQ.getSharedPreferences("wadl_jstask_file", 0).getBoolean("firstTime", true);
    }

    private void S(int i3, WadlParams wadlParams) {
        if (wadlParams == null) {
            return;
        }
        if (i3 == 4 || i3 == 5) {
            WadlProxyServiceUtil.getProxyService().deleteDownload(0, wadlParams.appId);
        }
        c0(GameCenterUtil.getWadlErrMsg(i3));
    }

    private void c0(final String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f106845f.post(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.jsplugin.WadlWebViewJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(com.tencent.open.adapter.a.f().e(), str, 0).show();
                }
            });
        } catch (Exception e16) {
            QLog.e("Wadl_WadlWebViewJsPlugin", 1, "showToast exception", e16);
        }
    }

    private void p(WadlResult wadlResult) {
        String str;
        if (wadlResult != null) {
            String jSONObject = GameCenterUtil.toResJSONObject(wadlResult).toString();
            if (TextUtils.isEmpty(this.f106844e)) {
                str = "if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadResProcess'," + jSONObject + ");}void(0);";
            } else {
                str = this.f106844e + "(" + jSONObject + ")";
            }
            callJs(str);
        }
    }

    private void q(WadlResult wadlResult) {
        String str;
        if (wadlResult != null) {
            String jSONObject = GameCenterUtil.toJSONObject(wadlResult).toString();
            if (TextUtils.isEmpty(this.f106843d)) {
                str = "if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + jSONObject + ");}void(0);";
            } else {
                str = this.f106843d + "(" + jSONObject + ")";
            }
            callJs(str);
        }
    }

    private void setDualSwitch(String str) {
        ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).setDualSwitch(str);
    }

    protected void B() {
        String readFromSp = GameCenterSpUtils.readFromSp("DELAY_LIST");
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(readFromSp)) {
            String[] split = readFromSp.split("\\|");
            for (int i3 = 0; i3 < split.length; i3++) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(split[i3])) {
                    try {
                        jSONObject.put("appid", split[i3]);
                        jSONArray.mo162put(jSONObject);
                    } catch (JSONException e16) {
                        QLog.e("Wadl_WadlWebViewJsPlugin", 1, "getDelayDownloadTasks>>>", e16);
                    }
                }
            }
        }
        callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDelayDownloadTasks',{\"result\" : 0, \"task\":" + jSONArray.toString() + "});}void(0);");
    }

    protected String C() {
        String valueOf = String.valueOf(4);
        callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getDownloadVersion',{\"version\":\"" + valueOf + "\",\"r\":\"-1\"});}void(0);");
        return valueOf;
    }

    public int E() {
        int intOutAccount = ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).getIntOutAccount(WadlProxyConsts.KEY_FLOAT_WND_TOGGLE, 1);
        QLog.d("Wadl_WadlWebViewJsPlugin", 2, "[getFloatWndToggle] toggle:" + intOutAccount);
        return intOutAccount;
    }

    protected void F(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = jSONObject.optString("guid");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("packageNames");
            JSONArray jSONArray = new JSONArray();
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    String string = optJSONArray.getString(i3);
                    PackageInfo packageInfo = GameCenterUtil.getPackageInfo(string);
                    if (packageInfo != null) {
                        str4 = String.valueOf(packageInfo.versionCode);
                        str5 = packageInfo.versionName;
                        str6 = GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(string));
                    } else {
                        str4 = "";
                        str5 = "";
                        str6 = str5;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("packageName", string);
                    jSONObject2.put("versionCode", str4);
                    jSONObject2.put("versionName", str5);
                    jSONObject2.put(WadlProxyConsts.CHANNEL, str6);
                    jSONArray.mo162put(jSONObject2);
                }
            }
            str3 = "if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{'guid':'" + str2 + "','r':'0','data':'" + jSONArray.toString() + "'});}void(0);";
        } catch (Exception unused) {
            str3 = "if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getInstalledAppVersionCode',{\"guid\":\"" + str2 + "\",\"r\":\"-1\"});}void(0);";
        }
        callJs(str3);
    }

    protected void H(String str) {
        if ("ALL_TASK_QUERY_IDENTITY".equals(str)) {
            U();
            return;
        }
        try {
            WadlProxyServiceUtil.getProxyService().doQueryActionByVia(new JSONObject(str).getString("via"));
        } catch (Exception e16) {
            QLog.e("Wadl_WadlWebViewJsPlugin", 1, "query getQueryDownloadActionByVia>>>", e16);
        }
    }

    protected boolean J(String str, JsBridgeListener jsBridgeListener, String... strArr) {
        if ("queryAllDownloadTask".equals(str)) {
            U();
            jsBridgeListener.c(0);
            return true;
        }
        if ("getQueryDownloadAction".equals(str)) {
            if (s(0, strArr)) {
                G(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("getQueryDownloadActionByVia".equals(str)) {
            if (s(0, strArr)) {
                H(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("deleteDownload".equals(str)) {
            if (s(0, strArr)) {
                v(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if (!WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION.equals(str) && !"doGCDownloadAction".equals(str)) {
            return false;
        }
        if (s(0, strArr)) {
            jsBridgeListener.c(Integer.valueOf(w(strArr[0])));
        }
        return true;
    }

    protected boolean K(String str, JsBridgeListener jsBridgeListener, String... strArr) {
        if ("delDelayDownloadTasks".equals(str)) {
            if (s(0, strArr)) {
                u(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("getDelayDownloadTasks".equals(str)) {
            B();
            jsBridgeListener.c(0);
            return true;
        }
        if ("requestWebSso".equals(str)) {
            if (s(0, strArr)) {
                a0(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("readLastTime".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Long.valueOf(W(strArr[0])));
            }
            return true;
        }
        if ("updateLastTime".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Integer.valueOf(d0(strArr[0])));
            }
            return true;
        }
        if ("setDualSwitch".equals(str)) {
            if (s(0, strArr)) {
                setDualSwitch(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("getDualSwitch".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Integer.valueOf(D()));
            }
            return true;
        }
        if ("canDualDownload".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Integer.valueOf(r()));
            }
        } else {
            if ("setFloatWndToggle".equals(str)) {
                b0(strArr[0]);
                if (jsBridgeListener != null) {
                    jsBridgeListener.c(0);
                }
                return true;
            }
            if ("getFloatWndToggle".equals(str)) {
                int E = E();
                if (jsBridgeListener != null) {
                    jsBridgeListener.c(Integer.valueOf(E));
                }
                return true;
            }
        }
        return false;
    }

    protected boolean L(String str, JsBridgeListener jsBridgeListener, String... strArr) {
        if ("requestFloatingPermission".equals(str)) {
            if (s(0, strArr)) {
                GameCenterUtil.requestFloatingScreenPermission(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("queryFloatingPermission".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Integer.valueOf(V(strArr[0])));
            }
            return true;
        }
        if ("openFloatingSetting".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Integer.valueOf(P(strArr[0])));
            }
            return true;
        }
        if ("readModeState".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Integer.valueOf(X(strArr[0])));
            }
            return true;
        }
        if ("openHuaWeiPureModeSetting".equals(str)) {
            jsBridgeListener.c(Integer.valueOf(Q()));
            return true;
        }
        if ("queryInstallPermission".equals(str)) {
            jsBridgeListener.c(Integer.valueOf(GameCenterUtil.checkInstallPermission() ? 1 : 0));
            return true;
        }
        if (!"openInstallSetting".equals(str)) {
            return false;
        }
        jsBridgeListener.c(Integer.valueOf(R()));
        return true;
    }

    protected boolean M(String str, JsBridgeListener jsBridgeListener, String... strArr) {
        if ("queryAllDownloadRes".equals(str)) {
            T();
            jsBridgeListener.c(0);
            return true;
        }
        if ("doResDownloadAction".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(Integer.valueOf(x(strArr[0])));
            }
            return true;
        }
        if (!"registerResCallBack".equals(str)) {
            return false;
        }
        if (s(0, strArr)) {
            Z(strArr[0]);
            jsBridgeListener.c(0);
        }
        return true;
    }

    protected boolean N(String str, JsBridgeListener jsBridgeListener, String... strArr) {
        if ("registerDownloadCallBackListener".equals(str)) {
            if (s(0, strArr)) {
                Y(strArr[0]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("isFirstTimeEntry".equals(str)) {
            jsBridgeListener.c(Boolean.valueOf(O()));
            return true;
        }
        if ("clearFirstRimeEntryFlag".equals(str)) {
            t();
            jsBridgeListener.c(0);
            return true;
        }
        if ("getDownloadVersion".equals(str)) {
            jsBridgeListener.c(C());
            return true;
        }
        if ("getInstalledAppVersionCode".equals(str)) {
            if (s(1, strArr)) {
                F(strArr[0], strArr[1]);
                jsBridgeListener.c(0);
            }
            return true;
        }
        if ("getAppVersionCode".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(y(strArr[0]));
            }
            return true;
        }
        if ("getAppVersionName".equals(str)) {
            if (s(0, strArr)) {
                jsBridgeListener.c(z(strArr[0]));
            }
            return true;
        }
        if ("getAvailableBytes".equals(str)) {
            jsBridgeListener.c(Long.valueOf(A()));
            return true;
        }
        if (!"getValidWebSsoCmds".equals(str)) {
            return false;
        }
        jsBridgeListener.c(I());
        return true;
    }

    protected int P(String str) {
        int i3;
        int i16 = Build.VERSION.SDK_INT;
        if (i16 <= 28) {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlWebViewJsPlugin", 1, "sdk version lower android10,version is " + i16);
            }
            i3 = 0;
        } else {
            Activity a16 = this.mRuntime.a();
            if (a16 != null && !a16.isFinishing()) {
                ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(a16);
                i3 = 1;
            } else {
                i3 = -1;
            }
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(str).setOperId(WadlProxyConsts.OPER_ID_FLOAT_PERMISSION).setRetId(i3).report();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlWebViewJsPlugin", 1, "openFloatingSetting appId=" + str + ",result=" + i3);
        }
        return i3;
    }

    protected int Q() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage("com.huawei.android.tips");
                intent.setAction("com.huawei.android.tips.ACTION_FEATURE_ID");
                intent.putExtra("featureId", "SF-10044537_f102");
                intent.putExtra("type", 52);
                intent.putExtra("big_brother_source_key", "biz_src_zf_games");
                topActivity.startActivity(intent);
                return 0;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("Wadl_WadlWebViewJsPlugin", 1, "openHuaWeiPureModeSetting exception", th5);
                }
            }
        }
        return -1;
    }

    protected int R() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            try {
                topActivity.startActivity(GameCenterUtil.getInstallSettingIntent());
                return 0;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("Wadl_WadlWebViewJsPlugin", 1, "openInstallSetting exception", th5);
                }
            }
        }
        return -1;
    }

    protected void T() {
        WadlProxyServiceUtil.getProxyService().doQueryAllRes();
    }

    protected void U() {
        WadlProxyServiceUtil.getProxyService().doQueryAllTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    protected int V(String str) {
        ?? r06;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 28) {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlWebViewJsPlugin", 1, "sdk version lower android10,version is " + i3);
            }
            r06 = 1;
        } else {
            boolean checkPermission = ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
            r06 = checkPermission;
            if (!checkPermission) {
                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(str).setOperId(WadlProxyConsts.OPER_ID_FLOAT_PERMISSION).setRetId(0).report();
                r06 = checkPermission;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlWebViewJsPlugin", 1, "queryFloatingPermission appid=" + str + ",floatPermission=" + ((boolean) r06));
        }
        return r06;
    }

    protected long W(String str) {
        try {
            if (TextUtils.isEmpty(str) || !f106842h.contains(str)) {
                return 0L;
            }
            return GameCenterSpUtils.readFromSpLong(GameCenterSpUtils.KEY_LAST_TIME_API_PRE + str);
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return 0L;
            }
            QLog.e("Wadl_WadlWebViewJsPlugin", 1, "readLastTime exception", th5);
            return 0L;
        }
    }

    protected int X(String str) {
        MobileQQ mobileQQ;
        try {
            if (TextUtils.isEmpty(str) || (mobileQQ = MobileQQ.sMobileQQ) == null) {
                return 1;
            }
            return Settings.Secure.getInt(mobileQQ.getContentResolver(), "pure_enhanced_mode_state", -1);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("Wadl_WadlWebViewJsPlugin", 1, "readModeState key=" + str + " exception", th5);
            }
            return -1;
        }
    }

    protected void Y(String str) {
        this.f106843d = str;
    }

    protected void Z(String str) {
        this.f106844e = str;
    }

    protected void a0(String str) {
        HashSet<String> hashSet;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(WadlProxyConsts.PARAM_WEBSSO_CMD_ID);
            JSONObject jSONObject2 = jSONObject.getJSONObject(WadlProxyConsts.PARAM_WEBSSO_REQ);
            com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
            if (gVar != null) {
                hashSet = gVar.c();
            } else {
                hashSet = GameCenterUtil.DEFAULT_WEBSSO_CMDS;
            }
            if (!TextUtils.isEmpty(string) && hashSet != null && hashSet.contains(string)) {
                Bundle bundle = new Bundle();
                bundle.putString(WadlProxyConsts.PARAM_REQ_JSON, jSONObject2.toString());
                ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).requestWebSso(string, jSONObject2, bundle);
                return;
            }
            callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + string + ", \"webssoReq\":" + jSONObject2.toString() + ", \"ret\":-2});}void(0);");
        } catch (Exception e16) {
            QLog.e("Wadl_WadlWebViewJsPlugin", 1, "requestWebSso>>>", e16);
        }
    }

    public void b0(String str) {
        try {
            int i3 = new JSONObject(str).getInt("toggle");
            Bundle bundle = new Bundle();
            bundle.putInt("toggle", i3);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_CHANGE_WND_TOGGLE, bundle);
        } catch (Exception e16) {
            QLog.e("Wadl_WadlWebViewJsPlugin", 1, "setFloatWndToggle>>>", e16);
        }
    }

    @Override // nl0.g
    public void d(WadlResult wadlResult) {
        if (wadlResult != null && wadlResult.wadlParams != null) {
            int convertRemoteStatusToLocal = GameCenterUtil.convertRemoteStatusToLocal(wadlResult.taskStatus);
            if (convertRemoteStatusToLocal != -2 && convertRemoteStatusToLocal != 10 && convertRemoteStatusToLocal != 20 && convertRemoteStatusToLocal != 2 && convertRemoteStatusToLocal != 3 && convertRemoteStatusToLocal != 4) {
                QLog.w("Wadl_WadlWebViewJsPlugin", 1, "download status not response!");
                return;
            } else {
                p(wadlResult);
                return;
            }
        }
        QLog.w("Wadl_WadlWebViewJsPlugin", 1, "onWadlResStatusChanged error wadlResult is null");
    }

    public int d0(String str) {
        try {
            if (!TextUtils.isEmpty(str) && f106842h.contains(str)) {
                GameCenterSpUtils.writeToSpLong(GameCenterSpUtils.KEY_LAST_TIME_API_PRE + str, NetConnInfoCenter.getServerTime());
                return 0;
            }
            return -1;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("Wadl_WadlWebViewJsPlugin", 1, "updateLastTime key=" + str + " exception", th5);
                return -1;
            }
            return -1;
        }
    }

    @Override // nl0.c
    public HashSet<String> getFilterCmds() {
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar != null) {
            return gVar.c();
        }
        return GameCenterUtil.DEFAULT_WEBSSO_CMDS;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "wadl_download";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4 = "[";
        if (strArr != null) {
            for (String str5 : strArr) {
                str4 = str4 + str5 + ",";
            }
        }
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", str, str2, str3, str4 + "]"));
        if (!"wadl_download".equals(str2)) {
            return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
        if (N(str3, jsBridgeListener, strArr) || J(str3, jsBridgeListener, strArr) || M(str3, jsBridgeListener, strArr) || L(str3, jsBridgeListener, strArr) || K(str3, jsBridgeListener, strArr)) {
            return true;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }

    @Override // nl0.g
    public void l(ArrayList<WadlResult> arrayList) {
        QLog.i("Wadl_WadlWebViewJsPlugin", 1, "onQueryResCallback params:" + arrayList);
        if (arrayList != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<WadlResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(GameCenterUtil.toResJSONObject(it.next()));
                }
                callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.queryAllDownloadRes',{\"r\" : 0, \"data\":" + jSONArray.toString() + "});}void(0);");
            } catch (Exception e16) {
                QLog.e("Wadl_WadlWebViewJsPlugin", 1, "onQueryResCallback exception:" + e16.getMessage());
            }
        }
    }

    @Override // nl0.c
    public void onCmdRsp(Intent intent, String str, long j3, JSONObject jSONObject) {
        String str2;
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, "onCmdRsp cmd=" + str + ",isSucc");
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (intent != null) {
            str2 = intent.getStringExtra(WadlProxyConsts.PARAM_REQ_JSON);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + str + ", \"webssoReq\":" + str2 + ", \"ret\":" + j3 + ", \"data\":" + jSONObject.toString() + "});}void(0);");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
        WadlProxyServiceUtil.getProxyService().unRegisterResCallBack(this);
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).removeListener(this);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, "onQueryCallback params:" + arrayList);
        if (arrayList != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<WadlResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(GameCenterUtil.toJSONObject(it.next()));
                }
                callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": 1, \"r\" : 0, \"data\":" + jSONArray.toString() + "});}void(0);");
            } catch (Exception e16) {
                QLog.e("Wadl_WadlWebViewJsPlugin", 1, "onQueryCallback exception:", e16);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, "onQueryCallbackVia params:" + arrayList);
        if (arrayList != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<WadlResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(GameCenterUtil.toJSONObject(it.next()));
                }
                callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadActionByVia',{\"guid\": 1, \"r\" : 0, \"data\":" + jSONArray.toString() + "});}void(0);");
            } catch (Exception e16) {
                QLog.e("Wadl_WadlWebViewJsPlugin", 1, "onQueryCallbackVia exception:", e16);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        if (wadlResult != null && wadlResult.wadlParams != null) {
            int convertRemoteStatusToLocal = GameCenterUtil.convertRemoteStatusToLocal(wadlResult.taskStatus);
            if (convertRemoteStatusToLocal != -2) {
                if (convertRemoteStatusToLocal != 6 && convertRemoteStatusToLocal != 13 && convertRemoteStatusToLocal != 20 && convertRemoteStatusToLocal != 2 && convertRemoteStatusToLocal != 3) {
                    if (convertRemoteStatusToLocal != 4) {
                        if (convertRemoteStatusToLocal != 9 && convertRemoteStatusToLocal != 10) {
                            QLog.w("Wadl_WadlWebViewJsPlugin", 1, "download status not response!");
                            return;
                        }
                    } else {
                        c0("\u4e0b\u8f7d\u5b8c\u6210");
                        q(wadlResult);
                        return;
                    }
                }
                q(wadlResult);
                return;
            }
            int wadlErrCode = GameCenterUtil.getWadlErrCode(wadlResult.errCode);
            QLog.w("Wadl_WadlWebViewJsPlugin", 1, "onWadlTaskStatusChanged  error,wadlErrCode=" + wadlErrCode);
            q(wadlResult);
            S(wadlErrCode, wadlResult.wadlParams);
            return;
        }
        QLog.w("Wadl_WadlWebViewJsPlugin", 1, "onWadlTaskStatusChanged error wadlResult is null");
    }

    public int r() {
        boolean isKingCard = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard();
        QLog.d("Wadl_WadlWebViewJsPlugin", 1, "canDualDownload isKingCard=" + isKingCard);
        return isKingCard ? 1 : 0;
    }

    protected boolean s(int i3, String... strArr) {
        if (strArr != null && strArr.length > i3) {
            return true;
        }
        return false;
    }

    protected void t() {
        SharedPreferences.Editor edit = MobileQQ.sMobileQQ.getSharedPreferences("wadl_jstask_file", 0).edit();
        edit.putBoolean("firstTime", false);
        edit.commit();
    }

    protected void u(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.Raft.TASKS);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                GameCenterUtil.deleteAppidFromList(jSONArray.get(i3).toString(), "DELAY_LIST");
            }
            callJs("if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.delDelayDownloadTasks',{\"result\" : 0 });}void(0);");
        } catch (Exception e16) {
            QLog.e("Wadl_WadlWebViewJsPlugin", 1, "delDelayDownloadTasks>>>", e16);
        }
    }

    protected void v(String str) {
        WadlProxyServiceUtil.getProxyService().deleteDownload(0, str);
    }

    protected int w(String str) {
        String str2;
        Intent intent;
        WebViewProvider f16 = this.mRuntime.f();
        if (f16 != null) {
            str2 = f16.getCurrentUrl();
        } else {
            str2 = "";
        }
        WadlParams wadlParams = new WadlParams(str);
        wadlParams.from = 0;
        if (TextUtils.isEmpty(wadlParams.fromWebUrl)) {
            wadlParams.fromWebUrl = str2;
        }
        if (wadlParams.isRes) {
            WadlProxyServiceUtil.getProxyService().dispatchResAction(wadlParams);
        } else {
            WadlProxyServiceUtil.getProxyService().dispatchAction(wadlParams);
        }
        int i3 = wadlParams.actionCode;
        if (i3 == 2 || i3 == 12 || i3 == 13) {
            Activity a16 = this.mRuntime.a();
            if (a16 != null) {
                intent = a16.getIntent();
            } else {
                intent = null;
            }
            Pair<Integer, String> sessionInfo = GameCenterUtil.getSessionInfo(intent);
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(WadlProxyConsts.OPER_ID_H5_CLICK_DOWNLOAD).setGameAppId(wadlParams.appId).setExt(2, String.valueOf(sessionInfo.first)).setExt(3, sessionInfo.second).setExt(4, wadlParams.apkChannel).setExt(5, wadlParams.apkUrl).setExt(6, str2).report();
        }
        return 0;
    }

    protected int x(String str) {
        String str2;
        WebViewProvider f16 = this.mRuntime.f();
        if (f16 != null) {
            str2 = f16.getCurrentUrl();
        } else {
            str2 = "";
        }
        WadlParams wadlParams = new WadlParams(str);
        wadlParams.from = 0;
        wadlParams.isRes = true;
        if (TextUtils.isEmpty(wadlParams.fromWebUrl)) {
            wadlParams.fromWebUrl = str2;
        }
        WadlProxyServiceUtil.getProxyService().dispatchResAction(wadlParams);
        return 0;
    }

    protected String y(String str) {
        int appVersionCode = GameCenterUtil.getAppVersionCode(str);
        if (appVersionCode == -1) {
            return "";
        }
        return String.valueOf(appVersionCode);
    }

    protected String z(String str) {
        PackageInfo packageInfo = GameCenterUtil.getPackageInfo(str);
        if (packageInfo == null) {
            return "";
        }
        return packageInfo.versionName + "";
    }
}
