package com.tencent.mobileqq.guild.widget;

import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/animation/Interpolator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class GuildSwipeBackLayout$Companion$sInterpolator$2 extends Lambda implements Function0<Interpolator> {
    public static final GuildSwipeBackLayout$Companion$sInterpolator$2 INSTANCE = new GuildSwipeBackLayout$Companion$sInterpolator$2();

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(float f16) {
        float f17 = f16 - 1.0f;
        return (f17 * f17 * f17 * f17 * f17) + 1.0f;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Interpolator invoke() {
        return new Interpolator() { // from class: com.tencent.mobileqq.guild.widget.s
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f16) {
                float b16;
                b16 = GuildSwipeBackLayout$Companion$sInterpolator$2.b(f16);
                return b16;
            }
        };
    }

    GuildSwipeBackLayout$Companion$sInterpolator$2() {
        super(0);
    }
}
