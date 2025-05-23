package com.tencent.biz.qqcircle.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k30.e;
import qqcircle.QQCircleFeedBase$StPageRedPointInfo;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class QCircleAbsTabFeedViewModel extends a implements IQCircleReportSessionOperation, IDataDisplaySurface<e30.b>, Call.OnRspCallBack, k30.a {
    protected QCircleTabInfo E;

    /* renamed from: m, reason: collision with root package name */
    protected final MutableLiveData<UIStateData<List<e30.b>>> f92794m = new MutableLiveData<>();
    protected volatile List<e30.b> C = new ArrayList();
    protected final MutableLiveData<e30.b> D = new MutableLiveData<>();
    protected QQCircleFeedBase$StPageRedPointInfo F = null;
    protected String G = null;
    protected String H = null;
    protected boolean I = false;
    protected FeedCloudCommon$StCommonExt J = null;

    @Override // k30.a
    public String E1() {
        return this.G;
    }

    @Override // k30.a
    public QQCircleFeedBase$StTabInfo G() {
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo != null) {
            return qCircleTabInfo.mTab;
        }
        return null;
    }

    protected void L1(List<e30.b> list, boolean z16) {
        if (z16) {
            return;
        }
        if (list.size() > 0) {
            e30.b bVar = list.get(0);
            if (bVar.g().dittoFeed.dittoId.get() == 10) {
                N1(bVar);
                return;
            } else {
                N1(null);
                return;
            }
        }
        N1(null);
    }

    @Override // k30.a
    public boolean M(@NonNull e.a aVar) {
        QLog.d(getTAG(), 1, "sendRspByCache feed size:" + aVar.f().size() + " | isFinish:" + this.I + " | feedAttachInfo:" + o0());
        if (aVar.f().size() <= 0) {
            return false;
        }
        updateSession(this.J);
        L1(aVar.f(), false);
        M1(UIStateData.obtainResumeCache(aVar.h(), aVar.k()).setData(false, aVar.f()).setFinish(this.I));
        return true;
    }

    protected void M1(final UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData.getData() != null && this.C != uIStateData.getData()) {
            this.C.clear();
            this.C.addAll(uIStateData.getData());
            uIStateData.setDataList(this.C);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleAbsTabFeedViewModel.this.f92794m.setValue(uIStateData);
            }
        });
    }

    protected void N1(final e30.b bVar) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                QCircleAbsTabFeedViewModel.this.D.setValue(bVar);
            }
        });
    }

    protected void O1(String str, String str2, boolean z16, boolean z17, int i3, QCircleFolderBean qCircleFolderBean) {
        if (this.E == null) {
            QLog.e(getTAG(), 1, "requestData() tabInfo is null!");
            return;
        }
        if (!z16) {
            M1(UIStateData.obtainLoading());
        }
        com.tencent.a.e("requestFeedsData" + i3);
        P1(str, str2, z16, z17, i3, qCircleFolderBean);
    }

    protected abstract void P1(String str, String str2, boolean z16, boolean z17, int i3, QCircleFolderBean qCircleFolderBean);

    @Override // k30.a
    public void Q0(@NonNull e.a aVar) {
        this.C.clear();
        this.C.addAll(aVar.f());
        this.I = aVar.g();
        this.J = aVar.d();
        this.H = aVar.e();
        this.G = aVar.i();
    }

    @Override // k30.a
    public boolean U() {
        return this.I;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        return this.f92794m;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        if (G() == null) {
            return 0;
        }
        return G().tabType.get();
    }

    @Override // k30.a
    public FeedCloudCommon$StCommonExt getExtInfo() {
        return this.J;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public abstract String getTAG();

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public FeedCloudCommon$StCommonExt getSession(boolean z16) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            return qCircleReporterAgent.getSessionCommonExt(z16);
        }
        return new FeedCloudCommon$StCommonExt();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        if (getDisplaySurfaceData(new Object[0]).getValue() != null && getDisplaySurfaceData(new Object[0]).getValue().getState() != 1) {
            getDisplaySurfaceData(new Object[0]).getValue().setState(1);
            n(0);
        }
    }

    public void n(int i3) {
        O1(this.H, this.G, true, false, i3, null);
    }

    @Override // k30.a
    public String o0() {
        return this.H;
    }

    @Override // k30.a
    public Collection<e30.b> s1() {
        return this.C;
    }

    @Override // cooperation.qqcircle.report.IQCircleReportSessionOperation
    public void updateSession(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QCircleReporterAgent qCircleReporterAgent = this.f92839i;
        if (qCircleReporterAgent != null) {
            qCircleReporterAgent.updateSubSession(feedCloudCommon$StCommonExt);
        }
    }
}
