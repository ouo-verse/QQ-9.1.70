package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import com.tencent.smtt.sdk.WebView;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZoneHttpDownloadUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneOfflineCacheHelper {
    private static final int DOWNLOAD_DELAY_TIME = 10000;
    private static final String TAG = "QzoneOfflineCacheHelper";
    private static final int UPDATE_LRU_FILE_DELAY_TIME = 20000;
    private static final byte[] URL_LOCK = new byte[0];
    private static ConcurrentHashMap<String, ArrayList<Object>> downloadindUrlMap = new ConcurrentHashMap<>();
    private static FileCacheService mFileCache;

    static /* bridge */ /* synthetic */ FileCacheService c() {
        return getFileCache();
    }

    public static boolean checkFileIfExist(String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            return false;
        }
        String path = getFileCache().getPath(urlKey2FileName(str, true));
        if (new File(path).exists()) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 2, String.format("check result file exist,url:%s,path:%s", str, path));
            }
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 2, String.format("check result file not exist,url:%s,path:%s", str, path));
        }
        return false;
    }

    public static void downloadAfterGetDomainAndTBSVersion(final AppInterface appInterface, final String str, final String str2, final String str3, final int i3, QzoneOfflineCacheHelperCallBack qzoneOfflineCacheHelperCallBack) {
        boolean z16;
        synchronized (URL_LOCK) {
            ConcurrentHashMap<String, ArrayList<Object>> concurrentHashMap = downloadindUrlMap;
            if (concurrentHashMap != null) {
                ArrayList<Object> arrayList = concurrentHashMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!arrayList.contains(qzoneOfflineCacheHelperCallBack)) {
                    arrayList.add(qzoneOfflineCacheHelperCallBack != null ? qzoneOfflineCacheHelperCallBack : new Object());
                    downloadindUrlMap.put(str, arrayList);
                }
                if (z16) {
                    return;
                }
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (QLog.isDevelopLevel()) {
                            QLog.i(QzoneOfflineCacheHelper.TAG, 4, String.format("delay 10s,url:%s ,path:%s", str, str2));
                        }
                        File file = new File(str2);
                        boolean download = QZoneHttpDownloadUtil.download(appInterface, str, file, str3, i3);
                        if (download) {
                            QzoneOfflineCacheHelper.updateLruFileInNewThread(str2);
                            if (QLog.isDevelopLevel()) {
                                QLog.i(QzoneOfflineCacheHelper.TAG, 4, String.format("download succ,path:%s", str2));
                            }
                        } else {
                            try {
                                if (file.exists()) {
                                    q.c(file);
                                }
                            } catch (Throwable unused) {
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.i(QzoneOfflineCacheHelper.TAG, 4, String.format("download fail,url:%s ,path:%s", str, str2));
                            }
                        }
                        synchronized (QzoneOfflineCacheHelper.URL_LOCK) {
                            if (QzoneOfflineCacheHelper.downloadindUrlMap != null) {
                                ArrayList arrayList2 = (ArrayList) QzoneOfflineCacheHelper.downloadindUrlMap.get(str);
                                if (arrayList2 != null) {
                                    Iterator it = arrayList2.iterator();
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        if (next instanceof QzoneOfflineCacheHelperCallBack) {
                                            ((QzoneOfflineCacheHelperCallBack) next).onResultOfNativeRequest(download, str2);
                                        }
                                    }
                                }
                                QzoneOfflineCacheHelper.downloadindUrlMap.remove(str);
                            }
                        }
                    } catch (Exception e16) {
                        QLog.w(QzoneOfflineCacheHelper.TAG, 1, "\u9884\u4e0b\u8f7doffline\u8d44\u6e90\u53d1\u751f\u5f02\u5e38", e16);
                    }
                }
            }, 10000L);
        }
    }

    private static FileCacheService getFileCache() {
        if (mFileCache == null) {
            mFileCache = CacheManager.getWebviewOfflineFileCacheService();
        }
        return mFileCache;
    }

    private static String getProtocolAndDomainOfCurrentWebPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            URL url = new URL(str);
            return url.getProtocol() + QzoneWebViewOfflinePlugin.STR_DEVIDER + url.getHost();
        } catch (Throwable th5) {
            QLog.e(TAG, 2, "getProtocolAndDomainOfCurrentWebPage error", th5);
            return null;
        }
    }

    private static int getTBSCoreVersion() {
        int tbsCoreVersion = WebView.getTbsCoreVersion(BaseApplication.getContext());
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "tbsCoreVersion= " + tbsCoreVersion);
        }
        return tbsCoreVersion;
    }

    public static void updateLruFileInNewThread(final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper.1
            @Override // java.lang.Runnable
            public void run() {
                QzoneOfflineCacheHelper.c().updateLruFile(str, true);
            }
        }, 20000L);
    }

    public static File downLoadFileIfNeeded(AppInterface appInterface, String str, QzoneOfflineCacheHelperCallBack qzoneOfflineCacheHelperCallBack, boolean z16, String str2) {
        String path;
        try {
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        String urlKey2FileName = urlKey2FileName(str, true);
        String str3 = "";
        if (!z16) {
            str3 = CacheManager.getQzoneWidgetAICacheService().getPath("dressup");
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            path = str3 + File.separator + urlKey2FileName;
        } else {
            path = getFileCache().getPath(urlKey2FileName);
        }
        String str4 = str3;
        String str5 = path;
        File file2 = new File(str5);
        File file3 = new File(str5 + FileCacheService.HeaderFileSuffix);
        if (file2.exists() && file2.length() > 0 && file3.exists() && file3.length() > 0) {
            if (!z16) {
                updateLruFileInNewThread(str4);
            } else {
                updateLruFileInNewThread(str5);
            }
            if (qzoneOfflineCacheHelperCallBack != null) {
                qzoneOfflineCacheHelperCallBack.onResultOfNativeRequest(true, str5);
            }
            return file2;
        }
        if (z16) {
            int tBSCoreVersion = getTBSCoreVersion();
            if (!TextUtils.isEmpty(str2)) {
                downloadAfterGetDomainAndTBSVersion(appInterface, str, str5, getProtocolAndDomainOfCurrentWebPage(str2), tBSCoreVersion, qzoneOfflineCacheHelperCallBack);
            } else if (QLog.isDevelopLevel()) {
                QLog.e(TAG, 1, "offline webview Url is empty!");
            }
        } else {
            downloadAfterGetDomainAndTBSVersion(appInterface, str, str5, "", 0, qzoneOfflineCacheHelperCallBack);
        }
        return null;
    }

    private static String urlKey2FileName(String str, boolean z16) {
        if (z16) {
            return String.valueOf(str.hashCode());
        }
        return str.startsWith("file://") ? str.substring(7, str.length()) : str;
    }

    public static void updataSmallGameLastCacheFinishTime(long j3, long j16) {
        try {
            if (j3 <= 0) {
                QLog.w(TAG, 1, "updataSmallGameLastCacheFinishTime uin is invalid,uin=" + j3);
                return;
            }
            LocalMultiProcConfig.putLong4Uin(QzoneConfig.SP_KEY_PRELOAD_SMALL_GAME_FINISH, j16, j3);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 2, "uin=" + j3 + ",updataSmallGameLastCacheFinishTime timestamp=" + j16);
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "updataSmallGameLastCacheFinishTime error.", e16);
        }
    }

    public static long getSmallGameLastCacheTime(long j3) {
        if (j3 <= 0) {
            return 0L;
        }
        long long4Uin = LocalMultiProcConfig.getLong4Uin(QzoneConfig.SP_KEY_PRELOAD_SMALL_GAME_FINISH, 0L, j3);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 2, "uin=" + j3 + ",getSmallGameLastCacheTime cacheTime=" + long4Uin);
        }
        return long4Uin;
    }
}
