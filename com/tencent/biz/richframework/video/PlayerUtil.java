package com.tencent.biz.richframework.video;

import com.tencent.richframework.video.MediaInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/richframework/video/PlayerUtil;", "", "()V", "convertMediaInfo", "Lcom/tencent/richframework/video/MediaInfo;", "superPlayerMediaInfo", "Lcom/tencent/superplayer/player/MediaInfo;", "qq-video-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayerUtil {

    @NotNull
    public static final PlayerUtil INSTANCE = new PlayerUtil();

    PlayerUtil() {
    }

    @Nullable
    public final MediaInfo convertMediaInfo(@Nullable com.tencent.superplayer.player.MediaInfo superPlayerMediaInfo) {
        if (superPlayerMediaInfo == null) {
            return null;
        }
        return new MediaInfo(superPlayerMediaInfo.getVideoCodec(), superPlayerMediaInfo.getVideoWidth(), superPlayerMediaInfo.getVideoHeight(), superPlayerMediaInfo.getVideoBitRate());
    }
}
