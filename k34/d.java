package k34;

import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\bR\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u0010\u0010\u001c\u00a8\u0006 "}, d2 = {"Lk34/d;", "Lk34/a;", "", "getItemType", "", "getItemId", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", IRobotUtilApi.MMKV_SCENE_ID, "f", "I", "b", "()I", "rank", h.F, "a", "categoryName", "", "i", "Z", "()Z", "(Z)V", "isAdded", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;ILjava/lang/String;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class d implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupRobot robot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int rank;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String categoryName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isAdded;

    public d(@NotNull String troopUin, @NotNull GroupRobot robot, int i3, @NotNull String categoryName, boolean z16) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(robot, "robot");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.troopUin = troopUin;
        this.robot = robot;
        this.rank = i3;
        this.categoryName = categoryName;
        this.isAdded = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: b, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GroupRobot getRobot() {
        return this.robot;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsAdded() {
        return this.isAdded;
    }

    public final void f(boolean z16) {
        this.isAdded = z16;
    }

    @Override // k34.a
    @NotNull
    public String getItemId() {
        return String.valueOf(this.robot.baseInfo.robotUin);
    }

    @Override // k34.a
    public int getItemType() {
        return 3;
    }

    public /* synthetic */ d(String str, GroupRobot groupRobot, int i3, String str2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, groupRobot, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str2, (i16 & 16) != 0 ? groupRobot.isAdded : z16);
    }
}
