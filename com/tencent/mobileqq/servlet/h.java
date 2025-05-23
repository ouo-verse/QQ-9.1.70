package com.tencent.mobileqq.servlet;

import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.PushReq;
import KQQ.CheckUpdateResp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.ah;
import com.tencent.mobileqq.config.business.MSFConfigParser;
import com.tencent.mobileqq.graycheck.business.GrayCheckHandler;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.PushExtraInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import mqq.observer.AccountObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f286485d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286485d = false;
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d(FMTSrvAddrProvider.TAG, 2, "RECEIVED PUSH: FMT SERVER ADDR LIST");
        }
        JceInputStream jceInputStream = new JceInputStream(bArr);
        FileStoragePushFSSvcList fileStoragePushFSSvcList = new FileStoragePushFSSvcList();
        fileStoragePushFSSvcList.readFrom(jceInputStream);
        f(fileStoragePushFSSvcList, (QQAppInterface) getAppRuntime());
    }

    private static void b(FileStoragePushFSSvcList fileStoragePushFSSvcList, QQAppInterface qQAppInterface) {
        ArrayList<FileStorageServerListInfo> arrayList;
        if (fileStoragePushFSSvcList != null && (arrayList = fileStoragePushFSSvcList.vUrlEncodeServiceList) != null) {
            Iterator<FileStorageServerListInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FileStorageServerListInfo next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("PushServlet", 2, "info.sip=" + next.sIP + ",info.port=" + next.iPort);
                }
            }
            g(fileStoragePushFSSvcList.vUrlEncodeServiceList);
        }
    }

    private static void c(FileStoragePushFSSvcList fileStoragePushFSSvcList) {
        new cooperation.qqfav.f().a(fileStoragePushFSSvcList);
    }

    private static void d(QQAppInterface qQAppInterface) {
        qQAppInterface.getApp();
        BaseApplication context = BaseApplication.getContext();
        ConfigManager.getInstance(context, qQAppInterface.getHwEngine()).onSrvAddrPush(context, qQAppInterface, FMTSrvAddrProvider.getInstance().getHighwayConfigMap());
    }

    private void e(FromServiceMsg fromServiceMsg) {
        int intValue = ((Integer) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_IP_FAMILY, 0)).intValue();
        QLog.d("PushServlet", 1, "serverIpFamily=" + intValue);
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("mmkv_key_server_ip_address_type", intValue);
    }

    public static void f(FileStoragePushFSSvcList fileStoragePushFSSvcList, QQAppInterface qQAppInterface) {
        fileStoragePushFSSvcList.pttlist = FMTSrvAddrProvider.getInstance().replaceWithTLVForPtt(fileStoragePushFSSvcList.pttlist);
        FMTSrvAddrProvider.getInstance().setSvcList(fileStoragePushFSSvcList);
        b(fileStoragePushFSSvcList, qQAppInterface);
        c(fileStoragePushFSSvcList);
        d(qQAppInterface);
        if (ah.f(fileStoragePushFSSvcList)) {
            com.tencent.mobileqq.nearby.h.b(qQAppInterface).j();
        }
        if (fileStoragePushFSSvcList.vGPicDownLoadList == null && QLog.isColorLevel()) {
            QLog.d(FMTSrvAddrProvider.TAG, 2, "RECEIVED PUSH: vGPicDownLoadList ==null");
        }
    }

    private static void g(ArrayList<FileStorageServerListInfo> arrayList) {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("SosoSrvAddrList", 4);
        if (arrayList != null) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<FileStorageServerListInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FileStorageServerListInfo next = it.next();
                sb5.append(next.sIP);
                sb5.append(":");
                sb5.append(next.iPort);
                sb5.append("|");
            }
            sharedPreferences.edit().putString("SosoSrvAddrList_key", sb5.toString()).commit();
            Intent intent = new Intent("com.tencent.receiver.soso");
            intent.putExtra("com.tencent.receiver.soso.type", com.tencent.mobileqq.troop.soso.b.f298860e);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
        }
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new String[]{BaseConstants.CMD_CONNOPENED, "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PbGetMsg", BaseConstants.CMD_NEW_REGPRXYSVC_PBSYNCMSG, "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullDisGroupSeq", BaseConstants.CMD_REGPRXYSVC_NOTICE_END, "RegPrxySvc.GetBoxFilter", BaseConstants.CMD_CONNCLOSED, BaseConstants.CMD_PUSHREQ, "StatSvc.register", BaseConstants.CMD_CONNALLFAILED, BaseConstants.CMD_RECVFIRSTRESP, BaseConstants.CMD_CONNWEAKNET, BaseConstants.CMD_CONNWEAKNET_NEW, "MultiVideo.s2c", "MultiVideo.c2sack", ProfileContants.CMD_CHECK_UPDATE_REQ, BaseConstants.CMD_NETNEEDSIGNON, BaseConstants.CMD_NOTIFY_QQWIFI_AVAILABLE, "RegPrxySvc.QueryIpwdStat", BaseConstants.CMD_PUSH_DOMAIN, BaseConstants.CMD_WAKE_FROM_DS, "GrayUinPro.Check"};
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        IQQNTWrapperSession k3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        String serviceCmd = fromServiceMsg.getServiceCmd();
        int i3 = 2;
        if (BaseConstants.CMD_CONNOPENED.equals(serviceCmd)) {
            f286485d = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_IS_TEST_ENV, Boolean.FALSE)).booleanValue();
            long longValue = ((Long) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_CONNSEQ, 0L)).longValue();
            if (QLog.isColorLevel()) {
                QLog.d("PushServlet", 2, "onReceive: cmd=" + serviceCmd + ", isTestEnv: " + f286485d + ", connSeq: " + longValue);
            }
            qQAppInterface.onMessageConnect(longValue);
            e(fromServiceMsg);
            return;
        }
        if (BaseConstants.CMD_CONNCLOSED.equals(serviceCmd)) {
            qQAppInterface.onConnClose();
            return;
        }
        if (BaseConstants.CMD_CONNWEAKNET.equals(serviceCmd)) {
            qQAppInterface.onWeakNet();
            return;
        }
        if (BaseConstants.CMD_CONNWEAKNET_NEW.equals(serviceCmd)) {
            qQAppInterface.onWeakNet(fromServiceMsg);
            return;
        }
        if (BaseConstants.CMD_NETNEEDSIGNON.equals(serviceCmd)) {
            qQAppInterface.onNetNeedSignon((String) fromServiceMsg.getAttribute("signonurl"));
            return;
        }
        boolean z17 = false;
        if (BaseConstants.CMD_NOTIFY_QQWIFI_AVAILABLE.equals(serviceCmd)) {
            boolean booleanValue = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.HAS_AVAIL_QQWIFI, Boolean.FALSE)).booleanValue();
            if (QLog.isColorLevel()) {
                QLog.i("PushServlet", 2, "QQWiFi : recv broadcast -" + serviceCmd + "hasAvailWiFi = " + booleanValue);
            }
            BannerManager l3 = BannerManager.l();
            int i16 = QQWifiBannerProcessor.f185264d;
            if (!booleanValue) {
                i3 = 0;
            }
            l3.O(i16, i3, null);
            if (booleanValue) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "QQWIFI", "show_buleNotify", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (BaseConstants.CMD_RECVFIRSTRESP.equals(serviceCmd)) {
            qQAppInterface.onRecvFistResp();
            return;
        }
        if (BaseConstants.CMD_CONNALLFAILED.equals(serviceCmd)) {
            qQAppInterface.onConnAllFailed();
            return;
        }
        if (BaseConstants.CMD_PUSHREQ.equals(serviceCmd)) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            PushReq pushReq = (PushReq) uniPacket.getByClass("PushReq", new PushReq());
            if (pushReq != null && pushReq.type == 2) {
                a(pushReq.jcebuf);
                return;
            }
            return;
        }
        if (BaseConstants.CMD_PUSH_DOMAIN.equals(serviceCmd)) {
            InnerDns.getInstance().onReceiveFromServer(fromServiceMsg, true);
            return;
        }
        if ("StatSvc.register".equals(fromServiceMsg.getServiceCmd())) {
            SvcRespRegister svcRespRegister = (SvcRespRegister) decodePacket(fromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
            if (svcRespRegister != null && svcRespRegister.cReplyCode == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.CONTACTS, 2, "PushServlet.onReceive " + svcRespRegister.timeStamp + ", bUpdateFlag: " + ((int) svcRespRegister.bUpdateFlag) + ", bLargeSeqUpdate: " + ((int) svcRespRegister.bLargeSeqUpdate) + ", iStatus: " + svcRespRegister.iStatus);
                }
                long j3 = svcRespRegister.timeStamp;
                if (j3 == 0) {
                    j3 = qQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
                }
                if (j3 == 0 || svcRespRegister.bUpdateFlag == 1 || svcRespRegister.bLargeSeqUpdate == 1) {
                    Automator automator = qQAppInterface.mAutomator;
                    if (j3 != 0 && svcRespRegister.bUpdateFlag != 1) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    long j16 = svcRespRegister.timeStamp;
                    if (svcRespRegister.bLargeSeqUpdate == 1) {
                        z17 = true;
                    }
                    automator.K2(z16, j16, z17);
                }
                AppRuntime.Status build = AppRuntime.Status.build(svcRespRegister.iStatus);
                long j17 = svcRespRegister.uExtOnlineStatus;
                if (build != null) {
                    IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) qQAppInterface.getRuntimeService(IOnlineStatusService.class);
                    iOnlineStatusService.setOnlineStatus(build, "SvcRespRegister");
                    iOnlineStatusService.setExtOnlineStatus(j17);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("onlineStatus", build);
                    bundle.putLong("extOnlineStatus", j17);
                    qQAppInterface.notifyObservers(AccountObserver.class, Constants.Action.ACTION_ONLINE_STATUS_PUSH, true, bundle);
                    return;
                }
                QLog.d(LogTag.CONTACTS, 1, "PushServlet.onReceive onlineStatus is null!");
                return;
            }
            return;
        }
        if (!"MultiVideo.s2c".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && !"MultiVideo.c2sack".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (ProfileContants.CMD_CHECK_UPDATE_REQ.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                if (QLog.isColorLevel()) {
                    QLog.d("PushServlet", 2, "push command:" + fromServiceMsg.getServiceCmd() + " ssoseq:" + fromServiceMsg.getRequestSsoSeq());
                }
                if (fromServiceMsg.getRequestSsoSeq() > 0) {
                    return;
                }
                UniPacket uniPacket2 = new UniPacket(true);
                try {
                    uniPacket2.setEncodeName("utf-8");
                    uniPacket2.decode(fromServiceMsg.getWupBuffer());
                } catch (RuntimeException | Exception unused) {
                }
                ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).handleCheckUpdate((CheckUpdateResp) uniPacket2.getByClass("CheckUpdateResp", new CheckUpdateResp()));
                return;
            }
            if (TextUtils.equals(BaseConstants.CMD_WAKE_FROM_DS, serviceCmd)) {
                QLog.d("PushServlet", 1, "onReceive: cmd = ", serviceCmd, ", manager = ", Boolean.valueOf(MSFConfigParser.d()));
                if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && MSFConfigParser.d()) {
                    qQAppInterface.getMsgHandler().e5((((int) (System.currentTimeMillis() / 1000)) << 32) | Math.abs(new Random().nextInt()), false, true, false);
                    if (com.tencent.mobileqq.service.message.j.a(qQAppInterface, 1000)) {
                        QQBeaconReport.report("load_msg_from_deep_sleep");
                        return;
                    }
                    return;
                }
                return;
            }
            if (!"MsgPush.PushGroupProMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && !"trpc.group_pro.synclogic.SyncLogic.PushFirstView".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && !"trpc.group_pro.synclogic.SyncLogic.PushChannelMsg".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                if ("GrayUinPro.Check".equals(fromServiceMsg.getServiceCmd())) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PushServlet", 2, "onGrayCheckFailed");
                    }
                    GrayCheckHandler grayCheckHandler = (GrayCheckHandler) qQAppInterface.getBusinessHandler(GrayCheckHandler.class.getName());
                    if (grayCheckHandler != null) {
                        grayCheckHandler.F2(fromServiceMsg);
                        return;
                    }
                    return;
                }
                if ((BaseConstants.CMD_NT_REGPRXYSVC_PUSH_PARAMS.equalsIgnoreCase(fromServiceMsg.getServiceCmd()) || BaseConstants.CMD_NT_REGPRXYSVC_PUSH_INFOSYNC.equalsIgnoreCase(fromServiceMsg.getServiceCmd()) || BaseConstants.CMD_NT_REGPRXYSVC_PUSH_GROUP_MSG.equalsIgnoreCase(fromServiceMsg.getServiceCmd()) || BaseConstants.CMD_NT_REGPRXYSVC_PUSH_C2C_MSG.equalsIgnoreCase(fromServiceMsg.getServiceCmd()) || BaseConstants.CMD_TRPC_MSG_PUSH.equalsIgnoreCase(fromServiceMsg.getServiceCmd()) || BaseConstants.CMD_OFFLINE_PUSH.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) && (k3 = com.tencent.qqnt.msg.f.k()) != null) {
                    PushExtraInfo pushExtraInfo = new PushExtraInfo();
                    for (Map.Entry<String, byte[]> entry : fromServiceMsg.getTransInfo().entrySet()) {
                        pushExtraInfo.getTransInfoMap().put(entry.getKey(), entry.getValue());
                    }
                    k3.onMsfPush(fromServiceMsg.getServiceCmd(), com.tencent.qqnt.kernel.msf.a.a(fromServiceMsg.getWupBuffer(), fromServiceMsg.getServiceCmd()), pushExtraInfo);
                    return;
                }
                return;
            }
            IQQNTWrapperSession k16 = com.tencent.qqnt.msg.f.k();
            if (k16 != null) {
                PushExtraInfo pushExtraInfo2 = new PushExtraInfo();
                for (Map.Entry<String, byte[]> entry2 : fromServiceMsg.getTransInfo().entrySet()) {
                    pushExtraInfo2.getTransInfoMap().put(entry2.getKey(), entry2.getValue());
                }
                k16.onMsfPush(fromServiceMsg.getServiceCmd(), com.tencent.qqnt.kernel.msf.a.a(fromServiceMsg.getWupBuffer(), fromServiceMsg.getServiceCmd()), pushExtraInfo2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("dimontang", 2, String.format("RECEIVED PUSH: MULTI VIDEO S2C, SsoSeq[%s], AppSeq[%s]", Integer.valueOf(fromServiceMsg.getRequestSsoSeq()), Integer.valueOf(fromServiceMsg.getAppSeq())));
        }
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        ((QQAppInterface) getAppRuntime()).receiveToService(toServiceMsg, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
        }
    }
}
