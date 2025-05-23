package hynb.s;

import android.content.Context;
import android.database.Cursor;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public volatile c f406841a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList<hynb.s.a> f406842b = new LinkedList<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f406843a;

        public a(Context context) {
            this.f406843a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f406841a = new c(this.f406843a, "huya_statistics");
        }
    }

    public b(Context context) {
        hynb.u.c.a(new a(context));
    }

    public boolean b(int i3) {
        synchronized (this.f406842b) {
            if (i3 > this.f406842b.size()) {
                i3 = this.f406842b.size();
            }
            this.f406842b.subList(0, i3).clear();
        }
        return true;
    }

    public void a(hynb.s.a aVar) {
        synchronized (this.f406842b) {
            this.f406842b.add(aVar);
        }
        try {
            this.f406841a.getWritableDatabase().execSQL("INSERT INTO task_data( uuid,content , createTime, lastSendTime , sendCount , isSuccess) VALUES(?,?,?,?,?,?)", new Object[]{aVar.f406840c, aVar.f406838a, Long.valueOf(aVar.f406839b), 0, 0, 0});
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
    
        if (r1 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (r1 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<hynb.s.a> a(int i3, long j3) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.f406841a.getWritableDatabase().rawQuery("SELECT id,uuid,content , createTime, lastSendTime , sendCount , isSuccess FROM task_data  WHERE  isSuccess=0  and createTime <=? ORDER BY id  limit ?", new String[]{String.valueOf(j3), String.valueOf(i3)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    hynb.s.a aVar = new hynb.s.a();
                    cursor.getLong(0);
                    aVar.f406840c = cursor.getBlob(1);
                    aVar.f406838a = cursor.getBlob(2);
                    aVar.f406839b = cursor.getLong(3);
                    cursor.getLong(4);
                    cursor.getInt(6);
                    arrayList.add(aVar);
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            if (cursor != null) {
                cursor.close();
            }
            throw th5;
        }
    }

    public Collection<hynb.s.a> a(int i3) {
        LinkedList linkedList;
        synchronized (this.f406842b) {
            if (i3 > this.f406842b.size()) {
                i3 = this.f406842b.size();
            }
            linkedList = new LinkedList(this.f406842b.subList(0, i3));
        }
        return linkedList;
    }

    public boolean a(Object[] objArr, boolean z16) {
        StringBuilder sb5 = new StringBuilder("UPDATE  task_data  SET isSuccess=");
        sb5.append(z16 ? "1" : "0");
        sb5.append(",lastSendTime= ");
        sb5.append(String.valueOf(System.currentTimeMillis()));
        sb5.append(",sendCount=sendCount+1");
        sb5.append(" WHERE  uuid in(");
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (i3 < length - 1) {
                sb5.append(",");
            }
        }
        sb5.append(")");
        try {
            this.f406841a.getWritableDatabase().execSQL(sb5.toString(), objArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f406841a.getWritableDatabase().execSQL("DELETE FROM task_data WHERE createTime<? OR (isSuccess=1 AND createTime<?)", new Object[]{Long.valueOf(currentTimeMillis - 1296000000), Long.valueOf(currentTimeMillis - 259200000)});
        } catch (Exception unused) {
        }
    }
}
