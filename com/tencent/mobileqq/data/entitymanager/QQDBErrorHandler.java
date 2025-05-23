package com.tencent.mobileqq.data.entitymanager;

import android.annotation.TargetApi;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQDBErrorHandler implements DatabaseErrorHandler {
    private final List<Interceptor<Void>> mCorruptionInterceptors;
    private final DefaultDatabaseErrorHandler mDefaultErrorHandler = new DefaultDatabaseErrorHandler();

    @TargetApi(11)
    public QQDBErrorHandler(List<Interceptor<Void>> list) {
        this.mCorruptionInterceptors = list;
    }

    @Override // android.database.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        try {
            if (QLog.isColorLevel()) {
                QLog.i("QQDatabaseErrorHandler", 2, "[SQLiteDatabaseCorruptException]Corruption reported by sqlite on database: " + sQLiteDatabase.getPath());
            }
            new CorruptionInterceptorChain(0, this.mCorruptionInterceptors, sQLiteDatabase, this.mDefaultErrorHandler).proceed();
        } catch (StackOverflowError unused) {
            this.mDefaultErrorHandler.onCorruption(sQLiteDatabase);
        }
    }
}
