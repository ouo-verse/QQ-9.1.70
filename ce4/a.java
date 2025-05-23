package ce4;

import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.DefaultMediaMuxer;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tavkit.tavffmpeg.FFmpegMuxer;
import com.tencent.tavkit.tavffmpeg.TAVFFmpegResourceLoader;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R(\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lce4/a;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "", "path", "", "format", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "createMediaMuxer", "<set-?>", "a", "Ljava/lang/String;", "getMuxerName", "()Ljava/lang/String;", "muxerName", "<init>", "()V", "b", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a implements MediaMuxerFactory.MediaMuxerCreator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String muxerName;

    @Override // com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator
    @NotNull
    public synchronized IMediaMuxer createMediaMuxer(@NotNull String path, int format) throws IOException {
        Intrinsics.checkParameterIsNotNull(path, "path");
        ee4.b.e("FFmpegMuxerCreator", "createMediaMuxer() called with: path = [" + path + "], format = [" + format + ']');
        if (TAVFFmpegResourceLoader.isSoLoaded()) {
            try {
                FFmpegMuxer fFmpegMuxer = new FFmpegMuxer(path, "");
                this.muxerName = "fFmpegMuxer";
                return fFmpegMuxer;
            } catch (Exception e16) {
                Logger.e("FFmpegMuxerCreator", "createMediaMuxer: ", e16);
            }
        }
        this.muxerName = "defaultMediaMuxer";
        return new DefaultMediaMuxer(path, format);
    }
}
