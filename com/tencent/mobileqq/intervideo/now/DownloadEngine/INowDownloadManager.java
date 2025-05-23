package com.tencent.mobileqq.intervideo.now.DownloadEngine;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INowDownloadManager extends QRouteApi {
    void addDownloadListener(String str, a aVar);

    void addNowDownloadTask(Object obj);

    INowDownloadManager createObject(boolean z16);

    void init(Context context);

    void removeDownloadListener(String str);

    void removeDownloadTask(String str, boolean z16);

    void startDownload(Object obj);

    void unInit();
}
