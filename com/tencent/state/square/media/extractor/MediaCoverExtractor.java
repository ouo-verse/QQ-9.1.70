package com.tencent.state.square.media.extractor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/media/extractor/MediaCoverExtractor;", "", "()V", "compose", "Landroid/graphics/Bitmap;", "src", "composeAboveO", "", "dst", "composeColor", "", c.f123400v, "rgb", "extract", "", "videoPath", "", QQWinkConstants.COVER_PATH, "listener", "Lcom/tencent/state/square/media/extractor/MediaCoverListener;", "save", "cover", "path", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MediaCoverExtractor {
    private static final String TAG = "MediaCoverExtractor";

    private final Bitmap compose(Bitmap src) {
        Bitmap cover = Bitmap.createBitmap(src.getWidth() / 2, src.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        composeAboveO(src, cover);
        return cover;
    }

    private final void composeAboveO(Bitmap src, Bitmap dst) {
        int[] iArr = new int[src.getWidth() * src.getHeight()];
        src.getPixels(iArr, 0, src.getWidth(), 0, 0, src.getWidth(), src.getHeight());
        int[] iArr2 = new int[dst.getWidth() * dst.getHeight()];
        int width = dst.getWidth();
        for (int i3 = 0; i3 < width; i3++) {
            int height = dst.getHeight();
            for (int i16 = 0; i16 < height; i16++) {
                iArr2[(dst.getHeight() * i16) + i3] = composeColor(iArr[(src.getWidth() * i16) + i3], iArr[(src.getWidth() * i16) + i3 + dst.getWidth()]);
            }
        }
        dst.setPixels(iArr2, 0, dst.getWidth(), 0, 0, dst.getWidth(), dst.getHeight());
    }

    private final int composeColor(int alpha, int rgb) {
        int red = Color.red(alpha);
        float f16 = red / 255.0f;
        return Color.argb(red, (int) (Color.red(rgb) * f16), (int) (Color.green(rgb) * f16), (int) (Color.blue(rgb) * f16));
    }

    private final boolean save(Bitmap cover, String path) {
        File parentFile;
        File file = new File(path);
        File parentFile2 = file.getParentFile();
        if (parentFile2 != null && !parentFile2.exists() && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            boolean compress = cover.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            CloseableKt.closeFinally(fileOutputStream, null);
            return compress;
        } finally {
        }
    }

    public final boolean extract(String videoPath, String coverPath, MediaCoverListener listener) {
        boolean z16;
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SquareBaseKt.getSquareLog().i(TAG, "extract: videoPath=" + videoPath + ", coverPath=" + coverPath);
        listener.onStart();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(videoPath);
            z16 = true;
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "setDataSource path error" + videoPath + " , " + coverPath, null, 4, null);
            listener.onError(1, String.valueOf(e16.getMessage()));
            z16 = false;
        }
        listener.onInitDone();
        if (z16) {
            listener.onGetFrameStart();
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
            listener.onGetFrameDone();
            boolean z17 = frameAtTime != null;
            if (frameAtTime == null) {
                listener.onError(2, "\u62bd\u5e27\u4e3a\u7a7a");
                z16 = z17;
            } else {
                listener.onComposeStart();
                try {
                    bitmap = compose(frameAtTime);
                } catch (Throwable th5) {
                    String message = th5.getMessage();
                    if (message == null) {
                        message = "compose throw exception";
                    }
                    listener.onError(5, message);
                    SquareBaseKt.getSquareLog().e(TAG, "compose throw:", th5);
                    bitmap = null;
                }
                listener.onComposeDone();
                boolean z18 = bitmap != null;
                if (bitmap != null) {
                    listener.getCoverDone(bitmap);
                    z16 = save(bitmap, coverPath);
                    if (!z16) {
                        listener.onError(4, "\u4fdd\u5b58\u51fa\u9519");
                    }
                } else {
                    z16 = z18;
                }
            }
        }
        listener.onExtractDone();
        return z16;
    }
}
