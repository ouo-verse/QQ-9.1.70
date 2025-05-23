package com.tencent.state.square.avatar.filament;

import com.tencent.state.square.IZipUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.download.DownloadCallback;
import com.tencent.state.square.download.Source;
import com.tencent.state.square.download.TaskProgress;
import com.tencent.state.square.download.TaskResponse;
import com.tencent.zplan.common.soloader.d;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/state/square/avatar/filament/FilamentZipFileUtils$downloadFile$1", "Lcom/tencent/state/square/download/DownloadCallback;", "onTaskFailed", "", "source", "Lcom/tencent/state/square/download/Source;", "response", "Lcom/tencent/state/square/download/TaskResponse;", "onTaskSuccess", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentZipFileUtils$downloadFile$1 implements DownloadCallback {
    final /* synthetic */ File $cacheDirFile;
    final /* synthetic */ String $cacheDirPath;
    final /* synthetic */ String $cachePath;
    final /* synthetic */ long $startTime;
    final /* synthetic */ String $url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilamentZipFileUtils$downloadFile$1(long j3, String str, File file, String str2, String str3) {
        this.$startTime = j3;
        this.$url = str;
        this.$cacheDirFile = file;
        this.$cacheDirPath = str2;
        this.$cachePath = str3;
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskFailed(Source source, TaskResponse response) {
        FilamentDownloadManager filamentDownloadManager;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        SquareBaseKt.getSquareLog().i("SquareZipFileUtils", "downloadFile, download failed: " + response.getErrorCode());
        FilamentZipFileUtils filamentZipFileUtils = FilamentZipFileUtils.INSTANCE;
        filamentDownloadManager = FilamentZipFileUtils.downloadQueen;
        if (filamentDownloadManager != null) {
            filamentDownloadManager.errorTask(this.$url, response.getErrorCode(), "download failed");
        }
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskProgress(Source source, TaskResponse response, TaskProgress progress) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(progress, "progress");
        DownloadCallback.DefaultImpls.onTaskProgress(this, source, response, progress);
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskStart(Source source, TaskResponse response) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        DownloadCallback.DefaultImpls.onTaskStart(this, source, response);
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskSuccess(final Source source, TaskResponse response) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        SquareBaseKt.getSquareLog().d("SquareZipFileUtils", "success downloadFile  cost: " + (System.currentTimeMillis() - this.$startTime) + ", " + this.$url);
        if (FilamentZipFileUtils.returnIfExists$default(FilamentZipFileUtils.INSTANCE, this.$cacheDirFile, this.$url, false, 4, null)) {
            SquareBaseKt.getSquareLog().d("SquareZipFileUtils", "same url: " + this.$url);
            return;
        }
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.FilamentZipFileUtils$downloadFile$1$onTaskSuccess$1
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
                String dirCachePath;
                ReentrantLock reentrantLock3;
                FilamentDownloadManager filamentDownloadManager;
                String moodConfigPath;
                FilamentDownloadManager filamentDownloadManager2;
                FilamentDownloadManager filamentDownloadManager3;
                try {
                    FilamentZipFileUtils filamentZipFileUtils = FilamentZipFileUtils.INSTANCE;
                    reentrantLock2 = FilamentZipFileUtils.cacheFileLock;
                    reentrantLock2.lock();
                    IZipUtils zipUtils = Square.INSTANCE.getConfig().getZipUtils();
                    String cachePath = source.getCachePath();
                    dirCachePath = filamentZipFileUtils.getDirCachePath(FilamentZipFileUtils$downloadFile$1.this.$url);
                    int unZip = zipUtils.unZip(cachePath, dirCachePath);
                    reentrantLock3 = FilamentZipFileUtils.cacheFileLock;
                    reentrantLock3.unlock();
                    SquareBaseKt.getSquareLog().i("SquareZipFileUtils", "unzip cost: " + (System.currentTimeMillis() - FilamentZipFileUtils$downloadFile$1.this.$startTime) + "\uff0c result: " + unZip);
                    if (unZip == 0) {
                        moodConfigPath = filamentZipFileUtils.getMoodConfigPath(FilamentZipFileUtils$downloadFile$1.this.$cacheDirPath);
                        JSONObject moodJson$default = FilamentZipFileUtils.getMoodJson$default(filamentZipFileUtils, moodConfigPath, false, 2, null);
                        if (moodJson$default != null) {
                            filamentDownloadManager3 = FilamentZipFileUtils.downloadQueen;
                            if (filamentDownloadManager3 != null) {
                                filamentDownloadManager3.successTask(FilamentZipFileUtils$downloadFile$1.this.$url, moodJson$default);
                            }
                            SquareBaseKt.getSquareLog().d("SquareZipFileUtils", "success getMoodJson cost: " + (System.currentTimeMillis() - FilamentZipFileUtils$downloadFile$1.this.$startTime));
                        } else {
                            filamentDownloadManager2 = FilamentZipFileUtils.downloadQueen;
                            if (filamentDownloadManager2 != null) {
                                filamentDownloadManager2.errorTask(FilamentZipFileUtils$downloadFile$1.this.$url, -2, "fail get mood json, url: " + FilamentZipFileUtils$downloadFile$1.this.$url + ", cacheDir: " + FilamentZipFileUtils$downloadFile$1.this.$cacheDirPath);
                            }
                        }
                        d.f385270a.a(new File(FilamentZipFileUtils$downloadFile$1.this.$cachePath));
                        return;
                    }
                    filamentDownloadManager = FilamentZipFileUtils.downloadQueen;
                    if (filamentDownloadManager != null) {
                        filamentDownloadManager.errorTask(FilamentZipFileUtils$downloadFile$1.this.$url, -1, "unZip: result !=0, " + unZip);
                    }
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareZipFileUtils", "error unZip: result != 0", null, 4, null);
                } catch (Throwable th5) {
                    FilamentZipFileUtils filamentZipFileUtils2 = FilamentZipFileUtils.INSTANCE;
                    reentrantLock = FilamentZipFileUtils.cacheFileLock;
                    reentrantLock.unlock();
                    throw th5;
                }
            }
        });
    }
}
