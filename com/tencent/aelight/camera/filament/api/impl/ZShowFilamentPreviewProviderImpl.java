package com.tencent.aelight.camera.filament.api.impl;

import com.tencent.aelight.camera.ae.flashshow.zshow.FilamentPreviewView;
import com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView;
import com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes32.dex */
public class ZShowFilamentPreviewProviderImpl implements IZShowFilamentPreviewProvider {
    static String TAG = "ZShowFilamentPreviewProviderImpl";

    @Override // com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider
    public BaseZShowFilamentPreviewView getView() {
        return new FilamentPreviewView(BaseApplication.getContext());
    }

    @Override // com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider
    public boolean isSupportFilament() {
        return ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase(null);
    }
}
