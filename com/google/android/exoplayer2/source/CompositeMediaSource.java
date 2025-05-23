package com.google.android.exoplayer2.source;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class CompositeMediaSource<T> implements MediaSource {
    private final HashMap<T, MediaSource> childSources = new HashMap<>();
    private ExoPlayer player;

    @Override // com.google.android.exoplayer2.source.MediaSource
    @CallSuper
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        Iterator<MediaSource> it = this.childSources.values().iterator();
        while (it.hasNext()) {
            it.next().maybeThrowSourceInfoRefreshError();
        }
    }

    protected abstract void onChildSourceInfoRefreshed(@Nullable T t16, MediaSource mediaSource, Timeline timeline, @Nullable Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public void prepareChildSource(@Nullable final T t16, final MediaSource mediaSource) {
        Assertions.checkArgument(!this.childSources.containsKey(t16));
        this.childSources.put(t16, mediaSource);
        mediaSource.prepareSource(this.player, false, new MediaSource.Listener() { // from class: com.google.android.exoplayer2.source.CompositeMediaSource.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.exoplayer2.source.MediaSource.Listener
            public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline, @Nullable Object obj) {
                CompositeMediaSource.this.onChildSourceInfoRefreshed(t16, mediaSource, timeline, obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @CallSuper
    public void prepareSource(ExoPlayer exoPlayer, boolean z16, MediaSource.Listener listener) {
        this.player = exoPlayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseChildSource(@Nullable T t16) {
        this.childSources.remove(t16).releaseSource();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    @CallSuper
    public void releaseSource() {
        Iterator<MediaSource> it = this.childSources.values().iterator();
        while (it.hasNext()) {
            it.next().releaseSource();
        }
        this.childSources.clear();
        this.player = null;
    }
}
