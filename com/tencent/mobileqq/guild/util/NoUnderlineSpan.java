package com.tencent.mobileqq.guild.util;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/util/NoUnderlineSpan;", "Landroid/text/style/UnderlineSpan;", "()V", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class NoUnderlineSpan extends UnderlineSpan {
    @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds5) {
        Intrinsics.checkNotNullParameter(ds5, "ds");
        ds5.setColor(ds5.linkColor);
        ds5.setUnderlineText(false);
    }
}
