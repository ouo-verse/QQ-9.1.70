package com.tencent.thumbplayer.api.resourceloader;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public interface ITPResourceLoader {
    public static final int TP_RESOURCE_LOADER_RET_CODE_ERROR = -2;
    public static final int TP_RESOURCE_LOADER_RET_CODE_SUCCESS = 0;
    public static final int TP_RESOURCE_LOADER_RET_CODE_TRY_AGAIN = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TPResourceLoaderRetCode {
    }

    void close(int i3, @NonNull String str);

    boolean open(int i3, @NonNull String str);

    TPResourceLoaderData readData(int i3, @NonNull String str, long j3);

    TPResourceLoaderMediaContentInfo readMediaContentInfo(int i3, @NonNull String str);

    int seekData(int i3, @NonNull String str, long j3);
}
