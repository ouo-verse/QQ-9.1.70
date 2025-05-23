package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.p;
import com.tencent.aelight.camera.api.ICameraCompatible;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CameraCompatibleImpl implements ICameraCompatible {
    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isFoundCoolPad() {
        return p.g();
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isFoundProduct(String str) {
        return p.h(str);
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isFoundProductByRomID(String str) {
        return p.j(str);
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isFoundProductFeature(String str) {
        return p.k(str);
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isFoundProductFeatureRom(String str) {
        return p.k(str);
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isFoundProductManufacturer(String str) {
        return p.l(str);
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isInARParticleBackList() {
        return p.m();
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isNeedDrawOnOpenGLSingleThread() {
        return p.n();
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean isNotSupportFilterBasedSdk() {
        return p.o();
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public boolean notSupportCameraFrontSysPhoto() {
        return p.q();
    }

    @Override // com.tencent.aelight.camera.api.ICameraCompatible
    public void updateCompatibleList(String str, boolean z16) {
        p.r(str, z16);
    }
}
