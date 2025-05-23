package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public interface q<Z> {
    @NonNull
    Z get();

    @NonNull
    Class<Z> getResourceClass();

    int getSize();

    void recycle();
}
