package h24;

import a74.CustomTitleInfo;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.robot.aio.bottombar.model.OptionType;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import com.tencent.robot.bottombar.RobotBottomSubMenuMsgIntent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lh24/e;", "Lh24/a;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/robot/aio/bottombar/model/a;", "model", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements h24.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"h24/e$a", "Lg34/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", "c", "La74/a;", "a", "", "id", "", "optType", "Lcom/tencent/robot/aio/bottombar/model/a;", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements g34.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RobotBottomBarItemModel f404126a;

        a(RobotBottomBarItemModel robotBottomBarItemModel) {
            this.f404126a = robotBottomBarItemModel;
        }

        @Override // g34.a
        @NotNull
        public CustomTitleInfo a() {
            return new CustomTitleInfo(this.f404126a.getTitle(), this.f404126a.getIconUrl());
        }

        @Override // g34.a
        @Nullable
        public RobotBottomBarItemModel b(@NotNull String id5, int optType) {
            Object obj;
            boolean z16;
            Intrinsics.checkNotNullParameter(id5, "id");
            Iterator<T> it = this.f404126a.r().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    RobotBottomBarItemModel robotBottomBarItemModel = (RobotBottomBarItemModel) obj;
                    if (Intrinsics.areEqual(robotBottomBarItemModel.getItemID(), id5) && robotBottomBarItemModel.getOptionType() == OptionType.INSTANCE.b(optType)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (RobotBottomBarItemModel) obj;
        }

        @Override // g34.a
        @NotNull
        public MenuInfo c() {
            return j24.c.a(this.f404126a);
        }
    }

    @Override // h24.a
    public void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull RobotBottomBarItemModel model) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(model, "model");
        aioContext.e().h(new RobotBottomSubMenuMsgIntent.ShowRobotMenuDialog(new a(model)));
    }
}
