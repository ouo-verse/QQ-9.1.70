package com.tencent.aelight.camera.qqstory.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureVideoFilterManagerImpl implements ICaptureVideoFilterManager {
    @Override // com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
    public FilterDesc getFilterDesc(String str) {
        return a.e().d(str);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
    public String getQQFilterConfigpath() {
        return a.f67458i;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
    public String getQQFilterResPath() {
        return a.f67459j;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
    public int getQQShortVideoFilterConfigVersion(Context context) {
        a.e();
        return a.g(context);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
    public FilterCategoryItem getSelectFilterCategoryItem() {
        return a.e().h();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
    public boolean needShowRedDot(int i3, int i16, String str) {
        return a.e().j(i3, i16, str);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
    public void updateQQShortVideoFilterConfig(Context context, String str, int i3) {
        a.e().n(context, str, i3);
    }
}
