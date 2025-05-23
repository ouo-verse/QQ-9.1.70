package android.support.v4.util;

import com.tencent.qphone.base.util.QLog;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes.dex */
public class LogWriter extends Writer {
    private StringBuilder mBuilder = new StringBuilder(128);
    private final String mTag;

    public LogWriter(String str) {
        this.mTag = str;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d(this.mTag, 4, this.mBuilder.toString());
            }
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
