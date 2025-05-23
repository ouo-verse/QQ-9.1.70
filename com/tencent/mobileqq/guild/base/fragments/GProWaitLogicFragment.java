package com.tencent.mobileqq.guild.base.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.h;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/base/fragments/GProWaitLogicFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initView", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "qh", "", "needStatusTrans", "needImmersive", "isWrapContent", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onDestroyView", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "D", "loadingView", "Lkotlinx/coroutines/CompletableDeferred;", "E", "Lkotlinx/coroutines/CompletableDeferred;", "gproReadyDeferred", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "serviceObserver", "<init>", "()V", "G", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GProWaitLogicFragment extends QPublicBaseFragment {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final CompletableDeferred<Unit> gproReadyDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver serviceObserver = qh();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JH\u0010\u000b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/base/fragments/GProWaitLogicFragment$Companion;", "", "Landroidx/fragment/app/Fragment;", "Landroid/widget/TextView;", "loadingView", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "waitBlock", "Lkotlin/Function0;", "onRefreshCallback", "a", "(Landroidx/fragment/app/Fragment;Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Fragment fragment, @NotNull TextView loadingView, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> waitBlock, @NotNull Function0<Unit> onRefreshCallback) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(loadingView, "loadingView");
            Intrinsics.checkNotNullParameter(waitBlock, "waitBlock");
            Intrinsics.checkNotNullParameter(onRefreshCallback, "onRefreshCallback");
            Lifecycle lifecycle = fragment.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new GProWaitLogicFragment$Companion$launchWaitGProLogic$1(fragment, loadingView, waitBlock, onRefreshCallback, null));
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/base/fragments/GProWaitLogicFragment$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "onStartGProComplete", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onStartGProComplete() {
            Logger.f235387a.d().i("GProWaitLogicFragment", 1, "onStartGProComplete()");
            GProWaitLogicFragment.this.gproReadyDeferred.complete(Unit.INSTANCE);
        }
    }

    private final void initView() {
        View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(getActivity(), false);
        Intrinsics.checkNotNullExpressionValue(loadingDialogTipsRight, "getLoadingDialogTipsRight(activity, false)");
        this.loadingView = loadingDialogTipsRight;
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        view.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        FrameLayout frameLayout = (FrameLayout) view3.findViewById(R.id.ef_);
        View view4 = this.loadingView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            view2 = view4;
        }
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        ImmersiveUtils.clearCoverForStatus(requireActivity().getWindow(), true);
        h.c(this);
    }

    private final GPServiceObserver qh() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168097es4;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.f235387a.d().d("GProWaitLogicFragment", 1, "onCreate! " + getLifecycle().getCurrentState());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGProGlobalService) S0).addObserver(this.serviceObserver);
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Intrinsics.checkNotNull(onCreateView, "null cannot be cast to non-null type android.view.View");
        this.rootView = onCreateView;
        initView();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGProGlobalService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        ((IGProGlobalService) S0).deleteObserver(this.serviceObserver);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.f235387a.d().d("GProWaitLogicFragment", 1, "onResume! " + getLifecycle().getCurrentState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.loadingView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            view2 = null;
        }
        TextView textView = (TextView) view2.findViewById(R.id.yt9);
        if (textView == null) {
            View findViewById = view.findViewById(R.id.efo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.loading_text)");
            textView = (TextView) findViewById;
        }
        INSTANCE.a(this, textView, new GProWaitLogicFragment$onViewCreated$1(this, null), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.base.fragments.GProWaitLogicFragment$onViewCreated$2
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
                FragmentActivity activity = GProWaitLogicFragment.this.getActivity();
                if (activity != null) {
                    activity.recreate();
                }
            }
        });
    }
}
