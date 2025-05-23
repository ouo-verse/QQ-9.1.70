package com.tencent.aelight.camera.qqstory.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.shortvideo.a;
import com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMBeautyManagerImpl implements IQIMBeautyManager {
    @Override // com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager
    public int getBeautyConfigVersion(Context context) {
        return a.c().a(context);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager
    public void parseConfig() {
        a.c().d();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager
    public boolean saveBeautyConfig(String str, int i3, Context context) {
        return a.c().e(str, i3, context);
    }
}
