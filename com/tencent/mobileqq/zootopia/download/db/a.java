package com.tencent.mobileqq.zootopia.download.db;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\"\u0010\u0018\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0014J,\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/db/a;", "Lcom/tencent/mobileqq/persistence/EntityManagerFactory;", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "d", "c", "e", "f", "g", h.F, "i", "j", "a", "b", "", "name", "Lcom/tencent/mobileqq/app/SQLiteOpenHelper;", "build", "getPackageName", "createDatabase", "", "oldVersion", "newVersion", "upgradeDatabase", "packageName", "checkTableColumnChange", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends EntityManagerFactory {
    public a() {
        super("");
    }

    private final void a(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "packType", "INTEGER", true, 0));
        }
    }

    private final void b(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "isPlayTogether", "INTEGER", true, 0));
        }
    }

    private final void c(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "startTime", "INTEGER", true, 0));
        }
    }

    private final void d(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "md5", "TEXT", false));
        }
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "showGameHealthyLoading", "INTEGER", true, 0));
        }
    }

    private final void e(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "runScript", "TEXT", false));
        }
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "isAutoDownload", "INTEGER", true, 0));
        }
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "isUpdate", "INTEGER", true, 0));
        }
    }

    private final void f(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "isSilentDownload", "INTEGER", true, 0));
        }
    }

    private final void g(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "needNotification", "INTEGER", true, 0));
        }
    }

    private final void h(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "isUseNewLoading", "INTEGER", true, 0));
        }
    }

    private final void i(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "loadingBackgroundMaterialBytes", "BLOB", false, 0));
        }
    }

    private final void j(SQLiteDatabase db5) {
        String tableName = TableBuilder.getTableName(ZootopiaDownloadEntity.class);
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "pakMd5", "TEXT", false));
        }
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "isDiffUpdate", "INTEGER", true, 0));
        }
        if (db5 != null) {
            db5.execSQL(TableBuilder.addColumn(tableName, "diffPatchInfoBytes", "BLOB", false, 0));
        }
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String name) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "zootopia_download_db.db", 11);
            this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
        }
        SQLiteOpenHelper dbHelper = this.dbHelper;
        Intrinsics.checkNotNullExpressionValue(dbHelper, "dbHelper");
        return dbHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void checkTableColumnChange(String packageName, SQLiteDatabase db5, int oldVersion, int newVersion) {
        try {
            QLog.e("DownloadEntityManagerFactory", 1, "checkTableColumnChange, oldVersion: " + oldVersion + ", newVersion: " + newVersion + ", " + packageName);
            StringBuilder sb5 = new StringBuilder("updateDbLog: ");
            for (int i3 = 1; i3 < 12; i3++) {
                boolean z16 = false;
                if (oldVersion + 1 <= i3 && i3 <= newVersion) {
                    z16 = true;
                }
                if (z16) {
                    sb5.append("updateToV" + i3 + " & ");
                    switch (i3) {
                        case 2:
                            c(db5);
                            break;
                        case 3:
                            d(db5);
                            break;
                        case 4:
                            e(db5);
                            break;
                        case 5:
                            f(db5);
                            break;
                        case 6:
                            g(db5);
                            break;
                        case 7:
                            h(db5);
                            break;
                        case 8:
                            i(db5);
                            break;
                        case 9:
                            j(db5);
                            break;
                        case 10:
                            a(db5);
                            break;
                        case 11:
                            b(db5);
                            break;
                    }
                }
            }
            QLog.e("DownloadEntityManagerFactory", 1, "checkTableColumnChange, " + ((Object) sb5));
        } catch (Throwable th5) {
            QLog.e("DownloadEntityManagerFactory", 1, "update error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public String getPackageName() {
        Package r06 = a.class.getPackage();
        String name = r06 != null ? r06.getName() : null;
        return name == null ? "" : name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase db5) {
        if (db5 != null) {
            db5.execSQL(TableBuilder.createSQLStatement(new ZootopiaDownloadEntity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase db5, int oldVersion, int newVersion) {
    }
}
