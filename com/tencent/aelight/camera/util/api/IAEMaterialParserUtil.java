package com.tencent.aelight.camera.util.api;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEMaterialParserUtil extends QRouteApi {
    void parseCategory(List<MetaCategory> list, List<AEMaterialCategory> list2);

    ArrayList<AEMaterialCategory> parseMaterialListFromConfig(String str) throws Exception;
}
