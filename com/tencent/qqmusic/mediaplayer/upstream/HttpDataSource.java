package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class HttpDataSource implements IDataSource {
    private final Map<String, String> headers;
    private IMediaHTTPConnection mediaHTTPConnection;
    private final IMediaHTTPService service;
    private final Uri uri;

    public HttpDataSource(Uri uri, Map<String, String> map, IMediaHTTPService iMediaHTTPService) {
        this.uri = uri;
        this.headers = map;
        this.service = iMediaHTTPService;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IMediaHTTPConnection iMediaHTTPConnection = this.mediaHTTPConnection;
        if (iMediaHTTPConnection != null) {
            iMediaHTTPConnection.disconnect();
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        return FormatDetector.getAudioFormat((IDataSource) this, false);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        return this.mediaHTTPConnection.getSize();
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        IMediaHTTPConnection makeHTTPConnection = this.service.makeHTTPConnection();
        this.mediaHTTPConnection = makeHTTPConnection;
        makeHTTPConnection.connect(new URL(this.uri.toString()), this.headers);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        int i17 = 0;
        do {
            int i18 = i3 + i17;
            int readAt = this.mediaHTTPConnection.readAt(i17 + j3, bArr, i18, i16 - i18);
            if (readAt < 0) {
                return readAt;
            }
            if (readAt == 0) {
                break;
            }
            i17 += readAt;
        } while (i17 < i16);
        return i17;
    }
}
