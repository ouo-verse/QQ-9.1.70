package j24;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.MenuInfo;
import com.tencent.robot.aio.bottombar.model.RobotBottomBarItemModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/robot/aio/bottombar/model/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MenuInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "b", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    @NotNull
    public static final MenuInfo a(@NotNull RobotBottomBarItemModel robotBottomBarItemModel) {
        Intrinsics.checkNotNullParameter(robotBottomBarItemModel, "<this>");
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.botInfo = new CommonBotInfo();
        menuInfo.featureInfo = new ArrayList<>();
        for (RobotBottomBarItemModel robotBottomBarItemModel2 : robotBottomBarItemModel.r()) {
            QLog.i("RobotBottomBarItemModel", 1, "[convertSubMenuInfo] subItems = " + robotBottomBarItemModel2);
            menuInfo.featureInfo.add(b(robotBottomBarItemModel2));
        }
        return menuInfo;
    }

    @NotNull
    public static final CommonBotFeatureInfo b(@NotNull RobotBottomBarItemModel robotBottomBarItemModel) {
        Integer intOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(robotBottomBarItemModel, "<this>");
        CommonBotFeatureInfo commonBotFeatureInfo = new CommonBotFeatureInfo();
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(robotBottomBarItemModel.getItemID());
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        commonBotFeatureInfo.f359162id = i3;
        commonBotFeatureInfo.name = robotBottomBarItemModel.getTitle();
        commonBotFeatureInfo.type = robotBottomBarItemModel.getOptionType().getValue();
        commonBotFeatureInfo.url = robotBottomBarItemModel.getScheme();
        commonBotFeatureInfo.schemaUrl = robotBottomBarItemModel.getScheme();
        return commonBotFeatureInfo;
    }
}
