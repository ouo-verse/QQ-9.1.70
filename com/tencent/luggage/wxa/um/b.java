package com.tencent.luggage.wxa.um;

import com.tencent.luggage.wxa.qb.f;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements IDataSource {

    /* renamed from: b, reason: collision with root package name */
    private static final String f142826b = "MicroMsg.Audio.InputStreamDataSource";

    /* renamed from: a, reason: collision with root package name */
    public f f142827a;

    public b(f fVar) {
        this.f142827a = fVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Logger.i(f142826b, "close");
        f fVar = this.f142827a;
        if (fVar != null) {
            fVar.close();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        if (this.f142827a == null) {
            Logger.e(f142826b, "[getAudioType] unsupport");
            return AudioFormat.AudioType.UNSUPPORT;
        }
        Logger.i(f142826b, "getAudioType:" + this.f142827a.getAudioType());
        int audioType = this.f142827a.getAudioType();
        if (audioType != 0) {
            if (audioType != 1) {
                if (audioType != 2) {
                    if (audioType != 3) {
                        if (audioType != 4) {
                            Logger.e(f142826b, "[getAudioType] unsupport");
                            return AudioFormat.AudioType.UNSUPPORT;
                        }
                        return AudioFormat.AudioType.OGG;
                    }
                    return AudioFormat.AudioType.WAV;
                }
                return AudioFormat.AudioType.MP3;
            }
            return AudioFormat.AudioType.AAC;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        f fVar = this.f142827a;
        if (fVar != null) {
            return fVar.getSize();
        }
        return 0L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        Logger.i(f142826b, "open");
        f fVar = this.f142827a;
        if (fVar != null) {
            fVar.open();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        f fVar = this.f142827a;
        if (fVar == null) {
            Logger.e(f142826b, "[readAt]audioDataSource is null");
            return -1;
        }
        return fVar.readAt(j3, bArr, i3, i16);
    }
}
