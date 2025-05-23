package com.tencent.mobileqq.wink.storage.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.qphone.base.util.QLog;
import fa3.n;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
@Database(entities = {ha3.b.class}, exportSchema = false, version = 4)
/* loaded from: classes21.dex */
public abstract class WinkRoomDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static volatile WinkRoomDatabase f326403a;

    /* renamed from: b, reason: collision with root package name */
    static final ExecutorService f326404b = new n();

    /* renamed from: c, reason: collision with root package name */
    private static final Migration f326405c = new a(1, 2);

    /* renamed from: d, reason: collision with root package name */
    private static final Migration f326406d = new b(2, 3);

    /* renamed from: e, reason: collision with root package name */
    private static final Migration f326407e = new c(3, 4);

    /* renamed from: f, reason: collision with root package name */
    private static final RoomDatabase.Callback f326408f = new d();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends Migration {
        a(int i3, int i16) {
            super(i3, i16);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE wink_publish_content_table ADD COLUMN extraInfo TEXT");
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b extends Migration {
        b(int i3, int i16) {
            super(i3, i16);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE wink_publish_content_table ADD COLUMN promotionParams TEXT");
            Cursor query = supportSQLiteDatabase.query("SELECT goodsId, goodsName FROM wink_publish_content_table WHERE goodsId IS NOT NULL AND goodsName IS NOT NULL");
            int columnIndex = query.getColumnIndex("goodsId");
            int columnIndex2 = query.getColumnIndex("goodsName");
            if (!query.moveToFirst()) {
                return;
            }
            do {
                try {
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex2);
                    supportSQLiteDatabase.execSQL("UPDATE wink_publish_content_table SET promotionParams =? WHERE goodsId =? AND goodsName =?", new String[]{new PromotionParams(string, string2, Long.MAX_VALUE, string, "", "", "", 2, 1).toString(), string, string2});
                } catch (SQLException e16) {
                    QLog.i("WinkRoomDatabase", 1, "[onCreate] MIGRATION_2_3 failed: " + e16);
                    return;
                }
            } while (query.moveToNext());
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class c extends Migration {
        c(int i3, int i16) {
            super(i3, i16);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE wink_publish_content_table ADD COLUMN declarationParams TEXT");
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class d extends RoomDatabase.Callback {
        d() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onCreate(supportSQLiteDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WinkRoomDatabase c(Context context) {
        if (f326403a == null) {
            synchronized (WinkRoomDatabase.class) {
                if (f326403a == null) {
                    f326403a = (WinkRoomDatabase) Room.databaseBuilder(context, WinkRoomDatabase.class, "wink_database").addCallback(f326408f).enableMultiInstanceInvalidation().setQueryExecutor(f326404b).addMigrations(f326405c).addMigrations(f326406d).addMigrations(f326407e).build();
                }
            }
        }
        return f326403a;
    }

    public abstract fa3.b d();
}
