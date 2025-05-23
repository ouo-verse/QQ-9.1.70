package com.tencent.mobileqq.icgame.room.likeowner;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/likeowner/d;", "Lg32/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/MotionEvent;", "c", "Landroid/view/MotionEvent;", "()Landroid/view/MotionEvent;", "motionEvent", "<init>", "(Landroid/view/MotionEvent;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.room.likeowner.d, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class TouchEvent extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MotionEvent motionEvent;

    public TouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        this.motionEvent = motionEvent;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TouchEvent) && Intrinsics.areEqual(this.motionEvent, ((TouchEvent) other).motionEvent)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.motionEvent.hashCode();
    }

    @NotNull
    public String toString() {
        return "TouchEvent(motionEvent=" + this.motionEvent + ")";
    }
}
