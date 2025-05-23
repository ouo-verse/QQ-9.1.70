package com.tencent.aelight.camera.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQIMCameraCapture extends QRouteApi {
    Intent getLaunchIntent(Context context, Bundle bundle);

    Class getQIMCameraCaptureActivityClass();

    void launch(Context context, Bundle bundle);

    void launchForResult(Activity activity, Bundle bundle, int i3);
}
