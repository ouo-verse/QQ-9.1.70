package com.tencent.mobileqq.nearbypro.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.land.k;
import com.tencent.mobileqq.nearbypro.utils.d;
import com.tencent.mobileqq.nearbypro.utils.h;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import ga2.a;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/view/AreaMarkInfoComponent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "initView", "onFinishInflate", "", NodeProps.MAX_WIDTH, "setBrandMaxWidth", "", "name", "setAreaName", "count", "setUserCount", "", NodeProps.COLORS, "setBrandBg", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AreaMarkInfoComponent extends ConstraintLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaMarkInfoComponent(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        h.f253950a.d((TextView) findViewById(R.id.bal));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    public final void setAreaName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        TextView textView = (TextView) findViewById(R.id.sv7);
        textView.setText(name);
        int textWidth = ViewUtils.getTextWidth(textView.getPaint(), name);
        a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e("AreaMarkInfoComponent", "setAreaName name=" + name + " width=" + textWidth + " MAX_WIDTH=" + k.INSTANCE.a());
        }
        k.Companion companion = k.INSTANCE;
        if (textWidth > companion.a()) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(0, -2);
            }
            layoutParams.width = companion.a();
            textView.setLayoutParams(layoutParams);
            textView.setSelected(true);
            textView.requestFocus();
        }
    }

    public final void setBrandBg(@NotNull int[] colors) {
        String joinToString$default;
        boolean z16;
        Intrinsics.checkNotNullParameter(colors, "colors");
        a c16 = j.c();
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(colors, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        c16.e("AreaMarkInfoComponent", "setBrandBg colors=" + joinToString$default);
        if (colors.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            a c17 = j.c();
            if (c17.isColorLevel()) {
                c17.e("AreaMarkInfoComponent", "set default bg");
            }
            setBackgroundResource(R.drawable.k2f);
            return;
        }
        try {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BL_TR, colors);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            gradientDrawable.setStroke(d.c(2, context), -1);
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            gradientDrawable.setCornerRadius(d.a(5.0f, context2));
            setBackground(gradientDrawable);
        } catch (Exception e16) {
            j.c().d("AreaMarkInfoComponent", "setBrandBg fail: " + e16);
            setBackgroundResource(R.drawable.k2f);
        }
    }

    public final void setBrandMaxWidth(int maxWidth) {
        ((TextView) findViewById(R.id.sv7)).setMaxWidth(maxWidth);
    }

    public final void setUserCount(@NotNull String count) {
        Intrinsics.checkNotNullParameter(count, "count");
        ((TextView) findViewById(R.id.bal)).setText(count);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaMarkInfoComponent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
