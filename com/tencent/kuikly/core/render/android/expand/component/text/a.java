package com.tencent.kuikly.core.render.android.expand.component.text;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/a;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "tp", "", "updateDrawState", "", "a", "Ljava/lang/String;", "fontVariant", "<init>", "(Ljava/lang/String;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String fontVariant;

    public a(@NotNull String fontVariant) {
        Intrinsics.checkNotNullParameter(fontVariant, "fontVariant");
        this.fontVariant = fontVariant;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint tp5) {
        Intrinsics.checkNotNullParameter(tp5, "tp");
        tp5.setFontFeatureSettings(this.fontVariant);
    }
}
