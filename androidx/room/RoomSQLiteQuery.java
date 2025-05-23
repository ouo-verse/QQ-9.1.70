package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;

    @VisibleForTesting
    static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;

    @VisibleForTesting
    static final int POOL_LIMIT = 15;
    private static final int STRING = 4;

    @VisibleForTesting
    static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = new TreeMap<>();

    @VisibleForTesting
    int mArgCount;
    private final int[] mBindingTypes;

    @VisibleForTesting
    final byte[][] mBlobBindings;

    @VisibleForTesting
    final int mCapacity;

    @VisibleForTesting
    final double[] mDoubleBindings;

    @VisibleForTesting
    final long[] mLongBindings;
    private volatile String mQuery;

    @VisibleForTesting
    final String[] mStringBindings;

    RoomSQLiteQuery(int i3) {
        this.mCapacity = i3;
        int i16 = i3 + 1;
        this.mBindingTypes = new int[i16];
        this.mLongBindings = new long[i16];
        this.mDoubleBindings = new double[i16];
        this.mStringBindings = new String[i16];
        this.mBlobBindings = new byte[i16];
    }

    public static RoomSQLiteQuery acquire(String str, int i3) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i3));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.init(str, i3);
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i3);
            roomSQLiteQuery.init(str, i3);
            return roomSQLiteQuery;
        }
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo(new SupportSQLiteProgram() { // from class: androidx.room.RoomSQLiteQuery.1
            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindBlob(int i3, byte[] bArr) {
                RoomSQLiteQuery.this.bindBlob(i3, bArr);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindDouble(int i3, double d16) {
                RoomSQLiteQuery.this.bindDouble(i3, d16);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindLong(int i3, long j3) {
                RoomSQLiteQuery.this.bindLong(i3, j3);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindNull(int i3) {
                RoomSQLiteQuery.this.bindNull(i3);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void bindString(int i3, String str) {
                RoomSQLiteQuery.this.bindString(i3, str);
            }

            @Override // androidx.sqlite.db.SupportSQLiteProgram
            public void clearBindings() {
                RoomSQLiteQuery.this.clearBindings();
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        });
        return acquire;
    }

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            while (true) {
                int i3 = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i3;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i3, byte[] bArr) {
        this.mBindingTypes[i3] = 5;
        this.mBlobBindings[i3] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i3, double d16) {
        this.mBindingTypes[i3] = 3;
        this.mDoubleBindings[i3] = d16;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i3, long j3) {
        this.mBindingTypes[i3] = 2;
        this.mLongBindings[i3] = j3;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i3) {
        this.mBindingTypes[i3] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i3, String str) {
        this.mBindingTypes[i3] = 4;
        this.mStringBindings[i3] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i3 = 1; i3 <= this.mArgCount; i3++) {
            int i16 = this.mBindingTypes[i3];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                supportSQLiteProgram.bindBlob(i3, this.mBlobBindings[i3]);
                            }
                        } else {
                            supportSQLiteProgram.bindString(i3, this.mStringBindings[i3]);
                        }
                    } else {
                        supportSQLiteProgram.bindDouble(i3, this.mDoubleBindings[i3]);
                    }
                } else {
                    supportSQLiteProgram.bindLong(i3, this.mLongBindings[i3]);
                }
            } else {
                supportSQLiteProgram.bindNull(i3);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, (Object) null);
        Arrays.fill(this.mBlobBindings, (Object) null);
        this.mQuery = null;
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.mBindingTypes, 0, this.mBindingTypes, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mLongBindings, 0, this.mLongBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mStringBindings, 0, this.mStringBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mBlobBindings, 0, this.mBlobBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.mDoubleBindings, 0, this.mDoubleBindings, 0, argCount);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    void init(String str, int i3) {
        this.mQuery = str;
        this.mArgCount = i3;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.mCapacity), this);
            prunePoolLocked();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
