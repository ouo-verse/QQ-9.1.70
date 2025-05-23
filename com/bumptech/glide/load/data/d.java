package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* compiled from: P */
/* loaded from: classes.dex */
public interface d<T> {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a<T> {
        void c(@NonNull Exception exc);

        void d(@Nullable T t16);
    }

    @NonNull
    Class<T> a();

    void b(@NonNull Priority priority, @NonNull a<? super T> aVar);

    void cancel();

    void cleanup();

    @NonNull
    DataSource getDataSource();
}
