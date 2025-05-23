package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import java.util.HashMap;

/* loaded from: classes32.dex */
public class AELaunchEditPicImpl implements IAELaunchEditPic {
    @Override // com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic
    public Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3) {
        return EditPicActivity.startEditPic(activity, str, z16, z17, z18, z19, z26, i3);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic
    public Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, int i3, int i16, int i17, boolean z36, HashMap<String, Object> hashMap) {
        return EditPicActivity.startEditPic(activity, str, z16, z17, z18, z19, z26, z27, z28, z29, i3, i16, i17, z36, hashMap);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic
    public Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17) {
        return EditPicActivity.startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, i17);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic
    public Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17, Bundle bundle) {
        return EditPicActivity.startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, i17, bundle);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic
    public Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17, HashMap<String, Object> hashMap) {
        return EditPicActivity.startEditPic(activity, str, z16, z17, z18, z19, z26, i3, i16, i17, hashMap);
    }
}
