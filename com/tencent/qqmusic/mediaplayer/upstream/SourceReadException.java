package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SourceReadException extends Exception {
    private final String source;

    public SourceReadException(String str, String str2) {
        super(str);
        this.source = str2;
    }

    public String getSource() {
        return this.source;
    }

    public SourceReadException(IOException iOException, String str) {
        super(iOException);
        this.source = str;
    }
}
