package com.airbnb.lottie.network;

import androidx.annotation.RestrictTo;
import com.tencent.oskplayer.cache.FileDataSink;
import cooperation.photoplus.sticker.Sticker;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public enum FileExtension {
    JSON(Sticker.JSON_SUFFIX),
    ZIP(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return FileDataSink.TEMP_FILE + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
