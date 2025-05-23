package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public interface f<T, Z> {
    boolean a(@NonNull T t16, @NonNull e eVar) throws IOException;

    @Nullable
    q<Z> b(@NonNull T t16, int i3, int i16, @NonNull e eVar) throws IOException;
}
