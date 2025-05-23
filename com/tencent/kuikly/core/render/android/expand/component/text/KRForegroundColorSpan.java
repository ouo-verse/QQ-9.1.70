package com.tencent.kuikly.core.render.android.expand.component.text;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/KRForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "Landroid/text/TextPaint;", "textPaint", "", "updateDrawState", "", "d", "I", "a", "()I", "b", "(I)V", "drawStateColor", "e", "color", "<init>", "f", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRForegroundColorSpan extends ForegroundColorSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int drawStateColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int color;

    public KRForegroundColorSpan(int i3) {
        super(i3);
        this.color = i3;
        this.drawStateColor = 2;
    }

    /* renamed from: a, reason: from getter */
    public final int getDrawStateColor() {
        return this.drawStateColor;
    }

    public final void b(int i3) {
        this.drawStateColor = i3;
    }

    @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        int i3 = this.drawStateColor;
        if (i3 != 0) {
            if (i3 == 2) {
                textPaint.setColor(this.color);
                return;
            }
            return;
        }
        textPaint.setColor(0);
    }
}
