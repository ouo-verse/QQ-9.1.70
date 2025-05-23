package com.tencent.biz.qqcircle.immersive.tab.mixfeed;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.immersive.events.QFSChangePgidEvent;
import com.tencent.biz.qqcircle.immersive.part.mixfeed.QFSMixFeedListPart;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSPublishBannerPart;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.lazyload.QFSNotifyLazyLoadEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import e40.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleDitto$StPicTextBanner;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedSubFragment extends QFSFolderTabFragment {
    private static final HashMap<String, Boolean> V = new HashMap<>();
    private static final int W = c.P3();
    protected QFSMixFeedListPart R;
    protected QFSMixFeedViewModel S;
    private v60.a T;
    private QFSPublishBannerPart U;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            QQCircleDitto$StPicTextBanner k26;
            super.onScrollStateChanged(recyclerView, i3);
            if (!QFSMixFeedSubFragment.this.vi() && recyclerView.computeVerticalScrollOffset() > cx.f() * QFSMixFeedSubFragment.W && (k26 = QFSMixFeedSubFragment.this.S.k2()) != null) {
                QLog.d(QFSMixFeedSubFragment.this.getTAG(), 2, "show publish banner");
                QFSMixFeedSubFragment.this.wi();
                QFSMixFeedSubFragment.this.U.J9(new s().d(k26));
                QFSMixFeedSubFragment.this.U.M9();
            }
        }
    }

    public QFSMixFeedSubFragment(QCircleTabInfo qCircleTabInfo, int i3) {
        super(qCircleTabInfo, i3);
    }

    private void initViewModel() {
        QFSMixFeedViewModel qFSMixFeedViewModel = (QFSMixFeedViewModel) getViewModel(QFSMixFeedViewModel.class);
        this.S = qFSMixFeedViewModel;
        qFSMixFeedViewModel.B2(this.E, this.F);
        w20.a.j().registerDisplaySurface(QCirclePluginUtil.getSubTabViewModelKey(this.E, this.F), this.S);
    }

    private void ti() {
        QFSMixFeedListPart qFSMixFeedListPart = this.R;
        if (qFSMixFeedListPart != null && qFSMixFeedListPart.getBlockContainer() != null && this.R.getBlockContainer().getRecyclerView() != null) {
            this.R.getBlockContainer().getRecyclerView().addOnScrollListener(new a());
        }
    }

    private QQCircleFeedBase$StSubTabInfo ui() {
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo != null) {
            int size = qCircleTabInfo.mTab.subTabInfo.size();
            int i3 = this.F;
            if (size > i3) {
                return this.E.mTab.subTabInfo.get(i3);
            }
        }
        return new QQCircleFeedBase$StSubTabInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vi() {
        String q16 = r.q();
        Boolean bool = V.get(q16);
        if (QLog.isColorLevel()) {
            QLog.d("QFSMixFeedFragment", 1, "hasShowGuideBanner, account: " + q16 + ", hasShow: " + bool);
        }
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi() {
        V.put(r.q(), Boolean.TRUE);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public int Ch() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void Hh(QFSNotifyLazyLoadEvent qFSNotifyLazyLoadEvent) {
        if (qFSNotifyLazyLoadEvent.getNotifyId() != Ch() || isLazyLoad()) {
            return;
        }
        makeSureInit(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Oh() {
        QCircleTabInfo qCircleTabInfo = this.E;
        if (qCircleTabInfo == null || qCircleTabInfo.mTab.subTabInfo.size() <= this.F || this.E.mTab.defaultSubTabindex.get() != this.F) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Th() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public boolean Wh() {
        return false;
    }

    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        QFSMixFeedListPart qFSMixFeedListPart = new QFSMixFeedListPart(Eh(), R.id.f47071wa, this.F);
        this.R = qFSMixFeedListPart;
        arrayList.add(qFSMixFeedListPart);
        QFSPublishBannerPart qFSPublishBannerPart = new QFSPublishBannerPart(2);
        this.U = qFSPublishBannerPart;
        arrayList.add(qFSPublishBannerPart);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gjc;
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        String str = ui().dtPgID.get();
        QLog.d(getTAG(), 4, "getDTPageId:" + str);
        return str;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMixFeedFragment" + this.F + this.E.getName();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return ui().pageId.get();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.ILazyLoader
    public boolean isLazyLoad() {
        if (!c.U4() || this.T == null || Oh()) {
            return false;
        }
        return !this.T.vd();
    }

    @Override // com.tencent.biz.richframework.part.ILazyLoader
    public void load() {
        QFSMixFeedListPart qFSMixFeedListPart = this.R;
        if (qFSMixFeedListPart != null) {
            qFSMixFeedListPart.M9();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        initViewModel();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QFSMixFeedViewModel qFSMixFeedViewModel = this.S;
        if (qFSMixFeedViewModel != null) {
            qFSMixFeedViewModel.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QFSVideoView.D = null;
        f.v().d0();
        SimpleEventBus.getInstance().dispatchEvent(new QFSChangePgidEvent(getDaTongPageId()));
        QFSMixFeedViewModel qFSMixFeedViewModel = this.S;
        if (qFSMixFeedViewModel != null) {
            qFSMixFeedViewModel.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        this.T = (v60.a) getIocInterface(v60.a.class);
        ti();
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void di() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void fi() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void scrollToTop() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment
    public void sh() {
    }
}
