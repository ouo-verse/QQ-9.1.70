package com.tencent.mobileqq.troop.troopblacklist;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopblacklist.view.adapter.TroopBlackListAdapter;
import com.tencent.mobileqq.troop.troopblacklist.viewmodel.TroopBlackListViewModel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.aio.at.widget.IndexBar;
import com.tencent.qqnt.troop.TroopInfoRepo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0014J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R#\u0010.\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/TroopBlackListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initUI", "", "isRemoveState", "isMemberListEmpty", "Lh", "", "numToRemove", "Ph", "Ih", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "Eh", "Dh", "Hh", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "useQUISecNavBar", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/troop/troopblacklist/view/adapter/TroopBlackListAdapter;", "D", "Lcom/tencent/mobileqq/troop/troopblacklist/view/adapter/TroopBlackListAdapter;", "adapter", "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", "E", "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", "indexBar", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Fh", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;", "kotlin.jvm.PlatformType", "G", "Gh", "()Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;", "viewModel", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBlackListFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopBlackListAdapter adapter;

    /* renamed from: E, reason: from kotlin metadata */
    private IndexBar indexBar;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopblacklist/TroopBlackListFragment$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBlackListFragment.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            TroopBlackListAdapter troopBlackListAdapter = TroopBlackListFragment.this.adapter;
            if (troopBlackListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                troopBlackListAdapter = null;
            }
            troopBlackListAdapter.n0(findFirstVisibleItemPosition);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopblacklist/TroopBlackListFragment$b", "Lcom/tencent/qqnt/aio/at/widget/IndexBar$a;", "", "letter", "", "action", "", com.tencent.luggage.wxa.c8.c.G, "", "p1", "", "touching", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements IndexBar.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopBlackListFragment.this);
            }
        }

        @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
        public void m(boolean touching) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, touching);
            }
        }

        @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
        public void p1(@Nullable String letter, int action, float pos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, letter, Integer.valueOf(action), Float.valueOf(pos));
                return;
            }
            if (letter != null && letter.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                RecyclerView recyclerView = TroopBlackListFragment.this.recyclerView;
                TroopBlackListAdapter troopBlackListAdapter = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                TroopBlackListAdapter troopBlackListAdapter2 = TroopBlackListFragment.this.adapter;
                if (troopBlackListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    troopBlackListAdapter = troopBlackListAdapter2;
                }
                linearLayoutManager.scrollToPositionWithOffset(troopBlackListAdapter.k0(letter), 0);
            }
        }
    }

    public TroopBlackListFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.troop.troopblacklist.TroopBlackListFragment$emptyView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBlackListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QUIEmptyState invoke() {
                    QUIEmptyState Eh;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Eh = TroopBlackListFragment.this.Eh();
                    return Eh;
                }
            });
            this.emptyView = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopBlackListViewModel>() { // from class: com.tencent.mobileqq.troop.troopblacklist.TroopBlackListFragment$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBlackListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TroopBlackListViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (TroopBlackListViewModel) TroopBlackListFragment.this.getViewModel(TroopBlackListViewModel.class) : (TroopBlackListViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void Dh() {
        LifecycleOwner hostLifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(hostLifecycleOwner, "hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(hostLifecycleOwner), Dispatchers.getMain(), null, new TroopBlackListFragment$addIntentObserver$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIEmptyState Eh() {
        String str;
        ViewGroup viewGroup;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(7);
        Context context = getContext();
        if (context == null || (str = context.getString(R.string.f2325174r)) == null) {
            str = "";
        }
        QUIEmptyState build = imageType.setTitle(str).setDesc(com.tencent.mobileqq.troop.troopblacklist.a.f299449a.b()).setBackgroundColorType(2).build();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.addView(build, -1, -1);
        }
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIEmptyState Fh() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopBlackListViewModel Gh() {
        return (TroopBlackListViewModel) this.viewModel.getValue();
    }

    private final void Hh() {
        String str;
        TroopInfo troopInfoFromCache;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("troop_uin", "");
        } else {
            str = null;
        }
        if (str == null || (troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(str)) == null) {
            return;
        }
        com.tencent.mobileqq.troop.troopblacklist.utils.a aVar = com.tencent.mobileqq.troop.troopblacklist.utils.a.f299464a;
        aVar.g(troopInfoFromCache.isOwner());
        VideoReport.setPageReportPolicy(this, PageReportPolicy.REPORT_NONE);
        aVar.e(true);
    }

    private final void Ih() {
        String str;
        String str2;
        Context context = getContext();
        Context context2 = getContext();
        if (context2 != null) {
            str = context2.getString(R.string.f221036_q);
        } else {
            str = null;
        }
        Context context3 = getContext();
        if (context3 != null) {
            str2 = context3.getString(R.string.f2325674w);
        } else {
            str2 = null;
        }
        DialogUtil.createCustomDialog(context, 230, str, str2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopBlackListFragment.Jh(TroopBlackListFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopBlackListFragment.Kh(dialogInterface, i3);
            }
        }).show();
        com.tencent.mobileqq.troop.troopblacklist.utils.a.d(com.tencent.mobileqq.troop.troopblacklist.utils.a.f299464a, "dt_imp", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(TroopBlackListFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this$0.getContext(), 1, R.string.f235097aq, 0).show();
            return;
        }
        dialogInterface.dismiss();
        this$0.Gh().f2();
        com.tencent.mobileqq.troop.troopblacklist.utils.a.f299464a.c("dt_clck", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        com.tencent.mobileqq.troop.troopblacklist.utils.a.f299464a.c("dt_clck", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(boolean isRemoveState, boolean isMemberListEmpty) {
        boolean z16;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (!isMemberListEmpty && isRemoveState) {
            this.quiSecNavBar.setLeftType(1);
            this.quiSecNavBar.setLeftText(context.getString(R.string.f172844un3));
            this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_TEXT, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopBlackListFragment.Mh(TroopBlackListFragment.this, view);
                }
            });
        } else {
            this.quiSecNavBar.setLeftType(2);
            this.quiSecNavBar.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopBlackListFragment.Nh(TroopBlackListFragment.this, view);
                }
            });
        }
        if (com.tencent.mobileqq.troop.troopblacklist.a.f299449a.a() && !isMemberListEmpty) {
            z16 = true;
        } else {
            z16 = false;
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        BaseAction baseAction = BaseAction.ACTION_RIGHT_TEXT;
        qUISecNavBar.setBaseViewVisible(baseAction, z16);
        if (z16 && isRemoveState) {
            Ph(Gh().X1());
        } else if (z16) {
            this.quiSecNavBar.setRightType(1);
            this.quiSecNavBar.setRightText(context.getString(R.string.f2325274s));
            this.quiSecNavBar.setBaseViewEnabled(baseAction, true);
            this.quiSecNavBar.setBaseClickListener(baseAction, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopBlackListFragment.Oh(TroopBlackListFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(TroopBlackListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh().l2(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(TroopBlackListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(TroopBlackListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh().l2(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(int numToRemove) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String string = context.getString(R.string.f2325574v);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026op_black_list_remove_btn)");
        if (numToRemove != 0) {
            string = string + "(" + numToRemove + ")";
        }
        boolean z16 = true;
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setRightText(string);
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        BaseAction baseAction = BaseAction.ACTION_RIGHT_TEXT;
        if (numToRemove == 0) {
            z16 = false;
        }
        qUISecNavBar.setBaseViewEnabled(baseAction, z16);
        this.quiSecNavBar.setBaseClickListener(baseAction, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopblacklist.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopBlackListFragment.Qh(TroopBlackListFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(TroopBlackListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ih();
        com.tencent.mobileqq.troop.troopblacklist.utils.a.f299464a.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initUI() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        setTitle(context.getText(R.string.f2325874y));
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f101495vc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026d.troop_black_list_index)");
        this.indexBar = (IndexBar) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f101485vb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.troop_black_list)");
        this.recyclerView = (RecyclerView) findViewById2;
        IndexBar indexBar = this.indexBar;
        IndexBar indexBar2 = null;
        if (indexBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexBar");
            indexBar = null;
        }
        TroopBlackListViewModel viewModel = Gh();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        this.adapter = new TroopBlackListAdapter(context, indexBar, viewModel);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        TroopBlackListAdapter troopBlackListAdapter = this.adapter;
        if (troopBlackListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            troopBlackListAdapter = null;
        }
        recyclerView2.setAdapter(troopBlackListAdapter);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addOnScrollListener(new a());
        IndexBar indexBar3 = this.indexBar;
        if (indexBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexBar");
        } else {
            indexBar2 = indexBar3;
        }
        indexBar2.setOnIndexBarTouchListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.hym;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            com.tencent.mobileqq.troop.troopblacklist.utils.a.f299464a.e(false);
        }
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
        initUI();
        Dh();
        Bundle arguments = getArguments();
        if (arguments != null) {
            Gh().init(arguments);
        } else {
            onBackEvent();
        }
        Hh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }
}
