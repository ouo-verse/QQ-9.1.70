package com.tencent.aelight.camera.filament.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import ks.a;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IZplanFilamentProvider extends QRouteApi {
    void enableLog(boolean z16);

    boolean isFilamentMaterial(@NonNull VideoMaterial videoMaterial);

    boolean isFilamentReady();

    void registerFilamentDownloader(@Nullable a aVar);
}
