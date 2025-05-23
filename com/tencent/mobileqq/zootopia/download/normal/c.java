package com.tencent.mobileqq.zootopia.download.normal;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\"\u0010\u000e\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/c;", "Lcom/tencent/mobileqq/persistence/EntityManagerFactory;", "", "name", "Lcom/tencent/mobileqq/app/SQLiteOpenHelper;", "build", "getPackageName", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "createDatabase", "", "oldVersion", "newVersion", "upgradeDatabase", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends EntityManagerFactory {
    public c() {
        super("");
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String name) {
        if (this.dbHelper == null) {
            this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, "zootopia_file_download_db.db", 1);
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
        String name = r06 != null ? r06.getName() : null;
        return name == null ? "" : name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void createDatabase(SQLiteDatabase db5) {
        if (db5 != null) {
            db5.execSQL(TableBuilder.createSQLStatement(new FileDownloadEntity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void upgradeDatabase(SQLiteDatabase db5, int oldVersion, int newVersion) {
    }
}
