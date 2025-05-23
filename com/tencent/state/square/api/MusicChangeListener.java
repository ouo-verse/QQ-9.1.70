package com.tencent.state.square.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/api/MusicChangeListener;", "", "onMusicInfoChange", "", "uin", "", "songInfo", "Lcom/tencent/state/square/api/SongInfo;", "onMusicPlayStateChange", "songMid", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface MusicChangeListener {
    void onMusicInfoChange(@NotNull String uin, @Nullable SongInfo songInfo);

    void onMusicPlayStateChange(@NotNull String songMid);
}
