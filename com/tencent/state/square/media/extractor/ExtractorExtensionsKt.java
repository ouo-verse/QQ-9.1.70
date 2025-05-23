package com.tencent.state.square.media.extractor;

import android.media.MediaExtractor;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.download.DownloadCallback;
import com.tencent.state.square.download.DownloadsKt;
import com.tencent.state.square.download.Source;
import com.tencent.state.square.download.TaskProgress;
import com.tencent.state.square.download.TaskResponse;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.square.media.SquareMedia;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\t2\u0006\u0010\r\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"TAG", "", IPrefRecorder.MILESTONE_EXTRACT_COVER, "", "Lcom/tencent/state/square/media/MediaSource;", "listener", "Lcom/tencent/state/square/media/extractor/MediaCoverListener;", "setDataSource", "", "Landroid/media/MediaExtractor;", "source", "setDataSourceWithDownload", "Lcom/tencent/state/square/media/extractor/MediaFuture;", "mediaSource", "square_media_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ExtractorExtensionsKt {
    private static final String TAG = "ExtractorExtensions";

    public static final boolean extractCover(MediaSource extractCover, MediaCoverListener listener) {
        Intrinsics.checkNotNullParameter(extractCover, "$this$extractCover");
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean z16 = false;
        if (!(extractCover.getCachePath().length() == 0)) {
            if (!(extractCover.getCoverPath().length() == 0)) {
                try {
                    z16 = new MediaCoverExtractor().extract(extractCover.getCachePath(), extractCover.getCoverPath(), listener);
                } catch (Exception unused) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "extractCover path error: " + extractCover.getCachePath() + ", " + extractCover.getCoverPath(), null, 4, null);
                }
                SquareBaseKt.getSquareLog().i(TAG, "extractCover result: " + z16 + ", " + extractCover);
                return z16;
            }
        }
        SquareBaseKt.getSquareLog().i(TAG, "cachePath is null");
        return false;
    }

    public static final void setDataSource(MediaExtractor setDataSource, MediaSource source) {
        Intrinsics.checkNotNullParameter(setDataSource, "$this$setDataSource");
        Intrinsics.checkNotNullParameter(source, "source");
        if (SquareUtil.INSTANCE.canPlayWithDownload() && source.getIsPlayWithDownload()) {
            setDataSource.setDataSource(new SystemMediaDataSource(source));
        } else {
            setDataSource.setDataSource(source.getCachePath());
        }
    }

    public static final MediaFuture setDataSourceWithDownload(final MediaExtractor setDataSourceWithDownload, final MediaSource mediaSource) {
        Intrinsics.checkNotNullParameter(setDataSourceWithDownload, "$this$setDataSourceWithDownload");
        Intrinsics.checkNotNullParameter(mediaSource, "mediaSource");
        final MediaFuture mediaFuture = new MediaFuture(mediaSource);
        if (DownloadsKt.getCacheFile(mediaSource).exists()) {
            setDataSourceWithDownload.setDataSource(mediaSource.getCachePath());
            mediaFuture.setSuccess(Boolean.TRUE);
        } else {
            SquareBaseKt.getSquareLog().i(TAG, "setDataSourceWithDownload: " + mediaSource);
            SquareMedia.INSTANCE.getDownloader().addHighTask(mediaSource, new DownloadCallback() { // from class: com.tencent.state.square.media.extractor.ExtractorExtensionsKt$setDataSourceWithDownload$1
                @Override // com.tencent.state.square.download.DownloadCallback
                public void onTaskFailed(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ExtractorExtensions", "onTaskFailed: " + source, null, 4, null);
                    mediaFuture.setSuccess(Boolean.FALSE);
                    mediaFuture.complete();
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
                public void onTaskSuccess(Source source, TaskResponse response) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(response, "response");
                    SquareBaseKt.getSquareLog().i("ExtractorExtensions", "onTaskSuccess: " + source);
                    mediaFuture.setSuccess(Boolean.TRUE);
                    setDataSourceWithDownload.setDataSource(mediaSource.getCachePath());
                    mediaFuture.complete();
                }
            });
            mediaFuture.await();
        }
        return mediaFuture;
    }
}
