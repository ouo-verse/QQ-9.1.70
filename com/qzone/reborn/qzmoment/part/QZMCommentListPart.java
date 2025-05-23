package com.qzone.reborn.qzmoment.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.block.aa;
import com.qzone.reborn.qzmoment.comment.QZMCommentBusinessViewModel;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.reborn.qzmoment.comment.d;
import com.qzone.reborn.qzmoment.comment.event.QZMShowSlidAnimFinishEvent;
import com.qzone.reborn.qzmoment.widget.QZMPageStateView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StReply;

/* loaded from: classes37.dex */
public class QZMCommentListPart extends com.qzone.reborn.base.k implements ILoadMoreProvider$LoadMoreListener, SimpleEventReceiver, Observer<QZMFeedCommentInfo> {
    private UIStateData<List<QZMomentMeta$StComment>> C;
    private QZMPageStateView D;
    private View E;
    private boolean F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private RFWConcatAdapter f58912d;

    /* renamed from: e, reason: collision with root package name */
    private cn.a f58913e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.block.aa f58914f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f58915h;

    /* renamed from: i, reason: collision with root package name */
    private QZMCommentBusinessViewModel f58916i;

    /* renamed from: m, reason: collision with root package name */
    private QZMFeedCommentInfo f58917m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements Observer<UIStateData<List<QZMomentMeta$StComment>>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<QZMomentMeta$StComment>> uIStateData) {
            QZMCommentListPart.this.G9(uIStateData);
        }
    }

    private void F9() {
        String str;
        HashMap hashMap = new HashMap();
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f58917m;
        String str2 = "";
        if (qZMFeedCommentInfo == null) {
            str = "";
        } else {
            str = qZMFeedCommentInfo.mFeed.f430362id.get();
        }
        hashMap.put("operated_feed", str);
        QZMFeedCommentInfo qZMFeedCommentInfo2 = this.f58917m;
        if (qZMFeedCommentInfo2 != null) {
            str2 = qZMFeedCommentInfo2.mFeed.poster.f430367id.get();
        }
        hashMap.put("author_id", str2);
        fo.c.o(this.E, "em_bas_comment_panel", new fo.b().l(hashMap).g(ClickPolicy.REPORT_NONE));
    }

    private void I9() {
        if (this.D == null) {
            return;
        }
        RFWLog.d("QZMCommentListPart", RFWLog.USR, "hide empty view");
        this.D.setVisibility(8);
    }

    private void J9() {
        String qqStr;
        bn.h hVar = new bn.h();
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(8);
        if (K9()) {
            qqStr = HardCodeUtil.qqStr(R.string.f133616l);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f133626m);
        }
        this.D.setData(hVar.c(imageType.setTitle(qqStr).setThemeType(0).setBackgroundColorType(1)).d(new QUIEmptyState.Builder(getContext()).setImageType(8).setTitle(HardCodeUtil.qqStr(R.string.f133596j)).setThemeType(0).setBackgroundColorType(1)));
    }

    private boolean K9() {
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f58917m;
        if (qZMFeedCommentInfo == null) {
            return true;
        }
        return qZMFeedCommentInfo.mIsGuest;
    }

    private void M9() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent.getExtras() == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY) instanceof QZMFeedCommentInfo) {
            this.f58917m = (QZMFeedCommentInfo) extras.get(QZMFeedCommentInfo.FEED_COMMENT_INFO_KEY);
        }
    }

    private void N9() {
        this.f58913e = new cn.a();
        com.qzone.reborn.feedx.block.aa aaVar = new com.qzone.reborn.feedx.block.aa();
        this.f58914f = aaVar;
        aaVar.registerLoadMoreListener(this);
        this.f58914f.p0(new aa.a().e(HardCodeUtil.qqStr(R.string.f133235k)).f(HardCodeUtil.qqStr(R.string.f133245l)));
        this.f58913e.setHasStableIds(true);
        this.f58914f.setHasStableIds(true);
        this.f58912d = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f58913e, this.f58914f});
    }

    private void O9(final UIStateData<List<QZMomentMeta$StComment>> uIStateData) {
        if (this.f58913e == null || uIStateData == null) {
            return;
        }
        RFWLog.i("QZMCommentListPart", RFWLog.USR, "set data to comment list");
        List<QZMomentMeta$StComment> data = uIStateData.getData();
        if (data == null) {
            QLog.e("QZMCommentListPart", 1, "list is null");
            return;
        }
        if (!data.isEmpty()) {
            I9();
        } else {
            R9();
        }
        this.f58913e.setItems(new ArrayList(data));
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMCommentListPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (QZMCommentListPart.this.f58915h == null || !uIStateData.getIsUpTurning()) {
                    return;
                }
                QZMCommentListPart.this.f58915h.smoothScrollToPosition(0);
            }
        });
    }

    private void P9(boolean z16, boolean z17) {
        com.qzone.reborn.feedx.block.aa aaVar = this.f58914f;
        if (aaVar == null) {
            return;
        }
        aaVar.setLoadState(z16, z17);
    }

    private void Q9() {
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f58917m;
        if (qZMFeedCommentInfo != null && qZMFeedCommentInfo.mIsGuest && qZMFeedCommentInfo.mTotalCommentCount == 0) {
            com.qzone.reborn.qzmoment.comment.d.l().p(this.f58916i);
            QZMFeedCommentInfo qZMFeedCommentInfo2 = new QZMFeedCommentInfo();
            QZMFeedCommentInfo qZMFeedCommentInfo3 = this.f58917m;
            qZMFeedCommentInfo2.mFeed = qZMFeedCommentInfo3.mFeed;
            qZMFeedCommentInfo2.mComment = qZMFeedCommentInfo3.mComment;
            qZMFeedCommentInfo2.mIsGuest = true;
            qZMFeedCommentInfo2.mTotalCommentCount = 0;
            com.qzone.reborn.qzmoment.comment.d.l().q(getActivity(), qZMFeedCommentInfo2, new b());
        }
    }

    private void R9() {
        QZMPageStateView qZMPageStateView = this.D;
        if (qZMPageStateView != null) {
            qZMPageStateView.p0();
        }
        Q9();
    }

    private void S9(UIStateData<List<QZMomentMeta$StComment>> uIStateData) {
        QZMPageStateView qZMPageStateView;
        if (uIStateData.getIsLoadMore() || (qZMPageStateView = this.D) == null) {
            return;
        }
        qZMPageStateView.showErrorView();
    }

    private void initViewModel() {
        M9();
        QZMCommentBusinessViewModel qZMCommentBusinessViewModel = (QZMCommentBusinessViewModel) getViewModel(QZMCommentBusinessViewModel.class);
        this.f58916i = qZMCommentBusinessViewModel;
        if (qZMCommentBusinessViewModel == null) {
            QLog.e("QZMCommentListPart", 1, "view model is null");
            return;
        }
        qZMCommentBusinessViewModel.n2().observeForever(new a());
        if (this.f58917m != null) {
            this.f58916i.D2(getActivity().hashCode(), this.f58917m.mFeed, false);
        }
        gn.b bVar = (gn.b) getIocInterface(gn.b.class);
        bVar.c(this.f58916i);
        bVar.b(this.f58917m);
        QZMFeedCommentInfo qZMFeedCommentInfo = this.f58917m;
        if (qZMFeedCommentInfo == null || qZMFeedCommentInfo.mFeed == null) {
            return;
        }
        en.a a16 = en.a.a();
        QZMomentMeta$StFeed qZMomentMeta$StFeed = this.f58917m.mFeed;
        a16.observerGlobalState(new QZMFeedCommentInfo(qZMomentMeta$StFeed, qZMomentMeta$StFeed.commentCount.get()), this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZMShowSlidAnimFinishEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.E = view;
        this.D = (QZMPageStateView) view.findViewById(R.id.mhv);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.mjy);
        this.f58915h = recyclerView;
        recyclerView.setItemAnimator(null);
        this.f58915h.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        N9();
        this.f58915h.setAdapter(this.f58912d);
        initViewModel();
        J9();
        F9();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QZMCommentBusinessViewModel qZMCommentBusinessViewModel = this.f58916i;
        if (qZMCommentBusinessViewModel == null) {
            QLog.e("QZMCommentListPart", 1, "load more start, but view model is null");
        } else if (this.f58917m != null) {
            qZMCommentBusinessViewModel.H2(getActivity().hashCode(), this.f58917m.mFeed, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        SimpleEventBus.getInstance().registerReceiver(this);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.part.QZMCommentListPart.2
            @Override // java.lang.Runnable
            public void run() {
                QZMCommentListPart.this.H9();
            }
        }, 350L);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        cn.a aVar = this.f58913e;
        if (aVar != null) {
            aVar.onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        cn.a aVar = this.f58913e;
        if (aVar != null) {
            aVar.l0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        cn.a aVar = this.f58913e;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        cn.a aVar = this.f58913e;
        if (aVar != null) {
            aVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9() {
        this.F = true;
        if (this.G) {
            RFWLog.d("QZMCommentListPart", RFWLog.USR, "anim finish after data ready, set data");
            O9(this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9(UIStateData<List<QZMomentMeta$StComment>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state == 0) {
            R9();
        } else if (state == 2 || state == 3) {
            if (this.F) {
                RFWLog.d("QZMCommentListPart", RFWLog.USR, "data ready before anim finish");
                O9(uIStateData);
            } else {
                RFWLog.d("QZMCommentListPart", RFWLog.USR, "restore data before slid anim finish");
                this.C = uIStateData;
            }
            this.G = true;
        } else if (state == 4) {
            S9(uIStateData);
        }
        P9(uIStateData.isLoading(), !uIStateData.getIsFinish());
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: L9, reason: merged with bridge method [inline-methods] */
    public void onChanged(QZMFeedCommentInfo qZMFeedCommentInfo) {
        gn.d dVar;
        if (qZMFeedCommentInfo == null || (dVar = (gn.d) getIocInterface(gn.d.class)) == null) {
            return;
        }
        dVar.b8(qZMFeedCommentInfo.mTotalCommentCount);
        dVar.L2(qZMFeedCommentInfo.mPermissionText);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements d.InterfaceC0494d {
        b() {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void a(QZMomentMeta$StComment qZMomentMeta$StComment) {
        }

        @Override // com.qzone.reborn.qzmoment.comment.d.InterfaceC0494d
        public void b(QZMomentMeta$StReply qZMomentMeta$StReply) {
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean z16) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
