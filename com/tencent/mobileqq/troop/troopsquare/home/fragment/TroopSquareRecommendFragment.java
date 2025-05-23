package com.tencent.mobileqq.troop.troopsquare.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsquare.TroopSquareRecommendAdapter;
import com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$troopMngObserver$2;
import com.tencent.mobileqq.troop.troopsquare.home.view.TroopSquareListLoadingView;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareTabItem;
import java.util.HashMap;
import java.util.List;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0001?\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107R#\u0010>\u001a\n :*\u0004\u0018\u000109098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010+\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010+\u001a\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareRecommendFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initData", "Eh", "", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", "errorMsg", "Hh", "Dh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "Lcom/tencent/mobileqq/troop/troopsquare/home/view/TroopSquareListLoadingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopsquare/home/view/TroopSquareListLoadingView;", "troopSquareListLoadingView", "Lcom/tencent/mobileqq/troop/troopsquare/common/b;", "D", "Lcom/tencent/mobileqq/troop/troopsquare/common/b;", "troopSquareLoadMoreAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recommendRv", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "emptyLayout", "G", "loadingLayout", "", "H", "Lkotlin/Lazy;", "getGroupCode", "()J", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareTabItem;", "I", "Ah", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareTabItem;", "tabItem", "Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter;", "J", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter;", "groupAdapter", "Lcom/tencent/mobileqq/troop/troopsquare/home/vm/e;", "kotlin.jvm.PlatformType", "K", "Ch", "()Lcom/tencent/mobileqq/troop/troopsquare/home/vm/e;", "viewModel", "com/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareRecommendFragment$troopMngObserver$2$a", "L", "Bh", "()Lcom/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareRecommendFragment$troopMngObserver$2$a;", "troopMngObserver", "<init>", "()V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareRecommendFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TroopSquareListLoadingView troopSquareListLoadingView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.troopsquare.common.b troopSquareLoadMoreAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView recommendRv;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout emptyLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private FrameLayout loadingLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupCode;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabItem;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy groupAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopMngObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareRecommendFragment$a;", "", "", "KEY_GROUP_CODE", "Ljava/lang/String;", "KEY_TAB_ITEM_STRING", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareRecommendFragment$b", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ILoadMoreProvider$LoadMoreListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendFragment.this);
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, hasMore);
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                TroopSquareRecommendFragment.this.Ch().O1(TroopSquareRecommendFragment.this.getGroupCode(), TroopSquareRecommendFragment.this.Ah());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61390);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareRecommendFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopSquareLoadMoreAdapter = new com.tencent.mobileqq.troop.troopsquare.common.b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$groupCode$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bundle arguments = TroopSquareRecommendFragment.this.getArguments();
                return Long.valueOf(arguments != null ? arguments.getLong("group_code") : 0L);
            }
        });
        this.groupCode = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GroupSquareTabItem>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$tabItem$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GroupSquareTabItem invoke() {
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (GroupSquareTabItem) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                try {
                    Gson gson = new Gson();
                    Bundle arguments = TroopSquareRecommendFragment.this.getArguments();
                    if (arguments == null || (str = arguments.getString("tab_item")) == null) {
                        str = "";
                    }
                    GroupSquareTabItem groupSquareTabItem = (GroupSquareTabItem) gson.fromJson(str, GroupSquareTabItem.class);
                    return groupSquareTabItem == null ? new GroupSquareTabItem() : groupSquareTabItem;
                } catch (Exception e16) {
                    QLog.e("TroopSquare.Home.TroopSquareRecommendFragment", 1, "error parse tabItem:" + e16);
                    return new GroupSquareTabItem();
                }
            }
        });
        this.tabItem = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSquareRecommendAdapter>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$groupAdapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopSquareRecommendAdapter invoke() {
                HashMap hashMapOf;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TroopSquareRecommendAdapter) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("tab_name", TroopSquareRecommendFragment.this.Ah().txt));
                return new TroopSquareRecommendAdapter(TroopSquareRecommendFragment.this.getGroupCode(), 10201, hashMapOf, null, 8, null);
            }
        });
        this.groupAdapter = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.troopsquare.home.vm.e>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.troop.troopsquare.home.vm.e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.troop.troopsquare.home.vm.e) TroopSquareRecommendFragment.this.getViewModel(com.tencent.mobileqq.troop.troopsquare.home.vm.e.class) : (com.tencent.mobileqq.troop.troopsquare.home.vm.e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.viewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSquareRecommendFragment$troopMngObserver$2.a>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$troopMngObserver$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/fragment/TroopSquareRecommendFragment$troopMngObserver$2$a", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "reqtype", "result", "", "troopUin", "", "l", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a extends com.tencent.mobileqq.troop.api.observer.b {
                static IPatchRedirector $redirector_;
                final /* synthetic */ TroopSquareRecommendFragment I;

                a(TroopSquareRecommendFragment troopSquareRecommendFragment) {
                    this.I = troopSquareRecommendFragment;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareRecommendFragment);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.mobileqq.troop.api.observer.b
                public void l(int reqtype, int result, @Nullable String troopUin) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(reqtype), Integer.valueOf(result), troopUin);
                    } else if (1 == reqtype) {
                        this.I.zh().r0(troopUin);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopSquareRecommendFragment.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.troopMngObserver = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GroupSquareTabItem Ah() {
        return (GroupSquareTabItem) this.tabItem.getValue();
    }

    private final TroopSquareRecommendFragment$troopMngObserver$2.a Bh() {
        return (TroopSquareRecommendFragment$troopMngObserver$2.a) this.troopMngObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.troopsquare.home.vm.e Ch() {
        return (com.tencent.mobileqq.troop.troopsquare.home.vm.e) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh() {
        FrameLayout frameLayout = this.emptyLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
            frameLayout = null;
        }
        if (frameLayout.getVisibility() == 0) {
            RecyclerView recyclerView = this.recommendRv;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendRv");
                recyclerView = null;
            }
            recyclerView.scrollToPosition(0);
        }
        FrameLayout frameLayout3 = this.emptyLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setVisibility(8);
    }

    private final void Eh() {
        LiveData<List<com.tencent.mobileqq.troop.troopsquare.data.a>> M1 = Ch().M1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final TroopSquareRecommendFragment$observe$1 troopSquareRecommendFragment$observe$1 = new TroopSquareRecommendFragment$observe$1(this);
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSquareRecommendFragment.Fh(Function1.this, obj);
            }
        });
        LiveData<Boolean> N1 = Ch().N1();
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.TroopSquareRecommendFragment$observe$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareRecommendFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.troop.troopsquare.common.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                } else {
                    bVar = TroopSquareRecommendFragment.this.troopSquareLoadMoreAdapter;
                    bVar.setLoadState(false, !bool.booleanValue());
                }
            }
        };
        N1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopsquare.home.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSquareRecommendFragment.Gh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(int imageType, String errorMsg) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final long getGroupCode() {
        return ((Number) this.groupCode.getValue()).longValue();
    }

    private final void initData() {
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            Hh(5, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        }
        Ch().O1(getGroupCode(), Ah());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.f169162i15, container, false);
            View findViewById = inflate.findViewById(R.id.f71443o6);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.recommend_rv)");
            this.recommendRv = (RecyclerView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.bwi);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.empty_layout)");
            this.emptyLayout = (FrameLayout) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.loading_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.loading_layout)");
            this.loadingLayout = (FrameLayout) findViewById3;
            FrameLayout frameLayout = this.emptyLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
                frameLayout = null;
            }
            frameLayout.setVisibility(0);
            FrameLayout frameLayout2 = this.loadingLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                frameLayout2 = null;
            }
            frameLayout2.setVisibility(0);
            FrameLayout frameLayout3 = this.loadingLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                frameLayout3 = null;
            }
            Context context = frameLayout3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TroopSquareListLoadingView troopSquareListLoadingView = new TroopSquareListLoadingView(context, null, 0, 6, null);
            this.troopSquareListLoadingView = troopSquareListLoadingView;
            frameLayout3.addView(troopSquareListLoadingView);
            RecyclerView recyclerView = this.recommendRv;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendRv");
                recyclerView = null;
            }
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            com.tencent.mobileqq.troop.troopsquare.common.b bVar = this.troopSquareLoadMoreAdapter;
            bVar.registerLoadMoreListener(new b());
            bVar.setLoadState(false, true);
            Unit unit = Unit.INSTANCE;
            recyclerView.setAdapter(new RFWConcatAdapter(zh(), bVar));
            Eh();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroyView();
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.removeObserver(Bh());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        List<com.tencent.mobileqq.troop.troopsquare.data.a> value = Ch().M1().getValue();
        if (value != null) {
            if (value.isEmpty()) {
                initData();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            initData();
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
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.addObserver(Bh());
        }
    }

    @NotNull
    public final TroopSquareRecommendAdapter zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopSquareRecommendAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (TroopSquareRecommendAdapter) this.groupAdapter.getValue();
    }
}
