package com.tencent.mobileqq.minigame.manager;

import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.minigame.config.MiniGamePallasConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.z;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FileDownloadManager {
    private static final int NO_FILESIZE = -1;
    private static final String TAG = "FileDownloadManager";
    private static ConcurrentHashMap<String, Call> taskMap = new ConcurrentHashMap<>();
    private static int enableDownloader = QzoneConfig.getInstance().getConfig("qqtriton", WnsConfig.SECONDARY_KEY_MINI_GAME_SDK_ENABLE_DOWNLOADER, 1);
    private static int sFileDownloadType = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class InnerListener implements Downloader.MiniDownloadListener {
        private long beginEnqueue = System.currentTimeMillis();
        private String filePath;
        Map<String, List<String>> headers;
        private DownloaderProxy.DownloadListener listener;
        private String url;

        public InnerListener(DownloaderProxy.DownloadListener downloadListener, String str, String str2) {
            this.filePath = "";
            this.url = "";
            this.listener = downloadListener;
            this.filePath = str;
            this.url = str2;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            DownloaderProxy.DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadFailed(-5, "abort");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            DownloaderProxy.DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadFailed(downloadResult.getStatus().httpStatus, downloadResult.getStatus().getErrorMessage());
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.MiniDownloadListener
        public void onDownloadHeadersReceived(String str, int i3, Map<String, List<String>> map) {
            this.headers = map;
            DownloaderProxy.DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadHeadersReceived(i3, map);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            DownloaderProxy.DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadProgress(f16, ((float) j3) * f16, j3);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            DownloaderProxy.DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadSucceed(downloadResult.getStatus().httpStatus, this.filePath, FileDownloadManager.convertDownloadResult(downloadResult, this.headers, this.beginEnqueue));
            }
            QLog.e(FileDownloadManager.TAG, 1, "downloadWithDownloader [timecost=" + (System.currentTimeMillis() - this.beginEnqueue) + "][receiveData=" + downloadResult.getReport().t_recvdata + "][connect=" + downloadResult.getReport().t_conn + "][duration=" + downloadResult.getProcess().duration + "][totalDuration=" + downloadResult.getProcess().totalDuration + "][wait=" + downloadResult.getReport().t_wait + "][url=" + this.url + "]");
        }
    }

    public static void abort(String str) {
        int downloadType = getDownloadType();
        if (downloadType != 1 && downloadType != 2) {
            Call call = taskMap.get(str);
            if (call != null) {
                call.cancel();
            }
            taskMap.remove(str);
            return;
        }
        MiniappDownloadUtil.getInstance().abort(str);
    }

    public static boolean download(String str, Map<String, String> map, String str2, int i3, DownloaderProxy.DownloadListener downloadListener) {
        if (getDownloadType() == 1) {
            return downloadWithDownloader(str, map, str2, i3, Downloader.DownloadMode.OkHttpMode, downloadListener);
        }
        if (getDownloadType() == 2) {
            return downloadWithDownloader(str, map, str2, i3, Downloader.DownloadMode.StrictMode, downloadListener);
        }
        return downloadWithOkhttp(str, map, str2, i3, downloadListener);
    }

    private static boolean downloadWithDownloader(String str, Map<String, String> map, String str2, int i3, Downloader.DownloadMode downloadMode, DownloaderProxy.DownloadListener downloadListener) {
        MiniappDownloadUtil.getInstance().download(str, str2, false, new InnerListener(downloadListener, str2, str), Downloader.DownloadMode.OkHttpMode, z.e(map));
        return true;
    }

    public static int getDownloadType() {
        int i3 = sFileDownloadType;
        if (i3 > 0) {
            return i3;
        }
        sFileDownloadType = 1;
        MiniGamePallasConfig miniGamePallasConfig = (MiniGamePallasConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGamePallasConfig.CONFIG_ID);
        if (miniGamePallasConfig != null) {
            sFileDownloadType = miniGamePallasConfig.getFileDownloadType();
        }
        return sFileDownloadType;
    }

    public static void preConnectDownloader() {
        if (getDownloadType() == 1) {
            GamePreConnectManager.preConnectDownloaderForSDK();
        }
    }

    private static boolean downloadWithOkhttp(final String str, Map<String, String> map, final String str2, int i3, final DownloaderProxy.DownloadListener downloadListener) {
        Call newCall = MiniOkHttpClientFactory.getDownloadClient(true).newCall(z.b(str, map, "GET", null, null));
        final long currentTimeMillis = System.currentTimeMillis();
        newCall.enqueue(new Callback() { // from class: com.tencent.mobileqq.minigame.manager.FileDownloadManager.1
            private volatile boolean canceled = false;
            private long beginEnqueue = System.currentTimeMillis();

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                QLog.e(FileDownloadManager.TAG, 1, "httpConnect err url:" + str, iOException);
                if ("Canceled".equals(iOException.getLocalizedMessage())) {
                    this.canceled = true;
                    downloadListener.onDownloadFailed(-5, "abort");
                } else {
                    downloadListener.onDownloadFailed(z.d(iOException, -1), "request error:network");
                }
                FileDownloadManager.taskMap.remove(str);
            }

            /* JADX WARN: Removed duplicated region for block: B:57:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:76:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:83:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:84:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // okhttp3.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(Call call, Response response) {
                Throwable th5;
                FileOutputStream fileOutputStream;
                int i16;
                int i17;
                FileOutputStream fileOutputStream2;
                int i18;
                int i19;
                if (this.canceled) {
                    return;
                }
                int code = response.code();
                Map<String, List<String>> multimap = response.headers().toMultimap();
                downloadListener.onDownloadHeadersReceived(code, multimap);
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                try {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ResponseBody body = response.body();
                    int i26 = 0;
                    InputStream inputStream = null;
                    if (body != null) {
                        try {
                            InputStream byteStream = body.byteStream();
                            try {
                                long contentLength = body.getContentLength();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[4096];
                                    int i27 = 0;
                                    while (true) {
                                        int read = byteStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream3.write(bArr, i26, read);
                                        i27 += read;
                                        if (contentLength > 0) {
                                            fileOutputStream = fileOutputStream3;
                                            try {
                                                downloadListener.onDownloadProgress((i27 * 1.0f) / ((float) contentLength), i27, contentLength);
                                            } catch (IOException unused) {
                                                inputStream = byteStream;
                                                try {
                                                    downloadListener.onDownloadFailed(2, "download error:local io exception");
                                                    FileDownloadManager.taskMap.remove(str);
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable th6) {
                                                            i17 = 1;
                                                            QLog.e(FileDownloadManager.TAG, 1, "", th6);
                                                            if (fileOutputStream == null) {
                                                                try {
                                                                    fileOutputStream.close();
                                                                    return;
                                                                } catch (Throwable th7) {
                                                                    QLog.e(FileDownloadManager.TAG, i17, "", th7);
                                                                    return;
                                                                }
                                                            }
                                                            return;
                                                        }
                                                    }
                                                    i17 = 1;
                                                    if (fileOutputStream == null) {
                                                    }
                                                } catch (Throwable th8) {
                                                    th5 = th8;
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Throwable th9) {
                                                            i16 = 1;
                                                            QLog.e(FileDownloadManager.TAG, 1, "", th9);
                                                            if (fileOutputStream != null) {
                                                            }
                                                        }
                                                    }
                                                    i16 = 1;
                                                    if (fileOutputStream != null) {
                                                        try {
                                                            fileOutputStream.close();
                                                            throw th5;
                                                        } catch (Throwable th10) {
                                                            QLog.e(FileDownloadManager.TAG, i16, "", th10);
                                                            throw th5;
                                                        }
                                                    }
                                                    throw th5;
                                                }
                                            } catch (Throwable th11) {
                                                th = th11;
                                                th5 = th;
                                                inputStream = byteStream;
                                                if (inputStream != null) {
                                                }
                                                i16 = 1;
                                                if (fileOutputStream != null) {
                                                }
                                            }
                                        } else {
                                            fileOutputStream = fileOutputStream3;
                                        }
                                        fileOutputStream3 = fileOutputStream;
                                        i26 = 0;
                                    }
                                    fileOutputStream2 = fileOutputStream3;
                                    i18 = i27;
                                    inputStream = byteStream;
                                } catch (IOException unused2) {
                                    fileOutputStream = fileOutputStream3;
                                } catch (Throwable th12) {
                                    th = th12;
                                    fileOutputStream = fileOutputStream3;
                                }
                            } catch (IOException unused3) {
                                fileOutputStream = null;
                            } catch (Throwable th13) {
                                th5 = th13;
                                fileOutputStream = null;
                            }
                        } catch (IOException unused4) {
                            fileOutputStream = null;
                        } catch (Throwable th14) {
                            th5 = th14;
                            fileOutputStream = null;
                        }
                    } else {
                        fileOutputStream2 = null;
                        i18 = 0;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th15) {
                            i19 = 1;
                            QLog.e(FileDownloadManager.TAG, 1, "", th15);
                        }
                    }
                    i19 = 1;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th16) {
                            QLog.e(FileDownloadManager.TAG, i19, "", th16);
                        }
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    long j3 = i18;
                    downloadListener.onDownloadProgress(0.99f, j3, j3);
                    downloadListener.onDownloadSucceed(code, str2, new DownloaderProxy.DownloadListener.DownloadResult(response.request().url().getUrl(), code, response.isSuccessful(), response.message(), false, 0L, 0L, 0L, 0L, System.currentTimeMillis() - currentTimeMillis, response.body().getContentLength(), multimap, currentTimeMillis));
                    FileDownloadManager.taskMap.remove(str);
                    QLog.e(FileDownloadManager.TAG, 1, "downloadWithOkhttp [timecost=" + (System.currentTimeMillis() - this.beginEnqueue) + "][receiveData=" + (currentTimeMillis3 - currentTimeMillis2) + "][" + response.protocol() + "][url=" + str + "]");
                } catch (IOException unused5) {
                    downloadListener.onDownloadFailed(2, "download error:local io exception");
                    FileDownloadManager.taskMap.remove(str);
                }
            }
        });
        taskMap.put(str, newCall);
        return true;
    }

    public static boolean miniAppDownload(boolean z16, String str, Map<String, String> map, String str2, int i3, long j3, DownloaderProxy.DownloadListener downloadListener) {
        if (z16) {
            return downloadWithOkhttp(str, map, str2, i3, downloadListener);
        }
        e.b.c(TAG, e.b.f295938b, "start okhttpDownload,url:" + str);
        return downloadWithDownloader(str, map, str2, i3, Downloader.DownloadMode.OkHttpMode, downloadListener);
    }

    public static void getLameMp3SoDownloadPath(final DownloaderProxy.SoLoadListener soLoadListener) {
        if (soLoadListener == null) {
            return;
        }
        ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).downloadModule(QzoneModuleConst.MINIGAME_MODULE_MINIGAME_LAMEMP3_SO, new ModuleDownloadListener() { // from class: com.tencent.mobileqq.minigame.manager.FileDownloadManager.2
            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadCanceled(String str) {
                DownloaderProxy.SoLoadListener.this.onFail(-2);
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadFailed(String str) {
                DownloaderProxy.SoLoadListener.this.onFail(-1);
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadSucceed(String str) {
                if (str.equals(QzoneModuleConst.MINIGAME_MODULE_MINIGAME_LAMEMP3_SO)) {
                    DownloaderProxy.SoLoadListener.this.onSuccess(((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(str));
                }
            }

            @Override // cooperation.qzone.networkedmodule.ModuleDownloadListener
            public void onDownloadProgress(String str, float f16) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DownloaderProxy.DownloadListener.DownloadResult convertDownloadResult(DownloadResult downloadResult, Map<String, List<String>> map, long j3) {
        DownloadReport report = downloadResult.getReport();
        return new DownloaderProxy.DownloadListener.DownloadResult(downloadResult.getUrl(), report.httpStatus, report.isSucceed, downloadResult.getDescInfo(), false, report.t_wait, report.t_prepare, report.t_conn, report.t_recvdata, report.totaltime, report.fileSize, map, j3);
    }
}
