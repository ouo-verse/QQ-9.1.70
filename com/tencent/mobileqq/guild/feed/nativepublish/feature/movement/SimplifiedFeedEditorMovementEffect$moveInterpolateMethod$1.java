package com.tencent.mobileqq.guild.feed.nativepublish.feature.movement;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class SimplifiedFeedEditorMovementEffect$moveInterpolateMethod$1 extends FunctionReferenceImpl implements Function3<Integer, Integer, Integer, Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SimplifiedFeedEditorMovementEffect$moveInterpolateMethod$1(Object obj) {
        super(3, obj, SimplifiedFeedEditorMovementEffect.class, "bezierInterpolate", "bezierInterpolate(III)F", 0);
    }

    @NotNull
    public final Float invoke(int i3, int i16, int i17) {
        float e16;
        e16 = ((SimplifiedFeedEditorMovementEffect) this.receiver).e(i3, i16, i17);
        return Float.valueOf(e16);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Float invoke(Integer num, Integer num2, Integer num3) {
        return invoke(num.intValue(), num2.intValue(), num3.intValue());
    }
}
