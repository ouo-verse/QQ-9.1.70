package com.tencent.mobileqq.app.message.filescan.api;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.c;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0006H&J0\u0010\u0015\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0012`\u0014H&J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0017\u001a\u00020\u0006H&JN\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004H&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/api/IStorageFileHelperApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "path", "", "getDirSize", "", "deleteFilesInDirectory", "Lcom/tencent/mobileqq/app/message/filescan/c;", "callback", "getCacheSize", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "isOptimizeStorageUI", "scanCacheFile", "getWhiteListSize", "cleanUpThorough", "Ljava/util/ArrayList;", "", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Lkotlin/collections/ArrayList;", "getCleanUpThoroughBusinessPath", "isFileUnderPublicDir", "releaseCleanupManager", "size", "isFile", "isWhiteListFile", "isPublicFile", "name", "totalSize", "cantClearSize", "reportFileSizeInfo", "storage-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IStorageFileHelperApi extends QRouteApi {
    void cleanUpThorough();

    void clearCache();

    void deleteFilesInDirectory(@NotNull String path);

    long getCacheSize(@Nullable c callback);

    @NotNull
    ArrayList<Map.Entry<String, y>> getCleanUpThoroughBusinessPath();

    long getDirSize(@NotNull String path);

    long getWhiteListSize();

    boolean isFileUnderPublicDir(@NotNull String path);

    void releaseCleanupManager();

    void reportFileSizeInfo(@NotNull String path, long size, boolean isFile, boolean isWhiteListFile, boolean isPublicFile, @NotNull String name, long totalSize, long cantClearSize);

    long scanCacheFile(boolean isOptimizeStorageUI);
}
