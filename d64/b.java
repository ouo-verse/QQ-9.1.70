package d64;

import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y54.SlashItemRobotMarkPayload;
import y54.SlashItemServiceNamePayload;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ld64/b;", "Lb74/a;", "newItemData", "", "a", "b", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "d", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;", "robotInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "e", "()Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "serviceInfo", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotInfo;Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements b74.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CommonBotInfo robotInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CommonBotFeatureInfo serviceInfo;

    public b(@NotNull CommonBotInfo robotInfo, @NotNull CommonBotFeatureInfo serviceInfo) {
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        this.robotInfo = robotInfo;
        this.serviceInfo = serviceInfo;
    }

    @Override // b74.a
    public boolean a(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (!(newItemData instanceof b)) {
            return false;
        }
        b bVar = (b) newItemData;
        if (this.robotInfo.uin != bVar.robotInfo.uin || this.serviceInfo.f359162id != bVar.serviceInfo.f359162id) {
            return false;
        }
        return true;
    }

    @Override // b74.a
    public boolean b(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        b bVar = (b) newItemData;
        if (this.robotInfo.mark == bVar.robotInfo.mark && Intrinsics.areEqual(this.serviceInfo.name, bVar.serviceInfo.name)) {
            return true;
        }
        return false;
    }

    @Override // b74.a
    @Nullable
    public Object c(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        b bVar = (b) newItemData;
        ArrayList arrayList = new ArrayList();
        long j3 = this.robotInfo.mark;
        long j16 = bVar.robotInfo.mark;
        if (j3 != j16) {
            arrayList.add(new SlashItemRobotMarkPayload(j16));
        }
        if (!Intrinsics.areEqual(this.serviceInfo.name, bVar.serviceInfo.name)) {
            String str = bVar.serviceInfo.name;
            Intrinsics.checkNotNullExpressionValue(str, "newItemData.serviceInfo.name");
            arrayList.add(new SlashItemServiceNamePayload(str));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final CommonBotInfo getRobotInfo() {
        return this.robotInfo;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final CommonBotFeatureInfo getServiceInfo() {
        return this.serviceInfo;
    }
}
