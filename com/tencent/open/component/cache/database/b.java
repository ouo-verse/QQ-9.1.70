package com.tencent.open.component.cache.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends AbstractDbCacheManager {

    /* renamed from: h, reason: collision with root package name */
    protected Cursor f341131h;

    /* renamed from: i, reason: collision with root package name */
    protected String f341132i;

    /* renamed from: j, reason: collision with root package name */
    protected String f341133j;

    /* renamed from: k, reason: collision with root package name */
    protected final ArrayList<WeakReference<a>> f341134k;

    /* renamed from: l, reason: collision with root package name */
    protected InterfaceC9276b f341135l;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(b bVar);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.open.component.cache.database.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    interface InterfaceC9276b {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, Class<? extends com.tencent.open.component.cache.database.a> cls, long j3, String str) {
        super(context, cls, j3, str);
        this.f341134k = new ArrayList<>();
        w();
    }

    public void A(com.tencent.open.component.cache.database.a aVar, int i3) {
        synchronized (this) {
            q(i3, aVar);
        }
    }

    public void B(com.tencent.open.component.cache.database.a[] aVarArr, int i3) {
        synchronized (this) {
            q(i3, aVarArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(InterfaceC9276b interfaceC9276b) {
        this.f341135l = interfaceC9276b;
    }

    public void D(com.tencent.open.component.cache.database.a aVar, String str) {
        synchronized (this) {
            u(aVar, str);
        }
    }

    @Override // com.tencent.open.component.cache.database.AbstractDbCacheManager
    protected void n() {
        List<a> v3 = v();
        if (v3 != null) {
            for (a aVar : v3) {
                if (aVar != null) {
                    aVar.a(this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.component.cache.database.AbstractDbCacheManager
    public void o(SQLiteDatabase sQLiteDatabase, int i3) {
        if (i3 != 2) {
            super.o(sQLiteDatabase, i3);
        } else {
            c(sQLiteDatabase, this.f341132i);
        }
    }

    protected List<a> v() {
        ArrayList arrayList;
        a aVar;
        synchronized (this.f341134k) {
            arrayList = null;
            if (this.f341134k.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<a>> it = this.f341134k.iterator();
                while (it.hasNext()) {
                    WeakReference<a> next = it.next();
                    if (next == null) {
                        aVar = null;
                    } else {
                        aVar = next.get();
                    }
                    if (aVar != null) {
                        arrayList2.add(aVar);
                    }
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    protected void w() {
        synchronized (this) {
            this.f341131h = i(this.f341132i, this.f341133j);
        }
    }

    public void x(String str) {
        synchronized (this) {
            d(str);
        }
    }

    public int y() {
        int i3;
        synchronized (this) {
            Cursor cursor = this.f341131h;
            if (cursor != null) {
                i3 = cursor.getCount();
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    public com.tencent.open.component.cache.database.a z(int i3) {
        com.tencent.open.component.cache.database.a h16;
        synchronized (this) {
            h16 = h(this.f341131h, i3);
        }
        return h16;
    }
}
