package com.tencent.mobileqq.mqq;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.er;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.inject.IMqqInjector;
import mqq.inject.MqqInjectorManager;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements IMqqInjector {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.inject.IMqqInjector
    public String getSDKPrivatePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return VFSAssistantUtils.getSDKPrivatePath(str);
    }

    @Override // mqq.inject.IMqqInjector
    public boolean getSwitch(Context context, String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? er.c(context, str, z16, z17) : ((Boolean) iPatchRedirector.redirect((short) 8, this, context, str, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
    }

    @Override // mqq.inject.IMqqInjector
    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return AppSetting.n();
    }

    @Override // mqq.inject.IMqqInjector
    public void handleSendTimeForSendMsgPb(ToServiceMsg toServiceMsg, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg, (Object) str);
            return;
        }
        if (BaseConstants.CMD_MSG_PBSENDMSG.equalsIgnoreCase(str)) {
            long j3 = toServiceMsg.extraData.getLong("msg_send_time", 0L);
            if (j3 != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                toServiceMsg.extraData.putLong("msg_request_time", currentTimeMillis);
                toServiceMsg.extraData.putLong("msg_send_to_request_cost", currentTimeMillis - j3);
            }
        }
    }

    @Override // mqq.inject.IMqqInjector
    public String[] highPriorityCommand() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return new String[]{"MessageSvc.PbGetMsg", "MessageSvc.PbGetGroupMsg", BaseConstants.CMD_NT_REGPRXYSVC_SSO_GET_GROUP_SHARE_MSG, "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "MessageSvc.PbGetDiscussMsg", "MessageSvc.PushNotify", "MessageSvc.PushReaded", MiniConst.Spark.CMD_PUSH_SPARK_REWARD, BaseConstants.CMD_RESPPUSH};
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isDebugVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isGrayVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isPublicVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // mqq.inject.IMqqInjector
    public boolean isUiTest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return AppSetting.u();
    }

    @Override // mqq.inject.IMqqInjector
    public ToServiceMsg makeOIDBPkg(OidbWrapper oidbWrapper, String str, int i3, int i16, byte[] bArr, long j3, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 14, this, oidbWrapper, str, Integer.valueOf(i3), Integer.valueOf(i16), bArr, Long.valueOf(j3), businessObserver, Boolean.valueOf(z16));
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.str_client_version.set(MqqInjectorManager.instance().getVersion());
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        ToServiceMsg createToServiceMsg = oidbWrapper.createToServiceMsg(str);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(j3);
        return createToServiceMsg;
    }

    @Override // mqq.inject.IMqqInjector
    public int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? parseOIDBPkg(fromServiceMsg, obj, new oidb_sso$OIDBSSOPkg(), messageMicro) : ((Integer) iPatchRedirector.redirect((short) 15, this, fromServiceMsg, obj, messageMicro)).intValue();
    }

    @Override // mqq.inject.IMqqInjector
    public void postNeedFixStartStepCapturedException(@NonNull Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) th5);
        } else {
            CrashDefendManager.i().p(th5);
        }
    }

    @Override // mqq.inject.IMqqInjector
    public void report(String str, Map<String, String> map) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) map);
            return;
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str2 = peekAppRuntime.getCurrentAccountUin();
            } else {
                str2 = "";
            }
            QQBeaconReport.report(str2, str, map);
        } catch (Exception e16) {
            QLog.e("MqqInjector", 1, "BeaconReport error:", e16);
        }
    }

    @Override // mqq.inject.IMqqInjector
    public String[] tempServletPreferSSOCommand() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new String[]{MiniConst.Spark.CMD_PUSH_SPARK_REWARD, "MessageSvc.PushNotify", BaseConstants.CMD_FORCE_LOGOUT, "ADMsgSvc.PushMsg", "MessageSvc.PushReaded", "OnlinePush.PbPushTransMsg", "OnlinePush.PbPushGroupMsg", "OnlinePush.PbPushBindUinGroupMsg", "OnlinePush.PbPushDisMsg", "OnlinePush.PbC2CMsgSync", "OnlinePush.PbPushC2CMsg", "NearFieldTranFileSvr.NotifyList"};
    }

    @Override // mqq.inject.IMqqInjector
    public void tryDumpUiHierarchyToFile(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            new zy2.a().g(view);
        }
    }

    @Override // mqq.inject.IMqqInjector
    public boolean getSwitch(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, z16) : ((Boolean) iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16))).booleanValue();
    }

    @Override // mqq.inject.IMqqInjector
    public int parseOIDBPkg(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro, MessageMicro messageMicro2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, fromServiceMsg, obj, messageMicro, messageMicro2)).intValue();
        }
        if (messageMicro != null && !(messageMicro instanceof oidb_sso$OIDBSSOPkg)) {
            if (isDebugVersion()) {
                throw new RuntimeException("parseOIDBPkg, !(ssopkg instanceof oidb_sso.OIDBSSOPkg)***");
            }
            return 1001;
        }
        int resultCode = fromServiceMsg.getResultCode();
        if (resultCode != 1000) {
            if (QLog.isDevelopLevel()) {
                QLog.d("BaseBusinessHandler", 4, "parseOIDBPkg, sso result: ", Integer.valueOf(resultCode));
            }
            return resultCode;
        }
        StringBuilder sb5 = QLog.isDevelopLevel() ? new StringBuilder() : null;
        if (messageMicro != null && obj != null) {
            try {
                messageMicro = messageMicro.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                if (sb5 != null) {
                    sb5.append("parseOIDBPkg, oidb_sso, parseFrom byte ");
                    sb5.append(e16);
                }
            }
        } else if (sb5 != null) {
            sb5.append("parseOIDBPkg, data is null");
        }
        if (messageMicro != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = (oidb_sso$OIDBSSOPkg) messageMicro;
            resultCode = oidb_sso_oidbssopkg.uint32_result.get();
            if (resultCode != 0) {
                String str = oidb_sso_oidbssopkg.str_error_msg.get();
                fromServiceMsg.extraData.putString("str_error_msg", str);
                if (sb5 != null) {
                    sb5.append("parseOIDBPkg, errMsg: ");
                    sb5.append(str);
                }
            }
        }
        if (messageMicro != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = (oidb_sso$OIDBSSOPkg) messageMicro;
            if (oidb_sso_oidbssopkg2.bytes_bodybuffer.has() && oidb_sso_oidbssopkg2.bytes_bodybuffer.get() != null && messageMicro2 != null) {
                try {
                    messageMicro2.mergeFrom(((oidb_sso$OIDBSSOPkg) messageMicro).bytes_bodybuffer.get().toByteArray());
                } catch (Exception e17) {
                    if (sb5 != null) {
                        sb5.append(e17);
                    }
                }
            }
        }
        if (sb5 != null && sb5.length() > 0) {
            QLog.i("BaseBusinessHandler", 4, sb5.toString());
        }
        return resultCode;
    }
}
