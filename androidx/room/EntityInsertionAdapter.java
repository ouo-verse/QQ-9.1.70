package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t16);

    public final void insert(T t16) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t16);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t16) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t16);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            Iterator<? extends T> it = collection.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                jArr[i3] = acquire.executeInsert();
                i3++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            Iterator<? extends T> it = collection.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                lArr[i3] = Long.valueOf(acquire.executeInsert());
                i3++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i3 = 0;
            for (T t16 : tArr) {
                bind(acquire, t16);
                arrayList.add(i3, Long.valueOf(acquire.executeInsert()));
                i3++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T t16 : tArr) {
                bind(acquire, t16);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i3 = 0;
            for (T t16 : tArr) {
                bind(acquire, t16);
                jArr[i3] = acquire.executeInsert();
                i3++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i3 = 0;
            for (T t16 : tArr) {
                bind(acquire, t16);
                lArr[i3] = Long.valueOf(acquire.executeInsert());
                i3++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        SupportSQLiteStatement acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<? extends T> it = collection.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                arrayList.add(i3, Long.valueOf(acquire.executeInsert()));
                i3++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}
