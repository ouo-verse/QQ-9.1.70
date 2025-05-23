package com.tencent.aelight.camera.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.aelight.camera.aebase.activity.CaptureQmcfSoDownloadActivity;
import com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureQmcfSoDownloadLaunchImpl implements ICaptureQmcfSoDownloadLaunch {
    @Override // com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
    public Class getQmcSoDownloadActivity() {
        return CaptureQmcfSoDownloadActivity.class;
    }

    @Override // com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
    public void launch(Context context, String str, Bundle bundle) {
        CaptureQmcfSoDownloadActivity.launch(context, str, bundle);
    }

    @Override // com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
    public void launchForResult(Activity activity, String str, Bundle bundle, int i3) {
        CaptureQmcfSoDownloadActivity.launchForResult(activity, str, bundle, i3);
    }

    @Override // com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
    public void launch(Context context, String str, Bundle bundle, boolean z16) {
        CaptureQmcfSoDownloadActivity.launch(context, str, bundle, z16);
    }

    @Override // com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
    public void launchForResult(Activity activity, String str, Bundle bundle, int i3, boolean z16) {
        CaptureQmcfSoDownloadActivity.launchForResult(activity, str, bundle, i3, z16);
    }

    @Override // com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
    public void launchForResult(Context context, String str, Bundle bundle, int i3, boolean z16) {
        CaptureQmcfSoDownloadActivity.launchForResult(context, str, bundle, i3, z16);
    }

    @Override // com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch
    public void launchForResult(Activity activity, String str, Bundle bundle, int i3, boolean z16, boolean z17) {
        CaptureQmcfSoDownloadActivity.launchForResult(activity, str, bundle, i3, z16, z17);
    }
}
