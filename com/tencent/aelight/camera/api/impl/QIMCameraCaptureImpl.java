package com.tencent.aelight.camera.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.api.IQIMCameraCapture;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMCameraCaptureImpl implements IQIMCameraCapture {
    @Override // com.tencent.aelight.camera.api.IQIMCameraCapture
    public Intent getLaunchIntent(Context context, Bundle bundle) {
        return QIMCameraCaptureActivity.y0(context, bundle);
    }

    @Override // com.tencent.aelight.camera.api.IQIMCameraCapture
    public Class getQIMCameraCaptureActivityClass() {
        return QIMCameraCaptureActivity.class;
    }

    @Override // com.tencent.aelight.camera.api.IQIMCameraCapture
    public void launch(Context context, Bundle bundle) {
        QIMCameraCaptureActivity.C0(context, bundle);
    }

    @Override // com.tencent.aelight.camera.api.IQIMCameraCapture
    public void launchForResult(Activity activity, Bundle bundle, int i3) {
        QIMCameraCaptureActivity.D0(activity, bundle, i3);
    }
}
