package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.qzmoment.widget.QZMPageStateView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes37.dex */
public class QZMMessageListPart extends an.a implements ILoadMoreProvider$LoadMoreListener {
    private QZMPageStateView C;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f58936d;

    /* renamed from: e, reason: collision with root package name */
    private RFWConcatAdapter f58937e;

    /* renamed from: f, reason: collision with root package name */
    private SmartRefreshLayout f58938f;

    /* renamed from: h, reason: collision with root package name */
    private cn.e f58939h;

    /* renamed from: i, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.aa f58940i;

    /* renamed from: m, reason: collision with root package name */
    private com.qzone.reborn.qzmoment.viewmodel.l f58941m;

    /* loaded from: classes37.dex */
    class a implements OnRefreshListener {
        a() {
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
        public void onRefresh(IRefreshLayout iRefreshLayout) {
            if (QZMMessageListPart.this.f58941m != null) {
                QZMMessageListPart.this.f58941m.refresh();
            }
        }
    }

    private void F9() {
        this.f58939h = new cn.e();
        com.qzone.reborn.feedx.block.aa aaVar = new com.qzone.reborn.feedx.block.aa();
        this.f58940i = aaVar;
        aaVar.registerLoadMoreListener(this);
        this.f58940i.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.f133706u)).f(HardCodeUtil.qqStr(R.string.f133716v)));
        this.f58939h.setHasStableIds(true);
        this.f58940i.setHasStableIds(true);
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f58939h, this.f58940i});
        this.f58937e = rFWConcatAdapter;
        this.f58936d.setAdapter(rFWConcatAdapter);
    }

    private void I9() {
        this.C.setData(new bn.h().c(new QUIEmptyState.Builder(getContext()).setImageType(8).setTitle(HardCodeUtil.qqStr(R.string.f133696t)).setThemeType(0).setBackgroundColorType(0)).d(new QUIEmptyState.Builder(getContext()).setImageType(5).setTitle(HardCodeUtil.qqStr(R.string.f133596j)).setThemeType(0).setBackgroundColorType(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9(UIStateData uIStateData) {
        if (this.f58939h != null) {
            G9(uIStateData);
        }
    }

    private void K9() {
        this.f58936d.setVisibility(4);
        this.C.p0();
    }

    private void L9(UIStateData<List<bn.g>> uIStateData) {
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        this.f58936d.setVisibility(4);
        this.C.showErrorView();
    }

    private void initData() {
        com.qzone.reborn.qzmoment.viewmodel.l lVar = (com.qzone.reborn.qzmoment.viewmodel.l) getViewModel(com.qzone.reborn.qzmoment.viewmodel.l.class);
        this.f58941m = lVar;
        lVar.O1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.qzmoment.part.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZMMessageListPart.this.J9((UIStateData) obj);
            }
        });
        this.f58941m.init();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.C = (QZMPageStateView) view.findViewById(R.id.mhv);
        this.f58936d = (RecyclerView) view.findViewById(R.id.nfa);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.f162941ng1);
        this.f58938f = smartRefreshLayout;
        smartRefreshLayout.setOnRefreshListener(new a());
        this.f58938f.setEnableOverScrollDrag(true);
        this.f58936d.setItemAnimator(null);
        this.f58936d.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        F9();
        initData();
        I9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        this.f58941m.loadMore();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        cn.e eVar = this.f58939h;
        if (eVar != null) {
            eVar.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        cn.e eVar = this.f58939h;
        if (eVar != null) {
            eVar.l0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        cn.e eVar = this.f58939h;
        if (eVar != null) {
            eVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        cn.e eVar = this.f58939h;
        if (eVar != null) {
            eVar.onStop();
        }
    }

    private void G9(UIStateData<List<bn.g>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 0) {
            K9();
        } else if (state == 2 || state == 3) {
            H9(uIStateData);
        } else if (state == 4) {
            L9(uIStateData);
        }
        this.f58938f.finishRefresh();
        this.f58940i.setLoadState(uIStateData.isLoading(), !uIStateData.getIsFinish());
    }

    private void H9(UIStateData<List<bn.g>> uIStateData) {
        if (uIStateData == null) {
            QLog.e("QZMFeedListPart", 1, "ui state data is null");
            return;
        }
        List<bn.g> data = uIStateData.getData();
        this.f58936d.setVisibility(0);
        this.C.setVisibility(8);
        this.f58939h.setItems(new ArrayList(data));
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMMessageListPart.2
            @Override // java.lang.Runnable
            public void run() {
                QZMMessageListPart.this.f58936d.scrollToPosition(0);
            }
        }, 100L);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean z16) {
    }
}
