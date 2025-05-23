package com.tencent.mobileqq.troop.troopnotification.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.TroopNotificationTabBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0016\u0010F\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010?R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020H0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initNavBar", "Vh", "Lh", "", "tabVisibility", "Th", "Uh", "", "tabIndex", "Yh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Jh", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "D", "Kh", "()Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "vm", "Lts2/a;", "E", "Lts2/a;", "viewBinding", UserInfo.SEX_FEMALE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "G", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "H", "Landroid/view/ViewGroup;", "contentView", "Lcom/tencent/mobileqq/widget/TroopNotificationTabBar;", "I", "Lcom/tencent/mobileqq/widget/TroopNotificationTabBar;", "tabBar", "Landroidx/viewpager2/widget/ViewPager2;", "J", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/e;", "K", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/e;", "fragmentAdapter", "", "L", "Z", "hadSetAdapter", "M", "showingClear", "N", "showingEmpty", "P", "hadInitFirstTab", "", "Lcom/tencent/mobileqq/troop/troopnotification/vm/processor/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/List;", "categoryProcessor", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationListFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: E, reason: from kotlin metadata */
    private ts2.a viewBinding;

    /* renamed from: F, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private QUISecNavBar navBar;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewGroup contentView;

    /* renamed from: I, reason: from kotlin metadata */
    private TroopNotificationTabBar tabBar;

    /* renamed from: J, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopnotification.adapter.e fragmentAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean hadSetAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean showingClear;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean showingEmpty;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hadInitFirstTab;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.troopnotification.vm.processor.d> categoryProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListFragment$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationListFragment.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            QUISecNavBar qUISecNavBar = null;
            if (position != 0 || !TroopNotificationListFragment.this.showingClear) {
                QUISecNavBar qUISecNavBar2 = TroopNotificationListFragment.this.navBar;
                if (qUISecNavBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navBar");
                } else {
                    qUISecNavBar = qUISecNavBar2;
                }
                qUISecNavBar.setRightText("");
                return;
            }
            QUISecNavBar qUISecNavBar3 = TroopNotificationListFragment.this.navBar;
            if (qUISecNavBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBar");
            } else {
                qUISecNavBar = qUISecNavBar3;
            }
            qUISecNavBar.setRightText(TroopNotificationListFragment.this.requireActivity().getResources().getString(R.string.f1788437r));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationListFragment() {
        Lazy lazy;
        Lazy lazy2;
        List<com.tencent.mobileqq.troop.troopnotification.vm.processor.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new TroopNotificationListFragment$emptyView$2(this));
            this.emptyView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopNotificationListVM>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopNotificationListVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? TroopNotificationListVM.INSTANCE.a(TroopNotificationListFragment.this) : (TroopNotificationListVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy2;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.troop.troopnotification.vm.processor.d[]{new com.tencent.mobileqq.troop.troopnotification.vm.processor.a(), new com.tencent.mobileqq.troop.troopnotification.vm.processor.e(), new com.tencent.mobileqq.troop.troopnotification.vm.processor.c(), new com.tencent.mobileqq.troop.troopnotification.vm.processor.b()});
            this.categoryProcessor = listOf;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIEmptyState Jh() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopNotificationListVM Kh() {
        return (TroopNotificationListVM) this.vm.getValue();
    }

    private final void Lh() {
        ts2.a aVar = this.viewBinding;
        TroopNotificationTabBar troopNotificationTabBar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aVar = null;
        }
        TroopNotificationTabBar troopNotificationTabBar2 = aVar.f437331e;
        Intrinsics.checkNotNullExpressionValue(troopNotificationTabBar2, "viewBinding.troopNotificationPagetabbar");
        this.tabBar = troopNotificationTabBar2;
        ts2.a aVar2 = this.viewBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aVar2 = null;
        }
        FrameLayout frameLayout = aVar2.f437330d;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "viewBinding.troopNotificationContent");
        this.contentView = frameLayout;
        ts2.a aVar3 = this.viewBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aVar3 = null;
        }
        ViewPager2 viewPager2 = aVar3.f437332f;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewBinding.troopNotificationViewpager");
        this.fragmentAdapter = new com.tencent.mobileqq.troop.troopnotification.adapter.e(this, Kh());
        viewPager2.registerOnPageChangeCallback(new b());
        this.viewPager = viewPager2;
        TroopNotificationTabBar troopNotificationTabBar3 = this.tabBar;
        if (troopNotificationTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            troopNotificationTabBar3 = null;
        }
        troopNotificationTabBar3.setOnCurrentTabClickListener(new QUIPageTabBar.h() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.d
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.h
            public final void k1(int i3) {
                TroopNotificationListFragment.Oh(TroopNotificationListFragment.this, i3);
            }
        });
        com.tencent.mobileqq.troop.troopnotification.utils.a<String[]> p26 = Kh().p2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String[], Unit> function1 = new Function1<String[], Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListFragment$initContent$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
                invoke2(strArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String[] strArr) {
                TroopNotificationTabBar troopNotificationTabBar4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
                    return;
                }
                if (strArr != null) {
                    troopNotificationTabBar4 = TroopNotificationListFragment.this.tabBar;
                    if (troopNotificationTabBar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                        troopNotificationTabBar4 = null;
                    }
                    troopNotificationTabBar4.setTabData(strArr);
                }
            }
        };
        p26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopNotificationListFragment.Ph(Function1.this, obj);
            }
        });
        String[] value = Kh().p2().getValue();
        if (value != null) {
            TroopNotificationTabBar troopNotificationTabBar4 = this.tabBar;
            if (troopNotificationTabBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            } else {
                troopNotificationTabBar = troopNotificationTabBar4;
            }
            troopNotificationTabBar.setTabData(value);
        }
        com.tencent.mobileqq.troop.troopnotification.utils.a<int[]> q26 = Kh().q2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<int[], Unit> function12 = new Function1<int[], Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListFragment$initContent$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(int[] iArr) {
                invoke2(iArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable int[] iArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) iArr);
                } else if (iArr != null) {
                    TroopNotificationListFragment.this.Th(iArr);
                }
            }
        };
        q26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopNotificationListFragment.Qh(Function1.this, obj);
            }
        });
        int[] value2 = Kh().q2().getValue();
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListFragment", 2, "initContent: vm.tabVisibility.value=" + value2);
        }
        if (value2 != null) {
            Th(value2);
        }
        com.tencent.mobileqq.troop.troopnotification.utils.a<boolean[]> o26 = Kh().o2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<boolean[], Unit> function13 = new Function1<boolean[], Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListFragment$initContent$7
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(boolean[] zArr) {
                invoke2(zArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable boolean[] zArr) {
                TroopNotificationTabBar troopNotificationTabBar5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) zArr);
                    return;
                }
                troopNotificationTabBar5 = TroopNotificationListFragment.this.tabBar;
                if (troopNotificationTabBar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                    troopNotificationTabBar5 = null;
                }
                troopNotificationTabBar5.setTabShowRed(zArr);
            }
        };
        o26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopNotificationListFragment.Mh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.troop.troopnotification.utils.a<Boolean> A2 = Kh().A2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListFragment$initContent$8
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopNotificationListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v24, types: [com.tencent.mobileqq.widget.TroopNotificationTabBar] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                boolean z16;
                QUIEmptyState Jh;
                TroopNotificationListVM Kh;
                ?? r65;
                QUIEmptyState Jh2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotificationListFragment", 2, "initContent: isAllEmpty=" + it);
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                QUISecNavBar qUISecNavBar = null;
                if (it.booleanValue()) {
                    TroopNotificationListFragment.this.showingClear = false;
                    QUISecNavBar qUISecNavBar2 = TroopNotificationListFragment.this.navBar;
                    if (qUISecNavBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navBar");
                        qUISecNavBar2 = null;
                    }
                    qUISecNavBar2.setRightText("");
                    r65 = TroopNotificationListFragment.this.tabBar;
                    if (r65 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                    } else {
                        qUISecNavBar = r65;
                    }
                    qUISecNavBar.setVisibility(8);
                    TroopNotificationListFragment.this.showingEmpty = true;
                    Jh2 = TroopNotificationListFragment.this.Jh();
                    Jh2.setVisibility(0);
                    return;
                }
                if (!TroopNotificationListFragment.this.showingClear) {
                    TroopNotificationListFragment.this.showingClear = true;
                    Kh = TroopNotificationListFragment.this.Kh();
                    if (Kh.d2() == 0) {
                        QUISecNavBar qUISecNavBar3 = TroopNotificationListFragment.this.navBar;
                        if (qUISecNavBar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navBar");
                        } else {
                            qUISecNavBar = qUISecNavBar3;
                        }
                        qUISecNavBar.setRightText(TroopNotificationListFragment.this.requireActivity().getResources().getString(R.string.f1788437r));
                    }
                }
                z16 = TroopNotificationListFragment.this.showingEmpty;
                if (z16) {
                    TroopNotificationListFragment.this.showingEmpty = false;
                    Jh = TroopNotificationListFragment.this.Jh();
                    Jh.setVisibility(8);
                }
            }
        };
        A2.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopNotificationListFragment.Nh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(TroopNotificationListFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.troopnotification.report.d.f300921a.t(this$0.categoryProcessor.get(i3).getCategory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(TroopNotificationListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(TroopNotificationListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListFragment", 2, "onInitView: clear all notification");
        }
        this$0.Vh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(int[] tabVisibility) {
        TroopNotificationTabBar troopNotificationTabBar = this.tabBar;
        com.tencent.mobileqq.troop.troopnotification.adapter.e eVar = null;
        ViewPager2 viewPager2 = null;
        if (troopNotificationTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            troopNotificationTabBar = null;
        }
        troopNotificationTabBar.setTabVisibility(tabVisibility);
        if (Kh().s2() > 1) {
            TroopNotificationTabBar troopNotificationTabBar2 = this.tabBar;
            if (troopNotificationTabBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                troopNotificationTabBar2 = null;
            }
            troopNotificationTabBar2.setVisibility(0);
        } else {
            TroopNotificationTabBar troopNotificationTabBar3 = this.tabBar;
            if (troopNotificationTabBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                troopNotificationTabBar3 = null;
            }
            troopNotificationTabBar3.setVisibility(8);
        }
        if (!this.hadSetAdapter) {
            this.hadSetAdapter = true;
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager22 = null;
            }
            com.tencent.mobileqq.troop.troopnotification.adapter.e eVar2 = this.fragmentAdapter;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentAdapter");
                eVar2 = null;
            }
            viewPager22.setAdapter(eVar2);
            TroopNotificationTabBar troopNotificationTabBar4 = this.tabBar;
            if (troopNotificationTabBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                troopNotificationTabBar4 = null;
            }
            ViewPager2 viewPager23 = this.viewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager2 = viewPager23;
            }
            troopNotificationTabBar4.bindViewPager2(viewPager2);
        } else {
            com.tencent.mobileqq.troop.troopnotification.adapter.e eVar3 = this.fragmentAdapter;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentAdapter");
            } else {
                eVar = eVar3;
            }
            eVar.notifyDataSetChanged();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListFragment", 2, "initContent: notifyDataSetChanged, notification.size=" + tabVisibility.length);
        }
        Uh();
    }

    private final void Uh() {
        int i3 = 0;
        if (!this.hadInitFirstTab) {
            this.hadInitFirstTab = true;
            Bundle arguments = getArguments();
            if (arguments != null) {
                i3 = arguments.getInt("tab", 0);
            }
            if (i3 != 0) {
                int t26 = Kh().t2(i3);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotificationListFragment", 2, "initFirstTab: categoryIndex=" + i3 + ", tabIndex=" + t26);
                }
                if (t26 > 0) {
                    Yh(t26);
                    return;
                }
                return;
            }
            return;
        }
        if (!Kh().r2(Kh().d2())) {
            Yh(0);
        }
    }

    private final void Vh() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        DialogUtil.createCustomDialog(context, (String) null, context.getString(R.string.f235227b3), (String) null, R.string.cancel, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopNotificationListFragment.Wh(TroopNotificationListFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopNotificationListFragment.Xh(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(TroopNotificationListFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Kh().b2();
        com.tencent.mobileqq.troop.troopnotification.report.d.f300921a.k();
    }

    private final void Yh(final int tabIndex) {
        if (tabIndex >= 0) {
            ViewPager2 viewPager2 = this.viewPager;
            ViewPager2 viewPager22 = null;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(tabIndex, false);
            ViewPager2 viewPager23 = this.viewPager;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager22.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.m
                @Override // java.lang.Runnable
                public final void run() {
                    TroopNotificationListFragment.Zh(TroopNotificationListFragment.this, tabIndex);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(TroopNotificationListFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopNotificationTabBar troopNotificationTabBar = this$0.tabBar;
        if (troopNotificationTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            troopNotificationTabBar = null;
        }
        troopNotificationTabBar.setCurrentPosition(i3);
    }

    private final void initNavBar() {
        ts2.a aVar = this.viewBinding;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            aVar = null;
        }
        QUISecNavBar qUISecNavBar = aVar.f437328b;
        Intrinsics.checkNotNullExpressionValue(qUISecNavBar, "viewBinding.rlTitleBar");
        qUISecNavBar.setLeftType(2);
        qUISecNavBar.setLeftImageRes(R.drawable.qui_chevron_left_icon_navigation_02_selector);
        boolean z16 = true;
        qUISecNavBar.setRightType(1);
        qUISecNavBar.setRightText(qUISecNavBar.getResources().getString(R.string.f1788437r));
        qUISecNavBar.setCenterType(1);
        qUISecNavBar.setCenterText(qUISecNavBar.getResources().getString(R.string.f1788537s));
        qUISecNavBar.S(this);
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopNotificationListFragment.Rh(TroopNotificationListFragment.this, view);
            }
        });
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_RIGHT_TEXT, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopNotificationListFragment.Sh(TroopNotificationListFragment.this, view);
            }
        });
        if (Kh().e2() == 4) {
            qUISecNavBar.setCenterText("\u5386\u53f2\u7fa4\u901a\u77e5");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(ILaunchTroopSysMsgUIUtilApi.KEY_CUSTOM_TITLE);
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            qUISecNavBar.setCenterText(str);
        }
        this.navBar = qUISecNavBar;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        arguments.putInt("KEY_SOURCE_FOR_VM", 1);
        Kh().z2(this, arguments, this.categoryProcessor);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            ts2.a g16 = ts2.a.g(inflater, container, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
            this.viewBinding = g16;
            if (g16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                g16 = null;
            }
            LinearLayout linearLayout = g16.f437329c;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.root");
            this.rootView = linearLayout;
            initNavBar();
            Lh();
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationListFragment", 2, "onCreateView: ");
            }
            com.tencent.mobileqq.troop.troopnotification.report.d dVar = com.tencent.mobileqq.troop.troopnotification.report.d.f300921a;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            dVar.g(requireActivity);
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            Kh().destroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        Kh().S2();
        com.tencent.mobileqq.troop.troopnotification.report.d dVar = com.tencent.mobileqq.troop.troopnotification.report.d.f300921a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        dVar.o(requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(DialogInterface dialogInterface, int i3) {
    }
}
