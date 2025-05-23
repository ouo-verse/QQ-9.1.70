package com.tencent.aelight.camera.util.api.impl;

import android.app.Activity;
import com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity;
import com.tencent.aelight.camera.util.api.IAEEditorJumpUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import er.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorJumpUtilImpl implements IAEEditorJumpUtil {
    @Override // com.tencent.aelight.camera.util.api.IAEEditorJumpUtil
    public int getFragmentContainerId(Activity activity) {
        return activity instanceof WinkHomeActivity ? R.id.rxr : R.id.ckj;
    }

    @Override // com.tencent.aelight.camera.util.api.IAEEditorJumpUtil
    public void picChooseJump(int i3, Activity activity, PhotoCommonBaseData photoCommonBaseData, boolean z16) {
        a.c(i3, activity, photoCommonBaseData, z16);
    }
}
