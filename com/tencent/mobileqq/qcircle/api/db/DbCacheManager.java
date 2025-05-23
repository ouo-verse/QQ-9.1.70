package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DbCacheManager extends AbstractDbCacheManager implements IDBManagerWrapper {

    /* renamed from: n, reason: collision with root package name */
    private String f261636n;

    /* renamed from: o, reason: collision with root package name */
    private String f261637o;

    /* renamed from: p, reason: collision with root package name */
    private String[] f261638p;

    /* renamed from: q, reason: collision with root package name */
    private final ArrayList<WeakReference<a>> f261639q;

    /* renamed from: r, reason: collision with root package name */
    private final ArrayList<WeakReference<IDBManagerWrapper.OnCloseListener>> f261640r;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(DbCacheManager dbCacheManager);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DbCacheManager(Context context, Class<? extends IDBCacheDataWrapper> cls, long j3, int i3, int i16, String str, int i17) {
        super(context, cls, j3, i3, i16, str, i17);
        this.f261639q = new ArrayList<>();
        this.f261640r = new ArrayList<>();
    }

    private List<a> X() {
        ArrayList arrayList;
        a aVar;
        synchronized (this.f261639q) {
            arrayList = null;
            if (this.f261639q.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<a>> it = this.f261639q.iterator();
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

    private List<IDBManagerWrapper.OnCloseListener> Y() {
        ArrayList arrayList;
        IDBManagerWrapper.OnCloseListener onCloseListener;
        synchronized (this.f261640r) {
            arrayList = null;
            if (this.f261640r.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<IDBManagerWrapper.OnCloseListener>> it = this.f261640r.iterator();
                while (it.hasNext()) {
                    WeakReference<IDBManagerWrapper.OnCloseListener> next = it.next();
                    if (next == null) {
                        onCloseListener = null;
                    } else {
                        onCloseListener = next.get();
                    }
                    if (onCloseListener != null) {
                        arrayList2.add(onCloseListener);
                    }
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        List<IDBManagerWrapper.OnCloseListener> Y = Y();
        if (Y != null) {
            for (IDBManagerWrapper.OnCloseListener onCloseListener : Y) {
                if (onCloseListener != null) {
                    onCloseListener.onClosed(this);
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

    @Override // com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager
    protected void A() {
        z();
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager
    protected void B() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.db.DbCacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager.this.b0();
            }
        });
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager
    public Cursor H(String str, String[] strArr) {
        return super.H(str, strArr);
    }

    public void W() {
        synchronized (this) {
            e(null, null);
        }
    }

    public List<IDBCacheDataWrapper> Z(String str, String[] strArr, String str2) {
        return a0(str, strArr, str2, 0, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0070, code lost:
    
        if (r1 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<IDBCacheDataWrapper> a0(String str, String[] strArr, String str2, int i3, int i16) {
        String str3;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                str = this.f261636n;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f261637o;
            }
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && (strArr == null || strArr.length <= 0)) {
                strArr = this.f261638p;
            }
            Cursor cursor = null;
            if (i3 >= 0 && i16 > 0) {
                str3 = i3 + "," + i16;
            } else {
                str3 = null;
            }
            try {
                try {
                    cursor = o(str, strArr, str2, str3);
                    if (cursor != null && cursor.getCount() > 0) {
                        int count = cursor.getCount();
                        for (int i17 = 0; i17 < count; i17++) {
                            DbCacheData dbCacheData = (DbCacheData) n(cursor, i17);
                            if (dbCacheData != null) {
                                arrayList.add(dbCacheData);
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

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public void addCloseListener(IDBManagerWrapper.OnCloseListener onCloseListener) {
        if (onCloseListener == null) {
            return;
        }
        synchronized (this.f261640r) {
            this.f261640r.add(new WeakReference<>(onCloseListener));
        }
    }

    public ArrayList<? extends IDBCacheDataWrapper> c0(String str, String[] strArr, String str2, int i3, int i16) {
        return d0(null, str, strArr, str2, i3, i16);
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager, com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public void close() {
        super.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0077, code lost:
    
        if (r9 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<? extends IDBCacheDataWrapper> d0(String str, String str2, String[] strArr, String str3, int i3, int i16) {
        String str4;
        ArrayList<? extends IDBCacheDataWrapper> arrayList = new ArrayList<>();
        synchronized (this) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f261636n;
            }
            String str5 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = this.f261637o;
            }
            String str6 = str3;
            if (str5 != null && str5.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && (strArr == null || strArr.length <= 0)) {
                strArr = this.f261638p;
            }
            String[] strArr2 = strArr;
            Cursor cursor = null;
            if (i3 >= 0 && i16 > 0) {
                str4 = i3 + "," + i16;
            } else {
                str4 = null;
            }
            try {
                try {
                    cursor = p(str, str5, strArr2, str6, str4);
                    if (cursor != null && cursor.getCount() > 0) {
                        int count = cursor.getCount();
                        for (int i17 = 0; i17 < count; i17++) {
                            IDBCacheDataWrapper n3 = n(cursor, i17);
                            if (n3 != null) {
                                arrayList.add(n3);
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

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    @Deprecated
    public long dbDeleteData(String str) {
        long e16;
        synchronized (this) {
            e16 = e(str, null);
        }
        return e16;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean dbInsertData(IDBCacheDataWrapper iDBCacheDataWrapper) {
        boolean K;
        synchronized (this) {
            K = K(1, this.f261636n, this.f261638p, iDBCacheDataWrapper);
        }
        return K;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    @Deprecated
    public List<IDBCacheDataWrapper> dbQueryData(String str, String str2) {
        return Z(str, null, str2);
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public IDBCacheDataWrapper dbQueryFirstData(String str, String str2) {
        return dbQueryFirstData(str, str2, null);
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    @Deprecated
    public boolean dbUpdateData(ContentValues contentValues, String str) {
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public int deleteData(String str, String[] strArr) {
        int e16;
        synchronized (this) {
            e16 = e(str, strArr);
        }
        return e16;
    }

    public void e0(IDBManagerWrapper.OnCloseListener onCloseListener) {
        IDBManagerWrapper.OnCloseListener onCloseListener2;
        if (onCloseListener == null) {
            return;
        }
        synchronized (this.f261640r) {
            Iterator<WeakReference<IDBManagerWrapper.OnCloseListener>> it = this.f261640r.iterator();
            while (it.hasNext()) {
                WeakReference<IDBManagerWrapper.OnCloseListener> next = it.next();
                if (next == null) {
                    onCloseListener2 = null;
                } else {
                    onCloseListener2 = next.get();
                }
                if (onCloseListener2 == null) {
                    it.remove();
                } else if (onCloseListener2 == onCloseListener) {
                    it.remove();
                }
            }
        }
    }

    public int f0(IDBCacheDataWrapper iDBCacheDataWrapper, String str) {
        int P;
        synchronized (this) {
            P = P(iDBCacheDataWrapper, str, null);
        }
        return P;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
    
        if (r1 == null) goto L21;
     */
    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCount(String str) {
        int i3;
        synchronized (this) {
            String str2 = "select count(1) from " + this.f261627d;
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + " where " + str;
            }
            i3 = 0;
            Cursor cursor = null;
            try {
                try {
                    cursor = H(str2, this.f261638p);
                    if (cursor != null && cursor.moveToFirst()) {
                        i3 = cursor.getInt(0);
                    }
                } catch (Exception e16) {
                    QLog.e("DbCacheManager", 1, "[getCount] table:" + this.f261627d, e16.getMessage());
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.AbstractDbCacheManager, com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean isClosed() {
        return super.isClosed();
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public ArrayList<? extends IDBCacheDataWrapper> queryData() {
        return c0(null, null, null, 0, 0);
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean saveData(IDBCacheDataWrapper iDBCacheDataWrapper, int i3) {
        boolean K;
        synchronized (this) {
            K = K(i3, this.f261636n, this.f261638p, iDBCacheDataWrapper);
        }
        return K;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public int updateData(IDBCacheDataWrapper iDBCacheDataWrapper, String str, String[] strArr) {
        int N;
        synchronized (this) {
            ContentValues contentValues = new ContentValues();
            iDBCacheDataWrapper.writeTo(contentValues);
            N = N(contentValues, str, strArr);
        }
        return N;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    @Deprecated
    public List<IDBCacheDataWrapper> dbQueryData(String str, String str2, int i3, int i16) {
        return a0(str, null, str2, i3, i16);
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
    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IDBCacheDataWrapper dbQueryFirstData(String str, String str2, String[] strArr) {
        Cursor cursor;
        IDBCacheDataWrapper iDBCacheDataWrapper;
        synchronized (this) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f261637o;
            }
            Cursor cursor2 = null;
            iDBCacheDataWrapper = null;
            iDBCacheDataWrapper = null;
            iDBCacheDataWrapper = null;
            iDBCacheDataWrapper = null;
            try {
                cursor = o(str, strArr, str2, "1");
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                iDBCacheDataWrapper = n(cursor, 0);
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

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    @Deprecated
    public boolean dbUpdateData(IDBCacheDataWrapper iDBCacheDataWrapper, String str) {
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean dbUpdateData(ContentValues contentValues, String str, String[] strArr) {
        N(contentValues, str, strArr);
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean dbInsertData(IDBCacheDataWrapper iDBCacheDataWrapper, int i3) {
        boolean K;
        synchronized (this) {
            K = K(i3, this.f261636n, this.f261638p, iDBCacheDataWrapper);
        }
        return K;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean dbInsertData(List<? extends IDBCacheDataWrapper> list) {
        boolean J;
        synchronized (this) {
            J = J(1, this.f261636n, this.f261638p, list);
        }
        return J;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean dbInsertData(List<? extends IDBCacheDataWrapper> list, int i3) {
        boolean J;
        synchronized (this) {
            J = J(i3, this.f261636n, this.f261638p, list);
        }
        return J;
    }

    @Override // com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper
    public boolean dbInsertData(List<? extends IDBCacheDataWrapper> list, int i3, String str) {
        throw new RuntimeException("not implements this method dbInsertData(List<? extends IDBCacheDataWrapper> datas, int strategy, String where)");
    }
}
