package com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSLayerBaseMiddleListPart {

    /* renamed from: d, reason: collision with root package name */
    private QCirclePolymerizeDetailBean f86697d;

    /* renamed from: e, reason: collision with root package name */
    private QFSLayerPolymerizeDetailViewModel f86698e;

    public d(QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean) {
        this.f86697d = qCirclePolymerizeDetailBean;
    }

    private void M9() {
        m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList() != null) {
            for (e30.b bVar : this.mLayerPageAdapter.getDataList()) {
                if (bVar.g() != null && bVar.g().type.get() == 2) {
                    w20.a.j().t(bVar.g().f398449id.get(), 0);
                }
            }
        }
    }

    private void N9() {
        this.mLayerPageContainer.setActionDownEventListener(new QFSPageTurnContainer.g() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.b
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.g
            public final boolean a() {
                boolean P9;
                P9 = d.this.P9();
                return P9;
            }
        });
    }

    private IDataDisplaySurface<e30.b> O9() {
        QFSLayerPolymerizeDetailViewModel qFSLayerPolymerizeDetailViewModel = (QFSLayerPolymerizeDetailViewModel) getViewModel(QFSLayerPolymerizeDetailViewModel.class);
        this.f86698e = qFSLayerPolymerizeDetailViewModel;
        if (qFSLayerPolymerizeDetailViewModel == null) {
            return null;
        }
        qFSLayerPolymerizeDetailViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.Q9((UIStateData) obj);
            }
        });
        return this.f86698e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean P9() {
        broadcastMessage("layer_notify_part_action_down", null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q9(UIStateData uIStateData) {
        Z9(uIStateData);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f86697d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPolymerizeDetailListPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return O9();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.mLayerPageContainer.setRefreshEnable(false);
        this.mLayerPageContainer.setLoadMoreEnable(true);
        N9();
        E9();
        requestData(true, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        M9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        if (this.f86698e != null) {
            QLog.d(getTAG(), 1, "requestData  refresh, , attachInfo: " + this.f86698e.P1().getStringAttachInfo());
            QCirclePolymerizeDetailBean qCirclePolymerizeDetailBean = this.f86697d;
            if (qCirclePolymerizeDetailBean != null) {
                this.f86698e.s2(qCirclePolymerizeDetailBean, true, false);
            } else {
                QLog.d(getTAG(), 1, "mInitBean error. ");
            }
        }
    }
}
