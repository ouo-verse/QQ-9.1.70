package d24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Ld24/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "index", "I", "a", "()I", "f", "(I)V", "style", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setStyle", "(Ljava/lang/String;)V", "prompt", "b", "g", "is_face_ref", "Z", "d", "()Z", "is_style_ref", "e", "skip_input_preprocess", "getSkip_input_preprocess", tl.h.F, "(Z)V", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZZZ)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d24.i, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class GenerateRequestExtra {

    @SerializedName("index")
    private int index;

    @SerializedName("is_face_ref")
    private final boolean is_face_ref;

    @SerializedName("is_style_ref")
    private final boolean is_style_ref;

    @SerializedName("prompt")
    @NotNull
    private String prompt;

    @SerializedName("skip_input_preprocess")
    private boolean skip_input_preprocess;

    @SerializedName("style")
    @NotNull
    private String style;

    public GenerateRequestExtra() {
        this(0, null, null, false, false, false, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIs_face_ref() {
        return this.is_face_ref;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIs_style_ref() {
        return this.is_style_ref;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateRequestExtra)) {
            return false;
        }
        GenerateRequestExtra generateRequestExtra = (GenerateRequestExtra) other;
        if (this.index == generateRequestExtra.index && Intrinsics.areEqual(this.style, generateRequestExtra.style) && Intrinsics.areEqual(this.prompt, generateRequestExtra.prompt) && this.is_face_ref == generateRequestExtra.is_face_ref && this.is_style_ref == generateRequestExtra.is_style_ref && this.skip_input_preprocess == generateRequestExtra.skip_input_preprocess) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.index = i3;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prompt = str;
    }

    public final void h(boolean z16) {
        this.skip_input_preprocess = z16;
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
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.skip_input_preprocess;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "GenerateRequestExtra(index=" + this.index + ", style=" + this.style + ", prompt=" + this.prompt + ", is_face_ref=" + this.is_face_ref + ", is_style_ref=" + this.is_style_ref + ", skip_input_preprocess=" + this.skip_input_preprocess + ")";
    }

    public GenerateRequestExtra(int i3, @NotNull String style, @NotNull String prompt, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        this.index = i3;
        this.style = style;
        this.prompt = prompt;
        this.is_face_ref = z16;
        this.is_style_ref = z17;
        this.skip_input_preprocess = z18;
    }

    public /* synthetic */ GenerateRequestExtra(int i3, String str, String str2, boolean z16, boolean z17, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) == 0 ? str2 : "", (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? false : z17, (i16 & 32) != 0 ? false : z18);
    }
}
