package com.tencent.thumbplayer.core.datatransport.resourceloader;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPDataTransportResourceLoaderListener {
    public static final int RESOURCE_LOADER_RESPONSE_CODE_FAILED = -2;
    public static final int RESOURCE_LOADER_RESPONSE_CODE_SUCCESS = 0;
    public static final int RESOURCE_LOADER_RESPONSE_CODE_TRY_AGAIN = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface ResourceLoaderResponseCode {
    }

    void close(int i3, @NonNull String str);

    boolean open(int i3, @NonNull String str);

    TPDataTransportResourceLoaderData readData(int i3, @NonNull String str, long j3);

    TPDataTransportResourceLoaderMediaContentInfo readMediaContentInfo(int i3, @NonNull String str);

    int seekData(int i3, @NonNull String str, long j3);
}
