package com.tencent.robot.qqmc.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/qqmc/model/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "showEditButton", "Z", "getShowEditButton", "()Z", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.qqmc.model.g, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotHomePageMineTabConfig {

    @SerializedName("showEditButton")
    private final boolean showEditButton;

    public RobotHomePageMineTabConfig() {
        this(false, 1, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof RobotHomePageMineTabConfig) && this.showEditButton == ((RobotHomePageMineTabConfig) other).showEditButton) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.showEditButton;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "RobotHomePageMineTabConfig(showEditButton=" + this.showEditButton + ")";
    }

    public RobotHomePageMineTabConfig(boolean z16) {
        this.showEditButton = z16;
    }

    public /* synthetic */ RobotHomePageMineTabConfig(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16);
    }
}
