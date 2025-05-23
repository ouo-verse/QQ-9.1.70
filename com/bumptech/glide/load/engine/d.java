package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;

/* compiled from: P */
/* loaded from: classes.dex */
interface d {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        void c(com.bumptech.glide.load.c cVar, @Nullable Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2);

        void d(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource);

        void i();
    }

    boolean a();

    void cancel();
}
