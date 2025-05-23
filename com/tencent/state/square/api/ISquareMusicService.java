package com.tencent.state.square.api;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/api/ISquareMusicService;", "", "addMusicChangeListener", "", "listener", "Lcom/tencent/state/square/api/MusicChangeListener;", "getCurrentPlayingSong", "Lcom/tencent/state/square/api/SongInfo;", "getLastPlayMusicMid", "", "init", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "removeMusicChangeListener", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareMusicService {
    void addMusicChangeListener(@NotNull MusicChangeListener listener);

    @Nullable
    SongInfo getCurrentPlayingSong();

    @NotNull
    String getLastPlayMusicMid();

    void init();

    void onDestroy();

    void removeMusicChangeListener(@NotNull MusicChangeListener listener);
}
