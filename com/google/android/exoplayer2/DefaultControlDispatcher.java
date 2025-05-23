package com.google.android.exoplayer2;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DefaultControlDispatcher implements ControlDispatcher {
    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(Player player, int i3, long j3) {
        player.seekTo(i3, j3);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(Player player, boolean z16) {
        player.setPlayWhenReady(z16);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(Player player, int i3) {
        player.setRepeatMode(i3);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(Player player, boolean z16) {
        player.setShuffleModeEnabled(z16);
        return true;
    }
}
