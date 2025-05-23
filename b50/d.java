package b50;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qcircle.api.event.QFSShortVideoPositionEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.List;
import uq3.o;
import z20.h;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends QFSLayerBaseMiddleListPart {

    /* renamed from: d, reason: collision with root package name */
    private QCircleLayerBean f27901d;

    /* renamed from: e, reason: collision with root package name */
    private g f27902e;

    public d(QCircleLayerBean qCircleLayerBean) {
        this.f27901d = qCircleLayerBean;
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

    private IDataDisplaySurface<e30.b> O9() {
        g gVar = (g) getViewModel(g.class);
        this.f27902e = gVar;
        if (gVar == null) {
            return null;
        }
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            this.f27902e.z2(reportBean.getDtPageId());
        }
        if (getInitBean() != null && h.b()) {
            this.f27902e.s2(getInitBean());
        }
        this.f27902e.j().observe(getHostFragment(), new Observer() { // from class: b50.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.this.Q9((UIStateData) obj);
            }
        });
        I9();
        return this.f27902e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean P9() {
        broadcastMessage("layer_notify_part_action_down", null);
        return false;
    }

    private void R9(int i3) {
        if (!o.Z0()) {
            return;
        }
        g gVar = this.f27902e;
        if (gVar == null) {
            QLog.w("QCHV-QFSLayerHistoryChatListPart", 1, "[updatePositionToChatHistoryList] default view model should not be null.");
            return;
        }
        Long p26 = gVar.p2(i3);
        if (p26 == null) {
            QLog.w("QCHV-QFSLayerHistoryChatListPart", 1, "[updatePositionToChatHistoryList] seq should not be null.");
            return;
        }
        try {
            QLog.d("QCHV-QFSLayerHistoryChatListPart", 1, "[pageContainerOnPageSelected] seq: " + p26 + " | position: " + i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSShortVideoPositionEvent(p26));
        } catch (Throwable th5) {
            QLog.w("QCHV-QFSLayerHistoryChatListPart", 1, "[pageContainerOnPageSelected] ex: ", th5);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart
    protected com.tencent.biz.qqcircle.immersive.layer.base.e H9() {
        return this.f27902e;
    }

    protected void N9() {
        this.mLayerPageContainer.setActionDownEventListener(new QFSPageTurnContainer.g() { // from class: b50.b
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.g
            public final boolean a() {
                boolean P9;
                P9 = d.this.P9();
                return P9;
            }
        });
        this.mLayerPageContainer.setPreloadLoadMore(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public QCircleInitBean getInitBean() {
        return this.f27901d;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCHV-QFSLayerHistoryChatListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if (str.equals("qfs_get_feed_by_pos")) {
            if ((obj instanceof Integer) && this.f27902e != null) {
                int intValue = ((Integer) obj).intValue();
                UIStateData<List<e30.b>> value = this.f27902e.j().getValue();
                if (value != null && !RFSafeListUtils.isEmpty(value.getData())) {
                    if (intValue >= value.getData().size()) {
                        return super.getMessage(str, obj);
                    }
                    return value.getData().get(intValue);
                }
                return super.getMessage(str, obj);
            }
            return super.getMessage(str, obj);
        }
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        return O9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void handleEmptyState() {
        hideLoadingView();
        if (isEmptyContent() && this.mFaultHintView != null) {
            com.tencent.biz.qqcircle.helpers.e.f84616a.c(getInitBean(), null);
            this.mFaultHintView.z0(uq3.c.w3(), false, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void handleErrorState(UIStateData<List<e30.b>> uIStateData, long j3, String str) {
        super.handleErrorState(uIStateData, j3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    /* renamed from: handleFeedRsp, reason: merged with bridge method [inline-methods] */
    public void Q9(UIStateData<List<e30.b>> uIStateData) {
        super.Q9(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void handleSuccessState(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        super.handleSuccessState(uIStateData, z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        if (getHostFragment() != null && getHostFragment().isResumed()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
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
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void pageContainerOnPageSelected(int i3) {
        super.pageContainerOnPageSelected(i3);
        R9(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean z16, boolean z17) {
        if (this.f27902e != null && this.f27901d != null) {
            QLog.d(getTAG(), 1, "requestData  isLoadMore: " + z16 + ", enableProtocolCache: " + z17 + ", attachInfo: " + this.f27902e.P1().getStringAttachInfo());
            g gVar = this.f27902e;
            QCircleLayerBean qCircleLayerBean = this.f27901d;
            gVar.y2(qCircleLayerBean, qCircleLayerBean.isGetFeedList(), z16 ^ true);
        }
    }
}
