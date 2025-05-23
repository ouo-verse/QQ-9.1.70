package dt0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Ldt0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tinyId", "nickName", "c", "Z", "()Z", "isGuest", "d", "isRobot", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "aio-guild-media-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dt0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class MediaUserEnterTipsModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isGuest;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRobot;

    public MediaUserEnterTipsModel(@NotNull String tinyId, @NotNull String nickName, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        this.tinyId = tinyId;
        this.nickName = nickName;
        this.isGuest = z16;
        this.isRobot = z17;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsGuest() {
        return this.isGuest;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRobot() {
        return this.isRobot;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaUserEnterTipsModel)) {
            return false;
        }
        MediaUserEnterTipsModel mediaUserEnterTipsModel = (MediaUserEnterTipsModel) other;
        if (Intrinsics.areEqual(this.tinyId, mediaUserEnterTipsModel.tinyId) && Intrinsics.areEqual(this.nickName, mediaUserEnterTipsModel.nickName) && this.isGuest == mediaUserEnterTipsModel.isGuest && this.isRobot == mediaUserEnterTipsModel.isRobot) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.tinyId.hashCode() * 31) + this.nickName.hashCode()) * 31;
        boolean z16 = this.isGuest;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.isRobot;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "MediaUserEnterTipsModel(tinyId=" + this.tinyId + ", nickName=" + this.nickName + ", isGuest=" + this.isGuest + ", isRobot=" + this.isRobot + ")";
    }

    public /* synthetic */ MediaUserEnterTipsModel(String str, String str2, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z16, (i3 & 8) != 0 ? false : z17);
    }
}
