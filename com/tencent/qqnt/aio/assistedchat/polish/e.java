package com.tencent.qqnt.aio.assistedchat.polish;

import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u0007"}, d2 = {"Landroid/widget/TextView;", "", "text", "", "width", "Landroid/text/DynamicLayout;", "a", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    @NotNull
    public static final DynamicLayout a(@NotNull TextView textView, @NotNull CharSequence text, int i3) {
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
}
