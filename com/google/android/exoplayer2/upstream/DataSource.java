package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface DataSource {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Factory {
        DataSource createDataSource();
    }

    void close() throws IOException;

    Uri getUri();

    long open(DataSpec dataSpec) throws IOException;

    int read(byte[] bArr, int i3, int i16) throws IOException;
}
