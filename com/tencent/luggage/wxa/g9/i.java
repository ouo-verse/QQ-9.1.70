package com.tencent.luggage.wxa.g9;

import android.media.MediaDataSource;
import androidx.annotation.RequiresApi;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

/* compiled from: P */
@RequiresApi(23)
/* loaded from: classes8.dex */
public class i extends MediaDataSource {

    /* renamed from: a, reason: collision with root package name */
    private IDataSource f126648a;

    public i(IDataSource iDataSource) {
        this.f126648a = iDataSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IDataSource iDataSource = this.f126648a;
        if (iDataSource != null) {
            iDataSource.close();
            this.f126648a = null;
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        IDataSource iDataSource = this.f126648a;
        if (iDataSource != null) {
            return iDataSource.getSize();
        }
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        IDataSource iDataSource = this.f126648a;
        if (iDataSource != null) {
            return iDataSource.readAt(j3, bArr, i3, i16);
        }
        return -1;
    }
}
