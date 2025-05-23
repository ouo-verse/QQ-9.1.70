package com.tencent.aelight.camera.ae.config;

import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCameraConfigRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetHorseRaceMaterialsReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetHorseRaceMaterialsRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTABConfigurationReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTABConfigurationRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import org.light.LightVersionInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends BaseProtocolCoder {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f63475d = {"ShadowBackendSvc"};

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String> f63476e = new HashMap<>();

    private boolean d(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetCategoryMaterialReq getCategoryMaterialReq = new GetCategoryMaterialReq();
        getCategoryMaterialReq.ServiceId = toServiceMsg.extraData.getString("ServiceId");
        getCategoryMaterialReq.ETag = c(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY + getCategoryMaterialReq.ServiceId);
        getCategoryMaterialReq.SdkInfos = a();
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY);
        uniPacket.put(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY, getCategoryMaterialReq);
        return true;
    }

    private <T extends JceStruct> void e(UniPacket uniPacket, String str, T t16) {
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(str);
        uniPacket.put(str, t16);
    }

    private boolean f(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetCameraConfigReq getCameraConfigReq = new GetCameraConfigReq();
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_CAMERA_CONFIG);
        uniPacket.put(AECameraConstants.CMD_CAMERA_CONFIG, getCameraConfigReq);
        return true;
    }

    private boolean g(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetPlayShowCatMatTreeReq getPlayShowCatMatTreeReq = new GetPlayShowCatMatTreeReq();
        getPlayShowCatMatTreeReq.ETag = c("ShadowBackendSvc.GetPlayShowCatMatTree");
        getPlayShowCatMatTreeReq.MqVersion = AppSetting.f99551k;
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName("ShadowBackendSvc.GetPlayShowCatMatTree");
        uniPacket.put("ShadowBackendSvc.GetPlayShowCatMatTree", getPlayShowCatMatTreeReq);
        return true;
    }

    private boolean h(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetTABConfigurationReq getTABConfigurationReq = new GetTABConfigurationReq();
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AECameraConstants.CMD_TAB_AB_TEST);
        uniPacket.put(AECameraConstants.CMD_TAB_AB_TEST, getTABConfigurationReq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<MetaSdkInfo> a() {
        ArrayList<MetaSdkInfo> arrayList = new ArrayList<>();
        MetaSdkInfo metaSdkInfo = new MetaSdkInfo();
        metaSdkInfo.sdk = 0;
        metaSdkInfo.sdkVersion = "2.0.0";
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            String replace = LightVersionInfo.VERSION_NAME.replace("-snapshots", "");
            String[] split = replace.split("\\.");
            if (split.length > 3) {
                replace = split[0] + "." + split[1] + "." + split[2];
            }
            metaSdkInfo.sdkVersion = replace;
        }
        arrayList.add(metaSdkInfo);
        return arrayList;
    }

    public final <T> T b(byte[] bArr, String str, T t16) {
        h hVar = new h(true);
        try {
            hVar.setEncodeName("utf-8");
            hVar.decode(bArr);
            return (T) hVar.getByClass(str, t16);
        } catch (Error e16) {
            e16.printStackTrace();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(String str) {
        return AECameraPrefsUtil.f().j(str, "", 4);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        return f63475d;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_CONFIG)) {
            return decodePacket(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_CAMERA_CONFIG, new GetCameraConfigRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY)) {
            return b(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY, new GetCategoryMaterialRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree")) {
            return b(fromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetPlayShowCatMatTree", new GetPlayShowCatMatTreeRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TAB_AB_TEST)) {
            return b(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_TAB_AB_TEST, new GetTABConfigurationRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_MATERIAL_RACE)) {
            return b(fromServiceMsg.getWupBuffer(), AECameraConstants.CMD_MATERIAL_RACE, new GetHorseRaceMaterialsRsp());
        }
        return null;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_CONFIG)) {
            return f(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_COMPRESSED_MATERIAL_CATEGORY)) {
            return d(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree")) {
            return g(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_TAB_AB_TEST)) {
            return h(toServiceMsg, uniPacket);
        }
        if (!toServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_MATERIAL_RACE)) {
            return false;
        }
        e(uniPacket, AECameraConstants.CMD_MATERIAL_RACE, new GetHorseRaceMaterialsReq());
        return true;
    }
}
