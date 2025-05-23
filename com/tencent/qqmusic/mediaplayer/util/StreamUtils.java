package com.tencent.qqmusic.mediaplayer.util;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class StreamUtils {
    public static long skipForBufferStream(InputStream inputStream, long j3) throws IOException {
        if (inputStream == null || j3 <= 0) {
            return 0L;
        }
        long j16 = j3;
        long j17 = 0;
        do {
            j16 -= j17;
            j17 = inputStream.skip(j16);
            if (j17 <= 0) {
                break;
            }
        } while (j17 < j16);
        if (j17 > 0) {
            return j3;
        }
        return j3 - j16;
    }
}
