package com.tencent.aelight.camera.watermark.api.impl;

import android.util.Log;
import com.tencent.aelight.camera.ae.camera.ui.watermark.b;
import com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEWaterMarkManagerImpl implements IAEWaterMarkManager {
    private static final String TAG = "AEWaterMarkManagerImpl";

    @Override // com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager
    public SosoLocation getLocation() {
        return b.f().g();
    }

    @Override // com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager
    public void onConfigChange(boolean z16) {
        try {
            b.f().h(z16);
        } catch (Error e16) {
            Log.d(TAG, "error msg :" + e16.getMessage());
        }
    }
}
