package com.tencent.qqnt.aio.assistedchat.panel.polish;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelGuideView;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001:B%\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\f\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0015\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R0\u00104\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelGuideView;", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelGuideView$GradualInTextView;", DomainData.DOMAIN_NAME, "Landroid/view/View;", "i", "Landroid/content/Context;", "context", "", "text", "", "emojiId", "j", "Landroid/graphics/drawable/Drawable;", "o", "", "p", "Lkotlin/Function0;", "endListener", "v", "Landroid/animation/ValueAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", ReportConstant.COSTREPORT_PREFIX, h.F, "d", "Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelGuideView$GradualInTextView;", "titleTextView", "e", "Landroid/view/View;", "cursorView", "f", "Landroid/widget/TextView;", "titlePlaceholder", "item1TextView", "item2TextView", "item3TextView", "Landroid/animation/Animator;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/animation/Animator;", "cursorAnimator", "D", "itemAnimator", "Lkotlin/Function1;", "E", "Lkotlin/jvm/functions/Function1;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "GradualInTextView", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPolishPanelGuideView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Animator cursorAnimator;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Animator itemAnimator;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super CharSequence, Unit> onItemClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GradualInTextView titleTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View cursorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView titlePlaceholder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView item1TextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView item2TextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView item3TextView;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelGuideView$GradualInTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "allText", "", "duration", "Lkotlin/Function0;", "", "endListener", "b", h.F, "Ljava/lang/String;", "getAllText", "()Ljava/lang/String;", "setAllText", "(Ljava/lang/String;)V", "", "i", "I", "getCurrentIndex", "()I", "setCurrentIndex", "(I)V", "currentIndex", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class GradualInTextView extends AppCompatTextView {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String allText;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int currentIndex;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/polish/AssistedChatPolishPanelGuideView$GradualInTextView$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes23.dex */
        public static final class a extends AnimatorListenerAdapter {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f349205d;

            a(Function0<Unit> function0) {
                this.f349205d = function0;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                } else {
                    this.f349205d.invoke();
                }
            }
        }

        public /* synthetic */ GradualInTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GradualInTextView this$0, String allText, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(allText, "$allText");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) animatedValue).intValue();
            if (intValue != this$0.currentIndex) {
                this$0.currentIndex = intValue;
                if (intValue > 0 && intValue <= allText.length()) {
                    String substring = allText.substring(0, intValue);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    this$0.setText(substring);
                }
            }
        }

        public final void b(@NotNull final String allText, long duration, @NotNull Function0<Unit> endListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, allText, Long.valueOf(duration), endListener);
                return;
            }
            Intrinsics.checkNotNullParameter(allText, "allText");
            Intrinsics.checkNotNullParameter(endListener, "endListener");
            this.allText = allText;
            ValueAnimator ofInt = ValueAnimator.ofInt(0, allText.length());
            ofInt.setDuration(duration);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AssistedChatPolishPanelGuideView.GradualInTextView.d(AssistedChatPolishPanelGuideView.GradualInTextView.this, allText, valueAnimator);
                }
            });
            ofInt.addListener(new a(endListener));
            ofInt.start();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GradualInTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            } else {
                this.allText = "";
                this.currentIndex = -1;
            }
        }
    }

    public /* synthetic */ AssistedChatPolishPanelGuideView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    private final View i() {
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(l.b(1), l.b(16)));
        view.setBackgroundResource(R.drawable.f160144bc);
        view.setVisibility(4);
        return view;
    }

    private final TextView j(Context context, CharSequence text, int emojiId) {
        final TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.b(8);
        textView.setLayoutParams(layoutParams);
        textView.setMinHeight(l.b(37));
        textView.setBackground(o(context));
        textView.setVisibility(4);
        textView.setPadding(l.b(12), l.b(5), l.b(12), l.b(5));
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        if (emojiId >= 0) {
            text = new QQTextBuilder(((Object) text) + QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(emojiId)), 3, 18);
        }
        textView.setText(text);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AssistedChatPolishPanelGuideView.l(AssistedChatPolishPanelGuideView.this, textView, view);
            }
        });
        return textView;
    }

    static /* synthetic */ TextView k(AssistedChatPolishPanelGuideView assistedChatPolishPanelGuideView, Context context, CharSequence charSequence, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        return assistedChatPolishPanelGuideView.j(context, charSequence, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AssistedChatPolishPanelGuideView this$0, TextView this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Function1<? super CharSequence, Unit> function1 = this$0.onItemClickListener;
        if (function1 != null) {
            CharSequence text = this_apply.getText();
            Intrinsics.checkNotNullExpressionValue(text, "this.text");
            function1.invoke(text);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final TextView m() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextSize(16.0f);
        textView.setText("\u8f93\u5165\u4ee5\u4e0b\u77ed\u53e5\u8bd5\u4e00\u8bd5");
        textView.setVisibility(4);
        return textView;
    }

    private final GradualInTextView n() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GradualInTextView gradualInTextView = new GradualInTextView(context, null, 0, 6, null);
        gradualInTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        gradualInTextView.setTextSize(16.0f);
        gradualInTextView.setTextColor(ContextCompat.getColorStateList(gradualInTextView.getContext(), R.color.qui_common_text_secondary));
        gradualInTextView.setGravity(3);
        gradualInTextView.setVisibility(4);
        return gradualInTextView;
    }

    private final Drawable o(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_allwhite_strong));
        gradientDrawable.setStroke((int) l.a(0.5f), ContextCompat.getColorStateList(context, R.color.qui_common_border_allwhite_weak));
        gradientDrawable.setCornerRadius(l.b(8));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_standard_primary));
        gradientDrawable2.setCornerRadius(l.b(8));
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private final void p() {
        this.titleTextView.setVisibility(4);
        this.cursorView.setVisibility(4);
        this.item1TextView.setVisibility(4);
        this.item2TextView.setVisibility(4);
        this.item3TextView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator q() {
        this.cursorView.setVisibility(0);
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setDuration(500L);
        animator.setRepeatMode(2);
        animator.setRepeatCount(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AssistedChatPolishPanelGuideView.r(AssistedChatPolishPanelGuideView.this, valueAnimator);
            }
        });
        animator.start();
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(AssistedChatPolishPanelGuideView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.cursorView.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator t() {
        this.item1TextView.setVisibility(0);
        this.item2TextView.setVisibility(0);
        this.item3TextView.setVisibility(0);
        ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setDuration(500L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AssistedChatPolishPanelGuideView.u(AssistedChatPolishPanelGuideView.this, valueAnimator);
            }
        });
        animator.start();
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        return animator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AssistedChatPolishPanelGuideView this$0, ValueAnimator valueAnimator) {
        Float f16;
        float f17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f16 = (Float) animatedValue;
        } else {
            f16 = null;
        }
        if (f16 != null) {
            f17 = f16.floatValue();
        } else {
            f17 = 0.0f;
        }
        this$0.item1TextView.setAlpha(f17);
        this$0.item2TextView.setAlpha(f17);
        this$0.item3TextView.setAlpha(f17);
    }

    private final void v(Function0<Unit> endListener) {
        String obj;
        String str = "";
        this.titleTextView.setText("");
        this.titleTextView.setVisibility(0);
        GradualInTextView gradualInTextView = this.titleTextView;
        CharSequence text = this.titlePlaceholder.getText();
        if (text != null && (obj = text.toString()) != null) {
            str = obj;
        }
        gradualInTextView.b(str, 800L, endListener);
    }

    public final void h() {
        boolean z16;
        Animator animator;
        Animator animator2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Animator animator3 = this.cursorAnimator;
        boolean z17 = true;
        if (animator3 != null && animator3.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (animator2 = this.cursorAnimator) != null) {
            animator2.cancel();
        }
        this.cursorAnimator = null;
        Animator animator4 = this.itemAnimator;
        if (animator4 == null || !animator4.isRunning()) {
            z17 = false;
        }
        if (z17 && (animator = this.itemAnimator) != null) {
            animator.cancel();
        }
        this.itemAnimator = null;
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        h();
        p();
        v(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.polish.AssistedChatPolishPanelGuideView$startGuideAnim$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPolishPanelGuideView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ValueAnimator q16;
                ValueAnimator t16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AssistedChatPolishPanelGuideView assistedChatPolishPanelGuideView = AssistedChatPolishPanelGuideView.this;
                q16 = assistedChatPolishPanelGuideView.q();
                assistedChatPolishPanelGuideView.cursorAnimator = q16;
                AssistedChatPolishPanelGuideView assistedChatPolishPanelGuideView2 = AssistedChatPolishPanelGuideView.this;
                t16 = assistedChatPolishPanelGuideView2.t();
                assistedChatPolishPanelGuideView2.itemAnimator = t16;
            }
        });
    }

    public final void setOnItemClickListener(@Nullable Function1<? super CharSequence, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function1);
        } else {
            this.onItemClickListener = function1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatPolishPanelGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Typeface create;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        setOrientation(1);
        setGravity(1);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = l.b(32);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(14.0f);
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(null, 600, false);
            textView.setTypeface(create);
        }
        textView.setText("\u6362\u4e2a\u8868\u8fbe\u65b9\u5f0f\uff0c\u53d8\u8eab\u804a\u5929\u9ad8\u624b");
        addView(textView);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = l.b(24);
        frameLayout.setLayoutParams(layoutParams2);
        TextView m3 = m();
        this.titlePlaceholder = m3;
        GradualInTextView n3 = n();
        this.titleTextView = n3;
        View i16 = i();
        this.cursorView = i16;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.addView(m3);
        linearLayout.addView(i());
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(0);
        linearLayout2.addView(n3);
        linearLayout2.addView(i16);
        frameLayout.addView(linearLayout2);
        addView(frameLayout);
        TextView j3 = j(context, "\u65e9\u4e0a\u597d\uff0c\u65b0\u4e00\u5929\u597d\u5fc3\u60c5", 74);
        this.item1TextView = j3;
        TextView j16 = j(context, "\u65e9\u5440\uff0c\u518d\u7ed9\u4f60\u4e2a\u4e48\u4e48\u54d2", 144);
        this.item2TextView = j16;
        TextView k3 = k(this, context, "(\u309c\u25bd\u309c*)\u65e9\u4e0a\u597d\uff0c\u65b0\u4e00\u5929\u65b0\u8d77\u70b9", 0, 4, null);
        this.item3TextView = k3;
        addView(j3);
        addView(j16);
        addView(k3);
    }
}
