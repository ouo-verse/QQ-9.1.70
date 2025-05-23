package com.tencent.aelight.camera.enhance.api.impl;

import com.tencent.aelight.camera.ae.flashshow.enhance.EnhanceHelper;
import com.tencent.aelight.camera.enhance.api.IEnhanceHelper;
import com.tencent.aelight.camera.struct.editor.EnhanceConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EnhanceHelperImpl implements IEnhanceHelper {
    @Override // com.tencent.aelight.camera.enhance.api.IEnhanceHelper
    public EnhanceConfig getEnhanceConfig() {
        return EnhanceHelper.getInstance().getEnhanceConfig();
    }

    @Override // com.tencent.aelight.camera.enhance.api.IEnhanceHelper
    public void updateEnhanceConfigInSubThread() {
        EnhanceHelper.getInstance().updateEnhanceConfigInSubThread();
    }
}
