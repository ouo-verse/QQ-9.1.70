package com.tencent.sqshow.zootopia.utils.ui;

import android.animation.TimeInterpolator;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ui/c;", "Landroid/animation/TimeInterpolator;", "", "input", "getInterpolation", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c implements TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        float f16 = input - 1.0f;
        return (f16 * f16 * ((f16 * 2.70158f) + 1.70158f)) + 1;
    }
}
