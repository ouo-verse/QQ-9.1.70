package com.tencent.biz.qqcircle.immersive.feed.live.ecommerce;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper;
import com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModel;
import com.tencent.mobileqq.qqecommerce.biz.nv.api.INVViewModelFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b3\u00104J?\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002J&\u0010\u000f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007J$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J\u0006\u0010\u001d\u001a\u00020\u000bR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020,8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/ecommerce/ECLiveGoodsInstructionBubbleViewModel;", "", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qqcircle/immersive/feed/live/ecommerce/a;", "info", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "contentView", "", "resultBlock", "g", "onClickListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "view", "e", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "j", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "Lorg/json/JSONObject;", "data", "Lkotlin/Function0;", "clickBlock", "", "o", "k", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "bubbleContainer", "b", "Landroid/view/View;", "flashShowFeedInfoView", "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel;", "c", "Lcom/tencent/mobileqq/qqecommerce/biz/nv/api/INVViewModel;", "nvViewModel", "d", "Lfeedcloud/FeedCloudMeta$StFeed;", "currentStFeeds", "", "value", "getFlashShowFeedInfoViewMarginRight", "()I", "l", "(I)V", "flashShowFeedInfoViewMarginRight", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ECLiveGoodsInstructionBubbleViewModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup bubbleContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View flashShowFeedInfoView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private INVViewModel nvViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed currentStFeeds;

    static {
        ((IECHRAccessHelper) QRoute.api(IECHRAccessHelper.class)).ensureNVViewMVPEnvironment();
    }

    private final void e(View view) {
        Map emptyMap;
        String str;
        PBStringField pBStringField;
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_LIVE_CARD);
        emptyMap = MapsKt__MapsKt.emptyMap();
        VideoReport.setElementParams(view, emptyMap);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.currentStFeeds;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        VideoReport.setElementReuseIdentifier(view, QCircleDaTongConstant.ElementId.EM_XSJ_LIVE_CARD + str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private final void f() {
        ViewGroup viewGroup = this.bubbleContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            viewGroup.setOnClickListener(null);
        }
    }

    private final void g(final Context context, final a info, final Function1<? super View, Unit> resultBlock) {
        final INVViewModel create = ((INVViewModelFactory) QRoute.api(INVViewModelFactory.class)).create(true);
        this.nvViewModel = create;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.c
            @Override // java.lang.Runnable
            public final void run() {
                ECLiveGoodsInstructionBubbleViewModel.h(INVViewModel.this, info, this, resultBlock, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final INVViewModel vm5, a info, final ECLiveGoodsInstructionBubbleViewModel this$0, final Function1 resultBlock, final Context context) {
        Intrinsics.checkNotNullParameter(vm5, "$vm");
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        INVViewModel.DefaultImpls.init$default(vm5, new JSONObject(info.getRichText()), 0.0f, null, 4, null);
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.d
            @Override // java.lang.Runnable
            public final void run() {
                ECLiveGoodsInstructionBubbleViewModel.i(INVViewModel.this, this$0, resultBlock, context);
            }
        }, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(INVViewModel vm5, ECLiveGoodsInstructionBubbleViewModel this$0, Function1 resultBlock, Context context) {
        Intrinsics.checkNotNullParameter(vm5, "$vm");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultBlock, "$resultBlock");
        if (!Intrinsics.areEqual(vm5, this$0.nvViewModel)) {
            QLog.d("ECLiveGoodsInstructionBubbleViewModel", 1, "vm had changed");
        } else {
            resultBlock.invoke(vm5.getNVView(context));
        }
    }

    private final void l(int i3) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.flashShowFeedInfoView;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.rightMargin = i3;
        View view2 = this.flashShowFeedInfoView;
        if (view2 != null) {
            view2.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(View contentView, final Function1<? super View, Unit> onClickListener) {
        ViewGroup viewGroup = this.bubbleContainer;
        if (viewGroup == null) {
            QLog.d("ECLiveGoodsInstructionBubbleViewModel", 1, "[showBubbleContainer]: bubbleContainer is null: " + hashCode());
            return;
        }
        if (contentView == null) {
            k();
            QLog.d("ECLiveGoodsInstructionBubbleViewModel", 1, "[showBubbleContainer]: contentView is null: " + hashCode());
            return;
        }
        Intrinsics.checkNotNull(viewGroup);
        viewGroup.setVisibility(0);
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ECLiveGoodsInstructionBubbleViewModel.n(Function1.this, view);
            }
        });
        viewGroup.removeAllViews();
        viewGroup.addView(contentView);
        l(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void j(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.bubbleContainer = (ViewGroup) rootView.findViewById(R.id.f31450r3);
        this.flashShowFeedInfoView = rootView.findViewById(R.id.v_p);
    }

    public final void k() {
        Resources resources;
        f();
        ViewGroup viewGroup = this.bubbleContainer;
        if (viewGroup != null && (resources = viewGroup.getResources()) != null) {
            l(resources.getDimensionPixelSize(R.dimen.f159409d34));
        }
    }

    public final boolean o(@NotNull FeedCloudMeta$StFeed stFeed, @NotNull JSONObject data, @NotNull final Function0<Unit> clickBlock) {
        boolean z16;
        Context context;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clickBlock, "clickBlock");
        if (Intrinsics.areEqual(stFeed, this.currentStFeeds)) {
            return true;
        }
        this.currentStFeeds = stFeed;
        QLog.d("ECLiveGoodsInstructionBubbleViewModel", 1, "[updateBubbleInfo]: " + data);
        a a16 = a.INSTANCE.a(data);
        if (a16.getRichText().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            k();
        } else {
            ViewGroup viewGroup = this.bubbleContainer;
            if (viewGroup != null) {
                context = viewGroup.getContext();
            } else {
                context = null;
            }
            g(context, a16, new Function1<View, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.ECLiveGoodsInstructionBubbleViewModel$updateBubbleInfo$info$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    ECLiveGoodsInstructionBubbleViewModel eCLiveGoodsInstructionBubbleViewModel = ECLiveGoodsInstructionBubbleViewModel.this;
                    final Function0<Unit> function0 = clickBlock;
                    eCLiveGoodsInstructionBubbleViewModel.m(view, new Function1<View, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.ecommerce.ECLiveGoodsInstructionBubbleViewModel$updateBubbleInfo$info$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                            invoke2(view2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            QLog.d("ECLiveGoodsInstructionBubbleViewModel", 1, "[clickBubbleView]");
                            function0.invoke();
                        }
                    });
                }
            });
        }
        ViewGroup viewGroup2 = this.bubbleContainer;
        if (viewGroup2 != null) {
            e(viewGroup2);
        }
        if (a16.getRichText().length() > 0) {
            return true;
        }
        return false;
    }
}
