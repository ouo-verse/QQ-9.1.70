package com.tencent.qqnt.robot.api.impl;

import android.content.Context;
import com.tencent.aio.api.runtime.a;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0017\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotServiceApiNtImpl;", "Lcom/tencent/qqnt/robot/api/IRobotServiceApi;", "()V", "fetchRobotProfileInfoFromServer", "", "robotUin", "", "troopUin", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "getRobotCoreInfoFromFriendsCache", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "getRobotProfileInfoFromLocal", "isMatchRobotChatType", "", "chatType", "", "(Ljava/lang/Integer;)Z", "isRobotAIO", "uin", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "isRobotAioMsg", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "isRobotUin", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotServiceApiNtImpl implements IRobotServiceApi {
    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void doSchemaAction(@NotNull String str, @NotNull a aVar, @NotNull String str2, @Nullable Object[] objArr) {
        IRobotServiceApi.a.a(this, str, aVar, str2, objArr);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void fetchRobotProfileInfoFromServer(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    @Nullable
    public RobotCoreInfo getRobotCoreInfoFromFriendsCache(@NotNull String robotUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        return null;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void getRobotProfileInfoFromLocal(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isMatchRobotChatType(@Nullable Integer chatType) {
        return false;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isRobotAIO(@Nullable String uin, @Nullable Integer chatType) {
        return false;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isRobotAioMsg(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return false;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isRobotUin(@Nullable String uin) {
        return false;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void showTicketRequestDialog(@NotNull Context context, long j3, long j16, @NotNull String str, @NotNull List<? extends Object> list, @NotNull Function1<? super Integer, Unit> function1) {
        IRobotServiceApi.a.b(this, context, j3, j16, str, list, function1);
    }
}
