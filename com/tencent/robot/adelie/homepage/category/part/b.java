package com.tencent.robot.adelie.homepage.category.part;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotTabInfo;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.robot.adelie.homepage.category.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.robot.adelie.homepage.category.viewmodel.BannerDelegateData;
import com.tencent.robot.adelie.homepage.category.viewmodel.PageDataType;
import com.tencent.robot.adelie.homepage.category.viewmodel.RecommondPageData;
import com.tencent.robot.adelie.homepage.eventbus.AdelieNewOrOldGuideEvent;
import com.tencent.robot.adelie.homepage.utils.i;
import com.tencent.robot.api.IPreDownloadVideoApi;
import com.tencent.robot.qqmc.RobotQQMC;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends Part implements ILoadMoreProvider$LoadMoreListener {
    public static final int M = com.tencent.qqnt.base.utils.c.f353052a.a(6.0f);
    private v14.b C;
    private View D;
    private View E;
    private ImageView F;
    private ScanningLightView G;
    private LifecycleOwner I;
    private AdelieHomeCategoryViewModel J;
    private LiveData<RecommondPageData> K;

    /* renamed from: d, reason: collision with root package name */
    private RobotTabInfo f365977d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f365978e;

    /* renamed from: f, reason: collision with root package name */
    private RFWConcatAdapter f365979f;

    /* renamed from: h, reason: collision with root package name */
    private s14.c f365980h;

    /* renamed from: i, reason: collision with root package name */
    private s14.b f365981i;

    /* renamed from: m, reason: collision with root package name */
    private SmartRefreshLayout f365982m;
    private volatile boolean H = false;
    private Observer<RecommondPageData> L = new a();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements Observer<RecommondPageData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(RecommondPageData recommondPageData) {
            if (recommondPageData != null && b.this.f365981i != null && b.this.f365977d != null && b.this.f365977d.tabId != null) {
                QLog.i("AdelieHomeCategoryPage", 1, b.this + "observe new PageData(count:" + recommondPageData.a().size() + "):at:" + System.currentTimeMillis() + recommondPageData);
                b.this.H = recommondPageData.getIsEnd();
                switch (e.f365988a[recommondPageData.getType().ordinal()]) {
                    case 1:
                        if (!b.this.f365977d.tabId.equals("0")) {
                            b.this.P9(true, false);
                            break;
                        }
                        break;
                    case 2:
                        if (recommondPageData.a().isEmpty()) {
                            b.this.P9(false, true);
                            b.this.f365981i.hide();
                            break;
                        } else {
                            b.this.P9(false, false);
                            b.this.f365981i.show();
                            b.this.f365981i.onLoadMoreEnd(!recommondPageData.getIsEnd());
                            break;
                        }
                    case 3:
                        b.this.O9();
                        b.this.f365981i.hide();
                        break;
                    case 4:
                        if (!recommondPageData.a().isEmpty()) {
                            b.this.P9(false, false);
                            break;
                        }
                        break;
                    case 5:
                        b.this.P9(false, true);
                        b.this.f365981i.hide();
                        break;
                    case 7:
                        b.this.f365981i.show();
                        b.this.f365981i.onLoadMoreEnd(true);
                        break;
                    case 8:
                        b.this.f365981i.show();
                        b.this.f365981i.onLoadMoreEnd(false);
                        break;
                }
                b.this.R9(recommondPageData);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.robot.adelie.homepage.category.part.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C9753b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f365984a;

        C9753b(int i3) {
            this.f365984a = i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            if (i3 == b.this.f365979f.getNUM_BACKGOURND_ICON() - 1) {
                return this.f365984a;
            }
            if (!b.this.Q9(i3)) {
                return 1;
            }
            return 2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && !recyclerView.canScrollVertically(1) && !b.this.H && b.this.f365981i != null) {
                b.this.f365981i.setLoadState(true, !b.this.H);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.O9();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f365988a;

        static {
            int[] iArr = new int[PageDataType.values().length];
            f365988a = iArr;
            try {
                iArr[PageDataType.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f365988a[PageDataType.BACKEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f365988a[PageDataType.CACHE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f365988a[PageDataType.CACHE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f365988a[PageDataType.REFRESH_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f365988a[PageDataType.REFRESHING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f365988a[PageDataType.LOADMORE_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f365988a[PageDataType.NO_NEXT_PAGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public b(@NonNull LifecycleOwner lifecycleOwner, @NonNull AdelieHomeCategoryViewModel adelieHomeCategoryViewModel, @NonNull RobotTabInfo robotTabInfo) {
        this.f365977d = robotTabInfo;
        this.I = lifecycleOwner;
        this.J = adelieHomeCategoryViewModel;
        this.K = adelieHomeCategoryViewModel.Q1(robotTabInfo);
    }

    private void I9() {
        s14.b bVar = this.f365981i;
        if (bVar != null && this.J != null) {
            bVar.show();
            this.f365981i.onLoadMoreStart();
            this.J.S1(this.f365977d);
        }
    }

    private void J9() {
        AdelieHomeCategoryViewModel adelieHomeCategoryViewModel;
        RobotTabInfo robotTabInfo;
        if (this.f365981i != null && (adelieHomeCategoryViewModel = this.J) != null && (robotTabInfo = this.f365977d) != null) {
            adelieHomeCategoryViewModel.W1(robotTabInfo);
            this.f365981i.hide();
        }
    }

    private int K9() {
        PadUtil.a(getContext());
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L9(RobotGuideInfo robotGuideInfo) {
        String str = robotGuideInfo.videoUrl;
        if (str != null && !str.isEmpty()) {
            ((IPreDownloadVideoApi) QRoute.api(IPreDownloadVideoApi.class)).preVideoDownload(str);
        }
    }

    private t14.f M9(RecommondPageData recommondPageData) {
        if (recommondPageData.getGuideInfo() == null || i.f366662a.b()) {
            return null;
        }
        N9(recommondPageData.getGuideInfo());
        return new t14.f(recommondPageData.getGuideInfo());
    }

    private void N9(final RobotGuideInfo robotGuideInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.category.part.a
            @Override // java.lang.Runnable
            public final void run() {
                b.L9(RobotGuideInfo.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O9() {
        RobotTabInfo robotTabInfo;
        AdelieHomeCategoryViewModel adelieHomeCategoryViewModel = this.J;
        if (adelieHomeCategoryViewModel != null && (robotTabInfo = this.f365977d) != null) {
            adelieHomeCategoryViewModel.T1(robotTabInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9(boolean z16, boolean z17) {
        View view;
        int i3;
        if (this.G != null && this.f365982m != null && (view = this.D) != null) {
            int i16 = 8;
            if (z17) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            ScanningLightView scanningLightView = this.G;
            if (z16) {
                i16 = 0;
            }
            scanningLightView.setVisibility(i16);
            if (!z16 && !z17) {
                this.f365982m.setVisibility(0);
            } else {
                this.f365982m.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q9(int i3) {
        s14.c cVar = this.f365980h;
        if (cVar == null) {
            return false;
        }
        return cVar.i0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(RecommondPageData recommondPageData) {
        t14.f M9 = M9(recommondPageData);
        List<com.tencent.robot.adelie.homepage.category.viewmodel.a> a16 = recommondPageData.a();
        boolean z16 = !recommondPageData.getIsEnd();
        if (this.f365981i != null && this.f365980h != null && !a16.isEmpty()) {
            QLog.d("AdelieHomeCategoryPage", 1, this + "updateAdapterData total:" + a16.size() + ", hasMore: " + z16 + ", mLoadMoreAdapter.isLoadingMore() = " + this.f365981i.isLoadingMore());
            if (this.f365977d.tabId.equals("0") && recommondPageData.getIsFirstSection() && !a16.isEmpty()) {
                if (recommondPageData.getType() == PageDataType.BACKEND) {
                    SimpleEventBus.getInstance().dispatchEvent(new AdelieNewOrOldGuideEvent(M9), false);
                }
                if (!(a16.get(0) instanceof BannerDelegateData)) {
                    BannerDelegateData bannerDelegateData = new BannerDelegateData(RobotQQMC.INSTANCE.getHomePageBannerConfig(), M9);
                    if (!bannerDelegateData.getBannerConfig().a().isEmpty() || M9 != null) {
                        a16.add(0, bannerDelegateData);
                    }
                }
            }
            this.f365980h.setItems(a16);
            this.f365981i.setLoadState(false, z16);
            return;
        }
        QLog.d("AdelieHomeCategoryPage", 1, "updateAdapterData null return");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        int i3;
        this.G = (ScanningLightView) view.findViewById(R.id.efs);
        P9(!this.f365977d.tabId.equals("0"), false);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.f72383qp);
        this.f365982m = smartRefreshLayout;
        smartRefreshLayout.setEnableOverScrollDrag(true);
        this.f365982m.setEnableRefresh(false);
        this.f365978e = (RecyclerView) view.findViewById(R.id.f790548q);
        s14.c cVar = new s14.c(new r14.a());
        this.f365980h = cVar;
        cVar.setHasStableIds(false);
        s14.b bVar = new s14.b();
        this.f365981i = bVar;
        bVar.hide();
        this.f365981i.registerLoadMoreListener(this);
        this.f365979f = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(false).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.NO_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f365980h, this.f365981i});
        this.f365978e.setItemAnimator(null);
        int K9 = K9();
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), K9);
        safeGridLayoutManager.setSpanSizeLookup(new C9753b(K9));
        this.f365978e.setLayoutManager(safeGridLayoutManager);
        this.f365978e.setAdapter(this.f365979f);
        this.f365978e.setOnScrollListener(new c());
        v14.b bVar2 = new v14.b(K9, M, false);
        this.C = bVar2;
        this.f365978e.addItemDecoration(bVar2);
        this.D = view.findViewById(R.id.uwt);
        this.F = (ImageView) view.findViewById(R.id.y2v);
        if (je0.a.a(BaseApplication.getContext())) {
            i3 = R.drawable.mi5;
        } else {
            i3 = R.drawable.f160066mi4;
        }
        this.F.setImageResource(i3);
        View findViewById = view.findViewById(R.id.by7);
        this.E = findViewById;
        findViewById.setOnClickListener(new d());
        this.K.observe(this.I, this.L);
        if (!this.f365977d.tabId.equals("0")) {
            J9();
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d("AdelieHomeCategoryPage", 1, this + "onLoadMoreStart");
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.i("AdelieHomeCategoryPage", 1, "onPartDestroy:" + this);
        this.K.removeObserver(this.L);
        this.f365981i.onAdapterDestroyed(this.f365978e);
        this.f365981i.unRegisterLoadMoreListener(this);
        this.f365979f.removeAdapter(this.f365981i);
        this.f365979f.removeAdapter(this.f365980h);
        this.f365981i = null;
        this.f365980h = null;
        this.f365979f = null;
        this.f365978e.removeItemDecoration(this.C);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.f365978e.getLayoutManager();
        if (gridLayoutManager != null) {
            gridLayoutManager.setSpanSizeLookup(null);
        }
        this.f365978e.setLayoutManager(null);
        this.f365978e.setAdapter(null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.i("AdelieHomeCategoryPage", 1, "onPagePause:" + this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i("AdelieHomeCategoryPage", 1, "onPageResume:" + this);
    }

    public String toString() {
        return "[" + this.f365977d.name + "] ";
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean z16) {
    }
}
