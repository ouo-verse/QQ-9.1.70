package com.tencent.guild.aio.msglist.markdown.inlineboard;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.MarkdownTextView;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBoardLayoutManager;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.msglist.text.util.f;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 X2\u00020\u0001:\u0001YB\u001b\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010T\u001a\u0004\u0018\u00010S\u00a2\u0006\u0004\bU\u0010VB\u0011\b\u0017\u0012\u0006\u0010R\u001a\u00020Q\u00a2\u0006\u0004\bU\u0010WJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0003J\b\u0010\u000f\u001a\u00020\u0006H\u0003J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u00162\b\u0010 \u001a\u0004\u0018\u00010\u001fJV\u0010,\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&2\u001e\u0010+\u001a\u001a\u0012\u0004\u0012\u00020\"\u0012\b\u0012\u00060$j\u0002`)\u0018\u00010(j\u0004\u0018\u0001`*H\u0007JT\u0010-\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&2\u001e\u0010+\u001a\u001a\u0012\u0004\u0012\u00020\"\u0012\b\u0012\u00060$j\u0002`)\u0018\u00010(j\u0004\u0018\u0001`*H\u0007J\u0019\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0.\u00a2\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0006J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u00020\u0006J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020\bH\u0016J\u0006\u00109\u001a\u00020\u0006R\u0018\u0010<\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010C\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR.\u0010L\u001a\u001a\u0012\u0004\u0012\u00020\"\u0012\b\u0012\u00060$j\u0002`)\u0018\u00010(j\u0004\u0018\u0001`*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR \u0010P\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020$0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006Z"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineBoardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "tv", "", "textsize", "", "M0", "", "H0", "currentHeight", "targetHeight", "Landroid/view/View;", "targetView", "D0", "B0", "textView", "I0", "", "msgId", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "chatMessage", "", "J0", "Lcom/tencent/android/androidbypass/parser/a;", "parser", "setParser", "setTextViewAppearance", "Landroid/view/View$OnLongClickListener;", "l", "setOnLongClickListener", "", "content", "L0", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/a;", "dispatchContext", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMessage", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "innerKeyboardInfo", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "Lcom/tencent/guild/aio/msglist/markdown/IGuildInlineKeyboardClickHandler;", "listener", "K0", "P0", "", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "G0", "()[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "O0", "N0", "", "F0", "Q0", "value", "setMaxWidth", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/android/androidbypass/parser/a;", "mMarkdownParser", "Lcom/tencent/android/androidbypass/MarkdownTextView;", "e", "Lcom/tencent/android/androidbypass/MarkdownTextView;", "mTextView", "f", "Landroid/view/View;", "mTextViewFadeOut", h.F, "Ljava/lang/String;", "mOriginText", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MarkdownElement;", "mChatMessage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "mOnButtonClickListener", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;", "mLayoutManager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class InlineBoardView extends ConstraintLayout {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final InlineBoardLayoutManager<a, GuildMsgItem> mLayoutManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.parser.a mMarkdownParser;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MarkdownTextView mTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mTextViewFadeOut;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mOriginText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MarkdownElement mChatMessage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<a, GuildMsgItem> mOnButtonClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineBoardView$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/parser/a;", "parser", "Lcom/tencent/guild/aio/msglist/markdown/inlineboard/InlineBoardView;", "a", "Landroid/widget/TextView;", "tv", "", "b", "", "ANIMATION_TIME_IN_MS", "I", "BUTTON_HORIZONTAL_TEXTPADDING", "BUTTON_SPACE", "ID_NULL", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.markdown.inlineboard.InlineBoardView$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @RequiresApi(api = 17)
        @NotNull
        public final InlineBoardView a(@NotNull Context context, @Nullable com.tencent.android.androidbypass.parser.a parser) {
            Intrinsics.checkNotNullParameter(context, "context");
            InlineBoardView inlineBoardView = new InlineBoardView(context);
            inlineBoardView.setParser(parser);
            return inlineBoardView;
        }

        @SuppressLint({"WrongConstant"})
        public final void b(@NotNull TextView tv5) {
            Intrinsics.checkNotNullParameter(tv5, "tv");
            if (fq0.a.f400309a.w()) {
                try {
                    tv5.setBreakStrategy(0);
                } catch (Throwable unused) {
                }
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/guild/aio/msglist/markdown/inlineboard/InlineBoardView$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f111752d;

        b(View view) {
            this.f111752d = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ViewGroup.LayoutParams layoutParams = this.f111752d.getLayoutParams();
            layoutParams.height = -2;
            this.f111752d.setLayoutParams(layoutParams);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 17)
    public InlineBoardView(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLayoutManager = new InlineBoardLayoutManager<>(new Function1<com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a, InlineBtnStyleSheet>() { // from class: com.tencent.guild.aio.msglist.markdown.inlineboard.InlineBoardView$mLayoutManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final InlineBtnStyleSheet invoke(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return InlineButtonStyleUtils.l(InlineButtonStyleUtils.f111753a, context, it, false, 4, null);
            }
        });
        setId(View.generateViewId());
        LayoutInflater.from(context).inflate(R.layout.evq, this);
        setPadding(ViewUtils.dip2px(3.0f), ViewUtils.dip2px(3.0f), ViewUtils.dip2px(3.0f), ViewUtils.dip2px(3.0f));
        View findViewById = findViewById(R.id.wpj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_markdown_tv)");
        MarkdownTextView markdownTextView = (MarkdownTextView) findViewById;
        this.mTextView = markdownTextView;
        View findViewById2 = findViewById(R.id.wpk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_markdown_tv2)");
        this.mTextViewFadeOut = findViewById2;
        I0(markdownTextView);
        setClickable(true);
        setLongClickable(true);
    }

    @RequiresApi(api = 11)
    private final void B0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.3f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.aio.msglist.markdown.inlineboard.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                InlineBoardView.C0(InlineBoardView.this, valueAnimator);
            }
        });
        ofFloat.setDuration(160L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(InlineBoardView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.mTextView.setAlpha(((Float) animatedValue).floatValue());
    }

    @RequiresApi(api = 11)
    private final void D0(int currentHeight, int targetHeight, final View targetView) {
        ValueAnimator ofInt = ValueAnimator.ofInt(currentHeight, targetHeight);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.aio.msglist.markdown.inlineboard.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                InlineBoardView.E0(targetView, valueAnimator);
            }
        });
        ofInt.addListener(new b(targetView));
        ofInt.setDuration(200L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(View targetView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        layoutParams.height = intValue;
        targetView.setLayoutParams(layoutParams);
    }

    private final int H0() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
        float f16 = displayMetrics.density;
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        return (((int) (((int) (min * ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getSplitRatioOfFunction())) - (76 * f16))) - getContext().getResources().getDimensionPixelSize(R.dimen.c_r)) - getContext().getResources().getDimensionPixelSize(R.dimen.c_r);
    }

    private final void I0(TextView textView) {
        INSTANCE.b(textView);
        textView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    }

    private final CharSequence J0(long msgId, MarkdownElement chatMessage) {
        com.tencent.android.androidbypass.parser.a aVar = this.mMarkdownParser;
        Intrinsics.checkNotNull(aVar);
        String str = chatMessage.content;
        Intrinsics.checkNotNullExpressionValue(str, "chatMessage.content");
        return aVar.a(str, this.mTextView, new a.b(msgId, false, 2, null));
    }

    private final void M0(TextView tv5, float textsize) {
        tv5.setLineSpacing(ViewUtils.dip2px(5.0f), 1.0f);
        tv5.setTextSize(textsize * 0.9375f);
        GuildUIUtils.f235378a.b(tv5, f.i(f.f111944a, false, 1, null));
        tv5.setTypeface(null);
        tv5.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        tv5.setGravity(16);
        tv5.setSelectAllOnFocus(false);
        tv5.setIncludeFontPadding(false);
    }

    public final boolean F0() {
        int H0 = H0();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        boolean z16 = false;
        if (layoutParams != null && layoutParams.width == H0) {
            z16 = true;
        }
        return !z16;
    }

    @NotNull
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] G0() {
        return this.mLayoutManager.f();
    }

    @RequiresApi(api = 17)
    @Nullable
    public final CharSequence K0(long msgId, @NotNull a dispatchContext, @NotNull MarkdownElement chatMessage, @Nullable GuildMsgItem guildMessage, @Nullable InlineKeyboardElement innerKeyboardInfo, @Nullable com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<a, GuildMsgItem> listener) {
        Intrinsics.checkNotNullParameter(dispatchContext, "dispatchContext");
        Intrinsics.checkNotNullParameter(chatMessage, "chatMessage");
        this.mChatMessage = chatMessage;
        this.mOnButtonClickListener = listener;
        String str = chatMessage.content;
        if (innerKeyboardInfo != null) {
            this.mLayoutManager.h(dispatchContext, guildMessage, e.f111771a.d(innerKeyboardInfo), listener);
            this.mLayoutManager.b(false, this.mTextView, this);
        } else {
            this.mLayoutManager.d();
        }
        this.mOriginText = str;
        return J0(msgId, chatMessage);
    }

    @Nullable
    public final CharSequence L0(@Nullable String content) {
        this.mOriginText = content;
        this.mLayoutManager.d();
        this.mTextView.setText(content);
        return content;
    }

    public final void N0() {
        if (F0()) {
            Q0();
            requestLayout();
            invalidate();
        }
    }

    public final void O0() {
        this.mLayoutManager.i();
    }

    @RequiresApi(api = 17)
    public final void P0(long msgId, @NotNull a dispatchContext, @NotNull MarkdownElement chatMessage, @Nullable GuildMsgItem guildMessage, @Nullable InlineKeyboardElement innerKeyboardInfo, @Nullable com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<a, GuildMsgItem> listener) {
        Intrinsics.checkNotNullParameter(dispatchContext, "dispatchContext");
        Intrinsics.checkNotNullParameter(chatMessage, "chatMessage");
        this.mChatMessage = chatMessage;
        this.mOnButtonClickListener = listener;
        int height = getHeight();
        if (height == 0) {
            K0(msgId, dispatchContext, chatMessage, guildMessage, innerKeyboardInfo, listener);
            return;
        }
        int measuredHeight = this.mTextView.getMeasuredHeight();
        J0(msgId, chatMessage);
        B0();
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight2 = getMeasuredHeight();
        QLog.d("MKDRender.InlineBoard", 4, "updateContent: height from " + height + " - " + measuredHeight2);
        D0(measuredHeight, (measuredHeight2 - height) + measuredHeight, this.mTextView);
        if (innerKeyboardInfo != null) {
            this.mLayoutManager.h(dispatchContext, guildMessage, e.f111771a.d(innerKeyboardInfo), this.mOnButtonClickListener);
            this.mLayoutManager.b(true, this.mTextView, this);
        } else {
            this.mLayoutManager.d();
        }
    }

    public final void Q0() {
        int H0 = H0();
        setMaxWidth(H0);
        if (getLayoutParams() == null) {
            setLayoutParams(new Constraints.LayoutParams(H0, -2));
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = H0;
        layoutParams.height = -2;
        setLayoutParams(layoutParams);
    }

    public final void onDestroy() {
        this.mTextView.onDestroy();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setMaxWidth(int value) {
        super.setMaxWidth(value);
        this.mTextView.setMaxWidth((value - getPaddingLeft()) - getPaddingRight());
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener l3) {
        super.setOnLongClickListener(l3);
        this.mTextView.setOnLongClickListener(l3);
    }

    public final void setParser(@Nullable com.tencent.android.androidbypass.parser.a parser) {
        this.mMarkdownParser = parser;
    }

    public final void setTextViewAppearance(float textsize) {
        M0(this.mTextView, textsize);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 17)
    public InlineBoardView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
