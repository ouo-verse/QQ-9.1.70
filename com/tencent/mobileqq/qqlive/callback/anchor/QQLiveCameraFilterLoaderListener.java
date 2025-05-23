package com.tencent.mobileqq.qqlive.callback.anchor;

import androidx.annotation.IntRange;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface QQLiveCameraFilterLoaderListener {
    void onLoadFinish(boolean z16);

    void onLoadProgressUpdate(@IntRange(from = 0, to = 100) int i3);
}
