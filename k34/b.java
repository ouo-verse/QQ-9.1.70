package k34;

import com.tencent.qqnt.kernel.nativeinterface.RobotBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR'\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lk34/b;", "Lk34/a;", "", "getItemType", "", "getItemId", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "troopUin", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotBase;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "addedRobots", "f", "I", "b", "()I", "maxNum", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RobotBase> addedRobots;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int maxNum;

    public b(@NotNull String troopUin, @NotNull ArrayList<RobotBase> addedRobots, int i3) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(addedRobots, "addedRobots");
        this.troopUin = troopUin;
        this.addedRobots = addedRobots;
        this.maxNum = i3;
    }

    @NotNull
    public final ArrayList<RobotBase> a() {
        return this.addedRobots;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxNum() {
        return this.maxNum;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    @Override // k34.a
    @NotNull
    public String getItemId() {
        return "1";
    }

    @Override // k34.a
    public int getItemType() {
        return 1;
    }
}
