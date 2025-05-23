package com.tencent.aelight.camera.util.api.impl;

import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;

/* loaded from: classes32.dex */
public class AECameraPrefsUtilImpl implements IAECameraPrefsUtil {
    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public boolean getBoolean(String str, boolean z16, int i3) {
        return AECameraPrefsUtil.f().c(str, z16, i3);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public int getInt(String str, int i3, int i16) {
        return AECameraPrefsUtil.f().g(str, i3, i16);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public long getLong(String str, long j3, int i3) {
        return AECameraPrefsUtil.f().h(str, j3, i3);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public String getString(String str, String str2, int i3) {
        return AECameraPrefsUtil.f().j(str, str2, i3);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public void putBoolean(String str, boolean z16, int i3) {
        AECameraPrefsUtil.f().l(str, z16, i3);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public void putInt(String str, int i3, int i16) {
        AECameraPrefsUtil.f().n(str, i3, i16);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public void putLong(String str, long j3, int i3) {
        AECameraPrefsUtil.f().o(str, j3, i3);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public void putString(String str, String str2, int i3) {
        AECameraPrefsUtil.f().p(str, str2, i3);
    }

    @Override // com.tencent.aelight.camera.util.api.IAECameraPrefsUtil
    public void remove(String str, int i3) {
        AECameraPrefsUtil.f().q(str, i3);
    }
}
