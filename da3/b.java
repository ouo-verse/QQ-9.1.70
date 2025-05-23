package da3;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import ha3.PhotoFace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b implements da3.a {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f393468a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<PhotoFace> f393469b;

    /* renamed from: c, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<PhotoFace> f393470c;

    /* renamed from: d, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<PhotoFace> f393471d;

    /* renamed from: e, reason: collision with root package name */
    private final SharedSQLiteStatement f393472e;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends EntityInsertionAdapter<PhotoFace> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PhotoFace photoFace) {
            supportSQLiteStatement.bindLong(1, photoFace.getId());
            supportSQLiteStatement.bindLong(2, photoFace.getFaceCount());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `photo_face` (`id`,`faceCount`) VALUES (?,?)";
        }
    }

    /* compiled from: P */
    /* renamed from: da3.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    class C10169b extends EntityDeletionOrUpdateAdapter<PhotoFace> {
        C10169b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PhotoFace photoFace) {
            supportSQLiteStatement.bindLong(1, photoFace.getId());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `photo_face` WHERE `id` = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class c extends EntityDeletionOrUpdateAdapter<PhotoFace> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PhotoFace photoFace) {
            supportSQLiteStatement.bindLong(1, photoFace.getId());
            supportSQLiteStatement.bindLong(2, photoFace.getFaceCount());
            supportSQLiteStatement.bindLong(3, photoFace.getId());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `photo_face` SET `id` = ?,`faceCount` = ? WHERE `id` = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class d extends SharedSQLiteStatement {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM photo_face";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class e implements Callable<List<PhotoFace>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f393477d;

        e(RoomSQLiteQuery roomSQLiteQuery) {
            this.f393477d = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PhotoFace> call() throws Exception {
            Cursor query = DBUtil.query(b.this.f393468a, this.f393477d, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "faceCount");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(new PhotoFace(query.getLong(columnIndexOrThrow), query.getInt(columnIndexOrThrow2)));
                }
                return arrayList;
            } finally {
                query.close();
            }
        }

        protected void finalize() {
            this.f393477d.release();
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f393468a = roomDatabase;
        this.f393469b = new a(roomDatabase);
        this.f393470c = new C10169b(roomDatabase);
        this.f393471d = new c(roomDatabase);
        this.f393472e = new d(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    @Override // da3.a
    public LiveData<List<PhotoFace>> a() {
        return this.f393468a.getInvalidationTracker().createLiveData(new String[]{"photo_face"}, false, new e(RoomSQLiteQuery.acquire("SELECT * FROM photo_face", 0)));
    }

    @Override // da3.a
    public void insertAll(List<PhotoFace> list) {
        this.f393468a.assertNotSuspendingTransaction();
        this.f393468a.beginTransaction();
        try {
            this.f393469b.insert(list);
            this.f393468a.setTransactionSuccessful();
        } finally {
            this.f393468a.endTransaction();
        }
    }
}
