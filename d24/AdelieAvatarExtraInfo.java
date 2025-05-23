package d24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014\u00a8\u0006*"}, d2 = {"Ld24/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "index", "I", "getIndex", "()I", "c", "(I)V", "style", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "prompt", "getPrompt", "d", "is_face_ref", "Z", "()Z", "i", "(Z)V", "is_style_ref", "j", "refer_img_url", "getRefer_img_url", "e", "workflow_id", "b", tl.h.F, "seed", "getSeed", "f", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieAvatarExtraInfo {

    @SerializedName("index")
    private int index;

    @SerializedName("is_face_ref")
    private boolean is_face_ref;

    @SerializedName("is_style_ref")
    private boolean is_style_ref;

    @SerializedName("prompt")
    @NotNull
    private String prompt;

    @SerializedName("refer_img_url")
    @NotNull
    private String refer_img_url;

    @SerializedName("seed")
    @NotNull
    private String seed;

    @SerializedName("style")
    @NotNull
    private String style;

    @SerializedName("workflow_id")
    @NotNull
    private String workflow_id;

    public AdelieAvatarExtraInfo() {
        this(0, null, null, false, false, null, null, null, 255, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getWorkflow_id() {
        return this.workflow_id;
    }

    public final void c(int i3) {
        this.index = i3;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prompt = str;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refer_img_url = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieAvatarExtraInfo)) {
            return false;
        }
        AdelieAvatarExtraInfo adelieAvatarExtraInfo = (AdelieAvatarExtraInfo) other;
        if (this.index == adelieAvatarExtraInfo.index && Intrinsics.areEqual(this.style, adelieAvatarExtraInfo.style) && Intrinsics.areEqual(this.prompt, adelieAvatarExtraInfo.prompt) && this.is_face_ref == adelieAvatarExtraInfo.is_face_ref && this.is_style_ref == adelieAvatarExtraInfo.is_style_ref && Intrinsics.areEqual(this.refer_img_url, adelieAvatarExtraInfo.refer_img_url) && Intrinsics.areEqual(this.workflow_id, adelieAvatarExtraInfo.workflow_id) && Intrinsics.areEqual(this.seed, adelieAvatarExtraInfo.seed)) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.seed = str;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.style = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.workflow_id = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.index * 31) + this.style.hashCode()) * 31) + this.prompt.hashCode()) * 31;
        boolean z16 = this.is_face_ref;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.is_style_ref;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((((i17 + i3) * 31) + this.refer_img_url.hashCode()) * 31) + this.workflow_id.hashCode()) * 31) + this.seed.hashCode();
    }

    public final void i(boolean z16) {
        this.is_face_ref = z16;
    }

    public final void j(boolean z16) {
        this.is_style_ref = z16;
    }

    @NotNull
    public String toString() {
        return "AdelieAvatarExtraInfo(index=" + this.index + ", style=" + this.style + ", prompt=" + this.prompt + ", is_face_ref=" + this.is_face_ref + ", is_style_ref=" + this.is_style_ref + ", refer_img_url=" + this.refer_img_url + ", workflow_id=" + this.workflow_id + ", seed=" + this.seed + ")";
    }

    public AdelieAvatarExtraInfo(int i3, @NotNull String style, @NotNull String prompt, boolean z16, boolean z17, @NotNull String refer_img_url, @NotNull String workflow_id, @NotNull String seed) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(refer_img_url, "refer_img_url");
        Intrinsics.checkNotNullParameter(workflow_id, "workflow_id");
        Intrinsics.checkNotNullParameter(seed, "seed");
        this.index = i3;
        this.style = style;
        this.prompt = prompt;
        this.is_face_ref = z16;
        this.is_style_ref = z17;
        this.refer_img_url = refer_img_url;
        this.workflow_id = workflow_id;
        this.seed = seed;
    }

    public /* synthetic */ AdelieAvatarExtraInfo(int i3, String str, String str2, boolean z16, boolean z17, String str3, String str4, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? false : z16, (i16 & 16) == 0 ? z17 : false, (i16 & 32) != 0 ? "" : str3, (i16 & 64) != 0 ? "" : str4, (i16 & 128) == 0 ? str5 : "");
    }
}
