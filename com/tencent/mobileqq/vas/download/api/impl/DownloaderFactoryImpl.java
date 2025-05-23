package com.tencent.mobileqq.vas.download.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/download/api/impl/DownloaderFactoryImpl;", "Lcom/tencent/mobileqq/vas/download/api/IDownloaderFactory;", "Ljava/io/File;", "zipFile", "dstDir", "", "delSrc", "unzipResource", "", "type", "Lcom/tencent/mobileqq/vip/h;", "getDownloader", "Lcom/tencent/mobileqq/vip/g;", "tsk", "Lmqq/app/AppRuntime;", "app", "download", "Lcom/tencent/mobileqq/vip/DownloaderFactory;", "mDownloaderFactory", "Lcom/tencent/mobileqq/vip/DownloaderFactory;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class DownloaderFactoryImpl implements IDownloaderFactory {

    @Nullable
    private DownloaderFactory mDownloaderFactory;

    @Override // com.tencent.mobileqq.vas.download.api.IDownloaderFactory
    public int download(@Nullable g tsk, @Nullable AppRuntime app) {
        return DownloaderFactory.o(tsk, app);
    }

    @Override // com.tencent.mobileqq.vas.download.api.IDownloaderFactory
    @Nullable
    public h getDownloader(int type) {
        try {
            if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
                Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.DOWNLOADER_FACTORY);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.vip.DownloaderFactory");
                this.mDownloaderFactory = (DownloaderFactory) manager;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.mDownloaderFactory == null) {
            this.mDownloaderFactory = new DownloaderFactory(MobileQQ.sMobileQQ.peekAppRuntime());
        }
        DownloaderFactory downloaderFactory = this.mDownloaderFactory;
        Intrinsics.checkNotNull(downloaderFactory);
        return downloaderFactory.u(type);
    }

    @Override // com.tencent.mobileqq.vas.download.api.IDownloaderFactory
    public boolean unzipResource(@Nullable File zipFile, @Nullable File dstDir, boolean delSrc) {
        return DownloaderFactory.X(zipFile, dstDir, delSrc);
    }
}
