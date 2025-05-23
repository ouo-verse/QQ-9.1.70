package com.tencent.state.square.avatar.filament;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.cache.DiskLruCache;
import com.tencent.state.square.download.Source;
import com.tencent.state.square.download.SquareDownloader;
import com.tencent.zplan.common.utils.d;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0016\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\u001e\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020\u0018J\u0012\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020\u0004H\u0002J\"\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020)H\u0002J\u0010\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/state/square/avatar/filament/FilamentZipFileUtils;", "", "()V", "DIR_NAME", "", "DIR_ZIP_NAME", "JSON_NAME", "MAX_CACHE_COUNT", "", "TAG", "TASK_FAIL_CODE_MOOD_JSON_NULL", "cacheDir", "Ljava/io/File;", "getCacheDir", "()Ljava/io/File;", "cacheFileLock", "Ljava/util/concurrent/locks/ReentrantLock;", "diskCache", "Lcom/tencent/state/square/cache/DiskLruCache;", "downloadQueen", "Lcom/tencent/state/square/avatar/filament/FilamentDownloadManager;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/state/square/download/SquareDownloader;", "deleteCacheFile", "", "url", "cb", "Lkotlin/Function0;", "doDeleteFile", "file", "downloadFile", "listener", "Lcom/tencent/state/square/avatar/filament/UnZipListener;", "getCachePath", "getDirCachePath", "getMoodConfigPath", "path", "getMoodJson", "Lorg/json/JSONObject;", QzoneZipCacheHelper.DIR, "fromCache", "", "init", "readJsonFile", WadlProxyConsts.PARAM_FILENAME, "returnIfExists", "cacheDirFile", "stringToJson", "jsonString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentZipFileUtils {
    private static final String DIR_NAME = "state_filament";
    private static final String DIR_ZIP_NAME = "un_zip";
    public static final FilamentZipFileUtils INSTANCE;
    private static final String JSON_NAME = "MoodConfig.json";
    private static final int MAX_CACHE_COUNT = 200;
    private static final String TAG = "SquareZipFileUtils";
    private static final int TASK_FAIL_CODE_MOOD_JSON_NULL = -2;
    private static final ReentrantLock cacheFileLock;
    private static final DiskLruCache diskCache;
    private static FilamentDownloadManager downloadQueen;
    private static final SquareDownloader downloader;

    static {
        FilamentZipFileUtils filamentZipFileUtils = new FilamentZipFileUtils();
        INSTANCE = filamentZipFileUtils;
        DiskLruCache diskLruCache = new DiskLruCache(filamentZipFileUtils.getCacheDir(), 200, null, 4, null);
        diskCache = diskLruCache;
        downloader = new SquareDownloader(diskLruCache);
        cacheFileLock = new ReentrantLock();
    }

    FilamentZipFileUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDeleteFile(File file) {
        boolean delete;
        if (file.isDirectory()) {
            delete = FilesKt__UtilsKt.deleteRecursively(file);
        } else {
            delete = file.delete();
        }
        SquareBaseKt.getSquareLog().i(TAG, "do deleteFile: " + delete + "\uff0cfile: " + file.getPath());
    }

    private final File getCacheDir() {
        return new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), DIR_NAME);
    }

    private final String getCachePath(String url) {
        return getCacheDir() + '/' + d.c(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDirCachePath(String url) {
        return getCacheDir() + "/un_zip/" + d.c(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getMoodConfigPath(String path) {
        return Square.INSTANCE.getConfig().getZipUtils().findFileInDirectory(new File(path), JSON_NAME);
    }

    private final String readJsonFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charsets.UTF_8));
                StringBuilder sb5 = new StringBuilder();
                try {
                    Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
                    while (it.hasNext()) {
                        sb5.append(it.next());
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    return sb5.toString();
                } finally {
                }
            } else {
                SquareBaseKt.getSquareLog().i(TAG, "[readJsonFile]: file not exist: " + fileName);
                return null;
            }
        } catch (Exception e16) {
            SquareBaseKt.getSquareLog().i(TAG, "[readJsonFile]: e: " + e16);
            return null;
        }
    }

    private final boolean returnIfExists(File cacheDirFile, String url, boolean fromCache) {
        if (!cacheDirFile.exists()) {
            return false;
        }
        String absolutePath = cacheDirFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "cacheDirFile.absolutePath");
        JSONObject moodJson = getMoodJson(getMoodConfigPath(absolutePath), fromCache);
        if (moodJson != null) {
            FilamentDownloadManager filamentDownloadManager = downloadQueen;
            if (filamentDownloadManager != null) {
                filamentDownloadManager.successTask(url, moodJson);
            }
            SquareBaseKt.getSquareLog().i(TAG, "[returnIfExists]: get mood json from cache: " + INSTANCE.getCacheDir().getAbsolutePath() + ", from cache: " + fromCache);
            return true;
        }
        SquareBaseKt.getSquareLog().i(TAG, "[returnIfExists]: cache dir exist, but mood json not exist, fromCache: " + fromCache);
        deleteCacheFile$default(this, url, null, 2, null);
        return false;
    }

    private final Object stringToJson(String jsonString) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jsonString, "{", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jsonString, "[", false, 2, null);
            if (startsWith$default2) {
                return new JSONArray(jsonString);
            }
            throw new IllegalArgumentException("Invalid JSON string");
        }
        return new JSONObject(jsonString);
    }

    public final void deleteCacheFile(final String url, final Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(url, "url");
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.FilamentZipFileUtils$deleteCacheFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReentrantLock reentrantLock;
                ReentrantLock reentrantLock2;
                ReentrantLock reentrantLock3;
                String dirCachePath;
                FilamentZipFileUtils filamentZipFileUtils = FilamentZipFileUtils.INSTANCE;
                reentrantLock = FilamentZipFileUtils.cacheFileLock;
                reentrantLock.lock();
                try {
                    dirCachePath = filamentZipFileUtils.getDirCachePath(url);
                    File file = new File(dirCachePath);
                    boolean exists = file.exists();
                    if (exists) {
                        filamentZipFileUtils.doDeleteFile(file);
                    }
                    Function0 function0 = cb5;
                    if (function0 != null) {
                    }
                    SquareBaseKt.getSquareLog().i("SquareZipFileUtils", "deleteCacheFile doDelete: " + url + ", exists: " + exists);
                } catch (Throwable th5) {
                    try {
                        Function0 function02 = cb5;
                        if (function02 != null) {
                        }
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareZipFileUtils", "deleteCacheFile error: " + url + ", " + th5, null, 4, null);
                        filamentZipFileUtils = FilamentZipFileUtils.INSTANCE;
                    } catch (Throwable th6) {
                        FilamentZipFileUtils filamentZipFileUtils2 = FilamentZipFileUtils.INSTANCE;
                        reentrantLock2 = FilamentZipFileUtils.cacheFileLock;
                        reentrantLock2.unlock();
                        throw th6;
                    }
                }
                reentrantLock3 = FilamentZipFileUtils.cacheFileLock;
                reentrantLock3.unlock();
            }
        });
    }

    public final void downloadFile(String url, UnZipListener listener) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            listener.onTaskFailed(-1, "parseName err");
            return;
        }
        String cachePath = getCachePath(url);
        String dirCachePath = getDirCachePath(url);
        File file = new File(dirCachePath);
        FilamentDownloadManager filamentDownloadManager = downloadQueen;
        if ((filamentDownloadManager == null || !filamentDownloadManager.addTask(url, listener)) && !returnIfExists(file, url, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            SquareBaseKt.getSquareLog().i(TAG, "downloadFile, startDownload zip");
            downloader.addHighTask(new Source(url, cachePath), new FilamentZipFileUtils$downloadFile$1(currentTimeMillis, url, file, dirCachePath, cachePath));
        }
    }

    public final void init() {
        if (!getCacheDir().exists()) {
            getCacheDir().mkdirs();
        }
        diskCache.buildDir(DIR_ZIP_NAME);
        downloadQueen = new FilamentDownloadManager();
    }

    private final JSONObject getMoodJson(String dir, boolean fromCache) {
        String replace$default;
        if (dir == null) {
            SquareBaseKt.getSquareLog().i(TAG, "getMoodJson dir is null");
            return null;
        }
        try {
            String readJsonFile = readJsonFile(dir);
            if (readJsonFile == null) {
                return null;
            }
            Object stringToJson = stringToJson(readJsonFile);
            if (!(stringToJson instanceof JSONObject)) {
                stringToJson = null;
            }
            JSONObject jSONObject = (JSONObject) stringToJson;
            if (jSONObject != null) {
                replace$default = StringsKt__StringsJVMKt.replace$default(dir, JSON_NAME, "", false, 4, (Object) null);
                jSONObject.put(QzoneZipCacheHelper.DIR, replace$default);
            }
            if (jSONObject != null) {
                jSONObject.put("fromCache", fromCache);
            }
            return jSONObject;
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "getMoodJson error: " + th5, null, 4, null);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void deleteCacheFile$default(FilamentZipFileUtils filamentZipFileUtils, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        filamentZipFileUtils.deleteCacheFile(str, function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ JSONObject getMoodJson$default(FilamentZipFileUtils filamentZipFileUtils, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return filamentZipFileUtils.getMoodJson(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean returnIfExists$default(FilamentZipFileUtils filamentZipFileUtils, File file, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        return filamentZipFileUtils.returnIfExists(file, str, z16);
    }
}
