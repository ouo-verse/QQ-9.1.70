package a74;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"La74/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "titleText", "titleIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: a74.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class CustomTitleInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String titleText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String titleIcon;

    public CustomTitleInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getTitleIcon() {
        return this.titleIcon;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTitleText() {
        return this.titleText;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomTitleInfo)) {
            return false;
        }
        CustomTitleInfo customTitleInfo = (CustomTitleInfo) other;
        if (Intrinsics.areEqual(this.titleText, customTitleInfo.titleText) && Intrinsics.areEqual(this.titleIcon, customTitleInfo.titleIcon)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.titleText.hashCode() * 31) + this.titleIcon.hashCode();
    }

    @NotNull
    public String toString() {
        return "CustomTitleInfo(titleText=" + this.titleText + ", titleIcon=" + this.titleIcon + ")";
    }

    public CustomTitleInfo(@NotNull String titleText, @NotNull String titleIcon) {
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        Intrinsics.checkNotNullParameter(titleIcon, "titleIcon");
        this.titleText = titleText;
        this.titleIcon = titleIcon;
    }

    public /* synthetic */ CustomTitleInfo(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }
}
