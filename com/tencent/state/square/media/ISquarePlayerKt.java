package com.tencent.state.square.media;

import android.media.MediaFormat;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\n"}, d2 = {"coverFile", "Ljava/io/File;", "Lcom/tencent/state/square/media/MediaSource;", "getCoverFile", "(Lcom/tencent/state/square/media/MediaSource;)Ljava/io/File;", CanvasView.CUSTOM_ACTION_FILL, "", "Lcom/tencent/state/square/media/VideoInfo;", "format", "Landroid/media/MediaFormat;", "square_media_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ISquarePlayerKt {
    public static final void fill(VideoInfo fill, MediaFormat format) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        Intrinsics.checkNotNullParameter(format, "format");
        fill.setFormat(format);
        String string = format.getString("mime");
        if (string == null) {
            string = "";
        }
        fill.setMime(string);
        fill.setWidth(format.getInteger("width"));
        fill.setHeight(format.getInteger("height"));
        if (format.containsKey("frame-rate")) {
            fill.setFrameRate(format.getInteger("frame-rate"));
        }
    }

    public static final File getCoverFile(MediaSource coverFile) {
        Intrinsics.checkNotNullParameter(coverFile, "$this$coverFile");
        return new File(coverFile.getCoverPath());
    }
}
