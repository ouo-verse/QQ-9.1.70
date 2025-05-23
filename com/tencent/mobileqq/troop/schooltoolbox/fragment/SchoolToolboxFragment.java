package com.tencent.mobileqq.troop.schooltoolbox.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$2;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$3;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$4;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/fragment/SchoolToolboxFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "yh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "initData", "", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", "errorMsg", "Bh", "wh", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "loadingLayout", "E", "emptyLayout", "Lcom/tencent/mobileqq/troop/schooltoolbox/viewModel/b;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "vh", "()Lcom/tencent/mobileqq/troop/schooltoolbox/viewModel/b;", "viewModel", "Lcom/tencent/mobileqq/troop/schooltoolbox/adapter/a;", "G", "th", "()Lcom/tencent/mobileqq/troop/schooltoolbox/adapter/a;", "adapter", "Landroid/app/Dialog;", "H", "uh", "()Landroid/app/Dialog;", "loadingView", "<init>", "()V", "I", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class SchoolToolboxFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    private FrameLayout loadingLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout emptyLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/fragment/SchoolToolboxFragment$a;", "", "Landroid/content/Context;", "context", "", "troopUin", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.schooltoolbox.fragment.SchoolToolboxFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@NotNull Context context, long troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, Long.valueOf(troopUin));
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("troop_uin", troopUin);
            QPublicFragmentActivity.start(context, intent, SchoolToolboxFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54812);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SchoolToolboxFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(com.tencent.mobileqq.troop.schooltoolbox.viewModel.b.class), new HWViewModelsExtKt$hwViewModels$3(new HWViewModelsExtKt$hwViewModels$2(this)), new HWViewModelsExtKt$hwViewModels$4(this));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.schooltoolbox.adapter.a>() { // from class: com.tencent.mobileqq.troop.schooltoolbox.fragment.SchoolToolboxFragment$adapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SchoolToolboxFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.schooltoolbox.adapter.a invoke() {
                com.tencent.mobileqq.troop.schooltoolbox.viewModel.b vh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.schooltoolbox.adapter.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                vh5 = SchoolToolboxFragment.this.vh();
                return new com.tencent.mobileqq.troop.schooltoolbox.adapter.a(vh5.O1());
            }
        });
        this.adapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.troop.schooltoolbox.fragment.SchoolToolboxFragment$loadingView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SchoolToolboxFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dialog invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? LoadingUtil.showLoadingDialogTipsRight(SchoolToolboxFragment.this.getContext(), false, true) : (Dialog) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.loadingView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(SchoolToolboxFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.schooltoolbox.adapter.a th5 = this$0.th();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        th5.submitList(it);
    }

    private final void Bh(int imageType, String errorMsg) {
        FrameLayout frameLayout = this.emptyLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        FrameLayout frameLayout3 = this.emptyLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
            frameLayout3 = null;
        }
        if (frameLayout3.getChildCount() == 0) {
            QUIEmptyState build = new QUIEmptyState.Builder(requireContext()).setImageType(imageType).setDesc(errorMsg).build();
            FrameLayout frameLayout4 = this.emptyLayout;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
            } else {
                frameLayout2 = frameLayout4;
            }
            frameLayout2.addView(build, -1, -1);
            return;
        }
        FrameLayout frameLayout5 = this.emptyLayout;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
        } else {
            frameLayout2 = frameLayout5;
        }
        View childAt = frameLayout2.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.tencent.biz.qui.quiemptystate.QUIEmptyState");
        QUIEmptyState qUIEmptyState = (QUIEmptyState) childAt;
        qUIEmptyState.setImageView(imageType);
        qUIEmptyState.setDesc(errorMsg);
    }

    private final void hideLoading() {
        uh().dismiss();
    }

    private final void initData() {
        vh().M1();
    }

    private final void initView(View rootView) {
        View findViewById = rootView.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        qUISecNavBar.setCenterText(HardCodeUtil.qqStr(R.string.f224056hw));
        qUISecNavBar.S(this);
        qUISecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.schooltoolbox.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SchoolToolboxFragment.xh(SchoolToolboxFragment.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.loading_layout)");
        this.loadingLayout = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.bwi);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.empty_layout)");
        this.emptyLayout = (FrameLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.recyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(th());
    }

    private final void showLoading() {
        uh().show();
    }

    private final com.tencent.mobileqq.troop.schooltoolbox.adapter.a th() {
        return (com.tencent.mobileqq.troop.schooltoolbox.adapter.a) this.adapter.getValue();
    }

    private final Dialog uh() {
        Object value = this.loadingView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingView>(...)");
        return (Dialog) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.schooltoolbox.viewModel.b vh() {
        return (com.tencent.mobileqq.troop.schooltoolbox.viewModel.b) this.viewModel.getValue();
    }

    private final void wh() {
        FrameLayout frameLayout = this.emptyLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(SchoolToolboxFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void yh() {
        vh().P1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.troop.schooltoolbox.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SchoolToolboxFragment.zh(SchoolToolboxFragment.this, (Integer) obj);
            }
        });
        vh().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.troop.schooltoolbox.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SchoolToolboxFragment.Ah(SchoolToolboxFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(SchoolToolboxFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == 0) {
            String qqStr = HardCodeUtil.qqStr(R.string.ci7);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.net_error)");
            this$0.Bh(5, qqStr);
            return;
        }
        if (num != null && num.intValue() == 1) {
            this$0.showLoading();
            return;
        }
        if (num != null && num.intValue() == 2) {
            this$0.hideLoading();
            String qqStr2 = HardCodeUtil.qqStr(R.string.f170912mb);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.no_data)");
            this$0.Bh(16, qqStr2);
            return;
        }
        if (num != null && num.intValue() == 3) {
            this$0.hideLoading();
            this$0.wh();
        } else if (num != null && num.intValue() == 4) {
            this$0.hideLoading();
            String qqStr3 = HardCodeUtil.qqStr(R.string.ci7);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.net_error)");
            this$0.Bh(5, qqStr3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.initWindowStyleAndAnimation(activity);
        if (!(activity instanceof QBaseActivity)) {
            return;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) activity;
        SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
        RFWImmersiveUtils.setNavigationBarColor(qBaseActivity.getWindow(), ie0.a.f().g(activity, R.color.qui_common_bg_bottom_light, 1000));
        qBaseActivity.overridePendingTransition(R.anim.f154427o, R.anim.f154429q);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        vh().R1();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            rootView = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            rootView = inflater.inflate(R.layout.i0r, container, false);
            rootView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            FragmentActivity activity = getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity != null) {
                qBaseActivity.mActNeedImmersive = false;
                qBaseActivity.mNeedStatusTrans = false;
            }
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            initView(rootView);
            initData();
            yh();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }
}
