package com.tencent.mobileqq.winkpublish.outbox.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.ark.ark;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class c implements com.tencent.mobileqq.winkpublish.outbox.db.b {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f327240a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<d> f327241b;

    /* renamed from: c, reason: collision with root package name */
    private final SharedSQLiteStatement f327242c;

    /* renamed from: d, reason: collision with root package name */
    private final SharedSQLiteStatement f327243d;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends EntityInsertionAdapter<d> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, d dVar) {
            supportSQLiteStatement.bindLong(1, dVar.f327247a);
            supportSQLiteStatement.bindLong(2, dVar.f327248b);
            String str = dVar.f327249c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `task_table` (`id`,`task_id`,`json`) VALUES (nullif(?, 0),?,?)";
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM task_table WHERE task_id=?";
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.db.c$c, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    class C9094c extends SharedSQLiteStatement {
        C9094c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM task_table";
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f327240a = roomDatabase;
        this.f327241b = new a(roomDatabase);
        this.f327242c = new b(roomDatabase);
        this.f327243d = new C9094c(roomDatabase);
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.db.b
    public void a(d dVar) {
        this.f327240a.assertNotSuspendingTransaction();
        this.f327240a.beginTransaction();
        try {
            this.f327241b.insert((EntityInsertionAdapter<d>) dVar);
            this.f327240a.setTransactionSuccessful();
        } finally {
            this.f327240a.endTransaction();
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.db.b
    public void delete(long j3) {
        this.f327240a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f327242c.acquire();
        acquire.bindLong(1, j3);
        this.f327240a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f327240a.setTransactionSuccessful();
        } finally {
            this.f327240a.endTransaction();
            this.f327242c.release(acquire);
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.db.b
    public List<d> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM task_table", 0);
        this.f327240a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f327240a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "task_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ark.ARKMETADATA_JSON);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                d dVar = new d();
                dVar.f327247a = query.getInt(columnIndexOrThrow);
                dVar.f327248b = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    dVar.f327249c = null;
                } else {
                    dVar.f327249c = query.getString(columnIndexOrThrow3);
                }
                arrayList.add(dVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
