package com.tencent.aelight.camera.entry.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import gq.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECameraEntryManagerImpl implements IAECameraEntryManager {
    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public int getAEFromType(Intent intent) {
        return a.a(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public int getStoryMediaType(Intent intent) {
        return a.d(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public int getStoryShareType(Intent intent) {
        return a.e(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isAddPlayShowEntry(Activity activity) {
        return a.h(activity);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isFromCheckEntry(Intent intent) {
        return a.p(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isFromGuideCircle(Intent intent) {
        return a.x(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isFromMiniApp(Intent intent) {
        return a.z(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isQzoneTailEntry(Intent intent) {
        return a.Q(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isSameStoryPhotoEntry(Intent intent) {
        return a.R(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isStoryDefaultShare(Intent intent) {
        return a.S(intent);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isStoryPhoto(Intent intent, int i3) {
        return a.U(intent, i3);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public int switchModeToInt(String str) {
        return a.X(str);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public String switchTabToName(String str) {
        return a.Y(str);
    }

    @Override // com.tencent.aelight.camera.entry.api.IAECameraEntryManager
    public boolean isAddPlayShowEntry(int i3) {
        return a.g(i3);
    }
}
