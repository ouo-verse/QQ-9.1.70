package com.tencent.biz.qqcircle.immersive.layer.biz.outside.search;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
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
    private QCircleLayerBean f87165d;

    /* renamed from: e, reason: collision with root package name */
    private QFSLayerSearchViewModel f87166e;

    public d(QCircleLayerBean qCircleLayerBean) {
        this.f87165d = qCircleLayerBean;
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
        this.mLayerPageContainer.setActionDownEventListener(new QFSPageTurnContainer.g() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.search.c
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.g
            public final boolean a() {
                boolean P9;
                P9 = d.this.P9();
                return P9;
            }
        });
    }

    private IDataDisplaySurface<e30.b> O9() {
        QFSLayerSearchViewModel qFSLayerSearchViewModel = (QFSLayerSearchViewModel) getViewModel(QFSLayerSearchViewModel.class);
        this.f87166e = qFSLayerSearchViewModel;
        if (qFSLayerSearchViewModel == null) {
            return null;
        }
        qFSLayerSearchViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.search.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.Q9((UIStateData) obj);
            }
        });
        I9();
        return this.f87166e;
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

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart
    protected com.tencent.biz.qqcircle.immersive.layer.base.e H9() {
        return this.f87166e;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f87165d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerSearchListPart";
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
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        M9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        if (this.f87166e != null) {
            QLog.d(getTAG(), 1, "requestData  refresh, , attachInfo: " + this.f87166e.P1().getStringAttachInfo());
            this.f87166e.q2(this.f87165d.getSchemeAttrs().get(QCircleSchemeAttr.Detail.KEY_WORD));
        }
    }
}
