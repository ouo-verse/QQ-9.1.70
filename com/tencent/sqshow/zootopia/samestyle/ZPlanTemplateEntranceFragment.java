package com.tencent.sqshow.zootopia.samestyle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateEntranceFragment$templateTabSelectedListener$2;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateGridFragment;
import com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;
import com.tencent.state.report.SquareReportConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 R2\u00020\u0001:\u0002STB\u0007\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0012\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010&\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u0002H\u0016R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020.0\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\u00a8\u0006U"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateEntranceFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Eh", "initTitleBar", "Dh", "Fh", "initViewModel", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "cats", "Ah", "cat", "Landroid/view/View;", "yh", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$f;", "tab", "Jh", "Kh", "Mh", "Ch", "Landroid/content/Context;", "context", "Lh", UIJsPlugin.EVENT_HIDE_LOADING, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "xh", "Ih", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", "", "onBackEvent", "onResume", "onDestroyView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "templateCats", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment;", "D", "templateGridFragments", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "E", "Lcom/tencent/mobileqq/widget/TabLayoutCompat;", "tabLayout", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "viewPager", "G", "Landroid/view/View;", "networkErrorPage", "H", "btnRetry", "Landroid/app/Dialog;", "I", "Landroid/app/Dialog;", "progressDialog", "Lcom/tencent/sqshow/zootopia/samestyle/TemplateEntranceViewModel;", "J", "Lcom/tencent/sqshow/zootopia/samestyle/TemplateEntranceViewModel;", "viewModel", "Lid3/d;", "K", "Lid3/d;", "reporter", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$c;", "L", "Lkotlin/Lazy;", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/widget/TabLayoutCompat$c;", "templateTabSelectedListener", "<init>", "()V", "M", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTemplateEntranceFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private List<ZPlanTemplateCat> templateCats;

    /* renamed from: D, reason: from kotlin metadata */
    private List<ZPlanTemplateGridFragment> templateGridFragments;

    /* renamed from: E, reason: from kotlin metadata */
    private TabLayoutCompat tabLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private ViewPagerCompat viewPager;

    /* renamed from: G, reason: from kotlin metadata */
    private View networkErrorPage;

    /* renamed from: H, reason: from kotlin metadata */
    private View btnRetry;

    /* renamed from: I, reason: from kotlin metadata */
    private Dialog progressDialog;

    /* renamed from: J, reason: from kotlin metadata */
    private TemplateEntranceViewModel viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private final id3.d reporter;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy templateTabSelectedListener;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateEntranceFragment$b;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "position", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment;", "d", "getCount", "", "Ljava/util/List;", "getFragments", "()Ljava/util/List;", "fragments", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Ljava/util/List;Landroidx/fragment/app/FragmentManager;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends FragmentPagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final List<ZPlanTemplateGridFragment> fragments;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List<ZPlanTemplateGridFragment> fragments, FragmentManager fm5) {
            super(fm5);
            Intrinsics.checkNotNullParameter(fragments, "fragments");
            Intrinsics.checkNotNullParameter(fm5, "fm");
            this.fragments = fragments;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ZPlanTemplateGridFragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.fragments.size();
        }
    }

    public ZPlanTemplateEntranceFragment() {
        List<ZPlanTemplateCat> emptyList;
        List<ZPlanTemplateGridFragment> emptyList2;
        Lazy lazy;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.templateCats = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.templateGridFragments = emptyList2;
        this.reporter = new id3.d(null, 1, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanTemplateEntranceFragment$templateTabSelectedListener$2.a>() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateEntranceFragment$templateTabSelectedListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/ZPlanTemplateEntranceFragment$templateTabSelectedListener$2$a", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$c;", "Lcom/tencent/mobileqq/widget/TabLayoutCompat$f;", "tab", "", "J8", "l3", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements TabLayoutCompat.c {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ZPlanTemplateEntranceFragment f372829d;

                a(ZPlanTemplateEntranceFragment zPlanTemplateEntranceFragment) {
                    this.f372829d = zPlanTemplateEntranceFragment;
                }

                @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
                public void J8(TabLayoutCompat.f tab) {
                    this.f372829d.Jh(tab);
                }

                @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
                public void l3(TabLayoutCompat.f tab) {
                    this.f372829d.Kh(tab);
                }

                @Override // com.tencent.mobileqq.widget.TabLayoutCompat.c
                public void c(TabLayoutCompat.f tab) {
                    View b16;
                    id3.d dVar;
                    ViewPagerCompat viewPagerCompat;
                    if (tab != null) {
                        viewPagerCompat = this.f372829d.viewPager;
                        if (viewPagerCompat == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                            viewPagerCompat = null;
                        }
                        viewPagerCompat.setCurrentItem(tab.d(), false);
                    }
                    this.f372829d.Jh(tab);
                    if (tab == null || (b16 = tab.b()) == null) {
                        return;
                    }
                    dVar = this.f372829d.reporter;
                    dVar.c("dt_clck", b16, new LinkedHashMap());
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(ZPlanTemplateEntranceFragment.this);
            }
        });
        this.templateTabSelectedListener = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(ZPlanTemplateEntranceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPagerCompat viewPagerCompat = this$0.viewPager;
        TabLayoutCompat tabLayoutCompat = null;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat = null;
        }
        viewPagerCompat.setCurrentItem(0);
        TabLayoutCompat tabLayoutCompat2 = this$0.tabLayout;
        if (tabLayoutCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            tabLayoutCompat = tabLayoutCompat2;
        }
        TabLayoutCompat.f z16 = tabLayoutCompat.z(0);
        if (z16 != null) {
            z16.j();
        }
    }

    private final void Ch() {
        View view = this.networkErrorPage;
        ViewPagerCompat viewPagerCompat = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkErrorPage");
            view = null;
        }
        view.setVisibility(8);
        TabLayoutCompat tabLayoutCompat = this.tabLayout;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat = null;
        }
        tabLayoutCompat.setVisibility(0);
        ViewPagerCompat viewPagerCompat2 = this.viewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPagerCompat = viewPagerCompat2;
        }
        viewPagerCompat.setVisibility(0);
    }

    private final void Dh() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qyp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026.vpZplanTemplateEntrance)");
        this.viewPager = (ViewPagerCompat) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163557qs0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026.tlZplanTemplateEntrance)");
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById2;
        this.tabLayout = tabLayoutCompat;
        TabLayoutCompat tabLayoutCompat2 = null;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat = null;
        }
        ViewPagerCompat viewPagerCompat = this.viewPager;
        if (viewPagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPagerCompat = null;
        }
        tabLayoutCompat.setupWithViewPager(viewPagerCompat);
        TabLayoutCompat tabLayoutCompat3 = this.tabLayout;
        if (tabLayoutCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat3 = null;
        }
        tabLayoutCompat3.setTabMode(0);
        TabLayoutCompat tabLayoutCompat4 = this.tabLayout;
        if (tabLayoutCompat4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat4 = null;
        }
        tabLayoutCompat4.setTabGravity(1);
        TabLayoutCompat tabLayoutCompat5 = this.tabLayout;
        if (tabLayoutCompat5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            tabLayoutCompat2 = tabLayoutCompat5;
        }
        tabLayoutCompat2.g(zh());
    }

    private final void Eh() {
        if (h.b(getArguments())) {
            h.a(this.f211174vg);
            h.c(getContext());
        }
    }

    private final void Fh() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.q_c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.network_error_page)");
        this.networkErrorPage = findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.pge);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.btn_retry)");
        this.btnRetry = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRetry");
            findViewById2 = null;
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTemplateEntranceFragment.Gh(ZPlanTemplateEntranceFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(final ZPlanTemplateEntranceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.networkErrorPage;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkErrorPage");
            view2 = null;
        }
        view2.setVisibility(8);
        TemplateEntranceViewModel templateEntranceViewModel = this$0.viewModel;
        if (templateEntranceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templateEntranceViewModel = null;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        templateEntranceViewModel.O1((AppInterface) waitAppRuntime, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateEntranceFragment$initNetworkErrorPage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanTemplateEntranceFragment zPlanTemplateEntranceFragment = ZPlanTemplateEntranceFragment.this;
                Context requireContext = zPlanTemplateEntranceFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                zPlanTemplateEntranceFragment.Lh(requireContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(ZPlanTemplateEntranceFragment this$0, List cats) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideLoading();
        Intrinsics.checkNotNullExpressionValue(cats, "cats");
        this$0.Ah(cats);
    }

    private final void Ih(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(-1);
        activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 8192);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(TabLayoutCompat.f tab) {
        int size = this.templateCats.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            TabLayoutCompat tabLayoutCompat = this.tabLayout;
            if (tabLayoutCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                tabLayoutCompat = null;
            }
            TabLayoutCompat.f z16 = tabLayoutCompat.z(i3);
            if (z16 != null) {
                boolean areEqual = Intrinsics.areEqual(z16, tab);
                View b16 = z16.b();
                TextView textView = b16 != null ? (TextView) b16.findViewById(R.id.f163559qs2) : null;
                View b17 = z16.b();
                View findViewById = b17 != null ? b17.findViewById(R.id.f163558qs1) : null;
                if (areEqual) {
                    View b18 = z16.b();
                    ZPlanRedDotView zPlanRedDotView = b18 != null ? (ZPlanRedDotView) b18.findViewById(R.id.qrz) : null;
                    if (zPlanRedDotView != null) {
                        zPlanRedDotView.setVisibility(4);
                    }
                    Object tag = zPlanRedDotView != null ? zPlanRedDotView.getTag() : null;
                    ZPlanTemplateCat zPlanTemplateCat = tag instanceof ZPlanTemplateCat ? (ZPlanTemplateCat) tag : null;
                    if (zPlanTemplateCat != null) {
                        ZPlanRedDotManager.f373437a.h(zPlanTemplateCat.getId().longValue());
                    }
                }
                if (textView != null) {
                    textView.setTextColor(textView.getResources().getColorStateList(areEqual ? R.color.b9l : R.color.black));
                    textView.setTypeface(null, areEqual ? 1 : 0);
                }
                if (findViewById != null) {
                    findViewById.setVisibility(areEqual ? 0 : 8);
                }
            }
            i3++;
        }
        Object f16 = tab != null ? tab.f() : null;
        ZPlanTemplateGridFragment zPlanTemplateGridFragment = f16 instanceof ZPlanTemplateGridFragment ? (ZPlanTemplateGridFragment) f16 : null;
        if (zPlanTemplateGridFragment != null) {
            zPlanTemplateGridFragment.onShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(Context context) {
        QLog.d("ZPlanSameStyle_ZPlanTemplateEntranceFragment", 1, "show loading " + this.progressDialog);
        if (this.progressDialog == null) {
            Dialog dialog = new Dialog(context, R.style.qZoneInputDialog);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.f168383uh);
            this.progressDialog = dialog;
        }
        Dialog dialog2 = this.progressDialog;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    private final void Mh() {
        View view = this.networkErrorPage;
        ViewPagerCompat viewPagerCompat = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkErrorPage");
            view = null;
        }
        view.setVisibility(0);
        TabLayoutCompat tabLayoutCompat = this.tabLayout;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat = null;
        }
        tabLayoutCompat.setVisibility(8);
        ViewPagerCompat viewPagerCompat2 = this.viewPager;
        if (viewPagerCompat2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPagerCompat = viewPagerCompat2;
        }
        viewPagerCompat.setVisibility(8);
    }

    private final void hideLoading() {
        QLog.d("ZPlanSameStyle_ZPlanTemplateEntranceFragment", 1, "hideLoading " + this.progressDialog);
        Dialog dialog = this.progressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void initTitleBar() {
        this.f211174vg.changeBg(true);
        this.f211174vg.setTitle(getString(R.string.xt7));
    }

    private final void initViewModel() {
        TemplateEntranceViewModel templateEntranceViewModel = this.viewModel;
        if (templateEntranceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templateEntranceViewModel = null;
        }
        templateEntranceViewModel.Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.sqshow.zootopia.samestyle.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanTemplateEntranceFragment.Hh(ZPlanTemplateEntranceFragment.this, (List) obj);
            }
        });
        TemplateEntranceViewModel templateEntranceViewModel2 = this.viewModel;
        if (templateEntranceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            templateEntranceViewModel2 = null;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        templateEntranceViewModel2.O1((AppInterface) waitAppRuntime, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateEntranceFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanTemplateEntranceFragment zPlanTemplateEntranceFragment = ZPlanTemplateEntranceFragment.this;
                Context requireContext = zPlanTemplateEntranceFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                zPlanTemplateEntranceFragment.Lh(requireContext);
            }
        });
    }

    private final void xh(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(1792);
    }

    private final View yh(ZPlanTemplateCat cat) {
        LayoutInflater layoutInflater = getLayoutInflater();
        TabLayoutCompat tabLayoutCompat = this.tabLayout;
        if (tabLayoutCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayoutCompat = null;
        }
        View inflate = layoutInflater.inflate(R.layout.f167394d31, (ViewGroup) tabLayoutCompat, false);
        ((TextView) inflate.findViewById(R.id.f163559qs2)).setText(cat.getName());
        View findViewById = inflate.findViewById(R.id.qrz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ZPlanRedDotView>(R.id.tlReddot)");
        ZPlanRedDotView zPlanRedDotView = (ZPlanRedDotView) findViewById;
        zPlanRedDotView.setTag(cat);
        zPlanRedDotView.n(cat.getReddotMsg().f417682a != 1 ? cat.getReddotMsg().f417682a : 0);
        if (cat.getReddotMsg().f417682a > 0) {
            zPlanRedDotView.setVisibility(0);
        } else {
            zPlanRedDotView.setVisibility(4);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(\n\u2026E\n            }\n        }");
        return inflate;
    }

    private final TabLayoutCompat.c zh() {
        return (TabLayoutCompat.c) this.templateTabSelectedListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        QLog.i("ZPlanSameStyle_ZPlanTemplateEntranceFragment", 4, "doOnCreateView");
        initTitleBar();
        Dh();
        Fh();
        initViewModel();
        Eh();
        ZPlanSameStyleResHelper.l(ZPlanSameStyleResHelper.f372974a, "ZPlanSameStyle_ZPlanTemplateEntranceFragment", null, 2, null);
        id3.d dVar = this.reporter;
        RelativeLayout titleRoot = this.titleRoot;
        Intrinsics.checkNotNullExpressionValue(titleRoot, "titleRoot");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE) : null;
        ZootopiaSource zootopiaSource = serializable instanceof ZootopiaSource ? (ZootopiaSource) serializable : null;
        if (zootopiaSource != null) {
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, com.tencent.sqshow.zootopia.utils.ah.b(zootopiaSource));
        }
        Unit unit = Unit.INSTANCE;
        dVar.j(this, titleRoot, "pg_zplan_samestyle_gallery", linkedHashMap);
        id3.d dVar2 = this.reporter;
        ImageView mLeftBackIcon = this.mLeftBackIcon;
        Intrinsics.checkNotNullExpressionValue(mLeftBackIcon, "mLeftBackIcon");
        id3.d.h(dVar2, mLeftBackIcon, "em_zplan_back_btn", new LinkedHashMap(), false, true, null, 40, null);
        id3.d dVar3 = this.reporter;
        ImageView mLeftBackIcon2 = this.mLeftBackIcon;
        Intrinsics.checkNotNullExpressionValue(mLeftBackIcon2, "mLeftBackIcon");
        dVar3.c("dt_imp", mLeftBackIcon2, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167393d30;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        id3.d dVar = this.reporter;
        ImageView mLeftBackIcon = this.mLeftBackIcon;
        Intrinsics.checkNotNullExpressionValue(mLeftBackIcon, "mLeftBackIcon");
        dVar.c("dt_clck", mLeftBackIcon, new LinkedHashMap());
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(TemplateEntranceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026nceViewModel::class.java]");
        this.viewModel = (TemplateEntranceViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        hideLoading();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("ZPlanSameStyle_ZPlanTemplateEntranceFragment", 4, "onResume");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        xh(requireActivity);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        Ih(requireActivity2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(TabLayoutCompat.f tab) {
        Object f16 = tab != null ? tab.f() : null;
        ZPlanTemplateGridFragment zPlanTemplateGridFragment = f16 instanceof ZPlanTemplateGridFragment ? (ZPlanTemplateGridFragment) f16 : null;
        if (zPlanTemplateGridFragment != null) {
            zPlanTemplateGridFragment.Yh();
        }
    }

    private final void Ah(List<ZPlanTemplateCat> cats) {
        int collectionSizeOrDefault;
        Object orNull;
        List<ZPlanTemplateGridFragment> list = this.templateGridFragments;
        this.templateCats = cats;
        List<ZPlanTemplateCat> list2 = cats;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ZPlanTemplateCat zPlanTemplateCat = (ZPlanTemplateCat) it.next();
            ZPlanTemplateGridFragment.Companion companion = ZPlanTemplateGridFragment.INSTANCE;
            Bundle arguments = getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE) : null;
            ZootopiaSource zootopiaSource = serializable instanceof ZootopiaSource ? (ZootopiaSource) serializable : null;
            arrayList.add(ZPlanTemplateGridFragment.Companion.b(companion, zPlanTemplateCat, zootopiaSource == null ? new ZootopiaSource(ZootopiaSource.INSTANCE.h(getArguments()), "", null, 4, null) : zootopiaSource, null, null, 12, null));
        }
        this.templateGridFragments = arrayList;
        if (this.templateCats.isEmpty()) {
            Mh();
            ViewPagerCompat viewPagerCompat = this.viewPager;
            if (viewPagerCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPagerCompat = null;
            }
            viewPagerCompat.setAdapter(null);
        } else {
            Ch();
            ViewPagerCompat viewPagerCompat2 = this.viewPager;
            if (viewPagerCompat2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPagerCompat2 = null;
            }
            List<ZPlanTemplateGridFragment> list3 = this.templateGridFragments;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            viewPagerCompat2.setAdapter(new b(list3, childFragmentManager));
            int i3 = 0;
            for (Object obj : this.templateCats) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ZPlanTemplateCat zPlanTemplateCat2 = (ZPlanTemplateCat) obj;
                TabLayoutCompat tabLayoutCompat = this.tabLayout;
                if (tabLayoutCompat == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                    tabLayoutCompat = null;
                }
                TabLayoutCompat.f z16 = tabLayoutCompat.z(i3);
                if (z16 != null) {
                    View yh5 = yh(zPlanTemplateCat2);
                    z16.m(yh5);
                    orNull = CollectionsKt___CollectionsKt.getOrNull(this.templateGridFragments, i3);
                    z16.o(orNull);
                    Object parent = yh5 != null ? yh5.getParent() : null;
                    if ((parent instanceof View ? (View) parent : null) != null) {
                        id3.d dVar = this.reporter;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        linkedHashMap.put("zplan_tab_id", zPlanTemplateCat2.getId());
                        linkedHashMap.put("zplan_tab_name", zPlanTemplateCat2.getName());
                        Unit unit = Unit.INSTANCE;
                        id3.d.h(dVar, yh5, "em_zplan_tab_btn", linkedHashMap, false, true, null, 40, null);
                    }
                }
                i3 = i16;
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanTemplateEntranceFragment.Bh(ZPlanTemplateEntranceFragment.this);
                    }
                });
            }
        }
        try {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                beginTransaction.remove((ZPlanTemplateGridFragment) it5.next());
            }
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception unused) {
        }
    }
}
