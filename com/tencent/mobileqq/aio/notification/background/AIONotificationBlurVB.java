package com.tencent.mobileqq.aio.notification.background;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.widget.AIORecycleView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.api.list.p;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.aio.reserve2.notification.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qui.quiblurview.QQBlur;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00014B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b1\u00102J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u001c\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/background/AIONotificationBlurVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState;", "Landroid/view/View;", "bgView", "", "enableBlur", "", "p1", "u1", "", "listHeight", "closeBtnHeight", ICustomDataEditor.NUMBER_PARAM_1, "height", "oldHeight", "l1", "j1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "state", "o1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lp81/f;", "d", "Lp81/f;", "viewBinding", "Lcom/tencent/mobileqq/aio/notification/background/AIONotificationBlurView;", "e", "Lcom/tencent/mobileqq/aio/notification/background/AIONotificationBlurView;", "blurView", "f", "Z", "hadCreateBlur", h.F, "layoutChanged", "i", "drawChanged", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "closeBtnShowing", BdhLogUtil.LogTag.Tag_Conn, "I", "animingHeight", "<init>", "(Lp81/f;)V", "D", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationBlurVB extends com.tencent.aio.base.mvvm.a<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int animingHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p81.f viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIONotificationBlurView blurView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hadCreateBlur;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean layoutChanged;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean drawChanged;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean closeBtnShowing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/background/AIONotificationBlurVB$a;", "", "", "BLUR_OVERLAY_ALPHA", "D", "", "BLUR_RADIUS", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.background.AIONotificationBlurVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/notification/background/AIONotificationBlurVB$b", "Lcom/tencent/aio/api/list/p;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "dispatchDraw", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements p {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationBlurVB.this);
            }
        }

        @Override // com.tencent.aio.api.list.p
        public void dispatchDraw(@Nullable Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            if (canvas != null) {
                AIONotificationBlurView aIONotificationBlurView = AIONotificationBlurVB.this.blurView;
                if (aIONotificationBlurView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    aIONotificationBlurView = null;
                }
                if (!aIONotificationBlurView.o(canvas)) {
                    AIONotificationBlurVB.this.drawChanged = true;
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52829);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONotificationBlurVB(@NotNull p81.f viewBinding) {
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewBinding);
        } else {
            this.viewBinding = viewBinding;
            this.animingHeight = -1;
        }
    }

    private final void j1(final int height, int oldHeight) {
        ValueAnimator animator = ValueAnimator.ofInt(oldHeight, height);
        if (height > oldHeight) {
            AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
            AIONotificationBlurView aIONotificationBlurView = this.blurView;
            if (aIONotificationBlurView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView = null;
            }
            aIONotificationUIUtils.Z(aIONotificationBlurView, height);
        } else {
            AIONotificationUIUtils aIONotificationUIUtils2 = AIONotificationUIUtils.f192828a;
            Intrinsics.checkNotNullExpressionValue(animator, "animator");
            aIONotificationUIUtils2.l(animator, new Function0<Unit>(height) { // from class: com.tencent.mobileqq.aio.notification.background.AIONotificationBlurVB$animInExpandState$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $height;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$height = height;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationBlurVB.this, height);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    AIONotificationUIUtils aIONotificationUIUtils3 = AIONotificationUIUtils.f192828a;
                    AIONotificationBlurView aIONotificationBlurView2 = AIONotificationBlurVB.this.blurView;
                    if (aIONotificationBlurView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("blurView");
                        aIONotificationBlurView2 = null;
                    }
                    aIONotificationUIUtils3.Z(aIONotificationBlurView2, this.$height);
                }
            });
        }
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.notification.background.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIONotificationBlurVB.k1(AIONotificationBlurVB.this, valueAnimator);
            }
        });
        AIONotificationUIUtils aIONotificationUIUtils3 = AIONotificationUIUtils.f192828a;
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        aIONotificationUIUtils3.l(animator, new Function0<Unit>(height) { // from class: com.tencent.mobileqq.aio.notification.background.AIONotificationBlurVB$animInExpandState$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $height;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$height = height;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationBlurVB.this, height);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AIONotificationUIUtils aIONotificationUIUtils4 = AIONotificationUIUtils.f192828a;
                AIONotificationBlurView aIONotificationBlurView2 = AIONotificationBlurVB.this.blurView;
                if (aIONotificationBlurView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    aIONotificationBlurView2 = null;
                }
                aIONotificationUIUtils4.Z(aIONotificationBlurView2, this.$height);
                AIONotificationBlurView aIONotificationBlurView3 = AIONotificationBlurVB.this.blurView;
                if (aIONotificationBlurView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    aIONotificationBlurView3 = null;
                }
                aIONotificationBlurView3.setClipBounds(null);
                AIONotificationBlurVB.this.animingHeight = -1;
            }
        });
        animator.setInterpolator(null);
        animator.setDuration(200L);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(AIONotificationBlurVB this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        AIONotificationBlurView aIONotificationBlurView = this$0.blurView;
        AIONotificationBlurView aIONotificationBlurView2 = null;
        if (aIONotificationBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView = null;
        }
        AIONotificationBlurView aIONotificationBlurView3 = this$0.blurView;
        if (aIONotificationBlurView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
        } else {
            aIONotificationBlurView2 = aIONotificationBlurView3;
        }
        aIONotificationBlurView.setClipBounds(new Rect(0, 0, aIONotificationBlurView2.getWidth(), intValue));
    }

    private final void l1(final int height, int oldHeight) {
        ValueAnimator animator;
        AIONotificationBlurView aIONotificationBlurView = null;
        if (height > oldHeight) {
            AIONotificationBlurView aIONotificationBlurView2 = this.blurView;
            if (aIONotificationBlurView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView2 = null;
            }
            aIONotificationBlurView2.setAnimAlpha(0.0f);
            animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        } else {
            AIONotificationBlurView aIONotificationBlurView3 = this.blurView;
            if (aIONotificationBlurView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView3 = null;
            }
            aIONotificationBlurView3.setAnimAlpha(1.0f);
            animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        }
        if (height > oldHeight) {
            AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
            AIONotificationBlurView aIONotificationBlurView4 = this.blurView;
            if (aIONotificationBlurView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView4 = null;
            }
            aIONotificationUIUtils.Z(aIONotificationBlurView4, height);
        } else {
            AIONotificationUIUtils aIONotificationUIUtils2 = AIONotificationUIUtils.f192828a;
            Intrinsics.checkNotNullExpressionValue(animator, "animator");
            aIONotificationUIUtils2.l(animator, new Function0<Unit>(height) { // from class: com.tencent.mobileqq.aio.notification.background.AIONotificationBlurVB$animInFoldState$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $height;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$height = height;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationBlurVB.this, height);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    AIONotificationUIUtils aIONotificationUIUtils3 = AIONotificationUIUtils.f192828a;
                    AIONotificationBlurView aIONotificationBlurView5 = AIONotificationBlurVB.this.blurView;
                    if (aIONotificationBlurView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("blurView");
                        aIONotificationBlurView5 = null;
                    }
                    aIONotificationUIUtils3.Z(aIONotificationBlurView5, this.$height);
                }
            });
        }
        AIONotificationUIUtils aIONotificationUIUtils3 = AIONotificationUIUtils.f192828a;
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        aIONotificationUIUtils3.l(animator, new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.notification.background.AIONotificationBlurVB$animInFoldState$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationBlurVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AIONotificationBlurView aIONotificationBlurView5 = AIONotificationBlurVB.this.blurView;
                if (aIONotificationBlurView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    aIONotificationBlurView5 = null;
                }
                aIONotificationBlurView5.setAnimAlphaHeight(0.0f);
                AIONotificationBlurVB.this.animingHeight = -1;
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.notification.background.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIONotificationBlurVB.m1(AIONotificationBlurVB.this, valueAnimator);
            }
        });
        animator.setInterpolator(null);
        AIONotificationBlurView aIONotificationBlurView5 = this.blurView;
        if (aIONotificationBlurView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
        } else {
            aIONotificationBlurView = aIONotificationBlurView5;
        }
        aIONotificationBlurView.setAnimAlphaHeight(Math.abs(height - oldHeight));
        animator.setDuration(200L);
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(AIONotificationBlurVB this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        AIONotificationBlurView aIONotificationBlurView = this$0.blurView;
        if (aIONotificationBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView = null;
        }
        aIONotificationBlurView.setAnimAlpha(floatValue);
    }

    private final void n1(int listHeight, int closeBtnHeight) {
        int height;
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationBlurVB", 2, "animUpdateBlurSize: listHeight=" + listHeight + ", closeBtnHeight=" + closeBtnHeight);
        }
        AIONotificationBlurView aIONotificationBlurView = this.blurView;
        AIONotificationBlurView aIONotificationBlurView2 = null;
        if (aIONotificationBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView = null;
        }
        boolean z16 = false;
        aIONotificationBlurView.setVisibility(0);
        int i3 = listHeight + closeBtnHeight;
        AIONotificationBlurView aIONotificationBlurView3 = this.blurView;
        if (aIONotificationBlurView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView3 = null;
        }
        if (aIONotificationBlurView3.getLayoutParams() != null) {
            AIONotificationBlurView aIONotificationBlurView4 = this.blurView;
            if (aIONotificationBlurView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView4 = null;
            }
            height = aIONotificationBlurView4.getLayoutParams().height;
        } else {
            AIONotificationBlurView aIONotificationBlurView5 = this.blurView;
            if (aIONotificationBlurView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView5 = null;
            }
            height = aIONotificationBlurView5.getHeight();
        }
        sendIntent(new a.b(i3));
        if (i3 != height && i3 != this.animingHeight) {
            if (closeBtnHeight == 0) {
                AIONotificationBlurView aIONotificationBlurView6 = this.blurView;
                if (aIONotificationBlurView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                } else {
                    aIONotificationBlurView2 = aIONotificationBlurView6;
                }
                aIONotificationBlurView2.setEdgeHeight(AIONotificationUIUtils.f192828a.o(getMContext()));
            } else {
                AIONotificationBlurView aIONotificationBlurView7 = this.blurView;
                if (aIONotificationBlurView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                } else {
                    aIONotificationBlurView2 = aIONotificationBlurView7;
                }
                aIONotificationBlurView2.setEdgeHeight(0.0f);
            }
            this.animingHeight = i3;
            if (closeBtnHeight <= 0 && !this.closeBtnShowing) {
                l1(i3, height);
                if (QLog.isColorLevel()) {
                    QLog.d("AIONotificationBlurVB", 2, "animUpdateBlurSize: UpdateNavigationTranslationY");
                }
                sendIntent(new a.c(i3));
            } else {
                j1(i3, height);
            }
        }
        if (closeBtnHeight > 0) {
            z16 = true;
        }
        this.closeBtnShowing = z16;
    }

    private final void p1(final View bgView, boolean enableBlur) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationBlurVB", 2, "initBlur: enable=" + enableBlur + ", " + bgView);
        }
        AIONotificationBlurView aIONotificationBlurView = this.blurView;
        AIONotificationBlurView aIONotificationBlurView2 = null;
        if (aIONotificationBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView = null;
        }
        boolean z17 = false;
        aIONotificationBlurView.setVisibility(0);
        AIONotificationBlurView aIONotificationBlurView3 = this.blurView;
        if (aIONotificationBlurView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView3 = null;
        }
        aIONotificationBlurView3.l(30);
        int color = getMContext().getResources().getColor(R.color.qui_common_bg_aio_01);
        AIONotificationBlurView aIONotificationBlurView4 = this.blurView;
        if (aIONotificationBlurView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView4 = null;
        }
        aIONotificationBlurView4.p(color);
        ColorDrawable colorDrawable = new ColorDrawable(color);
        colorDrawable.setAlpha(76);
        AIONotificationBlurView aIONotificationBlurView5 = this.blurView;
        if (aIONotificationBlurView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView5 = null;
        }
        aIONotificationBlurView5.z(colorDrawable);
        AIONotificationBlurView aIONotificationBlurView6 = this.blurView;
        if (aIONotificationBlurView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView6 = null;
        }
        aIONotificationBlurView6.setBlurBackgroundColor(color);
        AIONotificationBlurView aIONotificationBlurView7 = this.blurView;
        if (aIONotificationBlurView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView7 = null;
        }
        aIONotificationBlurView7.y(true);
        AIONotificationBlurView aIONotificationBlurView8 = this.blurView;
        if (aIONotificationBlurView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView8 = null;
        }
        aIONotificationBlurView8.setScaleModeOnSizeChanged(1);
        if (bgView != null && enableBlur) {
            if (bgView instanceof AIORecycleView) {
                ((AIORecycleView) bgView).addOnDispatchDrawListener(new b());
            }
            AIONotificationBlurView aIONotificationBlurView9 = this.blurView;
            if (aIONotificationBlurView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView9 = null;
            }
            aIONotificationBlurView9.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.notification.background.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    AIONotificationBlurVB.q1(AIONotificationBlurVB.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
            bgView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.aio.notification.background.b
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                    AIONotificationBlurVB.r1(AIONotificationBlurVB.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
                }
            });
            AIONotificationBlurView aIONotificationBlurView10 = this.blurView;
            if (aIONotificationBlurView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView10 = null;
            }
            aIONotificationBlurView10.setDirtyListener(new QQBlur.a() { // from class: com.tencent.mobileqq.aio.notification.background.c
                @Override // com.tencent.qui.quiblurview.QQBlur.a
                public final boolean a() {
                    boolean s16;
                    s16 = AIONotificationBlurVB.s1(AIONotificationBlurVB.this, bgView);
                    return s16;
                }
            });
            AIONotificationBlurView aIONotificationBlurView11 = this.blurView;
            if (aIONotificationBlurView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView11 = null;
            }
            aIONotificationBlurView11.j(bgView);
            if (Build.VERSION.SDK_INT >= 24) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z18 = !QQTheme.isNowSimpleUI();
            AIONotificationBlurView aIONotificationBlurView12 = this.blurView;
            if (aIONotificationBlurView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView12 = null;
            }
            if (z16 && z18) {
                z17 = true;
            }
            aIONotificationBlurView12.setEnableBlur(z17);
        } else {
            AIONotificationBlurView aIONotificationBlurView13 = this.blurView;
            if (aIONotificationBlurView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView13 = null;
            }
            aIONotificationBlurView13.setEnableBlur(false);
            AIONotificationBlurView aIONotificationBlurView14 = this.blurView;
            if (aIONotificationBlurView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView14 = null;
            }
            aIONotificationBlurView14.setBlurBackgroundColor(0);
        }
        AIONotificationBlurView aIONotificationBlurView15 = this.blurView;
        if (aIONotificationBlurView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
        } else {
            aIONotificationBlurView2 = aIONotificationBlurView15;
        }
        aIONotificationBlurView2.x();
        this.hadCreateBlur = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(AIONotificationBlurVB this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i18 != i28) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.layoutChanged = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(AIONotificationBlurVB this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.layoutChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s1(AIONotificationBlurVB this$0, View view) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.layoutChanged && !this$0.drawChanged) {
            z16 = false;
        } else {
            z16 = true;
        }
        this$0.layoutChanged = false;
        this$0.drawChanged = false;
        AIONotificationBlurView aIONotificationBlurView = this$0.blurView;
        if (aIONotificationBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView = null;
        }
        if (aIONotificationBlurView.getHeight() > 0 && (view.isDirty() || z16)) {
            return true;
        }
        return false;
    }

    private final void u1() {
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationBlurVB", 2, "onThemeChange: ");
        }
        if (this.hadCreateBlur) {
            AIONotificationBlurView aIONotificationBlurView = this.blurView;
            AIONotificationBlurView aIONotificationBlurView2 = null;
            if (aIONotificationBlurView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blurView");
                aIONotificationBlurView = null;
            }
            if (aIONotificationBlurView.b()) {
                AIONotificationBlurView aIONotificationBlurView3 = this.blurView;
                if (aIONotificationBlurView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    aIONotificationBlurView3 = null;
                }
                aIONotificationBlurView3.l(30);
                int color = getMContext().getResources().getColor(R.color.qui_common_bg_aio_01);
                AIONotificationBlurView aIONotificationBlurView4 = this.blurView;
                if (aIONotificationBlurView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    aIONotificationBlurView4 = null;
                }
                aIONotificationBlurView4.p(color);
                ColorDrawable colorDrawable = new ColorDrawable(color);
                colorDrawable.setAlpha(76);
                AIONotificationBlurView aIONotificationBlurView5 = this.blurView;
                if (aIONotificationBlurView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                    aIONotificationBlurView5 = null;
                }
                aIONotificationBlurView5.z(colorDrawable);
                AIONotificationBlurView aIONotificationBlurView6 = this.blurView;
                if (aIONotificationBlurView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("blurView");
                } else {
                    aIONotificationBlurView2 = aIONotificationBlurView6;
                }
                aIONotificationBlurView2.setBlurBackgroundColor(color);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        if (!this.hadCreateBlur) {
            sendIntent(a.C7353a.f193505d);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: createVM */
    public BaseVM<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState, com.tencent.aio.api.runtime.a> getViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new f();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIONotificationUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIONotificationUIState.UpdateBlurViewUIState) {
            AIONotificationUIState.UpdateBlurViewUIState updateBlurViewUIState = (AIONotificationUIState.UpdateBlurViewUIState) state;
            p1(updateBlurViewUIState.a(), updateBlurViewUIState.b());
        } else if (state instanceof AIONotificationUIState.UpdateContainerSizeUIState) {
            AIONotificationUIState.UpdateContainerSizeUIState updateContainerSizeUIState = (AIONotificationUIState.UpdateContainerSizeUIState) state;
            n1(updateContainerSizeUIState.b(), updateContainerSizeUIState.a());
        } else if (state instanceof AIONotificationUIState.OnThemeChangeUIState) {
            u1();
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        AIONotificationBlurView aIONotificationBlurView = this.viewBinding.f425737g;
        Intrinsics.checkNotNullExpressionValue(aIONotificationBlurView, "viewBinding.blurView");
        this.blurView = aIONotificationBlurView;
        if (aIONotificationBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView = null;
        }
        aIONotificationBlurView.getLayoutParams().height = 0;
        AIONotificationBlurView aIONotificationBlurView2 = this.viewBinding.f425737g;
        Intrinsics.checkNotNullExpressionValue(aIONotificationBlurView2, "viewBinding.blurView");
        return aIONotificationBlurView2;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        AIONotificationBlurView aIONotificationBlurView = this.blurView;
        AIONotificationBlurView aIONotificationBlurView2 = null;
        if (aIONotificationBlurView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView = null;
        }
        aIONotificationUIUtils.Z(aIONotificationBlurView, 0);
        this.layoutChanged = false;
        this.drawChanged = false;
        this.closeBtnShowing = false;
        this.animingHeight = -1;
        AIONotificationBlurView aIONotificationBlurView3 = this.blurView;
        if (aIONotificationBlurView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView3 = null;
        }
        aIONotificationBlurView3.setAnimAlpha(0.0f);
        AIONotificationBlurView aIONotificationBlurView4 = this.blurView;
        if (aIONotificationBlurView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView4 = null;
        }
        aIONotificationBlurView4.setAnimAlphaHeight(0.0f);
        AIONotificationBlurView aIONotificationBlurView5 = this.blurView;
        if (aIONotificationBlurView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
            aIONotificationBlurView5 = null;
        }
        aIONotificationBlurView5.setClipBounds(null);
        AIONotificationBlurView aIONotificationBlurView6 = this.blurView;
        if (aIONotificationBlurView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurView");
        } else {
            aIONotificationBlurView2 = aIONotificationBlurView6;
        }
        aIONotificationBlurView2.setVisibility(8);
    }
}
