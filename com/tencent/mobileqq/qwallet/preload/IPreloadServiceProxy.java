package com.tencent.mobileqq.qwallet.preload;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import java.util.LinkedList;
import java.util.List;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IPreloadServiceProxy extends IPreloadServiceAbs {
    public static final String KEY_DOWNLOAD_CONFIG_STR = "config_str";
    public static final String KEY_DOWNLOAD_ID = "id";
    public static final String KEY_DOWNLOAD_PARAMS = "download_params";
    public static final String KEY_DOWNLOAD_RECEIVER = "receiver";
    public static final String KEY_METHOD_TYPE = "method_type";
    public static final String KEY_MID = "mid";
    public static final String KEY_PATH = "path";
    public static final String KEY_PATH_RESULT = "path_result";
    public static final String KEY_RESID = "res_id";
    public static final String KEY_RESINFO = "res_info";
    public static final String KEY_RESULT_CODE = "result_code";
    public static final String KEY_URL = "url";
    public static final int METHOD_TYPE_DOWNLOAD_URLS = 2;
    public static final int METHOD_TYPE_GET_RES_PATH = 1;
    public static final int METHOD_TYPE_GET_RES_PATHS = 3;
    public static final int METHOD_TYPE_GET_RES_PATH_SYNC = 4;

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    void downloadModule(String str, String str2, IPreloadService.a aVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    @Deprecated
    void downloadRes(String str, String str2, IPreloadService.a aVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void downloadUrls(List<String> list, IPreloadService.c cVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void getFilePathByResID(String str, ResultReceiver resultReceiver);

    ResourceInfo getResInfoByResId(String str);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void getResPath(DownloadParam downloadParam, IPreloadService.c cVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    void getResPath(LinkedList<DownloadParam> linkedList, IPreloadService.d dVar);

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
    String getVideoResPathByID(String str);
}
