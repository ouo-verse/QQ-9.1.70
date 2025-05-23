package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.localserver.b;
import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.TDocLocalFileConfigParser;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.api.b;
import com.tencent.mobileqq.teamwork.app.ResourcePackageManager;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TDocFileBrowserFacadeImpl implements ITDocFileBrowserFacade {
    private static final String TAG = "TDocFileBrowserFacadeImpl";
    private static final String WEB_ENGINE_LOAD_URL_CLIENT = "qqclient_local";
    private static final int cacheMaxCount = 30;
    private static String defaultLocalHost = "127.0.0.1";
    private volatile boolean initialized = false;
    private b.a serverListener = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements b.a {
        a() {
        }

        @Override // com.tencent.localedit.fakenative.localserver.b.a
        public void a(@Nullable String str) {
            QLog.d(TDocFileBrowserFacadeImpl.TAG, 1, "tDoc_local_edit onServerError " + str);
        }

        @Override // com.tencent.localedit.fakenative.localserver.b.a
        public void b() {
            QLog.d(TDocFileBrowserFacadeImpl.TAG, 1, "tDoc_local_edit onServerStop");
        }

        @Override // com.tencent.localedit.fakenative.localserver.b.a
        public void c(@Nullable String str) {
            QLog.d(TDocFileBrowserFacadeImpl.TAG, 1, "tDoc_local_edit onServerStart " + str);
        }
    }

    private synchronized void handleLzmaDecodeSuccess(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.tencent.mobileqq.teamwork.app.e.r(str);
            String g16 = com.tencent.mobileqq.teamwork.app.e.g();
            if (!TextUtils.isEmpty(g16) && !g16.equals(str2)) {
                File file = new File(g16);
                if (file.exists() && file.isDirectory()) {
                    FileUtils.deleteFile(file);
                }
            }
            QLog.i(TAG, 1, "handleLzmaDecodeSuccess oldRelatedFilesFolder = " + g16 + " | relatedFilesFolder = " + str2);
            com.tencent.mobileqq.teamwork.app.e.s(str2);
            return;
        }
        QLog.e(TAG, 1, "handleLoadSoSuccess error :  newVer = " + str + " | relatedFilesFolder = " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initLocalEditSDK$4(String str, JSONObject jSONObject, int i3, int i16) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "report = " + str + " | tDoc_local_edit \uff5c " + jSONObject + " | tDoc_local_edit \uff5c " + i3 + APLogFileUtil.SEPARATOR_LOG + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$updateOfflinePackage$2(String str, ITDocFileBrowserFacade.a aVar, Boolean bool) {
        QLog.i(TAG, 1, "[updateOfflinePackage] updated:" + bool + "docsType: " + str);
        if (aVar != null) {
            aVar.onResult(bool.booleanValue());
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateOfflinePackage$3(final String str, final ITDocFileBrowserFacade.a aVar) {
        LocalEditSDK.INSTANCE.packageManager.k(str, new Function1() { // from class: com.tencent.mobileqq.teamwork.api.impl.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$updateOfflinePackage$2;
                lambda$updateOfflinePackage$2 = TDocFileBrowserFacadeImpl.lambda$updateOfflinePackage$2(str, aVar, (Boolean) obj);
                return lambda$updateOfflinePackage$2;
            }
        }, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSo$0(LoadExtResult loadExtResult, int i3, ITDocFileBrowserFacade.a aVar, long j3) {
        boolean z16 = false;
        if (loadExtResult == null) {
            QLog.e(TAG, 1, "tDoc_step [loadSo] NATIVE onLoadResult, resCode:" + i3 + "loadExtResult error");
            if (aVar != null) {
                aVar.onResult(false);
                return;
            }
            return;
        }
        String f16 = com.tencent.mobileqq.teamwork.app.e.f();
        String ver = loadExtResult.getVer();
        QLog.i(TAG, 1, "tDoc_step [loadSo] NATIVE onLoadResult, resCode:" + i3 + " cost:" + (System.currentTimeMillis() - j3) + " oldVer:" + f16 + " newVer:" + ver);
        if (!f16.equals(ver)) {
            String relatedFilesFolder = loadExtResult.getRelatedFilesFolder();
            int lzmaDecode = LzmaUtils.lzmaDecode(BaseApplication.getContext(), relatedFilesFolder + "/binding/binding.7z", relatedFilesFolder + "/binding/");
            QLog.i(TAG, 1, "tDoc_step [loadSo] NATIVE onLoadResult, resCode:" + lzmaDecode);
            if (lzmaDecode == 0) {
                handleLzmaDecodeSuccess(ver, relatedFilesFolder);
            } else {
                if (aVar != null) {
                    aVar.onResult(false);
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            if (i3 == 0) {
                z16 = true;
            }
            aVar.onResult(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSo$1(final ITDocFileBrowserFacade.a aVar, final long j3, final int i3, final LoadExtResult loadExtResult) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.q
            @Override // java.lang.Runnable
            public final void run() {
                TDocFileBrowserFacadeImpl.this.lambda$updateSo$0(loadExtResult, i3, aVar, j3);
            }
        }, 64, null, false);
    }

    private synchronized void startServer() {
        LocalEditSDK localEditSDK = LocalEditSDK.INSTANCE;
        if (localEditSDK.localServer.d()) {
            QLog.d(TAG, 1, "tDoc_local_edit checkIsServerRunning true ");
        } else {
            localEditSDK.localServer.m(MobileQQ.sMobileQQ, defaultLocalHost, this.serverListener);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public void checkAndExecuteDownloadTasks() {
        ResourcePackageManager.a();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean checkAndUpdateOfflinePackage(String str) {
        boolean d16 = LocalEditSDK.INSTANCE.packageManager.d(str);
        if (!d16) {
            updateOfflinePackage(str, null);
        }
        QLog.i(TAG, 1, "tDoc_step [checkAndUpdateOfflinePackage] result = " + d16);
        return d16;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean checkAndUpdateOfflinePackage4Bid(String str) {
        boolean b16 = ResourcePackageManager.b(str);
        if (!b16) {
            updateOfflinePackage4Bid(str, null);
        }
        QLog.i(TAG, 1, " [checkAndUpdateOfflinePackage] result = " + b16);
        return b16;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean checkAndUpdateSo() {
        boolean z16;
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(ITDocFileBrowserFacade.NATIVE_ENGINE_SO_NAME, new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setIsNoNeedCRC(true).setCloseRetry(true).setCloseReport(true).build());
        if (loadSync != null) {
            String relatedFilesFolder = loadSync.getRelatedFilesFolder();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(relatedFilesFolder);
            String str = File.separator;
            sb5.append(str);
            sb5.append("binding");
            sb5.append(str);
            sb5.append("libbinding.so");
            File file = new File(sb5.toString());
            if (loadSync.isSucc() && file.exists()) {
                QLog.i(TAG, 1, "tDoc_step [checkSoReady] success path: " + file.getPath());
                z16 = true;
                updateSo(null);
                QLog.i(TAG, 1, "tDoc_step [checkSoReady] result = " + z16);
                return z16;
            }
        }
        z16 = false;
        updateSo(null);
        QLog.i(TAG, 1, "tDoc_step [checkSoReady] result = " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean checkFileExist(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                return true;
            }
        }
        QLog.e(TAG, 1, "checkFileExist filePath = " + str);
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean checkPasswordCode(int i3) {
        if (i3 != 14014 && i3 != 14015) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public MenuTabViewBase.a createMenuItemClickListener(Activity activity, TeamWorkFileImportInfo teamWorkFileImportInfo, INativeEngineFileBrowserWrapper iNativeEngineFileBrowserWrapper, com.tencent.mobileqq.teamwork.menu.ak akVar) {
        return new com.tencent.mobileqq.teamwork.menu.ac(activity, teamWorkFileImportInfo, iNativeEngineFileBrowserWrapper, akVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public INativeEngineFileBrowserWrapper createNativeEngineFileBrowser(Activity activity, String str, int i3, INativeEngineFileBrowserWrapper.OpenMode openMode, OpenDocsPerformanceRecorder openDocsPerformanceRecorder, INativeEngineFileBrowserWrapper.c cVar) {
        return new com.tencent.mobileqq.teamwork.app.i(activity, str, i3, openMode, openDocsPerformanceRecorder, cVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public com.tencent.mobileqq.teamwork.api.b createWebEngineFileBrowser(Context context, String str, OpenDocsPerformanceRecorder openDocsPerformanceRecorder, b.InterfaceC8637b interfaceC8637b) {
        return new com.tencent.mobileqq.teamwork.app.z(context, str, openDocsPerformanceRecorder, interfaceC8637b);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public TDocLocalFileConfigParser.b getConfig() {
        return (TDocLocalFileConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(ITDocFileBrowserFacade.TDOC_FILE_BROWSER_LOAD_CONFIG_KEY);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public int getDocsTypeOfIntValue(String str) {
        char c16;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case 99640:
                if (str.equals(FileReaderHelper.DOC_EXT)) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 110834:
                if (str.equals(FileReaderHelper.PDF_EXT)) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 109403487:
                if (str.equals("sheet")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 109526449:
                if (str.equals(WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                return 0;
            case 1:
                return 6;
            case 2:
                return 1;
            case 3:
                return 4;
            default:
                return -1;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public String getFileDocsType(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replace = FileUtils.getExtension(str).toLowerCase().replace(".", "");
        if (!TextUtils.isEmpty(replace)) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(replace.toLowerCase());
            if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                if (!mimeTypeFromExtension.contains("wordprocessingml") && !mimeTypeFromExtension.contains("msword")) {
                    if (mimeTypeFromExtension.equals(MediaType.APPLICATION_PDF_VALUE)) {
                        str2 = FileReaderHelper.PDF_EXT;
                    } else if (mimeTypeFromExtension.equals("application/vnd.ms-excel") || mimeTypeFromExtension.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") || mimeTypeFromExtension.equals("text/comma-separated-values")) {
                        str2 = "sheet";
                    } else if (mimeTypeFromExtension.equals("application/vnd.ms-powerpoint") || mimeTypeFromExtension.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
                        str2 = WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE;
                    }
                } else {
                    str2 = FileReaderHelper.DOC_EXT;
                }
            }
            if (str2 == null) {
                char c16 = '\uffff';
                switch (replace.hashCode()) {
                    case 98822:
                        if (replace.equals("csv")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case 99640:
                        if (replace.equals(FileReaderHelper.DOC_EXT)) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 110834:
                        if (replace.equals(FileReaderHelper.PDF_EXT)) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 111220:
                        if (replace.equals(FileReaderHelper.PPT_EXT)) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 115312:
                        if (replace.equals(FileReaderHelper.TXT_EXT)) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 118783:
                        if (replace.equals(FileReaderHelper.XLS_EXT)) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case 3088960:
                        if (replace.equals(FileReaderHelper.DOCX_EXT)) {
                            c16 = 6;
                            break;
                        }
                        break;
                    case 3447940:
                        if (replace.equals(FileReaderHelper.PPTX_EXT)) {
                            c16 = 7;
                            break;
                        }
                        break;
                    case 3682393:
                        if (replace.equals(FileReaderHelper.XLSX_EXT)) {
                            c16 = '\b';
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                    case 5:
                    case '\b':
                        str2 = "sheet";
                        break;
                    case 1:
                    case 4:
                    case 6:
                        str2 = FileReaderHelper.DOC_EXT;
                        break;
                    case 2:
                        str2 = FileReaderHelper.PDF_EXT;
                        break;
                    case 3:
                    case 7:
                        str2 = WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE;
                        break;
                }
            }
        }
        QLog.d(TAG, 1, "getFileDocsType = " + str2 + APLogFileUtil.SEPARATOR_LOG + str + "|" + replace);
        return str2;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public String getWebEngineFileLoadUrl(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            String str4 = "https://docs.qq.com/" + str + "/local_edit?title=&globalPadId=" + str3 + "&localFilePath=" + str2 + "&local_edit=1&docType=" + str + "&client=" + WEB_ENGINE_LOAD_URL_CLIENT + "&paged_view=1&md5=" + MD5Utils.encodeFileHexStr(str2);
            QLog.d(TAG, 1, "getWebEngineFileLoadUrl = " + str4);
            return str4;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public WebResourceResponse getWebResourceResp(String str, WebResourceRequest webResourceRequest) {
        WebResourceReq webResourceReq;
        if (webResourceRequest == null) {
            webResourceReq = new WebResourceReq(null, null, null, null, null, null);
        } else {
            webResourceReq = new WebResourceReq(webResourceRequest.getUrl(), Boolean.valueOf(webResourceRequest.isForMainFrame()), Boolean.valueOf(webResourceRequest.isRedirect()), Boolean.valueOf(webResourceRequest.hasGesture()), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
        }
        WebResourceResp h16 = com.tencent.mobileqq.teamwork.app.e.h(str, webResourceReq);
        if (h16 != null) {
            return new WebResourceResponse(h16.getMimeType(), h16.getEncoding(), h16.getStatusCode(), h16.getReasonPhrase(), h16.getResponseHeaders(), h16.getInputStream());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public synchronized void initLocalEditSDK(Context context) {
        if (this.initialized) {
            QLog.i(TAG, 1, "already init local edit sdk");
            return;
        }
        LocalEditSDK localEditSDK = LocalEditSDK.INSTANCE;
        localEditSDK.init(context, new com.tencent.localedit.c(new HashMap(), 30), new b(), new x11.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.s
            @Override // x11.d
            public final void a(String str, JSONObject jSONObject, int i3, int i16) {
                TDocFileBrowserFacadeImpl.lambda$initLocalEditSDK$4(str, jSONObject, i3, i16);
            }
        });
        localEditSDK.packageManager.i(new com.tencent.mobileqq.teamwork.app.m());
        this.initialized = true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public void initWebEngine() {
        ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initLocalEditSDK(MobileQQ.sMobileQQ);
        startServer();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean isAllResourceReady(String str) {
        QLog.i(TAG, 1, "tDoc_step [checkAndUpdateResource] start docsType :" + str);
        if (isNativeSupportDocsType(str)) {
            QLog.i(TAG, 1, "tDoc_step [checkAndUpdateResource] load native engine so");
            return true;
        }
        if (!isWebEngineEnable(str)) {
            QLog.i(TAG, 1, "tDoc_step [checkAndUpdateResource] isWebEngineEnable false");
            return false;
        }
        return checkAndUpdateOfflinePackage(str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean isBottomMenuEnable() {
        TDocLocalFileConfigParser.b config = getConfig();
        if (config == null) {
            return false;
        }
        return config.G;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean isNativeSupportDocsType(String str) {
        TDocLocalFileConfigParser.b config = getConfig();
        if (config == null || TextUtils.isEmpty(str) || !config.f291511e || !config.D.contains(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean isTDocPreviewEnable(String str) {
        TDocLocalFileConfigParser.b config = getConfig();
        if (config != null && config.f291510d && config.C.contains(str) && (!config.f291514i || checkAndUpdateSo())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public boolean isWebEngineEnable(String str) {
        TDocLocalFileConfigParser.b config = getConfig();
        if (config == null || TextUtils.isEmpty(str) || !config.f291512f || !config.E.contains(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public void updateOfflinePackage(final String str, final ITDocFileBrowserFacade.a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.r
            @Override // java.lang.Runnable
            public final void run() {
                TDocFileBrowserFacadeImpl.lambda$updateOfflinePackage$3(str, aVar);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public void updateOfflinePackage4Bid(String str, ITDocFileBrowserFacade.a aVar) {
        ResourcePackageManager.j(str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade
    public void updateSo(final ITDocFileBrowserFacade.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        SoLoadManager.getInstance().download(ITDocFileBrowserFacade.NATIVE_ENGINE_SO_NAME, new OnLoadListener() { // from class: com.tencent.mobileqq.teamwork.api.impl.o
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                TDocFileBrowserFacadeImpl.this.lambda$updateSo$1(aVar, currentTimeMillis, i3, loadExtResult);
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements x11.c {
        b() {
        }

        @Override // x11.c
        public void d(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TDocFileBrowserFacadeImpl.TAG, 2, str + " | tDoc_local_edit \uff5c " + str2);
            }
        }

        @Override // x11.c
        public void e(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.e(TDocFileBrowserFacadeImpl.TAG, 2, str + " | tDoc_local_edit \uff5c " + str2);
            }
        }

        @Override // x11.c
        public void i(@Nullable String str, @Nullable String str2) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TDocFileBrowserFacadeImpl.TAG, 2, str + " | tDoc_local_edit \uff5c " + str2);
            }
        }

        @Override // x11.c
        public void e(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.e(TDocFileBrowserFacadeImpl.TAG, 2, str + " | tDoc_local_edit \uff5c " + str2, th5);
            }
        }
    }
}
