package com.tencent.biz.pubaccount.imagecollection.api;

import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountImageCollectionPreloadManager extends QRouteApi {
    void addTask(String str);

    boolean canPreload();

    void cancelNotDownloadTask();

    void checkDelDir();

    void clearAllCache();

    void doStatisticReportForImageHit(boolean z16, int i3);

    void doStatisticReportForImageTime(boolean z16, long j3);

    void doStatisticReportForProtoHit(boolean z16);

    IPublicAccountImageCollectionUtils.a getPhotoCollectionInfoFromCache(String str);

    void getPhotoCollectionInfoFromFile(String str, IPublicAccountArticleObserver iPublicAccountArticleObserver);

    int getPreloadImageCount();

    void preloadImage(IPublicAccountImageCollectionUtils.a aVar);

    void removeObserver();

    void saveImageCollectionInfo(IPublicAccountImageCollectionUtils.a aVar, byte[] bArr);

    void setObserver(IPublicAccountArticleObserver iPublicAccountArticleObserver);
}
