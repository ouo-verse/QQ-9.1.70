package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.QFSWorkSuggestionsFragment;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e40.QFSWorkSuggestionsData;
import feedcloud.FeedCloudRead$Advice;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\u001c\u001a\u00020\u00132\b\b\u0001\u0010\u001b\u001a\u00020\u000fH\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\b\u0001\u0010\u001b\u001a\u00020\u000fH\u0002J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010*\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\tH\u0002J\u0012\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010-\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0014\u00109\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010=\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0014\u0010?\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00108R#\u0010F\u001a\n A*\u0004\u0018\u00010@0@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSWorkSuggestionsPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "J9", "P9", "Lcom/airbnb/lottie/LottieAnimationView;", "", "isLike", "K9", "otherView", "Landroid/widget/TextView;", "likeTextView", "", "newTag", "R9", "like", "Landroid/graphics/drawable/Drawable;", "E9", QCircleDaTongConstant.ElementParamValue.DISLIKE, "D9", "", "adviceId", "userful", "N9", "resId", "G9", "F9", "Le40/r;", "data", "Q9", "Lfeedcloud/FeedCloudRead$Advice;", "advice", "O9", "C9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "L9", "textView", "inputText", "returnDisplayable", "H9", "v", NodeProps.ON_CLICK, "onInitView", "d", "Landroid/view/View;", "suggestLayout1", "e", "suggestLayout2", "f", "suggestLayout3", tl.h.F, "quiEmptyView", "i", "I", "UN_DISLIKE_DRAWABLE", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "DISLIKE_DRAWABLE", BdhLogUtil.LogTag.Tag_Conn, "UNLIKE_DRAWABLE", "D", "LIKE_DRAWABLE", "Lr70/c;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", "I9", "()Lr70/c;", "vm", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSWorkSuggestionsPart extends u implements View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View suggestLayout1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View suggestLayout2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View suggestLayout3;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View quiEmptyView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int UN_DISLIKE_DRAWABLE = R.drawable.qvideo_skin_icon_general_thumb_reverse;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int DISLIKE_DRAWABLE = R.drawable.qvideo_skin_icon_general_thumb_reverse_solid;

    /* renamed from: C, reason: from kotlin metadata */
    private final int UNLIKE_DRAWABLE = R.drawable.qvideo_skin_icon_general_thumb;

    /* renamed from: D, reason: from kotlin metadata */
    private final int LIKE_DRAWABLE = R.drawable.or5;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/QFSWorkSuggestionsPart$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ String C;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f87651e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f87652f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TextView f87653h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f87654i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f87655m;

        a(LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView, boolean z16, int i3, String str) {
            this.f87651e = lottieAnimationView;
            this.f87652f = lottieAnimationView2;
            this.f87653h = textView;
            this.f87654i = z16;
            this.f87655m = i3;
            this.C = str;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            QFSWorkSuggestionsPart qFSWorkSuggestionsPart = QFSWorkSuggestionsPart.this;
            LottieAnimationView lottieAnimationView = this.f87651e;
            LottieAnimationView otherView = this.f87652f;
            Intrinsics.checkNotNullExpressionValue(otherView, "otherView");
            TextView likeTextView = this.f87653h;
            Intrinsics.checkNotNullExpressionValue(likeTextView, "likeTextView");
            qFSWorkSuggestionsPart.R9(lottieAnimationView, otherView, likeTextView, this.f87654i, this.f87655m);
            QFSWorkSuggestionsPart.this.N9(this.C, this.f87655m);
        }
    }

    public QFSWorkSuggestionsPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<r70.c>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSWorkSuggestionsPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final r70.c invoke() {
                return (r70.c) QFSWorkSuggestionsPart.this.getViewModel(r70.c.class);
            }
        });
        this.vm = lazy;
    }

    private final void C9() {
        QFSWorkSuggestionsFragment qFSWorkSuggestionsFragment;
        IPartHost partHost = getPartHost();
        if (partHost instanceof QFSWorkSuggestionsFragment) {
            qFSWorkSuggestionsFragment = (QFSWorkSuggestionsFragment) partHost;
        } else {
            qFSWorkSuggestionsFragment = null;
        }
        if (qFSWorkSuggestionsFragment != null) {
            qFSWorkSuggestionsFragment.Ah();
        }
    }

    private final Drawable D9(boolean dislike) {
        if (dislike) {
            return F9(this.DISLIKE_DRAWABLE);
        }
        return G9(this.UN_DISLIKE_DRAWABLE);
    }

    private final Drawable E9(boolean like) {
        if (like) {
            return F9(this.LIKE_DRAWABLE);
        }
        return G9(this.UNLIKE_DRAWABLE);
    }

    private final Drawable F9(@DrawableRes int resId) {
        Drawable drawable = QCircleSkinHelper.getInstance().getDrawable(getContext(), resId);
        Intrinsics.checkNotNullExpressionValue(drawable, "getInstance().getDrawable(context, resId)");
        return drawable;
    }

    private final Drawable G9(@DrawableRes int resId) {
        return QFSQUIUtilsKt.f(getContext(), resId, R.color.qui_common_text_secondary);
    }

    private final String H9(TextView textView, String inputText, boolean returnDisplayable) {
        int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
        TextPaint paint = textView.getPaint();
        int length = inputText.length();
        String str = "";
        float f16 = 0.0f;
        String str2 = "";
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = inputText.charAt(i3);
            f16 += paint.measureText(String.valueOf(charAt));
            if (f16 > width) {
                break;
            }
            str2 = str2 + charAt;
        }
        if (str2.length() < inputText.length()) {
            str = inputText.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
        }
        if (!returnDisplayable) {
            return str;
        }
        return str2;
    }

    private final r70.c I9() {
        return (r70.c) this.vm.getValue();
    }

    private final void J9(View view) {
        com.tencent.biz.qqcircle.launcher.c.g(getActivity(), view.getTag().toString());
        C9();
    }

    private final void K9(LottieAnimationView view, boolean isLike) {
        int i3;
        int i16;
        boolean areEqual;
        int i17;
        String str;
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        if (isLike) {
            i3 = R.id.f165923y25;
        } else {
            i3 = R.id.f165944dw3;
        }
        LottieAnimationView otherView = (LottieAnimationView) viewGroup.findViewById(i3);
        TextView likeTextView = (TextView) viewGroup.findViewById(R.id.f109046er);
        String obj = viewGroup.getTag().toString();
        Object tag = view.getTag();
        if (Intrinsics.areEqual(tag, (Object) 0)) {
            areEqual = true;
        } else {
            if (isLike) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            areEqual = Intrinsics.areEqual(tag, Integer.valueOf(i16));
        }
        if (areEqual) {
            if (isLike) {
                i17 = 1;
            } else {
                i17 = 2;
            }
        } else {
            i17 = 0;
        }
        if (i17 != 0) {
            if (isLike) {
                str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_comment_like_lo.json";
            } else {
                str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9065/animation_lottie/qvideo_skin_comment_dislike_lo.json";
            }
            view.setAnimationFromUrl(str);
            view.addAnimatorListener(new a(view, otherView, likeTextView, isLike, i17, obj));
            view.playAnimation();
        } else {
            Intrinsics.checkNotNullExpressionValue(otherView, "otherView");
            Intrinsics.checkNotNullExpressionValue(likeTextView, "likeTextView");
            R9(view, otherView, likeTextView, isLike, i17);
            N9(obj, i17);
        }
        String str2 = "0";
        if (isLike) {
            if (i17 != 1) {
                str2 = "1";
            }
            VideoReport.setElementParam(view, "xsj_if_cancel", str2);
        } else {
            if (i17 != 2) {
                str2 = "1";
            }
            VideoReport.setElementParam(view, "xsj_if_cancel", str2);
        }
    }

    private final void L9(View rootView) {
        if (rootView == null) {
            return;
        }
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(16).setTitle("\u6682\u65e0\u5185\u5bb9").setDesc("\u6570\u636e\u6b63\u5728\u7edf\u8ba1\u4e2d").build();
        build.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        layoutParams.bottomMargin = kotlin.g.c(build, 160.0f);
        layoutParams.gravity = 17;
        build.setLayoutParams(layoutParams);
        this.quiEmptyView = build;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.yqu);
        if (linearLayout != null) {
            View view = this.quiEmptyView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quiEmptyView");
                view = null;
            }
            linearLayout.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(String adviceId, int userful) {
        r70.c I9 = I9();
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "api(IAccountRuntime::class.java).account");
        I9.Q1(account, adviceId, userful);
    }

    private final void O9(FeedCloudRead$Advice advice, View view) {
        boolean z16;
        String str;
        int i3;
        boolean z17;
        boolean z18;
        Object obj;
        int i16;
        boolean z19;
        Object obj2;
        Object obj3;
        TextView textView = (TextView) view.findViewById(R.id.seo);
        String str2 = advice.advice_rate.get();
        Intrinsics.checkNotNullExpressionValue(str2, "advice.advice_rate.get()");
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "";
        } else {
            str = advice.advice_rate.get() + MsgSummary.STR_COLON;
        }
        textView.setText(str);
        ((TextView) view.findViewById(R.id.sep)).setText(advice.advice_rate_desc.get());
        ((TextView) view.findViewById(R.id.seq)).setText(advice.advice_rate_unit.get());
        View findViewById = view.findViewById(R.id.sen);
        if (advice.advice_update.get()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        View findViewById2 = view.findViewById(R.id.jmp);
        findViewById2.setTag(advice.advice_tips.get());
        findViewById2.setOnClickListener(this);
        VideoReport.setElementId(findViewById2, QCircleDaTongConstant.ElementParamValue.XSJ_WORK_ADVISE_QUERY_BUTTON);
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_instruct_name", advice.advice_rate.get());
        VideoReport.setElementParams(findViewById2, map);
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.QFSWorkSuggestionsFragment");
        VideoReport.setPageId(findViewById2, ((QFSWorkSuggestionsFragment) partHost).Bh());
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(findViewById2, exposurePolicy);
        TextView textView2 = (TextView) view.findViewById(R.id.sem);
        textView2.setText(advice.jump_toast.get());
        textView2.setTag(advice.jump_url.get());
        textView2.setOnClickListener(this);
        VideoReport.setElementId(textView2, QCircleDaTongConstant.ElementParamValue.XSJ_WORK_ADVISE_LEARN_BUTTON);
        Map<String, Object> map2 = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map2, "map");
        map2.put("xsj_instruct_name", advice.advice_rate.get());
        VideoReport.setElementParams(textView2, map2);
        IPartHost partHost2 = getPartHost();
        Intrinsics.checkNotNull(partHost2, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.QFSWorkSuggestionsFragment");
        VideoReport.setPageId(textView2, ((QFSWorkSuggestionsFragment) partHost2).Bh());
        VideoReport.setElementExposePolicy(textView2, exposurePolicy);
        TextView textView3 = (TextView) view.findViewById(R.id.sek);
        Intrinsics.checkNotNullExpressionValue(textView3, "this");
        String str3 = advice.advice_desc.get();
        Intrinsics.checkNotNullExpressionValue(str3, "advice.advice_desc.get()");
        textView3.setText(H9(textView3, str3, true));
        String str4 = advice.advice_desc.get();
        Intrinsics.checkNotNullExpressionValue(str4, "advice.advice_desc.get()");
        String H9 = H9(textView3, str4, false);
        if (advice.useful.get() == 3) {
            textView3.setTextColor(textView3.getResources().getColor(R.color.qui_common_text_secondary));
        }
        TextView textView4 = (TextView) view.findViewById(R.id.sel);
        if (H9.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            textView4.setVisibility(4);
        } else {
            textView4.setText(H9);
            if (advice.useful.get() == 3) {
                textView4.setTextColor(textView4.getResources().getColor(R.color.qui_common_text_secondary));
            }
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.f165944dw3);
        if (advice.useful.get() == 3) {
            lottieAnimationView.setVisibility(8);
            obj = "0";
            z19 = true;
        } else {
            lottieAnimationView.setVisibility(0);
            if (advice.useful.get() == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            lottieAnimationView.setImageDrawable(E9(z18));
            lottieAnimationView.setTag(Integer.valueOf(advice.useful.get()));
            ViewParent parent = lottieAnimationView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setTag(advice.advice_id.get());
            TextView textView5 = (TextView) viewGroup.findViewById(R.id.f109046er);
            obj = "0";
            if (advice.useful.get() == 1) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            textView5.setVisibility(i16);
            lottieAnimationView.setOnClickListener(this);
            VideoReport.setElementId(lottieAnimationView, QCircleDaTongConstant.ElementParamValue.XSJ_WORK_ADVISE_FEEDBACK_BUTTON);
            Map<String, Object> map3 = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map3, "map");
            map3.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "useful");
            map3.put("xsj_instruct_name", advice.advice_rate.get());
            map3.put("xsj_advice_id", advice.advice_id.get());
            z19 = true;
            if (advice.useful.get() == 1) {
                obj2 = "1";
            } else {
                obj2 = obj;
            }
            map3.put("xsj_if_cancel", obj2);
            VideoReport.setElementParams(lottieAnimationView, map3);
            IPartHost partHost3 = getPartHost();
            Intrinsics.checkNotNull(partHost3, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.QFSWorkSuggestionsFragment");
            VideoReport.setPageId(lottieAnimationView, ((QFSWorkSuggestionsFragment) partHost3).Bh());
            VideoReport.setElementExposePolicy(lottieAnimationView, exposurePolicy);
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view.findViewById(R.id.f165923y25);
        if (advice.useful.get() == 3) {
            lottieAnimationView2.setVisibility(8);
            return;
        }
        lottieAnimationView2.setVisibility(0);
        if (advice.useful.get() != 2) {
            z19 = false;
        }
        lottieAnimationView2.setImageDrawable(D9(z19));
        lottieAnimationView2.setTag(Integer.valueOf(advice.useful.get()));
        lottieAnimationView2.setOnClickListener(this);
        VideoReport.setElementId(lottieAnimationView2, QCircleDaTongConstant.ElementParamValue.XSJ_WORK_ADVISE_FEEDBACK_BUTTON);
        Map<String, Object> map4 = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map4, "map");
        map4.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "useful");
        map4.put("xsj_instruct_name", advice.advice_rate.get());
        map4.put("xsj_advice_id", advice.advice_id.get());
        if (advice.useful.get() == 2) {
            obj3 = "1";
        } else {
            obj3 = obj;
        }
        map4.put("xsj_if_cancel", obj3);
        VideoReport.setElementParams(lottieAnimationView2, map4);
        IPartHost partHost4 = getPartHost();
        Intrinsics.checkNotNull(partHost4, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.QFSWorkSuggestionsFragment");
        VideoReport.setPageId(lottieAnimationView2, ((QFSWorkSuggestionsFragment) partHost4).Bh());
        VideoReport.setElementExposePolicy(lottieAnimationView2, exposurePolicy);
    }

    private final void P9(View view) {
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(getActivity());
        r16.o0(view.getTag().toString());
        r16.m0(3);
        r16.k0(0);
        r16.R(0);
        r16.S(view);
        r16.n0(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(QFSWorkSuggestionsData data) {
        List listOf;
        View view = null;
        if (data == null) {
            View view2 = this.suggestLayout1;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suggestLayout1");
                view2 = null;
            }
            Object parent = view2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).setVisibility(8);
            View view3 = this.quiEmptyView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quiEmptyView");
            } else {
                view = view3;
            }
            view.setVisibility(0);
            return;
        }
        View view4 = this.suggestLayout1;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestLayout1");
            view4 = null;
        }
        Object parent2 = view4.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        ((View) parent2).setVisibility(0);
        View[] viewArr = new View[3];
        View view5 = this.suggestLayout1;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestLayout1");
            view5 = null;
        }
        viewArr[0] = view5;
        View view6 = this.suggestLayout2;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestLayout2");
            view6 = null;
        }
        viewArr[1] = view6;
        View view7 = this.suggestLayout3;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suggestLayout3");
            view7 = null;
        }
        viewArr[2] = view7;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        List<FeedCloudRead$Advice> a16 = data.a();
        int i3 = 0;
        for (Object obj : listOf) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view8 = (View) obj;
            if (i3 < a16.size()) {
                view8.setVisibility(0);
                O9(a16.get(i3), view8);
            } else {
                view8.setVisibility(8);
            }
            i3 = i16;
        }
        View view9 = this.quiEmptyView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiEmptyView");
        } else {
            view = view9;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(LottieAnimationView view, LottieAnimationView otherView, TextView likeTextView, boolean isLike, int newTag) {
        boolean z16;
        boolean z17;
        boolean z18;
        Drawable drawable;
        int i3 = 0;
        if (newTag != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && isLike) {
            z17 = true;
        } else {
            z17 = false;
        }
        Drawable E9 = E9(z17);
        if (z16 && !isLike) {
            z18 = true;
        } else {
            z18 = false;
        }
        Drawable D9 = D9(z18);
        if (isLike) {
            drawable = E9;
        } else {
            drawable = D9;
        }
        view.setImageDrawable(drawable);
        if (isLike) {
            E9 = D9;
        }
        otherView.setImageDrawable(E9);
        view.setTag(Integer.valueOf(newTag));
        otherView.setTag(Integer.valueOf(newTag));
        if (newTag != 1) {
            i3 = 8;
        }
        likeTextView.setVisibility(i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.sem) {
            J9(v3);
        } else if (num != null && num.intValue() == R.id.f165944dw3) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            K9((LottieAnimationView) v3, true);
        } else if (num != null && num.intValue() == R.id.f165923y25) {
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            K9((LottieAnimationView) v3, false);
        } else if (num != null && num.intValue() == R.id.jmp) {
            P9(v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f9069536);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.suggestion_layout1)");
            this.suggestLayout1 = findViewById;
            View findViewById2 = rootView.findViewById(R.id.f9070537);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.suggestion_layout2)");
            this.suggestLayout2 = findViewById2;
            View findViewById3 = rootView.findViewById(R.id.f9071538);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.suggestion_layout3)");
            this.suggestLayout3 = findViewById3;
        }
        L9(rootView);
        LiveData<QFSWorkSuggestionsData> O1 = I9().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final QFSWorkSuggestionsPart$onInitView$2 qFSWorkSuggestionsPart$onInitView$2 = new QFSWorkSuggestionsPart$onInitView$2(this);
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.part.gk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSWorkSuggestionsPart.M9(Function1.this, obj);
            }
        });
    }
}
