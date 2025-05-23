package com.samsung.android.sdk.camera.delegator;

import android.content.Context;
import com.samsung.android.sep.camera.SemCamera;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SemCamera10_2 extends AbstractSemCamera {
    private SemCamera mSemCamera;

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCamera
    public int checkAvailability(Context context) {
        return SemCamera.getInstance().checkAvailability(context);
    }

    @Override // com.samsung.android.sdk.camera.delegator.AbstractSemCamera
    public boolean isFeatureEnabled(Context context, String str, int i3) {
        return SemCamera.getInstance().isFeatureEnabled(context, str, i3);
    }
}
