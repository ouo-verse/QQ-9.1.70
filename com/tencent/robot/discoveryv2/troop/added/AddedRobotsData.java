package com.tencent.robot.discoveryv2.troop.added;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotBaseInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/added/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "maxRobotCount", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotBaseInfo;", "Ljava/util/List;", "()Ljava/util/List;", "addedRobotList", "<init>", "(ILjava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.discoveryv2.troop.added.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AddedRobotsData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxRobotCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GroupRobotBaseInfo> addedRobotList;

    public AddedRobotsData() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final List<GroupRobotBaseInfo> a() {
        return this.addedRobotList;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxRobotCount() {
        return this.maxRobotCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddedRobotsData)) {
            return false;
        }
        AddedRobotsData addedRobotsData = (AddedRobotsData) other;
        if (this.maxRobotCount == addedRobotsData.maxRobotCount && Intrinsics.areEqual(this.addedRobotList, addedRobotsData.addedRobotList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.maxRobotCount * 31) + this.addedRobotList.hashCode();
    }

    @NotNull
    public String toString() {
        return "AddedRobotsData(maxRobotCount=" + this.maxRobotCount + ", addedRobotList=" + this.addedRobotList + ")";
    }

    public AddedRobotsData(int i3, @NotNull List<GroupRobotBaseInfo> addedRobotList) {
        Intrinsics.checkNotNullParameter(addedRobotList, "addedRobotList");
        this.maxRobotCount = i3;
        this.addedRobotList = addedRobotList;
    }

    public /* synthetic */ AddedRobotsData(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? new ArrayList() : list);
    }
}
