package com.tencent.mobileqq.troop.troopsquare.topic.fragment;

import NS_COMM.COMM;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$2;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$3;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$4;
import com.tencent.mobileqq.troop.troopsquare.TroopSquareRecommendAdapter;
import com.tencent.mobileqq.troop.troopsquare.topic.TroopSquareTopicLoadingView;
import com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel;
import com.tencent.mobileqq.troop.troopsquare.topic.vm.a;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001;\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J&\u0010\u001e\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\u001a\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010(\u001a\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/fragment/TroopSquareTopicFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "initReport", "Fh", "Landroid/view/View;", "view", "Bh", "Eh", "Ch", "Ih", "", "keyword", "Hh", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Gh", "Jh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "useQUISecNavBar", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", "onDestroyView", "onResume", "Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/TroopSquareTopicViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Ah", "()Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/TroopSquareTopicViewModel;", "viewModel", "Lcom/tencent/mobileqq/troop/troopsquare/topic/adapter/b;", "D", "Lcom/tencent/mobileqq/troop/troopsquare/topic/adapter/b;", "topicInfoAdapter", "Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter;", "E", "Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter;", "groupListAdapter", "Lcom/tencent/mobileqq/troop/troopsquare/common/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopsquare/common/b;", "loadMoreAdapter", "G", "Landroid/view/View;", "loadingView", "com/tencent/mobileqq/troop/troopsquare/topic/fragment/TroopSquareTopicFragment$c", "H", "Lcom/tencent/mobileqq/troop/troopsquare/topic/fragment/TroopSquareTopicFragment$c;", "troopMngObserver", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "I", OcrConfig.CHINESE, "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "retryView", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareTopicFragment extends QIphoneTitleBarFragment implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsquare.topic.adapter.b topicInfoAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopSquareRecommendAdapter groupListAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopsquare.common.b loadMoreAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final c troopMngObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy retryView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/fragment/TroopSquareTopicFragment$a;", "", "", "troopUin", "", "bannerId", "bannerName", "ext", "topicSource", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.fragment.TroopSquareTopicFragment$a, reason: from kotlin metadata */
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

        public static /* synthetic */ void b(Companion companion, String str, long j3, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                str3 = null;
            }
            String str5 = str3;
            if ((i3 & 16) != 0) {
                str4 = "group_square";
            }
            companion.a(str, j3, str2, str5, str4);
        }

        public final void a(@NotNull String troopUin, long bannerId, @Nullable String bannerName, @Nullable String ext, @Nullable String topicSource) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopUin, Long.valueOf(bannerId), bannerName, ext, topicSource);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("troop_uin", troopUin);
            intent.putExtra("banner_id", bannerId);
            intent.putExtra("banner_name", bannerName);
            intent.putExtra("ext", ext);
            intent.putExtra("topic_source", topicSource);
            intent.putExtra("big_brother_source_key", "biz_src_jc_huati_group");
            QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, TroopSquareTopicFragment.class);
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/topic/fragment/TroopSquareTopicFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f301677d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopSquareTopicFragment f301678e;

        b(LinearLayoutManager linearLayoutManager, TroopSquareTopicFragment troopSquareTopicFragment) {
            this.f301677d = linearLayoutManager;
            this.f301678e = troopSquareTopicFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) linearLayoutManager, (Object) troopSquareTopicFragment);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            int coerceAtLeast;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            View findViewByPosition = this.f301677d.findViewByPosition(0);
            if (findViewByPosition != null) {
                float abs = Math.abs(findViewByPosition.getTop());
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(findViewByPosition.getHeight(), 1);
                this.f301678e.quiSecNavBar.g(BaseAction.ACTION_CENTER_TEXT).setAlpha(abs / coerceAtLeast);
                return;
            }
            this.f301678e.quiSecNavBar.g(BaseAction.ACTION_CENTER_TEXT).setAlpha(1.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/topic/fragment/TroopSquareTopicFragment$c", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "reqtype", "result", "", "troopUin", "", "l", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareTopicFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int reqtype, int result, @Nullable String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(reqtype), Integer.valueOf(result), troopUin);
                return;
            }
            if (1 == reqtype) {
                TroopSquareRecommendAdapter troopSquareRecommendAdapter = TroopSquareTopicFragment.this.groupListAdapter;
                if (troopSquareRecommendAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
                    troopSquareRecommendAdapter = null;
                }
                troopSquareRecommendAdapter.r0(troopUin);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61665);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareTopicFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TroopSquareTopicViewModel.class), new HWViewModelsExtKt$hwViewModels$3(new HWViewModelsExtKt$hwViewModels$2(this)), new HWViewModelsExtKt$hwViewModels$4(this));
        this.troopMngObserver = new c();
        lazy = LazyKt__LazyJVMKt.lazy(new TroopSquareTopicFragment$retryView$2(this));
        this.retryView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSquareTopicViewModel Ah() {
        return (TroopSquareTopicViewModel) this.viewModel.getValue();
    }

    private final void Bh(View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TroopSquareTopicLoadingView troopSquareTopicLoadingView = new TroopSquareTopicLoadingView(context, null, false, 0, 14, null);
        troopSquareTopicLoadingView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.loadingView = troopSquareTopicLoadingView;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.f1039061v);
        if (frameLayout != null) {
            View view2 = this.loadingView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                view2 = null;
            }
            frameLayout.addView(view2);
        }
    }

    private final void Ch() {
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.addObserver(this.troopMngObserver);
        }
        MutableLiveData<com.tencent.mobileqq.troop.troopsquare.topic.vm.a> obtainUiState = Ah().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopsquare.topic.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.troopsquare.topic.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.fragment.TroopSquareTopicFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareTopicFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopsquare.topic.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopsquare.topic.vm.a aVar) {
                com.tencent.mobileqq.troop.troopsquare.common.b bVar;
                com.tencent.mobileqq.troop.troopsquare.common.b bVar2;
                QUIEmptyState zh5;
                View view;
                com.tencent.mobileqq.troop.troopsquare.topic.adapter.b bVar3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                com.tencent.mobileqq.troop.troopsquare.common.b bVar4 = null;
                com.tencent.mobileqq.troop.troopsquare.topic.adapter.b bVar5 = null;
                TroopSquareRecommendAdapter troopSquareRecommendAdapter = null;
                if (aVar instanceof a.c) {
                    zh5 = TroopSquareTopicFragment.this.zh();
                    ab.c(zh5);
                    view = TroopSquareTopicFragment.this.loadingView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                        view = null;
                    }
                    ab.c(view);
                    bVar3 = TroopSquareTopicFragment.this.topicInfoAdapter;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicInfoAdapter");
                    } else {
                        bVar5 = bVar3;
                    }
                    a.c cVar = (a.c) aVar;
                    bVar5.l0(cVar.a());
                    TroopSquareTopicFragment.this.setTitle(cVar.a().title);
                    return;
                }
                if (aVar instanceof a.b) {
                    bVar2 = TroopSquareTopicFragment.this.loadMoreAdapter;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        bVar2 = null;
                    }
                    a.b bVar6 = (a.b) aVar;
                    bVar2.setLoadState(false, bVar6.a());
                    TroopSquareRecommendAdapter troopSquareRecommendAdapter2 = TroopSquareTopicFragment.this.groupListAdapter;
                    if (troopSquareRecommendAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
                    } else {
                        troopSquareRecommendAdapter = troopSquareRecommendAdapter2;
                    }
                    troopSquareRecommendAdapter.p0(bVar6.b());
                    return;
                }
                if (aVar instanceof a.C8831a) {
                    bVar = TroopSquareTopicFragment.this.loadMoreAdapter;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                    } else {
                        bVar4 = bVar;
                    }
                    bVar4.setLoadState(false, true);
                    if (((a.C8831a) aVar).a()) {
                        return;
                    }
                    TroopSquareTopicFragment.this.Ih();
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSquareTopicFragment.Dh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Eh(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f1039161w);
        com.tencent.mobileqq.troop.troopsquare.common.b bVar = null;
        recyclerView.setItemAnimator(null);
        com.tencent.mobileqq.troop.troopsquare.topic.adapter.b bVar2 = new com.tencent.mobileqq.troop.troopsquare.topic.adapter.b(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.fragment.TroopSquareTopicFragment$initRecyclerView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareTopicFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    TroopSquareTopicFragment.this.Hh(it);
                }
            }
        });
        bVar2.setHasStableIds(true);
        this.topicInfoAdapter = bVar2;
        TroopSquareRecommendAdapter troopSquareRecommendAdapter = new TroopSquareRecommendAdapter(Ah().Z1(), COMM.qq_story_unread, null, "em_group_unit", 4, null);
        troopSquareRecommendAdapter.setHasStableIds(true);
        this.groupListAdapter = troopSquareRecommendAdapter;
        com.tencent.mobileqq.troop.troopsquare.common.b bVar3 = new com.tencent.mobileqq.troop.troopsquare.common.b();
        bVar3.setHasStableIds(true);
        bVar3.registerLoadMoreListener(this);
        bVar3.setLoadState(false, true);
        this.loadMoreAdapter = bVar3;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
        com.tencent.mobileqq.troop.troopsquare.topic.adapter.b bVar4 = this.topicInfoAdapter;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicInfoAdapter");
            bVar4 = null;
        }
        adapterArr[0] = bVar4;
        TroopSquareRecommendAdapter troopSquareRecommendAdapter2 = this.groupListAdapter;
        if (troopSquareRecommendAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupListAdapter");
            troopSquareRecommendAdapter2 = null;
        }
        adapterArr[1] = troopSquareRecommendAdapter2;
        com.tencent.mobileqq.troop.troopsquare.common.b bVar5 = this.loadMoreAdapter;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
        } else {
            bVar = bVar5;
        }
        adapterArr[2] = bVar;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rFWConcatAdapter);
        recyclerView.addOnScrollListener(new b(linearLayoutManager, this));
    }

    private final void Fh() {
        this.quiSecNavBar.g(BaseAction.ACTION_CENTER_TEXT).setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(boolean isLoadMore) {
        if (isLoadMore || NetworkUtil.isNetworkAvailable()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TroopSquareTopicFragment$loadData$1(this, isLoadMore, null), 3, null);
        } else {
            Ih();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(String keyword) {
        AppInterface e16;
        FragmentActivity activity = getActivity();
        if (activity == null || (e16 = bg.e()) == null) {
            return;
        }
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openSearchTabPageFromTroopSquare(e16, activity, keyword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        FrameLayout frameLayout;
        View view = getView();
        if (view != null) {
            frameLayout = (FrameLayout) view.findViewById(R.id.f1039061v);
        } else {
            frameLayout = null;
        }
        if (frameLayout == null) {
            return;
        }
        ab.c(zh());
        frameLayout.addView(zh(), -1, -1);
    }

    private final void Jh() {
        FragmentActivity activity = getActivity();
        if (activity != null && RFWImmersiveUtils.isNavigationBarExist(activity.getWindow())) {
            RFWImmersiveUtils.setNavigationBarIconColor(activity.getWindow(), !QQTheme.isNowThemeIsNight());
            RFWImmersiveUtils.setNavigationBarColor(activity.getWindow(), ie0.a.f().g(getContext(), R.color.qui_common_bg_bottom_light, 1000));
        }
    }

    private final void initReport() {
        HashMap hashMapOf;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        com.tencent.mobileqq.troop.troopsquare.common.c cVar = com.tencent.mobileqq.troop.troopsquare.common.c.f301578a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", Long.valueOf(Ah().Z1())), TuplesKt.to("topic_id", Long.valueOf(Ah().S1())), TuplesKt.to("topic_name", Ah().T1()), TuplesKt.to("topic_source", Ah().X1()));
        h.a.d(cVar, activity, "pg_group_square_topic", hashMapOf, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIEmptyState zh() {
        return (QUIEmptyState) this.retryView.getValue();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.troop.troopsquare.topic.part.c());
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            super.doOnCreateView(inflater, container, savedInstanceState);
            initReport();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.i18;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroyView();
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.removeObserver(this.troopMngObserver);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            Gh(true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onResume();
            Jh();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fh();
        Bh(view);
        Eh(view);
        Gh(false);
        Ch();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }
}
