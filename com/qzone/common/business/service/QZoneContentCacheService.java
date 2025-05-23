package com.qzone.common.business.service;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.model.BusinessContentCacheData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneContentCacheService {

    /* renamed from: a, reason: collision with root package name */
    private List<BusinessContentCacheData> f45590a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final b f45591b = new b();

    /* renamed from: c, reason: collision with root package name */
    a.InterfaceC10828a f45592c = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements a.InterfaceC10828a {
        a() {
        }

        @Override // n7.a.InterfaceC10828a
        public void onClosed(n7.a aVar) {
            QZoneContentCacheService.this.f45591b.f45597a = 0L;
            QZoneContentCacheService.this.f45591b.f45598b = null;
            QZoneContentCacheService.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        long f45597a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f45598b;

        b() {
        }
    }

    private DbCacheManager i() {
        g(this.f45591b);
        return this.f45591b.f45598b;
    }

    public synchronized void b() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - 43200);
        i().b0("timestamp<?", new String[]{"" + currentTimeMillis});
    }

    public void c() {
        List<BusinessContentCacheData> list = this.f45590a;
        if (list != null) {
            list.clear();
        }
    }

    protected synchronized void e(String str) {
        List<BusinessContentCacheData> list;
        BusinessContentCacheData businessContentCacheData;
        DbCacheManager i3 = i();
        if (str != null && !TextUtils.isEmpty(str) && i3 != null && (list = this.f45590a) != null) {
            Iterator<BusinessContentCacheData> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    businessContentCacheData = null;
                    break;
                }
                businessContentCacheData = it.next();
                if (str.equals(businessContentCacheData.getUnikey())) {
                    this.f45590a.remove(businessContentCacheData);
                    break;
                }
            }
            if (businessContentCacheData != null) {
                i3.b0("uin=? AND unikey=?", new String[]{this.f45591b.f45597a + "", str});
            }
        }
    }

    protected synchronized void f() {
        List<BusinessContentCacheData> list = this.f45590a;
        if (list != null && list.size() > 50) {
            String str = "";
            int i3 = 0;
            for (BusinessContentCacheData businessContentCacheData : this.f45590a) {
                if (i3 == 0 || businessContentCacheData.getTimestamp() < i3) {
                    i3 = businessContentCacheData.getTimestamp();
                    str = businessContentCacheData.getUnikey();
                }
            }
            d(str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (((java.lang.System.currentTimeMillis() / 1000) - 43200) >= r2.getTimestamp()) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r0 = new com.qzone.common.business.model.BusinessContentCacheData(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized BusinessContentCacheData h(String str) {
        BusinessContentCacheData businessContentCacheData = null;
        if (str != null) {
            if (!TextUtils.isEmpty(str)) {
                List<BusinessContentCacheData> list = this.f45590a;
                if (list != null && !list.isEmpty()) {
                    Iterator<BusinessContentCacheData> it = this.f45590a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        BusinessContentCacheData next = it.next();
                        if (str.equals(next.getUnikey())) {
                            break;
                        }
                    }
                    return businessContentCacheData;
                }
                return null;
            }
        }
        return null;
    }

    public void j() {
        ArrayList<? extends IDBCacheDataWrapper> g06;
        DbCacheManager i3 = i();
        if (i3 == null || (g06 = i3.g0()) == null) {
            return;
        }
        this.f45590a.addAll(g06);
    }

    protected synchronized void k(BusinessContentCacheData businessContentCacheData, int i3) {
        boolean z16;
        DbCacheManager i16 = i();
        if (i16 != null && businessContentCacheData != null && this.f45590a != null) {
            businessContentCacheData.setUin(this.f45591b.f45597a);
            Iterator<BusinessContentCacheData> it = this.f45590a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                BusinessContentCacheData next = it.next();
                if (businessContentCacheData.getUnikey().equals(next.getUnikey())) {
                    if (businessContentCacheData.getContent().equals(next.getContent())) {
                        return;
                    }
                    next.setContent(businessContentCacheData.getContent());
                    next.setTimestamp(businessContentCacheData.getTimestamp());
                    z16 = true;
                }
            }
            if (z16) {
                i16.v0(businessContentCacheData, "uin=? AND unikey=?", new String[]{String.valueOf(this.f45591b.f45597a), businessContentCacheData.getUnikey()});
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(businessContentCacheData);
                i16.p0(arrayList, 1);
                this.f45590a.add(new BusinessContentCacheData(businessContentCacheData));
                if (this.f45590a.size() > 50) {
                    f();
                }
            }
        }
    }

    private void g(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f45597a || (dbCacheManager = bVar.f45598b) == null || dbCacheManager.isClosed()) {
            bVar.f45597a = uin;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(BusinessContentCacheData.class, uin, "ContentCache");
            bVar.f45598b = e16;
            e16.r0("uin=?");
            bVar.f45598b.t0(new String[]{"" + uin});
            bVar.f45598b.U(this.f45592c);
        }
    }

    public void d(final String str) {
        if (str == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.business.service.QZoneContentCacheService.3
            @Override // java.lang.Runnable
            public void run() {
                QZoneContentCacheService.this.e(str);
            }
        });
    }

    public void l(final BusinessContentCacheData businessContentCacheData, final int i3) {
        if (businessContentCacheData == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.common.business.service.QZoneContentCacheService.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneContentCacheService.this.k(businessContentCacheData, i3);
            }
        });
    }
}
