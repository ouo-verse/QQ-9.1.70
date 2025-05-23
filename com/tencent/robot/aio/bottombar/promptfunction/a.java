package com.tencent.robot.aio.bottombar.promptfunction;

import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/a;", "Lb74/a;", "newItemData", "", "a", "b", "", "c", "Lcom/tencent/robot/aio/bottombar/model/a;", "Lcom/tencent/robot/aio/bottombar/model/a;", "d", "()Lcom/tencent/robot/aio/bottombar/model/a;", "data", "<init>", "(Lcom/tencent/robot/aio/bottombar/model/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements b74.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotBottomBarItemModel data;

    public a(@NotNull RobotBottomBarItemModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // b74.a
    public boolean a(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return false;
    }

    @Override // b74.a
    public boolean b(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return false;
    }

    @Override // b74.a
    @Nullable
    public Object c(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return null;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final RobotBottomBarItemModel getData() {
        return this.data;
    }
}
