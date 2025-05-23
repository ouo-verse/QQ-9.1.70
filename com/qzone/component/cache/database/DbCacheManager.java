package com.qzone.component.cache.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DbCacheManager extends AbstractDbCacheManager implements n7.a {

    /* renamed from: n, reason: collision with root package name */
    private String f46655n;

    /* renamed from: o, reason: collision with root package name */
    private String f46656o;

    /* renamed from: p, reason: collision with root package name */
    private String[] f46657p;

    /* renamed from: q, reason: collision with root package name */
    private final ArrayList<WeakReference<a>> f46658q;

    /* renamed from: r, reason: collision with root package name */
    private final ArrayList<WeakReference<a.InterfaceC10828a>> f46659r;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(DbCacheManager dbCacheManager);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DbCacheManager(Context context, Class<? extends IDBCacheDataWrapper> cls, long j3, int i3, int i16, String str, int i17) {
        super(context, cls, j3, i3, i16, str, i17);
        this.f46658q = new ArrayList<>();
        this.f46659r = new ArrayList<>();
    }

    private List<a> X() {
        ArrayList arrayList;
        synchronized (this.f46658q) {
            arrayList = null;
            if (this.f46658q.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<a>> it = this.f46658q.iterator();
                while (it.hasNext()) {
                    WeakReference<a> next = it.next();
                    a aVar = next == null ? null : next.get();
                    if (aVar != null) {
                        arrayList2.add(aVar);
                    }
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    private List<a.InterfaceC10828a> Y() {
        ArrayList arrayList;
        synchronized (this.f46659r) {
            arrayList = null;
            if (this.f46659r.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<a.InterfaceC10828a>> it = this.f46659r.iterator();
                while (it.hasNext()) {
                    WeakReference<a.InterfaceC10828a> next = it.next();
                    a.InterfaceC10828a interfaceC10828a = next == null ? null : next.get();
                    if (interfaceC10828a != null) {
                        arrayList2.add(interfaceC10828a);
                    }
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        List<a.InterfaceC10828a> Y = Y();
        if (Y != null) {
            for (a.InterfaceC10828a interfaceC10828a : Y) {
                if (interfaceC10828a != null) {
                    interfaceC10828a.onClosed(this);
                }
            }
        }
    }

    private void z() {
        List<a> X = X();
        if (X != null) {
            for (a aVar : X) {
                if (aVar != null) {
                    aVar.a(this);
                }
            }
        }
    }

    @Override // com.qzone.component.cache.database.AbstractDbCacheManager
    protected void A() {
        z();
    }

    @Override // com.qzone.component.cache.database.AbstractDbCacheManager
    protected void B() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.component.cache.database.DbCacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager.this.f0();
            }
        });
    }

    @Override // com.qzone.component.cache.database.AbstractDbCacheManager
    public Cursor F(String str, String[] strArr) {
        return super.F(str, strArr);
    }

    public void W() {
        synchronized (this) {
            f(null, null);
        }
    }

    public boolean Z(IDBCacheDataWrapper iDBCacheDataWrapper, int i3) {
        boolean I;
        synchronized (this) {
            I = I(i3, this.f46655n, null, iDBCacheDataWrapper);
        }
        return I;
    }

    @Override // n7.a
    public boolean a(IDBCacheDataWrapper iDBCacheDataWrapper) {
        boolean I;
        synchronized (this) {
            I = I(1, this.f46655n, this.f46657p, iDBCacheDataWrapper);
        }
        return I;
    }

    public int b0(String str, String[] strArr) {
        int f16;
        synchronized (this) {
            f16 = f(str, strArr);
        }
        return f16;
    }

    @Deprecated
    public int c0(Collection<String> collection) {
        int g16;
        synchronized (this) {
            g16 = g(collection);
        }
        return g16;
    }

    @Override // com.qzone.component.cache.database.AbstractDbCacheManager, n7.a
    public void close() {
        super.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r3 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r3 == null) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0038 A[Catch: all -> 0x003c, TryCatch #4 {, blocks: (B:3:0x0001, B:5:0x0007, B:11:0x0024, B:12:0x0032, B:28:0x0038, B:29:0x003b), top: B:2:0x0001 }] */
    @Override // n7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IDBCacheDataWrapper dbQueryFirstData(String str, String str2, String[] strArr) {
        Cursor cursor;
        IDBCacheDataWrapper iDBCacheDataWrapper;
        synchronized (this) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f46656o;
            }
            Cursor cursor2 = null;
            iDBCacheDataWrapper = null;
            iDBCacheDataWrapper = null;
            iDBCacheDataWrapper = null;
            iDBCacheDataWrapper = null;
            try {
                cursor = p(str, strArr, str2, "1");
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                iDBCacheDataWrapper = o(cursor, 0);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e17) {
                e = e17;
                cursor = null;
            } catch (Throwable th6) {
                th = th6;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
        return iDBCacheDataWrapper;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        if (r2 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e0() {
        int i3;
        synchronized (this) {
            String str = "select count(1) from " + this.f46646d;
            if (!TextUtils.isEmpty(this.f46655n)) {
                str = str + " where " + this.f46655n;
            }
            i3 = 0;
            Cursor cursor = null;
            try {
                try {
                    cursor = F(str, this.f46657p);
                    if (cursor != null && cursor.moveToFirst()) {
                        i3 = cursor.getInt(0);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i3;
    }

    @Override // com.qzone.component.cache.database.AbstractDbCacheManager, n7.a
    public boolean isClosed() {
        return super.isClosed();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0077, code lost:
    
        if (r9 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<? extends IDBCacheDataWrapper> j0(String str, String str2, String[] strArr, String str3, int i3, int i16) {
        String str4;
        ArrayList<? extends IDBCacheDataWrapper> arrayList = new ArrayList<>();
        synchronized (this) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f46655n;
            }
            String str5 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = this.f46656o;
            }
            String str6 = str3;
            if (str5 != null && str5.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && (strArr == null || strArr.length <= 0)) {
                strArr = this.f46657p;
            }
            String[] strArr2 = strArr;
            Cursor cursor = null;
            if (i3 < 0 || i16 <= 0) {
                str4 = null;
            } else {
                str4 = i3 + "," + i16;
            }
            try {
                try {
                    cursor = q(str, str5, strArr2, str6, str4);
                    if (cursor != null && cursor.getCount() > 0) {
                        int count = cursor.getCount();
                        for (int i17 = 0; i17 < count; i17++) {
                            IDBCacheDataWrapper o16 = o(cursor, i17);
                            if (o16 != null) {
                                arrayList.add(o16);
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    public Object m0(String str, String str2, String[] strArr, String str3) {
        Object obj;
        Object obj2;
        synchronized (this) {
            if (TextUtils.isEmpty(str3)) {
                str3 = this.f46656o;
            }
            String str4 = str3;
            Cursor cursor = null;
            r10 = null;
            r10 = null;
            r10 = null;
            Object obj3 = null;
            cursor = null;
            try {
                try {
                    Cursor q16 = q(str, str2, strArr, str4, "1");
                    if (q16 != null) {
                        try {
                            try {
                                if (q16.getCount() > 0) {
                                    if (str == null) {
                                        obj3 = o(q16, 0);
                                    } else {
                                        if (q16.isClosed()) {
                                            q16.close();
                                            return null;
                                        }
                                        if (q16.moveToFirst()) {
                                            obj2 = null;
                                            while (!q16.isAfterLast()) {
                                                try {
                                                    String[] columnNames = q16.getColumnNames();
                                                    if (columnNames != null && columnNames.length > 0) {
                                                        int i3 = 0;
                                                        obj2 = obj2;
                                                        while (i3 < columnNames.length) {
                                                            if (str.equals(columnNames[i3])) {
                                                                int type = q16.getType(q16.getColumnIndex(columnNames[i3]));
                                                                if (type != 0) {
                                                                    if (type == 1) {
                                                                        obj2 = Integer.valueOf(q16.getInt(q16.getColumnIndex(str)));
                                                                    } else if (type == 2) {
                                                                        obj2 = Float.valueOf(q16.getFloat(q16.getColumnIndex(str)));
                                                                    } else if (type == 3) {
                                                                        obj2 = q16.getString(q16.getColumnIndex(str));
                                                                    } else if (type == 4) {
                                                                        obj2 = q16.getBlob(q16.getColumnIndex(str));
                                                                    }
                                                                }
                                                                obj2 = null;
                                                            }
                                                            i3++;
                                                            obj2 = obj2;
                                                        }
                                                    }
                                                    q16.moveToNext();
                                                    obj2 = obj2;
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    cursor = q16;
                                                    obj = obj2;
                                                    e.printStackTrace();
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                    obj3 = obj;
                                                    return obj3;
                                                }
                                            }
                                            q16.close();
                                            obj3 = obj2;
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                cursor = q16;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            obj2 = obj3;
                        }
                    }
                    if (q16 != null) {
                        q16.close();
                    }
                } catch (Exception e18) {
                    e = e18;
                    obj = null;
                }
                return obj3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    public boolean o0(IDBCacheDataWrapper iDBCacheDataWrapper, int i3) {
        boolean I;
        synchronized (this) {
            I = I(i3, this.f46655n, this.f46657p, iDBCacheDataWrapper);
        }
        return I;
    }

    public boolean p0(Collection<? extends IDBCacheDataWrapper> collection, int i3) {
        boolean H;
        synchronized (this) {
            H = H(i3, this.f46655n, this.f46657p, collection);
        }
        return H;
    }

    public boolean q0(IDBCacheDataWrapper[] iDBCacheDataWrapperArr, int i3) {
        boolean I;
        synchronized (this) {
            I = I(i3, this.f46655n, this.f46657p, iDBCacheDataWrapperArr);
        }
        return I;
    }

    @Deprecated
    public void r0(String str) {
        if (d0(this.f46655n, str)) {
            return;
        }
        this.f46655n = str;
    }

    @Deprecated
    public void s0(String str) {
        if (d0(this.f46656o, str)) {
            return;
        }
        this.f46656o = str;
    }

    @Deprecated
    public void t0(String[] strArr) {
        this.f46657p = strArr;
    }

    public int u0(IDBCacheDataWrapper iDBCacheDataWrapper, String str) {
        int O;
        synchronized (this) {
            O = O(iDBCacheDataWrapper, str, null);
        }
        return O;
    }

    public int v0(IDBCacheDataWrapper iDBCacheDataWrapper, String str, String[] strArr) {
        int L;
        synchronized (this) {
            ContentValues contentValues = new ContentValues();
            iDBCacheDataWrapper.writeTo(contentValues);
            L = L(contentValues, str, strArr);
        }
        return L;
    }

    public int w0(String[] strArr, String[] strArr2, String str, String[] strArr3) {
        int P;
        synchronized (this) {
            P = P(strArr, strArr2, str, strArr3);
        }
        return P;
    }

    public IDBCacheDataWrapper k0(String str, String[] strArr) {
        return l0(str, strArr, null);
    }

    public IDBCacheDataWrapper l0(String str, String[] strArr, String str2) {
        return (IDBCacheDataWrapper) m0(null, str, strArr, str2);
    }

    public void U(a.InterfaceC10828a interfaceC10828a) {
        if (interfaceC10828a == null) {
            return;
        }
        synchronized (this.f46659r) {
            this.f46659r.add(new WeakReference<>(interfaceC10828a));
        }
    }

    public void V(int i3, String str) {
        if (i3 > 0 && x()) {
            synchronized (this) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("delete from ");
                sb5.append(this.f46646d);
                sb5.append(" where _id not in (select _id from ");
                sb5.append(this.f46646d);
                if (TextUtils.isEmpty(str)) {
                    str = this.f46656o;
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.f46643a.sortOrder();
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(" order by ");
                    sb5.append(str);
                }
                sb5.append(" limit 0,");
                sb5.append(i3);
                sb5.append(")");
                j(sb5.toString());
            }
        }
    }

    public void n0(a.InterfaceC10828a interfaceC10828a) {
        if (interfaceC10828a == null) {
            return;
        }
        synchronized (this.f46659r) {
            Iterator<WeakReference<a.InterfaceC10828a>> it = this.f46659r.iterator();
            while (it.hasNext()) {
                WeakReference<a.InterfaceC10828a> next = it.next();
                a.InterfaceC10828a interfaceC10828a2 = next == null ? null : next.get();
                if (interfaceC10828a2 == null) {
                    it.remove();
                } else if (interfaceC10828a2 == interfaceC10828a) {
                    it.remove();
                }
            }
        }
    }

    public boolean a0(IDBCacheDataWrapper iDBCacheDataWrapper, String str, String[] strArr) {
        if (iDBCacheDataWrapper == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        iDBCacheDataWrapper.writeTo(contentValues);
        return L(contentValues, str, strArr) != 0;
    }

    public ArrayList<? extends IDBCacheDataWrapper> g0() {
        return i0(null, null, null, 0, 0);
    }

    public ArrayList<? extends IDBCacheDataWrapper> h0(String str, String[] strArr) {
        return i0(str, strArr, null, 0, 0);
    }

    public ArrayList<? extends IDBCacheDataWrapper> i0(String str, String[] strArr, String str2, int i3, int i16) {
        return j0(null, str, strArr, str2, i3, i16);
    }

    private static boolean d0(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
