package com.tencent.mobileqq.aio.reserve1.blur;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.blur.BottomBlurUIState;
import com.tencent.mobileqq.aio.reserve1.blur.a;
import com.tencent.mobileqq.aio.reserve1.blur.b;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0018B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u001b\u0010\u001d\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/BottomBlurVB;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/a;", "Lcom/tencent/mobileqq/aio/reserve1/blur/a;", "Lcom/tencent/mobileqq/aio/reserve1/blur/BottomBlurUIState;", "Lcom/tencent/mobileqq/aio/reserve1/blur/b$c;", "", "height", "", "g1", "Lcom/tencent/mobileqq/aio/reserve1/blur/BottomBlurUIState$ShowBlurView;", "state", "c1", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/mvi/base/route/MsgIntent;", "initIntent", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "b1", "f1", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "a", "e", "Lkotlin/Lazy;", "d1", "()Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initMsgIntent", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "f", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class BottomBlurVB extends com.tencent.qqnt.aio.lazy.lazyInit.a<com.tencent.mobileqq.aio.reserve1.blur.a, BottomBlurUIState> implements b.c {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f193214f;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/blur/BottomBlurVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64633);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f193214f = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomBlurVB(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQBlurViewWrapper>() { // from class: com.tencent.mobileqq.aio.reserve1.blur.BottomBlurVB$rootView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BottomBlurVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final QQBlurViewWrapper invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QQBlurViewWrapper) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    DisplayMetrics displayMetrics = BottomBlurVB.this.getMContext().getResources().getDisplayMetrics();
                    QQBlurViewWrapper qQBlurViewWrapper = new QQBlurViewWrapper(BottomBlurVB.this.getMContext(), null, 0, 6, null);
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) TypedValue.applyDimension(1, 88.0f, displayMetrics);
                    layoutParams.bottomToBottom = 0;
                    qQBlurViewWrapper.setLayoutParams(layoutParams);
                    qQBlurViewWrapper.setId(R.id.f164620t93);
                    qQBlurViewWrapper.setVisibility(8);
                    return qQBlurViewWrapper;
                }
            });
            this.rootView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
        }
    }

    private final void c1(BottomBlurUIState.ShowBlurView state) {
        boolean z16;
        QQBlurViewWrapper d16 = d1();
        d1().getLayoutParams().height = state.a();
        d16.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, null, getMContext().getColor(R.color.qui_common_bg_nav_bottom_aio), new ColorDrawable(getMContext().getColor(R.color.qui_common_bg_nav_bottom_aio)), Integer.valueOf(R.drawable.c1j));
        aVar.o(true);
        d16.a(aVar);
    }

    private final QQBlurViewWrapper d1() {
        return (QQBlurViewWrapper) this.rootView.getValue();
    }

    private final void e1() {
        try {
            if (d1().getVisibility() == 8) {
                return;
            }
            sendIntent(new a.b(am.f194110a.e(d1(), false)));
            d1().setVisibility(8);
        } catch (Exception e16) {
            QLog.e("BottomBlurVB", 1, "handleInputBarBitmap inputBlur bitmap exception: " + e16);
        }
    }

    private final void g1(int height) {
        ViewGroup.LayoutParams layoutParams = d1().getLayoutParams();
        if (height == 0) {
            height = 1;
        }
        layoutParams.height = height;
        d1().setLayoutParams(d1().getLayoutParams());
    }

    @Override // com.tencent.mobileqq.aio.reserve1.blur.b.c
    @NotNull
    public QQBlurViewWrapper a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QQBlurViewWrapper) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return d1();
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.a
    @NotNull
    public com.tencent.qqnt.aio.lazy.lazyInit.b<com.tencent.mobileqq.aio.reserve1.blur.a, BottomBlurUIState> b1(@NotNull MsgIntent initIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.aio.lazy.lazyInit.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) initIntent);
        }
        Intrinsics.checkNotNullParameter(initIntent, "initIntent");
        return new b(this, initIntent);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.bindViewAndData();
            sendIntent(a.C7345a.f193220d);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull BottomBlurUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof BottomBlurUIState.HideBlurView) {
            d1().setVisibility(8);
            return;
        }
        if (state instanceof BottomBlurUIState.ShowBlurView) {
            c1((BottomBlurUIState.ShowBlurView) state);
        } else if (state instanceof BottomBlurUIState.UpdateBlurHeight) {
            g1(((BottomBlurUIState.UpdateBlurHeight) state).a());
        } else if (state instanceof BottomBlurUIState.GetBottomBlurBitmap) {
            e1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return d1();
    }
}
