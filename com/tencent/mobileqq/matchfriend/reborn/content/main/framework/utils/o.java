package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\u000b\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u001a\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0001\"\u0018\u0010\u0011\u001a\u00020\b*\u00020\b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0011\u001a\u00020\u0001*\u00020\u00018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Landroid/view/View;", "", "expendSize", "", "b", "Landroid/widget/TextView;", "", "text", "", "width", "Landroid/text/DynamicLayout;", "f", "spaceWidthDp", "Landroid/text/SpannableString;", "g", "e", "(I)I", "dp", "d", "(F)F", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class o {
    public static final void b(final View view, final float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.n
            @Override // java.lang.Runnable
            public final void run() {
                o.c(view, f16, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View this_expandTouchZone, float f16, View parentView) {
        Intrinsics.checkNotNullParameter(this_expandTouchZone, "$this_expandTouchZone");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        this_expandTouchZone.getHitRect(rect);
        int d16 = (int) d(f16);
        rect.left -= d16;
        rect.top -= d16;
        rect.right += d16;
        rect.bottom += d16;
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expandTouchZone));
    }

    public static final float d(float f16) {
        return ViewUtils.f244350a.c(f16);
    }

    public static final int e(int i3) {
        return ViewUtils.f244350a.b(i3);
    }

    public static final DynamicLayout f(TextView textView, CharSequence text, int i3) {
        DynamicLayout.Builder obtain;
        DynamicLayout.Builder alignment;
        DynamicLayout.Builder breakStrategy;
        boolean isFallbackLineSpacing;
        DynamicLayout.Builder useLineSpacingFromFallbacks;
        DynamicLayout.Builder hyphenationFrequency;
        DynamicLayout.Builder includePad;
        DynamicLayout build;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        if (Build.VERSION.SDK_INT >= 28) {
            obtain = DynamicLayout.Builder.obtain(text, textView.getPaint(), i3);
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain(text, paint, width)");
            alignment = obtain.setAlignment(Layout.Alignment.ALIGN_NORMAL);
            breakStrategy = alignment.setBreakStrategy(textView.getBreakStrategy());
            isFallbackLineSpacing = textView.isFallbackLineSpacing();
            useLineSpacingFromFallbacks = breakStrategy.setUseLineSpacingFromFallbacks(isFallbackLineSpacing);
            hyphenationFrequency = useLineSpacingFromFallbacks.setHyphenationFrequency(textView.getHyphenationFrequency());
            includePad = hyphenationFrequency.setIncludePad(textView.getIncludeFontPadding());
            includePad.setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier());
            build = obtain.build();
            Intrinsics.checkNotNullExpressionValue(build, "{\n        val builder = \u2026    builder.build()\n    }");
            return build;
        }
        return new DynamicLayout(text, textView.getPaint(), i3, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
    }

    public static final SpannableString g(float f16) {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, (int) ViewUtils.f244350a.c(f16), 1);
        ImageSpan imageSpan = new ImageSpan(colorDrawable);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, 1, 33);
        return spannableString;
    }
}
