package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDraftViewModel extends BaseViewModel {
    private final LiveData<List<DraftBean>> C;
    private int D = -1;

    /* renamed from: i, reason: collision with root package name */
    private final IWinkDraft f89109i;

    /* renamed from: m, reason: collision with root package name */
    private final LiveData<com.tencent.biz.qqcircle.immersive.personal.bean.k> f89110m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(int i3);
    }

    public QFSDraftViewModel() {
        IWinkDraft iWinkDraft = (IWinkDraft) QRoute.api(IWinkDraft.class);
        this.f89109i = iWinkDraft;
        LiveData<List<DraftBean>> liveDataDrafts = iWinkDraft.getLiveDataDrafts();
        this.f89110m = Transformations.map(liveDataDrafts, new Function() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.a
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                com.tencent.biz.qqcircle.immersive.personal.bean.k N1;
                N1 = QFSDraftViewModel.this.N1((List) obj);
                return N1;
            }
        });
        this.C = Transformations.map(liveDataDrafts, new Function() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.b
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                List T1;
                T1 = QFSDraftViewModel.this.T1((List) obj);
                return T1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.biz.qqcircle.immersive.personal.bean.k N1(List<DraftBean> list) {
        return null;
    }

    private List<String> S1() {
        ArrayList arrayList = new ArrayList();
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (qfsService == null) {
            QLog.w("QFSDraftViewModel", 1, "[getUploadingMissionIds] invalid service");
            return arrayList;
        }
        List<TaskInfo> runningTasks = qfsService.getRunningTasks();
        if (runningTasks.isEmpty()) {
            QLog.d("QFSDraftViewModel", 1, "[getUploadingMissionIds] empty list");
            return arrayList;
        }
        Iterator<TaskInfo> it = runningTasks.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getMissionId());
        }
        QLog.d("QFSDraftViewModel", 1, "[getUploadingMissionIds] uploadingMissionIds: ", arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DraftBean> T1(List<DraftBean> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            List<String> S1 = S1();
            if (S1.isEmpty()) {
                arrayList.addAll(list);
            } else {
                for (DraftBean draftBean : list) {
                    if (!S1.contains(draftBean.getMissionId())) {
                        arrayList.add(draftBean);
                    }
                }
            }
            QLog.d("QFSDraftViewModel", 1, "getValidDraftList, validDraftList.size: " + arrayList.size());
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    private List<String> U1(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            List<String> S1 = S1();
            if (S1.isEmpty()) {
                arrayList.addAll(list);
            } else {
                for (String str : list) {
                    if (!S1.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    private void W1(int i3) {
        this.D = i3;
    }

    public LiveData<List<DraftBean>> O1() {
        return this.C;
    }

    public void P1(final a aVar) {
        if (this.D != -1) {
            QLog.d("QFSDraftViewModel", 1, "getDraftCount, hit cache: " + this.D);
            if (aVar != null) {
                aVar.a(this.D);
                return;
            }
            return;
        }
        QLog.d("QFSDraftViewModel", 1, "getDraftCount, start");
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSDraftViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QFSDraftViewModel", 1, "getDraftCount, start2");
                final int Q1 = QFSDraftViewModel.this.Q1();
                QLog.d("QFSDraftViewModel", 1, "getDraftCount, refresh data: " + Q1);
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSDraftViewModel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(Q1);
                        }
                    }
                });
            }
        });
    }

    @WorkerThread
    public int Q1() {
        int i3;
        try {
            i3 = U1(this.f89109i.getAllDraftMissionIdsSync()).size();
        } catch (Exception e16) {
            QLog.e("QFSDraftViewModel", 1, "getDraftCountBlock, getAllDraftMissionIdsSync error ", e16);
            i3 = 0;
        }
        W1(i3);
        return i3;
    }

    public LiveData<com.tencent.biz.qqcircle.immersive.personal.bean.k> R1() {
        return this.f89110m;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSDraftViewModel";
    }
}
