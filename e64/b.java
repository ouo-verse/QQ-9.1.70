package e64;

import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y54.SlashItemRobotNamePayload;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Le64/b;", "Lb74/a;", "newItemData", "", "a", "b", "newItem", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements b74.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CommonBotInfo robotInfo;

    public b(@NotNull CommonBotInfo robotInfo) {
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        this.robotInfo = robotInfo;
    }

    @Override // b74.a
    public boolean a(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (!(newItemData instanceof b) || this.robotInfo.uin != ((b) newItemData).robotInfo.uin) {
            return false;
        }
        return true;
    }

    @Override // b74.a
    public boolean b(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return Intrinsics.areEqual(this.robotInfo.name, ((b) newItemData).robotInfo.name);
    }

    @Override // b74.a
    @Nullable
    public Object c(@NotNull b74.a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        b bVar = (b) newItem;
        ArrayList arrayList = new ArrayList();
        if (!Intrinsics.areEqual(this.robotInfo.name, bVar.robotInfo.name)) {
            String str = bVar.robotInfo.name;
            Intrinsics.checkNotNullExpressionValue(str, "newItem.robotInfo.name");
            arrayList.add(new SlashItemRobotNamePayload(str));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final CommonBotInfo getRobotInfo() {
        return this.robotInfo;
    }
}
