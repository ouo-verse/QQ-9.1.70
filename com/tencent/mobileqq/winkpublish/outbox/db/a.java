package com.tencent.mobileqq.winkpublish.outbox.db;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.room.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.outbox.db.gson.BundleTypeAdapterFactory;
import com.tencent.mobileqq.winkpublish.outbox.db.gson.DeclarationParamsAdapter;
import com.tencent.mobileqq.winkpublish.outbox.db.gson.MediaParamsTypeAdapterFactory;
import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    WinkPublishDataBase f327235a;

    /* renamed from: b, reason: collision with root package name */
    private b f327236b;

    /* renamed from: c, reason: collision with root package name */
    private Gson f327237c;

    /* renamed from: d, reason: collision with root package name */
    private final LongSparseArray<BaseTask> f327238d = new LongSparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.db.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9093a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f327239a = new a();
    }

    a() {
        try {
            WinkPublishDataBase winkPublishDataBase = (WinkPublishDataBase) Room.databaseBuilder(RFWApplication.getApplication(), WinkPublishDataBase.class, "wink_publish_data_base").fallbackToDestructiveMigration().build();
            this.f327235a = winkPublishDataBase;
            this.f327236b = winkPublishDataBase.c();
            this.f327237c = new GsonBuilder().registerTypeAdapterFactory(new MediaParamsTypeAdapterFactory()).registerTypeAdapterFactory(new BundleTypeAdapterFactory()).registerTypeAdapter(DeclarationParams.class, new DeclarationParamsAdapter()).create();
        } catch (Throwable th5) {
            QLog.e("WinkPublish-upload2-TaskRepository", 1, "TaskRepository ", th5);
        }
    }

    public static a c() {
        return C9093a.f327239a;
    }

    private BaseTask d(d dVar) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("WinkPublish-upload2-TaskRepository", 2, "[record2Task] taskId=" + dVar.f327248b + ", json=" + dVar.f327249c);
            }
            if (TextUtils.isEmpty(dVar.f327249c)) {
                return null;
            }
            return new BaseTask(TaskContext.INSTANCE.b((WinkPublishParams) this.f327237c.fromJson(dVar.f327249c, WinkPublishParams.class), Long.valueOf(dVar.f327248b)));
        } catch (Throwable th5) {
            QLog.w("WinkPublish-upload2-TaskRepository", 1, "[record2Task] ", th5);
            return null;
        }
    }

    public void a(BaseTask baseTask) {
        QLog.i("WinkPublish-upload2-TaskRepository", 1, "[deleteTask] id=" + baseTask.u());
        b bVar = this.f327236b;
        if (bVar == null) {
            QLog.w("WinkPublish-upload2-TaskRepository", 1, "[deleteTask] invalid dao");
            return;
        }
        try {
            bVar.delete(baseTask.u());
            this.f327238d.remove(baseTask.u());
        } catch (Throwable th5) {
            QLog.w("WinkPublish-upload2-TaskRepository", 1, "[deleteTask] ", th5);
        }
    }

    public List<BaseTask> b() {
        ArrayList arrayList = new ArrayList();
        if (this.f327238d.size() > 0) {
            for (int i3 = 0; i3 < this.f327238d.size(); i3++) {
                arrayList.add(this.f327238d.valueAt(i3));
            }
            QLog.i("WinkPublish-upload2-TaskRepository", 1, "[getAllTask] from cache, size=" + arrayList.size());
            return arrayList;
        }
        b bVar = this.f327236b;
        if (bVar != null && this.f327237c != null) {
            try {
                Iterator<d> it = bVar.getAll().iterator();
                while (it.hasNext()) {
                    BaseTask d16 = d(it.next());
                    if (d16 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("WinkPublish-upload2-TaskRepository", 2, "[getAllTask] publishParams=" + d16.getTaskContext().getPublishParams());
                        }
                        arrayList.add(d16);
                        this.f327238d.put(d16.u(), d16);
                    }
                }
            } catch (Throwable th5) {
                QLog.w("WinkPublish-upload2-TaskRepository", 1, "[getAllTask] ", th5);
            }
            QLog.i("WinkPublish-upload2-TaskRepository", 1, "[getAllTask] from db, size=" + arrayList.size());
            return arrayList;
        }
        QLog.w("WinkPublish-upload2-TaskRepository", 1, "[getAllTask] invalid dao");
        return arrayList;
    }

    public void e(BaseTask baseTask) {
        WinkPublishParams winkPublishParams;
        QLog.i("WinkPublish-upload2-TaskRepository", 1, "[saveTask] id=" + baseTask.u() + ", clientKey=" + baseTask.getTaskContext().c());
        if (this.f327236b != null && this.f327237c != null) {
            try {
                if (this.f327238d.indexOfKey(baseTask.u()) >= 0) {
                    a(baseTask);
                }
                Bundle transParams = baseTask.getTaskContext().getPublishParams().getTransParams();
                if (transParams != null) {
                    winkPublishParams = (WinkPublishParams) transParams.get("qcircle_wink_task_launch_params");
                    transParams.remove("qcircle_wink_task_launch_params");
                } else {
                    winkPublishParams = null;
                }
                String json = this.f327237c.toJson(baseTask.getTaskContext().getPublishParams());
                if (QLog.isColorLevel()) {
                    QLog.d("WinkPublish-upload2-TaskRepository", 1, "[saveTask] " + json);
                }
                if (transParams != null && winkPublishParams != null) {
                    transParams.putParcelable("qcircle_wink_task_launch_params", winkPublishParams);
                }
                d dVar = new d();
                dVar.f327249c = json;
                dVar.f327248b = baseTask.u();
                this.f327236b.a(dVar);
                this.f327238d.put(baseTask.u(), baseTask);
                return;
            } catch (Throwable th5) {
                QLog.w("WinkPublish-upload2-TaskRepository", 1, "[saveTask] ", th5);
                return;
            }
        }
        QLog.w("WinkPublish-upload2-TaskRepository", 1, "[saveTask] invalid dao");
    }
}
