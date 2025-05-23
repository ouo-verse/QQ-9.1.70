package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;

/* loaded from: classes32.dex */
public class PtvFilterUtilImpl implements IPtvFilterUtil {
    @Override // com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil
    public void createFakeVidConfigFile(String str, String str2) {
        PtvFilterUtils.a(str, str2);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil
    public void glSyncCommand(boolean z16) {
        PtvFilterUtils.b(z16);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil
    public void setBeautyKindSafety(int i3) {
        PtvFilterUtils.d(i3);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil
    public void setSupportBeautySafety(boolean z16) {
        PtvFilterUtils.e(z16);
    }
}
