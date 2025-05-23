package n7;

import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: n7.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10828a {
        void onClosed(a aVar);
    }

    boolean a(IDBCacheDataWrapper iDBCacheDataWrapper);

    void close();

    IDBCacheDataWrapper dbQueryFirstData(String str, String str2, String[] strArr);

    boolean isClosed();
}
