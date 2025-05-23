package com.tencent.mobileqq.emoticon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.AbsDownloader;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IVasExtensionDownloaderService extends QRouteApi {
    AbsDownloader createVasExtensionDownloader();
}
