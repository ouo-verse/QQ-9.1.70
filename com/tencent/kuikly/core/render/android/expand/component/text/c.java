package com.tencent.kuikly.core.render.android.expand.component.text;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/c;", "Landroid/text/style/LineHeightSpan;", "", "text", "", "start", "end", "spanstartv", NodeProps.LINE_HEIGHT, "Landroid/graphics/Paint$FontMetricsInt;", "fm", "", "chooseHeight", "d", "I", "height", "<init>", "(I)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c implements LineHeightSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int height;

    public c(int i3) {
        this.height = i3;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(@Nullable CharSequence text, int start, int end, int spanstartv, int lineHeight, @NotNull Paint.FontMetricsInt fm5) {
        Intrinsics.checkNotNullParameter(fm5, "fm");
        int i3 = this.height;
        double d16 = (i3 - ((-r4) + fm5.bottom)) / 2.0f;
        fm5.top = fm5.top - ((int) Math.ceil(d16));
        int floor = fm5.bottom + ((int) Math.floor(d16));
        fm5.bottom = floor;
        fm5.ascent = fm5.top;
        fm5.descent = floor;
    }
}
