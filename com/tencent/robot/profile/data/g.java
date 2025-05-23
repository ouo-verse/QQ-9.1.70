package com.tencent.robot.profile.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0001\bB)\b\u0004\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0000H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0000H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0012\u001a\u00020\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015\u0082\u0001\u000b\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/profile/data/g;", "", "", "g", "other", "equals", "newItemData", "b", "a", "", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "itemId", "e", "robotUin", "c", "f", "troopUin", "Lcom/tencent/robot/profile/data/h;", "Lcom/tencent/robot/profile/data/h;", "()Lcom/tencent/robot/profile/data/h;", "color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;)V", "Lcom/tencent/robot/profile/data/e;", "Lcom/tencent/robot/profile/data/f;", "Lcom/tencent/robot/profile/data/i;", "Lcom/tencent/robot/profile/data/j;", "Lcom/tencent/robot/profile/data/k;", "Lcom/tencent/robot/profile/data/l;", "Lcom/tencent/robot/profile/data/m;", "Lcom/tencent/robot/profile/data/n;", "Lcom/tencent/robot/profile/data/o;", "Lcom/tencent/robot/profile/data/p;", "Lcom/tencent/robot/profile/data/r;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class g {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String itemId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileColor color;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/profile/data/g$a;", "", "", "memberShip", "", "a", "", "troopUin", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.g$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int memberShip) {
            if (memberShip == 2 || memberShip == 1) {
                return true;
            }
            return false;
        }

        public final boolean b(@NotNull String troopUin) {
            boolean z16;
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            if (troopUin.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !Intrinsics.areEqual(troopUin, "0")) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    public /* synthetic */ g(String str, String str2, String str3, RobotProfileColor robotProfileColor, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, robotProfileColor);
    }

    public boolean a(@NotNull g newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return Intrinsics.areEqual(this, newItemData);
    }

    public boolean b(@NotNull g newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return Intrinsics.areEqual(this.itemId, newItemData.itemId);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public RobotProfileColor getColor() {
        return this.color;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public String getRobotUin() {
        return this.robotUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (Intrinsics.areEqual(this.itemId, gVar.itemId) && Intrinsics.areEqual(getRobotUin(), gVar.getRobotUin()) && Intrinsics.areEqual(getTroopUin(), gVar.getTroopUin()) && Intrinsics.areEqual(getColor(), gVar.getColor())) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTroopUin() {
        return this.troopUin;
    }

    public final boolean g() {
        return INSTANCE.b(getTroopUin());
    }

    g(String str, String str2, String str3, RobotProfileColor robotProfileColor) {
        this.itemId = str;
        this.robotUin = str2;
        this.troopUin = str3;
        this.color = robotProfileColor;
    }
}
