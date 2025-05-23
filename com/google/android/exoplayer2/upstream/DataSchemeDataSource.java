package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DataSchemeDataSource implements DataSource {
    public static final String SCHEME_DATA = "data";
    private int bytesRead;
    private byte[] data;
    private DataSpec dataSpec;

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.dataSpec = null;
        this.data = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        DataSpec dataSpec = this.dataSpec;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        this.dataSpec = dataSpec;
        Uri uri = dataSpec.uri;
        String scheme = uri.getScheme();
        if ("data".equals(scheme)) {
            String[] split = uri.getSchemeSpecificPart().split(",");
            if (split.length <= 2) {
                String str = split[1];
                if (split[0].contains(";base64")) {
                    try {
                        this.data = Base64.decode(str, 0);
                    } catch (IllegalArgumentException e16) {
                        throw new ParserException("Error while parsing Base64 encoded string: " + str, e16);
                    }
                } else {
                    this.data = URLDecoder.decode(str, "US-ASCII").getBytes();
                }
                return this.data.length;
            }
            throw new ParserException("Unexpected URI format: " + uri);
        }
        throw new ParserException("Unsupported scheme: " + scheme);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        int length = this.data.length - this.bytesRead;
        if (length == 0) {
            return -1;
        }
        int min = Math.min(i16, length);
        System.arraycopy(this.data, this.bytesRead, bArr, i3, min);
        this.bytesRead += min;
        return min;
    }
}
