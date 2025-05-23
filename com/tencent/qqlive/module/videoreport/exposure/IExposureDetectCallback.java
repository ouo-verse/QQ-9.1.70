package com.tencent.qqlive.module.videoreport.exposure;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.exposure.DetectionData;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IExposureDetectCallback<T extends DetectionData> {
    T createDetectionData();

    Rect getExcludeRect();

    boolean onEnter(View view, T t16);

    void onExposed(View view, T t16, @NonNull AreaInfo areaInfo);

    void onLeave(View view, T t16);
}
