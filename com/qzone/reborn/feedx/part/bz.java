package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.feedx.itemview.QZoneFeedxEmptyPageView;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.LoadingUtil;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.model.CoverCacheData;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bz extends com.qzone.reborn.base.d implements IObserver.main {
    private boolean C;
    private boolean D;
    private QZoneFeedxRefreshView E;
    private com.qzone.reborn.feedx.widget.g F;
    private com.qzone.reborn.feedx.block.k G;
    private Dialog H;
    private boolean I;

    /* renamed from: e, reason: collision with root package name */
    private boolean f55066e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.y f55067f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.q f55068h;

    /* renamed from: i, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.f f55069i;

    /* renamed from: m, reason: collision with root package name */
    private gf.q f55070m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Observer<UIStateData<List<BusinessFeedData>>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<BusinessFeedData>> uIStateData) {
            bz.this.U9(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements QZoneFeedxRefreshView.b {
        b() {
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public boolean a(float f16, float f17) {
            return ((com.qzone.reborn.feedx.viewmodel.r) bz.this.getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)).O1(f16, f17);
        }

        @Override // com.qzone.reborn.feedx.widget.header.QZoneFeedxRefreshView.b
        public void onRelease() {
            ((com.qzone.reborn.feedx.viewmodel.r) bz.this.getViewModel(com.qzone.reborn.feedx.viewmodel.r.class)).P1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c extends com.qzone.reborn.feedx.viewmodel.g {
        c() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void i5(QZoneResult qZoneResult) {
            bz.this.ha();
            if (qZoneResult.getSucceed() || bz.this.f55067f == null) {
                return;
            }
            bz.this.f55067f.notifyLoadingComplete(false);
        }
    }

    public bz(int i3, List<MultiViewBlock> list, boolean z16) {
        super(i3, list);
        for (MultiViewBlock multiViewBlock : list) {
            if (this.f55067f != null && this.G != null) {
                break;
            }
            if (multiViewBlock instanceof com.qzone.reborn.feedx.block.y) {
                this.f55067f = (com.qzone.reborn.feedx.block.y) multiViewBlock;
            } else if (multiViewBlock instanceof com.qzone.reborn.feedx.block.k) {
                this.G = (com.qzone.reborn.feedx.block.k) multiViewBlock;
            }
        }
        if (z16) {
            L9(false);
        }
        com.qzone.reborn.feedx.block.y yVar = this.f55067f;
        if (yVar != null) {
            yVar.setHasStableIds(true);
        }
        this.f55066e = z16;
    }

    private QZoneFeedxEmptyPageView.a R9() {
        return new QZoneFeedxEmptyPageView.a().n(com.qzone.reborn.util.h.c(true)).i(com.qzone.reborn.util.h.b(true, QQTheme.isNowThemeIsNightForQzone()));
    }

    private void S9() {
        RFWLog.i("QZoneFriendFeedxListBlockPart", RFWLog.USR, "try to clearExtraActiveCountInfo when resume");
        com.qzone.reborn.feedx.util.j jVar = com.qzone.reborn.feedx.util.j.f55760a;
        if (jVar.o(getActivity())) {
            RFWLog.i("QZoneFriendFeedxListBlockPart", RFWLog.USR, "clearExtraActiveCountInfo when resume");
            jVar.f();
        }
    }

    private int T9(CoverCacheData coverCacheData) {
        return getActivity().getResources().getColor(R.color.qui_common_border_light);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U9(UIStateData<List<BusinessFeedData>> uIStateData) {
        X9();
        if (uIStateData == null || this.f55067f == null) {
            return;
        }
        QLog.e("QZoneFriendFeedxListBlockPart", 1, "handleFeedListRsp() state" + uIStateData.getState());
        int state = uIStateData.getState();
        if (state == 0) {
            QLog.e("QZoneFriendFeedxListBlockPart", 1, "handleFeedListRsp() return empty data");
            this.f55067f.notifyLoadingComplete(false);
            return;
        }
        if (state == 2 || state == 3) {
            this.f55067f.notifyLoadingComplete(true, uIStateData.getIsFinish());
            W9(uIStateData.getData(), uIStateData);
            if (this.f55068h.getMNeedRefresh() || this.I) {
                return;
            }
            this.I = true;
            aa();
            return;
        }
        if (state != 4) {
            return;
        }
        QLog.e("QZoneFriendFeedxListBlockPart", 1, "handleFeedListRsp() return error  | retCode = " + uIStateData.getRetCode() + " | msg = " + uIStateData.getMsg());
        this.f55067f.notifyLoadingComplete(false);
    }

    private void V9(int i3) {
        com.qzone.reborn.feedx.viewmodel.q qVar;
        if (this.f55070m == null || (qVar = this.f55068h) == null || !qVar.getMIsReadDivideLineClicked()) {
            return;
        }
        this.C = true;
        RFWLog.d("QZoneFriendFeedxListBlockPart", RFWLog.USR, "read divide line is clicked " + this.f55068h.getMIsReadDivideLineClicked());
        if (this.f55068h.getMIsLoadMoreUp()) {
            this.f55070m.b(i3);
            return;
        }
        this.f55070m.c(this.f55067f);
        this.f55070m.e(this.f55068h.E2());
        this.f55070m.a();
    }

    private void X9() {
        Dialog dialog = this.H;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.H.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9(CoverCacheData coverCacheData) {
        com.qzone.reborn.feedx.widget.g gVar = this.F;
        if (gVar != null) {
            gVar.g(T9(coverCacheData));
            this.mBlockContainer.invalidate();
        }
    }

    private void Z9(boolean z16) {
        if (this.mBlockContainer == null || this.f55070m == null || this.f55068h == null) {
            return;
        }
        if (z16) {
            da();
        } else {
            ca();
        }
    }

    private void aa() {
        if (!QZoneConfigHelper.C() || this.f55066e || com.qzone.reborn.feedx.viewmodel.q.T <= 1) {
            return;
        }
        J9(com.qzone.reborn.feedx.viewmodel.q.T, true, com.qzone.reborn.feedx.viewmodel.q.U - QZoneFeedxViewUtils.e(getActivity()));
        broadcastMessage("FAST_MINIFY_QZM_ENTRANCE", null);
        com.qzone.reborn.feedx.viewmodel.q.N2();
    }

    private List<BusinessFeedData> ba(List<BusinessFeedData> list) {
        if (this.C && list != null && !list.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    i3 = -1;
                    break;
                }
                if (list.get(i3).isFriendFeedReadLineFeed()) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return list;
            }
            list.remove(i3);
        }
        return list;
    }

    private void ca() {
        E9(this.f55070m.f());
        this.f55068h.t2();
    }

    private void da() {
        E9(this.f55070m.d());
        this.f55068h.t2();
    }

    private void ea() {
        this.mBlockContainer.setLayoutManagerType(1, 1);
        this.mBlockContainer.setParentFragment(getHostFragment());
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.setEnableRefresh(true);
        QZoneFeedxRefreshView qZoneFeedxRefreshView = new QZoneFeedxRefreshView(getContext());
        this.E = qZoneFeedxRefreshView;
        this.mBlockContainer.setRefreshHeader(qZoneFeedxRefreshView);
    }

    private void ga() {
        if (this.D || getActivity() == null) {
            return;
        }
        this.D = true;
        com.qzone.reborn.feedx.widget.g gVar = new com.qzone.reborn.feedx.widget.g(getContext(), 0, DisplayUtil.dip2px(MobileQQ.sMobileQQ, 8.0f), T9(null));
        this.F = gVar;
        gVar.f(false);
        this.mBlockContainer.getRecyclerView().addItemDecoration(this.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        if (getBlockContainer() == null) {
            return;
        }
        int m06 = QZoneConfigHelper.m0();
        QLog.i("QZoneFriendFeedxListBlockPart", 1, "preload item size " + m06);
        getBlockContainer().getBlockMerger().j0(m06);
    }

    private void ia() {
        Q9(new b());
        this.f55068h.k2(new c());
    }

    private void ja(boolean z16) {
        com.qzone.reborn.feedx.block.k kVar = this.G;
        if (kVar == null) {
            return;
        }
        kVar.l0(z16, R9());
        this.G.setBlockVisible(z16);
    }

    private void la() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        if (this.H == null) {
            this.H = LoadingUtil.showLoadingDialog(getActivity(), getActivity().getResources().getString(R.string.w_3), false);
        }
        Dialog dialog = this.H;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        this.H.show();
    }

    @Override // com.qzone.reborn.base.d
    protected we.b C9() {
        return this.f55067f;
    }

    public void Q9(QZoneFeedxRefreshView.b bVar) {
        this.E.a(bVar);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFriendFeedxListBlockPart";
    }

    @Override // com.qzone.reborn.base.d, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("READ_DIVIDE_LINE_SCROLL".equals(str) && (obj instanceof Boolean)) {
            Z9(((Boolean) obj).booleanValue());
        } else if ("SHOW_LOADING".equals(str)) {
            la();
        } else if ("HIDE_LOADING".equals(str)) {
            X9();
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if (event.source.getName().equals("FeedX")) {
            int i3 = event.what;
            if (i3 == 1) {
                la();
            } else {
                if (i3 != 2) {
                    return;
                }
                X9();
            }
        }
    }

    @Override // com.qzone.reborn.base.c, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.qzone.reborn.feedx.viewmodel.q qVar = (com.qzone.reborn.feedx.viewmodel.q) getViewModel(com.qzone.reborn.feedx.viewmodel.q.class);
        this.f55068h = qVar;
        qVar.T1().observe(getPartHost().getLifecycleOwner(), new a());
        ea();
        this.f55070m = (gf.q) getIocInterface(gf.q.class);
        com.qzone.reborn.feedx.viewmodel.f fVar = (com.qzone.reborn.feedx.viewmodel.f) getViewModel(com.qzone.reborn.feedx.viewmodel.f.class);
        this.f55069i = fVar;
        fVar.N1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.bx
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bz.this.Y9((CoverCacheData) obj);
            }
        });
        ia();
        EventCenter.getInstance().addUIObserver(this, "FeedX", 1, 2);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        if (!this.f55066e) {
            com.qzone.reborn.feedx.viewmodel.q.J2(this.mBlockContainer);
        }
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
        BlockContainer blockContainer = this.mBlockContainer;
        if (blockContainer instanceof QZoneBaseBlockContainer) {
            ((QZoneBaseBlockContainer) blockContainer).c();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        S9();
    }

    private void W9(List<BusinessFeedData> list, UIStateData<List<BusinessFeedData>> uIStateData) {
        if (list == null) {
            return;
        }
        ja(list.size() == 0);
        if (this.f55067f == null) {
            this.f55067f = new com.qzone.reborn.feedx.block.y(null);
        }
        ba(list);
        com.qzone.reborn.feedx.scroller.g.f().e(list, uIStateData);
        this.f55067f.setDatas(list);
        V9(list.size());
        com.qzone.reborn.feedx.viewmodel.q qVar = this.f55068h;
        if (qVar != null && qVar.getMIsReadDivideLineClicked()) {
            broadcastMessage("READ_DIVIDE_LINE_SCROLL", Boolean.valueOf(this.f55068h.getMIsLoadMoreUp()));
        }
        ga();
    }
}
