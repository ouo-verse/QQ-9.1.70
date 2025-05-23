package com.tencent.mobileqq.uniformdownload.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.uniformdownload.util.d;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes17.dex */
public interface IUniformDownloadMgr extends IRuntimeService {
    public static final int BUSINESS_BROWSER_OPT = 1;
    public static final String DOWNLOAD_BIG_BROTHER_SOURCE = "DOWNLOAD_BIG_BROTHER_SOURCE";
    public static final String DOWNLOAD_QQBROWSER_BUSINESS = "_download_qqbrowser_business_";
    public static final String FILENAME_DEFAULT = "nofilename.x";
    public static final String FILENAME_FROM_DIALOG = "_filename_from_dlg";
    public static final String FILESIZE_FROM_DIALOG = "_filesize_from_dlg";
    public static final String FILE_BUNDLE_USERDATA = "_user_data";
    public static final String FILE_MIME_TYPE = "FILE_MIME_TYPE";
    public static final String NOTIFY_NAME_DIALOG = "_notify_name_dialog";
    public static final String OPEN_WITH_QQBROWSER = "_open_with_qq_browser_";
    public static final String PARAMS_OPEN_WITH_YYB = "params_open_with_yyb";
    public static final String UNIDOWNLOAD_BORDCAST = "com.tencent.mobileqq.qfile_unifromdownload";

    AppRuntime getApp();

    boolean isExistedDownloadOfUrl(String str);

    void onActiveAccount();

    void onAppInit(AppRuntime appRuntime);

    void onQQProcessExit();

    void removeOuterListenner(String str);

    void startDownload(String str, Bundle bundle);

    void startDownload(String str, Bundle bundle, d dVar);

    void startDownloadNoSzie(String str, Bundle bundle);
}
