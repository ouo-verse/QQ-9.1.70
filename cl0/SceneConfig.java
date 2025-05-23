package cl0;

import com.google.gson.annotations.SerializedName;
import com.tencent.hippy.qq.api.TabPreloadItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u001a\u0010\u001c\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001a\u0010\u001e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\u00a8\u0006\""}, d2 = {"Lcl0/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcl0/i;", "none", "Lcl0/i;", tl.h.F, "()Lcl0/i;", "portal", "i", "drawer", "b", TabPreloadItem.TAB_NAME_DYNAMIC, "c", "profile_card", "j", "aigc_preview", "a", "friend_profile_card", "d", "friends_dress_up", "e", "my_name_by", "g", "guest_name_by", "f", "<init>", "(Lcl0/i;Lcl0/i;Lcl0/i;Lcl0/i;Lcl0/i;Lcl0/i;Lcl0/i;Lcl0/i;Lcl0/i;Lcl0/i;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: cl0.k, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class SceneConfig {

    @SerializedName("aigc_preview")
    @NotNull
    private final GpuOptimizeOptions aigc_preview;

    @SerializedName("drawer")
    @NotNull
    private final GpuOptimizeOptions drawer;

    @SerializedName(TabPreloadItem.TAB_NAME_DYNAMIC)
    @NotNull
    private final GpuOptimizeOptions dynamic;

    @SerializedName("friend_profile_card")
    @NotNull
    private final GpuOptimizeOptions friend_profile_card;

    @SerializedName("friends_dress_up")
    @NotNull
    private final GpuOptimizeOptions friends_dress_up;

    @SerializedName("guest_name_by")
    @NotNull
    private final GpuOptimizeOptions guest_name_by;

    @SerializedName("my_name_by")
    @NotNull
    private final GpuOptimizeOptions my_name_by;

    @SerializedName("none")
    @NotNull
    private final GpuOptimizeOptions none;

    @SerializedName("portal")
    @NotNull
    private final GpuOptimizeOptions portal;

    @SerializedName("profile_card")
    @NotNull
    private final GpuOptimizeOptions profile_card;

    public SceneConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GpuOptimizeOptions getAigc_preview() {
        return this.aigc_preview;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GpuOptimizeOptions getDrawer() {
        return this.drawer;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GpuOptimizeOptions getDynamic() {
        return this.dynamic;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final GpuOptimizeOptions getFriend_profile_card() {
        return this.friend_profile_card;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GpuOptimizeOptions getFriends_dress_up() {
        return this.friends_dress_up;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SceneConfig) {
                SceneConfig sceneConfig = (SceneConfig) other;
                if (!Intrinsics.areEqual(this.none, sceneConfig.none) || !Intrinsics.areEqual(this.portal, sceneConfig.portal) || !Intrinsics.areEqual(this.drawer, sceneConfig.drawer) || !Intrinsics.areEqual(this.dynamic, sceneConfig.dynamic) || !Intrinsics.areEqual(this.profile_card, sceneConfig.profile_card) || !Intrinsics.areEqual(this.aigc_preview, sceneConfig.aigc_preview) || !Intrinsics.areEqual(this.friend_profile_card, sceneConfig.friend_profile_card) || !Intrinsics.areEqual(this.friends_dress_up, sceneConfig.friends_dress_up) || !Intrinsics.areEqual(this.my_name_by, sceneConfig.my_name_by) || !Intrinsics.areEqual(this.guest_name_by, sceneConfig.guest_name_by)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final GpuOptimizeOptions getGuest_name_by() {
        return this.guest_name_by;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final GpuOptimizeOptions getMy_name_by() {
        return this.my_name_by;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final GpuOptimizeOptions getNone() {
        return this.none;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        GpuOptimizeOptions gpuOptimizeOptions = this.none;
        int i36 = 0;
        if (gpuOptimizeOptions != null) {
            i3 = gpuOptimizeOptions.hashCode();
        } else {
            i3 = 0;
        }
        int i37 = i3 * 31;
        GpuOptimizeOptions gpuOptimizeOptions2 = this.portal;
        if (gpuOptimizeOptions2 != null) {
            i16 = gpuOptimizeOptions2.hashCode();
        } else {
            i16 = 0;
        }
        int i38 = (i37 + i16) * 31;
        GpuOptimizeOptions gpuOptimizeOptions3 = this.drawer;
        if (gpuOptimizeOptions3 != null) {
            i17 = gpuOptimizeOptions3.hashCode();
        } else {
            i17 = 0;
        }
        int i39 = (i38 + i17) * 31;
        GpuOptimizeOptions gpuOptimizeOptions4 = this.dynamic;
        if (gpuOptimizeOptions4 != null) {
            i18 = gpuOptimizeOptions4.hashCode();
        } else {
            i18 = 0;
        }
        int i46 = (i39 + i18) * 31;
        GpuOptimizeOptions gpuOptimizeOptions5 = this.profile_card;
        if (gpuOptimizeOptions5 != null) {
            i19 = gpuOptimizeOptions5.hashCode();
        } else {
            i19 = 0;
        }
        int i47 = (i46 + i19) * 31;
        GpuOptimizeOptions gpuOptimizeOptions6 = this.aigc_preview;
        if (gpuOptimizeOptions6 != null) {
            i26 = gpuOptimizeOptions6.hashCode();
        } else {
            i26 = 0;
        }
        int i48 = (i47 + i26) * 31;
        GpuOptimizeOptions gpuOptimizeOptions7 = this.friend_profile_card;
        if (gpuOptimizeOptions7 != null) {
            i27 = gpuOptimizeOptions7.hashCode();
        } else {
            i27 = 0;
        }
        int i49 = (i48 + i27) * 31;
        GpuOptimizeOptions gpuOptimizeOptions8 = this.friends_dress_up;
        if (gpuOptimizeOptions8 != null) {
            i28 = gpuOptimizeOptions8.hashCode();
        } else {
            i28 = 0;
        }
        int i56 = (i49 + i28) * 31;
        GpuOptimizeOptions gpuOptimizeOptions9 = this.my_name_by;
        if (gpuOptimizeOptions9 != null) {
            i29 = gpuOptimizeOptions9.hashCode();
        } else {
            i29 = 0;
        }
        int i57 = (i56 + i29) * 31;
        GpuOptimizeOptions gpuOptimizeOptions10 = this.guest_name_by;
        if (gpuOptimizeOptions10 != null) {
            i36 = gpuOptimizeOptions10.hashCode();
        }
        return i57 + i36;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GpuOptimizeOptions getPortal() {
        return this.portal;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final GpuOptimizeOptions getProfile_card() {
        return this.profile_card;
    }

    @NotNull
    public String toString() {
        return "SceneConfig(none=" + this.none + ", portal=" + this.portal + ", drawer=" + this.drawer + ", dynamic=" + this.dynamic + ", profile_card=" + this.profile_card + ", aigc_preview=" + this.aigc_preview + ", friend_profile_card=" + this.friend_profile_card + ", friends_dress_up=" + this.friends_dress_up + ", my_name_by=" + this.my_name_by + ", guest_name_by=" + this.guest_name_by + ")";
    }

    public SceneConfig(@NotNull GpuOptimizeOptions none, @NotNull GpuOptimizeOptions portal, @NotNull GpuOptimizeOptions drawer, @NotNull GpuOptimizeOptions dynamic, @NotNull GpuOptimizeOptions profile_card, @NotNull GpuOptimizeOptions aigc_preview, @NotNull GpuOptimizeOptions friend_profile_card, @NotNull GpuOptimizeOptions friends_dress_up, @NotNull GpuOptimizeOptions my_name_by, @NotNull GpuOptimizeOptions guest_name_by) {
        Intrinsics.checkNotNullParameter(none, "none");
        Intrinsics.checkNotNullParameter(portal, "portal");
        Intrinsics.checkNotNullParameter(drawer, "drawer");
        Intrinsics.checkNotNullParameter(dynamic, "dynamic");
        Intrinsics.checkNotNullParameter(profile_card, "profile_card");
        Intrinsics.checkNotNullParameter(aigc_preview, "aigc_preview");
        Intrinsics.checkNotNullParameter(friend_profile_card, "friend_profile_card");
        Intrinsics.checkNotNullParameter(friends_dress_up, "friends_dress_up");
        Intrinsics.checkNotNullParameter(my_name_by, "my_name_by");
        Intrinsics.checkNotNullParameter(guest_name_by, "guest_name_by");
        this.none = none;
        this.portal = portal;
        this.drawer = drawer;
        this.dynamic = dynamic;
        this.profile_card = profile_card;
        this.aigc_preview = aigc_preview;
        this.friend_profile_card = friend_profile_card;
        this.friends_dress_up = friends_dress_up;
        this.my_name_by = my_name_by;
        this.guest_name_by = guest_name_by;
    }

    public /* synthetic */ SceneConfig(GpuOptimizeOptions gpuOptimizeOptions, GpuOptimizeOptions gpuOptimizeOptions2, GpuOptimizeOptions gpuOptimizeOptions3, GpuOptimizeOptions gpuOptimizeOptions4, GpuOptimizeOptions gpuOptimizeOptions5, GpuOptimizeOptions gpuOptimizeOptions6, GpuOptimizeOptions gpuOptimizeOptions7, GpuOptimizeOptions gpuOptimizeOptions8, GpuOptimizeOptions gpuOptimizeOptions9, GpuOptimizeOptions gpuOptimizeOptions10, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions, (i3 & 2) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions2, (i3 & 4) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions3, (i3 & 8) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions4, (i3 & 16) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions5, (i3 & 32) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions6, (i3 & 64) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions7, (i3 & 128) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions8, (i3 & 256) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions9, (i3 & 512) != 0 ? new GpuOptimizeOptions(false, false, false, 0.0f, 15, null) : gpuOptimizeOptions10);
    }
}
