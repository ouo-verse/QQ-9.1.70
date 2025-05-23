package com.tencent.libra.cache;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface Resource<Z> {
    @NonNull
    Z get();

    @NonNull
    Class<Z> getResourceClass();

    int getSize();

    void recycle();
}
