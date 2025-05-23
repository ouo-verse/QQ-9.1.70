package com.tencent.state.utils;

import android.app.Application;
import com.tencent.state.square.IDownloadListener;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.zplan.common.utils.d;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/utils/DownloadUtils;", "", "()V", "TAG", "", "downloadFile", "", "url", "listener", "Lcom/tencent/state/square/IDownloadListener;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DownloadUtils {
    public static final DownloadUtils INSTANCE = new DownloadUtils();
    private static final String TAG = "DownloadUtils";

    DownloadUtils() {
    }

    public final void downloadFile(String url, final IDownloadListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String c16 = d.c(url);
        if (c16 == null || c16.length() == 0) {
            listener.onTaskFailed(-1, "parseName err");
            return;
        }
        SquareBase squareBase = SquareBase.INSTANCE;
        Application app = squareBase.getApp();
        File file = new File(app != null ? app.getExternalFilesDir(null) : null, c16);
        if (file.exists() && file.length() > 0) {
            SquareBaseKt.getSquareLog().i(TAG, "downloadPagFile, pag exists");
            listener.onTaskSuccess(file);
        } else {
            SquareBaseKt.getSquareLog().i(TAG, "downloadPagFile, startDownload pag");
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            squareBase.getConfig().getDownloader().download(new IHttpDownloader.Task(url, absolutePath), new SimpleDownloadListener() { // from class: com.tencent.state.utils.DownloadUtils$downloadFile$1
                @Override // com.tencent.state.square.IDownloadListener
                public void onTaskFailed(int errorCode, String errorMessage) {
                    Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                    SquareBaseKt.getSquareLog().i("DownloadUtils", "downloadPagFile, download failed: " + errorCode + ", " + errorMessage);
                    IDownloadListener.this.onTaskFailed(errorCode, errorMessage);
                }

                @Override // com.tencent.state.square.IDownloadListener
                public void onTaskSuccess(File resultFile) {
                    Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                    SquareBaseKt.getSquareLog().i("DownloadUtils", "downloadPagFile, download success");
                    IDownloadListener.this.onTaskSuccess(resultFile);
                }
            });
        }
    }
}
