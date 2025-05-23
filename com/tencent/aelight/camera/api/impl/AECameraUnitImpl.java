package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.api.IAECameraUnit;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECameraUnitImpl implements IAECameraUnit {
    @Override // com.tencent.aelight.camera.api.IAECameraUnit
    public Class getAEPitUnitClass() {
        return AEPituCameraUnit.class;
    }

    @Override // com.tencent.aelight.camera.api.IAECameraUnit
    public void setPublishStoryFlag(boolean z16) {
        AEPituCameraUnit.f61830t1 = z16;
    }
}
