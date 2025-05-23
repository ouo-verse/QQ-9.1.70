package com.tencent.robot.discoveryv2.troop.added;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/added/b;", "", "<init>", "()V", "a", "Lcom/tencent/robot/discoveryv2/troop/added/b$a;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/added/b$a;", "Lcom/tencent/robot/discoveryv2/troop/added/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/robot/discoveryv2/troop/added/a;", "a", "Lcom/tencent/robot/discoveryv2/troop/added/a;", "()Lcom/tencent/robot/discoveryv2/troop/added/a;", "addedRobotsData", "<init>", "(Lcom/tencent/robot/discoveryv2/troop/added/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.troop.added.b$a, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class RefreshAddedRobotsLayoutUIState extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final AddedRobotsData addedRobotsData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefreshAddedRobotsLayoutUIState(@NotNull AddedRobotsData addedRobotsData) {
            super(null);
            Intrinsics.checkNotNullParameter(addedRobotsData, "addedRobotsData");
            this.addedRobotsData = addedRobotsData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AddedRobotsData getAddedRobotsData() {
            return this.addedRobotsData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RefreshAddedRobotsLayoutUIState) && Intrinsics.areEqual(this.addedRobotsData, ((RefreshAddedRobotsLayoutUIState) other).addedRobotsData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.addedRobotsData.hashCode();
        }

        @NotNull
        public String toString() {
            return "RefreshAddedRobotsLayoutUIState(addedRobotsData=" + this.addedRobotsData + ")";
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
