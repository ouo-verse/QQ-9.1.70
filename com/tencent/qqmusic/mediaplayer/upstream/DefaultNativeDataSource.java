package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DefaultNativeDataSource implements INativeDataSource {
    private final AudioFormat.AudioType audioType;
    private final long nativeInstance;

    public DefaultNativeDataSource(long j3, AudioFormat.AudioType audioType) {
        this.nativeInstance = j3;
        this.audioType = audioType;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
    public AudioFormat.AudioType getAudioType() {
        return this.audioType;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
    public long getNativeInstance() {
        return this.nativeInstance;
    }

    public String toString() {
        return "DefaultNativeDataSource";
    }
}
