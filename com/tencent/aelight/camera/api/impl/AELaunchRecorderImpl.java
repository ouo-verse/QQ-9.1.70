package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.api.IAELaunchRecorder;
import tq.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AELaunchRecorderImpl implements IAELaunchRecorder {
    @Override // com.tencent.aelight.camera.api.IAELaunchRecorder
    public void beginSession() {
        b.h().a();
    }

    @Override // com.tencent.aelight.camera.api.IAELaunchRecorder
    public void endSession() {
        b.h().e();
    }

    @Override // com.tencent.aelight.camera.api.IAELaunchRecorder
    public void milestone(String str) {
        b.h().o(str);
    }

    @Override // com.tencent.aelight.camera.api.IAELaunchRecorder
    public void oldAioDrawFirstFrameDone() {
        b.h().r();
    }

    @Override // com.tencent.aelight.camera.api.IAELaunchRecorder
    public void print(boolean z16) {
        b.h().s(z16);
    }
}
