package com.tencent.mobileqq.qqlive.sail.ui.gift;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveQuickGiftPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "", com.tencent.luggage.wxa.c8.c.G, "buttonSum", "", "ra", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "U9", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "Z9", "V9", "Lqk4/h;", "e", "Lqk4/h;", "quickGiftPresenter", "Lgj4/c;", "f", "Lgj4/c;", "effectComboPresenter", "Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", tl.h.F, "Lkotlin/Lazy;", "na", "()Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "giftViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "i", "ma", "()Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "bottomViewModel", "", "oa", "()Z", MiniChatConstants.MINI_APP_LANDSCAPE, "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveQuickGiftPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final qk4.h quickGiftPresenter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gj4.c effectComboPresenter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy giftViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bottomViewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/QQLiveQuickGiftPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52134);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveQuickGiftPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.quickGiftPresenter = new qk4.h();
        this.effectComboPresenter = new gj4.c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GiftViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftPart$giftViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveQuickGiftPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GiftViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (GiftViewModel) QQLiveQuickGiftPart.this.getViewModel(GiftViewModel.class) : (GiftViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.giftViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.more.b>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftPart$bottomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveQuickGiftPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.more.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.more.b) QQLiveQuickGiftPart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.more.b.class) : (com.tencent.mobileqq.qqlive.sail.ui.more.b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.bottomViewModel = lazy2;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.more.b ma() {
        Object value = this.bottomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.more.b) value;
    }

    private final GiftViewModel na() {
        Object value = this.giftViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-giftViewModel>(...)");
        return (GiftViewModel) value;
    }

    private final boolean oa() {
        Resources resources;
        Configuration configuration;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(int pos, int buttonSum) {
        FrameLayout frameLayout;
        int b16;
        Resources resources;
        AegisLogger.INSTANCE.i("Gift|QQLiveQuickGiftPart", "updateQuickGiftBtnPosition", "roomId=" + H9() + ", pos=" + pos + ", total=" + buttonSum);
        int i3 = buttonSum - pos;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            frameLayout = (FrameLayout) partRootView.findViewById(R.id.f61452y6);
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                b16 = resources.getDimensionPixelOffset(R.dimen.c5i);
            } else {
                b16 = wi2.c.b(40);
            }
            int b17 = wi2.c.b(12);
            int b18 = wi2.c.b(108);
            int b19 = wi2.c.b(12);
            if (oa()) {
                b19 = wi2.c.b(24) + wi2.c.b(12);
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ((b19 + ((b17 + b16) * i3)) + (b16 / 2)) - (b18 / 2);
            frameLayout.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.U9();
        if (F9() != null) {
            this.quickGiftPresenter.A(getActivity(), H9(), J9());
            gj4.c cVar = this.effectComboPresenter;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            cVar.w(activity, H9());
            na().n2();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Gift|QQLiveQuickGiftPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.V9();
        this.quickGiftPresenter.B();
        this.effectComboPresenter.x();
        na().t2();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void Z9(@Nullable com.tencent.mobileqq.qqgift.data.service.d data) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
            return;
        }
        super.Z9(data);
        if (data != null) {
            AegisLogger.INSTANCE.i("Gift|QQLiveQuickGiftPart", "onSendGift", "roomId=" + H9() + ", giftId=" + data.f264874d + ", price=" + data.f264878f);
            this.quickGiftPresenter.L(data);
            if (R9()) {
                if (data.f264878f == 0) {
                    this.quickGiftPresenter.C();
                } else {
                    this.quickGiftPresenter.D();
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Gift|QQLiveQuickGiftPart", "onSendGift", "roomId=" + H9() + ", invalid gift data");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f61452y6);
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            this.quickGiftPresenter.J(frameLayout);
            this.effectComboPresenter.B(frameLayout);
        }
        LiveData<c55.d> f26 = na().f2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<c55.d, Unit> function1 = new Function1<c55.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftPart$onInitView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveQuickGiftPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c55.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable c55.d dVar) {
                qk4.h hVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar);
                } else {
                    hVar = QQLiveQuickGiftPart.this.quickGiftPresenter;
                    hVar.K(dVar);
                }
            }
        };
        f26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveQuickGiftPart.pa(Function1.this, obj);
            }
        });
        LiveData<Pair<Integer, Integer>> b26 = ma().b2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Pair<? extends Integer, ? extends Integer>, Unit> function12 = new Function1<Pair<? extends Integer, ? extends Integer>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.QQLiveQuickGiftPart$onInitView$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveQuickGiftPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends Integer> pair) {
                invoke2((Pair<Integer, Integer>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Integer, Integer> pair) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQLiveQuickGiftPart.this.ra(pair.getFirst().intValue(), pair.getSecond().intValue());
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pair);
                }
            }
        };
        b26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveQuickGiftPart.qa(Function1.this, obj);
            }
        });
    }
}
