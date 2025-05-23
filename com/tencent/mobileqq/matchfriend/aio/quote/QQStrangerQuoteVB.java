package com.tencent.mobileqq.matchfriend.aio.quote;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteUIState;
import com.tencent.mobileqq.matchfriend.aio.quote.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0003H\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "data", "", "e1", "", "needAnim", "j1", "show", "f1", ICustomDataEditor.NUMBER_PARAM_1, "o1", "clip", "", "padding", "l1", "margin", "k1", "m1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "bindViewAndData", "state", "i1", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "hostView", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteView;", "e", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteView;", "quoteView", "f", "Z", "isShowing", tl.h.F, "Lkotlin/Lazy;", "h1", "()I", "quoteHeight", "i", "I", "msgListPadding", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "quoteMargin", "Landroid/animation/Animator;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/animation/Animator;", "smoothAnimator", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerQuoteVB extends com.tencent.aio.base.mvvm.a<d, QQStrangerQuoteUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private Animator smoothAnimator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout hostView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQStrangerQuoteView quoteView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy quoteHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int msgListPadding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int quoteMargin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVB$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f243923e;

        b(boolean z16) {
            this.f243923e = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QQStrangerQuoteView qQStrangerQuoteView = QQStrangerQuoteVB.this.quoteView;
            if (qQStrangerQuoteView == null) {
                return;
            }
            qQStrangerQuoteView.setVisibility(this.f243923e ? 0 : 8);
        }
    }

    public QQStrangerQuoteVB() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVB$quoteHeight$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dpToPx(194.0f));
            }
        });
        this.quoteHeight = lazy;
        this.quoteMargin = -h1();
    }

    private final void e1(final QQStrangerQuoteData data) {
        if (this.quoteView != null) {
            return;
        }
        QLog.d("QQStrangerQuoteVB", 1, "addQuoteView");
        FrameLayout frameLayout = this.hostView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostView");
            frameLayout = null;
        }
        LayoutInflater from = LayoutInflater.from(frameLayout.getContext());
        FrameLayout frameLayout2 = this.hostView;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostView");
            frameLayout2 = null;
        }
        View inflate = from.inflate(R.layout.cwu, (ViewGroup) frameLayout2, false);
        QQStrangerQuoteView qQStrangerQuoteView = inflate instanceof QQStrangerQuoteView ? (QQStrangerQuoteView) inflate : null;
        this.quoteView = qQStrangerQuoteView;
        if (qQStrangerQuoteView != null) {
            qQStrangerQuoteView.setOnCloseListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVB$addQuoteView$1$1
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
                    QQStrangerQuoteVB.this.j1(true);
                }
            });
            qQStrangerQuoteView.setOnActionClickListener(new Function1<QQStrangerQuoteAction, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVB$addQuoteView$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQStrangerQuoteAction qQStrangerQuoteAction) {
                    invoke2(qQStrangerQuoteAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(QQStrangerQuoteAction action) {
                    Intrinsics.checkNotNullParameter(action, "action");
                    QQStrangerQuoteVB.this.sendIntent(new d.c(data, action));
                }
            });
            FrameworkVM mUIModel = getMUIModel();
            qQStrangerQuoteView.o(mUIModel != null ? (com.tencent.aio.api.runtime.a) mUIModel.getMContext() : null, data);
            FrameLayout frameLayout3 = this.hostView;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostView");
                frameLayout3 = null;
            }
            frameLayout3.addView(this.quoteView, new FrameLayout.LayoutParams(-1, -2));
            FrameLayout frameLayout4 = this.hostView;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostView");
                frameLayout4 = null;
            }
            frameLayout4.setVisibility(0);
        }
        g1(this, true, false, 2, null);
    }

    private final void f1(boolean show, boolean needAnim) {
        if (this.quoteView == null || this.isShowing == show) {
            return;
        }
        this.isShowing = show;
        QLog.d("QQStrangerQuoteVB", 1, "changeQuoteViewState show=" + show);
        if (show) {
            boolean isVasTheme = QQTheme.isVasTheme();
            QQStrangerQuoteView qQStrangerQuoteView = this.quoteView;
            if (qQStrangerQuoteView != null) {
                qQStrangerQuoteView.j(!isVasTheme);
                qQStrangerQuoteView.k(!isVasTheme);
            }
        }
        if (needAnim) {
            o1(show);
        } else {
            n1(show);
        }
    }

    private final int h1() {
        return ((Number) this.quoteHeight.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(boolean needAnim) {
        if (this.quoteView == null) {
            return;
        }
        QLog.d("QQStrangerQuoteVB", 1, "removeQuoteView");
        f1(false, needAnim);
        FrameLayout frameLayout = this.hostView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostView");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = this.hostView;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostView");
            frameLayout2 = null;
        }
        if (frameLayout2.getParent() != null) {
            ViewParent parent = frameLayout2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(frameLayout2);
        }
        this.quoteView = null;
        sendIntent(d.a.f243953d);
    }

    private final void k1(int margin) {
        FrameLayout frameLayout = this.hostView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hostView");
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = margin;
            FrameLayout frameLayout3 = this.hostView;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hostView");
            } else {
                frameLayout2 = frameLayout3;
            }
            frameLayout2.setLayoutParams(marginLayoutParams);
        }
    }

    private final void l1(boolean clip, int padding) {
        this.msgListPadding = padding;
        sendIntent(new d.C8004d(clip, padding));
    }

    private final void m1(int margin) {
        this.quoteMargin = margin;
        QQStrangerQuoteView qQStrangerQuoteView = this.quoteView;
        ViewGroup.LayoutParams layoutParams = qQStrangerQuoteView != null ? qQStrangerQuoteView.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = margin;
            QQStrangerQuoteView qQStrangerQuoteView2 = this.quoteView;
            if (qQStrangerQuoteView2 == null) {
                return;
            }
            qQStrangerQuoteView2.setLayoutParams(marginLayoutParams);
        }
    }

    private final void n1(boolean show) {
        QQStrangerQuoteView qQStrangerQuoteView = this.quoteView;
        if (qQStrangerQuoteView != null) {
            qQStrangerQuoteView.setVisibility(show ? 0 : 8);
        }
        if (show) {
            l1(true, h1());
        } else {
            l1(false, 0);
        }
        m1(0);
    }

    private final void o1(final boolean show) {
        final int i3 = this.msgListPadding;
        final int h16 = show ? h1() : 0;
        final int i16 = this.quoteMargin;
        final int i17 = show ? 0 : -h1();
        QQStrangerQuoteView qQStrangerQuoteView = this.quoteView;
        if (qQStrangerQuoteView != null) {
            qQStrangerQuoteView.setVisibility(0);
        }
        l1(show, i3);
        m1(i16);
        Animator animator = this.smoothAnimator;
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        he0.b.l(ofFloat, R.anim.f154986ut);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QQStrangerQuoteVB.p1(i3, h16, this, show, i16, i17, valueAnimator);
            }
        });
        ofFloat.addListener(new b(show));
        ofFloat.start();
        this.smoothAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(int i3, int i16, QQStrangerQuoteVB this$0, boolean z16, int i17, int i18, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Float f16 = animatedValue instanceof Float ? (Float) animatedValue : null;
        float floatValue = f16 != null ? f16.floatValue() : 1.0f;
        this$0.l1(z16, (int) (i3 + ((i16 - i3) * floatValue)));
        this$0.m1((int) (i17 + ((i18 - i17) * floatValue)));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        sendIntent(d.b.f243954d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    /* renamed from: createVM */
    public BaseVM<d, QQStrangerQuoteUIState, com.tencent.aio.api.runtime.a> getViewModel() {
        return new QQStrangerQuoteVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(QQStrangerQuoteUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof QQStrangerQuoteUIState.AddQuoteView) {
            e1(((QQStrangerQuoteUIState.AddQuoteView) state).getData());
            return;
        }
        if (state instanceof QQStrangerQuoteUIState.RemoveQuoteView) {
            j1(((QQStrangerQuoteUIState.RemoveQuoteView) state).getNeedAnim());
            return;
        }
        if (state instanceof QQStrangerQuoteUIState.ChangeQuoteViewState) {
            QQStrangerQuoteUIState.ChangeQuoteViewState changeQuoteViewState = (QQStrangerQuoteUIState.ChangeQuoteViewState) state;
            f1(changeQuoteViewState.getShow(), changeQuoteViewState.getNeedAnim());
        } else if (state instanceof QQStrangerQuoteUIState.UpdateBottomMargin) {
            k1(((QQStrangerQuoteUIState.UpdateBottomMargin) state).getMargin());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setVisibility(8);
        this.hostView = frameLayout;
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
    }

    static /* synthetic */ void g1(QQStrangerQuoteVB qQStrangerQuoteVB, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        qQStrangerQuoteVB.f1(z16, z17);
    }
}
