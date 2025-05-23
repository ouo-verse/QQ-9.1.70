package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.bf.l0;
import com.tencent.luggage.wxa.of.a;
import com.tencent.luggage.wxa.qf.a;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.JSONObjectFix;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.SecurityUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.MiniGameStorageExceedManager;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.BrotliUtil;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import com.tencent.qqmini.sdk.utils.MiniLog;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class FileJsPlugin extends BaseJsPlugin {
    private static final String BR_CACHE_ROOT = "minigame_brotli";
    private static final String ENCODING_ARRAYBUFFER_ = "__internal__array_buffer";
    private static final String ERR_ACCESS_NO_FILE = "no such file or directory ";
    private static final String ERR_CONTEXT_ERROR = "invalid context";
    private static final String ERR_FILE_ALREADY_EXIST = "file already exists ";
    private static final String ERR_FILE_IS_LARGER_THAN_100M = "file is larger than 100M";
    private static final String ERR_INVALID_DATA = "invalid data ";
    private static final String ERR_INVALID_ENCODE = "invalid encoding ";
    private static final String ERR_INVALID_PATH = "invalid path";
    private static final String ERR_NOT_DIR = "not a directory ";
    private static final String ERR_NOT_STORE_FILE_PATH = "not a store filePath";
    private static final String ERR_NO_SUCH_FILE = "no such file or directory, open ";
    private static final String ERR_PARAMS_DIR_PATH_IS_NULL = "fail parameter error: parameter.dirPath should be String instead of Null;";
    private static final String ERR_PERMISSION_DENIED = "permission denied, open ";
    private static final String ERR_READ_ZIP_DATA = "read zip data";
    private static final String ERR_STORAGE_EXCEEDED = "the maximum size of the file storage is exceeded";
    private static final String ERR_TEMP_FILE_NOT_EXIST = "tempFilePath file not exist";
    private static final String ERR_UNLINK_OPERATION_BAN = "operation not permitted, unlink ";
    private static final String ERR_WRITEFILE_ERROR = "failed to write file";
    private static final String TAG = "FileJsPlugin";
    private static final long UPPER_FILE_LIMIT_SIZE = 104857600;
    private static final Set<String> sSupportEncodingRead = new HashSet<String>() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.1
        {
            add("binary");
            add("hex");
            add("base64");
            add(FileJsPlugin.ENCODING_ARRAYBUFFER_);
        }
    };
    private static int shouldReport = -1;
    private MiniAppFileManager fileManager;
    public int curPreloadTaskId = 0;
    private final AtomicInteger downloadTaskId = new AtomicInteger(0);
    private final ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, String> uploadMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public interface FileTask {
        String run();
    }

    private void callbackDownloadFailed(String str, RequestEvent requestEvent, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            this.downloadMap.remove(str);
            jSONObject.put("downloadTaskId", str);
            jSONObject.put("state", "fail");
            jSONObject.put("errMsg", "Download Failed.");
            requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject.toString(), 0);
        } catch (JSONException unused) {
            QMLog.e(TAG, "download onDownloadSucceed callback fail exception.", exc);
        }
    }

    private void checkUsrFileSize(int i3) throws IOException {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext == null) {
            QMLog.w(TAG, "checkUsrFileSize context is null");
        } else if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isFolderCanWrite(2, i3, this.mIsMiniGame, this.mMiniAppInfo, iMiniAppContext.getAttachActivity(), iMiniAppContext)) {
        } else {
            throw new IOException(ERR_STORAGE_EXCEEDED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnDownloadHeadersReceived(Map<String, List<String>> map, String str, RequestEvent requestEvent) {
        new JSONObject();
        try {
            JSONObject headerToJson = JSONUtil.headerToJson(map);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadTaskId", str);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, 200);
            jSONObject.put("header", headerToJson);
            jSONObject.put("state", "headersReceived");
            requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject.toString(), 0);
        } catch (Exception e16) {
            QMLog.e(TAG, "onDownloadSucceed headerJson error." + e16);
        }
    }

    private int doUpload(final RequestEvent requestEvent, final long j3, JSONObject jSONObject, final String str, String str2, String str3, String str4, final File file, final boolean z16) {
        final int i3 = requestEvent.callbackId;
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("formData");
        String str5 = "";
        if (!TextUtils.isEmpty(str2)) {
            str5 = str2.replace("wxfile://", "");
        }
        HashMap<String, String> json2map = StringUtil.json2map(optJSONObject);
        json2map.put("Referer", getRequestReferer());
        HashMap<String, String> json2map2 = StringUtil.json2map(optJSONObject2);
        ((UploaderProxy) ProxyManager.get(UploaderProxy.class)).upload(str, json2map, str4, str3, str5, json2map2, 60, new UploaderProxy.UploadListener() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.4
            private void reportUploadResult(RequestEvent requestEvent2, long j16, int i16) {
                String str6;
                if (((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame) {
                    str6 = "1";
                } else {
                    str6 = "0";
                }
                MiniReportManager.reportEventType(((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, 641, null, null, null, i16, str6, j16, null);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener
            public void onUploadFailed(int i16, String str6) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("uploadTaskId", i3);
                    jSONObject2.put("state", "fail");
                    jSONObject2.put("errMsg", MiniappHttpUtil.convertCode2Reason("uploadFile", i16));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                long currentTimeMillis = System.currentTimeMillis() - j3;
                reportUploadResult(requestEvent, currentTimeMillis, i16);
                com.tencent.qqmini.sdk.report.a.d(((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, JobDbManager.TBL_UPLOAD, str, i16, file.length(), currentTimeMillis);
                requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject2.toString(), 0);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener
            public void onUploadHeadersReceived(int i16, Map<String, List<String>> map) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("uploadTaskId", i3);
                    jSONObject2.put("header", map);
                    jSONObject2.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i16);
                    jSONObject2.put("state", "headersReceived");
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject2.toString(), 0);
                } catch (Exception unused) {
                    QMLog.e(FileJsPlugin.TAG, "httpUpload--headersReceived fail---");
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener
            public void onUploadProgress(float f16, long j16, long j17) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("uploadTaskId", i3);
                    jSONObject2.put("totalBytesWritten", j16);
                    jSONObject2.put("totalBytesExpectedWrite", j17);
                    jSONObject2.put("totalBytesSent", j16);
                    jSONObject2.put("totalBytesExpectedToSend", j17);
                    jSONObject2.put("progress", f16);
                    jSONObject2.put("state", "progressUpdate");
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject2.toString(), 0);
                } catch (Exception e16) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("uploadTaskId", i3);
                        jSONObject3.put("state", "fail");
                        jSONObject3.put("errMsg", e16.getMessage());
                        requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject3.toString(), 0);
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener
            public void onUploadSucceed(int i16, byte[] bArr, Map<String, List<String>> map) {
                String str6;
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("uploadTaskId", i3);
                    jSONObject2.put("progress", 100);
                    jSONObject2.put("totalBytesSent", file.length());
                    jSONObject2.put("totalBytesExpectedToSend", file.length());
                    jSONObject2.put("state", "progressUpdate");
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject2.toString(), 0);
                    if (bArr == null) {
                        str6 = "";
                    } else {
                        str6 = new String(bArr, "utf-8");
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", str6);
                    jSONObject3.put("uploadTaskId", i3);
                    jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i16);
                    jSONObject3.put("state", "success");
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject3.toString(), 0);
                } catch (Exception unused) {
                    QMLog.e(FileJsPlugin.TAG, "httpUpload--onUploadSucceed fail---");
                }
                reportUploadResult(requestEvent, System.currentTimeMillis() - j3, i16);
                if (z16) {
                    com.tencent.qqmini.sdk.report.a.g(((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, JobDbManager.TBL_UPLOAD, str, file.length(), System.currentTimeMillis() - j3);
                }
            }
        });
        return i3;
    }

    private String execFileTask(String str, final FileTask fileTask) {
        if (str.endsWith("Sync")) {
            return fileTask.run();
        }
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.19
            @Override // java.lang.Runnable
            public void run() {
                fileTask.run();
            }
        });
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0105 -> B:30:0x0148). Please report as a decompilation issue!!! */
    public void executeDownloadTask(RequestEvent requestEvent, String str) {
        String str2;
        String str3;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            ((RequestStrategyProxy) ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(jSONObject);
            String optString = jSONObject.optString("url");
            if (jSONObject.has("origin_url")) {
                str2 = jSONObject.optString("origin_url");
            } else {
                str2 = optString;
            }
            boolean optBoolean = jSONObject.optBoolean("__skipDomainCheck__", false);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext == null) {
                QMLog.w(TAG, "createDownloadTask context is null");
                onFileDownloadFail(requestEvent, str, ERR_CONTEXT_ERROR);
                return;
            }
            MiniAppFileManager miniAppFileManager = (MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class);
            String usrPath = miniAppFileManager.getUsrPath(jSONObject.optString("filePath"));
            boolean f16 = com.tencent.qqmini.sdk.report.a.f(this.mMiniAppInfo, getFileDownloadTypeName(), optString);
            if (TextUtils.isEmpty(optString)) {
                QMLog.e(TAG, "download url is null");
                com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, getFileDownloadTypeName(), optString, "download url is null");
                onFileDownloadFail(requestEvent, str, "download url is null.");
                return;
            }
            int i3 = 2;
            if (!DomainUtil.isDomainValid(this.mMiniAppInfo, optBoolean, str2, 2)) {
                String str4 = "download url Domain not configured." + str2;
                QMLog.e(TAG, str4);
                com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, getFileDownloadTypeName(), optString, str4);
                onFileDownloadFail(requestEvent, str, "Domain not configured.");
                return;
            }
            if (TextUtils.isEmpty(usrPath)) {
                i3 = 0;
            }
            if (TextUtils.isEmpty(usrPath)) {
                str3 = miniAppFileManager.getTmpPathByUrl(optString);
            } else {
                str3 = usrPath;
            }
            try {
                if (!TextUtils.isEmpty(str3)) {
                    String downloadUrl = getDownloadUrl(optString);
                    this.downloadMap.put(str, downloadUrl);
                    HashMap<String, String> json2map = StringUtil.json2map(optJSONObject);
                    json2map.put("Referer", getRequestReferer());
                    doDownload(requestEvent, jSONObject, str, miniAppFileManager, usrPath, i3, str3, json2map, downloadUrl, f16);
                } else {
                    QMLog.e(TAG, "download failed, savepath is null.");
                    com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, getFileDownloadTypeName(), optString, "download failed, savepath is null.");
                    onFileDownloadFail(requestEvent, str, "Download Failed, savepath is null");
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "download failed." + e16);
            }
        } catch (JSONException e17) {
            String str5 = "Json data:" + requestEvent.jsonParams + " exception:" + e17;
            QMLog.e(TAG, str5);
            com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, getFileDownloadTypeName(), "", str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFileDownloadTypeName() {
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy == null || wnsConfigProxy.getMiniFileDownloadType() < 3) {
            return "download";
        }
        return "download_okhttp";
    }

    public static String getOutFilePath(DownloaderProxy.DownloadListener.DownloadResult downloadResult, String str) {
        String str2;
        try {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            if (TextUtils.isEmpty(fileExtensionFromUrl)) {
                List<String> list = downloadResult.headers.get("Content-Type");
                if (list != null && list.size() > 0) {
                    str2 = list.get(0);
                } else {
                    str2 = "";
                }
                if (!TextUtils.isEmpty(str2)) {
                    String[] split = str2.trim().split("/");
                    if (split.length > 1 && "image".equalsIgnoreCase(split[0])) {
                        String string = getString(fileExtensionFromUrl, split[1]);
                        if (!TextUtils.isEmpty(string)) {
                            String str3 = str + "." + string;
                            if (FileUtils.copyFile(str, str3)) {
                                FileUtils.deleteFile(str);
                                return str3;
                            }
                            return str;
                        }
                        return str;
                    }
                    return str;
                }
                return str;
            }
            return str;
        } catch (Throwable th5) {
            QMLog.e(TAG, "create file extension failed! " + th5);
            return str;
        }
    }

    private String getRequestReferer() {
        String str;
        String str2;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
            str2 = miniAppInfo.version;
            if (miniAppInfo.verType != 3) {
                str2 = "0";
            }
        } else {
            str = "";
            str2 = "debug";
        }
        if (!MiniappHttpUtil.isRefererVersionValid(str2)) {
            str2 = "invalidVersion";
        }
        return "https://appservice.qq.com/" + str + "/" + str2 + "/page-frame.html";
    }

    private static String getString(String str, String str2) {
        if (MimeHelper.IMAGE_SUBTYPE_JPEG.equalsIgnoreCase(str2)) {
            return "jpg";
        }
        String str3 = "png";
        if (!"png".equalsIgnoreCase(str2)) {
            str3 = "gif";
            if (!"gif".equalsIgnoreCase(str2)) {
                if ("svg+xml".equalsIgnoreCase(str2)) {
                    return "svg";
                }
                str3 = "webp";
                if (!"webp".equalsIgnoreCase(str2)) {
                    return str;
                }
            }
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String handleCallbackFail(RequestEvent requestEvent, JSONObject jSONObject, String str) {
        if (!requestEvent.event.endsWith("Sync")) {
            requestEvent.fail(jSONObject, str);
            return "";
        }
        return ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, str).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String handleCallbackOK(RequestEvent requestEvent, JSONObject jSONObject) {
        if (!requestEvent.event.endsWith("Sync")) {
            requestEvent.ok(jSONObject);
            return "";
        }
        return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEncodingSupport(String str) {
        try {
            if (sSupportEncodingRead.contains(str)) {
                return true;
            }
            return Charset.isSupported(str);
        } catch (Throwable th5) {
            QMLog.e(TAG, "isEncodingSupport exception,e:" + th5.getMessage(), th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEventFinish(final String str, final boolean z16, long j3, long j16, String str2) {
        int i3;
        final long j17 = j16 - j3;
        final long currentTimeMillis = System.currentTimeMillis() - j16;
        if (!this.mIsMiniGame) {
            return;
        }
        if (shouldReport < 0) {
            if (new Random(System.currentTimeMillis()).nextInt(100) < 10) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            shouldReport = i3;
        }
        if (shouldReport == 0) {
            return;
        }
        ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.20
            @Override // java.lang.Runnable
            public void run() {
                MiniGamePerformanceStatics.getInstance().recordFileApiTimeCost(str, z16, j17, currentTimeMillis);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFileDownloadFail(RequestEvent requestEvent, String str, String str2) {
        try {
            this.downloadMap.remove(str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadTaskId", str);
            jSONObject.put("state", "fail");
            jSONObject.put("errMsg", "Download Failed." + str2);
            requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject.toString(), 0);
        } catch (Exception e16) {
            QMLog.e(TAG, "download onDownloadFailed failed." + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFileDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult, String str2, MiniAppFileManager miniAppFileManager, int i16, String str3, RequestEvent requestEvent, JSONObject jSONObject, String str4, long j3, String str5, boolean z16) {
        long j16;
        long j17;
        String outFilePath;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        try {
        } catch (Exception e16) {
            e = e16;
            j16 = 0;
        }
        if (!TextUtils.isEmpty(str2)) {
            File retryCopyFile = retryCopyFile(str, str2, new File(str2));
            if (retryCopyFile.exists() && retryCopyFile.canRead()) {
                long length = retryCopyFile.length();
                try {
                    outFilePath = getOutFilePath(downloadResult, str2);
                    miniAppFileManager.updateFolderSize(i16, length);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("downloadTaskId", str3);
                    jSONObject4.put("progress", 100);
                    jSONObject4.put("totalBytesWritten", length);
                    jSONObject4.put("totalBytesExpectedToWrite", length);
                    jSONObject4.put("state", "progressUpdate");
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject4.toString(), 0);
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject2 = JSONUtil.headerToJson(downloadResult.headers);
                    } catch (Exception e17) {
                        QMLog.e(TAG, "onDownloadSucceed headerJson error." + e17);
                        jSONObject2 = jSONObject5;
                    }
                    this.downloadMap.remove(str3);
                    jSONObject3 = new JSONObject();
                    j17 = length;
                    try {
                        jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, 200);
                        jSONObject3.put("downloadTaskId", str3);
                    } catch (Exception e18) {
                        e = e18;
                        j16 = j17;
                        QMLog.e(TAG, "download onDownloadSucceed exception.", e);
                        callbackDownloadFailed(str3, requestEvent, e);
                        long currentTimeMillis = System.currentTimeMillis() - j3;
                        reportDownloadFileResult(currentTimeMillis, i3);
                        MiniProgramLpReportDC05115.reportDownloadResult(this.mMiniAppInfo, 0, currentTimeMillis, false);
                        MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, str5, currentTimeMillis, i3, 0);
                        if (z16) {
                        }
                    }
                } catch (Exception e19) {
                    e = e19;
                    j17 = length;
                }
                if (!jSONObject.isNull("filePath") && !TextUtils.isEmpty(jSONObject.optString("filePath"))) {
                    jSONObject3.put("filePath", jSONObject.optString("filePath"));
                    jSONObject3.put("header", jSONObject2);
                    jSONObject3.put("state", "success");
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject3.toString(), 0);
                    j16 = j17;
                    long currentTimeMillis2 = System.currentTimeMillis() - j3;
                    reportDownloadFileResult(currentTimeMillis2, i3);
                    MiniProgramLpReportDC05115.reportDownloadResult(this.mMiniAppInfo, 0, currentTimeMillis2, false);
                    MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, str5, currentTimeMillis2, i3, 0);
                    if (z16) {
                        return;
                    }
                    com.tencent.qqmini.sdk.report.a.g(this.mMiniAppInfo, getFileDownloadTypeName(), str5, j16, currentTimeMillis2);
                    return;
                }
                jSONObject3.put("tempFilePath", miniAppFileManager.getWxFilePath(outFilePath));
                jSONObject3.put("header", jSONObject2);
                jSONObject3.put("state", "success");
                requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject3.toString(), 0);
                j16 = j17;
                long currentTimeMillis22 = System.currentTimeMillis() - j3;
                reportDownloadFileResult(currentTimeMillis22, i3);
                MiniProgramLpReportDC05115.reportDownloadResult(this.mMiniAppInfo, 0, currentTimeMillis22, false);
                MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, str5, currentTimeMillis22, i3, 0);
                if (z16) {
                }
            } else {
                QMLog.d(TAG, "download failed, filepath not exists, tmpFile:" + str4);
                this.downloadMap.remove(str3);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("downloadTaskId", str3);
                jSONObject6.put("state", "fail");
                jSONObject6.put("errMsg", "Download Failed: file not exists or can not read.");
                requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject6.toString(), 0);
            }
        }
        j16 = 0;
        long currentTimeMillis222 = System.currentTimeMillis() - j3;
        reportDownloadFileResult(currentTimeMillis222, i3);
        MiniProgramLpReportDC05115.reportDownloadResult(this.mMiniAppInfo, 0, currentTimeMillis222, false);
        MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, str5, currentTimeMillis222, i3, 0);
        if (z16) {
        }
    }

    private static Object readFileByEncoding(String str, String str2) {
        byte[] fileToBytes = FileUtils.fileToBytes(new File(str2));
        if (fileToBytes == null) {
            return null;
        }
        if ("base64".equals(str)) {
            return Base64.encodeToString(fileToBytes, 2);
        }
        if ("binary".equals(str)) {
            return StringUtil.to8BitAsciiString(fileToBytes);
        }
        if ("hex".equals(str)) {
            return StringUtil.toHexString(new String(fileToBytes));
        }
        if (ENCODING_ARRAYBUFFER_.equals(str)) {
            return fileToBytes;
        }
        try {
            return Charset.forName(str).decode(ByteBuffer.wrap(fileToBytes));
        } catch (Throwable th5) {
            QMLog.e(TAG, "read file err", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a readFileSync(RequestEvent requestEvent) {
        String str;
        JSONObjectFix jSONObjectFix;
        String str2 = ENCODING_ARRAYBUFFER_;
        String str3 = null;
        try {
            jSONObjectFix = new JSONObjectFix(requestEvent.jsonParams);
            str = jSONObjectFix.optString("filePath");
        } catch (JSONException e16) {
            e = e16;
            str = null;
        }
        try {
            String optString = jSONObjectFix.optString("encoding", ENCODING_ARRAYBUFFER_);
            if (!TextUtils.isEmpty(optString)) {
                str2 = optString;
            }
            str3 = str2;
        } catch (JSONException e17) {
            e = e17;
            QMLog.e(TAG, "readFileSync: parse json params failed, params=" + requestEvent.jsonParams, e);
            if (!TextUtils.isEmpty(str)) {
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return new a(ERR_INVALID_PATH);
        }
        if (!isEncodingSupport(str3)) {
            return new a(ERR_INVALID_ENCODE + str3);
        }
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext == null) {
            return new a(ERR_CONTEXT_ERROR);
        }
        String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        if (!new File(absolutePath).exists()) {
            return new a(ERR_NO_SUCH_FILE + str);
        }
        if (FileUtils.getFileOrFolderSize(absolutePath) > 104857600) {
            return new a(ERR_FILE_IS_LARGER_THAN_100M + str);
        }
        Object readFileByEncoding = readFileByEncoding(str3, absolutePath);
        if (readFileByEncoding == null) {
            return new a(ERR_NO_SUCH_FILE + str);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            boolean z16 = this.mIsMiniGame;
            if (z16 && (readFileByEncoding instanceof byte[])) {
                NativeBuffer.packNativeBuffer(requestEvent.jsService, (byte[]) readFileByEncoding, NativeBuffer.TYPE_BUFFER_NATIVE, "data", jSONObject);
            } else if (!z16 && (readFileByEncoding instanceof byte[])) {
                NativeBuffer.packNativeBuffer(requestEvent.jsService, (byte[]) readFileByEncoding, NativeBuffer.TYPE_BUFFER_BASE64, "data", jSONObject);
            } else {
                jSONObject.put("data", readFileByEncoding);
            }
            return new a(jSONObject);
        } catch (JSONException e18) {
            QMLog.e(TAG, "readFileSync: wrap data failed.", e18);
            return new a(ERR_NO_SUCH_FILE + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDownloadFileResult(long j3, int i3) {
        String str;
        if (this.mIsMiniGame) {
            str = "1";
        } else {
            str = "0";
        }
        MiniReportManager.reportEventType(this.mMiniAppInfo, 640, null, null, null, i3, str, j3, null);
    }

    @NotNull
    private File retryCopyFile(String str, String str2, File file) {
        Throwable th5;
        File file2;
        File file3;
        if (!file.exists() && !TextUtils.isEmpty(str)) {
            try {
                file3 = new File(str);
            } catch (Throwable th6) {
                th5 = th6;
                file2 = file;
            }
            if (file3.exists() && file3.isFile() && file3.length() > 0) {
                QMLog.w(TAG, "download Succeed but target file not exists, try copy from download tmp file:" + str + ", length:" + file3.length() + ", to:" + str2);
                file2 = FileUtils.createFile(str2);
                try {
                    if (FileUtils.copyFile(file3, file2) && file2.exists() && file2.length() == file3.length()) {
                        QMLog.i(TAG, "copy from download tmp file:" + str + " success");
                    } else if (file2.exists()) {
                        file2.delete();
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    QMLog.e(TAG, "try copy from download tmp file exception! tmp file:" + str, th5);
                    return file2;
                }
                return file2;
            }
            return file;
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String writeUsrFile(long j3, String str, byte[] bArr, String str2, String str3, RequestEvent requestEvent, long j16) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext == null) {
            QMLog.w(TAG, "writeUsrFile done but context is null");
            return "";
        }
        String usrPath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(str);
        if (!TextUtils.isEmpty(usrPath)) {
            try {
                if (!writeUsrFile(bArr, str2, str3, usrPath, false)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("writeFile failed! path:");
                    sb5.append(usrPath);
                    sb5.append(",encoding:");
                    sb5.append(str3);
                    sb5.append(",nativeBufferBytes:");
                    sb5.append(bArr != null ? Integer.valueOf(bArr.length) : "0");
                    sb5.append(",data:");
                    sb5.append(str2 != null ? Integer.valueOf(str2.length()) : "null");
                    QMLog.e(TAG, sb5.toString());
                    onEventFinish(requestEvent.event, false, j16, j3, usrPath);
                    return handleCallbackFail(requestEvent, null, ERR_WRITEFILE_ERROR + usrPath);
                }
                onEventFinish(requestEvent.event, true, j16, j3, usrPath);
                return handleCallbackOK(requestEvent, null);
            } catch (IOException e16) {
                onEventFinish(requestEvent.event, false, j16, j3, usrPath);
                return handleCallbackFail(requestEvent, null, e16.getMessage());
            }
        }
        onEventFinish(requestEvent.event, false, j16, j3, usrPath);
        return handleCallbackFail(requestEvent, null, ERR_STORAGE_EXCEEDED);
    }

    @JsEvent({"access", "accessSync"})
    public String access(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.5
            @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
            public String run() {
                String optString;
                IMiniAppContext iMiniAppContext;
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    optString = new JSONObject(requestEvent.jsonParams).optString("path");
                    iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                } catch (JSONException e16) {
                    QMLog.e(FileJsPlugin.TAG, "access execFileTask throw:", e16);
                }
                if (iMiniAppContext == null) {
                    QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                    return "";
                }
                MiniAppFileManager miniAppFileManager = (MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class);
                if (miniAppFileManager != null) {
                    String absolutePath = miniAppFileManager.getAbsolutePath(optString);
                    if (!TextUtils.isEmpty(absolutePath) && new File(absolutePath).exists()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                    }
                    FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                    return FileJsPlugin.this.handleCallbackFail(requestEvent, null, "no such file or directory \"" + optString + "\"");
                }
                return "";
            }
        });
    }

    @JsEvent({"fs_appendFile", "fs_appendFileSync"})
    public String appendFile(final RequestEvent requestEvent) {
        byte[] bArr;
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObjectFix jSONObjectFix = new JSONObjectFix(requestEvent.jsonParams);
            final String optString = jSONObjectFix.optString("filePath");
            final String optString2 = jSONObjectFix.optString("data");
            final String optString3 = jSONObjectFix.optString("encoding", "utf8");
            NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(requestEvent.jsService, jSONObjectFix, "data");
            if (unpackNativeBuffer != null) {
                bArr = unpackNativeBuffer.buf;
            } else {
                bArr = null;
            }
            final byte[] bArr2 = bArr;
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.6
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!FileJsPlugin.isEncodingSupport(optString3)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_ENCODE + optString3);
                    }
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    MiniAppFileManager miniAppFileManager = (MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class);
                    if (miniAppFileManager != null && miniAppFileManager.getWxFileType(optString) != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    String usrPath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(optString);
                    if (!TextUtils.isEmpty(usrPath)) {
                        if (usrPath.contains("miniprogramLog")) {
                            MiniLog.writeMiniLog(((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo.appId, optString2);
                            FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, usrPath);
                            return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                        }
                        try {
                            if (FileJsPlugin.this.writeUsrFile(bArr2, optString2, optString3, usrPath, true)) {
                                FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, usrPath);
                                return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                            }
                        } catch (IOException e16) {
                            FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, usrPath);
                            return FileJsPlugin.this.handleCallbackFail(requestEvent, null, e16.getMessage());
                        }
                    }
                    FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                    return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "{}";
        }
    }

    @JsEvent({"fs_copyFile", "fs_copyFileSync"})
    public String copyFile(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("srcPath");
            final String optString2 = jSONObject.optString("destPath");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.8
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString) == 9999 && !((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isPackageRelativePath(optString)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString2) != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    String usrPath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(optString2);
                    long fileSizes = FileUtils.getFileSizes(absolutePath);
                    if (!((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isFolderCanWrite(2, fileSizes, ((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame, ((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, iMiniAppContext.getAttachActivity(), iMiniAppContext)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_STORAGE_EXCEEDED);
                    }
                    if (TextUtils.isEmpty(absolutePath) || TextUtils.isEmpty(usrPath)) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE);
                    }
                    boolean copyFile = FileUtils.copyFile(absolutePath, usrPath);
                    FileJsPlugin.this.onEventFinish(requestEvent.event, copyFile, currentTimeMillis, currentTimeMillis2, absolutePath);
                    if (!copyFile) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED);
                    }
                    FileJsPlugin.this.fileManager.updateFolderSize(2, fileSizes);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({com.tencent.luggage.wxa.of.b.NAME})
    public String createDownloadTask(final RequestEvent requestEvent) {
        final String valueOf = String.valueOf(this.downloadTaskId.getAndIncrement());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("downloadTaskId", valueOf);
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " return error.", e16);
        }
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                FileJsPlugin.this.executeDownloadTask(requestEvent, valueOf);
            }
        });
        return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
    }

    @JsEvent({"createFileSystemInstance"})
    public String createFileSystemInstance(RequestEvent requestEvent) {
        return "{}";
    }

    @JsEvent({com.tencent.luggage.wxa.qf.b.NAME})
    public String createUploadTask(RequestEvent requestEvent) {
        String str;
        String str2;
        String str3;
        String str4;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            ((RequestStrategyProxy) ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(jSONObject);
            String optString = jSONObject.optString("url");
            if (jSONObject.has("origin_url")) {
                str4 = jSONObject.optString("origin_url");
            } else {
                str4 = optString;
            }
            boolean optBoolean = jSONObject.optBoolean("__skipDomainCheck__", false);
            String optString2 = jSONObject.optString("filePath");
            String optString3 = jSONObject.optString("name");
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext == null) {
                QMLog.w(TAG, "createUploadTask context is null");
                return "";
            }
            String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString2);
            File file = new File(absolutePath);
            boolean f16 = com.tencent.qqmini.sdk.report.a.f(this.mMiniAppInfo, JobDbManager.TBL_UPLOAD, optString);
            if (TextUtils.isEmpty(optString)) {
                QMLog.w(TAG, "upload url is empty.");
                com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, JobDbManager.TBL_UPLOAD, optString, "upload url is empty.");
                return ApiUtil.wrapCallbackFail(requestEvent.event, null, "upload url is empty.").toString();
            }
            if (!DomainUtil.isDomainValid(this.mMiniAppInfo, optBoolean, str4, 3)) {
                QMLog.w(TAG, "url not in domain list, \u8bf7\u6c42\u57df\u540d\u4e0d\u5408\u6cd5");
                com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, JobDbManager.TBL_UPLOAD, optString, "url not in domain list, \u8bf7\u6c42\u57df\u540d\u4e0d\u5408\u6cd5");
                return ApiUtil.wrapCallbackFail(requestEvent.event, null, "url not in domain list, \u8bf7\u6c42\u57df\u540d\u4e0d\u5408\u6cd5").toString();
            }
            if (TextUtils.isEmpty(absolutePath)) {
                QMLog.w(TAG, "upload file path is empty.");
                com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, JobDbManager.TBL_UPLOAD, optString, "upload file path is empty.");
                return ApiUtil.wrapCallbackFail(requestEvent.event, null, "upload file path is empty.").toString();
            }
            if (!TextUtils.isEmpty(optString3)) {
                str = "";
                str2 = JobDbManager.TBL_UPLOAD;
                str3 = TAG;
                try {
                    int doUpload = doUpload(requestEvent, currentTimeMillis, jSONObject, optString, optString2, optString3, absolutePath, file, f16);
                    this.uploadMap.put(Integer.valueOf(doUpload), optString);
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("uploadTaskId", doUpload);
                        return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject2).toString();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        QMLog.e(str3, requestEvent.event + " return error.", th5);
                        return str;
                    }
                } catch (JSONException e16) {
                    e = e16;
                    String str5 = "event:" + requestEvent.event + " params:" + requestEvent.jsonParams + " error:" + e;
                    QMLog.e(str3, str5);
                    String str6 = str;
                    com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, str2, str6, str5);
                    return str6;
                }
            }
            QMLog.w(TAG, "upload file name is empty.");
            com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, JobDbManager.TBL_UPLOAD, optString, "upload file name is empty.");
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "upload file name is empty.").toString();
        } catch (JSONException e17) {
            e = e17;
            str = "";
            str2 = JobDbManager.TBL_UPLOAD;
            str3 = TAG;
        }
    }

    public void doDownload(final RequestEvent requestEvent, final JSONObject jSONObject, final String str, final MiniAppFileManager miniAppFileManager, final String str2, final int i3, final String str3, Map map, final String str4, final boolean z16) {
        final long currentTimeMillis = System.currentTimeMillis();
        ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).download(str4, map, str3, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i16, String str5) {
                QMLog.d(FileJsPlugin.TAG, "download failed! [minigame timecost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
                FileJsPlugin.this.onFileDownloadFail(requestEvent, str, str5);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                FileJsPlugin.this.reportDownloadFileResult(currentTimeMillis2, i16);
                MiniProgramLpReportDC05115.reportDownloadResult(((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, 0, currentTimeMillis2, true);
                MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, str4, currentTimeMillis2, i16, 0);
                com.tencent.qqmini.sdk.report.a.d(((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, FileJsPlugin.this.getFileDownloadTypeName(), str4, i16, 0L, currentTimeMillis2);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i16, Map<String, List<String>> map2) {
                FileJsPlugin.this.doOnDownloadHeadersReceived(map2, str, requestEvent);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
                if (((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame && f16 < 1.0f && !FileJsPlugin.this.isRuntimeForeground()) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("downloadTaskId", str);
                    jSONObject2.put("progress", (int) (f16 * 100.0f));
                    jSONObject2.put("totalBytesWritten", j3);
                    jSONObject2.put("totalBytesExpectedToWrite", j16);
                    jSONObject2.put("state", "progressUpdate");
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject2.toString(), 0);
                } catch (Throwable th5) {
                    QMLog.e(FileJsPlugin.TAG, "download onDownloadProgress failed." + th5);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i16, String str5, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                QMLog.d(FileJsPlugin.TAG, "download Succeed! [minigame downloadTaskId:" + str + ", timecost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms] isReport:" + z16 + ",filePath=" + str3);
                FileJsPlugin.this.onFileDownloadSucceed(i16, str5, downloadResult, str3, miniAppFileManager, i3, str, requestEvent, jSONObject, str2, currentTimeMillis, str4, z16);
            }
        });
    }

    public String getDownloadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf, str.length());
            if (substring2.contains("|")) {
                substring2 = substring2.replace("|", "%7C");
            }
            str = substring + substring2;
        }
        return str.replace(" ", "%20");
    }

    @JsEvent({"getFileInfo"})
    public void getFileInfo(RequestEvent requestEvent) {
        boolean z16;
        String encodeFileHexStr;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("filePath");
            String optString2 = jSONObject.optString("digestAlgorithm", "md5");
            try {
                IMiniAppContext iMiniAppContext = this.mMiniAppContext;
                if (iMiniAppContext == null) {
                    QMLog.w(TAG, "getFileInfo context is null");
                    return;
                }
                String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                if (!"md5".equals(optString2) && !"sha1".equals(optString2)) {
                    z16 = false;
                    String str = null;
                    if (TextUtils.isEmpty(absolutePath) && z16) {
                        File file = new File(absolutePath);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            if ("sha1".equals(optString2)) {
                                encodeFileHexStr = SecurityUtil.getFileSHA1(absolutePath);
                            } else {
                                encodeFileHexStr = MD5Utils.encodeFileHexStr(absolutePath);
                            }
                            if (encodeFileHexStr != null) {
                                str = encodeFileHexStr.toLowerCase();
                            }
                            jSONObject2.put(PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, str);
                            jSONObject2.put("size", file.length());
                            onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis, absolutePath);
                            requestEvent.ok(jSONObject2);
                            return;
                        } catch (Throwable th5) {
                            QMLog.e(TAG, "getFileInfo exception:" + th5.getMessage());
                            onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, absolutePath);
                            requestEvent.fail();
                            return;
                        }
                    }
                    onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, absolutePath);
                    requestEvent.fail(null, "invalid data");
                }
                z16 = true;
                String str2 = null;
                if (TextUtils.isEmpty(absolutePath)) {
                }
                onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, absolutePath);
                requestEvent.fail(null, "invalid data");
            } catch (JSONException e16) {
                e = e16;
                e.printStackTrace();
            }
        } catch (JSONException e17) {
            e = e17;
        }
    }

    @JsEvent({"getSavedFileInfo"})
    public String getSavedFileInfo(RequestEvent requestEvent) {
        String optString;
        IMiniAppContext iMiniAppContext;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            optString = new JSONObject(requestEvent.jsonParams).optString("filePath");
        } catch (JSONException e16) {
            e = e16;
        }
        try {
            iMiniAppContext = this.mMiniAppContext;
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            return "";
        }
        if (iMiniAppContext == null) {
            QMLog.w(TAG, "getSavedFileInfo context is null");
            return "";
        }
        String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
        if (!TextUtils.isEmpty(absolutePath)) {
            File file = new File(absolutePath);
            if (file.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("size", file.length());
                    jSONObject.put(WadlProxyConsts.CREATE_TIME, file.lastModified() / 1000);
                    onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis, absolutePath);
                    requestEvent.ok(jSONObject);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, absolutePath);
                    requestEvent.fail();
                }
            } else {
                onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, absolutePath);
                requestEvent.fail(null, "no such file" + optString);
            }
        } else {
            onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, optString);
            requestEvent.fail(null, "no such file" + optString);
        }
        return "";
    }

    @JsEvent({"getSavedFileList"})
    public String getSavedFileList(RequestEvent requestEvent) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext == null) {
            QMLog.w(TAG, "getSavedFileList done but context is null");
            return "";
        }
        File[] saveFileList = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getSaveFileList();
        try {
            JSONArray jSONArray = new JSONArray();
            if (saveFileList != null) {
                for (File file : saveFileList) {
                    if (file != null && file.exists() && file.isFile()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("filePath", ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFilePath(file.getAbsolutePath()));
                        jSONObject.put("size", file.length());
                        jSONObject.put(WadlProxyConsts.CREATE_TIME, file.lastModified() / 1000);
                        jSONArray.mo162put(jSONObject);
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileList", jSONArray);
            requestEvent.ok(jSONObject2);
        } catch (Throwable th5) {
            th5.printStackTrace();
            requestEvent.fail();
        }
        onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis, "");
        return "";
    }

    @JsEvent({"mkdir", "mkdirSync"})
    public String mkdir(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("dirPath");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.9
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "mkdir done but context is null");
                        return "";
                    }
                    if (TextUtils.isEmpty(optString) || jSONObject.isNull("dirPath")) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_PATH);
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString) != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    if (!TextUtils.isEmpty(absolutePath)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_FILE_ALREADY_EXIST + optString);
                    }
                    String usrPath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(optString);
                    if (TextUtils.isEmpty(usrPath) || !new File(usrPath).mkdirs()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, usrPath);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "{}";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        if (this.mMiniAppInfo != null) {
            MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
            this.fileManager = miniAppFileManager;
            if (miniAppFileManager != null) {
                miniAppFileManager.setStorageLimit(this.mMiniAppInfo.usrFileSizeLimit);
            }
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, SDKMiniProgramLpReportDC04239.BUFFER_ACTION, "", "", this.mMiniAppInfo.usrFileSizeLimit + "");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        MiniGameStorageExceedManager.resetStorageExceedDialogStatus();
        this.mMiniAppContext = null;
        super.onDestroy();
    }

    @JsEvent({com.tencent.luggage.wxa.of.d.NAME})
    public String operateDownloadTask(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("downloadTaskId");
            if ("abort".equals(jSONObject.optString("operationType")) && this.downloadMap.containsKey(optString)) {
                ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).abort(this.downloadMap.get(optString));
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("downloadTaskId", optString);
                    return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject2).toString();
                } catch (Throwable unused) {
                    return "";
                }
            }
            return "";
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({com.tencent.luggage.wxa.qf.d.NAME})
    public String operateUploadTask(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int optInt = jSONObject.optInt("uploadTaskId");
            if ("abort".equals(jSONObject.optString("operationType")) && this.uploadMap.containsKey(Integer.valueOf(optInt))) {
                ((UploaderProxy) ProxyManager.get(UploaderProxy.class)).abort(this.uploadMap.get(Integer.valueOf(optInt)));
                return "";
            }
            return "";
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({"readCompressedFile", "readCompressedFileSync"})
    public String readCompressedFile(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("filePath");
            final String optString2 = jSONObject.optString("compressionAlgorithm");
            final boolean optBoolean = jSONObject.optBoolean("isByWasmInstantiate", false);
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.11
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    if (optBoolean && !((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isPackageFile(optString)) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    if (!TtmlNode.TAG_BR.equalsIgnoreCase(optString2)) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_ENCODE + optString2);
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    if (TextUtils.isEmpty(absolutePath)) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (!new File(absolutePath).exists()) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (FileUtils.getFileOrFolderSize(absolutePath) > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_FILE_IS_LARGER_THAN_100M + optString);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] a16 = BrotliUtil.a(absolutePath);
                    if (a16 == null) {
                        QMLog.e(FileJsPlugin.TAG, "br decompress failed.");
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, "decompress failed, file=" + optString);
                    }
                    QMLog.i(FileJsPlugin.TAG, "br decompress success, cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", decompressSize=" + ((a16.length / 1024) / 1024));
                    JSONObject jSONObject2 = new JSONObject();
                    NativeBuffer.packNativeBuffer(requestEvent.jsService, a16, NativeBuffer.TYPE_BUFFER_NATIVE, "data", jSONObject2);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, jSONObject2);
                }
            });
        } catch (Exception e16) {
            QMLog.e(TAG, "readCompressedFile failed, exception:", e16);
            return "{}";
        }
    }

    @JsEvent({XWalkReaderBasePlugin.READ_METHOD_NAME, "readFileSync"})
    public String readFile(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (requestEvent.event.endsWith("Sync")) {
            a readFileSync = readFileSync(requestEvent);
            onEventFinish(requestEvent.event, readFileSync.f348193a, currentTimeMillis, currentTimeMillis, null);
            if (readFileSync.f348193a) {
                return ApiUtil.wrapCallbackOk(requestEvent.event, readFileSync.f348195c).toString();
            }
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, readFileSync.f348194b).toString();
        }
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.10
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis2 = System.currentTimeMillis();
                a readFileSync2 = FileJsPlugin.this.readFileSync(requestEvent);
                FileJsPlugin.this.onEventFinish(requestEvent.event, readFileSync2.f348193a, currentTimeMillis, currentTimeMillis2, null);
                if (readFileSync2.f348193a) {
                    requestEvent.ok(readFileSync2.f348195c);
                } else {
                    requestEvent.fail(readFileSync2.f348194b);
                }
            }
        });
        return "";
    }

    @JsEvent({"readdir", "readdirSync"})
    public String readdir(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("dirPath");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.12
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (TextUtils.isEmpty(optString) || jSONObject.isNull("dirPath")) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_PATH);
                    }
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    if (TextUtils.isEmpty(absolutePath)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (!new File(absolutePath).isDirectory()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NOT_DIR + optString);
                    }
                    File[] listFiles = new File(absolutePath).listFiles();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            if (file != null) {
                                jSONArray.mo162put(file.getName());
                            }
                        }
                    }
                    try {
                        jSONObject2.put("files", jSONArray);
                    } catch (JSONException unused) {
                    }
                    FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, jSONObject2);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({"removeSavedFile"})
    public String removeSavedFile(RequestEvent requestEvent) {
        JSONObject jSONObject;
        String optString;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject = new JSONObject(requestEvent.jsonParams);
            optString = jSONObject.optString("filePath");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (!TextUtils.isEmpty(optString) && !jSONObject.isNull("filePath")) {
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext == null) {
                QMLog.w(TAG, "removeSavedFile done but context is null");
                return "";
            }
            if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString) == 1) {
                String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                if (FileUtils.fileExists(absolutePath)) {
                    this.fileManager.updateFolderSize(1, -FileUtils.delete(absolutePath, false));
                    onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis, absolutePath);
                    requestEvent.ok();
                } else {
                    onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, absolutePath);
                    requestEvent.fail(null, ERR_NOT_STORE_FILE_PATH);
                }
            } else {
                onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, optString);
                requestEvent.fail(null, ERR_NOT_STORE_FILE_PATH);
            }
            return "";
        }
        onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis, optString);
        return handleCallbackFail(requestEvent, null, ERR_PARAMS_DIR_PATH_IS_NULL);
    }

    @JsEvent({"fs_rename", "fs_renameSync"})
    public String rename(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("oldPath");
            final String optString2 = jSONObject.optString("newPath");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.13
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (TextUtils.isEmpty(optString)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_PATH);
                    }
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    int wxFileType = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString);
                    int wxFileType2 = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString2);
                    if (wxFileType != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    if (wxFileType2 != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString2);
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    String usrPath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(optString2);
                    if (!new File(absolutePath).exists()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (!FileUtils.renameFile(absolutePath, usrPath)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE);
                    }
                    if (wxFileType != 2) {
                        long fileSizes = FileUtils.getFileSizes(usrPath);
                        FileJsPlugin.this.fileManager.updateFolderSize(wxFileType, -fileSizes);
                        FileJsPlugin.this.fileManager.updateFolderSize(wxFileType2, fileSizes);
                    }
                    FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({"rmdir", "rmdirSync"})
    public String rmdir(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("dirPath");
            final boolean optBoolean = jSONObject.optBoolean("recursive");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.14
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long deleteFilesInDirectory;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    if (TextUtils.isEmpty(optString) || jSONObject.isNull("dirPath")) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PARAMS_DIR_PATH_IS_NULL);
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString) != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    if (FileUtils.isExternalStoragePath(((BaseJsPlugin) FileJsPlugin.this).mContext, optString)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    String usrPath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(optString);
                    if (TextUtils.isEmpty(usrPath)) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, "no such file or directory, open dirPath is null");
                    }
                    if (!new File(usrPath).exists()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, usrPath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (optBoolean) {
                        deleteFilesInDirectory = FileUtils.deleteDirectory(usrPath);
                    } else {
                        deleteFilesInDirectory = FileUtils.deleteFilesInDirectory(usrPath);
                    }
                    FileJsPlugin.this.fileManager.updateFolderSize(2, -deleteFilesInDirectory);
                    FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, usrPath);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({l0.NAME, "saveFileSync"})
    public String saveFile(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("tempFilePath");
            final String optString2 = jSONObject.optString("filePath");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.7
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "saveFile execFileTask done but context is null");
                        return "";
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    if (TextUtils.isEmpty(absolutePath)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_TEMP_FILE_NOT_EXIST);
                    }
                    long fileSizes = FileUtils.getFileSizes(absolutePath);
                    if (TextUtils.isEmpty(optString2)) {
                        long fileSizes2 = fileSizes - FileUtils.getFileSizes(((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getSaveStorePath(optString));
                        if (!((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isFolderCanWrite(1, fileSizes2, ((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame, ((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, iMiniAppContext.getAttachActivity(), iMiniAppContext)) {
                            FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                            return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_STORAGE_EXCEEDED);
                        }
                        String savePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).savePath(optString);
                        if (TextUtils.isEmpty(savePath)) {
                            FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, savePath);
                            return FileJsPlugin.this.handleCallbackFail(requestEvent, null, null);
                        }
                        FileJsPlugin.this.fileManager.updateFolderSize(1, fileSizes2);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("savedFilePath", savePath);
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, savePath);
                        return FileJsPlugin.this.handleCallbackOK(requestEvent, jSONObject2);
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString2) != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString2);
                    }
                    String usrPath = FileJsPlugin.this.fileManager.getUsrPath(optString2);
                    long fileSizes3 = fileSizes - FileUtils.getFileSizes(usrPath);
                    if (!((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isFolderCanWrite(2, fileSizes3, ((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame, ((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, iMiniAppContext.getAttachActivity(), iMiniAppContext)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_STORAGE_EXCEEDED);
                    }
                    FileUtils.copyFile(absolutePath, usrPath);
                    FileJsPlugin.this.fileManager.updateFolderSize(2, fileSizes3);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("savedFilePath", optString2);
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                    QMLog.d(FileJsPlugin.TAG, "saveFile succeed! [minigame timecost:" + (System.currentTimeMillis() - currentTimeMillis) + "ms], saveAboPath:" + usrPath);
                    FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, usrPath);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, jSONObject3);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({"stat", "statSync"})
    public String stat(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("path");
            final boolean optBoolean = jSONObject.optBoolean("recursive");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.15
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString) == 9999) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    File file = new File(absolutePath);
                    if (!file.exists()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (optBoolean && file.isDirectory()) {
                        try {
                            JSONObject statsByDir = FileUtils.getStatsByDir(absolutePath);
                            if (statsByDir != null) {
                                if ("statSync".equals(requestEvent.event)) {
                                    FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                                    return statsByDir.toString();
                                }
                                if (!((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame) {
                                    return FileJsPlugin.this.handleCallbackOK(requestEvent, statsByDir);
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("stats", statsByDir);
                                } catch (JSONException unused) {
                                }
                                FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                                return FileJsPlugin.this.handleCallbackOK(requestEvent, jSONObject2);
                            }
                        } catch (Exception e16) {
                            QMLog.e(FileJsPlugin.TAG, " API_STAT error : " + e16);
                            return "";
                        }
                    } else {
                        JSONObject stats = FileUtils.getStats(absolutePath);
                        if (stats != null) {
                            if ("statSync".equals(requestEvent.event)) {
                                FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                                return stats.toString();
                            }
                            if (!((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame) {
                                return FileJsPlugin.this.handleCallbackOK(requestEvent, stats);
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("stats", stats);
                            } catch (JSONException unused2) {
                            }
                            FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                            return FileJsPlugin.this.handleCallbackOK(requestEvent, jSONObject3);
                        }
                    }
                    FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                    return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "{}";
        }
    }

    @JsEvent({"unlink", "unlinkSync"})
    public String unlink(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            final String optString = new JSONObject(requestEvent.jsonParams).optString("filePath");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.16
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    int wxFileType = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString);
                    if (wxFileType == 9999) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_PATH + optString);
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    if (TextUtils.isEmpty(absolutePath)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (new File(absolutePath).isDirectory()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_UNLINK_OPERATION_BAN + optString);
                    }
                    if (!new File(absolutePath).exists()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    if (FileUtils.isExternalStoragePath(((BaseJsPlugin) FileJsPlugin.this).mContext, absolutePath)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    FileJsPlugin.this.fileManager.updateFolderSize(wxFileType, -FileUtils.delete(absolutePath, false));
                    FileJsPlugin.this.onEventFinish(requestEvent.event, true, currentTimeMillis, currentTimeMillis2, absolutePath);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({"unzip"})
    public String unzip(final RequestEvent requestEvent) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("zipFilePath");
            final String optString2 = jSONObject.optString("targetPath");
            return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.17
                @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
                public String run() {
                    boolean z16;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString) == 9999 && !((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isPackageRelativePath(optString)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString);
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString2) != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString2);
                    }
                    String absolutePath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString);
                    String usrPath = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getUsrPath(optString2);
                    if (TextUtils.isEmpty(absolutePath) || !new File(absolutePath).exists()) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, absolutePath);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_NO_SUCH_FILE + optString);
                    }
                    long fileOrFolderSize = FileUtils.getFileOrFolderSize(usrPath);
                    int unZipFolder = ZipUtil.unZipFolder(absolutePath, usrPath);
                    FileJsPlugin fileJsPlugin = FileJsPlugin.this;
                    String str = requestEvent.event;
                    if (unZipFolder == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    fileJsPlugin.onEventFinish(str, z16, currentTimeMillis, currentTimeMillis2, optString);
                    if (unZipFolder != 0) {
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_READ_ZIP_DATA);
                    }
                    FileJsPlugin.this.fileManager.updateFolderSize(2, FileUtils.getFileOrFolderSize(usrPath) - fileOrFolderSize);
                    return FileJsPlugin.this.handleCallbackOK(requestEvent, null);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @JsEvent({"writeFile", "writeFileSync"})
    public String writeFile(final RequestEvent requestEvent) {
        return execFileTask(requestEvent.event, new FileTask() { // from class: com.tencent.qqmini.sdk.plugins.FileJsPlugin.18
            @Override // com.tencent.qqmini.sdk.plugins.FileJsPlugin.FileTask
            public String run() {
                String optString;
                byte[] bArr;
                int length;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    String optString2 = jSONObject.optString("filePath");
                    if (jSONObject.isNull("data")) {
                        optString = null;
                    } else {
                        optString = jSONObject.optString("data");
                    }
                    String optString3 = jSONObject.optString("encoding", "utf8");
                    NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(requestEvent.jsService, jSONObject, "data");
                    if (unpackNativeBuffer != null) {
                        bArr = unpackNativeBuffer.buf;
                    } else {
                        bArr = null;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (optString == null && bArr == null) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_DATA);
                    }
                    if (!FileJsPlugin.isEncodingSupport(optString3)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_ENCODE + optString3);
                    }
                    IMiniAppContext iMiniAppContext = ((BaseJsPlugin) FileJsPlugin.this).mMiniAppContext;
                    if (iMiniAppContext == null) {
                        QMLog.w(FileJsPlugin.TAG, "execFileTask done but context is null");
                        return "";
                    }
                    if (((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getWxFileType(optString2) != 2) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_PERMISSION_DENIED + optString2);
                    }
                    if (bArr != null) {
                        length = bArr.length;
                    } else {
                        length = optString.length();
                    }
                    if (!((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).isFolderCanWrite(2, length, ((BaseJsPlugin) FileJsPlugin.this).mIsMiniGame, ((BaseJsPlugin) FileJsPlugin.this).mMiniAppInfo, iMiniAppContext.getAttachActivity(), iMiniAppContext)) {
                        FileJsPlugin.this.onEventFinish(requestEvent.event, false, currentTimeMillis, currentTimeMillis2, optString2);
                        return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_STORAGE_EXCEEDED);
                    }
                    return FileJsPlugin.this.writeUsrFile(currentTimeMillis2, optString2, bArr, optString, optString3, requestEvent, currentTimeMillis);
                } catch (JSONException e16) {
                    QMLog.e(FileJsPlugin.TAG, "writeFile: parse params failed.", e16);
                    return FileJsPlugin.this.handleCallbackFail(requestEvent, null, FileJsPlugin.ERR_INVALID_DATA);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f348193a = false;

        /* renamed from: b, reason: collision with root package name */
        String f348194b;

        /* renamed from: c, reason: collision with root package name */
        JSONObject f348195c;

        a(String str) {
            this.f348194b = str;
        }

        a(JSONObject jSONObject) {
            this.f348195c = jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeUsrFile(byte[] bArr, String str, String str2, String str3, boolean z16) throws IOException {
        byte[] bytes;
        if (bArr != null) {
            checkUsrFileSize(bArr.length);
            long fileSizes = FileUtils.getFileSizes(str3);
            boolean writeFile = FileUtils.writeFile(str3, bArr, z16);
            if (writeFile) {
                this.fileManager.updateFolderSize(2, FileUtils.getFileSizes(str3) - fileSizes);
            }
            return writeFile;
        }
        if ("base64".equals(str2)) {
            bytes = Base64.decode(str, 2);
        } else if ("hex".equals(str2)) {
            bytes = StringUtil.hexStr2Bytes(str);
        } else {
            bytes = str.getBytes();
        }
        if (!str2.equals("binary") && !str2.equals("hex") && !str2.equals("base64")) {
            ByteBuffer encode = Charset.forName(str2).encode(new String(bytes, Charset.forName("utf8")));
            byte[] array = encode.array();
            checkUsrFileSize(encode.limit());
            long fileSizes2 = FileUtils.getFileSizes(str3);
            boolean writeFile2 = FileUtils.writeFile(str3, array, z16, encode.limit());
            if (writeFile2) {
                this.fileManager.updateFolderSize(2, FileUtils.getFileSizes(str3) - fileSizes2);
            }
            return writeFile2;
        }
        checkUsrFileSize(bytes.length);
        long fileSizes3 = FileUtils.getFileSizes(str3);
        boolean writeFile3 = FileUtils.writeFile(str3, bytes, z16);
        if (writeFile3) {
            this.fileManager.updateFolderSize(2, FileUtils.getFileSizes(str3) - fileSizes3);
        }
        return writeFile3;
    }
}
