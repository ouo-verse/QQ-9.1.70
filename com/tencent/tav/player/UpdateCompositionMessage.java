package com.tencent.tav.player;

import com.tencent.tav.coremedia.CMTime;

/* compiled from: P */
/* loaded from: classes26.dex */
public class UpdateCompositionMessage {
    public final PlayerItem playerItem;
    public final CMTime position;
    public final OnCompositionUpdateListener updateListener;

    public UpdateCompositionMessage(PlayerItem playerItem, CMTime cMTime, OnCompositionUpdateListener onCompositionUpdateListener) {
        this.playerItem = playerItem;
        this.updateListener = onCompositionUpdateListener;
        this.position = cMTime;
    }
}
