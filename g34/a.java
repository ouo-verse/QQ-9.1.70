package g34;

import a74.CustomTitleInfo;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lg34/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", "c", "La74/a;", "a", "", "itemID", "", "optType", "Lcom/tencent/robot/aio/bottombar/model/a;", "b", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    @NotNull
    CustomTitleInfo a();

    @Nullable
    RobotBottomBarItemModel b(@NotNull String itemID, int optType);

    @NotNull
    MenuInfo c();
}
