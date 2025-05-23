package com.tencent.mobileqq.qqvideoedit.edit.manager;

import android.text.TextUtils;
import camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendReq;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaSdkInfo;
import com.google.gson.Gson;
import com.qq.jce.wup.UniPacket;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qqvideoedit.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorFragment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import lj2.b;
import nj2.c;
import org.light.LightVersionInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VideoDataServiceHandler extends VideoDataBaseServiceHandler {

    /* renamed from: d, reason: collision with root package name */
    private static final String f275032d = "VideoDataServiceHandler";

    public VideoDataServiceHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private boolean J2(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetCatMatTreeReq getCatMatTreeReq = new GetCatMatTreeReq();
        getCatMatTreeReq.ServiceId = toServiceMsg.extraData.getString("ServiceId");
        getCatMatTreeReq.ETag = H2(AECameraPrefsUtil.f275089d);
        getCatMatTreeReq.SdkInfos = G2();
        getCatMatTreeReq.GroupId = "2";
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY);
        uniPacket.put(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY, getCatMatTreeReq);
        return true;
    }

    private void K2(FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<BigShowRecommendInfo> arrayList;
        GetBigShowRecommendRsp getBigShowRecommendRsp = (GetBigShowRecommendRsp) obj;
        if (getBigShowRecommendRsp != null && getBigShowRecommendRsp.Code == 0 && (arrayList = getBigShowRecommendRsp.Materials) != null && !arrayList.isEmpty()) {
            ArrayList<MetaMaterial> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator<BigShowRecommendInfo> it = getBigShowRecommendRsp.Materials.iterator();
            while (it.hasNext()) {
                BigShowRecommendInfo next = it.next();
                arrayList2.add(next.MaterialInfo);
                arrayList3.add(next.Reason);
            }
            a.b().j(arrayList2, arrayList3);
            VideoEditorResourceManager.L().d0();
            return;
        }
        a.b().g();
        VideoEditorResourceManager.L().d0();
    }

    private boolean L2(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        GetBigShowRecommendReq getBigShowRecommendReq = new GetBigShowRecommendReq();
        getBigShowRecommendReq.framePics = (ArrayList) toServiceMsg.extraData.getSerializable(AEEditorConstants.REQ_FIELD_FRAMES);
        getBigShowRecommendReq.SdkVersion = G2().get(0).sdkVersion;
        getBigShowRecommendReq.MediaType = toServiceMsg.extraData.getInt("media_type", 0);
        uniPacket.setServantName("ShadowBackendSvc");
        uniPacket.setFuncName("ShadowBackendSvc.GetKuaishanMaterialRecommend");
        uniPacket.put("ShadowBackendSvc.GetKuaishanMaterialRecommend", getBigShowRecommendReq);
        return true;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoDataBaseServiceHandler
    public Object D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY)) {
            return E2(fromServiceMsg.getWupBuffer(), AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY, new GetCatMatTreeRsp());
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetKuaishanMaterialRecommend")) {
            return E2(fromServiceMsg.getWupBuffer(), "ShadowBackendSvc.GetKuaishanMaterialRecommend", new GetBigShowRecommendRsp());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.edit.manager.VideoDataBaseServiceHandler
    public boolean F2(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY)) {
            return J2(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetKuaishanMaterialRecommend")) {
            return L2(toServiceMsg, uniPacket);
        }
        return false;
    }

    protected ArrayList<MetaSdkInfo> G2() {
        ArrayList<MetaSdkInfo> arrayList = new ArrayList<>();
        MetaSdkInfo metaSdkInfo = new MetaSdkInfo();
        metaSdkInfo.sdk = 0;
        String str = LightVersionInfo.VERSION_NAME;
        if (!TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            String[] split = LightVersionInfo.VERSION_NAME.split("\\.");
            if (split.length > 3) {
                str = split[0] + "." + split[1] + "." + split[2];
            }
            metaSdkInfo.sdkVersion = str;
        }
        arrayList.add(metaSdkInfo);
        return arrayList;
    }

    protected String H2(String str) {
        return AECameraPrefsUtil.b().c(str, "", 4);
    }

    protected void I2(FromServiceMsg fromServiceMsg, Object obj) {
        Object obj2;
        ArrayList<MetaCategory> arrayList;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            AECameraPrefsUtil.b().e(AECameraPrefsUtil.f275089d, getCatMatTreeRsp.ETag, 4);
            Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
            while (true) {
                boolean z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                MetaCategory next = it.next();
                if (next.f30532id.equals("10004")) {
                    z16 = FileUtils.writeFile(a.b().a(b.f414871d, "editor_filter_update_template.json"), new Gson().toJson(next.subCategories));
                    VideoEditorResourceManager.L().a0();
                } else if (next.f30532id.equals("10002")) {
                    z16 = FileUtils.writeFile(a.b().a(b.f414869b, "editor_text_sticker_update_template.json"), new Gson().toJson(next.subCategories));
                    VideoEditorResourceManager.L().b0();
                } else if (next.f30532id.equals(HippyQQConstants.HIPPY_CHANNEL)) {
                    z16 = FileUtils.writeFile(a.b().a(b.f414870c, "editor_auto_template_update_template.json"), new Gson().toJson(next.subCategories));
                    VideoEditorResourceManager.L().d0();
                } else if (next.f30532id.equals("10003")) {
                    z16 = FileUtils.writeFile(a.b().a(b.f414874g, "editor_text_update_template.json"), new Gson().toJson(next.subCategories));
                    VideoEditorResourceManager.L().c0();
                }
                mj2.a.a(f275032d, next.f30532id + " isWriteFile:" + z16);
            }
            VideoEditorResourceManager.L().n(false);
        } else {
            String str = f275032d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("response code:");
            if (getCatMatTreeRsp != null) {
                obj2 = Integer.valueOf(getCatMatTreeRsp.Code);
            } else {
                obj2 = "null";
            }
            sb5.append(obj2);
            mj2.a.a(str, sb5.toString());
        }
        notifyUI(1, true, null);
    }

    public void M2(String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            mj2.a.e(f275032d, "[requestEditorMaterials] no network....");
            return;
        }
        mj2.a.d(f275032d, "\u3010REQUEST\u3011requestEditorMaterials" + str);
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getAccount(), AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY);
        toServiceMsg.extraData.putString("ServiceId", str);
        c.a(toServiceMsg, getClass().getName(), nj2.b.class);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return VideoEditorFragment.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.getServiceCmd().equals(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY)) {
            I2(fromServiceMsg, obj);
        }
        if (toServiceMsg.getServiceCmd().equals("ShadowBackendSvc.GetKuaishanMaterialRecommend")) {
            K2(fromServiceMsg, obj);
        }
    }
}
