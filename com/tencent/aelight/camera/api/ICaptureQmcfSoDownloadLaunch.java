package com.tencent.aelight.camera.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICaptureQmcfSoDownloadLaunch extends QRouteApi {
    Class getQmcSoDownloadActivity();

    void launch(Context context, String str, Bundle bundle);

    void launch(Context context, String str, Bundle bundle, boolean z16);

    void launchForResult(Activity activity, String str, Bundle bundle, int i3);

    void launchForResult(Activity activity, String str, Bundle bundle, int i3, boolean z16);

    void launchForResult(Activity activity, String str, Bundle bundle, int i3, boolean z16, boolean z17);

    void launchForResult(Context context, String str, Bundle bundle, int i3, boolean z16);
}
