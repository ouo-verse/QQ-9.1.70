package com.tencent.qfsmonet.api.module.singleinput;

import androidx.annotation.NonNull;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IMonetModuleChain extends IMonetSingleInputModule {
    void addSingleModule(@NonNull IMonetSingleInputModule iMonetSingleInputModule) throws IllegalStateException;

    void removeSingleModule(@NonNull IMonetSingleInputModule iMonetSingleInputModule);
}
