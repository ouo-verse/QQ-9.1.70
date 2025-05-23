package com.tencent.now.linkpkanchorplay.mainpage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.app.common.widget.BaseViewPager;
import com.tencent.now.app.common.widget.NewPagerSlidingTabStrip;
import com.tencent.now.linkpkanchorplay.event.LinkPKWebEvent;
import com.tencent.now.linkpkanchorplay.event.MainPageTabChangeEvent;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.mainpage.model.LinkPKTabData;
import com.tencent.now.linkpkanchorplay.mainpage.view.NewLinkAndPKInviteTabView;
import com.tencent.now.linkpkanchorplay.setting.view.SettingDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qm3.d;
import sm3.a;
import tl.h;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001?B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b7\u00108B\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b7\u0010;B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010<\u001a\u00020\t\u00a2\u0006\u0004\b7\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J&\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0002H\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R \u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020302018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006@"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/NewLinkAndPKInviteTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "H0", "I0", "", "sp", "Landroid/content/Context;", "context", "", "K0", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "J0", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "settingTv", "e", "ruleTv", "Lcom/tencent/now/app/common/widget/NewPagerSlidingTabStrip;", "f", "Lcom/tencent/now/app/common/widget/NewPagerSlidingTabStrip;", "titleTab", "Lcom/tencent/now/app/common/widget/BaseViewPager;", h.F, "Lcom/tencent/now/app/common/widget/BaseViewPager;", "tabViewPager", "Lqm3/d;", "i", "Lqm3/d;", "tabViewAdapter", "Lsm3/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lsm3/a;", "tabViewModel", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "D", "Landroidx/lifecycle/ViewModelProvider;", "E", "Lcom/tencent/now/linkpkanchorplay/event/b;", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/Observer;", "dataObserver", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NewLinkAndPKInviteTabView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewModelProvider viewModelProvider;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.now.linkpkanchorplay.event.b eventTrigger;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<LinkPKTabData>> dataObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView settingTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView ruleTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private NewPagerSlidingTabStrip titleTab;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BaseViewPager tabViewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private d tabViewAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private a tabViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewLinkAndPKInviteTabView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.fed, this);
        View findViewById = findViewById(R.id.f98145ma);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip = (NewPagerSlidingTabStrip) findViewById;
        newPagerSlidingTabStrip.setIndicatorWidth((int) newPagerSlidingTabStrip.getContext().getResources().getDimension(R.dimen.f158654c82));
        newPagerSlidingTabStrip.setIndicatorHeight((int) newPagerSlidingTabStrip.getContext().getResources().getDimension(R.dimen.f158652c80));
        newPagerSlidingTabStrip.setIndicatorColor(-1);
        newPagerSlidingTabStrip.setTabPaddingLeftRight(AppUtils.UI.dip2px(12.5f));
        newPagerSlidingTabStrip.setIndictorBottomMargin(0);
        newPagerSlidingTabStrip.setTextColor(-1);
        newPagerSlidingTabStrip.setUnSelectedTextColor(2063597567);
        newPagerSlidingTabStrip.setTabBackground(R.drawable.f160907jv4);
        Context context2 = newPagerSlidingTabStrip.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        newPagerSlidingTabStrip.setTextSize(K0(14.0f, context2));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<NewPagerSli\u2026x(14f,context);\n        }");
        this.titleTab = newPagerSlidingTabStrip;
        View findViewById2 = findViewById(R.id.yj7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.link_setting)");
        TextView textView = (TextView) findViewById2;
        this.settingTv = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: qm3.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewLinkAndPKInviteTabView.C0(NewLinkAndPKInviteTabView.this, view);
            }
        });
        View findViewById3 = findViewById(R.id.yj5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.link_rule)");
        TextView textView2 = (TextView) findViewById3;
        this.ruleTv = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: qm3.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewLinkAndPKInviteTabView.D0(view);
            }
        });
        this.dataObserver = new Observer() { // from class: qm3.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewLinkAndPKInviteTabView.G0(NewLinkAndPKInviteTabView.this, (List) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(NewLinkAndPKInviteTabView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        SettingDialog a16 = cn3.a.a((FragmentActivity) context);
        com.tencent.now.linkpkanchorplay.event.b bVar = this$0.eventTrigger;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTrigger");
            bVar = null;
        }
        a16.sh(bVar);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCenter.post(new LinkPKWebEvent("https://m.xsj.qq.com/operation/xsj-act/activity/page?id=ff95e2f877f6d450a9dcc9396e755c57&_wv=1", null, 2, null));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(NewLinkAndPKInviteTabView this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.tabViewAdapter;
        BaseViewPager baseViewPager = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewAdapter");
            dVar = null;
        }
        BaseViewPager baseViewPager2 = this$0.tabViewPager;
        if (baseViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager");
        } else {
            baseViewPager = baseViewPager2;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        dVar.f(baseViewPager, it);
        this$0.titleTab.l();
    }

    private final void H0() {
        ViewModelProvider viewModelProvider = this.viewModelProvider;
        LifecycleOwner lifecycleOwner = null;
        if (viewModelProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
            viewModelProvider = null;
        }
        ViewModel viewModel = viewModelProvider.get(a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModelProvider.get(Li\u2026TabViewModel::class.java)");
        a aVar = (a) viewModel;
        this.tabViewModel = aVar;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewModel");
            aVar = null;
        }
        MutableLiveData<List<LinkPKTabData>> M1 = aVar.M1();
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        if (lifecycleOwner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        } else {
            lifecycleOwner = lifecycleOwner2;
        }
        M1.observe(lifecycleOwner, this.dataObserver);
    }

    private final void I0() {
        a aVar = this.tabViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewModel");
            aVar = null;
        }
        aVar.N1();
    }

    private final int K0(float sp5, Context context) {
        return (int) TypedValue.applyDimension(2, sp5, context.getResources().getDisplayMetrics());
    }

    public final void J0(@NotNull com.tencent.now.linkpkanchorplay.event.b eventTrigger, @NotNull ViewModelProvider viewModelProvider, @NotNull LifecycleOwner lifecycleOwner, @NotNull AnchorTabPageContext pageContext) {
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.lifecycleOwner = lifecycleOwner;
        this.viewModelProvider = viewModelProvider;
        this.eventTrigger = eventTrigger;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.tabViewAdapter = new d(eventTrigger, context, pageContext, viewModelProvider, lifecycleOwner, new ArrayList());
        View findViewById = findViewById(R.id.f916255o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<BaseViewPager>(R.id.tabViewPager)");
        BaseViewPager baseViewPager = (BaseViewPager) findViewById;
        this.tabViewPager = baseViewPager;
        BaseViewPager baseViewPager2 = null;
        if (baseViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager");
            baseViewPager = null;
        }
        d dVar = this.tabViewAdapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewAdapter");
            dVar = null;
        }
        baseViewPager.setAdapter(dVar);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip = this.titleTab;
        BaseViewPager baseViewPager3 = this.tabViewPager;
        if (baseViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager");
            baseViewPager3 = null;
        }
        newPagerSlidingTabStrip.setViewPager(baseViewPager3);
        BaseViewPager baseViewPager4 = this.tabViewPager;
        if (baseViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager");
        } else {
            baseViewPager2 = baseViewPager4;
        }
        baseViewPager2.addOnPageChangeListener(new b());
        H0();
        I0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.tabViewModel;
        BaseViewPager baseViewPager = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewModel");
            aVar = null;
        }
        BaseViewPager baseViewPager2 = this.tabViewPager;
        if (baseViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager");
        } else {
            baseViewPager = baseViewPager2;
        }
        aVar.O1(baseViewPager.getCurrentItem());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewLinkAndPKInviteTabView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.fed, this);
        View findViewById = findViewById(R.id.f98145ma);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip = (NewPagerSlidingTabStrip) findViewById;
        newPagerSlidingTabStrip.setIndicatorWidth((int) newPagerSlidingTabStrip.getContext().getResources().getDimension(R.dimen.f158654c82));
        newPagerSlidingTabStrip.setIndicatorHeight((int) newPagerSlidingTabStrip.getContext().getResources().getDimension(R.dimen.f158652c80));
        newPagerSlidingTabStrip.setIndicatorColor(-1);
        newPagerSlidingTabStrip.setTabPaddingLeftRight(AppUtils.UI.dip2px(12.5f));
        newPagerSlidingTabStrip.setIndictorBottomMargin(0);
        newPagerSlidingTabStrip.setTextColor(-1);
        newPagerSlidingTabStrip.setUnSelectedTextColor(2063597567);
        newPagerSlidingTabStrip.setTabBackground(R.drawable.f160907jv4);
        Context context2 = newPagerSlidingTabStrip.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        newPagerSlidingTabStrip.setTextSize(K0(14.0f, context2));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<NewPagerSli\u2026x(14f,context);\n        }");
        this.titleTab = newPagerSlidingTabStrip;
        View findViewById2 = findViewById(R.id.yj7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.link_setting)");
        TextView textView = (TextView) findViewById2;
        this.settingTv = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: qm3.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewLinkAndPKInviteTabView.C0(NewLinkAndPKInviteTabView.this, view);
            }
        });
        View findViewById3 = findViewById(R.id.yj5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.link_rule)");
        TextView textView2 = (TextView) findViewById3;
        this.ruleTv = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: qm3.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewLinkAndPKInviteTabView.D0(view);
            }
        });
        this.dataObserver = new Observer() { // from class: qm3.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewLinkAndPKInviteTabView.G0(NewLinkAndPKInviteTabView.this, (List) obj);
            }
        };
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/now/linkpkanchorplay/mainpage/view/NewLinkAndPKInviteTabView$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            zm3.a aVar = zm3.a.f452778a;
            d dVar = NewLinkAndPKInviteTabView.this.tabViewAdapter;
            BaseViewPager baseViewPager = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabViewAdapter");
                dVar = null;
            }
            List<LinkPKTabData> e16 = dVar.e();
            BaseViewPager baseViewPager2 = NewLinkAndPKInviteTabView.this.tabViewPager;
            if (baseViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabViewPager");
                baseViewPager2 = null;
            }
            aVar.g(e16.get(baseViewPager2.getCurrentItem()).getTabID());
            d dVar2 = NewLinkAndPKInviteTabView.this.tabViewAdapter;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabViewAdapter");
                dVar2 = null;
            }
            List<LinkPKTabData> e17 = dVar2.e();
            BaseViewPager baseViewPager3 = NewLinkAndPKInviteTabView.this.tabViewPager;
            if (baseViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabViewPager");
            } else {
                baseViewPager = baseViewPager3;
            }
            EventCenter.post(new MainPageTabChangeEvent(e17.get(baseViewPager.getCurrentItem()).getTabID()));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewLinkAndPKInviteTabView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.fed, this);
        View findViewById = findViewById(R.id.f98145ma);
        NewPagerSlidingTabStrip newPagerSlidingTabStrip = (NewPagerSlidingTabStrip) findViewById;
        newPagerSlidingTabStrip.setIndicatorWidth((int) newPagerSlidingTabStrip.getContext().getResources().getDimension(R.dimen.f158654c82));
        newPagerSlidingTabStrip.setIndicatorHeight((int) newPagerSlidingTabStrip.getContext().getResources().getDimension(R.dimen.f158652c80));
        newPagerSlidingTabStrip.setIndicatorColor(-1);
        newPagerSlidingTabStrip.setTabPaddingLeftRight(AppUtils.UI.dip2px(12.5f));
        newPagerSlidingTabStrip.setIndictorBottomMargin(0);
        newPagerSlidingTabStrip.setTextColor(-1);
        newPagerSlidingTabStrip.setUnSelectedTextColor(2063597567);
        newPagerSlidingTabStrip.setTabBackground(R.drawable.f160907jv4);
        Context context2 = newPagerSlidingTabStrip.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        newPagerSlidingTabStrip.setTextSize(K0(14.0f, context2));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<NewPagerSli\u2026x(14f,context);\n        }");
        this.titleTab = newPagerSlidingTabStrip;
        View findViewById2 = findViewById(R.id.yj7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.link_setting)");
        TextView textView = (TextView) findViewById2;
        this.settingTv = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: qm3.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewLinkAndPKInviteTabView.C0(NewLinkAndPKInviteTabView.this, view);
            }
        });
        View findViewById3 = findViewById(R.id.yj5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.link_rule)");
        TextView textView2 = (TextView) findViewById3;
        this.ruleTv = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: qm3.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewLinkAndPKInviteTabView.D0(view);
            }
        });
        this.dataObserver = new Observer() { // from class: qm3.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewLinkAndPKInviteTabView.G0(NewLinkAndPKInviteTabView.this, (List) obj);
            }
        };
    }
}
