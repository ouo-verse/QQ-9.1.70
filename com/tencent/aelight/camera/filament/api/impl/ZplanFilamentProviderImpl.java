package com.tencent.aelight.camera.filament.api.impl;

import android.text.TextUtils;
import com.tencent.aelight.camera.filament.api.IZplanFilamentProvider;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import ks.a;
import xq.c;

/* loaded from: classes32.dex */
public class ZplanFilamentProviderImpl implements IZplanFilamentProvider {
    @Override // com.tencent.aelight.camera.filament.api.IZplanFilamentProvider
    public boolean isFilamentReady() {
        return c.f448345a.isFilamentReady();
    }

    @Override // com.tencent.aelight.camera.filament.api.IZplanFilamentProvider
    public void registerFilamentDownloader(a aVar) {
        c.f448345a.h(aVar);
    }

    @Override // com.tencent.aelight.camera.filament.api.IZplanFilamentProvider
    public void enableLog(boolean z16) {
        if (z16) {
            w53.a.e(2);
        } else {
            w53.a.e(4);
        }
    }

    @Override // com.tencent.aelight.camera.filament.api.IZplanFilamentProvider
    public boolean isFilamentMaterial(VideoMaterial videoMaterial) {
        if (videoMaterial == null) {
            return false;
        }
        String id5 = videoMaterial.getId();
        if (TextUtils.isEmpty(id5)) {
            return false;
        }
        return c.f448345a.isFilamentMaterial(id5);
    }
}
