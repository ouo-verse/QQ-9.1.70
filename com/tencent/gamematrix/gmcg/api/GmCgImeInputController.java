package com.tencent.gamematrix.gmcg.api;

import android.app.Activity;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface GmCgImeInputController {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GmCgImeInputEvtListener {
        void onImeInputEvtHide();

        void onImeInputEvtSizeRatioGot(float f16);
    }

    void closeImeInput();

    void enableImeInput(boolean z16, Activity activity, FrameLayout frameLayout, GmCgImeInputEvtListener gmCgImeInputEvtListener);

    void onImeInputCloudFinish();

    void onImeInputCloudStart();
}
