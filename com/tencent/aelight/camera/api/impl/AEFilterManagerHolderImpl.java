package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.api.IAEFilterManagerHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFilterManagerHolderImpl implements IAEFilterManagerHolder {
    @Override // com.tencent.aelight.camera.api.IAEFilterManagerHolder
    public boolean isAEFilterManagerEmpty() {
        return AEFilterManagerHolder.getAEFilterManager() == null;
    }

    @Override // com.tencent.aelight.camera.api.IAEFilterManagerHolder
    public void setIsAfterUpdateMaterial(boolean z16) {
        AEFilterProcessTex aEFilterManager = AEFilterManagerHolder.getAEFilterManager();
        if (aEFilterManager != null) {
            aEFilterManager.w0(z16);
        }
    }

    @Override // com.tencent.aelight.camera.api.IAEFilterManagerHolder
    public void updateLutGL(String str) {
        AEFilterProcessTex aEFilterManager = AEFilterManagerHolder.getAEFilterManager();
        if (aEFilterManager != null) {
            aEFilterManager.V0(str);
        }
    }
}
