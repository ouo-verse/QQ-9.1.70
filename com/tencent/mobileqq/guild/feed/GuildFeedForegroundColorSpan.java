package com.tencent.mobileqq.guild.feed;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/GuildFeedForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "", "color", "", "a", "Landroid/text/TextPaint;", "textPaint", "updateDrawState", "d", "I", "textColor", "<init>", "(I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedForegroundColorSpan extends ForegroundColorSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int textColor;

    public GuildFeedForegroundColorSpan(int i3) {
        super(i3);
        this.textColor = i3;
    }

    public final void a(int color) {
        this.textColor = color;
    }

    @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setColor(this.textColor);
    }
}
