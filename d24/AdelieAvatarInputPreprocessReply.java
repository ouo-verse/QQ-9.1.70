package d24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Ld24/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "msg_id", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setMsg_id", "(Ljava/lang/String;)V", "translated_prompt", "b", "setTranslated_prompt", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.c, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieAvatarInputPreprocessReply {

    @SerializedName("msg_id")
    @NotNull
    private String msg_id;

    @SerializedName("translated_prompt")
    @NotNull
    private String translated_prompt;

    public AdelieAvatarInputPreprocessReply() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMsg_id() {
        return this.msg_id;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTranslated_prompt() {
        return this.translated_prompt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieAvatarInputPreprocessReply)) {
            return false;
        }
        AdelieAvatarInputPreprocessReply adelieAvatarInputPreprocessReply = (AdelieAvatarInputPreprocessReply) other;
        if (Intrinsics.areEqual(this.msg_id, adelieAvatarInputPreprocessReply.msg_id) && Intrinsics.areEqual(this.translated_prompt, adelieAvatarInputPreprocessReply.translated_prompt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.msg_id.hashCode() * 31) + this.translated_prompt.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdelieAvatarInputPreprocessReply(msg_id=" + this.msg_id + ", translated_prompt=" + this.translated_prompt + ")";
    }

    public AdelieAvatarInputPreprocessReply(@NotNull String msg_id, @NotNull String translated_prompt) {
        Intrinsics.checkNotNullParameter(msg_id, "msg_id");
        Intrinsics.checkNotNullParameter(translated_prompt, "translated_prompt");
        this.msg_id = msg_id;
        this.translated_prompt = translated_prompt;
    }

    public /* synthetic */ AdelieAvatarInputPreprocessReply(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }
}
