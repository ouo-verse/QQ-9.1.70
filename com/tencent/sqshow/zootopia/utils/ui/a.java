package com.tencent.sqshow.zootopia.utils.ui;

import android.animation.TimeInterpolator;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/ui/a;", "Landroid/animation/TimeInterpolator;", "", "input", "getInterpolation", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        return input * input * input;
    }
}
