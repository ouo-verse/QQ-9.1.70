package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.widget.QZMPageStateView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qzonemoment.QZMomentMeta$StFeed;

/* compiled from: P */
/* loaded from: classes37.dex */
public class w extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, SimpleEventReceiver {
    private static final int E = ImmersiveUtils.dpToPx(10.0f);
    private static final int F = ImmersiveUtils.dpToPx(15.0f);
    private QZMPageStateView C;
    private View D;

    /* renamed from: d, reason: collision with root package name */
    private QZMomentMeta$StFeed f58985d;

    /* renamed from: e, reason: collision with root package name */
    private RFWConcatAdapter f58986e;

    /* renamed from: f, reason: collision with root package name */
    private cn.f f58987f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.aa f58988h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f58989i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.qzmoment.viewmodel.o f58990m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (w.this.f58987f != null && !bl.b(w.this.f58987f.getItems())) {
                w.this.G9(rect, view, recyclerView);
            } else {
                super.getItemOffsets(rect, view, recyclerView, state);
            }
        }
    }

    private void H9() {
        String str;
        HashMap hashMap = new HashMap();
        QZMomentMeta$StFeed qZMomentMeta$StFeed = this.f58985d;
        String str2 = "";
        if (qZMomentMeta$StFeed == null) {
            str = "";
        } else {
            str = qZMomentMeta$StFeed.f430362id.get();
        }
        hashMap.put("operated_feed", str);
        QZMomentMeta$StFeed qZMomentMeta$StFeed2 = this.f58985d;
        if (qZMomentMeta$StFeed2 != null) {
            str2 = qZMomentMeta$StFeed2.poster.f430367id.get();
        }
        hashMap.put("author_id", str2);
        fo.c.o(this.D, "em_bas_like_list", new fo.b().l(hashMap).g(ClickPolicy.REPORT_NONE));
    }

    private void J9(List<bn.f> list) {
        this.f58989i.setVisibility(0);
        this.C.setVisibility(8);
        this.f58987f.setItems(new ArrayList(list));
        this.f58990m.P1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.qzmoment.part.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                w.this.L9((Integer) obj);
            }
        });
    }

    private void K9() {
        this.C.setData(new bn.h().c(new QUIEmptyState.Builder(getContext()).setImageType(8).setDesc(HardCodeUtil.qqStr(R.string.f133756z)).setThemeType(0).setBackgroundColorType(0)).d(new QUIEmptyState.Builder(getContext()).setImageType(8).setDesc(HardCodeUtil.qqStr(R.string.f133596j)).setThemeType(0).setBackgroundColorType(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L9(Integer num) {
        gn.d dVar = (gn.d) getIocInterface(gn.d.class);
        if (dVar == null || num == null) {
            return;
        }
        dVar.r5(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M9(UIStateData uIStateData) {
        if (this.f58987f != null) {
            I9(uIStateData);
        }
    }

    private void N9() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent.getExtras() == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY) instanceof QZMFeedCommentInfo) {
            this.f58985d = ((QZMFeedCommentInfo) extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY)).mFeed;
        }
    }

    private void O9() {
        this.f58987f = new cn.f();
        com.qzone.reborn.feedx.block.aa aaVar = new com.qzone.reborn.feedx.block.aa();
        this.f58988h = aaVar;
        aaVar.registerLoadMoreListener(this);
        this.f58988h.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.f1337670)).f(HardCodeUtil.qqStr(R.string.f1337771)));
        this.f58987f.setHasStableIds(true);
        this.f58988h.setHasStableIds(true);
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f58987f, this.f58988h});
        this.f58986e = rFWConcatAdapter;
        this.f58989i.setAdapter(rFWConcatAdapter);
    }

    private void P9() {
        this.f58989i.setVisibility(4);
        this.C.p0();
    }

    private void Q9(UIStateData<List<bn.f>> uIStateData) {
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        this.f58989i.setVisibility(4);
        this.C.showErrorView();
    }

    private void initData() {
        com.qzone.reborn.qzmoment.viewmodel.o oVar = (com.qzone.reborn.qzmoment.viewmodel.o) getViewModel(com.qzone.reborn.qzmoment.viewmodel.o.class);
        this.f58990m = oVar;
        oVar.O1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.qzmoment.part.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                w.this.M9((UIStateData) obj);
            }
        });
        this.f58990m.R1(this.f58985d);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.D = view;
        N9();
        this.C = (QZMPageStateView) view.findViewById(R.id.mhv);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f162780ml3);
        this.f58989i = recyclerView;
        recyclerView.setItemAnimator(null);
        this.f58989i.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        this.f58989i.addItemDecoration(new a());
        O9();
        initData();
        K9();
        H9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        this.f58990m.T1(this.f58985d);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        cn.f fVar = this.f58987f;
        if (fVar != null) {
            fVar.onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        cn.f fVar = this.f58987f;
        if (fVar != null) {
            fVar.l0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        cn.f fVar = this.f58987f;
        if (fVar != null) {
            fVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        cn.f fVar = this.f58987f;
        if (fVar != null) {
            fVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(Rect rect, View view, RecyclerView recyclerView) {
        rect.left = 0;
        rect.right = 0;
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.top = F;
        } else {
            rect.top = E;
        }
        rect.bottom = E;
    }

    private void I9(UIStateData<List<bn.f>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 0) {
            P9();
        } else if (state == 2 || state == 3) {
            J9(uIStateData.getData());
        } else if (state == 4) {
            Q9(uIStateData);
        }
        this.f58988h.setLoadState(uIStateData.isLoading(), !uIStateData.getIsFinish());
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean z16) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
