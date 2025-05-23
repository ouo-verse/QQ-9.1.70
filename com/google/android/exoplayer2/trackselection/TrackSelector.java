package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroupArray;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class TrackSelector {
    private InvalidationListener listener;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    public final void init(InvalidationListener invalidationListener) {
        this.listener = invalidationListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invalidate() {
        InvalidationListener invalidationListener = this.listener;
        if (invalidationListener != null) {
            invalidationListener.onTrackSelectionsInvalidated();
        }
    }

    public abstract void onSelectionActivated(Object obj);

    public abstract TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException;
}
