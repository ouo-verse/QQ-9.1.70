package com.tencent.mobileqq.matchfriend.aio.quote;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.aio.utils.InteractiveContentEmotionCodec;
import com.tencent.mobileqq.matchfriend.widget.RoundCornerImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 ^2\u00020\u0001:\u0001_B'\b\u0007\u0012\u0006\u0010W\u001a\u00020V\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X\u0012\b\b\u0002\u0010[\u001a\u00020Z\u00a2\u0006\u0004\b\\\u0010]J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J*\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J$\u0010\u001c\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0014J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000fJ\u0018\u0010%\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010*R\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010-R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010-R\u0016\u0010;\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001c\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR*\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR0\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteView;", "Landroid/widget/LinearLayout;", "", "Lcom/tencent/mobileqq/matchfriend/aio/quote/a;", "actions", "", "l", "Landroid/view/View;", "actionItemLayout", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "imageView", "action", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "noImage", "p", "Landroid/graphics/drawable/GradientDrawable;", "e", "Landroid/graphics/drawable/StateListDrawable;", "c", "Landroid/graphics/drawable/Drawable;", "f", "d", "", "url", ToastView.ICON_LOADING, "g", "onFinishInflate", "show", "j", "k", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "data", "o", "Landroid/view/View;", "shadowView", "containerView", "Lcom/tencent/mobileqq/matchfriend/widget/RoundCornerImageView;", "Lcom/tencent/mobileqq/matchfriend/widget/RoundCornerImageView;", "bgIv", tl.h.F, "Landroid/widget/ImageView;", "logoIv", "i", "maskIv", "avatarIv", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "titleTv", "D", "contentTv", "E", "closeIv", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "actionLayout", "", "G", "[Landroid/view/View;", "actionItemLayouts", "H", "[Landroid/widget/TextView;", "actionTextViews", "I", "[Landroid/widget/ImageView;", "actionImageViews", "Lkotlin/Function0;", "J", "Lkotlin/jvm/functions/Function0;", "getOnCloseListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseListener", "(Lkotlin/jvm/functions/Function0;)V", "onCloseListener", "Lkotlin/Function1;", "K", "Lkotlin/jvm/functions/Function1;", "getOnActionClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnActionClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onActionClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerQuoteView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView contentTv;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView closeIv;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout actionLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private final View[] actionItemLayouts;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView[] actionTextViews;

    /* renamed from: I, reason: from kotlin metadata */
    private final ImageView[] actionImageViews;

    /* renamed from: J, reason: from kotlin metadata */
    private Function0<Unit> onCloseListener;

    /* renamed from: K, reason: from kotlin metadata */
    private Function1<? super QQStrangerQuoteAction, Unit> onActionClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View shadowView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView bgIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView logoIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView maskIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarIv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerQuoteView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final StateListDrawable c() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ContextCompat.getColorStateList(getContext(), R.color.qui_common_bubble_guest));
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(8.0f));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(ContextCompat.getColorStateList(getContext(), R.color.qui_common_overlay_standard_primary));
        gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(8.0f));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2}));
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private final Drawable d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColorStateList(getContext(), R.color.qui_common_bg_aio_01));
        return gradientDrawable;
    }

    private final GradientDrawable e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ContextCompat.getColorStateList(getContext(), R.color.qui_common_overlay_dark));
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(8.0f));
        return gradientDrawable;
    }

    private final Drawable f() {
        return new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, ContextCompat.getColor(getContext(), R.color.qui_common_bg_aio_01)});
    }

    private final void g(ImageView imageView, String url, Drawable loading) {
        try {
            Option option = Option.obtain().setTargetView(imageView).setUrl(url).setLoadingDrawable(loading).setFailDrawable(loading);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        } catch (Exception e16) {
            QLog.e("QQStrangerQuoteView", 1, "loadImage exception ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QQStrangerQuoteView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onCloseListener;
        if (function0 != null) {
            function0.invoke();
        }
        com.tencent.mobileqq.matchfriend.aio.a aVar = com.tencent.mobileqq.matchfriend.aio.a.f243789a;
        ImageView imageView = this$0.closeIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIv");
            imageView = null;
        }
        com.tencent.mobileqq.matchfriend.aio.a.b(aVar, "em_kl_graphic_dynamic_close", imageView, null, 4, null);
    }

    private final void l(List<QQStrangerQuoteAction> actions) {
        Object orNull;
        Object orNull2;
        Object orNull3;
        Object orNull4;
        LinearLayout linearLayout = null;
        if (actions.isEmpty()) {
            LinearLayout linearLayout2 = this.actionLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = this.actionLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.setVisibility(0);
        for (int i3 = 0; i3 < 3; i3++) {
            orNull = ArraysKt___ArraysKt.getOrNull(this.actionItemLayouts, i3);
            View view = (View) orNull;
            if (view != null) {
                orNull2 = ArraysKt___ArraysKt.getOrNull(this.actionTextViews, i3);
                TextView textView = (TextView) orNull2;
                if (textView != null) {
                    orNull3 = ArraysKt___ArraysKt.getOrNull(this.actionImageViews, i3);
                    ImageView imageView = (ImageView) orNull3;
                    if (imageView != null) {
                        orNull4 = CollectionsKt___CollectionsKt.getOrNull(actions, i3);
                        m(view, textView, imageView, (QQStrangerQuoteAction) orNull4);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QQStrangerQuoteView this$0, QQStrangerQuoteAction qQStrangerQuoteAction, TextView textView, Map reportParams, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        Function1<? super QQStrangerQuoteAction, Unit> function1 = this$0.onActionClickListener;
        if (function1 != null) {
            function1.invoke(qQStrangerQuoteAction);
        }
        com.tencent.mobileqq.matchfriend.aio.a.f243789a.a("em_kl_graphic_dynamic_recommend", textView, reportParams);
    }

    public final void j(boolean show) {
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view = null;
        }
        view.setBackground(show ? d() : null);
    }

    public final void k(boolean show) {
        View view = this.shadowView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadowView");
            view = null;
        }
        view.setVisibility(show ? 0 : 8);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        List listOf;
        List listOf2;
        List listOf3;
        super.onFinishInflate();
        View findViewById = findViewById(R.id.f163182or2);
        findViewById.setBackground(f());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026hadowDrawable()\n        }");
        this.shadowView = findViewById;
        View findViewById2 = findViewById(R.id.ol5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.layout_container)");
        this.containerView = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            findViewById2 = null;
        }
        View findViewById3 = findViewById2.findViewById(R.id.oko);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById3;
        int dpToPx = ViewUtils.dpToPx(8.0f);
        roundCornerImageView.setCorner(dpToPx, dpToPx, dpToPx, dpToPx);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026corner, corner)\n        }");
        this.bgIv = roundCornerImageView;
        View view = this.containerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view = null;
        }
        View findViewById4 = view.findViewById(R.id.oku);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.iv_logo)");
        this.logoIv = (ImageView) findViewById4;
        View view2 = this.containerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view2 = null;
        }
        View findViewById5 = view2.findViewById(R.id.okv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.iv_mask)");
        this.maskIv = (ImageView) findViewById5;
        View view3 = this.containerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view3 = null;
        }
        View findViewById6 = view3.findViewById(R.id.okn);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.iv_avatar)");
        this.avatarIv = (ImageView) findViewById6;
        View view4 = this.containerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view4 = null;
        }
        View findViewById7 = view4.findViewById(R.id.osa);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewById(R.id.tv_title)");
        this.titleTv = (TextView) findViewById7;
        View view5 = this.containerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view5 = null;
        }
        View findViewById8 = view5.findViewById(R.id.orw);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewById(R.id.tv_content)");
        this.contentTv = (TextView) findViewById8;
        View view6 = this.containerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view6 = null;
        }
        View findViewById9 = view6.findViewById(R.id.okp);
        ImageView imageView = (ImageView) findViewById9;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                QQStrangerQuoteView.i(QQStrangerQuoteView.this, view7);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026)\n            }\n        }");
        this.closeIv = imageView;
        View view7 = this.containerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view7 = null;
        }
        View findViewById10 = view7.findViewById(R.id.f163152ol1);
        LinearLayout linearLayout = (LinearLayout) findViewById10;
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i3 = 0;
        gradientDrawable.setColor(0);
        gradientDrawable.setSize(ViewUtils.dpToPx(12.0f), 1);
        linearLayout.setDividerDrawable(gradientDrawable);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewBy\u2026)\n            }\n        }");
        this.actionLayout = linearLayout;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.f163153ol2), Integer.valueOf(R.id.f163154ol3), Integer.valueOf(R.id.f163155ol4)});
        int i16 = 0;
        for (Object obj : listOf) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) obj).intValue();
            View[] viewArr = this.actionItemLayouts;
            LinearLayout linearLayout2 = this.actionLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
                linearLayout2 = null;
            }
            View findViewById11 = linearLayout2.findViewById(intValue);
            if (findViewById11 != null) {
                Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById<View>(id)");
                findViewById11.setBackground(c());
                Unit unit = Unit.INSTANCE;
            } else {
                findViewById11 = null;
            }
            viewArr[i16] = findViewById11;
            i16 = i17;
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.ors), Integer.valueOf(R.id.ort), Integer.valueOf(R.id.oru)});
        int i18 = 0;
        for (Object obj2 : listOf2) {
            int i19 = i18 + 1;
            if (i18 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int intValue2 = ((Number) obj2).intValue();
            TextView[] textViewArr = this.actionTextViews;
            LinearLayout linearLayout3 = this.actionLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
                linearLayout3 = null;
            }
            textViewArr[i18] = (TextView) linearLayout3.findViewById(intValue2);
            i18 = i19;
        }
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.okk), Integer.valueOf(R.id.okl), Integer.valueOf(R.id.okm)});
        for (Object obj3 : listOf3) {
            int i26 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int intValue3 = ((Number) obj3).intValue();
            ImageView[] imageViewArr = this.actionImageViews;
            LinearLayout linearLayout4 = this.actionLayout;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
                linearLayout4 = null;
            }
            imageViewArr[i3] = (ImageView) linearLayout4.findViewById(intValue3);
            i3 = i26;
        }
    }

    public final void setOnActionClickListener(Function1<? super QQStrangerQuoteAction, Unit> function1) {
        this.onActionClickListener = function1;
    }

    public final void setOnCloseListener(Function0<Unit> function0) {
        this.onCloseListener = function0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerQuoteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QQStrangerQuoteView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerQuoteView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View[] viewArr = new View[3];
        for (int i16 = 0; i16 < 3; i16++) {
            viewArr[i16] = null;
        }
        this.actionItemLayouts = viewArr;
        TextView[] textViewArr = new TextView[3];
        for (int i17 = 0; i17 < 3; i17++) {
            textViewArr[i17] = null;
        }
        this.actionTextViews = textViewArr;
        ImageView[] imageViewArr = new ImageView[3];
        for (int i18 = 0; i18 < 3; i18++) {
            imageViewArr[i18] = null;
        }
        this.actionImageViews = imageViewArr;
    }

    public final void o(com.tencent.aio.api.runtime.a aioContext, QQStrangerQuoteData data) {
        View view;
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(data, "data");
        if (aioContext != null) {
            com.tencent.mobileqq.matchfriend.aio.a.f243789a.e(aioContext, this);
        }
        com.tencent.mobileqq.matchfriend.aio.a aVar = com.tencent.mobileqq.matchfriend.aio.a.f243789a;
        View view2 = this.containerView;
        ImageView imageView3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view = null;
        } else {
            view = view2;
        }
        com.tencent.mobileqq.matchfriend.aio.a.d(aVar, "em_kl_graphic_dynamic", view, null, 4, null);
        ImageView imageView4 = this.closeIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIv");
            imageView = null;
        } else {
            imageView = imageView4;
        }
        com.tencent.mobileqq.matchfriend.aio.a.d(aVar, "em_kl_graphic_dynamic_close", imageView, null, 4, null);
        if (data.getAvatar().length() > 0) {
            ImageView imageView5 = this.avatarIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
                imageView2 = null;
            } else {
                imageView2 = imageView5;
            }
            h(this, imageView2, data.getAvatar(), null, 4, null);
        } else {
            ImageView imageView6 = this.avatarIv;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
                imageView6 = null;
            }
            imageView6.setImageDrawable(null);
        }
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        textView.setText(data.getTitle());
        TextView textView2 = this.contentTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTv");
            textView2 = null;
        }
        textView2.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(data.getContent(), 17));
        if (data.getImage().length() > 0) {
            ImageView imageView7 = this.bgIv;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgIv");
                imageView7 = null;
            }
            String image = data.getImage();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ContextCompat.getColorStateList(getContext(), R.color.qui_common_fill_standard_primary));
            Unit unit = Unit.INSTANCE;
            g(imageView7, image, gradientDrawable);
            ImageView imageView8 = this.logoIv;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoIv");
                imageView8 = null;
            }
            imageView8.setImageDrawable(null);
            ImageView imageView9 = this.logoIv;
            if (imageView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoIv");
                imageView9 = null;
            }
            imageView9.setVisibility(8);
            ImageView imageView10 = this.maskIv;
            if (imageView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskIv");
                imageView10 = null;
            }
            imageView10.setVisibility(0);
            ImageView imageView11 = this.maskIv;
            if (imageView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskIv");
            } else {
                imageView3 = imageView11;
            }
            imageView3.setBackground(e());
        } else {
            RoundCornerImageView roundCornerImageView = this.bgIv;
            if (roundCornerImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgIv");
                roundCornerImageView = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(ContextCompat.getColorStateList(getContext(), R.color.qui_common_bubble_guest));
            gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(8.0f));
            roundCornerImageView.setImageDrawable(gradientDrawable2);
            ImageView imageView12 = this.logoIv;
            if (imageView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoIv");
                imageView12 = null;
            }
            imageView12.setVisibility(0);
            ImageView imageView13 = this.logoIv;
            if (imageView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoIv");
                imageView13 = null;
            }
            g(imageView13, "https://downv6.qq.com/extendfriend/qqstranger_quote_logo.png", new ColorDrawable(0));
            ImageView imageView14 = this.maskIv;
            if (imageView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maskIv");
            } else {
                imageView3 = imageView14;
            }
            imageView3.setVisibility(8);
        }
        p(data.getImage().length() == 0);
        l(data.a());
    }

    private final void m(View actionItemLayout, final TextView textView, ImageView imageView, final QQStrangerQuoteAction action) {
        final Map<String, String> mapOf;
        if (action == null) {
            actionItemLayout.setVisibility(8);
            return;
        }
        actionItemLayout.setVisibility(0);
        Pair<Integer, String> a16 = InteractiveContentEmotionCodec.f243983a.a(action.getContent());
        Integer first = a16.getFirst();
        imageView.setImageDrawable(first != null ? QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.convertToLocal(first.intValue())) : null);
        textView.setText(a16.getSecond());
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_recommend_id", String.valueOf(action.getActionId())));
        actionItemLayout.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerQuoteView.n(QQStrangerQuoteView.this, action, textView, mapOf, view);
            }
        }, 1, null));
        com.tencent.mobileqq.matchfriend.aio.a.f243789a.c("em_kl_graphic_dynamic_recommend", textView, mapOf);
    }

    static /* synthetic */ void h(QQStrangerQuoteView qQStrangerQuoteView, ImageView imageView, String str, Drawable drawable, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            drawable = null;
        }
        qQStrangerQuoteView.g(imageView, str, drawable);
    }

    private final void p(boolean noImage) {
        int i3;
        int i16;
        int i17;
        if (noImage) {
            i3 = R.color.qui_common_bubble_guest_text_secondary;
            i17 = R.color.qui_common_bubble_guest_text_primary;
            i16 = R.drawable.qui_close_bubble_guest_text_secondary;
        } else {
            i3 = R.color.qui_common_text_allwhite_primary;
            i16 = R.drawable.qui_close_icon_allwhite_primary;
            i17 = R.color.qui_common_text_allwhite_primary;
        }
        TextView textView = this.titleTv;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView = null;
        }
        TextView textView2 = this.titleTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView2 = null;
        }
        textView.setTextColor(ContextCompat.getColorStateList(textView2.getContext(), i3));
        TextView textView3 = this.contentTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTv");
            textView3 = null;
        }
        TextView textView4 = this.titleTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView4 = null;
        }
        textView3.setTextColor(ContextCompat.getColorStateList(textView4.getContext(), i17));
        ImageView imageView2 = this.closeIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIv");
        } else {
            imageView = imageView2;
        }
        imageView.setImageResource(i16);
    }
}
