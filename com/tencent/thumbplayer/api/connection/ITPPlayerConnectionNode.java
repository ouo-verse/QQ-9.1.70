package com.tencent.thumbplayer.api.connection;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPPlayerConnectionNode {
    public static final int CFG_LONG_SYNC_CLOCK_OFFSET_MS = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface Config {
    }

    long getConfig(int i3);

    @NonNull
    ITPPlayer getPlayer();

    void setConfig(int i3, long j3);
}
