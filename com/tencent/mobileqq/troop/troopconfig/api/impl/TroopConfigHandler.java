package com.tencent.mobileqq.troop.troopconfig.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.config.z;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$ReqBody;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$RspBody;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopConfigHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f299969e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopConfigHandler.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0) {
                oidb_0x496$RspBody oidb_0x496_rspbody = new oidb_0x496$RspBody();
                try {
                    oidb_0x496_rspbody.mergeFrom(bArr);
                    TroopConfigHandler.this.K2(oidb_0x496_rspbody);
                    TroopConfigHandler.this.L2(oidb_0x496_rspbody);
                    TroopConfigHandler.this.J2(oidb_0x496_rspbody);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopConfigHandler", 2, "getTroopConfig, e=" + e16.toString());
                        return;
                    }
                    return;
                }
            }
            QLog.i("TroopConfigHandler", 1, "getTroopConfig, errorCode=" + i3);
        }
    }

    public TroopConfigHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2(oidb_0x496$RspBody oidb_0x496_rspbody) {
        oidb_0x496$AioKeyword oidb_0x496_aiokeyword = oidb_0x496_rspbody.aio_keyword_config;
        if (this.appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, app == null");
                return;
            }
            return;
        }
        if (oidb_0x496_aiokeyword.has()) {
            if (oidb_0x496_aiokeyword.version.has()) {
                int troopAioKeyWordVersion = ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).getTroopAioKeyWordVersion(BaseApplication.getContext(), this.appRuntime.getCurrentAccountUin());
                if (oidb_0x496_aiokeyword.version.get() != troopAioKeyWordVersion) {
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, version change, new_version=" + oidb_0x496_aiokeyword.version.get() + "old_version=" + troopAioKeyWordVersion);
                    }
                    z.a().c(this.appRuntime, oidb_0x496_aiokeyword);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, version no change");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, do not has version");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopConfigHandler", 2, "handleAioKeywordConfig, do not has aioKeyword");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2(oidb_0x496$RspBody oidb_0x496_rspbody) {
        z.a().d(this.appRuntime, oidb_0x496_rspbody.msg_group_msg_config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(oidb_0x496$RspBody oidb_0x496_rspbody) {
        oidb_0x496$Robot oidb_0x496_robot = oidb_0x496_rspbody.robot_config;
        int i3 = BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).getInt("troop_robot_config_version", 0);
        if (QLog.isColorLevel()) {
            QLog.i("TroopConfigHandler", 2, "handleRobotConfig " + i3 + " " + oidb_0x496_robot.version.get());
        }
        if (oidb_0x496_robot.has() && i3 != oidb_0x496_robot.version.get()) {
            ITroopRobotService iTroopRobotService = (ITroopRobotService) this.appRuntime.getRuntimeService(ITroopRobotService.class, "all");
            iTroopRobotService.setRobotConfig(oidb_0x496_robot);
            iTroopRobotService.saveRobotConfig(oidb_0x496_robot);
        }
    }

    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopConfigHandler", 2, "getTroopConfig, app= null");
                return;
            }
            return;
        }
        oidb_0x496$ReqBody oidb_0x496_reqbody = new oidb_0x496$ReqBody();
        oidb_0x496_reqbody.uint64_update_time.set(0L);
        oidb_0x496_reqbody.uint64_first_unread_manager_msg_seq.set(1L);
        int i3 = BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).getInt("troop_robot_config_version", 0);
        oidb_0x496_reqbody.uint32_version.set(i3, true);
        oidb_0x496_reqbody.uint32_aio_keyword_version.set(((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).getTroopAioKeyWordVersion(BaseApplication.getContext(), this.appRuntime.getCurrentAccountUin()));
        if (QLog.isColorLevel()) {
            QLog.i("TroopConfigHandler", 2, "getTroopConfig, type =3 version=" + i3);
        }
        oidb_0x496_reqbody.uint32_type.set(3, true);
        ProtoUtils.a(this.appRuntime, new a(), oidb_0x496_reqbody.toByteArray(), "OidbSvc.0x496", 1174, 0);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f299969e == null) {
            this.f299969e = new HashSet();
        }
        return this.f299969e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopConfigHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopconfig.api.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
