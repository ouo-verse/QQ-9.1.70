package androidx.sqlite.db;

import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    @Nullable
    private final Object[] mBindArgs;
    private final String mQuery;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        this.mQuery = str;
        this.mBindArgs = objArr;
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i3 = 0;
        while (i3 < length) {
            Object obj = objArr[i3];
            i3++;
            bind(supportSQLiteProgram, i3, obj);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        bind(supportSQLiteProgram, this.mBindArgs);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] objArr = this.mBindArgs;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, null);
    }

    private static void bind(SupportSQLiteProgram supportSQLiteProgram, int i3, Object obj) {
        if (obj == null) {
            supportSQLiteProgram.bindNull(i3);
            return;
        }
        if (obj instanceof byte[]) {
            supportSQLiteProgram.bindBlob(i3, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            supportSQLiteProgram.bindDouble(i3, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            supportSQLiteProgram.bindDouble(i3, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            supportSQLiteProgram.bindLong(i3, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            supportSQLiteProgram.bindLong(i3, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            supportSQLiteProgram.bindLong(i3, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            supportSQLiteProgram.bindLong(i3, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            supportSQLiteProgram.bindString(i3, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            supportSQLiteProgram.bindLong(i3, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i3 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }
}
