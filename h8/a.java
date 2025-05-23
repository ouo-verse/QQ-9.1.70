package h8;

import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.preview.database.PictureViewerCacheData;
import cooperation.qzone.util.QZLog;
import n7.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final C10420a f404556a = new C10420a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: h8.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10420a {

        /* renamed from: a, reason: collision with root package name */
        long f404557a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f404558b;

        /* renamed from: c, reason: collision with root package name */
        a.InterfaceC10828a f404559c = new C10421a();

        /* compiled from: P */
        /* renamed from: h8.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        class C10421a implements a.InterfaceC10828a {
            C10421a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                C10420a c10420a = C10420a.this;
                c10420a.f404557a = 0L;
                c10420a.f404558b = null;
            }
        }

        C10420a() {
        }
    }

    public void a() {
        DbCacheManager dbCacheManager;
        C10420a c10420a = this.f404556a;
        if (c10420a == null || (dbCacheManager = c10420a.f404558b) == null) {
            return;
        }
        dbCacheManager.close();
    }

    public PictureViewerCacheData c() {
        b(this.f404556a);
        PictureViewerCacheData pictureViewerCacheData = (PictureViewerCacheData) this.f404556a.f404558b.k0("uin=?", new String[]{LoginData.getInstance().getUinString()});
        d(LoginData.getInstance().getUinString());
        a();
        return pictureViewerCacheData;
    }

    public void d(String str) {
        b(this.f404556a);
        this.f404556a.f404558b.b0("uin=?", new String[]{str});
    }

    public void e(PictureViewerCacheData pictureViewerCacheData) {
        b(this.f404556a);
        this.f404556a.f404558b.o0(pictureViewerCacheData, 1);
        a();
    }

    private void b(C10420a c10420a) {
        DbCacheManager dbCacheManager;
        if (c10420a == null) {
            QZLog.d("kaedelin", 1, "ensureCacheHolder cacheHolder == null");
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != c10420a.f404557a || (dbCacheManager = c10420a.f404558b) == null || dbCacheManager.isClosed()) {
            c10420a.f404557a = uin;
            DbCacheManager h16 = c.g().h(PictureViewerCacheData.class, uin, "picture_db");
            c10420a.f404558b = h16;
            h16.U(c10420a.f404559c);
        }
    }
}
