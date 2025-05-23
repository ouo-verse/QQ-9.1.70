package com.tencent.qqmusic.mediaplayer.upstream;

import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TracerDataSource implements IDataSource {
    private static final String TAG = "TracerDataSource";

    @NonNull
    private final IDataSource impl;

    public TracerDataSource(@NonNull IDataSource iDataSource) {
        this.impl = iDataSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.impl.close();
        } catch (Throwable th5) {
            Logger.e(TAG, "[close] failed!", th5);
            throw th5;
        }
    }

    public boolean equals(Object obj) {
        return this.impl.equals(obj);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        try {
            return this.impl.getAudioType();
        } catch (Throwable th5) {
            Logger.e(TAG, "[getAudioType] failed!", th5);
            throw th5;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        try {
            return this.impl.getSize();
        } catch (Throwable th5) {
            Logger.e(TAG, "[getSize] failed!", th5);
            throw th5;
        }
    }

    public int hashCode() {
        return this.impl.hashCode();
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        try {
            this.impl.open();
        } catch (Throwable th5) {
            Logger.e(TAG, "[open] failed!", th5);
            throw th5;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        try {
            return this.impl.readAt(j3, bArr, i3, i16);
        } catch (Throwable th5) {
            Logger.e(TAG, "[readAt] failed! pos = " + j3 + ", offset = " + i3 + ", size = " + i16, th5);
            throw th5;
        }
    }

    public String toString() {
        return this.impl.toString();
    }
}
