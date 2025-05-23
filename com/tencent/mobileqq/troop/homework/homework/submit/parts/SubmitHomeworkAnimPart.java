package com.tencent.mobileqq.troop.homework.homework.submit.parts;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard;
import com.tencent.mobileqq.troop.homework.homework.submit.vm.SubmitHomeWorkVM;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/parts/SubmitHomeworkAnimPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "G9", "F9", "D9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", "viewModel", "", "e", "Z", "inputMethodIsActive", "Lts2/i;", "f", "Lts2/i;", "binding", "<init>", "()V", tl.h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class SubmitHomeworkAnimPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean inputMethodIsActive;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ts2.i binding;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/parts/SubmitHomeworkAnimPart$a;", "", "", "CALLBACK", "Ljava/lang/String;", "KEY_WEB_JS_PLUGIN_CALLBACK", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.homework.submit.parts.SubmitHomeworkAnimPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/homework/homework/submit/parts/SubmitHomeworkAnimPart$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeworkAnimPart.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Activity activity = SubmitHomeworkAnimPart.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            Activity activity2 = SubmitHomeworkAnimPart.this.getActivity();
            if (activity2 != null) {
                activity2.overridePendingTransition(0, 0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52011);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SubmitHomeworkAnimPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SubmitHomeWorkVM>() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.SubmitHomeworkAnimPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubmitHomeworkAnimPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SubmitHomeWorkVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (SubmitHomeWorkVM) new ViewModelProvider(SubmitHomeworkAnimPart.this.getHostFragment()).get(SubmitHomeWorkVM.class) : (SubmitHomeWorkVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void D9() {
        ts2.i iVar = this.binding;
        if (iVar == null) {
            return;
        }
        iVar.f437403c.animate().translationYBy(r1.getHeight()).setDuration(200L).start();
        iVar.getRoot().animate().alpha(0.0f).setDuration(150L).setStartDelay(150L).setListener(new b()).start();
    }

    private final SubmitHomeWorkVM E9() {
        return (SubmitHomeWorkVM) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        Activity activity;
        Boolean value = E9().W1().getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            if (Intrinsics.areEqual(E9().X1().getValue(), bool) && (activity = getActivity()) != null) {
                Intent intent = new Intent();
                intent.putExtra("callbackSn", "onNativeClose");
                intent.putExtra("result", "{\"hw_id\":\"" + E9().R1() + "\"}");
                intent.putExtra("SubmitHWAnimPartJsCallback", "{\"hw_id\":\"" + E9().R1() + "\"}");
                Unit unit = Unit.INSTANCE;
                activity.setResult(-1, intent);
            }
            D9();
        }
    }

    private final void G9() {
        LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(this);
        if (a16 == null) {
            return;
        }
        MutableLiveData<Boolean> W1 = E9().W1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.SubmitHomeworkAnimPart$initExitAnim$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SubmitHomeworkAnimPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean finish) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) finish);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(finish, "finish");
                if (finish.booleanValue()) {
                    SubmitHomeworkAnimPart.this.F9();
                }
            }
        };
        W1.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubmitHomeworkAnimPart.H9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> X1 = E9().X1();
        final SubmitHomeworkAnimPart$initExitAnim$2 submitHomeworkAnimPart$initExitAnim$2 = SubmitHomeworkAnimPart$initExitAnim$2.INSTANCE;
        X1.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubmitHomeworkAnimPart.I9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void J9() {
        final ts2.i iVar = this.binding;
        if (iVar == null) {
            return;
        }
        iVar.f437405e.setOnInputMethodChangeListener(new InputMethodGuard.a() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.c
            @Override // com.tencent.mobileqq.troop.homework.entry.ui.view.InputMethodGuard.a
            public final void Xb(boolean z16, int i3) {
                SubmitHomeworkAnimPart.K9(SubmitHomeworkAnimPart.this, iVar, z16, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(SubmitHomeworkAnimPart this$0, final ts2.i bindingNonNull, boolean z16, int i3) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bindingNonNull, "$bindingNonNull");
        this$0.inputMethodIsActive = z16;
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("SubmitHWAnimPart", "setOnInputMethodChangeListener:" + z16 + ",height:" + i3);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 - ViewUtils.dip2px(60.0f), 0);
        ValueAnimator ofInt = ValueAnimator.ofInt(bindingNonNull.getRoot().getPaddingBottom(), coerceAtLeast);
        ofInt.setDuration(150L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubmitHomeworkAnimPart.L9(ts2.i.this, valueAnimator);
            }
        });
        ofInt.start();
        if (!z16) {
            bindingNonNull.f437403c.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(ts2.i bindingNonNull, ValueAnimator valueAnimator) {
        Integer num;
        int i3;
        Intrinsics.checkNotNullParameter(bindingNonNull, "$bindingNonNull");
        LinearLayout linearLayout = bindingNonNull.f437403c;
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Integer) {
            num = (Integer) animatedValue;
        } else {
            num = null;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        linearLayout.setPadding(0, 0, 0, i3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("SubmitHWAnimPart", "error for init view got null");
            return;
        }
        this.binding = ts2.i.e(rootView);
        G9();
        J9();
    }
}
