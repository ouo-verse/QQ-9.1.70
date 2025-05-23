package com.tencent.richframework.video;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/video/IPlayerManager;", "", "getPlayScene", "", "obtain", "Lcom/tencent/richframework/video/IPlayer;", "key", "", "releasePlayer", "", "video-base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IPlayerManager {
    int getPlayScene();

    @NotNull
    IPlayer obtain(@NotNull String key);

    void releasePlayer(@NotNull String key);
}
