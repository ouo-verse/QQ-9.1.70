package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class ExoPlaybackException extends Exception {
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    public final int rendererIndex;
    public final int type;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Type {
    }

    ExoPlaybackException(int i3, String str, Throwable th5, int i16) {
        super(str, th5);
        this.type = i3;
        this.rendererIndex = i16;
    }

    public static ExoPlaybackException createForRenderer(Exception exc, int i3) {
        return new ExoPlaybackException(1, null, exc, i3);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, null, iOException, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExoPlaybackException createForUnexpected(Exception exc) {
        return new ExoPlaybackException(2, null, exc, -1);
    }

    public Exception getRendererException() {
        boolean z16 = true;
        if (this.type != 1) {
            z16 = false;
        }
        Assertions.checkState(z16);
        return (Exception) getCause();
    }

    public IOException getSourceException() {
        boolean z16;
        if (this.type == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        return (IOException) getCause();
    }

    public RuntimeException getUnexpectedException() {
        boolean z16;
        if (this.type == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        return (RuntimeException) getCause();
    }
}
