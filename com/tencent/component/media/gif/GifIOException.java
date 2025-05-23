package com.tencent.component.media.gif;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    public final GifError reason;

    GifIOException(GifError gifError) {
        super(gifError.getFormattedDescription());
        this.reason = gifError;
    }

    static GifIOException fromCode(int i3) {
        if (i3 == 0) {
            return null;
        }
        return new GifIOException(i3);
    }

    GifIOException(int i3) {
        this(GifError.fromCode(i3));
    }
}
