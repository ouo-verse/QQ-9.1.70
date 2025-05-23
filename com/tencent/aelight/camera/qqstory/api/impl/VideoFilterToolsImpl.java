package com.tencent.aelight.camera.qqstory.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VideoFilterToolsImpl implements IVideoFilterTools {
    @Override // com.tencent.aelight.camera.qqstory.api.IVideoFilterTools
    public String getCommonPrefix() {
        return m.f66480m;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IVideoFilterTools
    public int getQQShortVideoFilterConfigVersion(Context context) {
        return m.r(context);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IVideoFilterTools
    public void handleQQShortVideoCommonConfig(String str) {
        m.w(str);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IVideoFilterTools
    public void updateQQShortVideoFilterConfig(Context context, String str) {
        m.W(context, str);
    }
}
