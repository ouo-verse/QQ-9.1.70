package com.qzone.publish.business.publishqueue;

import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.publish.business.task.IQueueTask;
import java.util.ArrayList;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final a f51136a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        long f51137a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f51138b;

        /* renamed from: c, reason: collision with root package name */
        a.InterfaceC10828a f51139c = new C0440a();

        /* compiled from: P */
        /* renamed from: com.qzone.publish.business.publishqueue.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0440a implements a.InterfaceC10828a {
            C0440a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                a aVar2 = a.this;
                aVar2.f51137a = 0L;
                aVar2.f51138b = null;
            }
        }

        a() {
        }
    }

    public void b(IQueueTask iQueueTask) {
        DbCacheManager dbCacheManager;
        a(this.f51136a);
        a aVar = this.f51136a;
        if (aVar == null || (dbCacheManager = aVar.f51138b) == null) {
            return;
        }
        dbCacheManager.b0("client_key=?", new String[]{iQueueTask.getCommentUniKey()});
    }

    public ArrayList<IQueueTask> c() {
        a(this.f51136a);
        ArrayList<? extends IDBCacheDataWrapper> i06 = this.f51136a.f51138b.i0("type=?", new String[]{String.valueOf(17)}, null, 0, 0);
        if (i06 == null) {
            return null;
        }
        ArrayList<IQueueTask> arrayList = new ArrayList<>();
        int size = i06.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) i06.get(i3);
            if (dVar != null && dVar.getQueueTask() != null) {
                IQueueTask queueTask = dVar.getQueueTask();
                if (queueTask.getState() != 6) {
                    queueTask.setState(2);
                }
                arrayList.add(dVar.getQueueTask());
            }
        }
        return arrayList;
    }

    public void d(IQueueTask iQueueTask) {
        DbCacheManager dbCacheManager;
        a(this.f51136a);
        a aVar = this.f51136a;
        if (aVar == null || (dbCacheManager = aVar.f51138b) == null) {
            return;
        }
        dbCacheManager.o0(new d(iQueueTask), 1);
    }

    public void e(IQueueTask iQueueTask) {
        DbCacheManager dbCacheManager;
        a(this.f51136a);
        String[] strArr = {iQueueTask.getCommentUniKey()};
        a aVar = this.f51136a;
        if (aVar == null || (dbCacheManager = aVar.f51138b) == null) {
            return;
        }
        dbCacheManager.v0(new d(iQueueTask), "client_key=?", strArr);
    }

    private void a(a aVar) {
        DbCacheManager dbCacheManager;
        if (aVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != aVar.f51137a || (dbCacheManager = aVar.f51138b) == null || dbCacheManager.isClosed()) {
            aVar.f51137a = uin;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(d.class, uin, "report_publish_queue");
            aVar.f51138b = e16;
            e16.U(aVar.f51139c);
        }
    }
}
