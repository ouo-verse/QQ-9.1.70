package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.tencent.ark.ark;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB%\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;", "", "", "toJson", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "component1", "component2", "component3", "hostAnim", "guestAnim", "extraAnimGltf", "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "getHostAnim", "()Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;", "getGuestAnim", "Ljava/lang/String;", "getExtraAnimGltf", "()Ljava/lang/String;", "<init>", "(Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;Lcom/tencent/filament/zplan/scene/square/SquareAvatarData$AvatarAnim;Ljava/lang/String;)V", "Companion", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class SquareInteractionEventData {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final String extraAnimGltf;

    @Nullable
    private final SquareAvatarData.AvatarAnim guestAnim;

    @Nullable
    private final SquareAvatarData.AvatarAnim hostAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData$a;", "", "", ark.ARKMETADATA_JSON, "Lcom/tencent/filament/zplan/scene/square/SquareInteractionEventData;", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.scene.square.SquareInteractionEventData$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final SquareInteractionEventData a(@NotNull String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                return (SquareInteractionEventData) new Gson().fromJson(json, SquareInteractionEventData.class);
            } catch (Exception e16) {
                FLog.INSTANCE.e("SquareInteractionEventData", "fromJson error: " + e16);
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SquareInteractionEventData(@Nullable SquareAvatarData.AvatarAnim avatarAnim, @Nullable SquareAvatarData.AvatarAnim avatarAnim2, @Nullable String str) {
        this.hostAnim = avatarAnim;
        this.guestAnim = avatarAnim2;
        this.extraAnimGltf = str;
    }

    public static /* synthetic */ SquareInteractionEventData copy$default(SquareInteractionEventData squareInteractionEventData, SquareAvatarData.AvatarAnim avatarAnim, SquareAvatarData.AvatarAnim avatarAnim2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            avatarAnim = squareInteractionEventData.hostAnim;
        }
        if ((i3 & 2) != 0) {
            avatarAnim2 = squareInteractionEventData.guestAnim;
        }
        if ((i3 & 4) != 0) {
            str = squareInteractionEventData.extraAnimGltf;
        }
        return squareInteractionEventData.copy(avatarAnim, avatarAnim2, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final SquareAvatarData.AvatarAnim getHostAnim() {
        return this.hostAnim;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final SquareAvatarData.AvatarAnim getGuestAnim() {
        return this.guestAnim;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getExtraAnimGltf() {
        return this.extraAnimGltf;
    }

    @NotNull
    public final SquareInteractionEventData copy(@Nullable SquareAvatarData.AvatarAnim hostAnim, @Nullable SquareAvatarData.AvatarAnim guestAnim, @Nullable String extraAnimGltf) {
        return new SquareInteractionEventData(hostAnim, guestAnim, extraAnimGltf);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareInteractionEventData) {
                SquareInteractionEventData squareInteractionEventData = (SquareInteractionEventData) other;
                if (!Intrinsics.areEqual(this.hostAnim, squareInteractionEventData.hostAnim) || !Intrinsics.areEqual(this.guestAnim, squareInteractionEventData.guestAnim) || !Intrinsics.areEqual(this.extraAnimGltf, squareInteractionEventData.extraAnimGltf)) {
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

    public int hashCode() {
        int i3;
        int i16;
        SquareAvatarData.AvatarAnim avatarAnim = this.hostAnim;
        int i17 = 0;
        if (avatarAnim != null) {
            i3 = avatarAnim.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        SquareAvatarData.AvatarAnim avatarAnim2 = this.guestAnim;
        if (avatarAnim2 != null) {
            i16 = avatarAnim2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str = this.extraAnimGltf;
        if (str != null) {
            i17 = str.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public final String toJson() {
        try {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        } catch (Exception e16) {
            FLog.INSTANCE.e("SquareInteractionEventData", "toJson error: " + e16);
            return "";
        }
    }

    @NotNull
    public String toString() {
        return "SquareInteractionEventData(hostAnim=" + this.hostAnim + ", guestAnim=" + this.guestAnim + ", extraAnimGltf=" + this.extraAnimGltf + ")";
    }
}
