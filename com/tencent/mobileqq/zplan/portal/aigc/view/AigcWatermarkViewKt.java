package com.tencent.mobileqq.zplan.portal.aigc.view;

import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\"\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a8\u0006\u000b"}, d2 = {"", "radius", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "c", "px", "py", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "d", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AigcWatermarkViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence<Pair<Integer, Integer>> c(int i3) {
        Sequence<Pair<Integer, Integer>> sequence;
        sequence = SequencesKt__SequenceBuilderKt.sequence(new AigcWatermarkViewKt$circleCoordination$1(i3, null));
        return sequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(int i3, int i16, DisplayMetrics displayMetrics) {
        return i3 < displayMetrics.widthPixels && i3 >= 0 && i16 < displayMetrics.heightPixels && i16 >= 0;
    }
}
