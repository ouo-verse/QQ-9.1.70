package com.tencent.qcircle.tavcut.session.callback;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface FrameExtractCallback {
    void onExtractCanceled();

    void onExtractFailed();

    void onFrameExtracted(Bitmap bitmap);
}
