package com.tencent.mobileqq.qwallet.hb.skin.local;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.remote.HbSkinRemoteDataSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Database(entities = {HbSkinData.class}, exportSchema = false, version = 3)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 \u00062\u00020\u0001:\u0002\u0007\bB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/tencent/mobileqq/qwallet/hb/skin/local/a;", "d", "<init>", "()V", "a", "b", "c", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class HbSkinDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Migration f277850b = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase$a", "Landroidx/room/migration/Migration;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database", "", "migrate", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends Migration {
        a() {
            super(3, 4);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE hb_skin_table ADD COLUMN popOpenUrl TEXT");
            database.execSQL("ALTER TABLE hb_skin_table ADD COLUMN popBrokenUrl TEXT");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase$b;", "", "Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase;", "a", "Landroidx/room/migration/Migration;", "MIGRATION_3_4", "Landroidx/room/migration/Migration;", "b", "()Landroidx/room/migration/Migration;", "", "HB_SKIN_DATABASE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.skin.local.HbSkinDatabase$b, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HbSkinDatabase a() {
            return c.f277851a.a();
        }

        @NotNull
        public final Migration b() {
            return HbSkinDatabase.f277850b;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase$c;", "", "Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase;", "b", "Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase;", "a", "()Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase;", "INSTANCE", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f277851a = new c();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final HbSkinDatabase INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/skin/local/HbSkinDatabase$c$a", "Landroidx/room/RoomDatabase$Callback;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "onDestructiveMigration", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a extends RoomDatabase.Callback {
            a() {
            }

            @Override // androidx.room.RoomDatabase.Callback
            public void onDestructiveMigration(@NotNull SupportSQLiteDatabase db5) {
                Intrinsics.checkNotNullParameter(db5, "db");
                QLog.i("HbSkinDatabase", 1, "[onDestructiveMigration] version=" + db5.getVersion());
                HbSkinRemoteDataSource.f277873a.o("");
            }
        }

        static {
            RoomDatabase build = Room.databaseBuilder(MobileQQ.sMobileQQ, HbSkinDatabase.class, "hb_skin").fallbackToDestructiveMigration().addMigrations(HbSkinDatabase.INSTANCE.b()).addCallback(new a()).build();
            Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(\n       \u2026\n                .build()");
            INSTANCE = (HbSkinDatabase) build;
        }

        c() {
        }

        @NotNull
        public final HbSkinDatabase a() {
            return INSTANCE;
        }
    }

    @NotNull
    public abstract com.tencent.mobileqq.qwallet.hb.skin.local.a d();
}
