package d24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Ld24/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "version", "I", "getVersion", "()I", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "refer_img_path", "b", "prompt", "a", "style", "c", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.l, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class UgcAdelieAvatarTemplateData {

    @SerializedName("name")
    @NotNull
    private final String name;

    @SerializedName("prompt")
    @NotNull
    private final String prompt;

    @SerializedName("refer_img_path")
    @NotNull
    private final String refer_img_path;

    @SerializedName("style")
    @NotNull
    private final String style;

    @SerializedName("version")
    private final int version;

    public UgcAdelieAvatarTemplateData() {
        this(0, null, null, null, null, 31, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRefer_img_path() {
        return this.refer_img_path;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UgcAdelieAvatarTemplateData)) {
            return false;
        }
        UgcAdelieAvatarTemplateData ugcAdelieAvatarTemplateData = (UgcAdelieAvatarTemplateData) other;
        if (this.version == ugcAdelieAvatarTemplateData.version && Intrinsics.areEqual(this.name, ugcAdelieAvatarTemplateData.name) && Intrinsics.areEqual(this.refer_img_path, ugcAdelieAvatarTemplateData.refer_img_path) && Intrinsics.areEqual(this.prompt, ugcAdelieAvatarTemplateData.prompt) && Intrinsics.areEqual(this.style, ugcAdelieAvatarTemplateData.style)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.version * 31) + this.name.hashCode()) * 31) + this.refer_img_path.hashCode()) * 31) + this.prompt.hashCode()) * 31) + this.style.hashCode();
    }

    @NotNull
    public String toString() {
        return "UgcAdelieAvatarTemplateData(version=" + this.version + ", name=" + this.name + ", refer_img_path=" + this.refer_img_path + ", prompt=" + this.prompt + ", style=" + this.style + ")";
    }

    public UgcAdelieAvatarTemplateData(int i3, @NotNull String name, @NotNull String refer_img_path, @NotNull String prompt, @NotNull String style) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(refer_img_path, "refer_img_path");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(style, "style");
        this.version = i3;
        this.name = name;
        this.refer_img_path = refer_img_path;
        this.prompt = prompt;
        this.style = style;
    }

    public /* synthetic */ UgcAdelieAvatarTemplateData(int i3, String str, String str2, String str3, String str4, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "test" : str, (i16 & 4) != 0 ? "pad.png" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? "" : str4);
    }
}
