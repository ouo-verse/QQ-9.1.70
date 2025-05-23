package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "enable", "Z", "a", "()Z", "forceBodyTypeBoy", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "forceBodyTypeGirl", "c", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.q, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanCoupleAvatarBodyTypeConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("forceBodyTypeBoy")
    private final String forceBodyTypeBoy;

    @SerializedName("forceBodyTypeGirl")
    private final String forceBodyTypeGirl;

    public ZPlanCoupleAvatarBodyTypeConfig() {
        this(false, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: b, reason: from getter */
    public final String getForceBodyTypeBoy() {
        return this.forceBodyTypeBoy;
    }

    /* renamed from: c, reason: from getter */
    public final String getForceBodyTypeGirl() {
        return this.forceBodyTypeGirl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.forceBodyTypeBoy.hashCode()) * 31) + this.forceBodyTypeGirl.hashCode();
    }

    public String toString() {
        return "ZPlanCoupleAvatarBodyTypeConfig(enable=" + this.enable + ", forceBodyTypeBoy=" + this.forceBodyTypeBoy + ", forceBodyTypeGirl=" + this.forceBodyTypeGirl + ')';
    }

    public ZPlanCoupleAvatarBodyTypeConfig(boolean z16, String forceBodyTypeBoy, String forceBodyTypeGirl) {
        Intrinsics.checkNotNullParameter(forceBodyTypeBoy, "forceBodyTypeBoy");
        Intrinsics.checkNotNullParameter(forceBodyTypeGirl, "forceBodyTypeGirl");
        this.enable = z16;
        this.forceBodyTypeBoy = forceBodyTypeBoy;
        this.forceBodyTypeGirl = forceBodyTypeGirl;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanCoupleAvatarBodyTypeConfig)) {
            return false;
        }
        ZPlanCoupleAvatarBodyTypeConfig zPlanCoupleAvatarBodyTypeConfig = (ZPlanCoupleAvatarBodyTypeConfig) other;
        return this.enable == zPlanCoupleAvatarBodyTypeConfig.enable && Intrinsics.areEqual(this.forceBodyTypeBoy, zPlanCoupleAvatarBodyTypeConfig.forceBodyTypeBoy) && Intrinsics.areEqual(this.forceBodyTypeGirl, zPlanCoupleAvatarBodyTypeConfig.forceBodyTypeGirl);
    }

    public /* synthetic */ ZPlanCoupleAvatarBodyTypeConfig(boolean z16, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? "CMShow/Assets/Character/AvatarV2/BodyType/BoyStretchConfig" : str, (i3 & 4) != 0 ? "CMShow/Assets/Character/AvatarV2/BodyType/GirlStretchConfig" : str2);
    }
}
