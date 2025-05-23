package cooperation.qzone.webviewplugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.reborn.configx.g;
import com.qzone.report.QZonePerfReporter;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneHttpDownloadUtil;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneZipCacheHelper {
    public static final String BUSINESS = "business";
    public static final String CALLBACK = "callback";
    public static final String COUNT = "count";
    public static final String DIR = "dir";
    private static final int DOWNLOAD_DELAY_TIME = 3000;
    public static final String FILEB_NAME_LIST = "imageNameList";
    private static final String TAG = "QzoneZipCacheHelper";
    public static final String ZIPURL = "zipurl";
    private static FileCacheService mFileCache;
    private static final byte[] URL_LOCK = new byte[0];
    private static final Map<String, CopyOnWriteArrayList<QzoneZipCacheHelperCallBack>> sDownloadindUrlMap = new ConcurrentHashMap();

    static /* bridge */ /* synthetic */ FileCacheService c() {
        return getFileCache();
    }

    public static boolean checkDownloadZip(String str) {
        if (TextUtils.isEmpty(str) || !(str.contains("?_offline=1") || str.contains("&_offline=1"))) {
            return false;
        }
        return str.contains("&_type=1") || str.contains("?_type=1");
    }

    private static void createAndClearFile(File file) {
        if (!file.exists()) {
            file.mkdir();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
            return;
        }
        file.mkdir();
    }

    public static Bitmap decodeByteArray(String str, String str2, byte[] bArr, BitmapFactory.Options options, boolean z16) {
        if (z16) {
            updateLruFileInNewThread(str, str2);
        }
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (Exception unused) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.i(TAG, 2, "decodeByteArray exception ");
            return null;
        } catch (OutOfMemoryError unused2) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.i(TAG, 2, "decodeByteArray out of memory");
            return null;
        }
    }

    public static String getBasePath(String str, String str2) {
        return getFileCache().getPath(getFolderName(str, str2));
    }

    private static FileCacheService getFileCache() {
        if (mFileCache == null) {
            mFileCache = CacheManager.getZipCacheService();
        }
        return mFileCache;
    }

    public static File getFileIfExists(AppInterface appInterface, String str) {
        if (!URLUtil.isNetworkUrl(str)) {
            return null;
        }
        Map<String, String> argumentsFromURL = com.tencent.util.URLUtil.getArgumentsFromURL(str);
        return getFileIfExists(appInterface, getUrlBase(str), getFileName(str), argumentsFromURL.get("business"), argumentsFromURL.get(DIR), null);
    }

    public static String[] getFileList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getFileList doesn't exists path = " + str);
                }
                return null;
            }
            String[] list = file.list();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getFileList path = " + str + " nameList = " + list);
            }
            if (list != null) {
                Arrays.sort(list);
            }
            return list;
        } catch (Exception e16) {
            QZLog.e(TAG, " getFileList ", e16);
            return null;
        }
    }

    private static String getFileName(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        int indexOf = str.indexOf(63);
        if (lastIndexOf == -1 || indexOf == -1 || indexOf <= lastIndexOf) {
            return null;
        }
        return str.substring(lastIndexOf + 1, indexOf);
    }

    public static String[] getFolderFileNameList(String str, String str2) {
        return getFileList(getFileCache().getPath(getFolderName(str, str2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFolderName(String str, String str2) {
        return str + "_" + str2;
    }

    private static String getUrlBase(String str) {
        return str.substring(0, str.lastIndexOf(File.separator));
    }

    public static boolean isDangerousLocalPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("../") || str.contains("..\\");
    }

    public static void unzipFile(String str, String str2) {
        synchronized (FileCacheService.class) {
            createAndClearFile(new File(str2));
            ZipUtils.unZipFolder(str, str2);
        }
    }

    private static void updateLruFileInNewThread(final String str, final String str2) {
        if (g.f53821a.b().j0()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneZipCacheHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    QzoneZipCacheHelper.c().updateLruFile(QzoneZipCacheHelper.c().getPath(QzoneZipCacheHelper.getFolderName(str, str2)), true);
                }
            });
        } else {
            PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: cooperation.qzone.webviewplugin.QzoneZipCacheHelper.2
                @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
                public Object run(ThreadPool.JobContext jobContext) {
                    QzoneZipCacheHelper.c().updateLruFile(QzoneZipCacheHelper.c().getPath(QzoneZipCacheHelper.getFolderName(str, str2)), true);
                    return null;
                }
            }, PriorityThreadPool.Priority.LOW);
        }
    }

    public static boolean checkAndDownLoadFileIfNeeded(final AppInterface appInterface, final String str, final String str2, String str3, final int i3, QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack) {
        final String path;
        boolean z16;
        File[] listFiles;
        try {
            path = getFileCache().getPath(getFolderName(str2, str3));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        if (isDangerousLocalPath(path)) {
            QLog.w(TAG, 1, "\u8def\u5f84\u4e0d\u5408\u6cd5\uff1a" + path);
            return false;
        }
        File file = new File(path);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && ((i3 == -1 || listFiles.length == i3) && listFiles.length > 0)) {
            updateLruFileInNewThread(str2, str3);
            if (qzoneZipCacheHelperCallBack != null) {
                qzoneZipCacheHelperCallBack.onResultOfNativeRequest(true, path, str);
            }
            return true;
        }
        synchronized (URL_LOCK) {
            Map<String, CopyOnWriteArrayList<QzoneZipCacheHelperCallBack>> map = sDownloadindUrlMap;
            CopyOnWriteArrayList<QzoneZipCacheHelperCallBack> copyOnWriteArrayList = map.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                map.put(str, copyOnWriteArrayList);
                z16 = false;
            } else {
                z16 = true;
            }
            if (qzoneZipCacheHelperCallBack != null && !copyOnWriteArrayList.contains(qzoneZipCacheHelperCallBack)) {
                copyOnWriteArrayList.add(qzoneZipCacheHelperCallBack);
            }
            if (z16) {
                return false;
            }
            ThreadManagerV2.postDownLoadTask(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneZipCacheHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles2;
                    int i16;
                    File[] listFiles3;
                    int i17;
                    if (QLog.isColorLevel()) {
                        QLog.i(QzoneZipCacheHelper.TAG, 2, String.format("delay 10s,url:%s,path:%s ,  zipUrl = %s ", str2, path, str));
                    }
                    File file2 = new File(path);
                    boolean z17 = file2.exists() && file2.isDirectory() && (listFiles3 = file2.listFiles()) != null && ((i17 = i3) == -1 || listFiles3.length == i17) && listFiles3.length > 0;
                    try {
                        File file3 = new File(path + System.currentTimeMillis() + ".zip");
                        if (QLog.isColorLevel()) {
                            QLog.i(QzoneZipCacheHelper.TAG, 2, String.format("check isDownloaded %s , file Exist = %s ", Boolean.valueOf(z17), Boolean.valueOf(file3.exists())));
                        }
                        if (!z17) {
                            QZonePerfReporter.f59697a.j("custom", "download_zip_cache_" + str);
                            String filterUrl = QZoneHttpDownloadUtil.getFilterUrl(str);
                            z17 = HttpDownloadUtil.download(appInterface, filterUrl, file3);
                            if (z17) {
                                File file4 = new File(path);
                                boolean z18 = file4.exists() && file4.isDirectory() && (listFiles2 = file4.listFiles()) != null && ((i16 = i3) == -1 || listFiles2.length == i16) && listFiles2.length > 0;
                                if (!z18) {
                                    QzoneZipCacheHelper.unzipFile(file3.getAbsolutePath(), path);
                                }
                                QzoneZipCacheHelper.c().updateLruFile(path, true);
                                if (QLog.isColorLevel()) {
                                    QLog.i(QzoneZipCacheHelper.TAG, 2, String.format("download succ,path:%s \uff0c fileExist: %s ", path, Boolean.valueOf(z18)));
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.i(QzoneZipCacheHelper.TAG, 2, String.format("download fail,url:%s,path:%s", filterUrl, path));
                            }
                        }
                        if (file3.exists()) {
                            q.c(file3);
                        }
                    } catch (Throwable unused) {
                    }
                    synchronized (QzoneZipCacheHelper.URL_LOCK) {
                        CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList) QzoneZipCacheHelper.sDownloadindUrlMap.get(str);
                        if (copyOnWriteArrayList2 != null) {
                            Iterator it = copyOnWriteArrayList2.iterator();
                            while (it.hasNext()) {
                                QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack2 = (QzoneZipCacheHelperCallBack) it.next();
                                qzoneZipCacheHelperCallBack2.onResult(z17);
                                qzoneZipCacheHelperCallBack2.onResultOfNativeRequest(true, path, str);
                            }
                        }
                        QzoneZipCacheHelper.sDownloadindUrlMap.remove(str);
                    }
                }
            }, 2, null, false);
            return false;
        }
    }

    public static String[] getFolderFileNameList(String str, String str2, String str3) {
        return getFileList(getFileCache().getPath(getFolderName(str, str2)) + File.separator + str3);
    }

    public static File getFileIfExists(AppInterface appInterface, String str, String str2, String str3, String str4, QzoneOfflineCacheHelperCallBack qzoneOfflineCacheHelperCallBack) {
        try {
            File file = new File(getFileCache().getPath(getFolderName(str3, str4)) + File.separator + str2);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            updateLruFileInNewThread(str3, str4);
            return file;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }
}
