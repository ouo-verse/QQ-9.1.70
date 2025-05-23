package com.tencent.mobileqq.data.entitymanager;

import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CorruptionInterceptorChain implements Interceptor.Chain<Void> {
    public final SQLiteDatabase database;
    public final DefaultDatabaseErrorHandler defaultErrorHandler;
    private final int index;
    private final List<Interceptor<Void>> interceptors;

    public CorruptionInterceptorChain(int i3, List<Interceptor<Void>> list, SQLiteDatabase sQLiteDatabase, DefaultDatabaseErrorHandler defaultDatabaseErrorHandler) {
        this.index = i3;
        this.interceptors = list;
        this.database = sQLiteDatabase;
        this.defaultErrorHandler = defaultDatabaseErrorHandler;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor.Chain
    public Void proceed() {
        List<Interceptor<Void>> list = this.interceptors;
        if (list == null || this.index >= list.size()) {
            return null;
        }
        return this.interceptors.get(this.index).intercept(new CorruptionInterceptorChain(this.index + 1, this.interceptors, this.database, this.defaultErrorHandler));
    }
}
