package com.tencent.robot.aio.helper;

import android.os.Bundle;
import com.tencent.aio.api.help.b;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.ProtoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.robot.proto.Oidb_0x937b$BotAIOEventReq;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/aio/helper/e;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/help/b;", "", "a", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "e", "Ljava/lang/String;", "robotUid", "", "f", "J", "robotUin", "<init>", "()V", tl.h.F, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.help.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String robotUid = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long robotUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/robot/aio/helper/e$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        b() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            QLog.e("RobotEnterEventHelper", 1, "[sendEnterAIOEvent]: error. code: " + errorCode + " msg: " + errorMsg);
            return super.onError(errorCode, errorMsg, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            if (errorCode == 0 && data != null) {
                QLog.d("RobotEnterEventHelper", 1, "[sendEnterAIOEvent]: success");
                return;
            }
            QLog.e("RobotEnterEventHelper", 1, "[sendEnterAIOEvent]: error. data is null. code: " + errorCode);
        }
    }

    private final void a() {
        boolean z16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        String str = "1000";
        String scene = l3.getString("key_robot_aio_scene", "1000");
        Intrinsics.checkNotNullExpressionValue(scene, "scene");
        if (scene.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            str = scene;
        }
        String string = l3.getString("key_robot_callback_data", "");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        QLog.d("RobotEnterEventHelper", 1, "[sendEnterAIOEvent]: uin=" + this.robotUin + " scene=" + str + " data=" + string);
        Oidb_0x937b$BotAIOEventReq oidb_0x937b$BotAIOEventReq = new Oidb_0x937b$BotAIOEventReq();
        oidb_0x937b$BotAIOEventReq.opt.set(1);
        oidb_0x937b$BotAIOEventReq.bot_uid.set(this.robotUid);
        oidb_0x937b$BotAIOEventReq.bot_uin.set(this.robotUin);
        oidb_0x937b$BotAIOEventReq.aio_data.setHasFlag(true);
        oidb_0x937b$BotAIOEventReq.aio_data.scene.set(str);
        oidb_0x937b$BotAIOEventReq.aio_data.callbac_data.set(string);
        ProtoUtils.a(peekAppRuntime, new b(), oidb_0x937b$BotAIOEventReq.toByteArray(), "OidbSvcTrpcTcp.0x937b_1", 37755, 1);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.C1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "RobotEnterEventHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(@NotNull com.tencent.aio.main.businesshelper.b bVar) {
        b.a.a(this, bVar);
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
        b.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        this.robotUid = a16.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        AIOParam g16 = aVar.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        this.robotUin = su3.c.a(g16);
        a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
