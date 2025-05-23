package com.tencent.mobileqq.troop.teamup.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.teamup.home.data.TroopTeamUpData;
import com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM;
import com.tencent.mobileqq.troop.teamup.publish.fragment.TroopTeamUpTemplatesFragment;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts2.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000bH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001b\u00108\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/fragment/TroopTeamUpContentListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "initVM", "Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM$b;", "action", "Ih", "initView", "initData", "initReport", "", "isLoading", "Qh", "Landroid/view/View;", "Gh", "Eh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", "Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM;", "vm", "Lts2/k;", "D", "Lts2/k;", "binding", "Lcom/tencent/mobileqq/troop/teamup/home/adapter/e;", "E", "Lcom/tencent/mobileqq/troop/teamup/home/adapter/e;", "contentAdapter", "Lcom/tencent/mobileqq/troop/teamup/home/adapter/f;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/teamup/home/adapter/f;", "moreAdapter", "G", "Z", "isPullRefreshing", "H", "Lkotlin/Lazy;", "Jh", "()Landroid/view/View;", "emptyView", "I", "Kh", "errorView", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpContentListFragment extends QPublicBaseFragment implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TroopTeamUpContentListVM vm;

    /* renamed from: D, reason: from kotlin metadata */
    private k binding;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.teamup.home.adapter.e contentAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.teamup.home.adapter.f moreAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isPullRefreshing;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy errorView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/fragment/TroopTeamUpContentListFragment$a;", "", "", "ARGUMENTS_KEY_TROOP_ID", "Ljava/lang/String;", "ARGUMENTS_KEY_TYPE", "", "ARGUMENTS_TYPE_ALL", "I", "ARGUMENTS_TYPE_MY", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpContentListFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$emptyView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final View invoke() {
                    View Eh;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Eh = TroopTeamUpContentListFragment.this.Eh();
                    return Eh;
                }
            });
            this.emptyView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$errorView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final View invoke() {
                    View Gh;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Gh = TroopTeamUpContentListFragment.this.Gh();
                    return Gh;
                }
            });
            this.errorView = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Eh() {
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(getContext()).setImageType(20).setHalfScreenState(false).setBackgroundColorType(0);
        String string = requireContext().getString(R.string.f236127di);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026oop_team_up_home_no_data)");
        backgroundColorType.setTitle(string);
        String string2 = requireContext().getString(R.string.f236147dk);
        Intrinsics.checkNotNullExpressionValue(string2, "requireContext().getStri\u2026eam_up_home_no_data_desc)");
        backgroundColorType.setDesc(string2);
        String string3 = requireContext().getString(R.string.f236137dj);
        Intrinsics.checkNotNullExpressionValue(string3, "requireContext().getStri\u2026team_up_home_no_data_btn)");
        backgroundColorType.setButton(string3, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpContentListFragment.Fh(TroopTeamUpContentListFragment.this, view);
            }
        });
        QUIEmptyState build = backgroundColorType.build();
        k kVar = this.binding;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kVar = null;
        }
        ConstraintLayout mRv = kVar.getMRv();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        Unit unit = Unit.INSTANCE;
        mRv.addView(build, layoutParams);
        QUIButton button = build.getButton();
        VideoReport.setElementId(button, "em_group_release_btn");
        VideoReport.setElementExposePolicy(button, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(button, ClickPolicy.REPORT_ALL);
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(TroopTeamUpContentListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopTeamUpTemplatesFragment.Companion companion = TroopTeamUpTemplatesFragment.INSTANCE;
        TroopTeamUpContentListVM troopTeamUpContentListVM = this$0.vm;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        companion.a(String.valueOf(troopTeamUpContentListVM.b2()));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Gh() {
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(getContext()).setImageType(5).setHalfScreenState(false).setBackgroundColorType(0);
        String string = requireContext().getString(R.string.f235987d5);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026eam_up_detail_load_error)");
        backgroundColorType.setTitle(string);
        String string2 = requireContext().getString(R.string.f236007d7);
        Intrinsics.checkNotNullExpressionValue(string2, "requireContext().getStri\u2026team_up_detail_net_error)");
        backgroundColorType.setDesc(string2);
        String string3 = requireContext().getString(R.string.f236047da);
        Intrinsics.checkNotNullExpressionValue(string3, "requireContext().getStri\u2026oop_team_up_detail_retry)");
        backgroundColorType.setButton(string3, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpContentListFragment.Hh(TroopTeamUpContentListFragment.this, view);
            }
        });
        QUIEmptyState build = backgroundColorType.build();
        k kVar = this.binding;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kVar = null;
        }
        ConstraintLayout mRv = kVar.getMRv();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        Unit unit = Unit.INSTANCE;
        mRv.addView(build, layoutParams);
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(TroopTeamUpContentListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TroopTeamUpContentListVM troopTeamUpContentListVM = this$0.vm;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        troopTeamUpContentListVM.e2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Jh() {
        return (View) this.emptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View Kh() {
        return (View) this.errorView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(TroopTeamUpContentListFragment this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.isPullRefreshing) {
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a(QPublicBaseFragment.TAG, "pull fresh start");
        this$0.isPullRefreshing = true;
        TroopTeamUpContentListVM troopTeamUpContentListVM = this$0.vm;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        troopTeamUpContentListVM.e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(boolean isLoading) {
        boolean z16;
        TroopTeamUpContentListVM troopTeamUpContentListVM = this.vm;
        TroopTeamUpContentListVM troopTeamUpContentListVM2 = null;
        k kVar = null;
        TroopTeamUpContentListVM troopTeamUpContentListVM3 = null;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        ArrayList<TroopTeamUpData> value = troopTeamUpContentListVM.a2().getValue();
        if (value != null && !value.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            k kVar2 = this.binding;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                kVar = kVar2;
            }
            ImageView imageView = kVar.f437419b;
            Boolean valueOf = Boolean.valueOf(isLoading);
            imageView.setVisibility(0);
            if (((View) au.a(valueOf, imageView)) == null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        k kVar3 = this.binding;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kVar3 = null;
        }
        kVar3.f437419b.setVisibility(8);
        if (this.isPullRefreshing) {
            k kVar4 = this.binding;
            if (kVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                kVar4 = null;
            }
            kVar4.f437420c.setLoadingState(isLoading);
            if (!isLoading) {
                k kVar5 = this.binding;
                if (kVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    kVar5 = null;
                }
                kVar5.f437421d.finishRefresh();
                this.isPullRefreshing = false;
                com.tencent.mobileqq.troop.teamup.home.adapter.f fVar = this.moreAdapter;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("moreAdapter");
                    fVar = null;
                }
                TroopTeamUpContentListVM troopTeamUpContentListVM4 = this.vm;
                if (troopTeamUpContentListVM4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    troopTeamUpContentListVM3 = troopTeamUpContentListVM4;
                }
                fVar.setLoadState(isLoading, troopTeamUpContentListVM3.getHasMore());
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.adapter.f fVar2 = this.moreAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreAdapter");
            fVar2 = null;
        }
        TroopTeamUpContentListVM troopTeamUpContentListVM5 = this.vm;
        if (troopTeamUpContentListVM5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            troopTeamUpContentListVM2 = troopTeamUpContentListVM5;
        }
        fVar2.setLoadState(isLoading, troopTeamUpContentListVM2.getHasMore());
    }

    private final void initData() {
        TroopTeamUpContentListVM troopTeamUpContentListVM = this.vm;
        TroopTeamUpContentListVM troopTeamUpContentListVM2 = null;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        MutableLiveData<ArrayList<TroopTeamUpData>> a26 = troopTeamUpContentListVM.a2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ArrayList<TroopTeamUpData>, Unit> function1 = new Function1<ArrayList<TroopTeamUpData>, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<TroopTeamUpData> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<TroopTeamUpData> arrayList) {
                com.tencent.mobileqq.troop.teamup.home.adapter.e eVar;
                com.tencent.mobileqq.troop.teamup.home.adapter.e eVar2;
                k kVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                    return;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                eVar = TroopTeamUpContentListFragment.this.contentAdapter;
                k kVar2 = null;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                    eVar = null;
                }
                eVar.getNUM_BACKGOURND_ICON();
                eVar2 = TroopTeamUpContentListFragment.this.contentAdapter;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
                    eVar2 = null;
                }
                eVar2.setItems(arrayList);
                kVar = TroopTeamUpContentListFragment.this.binding;
                if (kVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    kVar2 = kVar;
                }
                kVar2.f437421d.setEnableRefresh(!arrayList.isEmpty());
            }
        };
        a26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpContentListFragment.Lh(Function1.this, obj);
            }
        });
        TroopTeamUpContentListVM troopTeamUpContentListVM3 = this.vm;
        if (troopTeamUpContentListVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM3 = null;
        }
        MutableLiveData<Boolean> d26 = troopTeamUpContentListVM3.d2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$initData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isLoading) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) isLoading);
                    return;
                }
                TroopTeamUpContentListFragment troopTeamUpContentListFragment = TroopTeamUpContentListFragment.this;
                Intrinsics.checkNotNullExpressionValue(isLoading, "isLoading");
                troopTeamUpContentListFragment.Qh(isLoading.booleanValue());
            }
        };
        d26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpContentListFragment.Mh(Function1.this, obj);
            }
        });
        TroopTeamUpContentListVM troopTeamUpContentListVM4 = this.vm;
        if (troopTeamUpContentListVM4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM4 = null;
        }
        MutableLiveData<Boolean> X1 = troopTeamUpContentListVM4.X1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$initData$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                View Jh;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                Jh = TroopTeamUpContentListFragment.this.Jh();
                Jh.setVisibility(0);
                if (((View) au.a(bool, Jh)) == null) {
                    Jh.setVisibility(8);
                }
            }
        };
        X1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpContentListFragment.Nh(Function1.this, obj);
            }
        });
        TroopTeamUpContentListVM troopTeamUpContentListVM5 = this.vm;
        if (troopTeamUpContentListVM5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            troopTeamUpContentListVM2 = troopTeamUpContentListVM5;
        }
        MutableLiveData<Boolean> Z1 = troopTeamUpContentListVM2.Z1();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$initData$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                View Kh;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                Kh = TroopTeamUpContentListFragment.this.Kh();
                Kh.setVisibility(0);
                if (((View) au.a(bool, Kh)) == null) {
                    Kh.setVisibility(8);
                }
            }
        };
        Z1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpContentListFragment.Oh(Function1.this, obj);
            }
        });
    }

    private final void initReport() {
        HashMap hashMapOf;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        TroopTeamUpContentListVM troopTeamUpContentListVM = this.vm;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        long b26 = troopTeamUpContentListVM.b2();
        com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", Long.valueOf(b26)));
        h.a.d(aVar, activity, "pg_group_teamup_trends", hashMapOf, false, 8, null);
    }

    private final void initVM() {
        ViewModel viewModel = new ViewModelProvider(this).get(TroopTeamUpContentListVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ontentListVM::class.java)");
        TroopTeamUpContentListVM troopTeamUpContentListVM = (TroopTeamUpContentListVM) viewModel;
        this.vm = troopTeamUpContentListVM;
        TroopTeamUpContentListVM troopTeamUpContentListVM2 = null;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        troopTeamUpContentListVM.c2(arguments);
        TroopTeamUpContentListVM troopTeamUpContentListVM3 = this.vm;
        if (troopTeamUpContentListVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            troopTeamUpContentListVM2 = troopTeamUpContentListVM3;
        }
        troopTeamUpContentListVM2.l2(new Function1<TroopTeamUpContentListVM.b, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.TroopTeamUpContentListFragment$initVM$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopTeamUpContentListVM.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopTeamUpContentListVM.b action) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) action);
                } else {
                    Intrinsics.checkNotNullParameter(action, "action");
                    TroopTeamUpContentListFragment.this.Ih(action);
                }
            }
        });
    }

    private final void initView() {
        k kVar = this.binding;
        k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kVar = null;
        }
        kVar.f437419b.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 1));
        k kVar3 = this.binding;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kVar3 = null;
        }
        kVar3.f437422e.setLayoutManager(new LinearLayoutManager(getContext()));
        k kVar4 = this.binding;
        if (kVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kVar4 = null;
        }
        kVar4.f437422e.setItemAnimator(null);
        TroopTeamUpContentListVM troopTeamUpContentListVM = this.vm;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        this.contentAdapter = new com.tencent.mobileqq.troop.teamup.home.adapter.e(this, troopTeamUpContentListVM.b2());
        TroopTeamUpContentListVM troopTeamUpContentListVM2 = this.vm;
        if (troopTeamUpContentListVM2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM2 = null;
        }
        com.tencent.mobileqq.troop.teamup.home.adapter.f fVar = new com.tencent.mobileqq.troop.teamup.home.adapter.f(troopTeamUpContentListVM2);
        fVar.setHasStableIds(true);
        fVar.registerLoadMoreListener(this);
        fVar.setLoadState(false, false);
        this.moreAdapter = fVar;
        k kVar5 = this.binding;
        if (kVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kVar5 = null;
        }
        RecyclerView recyclerView = kVar5.f437422e;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.mobileqq.troop.teamup.home.adapter.e eVar = this.contentAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentAdapter");
            eVar = null;
        }
        adapterArr[0] = eVar;
        com.tencent.mobileqq.troop.teamup.home.adapter.f fVar2 = this.moreAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreAdapter");
            fVar2 = null;
        }
        adapterArr[1] = fVar2;
        recyclerView.setAdapter(new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr));
        k kVar6 = this.binding;
        if (kVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            kVar2 = kVar6;
        }
        kVar2.f437421d.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.troop.teamup.home.fragment.f
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                TroopTeamUpContentListFragment.Ph(TroopTeamUpContentListFragment.this, iRefreshLayout);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRv;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            mRv = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            k g16 = k.g(inflater);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
            this.binding = g16;
            if (g16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                g16 = null;
            }
            mRv = g16.getMRv();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, mRv);
        return mRv;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroyView();
        TroopTeamUpContentListVM troopTeamUpContentListVM = this.vm;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        troopTeamUpContentListVM.l2(null);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.isPullRefreshing) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a(QPublicBaseFragment.TAG, "onLoadMoreStart but isPullRefreshing return");
            return;
        }
        TroopTeamUpContentListVM troopTeamUpContentListVM = this.vm;
        k kVar = null;
        if (troopTeamUpContentListVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopTeamUpContentListVM = null;
        }
        troopTeamUpContentListVM.loadMore();
        k kVar2 = this.binding;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            kVar = kVar2;
        }
        kVar.f437420c.setLoadingState(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initVM();
        initView();
        initData();
        initReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(TroopTeamUpContentListVM.b action) {
    }
}
