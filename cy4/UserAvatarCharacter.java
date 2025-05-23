package cy4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcy4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "Lgx4/a;", "b", "Lgx4/a;", "()Lgx4/a;", "avatarInfo", "dressKey", "<init>", "(Ljava/lang/String;Lgx4/a;Ljava/lang/String;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: cy4.a, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class UserAvatarCharacter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final gx4.a avatarInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dressKey;

    public UserAvatarCharacter(@NotNull String uin, @NotNull gx4.a avatarInfo, @NotNull String dressKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.uin = uin;
        this.avatarInfo = avatarInfo;
        this.dressKey = dressKey;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final gx4.a getAvatarInfo() {
        return this.avatarInfo;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof UserAvatarCharacter) {
                UserAvatarCharacter userAvatarCharacter = (UserAvatarCharacter) other;
                if (!Intrinsics.areEqual(this.uin, userAvatarCharacter.uin) || !Intrinsics.areEqual(this.avatarInfo, userAvatarCharacter.avatarInfo) || !Intrinsics.areEqual(this.dressKey, userAvatarCharacter.dressKey)) {
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
        String str = this.uin;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        gx4.a aVar = this.avatarInfo;
        if (aVar != null) {
            i16 = aVar.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str2 = this.dressKey;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "UserAvatarCharacter(uin=" + this.uin + ", avatarInfo=" + this.avatarInfo + ", dressKey=" + this.dressKey + ")";
    }
}
