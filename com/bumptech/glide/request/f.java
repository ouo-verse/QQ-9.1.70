package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.q;

/* compiled from: P */
/* loaded from: classes.dex */
public interface f {
    void a(GlideException glideException);

    void b(q<?> qVar, DataSource dataSource, boolean z16);

    Object getLock();
}
