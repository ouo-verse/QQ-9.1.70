package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    private final TransferListener<? super DataSource> listener;
    private final int readTimeoutMillis;
    private final String userAgent;

    public DefaultHttpDataSourceFactory(String str) {
        this(str, null);
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener) {
        this(str, transferListener, 8000, 8000, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    public DefaultHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        return new DefaultHttpDataSource(this.userAgent, null, this.listener, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, requestProperties);
    }

    public DefaultHttpDataSourceFactory(String str, TransferListener<? super DataSource> transferListener, int i3, int i16, boolean z16) {
        this.userAgent = str;
        this.listener = transferListener;
        this.connectTimeoutMillis = i3;
        this.readTimeoutMillis = i16;
        this.allowCrossProtocolRedirects = z16;
    }
}
