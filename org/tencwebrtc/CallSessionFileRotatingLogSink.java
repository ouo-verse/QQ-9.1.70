package org.tencwebrtc;

import org.tencwebrtc.Logging;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CallSessionFileRotatingLogSink {
    private long nativeSink;

    public CallSessionFileRotatingLogSink(String str, int i3, Logging.Severity severity) {
        if (str != null) {
            this.nativeSink = nativeAddSink(str, i3, severity.ordinal());
            return;
        }
        throw new IllegalArgumentException("dirPath may not be null.");
    }

    public static byte[] getLogData(String str) {
        if (str != null) {
            return nativeGetLogData(str);
        }
        throw new IllegalArgumentException("dirPath may not be null.");
    }

    private static native long nativeAddSink(String str, int i3, int i16);

    private static native void nativeDeleteSink(long j3);

    private static native byte[] nativeGetLogData(String str);

    public void dispose() {
        long j3 = this.nativeSink;
        if (j3 != 0) {
            nativeDeleteSink(j3);
            this.nativeSink = 0L;
        }
    }
}
