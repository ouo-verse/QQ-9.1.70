package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.control.a;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AsyncControlImpl implements IAsyncControl {
    static a mAsyncControl = new a();

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public Object createCaptureAsyncControl() {
        return new a();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public void destory() {
        mAsyncControl.a();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public Object getAsynControl() {
        return mAsyncControl;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public String getCameraCreatedResultInfo() {
        return a.f66682f;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public boolean isCameraCreated() {
        return a.f66680d;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public boolean isCameraCreatedResult() {
        return a.f66681e;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public void startAsyncStep(int i3) {
        mAsyncControl.c(i3);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public void startPeakPreLoadAsyncStep() {
        mAsyncControl.d("{1000,1002}");
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAsyncControl
    public void startAsyncStep(String str, Object[] objArr) {
        mAsyncControl.e(str, objArr);
    }
}
