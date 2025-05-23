package l20;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.aioshare.QFSAIOSendDataManager;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.widgets.QFSPageTabBar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Ll20/e;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$l;", "", "D9", "initHalfScreenView", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getLogTag", "", "onBackEvent", "v", NodeProps.ON_CLICK, "onDismiss", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "d", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mHalfScreenView", "e", "Landroid/view/View;", "mContentView", "Lcom/tencent/biz/qqcircle/widgets/QFSPageTabBar;", "f", "Lcom/tencent/biz/qqcircle/widgets/QFSPageTabBar;", "mPageTabBar", "Landroidx/viewpager2/widget/ViewPager2;", h.F, "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager", "<init>", "()V", "i", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends u implements View.OnClickListener, QUSBaseHalfScreenFloatingView.l {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenFloatingView mHalfScreenView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QFSPageTabBar mPageTabBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 mViewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String[] f413711m = {"\u8d5e\u8fc7", "\u63a8\u8fc7", "\u6536\u85cf", "\u4f5c\u54c1", "\u770b\u8fc7"};

    @NotNull
    private static final String[] C = {"\u8d5e\u8fc7", "\u6536\u85cf", "\u770b\u8fc7"};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Ll20/e$a;", "", "", "", "ARRAY_TAB", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "ARRAY_TAB_TEENAGE", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: l20.e$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] a() {
            return e.f413711m;
        }

        @NotNull
        public final String[] b() {
            return e.C;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"l20/e$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF52508d() {
            ViewGroup viewGroup;
            e eVar = e.this;
            LayoutInflater from = LayoutInflater.from(eVar.getContext());
            View partRootView = e.this.getPartRootView();
            if (partRootView instanceof ViewGroup) {
                viewGroup = (ViewGroup) partRootView;
            } else {
                viewGroup = null;
            }
            View inflate = from.inflate(R.layout.g7s, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026iew as? ViewGroup, false)");
            eVar.mContentView = inflate;
            View view = e.this.mContentView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                return null;
            }
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    private final void C9() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mHalfScreenView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
    }

    private final void D9() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mHalfScreenView;
        ViewPager2 viewPager2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView = null;
        }
        View findViewById = qUSHalfScreenFloatingView.findViewById(R.id.f220702q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mHalfScreenView.findViewById(R.id.page_tabbar)");
        this.mPageTabBar = (QFSPageTabBar) findViewById;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mHalfScreenView;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView2 = null;
        }
        View findViewById2 = qUSHalfScreenFloatingView2.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mHalfScreenView.findViewById(R.id.view_pager)");
        this.mViewPager = (ViewPager2) findViewById2;
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QFSPageTabBar qFSPageTabBar = this.mPageTabBar;
            if (qFSPageTabBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPageTabBar");
                qFSPageTabBar = null;
            }
            qFSPageTabBar.setTabData(C);
        } else {
            QFSPageTabBar qFSPageTabBar2 = this.mPageTabBar;
            if (qFSPageTabBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPageTabBar");
                qFSPageTabBar2 = null;
            }
            qFSPageTabBar2.setTabData(f413711m);
        }
        QFSBaseFragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        com.tencent.biz.qqcircle.aioshare.a aVar = new com.tencent.biz.qqcircle.aioshare.a(hostFragment);
        ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager22 = null;
        }
        viewPager22.setAdapter(aVar);
        ViewPager2 viewPager23 = this.mViewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager23 = null;
        }
        viewPager23.setOffscreenPageLimit(2);
        QFSPageTabBar qFSPageTabBar3 = this.mPageTabBar;
        if (qFSPageTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageTabBar");
            qFSPageTabBar3 = null;
        }
        ViewPager2 viewPager24 = this.mViewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPager2 = viewPager24;
        }
        qFSPageTabBar3.bindViewPager2(viewPager2);
    }

    private final void initHalfScreenView() {
        View findViewById = getPartRootView().findViewById(R.id.x5m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lf_screen_aio_feed_share)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        this.mHalfScreenView = qUSHalfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(false);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mHalfScreenView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.q();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mHalfScreenView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setQUSDragFloatController(new b());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.mHalfScreenView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView5;
        }
        qUSHalfScreenFloatingView2.setOnDismissListener(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAIOFeedShareContentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        C9();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f167033k60) {
            C9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RFWLog.d("QFSAIOFeedShareContentPart", RFWLog.USR, "onConfigurationChanged");
        QFSPageTabBar qFSPageTabBar = this.mPageTabBar;
        if (qFSPageTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageTabBar");
            qFSPageTabBar = null;
        }
        qFSPageTabBar.onConfigurationChanged(configuration);
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
    public void onDismiss() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
        QFSAIOSendDataManager.f82679a.d();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initHalfScreenView();
        D9();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mHalfScreenView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.findViewById(R.id.f167033k60).setOnClickListener(this);
    }
}
