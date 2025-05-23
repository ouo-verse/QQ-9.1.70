package com.tencent.gamematrix.gmcg.api;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.gamematrix.gmcg.api.model.GmCgNetDetectionInfo;
import java.util.List;

/* loaded from: classes6.dex */
public interface GmCgPlayDetectorListener {
    @MainThread
    void onGmCgDetectorError(@NonNull GmCgError gmCgError);

    @MainThread
    void onGmCgDetectorStart(boolean z16, float f16, float f17);

    void onGmCgDetectorUpdate(int i3);

    void onGmCgNetDetectResult(int i3, boolean z16, List<GmCgNetDetectionInfo> list);
}
