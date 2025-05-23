package com.qzone.album.business.downloader;

import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import java.util.ArrayList;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f42416a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        long f42417a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f42418b;

        /* renamed from: c, reason: collision with root package name */
        a.InterfaceC10828a f42419c = new C0321a();

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.downloader.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0321a implements a.InterfaceC10828a {
            C0321a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                a aVar2 = a.this;
                aVar2.f42417a = 0L;
                aVar2.f42418b = null;
            }
        }

        a() {
        }
    }

    public void b(IDownloadQueueTask iDownloadQueueTask) {
        a(this.f42416a);
        this.f42416a.f42418b.b0("task_id=?", new String[]{String.valueOf(iDownloadQueueTask.getTaskId())});
    }

    public ArrayList<IDownloadQueueTask> c() {
        a(this.f42416a);
        ArrayList<? extends IDBCacheDataWrapper> g06 = this.f42416a.f42418b.g0();
        if (g06 == null) {
            return null;
        }
        ArrayList<IDownloadQueueTask> arrayList = new ArrayList<>();
        int size = g06.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.qzone.album.business.downloader.a aVar = (com.qzone.album.business.downloader.a) g06.get(i3);
            if (aVar != null && aVar.getQueueTask() != null) {
                IDownloadQueueTask queueTask = aVar.getQueueTask();
                if (!queueTask.isNullTask()) {
                    arrayList.add(aVar.getQueueTask());
                } else {
                    b(queueTask);
                    w5.b.j("[DownloadTaskCacheManager]", 1, "remove null task, id:" + queueTask.getTaskId());
                }
            }
        }
        return arrayList;
    }

    public void d(IDownloadQueueTask iDownloadQueueTask) {
        if (!iDownloadQueueTask.isNullTask()) {
            a(this.f42416a);
            this.f42416a.f42418b.o0(new com.qzone.album.business.downloader.a(iDownloadQueueTask), 1);
        } else {
            w5.b.j("[DownloadTaskCacheManager]", 1, "save null task, id:" + iDownloadQueueTask.getTaskId());
        }
    }

    public void e(IDownloadQueueTask iDownloadQueueTask) {
        a(this.f42416a);
        this.f42416a.f42418b.v0(new com.qzone.album.business.downloader.a(iDownloadQueueTask), "task_id=?", new String[]{String.valueOf(iDownloadQueueTask.getTaskId())});
    }

    private void a(a aVar) {
        DbCacheManager dbCacheManager;
        if (aVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != aVar.f42417a || (dbCacheManager = aVar.f42418b) == null || dbCacheManager.isClosed()) {
            aVar.f42417a = uin;
            DbCacheManager e16 = c.g().e(com.qzone.album.business.downloader.a.class, uin, "download_queue");
            aVar.f42418b = e16;
            e16.U(aVar.f42419c);
        }
    }
}
