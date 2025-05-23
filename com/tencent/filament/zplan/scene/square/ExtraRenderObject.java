package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u001b\u0010\u0013\u001a\u00060\u0002j\u0002`\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b\u0019\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/c;", "Lcom/tencent/filament/zplan/scene/square/f;", "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "a", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "d", "()J", "objectId", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "getAnim", "()Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "anim", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "c", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "getTransform", "()Lcom/tencent/filament/zplan/scene/couple/config/d;", "transform", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;", WadlProxyConsts.EXTRA_DATA, "<init>", "(JLcom/tencent/filament/zplan/animation/FilamentAnimation;Lcom/tencent/filament/zplan/scene/couple/config/d;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$ExtraActorData;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.square.c, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class ExtraRenderObject implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long objectId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FilamentAnimation anim;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.filament.zplan.scene.couple.config.d transform;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SquareAvatarData.ExtraActorData extraData;

    public ExtraRenderObject(long j3, @Nullable FilamentAnimation filamentAnimation, @NotNull com.tencent.filament.zplan.scene.couple.config.d transform, @Nullable SquareAvatarData.ExtraActorData extraActorData) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.objectId = j3;
        this.anim = filamentAnimation;
        this.transform = transform;
        this.extraData = extraActorData;
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
    public final SquareAvatarData.ExtraActorData getExtraData() {
        return this.extraData;
    }

    public final long d() {
        return this.objectId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ExtraRenderObject) {
                ExtraRenderObject extraRenderObject = (ExtraRenderObject) other;
                if (this.objectId != extraRenderObject.objectId || !Intrinsics.areEqual(this.anim, extraRenderObject.anim) || !Intrinsics.areEqual(this.transform, extraRenderObject.transform) || !Intrinsics.areEqual(this.extraData, extraRenderObject.extraData)) {
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
        int i16;
        long j3 = this.objectId;
        int i17 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        FilamentAnimation filamentAnimation = this.anim;
        int i18 = 0;
        if (filamentAnimation != null) {
            i3 = filamentAnimation.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        com.tencent.filament.zplan.scene.couple.config.d dVar = this.transform;
        if (dVar != null) {
            i16 = dVar.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        SquareAvatarData.ExtraActorData extraActorData = this.extraData;
        if (extraActorData != null) {
            i18 = extraActorData.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "ExtraRenderObject(objectId=" + this.objectId + ", anim=" + this.anim + ", transform=" + this.transform + ", extraData=" + this.extraData + ")";
    }
}
