package nw1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lnw1/c;", "Lmw1/c;", "Landroid/widget/TextView;", "textView", "Lmw1/b;", "helper", "", "d", "c", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/view/View;", "view", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c implements mw1.c {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f421453d = new c();

    c() {
    }

    private final Drawable b(mw1.b helper, Context context, Drawable d16) {
        Drawable a16;
        if (d16 != null && (a16 = helper.a(context, d16)) != d16) {
            a16.setBounds(d16.getBounds());
            return a16;
        }
        return d16;
    }

    private final void c(TextView textView, mw1.b helper) {
        Context context = textView.getContext();
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(compoundDrawables, "textView.compoundDrawables");
        if (compoundDrawables.length == 4 && (compoundDrawables[0] != null || compoundDrawables[1] != null || compoundDrawables[2] != null || compoundDrawables[3] != null)) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Drawable b16 = b(helper, context, compoundDrawables[3]);
            Drawable[] drawableArr = {b(helper, context, compoundDrawables[0]), b(helper, context, compoundDrawables[1]), b(helper, context, compoundDrawables[2]), b16};
            textView.setCompoundDrawables(drawableArr[0], drawableArr[1], drawableArr[2], b16);
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative, "textView.compoundDrawablesRelative");
        if (compoundDrawablesRelative.length == 4) {
            if (compoundDrawablesRelative[0] != null || compoundDrawablesRelative[2] != null) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Drawable b17 = b(helper, context, compoundDrawablesRelative[2]);
                Drawable drawable = compoundDrawablesRelative[3];
                Drawable[] drawableArr2 = {b(helper, context, compoundDrawablesRelative[0]), compoundDrawablesRelative[1], b17, drawable};
                textView.setCompoundDrawablesRelative(drawableArr2[0], drawableArr2[1], b17, drawable);
            }
        }
    }

    private final void d(TextView textView, mw1.b helper) {
        ColorStateList b16;
        ColorStateList b17;
        ColorStateList b18;
        ColorStateList textColors = textView.getTextColors();
        if (textColors != null && (b18 = helper.b(textColors)) != textColors) {
            textView.setTextColor(b18);
        }
        ColorStateList linkTextColors = textView.getLinkTextColors();
        if (linkTextColors != null && (b17 = helper.b(linkTextColors)) != linkTextColors) {
            textView.setLinkTextColor(b17);
        }
        ColorStateList hintTextColors = textView.getHintTextColors();
        if (hintTextColors != null && (b16 = helper.b(hintTextColors)) != hintTextColors) {
            textView.setHintTextColor(b16);
        }
    }

    @Override // mw1.c
    public void a(@NotNull View view, @NotNull mw1.b helper) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        d(textView, helper);
        c(textView, helper);
    }
}
