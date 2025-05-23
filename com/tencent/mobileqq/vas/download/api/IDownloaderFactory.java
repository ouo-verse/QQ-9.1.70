package com.tencent.mobileqq.vas.download.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import java.io.File;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH&J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/download/api/IDownloaderFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/io/File;", "zipFile", "dstDir", "", "delSrc", "unzipResource", "", "type", "Lcom/tencent/mobileqq/vip/h;", "getDownloader", "Lcom/tencent/mobileqq/vip/g;", "tsk", "Lmqq/app/AppRuntime;", "app", "download", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IDownloaderFactory extends QRouteApi {
    int download(@Nullable g tsk, @Nullable AppRuntime app);

    @Nullable
    h getDownloader(int type);

    boolean unzipResource(@Nullable File zipFile, @Nullable File dstDir, boolean delSrc);
}
