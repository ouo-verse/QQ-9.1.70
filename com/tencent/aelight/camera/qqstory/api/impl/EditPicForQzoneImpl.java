package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPictureActivity;
import com.tencent.aelight.camera.qqstory.api.IEditPicForQzone;

/* loaded from: classes32.dex */
public class EditPicForQzoneImpl implements IEditPicForQzone {
    @Override // com.tencent.aelight.camera.qqstory.api.IEditPicForQzone
    public Intent newPictureEditIntentWithoutPublish(Activity activity, String str) {
        return QzoneEditPictureActivity.newPictureEditIntentWithoutPublish(activity, str);
    }
}
