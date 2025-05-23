package com.tencent.mobileqq.bigbrother.RockDownloader;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(@Nonnull RockDownloadInfo rockDownloadInfo) {
        RockDownloaderTask rockDownloaderTask = new RockDownloaderTask();
        rockDownloaderTask.setDownloadInfo(rockDownloadInfo);
        rockDownloaderTask.setTaskCheckLevel(1);
        rockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
        return RockDownloader.d(rockDownloaderTask);
    }

    public static void b(@Nonnull RockDownloadInfo rockDownloadInfo, @Nullable a aVar) {
        RockDownloaderTask rockDownloaderTask = new RockDownloaderTask();
        rockDownloaderTask.setDownloadInfo(rockDownloadInfo);
        rockDownloaderTask.setTaskCheckLevel(1);
        rockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
        rockDownloaderTask.setQueryAPKListener(aVar);
        RockDownloader.e(rockDownloaderTask);
    }
}
