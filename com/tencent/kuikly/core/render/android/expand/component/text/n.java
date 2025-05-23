package com.tencent.kuikly.core.render.android.expand.component.text;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/n;", "Landroid/text/style/CharacterStyle;", "Landroid/text/TextPaint;", "textPaint", "", "updateDrawState", "", "a", UserInfo.SEX_FEMALE, "dx", "b", "dy", "c", "radius", "", "d", "I", "color", "<init>", "(FFFI)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class n extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float dx;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float dy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float radius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int color;

    public n(float f16, float f17, float f18, int i3) {
        this.dx = f16;
        this.dy = f17;
        this.radius = f18;
        this.color = i3;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setShadowLayer(this.radius, this.dx, this.dy, this.color);
    }
}
