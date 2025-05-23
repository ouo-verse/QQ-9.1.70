package d9;

import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.proxy.feedcomponent.util.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f393214b;

    /* renamed from: a, reason: collision with root package name */
    private DbCacheManager f393215a;

    public static a b() {
        if (f393214b == null) {
            synchronized (a.class) {
                if (f393214b == null) {
                    f393214b = new a();
                }
            }
        }
        return f393214b;
    }

    public void c(long j3) {
        this.f393215a = c.g().e(b9.a.class, j3, "outbox_session_data");
    }

    public synchronized void d(com.qzone.publish.outbox.a aVar) {
        j.a("Outbox", 1, "persist session:" + aVar.getSessionId());
        DbCacheManager dbCacheManager = this.f393215a;
        if (dbCacheManager == null) {
            j.a("Outbox", 1, "mOutboxDbCache is null");
        } else {
            dbCacheManager.o0(aVar, 1);
        }
    }

    public synchronized void e(com.qzone.publish.outbox.a aVar) {
        j.a("Outbox", 1, "remove session:" + aVar.getSessionId());
        DbCacheManager dbCacheManager = this.f393215a;
        if (dbCacheManager == null) {
            j.a("Outbox", 1, "mOutboxDbCache is null");
            return;
        }
        dbCacheManager.b0("sessionId=?", new String[]{"" + aVar.getSessionId()});
    }

    public synchronized List<com.qzone.publish.outbox.a> f() {
        j.a("Outbox", 1, "restore outbox");
        DbCacheManager dbCacheManager = this.f393215a;
        if (dbCacheManager == null) {
            j.a("Outbox", 1, "mOutboxDbCache is null");
            return null;
        }
        return dbCacheManager.g0();
    }

    public synchronized void g(com.qzone.publish.outbox.a aVar) {
        j.a("Outbox", 1, "update session:" + aVar.getSessionId());
        DbCacheManager dbCacheManager = this.f393215a;
        if (dbCacheManager == null) {
            j.a("Outbox", 1, "mOutboxDbCache is null");
        } else {
            dbCacheManager.v0(aVar, "sessionId=?", new String[]{String.valueOf(aVar.getSessionId())});
        }
    }

    public void a() {
        this.f393215a = null;
    }
}
