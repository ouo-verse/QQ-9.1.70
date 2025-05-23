package o14;

import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfoType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lo14/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;", "type", "b", "I", "()I", "serialNumber", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "data", "Ljava/lang/String;", "()Ljava/lang/String;", "tabName", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfoType;ILcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: o14.h, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieHotAndFriendItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RobotRecommendCardInfoType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int serialNumber;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final RobotCoreInfo data;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabName;

    public AdelieHotAndFriendItemData() {
        this(null, 0, null, null, 15, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final RobotCoreInfo getData() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getSerialNumber() {
        return this.serialNumber;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTabName() {
        return this.tabName;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RobotRecommendCardInfoType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieHotAndFriendItemData)) {
            return false;
        }
        AdelieHotAndFriendItemData adelieHotAndFriendItemData = (AdelieHotAndFriendItemData) other;
        if (this.type == adelieHotAndFriendItemData.type && this.serialNumber == adelieHotAndFriendItemData.serialNumber && Intrinsics.areEqual(this.data, adelieHotAndFriendItemData.data) && Intrinsics.areEqual(this.tabName, adelieHotAndFriendItemData.tabName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.type.hashCode() * 31) + this.serialNumber) * 31;
        RobotCoreInfo robotCoreInfo = this.data;
        if (robotCoreInfo == null) {
            hashCode = 0;
        } else {
            hashCode = robotCoreInfo.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.tabName.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdelieHotAndFriendItemData(type=" + this.type + ", serialNumber=" + this.serialNumber + ", data=" + this.data + ", tabName=" + this.tabName + ")";
    }

    public AdelieHotAndFriendItemData(@NotNull RobotRecommendCardInfoType type, int i3, @Nullable RobotCoreInfo robotCoreInfo, @NotNull String tabName) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        this.type = type;
        this.serialNumber = i3;
        this.data = robotCoreInfo;
        this.tabName = tabName;
    }

    public /* synthetic */ AdelieHotAndFriendItemData(RobotRecommendCardInfoType robotRecommendCardInfoType, int i3, RobotCoreInfo robotCoreInfo, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? RobotRecommendCardInfoType.KWEEKHOT : robotRecommendCardInfoType, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? null : robotCoreInfo, (i16 & 8) != 0 ? "" : str);
    }
}
