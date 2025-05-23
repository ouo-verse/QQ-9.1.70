package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.msglist.IGuildAIOLinkSpanApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.aisearch.AIChatListPart;
import com.tencent.mobileqq.guild.aisearch.views.AIReplyView;
import com.tencent.mobileqq.guild.config.GuildSearchConfBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.quicksearch.adapter.BaseQuickSearchViewHolder;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.at;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001H\u0018\u0000 S2\u00020\u0001:\u0001TB\u000f\u0012\u0006\u0010P\u001a\u00020\u0002\u00a2\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\rH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\u001e\u0010*\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(J\b\u0010+\u001a\u00020\u0004H\u0014J\b\u0010,\u001a\u00020\u0004H\u0014J\u0006\u0010-\u001a\u00020\u0004R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00105R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00107R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010=R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00100L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAIViewHolder;", "Lcom/tencent/mobileqq/guild/quicksearch/adapter/BaseQuickSearchViewHolder;", "Landroid/view/View;", "topView", "", "H", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/p;", "data", "M", "Landroid/widget/ImageView;", "apngView", "i0", "c0", "", "rawContent", "I", "", "resume", "e0", "reasonContent", "L", "Lcom/tencent/android/androidbypass/parser/a;", "Z", "isShowExpandedBtn", "f0", "N", "bindReport", "eid", "view", "O", "K", "", "state", "a0", "containerView", "P", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "feedData", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MosaicConstants$JsFunction.FUNC_ON_DESTROY, tl.h.F, "Lvp1/at;", "G", "Lvp1/at;", "binding", "Lcom/tencent/android/androidbypass/parser/a;", "markdownParser", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "bindJob", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchViewModel;", "isExpanded", "Lcom/tencent/android/androidbypass/enhance/i;", "Lcom/tencent/android/androidbypass/enhance/i;", "styleSheet", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAICardFeedBackPopupWindow;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAICardFeedBackPopupWindow;", "feedBackPopupWindow", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/p;", "dsViewData", "Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "b0", "()Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean;", "searchConfig", "com/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAIViewHolder$d", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAIViewHolder$d;", "sHttpUrlClickDispatcher", "Landroidx/lifecycle/Observer;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/Observer;", "expandedBtnObserver", "itemView", "<init>", "(Landroid/view/View;)V", "T", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DSAIViewHolder extends BaseQuickSearchViewHolder {

    /* renamed from: G, reason: from kotlin metadata */
    private at binding;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.parser.a markdownParser;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Job bindJob;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private DSSearchViewModel viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isExpanded;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.android.androidbypass.enhance.i styleSheet;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private DSAICardFeedBackPopupWindow feedBackPopupWindow;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private IGProGuildSearchAISearchInfo feedData;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private DSSearchData dsViewData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchConfig;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final d sHttpUrlClickDispatcher;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Observer<Boolean> expandedBtnObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f231652d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DSAIViewHolder f231653e;

        public c(View view, DSAIViewHolder dSAIViewHolder) {
            this.f231652d = view;
            this.f231653e = dSAIViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean z16;
            float f16;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                DSSearchViewModel dSSearchViewModel = this.f231653e.viewModel;
                Intrinsics.checkNotNull(dSSearchViewModel);
                if (!Intrinsics.areEqual(dSSearchViewModel.X1().getValue(), Boolean.TRUE)) {
                    DSSearchData dSSearchData = this.f231653e.dsViewData;
                    if (dSSearchData != null && dSSearchData.g()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.f231653e.e0(false);
                        at atVar = this.f231653e.binding;
                        at atVar2 = null;
                        if (atVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            atVar = null;
                        }
                        atVar.f442310x.getRootView().requestFocus();
                        at atVar3 = this.f231653e.binding;
                        if (atVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            atVar3 = null;
                        }
                        ViewPropertyAnimator animate = atVar3.f442307u.animate();
                        if (this.f231653e.isExpanded) {
                            f16 = 180.0f;
                        } else {
                            f16 = 0.0f;
                        }
                        animate.rotation(f16).setDuration(300L).start();
                        te1.g gVar = te1.g.f435886a;
                        at atVar4 = this.f231653e.binding;
                        if (atVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            atVar2 = atVar4;
                        }
                        AIReplyView aIReplyView = atVar2.f442305s;
                        Intrinsics.checkNotNullExpressionValue(aIReplyView, "binding.reasonContent");
                        gVar.b(aIReplyView, new b());
                        DSAIViewHolder dSAIViewHolder = this.f231653e;
                        dSAIViewHolder.isExpanded = true ^ dSAIViewHolder.isExpanded;
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAIViewHolder$d", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.c f231654a = new com.tencent.android.androidbypass.enhance.scheme.matcher.c();

        d() {
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f231654a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
            AppRuntime peekAppRuntime;
            String str;
            if (url != null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
                DSAIViewHolder dSAIViewHolder = DSAIViewHolder.this;
                IGuildAIOLinkSpanApi iGuildAIOLinkSpanApi = (IGuildAIOLinkSpanApi) QRoute.api(IGuildAIOLinkSpanApi.class);
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                iGuildAIOLinkSpanApi.onInlineBtnClick(peekAppRuntime, context, url);
                VideoReport.setElementId(view, "em_sgrp_ai_search_result_forum_url");
                HashMap hashMap = new HashMap();
                hashMap.put("sgrp_url", url);
                IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo = dSAIViewHolder.feedData;
                if (iGProGuildSearchAISearchInfo == null || (str = kw1.a.f413327a.c(iGProGuildSearchAISearchInfo)) == null) {
                    str = "";
                }
                hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, str);
                Unit unit = Unit.INSTANCE;
                VideoReport.reportEvent("clck", view, hashMap);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSAIViewHolder(@NotNull View itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.isExpanded = true;
        com.tencent.android.androidbypass.enhance.i iVar = new com.tencent.android.androidbypass.enhance.i();
        iVar.f72206v = BaseApplication.getContext().getColor(R.color.qui_common_brand_standard);
        iVar.B = 4;
        iVar.C = 1;
        iVar.f72209y = 0.875f;
        iVar.f72205u = BaseApplication.getContext().getColor(R.color.qui_common_text_secondary);
        iVar.f72208x = 0.65f;
        iVar.f72207w = 0.1f;
        iVar.f72184e = 15.0f;
        this.styleSheet = iVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildSearchConfBean>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSAIViewHolder$searchConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSearchConfBean invoke() {
                return GuildSearchConfBean.INSTANCE.a();
            }
        });
        this.searchConfig = lazy;
        this.sHttpUrlClickDispatcher = new d();
        this.expandedBtnObserver = new Observer() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DSAIViewHolder.Y(DSAIViewHolder.this, (Boolean) obj);
            }
        };
    }

    private final void H(View topView) {
        at atVar = this.binding;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar = null;
        }
        atVar.f442290d.setVisibility(0);
        at atVar3 = this.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar3 = null;
        }
        ViewGroup.LayoutParams layoutParams = atVar3.f442290d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.topToBottom = topView.getId();
        at atVar4 = this.binding;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar2 = atVar4;
        }
        atVar2.f442290d.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String rawContent) {
        boolean z16;
        DSSearchViewModel dSSearchViewModel;
        MutableLiveData<Boolean> U1;
        Boolean bool;
        MutableLiveData<Boolean> U12;
        String d16 = b0().d(rawContent);
        com.tencent.android.androidbypass.parser.a Z = Z();
        at atVar = null;
        if (Z != null) {
            at atVar2 = this.binding;
            if (atVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar2 = null;
            }
            a.C0724a.a(Z, d16, atVar2.f442292f, null, 4, null);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            int length = d16.length();
            at atVar3 = this.binding;
            if (atVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar3 = null;
            }
            int lineCount = atVar3.f442292f.getLineCount();
            DSSearchViewModel dSSearchViewModel2 = this.viewModel;
            if (dSSearchViewModel2 != null && (U12 = dSSearchViewModel2.U1()) != null) {
                bool = U12.getValue();
            } else {
                bool = null;
            }
            Log.d("QQGuildInSearchTag.DSAIViewHolder", "bindContent: (" + length + ") line=" + lineCount + ", hasShow=" + bool);
        }
        DSSearchViewModel dSSearchViewModel3 = this.viewModel;
        if (dSSearchViewModel3 != null && (U1 = dSSearchViewModel3.U1()) != null) {
            z16 = Intrinsics.areEqual(U1.getValue(), Boolean.TRUE);
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        at atVar4 = this.binding;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar4 = null;
        }
        int lineCount2 = atVar4.f442292f.getLineCount();
        at atVar5 = this.binding;
        if (atVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar = atVar5;
        }
        if (lineCount2 + atVar.f442305s.getLineCount() > 9 && (dSSearchViewModel = this.viewModel) != null) {
            dSSearchViewModel.c2(true);
        }
    }

    private final void K() {
        at atVar = this.binding;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar = null;
        }
        VideoReport.setElementId(atVar.f442295i, "em_sgrp_ai_search_result_fail_refresh");
        at atVar3 = this.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar3 = null;
        }
        String valueOf = String.valueOf(atVar3.f442295i.hashCode());
        at atVar4 = this.binding;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar4 = null;
        }
        VideoReport.setElementReuseIdentifier(atVar4.f442295i, valueOf);
        at atVar5 = this.binding;
        if (atVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar2 = atVar5;
        }
        VideoReport.setElementClickPolicy(atVar2.f442295i, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(String reasonContent) {
        boolean z16;
        DSSearchViewModel dSSearchViewModel;
        MutableLiveData<Boolean> U1;
        com.tencent.android.androidbypass.parser.a Z = Z();
        at atVar = null;
        if (Z != null) {
            at atVar2 = this.binding;
            if (atVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar2 = null;
            }
            a.C0724a.a(Z, reasonContent, atVar2.f442305s, null, 4, null);
        }
        DSSearchViewModel dSSearchViewModel2 = this.viewModel;
        if (dSSearchViewModel2 != null && (U1 = dSSearchViewModel2.U1()) != null) {
            z16 = Intrinsics.areEqual(U1.getValue(), Boolean.TRUE);
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        at atVar3 = this.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar = atVar3;
        }
        if (atVar.f442305s.getLineCount() > 9 && (dSSearchViewModel = this.viewModel) != null) {
            dSSearchViewModel.c2(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(DSSearchData data) {
        MutableLiveData<Boolean> X1;
        Boolean bool;
        MutableLiveData<Boolean> X12;
        MutableLiveData<Boolean> X13;
        boolean z16 = true;
        boolean z17 = false;
        at atVar = null;
        switch (data.getState()) {
            case 1:
                L("");
                I("");
                at atVar2 = this.binding;
                if (atVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar2 = null;
                }
                atVar2.f442303q.setVisibility(0);
                at atVar3 = this.binding;
                if (atVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar3 = null;
                }
                atVar3.f442295i.setVisibility(8);
                at atVar4 = this.binding;
                if (atVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar4 = null;
                }
                atVar4.f442292f.setVisibility(8);
                at atVar5 = this.binding;
                if (atVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar5 = null;
                }
                atVar5.f442305s.setVisibility(8);
                at atVar6 = this.binding;
                if (atVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar6 = null;
                }
                atVar6.f442296j.setVisibility(8);
                at atVar7 = this.binding;
                if (atVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar7 = null;
                }
                atVar7.f442310x.setVisibility(8);
                at atVar8 = this.binding;
                if (atVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar8 = null;
                }
                atVar8.f442290d.setVisibility(8);
                at atVar9 = this.binding;
                if (atVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar9 = null;
                }
                atVar9.f442302p.setText(o.INSTANCE.a().getLoadingText());
                at atVar10 = this.binding;
                if (atVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    atVar = atVar10;
                }
                ImageView imageView = atVar.f442301o;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.loadingIv");
                i0(imageView);
                this.isExpanded = true;
                return;
            case 2:
                at atVar11 = this.binding;
                if (atVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar11 = null;
                }
                atVar11.f442305s.setFocusable(false);
                at atVar12 = this.binding;
                if (atVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar12 = null;
                }
                atVar12.f442305s.setTextIsSelectable(false);
                at atVar13 = this.binding;
                if (atVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar13 = null;
                }
                atVar13.f442303q.setVisibility(8);
                at atVar14 = this.binding;
                if (atVar14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar14 = null;
                }
                atVar14.f442295i.setVisibility(8);
                at atVar15 = this.binding;
                if (atVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar15 = null;
                }
                atVar15.f442305s.setVisibility(0);
                at atVar16 = this.binding;
                if (atVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar16 = null;
                }
                atVar16.f442310x.setVisibility(0);
                at atVar17 = this.binding;
                if (atVar17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar17 = null;
                }
                atVar17.f442292f.setVisibility(8);
                at atVar18 = this.binding;
                if (atVar18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar18 = null;
                }
                atVar18.f442309w.setText(this.itemView.getContext().getString(R.string.f157701nm));
                at atVar19 = this.binding;
                if (atVar19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar19 = null;
                }
                ImageView imageView2 = atVar19.f442311y;
                Intrinsics.checkNotNullExpressionValue(imageView2, "binding.thinkingIcon");
                i0(imageView2);
                DSSearchViewModel dSSearchViewModel = this.viewModel;
                if (dSSearchViewModel != null && (X1 = dSSearchViewModel.X1()) != null) {
                    z17 = Intrinsics.areEqual(X1.getValue(), Boolean.TRUE);
                }
                if (z17) {
                    at atVar20 = this.binding;
                    if (atVar20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        atVar20 = null;
                    }
                    atVar20.f442305s.setMaxLines(9);
                    at atVar21 = this.binding;
                    if (atVar21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        atVar21 = null;
                    }
                    atVar21.f442293g.setDrawSize(ViewUtils.dip2px(24.0f));
                } else {
                    at atVar22 = this.binding;
                    if (atVar22 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        atVar22 = null;
                    }
                    atVar22.f442305s.setMaxLines(Integer.MAX_VALUE);
                }
                at atVar23 = this.binding;
                if (atVar23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    atVar = atVar23;
                }
                FadeFrameLayout fadeFrameLayout = atVar.f442293g;
                Intrinsics.checkNotNullExpressionValue(fadeFrameLayout, "binding.contentWrapper");
                H(fadeFrameLayout);
                return;
            case 3:
            default:
                return;
            case 4:
                at atVar24 = this.binding;
                if (atVar24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar24 = null;
                }
                atVar24.f442292f.setFocusable(false);
                at atVar25 = this.binding;
                if (atVar25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar25 = null;
                }
                atVar25.f442292f.setTextIsSelectable(false);
                if (data.getReasonContent().length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    at atVar26 = this.binding;
                    if (atVar26 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        atVar26 = null;
                    }
                    atVar26.f442305s.setVisibility(8);
                    at atVar27 = this.binding;
                    if (atVar27 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        atVar27 = null;
                    }
                    atVar27.f442310x.setVisibility(8);
                    at atVar28 = this.binding;
                    if (atVar28 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        atVar28 = null;
                    }
                    atVar28.f442305s.setVisibility(8);
                } else {
                    at atVar29 = this.binding;
                    if (atVar29 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        atVar29 = null;
                    }
                    atVar29.f442310x.setVisibility(0);
                    c0(data);
                }
                at atVar30 = this.binding;
                if (atVar30 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar30 = null;
                }
                atVar30.f442303q.setVisibility(8);
                at atVar31 = this.binding;
                if (atVar31 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar31 = null;
                }
                atVar31.f442295i.setVisibility(8);
                DSSearchViewModel dSSearchViewModel2 = this.viewModel;
                if (dSSearchViewModel2 == null || (X12 = dSSearchViewModel2.X1()) == null || (bool = X12.getValue()) == null) {
                    bool = Boolean.FALSE;
                }
                f0(bool.booleanValue());
                at atVar32 = this.binding;
                if (atVar32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    atVar = atVar32;
                }
                FadeFrameLayout fadeFrameLayout2 = atVar.f442293g;
                Intrinsics.checkNotNullExpressionValue(fadeFrameLayout2, "binding.contentWrapper");
                H(fadeFrameLayout2);
                return;
            case 5:
                DSSearchViewModel dSSearchViewModel3 = this.viewModel;
                if (dSSearchViewModel3 != null && (X13 = dSSearchViewModel3.X1()) != null) {
                    z17 = Intrinsics.areEqual(X13.getValue(), Boolean.FALSE);
                }
                if (z17) {
                    e0(true);
                    return;
                }
                return;
            case 6:
                at atVar33 = this.binding;
                if (atVar33 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar33 = null;
                }
                atVar33.f442303q.setVisibility(8);
                at atVar34 = this.binding;
                if (atVar34 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar34 = null;
                }
                atVar34.f442295i.setVisibility(0);
                at atVar35 = this.binding;
                if (atVar35 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar35 = null;
                }
                atVar35.f442292f.setVisibility(8);
                at atVar36 = this.binding;
                if (atVar36 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar36 = null;
                }
                atVar36.f442305s.setVisibility(8);
                at atVar37 = this.binding;
                if (atVar37 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar37 = null;
                }
                atVar37.f442310x.setVisibility(8);
                at atVar38 = this.binding;
                if (atVar38 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar38 = null;
                }
                atVar38.f442294h.setText(a0(6));
                at atVar39 = this.binding;
                if (atVar39 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar39 = null;
                }
                LinearLayout linearLayout = atVar39.f442295i;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
                H(linearLayout);
                at atVar40 = this.binding;
                if (atVar40 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar40 = null;
                }
                VideoReport.reportEvent("imp", atVar40.f442295i, null);
                return;
            case 7:
                at atVar41 = this.binding;
                if (atVar41 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar41 = null;
                }
                atVar41.f442303q.setVisibility(8);
                at atVar42 = this.binding;
                if (atVar42 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar42 = null;
                }
                atVar42.f442295i.setVisibility(0);
                at atVar43 = this.binding;
                if (atVar43 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar43 = null;
                }
                atVar43.f442306t.setVisibility(8);
                at atVar44 = this.binding;
                if (atVar44 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar44 = null;
                }
                atVar44.f442292f.setVisibility(8);
                at atVar45 = this.binding;
                if (atVar45 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar45 = null;
                }
                atVar45.f442305s.setVisibility(8);
                at atVar46 = this.binding;
                if (atVar46 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar46 = null;
                }
                atVar46.f442310x.setVisibility(8);
                at atVar47 = this.binding;
                if (atVar47 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar47 = null;
                }
                atVar47.f442294h.setText(a0(7));
                at atVar48 = this.binding;
                if (atVar48 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar48 = null;
                }
                LinearLayout linearLayout2 = atVar48.f442295i;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
                H(linearLayout2);
                at atVar49 = this.binding;
                if (atVar49 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar49 = null;
                }
                VideoReport.reportEvent("imp", atVar49.f442295i, null);
                return;
            case 8:
                at atVar50 = this.binding;
                if (atVar50 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar50 = null;
                }
                atVar50.f442303q.setVisibility(8);
                at atVar51 = this.binding;
                if (atVar51 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar51 = null;
                }
                atVar51.f442295i.setVisibility(0);
                at atVar52 = this.binding;
                if (atVar52 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar52 = null;
                }
                atVar52.f442292f.setVisibility(8);
                at atVar53 = this.binding;
                if (atVar53 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar53 = null;
                }
                atVar53.f442305s.setVisibility(8);
                at atVar54 = this.binding;
                if (atVar54 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar54 = null;
                }
                atVar54.f442310x.setVisibility(8);
                at atVar55 = this.binding;
                if (atVar55 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar55 = null;
                }
                atVar55.f442294h.setText(a0(8));
                at atVar56 = this.binding;
                if (atVar56 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar56 = null;
                }
                LinearLayout linearLayout3 = atVar56.f442295i;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.errorView");
                H(linearLayout3);
                at atVar57 = this.binding;
                if (atVar57 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar57 = null;
                }
                VideoReport.reportEvent("imp", atVar57.f442295i, null);
                return;
        }
    }

    private final void N() {
        IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo;
        DSSearchViewModel dSSearchViewModel = this.viewModel;
        at atVar = null;
        if (dSSearchViewModel != null) {
            iGProGuildSearchAISearchInfo = dSSearchViewModel.getAiSearchInfo();
        } else {
            iGProGuildSearchAISearchInfo = null;
        }
        if (iGProGuildSearchAISearchInfo == null) {
            QLog.d("QQGuildInSearchTag.DSAIViewHolder", 1, "bindTitle fail, plz check info");
            at atVar2 = this.binding;
            if (atVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                atVar = atVar2;
            }
            atVar.A.setVisibility(8);
            return;
        }
        at atVar3 = this.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar3 = null;
        }
        atVar3.f442312z.setText(iGProGuildSearchAISearchInfo.getTitle());
        at atVar4 = this.binding;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar = atVar4;
        }
        atVar.A.setVisibility(0);
    }

    private final void O(String eid, View view) {
        VideoReport.setElementId(view, eid);
        VideoReport.setElementReuseIdentifier(view, String.valueOf(view.hashCode()));
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(DSAIViewHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DSSearchViewModel dSSearchViewModel = this$0.viewModel;
        if (dSSearchViewModel != null) {
            dSSearchViewModel.c2(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(DSAIViewHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DSSearchViewModel dSSearchViewModel = this$0.viewModel;
        if (dSSearchViewModel != null) {
            dSSearchViewModel.b2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(DSAIViewHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DSSearchViewModel dSSearchViewModel = this$0.viewModel;
        if (dSSearchViewModel != null) {
            dSSearchViewModel.b2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(DSAIViewHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DSSearchViewModel dSSearchViewModel = this$0.viewModel;
        if (dSSearchViewModel != null) {
            dSSearchViewModel.b2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(DSAIViewHolder this$0, View view, View it) {
        ArrayList<SearchText> arrayList;
        DSAICardFeedBackPopupWindow dSAICardFeedBackPopupWindow;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (this$0.feedBackPopupWindow == null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            DSAICardFeedBackPopupWindow dSAICardFeedBackPopupWindow2 = new DSAICardFeedBackPopupWindow(context);
            this$0.feedBackPopupWindow = dSAICardFeedBackPopupWindow2;
            dSAICardFeedBackPopupWindow2.x(al.a(view.getContext(), 28.0f), -al.a(view.getContext(), 5.0f));
            DSAICardFeedBackPopupWindow dSAICardFeedBackPopupWindow3 = this$0.feedBackPopupWindow;
            if (dSAICardFeedBackPopupWindow3 != null) {
                dSAICardFeedBackPopupWindow3.y(13.0f);
            }
        }
        DSSearchViewModel dSSearchViewModel = this$0.viewModel;
        if (dSSearchViewModel == null || (arrayList = dSSearchViewModel.T1()) == null) {
            arrayList = new ArrayList<>();
        }
        if ((!arrayList.isEmpty()) && (dSAICardFeedBackPopupWindow = this$0.feedBackPopupWindow) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dSAICardFeedBackPopupWindow.A(it, arrayList);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(DSAIViewHolder this$0, Boolean isShowExpandedBtn) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.a d16 = Logger.f235387a.d();
        at atVar = this$0.binding;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar = null;
        }
        d16.i("QQGuildInSearchTag.DSAIViewHolder", 1, "expandedBtnObserver: " + isShowExpandedBtn + " line=" + atVar.f442292f.getLineCount());
        Intrinsics.checkNotNullExpressionValue(isShowExpandedBtn, "isShowExpandedBtn");
        boolean z16 = false;
        if (isShowExpandedBtn.booleanValue()) {
            at atVar3 = this$0.binding;
            if (atVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar3 = null;
            }
            VideoReport.reportEvent("imp", atVar3.f442298l, null);
            at atVar4 = this$0.binding;
            if (atVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                atVar2 = atVar4;
            }
            atVar2.f442296j.setVisibility(0);
        } else {
            at atVar5 = this$0.binding;
            if (atVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                atVar2 = atVar5;
            }
            atVar2.f442296j.setVisibility(8);
            DSSearchData dSSearchData = this$0.dsViewData;
            if (dSSearchData != null && dSSearchData.g()) {
                z16 = true;
            }
            if (z16) {
                this$0.e0(true);
            }
        }
        this$0.f0(isShowExpandedBtn.booleanValue());
    }

    private final com.tencent.android.androidbypass.parser.a Z() {
        List<? extends com.tencent.android.androidbypass.parser.api.b> listOf;
        if (this.markdownParser == null) {
            com.tencent.android.androidbypass.parser.d j3 = com.tencent.qqnt.markdown.g.f359430a.g().j(com.tencent.guild.aio.msglist.text.util.f.f(com.tencent.guild.aio.msglist.text.util.f.f111944a, false, 1, null));
            listOf = CollectionsKt__CollectionsJVMKt.listOf(this.sHttpUrlClickDispatcher);
            this.markdownParser = j3.e(listOf).h(this.styleSheet).b();
        }
        return this.markdownParser;
    }

    private final String a0(int state) {
        String W1;
        if (state != 6) {
            if (state != 7) {
                if (state != 8) {
                    return "";
                }
                return "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
            }
            DSSearchViewModel dSSearchViewModel = this.viewModel;
            if (dSSearchViewModel == null || (W1 = dSSearchViewModel.W1()) == null) {
                return "\u62b1\u6b49\uff0c\u5f53\u524d\u95ee\u9898\u6211\u6682\u65f6\u65e0\u6cd5\u56de\u7b54\uff0c\u8bf7\u6362\u4e2a\u95ee\u9898\u91cd\u8bd5\u3002";
            }
            return W1;
        }
        return "\u62b1\u6b49\uff0c\u6211\u6682\u65f6\u65e0\u6cd5\u56de\u7b54\u4f60\u7684\u95ee\u9898\u3002\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002";
    }

    private final GuildSearchConfBean b0() {
        return (GuildSearchConfBean) this.searchConfig.getValue();
    }

    private final void bindReport() {
        at atVar = this.binding;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar = null;
        }
        FrameLayout frameLayout = atVar.f442299m;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.feedbackEntry");
        O("em_sgrp_ai_search_result_feedback", frameLayout);
        at atVar3 = this.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar3 = null;
        }
        TextView textView = atVar3.f442298l;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.expandTv");
        O("em_sgrp_ai_search_result_expand", textView);
        at atVar4 = this.binding;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar2 = atVar4;
        }
        LinearLayout linearLayout = atVar2.f442304r;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.mkLl");
        O("em_sgrp_ai_search_result", linearLayout);
        K();
    }

    private final void c0(DSSearchData data) {
        boolean z16;
        at atVar = this.binding;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar = null;
        }
        ImageView thinkingIcon = atVar.f442311y;
        Intrinsics.checkNotNullExpressionValue(thinkingIcon, "thinkingIcon");
        if (thinkingIcon.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView thinkingIcon2 = atVar.f442311y;
            Intrinsics.checkNotNullExpressionValue(thinkingIcon2, "thinkingIcon");
            te1.c.c(thinkingIcon2, 0L, 1, null);
            ImageView thinkFinishIcon = atVar.f442308v;
            Intrinsics.checkNotNullExpressionValue(thinkFinishIcon, "thinkFinishIcon");
            te1.c.f(thinkFinishIcon, 0L, 1, null);
        } else {
            atVar.f442311y.setVisibility(8);
            atVar.f442308v.setVisibility(0);
        }
        TextView textView = atVar.f442309w;
        textView.setText(textView.getContext().getString(R.string.f157691nl, Integer.valueOf(data.i())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(DSAIViewHolder this$0) {
        View view;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        at atVar = this$0.binding;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar = null;
        }
        Object parent = atVar.f442305s.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            i3 = view.getWidth();
        } else {
            i3 = UIUtil.f112434a.x().getDisplayMetrics().widthPixels;
        }
        at atVar3 = this$0.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar3 = null;
        }
        atVar3.f442305s.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        at atVar4 = this$0.binding;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar4 = null;
        }
        atVar4.f442305s.getLayoutParams().height = -2;
        at atVar5 = this$0.binding;
        if (atVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar2 = atVar5;
        }
        atVar2.f442305s.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(boolean resume) {
        at atVar = this.binding;
        at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar = null;
        }
        atVar.f442305s.setFocusable(resume);
        at atVar3 = this.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar3 = null;
        }
        atVar3.f442305s.setTextIsSelectable(resume);
        at atVar4 = this.binding;
        if (atVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar4 = null;
        }
        atVar4.f442292f.setFocusable(resume);
        at atVar5 = this.binding;
        if (atVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar2 = atVar5;
        }
        atVar2.f442292f.setTextIsSelectable(resume);
    }

    private final void f0(boolean isShowExpandedBtn) {
        at atVar = null;
        if (isShowExpandedBtn) {
            at atVar2 = this.binding;
            if (atVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar2 = null;
            }
            atVar2.f442305s.setMaxLines(9);
            at atVar3 = this.binding;
            if (atVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar3 = null;
            }
            if (atVar3.f442305s.getLineCount() >= 9) {
                at atVar4 = this.binding;
                if (atVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar4 = null;
                }
                atVar4.f442292f.setVisibility(8);
            } else {
                at atVar5 = this.binding;
                if (atVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar5 = null;
                }
                AIReplyView aIReplyView = atVar5.f442292f;
                at atVar6 = this.binding;
                if (atVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar6 = null;
                }
                aIReplyView.setMaxLines(9 - atVar6.f442305s.getLineCount());
                at atVar7 = this.binding;
                if (atVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    atVar7 = null;
                }
                atVar7.f442292f.setVisibility(0);
            }
            at atVar8 = this.binding;
            if (atVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                atVar = atVar8;
            }
            atVar.f442293g.setDrawSize(ViewUtils.dip2px(24.0f));
            return;
        }
        at atVar9 = this.binding;
        if (atVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar9 = null;
        }
        atVar9.f442305s.setMaxLines(Integer.MAX_VALUE);
        at atVar10 = this.binding;
        if (atVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar10 = null;
        }
        atVar10.f442292f.setMaxLines(Integer.MAX_VALUE);
        at atVar11 = this.binding;
        if (atVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar11 = null;
        }
        atVar11.f442292f.setVisibility(0);
        at atVar12 = this.binding;
        if (atVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar = atVar12;
        }
        atVar.f442293g.setDrawSize(0.0f);
    }

    private final void i0(ImageView apngView) {
        boolean z16;
        if (apngView.getVisibility() == 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            apngView.setVisibility(0);
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setRequestWidth(apngView.getWidth());
            apngOptions.setRequestHeight(apngView.getHeight());
            apngView.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("MsgStateController", AIChatListPart.INSTANCE.a(), apngOptions));
        }
    }

    public final void J(@NotNull IGProGuildSearchAISearchInfo feedData, @NotNull DSSearchViewModel viewModel, @NotNull LifecycleOwner lifecycle) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        h();
        this.feedData = feedData;
        Job job = this.bindJob;
        at atVar = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        DSSearchViewModel dSSearchViewModel = this.viewModel;
        if (dSSearchViewModel != null) {
            dSSearchViewModel.X1().removeObserver(this.expandedBtnObserver);
        }
        this.bindJob = FlowKt.launchIn(FlowKt.onEach(com.tencent.mobileqq.guild.base.extension.FlowKt.b(DSSearchViewModelKt.a(viewModel.Q1(), 80L, 2), 500L, new Function1<DSSearchData, Boolean>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSAIViewHolder$bindData$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull DSSearchData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.g());
            }
        }), new DSAIViewHolder$bindData$3(this, null)), LifecycleOwnerKt.getLifecycleScope(lifecycle));
        this.viewModel = viewModel;
        viewModel.X1().observe(lifecycle, this.expandedBtnObserver);
        IGProGuildSearchAISearchInfo aiSearchInfo = viewModel.getAiSearchInfo();
        if (aiSearchInfo == null) {
            return;
        }
        at atVar2 = this.binding;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            atVar2 = null;
        }
        atVar2.f442291e.setText(aiSearchInfo.getBottomTitle());
        N();
        at atVar3 = this.binding;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            atVar = atVar3;
        }
        atVar.B.setText(aiSearchInfo.getLabel());
    }

    public final void P(@Nullable final View containerView) {
        if (containerView != null) {
            at e16 = at.e(containerView);
            Intrinsics.checkNotNullExpressionValue(e16, "bind(view)");
            this.binding = e16;
            bindReport();
            at atVar = this.binding;
            at atVar2 = null;
            if (atVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar = null;
            }
            ImageView imageView = atVar.f442300n;
            at atVar3 = this.binding;
            if (atVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar3 = null;
            }
            imageView.setColorFilter(new PorterDuffColorFilter(atVar3.f442300n.getContext().getColor(R.color.qui_common_text_primary), PorterDuff.Mode.SRC_IN));
            at atVar4 = this.binding;
            if (atVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar4 = null;
            }
            atVar4.B.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAIViewHolder.R(DSAIViewHolder.this, view);
                }
            });
            at atVar5 = this.binding;
            if (atVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar5 = null;
            }
            atVar5.f442312z.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAIViewHolder.T(DSAIViewHolder.this, view);
                }
            });
            at atVar6 = this.binding;
            if (atVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar6 = null;
            }
            atVar6.f442295i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAIViewHolder.U(DSAIViewHolder.this, view);
                }
            });
            at atVar7 = this.binding;
            if (atVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar7 = null;
            }
            atVar7.f442299m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAIViewHolder.W(DSAIViewHolder.this, containerView, view);
                }
            });
            at atVar8 = this.binding;
            if (atVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar8 = null;
            }
            ImageView imageView2 = atVar8.f442300n;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.loadingIcon");
            v.l("https://downv6.qq.com/innovate/search/search_ai_loading_ispt.png", imageView2, null, 4, null);
            at atVar9 = this.binding;
            if (atVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                atVar9 = null;
            }
            atVar9.f442298l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DSAIViewHolder.Q(DSAIViewHolder.this, view);
                }
            });
            at atVar10 = this.binding;
            if (atVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                atVar2 = atVar10;
            }
            LinearLayout linearLayout = atVar2.f442310x;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.thinkTipsLl");
            linearLayout.setOnClickListener(new c(linearLayout, this));
        }
    }

    public final void h() {
        this.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.n
            @Override // java.lang.Runnable
            public final void run() {
                DSAIViewHolder.d0(DSAIViewHolder.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.quicksearch.adapter.BaseQuickSearchViewHolder
    protected void m() {
        super.m();
        Logger.f235387a.d().i("QQGuildInSearchTag.DSAIViewHolder", 1, "onCreate");
    }

    @Override // com.tencent.mobileqq.guild.quicksearch.adapter.BaseQuickSearchViewHolder
    protected void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().i("QQGuildInSearchTag.DSAIViewHolder", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        DSAICardFeedBackPopupWindow dSAICardFeedBackPopupWindow = this.feedBackPopupWindow;
        if (dSAICardFeedBackPopupWindow != null) {
            dSAICardFeedBackPopupWindow.r();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSAIViewHolder$b", "Lcom/tencent/qqnt/aio/anisticker/drawable/g;", "", "repeatedCount", "", "a", "", "endAnimation", DKHippyEvent.EVENT_STOP, "onStart", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.qqnt.aio.anisticker.drawable.g {
        b() {
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStop(boolean endAnimation) {
            DSAIViewHolder.this.e0(true);
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void onStart() {
        }

        @Override // com.tencent.qqnt.aio.anisticker.drawable.g
        public void a(int repeatedCount) {
        }
    }
}
