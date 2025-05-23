package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.qzmoment.event.QZMNotifyNewPublishFeedEvent;
import com.qzone.reborn.qzmoment.preload.QZMFeedPicPreloadManager;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes37.dex */
public abstract class QZMBaseFeedListPart extends an.a implements ILoadMoreProvider$LoadMoreListener, SimpleEventReceiver {
    private static final int C = ImmersiveUtils.dpToPx(10.0f);
    private static final int D = ImmersiveUtils.dpToPx(15.0f);
    private static final int E = QZoneConfigHelper.A0();

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f58904d;

    /* renamed from: e, reason: collision with root package name */
    private RFWConcatAdapter f58905e;

    /* renamed from: f, reason: collision with root package name */
    protected SmartRefreshLayout f58906f;

    /* renamed from: h, reason: collision with root package name */
    private cn.d f58907h;

    /* renamed from: i, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.aa f58908i;

    /* renamed from: m, reason: collision with root package name */
    private QZMPageStateView f58909m;

    /* loaded from: classes37.dex */
    class a implements OnRefreshListener {
        a() {
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
        public void onRefresh(IRefreshLayout iRefreshLayout) {
            if (QZMBaseFeedListPart.this.I9() != null) {
                QZMBaseFeedListPart.this.I9().d2(false);
            }
        }
    }

    /* loaded from: classes37.dex */
    class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (QZMBaseFeedListPart.this.f58907h != null && !bl.b(QZMBaseFeedListPart.this.f58907h.getItems())) {
                QZMBaseFeedListPart.this.G9(rect, view, recyclerView);
            } else {
                super.getItemOffsets(rect, view, recyclerView, state);
            }
        }
    }

    private void H9() {
        this.f58907h = new cn.d();
        com.qzone.reborn.feedx.block.aa aaVar = new com.qzone.reborn.feedx.block.aa();
        this.f58908i = aaVar;
        aaVar.registerLoadMoreListener(this);
        this.f58907h.setHasStableIds(true);
        this.f58908i.setHasStableIds(true);
        this.f58905e = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f58907h, this.f58908i});
    }

    private void J9(UIStateData<List<bn.b>> uIStateData) {
        this.f58907h.setItems(new ArrayList(uIStateData.getData()));
    }

    private void M9(UIStateData<List<bn.b>> uIStateData) {
        if (bl.b(uIStateData.getData())) {
            O9();
            return;
        }
        this.f58904d.setVisibility(0);
        this.f58909m.setVisibility(8);
        QZMFeedPicPreloadManager.c().b(uIStateData.getData());
        this.f58907h.setItems(new ArrayList(uIStateData.getData()));
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart.3
            @Override // java.lang.Runnable
            public void run() {
                QZMBaseFeedListPart.this.f58904d.scrollToPosition(0);
            }
        }, 100L);
    }

    private void N9() {
        this.f58909m.setData(new bn.h().c(new QUIEmptyState.Builder(getContext()).setImageType(8).setDesc(HardCodeUtil.qqStr(R.string.f133586i)).setThemeType(2).setBackgroundColorType(0)).d(new QUIEmptyState.Builder(getContext()).setImageType(5).setDesc(HardCodeUtil.qqStr(R.string.f133596j)).setThemeType(2).setBackgroundColorType(0)));
    }

    private void O9() {
        this.f58904d.setVisibility(4);
        this.f58909m.p0();
    }

    private void P9(UIStateData<List<bn.b>> uIStateData) {
        if (uIStateData.getIsLoadMore()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f133576h, 0).show();
        } else {
            this.f58904d.setVisibility(4);
            this.f58909m.showErrorView();
        }
    }

    private void initData() {
        if (I9() == null || getHostFragment() == null) {
            return;
        }
        I9().T1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.qzmoment.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZMBaseFeedListPart.this.K9((UIStateData) obj);
            }
        });
        this.f58906f.autoRefresh();
    }

    protected abstract com.qzone.reborn.qzmoment.viewmodel.c I9();

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZMNotifyNewPublishFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public abstract String getTAG();

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f58909m = (QZMPageStateView) view.findViewById(R.id.mhv);
        this.f58904d = (RecyclerView) view.findViewById(R.id.nf7);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.f162941ng1);
        this.f58906f = smartRefreshLayout;
        smartRefreshLayout.setOnRefreshListener(new a());
        this.f58906f.setEnableOverScrollDrag(true);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.f58904d.setItemAnimator(defaultItemAnimator);
        this.f58904d.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        this.f58904d.addItemDecoration(new b());
        H9();
        this.f58904d.setAdapter(this.f58905e);
        initData();
        N9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean z16) {
        QLog.d(getTAG(), 1, "onLoadMoreEnd  hasMore = " + z16);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d(getTAG(), 1, "onLoadMoreStart ");
        if (I9() != null) {
            I9().d2(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        cn.d dVar = this.f58907h;
        if (dVar != null) {
            dVar.onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        cn.d dVar = this.f58907h;
        if (dVar != null) {
            dVar.l0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        cn.d dVar = this.f58907h;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        cn.d dVar = this.f58907h;
        if (dVar != null) {
            dVar.onStop();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZMNotifyNewPublishFeedEvent) {
            L9((QZMNotifyNewPublishFeedEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(Rect rect, View view, RecyclerView recyclerView) {
        rect.left = 0;
        rect.right = 0;
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.top = C;
        } else {
            rect.top = D;
        }
        rect.bottom = D;
    }

    private void L9(QZMNotifyNewPublishFeedEvent qZMNotifyNewPublishFeedEvent) {
        if (qZMNotifyNewPublishFeedEvent == null || qZMNotifyNewPublishFeedEvent.mNewFeed == null) {
            return;
        }
        QLog.i(getTAG(), 1, "handleNewPublishFeedEvent  feedId = " + qZMNotifyNewPublishFeedEvent.mNewFeed.f430362id.get());
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMBaseFeedListPart.4
            @Override // java.lang.Runnable
            public void run() {
                SmartRefreshLayout smartRefreshLayout = QZMBaseFeedListPart.this.f58906f;
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.autoRefresh();
                }
            }
        }, (long) E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9(UIStateData<List<bn.b>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        QLog.i(getTAG(), 1, "handleFeedListRsp()  state = " + uIStateData.getState());
        int state = uIStateData.getState();
        if (state == 0) {
            O9();
        } else if (state == 2 || state == 3) {
            M9(uIStateData);
        } else if (state == 4) {
            P9(uIStateData);
        } else if (state == 6 || state == 7) {
            J9(uIStateData);
        }
        this.f58906f.finishRefresh();
        this.f58908i.setLoadState(false, !uIStateData.getIsFinish());
    }
}
