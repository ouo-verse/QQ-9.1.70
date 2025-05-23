package com.tencent.kuikly.core.render.android.expand.component.text;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/h;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/TextPaint;", "tp", "", "a", "updateDrawState", "textPaint", "updateMeasureState", "", "d", UserInfo.SEX_FEMALE, NodeProps.LETTER_SPACING, "<init>", "(F)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h extends MetricAffectingSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float letterSpacing;

    public h(float f16) {
        this.letterSpacing = f16;
    }

    private final void a(TextPaint tp5) {
        float f16 = this.letterSpacing;
        if (f16 != 0.0f) {
            tp5.setLetterSpacing(f16);
        }
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint tp5) {
        Intrinsics.checkNotNullParameter(tp5, "tp");
        a(tp5);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        a(textPaint);
    }
}
