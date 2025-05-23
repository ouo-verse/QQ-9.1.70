package com.tencent.mobileqq.wink.intermediate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.intermediate.protocol.SHADOW_BACKEND_INTERFACE.GetMaterialInfoByIdsRsp;
import com.tencent.qphone.base.util.QLog;
import d83.a;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import y53.b;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TemplateLibIntermediateServiceHandler extends WinkDataServiceHandler {
    public TemplateLibIntermediateServiceHandler(@NotNull AppInterface appInterface) {
        super(appInterface);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
    protected void R2(GetMaterialInfoByIdsRsp getMaterialInfoByIdsRsp) {
        try {
            Map<String, MetaMaterial> map = getMaterialInfoByIdsRsp.MaterialInfo;
            QLog.d("TemplateLibIntermediateServiceHandler", 1, "handleGetMaterialInfoByIds, materialInfoMap: " + map);
            if (map != null && !map.isEmpty()) {
                HashMap hashMap = new HashMap();
                for (String str : map.keySet()) {
                    MetaMaterial metaMaterial = map.get(str);
                    if (metaMaterial != null) {
                        hashMap.put(str, b.b(metaMaterial));
                    }
                }
                notifyUI(120, true, hashMap);
                return;
            }
            notifyUI(120, false, null);
        } catch (Exception e16) {
            QLog.w("TemplateLibIntermediateServiceHandler", 1, "handleGetMaterialInfoByIds, error ", e16);
            notifyUI(120, false, null);
        }
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return a.class;
    }
}
