package com.qzone.reborn.feedx.fragment;

import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.base.QZoneBaseFeedxFragment;
import com.qzone.reborn.event.QZoneHolidayRefreshFeedEvent;
import com.qzone.reborn.feedx.block.QZoneLoadingStateBlock;
import com.qzone.reborn.feedx.block.n;
import com.qzone.reborn.feedx.block.p;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import gf.k;
import gf.q;
import java.util.ArrayList;
import java.util.List;
import ve.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedXMoodListFragment extends QZoneBaseFeedxFragment implements k, SimpleEventReceiver {
    protected com.qzone.reborn.feedx.part.moodlist.a C;
    protected QZoneFeedxMoodListViewModel D;
    private q E;
    private n F;
    private p G;
    private com.qzone.reborn.feedx.block.k H;
    private QZoneLoadingStateBlock I;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleHolidayRefreshEvent, reason: merged with bridge method [inline-methods] */
    public void lambda$onReceiveEvent$0(SimpleBaseEvent simpleBaseEvent) {
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel;
        RFWLog.i("QZoneFeedXMoodFragment", RFWLog.USR, "receive holiday refresh event: " + simpleBaseEvent);
        if (this.C == null || (qZoneFeedxMoodListViewModel = this.D) == null || !qZoneFeedxMoodListViewModel.D2()) {
            return;
        }
        this.C.refresh();
    }

    private void initViewModel() {
        this.D = (QZoneFeedxMoodListViewModel) getViewModel(QZoneFeedxMoodListViewModel.class);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        com.qzone.reborn.feedx.part.moodlist.a aVar = new com.qzone.reborn.feedx.part.moodlist.a(R.id.n2d, buildBlockList());
        this.C = aVar;
        arrayList.add(aVar);
        arrayList.addAll(new ve.g().c(new i().h(this.D.getMUin()).e(getMFromDtPageId()).g("shuoshuoList")));
        arrayList.add(new com.qzone.reborn.feedx.part.p());
        return arrayList;
    }

    List<MultiViewBlock> buildBlockList() {
        ArrayList arrayList = new ArrayList();
        if (this.D.D2()) {
            n nVar = new n(null);
            this.F = nVar;
            arrayList.add(nVar);
        }
        com.qzone.reborn.feedx.block.k kVar = new com.qzone.reborn.feedx.block.k(null);
        this.H = kVar;
        arrayList.add(kVar);
        QZoneLoadingStateBlock qZoneLoadingStateBlock = new QZoneLoadingStateBlock(null, getPageType());
        this.I = qZoneLoadingStateBlock;
        arrayList.add(qZoneLoadingStateBlock);
        p pVar = new p(null);
        this.G = pVar;
        arrayList.add(pVar);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.base.c getBlockPart() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ci6;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment
    /* renamed from: getDaTongPageId */
    protected String getMFromDtPageId() {
        return "pg_qz_talk_about_list";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneHolidayRefreshFeedEvent.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.viewmodel.a
    public tc.b getFeedxViewModel() {
        if (this.D == null) {
            this.D = (QZoneFeedxMoodListViewModel) getViewModel(QZoneFeedxMoodListViewModel.class);
        }
        return this.D;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment
    public com.qzone.reborn.feedx.block.b getHeaderBlock() {
        return this.F;
    }

    @Override // gf.k
    public int getPageType() {
        return 5;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.qzone.util.ap.a
    public int getReportPageId() {
        return 10;
    }

    public void initIoc() {
        n6.a aVar = new n6.a();
        this.E = aVar;
        registerIoc(aVar, q.class);
        registerIoc(this, k.class);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        if (getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getActivity().getWindow());
    }

    @Override // com.qzone.reborn.base.QZoneBaseFeedxFragment, com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneHolidayRefreshFeedEvent) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.fragment.d
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedXMoodListFragment.this.lambda$onReceiveEvent$0(simpleBaseEvent);
                }
            });
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        initViewModel();
        if (this.D != null && getActivity() != null) {
            this.D.H2(getActivity().getIntent(), bundle);
        }
        super.onViewCreated(view, bundle);
        syncLoginStatus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        QLog.d("QZoneFeedXMoodFragment", 1, "contentView.getContext: " + view.getContext());
        initIoc();
    }
}
