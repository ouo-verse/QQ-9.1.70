package com.tencent.mobileqq.guild.base.extension;

import kotlin.Metadata;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0004\u00a8\u0006\u0004"}, d2 = {"", "to", "Lkotlin/ranges/IntProgression;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class p {
    @NotNull
    public static final IntProgression a(int i3, int i16) {
        boolean z16;
        IntProgression downTo;
        if (i3 < i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            downTo = RangesKt___RangesKt.downTo(i3, i16);
            return downTo;
        }
        return new IntRange(i3, i16);
    }
}
