package com.tencent.filament.zplan.util;

import com.tencent.filament.zplan.animation.sequencer.Animation;
import com.tencent.filament.zplan.animation.sequencer.Track;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/filament/zplan/animation/sequencer/Track;", "", "a", "zplan-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class d {
    public static final void a(@NotNull Track toNoCrossFade) {
        Intrinsics.checkNotNullParameter(toNoCrossFade, "$this$toNoCrossFade");
        int size = toNoCrossFade.getAnimations().size();
        double d16 = 0.0d;
        for (int i3 = 0; i3 < size; i3++) {
            Animation animation = toNoCrossFade.getAnimations().get(i3);
            animation.setBeginTime(d16);
            d16 += animation.getDuration();
        }
    }
}
