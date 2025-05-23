package com.tencent.thumbplayer.core.codec.tmediacodec.reuse;

import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public final class ReusePolicy {
    public static final ReusePolicy DEFAULT = new ReusePolicy(1920, 1920);
    public static final int DEFAULT_INIT_HEIGHT = 1920;
    public static final int DEFAULT_INIT_WIDTH = 1920;
    public int initHeight;
    public int initWidth;
    public boolean reConfigByRealFormat = true;
    public EraseType eraseType = EraseType.First;

    /* loaded from: classes26.dex */
    public enum EraseType {
        First,
        SAME
    }

    public ReusePolicy(int i3, int i16) {
        this.initWidth = i3;
        this.initHeight = i16;
    }

    @NonNull
    public String toString() {
        return "[initWidth:" + this.initWidth + ", initHeight:" + this.initHeight + ", reConfigByRealFormat:" + this.reConfigByRealFormat + ']';
    }
}
