package com.tencent.state.square.api;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/api/DefaultSquareMusicService;", "Lcom/tencent/state/square/api/ISquareMusicService;", "()V", "addMusicChangeListener", "", "listener", "Lcom/tencent/state/square/api/MusicChangeListener;", "getCurrentPlayingSong", "Lcom/tencent/state/square/api/SongInfo;", "getLastPlayMusicMid", "", "init", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "removeMusicChangeListener", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareMusicService implements ISquareMusicService {
    @Override // com.tencent.state.square.api.ISquareMusicService
    public void addMusicChangeListener(@NotNull MusicChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    @Nullable
    public SongInfo getCurrentPlayingSong() {
        return null;
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    @NotNull
    public String getLastPlayMusicMid() {
        return "";
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public void removeMusicChangeListener(@NotNull MusicChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public void init() {
    }

    @Override // com.tencent.state.square.api.ISquareMusicService
    public void onDestroy() {
    }
}
