package com.tencent.mobileqq.guild.feed.nativepublish.feature.movement;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010G\u001a\u000200\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00101R\u001e\u00107\u001a\u0004\u0018\u0001038B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\t\u00104\u001a\u0004\b5\u00106R3\u0010=\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R[\u0010@\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010DR\u0014\u0010F\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010%\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorMovementEffect;", "", "", "height", "", "u", "expandedHeight", NodeProps.MAX_HEIGHT, "", "f", ReportConstant.COSTREPORT_PREFIX, "alphaPercent", "r", "offset", "k", "e", "shadowHeightAndInputOffset", "Landroid/view/animation/Interpolator;", tl.h.F, "", "isHalfScreenMode", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "t", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "a", "Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "binding", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;", "inputAnimController", "c", "I", "getShadowHeight", "()I", "p", "(I)V", "shadowHeight", "d", "Z", "j", "()Z", "o", "(Z)V", "isBackgroundEffectEnabled", "", "Ljava/lang/String;", "logTag", "Landroid/view/View;", "Landroid/view/View;", "i", "()Landroid/view/View;", "rootBackgroundView", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "g", "Lkotlin/jvm/functions/Function1;", "backgroundEffectImpl", "Lkotlin/reflect/KFunction3;", "Lkotlin/reflect/KFunction;", "moveInterpolateMethod", "Landroid/graphics/Point;", "Landroid/graphics/Point;", "oldBazierKeyPoint", "Landroid/view/animation/Interpolator;", "interpolator", "inputHeightIncludingDecoration", "prefix", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/framework/animation/e;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SimplifiedFeedEditorMovementEffect {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimplifiedFeedEditorViewBinding binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e inputAnimController;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int shadowHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isBackgroundEffectEnabled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View rootBackgroundView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Float, Unit> backgroundEffectImpl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private KFunction<Float> moveInterpolateMethod;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Point oldBazierKeyPoint;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Interpolator interpolator;

    public SimplifiedFeedEditorMovementEffect(@NotNull String prefix, @NotNull SimplifiedFeedEditorViewBinding binding, @NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e inputAnimController) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(inputAnimController, "inputAnimController");
        this.binding = binding;
        this.inputAnimController = inputAnimController;
        this.shadowHeight = -1;
        this.logTag = prefix + ".MovementEffect";
        this.moveInterpolateMethod = new SimplifiedFeedEditorMovementEffect$moveInterpolateMethod$1(this);
        n(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float e(int expandedHeight, int offset, int maxHeight) {
        if (offset == 0) {
            return expandedHeight;
        }
        Interpolator h16 = h(offset, maxHeight);
        float f16 = maxHeight;
        float f17 = expandedHeight / f16;
        if (offset > 0) {
            return h16.getInterpolation(f17) * f16;
        }
        return (h16.getInterpolation(f17) * (maxHeight - offset)) + offset;
    }

    private final float f(int expandedHeight, int maxHeight) {
        if (this.shadowHeight < 0) {
            return expandedHeight;
        }
        if (maxHeight <= 0) {
            return 0.0f;
        }
        int g16 = this.shadowHeight - g();
        if (g16 >= maxHeight) {
            return g16;
        }
        return ((Number) ((Function3) this.moveInterpolateMethod).invoke(Integer.valueOf(expandedHeight), Integer.valueOf(g16), Integer.valueOf(maxHeight))).floatValue();
    }

    private final int g() {
        return (this.binding.getBottomLinearLayout().getTop() - this.binding.getWhiteSheetBackground().getTop()) + SimplifiedFeedEditorViewBinding.INSTANCE.c();
    }

    private final Interpolator h(int shadowHeightAndInputOffset, int maxHeight) {
        float abs;
        Interpolator interpolator;
        Point point = this.oldBazierKeyPoint;
        if (point != null && point.x == shadowHeightAndInputOffset && point.y == maxHeight && (interpolator = this.interpolator) != null) {
            Intrinsics.checkNotNull(interpolator);
            return interpolator;
        }
        if (point == null) {
            point = new Point();
        }
        point.x = shadowHeightAndInputOffset;
        point.y = maxHeight;
        this.oldBazierKeyPoint = point;
        if (shadowHeightAndInputOffset > 0) {
            abs = shadowHeightAndInputOffset / maxHeight;
        } else {
            abs = Math.abs(shadowHeightAndInputOffset) / (Math.abs(shadowHeightAndInputOffset) + maxHeight);
        }
        ve1.b bVar = new ve1.b(0.0f, abs, 0.0f, abs);
        this.interpolator = bVar;
        Intrinsics.checkNotNull(bVar);
        return bVar;
    }

    private final View i() {
        if (this.rootBackgroundView == null) {
            this.rootBackgroundView = this.binding.getRoot().findViewById(SimplifiedFeedEditorViewBinding.INSTANCE.i());
        }
        return this.rootBackgroundView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float k(int expandedHeight, int offset, int maxHeight) {
        float f16 = offset;
        return ((1 - (f16 / maxHeight)) * expandedHeight) + f16;
    }

    private final void r(float alphaPercent) {
        Drawable drawable;
        View i3 = i();
        if (i3 != null) {
            drawable = i3.getBackground();
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setAlpha((int) (alphaPercent * 255));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        r(this.inputAnimController.f() / this.inputAnimController.j());
    }

    private final void u(int height) {
        if (height >= 0) {
            View u16 = this.binding.u();
            ViewGroup.LayoutParams layoutParams = u16.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = height;
                u16.setLayoutParams(layoutParams);
                View bottomGuideLine = this.binding.getBottomGuideLine();
                ViewGroup.LayoutParams layoutParams2 = bottomGuideLine.getLayoutParams();
                if (layoutParams2 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams.topMargin = 0;
                    bottomGuideLine.setLayoutParams(marginLayoutParams);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        View u17 = this.binding.u();
        ViewGroup.LayoutParams layoutParams3 = u17.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.height = 0;
            u17.setLayoutParams(layoutParams3);
            View bottomGuideLine2 = this.binding.getBottomGuideLine();
            ViewGroup.LayoutParams layoutParams4 = bottomGuideLine2.getLayoutParams();
            if (layoutParams4 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams2.topMargin = -height;
                bottomGuideLine2.setLayoutParams(marginLayoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsBackgroundEffectEnabled() {
        return this.isBackgroundEffectEnabled;
    }

    public final void l() {
        n(true);
        this.moveInterpolateMethod = new SimplifiedFeedEditorMovementEffect$onFirstShowUpCompletely$1(this);
    }

    public final void m() {
        this.shadowHeight = 0;
        this.backgroundEffectImpl = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorMovementEffect$onRenderFirstFrame$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke(f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f16) {
                SimplifiedFeedEditorMovementEffect.this.s();
            }
        };
        t(0, this.inputAnimController.j());
    }

    public final void n(boolean isHalfScreenMode) {
        if (isHalfScreenMode) {
            this.shadowHeight = -1;
            this.backgroundEffectImpl = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorMovementEffect$onSwitchMode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                    invoke(f16.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f16) {
                    com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e eVar;
                    if (SimplifiedFeedEditorMovementEffect.this.getIsBackgroundEffectEnabled()) {
                        eVar = SimplifiedFeedEditorMovementEffect.this.inputAnimController;
                        if (com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.g.d(eVar)) {
                            SimplifiedFeedEditorMovementEffect.this.s();
                        }
                    }
                }
            };
        } else {
            this.backgroundEffectImpl = null;
            this.shadowHeight = -1;
        }
    }

    public final void o(boolean z16) {
        this.isBackgroundEffectEnabled = z16;
    }

    public final void p(int i3) {
        this.shadowHeight = i3;
    }

    public final void q() {
        l();
        t(0, 0);
        r(1.0f);
    }

    public final void t(int expandedHeight, int maxHeight) {
        float f16 = f(expandedHeight, maxHeight);
        u((int) f16);
        Function1<? super Float, Unit> function1 = this.backgroundEffectImpl;
        if (function1 != null) {
            function1.invoke(Float.valueOf(f16));
        }
    }
}
