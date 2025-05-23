package com.tencent.mobileqq.msf.sdk;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.f;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfRespHandleUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String tag = "MSF.D.RespHandleUtil";
    IAuthHandler authHandler;
    IMsfMsgHandler msfMsgHandler;
    INotifyHandler notifyHandler;
    IPushHandler pushHandler;
    IRegisterUinHandler registerUinHandler;
    IServerInfoHandler serverInfoHandler;
    IServerMsgPushHandler serverMsgPushHandler;

    public MsfRespHandleUtil(IMsfHandler[] iMsfHandlerArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iMsfHandlerArr);
            return;
        }
        if (iMsfHandlerArr != null) {
            for (IMsfHandler iMsfHandler : iMsfHandlerArr) {
                if (iMsfHandler instanceof IAuthHandler) {
                    this.authHandler = (IAuthHandler) iMsfHandler;
                } else if (iMsfHandler instanceof IMsfMsgHandler) {
                    this.msfMsgHandler = (IMsfMsgHandler) iMsfHandler;
                } else if (iMsfHandler instanceof INotifyHandler) {
                    this.notifyHandler = (INotifyHandler) iMsfHandler;
                } else if (iMsfHandler instanceof IServerInfoHandler) {
                    this.serverInfoHandler = (IServerInfoHandler) iMsfHandler;
                } else if (iMsfHandler instanceof IPushHandler) {
                    this.pushHandler = (IPushHandler) iMsfHandler;
                } else if (iMsfHandler instanceof IRegisterUinHandler) {
                    this.registerUinHandler = (IRegisterUinHandler) iMsfHandler;
                } else if (iMsfHandler instanceof IServerMsgPushHandler) {
                    this.serverMsgPushHandler = (IServerMsgPushHandler) iMsfHandler;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a2 A[Catch: Exception -> 0x018b, TryCatch #0 {Exception -> 0x018b, blocks: (B:10:0x001a, B:12:0x0023, B:14:0x009a, B:16:0x00a2, B:18:0x00a6, B:21:0x015f, B:23:0x0163, B:25:0x0167, B:27:0x016d, B:29:0x017a, B:32:0x00ab, B:34:0x00b3, B:36:0x00b7, B:37:0x00ce, B:39:0x00d6, B:41:0x00da, B:42:0x00df, B:44:0x00e7, B:46:0x00eb, B:47:0x00ef, B:49:0x00f7, B:51:0x00fb, B:52:0x0103, B:54:0x010b, B:56:0x010f, B:57:0x0123, B:59:0x012b, B:61:0x012f, B:62:0x0148, B:63:0x002f, B:65:0x0037, B:67:0x0048, B:69:0x0051, B:71:0x0059, B:73:0x006f, B:74:0x0073, B:76:0x007b, B:78:0x0082, B:79:0x0086, B:81:0x008e, B:83:0x0094), top: B:9:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x015f A[Catch: Exception -> 0x018b, TryCatch #0 {Exception -> 0x018b, blocks: (B:10:0x001a, B:12:0x0023, B:14:0x009a, B:16:0x00a2, B:18:0x00a6, B:21:0x015f, B:23:0x0163, B:25:0x0167, B:27:0x016d, B:29:0x017a, B:32:0x00ab, B:34:0x00b3, B:36:0x00b7, B:37:0x00ce, B:39:0x00d6, B:41:0x00da, B:42:0x00df, B:44:0x00e7, B:46:0x00eb, B:47:0x00ef, B:49:0x00f7, B:51:0x00fb, B:52:0x0103, B:54:0x010b, B:56:0x010f, B:57:0x0123, B:59:0x012b, B:61:0x012f, B:62:0x0148, B:63:0x002f, B:65:0x0037, B:67:0x0048, B:69:0x0051, B:71:0x0059, B:73:0x006f, B:74:0x0073, B:76:0x007b, B:78:0x0082, B:79:0x0086, B:81:0x008e, B:83:0x0094), top: B:9:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x018a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab A[Catch: Exception -> 0x018b, TryCatch #0 {Exception -> 0x018b, blocks: (B:10:0x001a, B:12:0x0023, B:14:0x009a, B:16:0x00a2, B:18:0x00a6, B:21:0x015f, B:23:0x0163, B:25:0x0167, B:27:0x016d, B:29:0x017a, B:32:0x00ab, B:34:0x00b3, B:36:0x00b7, B:37:0x00ce, B:39:0x00d6, B:41:0x00da, B:42:0x00df, B:44:0x00e7, B:46:0x00eb, B:47:0x00ef, B:49:0x00f7, B:51:0x00fb, B:52:0x0103, B:54:0x010b, B:56:0x010f, B:57:0x0123, B:59:0x012b, B:61:0x012f, B:62:0x0148, B:63:0x002f, B:65:0x0037, B:67:0x0048, B:69:0x0051, B:71:0x0059, B:73:0x006f, B:74:0x0073, B:76:0x007b, B:78:0x0082, B:79:0x0086, B:81:0x008e, B:83:0x0094), top: B:9:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handlePushMsg(FromServiceMsg fromServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fromServiceMsg)).booleanValue();
        }
        try {
            if (fromServiceMsg.getMsfCommand() == MsfCommand.onStartConnect) {
                MsfServiceSdk.get().getMSFMsgPushHandlerUtil().handleMSFStartConnect(fromServiceMsg);
            } else {
                if (fromServiceMsg.getMsfCommand() == MsfCommand.onConnOpened) {
                    NetConnInfoCenter.socketConnState = 2;
                    MsfServiceSdk.get().getMSFMsgPushHandlerUtil().handleMSFConnectSuccess(fromServiceMsg);
                    if (this.serverMsgPushHandler != null) {
                        AppNetConnInfo.checkNetEvent();
                        this.serverMsgPushHandler.onConnOpened(fromServiceMsg);
                    }
                    z16 = false;
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand.onReceFirstResp) {
                    NetConnInfoCenter.socketConnState = 4;
                    NetConnInfoCenter.setGateWayIp((String) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_GATEWAY_IP, ""));
                    IServerMsgPushHandler iServerMsgPushHandler = this.serverMsgPushHandler;
                    if (iServerMsgPushHandler != null) {
                        iServerMsgPushHandler.onReceFirstResp(fromServiceMsg);
                    }
                    z16 = false;
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand.onOepnConnAllFailed) {
                    NetConnInfoCenter.socketConnState = 3;
                    IServerMsgPushHandler iServerMsgPushHandler2 = this.serverMsgPushHandler;
                    if (iServerMsgPushHandler2 != null) {
                        iServerMsgPushHandler2.onOpenConnAllFailed(fromServiceMsg);
                    }
                    z16 = false;
                } else {
                    if (fromServiceMsg.getMsfCommand() == MsfCommand.onConnClosed) {
                        NetConnInfoCenter.socketConnState = 1;
                        IServerMsgPushHandler iServerMsgPushHandler3 = this.serverMsgPushHandler;
                        if (iServerMsgPushHandler3 != null) {
                            iServerMsgPushHandler3.onConnClose(fromServiceMsg);
                        }
                    }
                    z16 = false;
                }
                if (fromServiceMsg.getMsfCommand() != MsfCommand.onRecvConfigPush) {
                    IServerMsgPushHandler iServerMsgPushHandler4 = this.serverMsgPushHandler;
                    if (iServerMsgPushHandler4 != null) {
                        iServerMsgPushHandler4.onRecvServerConfigPush(fromServiceMsg);
                        z16 = true;
                    }
                    if (!z16) {
                        IPushHandler iPushHandler = this.pushHandler;
                        if (iPushHandler != null) {
                            iPushHandler.onRecvCmdPush(fromServiceMsg);
                            return true;
                        }
                        if (fromServiceMsg.getServiceCmd() != null && fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                            com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247650b, fromServiceMsg.getWupBuffer(), 18);
                        }
                        return false;
                    }
                    return z16;
                }
                if (fromServiceMsg.getMsfCommand() == MsfCommand.onRecvNotifyMsg) {
                    if (this.notifyHandler != null) {
                        this.notifyHandler.onRecvNotify(((Long) fromServiceMsg.getAttributes().get("notifyId")).longValue(), fromServiceMsg);
                        z16 = true;
                    }
                    if (!z16) {
                    }
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand.registerPush) {
                    IPushHandler iPushHandler2 = this.pushHandler;
                    if (iPushHandler2 != null) {
                        iPushHandler2.onRegisterPushResp(null, fromServiceMsg);
                        z16 = true;
                    }
                    if (!z16) {
                    }
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand.onTicketChanged) {
                    IPushHandler iPushHandler3 = this.pushHandler;
                    if (iPushHandler3 != null) {
                        iPushHandler3.onTicketChanged(fromServiceMsg);
                        z16 = true;
                    }
                    if (!z16) {
                    }
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand.onProxyIpChanged) {
                    IPushHandler iPushHandler4 = this.pushHandler;
                    if (iPushHandler4 != null) {
                        iPushHandler4.onProxyIpChanged(fromServiceMsg.getUin());
                        z16 = true;
                    }
                    if (!z16) {
                    }
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand.onOverloadPushNotify) {
                    if (this.pushHandler != null) {
                        this.pushHandler.onOverloadPushNotify((String) fromServiceMsg.getAttributes().get("msg"));
                        z16 = true;
                    }
                    if (!z16) {
                    }
                } else {
                    if (fromServiceMsg.getMsfCommand() == MsfCommand.msf_sec_dispatch_to_app_event) {
                        IPushHandler iPushHandler5 = this.pushHandler;
                        if (iPushHandler5 != null) {
                            iPushHandler5.onSecDispatchToAppEvent(fromServiceMsg);
                            QLog.d(tag, 1, "handle SecDispatchAppEvent, msg: " + fromServiceMsg);
                            z16 = true;
                        } else {
                            QLog.d(tag, 1, "handle SecDispatchAppEvent error for handler null, msg: " + fromServiceMsg);
                        }
                    }
                    if (!z16) {
                    }
                }
            }
            z16 = true;
            if (fromServiceMsg.getMsfCommand() != MsfCommand.onRecvConfigPush) {
            }
        } catch (Exception e16) {
            QLog.d(tag, 1, "handle push msg error " + e16, e16);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:306:0x047b A[Catch: Exception -> 0x0518, TryCatch #20 {Exception -> 0x0518, blocks: (B:10:0x0020, B:12:0x0033, B:13:0x0048, B:15:0x0051, B:18:0x005b, B:20:0x0063, B:22:0x006b, B:25:0x0075, B:27:0x007e, B:30:0x0088, B:32:0x0090, B:34:0x0094, B:38:0x050e, B:40:0x0512, B:47:0x00a3, B:49:0x00ab, B:51:0x00af, B:52:0x00b7, B:54:0x00bf, B:56:0x00c3, B:57:0x00cb, B:59:0x00d3, B:61:0x00d7, B:62:0x00df, B:64:0x00e7, B:66:0x00eb, B:67:0x00f3, B:69:0x00fb, B:71:0x00ff, B:72:0x0107, B:74:0x010f, B:76:0x0113, B:77:0x011e, B:79:0x0126, B:81:0x012a, B:82:0x0133, B:84:0x013b, B:90:0x016d, B:91:0x0184, B:93:0x018c, B:95:0x0190, B:96:0x0195, B:98:0x019d, B:100:0x01a1, B:101:0x01a6, B:103:0x01ae, B:105:0x01b2, B:106:0x01b7, B:108:0x01bf, B:110:0x01c3, B:111:0x01c8, B:114:0x01d6, B:116:0x01da, B:124:0x0201, B:127:0x01fe, B:132:0x0208, B:135:0x0213, B:137:0x0217, B:149:0x0252, B:153:0x024c, B:158:0x025d, B:161:0x026b, B:163:0x026f, B:177:0x02bd, B:180:0x02b8, B:189:0x02c8, B:191:0x02d0, B:197:0x02ec, B:201:0x02e8, B:202:0x02f3, B:205:0x0301, B:207:0x0305, B:217:0x0341, B:221:0x033c, B:229:0x034c, B:231:0x0354, B:233:0x0358, B:256:0x03db, B:259:0x03d4, B:275:0x03e8, B:278:0x03f9, B:285:0x0414, B:287:0x041a, B:288:0x042c, B:290:0x0411, B:291:0x0433, B:293:0x043b, B:304:0x0475, B:306:0x047b, B:307:0x048d, B:310:0x046d, B:314:0x049a, B:316:0x04a2, B:323:0x04ac, B:324:0x04b0, B:326:0x04b6, B:329:0x04e3, B:337:0x04df, B:338:0x04ed, B:340:0x04f3, B:341:0x04fb, B:343:0x0501, B:87:0x0141, B:319:0x04a6, B:331:0x04bc, B:333:0x04d1, B:194:0x02d4, B:196:0x02da, B:281:0x03fd, B:283:0x0403), top: B:9:0x0020, inners: #2, #4, #13, #14, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x050e A[Catch: Exception -> 0x0518, TryCatch #20 {Exception -> 0x0518, blocks: (B:10:0x0020, B:12:0x0033, B:13:0x0048, B:15:0x0051, B:18:0x005b, B:20:0x0063, B:22:0x006b, B:25:0x0075, B:27:0x007e, B:30:0x0088, B:32:0x0090, B:34:0x0094, B:38:0x050e, B:40:0x0512, B:47:0x00a3, B:49:0x00ab, B:51:0x00af, B:52:0x00b7, B:54:0x00bf, B:56:0x00c3, B:57:0x00cb, B:59:0x00d3, B:61:0x00d7, B:62:0x00df, B:64:0x00e7, B:66:0x00eb, B:67:0x00f3, B:69:0x00fb, B:71:0x00ff, B:72:0x0107, B:74:0x010f, B:76:0x0113, B:77:0x011e, B:79:0x0126, B:81:0x012a, B:82:0x0133, B:84:0x013b, B:90:0x016d, B:91:0x0184, B:93:0x018c, B:95:0x0190, B:96:0x0195, B:98:0x019d, B:100:0x01a1, B:101:0x01a6, B:103:0x01ae, B:105:0x01b2, B:106:0x01b7, B:108:0x01bf, B:110:0x01c3, B:111:0x01c8, B:114:0x01d6, B:116:0x01da, B:124:0x0201, B:127:0x01fe, B:132:0x0208, B:135:0x0213, B:137:0x0217, B:149:0x0252, B:153:0x024c, B:158:0x025d, B:161:0x026b, B:163:0x026f, B:177:0x02bd, B:180:0x02b8, B:189:0x02c8, B:191:0x02d0, B:197:0x02ec, B:201:0x02e8, B:202:0x02f3, B:205:0x0301, B:207:0x0305, B:217:0x0341, B:221:0x033c, B:229:0x034c, B:231:0x0354, B:233:0x0358, B:256:0x03db, B:259:0x03d4, B:275:0x03e8, B:278:0x03f9, B:285:0x0414, B:287:0x041a, B:288:0x042c, B:290:0x0411, B:291:0x0433, B:293:0x043b, B:304:0x0475, B:306:0x047b, B:307:0x048d, B:310:0x046d, B:314:0x049a, B:316:0x04a2, B:323:0x04ac, B:324:0x04b0, B:326:0x04b6, B:329:0x04e3, B:337:0x04df, B:338:0x04ed, B:340:0x04f3, B:341:0x04fb, B:343:0x0501, B:87:0x0141, B:319:0x04a6, B:331:0x04bc, B:333:0x04d1, B:194:0x02d4, B:196:0x02da, B:281:0x03fd, B:283:0x0403), top: B:9:0x0020, inners: #2, #4, #13, #14, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0517 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleRespMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int resultCode;
        int businessFailCode;
        String businessFailMsg;
        boolean z16;
        boolean z17;
        RespondCustomSig respondCustomSig;
        IAuthHandler iAuthHandler;
        String str;
        String str2;
        int i3;
        byte[] bArr;
        String str3;
        String str4;
        int i16;
        int i17;
        int i18;
        String str5;
        int i19;
        int i26;
        int i27;
        byte[] bArr2;
        String str6;
        int i28;
        byte[] bArr3;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        byte[] bArr4;
        int i46;
        byte[] bArr5;
        int i47;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg)).booleanValue();
        }
        try {
            resultCode = fromServiceMsg.getResultCode();
            businessFailCode = fromServiceMsg.getBusinessFailCode();
            businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "handle fmsg:" + fromServiceMsg);
            }
        } catch (Exception e16) {
            QLog.d(tag, 1, "handle resp msg error " + e16, e16);
            return true;
        }
        if (fromServiceMsg.getMsfCommand() != MsfCommand.loginAuth && fromServiceMsg.getMsfCommand() != MsfCommand.wt_loginAuth) {
            if (fromServiceMsg.getMsfCommand() != MsfCommand.changeUinLogin && fromServiceMsg.getMsfCommand() != MsfCommand.wt_GetStViaSMSVerifyLogin && fromServiceMsg.getMsfCommand() != MsfCommand.wt_GetStViaGatewayLogin) {
                String str7 = null;
                if (fromServiceMsg.getMsfCommand() != MsfCommand.changeToken && fromServiceMsg.getMsfCommand() != MsfCommand.wt_exchange) {
                    if (fromServiceMsg.getMsfCommand() == MsfCommand.submitPuzzleVerifyCodeTicket) {
                        IAuthHandler iAuthHandler2 = this.authHandler;
                        if (iAuthHandler2 != null) {
                            iAuthHandler2.onRecvLoginResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                                IMsfMsgHandler iMsfMsgHandler = this.msfMsgHandler;
                                if (iMsfMsgHandler != null) {
                                    iMsfMsgHandler.onRecvResp(toServiceMsg, fromServiceMsg);
                                    return true;
                                }
                                return z16;
                            }
                            return z17;
                        }
                    } else if (fromServiceMsg.getMsfCommand() == MsfCommand.submitVerifyCode) {
                        IAuthHandler iAuthHandler3 = this.authHandler;
                        if (iAuthHandler3 != null) {
                            iAuthHandler3.onRecvLoginResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        }
                    } else if (fromServiceMsg.getMsfCommand() == MsfCommand.refreVerifyCode) {
                        IAuthHandler iAuthHandler4 = this.authHandler;
                        if (iAuthHandler4 != null) {
                            iAuthHandler4.onRecvLoginResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        }
                    } else if (fromServiceMsg.getMsfCommand() == MsfCommand.wt_CheckSMSAndGetSt) {
                        IAuthHandler iAuthHandler5 = this.authHandler;
                        if (iAuthHandler5 != null) {
                            iAuthHandler5.onRecvLoginResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        }
                    } else if (fromServiceMsg.getMsfCommand() == MsfCommand.delLoginedAccount) {
                        IAuthHandler iAuthHandler6 = this.authHandler;
                        if (iAuthHandler6 != null) {
                            iAuthHandler6.onDelLoginedAccountResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        }
                    } else if (fromServiceMsg.getMsfCommand() == MsfCommand.wt_name2uin) {
                        IAuthHandler iAuthHandler7 = this.authHandler;
                        if (iAuthHandler7 != null) {
                            iAuthHandler7.onRecvChangeUinResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        }
                    } else if (fromServiceMsg.getMsfCommand() == MsfCommand.onRecvVerifyCode) {
                        if (this.authHandler != null) {
                            this.authHandler.onReceVerifyCode(VerifyCodeInfo.getVerifyCodeInfo(fromServiceMsg), toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        }
                    } else if (fromServiceMsg.getMsfCommand() == MsfCommand.reportMsg) {
                        IServerInfoHandler iServerInfoHandler = this.serverInfoHandler;
                        if (iServerInfoHandler != null) {
                            iServerInfoHandler.onReportResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        }
                    } else {
                        if (fromServiceMsg.getMsfCommand() == MsfCommand.getServerConfig) {
                            if (fromServiceMsg.isSuccess()) {
                                try {
                                    MsfSdkUtils.writeServerConfig(com.tencent.mobileqq.msf.service.n.b(toServiceMsg), ((Integer) fromServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_GETSERVERCONFIG_TYPE)).intValue(), (String) fromServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_GETSERVERCONFIG_CONTENT), toServiceMsg.getUin());
                                } catch (Exception e17) {
                                    QLog.e(tag, 1, "write config error " + e17);
                                }
                            }
                            z16 = false;
                            z17 = true;
                            if (!z17) {
                            }
                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.registerPush) {
                            IPushHandler iPushHandler = this.pushHandler;
                            if (iPushHandler != null) {
                                iPushHandler.onRegisterPushResp(toServiceMsg, fromServiceMsg);
                                z16 = false;
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.unRegisterPush) {
                            IPushHandler iPushHandler2 = this.pushHandler;
                            if (iPushHandler2 != null) {
                                iPushHandler2.onUnRegisterPushResp(toServiceMsg, fromServiceMsg);
                                z16 = false;
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.registerCmdCallback) {
                            IPushHandler iPushHandler3 = this.pushHandler;
                            if (iPushHandler3 != null) {
                                iPushHandler3.onRegisterCmdPushResp(toServiceMsg, fromServiceMsg);
                                z16 = false;
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.resetCmdCallback) {
                            IPushHandler iPushHandler4 = this.pushHandler;
                            if (iPushHandler4 != null) {
                                iPushHandler4.onResetCmdPushResp(toServiceMsg, fromServiceMsg);
                                z16 = false;
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.regUin_queryMobile) {
                            if (this.registerUinHandler != null) {
                                byte[] bArr6 = new byte[0];
                                try {
                                    if (fromServiceMsg.isSuccess()) {
                                        i47 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                        try {
                                            bArr6 = (byte[]) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO);
                                        } catch (Exception e18) {
                                            e = e18;
                                            e.printStackTrace();
                                            this.registerUinHandler.onRegQueryAccountResp(i47, bArr6, toServiceMsg, fromServiceMsg);
                                            z16 = false;
                                            z17 = true;
                                            if (!z17) {
                                            }
                                        }
                                    } else {
                                        i47 = 0;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    i47 = 0;
                                }
                                this.registerUinHandler.onRegQueryAccountResp(i47, bArr6, toServiceMsg, fromServiceMsg);
                                z16 = false;
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.regUin_commitMobile) {
                            if (this.registerUinHandler != null) {
                                byte[] bArr7 = new byte[0];
                                byte[] bArr8 = new byte[0];
                                try {
                                    if (fromServiceMsg.isSuccess()) {
                                        i39 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                        try {
                                            bArr4 = (byte[]) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO);
                                            try {
                                                i46 = i39;
                                                bArr5 = (byte[]) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE, new byte[0]);
                                            } catch (Exception e26) {
                                                e = e26;
                                                bArr8 = bArr4;
                                                e.printStackTrace();
                                                bArr4 = bArr8;
                                                i46 = i39;
                                                bArr5 = bArr7;
                                                this.registerUinHandler.onRegisterCommitMobileResp(i46, bArr4, bArr5, toServiceMsg, fromServiceMsg);
                                                z16 = false;
                                                z17 = true;
                                                if (!z17) {
                                                }
                                            }
                                        } catch (Exception e27) {
                                            e = e27;
                                        }
                                    } else {
                                        bArr5 = bArr7;
                                        bArr4 = bArr8;
                                        i46 = 0;
                                    }
                                } catch (Exception e28) {
                                    e = e28;
                                    i39 = 0;
                                }
                                this.registerUinHandler.onRegisterCommitMobileResp(i46, bArr4, bArr5, toServiceMsg, fromServiceMsg);
                                z16 = false;
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.regUin_reSendSms) {
                            if (this.registerUinHandler != null) {
                                byte[] bArr9 = new byte[0];
                                try {
                                    if (fromServiceMsg.isSuccess()) {
                                        i36 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                        try {
                                            bArr3 = (byte[]) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO);
                                            try {
                                                i29 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESENDTIME)).intValue();
                                                try {
                                                    i38 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_TIMEOVER)).intValue();
                                                    i37 = i29;
                                                } catch (Exception e29) {
                                                    e = e29;
                                                    e.printStackTrace();
                                                    i37 = i29;
                                                    i38 = 0;
                                                    this.registerUinHandler.onRegisterSendResendSmsreqResp(i36, bArr3, i37, i38, toServiceMsg, fromServiceMsg);
                                                    z16 = false;
                                                    z17 = true;
                                                    if (!z17) {
                                                    }
                                                }
                                            } catch (Exception e36) {
                                                e = e36;
                                                i29 = 0;
                                                e.printStackTrace();
                                                i37 = i29;
                                                i38 = 0;
                                                this.registerUinHandler.onRegisterSendResendSmsreqResp(i36, bArr3, i37, i38, toServiceMsg, fromServiceMsg);
                                                z16 = false;
                                                z17 = true;
                                                if (!z17) {
                                                }
                                            }
                                        } catch (Exception e37) {
                                            e = e37;
                                            bArr3 = bArr9;
                                        }
                                    } else {
                                        bArr3 = bArr9;
                                        i36 = 0;
                                        i37 = 0;
                                        i38 = 0;
                                    }
                                } catch (Exception e38) {
                                    e = e38;
                                    bArr3 = bArr9;
                                    i29 = 0;
                                    i36 = 0;
                                }
                                this.registerUinHandler.onRegisterSendResendSmsreqResp(i36, bArr3, i37, i38, toServiceMsg, fromServiceMsg);
                                z16 = false;
                                z17 = true;
                                if (!z17) {
                                }
                            }
                        } else {
                            if (fromServiceMsg.getMsfCommand() == MsfCommand.regUin_commitSmsCode) {
                                if (this.registerUinHandler != null) {
                                    try {
                                    } catch (Exception e39) {
                                        e39.printStackTrace();
                                    }
                                    if (fromServiceMsg.isSuccess()) {
                                        i28 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                        this.registerUinHandler.onRegisterCommitSmsCodeResp(i28, toServiceMsg, fromServiceMsg);
                                        z16 = false;
                                        z17 = true;
                                        if (!z17) {
                                        }
                                    }
                                    i28 = 0;
                                    this.registerUinHandler.onRegisterCommitSmsCodeResp(i28, toServiceMsg, fromServiceMsg);
                                    z16 = false;
                                    z17 = true;
                                    if (!z17) {
                                    }
                                }
                            } else {
                                String str8 = "";
                                if (fromServiceMsg.getMsfCommand() == MsfCommand.regUin_commitPass) {
                                    if (this.registerUinHandler != null) {
                                        byte[] bArr10 = new byte[0];
                                        try {
                                        } catch (Exception e46) {
                                            e = e46;
                                            i27 = 0;
                                        }
                                        if (fromServiceMsg.isSuccess()) {
                                            i27 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                            try {
                                                str6 = (String) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN);
                                            } catch (Exception e47) {
                                                e = e47;
                                            }
                                            try {
                                                bArr2 = (byte[]) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_CONTACTSIG);
                                            } catch (Exception e48) {
                                                e = e48;
                                                str8 = str6;
                                                e.printStackTrace();
                                                bArr2 = bArr10;
                                                str6 = str8;
                                                this.registerUinHandler.onRegisterCommitPassResp(i27, str6, bArr2, toServiceMsg, fromServiceMsg);
                                                z16 = false;
                                                z17 = true;
                                                if (!z17) {
                                                }
                                            }
                                            this.registerUinHandler.onRegisterCommitPassResp(i27, str6, bArr2, toServiceMsg, fromServiceMsg);
                                            z16 = false;
                                            z17 = true;
                                            if (!z17) {
                                            }
                                        } else {
                                            bArr2 = bArr10;
                                            i27 = 0;
                                            str6 = str8;
                                            this.registerUinHandler.onRegisterCommitPassResp(i27, str6, bArr2, toServiceMsg, fromServiceMsg);
                                            z16 = false;
                                            z17 = true;
                                            if (!z17) {
                                            }
                                        }
                                    }
                                } else {
                                    if (fromServiceMsg.getMsfCommand() == MsfCommand.regUin_querySmsStat) {
                                        if (this.registerUinHandler != null) {
                                            byte[] bArr11 = new byte[0];
                                            try {
                                            } catch (Exception e49) {
                                                e = e49;
                                                bArr = bArr11;
                                                str3 = null;
                                                str4 = null;
                                                i16 = 0;
                                                i17 = 0;
                                                i18 = 0;
                                            }
                                            if (fromServiceMsg.isSuccess()) {
                                                i17 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                                try {
                                                    bArr = (byte[]) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_PROMPTINFO);
                                                    try {
                                                        i16 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESENDTIME)).intValue();
                                                        try {
                                                            i18 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_TIMEOVER)).intValue();
                                                            try {
                                                                str3 = (String) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN);
                                                                try {
                                                                    str4 = (String) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_NICK);
                                                                } catch (Exception e56) {
                                                                    e = e56;
                                                                    str4 = null;
                                                                }
                                                            } catch (Exception e57) {
                                                                e = e57;
                                                                str3 = null;
                                                                str4 = null;
                                                            }
                                                        } catch (Exception e58) {
                                                            e = e58;
                                                            str3 = null;
                                                            str4 = null;
                                                            i18 = 0;
                                                        }
                                                    } catch (Exception e59) {
                                                        e = e59;
                                                        str3 = null;
                                                        str4 = null;
                                                        i16 = 0;
                                                        i18 = 0;
                                                        e.printStackTrace();
                                                        str5 = null;
                                                        str7 = str3;
                                                        i19 = i18;
                                                        i26 = i16;
                                                        z16 = false;
                                                        this.registerUinHandler.onRegisterQuerySmsStatResp(i17, bArr, i26, i19, str7, str4, str5, toServiceMsg, fromServiceMsg);
                                                        z17 = true;
                                                        if (!z17) {
                                                        }
                                                    }
                                                } catch (Exception e65) {
                                                    e = e65;
                                                    bArr = bArr11;
                                                }
                                                try {
                                                    str5 = (String) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_PICTURE_URL);
                                                } catch (Exception e66) {
                                                    e = e66;
                                                    e.printStackTrace();
                                                    str5 = null;
                                                    str7 = str3;
                                                    i19 = i18;
                                                    i26 = i16;
                                                    z16 = false;
                                                    this.registerUinHandler.onRegisterQuerySmsStatResp(i17, bArr, i26, i19, str7, str4, str5, toServiceMsg, fromServiceMsg);
                                                    z17 = true;
                                                    if (!z17) {
                                                    }
                                                }
                                                str7 = str3;
                                                i19 = i18;
                                                i26 = i16;
                                                z16 = false;
                                                this.registerUinHandler.onRegisterQuerySmsStatResp(i17, bArr, i26, i19, str7, str4, str5, toServiceMsg, fromServiceMsg);
                                            } else {
                                                bArr = bArr11;
                                                str4 = null;
                                                str5 = null;
                                                i17 = 0;
                                                i26 = 0;
                                                i19 = 0;
                                                z16 = false;
                                                this.registerUinHandler.onRegisterQuerySmsStatResp(i17, bArr, i26, i19, str7, str4, str5, toServiceMsg, fromServiceMsg);
                                            }
                                        }
                                    } else {
                                        z16 = false;
                                        int i48 = -1;
                                        if (fromServiceMsg.getMsfCommand() == MsfCommand.quick_register_checkAccount) {
                                            if (this.registerUinHandler != null) {
                                                try {
                                                    if (fromServiceMsg.isSuccess()) {
                                                        i48 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                                    }
                                                } catch (Exception e67) {
                                                    e67.printStackTrace();
                                                }
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("Login_Optimize_MSFMSF.D.RespHandleUtil", 2, "handleRespMsg: fromServiceMsg=" + fromServiceMsg);
                                                }
                                                this.registerUinHandler.onCheckQuickRegisterResp(i48, toServiceMsg, fromServiceMsg);
                                            }
                                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.quick_register_getAccount) {
                                            if (this.registerUinHandler != null) {
                                                try {
                                                } catch (Exception e68) {
                                                    e = e68;
                                                    str = "";
                                                }
                                                if (fromServiceMsg.isSuccess()) {
                                                    i48 = ((Integer) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_RESULTCODE)).intValue();
                                                    str = (String) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_RESP_REGISTER_UIN);
                                                    try {
                                                        str2 = (String) fromServiceMsg.attributes.get(MsfConstants.ATTRIBUTE_REGISTER_CM_MOBILE);
                                                    } catch (Exception e69) {
                                                        e = e69;
                                                        e.printStackTrace();
                                                        str2 = "";
                                                        str8 = str;
                                                        i3 = i48;
                                                        if (QLog.isColorLevel()) {
                                                        }
                                                        this.registerUinHandler.onGetQuickRegisterResp(i3, str8, str2, toServiceMsg, fromServiceMsg);
                                                        z17 = true;
                                                        if (!z17) {
                                                        }
                                                    }
                                                    str8 = str;
                                                    i3 = i48;
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("Login_Optimize_MSFMSF.D.RespHandleUtil", 2, "handleRespMsg: fromServiceMsg=" + fromServiceMsg);
                                                    }
                                                    this.registerUinHandler.onGetQuickRegisterResp(i3, str8, str2, toServiceMsg, fromServiceMsg);
                                                } else {
                                                    i3 = -1;
                                                    str2 = "";
                                                    if (QLog.isColorLevel()) {
                                                    }
                                                    this.registerUinHandler.onGetQuickRegisterResp(i3, str8, str2, toServiceMsg, fromServiceMsg);
                                                }
                                            }
                                        } else if (fromServiceMsg.getMsfCommand() == MsfCommand.getKey && (iAuthHandler = this.authHandler) != null) {
                                            try {
                                                iAuthHandler.onGetKeyResp(toServiceMsg, fromServiceMsg);
                                            } catch (Exception e75) {
                                                e75.printStackTrace();
                                            }
                                        }
                                        if (!z17) {
                                        }
                                    }
                                    z17 = true;
                                    if (!z17) {
                                    }
                                }
                            }
                            z17 = z16;
                            if (!z17) {
                            }
                        }
                        QLog.d(tag, 1, "handle resp msg error " + e16, e16);
                        return true;
                    }
                    z16 = false;
                    z17 = z16;
                    if (!z17) {
                    }
                }
                z16 = false;
                if (this.authHandler != null) {
                    if (fromServiceMsg.isSuccess()) {
                        try {
                            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                            UniPacket uniPacket = new UniPacket(true);
                            uniPacket.setEncodeName("UTF-8");
                            uniPacket.decode(wupBuffer);
                            respondCustomSig = (RespondCustomSig) uniPacket.getByClass(com.tencent.mobileqq.msf.core.auth.e.f247454n, new RespondCustomSig());
                        } catch (Exception e76) {
                            e76.printStackTrace();
                        }
                        this.authHandler.onRecvChangeTokenResp(resultCode, businessFailCode, businessFailMsg, respondCustomSig, toServiceMsg, fromServiceMsg);
                        z17 = true;
                        if (!z17) {
                        }
                    }
                    respondCustomSig = null;
                    this.authHandler.onRecvChangeTokenResp(resultCode, businessFailCode, businessFailMsg, respondCustomSig, toServiceMsg, fromServiceMsg);
                    z17 = true;
                    if (!z17) {
                    }
                }
                z17 = z16;
                if (!z17) {
                }
            }
            z16 = false;
            IAuthHandler iAuthHandler8 = this.authHandler;
            if (iAuthHandler8 != null) {
                iAuthHandler8.onRecvChangeUinLoginResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
                z17 = true;
                if (!z17) {
                }
            }
            z17 = z16;
            if (!z17) {
            }
        }
        z16 = false;
        IAuthHandler iAuthHandler9 = this.authHandler;
        if (iAuthHandler9 != null) {
            iAuthHandler9.onRecvLoginResp(resultCode, businessFailCode, businessFailMsg, toServiceMsg, fromServiceMsg);
            z17 = true;
            if (!z17) {
            }
        }
        z17 = z16;
        if (!z17) {
        }
    }
}
