package com.qzone.misc.network.qboss.manager;

import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.misc.network.qboss.model.QBossDBData;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final C0400a f48452a = new C0400a("TABLE_QZONE_QBOSS_DATA", QBossDBData.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.misc.network.qboss.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0400a {

        /* renamed from: a, reason: collision with root package name */
        long f48453a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f48454b;

        /* renamed from: c, reason: collision with root package name */
        String f48455c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f48456d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f48457e = new C0401a();

        /* compiled from: P */
        /* renamed from: com.qzone.misc.network.qboss.manager.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0401a implements a.InterfaceC10828a {
            C0401a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                C0400a c0400a = C0400a.this;
                c0400a.f48453a = 0L;
                c0400a.f48454b = null;
            }
        }

        public C0400a(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f48455c = str;
            this.f48456d = cls;
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f48459a = new a();
    }

    a() {
    }

    public static a c() {
        return b.f48459a;
    }

    private DbCacheManager d(C0400a c0400a) {
        b(c0400a);
        return c0400a.f48454b;
    }

    private DbCacheManager e() {
        return d(this.f48452a);
    }

    public int a(int i3) {
        DbCacheManager e16 = e();
        if (e16 == null) {
            return -1;
        }
        return e16.b0("qbossId= ?", new String[]{i3 + ""});
    }

    public QBossDBData f(int i3) {
        DbCacheManager e16 = e();
        if (e16 == null) {
            return null;
        }
        return (QBossDBData) e16.k0("qbossId= ?", new String[]{i3 + ""});
    }

    private void b(C0400a c0400a) {
        DbCacheManager dbCacheManager;
        if (c0400a == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != c0400a.f48453a || (dbCacheManager = c0400a.f48454b) == null || dbCacheManager.isClosed()) {
            c0400a.f48453a = uin;
            DbCacheManager e16 = c.g().e(c0400a.f48456d, uin, c0400a.f48455c);
            c0400a.f48454b = e16;
            e16.U(c0400a.f48457e);
        }
    }

    public boolean g(QBossDBData qBossDBData) {
        DbCacheManager e16;
        if (qBossDBData == null || (e16 = e()) == null) {
            return false;
        }
        e16.r0("qbossId= ?");
        e16.t0(new String[]{qBossDBData.qbossId + ""});
        return e16.o0(qBossDBData, 2);
    }
}
