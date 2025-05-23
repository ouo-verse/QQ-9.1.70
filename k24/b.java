package k24;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.factory.f;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lk24/b;", "Lcom/tencent/qqnt/aio/factory/f;", "Lcom/tencent/qqnt/aio/factory/a;", "param", "", QZoneImageUtils.KEY_MATCH, "", "getAIOFactoryClassName", "cacheAble", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements f {
    @Override // com.tencent.qqnt.aio.factory.f
    public boolean cacheAble() {
        return true;
    }

    @Override // com.tencent.qqnt.aio.factory.f
    @NotNull
    public String getAIOFactoryClassName(@NotNull com.tencent.qqnt.aio.factory.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        String name = a.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "RobotAIOFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.qqnt.aio.factory.f
    public boolean match(@NotNull com.tencent.qqnt.aio.factory.a param) {
        Bundle a16;
        AppRuntime peekAppRuntime;
        String str;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(param, "param");
        if (param.b() != 1 || (a16 = param.a()) == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        long j3 = 0;
        long j16 = a16.getLong("key_peerUin", 0L);
        if (j16 == 0) {
            Bundle a17 = param.a();
            if (a17 == null || (str = a17.getString("key_peerId")) == null) {
                str = "";
            }
            String friendUinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUinFromUid(str);
            Intrinsics.checkNotNullExpressionValue(friendUinFromUid, "api(IRelationNTUinAndUid\u2026.getFriendUinFromUid(uid)");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(friendUinFromUid);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            }
            QLog.d("RobotAIOFactorySupplier", 1, "match uid=" + str + " uin=" + j3);
            j16 = j3;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        return ((ITroopRobotService) runtimeService).isRobotUin(j16);
    }
}
