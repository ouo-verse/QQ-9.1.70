package com.tencent.robot.aio.input.shortcutbar;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u00c6\u0003J/\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/aio/input/shortcutbar/RobotPlusPanelIdListEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "robotUin", "", "idList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getIdList", "()Ljava/util/ArrayList;", "getRobotUin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final /* data */ class RobotPlusPanelIdListEvent extends SimpleBaseEvent {

    @NotNull
    private final ArrayList<Integer> idList;

    @Nullable
    private final String robotUin;

    public RobotPlusPanelIdListEvent(@Nullable String str, @NotNull ArrayList<Integer> idList) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        this.robotUin = str;
        this.idList = idList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RobotPlusPanelIdListEvent copy$default(RobotPlusPanelIdListEvent robotPlusPanelIdListEvent, String str, ArrayList arrayList, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = robotPlusPanelIdListEvent.robotUin;
        }
        if ((i3 & 2) != 0) {
            arrayList = robotPlusPanelIdListEvent.idList;
        }
        return robotPlusPanelIdListEvent.copy(str, arrayList);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    @NotNull
    public final ArrayList<Integer> component2() {
        return this.idList;
    }

    @NotNull
    public final RobotPlusPanelIdListEvent copy(@Nullable String robotUin, @NotNull ArrayList<Integer> idList) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        return new RobotPlusPanelIdListEvent(robotUin, idList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotPlusPanelIdListEvent)) {
            return false;
        }
        RobotPlusPanelIdListEvent robotPlusPanelIdListEvent = (RobotPlusPanelIdListEvent) other;
        if (Intrinsics.areEqual(this.robotUin, robotPlusPanelIdListEvent.robotUin) && Intrinsics.areEqual(this.idList, robotPlusPanelIdListEvent.idList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<Integer> getIdList() {
        return this.idList;
    }

    @Nullable
    public final String getRobotUin() {
        return this.robotUin;
    }

    public int hashCode() {
        int hashCode;
        String str = this.robotUin;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return (hashCode * 31) + this.idList.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotPlusPanelIdListEvent(robotUin=" + this.robotUin + ", idList=" + this.idList + ")";
    }
}
