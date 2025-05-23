package com.tencent.qfsmonet.api;

import android.opengl.EGLContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qfsmonet.api.inputstream.IMonetInputStream;
import com.tencent.qfsmonet.api.module.IMonetModule;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import com.tencent.qfsmonet.api.outputstream.IMonetOutputStream;

/* loaded from: classes22.dex */
public interface IMonetProcessor {
    void destroy();

    @Nullable
    MonetContext initialize();

    @Nullable
    MonetContext initialize(@Nullable EGLContext eGLContext);

    @Nullable
    MonetContext initializeWithSoLoad();

    void loadModule(@Nullable IMonetSingleInputModule iMonetSingleInputModule, @NonNull IMonetInputStream iMonetInputStream, @NonNull IMonetOutputStream iMonetOutputStream) throws IllegalStateException;

    void run() throws IllegalStateException;

    void setDestroyFlag();

    void setTextureIdInterceptor(IMonetTextureIdInterceptor iMonetTextureIdInterceptor);

    void updateModule(@Nullable IMonetModule iMonetModule) throws IllegalStateException;
}
