package com.tencent.mobileqq.wink.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u0015\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001e\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkFilterApplyTipView;", "Landroid/widget/FrameLayout;", "", "f", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "k", "j", "", "g", "i", "", "e", "l", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "d", "Landroid/animation/ValueAnimator;", "mFilterIndicatorAnimator", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkFilterApplyTipView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mFilterIndicatorAnimator;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f322697e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/view/WinkFilterApplyTipView$a", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationStart", "onAnimationEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            WinkFilterApplyTipView.this.setVisibility(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (WinkFilterApplyTipView.this.g()) {
                WinkFilterApplyTipView.this.i();
            }
            WinkFilterApplyTipView.this.setVisibility(0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkFilterApplyTipView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String e() {
        return ((Object) ((TextView) b(R.id.f1052665j)).getText()) + "," + ((Object) ((TextView) b(R.id.f1056666m)).getText()) + "," + ((Object) ((TextView) b(R.id.f1056866o)).getText()) + "," + ((Object) ((TextView) b(R.id.f1056766n)).getText());
    }

    private final void f() {
        LayoutInflater.from(getContext()).inflate(R.layout.hdc, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (((TextView) b(R.id.f1056666m)).getText().toString().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        if (((TextView) b(R.id.f1056866o)).getText().toString().length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return true;
        }
        if (((TextView) b(R.id.f1056766n)).getText().toString().length() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(WinkFilterApplyTipView this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        VideoReport.setElementId(this, WinkDaTongReportConstant.ElementId.EM_XSJ_SMART_FILTER_TAG_PANEL);
        VideoReport.setElementExposePolicy(this, ExposurePolicy.REPORT_NONE);
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SMART_FILTER_TAG, e());
        VideoReport.reportEvent("dt_imp", this, params);
    }

    private final void j(MetaMaterial material) {
        boolean z16;
        ((TextView) b(R.id.f1052665j)).setText(com.tencent.mobileqq.wink.editor.c.a0(material));
        ((TextView) b(R.id.f1052565i)).setText(com.tencent.mobileqq.wink.editor.c.p(material));
        if (com.tencent.mobileqq.wink.editor.c.p(material) != null) {
            if (com.tencent.mobileqq.wink.editor.c.p(material).length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                b(R.id.f116036xn).setVisibility(0);
                ((TextView) b(R.id.f1052565i)).setVisibility(0);
                ((TextView) b(R.id.f1056666m)).setVisibility(8);
                ((TextView) b(R.id.f1056866o)).setVisibility(8);
                ((TextView) b(R.id.f1056766n)).setVisibility(8);
            }
        }
        b(R.id.f116036xn).setVisibility(8);
        ((TextView) b(R.id.f1052565i)).setVisibility(0);
        ((TextView) b(R.id.f1056666m)).setVisibility(8);
        ((TextView) b(R.id.f1056866o)).setVisibility(8);
        ((TextView) b(R.id.f1056766n)).setVisibility(8);
    }

    private final void k(MetaMaterial material) {
        boolean isBlank;
        ((TextView) b(R.id.f1052665j)).setText(com.tencent.mobileqq.wink.editor.c.a0(material));
        if (material.additionalFields.containsKey("label1")) {
            ((TextView) b(R.id.f1056666m)).setText(material.additionalFields.get("label1"));
            ((TextView) b(R.id.f1056666m)).setVisibility(0);
        }
        if (material.additionalFields.containsKey("label2")) {
            ((TextView) b(R.id.f1056866o)).setText(material.additionalFields.get("label2"));
            ((TextView) b(R.id.f1056866o)).setVisibility(0);
        } else {
            ((TextView) b(R.id.f1056866o)).setVisibility(8);
        }
        if (material.additionalFields.containsKey("label3")) {
            ((TextView) b(R.id.f1056766n)).setText(material.additionalFields.get("label3"));
            ((TextView) b(R.id.f1056766n)).setVisibility(0);
        } else {
            ((TextView) b(R.id.f1056766n)).setVisibility(8);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(com.tencent.mobileqq.wink.editor.filter.f.f(material));
        if (!isBlank) {
            ((TextView) b(R.id.f1052665j)).setText(com.tencent.mobileqq.wink.editor.filter.f.f(material));
        }
        ((TextView) b(R.id.f1052565i)).setVisibility(8);
        ((TextView) b(R.id.f1056666m)).setVisibility(0);
    }

    @Nullable
    public View b(int i3) {
        Map<Integer, View> map = this.f322697e;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View findViewById = findViewById(i3);
            if (findViewById != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final void l(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (com.tencent.mobileqq.wink.editor.filter.f.r(material)) {
            k(material);
        } else {
            j(material);
        }
        this.mFilterIndicatorAnimator.start();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkFilterApplyTipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkFilterApplyTipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f322697e = new LinkedHashMap();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 1.0f, 0.0f);
        ofFloat.setDuration(3000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.view.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WinkFilterApplyTipView.h(WinkFilterApplyTipView.this, valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        this.mFilterIndicatorAnimator = ofFloat;
        f();
    }
}
