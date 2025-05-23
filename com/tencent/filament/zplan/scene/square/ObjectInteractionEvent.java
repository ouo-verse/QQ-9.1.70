package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J7\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/filament/zplan/scene/square/ObjectInteractionEvent;", "Lcom/tencent/filament/zplan/scene/square/SquareMapEvent;", "", "component1", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "component2", "component3", "component4", "id", "hostAnim", "guestAnim", "extraAnimGltf", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "getHostAnim", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "getGuestAnim", "getExtraAnimGltf", "<init>", "(Ljava/lang/String;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;Ljava/lang/String;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ObjectInteractionEvent extends SquareMapEvent {

    @NotNull
    public static final String NAME = "SquareMapScene.EVENT_ON_OBJECT_INTERACTION";

    @Nullable
    private final String extraAnimGltf;

    @Nullable
    private final SquareAvatarData.AvatarAnim guestAnim;

    @Nullable
    private final SquareAvatarData.AvatarAnim hostAnim;

    @NotNull
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectInteractionEvent(@NotNull String id5, @Nullable SquareAvatarData.AvatarAnim avatarAnim, @Nullable SquareAvatarData.AvatarAnim avatarAnim2, @Nullable String str) {
        super(NAME);
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.hostAnim = avatarAnim;
        this.guestAnim = avatarAnim2;
        this.extraAnimGltf = str;
    }

    public static /* synthetic */ ObjectInteractionEvent copy$default(ObjectInteractionEvent objectInteractionEvent, String str, SquareAvatarData.AvatarAnim avatarAnim, SquareAvatarData.AvatarAnim avatarAnim2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = objectInteractionEvent.id;
        }
        if ((i3 & 2) != 0) {
            avatarAnim = objectInteractionEvent.hostAnim;
        }
        if ((i3 & 4) != 0) {
            avatarAnim2 = objectInteractionEvent.guestAnim;
        }
        if ((i3 & 8) != 0) {
            str2 = objectInteractionEvent.extraAnimGltf;
        }
        return objectInteractionEvent.copy(str, avatarAnim, avatarAnim2, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final SquareAvatarData.AvatarAnim getHostAnim() {
        return this.hostAnim;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final SquareAvatarData.AvatarAnim getGuestAnim() {
        return this.guestAnim;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getExtraAnimGltf() {
        return this.extraAnimGltf;
    }

    @NotNull
    public final ObjectInteractionEvent copy(@NotNull String id5, @Nullable SquareAvatarData.AvatarAnim hostAnim, @Nullable SquareAvatarData.AvatarAnim guestAnim, @Nullable String extraAnimGltf) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new ObjectInteractionEvent(id5, hostAnim, guestAnim, extraAnimGltf);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ObjectInteractionEvent) {
                ObjectInteractionEvent objectInteractionEvent = (ObjectInteractionEvent) other;
                if (!Intrinsics.areEqual(this.id, objectInteractionEvent.id) || !Intrinsics.areEqual(this.hostAnim, objectInteractionEvent.hostAnim) || !Intrinsics.areEqual(this.guestAnim, objectInteractionEvent.guestAnim) || !Intrinsics.areEqual(this.extraAnimGltf, objectInteractionEvent.extraAnimGltf)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getExtraAnimGltf() {
        return this.extraAnimGltf;
    }

    @Nullable
    public final SquareAvatarData.AvatarAnim getGuestAnim() {
        return this.guestAnim;
    }

    @Nullable
    public final SquareAvatarData.AvatarAnim getHostAnim() {
        return this.hostAnim;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.id;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        SquareAvatarData.AvatarAnim avatarAnim = this.hostAnim;
        if (avatarAnim != null) {
            i16 = avatarAnim.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        SquareAvatarData.AvatarAnim avatarAnim2 = this.guestAnim;
        if (avatarAnim2 != null) {
            i17 = avatarAnim2.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str2 = this.extraAnimGltf;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "ObjectInteractionEvent(id=" + this.id + ", hostAnim=" + this.hostAnim + ", guestAnim=" + this.guestAnim + ", extraAnimGltf=" + this.extraAnimGltf + ")";
    }
}
