package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public interface e<T> {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a<T> {
        @NonNull
        Class<T> a();

        @NonNull
        e<T> build(@NonNull T t16);
    }

    @NonNull
    T a() throws IOException;

    void cleanup();
}
