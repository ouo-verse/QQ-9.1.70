package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.block.QZoneMessageBoardBlock;
import com.qzone.reborn.feedx.event.QZoneUserHomeUpdateBackgroundEvent;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cl extends com.qzone.reborn.base.d implements SimpleEventReceiver {
    private static final int L = ImmersiveUtils.dpToPx(90.0f);
    private com.qzone.reborn.feedx.block.ag C;
    private QZoneFeedxRefreshView D;
    private com.qzone.reborn.feedx.block.k E;
    private com.qzone.reborn.feedx.viewmodel.w F;
    private com.qzone.reborn.feedx.viewmodel.t G;
    private boolean H;
    private com.qzone.reborn.feedx.widget.g I;
    private x6.a J;
    private ImageView K;

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.ad f55118e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.ah f55119f;

    /* renamed from: h, reason: collision with root package name */
    private QZoneMessageBoardBlock f55120h;

    /* renamed from: i, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.ab f55121i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.ae f55122m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends com.qzone.reborn.feedx.viewmodel.s {
        a() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void a(List<? extends BusinessFeedData> list, int i3) {
            cl.this.G9(i3, true, cl.this.f55121i != null ? cl.this.f55121i.p0() : 0);
        }

        @Override // com.qzone.reborn.feedx.viewmodel.s
        public void b(List<? extends BusinessFeedData> list) {
            cl.this.G9(0, true, QZoneFeedxViewUtils.c());
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b extends com.qzone.reborn.feedx.viewmodel.g {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult qZoneResult) {
            if (qZoneResult.getSucceed() || cl.this.C == null) {
                return;
            }
            cl.this.C.notifyLoadingComplete(false);
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
            return ((com.qzone.reborn.feedx.viewmodel.r) cl.this.getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)).O1(f16, f17);
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public void onRelease() {
            ((com.qzone.reborn.feedx.viewmodel.r) cl.this.getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)).P1();
        }
    }

    public cl(int i3, List<MultiViewBlock> list) {
        super(i3, list);
        for (MultiViewBlock multiViewBlock : list) {
            if (this.C != null && this.E != null) {
                return;
            }
            if (multiViewBlock instanceof com.qzone.reborn.feedx.block.ag) {
                this.C = (com.qzone.reborn.feedx.block.ag) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.k) {
                this.E = (com.qzone.reborn.feedx.block.k) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.ae) {
                this.f55122m = (com.qzone.reborn.feedx.block.ae) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.ab) {
                this.f55121i = (com.qzone.reborn.feedx.block.ab) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.ad) {
                this.f55118e = (com.qzone.reborn.feedx.block.ad) multiViewBlock;
            } else if (multiViewBlock instanceof QZoneMessageBoardBlock) {
                this.f55120h = (QZoneMessageBoardBlock) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.ah) {
                this.f55119f = (com.qzone.reborn.feedx.block.ah) multiViewBlock;
            }
        }
    }

    private void S9(Object obj) {
        com.qzone.reborn.feedx.block.ag agVar = this.C;
        if (agVar == null || agVar.getBlockContainer() == null || !(obj instanceof Boolean)) {
            return;
        }
        this.C.getBlockContainer().setPadding(0, 0, 0, ((Boolean) obj).booleanValue() ? L : 0);
    }

    private int T9() {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    private void X9(boolean z16) {
        com.qzone.reborn.feedx.block.k kVar = this.E;
        if (kVar == null || kVar.x0()) {
            return;
        }
        if (this.F.getMIsTimeLineClick() && z16) {
            QLog.d("QZoneUserHomeListBlockPart", 1, "time line click and data is empty");
        } else {
            this.E.l0(z16, com.qzone.reborn.feedx.util.k.t(this.F.M2()));
            this.E.setBlockVisible(z16);
        }
    }

    private void aa(int i3, Intent intent) {
        com.qzone.reborn.feedx.viewmodel.t tVar = this.G;
        if (tVar == null) {
            return;
        }
        tVar.A2(i3, intent);
    }

    private void ba() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        QZoneFeedxRefreshView qZoneFeedxRefreshView = new QZoneFeedxRefreshView(getContext());
        this.D = qZoneFeedxRefreshView;
        this.mBlockContainer.setRefreshHeader(qZoneFeedxRefreshView);
        getBlockContainer().getBlockMerger().j0(QZoneConfigHelper.m0());
    }

    private void ca() {
        if (this.H || getActivity() == null) {
            return;
        }
        this.H = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, DisplayUtil.dip2px(MobileQQ.sMobileQQ, 8.0f), T9());
        this.I = gVar;
        gVar.f(false);
        this.mBlockContainer.getRecyclerView().addItemDecoration(this.I);
    }

    private void da() {
        R9(new c());
    }

    private void ga(boolean z16) {
        if (getBlockContainer() == null || this.E == null) {
            return;
        }
        getBlockContainer().setBackgroundResource(z16 ? R.drawable.lvj : R.drawable.qui_common_bg_bottom_light_bg);
        this.E.B0(z16);
        ImageView imageView = this.K;
        if (imageView != null) {
            imageView.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.qzone.reborn.base.d
    protected we.b C9() {
        return this.C;
    }

    @Override // com.qzone.reborn.base.d
    public void K9() {
        if (this.F.getMIsTimeLineClick()) {
            return;
        }
        super.K9();
    }

    public void R9(QZoneFeedxRefreshView.b bVar) {
        this.D.a(bVar);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneUserHomeUpdateBackgroundEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeListBlockPart";
    }

    @Override // com.qzone.reborn.base.d, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "whether_set_user_home_bottom_padding")) {
            S9(obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 14) {
            aa(i16, intent);
        }
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.K = (ImageView) view.findViewById(R.id.nck);
        this.G = (com.qzone.reborn.feedx.viewmodel.t) getViewModel(com.qzone.reborn.feedx.viewmodel.t.class);
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.F = wVar;
        wVar.T1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.ci
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                cl.this.V9((UIStateData) obj);
            }
        });
        this.F.B2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.cj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                cl.this.ea(((Integer) obj).intValue());
            }
        });
        this.F.C2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.ck
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                cl.this.U9((x6.a) obj);
            }
        });
        ba();
        da();
        this.F.f3(new a());
        this.F.k2(new b());
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        getActivity().getWindow().setSoftInputMode(32);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneUserHomeUpdateBackgroundEvent) {
            Z9((QZoneUserHomeUpdateBackgroundEvent) simpleBaseEvent);
        }
    }

    private void W9(UIStateData<List<BusinessFeedData>> uIStateData, boolean z16) {
        com.qzone.reborn.feedx.block.ag agVar;
        if (uIStateData == null || uIStateData.getData() == null || !z16 || !uIStateData.getIsUpTurning() || (agVar = this.C) == null || agVar.getBlockMerger() == null) {
            return;
        }
        this.C.getBlockMerger().setCustomNoMoreDataView(new ImageView(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9(x6.a aVar) {
        Object valueOf;
        if (aVar == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("get usr info data view model hashCode is ");
        com.qzone.reborn.feedx.viewmodel.w wVar = this.F;
        if (wVar == null) {
            valueOf = "0";
        } else {
            valueOf = Integer.valueOf(wVar.hashCode());
        }
        sb5.append(valueOf);
        QLog.d("QZoneUserHomeListBlockPart", 1, sb5.toString());
        this.J = aVar;
        new LpReportInfo_pf00064(308, 71, aVar.uin).reportImediately();
        broadcastMessage("user_home_business_info", aVar);
        QLog.i("QZoneUserHomeListBlockPart", 1, "host uin is " + aVar.uin + ", guest uin is " + LoginData.getInstance().getUin() + ", relationship is " + aVar.relationShip);
        this.E.v0(this.F, this.G);
        this.E.m0(aVar);
        if (this.E.x0()) {
            this.E.setBlockVisible(true);
            this.E.A0();
            com.qzone.reborn.feedx.block.ag agVar = this.C;
            if (agVar != null) {
                agVar.setDatas(new ArrayList());
                return;
            }
            return;
        }
        if (this.E.w0()) {
            return;
        }
        this.E.setBlockVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V9(UIStateData<List<BusinessFeedData>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        QLog.e("QZoneUserHomeListBlockPart", 1, "handleFeedListRsp() state" + uIStateData.getState());
        int state = uIStateData.getState();
        if (state == 0) {
            QLog.e("QZoneUserHomeListBlockPart", 1, "handleFeedListRsp() return empty data");
            this.C.notifyLoadingComplete(false);
            return;
        }
        if (state == 2 || state == 3) {
            this.C.notifyLoadingComplete(true, uIStateData.getIsFinish());
            Y9(uIStateData);
        } else {
            if (state != 4) {
                return;
            }
            QLog.e("QZoneUserHomeListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + uIStateData.getRetCode() + " | msg = " + uIStateData.getMsg());
            this.C.notifyLoadingComplete(false);
        }
    }

    private void Y9(UIStateData<List<BusinessFeedData>> uIStateData) {
        Object valueOf;
        if (uIStateData == null) {
            return;
        }
        com.qzone.reborn.feedx.block.k kVar = this.E;
        if (kVar != null && kVar.x0()) {
            QLog.i("QZoneUserHomeListBlockPart", 1, "is show empty page block");
            return;
        }
        List<BusinessFeedData> data = uIStateData.getData();
        boolean isFinish = uIStateData.getIsFinish();
        if (data == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("get usr feed data  view model hashCode is ");
        com.qzone.reborn.feedx.viewmodel.w wVar = this.F;
        if (wVar == null) {
            valueOf = "0";
        } else {
            valueOf = Integer.valueOf(wVar.hashCode());
        }
        sb5.append(valueOf);
        QLog.d("QZoneUserHomeListBlockPart", 1, sb5.toString());
        if (data.size() == 1 && com.qzone.reborn.feedx.util.y.c(data.get(0))) {
            data.clear();
        }
        X9(data.size() == 0);
        if (this.C == null) {
            this.C = new com.qzone.reborn.feedx.block.ag(null);
        }
        W9(uIStateData, isFinish);
        this.C.setDatas(data);
        ca();
    }

    private void Z9(QZoneUserHomeUpdateBackgroundEvent qZoneUserHomeUpdateBackgroundEvent) {
        if (qZoneUserHomeUpdateBackgroundEvent == null) {
            return;
        }
        ga(qZoneUserHomeUpdateBackgroundEvent.hasStrangerDecorate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(int i3) {
        boolean z16 = i3 == 1;
        this.f55122m.setBlockVisible(z16);
        this.f55118e.setBlockVisible(z16);
        this.f55119f.setBlockVisible(z16);
        this.f55120h.setBlockVisible(z16);
        this.mBlockContainer.setEnableRefresh(z16);
        this.f55121i.setBlockVisible(!z16);
    }
}
