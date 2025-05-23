package com.tencent.mobileqq.qwallet.preload;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import java.util.LinkedList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IPreloadServiceAbs extends IRuntimeService {
    public static final String PRELOAD_DIR_NAME_HIDE = ".preloaduni";

    @Deprecated
    void downloadModule(String str, String str2, IPreloadService.a aVar);

    @Deprecated
    void downloadRes(String str, String str2, IPreloadService.a aVar);

    void downloadUrls(List<String> list, IPreloadService.c cVar);

    void getFilePathByResID(String str, ResultReceiver resultReceiver);

    void getResPath(DownloadParam downloadParam, IPreloadService.c cVar);

    void getResPath(String str, IPreloadService.c cVar);

    void getResPath(LinkedList<DownloadParam> linkedList, IPreloadService.d dVar);

    IPreloadResource getResourceByResID(String str);

    String getVideoResPathByID(String str);

    boolean isNetValidToDownload(String str);
}
