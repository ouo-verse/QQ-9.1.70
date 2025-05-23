package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.ttpic.openapi.filter.LightConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/al;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/utils/featureswitch/model/am;", LightConstants.MALE, "Lcom/tencent/sqshow/utils/featureswitch/model/am;", "b", "()Lcom/tencent/sqshow/utils/featureswitch/model/am;", LightConstants.FEMALE, "a", "<init>", "(Lcom/tencent/sqshow/utils/featureswitch/model/am;Lcom/tencent/sqshow/utils/featureswitch/model/am;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.al, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanTofuAvatarConfig {

    @SerializedName(LightConstants.FEMALE)
    private final ZPlanTofuPathConfig female;

    @SerializedName(LightConstants.MALE)
    private final ZPlanTofuPathConfig male;

    public ZPlanTofuAvatarConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final ZPlanTofuPathConfig getFemale() {
        return this.female;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanTofuPathConfig getMale() {
        return this.male;
    }

    public int hashCode() {
        return (this.male.hashCode() * 31) + this.female.hashCode();
    }

    public String toString() {
        return "ZPlanTofuAvatarConfig(male=" + this.male + ", female=" + this.female + ')';
    }

    public ZPlanTofuAvatarConfig(ZPlanTofuPathConfig male, ZPlanTofuPathConfig female) {
        Intrinsics.checkNotNullParameter(male, "male");
        Intrinsics.checkNotNullParameter(female, "female");
        this.male = male;
        this.female = female;
    }

    public /* synthetic */ ZPlanTofuAvatarConfig(ZPlanTofuPathConfig zPlanTofuPathConfig, ZPlanTofuPathConfig zPlanTofuPathConfig2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ZPlanTofuPathConfig("CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/HeadAnimation/A_CH_M_H_BaseWear_Emote_Anim_Montage", "CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Male/BodyAnimation/A_CH_M_H_BaseWear_Montage") : zPlanTofuPathConfig, (i3 & 2) != 0 ? new ZPlanTofuPathConfig("CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/HeadAnimation/A_CH_F_H_SportsWear_01_Emote_Montage", "CMShow/Assets/AnimationUnpak/Character/Player/Montage/A_Female/BodyAnimation/A_CH_F_H_SportsWear_01_Montage") : zPlanTofuPathConfig2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanTofuAvatarConfig)) {
            return false;
        }
        ZPlanTofuAvatarConfig zPlanTofuAvatarConfig = (ZPlanTofuAvatarConfig) other;
        return Intrinsics.areEqual(this.male, zPlanTofuAvatarConfig.male) && Intrinsics.areEqual(this.female, zPlanTofuAvatarConfig.female);
    }
}
