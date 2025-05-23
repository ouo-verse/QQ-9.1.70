package com.tencent.qfsmonet.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qfsmonet.api.inputstream.IMonetSurfaceInputStream;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import com.tencent.qfsmonet.api.outputstream.IMonetSurfaceOutputStream;

/* loaded from: classes22.dex */
public interface IMonetProxyFactory {
    @NonNull
    IMonetProcessor createMonetProcessor();

    @Nullable
    IMonetSingleInputModule createSingleInputModule(@NonNull MonetContext monetContext, String str);

    @NonNull
    IMonetSurfaceInputStream createSurfaceInputStream(@NonNull MonetContext monetContext);

    @Nullable
    IMonetSurfaceOutputStream createSurfaceOutputStream(@NonNull MonetContext monetContext);
}
