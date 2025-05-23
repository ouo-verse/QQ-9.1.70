package androidx.sqlite.db;

import java.io.Closeable;

/* loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i3, byte[] bArr);

    void bindDouble(int i3, double d16);

    void bindLong(int i3, long j3);

    void bindNull(int i3);

    void bindString(int i3, String str);

    void clearBindings();
}
