package com.tencent.robot.adelie.homepage.ugc.view;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/v;", "", "", "toString", "", "hashCode", "other", "", "equals", "charDesign", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "charDesc", "a", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.ugc.view.v, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class GenerateRequestExtra {

    @SerializedName("char_desc")
    @NotNull
    private String charDesc;

    @SerializedName("char_design")
    @NotNull
    private String charDesign;

    public GenerateRequestExtra() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCharDesc() {
        return this.charDesc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getCharDesign() {
        return this.charDesign;
    }

    public final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.charDesc = str;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.charDesign = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateRequestExtra)) {
            return false;
        }
        GenerateRequestExtra generateRequestExtra = (GenerateRequestExtra) other;
        if (Intrinsics.areEqual(this.charDesign, generateRequestExtra.charDesign) && Intrinsics.areEqual(this.charDesc, generateRequestExtra.charDesc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.charDesign.hashCode() * 31) + this.charDesc.hashCode();
    }

    @NotNull
    public String toString() {
        return "GenerateRequestExtra(charDesign=" + this.charDesign + ", charDesc=" + this.charDesc + ")";
    }

    public GenerateRequestExtra(@NotNull String charDesign, @NotNull String charDesc) {
        Intrinsics.checkNotNullParameter(charDesign, "charDesign");
        Intrinsics.checkNotNullParameter(charDesc, "charDesc");
        this.charDesign = charDesign;
        this.charDesc = charDesc;
    }

    public /* synthetic */ GenerateRequestExtra(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }
}
