package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private List<Object> mBindArgsCache = new ArrayList();

    private void saveArgsToCache(int i3, Object obj) {
        int i16 = i3 - 1;
        if (i16 >= this.mBindArgsCache.size()) {
            for (int size = this.mBindArgsCache.size(); size <= i16; size++) {
                this.mBindArgsCache.add(null);
            }
        }
        this.mBindArgsCache.set(i16, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i3, byte[] bArr) {
        saveArgsToCache(i3, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i3, double d16) {
        saveArgsToCache(i3, Double.valueOf(d16));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i3, long j3) {
        saveArgsToCache(i3, Long.valueOf(j3));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i3) {
        saveArgsToCache(i3, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i3, String str) {
        saveArgsToCache(i3, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> getBindArgs() {
        return this.mBindArgsCache;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
