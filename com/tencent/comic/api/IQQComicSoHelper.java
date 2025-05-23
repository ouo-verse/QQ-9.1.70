package com.tencent.comic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQComicSoHelper extends QRouteApi {
    String getComicPlayerSoPath();

    String getComicPlayerSoZipPath();

    void onSoDownloadCompleted(AppRuntime appRuntime, int i3);
}
