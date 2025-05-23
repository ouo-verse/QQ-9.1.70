package com.qzone.reborn.feedx.part.moodlist;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.feedx.block.QZoneLoadingStateBlock;
import com.qzone.reborn.feedx.block.k;
import com.qzone.reborn.feedx.block.p;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qzone.model.CoverCacheData;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends com.qzone.reborn.base.d implements IObserver.main {
    private k C;
    private QZoneLoadingStateBlock D;

    /* renamed from: e, reason: collision with root package name */
    private p f55287e;

    /* renamed from: f, reason: collision with root package name */
    private QZoneFeedxMoodListViewModel f55288f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f55289h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneFeedxRefreshView f55290i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.feedx.widget.g f55291m;

    /* compiled from: P */
    /* renamed from: com.qzone.reborn.feedx.part.moodlist.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    class C0463a implements Observer<UIStateData<List<BusinessFeedData>>> {
        C0463a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<BusinessFeedData>> uIStateData) {
            a.this.R9(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends com.qzone.reborn.feedx.viewmodel.g {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult qZoneResult) {
            super.i5(qZoneResult);
            if (a.this.D != null) {
                a.this.D.n0();
            }
            a.this.Z9();
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void p4() {
            super.p4();
            if (a.this.D == null || !a.this.f55288f.A2()) {
                return;
            }
            a.this.D.n0();
        }
    }

    public a(int i3, List<MultiViewBlock> list) {
        super(i3, list);
        for (MultiViewBlock multiViewBlock : list) {
            if (this.f55287e != null && this.C != null) {
                return;
            }
            if (multiViewBlock instanceof p) {
                this.f55287e = (p) multiViewBlock;
            } else if (multiViewBlock instanceof k) {
                this.C = (k) multiViewBlock;
            } else if (multiViewBlock instanceof QZoneLoadingStateBlock) {
                this.D = (QZoneLoadingStateBlock) multiViewBlock;
            }
        }
    }

    private int Q9(CoverCacheData coverCacheData) {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private void U9() {
        EventCenter.getInstance().addUIObserver(this, "Feed", 25);
        EventCenter.getInstance().addUIObserver(this, "Feed", 2);
    }

    private void V9() {
        this.f55288f.k2(new b());
    }

    private void W9() {
        new LpReportInfo_pf00064(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 65, 1).reportImediately();
    }

    private void X9() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        QZoneFeedxRefreshView qZoneFeedxRefreshView = new QZoneFeedxRefreshView(getContext());
        this.f55290i = qZoneFeedxRefreshView;
        this.mBlockContainer.setRefreshHeader(qZoneFeedxRefreshView);
    }

    private void Y9() {
        if (this.f55289h || getActivity() == null) {
            return;
        }
        this.f55289h = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, DisplayUtil.dip2px(MobileQQ.sMobileQQ, 8.0f), Q9(null));
        this.f55291m = gVar;
        gVar.f(false);
        this.f55291m.e(false);
        this.mBlockContainer.getRecyclerView().addItemDecoration(this.f55291m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z9() {
        if (this.C == null || this.f55288f.T1().getValue() == null) {
            return;
        }
        boolean b16 = bl.b(this.f55288f.T1().getValue().getData());
        this.C.setBlockVisible(b16);
        this.C.l0(b16, com.qzone.reborn.feedx.util.k.k(this.f55288f.B2()));
    }

    @Override // com.qzone.reborn.base.d
    protected we.b C9() {
        return this.f55287e;
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        int i3 = event.what;
        if (i3 != 2) {
            if (i3 != 25) {
                return;
            }
            broadcastMessage("SCROLL_TO_TOP", null);
        } else if ("TimerShuoShuo".equals(event.source.getName())) {
            this.f55288f.P1();
        }
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = (QZoneFeedxMoodListViewModel) getViewModel(QZoneFeedxMoodListViewModel.class);
        this.f55288f = qZoneFeedxMoodListViewModel;
        qZoneFeedxMoodListViewModel.T1().observe(getPartHost().getLifecycleOwner(), new C0463a());
        X9();
        V9();
        U9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = this.f55288f;
        if (qZoneFeedxMoodListViewModel != null) {
            qZoneFeedxMoodListViewModel.L1();
        }
        EventCenter.getInstance().removeObserver(this);
    }

    private void S9(UIStateData<List<BusinessFeedData>> uIStateData, boolean z16) {
        p pVar;
        if (uIStateData == null || uIStateData.getData() == null || !z16 || !uIStateData.getIsUpTurning() || (pVar = this.f55287e) == null || pVar.getBlockMerger() == null) {
            return;
        }
        this.f55287e.getBlockMerger().setCustomNoMoreDataView(new ImageView(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(UIStateData<List<BusinessFeedData>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        W9();
        QLog.e("QZoneFeedxMoodListBlockPart", 1, "handleFeedListRsp() state" + uIStateData.getState());
        int state = uIStateData.getState();
        if (state == 0) {
            QLog.e("QZoneFeedxMoodListBlockPart", 1, "handleFeedListRsp() return empty data");
            this.f55287e.notifyLoadingComplete(false);
            return;
        }
        if (state == 2 || state == 3) {
            this.f55287e.notifyLoadingComplete(true, uIStateData.getIsFinish());
            T9(uIStateData);
        } else {
            if (state != 4) {
                return;
            }
            QLog.e("QZoneFeedxMoodListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + uIStateData.getRetCode() + " | msg = " + uIStateData.getMsg());
            this.f55287e.notifyLoadingComplete(false);
        }
    }

    private void T9(UIStateData<List<BusinessFeedData>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        List<BusinessFeedData> data = uIStateData.getData();
        boolean isFinish = uIStateData.getIsFinish();
        if (data == null) {
            return;
        }
        if (this.C != null && !bl.b(data)) {
            this.C.setBlockVisible(false);
        }
        if (this.f55287e == null) {
            this.f55287e = new p(null);
        }
        S9(uIStateData, isFinish);
        this.f55287e.setDatas(new ArrayList(data));
        Y9();
    }
}
