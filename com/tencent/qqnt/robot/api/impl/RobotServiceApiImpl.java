package com.tencent.qqnt.robot.api.impl;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.subscribe.api.IRobotMessageSubscribeApi;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import r64.SubscribeMessageDialogParam;
import xx3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J:\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0096\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0019\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014JY\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000b0\u001dH\u0016J#\u0010#\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0004\b#\u0010$J\"\u0010'\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020&H\u0016J\"\u0010(\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020&H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020+H\u0016\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotServiceApiImpl;", "Lcom/tencent/qqnt/robot/api/IRobotServiceApi;", "Lwx3/a;", "", "source", "Lcom/tencent/aio/api/runtime/a;", "aioContext", QZoneDTLoginReporter.SCHEMA, "", "", "otherArgs", "", "doSchemaAction", "(Ljava/lang/String;Lcom/tencent/aio/api/runtime/a;Ljava/lang/String;[Ljava/lang/Object;)V", "uin", "", "isRobotUin", "", "chatType", "isMatchRobotChatType", "(Ljava/lang/Integer;)Z", "Landroid/content/Context;", "context", "", "groupId", "robotUin", "robotName", "", "templateIds", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "callback", "showTicketRequestDialog", "isRobotAIO", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "fetchRobotProfileInfoFromServer", "getRobotProfileInfoFromLocal", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "getRobotCoreInfoFromFriendsCache", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "isRobotAioMsg", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RobotServiceApiImpl implements IRobotServiceApi, wx3.a {
    private static final a Companion = new a(null);

    @Deprecated
    private static final String TAG = "RobotServiceApiImpl";
    private final /* synthetic */ b $$delegate_0 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotServiceApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void doSchemaAction(String source, com.tencent.aio.api.runtime.a aioContext, String schema, Object[] otherArgs) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(schema, "schema");
        this.$$delegate_0.doSchemaAction(source, aioContext, schema, otherArgs);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void fetchRobotProfileInfoFromServer(String robotUin, String troopUin, IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).fetchRobotProfileInfoFromServer(robotUin, troopUin, callback);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public RobotCoreInfo getRobotCoreInfoFromFriendsCache(String robotUin) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        return ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotCoreInfoFromFriendsCache(robotUin);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void getRobotProfileInfoFromLocal(String robotUin, String troopUin, IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotProfileInfoFromLocal(robotUin, troopUin, callback);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isMatchRobotChatType(Integer chatType) {
        return ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isMatchRobotChatType(chatType);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isRobotAIO(String uin, Integer chatType) {
        return isMatchRobotChatType(chatType) && isRobotUin(uin);
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isRobotAioMsg(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return isRobotAIO(String.valueOf(msgRecord.peerUin), Integer.valueOf(msgRecord.chatType));
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public boolean isRobotUin(String uin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            String account = peekAppRuntime.getAccount();
            if (!(account == null || account.length() == 0)) {
                return k.l(peekAppRuntime, uin);
            }
        }
        QLog.e(TAG, 1, "isRobotUin app invalid " + peekAppRuntime);
        return false;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotServiceApi
    public void showTicketRequestDialog(Context context, long groupId, long robotUin, String robotName, List<? extends Object> templateIds, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(templateIds, "templateIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IRobotMessageSubscribeApi) QRoute.api(IRobotMessageSubscribeApi.class)).showTicketRequestDialog(TAG, context, new SubscribeMessageDialogParam(groupId, robotUin, robotName, templateIds), callback);
    }
}
