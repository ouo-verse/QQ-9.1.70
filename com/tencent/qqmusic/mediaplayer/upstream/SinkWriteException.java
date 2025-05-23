package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SinkWriteException extends Exception {
    public SinkWriteException(String str) {
        super(str);
    }

    public SinkWriteException(IOException iOException) {
        super(iOException);
    }
}
