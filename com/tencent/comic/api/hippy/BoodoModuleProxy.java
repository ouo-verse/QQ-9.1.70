package com.tencent.comic.api.hippy;

import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface BoodoModuleProxy {
    public static final String METHOD_DOWNLOAD_COMIC = "downloadComic";
    public static final String METHOD_GET_DOWNLOAD_LIST = "getDownloadList";
    public static final String METHOD_MAIN_TAB_APPEAR = "mainTabAppear";
    public static final String METHOD_MODIFY_DOWNLOAD_STATUS = "modifyDownloadStatus";
    public static final String METHOD_NOTIFY_WEB_STATUS = "notifyWebStatus";
    public static final String METHOD_OPEN_COMIC_INTRO = "openComicIntro";
    public static final String METHOD_OPEN_DOWNLOAD_DETAIL = "openDownloadDetail";
    public static final String METHOD_OPEN_VIDEO_ADV = "openVideoAdv";
    public static final String METHOD_PAGE_GET_TRACE = "getPageTrace";
    public static final String METHOD_PAGE_POP = "popPage";
    public static final String METHOD_PAGE_PUSH = "pushPage";
    public static final String METHOD_QUERY_DOWNLOAD_PROGRESS = "queryDownloadProgress";
    public static final String METHOD_REPORT_01327 = "reportDC01327";
    public static final String METHOD_START_READ = "startRead";

    void callModule(IBoodoModule iBoodoModule, String str, JSONObject jSONObject, Promise promise);

    void onDestroy();
}
