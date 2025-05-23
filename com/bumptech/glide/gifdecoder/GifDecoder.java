package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes.dex */
public interface GifDecoder {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface GifDecodeStatus {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        void a(@NonNull byte[] bArr);

        void b(@NonNull int[] iArr);

        @NonNull
        byte[] c(int i3);

        @NonNull
        int[] d(int i3);

        @NonNull
        Bitmap e(int i3, int i16, @NonNull Bitmap.Config config);

        void f(@NonNull Bitmap bitmap);
    }

    void a(@NonNull Bitmap.Config config);

    void advance();

    void b();

    int c();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    @NonNull
    ByteBuffer getData();

    int getFrameCount();

    @Nullable
    Bitmap getNextFrame();
}
