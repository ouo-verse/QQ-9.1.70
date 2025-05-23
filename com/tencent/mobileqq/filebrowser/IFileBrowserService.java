package com.tencent.mobileqq.filebrowser;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileBrowserService extends QRouteApi {
    public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_BUDDY = 1;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_BUDDY_LIST = 2;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_DATALINE = 11;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_DISC = 5;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_DISC_LIST = 6;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_TROOP = 3;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_TROOP_LIST = 4;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_FAV = 10;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_FORWARD = 12;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_LOCAL = 8;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_RECENT = 7;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_TBS_TOOL = 13;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_UNKNOW = 0;
    public static final int FILE_BROWSER_ENTRANCE_TYPE_WEIYUN = 9;
    public static final String FILE_BROWSER_PAGE_FROM = "page_from";
    public static final String FILE_BROWSER_PARAMS_ENTRANCE = "browser_params_entrance";
    public static final int PAGE_AIO = 0;
    public static final int PAGE_CHAT_HISTORY = 1;
    public static final int PAGE_EXPIRING_FILE = 6;
    public static final int PAGE_FILE_OTHER = 5;
    public static final int PAGE_FILE_SELECT = 4;
    public static final int PAGE_FLASH_TRANSFER = 7;
    public static final int PAGE_MY_FILE = 2;
    public static final int PAGE_SEARCH = 3;
    public static final String STRING_BROWSE_ID = "browseId";

    void browserFile(Activity activity, int i3, e eVar, f fVar);

    void browserFile(Context context, e eVar, f fVar);

    e getFileModel(int i3);

    void onDestroy(int i3);

    int putFileModel(e eVar);

    void reportQQBrowserDownloadEvent(String str);

    void setCheckShowTbsReaderBar(boolean z16);
}
