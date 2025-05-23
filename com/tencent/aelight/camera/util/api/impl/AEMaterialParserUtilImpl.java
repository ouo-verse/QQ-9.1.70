package com.tencent.aelight.camera.util.api.impl;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.ae.data.AEMaterialConfigParser;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.util.api.IAEMaterialParserUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class AEMaterialParserUtilImpl implements IAEMaterialParserUtil {
    @Override // com.tencent.aelight.camera.util.api.IAEMaterialParserUtil
    public void parseCategory(List<MetaCategory> list, List<AEMaterialCategory> list2) {
        AEMaterialConfigParser.b(list, list2);
    }

    @Override // com.tencent.aelight.camera.util.api.IAEMaterialParserUtil
    public ArrayList<AEMaterialCategory> parseMaterialListFromConfig(String str) throws Exception {
        return AEMaterialConfigParser.d(str);
    }
}
