package com.tencent.mobileqq.wink.publish.part;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.publish.part.PublishFollowQCircleSeverAccountPart;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishFollowQCircleSeverAccountViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010$\u001a\u0004\b3\u00100R\u0017\u00109\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishFollowQCircleSeverAccountPart;", "Lcom/tencent/mobileqq/wink/publish/part/j;", "", "R9", "M9", "O9", "H9", "Landroid/view/View;", "mRootView", "onInitView", "", "B9", "Landroid/view/ViewStub;", "d", "Landroid/view/ViewStub;", "tipsViewViewStub", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "tipsView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "followTipsFirstTv", tl.h.F, "followTipsSecondTv", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "closedBtn", "Lcom/tencent/widget/Switch;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/widget/Switch;", "followSwitch", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishFollowQCircleSeverAccountViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "L9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishFollowQCircleSeverAccountViewModel;", "viewModel", "Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "D", "K9", "()Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishViewModel;", "publishViewModel", "Landroid/view/animation/AlphaAnimation;", "E", "J9", "()Landroid/view/animation/AlphaAnimation;", "alphaAniShow", UserInfo.SEX_FEMALE, "I9", "alphaAniHide", "G", "Ljava/lang/String;", "getErrorText", "()Ljava/lang/String;", HippyQQHttpModule.HTPP_ERROR_TEXT, "<init>", "()V", "H", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishFollowQCircleSeverAccountPart extends j {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy publishViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy alphaAniShow;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy alphaAniHide;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String errorText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewStub tipsViewViewStub;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout tipsView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView followTipsFirstTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView followTipsSecondTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView closedBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Switch followSwitch;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/PublishFollowQCircleSeverAccountPart$a;", "", "Landroid/view/View;", "view", "", "expandTouchWidth", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.part.PublishFollowQCircleSeverAccountPart$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(View view, int i3, View parentView) {
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(parentView, "$parentView");
            Rect rect = new Rect();
            view.getHitRect(rect);
            rect.top -= i3;
            rect.bottom += i3;
            rect.left -= i3;
            rect.right += i3;
            parentView.setTouchDelegate(new TouchDelegate(rect, view));
        }

        public final void b(@NotNull final View view, final int expandTouchWidth) {
            Intrinsics.checkNotNullParameter(view, "view");
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            final View view2 = (View) parent;
            view2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.t
                @Override // java.lang.Runnable
                public final void run() {
                    PublishFollowQCircleSeverAccountPart.Companion.c(view, expandTouchWidth, view2);
                }
            });
        }

        Companion() {
        }
    }

    public PublishFollowQCircleSeverAccountPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PublishFollowQCircleSeverAccountViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishFollowQCircleSeverAccountPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishFollowQCircleSeverAccountViewModel invoke() {
                return (PublishFollowQCircleSeverAccountViewModel) PublishFollowQCircleSeverAccountPart.this.getViewModel(PublishFollowQCircleSeverAccountViewModel.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<PublishViewModel>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishFollowQCircleSeverAccountPart$publishViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishViewModel invoke() {
                return (PublishViewModel) PublishFollowQCircleSeverAccountPart.this.getViewModel(PublishViewModel.class);
            }
        });
        this.publishViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<AlphaAnimation>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishFollowQCircleSeverAccountPart$alphaAniShow$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AlphaAnimation invoke() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                return alphaAnimation;
            }
        });
        this.alphaAniShow = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<AlphaAnimation>() { // from class: com.tencent.mobileqq.wink.publish.part.PublishFollowQCircleSeverAccountPart$alphaAniHide$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AlphaAnimation invoke() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500L);
                return alphaAnimation;
            }
        });
        this.alphaAniHide = lazy4;
        String b16 = uq3.c.b1("qqcircle", "qqcircle_server_error_toast_text", "\u7f51\u7edc\u5f00\u5c0f\u5dee\u4e86\uff0c\u7a0d\u540e\u518d\u8bd5\u8bd5\u5427");
        Intrinsics.checkNotNullExpressionValue(b16, "getConfigValue(\n        \u2026ER_ERROR_TOAST_TEXT\n    )");
        this.errorText = b16;
    }

    private final void H9() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SERVICE_ID, IQCircleIPCApi.QCIRCLE_SEVER_PUBLISH_ACCOUNT_UIN);
        RelativeLayout relativeLayout = this.tipsView;
        ImageView imageView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            relativeLayout = null;
        }
        VideoReport.setElementId(relativeLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_FUWUHAO_DRAINGE_BAR);
        RelativeLayout relativeLayout2 = this.tipsView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            relativeLayout2 = null;
        }
        VideoReport.setElementParams(relativeLayout2, params);
        Switch r06 = this.followSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followSwitch");
            r06 = null;
        }
        VideoReport.setElementId(r06, WinkDaTongReportConstant.ElementId.EM_XSJ_FUWUHAO_FOLLOW_BUTTON);
        ImageView imageView2 = this.closedBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closedBtn");
        } else {
            imageView = imageView2;
        }
        VideoReport.setElementId(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_FUWUHAO_CLOSE_BUTTON);
    }

    private final AlphaAnimation I9() {
        return (AlphaAnimation) this.alphaAniHide.getValue();
    }

    private final AlphaAnimation J9() {
        return (AlphaAnimation) this.alphaAniShow.getValue();
    }

    private final PublishViewModel K9() {
        Object value = this.publishViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-publishViewModel>(...)");
        return (PublishViewModel) value;
    }

    private final PublishFollowQCircleSeverAccountViewModel L9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (PublishFollowQCircleSeverAccountViewModel) value;
    }

    private final void M9() {
        Companion companion = INSTANCE;
        ImageView imageView = this.closedBtn;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closedBtn");
            imageView = null;
        }
        companion.b(imageView, ViewUtils.dip2px(24.0f));
        ImageView imageView3 = this.closedBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closedBtn");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.part.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PublishFollowQCircleSeverAccountPart.N9(PublishFollowQCircleSeverAccountPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(PublishFollowQCircleSeverAccountPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L9().O1();
        RelativeLayout relativeLayout = this$0.tipsView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            relativeLayout = null;
        }
        relativeLayout.startAnimation(this$0.I9());
        RelativeLayout relativeLayout2 = this$0.tipsView;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            relativeLayout2 = null;
        }
        relativeLayout2.setVisibility(8);
        ImageView imageView = this$0.closedBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closedBtn");
            imageView = null;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", imageView, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O9() {
        Switch r06 = this.followSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("followSwitch");
            r06 = null;
        }
        r06.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.publish.part.q
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PublishFollowQCircleSeverAccountPart.P9(PublishFollowQCircleSeverAccountPart.this, compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(final PublishFollowQCircleSeverAccountPart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            if (NetworkUtil.isNetworkAvailable()) {
                this$0.L9().P1();
                this$0.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublishFollowQCircleSeverAccountPart.Q9(PublishFollowQCircleSeverAccountPart.this);
                    }
                }, 1000L);
                QCircleToast.p("\u5df2\u5173\u6ce8\uff0c\u8bf7\u5230\u8054\u7cfb\u4eba-\u8ba2\u9605\u53f7\u67e5\u770b", 1, true);
            } else {
                Switch r06 = this$0.followSwitch;
                if (r06 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followSwitch");
                    r06 = null;
                }
                r06.setChecked(false);
                QCircleToast.p(this$0.errorText, 1, true);
            }
            Switch r75 = this$0.followSwitch;
            if (r75 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("followSwitch");
                r75 = null;
            }
            VideoReport.reportEvent("ev_xsj_abnormal_clck", r75, null);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(PublishFollowQCircleSeverAccountPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.tipsView;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            relativeLayout = null;
        }
        relativeLayout.startAnimation(this$0.I9());
        this$0.I9().setAnimationListener(new b());
    }

    private final void R9() {
        L9().Z1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PublishFollowQCircleSeverAccountPart.S9(PublishFollowQCircleSeverAccountPart.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(PublishFollowQCircleSeverAccountPart this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            RelativeLayout relativeLayout = this$0.tipsView;
            RelativeLayout relativeLayout2 = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                relativeLayout = null;
            }
            relativeLayout.startAnimation(this$0.J9());
            RelativeLayout relativeLayout3 = this$0.tipsView;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            } else {
                relativeLayout2 = relativeLayout3;
            }
            relativeLayout2.setVisibility(0);
            this$0.O9();
            this$0.M9();
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NotNull
    public String B9() {
        return "PublishFollowQCircleSeverAccountPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View mRootView) {
        super.onInitView(mRootView);
        if (mRootView != null) {
            View findViewById = mRootView.findViewById(R.id.f657039n);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026ver_tips_layout_viewstub)");
            ViewStub viewStub = (ViewStub) findViewById;
            this.tipsViewViewStub = viewStub;
            RelativeLayout relativeLayout = null;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsViewViewStub");
                viewStub = null;
            }
            View inflate = viewStub.inflate();
            View findViewById2 = inflate.findViewById(R.id.f656939m);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.qub\u2026ircle_server_tips_layout)");
            this.tipsView = (RelativeLayout) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.f58212pe);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.qpu\u2026circle_server_first_text)");
            this.followTipsFirstTv = (TextView) findViewById3;
            View findViewById4 = inflate.findViewById(R.id.f58222pf);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.qpu\u2026ircle_server_second_text)");
            this.followTipsSecondTv = (TextView) findViewById4;
            if (K9().G2()) {
                TextView textView = this.followTipsFirstTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followTipsFirstTv");
                    textView = null;
                }
                textView.setText(com.dataline.util.j.d(uq3.c.D2()));
                TextView textView2 = this.followTipsSecondTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followTipsSecondTv");
                    textView2 = null;
                }
                textView2.setText(uq3.c.B2());
            } else {
                TextView textView3 = this.followTipsFirstTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followTipsFirstTv");
                    textView3 = null;
                }
                textView3.setText(com.dataline.util.j.d(uq3.c.C2()));
                TextView textView4 = this.followTipsSecondTv;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("followTipsSecondTv");
                    textView4 = null;
                }
                textView4.setText(uq3.c.A2());
            }
            View findViewById5 = inflate.findViewById(R.id.f58202pd);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.qpu\u2026ow_qcircle_server_cancel)");
            this.closedBtn = (ImageView) findViewById5;
            View findViewById6 = inflate.findViewById(R.id.f58232pg);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.qpu\u2026ow_qcircle_server_switch)");
            this.followSwitch = (Switch) findViewById6;
            RelativeLayout relativeLayout2 = this.tipsView;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
            R9();
            L9().T1(K9().x2());
            H9();
            if (QQTheme.isNowThemeIsNight()) {
                RelativeLayout relativeLayout3 = this.tipsView;
                if (relativeLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                    relativeLayout3 = null;
                }
                ViewGroup.LayoutParams layoutParams = relativeLayout3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(ViewUtils.dip2px(16.0f), layoutParams2.topMargin, ViewUtils.dip2px(16.0f), layoutParams2.bottomMargin);
                RelativeLayout relativeLayout4 = this.tipsView;
                if (relativeLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                } else {
                    relativeLayout = relativeLayout4;
                }
                relativeLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/publish/part/PublishFollowQCircleSeverAccountPart$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation p06) {
            RelativeLayout relativeLayout = PublishFollowQCircleSeverAccountPart.this.tipsView;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation p06) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation p06) {
        }
    }
}
