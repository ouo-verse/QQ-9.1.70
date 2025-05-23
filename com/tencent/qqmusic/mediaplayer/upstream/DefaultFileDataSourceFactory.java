package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DefaultFileDataSourceFactory implements IDataSourceFactory {
    private final String filePath;

    public DefaultFileDataSourceFactory(String str) {
        this.filePath = str;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    @NonNull
    public IDataSource createDataSource() throws DataSourceException {
        if (!TextUtils.isEmpty(this.filePath)) {
            return new FileDataSource(this.filePath);
        }
        throw new DataSourceException(-5, "filePath is empty!", null);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
    @Nullable
    public INativeDataSource createNativeDataSource() {
        return NativeDataSourceFactory.fileDataSource(this.filePath, 0);
    }
}
