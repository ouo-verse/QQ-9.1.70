package com.qzone.publish.business.publishqueue;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.editdraft.QZWinkEditDraftUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f51123a;

    /* renamed from: b, reason: collision with root package name */
    private final a f51124b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        long f51125a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f51126b;

        /* renamed from: c, reason: collision with root package name */
        a.InterfaceC10828a f51127c = new C0439a();

        /* compiled from: P */
        /* renamed from: com.qzone.publish.business.publishqueue.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0439a implements a.InterfaceC10828a {
            C0439a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                a aVar2 = a.this;
                aVar2.f51125a = 0L;
                aVar2.f51126b = null;
            }
        }

        a() {
        }
    }

    public e() {
        this("publish_queue");
    }

    private int c(IQueueTask iQueueTask) {
        if (com.qzone.publish.business.publishqueue.intimate.a.c(iQueueTask)) {
            return 1;
        }
        if (com.qzone.publish.business.publishqueue.intimate.a.b(iQueueTask)) {
            return 2;
        }
        if (com.qzone.publish.business.publishqueue.intimate.a.d(iQueueTask)) {
            return 3;
        }
        com.qzone.publish.business.publishqueue.intimate.a.e(iQueueTask);
        return 0;
    }

    public ArrayList<IQueueTask> b() {
        RFWLog.i("[upload2_QzoneTaskCacheManager]", RFWLog.USR, "getAllTasks, start ");
        a(this.f51124b);
        ArrayList<? extends IDBCacheDataWrapper> g06 = this.f51124b.f51126b.g0();
        ArrayList<IQueueTask> arrayList = new ArrayList<>();
        if (g06 != null) {
            int size = g06.size();
            for (int i3 = 0; i3 < size; i3++) {
                d dVar = (d) g06.get(i3);
                if (dVar != null && dVar.getQueueTask() != null) {
                    IQueueTask queueTask = dVar.getQueueTask();
                    if (!queueTask.isNullTask()) {
                        if (queueTask.getState() != 6) {
                            queueTask.setState(2);
                        }
                        arrayList.add(dVar.getQueueTask());
                    } else {
                        d(queueTask);
                        RFWLog.w("[upload2_QzoneTaskCacheManager]", 1, "getAllTasks, remove null task, id: " + queueTask.getTaskId());
                    }
                }
            }
        }
        RFWLog.i("[upload2_QzoneTaskCacheManager]", RFWLog.USR, "getAllTasks, end, size: " + arrayList.size());
        return arrayList;
    }

    public ArrayList<IQueueTask> e(int i3) {
        ArrayList<IQueueTask> arrayList;
        RFWLog.i("[upload2_QzoneTaskCacheManager]", RFWLog.USR, "restoreTasks, businessType: " + i3);
        a(this.f51124b);
        ArrayList<? extends IDBCacheDataWrapper> g06 = this.f51124b.f51126b.g0();
        if (g06 != null) {
            arrayList = new ArrayList<>();
            int size = g06.size();
            for (int i16 = 0; i16 < size; i16++) {
                d dVar = (d) g06.get(i16);
                if (dVar != null && dVar.getQueueTask() != null) {
                    IQueueTask queueTask = dVar.getQueueTask();
                    if (!queueTask.isNullTask()) {
                        if (c(queueTask) == i3) {
                            if (com.qzone.reborn.configx.g.f53821a.j().n() && queueTask.getState() == 7) {
                                RFWLog.w("[upload2_QzoneTaskCacheManager]", RFWLog.USR, "restoreTasks, state == STATE_FINISH_REQUEST, remove, taskId = " + queueTask.getTaskId());
                                d(queueTask);
                            } else {
                                if (queueTask.getState() != 6) {
                                    queueTask.setState(2);
                                }
                                arrayList.add(queueTask);
                            }
                        }
                    } else {
                        d(queueTask);
                        w5.b.j("[upload2_QzoneTaskCacheManager]", 1, "remove null task, id:" + queueTask.getTaskId());
                    }
                }
            }
        } else {
            arrayList = null;
        }
        int i17 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("restoreTasks, size: ");
        sb5.append(arrayList != null ? arrayList.size() : 0);
        RFWLog.i("[upload2_QzoneTaskCacheManager]", i17, sb5.toString());
        return arrayList;
    }

    public void f(IQueueTask iQueueTask) {
        if (!iQueueTask.isNullTask()) {
            a(this.f51124b);
            this.f51124b.f51126b.o0(new d(iQueueTask), 1);
        } else {
            w5.b.j("[upload2_QzoneTaskCacheManager]", 1, "save null task, id:" + iQueueTask.getTaskId());
        }
    }

    public void g(IQueueTask iQueueTask) {
        a(this.f51124b);
        this.f51124b.f51126b.v0(new d(iQueueTask), "client_key=?", new String[]{iQueueTask.getCacheKey()});
    }

    public e(String str) {
        this.f51123a = "publish_queue";
        this.f51124b = new a();
        this.f51123a = str;
    }

    private void a(a aVar) {
        DbCacheManager dbCacheManager;
        if (aVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != aVar.f51125a || (dbCacheManager = aVar.f51126b) == null || dbCacheManager.isClosed()) {
            aVar.f51125a = uin;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(d.class, uin, this.f51123a);
            aVar.f51126b = e16;
            e16.U(aVar.f51127c);
        }
    }

    public void d(IQueueTask iQueueTask) {
        int i3 = 0;
        if (iQueueTask != null && !TextUtils.isEmpty(iQueueTask.getCacheKey())) {
            a(this.f51124b);
            i3 = this.f51124b.f51126b.b0("client_key=?", new String[]{iQueueTask.getCacheKey()});
        }
        if (i3 > 0) {
            QZWinkEditDraftUtil.a(iQueueTask.getEditMissionId());
        }
    }
}
