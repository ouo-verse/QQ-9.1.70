package androidx.core.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import java.io.Writer;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class LogWriter extends Writer {
    private StringBuilder mBuilder = new StringBuilder(128);
    private final String mTag;

    public LogWriter(String str) {
        this.mTag = str;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            Log.d(this.mTag, this.mBuilder.toString());
            StringBuilder sb5 = this.mBuilder;
            sb5.delete(0, sb5.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        flushBuilder();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i16) {
        for (int i17 = 0; i17 < i16; i17++) {
            char c16 = cArr[i3 + i17];
            if (c16 == '\n') {
                flushBuilder();
            } else {
                this.mBuilder.append(c16);
            }
        }
    }
}
