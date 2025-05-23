package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultDataSource implements DataSource {
    private static final String SCHEME_ASSET = "asset";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_RAW = "rawresource";
    private static final String SCHEME_RTMP = "rtmp";
    private static final String TAG = "DefaultDataSource";
    private DataSource assetDataSource;
    private final DataSource baseDataSource;
    private DataSource contentDataSource;
    private final Context context;
    private DataSource dataSchemeDataSource;
    private DataSource dataSource;
    private DataSource fileDataSource;
    private final TransferListener<? super DataSource> listener;
    private DataSource rawResourceDataSource;
    private DataSource rtmpDataSource;

    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, String str, boolean z16) {
        this(context, transferListener, str, 8000, 8000, z16);
    }

    private DataSource getAssetDataSource() {
        if (this.assetDataSource == null) {
            this.assetDataSource = new AssetDataSource(this.context, this.listener);
        }
        return this.assetDataSource;
    }

    private DataSource getContentDataSource() {
        if (this.contentDataSource == null) {
            this.contentDataSource = new ContentDataSource(this.context, this.listener);
        }
        return this.contentDataSource;
    }

    private DataSource getDataSchemeDataSource() {
        if (this.dataSchemeDataSource == null) {
            this.dataSchemeDataSource = new DataSchemeDataSource();
        }
        return this.dataSchemeDataSource;
    }

    private DataSource getFileDataSource() {
        if (this.fileDataSource == null) {
            this.fileDataSource = new FileDataSource(this.listener);
        }
        return this.fileDataSource;
    }

    private DataSource getRawResourceDataSource() {
        if (this.rawResourceDataSource == null) {
            this.rawResourceDataSource = new RawResourceDataSource(this.context, this.listener);
        }
        return this.rawResourceDataSource;
    }

    private DataSource getRtmpDataSource() {
        if (this.rtmpDataSource == null) {
            try {
                this.rtmpDataSource = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                Log.w(TAG, "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e16) {
                throw new RuntimeException("Error instantiating RTMP extension", e16);
            }
            if (this.rtmpDataSource == null) {
                this.rtmpDataSource = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.dataSource = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        DataSource dataSource = this.dataSource;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        boolean z16;
        if (this.dataSource == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        String scheme = dataSpec.uri.getScheme();
        if (Util.isLocalFileUri(dataSpec.uri)) {
            if (dataSpec.uri.getPath().startsWith("/android_asset/")) {
                this.dataSource = getAssetDataSource();
            } else {
                this.dataSource = getFileDataSource();
            }
        } else if (SCHEME_ASSET.equals(scheme)) {
            this.dataSource = getAssetDataSource();
        } else if ("content".equals(scheme)) {
            this.dataSource = getContentDataSource();
        } else if ("rtmp".equals(scheme)) {
            this.dataSource = getRtmpDataSource();
        } else if ("data".equals(scheme)) {
            this.dataSource = getDataSchemeDataSource();
        } else if ("rawresource".equals(scheme)) {
            this.dataSource = getRawResourceDataSource();
        } else {
            this.dataSource = this.baseDataSource;
        }
        return this.dataSource.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        return this.dataSource.read(bArr, i3, i16);
    }

    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, String str, int i3, int i16, boolean z16) {
        this(context, transferListener, new DefaultHttpDataSource(str, null, transferListener, i3, i16, z16, null));
    }

    public DefaultDataSource(Context context, TransferListener<? super DataSource> transferListener, DataSource dataSource) {
        this.context = context.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource);
    }
}
