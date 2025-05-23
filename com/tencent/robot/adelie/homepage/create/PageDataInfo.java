package com.tencent.robot.adelie.homepage.create;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/an;", "", "", "toString", "", "hashCode", "other", "", "equals", "tpl_info", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "activity_id", "a", "activity_name", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.create.an, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class PageDataInfo {

    @SerializedName("activity_id")
    @NotNull
    private final String activity_id;

    @SerializedName("activity_name")
    @NotNull
    private final String activity_name;

    @SerializedName("tpl_info")
    @NotNull
    private final String tpl_info;

    public PageDataInfo() {
        this(null, null, null, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActivity_id() {
        return this.activity_id;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getActivity_name() {
        return this.activity_name;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTpl_info() {
        return this.tpl_info;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageDataInfo)) {
            return false;
        }
        PageDataInfo pageDataInfo = (PageDataInfo) other;
        if (Intrinsics.areEqual(this.tpl_info, pageDataInfo.tpl_info) && Intrinsics.areEqual(this.activity_id, pageDataInfo.activity_id) && Intrinsics.areEqual(this.activity_name, pageDataInfo.activity_name)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.tpl_info.hashCode() * 31) + this.activity_id.hashCode()) * 31) + this.activity_name.hashCode();
    }

    @NotNull
    public String toString() {
        return "PageDataInfo(tpl_info=" + this.tpl_info + ", activity_id=" + this.activity_id + ", activity_name=" + this.activity_name + ")";
    }

    public PageDataInfo(@NotNull String tpl_info, @NotNull String activity_id, @NotNull String activity_name) {
        Intrinsics.checkNotNullParameter(tpl_info, "tpl_info");
        Intrinsics.checkNotNullParameter(activity_id, "activity_id");
        Intrinsics.checkNotNullParameter(activity_name, "activity_name");
        this.tpl_info = tpl_info;
        this.activity_id = activity_id;
        this.activity_name = activity_name;
    }

    public /* synthetic */ PageDataInfo(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}
