package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import lr.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class JumpUtilImpl implements IJumpUtil {
    @Override // com.tencent.aelight.camera.qqstory.api.IJumpUtil
    public String getCircleScheme(String str, String str2) {
        return a.b(str, str2);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IJumpUtil
    public String getSchemeForTail(String str) {
        return a.d(str);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IJumpUtil
    public Bundle handleWidgetInfo(Bundle bundle, String str) {
        return a.e(bundle, str);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IJumpUtil
    public void jumpToCameraActivityForAio(Activity activity, String str) {
        a.g(activity, str);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IJumpUtil
    public void jumpToCameraForTakeSameGif(Activity activity, String str) {
        a.h(activity, str);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IJumpUtil
    public void jumpToSlideShowEditVideoActivityForQzone(Activity activity, Bundle bundle) {
        a.k(activity, bundle);
    }
}
