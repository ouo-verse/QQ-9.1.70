package com.tencent.biz.qqcircle.immersive.layer.base;

import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSLayerBaseViewModel extends com.tencent.biz.qqcircle.viewmodels.a implements IQCircleReportSessionOperation, SimpleEventReceiver, IDataDisplaySurface<e30.b> {

    /* renamed from: m, reason: collision with root package name */
    protected final LoadInfo f86506m = new LoadInfo();
    protected final List<e30.b> C = new ArrayList();
    protected final MutableLiveData<UIStateData<List<e30.b>>> D = new MutableLiveData<>();

    public QFSLayerBaseViewModel() {
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f92839i = QCircleReporterAgent.obtain(57);
    }

    private void Q1(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent == null) {
            return;
        }
        int i3 = qCircleFeedEvent.mState;
        if (i3 == 3) {
            M1(qCircleFeedEvent);
            return;
        }
        if (i3 == 6) {
            N1(qCircleFeedEvent);
        } else if (i3 == 8 && !TextUtils.isEmpty(qCircleFeedEvent.mTargetId)) {
            L1();
        }
    }

    protected void L1() {
        if (this.C.size() == 0) {
            return;
        }
        Iterator<e30.b> it = this.C.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            e30.b next = it.next();
            if (next != null && next.g().feedType.get() == 4) {
                it.remove();
                z16 = true;
            }
        }
        if (z16) {
            R1(UIStateData.obtainDelete().setDataList(this.C).setFinish(this.f86506m.isFinish()));
        }
        QLog.d(getTAG(), 1, "deleteAdFeed removeFeed end result: ", Boolean.valueOf(z16), ",size = ", Integer.valueOf(this.C.size()));
    }

    protected void M1(QCircleFeedEvent qCircleFeedEvent) {
        List<e30.b> list;
        boolean z16;
        String str = qCircleFeedEvent.mTargetId;
        if (!TextUtils.isEmpty(str) && (list = this.C) != null && list.size() != 0) {
            Iterator<e30.b> it = this.C.iterator();
            while (true) {
                if (it.hasNext()) {
                    e30.b next = it.next();
                    if (next != null && TextUtils.equals(str, next.g().f398449id.get())) {
                        it.remove();
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                R1(UIStateData.obtainDelete().setDataList(this.C).setFinish(this.f86506m.isFinish()));
            }
            QLog.d(getTAG(), 1, "deleteFeedById removeFeed result: ", Boolean.valueOf(z16), ",size = ", Integer.valueOf(this.C.size()));
        }
    }

    protected void N1(QCircleFeedEvent qCircleFeedEvent) {
        List<e30.b> list;
        String str = qCircleFeedEvent.mTargetId;
        if (!TextUtils.isEmpty(str) && (list = this.C) != null && list.size() != 0) {
            Iterator<e30.b> it = this.C.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                e30.b next = it.next();
                if (next != null && TextUtils.equals(str, next.g().poster.f398463id.get())) {
                    it.remove();
                    z16 = true;
                }
            }
            if (z16) {
                R1(UIStateData.obtainDelete().setData(false, this.C).setFinish(this.f86506m.isFinish()));
            }
            QLog.d(getTAG(), 1, "deleteFeedsByUid removeFeed result: ", Boolean.valueOf(z16), ",size = ", Integer.valueOf(this.C.size()));
        }
    }

    public List<e30.b> O1() {
        return this.C;
    }

    public LoadInfo P1() {
        return this.f86506m;
    }

    public void R1(final UIStateData<List<e30.b>> uIStateData) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            j().setValue(uIStateData);
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSLayerBaseViewModel.this.j().setValue(uIStateData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S1(boolean z16, BaseRequest baseRequest, long j3, String str, String str2) {
        QLog.d("QFSLayerBaseViewModel", 1, str2 + " onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isLoadMore: true");
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.D;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerBaseViewModel";
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    public MutableLiveData<UIStateData<List<e30.b>>> j() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFeedEvent) {
            Q1((QCircleFeedEvent) simpleBaseEvent);
        }
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
    }
}
