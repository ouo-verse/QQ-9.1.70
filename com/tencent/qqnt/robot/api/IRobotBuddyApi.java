package com.tencent.qqnt.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/robot/api/IRobotBuddyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", QQFriendJsPlugin.API_ADD_FRIEND, "", "robotUid", "", "robotUin", "", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddFriendCallback;", "addRobotFriendShipChangedListener", "listener", "Lkotlin/Function0;", "removeRobotFriendShipChangedListener", "listenerID", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotBuddyApi extends QRouteApi {
    void addFriend(@NotNull String robotUid, long robotUin, @NotNull IAddFriendCallback callback);

    long addRobotFriendShipChangedListener(@NotNull Function0<Unit> listener);

    void removeRobotFriendShipChangedListener(long listenerID);
}
