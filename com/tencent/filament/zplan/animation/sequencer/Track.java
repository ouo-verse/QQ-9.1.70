package com.tencent.filament.zplan.animation.sequencer;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplan/animation/sequencer/Track;", "", "loop", "", "animations", "", "Lcom/tencent/filament/zplan/animation/sequencer/Animation;", "(ZLjava/util/List;)V", "getAnimations", "()Ljava/util/List;", "getLoop", "()Z", "getDuration", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class Track {

    @NotNull
    private final List<Animation> animations;
    private final boolean loop;

    public Track() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<Animation> getAnimations() {
        return this.animations;
    }

    public final double getDuration() {
        Iterator<T> it = this.animations.iterator();
        double d16 = 0.0d;
        while (it.hasNext()) {
            d16 += ((Animation) it.next()).getDuration();
        }
        return d16;
    }

    public final boolean getLoop() {
        return this.loop;
    }

    public Track(boolean z16, @NotNull List<Animation> animations) {
        Intrinsics.checkNotNullParameter(animations, "animations");
        this.loop = z16;
        this.animations = animations;
    }

    public /* synthetic */ Track(boolean z16, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? new ArrayList() : list);
    }
}
