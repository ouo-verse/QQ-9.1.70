package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class m extends com.qzone.reborn.base.d {
    private com.qzone.reborn.feedx.viewmodel.w C;
    private com.qzone.reborn.feedx.viewmodel.t D;
    private boolean E;
    private com.qzone.reborn.feedx.widget.g F;
    private x6.a G;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.ab f55272e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.d f55273f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.f f55274h;

    /* renamed from: i, reason: collision with root package name */
    private QZoneFeedxRefreshView f55275i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.k f55276m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.s {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void a(List<? extends BusinessFeedData> list, int i3) {
            m.this.G9(i3, true, m.this.f55272e != null ? m.this.f55272e.p0() : 0);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void b(List<? extends BusinessFeedData> list) {
            m.this.F9(0, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b extends com.qzone.reborn.feedx.viewmodel.g {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult qZoneResult) {
            if (qZoneResult.getSucceed() || m.this.f55274h == null) {
                return;
            }
            m.this.f55274h.notifyLoadingComplete(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements QZoneFeedxRefreshView.b {
        c() {
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public boolean a(float f16, float f17) {
            return ((com.qzone.reborn.feedx.viewmodel.r) m.this.getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)).O1(f16, f17);
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public void onRelease() {
            ((com.qzone.reborn.feedx.viewmodel.r) m.this.getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)).P1();
        }
    }

    public m(int i3, List<MultiViewBlock> list) {
        super(i3, list);
        for (MultiViewBlock multiViewBlock : list) {
            if (this.f55274h != null && this.f55276m != null) {
                return;
            }
            if (multiViewBlock instanceof com.qzone.reborn.feedx.block.f) {
                this.f55274h = (com.qzone.reborn.feedx.block.f) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.k) {
                this.f55276m = (com.qzone.reborn.feedx.block.k) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.d) {
                this.f55273f = (com.qzone.reborn.feedx.block.d) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.ab) {
                this.f55272e = (com.qzone.reborn.feedx.block.ab) multiViewBlock;
            }
        }
    }

    private int S9() {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private void W9(boolean z16) {
        com.qzone.reborn.feedx.block.k kVar = this.f55276m;
        if (kVar == null || kVar.x0()) {
            return;
        }
        if (this.C.getMIsTimeLineClick() && z16) {
            QLog.d("QZoneFamousUserHomeListBlockPart", 1, "time line click and data is empty");
        } else {
            this.f55276m.l0(z16, com.qzone.reborn.feedx.util.k.t(this.C.M2()));
            this.f55276m.setBlockVisible(z16);
        }
    }

    private void Y9(int i3, Intent intent) {
        com.qzone.reborn.feedx.viewmodel.t tVar = this.D;
        if (tVar == null) {
            return;
        }
        tVar.A2(i3, intent);
    }

    private void Z9() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        QZoneFeedxRefreshView qZoneFeedxRefreshView = new QZoneFeedxRefreshView(getContext());
        this.f55275i = qZoneFeedxRefreshView;
        this.mBlockContainer.setRefreshHeader(qZoneFeedxRefreshView);
        getBlockContainer().getBlockMerger().j0(QZoneConfigHelper.m0());
    }

    private void aa() {
        if (this.E || getActivity() == null) {
            return;
        }
        this.E = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, DisplayUtil.dip2px(MobileQQ.sMobileQQ, 8.0f), S9());
        this.F = gVar;
        gVar.f(false);
        this.mBlockContainer.getRecyclerView().addItemDecoration(this.F);
    }

    private void ba() {
        R9(new c());
    }

    @Override // com.qzone.reborn.base.d
    protected we.b C9() {
        return this.f55274h;
    }

    @Override // com.qzone.reborn.base.d
    public void K9() {
        if (this.C.getMIsTimeLineClick()) {
            return;
        }
        super.K9();
    }

    public void R9(QZoneFeedxRefreshView.b bVar) {
        this.f55275i.a(bVar);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFamousUserHomeListBlockPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 14) {
            Y9(i16, intent);
        }
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.D = (com.qzone.reborn.feedx.viewmodel.t) getViewModel(com.qzone.reborn.feedx.viewmodel.t.class);
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.C = wVar;
        wVar.T1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.this.U9((UIStateData) obj);
            }
        });
        this.C.B2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.this.ca(((Integer) obj).intValue());
            }
        });
        this.C.C2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m.this.T9((x6.a) obj);
            }
        });
        Z9();
        ba();
        this.C.f3(new a());
        this.C.k2(new b());
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        getActivity().getWindow().setSoftInputMode(32);
    }

    private void V9(UIStateData<List<BusinessFeedData>> uIStateData, boolean z16) {
        com.qzone.reborn.feedx.block.f fVar;
        if (uIStateData == null || uIStateData.getData() == null || !z16 || !uIStateData.getIsUpTurning() || (fVar = this.f55274h) == null || fVar.getBlockMerger() == null) {
            return;
        }
        this.f55274h.getBlockMerger().setCustomNoMoreDataView(new ImageView(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9(x6.a aVar) {
        Object valueOf;
        if (aVar == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("get usr info data view model hashCode is ");
        com.qzone.reborn.feedx.viewmodel.w wVar = this.C;
        if (wVar == null) {
            valueOf = "0";
        } else {
            valueOf = Integer.valueOf(wVar.hashCode());
        }
        sb5.append(valueOf);
        QLog.d("QZoneFamousUserHomeListBlockPart", 1, sb5.toString());
        this.G = aVar;
        new LpReportInfo_pf00064(308, 71, aVar.uin).reportImediately();
        broadcastMessage("user_home_business_info", aVar);
        QLog.i("QZoneFamousUserHomeListBlockPart", 1, "host uin is " + aVar.uin + ", guest uin is " + LoginData.getInstance().getUin() + ", relationship is " + aVar.relationShip);
        this.f55276m.v0(this.C, this.D);
        this.f55276m.m0(aVar);
        if (this.f55276m.x0()) {
            this.f55276m.setBlockVisible(true);
        } else {
            if (this.f55276m.w0()) {
                return;
            }
            this.f55276m.setBlockVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9(UIStateData<List<BusinessFeedData>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        QLog.e("QZoneFamousUserHomeListBlockPart", 1, "handleFeedListRsp() state" + uIStateData.getState());
        int state = uIStateData.getState();
        if (state == 0) {
            QLog.e("QZoneFamousUserHomeListBlockPart", 1, "handleFeedListRsp() return empty data");
            this.f55274h.notifyLoadingComplete(false);
            return;
        }
        if (state == 2 || state == 3) {
            this.f55274h.notifyLoadingComplete(true, uIStateData.getIsFinish());
            X9(uIStateData);
        } else {
            if (state != 4) {
                return;
            }
            QLog.e("QZoneFamousUserHomeListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + uIStateData.getRetCode() + " | msg = " + uIStateData.getMsg());
            this.f55274h.notifyLoadingComplete(false);
        }
    }

    private void X9(UIStateData<List<BusinessFeedData>> uIStateData) {
        Object valueOf;
        if (uIStateData == null) {
            return;
        }
        List<BusinessFeedData> data = uIStateData.getData();
        boolean isFinish = uIStateData.getIsFinish();
        if (data == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("get usr feed data  view model hashCode is ");
        com.qzone.reborn.feedx.viewmodel.w wVar = this.C;
        if (wVar == null) {
            valueOf = "0";
        } else {
            valueOf = Integer.valueOf(wVar.hashCode());
        }
        sb5.append(valueOf);
        QLog.d("QZoneFamousUserHomeListBlockPart", 1, sb5.toString());
        if (data.size() == 1 && com.qzone.reborn.feedx.util.y.c(data.get(0))) {
            data.clear();
        }
        W9(data.size() == 0);
        if (this.f55274h == null) {
            this.f55274h = new com.qzone.reborn.feedx.block.f(null);
        }
        V9(uIStateData, isFinish);
        this.f55274h.setDatas(data);
        aa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i3) {
        boolean z16 = i3 == 1;
        this.f55273f.setBlockVisible(z16);
        this.mBlockContainer.setEnableRefresh(z16);
        this.f55272e.setBlockVisible(!z16);
    }
}
