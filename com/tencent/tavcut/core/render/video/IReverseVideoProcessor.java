package com.tencent.tavcut.core.render.video;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.TimeRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/tavcut/core/render/video/IReverseVideoProcessor;", "", "reverseVideoFromPath", "Lcom/tencent/tavcut/core/render/video/IReverseVideoProcessor$Canceler;", "videoPath", "", "outputPath", "timeRange", "Lorg/light/TimeRange;", "listener", "Lcom/tencent/tavcut/core/render/video/OnReverseVideoListener;", "Canceler", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IReverseVideoProcessor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/tavcut/core/render/video/IReverseVideoProcessor$Canceler;", "", "cancel", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public interface Canceler {
        void cancel();
    }

    @Nullable
    Canceler reverseVideoFromPath(@NotNull String videoPath, @NotNull String outputPath, @NotNull TimeRange timeRange, @NotNull OnReverseVideoListener listener);
}
