package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountScrollStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.NegativeItem;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountNegativeFeedback;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountNegativePopup;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggeredBlockContainer;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.QFSPublishAccountStaggeredTechReporter;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountRefreshCtrl;
import com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountMessageServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ef extends u implements o.b {
    private static final int I = ImmersiveUtils.dpToPx(7.0f);
    private static float J = 40.0f;
    private static float K = 0.15f;
    private static boolean L = false;
    private LifecycleOwner C;
    private Bundle D;
    private RefreshHeaderView E;
    private byte[] F;
    private a G;
    private MutableLiveData<UIStateData<List<e30.b>>> H;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o f88036d;

    /* renamed from: e, reason: collision with root package name */
    private QFSPublicAccountStaggeredViewModel f88037e;

    /* renamed from: f, reason: collision with root package name */
    private QFSPublicAccountStaggeredBlockContainer f88038f;

    /* renamed from: h, reason: collision with root package name */
    private QFSPublicAccountNegativePopup f88039h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleFullScreenStatusView f88040i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleInitBean f88041m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ef> f88042a;

        public a(ef efVar) {
            this.f88042a = new WeakReference<>(efVar);
        }

        @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a
        public boolean a(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, @NonNull View view, int i3) {
            ef efVar;
            WeakReference<ef> weakReference = this.f88042a;
            if (weakReference == null) {
                efVar = null;
            } else {
                efVar = weakReference.get();
            }
            if (efVar != null) {
                return efVar.J9(feedCloudMeta$StFeed, view, i3);
            }
            return false;
        }

        @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a
        public void removeAll(@NonNull Function1<? super e30.b, Boolean> function1) {
            ef efVar;
            WeakReference<ef> weakReference = this.f88042a;
            if (weakReference == null) {
                efVar = null;
            } else {
                efVar = weakReference.get();
            }
            if (efVar == null) {
                return;
            }
            efVar.W9(function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<ef> f88043d;

        public b(ef efVar) {
            this.f88043d = new WeakReference<>(efVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            ef efVar;
            QFSPublicAccountStaggeredBlockContainer qFSPublicAccountStaggeredBlockContainer;
            RecyclerView.LayoutManager layoutManager;
            super.onScrollStateChanged(recyclerView, i3);
            WeakReference<ef> weakReference = this.f88043d;
            if (weakReference == null) {
                efVar = null;
            } else {
                efVar = weakReference.get();
            }
            if (efVar != null) {
                qFSPublicAccountStaggeredBlockContainer = efVar.f88038f;
            } else {
                qFSPublicAccountStaggeredBlockContainer = null;
            }
            if (qFSPublicAccountStaggeredBlockContainer == null) {
                layoutManager = null;
            } else {
                layoutManager = qFSPublicAccountStaggeredBlockContainer.getLayoutManager();
            }
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                QLog.e("PublicAccountStaggeredScrollImpl", 1, "[onScrollStateChanged] current layout manager not is staggered grid.");
                return;
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            if (i3 != 0) {
                QLog.e("PublicAccountStaggeredScrollImpl", 1, "[onScrollStateChanged] current not is state idle, end flow.");
                return;
            }
            int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
            if (findFirstVisibleItemPositions.length == 0 || findFirstVisibleItemPositions[0] <= 0) {
                staggeredGridLayoutManager.invalidateSpanAssignments();
                recyclerView.invalidateItemDecorations();
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSPublicAccountScrollStateChangeEvent(1));
        }
    }

    public ef(LifecycleOwner lifecycleOwner, Bundle bundle) {
        this.C = lifecycleOwner;
        this.D = bundle;
    }

    private Long E9() {
        return Long.valueOf(System.currentTimeMillis() - this.f88041m.getEnterTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: F9, reason: merged with bridge method [inline-methods] */
    public List<String> U9() {
        List<e30.b> dataList;
        FeedCloudMeta$StFeed g16;
        String str;
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o oVar = this.f88036d;
        if (oVar == null) {
            dataList = null;
        } else {
            dataList = oVar.getDataList();
        }
        ArrayList arrayList = new ArrayList();
        if (dataList != null && !dataList.isEmpty()) {
            for (e30.b bVar : dataList) {
                if (bVar == null) {
                    g16 = null;
                } else {
                    g16 = bVar.g();
                }
                if (g16 == null) {
                    str = null;
                } else {
                    str = g16.f398449id.get();
                }
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private int G9() {
        return uq3.k.a().e(QCirclePublicAccountMessageServiceImpl.KEY_QCIRCLE_PUBLIC_ACCOUNT_STAGGER_PRELOAD_TRIGGER_COUNT, 8);
    }

    private void H9(UIStateData<List<e30.b>> uIStateData) {
        QCircleFullScreenStatusView qCircleFullScreenStatusView;
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o oVar = this.f88036d;
        if (oVar != null && uIStateData != null) {
            oVar.notifyLoadingComplete(true, uIStateData.getIsFinish());
            if (!this.f88036d.getDataList().isEmpty()) {
                QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[handleEmptyState] current adapter exists data, do nothing.");
                return;
            }
            if (!uIStateData.getIsLoadMore() && (qCircleFullScreenStatusView = this.f88040i) != null) {
                qCircleFullScreenStatusView.showEmptyView("");
                return;
            } else {
                if (uIStateData.getIsLoadMore()) {
                    this.f88036d.getLoadInfo().setFinish(uIStateData.getIsFinish());
                    return;
                }
                return;
            }
        }
        QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[handleEmptyState] operation param is illegality.");
    }

    private void I9(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[handleErrorState] state data should not be null.");
            return;
        }
        String msg2 = uIStateData.getMsg();
        if (TextUtils.isEmpty(msg2)) {
            msg2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f184743mp);
        }
        long retCode = uIStateData.getRetCode();
        QLog.e("QFSPublicAccountStaggeredTabPart", 1, "handleFeedDataRsp() return error\uff01errMsg: " + msg2 + " | errorCode: " + retCode);
        this.f88036d.notifyLoadingComplete(true, uIStateData.getIsFinish());
        if (!QCirclePluginUtil.isRequestSecurityHit(retCode) && this.f88036d.getDataList() != null && !this.f88036d.getDataList().isEmpty()) {
            com.tencent.biz.qqcircle.utils.cj.b(false, retCode, msg2);
        } else {
            this.f88036d.setDatas(new ArrayList());
            this.f88040i.x0(msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J9(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, View view, final int i3) {
        boolean z16;
        QFSBaseFragment qFSBaseFragment;
        ArrayList<NegativeItem> j3 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.j(feedCloudMeta$StFeed, view.getContext());
        if (j3.isEmpty()) {
            return false;
        }
        Rect d16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.d(view);
        int height = d16.height();
        float c16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.c(view);
        if (height > J && c16 > K) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("QFSPublicAccountStaggeredTabPart", 1, "[onLongClick] item but the area is not enough, percent=$visiblePercent");
            return false;
        }
        int centerX = d16.centerX();
        int centerY = d16.centerY();
        if (!(getContext() instanceof Activity)) {
            return false;
        }
        LifecycleOwner lifecycleOwner = this.C;
        if (lifecycleOwner instanceof QFSBaseFragment) {
            qFSBaseFragment = (QFSBaseFragment) lifecycleOwner;
        } else {
            qFSBaseFragment = null;
        }
        if (qFSBaseFragment == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[handleLongClick] fragment should not be null.");
            return false;
        }
        QFSPublicAccountNegativePopup qFSPublicAccountNegativePopup = this.f88039h;
        if (qFSPublicAccountNegativePopup != null) {
            qFSPublicAccountNegativePopup.dismissAllowingStateLoss();
        }
        QFSPublicAccountNegativePopup qFSPublicAccountNegativePopup2 = new QFSPublicAccountNegativePopup(this.f88041m);
        this.f88039h = qFSPublicAccountNegativePopup2;
        qFSPublicAccountNegativePopup2.Ch(qFSBaseFragment.getChildFragmentManager(), feedCloudMeta$StFeed.f398449id.get(), j3, centerX, centerY, new Function1() { // from class: com.tencent.biz.qqcircle.immersive.part.ed
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R9;
                R9 = ef.this.R9(feedCloudMeta$StFeed, i3, (NegativeItem) obj);
                return R9;
            }
        });
        return true;
    }

    private void K9(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        if (this.f88036d == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[handleSuccessData] public account stagger adapter should not be null.");
            return;
        }
        int type = uIStateData.getType();
        QFSPublicAccountStaggeredRepo.RequestType requestType = QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH;
        if (type == requestType.ordinal()) {
            QFSPublishAccountStaggeredTechReporter.g(E9().longValue(), L, false, uIStateData.getData());
        }
        boolean isLoadMore = uIStateData.getIsLoadMore();
        boolean isFinish = uIStateData.getIsFinish();
        if (uIStateData.getType() != QFSPublicAccountStaggeredRepo.RequestType.REFRESH.ordinal() && uIStateData.getType() != requestType.ordinal()) {
            z16 = false;
        } else {
            z16 = true;
        }
        M9();
        if (isLoadMore) {
            this.f88036d.addAll(uIStateData.getData());
        } else if (z16) {
            this.f88036d.E0(uIStateData.getData());
        } else {
            this.f88036d.setDatas(uIStateData.getData());
        }
        this.f88036d.notifyLoadingComplete(true, isFinish);
        if (aa(uIStateData)) {
            this.f88036d.x0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L9, reason: merged with bridge method [inline-methods] */
    public void T9(UIStateData<List<e30.b>> uIStateData) {
        int state = uIStateData.getState();
        QLog.d("QFSPublicAccountStaggeredTabPart", 1, "[handleUIState] state: " + state + ", isLoadMore: " + uIStateData.getIsLoadMore() + ", isFinish: " + uIStateData.getIsFinish() + ".");
        if (state != 0) {
            if (state != 1) {
                if (state != 2) {
                    if (state != 3) {
                        if (state != 4) {
                            if (state == 8) {
                                Q9(uIStateData);
                            }
                        } else {
                            I9(uIStateData);
                        }
                    } else {
                        X9();
                        K9(uIStateData);
                    }
                } else {
                    K9(uIStateData);
                }
            } else {
                M9();
            }
        } else {
            H9(uIStateData);
        }
        V9(uIStateData);
    }

    private void M9() {
        QCircleFullScreenStatusView qCircleFullScreenStatusView = this.f88040i;
        if (qCircleFullScreenStatusView == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[handleLoadingState] status view should not be null.");
        } else {
            qCircleFullScreenStatusView.o0();
        }
    }

    private void N9(View view) {
        this.G = new a(this);
        this.f88036d = new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o(this.D, this.G);
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        this.f88036d.F0(this);
        arrayList.add(this.f88036d);
        QFSPublicAccountStaggeredBlockContainer qFSPublicAccountStaggeredBlockContainer = (QFSPublicAccountStaggeredBlockContainer) view.findViewById(R.id.f165301vg1);
        this.f88038f = qFSPublicAccountStaggeredBlockContainer;
        qFSPublicAccountStaggeredBlockContainer.setEnablePageRecyclerViewPool(false);
        this.f88038f.setLayoutManagerType(3, 2);
        this.f88038f.setParentFragment(getHostFragment());
        this.f88038f.registerBlock(arrayList);
        this.f88038f.setEnableLoadMore(true);
        BlockMerger blockMerger = this.f88038f.getBlockMerger();
        blockMerger.setTryToLoadMoreWhenNotFullScreen(1);
        blockMerger.setEnableRefresh(true);
        blockMerger.setStaggeredRemainCountToTriggerPreload(G9());
        RefreshHeaderView refreshHeaderView = new RefreshHeaderView(getContext());
        this.E = refreshHeaderView;
        this.f88038f.setRefreshHeader(refreshHeaderView);
        this.E.setOnRefreshListener(blockMerger);
        this.f88038f.start();
    }

    private void O9() {
        NestScrollRecyclerView recyclerView;
        QFSPublicAccountStaggeredBlockContainer qFSPublicAccountStaggeredBlockContainer = this.f88038f;
        if (qFSPublicAccountStaggeredBlockContainer == null) {
            recyclerView = null;
        } else {
            recyclerView = qFSPublicAccountStaggeredBlockContainer.getRecyclerView();
        }
        if (recyclerView == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[initRecyclerParam] recycler view should not be null.", new Exception());
            return;
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.ab(I, com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.A0()));
        recyclerView.addOnScrollListener(new b(this));
    }

    private void P9() {
        if (this.f88038f == null) {
            return;
        }
        QCircleFullScreenStatusView qCircleFullScreenStatusView = new QCircleFullScreenStatusView(getContext());
        this.f88040i = qCircleFullScreenStatusView;
        qCircleFullScreenStatusView.setOnRetryClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.eb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ef.this.S9(view);
            }
        });
        this.f88040i.setEmptyImageAndText(5, uq3.c.A3(), getContext().getString(R.string.f183003i0));
        this.f88038f.setStatusViewInterface(this.f88040i);
    }

    private void Q9(UIStateData<List<e30.b>> uIStateData) {
        int pos = uIStateData.getPos();
        List<e30.b> data = uIStateData.getData();
        QLog.i("QFSPublicAccountStaggeredTabPart", 1, "[handleUIState] forceInsert succeed,toBeInsertData size: " + data.size());
        this.f88036d.insertData(data, pos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit R9(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, NegativeItem negativeItem) {
        QFSPublicAccountNegativeFeedback.c(feedCloudMeta$StFeed, negativeItem, i3, getPageId(), this.G);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o oVar = this.f88036d;
        if (oVar != null) {
            oVar.x0(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void V9(UIStateData<List<e30.b>> uIStateData) {
        MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData = this.H;
        if (mutableLiveData == null) {
            return;
        }
        mutableLiveData.postValue(uIStateData);
    }

    private void X9() {
        BlockMerger blockMerger;
        QFSPublicAccountStaggeredBlockContainer qFSPublicAccountStaggeredBlockContainer = this.f88038f;
        if (qFSPublicAccountStaggeredBlockContainer == null) {
            blockMerger = null;
        } else {
            blockMerger = qFSPublicAccountStaggeredBlockContainer.getBlockMerger();
        }
        if (blockMerger == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[resetRetryCount] block merger should not be null.");
        } else {
            blockMerger.setTryToLoadMoreWhenNotFullScreen(1);
            blockMerger.resetTryToLoadMoreCount();
        }
    }

    private boolean aa(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        boolean z17;
        if (uIStateData.getType() == QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH_CACHED.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.f88041m == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[shouldAutoRefresh] init bean should not be null.");
            return false;
        }
        boolean isEmpty = uIStateData.getData().isEmpty();
        boolean isTimeToRefreshStaggered = ((IQCirclePublicAccountRefreshCtrl) QRoute.api(IQCirclePublicAccountRefreshCtrl.class)).isTimeToRefreshStaggered();
        if (this.f88041m.getFeed() != null && TextUtils.isEmpty(this.f88041m.getFeed().f398449id.get())) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.i("QFSPublicAccountStaggeredTabPart", 1, "[shouldAutoRefresh], isTimeToRefresh= " + isTimeToRefreshStaggered + "hasFirstFeedFromRedDot= " + z17 + "isCachedEmpty= " + isEmpty);
        if (isTimeToRefreshStaggered || z17 || isEmpty) {
            return true;
        }
        return false;
    }

    private void initViewModel() {
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel = (QFSPublicAccountStaggeredViewModel) getViewModel(QFSPublicAccountStaggeredViewModel.class);
        this.f88037e = qFSPublicAccountStaggeredViewModel;
        qFSPublicAccountStaggeredViewModel.Z1().observe(this.C, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.ec
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ef.this.T9((UIStateData) obj);
            }
        });
        this.f88037e.e2(this.f88041m);
    }

    public void W9(Function1<? super e30.b, Boolean> function1) {
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel = this.f88037e;
        if (qFSPublicAccountStaggeredViewModel != null && this.f88036d != null) {
            qFSPublicAccountStaggeredViewModel.j2(function1);
            this.f88036d.B0(function1);
        } else {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[removeFeedsAll] view model or aadapter param should not be null.");
        }
    }

    public void Y9(Bundle bundle) {
        this.D = bundle;
    }

    public void Z9(QCircleInitBean qCircleInitBean) {
        String dtPageId;
        this.f88041m = qCircleInitBean;
        if (qCircleInitBean.getFromReportBean() == null) {
            dtPageId = "";
        } else {
            dtPageId = qCircleInitBean.getFromReportBean().getDtPageId();
        }
        QLog.d("QFSPublicAccountStaggeredTabPart", 1, "[setInitBean] initBean: " + qCircleInitBean + " | dtPageId: " + dtPageId);
    }

    public void ba(byte[] bArr, boolean z16) {
        int length;
        QFSPublicAccountStaggeredBlockContainer qFSPublicAccountStaggeredBlockContainer;
        if (this.E == null) {
            return;
        }
        this.F = bArr;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        QLog.d("QFSPublicAccountStaggeredTabPart", 1, "[updateRefreshStatus] update to refresh state size: " + length + "isScrollTop" + z16);
        this.E.setState(2);
        if (z16 && (qFSPublicAccountStaggeredBlockContainer = this.f88038f) != null && qFSPublicAccountStaggeredBlockContainer.getRecyclerView() != null) {
            this.f88038f.getRecyclerView().scrollToPosition(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QLog.d("QFSPublicAccountStaggeredTabPart", 1, "[onInitView] init view flow.");
        N9(view);
        O9();
        P9();
        initViewModel();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().dispatchEvent(new QFSPublicAccountStaggerLifecycleEvent(2));
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().dispatchEvent(new QFSPublicAccountStaggerLifecycleEvent(3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.b
    public void onRefresh() {
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel = this.f88037e;
        if (qFSPublicAccountStaggeredViewModel != null) {
            qFSPublicAccountStaggeredViewModel.h2(this.f88041m, this.F);
        }
        if (this.F != null) {
            this.F = null;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.b
    public void s() {
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel = this.f88037e;
        if (qFSPublicAccountStaggeredViewModel == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[onLoadMore] view model should not be null.");
        } else {
            qFSPublicAccountStaggeredViewModel.f2(this.f88041m, new Function0() { // from class: com.tencent.biz.qqcircle.immersive.part.ee
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List U9;
                    U9 = ef.this.U9();
                    return U9;
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.b
    public void s9() {
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel = this.f88037e;
        if (qFSPublicAccountStaggeredViewModel == null) {
            QLog.e("QFSPublicAccountStaggeredTabPart", 1, "[onAutoRefresh] view model should not be null.");
        } else {
            qFSPublicAccountStaggeredViewModel.d2(this.f88041m);
        }
    }
}
