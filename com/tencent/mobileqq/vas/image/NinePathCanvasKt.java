package com.tencent.mobileqq.vas.image;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Triple;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\t"}, d2 = {"calculateScale", "Lkotlin/Triple;", "", "", "width", "", "height", "canvasRect", "Landroid/graphics/Rect;", "vas_kit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class NinePathCanvasKt {
    private static final Triple<Boolean, Boolean, Float> calculateScale(int i3, int i16, Rect rect) {
        boolean z16;
        boolean z17 = true;
        if (rect.width() < i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (rect.height() >= i16) {
            z17 = false;
        }
        if (!z16 && !z17) {
            Boolean bool = Boolean.FALSE;
            return new Triple<>(bool, bool, Float.valueOf(1.0f));
        }
        return new Triple<>(Boolean.valueOf(z16), Boolean.valueOf(z17), Float.valueOf(Math.max(i16 / rect.height(), i3 / rect.width())));
    }
}
