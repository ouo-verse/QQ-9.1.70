package com.qq.e.tg;

import android.view.View;
import com.qq.e.comm.pi.TGEPI;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramExposureChecker {

    /* renamed from: a, reason: collision with root package name */
    private TGEPI f40443a;

    public TangramExposureChecker(TGEPI tgepi) {
        this.f40443a = tgepi;
    }

    public void onExposureDestroy() {
        this.f40443a.onExposureDestroy();
    }

    public void onExposurePause() {
        this.f40443a.onExposurePause();
    }

    public void onExposureResume() {
        this.f40443a.onExposureResume();
    }

    public void startCheck(WeakReference<View> weakReference) {
        this.f40443a.startCheck(weakReference);
    }
}
