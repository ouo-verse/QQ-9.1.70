package d24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Ld24/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "msg_id", "Ljava/lang/String;", "getMsg_id", "()Ljava/lang/String;", "setMsg_id", "(Ljava/lang/String;)V", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.d, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieAvatarMediaExtra {

    @SerializedName("msg_id")
    @NotNull
    private String msg_id;

    public AdelieAvatarMediaExtra() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof AdelieAvatarMediaExtra) && Intrinsics.areEqual(this.msg_id, ((AdelieAvatarMediaExtra) other).msg_id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.msg_id.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdelieAvatarMediaExtra(msg_id=" + this.msg_id + ")";
    }

    public AdelieAvatarMediaExtra(@NotNull String msg_id) {
        Intrinsics.checkNotNullParameter(msg_id, "msg_id");
        this.msg_id = msg_id;
    }

    public /* synthetic */ AdelieAvatarMediaExtra(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }
}
