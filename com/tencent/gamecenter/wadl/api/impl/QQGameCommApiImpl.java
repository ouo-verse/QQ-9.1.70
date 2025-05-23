package com.tencent.gamecenter.wadl.api.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.i;
import com.tencent.gamecenter.wadl.sdk.app.WadlRuntime;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameCommApiImpl implements IQQGameCommApi {
    public static final String TAG = "Wadl_QQGameCommApiImpl";

    private boolean compareFromParams(Map<String, String> map, String str, String str2) {
        if (map != null && map.containsKey(str)) {
            String str3 = map.get(str);
            if (TextUtils.isEmpty(str3)) {
                return true;
            }
            for (String str4 : str3.split(",")) {
                if (!TextUtils.isEmpty(str4) && str4.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public void clearQQGameDownloadFile() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameCommApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WadlRequest wadlRequest = new WadlRequest(Integer.MAX_VALUE, WadlProxyConsts.REMOTE_CMD_APP_DELETE_ALL_ACTION, new Bundle());
                    g Z = g.Z();
                    if (Z != null) {
                        Z.e3(wadlRequest);
                    }
                } catch (Exception e16) {
                    QLog.e(QQGameCommApiImpl.TAG, 1, e16, new Object[0]);
                }
            }
        }, 96, null, true);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public AppRuntime createAppRuntime(Context context, String str) {
        return new WadlRuntime();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public int getExpIntValue(String str, String str2, boolean z16) {
        int i3 = 0;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(WadlProxyConsts.EXP_QQ_QQGAME_TIPS);
            if (!expEntity.isExperiment()) {
                return 0;
            }
            Map<String, String> tabParams = expEntity.getTabParams();
            String str3 = tabParams.get(str);
            QLog.d(TAG, 1, "getExpIntValue tipsJson=" + str3);
            if (TextUtils.isEmpty(str3) && z16) {
                str3 = tabParams.get("*");
            }
            if (TextUtils.isEmpty(str3)) {
                return 0;
            }
            try {
                i3 = new JSONObject(str3).optInt(str2, 0);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "getExpIntValue exception paramsName=" + str2, e16);
            }
            QLog.d(TAG, 1, "getExpIntValue paramsName=" + str2 + ",value=" + i3);
        }
        return i3;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public int getExpType(String str, boolean z16, String str2, String str3) {
        int i3;
        QLog.d(TAG, 1, "getExpType appid=" + str + ",checkModel=" + z16 + ",expName=" + str2 + ", paramsName=" + str3 + ", model=" + DeviceInfoMonitor.getModel());
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str2);
        boolean isContrast = expEntity.isContrast();
        boolean isExperiment = expEntity.isExperiment();
        if (!isContrast && !isExperiment) {
            QLog.w(TAG, 1, "getExpType not exp user, appid=" + str + ",checkModel=" + z16 + ",expName=" + str2 + ", paramsName=" + str3);
            return 0;
        }
        Map<String, String> tabParams = expEntity.getTabParams();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isExpAppid checkModel=");
        sb5.append(z16);
        sb5.append(",expName=");
        sb5.append(str2);
        sb5.append(", expParamsMapSize=");
        if (tabParams != null) {
            i3 = tabParams.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        QLog.d(TAG, 1, sb5.toString());
        boolean compareFromParams = compareFromParams(tabParams, str3, str);
        if (compareFromParams && z16) {
            compareFromParams = compareFromParams(tabParams, IQQGameCommApi.K_ABTEST_MODELS, DeviceInfoMonitor.getModel());
        }
        if (!compareFromParams) {
            return 0;
        }
        if (!isExperiment) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public i getNextTipsInfo(GameNoticeInfo gameNoticeInfo, boolean z16) {
        JSONArray jSONArray;
        if (gameNoticeInfo == null) {
            return null;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(WadlProxyConsts.EXP_QQ_QQGAME_TIPS);
        expEntity.reportExpExposure();
        if (!expEntity.isExperiment()) {
            return null;
        }
        Map<String, String> tabParams = expEntity.getTabParams();
        String str = tabParams.get(gameNoticeInfo.f106722d);
        if (TextUtils.isEmpty(str) && z16) {
            str = tabParams.get("*");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            i iVar = new i();
            int i3 = gameNoticeInfo.F;
            int i16 = 0;
            if (i3 == 1) {
                iVar.f106835c = String.format(jSONObject.getString(IQQGameCommApi.KEY_INSTALL_CONTENT), gameNoticeInfo.f106723e);
                jSONArray = jSONObject.getJSONArray(IQQGameCommApi.KEY_INSTALL_SHOW_DELAY);
            } else if (i3 == 3) {
                iVar.f106835c = String.format(jSONObject.getString(IQQGameCommApi.KEY_PAUSE_CONTENT), gameNoticeInfo.f106723e);
                jSONArray = jSONObject.getJSONArray(IQQGameCommApi.KEY_PAUSE_SHOW_DELAY);
            } else {
                jSONArray = null;
            }
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                if (i16 >= length) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                long j3 = jSONObject2.getInt(IQQGameCommApi.KEY_END_DELAY) * 1000;
                long j16 = gameNoticeInfo.L + j3;
                if (j16 > currentTimeMillis && j16 > gameNoticeInfo.G) {
                    iVar.f106833a = jSONObject2.getInt(IQQGameCommApi.KEY_START_DELAY) * 1000;
                    iVar.f106834b = j3;
                    iVar.f106836d = jSONObject2.optBoolean(IQQGameCommApi.KEY_SYNC_NOTICE, true);
                    break;
                }
                QLog.d(TAG, 4, "getNextTipsInfo appId=" + gameNoticeInfo.f106722d + ",lastUpdateTime=" + gameNoticeInfo.G + ",endDelay=" + j3 + ",endTime=" + j16);
                i16++;
            }
            QLog.d(TAG, 1, "getNextTipsInfo appId=" + gameNoticeInfo.f106722d + ",wadlTipsInfo=" + iVar);
            return iVar;
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getNextTipsInfo exception", e16);
            return null;
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public com.tencent.gamecenter.wadl.biz.entity.f getTaskByAppId(String str) {
        return new kl0.b().d(str);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public boolean hasGameInstall(String str) {
        if (GameCenterUtil.getPackageInfo(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public boolean isExistMiniApp(String str) {
        Bundle bundle;
        String str2 = "";
        try {
            ApplicationInfo applicationInfo = MobileQQ.sMobileQQ.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                str2 = bundle.getString("isMiniApp");
            }
            QLog.i(TAG, 1, "isExistMiniApp isMiniApp=" + str2);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        return "yes".equals(str2);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public void onGameServiceExit() {
        g Z = g.Z();
        if (Z != null) {
            Z.destroy();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCommApi
    public void reportGameShare(int i3, int i16, int i17, String str, String str2, String str3, String str4) {
        String str5;
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        WadlReportBuilder operModule = wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("1044");
        if (i3 == 0) {
            str5 = "208076";
        } else {
            str5 = "208077";
        }
        operModule.setOperId(str5).setGameAppId(str).setModuleType("104005").setBussinessId("5").setPageId("122").setExt(2, String.valueOf(i16)).setExt(3, str2).setExt(6, str4).setExt(35, "0").setExt(46, str3).setExt(45, String.valueOf(i17));
        wadlReportBuilder.report();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportGameShare actionType=" + i3 + ",msgType=" + i16 + ",sessionType=" + i17 + ",gameappId=" + str + ",tagName=" + str2 + ",messageExt=" + str3 + ",title=" + str4);
        }
    }
}
