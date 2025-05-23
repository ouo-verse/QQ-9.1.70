package com.tencent.qqnt.robot.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wx3.a;
import wx3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\"\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u0004H&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/robot/api/IRobotServiceApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lwx3/a;", "Lwx3/b;", "", "uin", "", "isRobotUin", "", "chatType", "isMatchRobotChatType", "(Ljava/lang/Integer;)Z", "isRobotAIO", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "robotUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "callback", "", "fetchRobotProfileInfoFromServer", "getRobotProfileInfoFromLocal", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "getRobotCoreInfoFromFriendsCache", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "isRobotAioMsg", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRobotServiceApi extends QRouteApi, wx3.a, b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static void a(@NotNull IRobotServiceApi iRobotServiceApi, @NotNull String source, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String schema, @Nullable Object[] objArr) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(schema, "schema");
            a.C11520a.a(iRobotServiceApi, source, aioContext, schema, objArr);
        }

        public static void b(@NotNull IRobotServiceApi iRobotServiceApi, @NotNull Context context, long j3, long j16, @NotNull String robotName, @NotNull List<? extends Object> templateIds, @NotNull Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(robotName, "robotName");
            Intrinsics.checkNotNullParameter(templateIds, "templateIds");
            Intrinsics.checkNotNullParameter(callback, "callback");
            b.a.a(iRobotServiceApi, context, j3, j16, robotName, templateIds, callback);
        }
    }

    /* synthetic */ void doSchemaAction(@NotNull String str, @NotNull com.tencent.aio.api.runtime.a aVar, @NotNull String str2, @Nullable Object[] objArr);

    void fetchRobotProfileInfoFromServer(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback);

    @Nullable
    RobotCoreInfo getRobotCoreInfoFromFriendsCache(@NotNull String robotUin);

    void getRobotProfileInfoFromLocal(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback);

    boolean isMatchRobotChatType(@Nullable Integer chatType);

    boolean isRobotAIO(@Nullable String uin, @Nullable Integer chatType);

    boolean isRobotAioMsg(@NotNull MsgRecord msgRecord);

    boolean isRobotUin(@Nullable String uin);

    /* synthetic */ void showTicketRequestDialog(@NotNull Context context, long j3, long j16, @NotNull String str, @NotNull List<? extends Object> list, @NotNull Function1<? super Integer, Unit> function1);
}
