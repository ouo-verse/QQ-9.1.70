package com.tencent.zplan.persistent;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.zplan.persistent.ZPlanDataBase;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@TypeConverters({com.tencent.zplan.persistent.a.class})
@Database(entities = {ZPlanRecordResource.class}, version = 3)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/zplan/persistent/ZPlanDataBase;", "Landroidx/room/RoomDatabase;", "Lxx4/a;", "g", "<init>", "()V", "e", "d", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class ZPlanDataBase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f385974a;

    /* renamed from: b, reason: collision with root package name */
    private static final a f385975b;

    /* renamed from: c, reason: collision with root package name */
    private static final c f385976c;

    /* renamed from: d, reason: collision with root package name */
    private static final b f385977d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/persistent/ZPlanDataBase$a", "Landroidx/room/migration/Migration;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "", "migrate", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a extends Migration {
        a(int i3, int i16) {
            super(i3, i16);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            ZPlanDataBase.INSTANCE.d(database);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/persistent/ZPlanDataBase$b", "Landroidx/room/migration/Migration;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "", "migrate", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b extends Migration {
        b(int i3, int i16) {
            super(i3, i16);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            Companion companion = ZPlanDataBase.INSTANCE;
            companion.d(database);
            companion.c(database);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/persistent/ZPlanDataBase$c", "Landroidx/room/migration/Migration;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "", "migrate", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c extends Migration {
        c(int i3, int i16) {
            super(i3, i16);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            ZPlanDataBase.INSTANCE.c(database);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006*\u0003\f\u000f\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002R\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/persistent/ZPlanDataBase$d;", "", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "", "d", "c", "Lcom/tencent/zplan/persistent/ZPlanDataBase;", "db$delegate", "Lkotlin/Lazy;", "e", "()Lcom/tencent/zplan/persistent/ZPlanDataBase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "com/tencent/zplan/persistent/ZPlanDataBase$a", "migration_1_2", "Lcom/tencent/zplan/persistent/ZPlanDataBase$a;", "com/tencent/zplan/persistent/ZPlanDataBase$b", "migration_1_3", "Lcom/tencent/zplan/persistent/ZPlanDataBase$b;", "com/tencent/zplan/persistent/ZPlanDataBase$c", "migration_2_3", "Lcom/tencent/zplan/persistent/ZPlanDataBase$c;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.persistent.ZPlanDataBase$d, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE RecordResource ADD COLUMN actionId INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE RecordResource ADD COLUMN dressKey TEXT DEFAULT NULL");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE RecordResource ADD COLUMN timestamp INTEGER NOT NULL DEFAULT 0");
            supportSQLiteDatabase.execSQL("ALTER TABLE RecordResource ADD COLUMN source INTEGER NOT NULL DEFAULT 0");
        }

        @NotNull
        public final ZPlanDataBase e() {
            return (ZPlanDataBase) ZPlanDataBase.f385974a.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanDataBase>() { // from class: com.tencent.zplan.persistent.ZPlanDataBase$DBHelper$db$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ZPlanDataBase invoke() {
                ZPlanDataBase.a aVar;
                ZPlanDataBase.c cVar;
                ZPlanDataBase.b bVar;
                Object a16 = mx4.a.f417748a.a(lx4.a.class);
                Intrinsics.checkNotNull(a16);
                RoomDatabase.Builder allowMainThreadQueries = Room.databaseBuilder(((lx4.a) a16).getContext(), ZPlanDataBase.class, "zplan_db").allowMainThreadQueries();
                aVar = ZPlanDataBase.f385975b;
                cVar = ZPlanDataBase.f385976c;
                bVar = ZPlanDataBase.f385977d;
                return (ZPlanDataBase) allowMainThreadQueries.addMigrations(aVar, cVar, bVar).fallbackToDestructiveMigrationOnDowngrade().build();
            }
        });
        f385974a = lazy;
        f385975b = new a(1, 2);
        f385976c = new c(2, 3);
        f385977d = new b(1, 3);
    }

    @NotNull
    public abstract xx4.a g();
}
