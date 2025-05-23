package com.tencent.av.business.processor;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.av.utils.m;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends BaseConfigFileProcessor<ku.a> {
    public c(AppRuntime appRuntime) {
        super(appRuntime);
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public void b() {
        m.c(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTreeQQAVZPlanAvatar");
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public String d() {
        return com.tencent.av.b.p();
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public List<ku.a> f(File file) {
        GetCatMatTreeRsp getCatMatTreeRsp;
        ArrayList<MetaCategory> arrayList;
        ArrayList arrayList2 = new ArrayList();
        String e16 = BaseConfigFileProcessor.e(file);
        if (QLog.isColorLevel()) {
            QLog.i("ZplanAvatarConfigFileProcessor", 2, "loadMaterialListFromFile -> jsonStr: " + e16);
        }
        if (TextUtils.isEmpty(e16)) {
            return arrayList2;
        }
        MetaCategory metaCategory = null;
        try {
            getCatMatTreeRsp = (GetCatMatTreeRsp) new Gson().fromJson(e16, GetCatMatTreeRsp.class);
        } catch (Exception e17) {
            QLog.e("ZplanAvatarConfigFileProcessor", 1, "loadMaterialListFromFile exception = " + e17.getMessage());
            getCatMatTreeRsp = null;
        }
        if (getCatMatTreeRsp != null && (arrayList = getCatMatTreeRsp.Categories) != null) {
            if (arrayList.size() > 0) {
                metaCategory = getCatMatTreeRsp.Categories.get(0);
            }
            if (metaCategory == null) {
                QLog.e("ZplanAvatarConfigFileProcessor", 1, "loadMaterialListFromFile total category = null");
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
            if (QLog.isColorLevel()) {
                QLog.i("ZplanAvatarConfigFileProcessor", 2, "loadMaterialListFromFile result: ");
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    QLog.i("ZplanAvatarConfigFileProcessor", 2, "zplanAvatar item: " + ((ku.a) it5.next()).toString());
                }
            }
            return arrayList2;
        }
        QLog.e("ZplanAvatarConfigFileProcessor", 2, "no materials return");
        return arrayList2;
    }

    public ku.a k(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return null;
        }
        ku.a aVar = new ku.a();
        aVar.setId(metaMaterial.f30533id);
        aVar.setIconUrl(metaMaterial.thumbUrl);
        aVar.setResUrl(metaMaterial.packageUrl);
        aVar.setMd5(metaMaterial.packageMd5);
        aVar.setPredownload(TextUtils.equals("true", metaMaterial.additionalFields.get("predownload")));
        aVar.b(TextUtils.equals("true", metaMaterial.additionalFields.get("zplanAvatarDownload")));
        return aVar;
    }
}
