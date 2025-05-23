package com.tencent.mobileqq.data.entitymanager;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.entitymanager.Interceptor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FindTableNameInterceptorChain implements Interceptor.Chain<Class> {

    /* renamed from: db, reason: collision with root package name */
    public final SQLiteDatabase f203156db;
    private final int index;
    private final List<Interceptor<Class>> interceptors;
    public final int newVersion;
    public final int oldVersion;
    public final String tableName;

    public FindTableNameInterceptorChain(int i3, String str, List<Interceptor<Class>> list, int i16, int i17, SQLiteDatabase sQLiteDatabase) {
        this.index = i3;
        this.oldVersion = i16;
        this.newVersion = i17;
        this.tableName = str;
        this.interceptors = list;
        this.f203156db = sQLiteDatabase;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.data.entitymanager.Interceptor.Chain
    public Class proceed() {
        return proceed(this.tableName);
    }

    public Class proceed(String str) {
        List<Interceptor<Class>> list = this.interceptors;
        if (list == null || this.index >= list.size()) {
            return null;
        }
        return this.interceptors.get(this.index).intercept(new FindTableNameInterceptorChain(this.index + 1, str, this.interceptors, this.oldVersion, this.newVersion, this.f203156db));
    }
}
