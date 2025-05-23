package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z16) {
            this.hasAlpha = z16;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int a(@NonNull InputStream inputStream, @NonNull r.b bVar) throws IOException;

    @NonNull
    ImageType getType(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException;
}
