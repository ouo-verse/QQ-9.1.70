package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0000\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0000\u001a\u0016\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0000\u001a \u0010\u000b\u001a\u0004\u0018\u00010\u0006*\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u0000\u001a\u0012\u0010\u000e\u001a\u00020\r*\u00020\b2\u0006\u0010\f\u001a\u00020\u0000\u001a\u0012\u0010\u000f\u001a\u00020\r*\u00020\b2\u0006\u0010\f\u001a\u00020\u0000\u001a\u0012\u0010\u0010\u001a\u00020\r*\u00020\b2\u0006\u0010\f\u001a\u00020\u0000\u001a\u0012\u0010\u0011\u001a\u00020\r*\u00020\b2\u0006\u0010\f\u001a\u00020\u0000\u001a1\u0010\u0016\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\b*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a9\u0010\u001a\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\b*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a1\u0010\u001c\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\b*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a)\u0010\u001e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\b*\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010\f\u001a\u00020!*\u00020\b2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\r0 \u00a2\u0006\u0002\b\"\u001a'\u0010%\u001a\u00020$*\u00020\b2\u001b\b\u0002\u0010#\u001a\u0015\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r\u0018\u00010 \u00a2\u0006\u0002\b\"\u001a#\u0010'\u001a\u00020&*\u00020\b2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r0 \u00a2\u0006\u0002\b\"\u001a'\u0010(\u001a\u00020\b*\u00020\b2\u001b\b\u0002\u0010#\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010 \u00a2\u0006\u0002\b\"\u001a\u0006\u0010)\u001a\u00020\u0018\u001a\u0006\u0010+\u001a\u00020*\u001a\u0018\u0010.\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00002\b\b\u0002\u0010-\u001a\u00020\u0000\u001a\u0018\u00101\u001a\u00020\u00002\u0006\u0010,\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/\u00a8\u00062"}, d2 = {"", "i", "", "u", "Landroid/content/Context;", "id", "Landroid/graphics/drawable/Drawable;", "j", "Landroid/view/View;", "k", "nightId", "l", "v", "", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "T", "Landroid/view/ViewGroup;", "Lkotlin/Function0;", "child", "b", "(Landroid/view/ViewGroup;ILkotlin/jvm/functions/Function0;)Landroid/view/View;", "Landroid/view/ViewGroup$LayoutParams;", "params", "a", "(Landroid/view/ViewGroup;ILandroid/view/ViewGroup$LayoutParams;Lkotlin/jvm/functions/Function0;)Landroid/view/View;", "c", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;Lkotlin/jvm/functions/Function0;)Landroid/view/View;", "d", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)Landroid/view/View;", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ExtensionFunctionType;", "invoke", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/widget/RoundRectImageView;", "t", "w", "o", "", DomainData.DOMAIN_NAME, "dayColor", "night", "e", "", "nightColor", "f", "vas-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class o {
    @NotNull
    public static final <T extends View> T a(@NotNull ViewGroup viewGroup, int i3, @NotNull ViewGroup.LayoutParams params, @NotNull Function0<? extends T> child) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(child, "child");
        T invoke = child.invoke();
        invoke.setId(i3);
        viewGroup.addView(invoke, params);
        return invoke;
    }

    @NotNull
    public static final <T extends View> T b(@NotNull ViewGroup viewGroup, int i3, @NotNull Function0<? extends T> child) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        T invoke = child.invoke();
        invoke.setId(i3);
        viewGroup.addView(invoke);
        return invoke;
    }

    @NotNull
    public static final <T extends View> T c(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams params, @NotNull Function0<? extends T> child) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(child, "child");
        T invoke = child.invoke();
        viewGroup.addView(invoke, params);
        return invoke;
    }

    @NotNull
    public static final <T extends View> T d(@NotNull ViewGroup viewGroup, @NotNull Function0<? extends T> child) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        T invoke = child.invoke();
        viewGroup.addView(invoke);
        return invoke;
    }

    public static final int e(int i3, int i16) {
        if (n()) {
            return i16;
        }
        return i3;
    }

    public static final int f(@NotNull String dayColor, @NotNull String nightColor) {
        Intrinsics.checkNotNullParameter(dayColor, "dayColor");
        Intrinsics.checkNotNullParameter(nightColor, "nightColor");
        return e(Color.parseColor(dayColor), Color.parseColor(nightColor));
    }

    public static /* synthetic */ int g(int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = i3;
        }
        return e(i3, i16);
    }

    public static /* synthetic */ int h(String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return f(str, str2);
    }

    public static final int i(int i3) {
        return ViewUtils.dpToPx(i3);
    }

    @Nullable
    public static final Drawable j(@NotNull Context context, @DrawableRes int i3) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getDrawable(context, i3);
    }

    @Nullable
    public static final Drawable k(@NotNull View view, @DrawableRes int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return ContextCompat.getDrawable(view.getContext(), i3);
    }

    @Nullable
    public static final Drawable l(@NotNull View view, @DrawableRes int i3, @DrawableRes int i16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (n()) {
            return ContextCompat.getDrawable(view.getContext(), i16);
        }
        return ContextCompat.getDrawable(view.getContext(), i3);
    }

    @NotNull
    public static final ImageView m(@NotNull View view, @Nullable Function1<? super ImageView, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ImageView imageView = new ImageView(view.getContext());
        if (function1 != null) {
            function1.invoke(imageView);
        }
        return imageView;
    }

    public static final boolean n() {
        return ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null);
    }

    @NotNull
    public static final ViewGroup.LayoutParams o() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    public static final void p(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }

    public static final void q(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingStart(), view.getPaddingTop(), i3, view.getPaddingBottom());
    }

    public static final void r(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(i3, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final void s(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingStart(), i3, view.getPaddingRight(), view.getPaddingBottom());
    }

    @NotNull
    public static final RoundRectImageView t(@NotNull View view, @NotNull Function1<? super RoundRectImageView, Unit> invoke) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        RoundRectImageView roundRectImageView = new RoundRectImageView(view.getContext());
        invoke.invoke(roundRectImageView);
        return roundRectImageView;
    }

    public static final float u(int i3) {
        return i3;
    }

    @NotNull
    public static final TextView v(@NotNull View view, @NotNull Function1<? super TextView, Unit> invoke) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        TextView textView = new TextView(view.getContext());
        invoke.invoke(textView);
        return textView;
    }

    @NotNull
    public static final View w(@NotNull View view, @Nullable Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        View view2 = new View(view.getContext());
        if (function1 != null) {
            function1.invoke(view2);
        }
        return view2;
    }

    public static /* synthetic */ View x(View view, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        return w(view, function1);
    }
}
