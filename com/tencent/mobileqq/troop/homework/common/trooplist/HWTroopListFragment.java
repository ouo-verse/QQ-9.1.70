package com.tencent.mobileqq.troop.homework.common.trooplist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.HWPageType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\r\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0010H\u0014J&\u0010\u0017\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0014R\u001b\u0010\u001c\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/HWTroopListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "initReport", "Gh", "Hh", "Eh", "Jh", "Lh", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a;", "Ch", "Landroid/os/Bundle;", "bundle", "com/tencent/mobileqq/troop/homework/common/trooplist/HWTroopListFragment$b", "Bh", "(Landroid/os/Bundle;)Lcom/tencent/mobileqq/troop/homework/common/trooplist/HWTroopListFragment$b;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "doOnCreateView", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/troop/homework/common/trooplist/viewmodel/a;", "viewModel", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "D", "Ah", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "contentViewGroup", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "G", "Landroid/view/View;", "confirmBtn", "H", "loadingView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "I", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/adapter/a;", "J", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/adapter/a;", "adapter", "<init>", "()V", "K", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWTroopListFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: E, reason: from kotlin metadata */
    private RelativeLayout contentViewGroup;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private View confirmBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: I, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.common.trooplist.adapter.a adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/trooplist/HWTroopListFragment$a;", "", "Lcom/tencent/mobileqq/troop/homework/common/HWPageType;", "pageFrom", "", "", "troopList", "troopUin", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.trooplist.HWTroopListFragment$a, reason: from kotlin metadata */
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
        public final void a(@NotNull HWPageType pageFrom, @NotNull List<String> troopList, @NotNull String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, pageFrom, troopList, troopUin);
                return;
            }
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            Intrinsics.checkNotNullParameter(troopList, "troopList");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("NOTICE_TROOP_LIST", new ArrayList(troopList));
            intent.putExtra("TROOP_UIN", troopUin);
            intent.putExtra("PAGE_FROM", pageFrom.ordinal());
            QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, HWTroopListFragment.class);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/homework/common/trooplist/HWTroopListFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f296631a;

        b(Bundle bundle) {
            this.f296631a = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            T newInstance = modelClass.getConstructor(Bundle.class).newInstance(this.f296631a);
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026java).newInstance(bundle)");
            return newInstance;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45957);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWTroopListFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a>() { // from class: com.tencent.mobileqq.troop.homework.common.trooplist.HWTroopListFragment$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWTroopListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a invoke() {
                com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a Ch;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Ch = HWTroopListFragment.this.Ch();
                return Ch;
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.troop.homework.common.trooplist.HWTroopListFragment$emptyView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWTroopListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIEmptyState invoke() {
                com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a Dh;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(HWTroopListFragment.this.getContext()).setImageType(9).setBackgroundColorType(0);
                Dh = HWTroopListFragment.this.Dh();
                return backgroundColorType.setTitle(Dh.getPageFrom() == HWPageType.PAGE_TYPE_NOTICE.ordinal() ? "\u6ca1\u6709\u5176\u4ed6\u4efb\u73ed\u4e3b\u4efb\u6216\u8005\u8001\u5e08\u7684\u7fa4" : "\u6ca1\u6709\u8eab\u4efd\u4e3a\u8001\u5e08\u4e14\u662f\u7ba1\u7406\u5458\u7684\u7fa4").setAutoCenter(false).build();
            }
        });
        this.emptyView = lazy2;
    }

    private final QUIEmptyState Ah() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    private final b Bh(Bundle bundle) {
        return new b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a Ch() {
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        ViewModel viewModel = new ViewModelProvider(this, Bh(requireArguments)).get(com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026istViewModel::class.java)");
        return (com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a Dh() {
        return (com.tencent.mobileqq.troop.homework.common.trooplist.viewmodel.a) this.viewModel.getValue();
    }

    private final void Eh() {
        View view = this.confirmBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.trooplist.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWTroopListFragment.Fh(HWTroopListFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(HWTroopListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh().P1();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Gh() {
        HWNoticeUtils hWNoticeUtils = HWNoticeUtils.f297171a;
        RelativeLayout relativeLayout = this.contentViewGroup;
        View view = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewGroup");
            relativeLayout = null;
        }
        Context context = relativeLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "contentViewGroup.context");
        this.loadingView = hWNoticeUtils.c(context);
        RelativeLayout relativeLayout2 = this.contentViewGroup;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewGroup");
            relativeLayout2 = null;
        }
        View view2 = this.loadingView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            view = view2;
        }
        relativeLayout2.addView(view);
    }

    private final void Hh() {
        RecyclerView recyclerView = this.recyclerView;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setOverScrollMode(2);
        recyclerView.setItemAnimator(null);
        com.tencent.mobileqq.troop.homework.common.trooplist.adapter.a aVar = new com.tencent.mobileqq.troop.homework.common.trooplist.adapter.a(Dh());
        aVar.setHasStableIds(true);
        this.adapter = aVar;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[1];
        com.tencent.mobileqq.troop.homework.common.trooplist.adapter.a aVar2 = this.adapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar2 = null;
        }
        adapterArr[0] = aVar2;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView2.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Ih(HWTroopListFragment this$0, String str) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_num", Integer.valueOf(this$0.Dh().L1())));
        return hashMapOf;
    }

    private final void Jh() {
        Dh().init();
        LiveData<List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a>> M1 = Dh().M1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.troop.homework.common.trooplist.data.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.troop.homework.common.trooplist.data.a>, Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.trooplist.HWTroopListFragment$observeLiveData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWTroopListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.homework.common.trooplist.data.a> list) {
                invoke2((List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.tencent.mobileqq.troop.homework.common.trooplist.data.a> list) {
                com.tencent.mobileqq.troop.homework.common.trooplist.adapter.a aVar;
                RelativeLayout relativeLayout;
                View view;
                RecyclerView recyclerView;
                View view2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                aVar = HWTroopListFragment.this.adapter;
                View view3 = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    aVar = null;
                }
                aVar.setItems(list);
                relativeLayout = HWTroopListFragment.this.contentViewGroup;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentViewGroup");
                    relativeLayout = null;
                }
                view = HWTroopListFragment.this.loadingView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                    view = null;
                }
                relativeLayout.removeView(view);
                if (list.isEmpty()) {
                    HWTroopListFragment.this.Lh();
                    return;
                }
                recyclerView = HWTroopListFragment.this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                recyclerView.setVisibility(0);
                view2 = HWTroopListFragment.this.confirmBtn;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
                } else {
                    view3 = view2;
                }
                view3.setVisibility(0);
            }
        };
        M1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.common.trooplist.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWTroopListFragment.Kh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh() {
        QUIEmptyState Ah = Ah();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        Ah.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = this.contentViewGroup;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentViewGroup");
            relativeLayout = null;
        }
        relativeLayout.addView(Ah());
    }

    private final void initReport() {
        String str;
        HashMap hashMapOf;
        View view;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (Dh().getPageFrom() == HWPageType.PAGE_TYPE_NOTICE.ordinal()) {
            str = "pg_group_notice_range_selection";
        } else {
            str = "pg_group_clock_in_range_selection";
        }
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", Dh().N1()));
        h.a.d(aVar, activity, str, hashMapOf, false, 8, null);
        View view2 = this.confirmBtn;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            view = null;
        } else {
            view = view2;
        }
        h.a.m(aVar, view, "em_group_complete_btn", ExposurePolicy.REPORT_NONE, null, new IDynamicParams() { // from class: com.tencent.mobileqq.troop.homework.common.trooplist.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str2) {
                Map Ih;
                Ih = HWTroopListFragment.Ih(HWTroopListFragment.this, str2);
                return Ih;
            }
        }, activity.getWindow().getDecorView(), 8, null);
        View view4 = this.confirmBtn;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        } else {
            view3 = view4;
        }
        aVar.f(view3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        String str = "";
        if (Dh().getPageFrom() == HWPageType.PAGE_TYPE_NOTICE.ordinal()) {
            Context context = getContext();
            if (context != null && (string2 = context.getString(R.string.f2340478w)) != null) {
                str = string2;
            }
            setTitle(str);
        } else {
            Context context2 = getContext();
            if (context2 != null && (string = context2.getString(R.string.f2339778p)) != null) {
                str = string;
            }
            setTitle(str);
        }
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recycler_view)");
        this.recyclerView = (RecyclerView) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.b7p);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.confirm_btn)");
        this.confirmBtn = findViewById2;
        View findViewById3 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.u8n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.content_view_group)");
        this.contentViewGroup = (RelativeLayout) findViewById3;
        Gh();
        Hh();
        Eh();
        Jh();
        initReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.g0i;
    }
}
