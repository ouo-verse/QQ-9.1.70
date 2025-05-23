package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* loaded from: classes.dex */
class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i3, byte[] bArr) {
        this.mDelegate.bindBlob(i3, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i3, double d16) {
        this.mDelegate.bindDouble(i3, d16);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i3, long j3) {
        this.mDelegate.bindLong(i3, j3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i3) {
        this.mDelegate.bindNull(i3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i3, String str) {
        this.mDelegate.bindString(i3, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }
}
