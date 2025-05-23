package cooperation.qzone.cache;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneUndealCountApi;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.cache.FileStorageHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CacheManager {
    public static final int AUDIO_EXTERNAL_CAPACITY = 104857600;
    public static final String AUDIO_FILE_CACHE_NAME = "audio";
    public static final int AUDIO_INTERNAL_CAPACITY = 41943040;
    public static final int AVATAR_EXTERNAL_CAPACITY = 52428800;
    public static final String AVATAR_FILE_CACHE_NAME = "avatar";
    public static final int AVATAR_INTERNAL_CAPACITY = 20971520;
    public static final String DEHAZE_PIC = "dehaze_pic";
    public static final String GIFT_FULLSCREEN_PATH = "gift_fullscreen";
    public static final String GIFT_PASSIVE_PRAISE_PATH = "passive_praise";
    public static final String HEAD_DROP_OPERATION = "head_drop_operaion";
    public static final int IMAGE_EXTERNAL_CAPACITY = 104857600;
    public static final String IMAGE_FILE_CACHE_NAME = "batch_image";
    public static final int IMAGE_INTERNAL_CAPACITY = 62914560;
    private static final int MEGABYTES = 1048576;
    private static final String NO_SDCARD_TIPS = "\u65e0SD Card";
    public static final int PERSONALISE_FONT_EXTERNAL_CAPACITY = 104857600;
    public static final int PERSONALISE_FONT_INTERNAL_CAPACITY = 41943040;
    public static final String PERSONALISE_FONT_PATH = "personalise_font";
    public static final String PERSONALITY_CANVAS_CACHE_NAME = "personality_canvas";
    public static final int PERSONALITY_CANVAS_FILE_EXTERNAL_CAPACITY = 2097152;
    public static final int PERSONALITY_CANVAS_FILE_INTERNAL_CAPACITY = 1048576;
    public static final String PLUS_DECORATE_DIR = "plus_decorate";
    public static final String PLUS_OPERATION = "plus_operation";
    public static final String QZONE_TEMP_IMAGE_SHARE = "qzone_temp_image_share";
    public static final String QZONE_WIDGETAI_NAME = "qzone_widgetai";
    public static final int QZONE_WIDGETAI_NAME_EXTERNAL_CAPACITY = 104857600;
    public static final int QZONE_WIDGETAI_NAME_INTERNAL_CAPACITY = 20971520;
    public static final String RAPID_COMMENT_PATH = "rapid_comment";
    public static final String REACT_CACHE_NAME = "react";
    public static final String SHAISHAI_DIR = "shaishai";
    public static final String SMART_BEAUTIFY_RESOURCE_PATH = "smart_beautify";
    public static final String SURPRISE_RESOURCE_PATH = "surprise";
    public static final String TAG = "CacheManager";
    private static final String VERSION = "qua";
    public static final String VIDEO_FILE_CACHE_NAME = "video";
    public static final String VIDEO_PLAY_CACHE_DIR = "video_cache";
    private static final long VIDEO_STORAGE_LOW_BOUND = 5242880;
    private static HashMap<String, Integer> VersionMap = null;
    public static final int WEBVIEW_OFFLINE_EXTERNAL_CAPACITY = 104857600;
    public static final String WEBVIEW_OFFLINE_FILE_CACHE_NAME = "offline";
    public static final int WEBVIEW_OFFLINE_INTERNAL_CAPACITY = 20971520;
    public static final int ZIP_CACHE_INTERNAL_CAPACITY = 20971520;
    public static final String ZIP_CACHE_NAME = "zip_cache";
    public static final int ZIP_CACHE__EXTERNAL_CAPACITY = 104857600;
    private static final HashMap<String, FileCacheService> sFileCacheService = new HashMap<>();
    private static FileStorageHandler sStorageHandler = null;
    private static Object storageHandlerLock = new Object();
    private static HashMap<String, String> mSDCardName2PathMap = new HashMap<>();
    private static volatile boolean mHasLoadSDCardName = false;
    private static String maxAvailableSizePath = "";
    private static long maxAvailableSize = 0;
    private static String storeRootPath = null;

    private static final String calcCapUnit(long j3) {
        return calcCapUnit(0, (float) j3);
    }

    public static void checkAndCleanStorage() {
        getAudioFileCacheService();
        getAvatarFileCacheService();
        getWebviewOfflineFileCacheService();
        getPersonaliseFontCacheService();
        getBatchImageDownloadCacheService();
        getStorageHandler().onCheckAndCleanStorage();
    }

    public static void clearFileCache(Context context) {
        String str = QZoneFilePath.CACHE_DIR_IMAGE;
        if (str != null) {
            q.d(str);
        }
        q.d(QZoneFilePath.CACHE_DIR_IMAGE_SR);
        String str2 = QZoneFilePath.CACHE_DIR_VIDEO;
        if (str2 != null) {
            q.d(str2);
        }
        q.d(QZoneFilePath.CACHE_DIR_VIDEO_PLAY);
        String str3 = QZoneFilePath.CACHE_DIR_FILE;
        if (str3 != null) {
            q.d(str3);
        }
        String str4 = QZoneFilePath.CACHE_DIR_FEEDS;
        if (str4 != null) {
            q.d(str4);
        }
        String storeRootPath2 = getStoreRootPath();
        if (storeRootPath2 != null) {
            q.d(storeRootPath2);
        }
        String internalCacheDir = getInternalCacheDir();
        if (internalCacheDir != null) {
            q.d(internalCacheDir);
        }
        if (getAudioFileCacheService() != null) {
            fileDelete(getAudioFileCacheService().getDir());
        }
        fileDelete(QZoneFilePath.VGIF_SAVE);
        fileDelete(QZoneFilePath.THUMB_BASE_PATH);
        fileDelete(QZoneFilePath.CACHE_DYNAMIC_ALBUM);
        fileDelete(QZoneFilePath.BEAUTY_IMG_PATH);
    }

    private static void clearSP(long j3) {
        String string = LocalMultiProcConfig.getString("qua", "");
        String qua3 = QUA.getQUA3();
        if (!string.equals(qua3)) {
            LocalMultiProcConfig.putString4Uin(IQzoneUndealCountApi.UNDEALCOUNT_FEEDALERT_LAST_GET_TIME, "", j3);
            LocalMultiProcConfig.putString("qua", qua3);
        }
    }

    private static String countToUnit(int i3) {
        if (i3 == 0) {
            return "byte";
        }
        if (i3 == 1) {
            return "KB";
        }
        if (i3 == 2) {
            return "MB";
        }
        if (i3 == 3) {
            return "GB";
        }
        if (i3 == 4) {
            return "TB";
        }
        if (i3 == 5) {
            return "PB";
        }
        return "";
    }

    public static void fileDelete(String str) {
        if (str != null) {
            q.d(str);
        }
    }

    public static FileCacheService getAudioFileCacheService() {
        return getFileCacheService("audio", 104857600, 41943040);
    }

    public static String getAudioGiftSavePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(System.currentTimeMillis());
        }
        File file = getAudioFileCacheService().getFile("audio_gift_" + str, true);
        if (file == null) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public static String getAudioShuoshuoSavePath(Context context, String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(System.currentTimeMillis());
        }
        File file = getAudioFileCacheService().getFile(j3 + "_" + str, true);
        if (file == null) {
            return null;
        }
        return file.getAbsolutePath();
    }

    public static FileCacheService getAvatarFileCacheService() {
        return getFileCacheService("avatar", 52428800, 20971520);
    }

    public static FileCacheService getBatchImageDownloadCacheService() {
        return getFileCacheService(IMAGE_FILE_CACHE_NAME, 104857600, IMAGE_INTERNAL_CAPACITY);
    }

    public static String getCacheDir(String str) {
        String storeRootPath2 = getStoreRootPath();
        if (TextUtils.isEmpty(str)) {
            return storeRootPath2;
        }
        File file = new File(storeRootPath2 + File.separator + str);
        if (file.isFile()) {
            FileUtils.delete(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getCameraPhotoSavePath() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE + UUID.randomUUID().toString() + ".jpg");
    }

    public static String getDehazeDir() {
        return getCacheDir(DEHAZE_PIC);
    }

    public static FileCacheService getFileCacheService(String str, int i3, int i16) {
        FileCacheService fileCacheService;
        AssertUtil.assertTrue(!TextUtils.isEmpty(str));
        HashMap<String, FileCacheService> hashMap = sFileCacheService;
        synchronized (hashMap) {
            fileCacheService = hashMap.get(str);
            if (fileCacheService == null) {
                fileCacheService = new FileCacheService(str, 1, i3, i16);
                fileCacheService.setStorageHandler(getStorageHandler());
                hashMap.put(str, fileCacheService);
            }
        }
        return fileCacheService;
    }

    public static String getGifFullScreenDir() {
        return getCacheDir(GIFT_FULLSCREEN_PATH);
    }

    public static String getHeadDropOperation() {
        return getCacheDir(HEAD_DROP_OPERATION);
    }

    public static String getImageFilePath(Context context, String str) {
        String sb5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String urlKey = getUrlKey(str);
        if (!TextUtils.isEmpty(urlKey)) {
            str = urlKey;
        }
        String valueOf = String.valueOf(str.hashCode());
        if ("mounted".equals(Environment.getExternalStorageState())) {
            sb5 = QZoneFilePath.CACHE_DIR_IMAGE;
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(context.getCacheDir().getAbsolutePath());
            String str2 = File.separator;
            sb6.append(str2);
            sb6.append("qzone");
            sb6.append(str2);
            sb6.append("image");
            sb5 = sb6.toString();
        }
        if (sb5 == null) {
            return null;
        }
        return sb5 + File.separator + valueOf;
    }

    public static String getInternalCacheDir(String str) {
        String internalCacheDir = getInternalCacheDir();
        if (TextUtils.isEmpty(str)) {
            return internalCacheDir;
        }
        File file = new File(internalCacheDir + File.separator + str);
        if (file.isFile()) {
            FileUtils.delete(file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getMoodListIconDir() {
        return getCacheDir("moodlistIcons");
    }

    public static FileCacheService getPersonaliseFontCacheService() {
        return getFileCacheService(PERSONALISE_FONT_PATH, 104857600, 41943040);
    }

    public static final String getPersonaliseFontDir() {
        return getPersonaliseFontCacheService().getDir();
    }

    public static FileCacheService getPersonalityWidgetCacheService() {
        return getFileCacheService(PERSONALITY_CANVAS_CACHE_NAME, 2097152, 1048576);
    }

    public static String getPlusDecorateDir() {
        return getCacheDir(PLUS_DECORATE_DIR);
    }

    public static String getPlusOperationDir() {
        return getCacheDir(PLUS_OPERATION);
    }

    public static String getPraiseDir() {
        return getCacheDir(GIFT_PASSIVE_PRAISE_PATH);
    }

    public static FileCacheService getQzoneWidgetAICacheService() {
        return getFileCacheService(QZONE_WIDGETAI_NAME, 104857600, 20971520);
    }

    public static String getRapidCommentDir() {
        return getCacheDir(RAPID_COMMENT_PATH);
    }

    public static String getReactCacheDir() {
        return getCacheDir("react");
    }

    public static final long getSDCardCapability() {
        if (!isExternalAvailable()) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(getStoreRootPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return -1L;
        }
    }

    public static final String getSDCardCapabilityForDisplay() {
        long sDCardCapability = getSDCardCapability();
        if (sDCardCapability >= 0) {
            return calcCapUnit(sDCardCapability);
        }
        return NO_SDCARD_TIPS;
    }

    public static final long getSDCardRemain() {
        if (!isExternalAvailable()) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(getStoreRootPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return -1L;
        }
    }

    public static final String getSDCardRemainForDisplay() {
        long sDCardRemain = getSDCardRemain();
        if (sDCardRemain >= 0) {
            return calcCapUnit(sDCardRemain);
        }
        return NO_SDCARD_TIPS;
    }

    public static String getShaiShaiDir() {
        return getCacheDir(SHAISHAI_DIR);
    }

    public static String getSmartBeautifyResourceDir() {
        return getCacheDir(SMART_BEAUTIFY_RESOURCE_PATH);
    }

    public static FileStorageHandler getStorageHandler() {
        synchronized (storageHandlerLock) {
            if (sStorageHandler == null) {
                sStorageHandler = new FileStorageHandler(new FileStorageHandler.Collector() { // from class: cooperation.qzone.cache.CacheManager.1
                    @Override // cooperation.qzone.cache.FileStorageHandler.Collector
                    public Collection<FileCacheService> collect() {
                        ArrayList arrayList;
                        synchronized (CacheManager.sFileCacheService) {
                            if (CacheManager.sFileCacheService.size() <= 0) {
                                arrayList = null;
                            } else {
                                arrayList = new ArrayList(CacheManager.sFileCacheService.values());
                            }
                        }
                        return arrayList;
                    }
                });
            }
        }
        return sStorageHandler;
    }

    public static String getStoreRootPath() {
        if (storeRootPath == null) {
            synchronized (CacheManager.class) {
                if (storeRootPath == null) {
                    resetStorePath(false);
                }
            }
        }
        return storeRootPath;
    }

    public static String getSurpriseResourceDir() {
        return getCacheDir(SURPRISE_RESOURCE_PATH);
    }

    public static String getUrlKey(String str) {
        if (isNetworkUrl(str)) {
            int indexOf = str.indexOf(47, 8);
            int indexOf2 = str.indexOf("ek=1");
            if (indexOf2 == -1 && (indexOf2 = str.indexOf(35)) == -1) {
                indexOf2 = str.length();
            }
            return str.substring(indexOf + 1, indexOf2);
        }
        return str;
    }

    public static String getVideoFileCacheDir() {
        return getCacheDir("video");
    }

    public static String getVideoPlayCacheDir() {
        String str = QZoneFilePath.ROOT_QZONE_PATH;
        if (str != null) {
            File file = new File(str);
            if (file.isFile()) {
                FileUtils.delete(file);
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        File file2 = new File(str + File.separator + VIDEO_PLAY_CACHE_DIR);
        if (file2.isFile()) {
            FileUtils.delete(file2);
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.getAbsolutePath();
    }

    public static FileCacheService getWebviewOfflineFileCacheService() {
        return getFileCacheService("offline", 104857600, 20971520);
    }

    public static FileCacheService getZipCacheService() {
        return getFileCacheService(ZIP_CACHE_NAME, 104857600, 20971520);
    }

    public static void initiate(long j3) {
        clearSP(j3);
    }

    public static boolean isExternalAvailable() {
        return SDCardMountMonitorReceiver.getInstance().isSDCardMount();
    }

    public static boolean isInternal(String str) {
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        if (str != null && str.startsWith(absolutePath)) {
            return true;
        }
        return false;
    }

    public static boolean isNetworkUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("https://") && !str.startsWith("https://") && !URLUtil.isNetworkUrl(str)) {
            return false;
        }
        return true;
    }

    private static boolean isStorageSizeLow(String str) {
        boolean z16;
        try {
            StatFs statFs = new StatFs(str);
            long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            if (availableBlocks < VIDEO_STORAGE_LOW_BOUND) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.w(TAG, 1, "low storage: totalSize=" + (statFs.getBlockCount() * statFs.getBlockSize()) + ", availableSize=" + availableBlocks + ", external=" + str);
            }
            return z16;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
            return true;
        }
    }

    public static void onStorageMountChange() {
        mHasLoadSDCardName = false;
        resetStorePath(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resetStorePath(boolean z16) {
        try {
            if (z16) {
                storeRootPath = getInternalCacheDir();
            } else {
                storeRootPath = QZoneFilePath.ROOT_QZONE_PATH;
            }
            File file = new File(storeRootPath);
            if (!file.exists() && !file.mkdirs() && QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Unable to create external cache directory");
            }
            if (file.exists()) {
                File file2 = new File(storeRootPath, ".nomedia");
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    private static final String calcCapUnit(int i3, float f16) {
        if (f16 < 0.0f) {
            return "";
        }
        if (f16 < 1024.0f) {
            return String.format("%.2f", Float.valueOf(f16)) + countToUnit(i3);
        }
        return calcCapUnit(i3 + 1, f16 / 1024.0f);
    }

    public static String getCacheDir(String str, int i3) {
        return getCacheDir(str);
    }

    public static String getInternalCacheDir() {
        File cacheDir = BaseApplication.getContext().getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        return cacheDir.getAbsolutePath() + File.separator + "qzone";
    }
}
