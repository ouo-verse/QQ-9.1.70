package com.google.android.exoplayer2;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ControlDispatcher {
    boolean dispatchSeekTo(Player player, int i3, long j3);

    boolean dispatchSetPlayWhenReady(Player player, boolean z16);

    boolean dispatchSetRepeatMode(Player player, int i3);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z16);
}
