package com.tencent.qqnt.aio.robot.api.impl;

import android.content.Context;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qqnt.aio.robot.api.IRobotAIOFavApi;
import com.tencent.robot.aio.share.RobotSessionShareInfo;
import cooperation.qqfav.QfavBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/robot/api/impl/RobotAIOFavApiImpl;", "Lcom/tencent/qqnt/aio/robot/api/IRobotAIOFavApi;", "()V", "multiFav", "", "context", "Landroid/content/Context;", TabPreloadItem.TAB_NAME_MESSAGE, "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "robotSessionShareInfo", "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class RobotAIOFavApiImpl implements IRobotAIOFavApi {
    @Override // com.tencent.qqnt.aio.robot.api.IRobotAIOFavApi
    public void multiFav(Context context, List<? extends AIOMsgItem> msgList, RobotSessionShareInfo robotSessionShareInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(robotSessionShareInfo, "robotSessionShareInfo");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        QfavBuilder.Z(0, robotSessionShareInfo.getShareTitle(), robotSessionShareInfo.getShareLink(), null, robotSessionShareInfo.getShareDesc(), robotSessionShareInfo.getShareIcon(), null, null, false, -1L).F(currentUin).j(context, currentUin);
    }
}
