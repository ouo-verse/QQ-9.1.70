package j61;

import com.tencent.mobileqq.data.IntimateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lj61/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/data/IntimateInfo;", "a", "Lcom/tencent/mobileqq/data/IntimateInfo;", "c", "()Lcom/tencent/mobileqq/data/IntimateInfo;", "setIntimateInfo", "(Lcom/tencent/mobileqq/data/IntimateInfo;)V", "intimateInfo", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "friendUin", "I", "()I", "setFriendIntimateType", "(I)V", "friendIntimateType", "<init>", "(Lcom/tencent/mobileqq/data/IntimateInfo;Ljava/lang/String;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: j61.a, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class IntimateBaseModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private IntimateInfo intimateInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String friendUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int friendIntimateType;

    public IntimateBaseModel(@NotNull IntimateInfo intimateInfo, @NotNull String friendUin, int i3) {
        Intrinsics.checkNotNullParameter(intimateInfo, "intimateInfo");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        this.intimateInfo = intimateInfo;
        this.friendUin = friendUin;
        this.friendIntimateType = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getFriendIntimateType() {
        return this.friendIntimateType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getFriendUin() {
        return this.friendUin;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final IntimateInfo getIntimateInfo() {
        return this.intimateInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateBaseModel)) {
            return false;
        }
        IntimateBaseModel intimateBaseModel = (IntimateBaseModel) other;
        if (Intrinsics.areEqual(this.intimateInfo, intimateBaseModel.intimateInfo) && Intrinsics.areEqual(this.friendUin, intimateBaseModel.friendUin) && this.friendIntimateType == intimateBaseModel.friendIntimateType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.intimateInfo.hashCode() * 31) + this.friendUin.hashCode()) * 31) + this.friendIntimateType;
    }

    @NotNull
    public String toString() {
        return "IntimateBaseModel(intimateInfo=" + this.intimateInfo + ", friendUin=" + this.friendUin + ", friendIntimateType=" + this.friendIntimateType + ")";
    }
}
