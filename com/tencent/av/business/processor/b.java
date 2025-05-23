package com.tencent.av.business.processor;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaAdditionalPackage;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.m;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarLightSDKSettingsResJsonConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends BaseConfigFileProcessor<PendantItem> {
    public b(AppRuntime appRuntime) {
        super(appRuntime);
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public void b() {
        m.c(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTreeQQAVSinglePendantV2");
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public String d() {
        return com.tencent.av.b.k();
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public List<PendantItem> f(File file) {
        GetCatMatTreeRsp getCatMatTreeRsp;
        ArrayList<MetaCategory> arrayList;
        ArrayList arrayList2 = new ArrayList();
        String e16 = BaseConfigFileProcessor.e(file);
        if (QLog.isDevelopLevel()) {
            QLog.i("PendantConfigFileProcessor", 2, "loadMaterialListFromFile -> jsonStr: " + e16);
        }
        if (TextUtils.isEmpty(e16)) {
            return arrayList2;
        }
        MetaCategory metaCategory = null;
        try {
            getCatMatTreeRsp = (GetCatMatTreeRsp) new Gson().fromJson(e16, GetCatMatTreeRsp.class);
        } catch (Exception e17) {
            QLog.e("PendantConfigFileProcessor", 1, "loadMaterialListFromFile exception = " + e17.getMessage());
            getCatMatTreeRsp = null;
        }
        if (getCatMatTreeRsp != null && (arrayList = getCatMatTreeRsp.Categories) != null) {
            if (arrayList.size() > 0) {
                metaCategory = getCatMatTreeRsp.Categories.get(0);
            }
            if (metaCategory == null) {
                QLog.e("PendantConfigFileProcessor", 1, "loadMaterialListFromFile total category = null");
                return arrayList2;
            }
            ArrayList<MetaCategory> arrayList3 = new ArrayList<>();
            arrayList3.add(metaCategory);
            Iterator<MetaMaterial> it = c(arrayList3).iterator();
            while (it.hasNext()) {
                MetaMaterial next = it.next();
                if (next != null) {
                    arrayList2.add(k(next));
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("PendantConfigFileProcessor", 2, "loadMaterialListFromFile result: " + arrayList2.size());
            }
            return arrayList2;
        }
        QLog.e("PendantConfigFileProcessor", 2, "no materials return");
        return arrayList2;
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    protected void h() {
        if (AVAvatarLightSDKSettingsResJsonConfig.a()) {
            QLog.i("PendantConfigFileProcessor", 2, "updateConfigFile and onUpdateJsonConfig");
            AVAvatarLightSDKSettingsResJsonConfig.c(0);
        }
    }

    public PendantItem k(MetaMaterial metaMaterial) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (metaMaterial == null) {
            return null;
        }
        PendantItem pendantItem = new PendantItem();
        pendantItem.setId(metaMaterial.f30533id);
        pendantItem.setName(metaMaterial.f30533id);
        pendantItem.setIconurl(metaMaterial.thumbUrl);
        pendantItem.setResurl(metaMaterial.packageUrl);
        pendantItem.setMd5(metaMaterial.packageMd5);
        pendantItem.setPredownload(TextUtils.equals("true", metaMaterial.additionalFields.get("predownload")));
        boolean z16 = true;
        pendantItem.setIsshow(!TextUtils.equals("false", metaMaterial.additionalFields.get("isshow")));
        pendantItem.setKind(m(metaMaterial));
        pendantItem.setType(n(metaMaterial));
        pendantItem.setCategory(l(metaMaterial));
        String str7 = "";
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("version"))) {
            str = "";
        } else {
            str = metaMaterial.additionalFields.get("version");
        }
        pendantItem.setVersion(str);
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("gestureType"))) {
            str2 = "";
        } else {
            str2 = metaMaterial.additionalFields.get("gestureType");
        }
        pendantItem.setGestureType(str2);
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("gestureWording"))) {
            str3 = "";
        } else {
            str3 = metaMaterial.additionalFields.get("gestureWording");
        }
        pendantItem.setGestureWording(str3);
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("key_local_use_category_id"))) {
            str4 = "";
        } else {
            str4 = metaMaterial.additionalFields.get("key_local_use_category_id");
        }
        pendantItem.setCategoryId(str4);
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("key_local_use_category_name"))) {
            str5 = "";
        } else {
            str5 = metaMaterial.additionalFields.get("key_local_use_category_name");
        }
        pendantItem.setCategoryName(str5);
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("isZplan")) || !"1".equals(metaMaterial.additionalFields.get("isZplan"))) {
            z16 = false;
        }
        pendantItem.setIsZplan(z16);
        pendantItem.setZplanRenderType(NumberUtil.stringToInt(metaMaterial.additionalFields.get("zplanRenderType"), -1));
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("currentLowestSupportLevel"))) {
            str6 = "";
        } else {
            str6 = metaMaterial.additionalFields.get("currentLowestSupportLevel");
        }
        pendantItem.setCurrentLowestSupportLevel(str6);
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("deviceBlackList"))) {
            str7 = metaMaterial.additionalFields.get("deviceBlackList");
        }
        pendantItem.setDeviceBlackList(str7);
        String str8 = metaMaterial.additionalFields.get("originName");
        if (!TextUtils.isEmpty(str8)) {
            pendantItem.setId(str8);
            pendantItem.setName(str8);
        }
        if (metaMaterial.additionalPackage != null) {
            PendantItem.a aVar = new PendantItem.a();
            MetaAdditionalPackage metaAdditionalPackage = metaMaterial.additionalPackage;
            aVar.f73406b = metaAdditionalPackage.highPackageMd5;
            aVar.f73405a = metaAdditionalPackage.highPackageUrl;
            aVar.f73408d = metaAdditionalPackage.midPackageMd5;
            aVar.f73407c = metaAdditionalPackage.midPackageUrl;
            aVar.f73410f = metaAdditionalPackage.lowPackageMd5;
            aVar.f73409e = metaAdditionalPackage.lowPackageUrl;
            aVar.f73412h = metaAdditionalPackage.superLowPackageMd5;
            aVar.f73411g = metaAdditionalPackage.superLowPackageUrl;
            pendantItem.setAdditionalPackage(aVar);
        }
        return pendantItem;
    }

    public int l(MetaMaterial metaMaterial) {
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("category"))) {
            return 0;
        }
        try {
            return Integer.parseInt(metaMaterial.additionalFields.get("category"));
        } catch (Exception e16) {
            QLog.e("PendantConfigFileProcessor", 1, "getCategory exception: " + e16.getMessage());
            return 0;
        }
    }

    public int m(MetaMaterial metaMaterial) {
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("kind"))) {
            return 0;
        }
        try {
            return Integer.parseInt(metaMaterial.additionalFields.get("kind"));
        } catch (Exception e16) {
            QLog.e("PendantConfigFileProcessor", 1, "getKind exception: " + e16.getMessage());
            return 0;
        }
    }

    public int n(MetaMaterial metaMaterial) {
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("type"))) {
            return 0;
        }
        try {
            return Integer.parseInt(metaMaterial.additionalFields.get("type"));
        } catch (Exception e16) {
            QLog.e("PendantConfigFileProcessor", 1, "getType exception: " + e16.getMessage());
            return 0;
        }
    }
}
