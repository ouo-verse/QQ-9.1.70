package com.tencent.aelight.camera.download.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEResDownload extends QRouteApi {
    @Deprecated
    int getResPackageStatus(@NonNull AEResInfo aEResInfo);

    void preDownloadAEResOnAppStartUp();

    void removeCallBack(@Nullable a aVar);

    @Deprecated
    void requestDownload(@NonNull AEResInfo aEResInfo, @Nullable a aVar, boolean z16);
}
