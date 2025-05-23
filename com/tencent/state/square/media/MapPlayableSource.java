package com.tencent.state.square.media;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.state.square.download.DownloadsKt;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/media/MapPlayableSource;", "Ljava/io/Serializable;", "mediaSource", "Lcom/tencent/state/square/media/MediaSource;", "defaultResourceId", "", "showSize", "Lcom/tencent/state/square/media/Size;", "filamentUrl", "", "(Lcom/tencent/state/square/media/MediaSource;ILcom/tencent/state/square/media/Size;Ljava/lang/String;)V", "cacheFile", "Ljava/io/File;", "getCacheFile", "()Ljava/io/File;", QAdRewardDefine$VideoParams.CACHE_PATH, "getCachePath", "()Ljava/lang/String;", "coverFile", "getCoverFile", QQWinkConstants.COVER_PATH, "getCoverPath", "coverUrl", "getCoverUrl", "getDefaultResourceId", "()I", "getFilamentUrl", "isPlayWithDownload", "", "()Z", "getMediaSource", "()Lcom/tencent/state/square/media/MediaSource;", "remoteUrl", "getRemoteUrl", "getShowSize", "()Lcom/tencent/state/square/media/Size;", "supportFilament", "getSupportFilament", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class MapPlayableSource implements Serializable {
    private final int defaultResourceId;
    private final String filamentUrl;
    private final MediaSource mediaSource;
    private final Size showSize;

    public MapPlayableSource(MediaSource mediaSource, int i3, Size size, String filamentUrl) {
        Intrinsics.checkNotNullParameter(mediaSource, "mediaSource");
        Intrinsics.checkNotNullParameter(filamentUrl, "filamentUrl");
        this.mediaSource = mediaSource;
        this.defaultResourceId = i3;
        this.showSize = size;
        this.filamentUrl = filamentUrl;
    }

    public final File getCacheFile() {
        return DownloadsKt.getCacheFile(this.mediaSource);
    }

    public final String getCachePath() {
        return this.mediaSource.getCachePath();
    }

    public final File getCoverFile() {
        return ISquarePlayerKt.getCoverFile(this.mediaSource);
    }

    public final String getCoverPath() {
        return this.mediaSource.getCoverPath();
    }

    public final String getCoverUrl() {
        return this.mediaSource.getCoverUrl();
    }

    public final int getDefaultResourceId() {
        return this.defaultResourceId;
    }

    public final String getFilamentUrl() {
        return this.filamentUrl;
    }

    public final MediaSource getMediaSource() {
        return this.mediaSource;
    }

    public final String getRemoteUrl() {
        return this.mediaSource.getRemoteUrl();
    }

    public final Size getShowSize() {
        return this.showSize;
    }

    public final boolean getSupportFilament() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.filamentUrl);
        return !isBlank;
    }

    public final boolean isPlayWithDownload() {
        return this.mediaSource.getIsPlayWithDownload();
    }

    public /* synthetic */ MapPlayableSource(MediaSource mediaSource, int i3, Size size, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaSource, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : size, (i16 & 8) != 0 ? "" : str);
    }
}
