package com.tencent.robot.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u0017\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a2\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&\u00a2\u0006\u0002\u0010\fJ\u0017\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/api/IRobotIdentityApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAndAddFriend", "", "uid", "", "afterAddFriend", "Lkotlin/Function0;", "isMatchRobotChatType", "", "chatType", "", "(Ljava/lang/Integer;)Z", "isMatchRobotUinType", "uinType", "isRobotUin", "userUin", "", "(Ljava/lang/Long;)Z", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotIdentityApi extends QRouteApi {
    void checkAndAddFriend(@NotNull String uid, @NotNull Function0<Unit> afterAddFriend);

    boolean isMatchRobotChatType(@Nullable Integer chatType);

    boolean isMatchRobotUinType(@Nullable Integer uinType);

    boolean isRobotUin(@Nullable Long userUin);

    boolean isRobotUin(@Nullable String userUin);
}
