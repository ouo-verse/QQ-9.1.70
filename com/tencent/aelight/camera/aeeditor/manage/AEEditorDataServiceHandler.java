package com.tencent.aelight.camera.aeeditor.manage;

import camera.RECOMMEND_GENERAL_DATASTRUCT.BigShowRecommendInfo;
import camera.SHADOW_BACKEND_INTERFACE.GetBigShowRecommendRsp;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.i;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorDataServiceHandler extends BusinessHandler {

    /* renamed from: e, reason: collision with root package name */
    private static final String f66127e = "[AEEditor2]" + AEEditorDataServiceHandler.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    protected Map<String, Long> f66128d;

    public AEEditorDataServiceHandler(AppInterface appInterface) {
        super(appInterface);
        this.f66128d = new HashMap();
        LogUtils.setEnable(false);
    }

    private void D2(FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<MetaCategory> arrayList;
        boolean z16;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) obj;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null && !arrayList.isEmpty()) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetCircleCatMatTree.MqCircleEditor", "response", "succeeded with content"));
            }
            AECameraPrefsUtil.f().p(IAECameraPrefsUtil.KEY_ETAG_AEEDITOR_MATERIAL, getCatMatTreeRsp.ETag, 4);
            Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
            while (it.hasNext()) {
                MetaCategory next = it.next();
                if (next.f30532id.equals(HippyQQConstants.HIPPY_CHANNEL)) {
                    z16 = FileUtils.writeFile(c.b().a(i.f65581d, "editor_filter_update_template.json"), new Gson().toJson(next.subCategories));
                    AEEditorResourceManager.J().U();
                } else if (next.f30532id.equals("10002")) {
                    z16 = FileUtils.writeFile(c.b().a(i.f65579b, "editor_text_sticker_update_template.json"), new Gson().toJson(next.subCategories));
                    AEEditorResourceManager.J().X();
                } else if (next.f30532id.equals("10003")) {
                    z16 = FileUtils.writeFile(c.b().a(i.f65580c, "editor_auto_template_update_template.json"), new Gson().toJson(next.subCategories));
                    AEEditorResourceManager.J().T();
                } else if (next.f30532id.equals("10004")) {
                    z16 = FileUtils.writeFile(c.b().a(i.f65584g, "editor_text_update_template.json"), new Gson().toJson(next.subCategories));
                    AEEditorResourceManager.J().Y();
                } else if (next.f30532id.equals("10005")) {
                    z16 = FileUtils.writeFile(c.b().a(i.f65582e, "editor_frame_update_template.json"), new Gson().toJson(next.subCategories));
                    AEEditorResourceManager.J().V();
                } else if (next.f30532id.equals("10006")) {
                    z16 = FileUtils.writeFile(c.b().a(i.f65583f, "editor_pic_template_update_template.json"), new Gson().toJson(next.subCategories));
                    AEEditorResourceManager.J().W();
                } else {
                    z16 = false;
                }
                ms.a.a(f66127e, next.f30532id + " isWriteFile:" + z16);
            }
        }
        notifyUI(1, true, null);
    }

    private void E2(FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<BigShowRecommendInfo> arrayList;
        GetBigShowRecommendRsp getBigShowRecommendRsp = (GetBigShowRecommendRsp) obj;
        if (getBigShowRecommendRsp != null && getBigShowRecommendRsp.Code == 0 && (arrayList = getBigShowRecommendRsp.Materials) != null && !arrayList.isEmpty()) {
            if (AEDashboardUtil.x()) {
                AEDashboardUtil.k().postValue(new AEDashboardUtil.d("ShadowBackendSvc.GetBigShowRecommend.MqCircleEditor", "response", "succeeded with content"));
            }
            ArrayList<MetaMaterial> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator<BigShowRecommendInfo> it = getBigShowRecommendRsp.Materials.iterator();
            while (it.hasNext()) {
                BigShowRecommendInfo next = it.next();
                arrayList2.add(next.MaterialInfo);
                arrayList3.add(next.Reason);
            }
            c.b().j(arrayList2, arrayList3);
            return;
        }
        c.b().f();
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return AEEditorCommonEditFragment.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg.getServiceCmd().equals(AEEditorConstants.CMD_EDITOR_MATERIAL_CATEGORY)) {
            D2(fromServiceMsg, obj);
        }
        if (toServiceMsg.getServiceCmd().equals(AEEditorConstants.CMD_AUTO_TEMPLATE_RECOMMEND)) {
            E2(fromServiceMsg, obj);
        }
    }
}
