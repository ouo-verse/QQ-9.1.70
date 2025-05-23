package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQStoryFlowManagerImpl implements IQQStoryFlowManager {
    @Override // com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager
    public boolean isValidMedia(Activity activity, LocalMediaInfo localMediaInfo) {
        return QQStoryFlowCallback.e(activity, localMediaInfo);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager
    public void startEditVideoActivity(Activity activity, String str, LocalMediaInfo localMediaInfo, int i3, int i16, int i17, int i18, int i19, String str2, String str3, boolean z16, int i26, int i27, Bundle bundle) {
        QQStoryFlowCallback.f(activity, str, localMediaInfo, i3, i16, i17, i18, i19, str2, str3, z16, i26, i27, bundle);
    }
}
