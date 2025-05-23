package com.tencent.mobileqq.qqgamepub.hippy.module;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e implements WadlProxyServiceCallBackInterface {

    /* renamed from: e, reason: collision with root package name */
    private static HashSet<String> f264550e;

    /* renamed from: d, reason: collision with root package name */
    private volatile a f264551d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        String a();

        void b(ArrayList<WadlResult> arrayList);

        Activity getHostActivity();

        void onWadlTaskStatusChanged(WadlResult wadlResult);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        f264550e = hashSet;
        hashSet.add("LAST_SHOW_DIALOG_TIME");
        f264550e.add("LAST_TIME_B1");
        f264550e.add("LAST_TIME_B2");
        f264550e.add("LAST_TIME_B3");
        f264550e.add("LAST_TIME_B4");
        f264550e.add("LAST_TIME_B5");
        f264550e.add("LAST_TIME_B6");
        f264550e.add("LAST_TIME_B7");
        f264550e.add("LAST_TIME_B8");
    }

    public e(a aVar) {
        this.f264551d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(WadlParams wadlParams, int i3) {
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "auto dual download status:" + i3);
        wadlParams.isDirectUseDualWay = i3;
        wadlParams.dualSwitch = i3;
        WadlProxyServiceUtil.getProxyService().dispatchAction(wadlParams);
    }

    public int A(String str) {
        try {
            if (TextUtils.isEmpty(str) || !f264550e.contains(str)) {
                return -1;
            }
            GameCenterSpUtils.writeToSpLong(GameCenterSpUtils.KEY_LAST_TIME_API_PRE + str, NetConnInfoCenter.getServerTime());
            return 0;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("QQGameCenter_QQWadlWrapper", 1, "updateLastTime key=" + str + " exception", th5);
            return -1;
        }
    }

    public int b() {
        boolean isKingCard = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard();
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "canDualDownload result=" + (isKingCard ? 1 : 0));
        return isKingCard ? 1 : 0;
    }

    public void c(String str) {
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "deleteDownload appid=" + str);
        WadlProxyServiceUtil.getProxyService().deleteDownload(0, str);
    }

    public void d() {
        z();
        this.f264551d = null;
    }

    public void e(String str) {
        if (this.f264551d == null) {
            return;
        }
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "doDownloadAction jsonParams=" + str);
        final WadlParams wadlParams = new WadlParams(str);
        wadlParams.from = 0;
        if (TextUtils.isEmpty(wadlParams.fromWebUrl)) {
            wadlParams.fromWebUrl = this.f264551d.a();
        }
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "isDirectUseDualWay=" + wadlParams.isDirectUseDualWay);
        if (wadlParams.isDirectUseDualWay < 0) {
            ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).getAutoDualGameSwitch(27, new jl0.a() { // from class: com.tencent.mobileqq.qqgamepub.hippy.module.d
                @Override // jl0.a
                public final void a(int i3) {
                    e.m(WadlParams.this, i3);
                }
            });
        } else {
            WadlProxyServiceUtil.getProxyService().dispatchAction(wadlParams);
        }
    }

    public void f(String str) {
        ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).doDualDownload(str);
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "doDualDownloadAction jsonParams=" + str);
    }

    public long g() {
        try {
            return Utils.z();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public int h() {
        int cacheDualSwitch = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).getCacheDualSwitch();
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "getDualSwitch getCacheDualSwitch=" + cacheDualSwitch);
        return cacheDualSwitch;
    }

    public HashMap<String, Object> i(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenter_QQWadlWrapper", 2, "getInstalledAppVersionCode packageNameJsonStr=", str, ",guid=", str2);
        }
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
                    if (packageInfo == null) {
                        str4 = "";
                        str5 = str4;
                        str6 = str5;
                    } else {
                        str5 = String.valueOf(packageInfo.versionCode);
                        str4 = packageInfo.versionName;
                        str6 = GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(string));
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("packageName", string);
                    jSONObject2.put("versionCode", str5);
                    jSONObject2.put("versionName", str4);
                    jSONObject2.put(WadlProxyConsts.CHANNEL, str6);
                    jSONArray.mo162put(jSONObject2);
                }
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("r", 0);
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
            }
            hashMap.put("guid", str3);
            hashMap.put("data", jSONArray.toString());
            return hashMap;
        } catch (Exception unused) {
            HashMap<String, Object> hashMap2 = new HashMap<>();
            hashMap2.put("r", -1);
            if (str2 != null) {
                str7 = str2;
            }
            hashMap2.put("guid", str7);
            return hashMap2;
        }
    }

    public float j() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF, "");
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "[getMobileDownloadRate] downloaderConfStr=" + loadAsString);
        float f16 = 0.1f;
        if (TextUtils.isEmpty(loadAsString)) {
            return 0.1f;
        }
        try {
            JSONObject optJSONObject = new JSONObject(loadAsString).optJSONObject("dual");
            if (optJSONObject == null) {
                return 0.1f;
            }
            int optInt = optJSONObject.optInt("def_rate", 0);
            short optInt2 = (short) optJSONObject.optInt("mobile_rate", 0);
            int optInt3 = optInt + optInt2 + ((short) optJSONObject.optInt("p2p_rate", 0));
            if (optInt2 != 0 && optInt3 > 0) {
                f16 = (optInt2 * 1.0f) / optInt3;
                QLog.i("QQGameCenter_QQWadlWrapper", 1, "mobileAmount=" + ((int) optInt2) + ",totalAmount=" + optInt3 + ",mobileRate:" + f16);
                return f16;
            }
            return 0.1f;
        } catch (Throwable th5) {
            QLog.e("QQGameCenter_QQWadlWrapper", 1, "optChangeThreadRate exception", th5);
            return f16;
        }
    }

    public void k(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenter_QQWadlWrapper", 2, "getQueryDownloadAction, jsonParams=", str);
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("infolist");
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
        } catch (Exception e16) {
            QLog.e("QQGameCenter_QQWadlWrapper", 1, "query getQueryDownloadAction>>>", e16);
        }
    }

    public boolean l() {
        boolean hasSimCard = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).hasSimCard();
        boolean isFlowSwitchOn = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isFlowSwitchOn();
        QLog.i("QQGameCenter_QQWadlWrapper", 1, "[isMobileFlowAvailable] hasSimCard:" + hasSimCard + ",isFlowSwitchOn:" + isFlowSwitchOn);
        if (hasSimCard && isFlowSwitchOn) {
            return true;
        }
        return false;
    }

    public int n(String str) {
        int i3;
        int i16 = -1;
        if (this.f264551d == null) {
            return -1;
        }
        int i17 = Build.VERSION.SDK_INT;
        if (i17 <= 28) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGameCenter_QQWadlWrapper", 1, "sdk version lower android10,version is " + i17);
            }
            i3 = 0;
        } else {
            Activity hostActivity = this.f264551d.getHostActivity();
            if (hostActivity != null) {
                ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(hostActivity);
                i16 = 1;
            }
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(str).setOperId(WadlProxyConsts.OPER_ID_FLOAT_PERMISSION).setRetId(i16).report();
            i3 = i16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenter_QQWadlWrapper", 1, "openFloatingSetting appid=" + str + ",result=" + i3);
        }
        return i3;
    }

    public int o() {
        Activity hostActivity;
        if (this.f264551d == null || (hostActivity = this.f264551d.getHostActivity()) == null) {
            return -1;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage("com.huawei.android.tips");
            intent.setAction("com.huawei.android.tips.ACTION_FEATURE_ID");
            intent.putExtra("featureId", "SF-10044537_f102");
            intent.putExtra("type", 52);
            intent.putExtra("big_brother_source_key", "biz_src_zf_games");
            hostActivity.startActivity(intent);
            return 0;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("QQGameCenter_QQWadlWrapper", 1, "openHuaWeiPureModeSetting exception", th5);
            return -1;
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(ArrayList<WadlResult> arrayList) {
        if (arrayList != null && this.f264551d != null) {
            this.f264551d.b(arrayList);
        }
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(WadlResult wadlResult) {
        if (wadlResult != null && wadlResult.wadlParams != null && this.f264551d != null) {
            this.f264551d.onWadlTaskStatusChanged(wadlResult);
        }
    }

    public int p() {
        if (this.f264551d == null) {
            return -1;
        }
        QLog.d("QQGameCenter_QQWadlWrapper", 1, "hippy api call openInstallSetting");
        Activity hostActivity = this.f264551d.getHostActivity();
        if (hostActivity == null) {
            return -1;
        }
        try {
            hostActivity.startActivity(GameCenterUtil.getInstallSettingIntent());
            return 0;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("QQGameCenter_QQWadlWrapper", 1, "openInstallSetting exception", th5);
            return -1;
        }
    }

    public void q() {
        if (this.f264551d == null) {
            return;
        }
        Activity hostActivity = this.f264551d.getHostActivity();
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenter_QQWadlWrapper", 2, "queryAllDownloadTask currActivity=" + hostActivity);
        }
        if (hostActivity != null) {
            WadlProxyServiceUtil.getProxyService().doQueryAllTask();
        } else {
            WadlProxyServiceUtil.getProxyService().doQueryAllTaskByPreload();
        }
    }

    public boolean r(String str) {
        boolean checkPermission;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 28) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGameCenter_QQWadlWrapper", 1, "sdk version lower android10,version is " + i3);
            }
            checkPermission = true;
        } else {
            checkPermission = ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext());
            if (!checkPermission) {
                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(str).setOperId(WadlProxyConsts.OPER_ID_FLOAT_PERMISSION).setRetId(0).report();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenter_QQWadlWrapper", 1, "queryFloatingPermission appid=" + str + ",floatPermission=" + checkPermission);
        }
        return checkPermission;
    }

    public boolean s() {
        QLog.d("QQGameCenter_QQWadlWrapper", 1, "hippy api call queryInstallPermission");
        return GameCenterUtil.checkInstallPermission();
    }

    public int t() {
        int i3 = 1;
        try {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                i3 = Settings.Secure.getInt(mobileQQ.getContentResolver(), "pure_enhanced_mode_state", -1);
            }
            return i3;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return -1;
            }
            QLog.e("QQGameCenter_QQWadlWrapper", 1, "readHuaweiPureModeState exception:", th5);
            return -1;
        }
    }

    public long u(String str) {
        try {
            if (TextUtils.isEmpty(str) || !f264550e.contains(str)) {
                return 0L;
            }
            return GameCenterSpUtils.readFromSpLong(GameCenterSpUtils.KEY_LAST_TIME_API_PRE + str);
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return 0L;
            }
            QLog.e("QQGameCenter_QQWadlWrapper", 1, "readLastTime exception", th5);
            return 0L;
        }
    }

    public void v() {
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
    }

    public void w(String str) {
        QLog.d("QQGameCenter_QQWadlWrapper", 1, "hippy api call requestFloatingPermission");
        GameCenterUtil.requestFloatingScreenPermission(str);
    }

    public void x(String str) {
        QLog.d("QQGameCenter_QQWadlWrapper", 1, "setDualSwitch switchValue=" + str);
        ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).setDualSwitch(str);
    }

    public void y(int i3, int i16) {
        QLog.d("QQGameCenter_QQWadlWrapper", 1, "setDualSwitchExt status=" + i3 + ",switchId=" + i16);
        ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).setDualSwitch(i3, i16);
    }

    public void z() {
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
    }
}
