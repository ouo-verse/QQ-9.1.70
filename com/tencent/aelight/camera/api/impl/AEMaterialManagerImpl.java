package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.api.IAEMaterialManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEMaterialManagerImpl implements IAEMaterialManager {
    @Override // com.tencent.aelight.camera.api.IAEMaterialManager
    public String getMaterialZipFolderPath() {
        return AEMaterialManager.D();
    }

    @Override // com.tencent.aelight.camera.api.IAEMaterialManager
    public boolean isSpecialTemplate(VideoMaterial videoMaterial) {
        return AEMaterialManager.U(videoMaterial);
    }

    @Override // com.tencent.aelight.camera.api.IAEMaterialManager
    public String materialListToString(ArrayList<ps.a> arrayList) {
        return AEMaterialManager.d0(arrayList);
    }

    @Override // com.tencent.aelight.camera.api.IAEMaterialManager
    public ArrayList<ps.a> stringToLastMaterialList(String str) {
        return AEMaterialManager.F0(str);
    }
}
