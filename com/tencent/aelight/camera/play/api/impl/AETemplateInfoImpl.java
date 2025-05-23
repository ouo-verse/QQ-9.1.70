package com.tencent.aelight.camera.play.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.play.AETemplateInfoFragment;
import com.tencent.aelight.camera.play.api.IAETemplateInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AETemplateInfoImpl implements IAETemplateInfo {
    @Override // com.tencent.aelight.camera.play.api.IAETemplateInfo
    public void sendPickedPhotosToMe(Context context, Intent intent) {
        AETemplateInfoFragment.sendPickedPhotosToMe(context, intent);
    }
}
