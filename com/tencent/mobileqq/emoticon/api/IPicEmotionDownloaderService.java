package com.tencent.mobileqq.emoticon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.AbsDownloader;
import mqq.app.MobileQQ;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IPicEmotionDownloaderService extends QRouteApi {
    AbsDownloader createPicEmotionDownloader(MobileQQ mobileQQ);
}
