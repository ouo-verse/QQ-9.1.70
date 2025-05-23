package com.tencent.aelight.camera.download.api.impl;

import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import org.light.LightEngine;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEKitForQQImpl implements IAEKitForQQ {
    @Override // com.tencent.aelight.camera.download.api.IAEKitForQQ
    public LightEngine.SDKServiceCallback getLightServiceCallback() {
        return d.g();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEKitForQQ
    public boolean init() {
        return d.h();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEKitForQQ
    public boolean initWithConfig() {
        return d.j();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEKitForQQ
    public boolean isSupported() {
        return d.p();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEKitForQQ
    public boolean lightSdkIsFunctionReadyWithConfig() {
        return d.t();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEKitForQQ
    public boolean lightSdkLoadBasicFeaturesWithConfig() {
        return d.u();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEKitForQQ
    public boolean loadLightSdkWithConfig() {
        return d.s();
    }
}
