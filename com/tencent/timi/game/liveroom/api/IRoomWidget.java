package com.tencent.timi.game.liveroom.api;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IRoomWidget {
    void onEnterRoom(long j3, boolean z16);

    void onExitRoom(long j3);

    void onPageIn(long j3);

    void onPageOut(long j3);

    void onPreload(long j3, boolean z16, @Nullable String str);
}
