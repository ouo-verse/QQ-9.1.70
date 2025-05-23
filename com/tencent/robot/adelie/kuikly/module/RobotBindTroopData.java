package com.tencent.robot.adelie.kuikly.module;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/q;", "Lcom/tencent/robot/adelie/kuikly/module/p;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "troopUins", "Ljava/util/List;", "b", "()Ljava/util/List;", "maxSize", "I", "a", "()I", "<init>", "(Ljava/util/List;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.kuikly.module.q, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotBindTroopData implements p {

    @SerializedName("maxSize")
    private final int maxSize;

    @SerializedName("troopUins")
    @NotNull
    private final List<String> troopUins;

    public RobotBindTroopData() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final int getMaxSize() {
        return this.maxSize;
    }

    @NotNull
    public final List<String> b() {
        return this.troopUins;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotBindTroopData)) {
            return false;
        }
        RobotBindTroopData robotBindTroopData = (RobotBindTroopData) other;
        if (Intrinsics.areEqual(this.troopUins, robotBindTroopData.troopUins) && this.maxSize == robotBindTroopData.maxSize) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.troopUins.hashCode() * 31) + this.maxSize;
    }

    @NotNull
    public String toString() {
        return "RobotBindTroopData(troopUins=" + this.troopUins + ", maxSize=" + this.maxSize + ")";
    }

    public RobotBindTroopData(@NotNull List<String> troopUins, int i3) {
        Intrinsics.checkNotNullParameter(troopUins, "troopUins");
        this.troopUins = troopUins;
        this.maxSize = i3;
    }

    public /* synthetic */ RobotBindTroopData(List list, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 2) != 0 ? 1 : i3);
    }
}
