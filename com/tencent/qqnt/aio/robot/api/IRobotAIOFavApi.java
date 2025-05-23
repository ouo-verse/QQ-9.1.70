package com.tencent.qqnt.aio.robot.api;

import android.content.Context;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.robot.aio.share.RobotSessionShareInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/robot/api/IRobotAIOFavApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "multiFav", "", "context", "Landroid/content/Context;", TabPreloadItem.TAB_NAME_MESSAGE, "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "robotSessionShareInfo", "Lcom/tencent/robot/aio/share/RobotSessionShareInfo;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IRobotAIOFavApi extends QRouteApi {
    void multiFav(@NotNull Context context, @NotNull List<? extends AIOMsgItem> msgList, @NotNull RobotSessionShareInfo robotSessionShareInfo);
}
