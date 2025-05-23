package com.tencent.state.decode;

import com.tencent.state.square.DefaultDownloadListener;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.zplan.common.utils.d;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00040\bH\u0002J&\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00040\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/decode/ImageLoader;", "", "()V", "download", "", "url", "", "callback", "Lkotlin/Function1;", "loadImage", "remoteUrl", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class ImageLoader {
    private static final String CACHE_DIR = "backgroundMap";
    private static final String TAG = "ImageLoader";

    /* JADX INFO: Access modifiers changed from: private */
    public final void download(String url, final Function1<? super String, Unit> callback) {
        String c16 = d.c(url);
        SquareBase squareBase = SquareBase.INSTANCE;
        File file = new File(squareBase.getConfig().getRootCacheDir(), "backgroundMap/" + c16);
        if (file.exists()) {
            callback.invoke(file.getAbsolutePath());
            return;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "cache.absolutePath");
        squareBase.getConfig().getDownloader().download(new IHttpDownloader.Task(url, absolutePath), new DefaultDownloadListener() { // from class: com.tencent.state.decode.ImageLoader$download$1
            @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), com.nostra13.universalimageloader.core.ImageLoader.TAG, "download task fail " + errorCode + TokenParser.SP + errorMessage, null, 4, null);
                Function1.this.invoke(null);
            }

            @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                SquareBaseKt.getSquareLog().d(com.nostra13.universalimageloader.core.ImageLoader.TAG, "download task success " + resultFile.getAbsolutePath());
                Function1.this.invoke(resultFile.getAbsolutePath());
            }
        });
    }

    public final void loadImage(String remoteUrl, Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (remoteUrl == null || remoteUrl.length() == 0) {
            callback.invoke(null);
        } else {
            SquareBaseKt.getSquareThread().postOnFileThread(new ImageLoader$loadImage$1(this, remoteUrl, callback));
        }
    }
}
