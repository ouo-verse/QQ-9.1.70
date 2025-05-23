package com.tencent.mobileqq.zplan.persistent;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleAvatarProfileInfo;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0004J\"\u0010\u000f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/c;", "Lcom/tencent/mobileqq/persistence/EntityManagerFactory;", "", "uin", "Lcom/tencent/mobileqq/app/SQLiteOpenHelper;", "build", "getPackageName", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "createDatabase", "a", "", "oldVersion", "newVersion", "upgradeDatabase", "name", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends EntityManagerFactory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/c$a;", "", "", "uin", "a", "", "CURRENT_DB_VERSION", "I", "DB_NAME_PREFIX", "Ljava/lang/String;", "DB_VERSION_8835", "DB_VERSION_893", "DB_VERSION_8968", "DB_VERSION_898", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.persistent.c$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return "zplan_" + uin + DBBackupServiceImpl.DB_FILE_SUFFIX;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    protected final void a(SQLiteDatabase db5) {
        Intrinsics.checkNotNullParameter(db5, "db");
        db5.execSQL(TableBuilder.dropSQLStatement(ZPlanUserInfo.class.getSimpleName()));
        db5.execSQL(TableBuilder.dropSQLStatement(ZPlanCoupleAvatarProfileInfo.class.getSimpleName()));
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String uin) {
        if (this.dbHelper == null) {
            if (uin == null) {
                QLog.w("ZPlanEntityManagerFactory", 1, "build: uin is null!! now use the default value: \"\"");
            }
            Companion companion = INSTANCE;
            if (uin == null) {
                uin = "";
            }
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, companion.a(uin), 4);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        SQLiteOpenHelper dbHelper = this.dbHelper;
        Intrinsics.checkNotNullExpressionValue(dbHelper, "dbHelper");
        return dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        Package r06 = c.class.getPackage();
        Intrinsics.checkNotNull(r06);
        String name = r06.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this::class.java.`package`!!.name");
        return name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase db5, int oldVersion, int newVersion) {
        if (db5 == null) {
            QLog.e("ZPlanEntityManagerFactory", 1, "upgradeDatabase: db is null!!");
            return;
        }
        if (oldVersion > newVersion) {
            a(db5);
            createDatabase(db5);
            QLog.i("ZPlanEntityManagerFactory", 1, "upgradeDatabase: downgrade db version from " + oldVersion + " to " + newVersion);
        }
        if (oldVersion < 4) {
            db5.execSQL(TableBuilder.dropSQLStatement(ZPlanUserInfo.class.getSimpleName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase db5) {
        if (db5 != null) {
            db5.execSQL(TableBuilder.createSQLStatement(new ZPlanUserInfo()));
            db5.execSQL(TableBuilder.createSQLStatement(new ZPlanCoupleAvatarProfileInfo()));
        } else {
            QLog.e("ZPlanEntityManagerFactory", 1, "createDatabase: db is null!!");
        }
    }
}
