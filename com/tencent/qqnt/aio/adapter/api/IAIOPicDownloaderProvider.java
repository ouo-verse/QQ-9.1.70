package com.tencent.qqnt.aio.adapter.api;

import com.tencent.libra.download.ILibraDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOPicDownloaderProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "provideDownloader", "Lcom/tencent/libra/download/ILibraDownloader;", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOPicDownloaderProvider extends QRouteApi {
    @NotNull
    ILibraDownloader provideDownloader();
}
