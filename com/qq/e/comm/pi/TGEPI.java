package com.qq.e.comm.pi;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public interface TGEPI {
    void onExposureDestroy();

    void onExposurePause();

    void onExposureResume();

    void startCheck(WeakReference<View> weakReference);
}
