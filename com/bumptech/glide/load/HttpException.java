package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i3) {
        this("Http request failed", i3);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Deprecated
    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i3) {
        this(str, i3, null);
    }

    public HttpException(String str, int i3, @Nullable Throwable th5) {
        super(str + ", status code: " + i3, th5);
        this.statusCode = i3;
    }
}
