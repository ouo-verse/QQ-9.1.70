package com.tencent.mobileqq.qqvideoplatform.imp;

import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr;
import com.tencent.mobileqq.qqvideoplatform.imp.QQVideoSDKUnitedConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e implements IQQVideoSDKConfigMgr {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Executor {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            } else {
                ThreadManagerV2.excute(runnable, 16, null, false);
            }
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int[] a(String str, String str2) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split(str2)) != null && split.length > 0) {
            int[] iArr = new int[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                iArr[i3] = Integer.parseInt(split[i3]);
            }
            return iArr;
        }
        return null;
    }

    private String b(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (expEntity == null) {
            return "";
        }
        return expEntity.getAssignment();
    }

    private String c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103135", "115|116|118|124|125|126|129|132|135|140");
    }

    private static JSONObject d(QQVideoSDKUnitedConfigParser.b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("EnableRequestFileSizeFirst", true);
        jSONObject.put("UsePlayerPosRemainTime", true);
        jSONObject.put("enableListenerPlayerBuffer", true);
        jSONObject.put("PCDNFileProtectBuffTime", 4);
        jSONObject.put("PCDNFileMinBuffTime", 2);
        jSONObject.put("EnableReport", false);
        jSONObject.put("EnableUseDnsV6InV6Dual4G", true);
        jSONObject.put("EnableUseDnsV6InV6DualWifi", false);
        jSONObject.put("ReportTime", "11:14 21:24");
        jSONObject.put("ChoosePieceModule", 4);
        jSONObject.put("PCDNPrepareDownloadResident", true);
        jSONObject.put("VodCarrierP2PTime", "8:24");
        jSONObject.put("PrePlayDownloadGoPcdn", true);
        jSONObject.put("PrepareDownloadGoPcdn", true);
        jSONObject.put("PCDN4gEnable", true);
        jSONObject.put("EnableCarrierP2PDownload", true);
        jSONObject.put("EnableEmergencyOpt", false);
        jSONObject.put("EnableP2P", false);
        jSONObject.put("OpenIPSwitch", true);
        jSONObject.put("EmergencyDownloadIgnoreCacheFull", true);
        jSONObject.put("QuicFailedTimesMax", 3);
        jSONObject.put("PrePlayPCDNNoDataTimeout", 2000);
        jSONObject.put("EnableClearTimerOnStart", false);
        jSONObject.put("EnableUseDnsV6InV6Dual", true);
        jSONObject.put("UseIPv6Cache", true);
        f(jSONObject, bVar);
        return jSONObject;
    }

    @NonNull
    private QQVideoSDKUnitedConfigParser.b e(IUnitedConfigManager iUnitedConfigManager, String str) {
        if (iUnitedConfigManager == null) {
            iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        }
        QQVideoSDKUnitedConfigParser.b bVar = (QQVideoSDKUnitedConfigParser.b) iUnitedConfigManager.loadConfig(str);
        if (bVar == null) {
            return new QQVideoSDKUnitedConfigParser.b();
        }
        return bVar;
    }

    private static JSONObject f(JSONObject jSONObject, QQVideoSDKUnitedConfigParser.b bVar) throws JSONException {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        Map<String, String> a16 = bVar.a();
        for (String str : a16.keySet()) {
            String str2 = a16.get(str);
            if (str2 != null) {
                if (Boolean.TRUE.toString().equals(str2)) {
                    jSONObject.put(str, true);
                } else if (Boolean.FALSE.toString().equals(str2)) {
                    jSONObject.put(str, false);
                } else {
                    try {
                        if (str2.contains(".")) {
                            jSONObject.put(str, Double.parseDouble(str2));
                        } else {
                            jSONObject.put(str, Integer.parseInt(str2));
                        }
                    } catch (Exception unused) {
                        jSONObject.put(str, str2);
                    }
                }
            }
        }
        return jSONObject;
    }

    private static void g(String str, String str2) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeString(str, str2);
        from.commitSync();
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr
    public boolean enableInitDownloadOnly() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (e((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class), "100697").b("initDownloadOnly", 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr
    public boolean enableInitSDKWithoutWait() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (e((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class), "100697").b("initSDKWithoutWait", 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr
    public boolean getAliveEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (e((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class), "100100").b("alive_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr
    public ConcurrentHashMap<String, String> getCommonReportMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new ConcurrentHashMap<>();
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr
    public void initConfig(SuperPlayerSdkOption superPlayerSdkOption) throws JSONException {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) superPlayerSdkOption);
            return;
        }
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        QQVideoSDKUnitedConfigParser.b e16 = e(iUnitedConfigManager, "100098");
        superPlayerSdkOption.userConfig = d(e16).toString();
        superPlayerSdkOption.superSampleConfig = e(iUnitedConfigManager, "100112").a();
        boolean z18 = false;
        if (e16.b("server_config_enable", 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        superPlayerSdkOption.serverConfigEnable = z16;
        superPlayerSdkOption.configRequestIntervalInHour = e16.b("request_interval_inhour", 12);
        SuperPlayerSDKMgr.setUpdatePlayerInfoInterval(e16.b("update_player_info_interval", 1000));
        int b16 = e16.b("proxy_max_memory_size", 100);
        if (b16 != 100) {
            SuperPlayerSDKMgr.setProxyMaxUseMemoryMB(b16);
        }
        QQVideoSDKUnitedConfigParser.b e17 = e(iUnitedConfigManager, "100100");
        superPlayerSdkOption.backgroundAliveTime = e17.b("alive_time", 30);
        superPlayerSdkOption.quickDeinitTime = e17.b("quick_deinit_time", 5);
        superPlayerSdkOption.dropFrameReportSceneId = a(e(iUnitedConfigManager, "100191").d("scene_id", ""), "\\|");
        QQVideoSDKUnitedConfigParser.b e18 = e(iUnitedConfigManager, "100249");
        if (e18.b("enableThreadPool", 1) == 1) {
            superPlayerSdkOption.threadPool = new a();
        }
        if (e18.b("enableSubThread", 1) == 1) {
            superPlayerSdkOption.subThread = (HandlerThread) ThreadManagerV2.getSubThread();
        }
        if (e18.b("enableTVideoResidentThread", 0) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        superPlayerSdkOption.tvideoUseResidentThread = z17;
        superPlayerSdkOption.tvideoThreadSize = e18.b("tvideoThreadSize", 1);
        superPlayerSdkOption.tvideoThreadAliveTimeSecond = e18.b("tvideoThreadAliveTime", 30);
        if (e16.b("mediaCodecStuckCheckEnable", 1) == 1) {
            z18 = true;
        }
        superPlayerSdkOption.mediaCodecStuckCheckEnable = z18;
        try {
            QQVideoSDKUnitedConfigParser.b e19 = e(iUnitedConfigManager, "100104");
            superPlayerSdkOption.bandwidthReportSceneId = a(e19.d("scene_id", ""), "\\|");
            superPlayerSdkOption.bandwidthReportIntervalMs = e19.c("report_interval", 60000L);
        } catch (Exception e26) {
            if (QLog.isColorLevel()) {
                QLog.e("[VideoPlatform]QQVideoSDKUnitedConfigMgr", 2, "initConfig: reportConfig error", e26);
            }
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103108", true);
        superPlayerSdkOption.enableReleaseByJoin = isSwitchOn;
        QLog.d("[VideoPlatform]QQVideoSDKUnitedConfigMgr", 1, "initConfig enableReleaseByJoin :" + isSwitchOn);
        superPlayerSdkOption.pcdnBizID = b("exp_xsj_player_fast_play_9095_pcdn");
        QLog.d("[VideoPlatform]QQVideoSDKUnitedConfigMgr", 1, "initConfig pcdnBizId :" + superPlayerSdkOption.pcdnBizID);
        superPlayerSdkOption.sceneReleaseWhiteString = c();
        QLog.d("[VideoPlatform]QQVideoSDKUnitedConfigMgr", 1, "initConfig whit sceneId :" + superPlayerSdkOption.sceneReleaseWhiteString);
        superPlayerSdkOption.demuxerReadPacketErrorCheckEof = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105808", true);
        superPlayerSdkOption.enableErrorWhenThreadCreateFailed = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105809", true);
        if (QLog.isColorLevel()) {
            QLog.d("[VideoPlatform]QQVideoSDKUnitedConfigMgr", 2, "initConfig by united ");
        }
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr
    public void saveConfigToMMKV() throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
        QQVideoSDKUnitedConfigParser.b e16 = e(iUnitedConfigManager, "100098");
        String d16 = e16.d(IQQVideoSDKConfigMgr.CONFIG_KEY_SUPERPLAYER_SO_NAMES, "");
        if (!TextUtils.isEmpty(d16)) {
            g(IQQVideoSDKConfigMgr.CONFIG_KEY_SUPERPLAYER_SO_NAMES, d16);
        }
        g(IQQVideoSDKConfigMgr.CONFIG_KEY_SUPERPLAYER_USER_CONFIG, d(e16).toString());
        g(IQQVideoSDKConfigMgr.CONFIG_KEY_SUPERPLAYER_SAMPLE_CONFIG, f(null, e(iUnitedConfigManager, "100112")).toString());
    }
}
