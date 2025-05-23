package com.tencent.qqmusic.mediaplayer.upstream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IDataSourceFactory {
    @NonNull
    IDataSource createDataSource() throws DataSourceException;

    @Nullable
    INativeDataSource createNativeDataSource() throws DataSourceException;
}
