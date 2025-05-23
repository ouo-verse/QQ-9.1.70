package com.tencent.biz.qqcircle.immersive.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.events.QFSForceTabRefreshEvent;
import com.tencent.biz.qqcircle.events.QFSFullScreenSelectedFeedEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSLayerTabPart;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.c;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.g;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p40.n;
import p40.u;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSFolderLayerTabFragment extends QFSFolderTabFragment {
    protected QFSLayerTabPart R;
    protected t40.b S;
    private QCircleInitBean T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            n.e().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QFSFolderLayerTabFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
    }

    private void initIntentData() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return;
        }
        if (intent.hasExtra("key_bundle_common_init_bean")) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (serializableExtra instanceof QCircleInitBean) {
                this.T = (QCircleInitBean) serializableExtra;
                return;
            } else {
                QLog.d(getTAG(), 1, "intent without launch bean. ");
                return;
            }
        }
        QLog.d("QFSFolderTabFragment", 1, "[initIntentData] KEY_BUNDLE_COMMON_INIT_BEAN is null");
    }

    private boolean pi() {
        if (!g.c()) {
            QLog.d(getTAG(), 1, "canUseRedPointScreen enablePageResumeRedPointFeedInsert is false");
            return false;
        }
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart == null) {
            return false;
        }
        return qFSLayerTabPart.O9();
    }

    private void qi() {
        if (!Mh()) {
            return;
        }
        if (Oh()) {
            QLog.d("QFSFolderTabFragment", 1, "dealWithFeedPrePull isFirstShow fragment");
            return;
        }
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart != null) {
            qFSLayerTabPart.Ba();
        }
    }

    private void si(QFSFullScreenSelectedFeedEvent qFSFullScreenSelectedFeedEvent) {
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart == null) {
            return;
        }
        qFSLayerTabPart.setContainerOnPageSelected(qFSFullScreenSelectedFeedEvent.getSelectedData());
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void Gh() {
        ei(1);
        QCircleToast.h(R.string.f19048428, 2000);
        xh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void Xh() {
        super.Xh();
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart != null) {
            qFSLayerTabPart.Aa();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void ai() {
        QLog.d(getTAG(), 1, "refreshData");
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart != null) {
            qFSLayerTabPart.requestData(false, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @CallSuper
    public List<Part> assembleParts() {
        initIntentData();
        QCircleInitBean qCircleInitBean = this.T;
        if (qCircleInitBean == null) {
            QLog.d("QFSFolderTabFragment", 1, "[assembleParts] mInitBean is null");
            return new ArrayList();
        }
        qCircleInitBean.setLayerBizAssemblerType("biz_tab");
        com.tencent.biz.qqcircle.immersive.layer.base.b a16 = n50.a.a(this.T);
        if (!(a16 instanceof com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.c)) {
            QLog.d("QFSFolderTabFragment", 1, "[assembleParts] assembler is " + a16);
            return new ArrayList();
        }
        List<Part> p16 = a16.p(new c.a().h(this.E).g(Oh()).d(this.T));
        Iterator<Part> it = p16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Part next = it.next();
            if (next instanceof QFSLayerTabPart) {
                this.R = (QFSLayerTabPart) next;
                break;
            }
        }
        return p16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void ci() {
        QLog.d(getTAG(), 1, "requestSilenceInsertFeeds");
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart != null) {
            qFSLayerTabPart.Ha();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void di() {
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart != null) {
            qFSLayerTabPart.switchToContentState();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void fi() {
        gi(0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QCircleFrameEvent.class);
        eventClass.add(QFSFullScreenSelectedFeedEvent.class);
        eventClass.add(QFSForceTabRefreshEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        String str;
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo != null && (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) != null) {
            str = qQCircleFeedBase$StTabInfo.dtPgID.get();
        } else {
            str = "";
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void gi(final int i3) {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.tab.QFSFolderLayerTabFragment.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(QFSFolderLayerTabFragment.this.getTAG(), 1, "scrollToTopAndRefresh");
                try {
                    t40.b bVar = QFSFolderLayerTabFragment.this.S;
                    if (bVar != null) {
                        bVar.onHandlerMessage("event_hide_comment", new Object[0]);
                    }
                    QFSLayerTabPart qFSLayerTabPart = QFSFolderLayerTabFragment.this.R;
                    if (qFSLayerTabPart != null) {
                        qFSLayerTabPart.Fa(i3);
                    }
                } catch (Exception e16) {
                    QLog.d(QFSFolderLayerTabFragment.this.getTAG(), 1, "scrollToTopAndRefresh exception:" + e16.toString());
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart != null) {
            qFSLayerTabPart.ha();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void oi() {
        QFSLayerTabPart qFSLayerTabPart;
        super.oi();
        if (g.c() && (qFSLayerTabPart = this.R) != null) {
            qFSLayerTabPart.Pa();
        }
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        u.H().P0(getPageId());
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        u.H().Q0(getPageId());
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QFSTabFeedViewModel qFSTabFeedViewModel = (QFSTabFeedViewModel) getViewModel(QFSTabFeedViewModel.class);
        if (qFSTabFeedViewModel != null) {
            qFSTabFeedViewModel.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFullScreenSelectedFeedEvent) {
            si((QFSFullScreenSelectedFeedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSForceTabRefreshEvent) {
            gi(1);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Oh()) {
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_FOLDER_PAGE_EXPOSE);
        }
        QFSTabFeedViewModel qFSTabFeedViewModel = (QFSTabFeedViewModel) getViewModel(QFSTabFeedViewModel.class);
        if (qFSTabFeedViewModel != null) {
            qFSTabFeedViewModel.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.R.getLayerPageContainer().B().registerOnPageChangeCallback(new a());
        qi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        this.S = (t40.b) getIocInterface(t40.b.class);
    }

    public QFSLayerTabPart ri() {
        return this.R;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void scrollToTop() {
        QLog.d(getTAG(), 1, "scrollToTop");
        try {
            this.R.getLayerPageContainer().B().setCurrentItem(0);
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "scrollToTop exception:" + e16.toString());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void sh() {
        QFSLayerTabPart qFSLayerTabPart = this.R;
        if (qFSLayerTabPart != null) {
            qFSLayerTabPart.switchToEmptyState();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void vh() {
        super.vh();
        if (pi()) {
            QLog.d(getTAG(), 1, "doRedPointRefreshLogic");
            try {
                t40.b bVar = this.S;
                if (bVar != null) {
                    bVar.onHandlerMessage("event_hide_comment", new Object[0]);
                }
                QFSLayerTabPart qFSLayerTabPart = this.R;
                if (qFSLayerTabPart != null) {
                    qFSLayerTabPart.Na();
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.d(getTAG(), 1, "doRedPointRefreshLogic exception:" + e16.toString());
                return;
            }
        }
        QLog.d(getTAG(), 1, "doRedPointRefreshLogic use scrollToTopAndRefresh");
        fi();
    }
}
