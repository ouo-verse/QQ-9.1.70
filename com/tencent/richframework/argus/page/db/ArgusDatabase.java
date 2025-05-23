package com.tencent.richframework.argus.page.db;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tencent.richframework.argus.page.converter.ArgusNodeInfoTypeConverter;
import com.tencent.richframework.argus.page.converter.PageInfoTypeConverter;

/* compiled from: P */
@TypeConverters({PageInfoTypeConverter.class, ArgusNodeInfoTypeConverter.class})
@Database(entities = {PageChangeRecord.class, PageInflateRecord.class, ListLayoutInflateRecord.class}, exportSchema = false, version = 1)
/* loaded from: classes25.dex */
public abstract class ArgusDatabase extends RoomDatabase {
    private static volatile ArgusDatabase INSTANCE;
    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() { // from class: com.tencent.richframework.argus.page.db.ArgusDatabase.1
        @Override // androidx.room.RoomDatabase.Callback
        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onCreate(supportSQLiteDatabase);
        }
    };

    public static ArgusDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (ArgusDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = (ArgusDatabase) Room.databaseBuilder(context, ArgusDatabase.class, "argus_db_release_v6").addCallback(sRoomDatabaseCallback).enableMultiInstanceInvalidation().setQueryExecutor(ArgusDbThreadPool.INSTANCE.getInstance()).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ListLayoutInflateRecordDao getListInflateDao();

    public abstract InflateRecordDao getPageInflateDao();

    public abstract PageChangeRecordDao getPageRecordDao();
}
