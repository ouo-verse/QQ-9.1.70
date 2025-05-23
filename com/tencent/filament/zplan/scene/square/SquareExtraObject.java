package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u001b\u0010\u0013\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/j;", "Lcom/tencent/filament/zplan/scene/square/f;", "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "a", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "d", "()J", "objectId", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "c", "()Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "anim", "<init>", "(JLcom/tencent/filament/zplan/animation/FilamentAnimation;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.square.j, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class SquareExtraObject implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long objectId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FilamentAnimation anim;

    public SquareExtraObject(long j3, @Nullable FilamentAnimation filamentAnimation) {
        this.objectId = j3;
        this.anim = filamentAnimation;
    }

    @Override // com.tencent.filament.zplan.scene.square.f
    /* renamed from: a, reason: from getter */
    public long getObjectId() {
        return this.objectId;
    }

    @Override // com.tencent.filament.zplan.scene.square.f
    @NotNull
    public List<FilamentAnimation> b() {
        List<FilamentAnimation> listOfNotNull;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(this.anim);
        return listOfNotNull;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final FilamentAnimation getAnim() {
        return this.anim;
    }

    public final long d() {
        return this.objectId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareExtraObject) {
                SquareExtraObject squareExtraObject = (SquareExtraObject) other;
                if (this.objectId != squareExtraObject.objectId || !Intrinsics.areEqual(this.anim, squareExtraObject.anim)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        long j3 = this.objectId;
        int i16 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        FilamentAnimation filamentAnimation = this.anim;
        if (filamentAnimation != null) {
            i3 = filamentAnimation.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "SquareExtraObject(objectId=" + this.objectId + ", anim=" + this.anim + ")";
    }
}
