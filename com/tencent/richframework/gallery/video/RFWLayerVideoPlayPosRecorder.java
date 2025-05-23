package com.tencent.richframework.gallery.video;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/gallery/video/RFWLayerVideoPlayPosRecorder;", "", "()V", "allVideoPlayPos", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getPlayPosition", "videoKey", "updatePlayPosition", "", "newPosition", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerVideoPlayPosRecorder {

    @NotNull
    public static final RFWLayerVideoPlayPosRecorder INSTANCE = new RFWLayerVideoPlayPosRecorder();
    private static final ConcurrentHashMap<String, Long> allVideoPlayPos = new ConcurrentHashMap<>();

    RFWLayerVideoPlayPosRecorder() {
    }

    public final long getPlayPosition(@NotNull String videoKey) {
        Intrinsics.checkNotNullParameter(videoKey, "videoKey");
        Long l3 = allVideoPlayPos.get(videoKey);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    public final void updatePlayPosition(@NotNull String videoKey, long newPosition) {
        Intrinsics.checkNotNullParameter(videoKey, "videoKey");
        allVideoPlayPos.put(videoKey, Long.valueOf(newPosition));
    }
}
