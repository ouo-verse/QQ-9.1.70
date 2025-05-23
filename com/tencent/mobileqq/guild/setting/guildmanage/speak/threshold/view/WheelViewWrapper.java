package com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.theme.SkinnableView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/speak/threshold/view/WheelViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/tencent/theme/SkinnableView;", "Lcom/tencent/mobileqq/remind/widget/WheelView;", "b", "", "onThemeChanged", "", "Landroid/view/View;", "d", "Lkotlin/Lazy;", "a", "()[Landroid/view/View;", "dividers", "Lvp1/dv;", "e", "Lvp1/dv;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class WheelViewWrapper extends FrameLayout implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dividers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dv binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WheelViewWrapper(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final View[] a() {
        return (View[]) this.dividers.getValue();
    }

    @NotNull
    public final WheelView b() {
        WheelView wheelView = this.binding.f442999b;
        Intrinsics.checkNotNullExpressionValue(wheelView, "binding.joinTimeWheel");
        return wheelView;
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        int i3;
        ie0.a f16 = ie0.a.f();
        Context context = getContext();
        if (GuildThemeManager.f235286a.b()) {
            i3 = 1002;
        } else {
            i3 = 1001;
        }
        ColorStateList h16 = f16.h(context, R.color.qui_common_border_standard, i3);
        for (View view : a()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(h16);
            view.setBackground(gradientDrawable);
        }
    }

    public /* synthetic */ WheelViewWrapper(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WheelViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<View[]>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.WheelViewWrapper$dividers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View[] invoke() {
                View findViewById = WheelViewWrapper.this.findViewById(R.id.yin);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.line_top)");
                View findViewById2 = WheelViewWrapper.this.findViewById(R.id.e_x);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.line_up)");
                View findViewById3 = WheelViewWrapper.this.findViewById(R.id.e_b);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.line_down)");
                return new View[]{findViewById, findViewById2, findViewById3};
            }
        });
        this.dividers = lazy;
        dv f16 = dv.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        onThemeChanged();
    }
}
