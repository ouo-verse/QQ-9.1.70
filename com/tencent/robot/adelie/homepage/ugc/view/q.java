package com.tencent.robot.adelie.homepage.ugc.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/q;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "", "a", "Landroid/graphics/drawable/StateListDrawable;", "b", "Landroid/content/res/ColorStateList;", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f366599a = new q();

    q() {
    }

    public final void a(@Nullable Context context, @Nullable View view) {
        if (context != null && view != null && ScreenUtil.checkDeviceHasNavigationBar(context)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "view.layoutParams");
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin -= ScreenUtil.getNavigationBarHeight(context);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    @NotNull
    public final StateListDrawable b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(context.getColor(R.color.f158017al3));
        gradientDrawable.setStroke(Utils.n(0.5f, BaseApplication.getContext().getResources()), context.getColor(R.color.qui_common_brand_standard));
        gradientDrawable.setCornerRadius(c24.a.a(29));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(CommonExKt.l(context.getColor(R.color.qui_common_fill_light_primary), 0.5f));
        gradientDrawable2.setStroke(Utils.n(0.5f, BaseApplication.getContext().getResources()), context.getColor(R.color.qui_common_border_superlight));
        gradientDrawable2.setCornerRadius(c24.a.a(29));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    @NotNull
    public final ColorStateList c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{context.getColor(R.color.qui_common_brand_standard), context.getColor(R.color.qui_common_text_primary)});
    }
}
