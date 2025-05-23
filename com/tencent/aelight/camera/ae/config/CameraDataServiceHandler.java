package com.tencent.aelight.camera.ae.config;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetHorseRaceMaterialsRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTABConfigurationRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.data.AEGiftMaterialConfigParser;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.GsonUtils;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.light.LightVersionInfo;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c$ReqBody;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c$RspBody;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CameraDataServiceHandler extends BusinessHandler {

    /* renamed from: f, reason: collision with root package name */
    public static final Type f63463f = new a().getType();

    /* renamed from: h, reason: collision with root package name */
    private static final String f63464h = CameraDataServiceHandler.class.getName();

    /* renamed from: d, reason: collision with root package name */
    private EntityManager f63465d;

    /* renamed from: e, reason: collision with root package name */
    protected Map<String, Long> f63466e;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends TypeToken<GetPlayShowCatMatTreeRsp> {
        a() {
        }
    }

    public CameraDataServiceHandler(AppInterface appInterface) {
        super(appInterface);
        this.f63466e = new HashMap();
        LogUtils.setEnable(false);
        this.f63465d = appInterface.getEntityManagerFactory().createEntityManager();
    }

    private void I2(FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        ArrayList<MetaCategory> arrayList;
        GetCategoryMaterialRsp getCategoryMaterialRsp = (GetCategoryMaterialRsp) obj;
        if (getCategoryMaterialRsp != null && getCategoryMaterialRsp.Code == 0 && (arrayList = getCategoryMaterialRsp.Categories) != null && !arrayList.isEmpty()) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera", "response", "succeeded with content"));
            }
            AECameraPrefsUtil.f().p(IAECameraPrefsUtil.KEY_ETAG_EMOJI, getCategoryMaterialRsp.ETag, 4);
            String json = new Gson().toJson(getCategoryMaterialRsp);
            File file = new File(g.b.C0560b.f65280g);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileUtils.writeFile(g.b.f65271b, json);
        } else if (AEDashboardUtil.x()) {
            MutableLiveData<AEDashboardUtil.d> k3 = AEDashboardUtil.k();
            if (fromServiceMsg.isSuccess()) {
                str = "succeeded without content";
            } else {
                str = "failed";
            }
            k3.postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera", "response", str));
        }
        b.b().postValue(Boolean.TRUE);
        Map<String, Long> map = this.f63466e;
        if (map != null && map.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera")) {
            str2 = "" + (System.currentTimeMillis() - this.f63466e.get("ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera").longValue());
        } else {
            str2 = "-1";
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), str2, "ShadowBackendSvc.GetCategoryMaterial.MqEmoCamera", getCategoryMaterialRsp != null ? getCategoryMaterialRsp.Code : -1024);
    }

    private void J2(FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        ArrayList<MetaCategory> arrayList;
        AEFlashShowMaterialManager aEFlashShowMaterialManager;
        GetCategoryMaterialRsp getCategoryMaterialRsp = (GetCategoryMaterialRsp) obj;
        if (getCategoryMaterialRsp != null && getCategoryMaterialRsp.Code == 0 && (arrayList = getCategoryMaterialRsp.Categories) != null && !arrayList.isEmpty()) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera", "response", "succeeded with content"));
            }
            AECameraPrefsUtil.f().p(IAECameraPrefsUtil.KEY_ETAG_FLASH_SHOW, getCategoryMaterialRsp.ETag, 4);
            FileUtils.writeFile(AEFlashShowMaterialManager.E(), new Gson().toJson(getCategoryMaterialRsp));
            if ((com.tencent.aelight.camera.aebase.a.a() instanceof PeakAppInterface) && (aEFlashShowMaterialManager = (AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(3)) != null) {
                aEFlashShowMaterialManager.I(true);
            }
        } else if (AEDashboardUtil.x()) {
            MutableLiveData<AEDashboardUtil.d> k3 = AEDashboardUtil.k();
            if (fromServiceMsg.isSuccess()) {
                str = "succeeded without content";
            } else {
                str = "failed";
            }
            k3.postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera", "response", str));
        }
        ((AEFlashShowMaterialManager) com.tencent.aelight.camera.ae.control.a.b(3)).Z();
        Map<String, Long> map = this.f63466e;
        if (map != null && map.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqStoryCamera")) {
            str2 = "" + (System.currentTimeMillis() - this.f63466e.get("ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera").longValue());
        } else {
            str2 = "-1";
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), str2, "ShadowBackendSvc.GetCategoryMaterial.MqKuaishanCamera", getCategoryMaterialRsp != null ? getCategoryMaterialRsp.Code : -1024);
    }

    private void L2(FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        if (QLog.isDebugVersion()) {
            QLog.d(f63464h, 4, "[handlePlayShowCategoryMaterials] start");
        }
        GetPlayShowCatMatTreeRsp getPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp) obj;
        if (getPlayShowCatMatTreeRsp != null && getPlayShowCatMatTreeRsp.Code == 0 && !getPlayShowCatMatTreeRsp.Categories.isEmpty()) {
            if (QLog.isDebugVersion()) {
                QLog.d(f63464h, 4, "[handlePlayShowCategoryMaterials] response=" + getPlayShowCatMatTreeRsp);
            }
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetPlayShowCatMatTree", "response", "succeeded with content"));
            }
            AECameraPrefsUtil.f().p("ShadowBackendSvc.GetPlayShowCatMatTree", getPlayShowCatMatTreeRsp.ETag, 4);
            String obj2Json = GsonUtils.obj2Json(getPlayShowCatMatTreeRsp, f63463f);
            File file = new File(g.c.b.f65290d);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileUtils.writeFile(g.c.f65282b, obj2Json);
        } else {
            if (QLog.isDebugVersion()) {
                QLog.d(f63464h, 4, "[handlePlayShowCategoryMaterials] response=empty");
            }
            if (AEDashboardUtil.x()) {
                MutableLiveData<AEDashboardUtil.d> k3 = AEDashboardUtil.k();
                if (fromServiceMsg.isSuccess()) {
                    str = "succeeded without content";
                } else {
                    str = "failed";
                }
                k3.postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetPlayShowCatMatTree", "response", str));
            }
        }
        b.d().postValue(Boolean.TRUE);
        Map<String, Long> map = this.f63466e;
        if (map != null && map.containsKey("ShadowBackendSvc.GetPlayShowCatMatTree")) {
            str2 = "" + (System.currentTimeMillis() - this.f63466e.get("ShadowBackendSvc.GetPlayShowCatMatTree").longValue());
        } else {
            str2 = "-1";
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), str2, "ShadowBackendSvc.GetPlayShowCatMatTree", getPlayShowCatMatTreeRsp == null ? -1024 : getPlayShowCatMatTreeRsp.Code);
        if (QLog.isDebugVersion()) {
            QLog.d(f63464h, 4, "[handlePlayShowCategoryMaterials] end");
        }
    }

    private void M2(FromServiceMsg fromServiceMsg, Object obj) {
        AEMaterialManager aEMaterialManager;
        if (!(fr.b.a() instanceof PeakAppInterface) || (aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1)) == null) {
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        aEMaterialManager.g0(isSuccess, (isSuccess && (obj instanceof GetHorseRaceMaterialsRsp)) ? ((GetHorseRaceMaterialsRsp) obj).RaceMaterialList : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N2(FromServiceMsg fromServiceMsg, Object obj, String str) {
        String str2;
        String str3;
        ArrayList<MetaCategory> arrayList;
        AEMaterialManager aEMaterialManager;
        GetCategoryMaterialRsp getCategoryMaterialRsp = (GetCategoryMaterialRsp) obj;
        if (getCategoryMaterialRsp != null && getCategoryMaterialRsp.Code == 0 && (arrayList = getCategoryMaterialRsp.Categories) != null && !arrayList.isEmpty()) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial." + str, "response", "succeeded with content"));
            }
            if (str.equals(AECameraConstants.CAMERA_STORY_MAKEUP_SERVICEID)) {
                AECameraPrefsUtil.f().p(IAECameraPrefsUtil.KEY_ETAG_STORY_MAKEUP, getCategoryMaterialRsp.ETag, 4);
            } else {
                AECameraPrefsUtil.f().p(IAECameraPrefsUtil.KEY_ETAG_STORY, getCategoryMaterialRsp.ETag, 4);
            }
            FileUtils.writeFile(AEMaterialManager.M(), new Gson().toJson(getCategoryMaterialRsp));
            if ((com.tencent.aelight.camera.aebase.a.a() instanceof PeakAppInterface) && (aEMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1)) != null) {
                aEMaterialManager.P(true);
            }
        } else if (AEDashboardUtil.x()) {
            MutableLiveData<AEDashboardUtil.d> k3 = AEDashboardUtil.k();
            String str4 = "ShadowBackendSvc.GetCategoryMaterial." + str;
            if (fromServiceMsg.isSuccess()) {
                str2 = "succeeded without content";
            } else {
                str2 = "failed";
            }
            k3.postValue(new AEDashboardUtil.d(str4, "response", str2));
        }
        AEMaterialManager aEMaterialManager2 = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
        aEMaterialManager2.k0();
        aEMaterialManager2.h(g.a.f65246a);
        Map<String, Long> map = this.f63466e;
        if (map != null) {
            if (map.containsKey("ShadowBackendSvc.GetCategoryMaterial." + str)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append(System.currentTimeMillis() - this.f63466e.get("ShadowBackendSvc.GetCategoryMaterial." + str).longValue());
                str3 = sb5.toString();
                com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), str3, "ShadowBackendSvc.GetCategoryMaterial." + str, getCategoryMaterialRsp == null ? getCategoryMaterialRsp.Code : -1024);
            }
        }
        str3 = "-1";
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), str3, "ShadowBackendSvc.GetCategoryMaterial." + str, getCategoryMaterialRsp == null ? getCategoryMaterialRsp.Code : -1024);
    }

    private void P2(FromServiceMsg fromServiceMsg, Object obj) {
        if (obj instanceof GetTABConfigurationRsp) {
            GetTABConfigurationRsp getTABConfigurationRsp = (GetTABConfigurationRsp) obj;
            if (fromServiceMsg.isSuccess()) {
                Map<String, CameraConfig> map = getTABConfigurationRsp.ConfigMap;
                ms.a.f(f63464h, "TabABTest configMap=" + map.toString());
                G2(map);
                K2(map);
                O2(map);
                return;
            }
            ms.a.c(f63464h, "tab a/b test request failed.");
        }
    }

    private void Q2(FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        ArrayList<MetaCategory> arrayList;
        GetCategoryMaterialRsp getCategoryMaterialRsp = (GetCategoryMaterialRsp) obj;
        if (getCategoryMaterialRsp != null && getCategoryMaterialRsp.Code == 0 && (arrayList = getCategoryMaterialRsp.Categories) != null && !arrayList.isEmpty()) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark", "response", "succeeded with content"));
            }
            AECameraPrefsUtil.f().p(IAECameraPrefsUtil.KEY_ETAG_WATERMARK, getCategoryMaterialRsp.ETag, 4);
            String json = new Gson().toJson(getCategoryMaterialRsp);
            File file = new File(g.d.a.f65297c);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileUtils.writeFile(g.d.f65294b, json);
            if (com.tencent.aelight.camera.aebase.a.a() instanceof PeakAppInterface) {
                com.tencent.aelight.camera.ae.data.b.a().e();
            }
        } else if (AEDashboardUtil.x()) {
            MutableLiveData<AEDashboardUtil.d> k3 = AEDashboardUtil.k();
            if (fromServiceMsg.isSuccess()) {
                str = "succeeded without content";
            } else {
                str = "failed";
            }
            k3.postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark", "response", str));
        }
        Map<String, Long> map = this.f63466e;
        if (map != null && map.containsKey("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark")) {
            str2 = "" + (System.currentTimeMillis() - this.f63466e.get("ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark").longValue());
        } else {
            str2 = "-1";
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), str2, "ShadowBackendSvc.GetCategoryMaterial.MqCircleWatermark", getCategoryMaterialRsp != null ? getCategoryMaterialRsp.Code : -1024);
    }

    private boolean R2(JsonObject jsonObject) {
        return com.tencent.aelight.camera.ae.util.c.c(GsonUtils.optString(jsonObject, "verFrom"), GsonUtils.optString(jsonObject, "verTo"));
    }

    public void E2() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.config.CameraDataServiceHandler.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile]");
                String str = g.a.b.f65255d;
                if (FileUtils.fileExists(str)) {
                    QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile] PATH_MATERIAL_ZIP_DOWNLOAD_OLD");
                    FileUtils.deleteDirectory(str);
                }
                String str2 = g.a.b.f65256e;
                if (FileUtils.fileExists(str2)) {
                    QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile] PATH_MATERIAL_FINAL_USABLE_OLD");
                    FileUtils.deleteDirectory(str2);
                }
                String str3 = g.a.b.f65257f;
                if (FileUtils.fileExists(str3)) {
                    QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_OLD");
                    FileUtils.deleteDirectory(str3);
                }
                if (FileUtils.fileExists(g.d.a.f65296b)) {
                    QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_JSON_OLD");
                    FileUtils.deleteDirectory(str3);
                }
                if (FileUtils.fileExists(g.b.C0560b.f65279f)) {
                    QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile] PATH_MATERIAL_CONFIG_JSON_OLD");
                    FileUtils.deleteDirectory(str3);
                }
                String str4 = g.a.b.f65258g;
                if (FileUtils.fileExists(str4)) {
                    QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile] PATH_MATERIAL_ZIP_DOWNLOAD_DEPRECATED");
                    FileUtils.deleteDirectory(str4);
                }
                String str5 = g.a.b.f65259h;
                if (FileUtils.fileExists(str5)) {
                    QLog.d(CameraDataServiceHandler.f63464h, 4, "[deleteOldMaterialFile] PATH_MATERIAL_FINAL_USABLE_DEPRECATED");
                    FileUtils.deleteDirectory(str5);
                }
            }
        });
    }

    protected void F2(FromServiceMsg fromServiceMsg, Object obj) {
        String str = f63464h;
        ms.a.a(str, "arcake: handleARCakeMaterial");
        if (!fromServiceMsg.isSuccess()) {
            ms.a.c(str, "arcake: handleARCakeMaterial not success ");
            return;
        }
        oidb_cmd0xf8c$RspBody oidb_cmd0xf8c_rspbody = new oidb_cmd0xf8c$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_cmd0xf8c_rspbody);
        ms.a.a(str, "arcake: result :" + parseOIDBPkg);
        if (parseOIDBPkg != 0) {
            AEGiftMaterialConfigParser.f63512c = false;
            return;
        }
        AEGiftMaterialConfigParser.f63512c = true;
        try {
            AEGiftMaterialConfigParser.d(oidb_cmd0xf8c_rspbody);
            if (com.tencent.aelight.camera.aebase.a.a() instanceof PeakAppInterface) {
                AEARCakeMaterialManager.i().q();
            }
        } catch (AEGiftMaterialConfigParser.AEGiftMaterialConfigParserExpection e16) {
            ms.a.c(f63464h, "arcake: exception  :" + e16.getMessage());
        }
    }

    public void S2() {
        if (!NetworkUtil.isNetworkAvailable()) {
            LogUtils.w(f63464h, "[reqCameraConfig] no network....");
            return;
        }
        if (AEDashboardUtil.x()) {
            AEDashboardUtil.k().postValue(new AEDashboardUtil.d(AECameraConstants.CMD_CAMERA_CONFIG, Const.BUNDLE_KEY_REQUEST, "null"));
        }
        ms.a.f(f63464h, "\u3010REQUEST\u3011reqCameraConfig");
        this.f63466e.put(AECameraConstants.CMD_CAMERA_CONFIG, Long.valueOf(System.currentTimeMillis()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), AECameraConstants.CMD_CAMERA_CONFIG);
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE);
        send(toServiceMsg);
    }

    public void T2() {
        if (!NetworkUtil.isNetworkAvailable()) {
            ms.a.c(f63464h, "reqMaterialRace---network error.");
            return;
        }
        ms.a.f(f63464h, "\u3010REQUEST\u3011 reqMaterialRace");
        this.f63466e.put(AECameraConstants.CMD_MATERIAL_RACE, Long.valueOf(System.currentTimeMillis()));
        send(new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), AECameraConstants.CMD_MATERIAL_RACE));
    }

    public void U2() {
        if (!NetworkUtil.isNetworkAvailable()) {
            if (QLog.isDebugVersion()) {
                String str = f63464h;
                QLog.d(str, 4, "[reqPlayShowCategoryMaterials] no network....");
                QLog.d(str, 4, "[reqPlayShowCategoryMaterials] end");
                return;
            }
            return;
        }
        ms.a.f(f63464h, "\u3010REQUEST\u3011reqPlayShowCategoryMaterials");
        if (AEDashboardUtil.x()) {
            AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetPlayShowCatMatTree", Const.BUNDLE_KEY_REQUEST, "null"));
        }
        this.f63466e.put("ShadowBackendSvc.GetPlayShowCatMatTree", Long.valueOf(System.currentTimeMillis()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), "ShadowBackendSvc.GetPlayShowCatMatTree");
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE);
        send(toServiceMsg);
    }

    public void V2() {
        if (!NetworkUtil.isNetworkAvailable()) {
            ms.a.c(f63464h, "reqTabABTest---network error.");
            return;
        }
        ms.a.f(f63464h, "\u3010REQUEST\u3011reqTabABTest");
        this.f63466e.put(AECameraConstants.CMD_TAB_AB_TEST, Long.valueOf(System.currentTimeMillis()));
        send(new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), AECameraConstants.CMD_TAB_AB_TEST));
    }

    public void W2() {
        String str = f63464h;
        ms.a.f(str, "arcake: requestARCakeMaterial--begin");
        String currentUin = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
        new ArrayList().add(Long.valueOf(Long.parseLong(currentUin)));
        oidb_cmd0xf8c$ReqBody oidb_cmd0xf8c_reqbody = new oidb_cmd0xf8c$ReqBody();
        ms.a.a(str, "arcake: requestARCakeMaterial--uin" + Long.parseLong(currentUin));
        String j3 = AECameraPrefsUtil.f().j(IAECameraPrefsUtil.KEY_ARCAKE_ID, null, 4);
        AEGiftMaterialConfigParser.e(j3);
        ms.a.a(str, "arcake: requestARCakeMaterial--arCakeId" + j3);
        if (!TextUtils.isEmpty(j3)) {
            oidb_cmd0xf8c_reqbody.cakeID.set(j3);
        }
        oidb_cmd0xf8c_reqbody.uin.set(Long.parseLong(currentUin));
        String str2 = LightVersionInfo.VERSION_NAME;
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            String[] split = LightVersionInfo.VERSION_NAME.split("\\.");
            if (split.length > 3) {
                str2 = split[0] + "." + split[1] + "." + split[2];
            }
        }
        ms.a.a(str, "arcake: requestARCakeMaterial--sdkVersion" + str2);
        oidb_cmd0xf8c_reqbody.sdk_version.set(str2);
        oidb_cmd0xf8c_reqbody.zhongtai_number.set(str2);
        oidb_cmd0xf8c_reqbody.clientplat.set(AppSetting.f99551k);
        oidb_cmd0xf8c_reqbody.PlatformFlag.set(1);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(AECameraConstants.CMD_AR_CAMKE_SERVICE, 3980, 1, oidb_cmd0xf8c_reqbody.toByteArray());
        if (!NetworkUtil.isNetworkAvailable()) {
            ms.a.f(str, "arcake: net work not avalilable");
            AEGiftMaterialConfigParser.f63512c = false;
        }
        sendPbReq(makeOIDBPkg);
        ms.a.a(str, "arcake: requestARCakeMaterial--end");
    }

    public void X2(String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            LogUtils.w(f63464h, "[reqCompressedMaterials] no network....");
            return;
        }
        ms.a.f(f63464h, "\u3010REQUEST\u3011requestCompressedMaterials" + str);
        if (AEDashboardUtil.x()) {
            AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCategoryMaterial." + str, Const.BUNDLE_KEY_REQUEST, "null"));
        }
        this.f63466e.put("ShadowBackendSvc.GetCategoryMaterial." + str, Long.valueOf(System.currentTimeMillis()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY);
        toServiceMsg.extraData.putString("ServiceId", str);
        send(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        E2();
        try {
            if (fromServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY)) {
                String string = toServiceMsg.extraData.getString("ServiceId");
                if (string.endsWith(AECameraConstants.CAMERA_STORY_SERVICEID)) {
                    N2(fromServiceMsg, obj, AECameraConstants.CAMERA_STORY_SERVICEID);
                } else if (string.endsWith(AECameraConstants.CAMERA_STORY_MAKEUP_SERVICEID)) {
                    N2(fromServiceMsg, obj, AECameraConstants.CAMERA_STORY_MAKEUP_SERVICEID);
                } else if (string.endsWith(AECameraConstants.CAMERA_EMO_SERVICEID)) {
                    I2(fromServiceMsg, obj);
                } else if (string.endsWith(AECameraConstants.CAMERA_WATERMARK_SERVICEID)) {
                    Q2(fromServiceMsg, obj);
                } else if (string.endsWith(AECameraConstants.CAMERA_FLASH_SHOW_SERVICEID)) {
                    J2(fromServiceMsg, obj);
                }
            } else if (fromServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_CAMERA_CONFIG)) {
                H2(fromServiceMsg, obj);
            } else if (toServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetPlayShowCatMatTree")) {
                L2(fromServiceMsg, obj);
            } else if (toServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_AR_CAMKE_SERVICE)) {
                F2(fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TAB_AB_TEST)) {
                P2(fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_MATERIAL_RACE)) {
                M2(fromServiceMsg, obj);
            }
        } catch (Throwable th5) {
            ms.a.c(f63464h, "onReceive exception:" + th5.getMessage());
        }
    }

    private void G2(Map<String, CameraConfig> map) {
        if (map != null && map.containsKey(AECameraConstants.CAMERA_A_B_BEAUTY_KEY)) {
            CameraConfig cameraConfig = map.get(AECameraConstants.CAMERA_A_B_BEAUTY_KEY);
            if (cameraConfig != null) {
                ms.a.f(f63464h, "handleTabABTest---beauty---content: " + cameraConfig.ConfigContent);
                if (AECameraConstants.CAMERA_A_B_BEAUTY_KEY_A.equals(cameraConfig.ConfigContent)) {
                    AEDashboardUtil.v(false);
                    return;
                } else {
                    AEDashboardUtil.v(true);
                    return;
                }
            }
            ms.a.c(f63464h, "handleTabABTest---beauty---cameraConfig is null.");
            return;
        }
        ms.a.f(f63464h, "tab AB Test map is null.");
    }

    private void K2(Map<String, CameraConfig> map) {
        if (map == null || !map.containsKey("itemEntry_0816")) {
            return;
        }
        CameraConfig cameraConfig = map.get("itemEntry_0816");
        if (cameraConfig != null) {
            ms.a.f(f63464h, "handleTabABTest---materialIcon---content: " + cameraConfig.ConfigContent);
            if ("itemEntry_0816_B".equals(cameraConfig.ConfigContent)) {
                AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_CAMERA_TAB_B_MATERIAL_ENTRY_OLD, true, 4);
                return;
            } else {
                AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_CAMERA_TAB_B_MATERIAL_ENTRY_OLD, false, 4);
                return;
            }
        }
        ms.a.c(f63464h, "handleTabABTest---materialIcon---cameraConfig is null.");
    }

    private void O2(Map<String, CameraConfig> map) {
        if (map != null) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<CameraConfig> it = map.values().iterator();
            while (it.hasNext()) {
                sb5.append(it.next().ExpId);
                sb5.append(",");
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            String sb6 = sb5.toString();
            ms.a.f(f63464h, "handleTabABTest---tabExpIds=" + sb6);
            AECameraPrefsUtil.f().p(AECameraConstants.SP_KEY_AE_CAMERA_TAB_EXPERIMENT_IDS, sb6, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H2(FromServiceMsg fromServiceMsg, Object obj) {
        GetCameraConfigRsp getCameraConfigRsp;
        String str;
        Iterator<Map.Entry<String, CameraConfig>> it;
        String str2;
        GetCameraConfigRsp getCameraConfigRsp2;
        String str3;
        ms.a.f(f63464h, "\u3010Handle\u3011handleCameraConfig:" + fromServiceMsg.isSuccess());
        if (!fromServiceMsg.isSuccess()) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d(AECameraConstants.CMD_CAMERA_CONFIG, "response", "failed"));
                return;
            }
            return;
        }
        GetCameraConfigRsp getCameraConfigRsp3 = (GetCameraConfigRsp) obj;
        if (getCameraConfigRsp3.ConfigMap != null) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d(AECameraConstants.CMD_CAMERA_CONFIG, "response", "succeeded with content"));
            }
            Iterator<Map.Entry<String, CameraConfig>> it5 = getCameraConfigRsp3.ConfigMap.entrySet().iterator();
            String str4 = "";
            String str5 = str4;
            String str6 = str5;
            while (it5.hasNext()) {
                Map.Entry<String, CameraConfig> next = it5.next();
                CameraConfig value = next.getValue();
                if (TextUtils.isEmpty(str4)) {
                    str = value.ExpId;
                } else {
                    str = str4 + "," + value.ExpId;
                }
                String key = next.getKey();
                if (AECameraConstants.RES_MAP_PLAY_SHOW_KEY.equals(key)) {
                    str5 = value.ConfigContent;
                } else if (AECameraConstants.RES_MAP_ENTRANCE_QZONE_KEY.equals(key)) {
                    str6 = value.ConfigContent;
                } else {
                    it = it5;
                    str2 = str;
                    getCameraConfigRsp2 = getCameraConfigRsp3;
                    if (AECameraConstants.RES_MAP_CAMERA_AD_ID.equals(key)) {
                        try {
                            JsonArray asJsonArray = new JsonParser().parse(value.ConfigContent).getAsJsonArray();
                            if (asJsonArray != null && asJsonArray.size() > 0) {
                                int size = asJsonArray.size();
                                str3 = str6;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= size) {
                                        break;
                                    }
                                    try {
                                        int i16 = size;
                                        JsonObject jsonObject = (JsonObject) asJsonArray.get(i3);
                                        if (R2(jsonObject)) {
                                            AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_OP_ID, GsonUtils.optString(jsonObject, "opID"), 4);
                                            AECameraPrefsUtil.f().l(AECameraConstants.CAMERA_AD_SHOW, GsonUtils.optBoolean(jsonObject, "showOp"), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_ICON_URL, GsonUtils.optString(jsonObject, "opIcon"), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_TYPE, GsonUtils.optString(jsonObject, "type"), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_SCHEMA, GsonUtils.optString(jsonObject, QZoneDTLoginReporter.SCHEMA), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_ACTIVITY_ID, GsonUtils.optString(jsonObject, "activity_id"), 4);
                                            break;
                                        }
                                        i3++;
                                        size = i16;
                                    } catch (Exception unused) {
                                        ms.a.c(f63464h, "camera ad ab test inflate error.");
                                        str6 = str3;
                                        it5 = it;
                                        str4 = str2;
                                        getCameraConfigRsp3 = getCameraConfigRsp2;
                                    }
                                }
                            } else {
                                str3 = str6;
                                AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_OP_ID, "", 4);
                                AECameraPrefsUtil.f().l(AECameraConstants.CAMERA_AD_SHOW, false, 4);
                                AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_ICON_URL, "", 4);
                                AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_TYPE, "", 4);
                                AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_SCHEMA, "", 4);
                                AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_ACTIVITY_ID, "", 4);
                            }
                        } catch (Exception unused2) {
                            str3 = str6;
                        }
                    } else {
                        str3 = str6;
                        if (AECameraConstants.RES_PENDENT_AD_ID.equals(key)) {
                            try {
                                JsonArray asJsonArray2 = new JsonParser().parse(value.ConfigContent).getAsJsonArray();
                                if (asJsonArray2 != null && asJsonArray2.size() > 0) {
                                    int size2 = asJsonArray2.size();
                                    int i17 = 0;
                                    while (true) {
                                        if (i17 >= size2) {
                                            break;
                                        }
                                        JsonObject jsonObject2 = (JsonObject) asJsonArray2.get(i17);
                                        if (R2(jsonObject2)) {
                                            os.a aVar = os.a.f423933a;
                                            aVar.h(AECameraConstants.CAMERA_AD_PENDENT_OP_ID, GsonUtils.optString(jsonObject2, "opID"));
                                            aVar.e(AECameraConstants.CAMERA_AD_PENDENT_SHOW, GsonUtils.optBoolean(jsonObject2, "showOp"));
                                            aVar.h(AECameraConstants.CAMERA_AD_PENDENT_TYPE, GsonUtils.optString(jsonObject2, "type"));
                                            aVar.h(AECameraConstants.CAMERA_AD_PENDENT_ICON_URL, GsonUtils.optString(jsonObject2, "opIcon"));
                                            aVar.h(AECameraConstants.CAMERA_AD_PENDENT_SCHEMA, GsonUtils.optString(jsonObject2, QZoneDTLoginReporter.SCHEMA));
                                            aVar.h(AECameraConstants.CAMERA_AD_PENDENT_ICON_TYPE, GsonUtils.optString(jsonObject2, "iconType"));
                                            aVar.f(AECameraConstants.CAMERA_AD_PENDENT_CATEGORYID, GsonUtils.optInt(jsonObject2, "categoryId"));
                                            aVar.h(AECameraConstants.CAMERA_AD_PENDANT_ACTIVITY_ID, GsonUtils.optString(jsonObject2, "activity_id"));
                                            break;
                                        }
                                        i17++;
                                    }
                                } else {
                                    os.a aVar2 = os.a.f423933a;
                                    aVar2.h(AECameraConstants.CAMERA_AD_PENDENT_OP_ID, "");
                                    aVar2.e(AECameraConstants.CAMERA_AD_PENDENT_SHOW, false);
                                    aVar2.h(AECameraConstants.CAMERA_AD_PENDENT_TYPE, "");
                                    aVar2.h(AECameraConstants.CAMERA_AD_PENDENT_ICON_URL, "");
                                    aVar2.h(AECameraConstants.CAMERA_AD_PENDENT_SCHEMA, "");
                                    aVar2.h(AECameraConstants.CAMERA_AD_PENDENT_ICON_TYPE, "");
                                    aVar2.f(AECameraConstants.CAMERA_AD_PENDENT_CATEGORYID, -1);
                                    aVar2.h(AECameraConstants.CAMERA_AD_PENDANT_ACTIVITY_ID, "");
                                }
                            } catch (Exception unused3) {
                                ms.a.c(f63464h, "camera pendent ad ab test inflate error.");
                            }
                        } else if (AECameraConstants.RES_MAP_CAMERA_TAB_BUBBLE_AD_ID.equals(key)) {
                            String str7 = value.ConfigContent;
                            ms.a.f(f63464h, "get camera tab bubble ad: " + str7);
                            AECameraPrefsUtil.f().p(AECameraConstants.CAMERA_AD_TAB_BUBBLE_CONTENT, str7, 4);
                        } else if (AECameraConstants.RES_MAP_CAMERA_INIT_FILTER_TIMEOUT.equals(key)) {
                            AECameraPrefsUtil.f().p(AECameraConstants.RES_MAP_CAMERA_INIT_FILTER_TIMEOUT, value.ConfigContent, 4);
                        } else if (AECameraConstants.RES_MAP_CIRCLE_CAMERA_AD_ID.equals(key)) {
                            try {
                                JsonArray asJsonArray3 = new JsonParser().parse(value.ConfigContent).getAsJsonArray();
                                if (asJsonArray3 != null && asJsonArray3.size() > 0) {
                                    int size3 = asJsonArray3.size();
                                    int i18 = 0;
                                    while (true) {
                                        if (i18 >= size3) {
                                            break;
                                        }
                                        JsonObject jsonObject3 = (JsonObject) asJsonArray3.get(i18);
                                        if (R2(jsonObject3)) {
                                            AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_OP_ID, GsonUtils.optString(jsonObject3, "opID"), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_ICON_URL, GsonUtils.optString(jsonObject3, "opIcon"), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_TYPE, GsonUtils.optString(jsonObject3, "type"), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_SCHEMA, GsonUtils.optString(jsonObject3, QZoneDTLoginReporter.SCHEMA), 4);
                                            AECameraPrefsUtil.f().l(AECameraConstants.CIRCLE_CAMERA_AD_SHOW, GsonUtils.optBoolean(jsonObject3, "showOp"), 4);
                                            AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_ACTIVITY_ID, GsonUtils.optString(jsonObject3, "activity_id"), 4);
                                            break;
                                        }
                                        i18++;
                                    }
                                } else {
                                    AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_OP_ID, "", 4);
                                    AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_ICON_URL, "", 4);
                                    AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_TYPE, "", 4);
                                    AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_SCHEMA, "", 4);
                                    AECameraPrefsUtil.f().l(AECameraConstants.CIRCLE_CAMERA_AD_SHOW, false, 4);
                                    AECameraPrefsUtil.f().p(AECameraConstants.CIRCLE_CAMERA_AD_ACTIVITY_ID, "", 4);
                                }
                            } catch (Exception unused4) {
                                ms.a.c(f63464h, "camera ad ab test inflate error.");
                            }
                        } else if (AECameraConstants.CIRCLE_CAMERA_ENTRY_ID.equals(key)) {
                            try {
                                JsonArray asJsonArray4 = new JsonParser().parse(value.ConfigContent).getAsJsonArray();
                                if (asJsonArray4 != null && asJsonArray4.size() > 0) {
                                    int size4 = asJsonArray4.size();
                                    int i19 = 0;
                                    while (true) {
                                        if (i19 >= size4) {
                                            break;
                                        }
                                        JsonObject jsonObject4 = (JsonObject) asJsonArray4.get(i19);
                                        if (R2(jsonObject4)) {
                                            AECameraPrefsUtil.f().l(AECameraConstants.CIRCLE_ENTRY_TYPE_CAMERA, "camera".endsWith(GsonUtils.optString(jsonObject4, "ABContent")), 4);
                                            break;
                                        }
                                        i19++;
                                    }
                                } else {
                                    AECameraPrefsUtil.f().l(AECameraConstants.CIRCLE_ENTRY_TYPE_CAMERA, false, 4);
                                }
                            } catch (Exception unused5) {
                                ms.a.c(f63464h, "camera entry ab test inflate error.");
                            }
                        }
                    }
                    str6 = str3;
                    it5 = it;
                    str4 = str2;
                    getCameraConfigRsp3 = getCameraConfigRsp2;
                }
                getCameraConfigRsp2 = getCameraConfigRsp3;
                it = it5;
                str2 = str;
                it5 = it;
                str4 = str2;
                getCameraConfigRsp3 = getCameraConfigRsp2;
            }
            getCameraConfigRsp = getCameraConfigRsp3;
            AECameraPrefsUtil.f().p(AECameraConstants.CMD_CAMERA_CONFIG, str4, 4);
            AECameraPrefsUtil.f().p(AECameraConstants.RES_MAP_PLAY_SHOW_KEY, str5, 4);
            AECameraPrefsUtil.f().p(AECameraConstants.RES_MAP_ENTRANCE_QZONE_KEY, str6, 4);
        } else {
            getCameraConfigRsp = getCameraConfigRsp3;
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d(AECameraConstants.CMD_CAMERA_CONFIG, "response", "succeeded without content"));
            }
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), String.valueOf(System.currentTimeMillis() - (this.f63466e.containsKey(AECameraConstants.CMD_CAMERA_CONFIG) ? this.f63466e.get(AECameraConstants.CMD_CAMERA_CONFIG).longValue() : 0L)), AECameraConstants.CMD_CAMERA_CONFIG, getCameraConfigRsp.Code);
    }
}
