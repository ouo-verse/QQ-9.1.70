package com.tencent.av.business.processor;

import android.text.TextUtils;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.utils.m;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends BaseConfigFileProcessor<FaceItem> {

    /* renamed from: c, reason: collision with root package name */
    private String f73466c;

    public a(AppRuntime appRuntime) {
        super(appRuntime);
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public void b() {
        m.c(BaseApplication.getContext(), "ShadowBackendSvc.GetCatMatTreeQQAVDoublePendantV2");
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public String d() {
        return com.tencent.av.b.h();
    }

    @Override // com.tencent.av.business.processor.BaseConfigFileProcessor
    public List<FaceItem> f(File file) {
        GetCatMatTreeRsp getCatMatTreeRsp;
        ArrayList<MetaCategory> arrayList;
        ArrayList arrayList2 = new ArrayList();
        String e16 = BaseConfigFileProcessor.e(file);
        if (QLog.isColorLevel()) {
            QLog.i("FaceConfigFileProcessor", 2, "loadMaterialListFromFile -> jsonStr: " + e16);
        }
        if (TextUtils.isEmpty(e16)) {
            return arrayList2;
        }
        try {
            getCatMatTreeRsp = (GetCatMatTreeRsp) new Gson().fromJson(e16, GetCatMatTreeRsp.class);
        } catch (Exception e17) {
            QLog.e("FaceConfigFileProcessor", 1, "loadMaterialListFromFile exception = " + e17.getMessage());
            getCatMatTreeRsp = null;
        }
        if (getCatMatTreeRsp != null && (arrayList = getCatMatTreeRsp.Categories) != null) {
            MetaCategory metaCategory = arrayList.get(0);
            this.f73466c = metaCategory.dynamicFields.get("black_list");
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
                QLog.i("FaceConfigFileProcessor", 2, "loadMaterialListFromFile result: ");
                Iterator it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    QLog.i("FaceConfigFileProcessor", 2, "pendant item: " + ((FaceItem) it5.next()).toString());
                }
            }
        }
        return arrayList2;
    }

    public FaceItem k(MetaMaterial metaMaterial) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (metaMaterial == null) {
            return null;
        }
        FaceItem faceItem = new FaceItem();
        faceItem.setId(metaMaterial.f30533id);
        faceItem.setIconUrl(metaMaterial.thumbUrl);
        faceItem.setResUrl(metaMaterial.packageUrl);
        faceItem.setResMd5(metaMaterial.packageMd5);
        String str6 = "";
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("text"))) {
            str = "";
        } else {
            str = metaMaterial.additionalFields.get("text");
        }
        faceItem.setText(str);
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("type"))) {
            str2 = IndividuationUrlHelper.UrlId.PENDANT_HOME;
        } else {
            str2 = metaMaterial.additionalFields.get("type");
        }
        faceItem.setType(str2);
        faceItem.setIsshow(!TextUtils.equals("false", metaMaterial.additionalFields.get("isshow")));
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("version"))) {
            str3 = "";
        } else {
            str3 = metaMaterial.additionalFields.get("version");
        }
        faceItem.setVersion(str3);
        faceItem.setVipLevel(m(metaMaterial));
        faceItem.setIsInteract(!TextUtils.equals("false", metaMaterial.additionalFields.get("is_interact")));
        faceItem.setPredownload(TextUtils.equals("true", metaMaterial.additionalFields.get("predownload")));
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("peerdeconame1"))) {
            str4 = "";
        } else {
            str4 = metaMaterial.additionalFields.get("peerdeconame1");
        }
        faceItem.setPeerdeconame1(str4);
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("selfdeconame1"))) {
            str5 = "";
        } else {
            str5 = metaMaterial.additionalFields.get("selfdeconame1");
        }
        faceItem.setSelfdeconame1(str5);
        if (!TextUtils.isEmpty(metaMaterial.additionalFields.get("attr"))) {
            str6 = metaMaterial.additionalFields.get("attr");
        }
        faceItem.setAttr(str6);
        String str7 = metaMaterial.additionalFields.get("originName");
        if (!TextUtils.isEmpty(str7)) {
            if (QLog.isColorLevel()) {
                QLog.i("FaceConfigFileProcessor", 2, "convertFromMetaMaterial originName: " + str7);
            }
            faceItem.setId(str7);
        }
        return faceItem;
    }

    public String l() {
        return this.f73466c;
    }

    public int m(MetaMaterial metaMaterial) {
        if (TextUtils.isEmpty(metaMaterial.additionalFields.get("vip_level"))) {
            return 0;
        }
        try {
            return Integer.parseInt(metaMaterial.additionalFields.get("vip_level"));
        } catch (Exception e16) {
            QLog.e("FaceConfigFileProcessor", 1, "getVipLevel exception: " + e16.getMessage());
            return 0;
        }
    }
}
