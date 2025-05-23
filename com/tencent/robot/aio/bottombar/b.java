package com.tencent.robot.aio.bottombar;

import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/bottombar/b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/robot/aio/bottombar/b$a;", "Lcom/tencent/robot/aio/bottombar/b$b;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class b implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/aio/bottombar/b$a;", "Lcom/tencent/robot/aio/bottombar/b;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final a f366882d = new a();

        a() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/bottombar/b$b;", "Lcom/tencent/robot/aio/bottombar/b;", "Lcom/tencent/robot/aio/bottombar/model/a;", "d", "Lcom/tencent/robot/aio/bottombar/model/a;", "a", "()Lcom/tencent/robot/aio/bottombar/model/a;", "itemData", "<init>", "(Lcom/tencent/robot/aio/bottombar/model/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.bottombar.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9758b extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RobotBottomBarItemModel itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9758b(@NotNull RobotBottomBarItemModel itemData) {
            super(null);
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            this.itemData = itemData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final RobotBottomBarItemModel getItemData() {
            return this.itemData;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
