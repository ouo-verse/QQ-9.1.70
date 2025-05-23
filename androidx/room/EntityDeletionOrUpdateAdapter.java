package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t16);

    @Override // androidx.room.SharedSQLiteStatement
    protected abstract String createQuery();

    public final int handle(T t16) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t16);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        SupportSQLiteStatement acquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                bind(acquire, it.next());
                i3 += acquire.executeUpdateDelete();
            }
            return i3;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i3 = 0;
            for (T t16 : tArr) {
                bind(acquire, t16);
                i3 += acquire.executeUpdateDelete();
            }
            return i3;
        } finally {
            release(acquire);
        }
    }
}
