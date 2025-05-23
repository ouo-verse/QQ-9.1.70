package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.TDocLocalFileConfigParser;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.api.b;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.teamwork.menu.ak;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITDocFileBrowserFacade extends QRouteApi {
    public static final String NATIVE_ENGINE_SO_NAME = "docx_binding_loader";
    public static final int PASS_WORD_EMPTY_CODE = 14014;
    public static final int PASS_WORD_ERROR_CODE = 14015;
    public static final String TDOC_FILE_BROWSER_LOAD_CONFIG_KEY = "tdoc_local_file_preview";
    public static final int TD_CONNECT_UNBIND = -104;
    public static final int TD_FILE_TYPE_UNSUPPORTED_CODE = -102;
    public static final int TD_RESOURCE_LOAD_FAILED_CODE = -103;
    public static final int TD_SWITCH_NO_ENABLE = -101;
    public static final String TD_UNSUPPORTED_MSG = "engine not support";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public enum EngineType {
        NATIVE,
        WEB
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onResult(boolean z16);
    }

    void checkAndExecuteDownloadTasks();

    boolean checkAndUpdateOfflinePackage(String str);

    boolean checkAndUpdateOfflinePackage4Bid(String str);

    boolean checkAndUpdateSo();

    boolean checkFileExist(String str);

    boolean checkPasswordCode(int i3);

    MenuTabViewBase.a createMenuItemClickListener(Activity activity, TeamWorkFileImportInfo teamWorkFileImportInfo, INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper, ak akVar);

    INativeEngineFileBrowserWrapper createNativeEngineFileBrowser(Activity activity, String str, int i3, INativeEngineFileBrowserWrapper.OpenMode openMode, OpenDocsPerformanceRecorder openDocsPerformanceRecorder, INativeEngineFileBrowserWrapper.c cVar);

    b createWebEngineFileBrowser(Context context, String str, OpenDocsPerformanceRecorder openDocsPerformanceRecorder, b.InterfaceC8637b interfaceC8637b);

    TDocLocalFileConfigParser.b getConfig();

    int getDocsTypeOfIntValue(String str);

    String getFileDocsType(String str);

    String getWebEngineFileLoadUrl(String str, String str2, String str3);

    WebResourceResponse getWebResourceResp(String str, WebResourceRequest webResourceRequest);

    void initLocalEditSDK(Context context);

    void initWebEngine();

    boolean isAllResourceReady(String str);

    boolean isBottomMenuEnable();

    boolean isNativeSupportDocsType(String str);

    boolean isTDocPreviewEnable(String str);

    boolean isWebEngineEnable(String str);

    void updateOfflinePackage(String str, a aVar);

    void updateOfflinePackage4Bid(String str, a aVar);

    void updateSo(a aVar);
}
