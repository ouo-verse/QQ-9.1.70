package com.tencent.qav.channel;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.utils.ax;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import cooperation.qzone.util.WnsNetworkConst;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import trpc.qq_av.av_appsvr.GroupInvite$GroupInviteMsgBody;
import trpc.qq_av.av_appsvr.PushOnline$PushOnlineMsg;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected AppRuntime f342366d;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(FromServiceMsg fromServiceMsg) {
        ArrayList<MsgInfo> arrayList;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("VideoChannelServlet", 2, "handleMultiS2CPush");
        }
        SvcReqPushMsg svcReqPushMsg = (SvcReqPushMsg) Packet.decodePacket(fromServiceMsg.getWupBuffer(), "req", new SvcReqPushMsg());
        if (svcReqPushMsg == null) {
            arrayList = null;
        } else {
            arrayList = svcReqPushMsg.vMsgInfos;
        }
        if (arrayList != null && arrayList.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.i("VideoChannelServlet", 2, "handleMultiS2CPush doesn't has msgInfoList return");
                return;
            }
            return;
        }
        Iterator<MsgInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgInfo next = it.next();
            if (528 == next.shMsgType) {
                MsgType0x210 G = com.tencent.imcore.message.g.G(next.vMsg);
                if (G != null) {
                    long j3 = G.uSubMsgType;
                    if (j3 == 329 || j3 == 332) {
                        if (QLog.isColorLevel()) {
                            QLog.i("VideoChannelServlet", 2, "handleMultiS2CPush successfully");
                        }
                        long j16 = G.uSubMsgType;
                        if (j16 == 329) {
                            GroupInvite$GroupInviteMsgBody groupInvite$GroupInviteMsgBody = new GroupInvite$GroupInviteMsgBody();
                            try {
                                groupInvite$GroupInviteMsgBody.mergeFrom(G.vProtobuf);
                                long j17 = groupInvite$GroupInviteMsgBody.video_msg_type.get();
                                if (QLog.isColorLevel()) {
                                    QLog.i("VideoChannelServlet", 2, "handleMultiS2CPush 0x149 video_msg_type.has() : " + groupInvite$GroupInviteMsgBody.video_msg_type.has() + " video_msg_type:" + groupInvite$GroupInviteMsgBody.video_msg_type.get());
                                }
                                h((int) j17, 768, G.vProtobuf);
                            } catch (InvalidProtocolBufferMicroException unused) {
                                QLog.e("VideoChannelServlet", 1, "handleMultiS2CPush subType 0x149 parse failed");
                            }
                        } else if (j16 == 332) {
                            try {
                                PushOnline$PushOnlineMsg pushOnline$PushOnlineMsg = new PushOnline$PushOnlineMsg();
                                pushOnline$PushOnlineMsg.mergeFrom(G.vProtobuf);
                                if (QLog.isColorLevel()) {
                                    QLog.i("VideoChannelServlet", 2, "handleMultiS2CPush 0x14c video_msg_type.has() : " + pushOnline$PushOnlineMsg.video_msg_type.has() + " video_msg_type:" + pushOnline$PushOnlineMsg.video_msg_type.get());
                                }
                                h(pushOnline$PushOnlineMsg.video_msg_type.get(), 769, G.vProtobuf);
                            } catch (InvalidProtocolBufferMicroException unused2) {
                                QLog.e("VideoChannelServlet", 1, "handleMultiS2CPush subType 0x14c parse failed");
                            }
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("VideoChannelServlet", 2, "handleMultiS2CPush shouldn't handle this push");
                }
            }
        }
    }

    private void b(String str, int i3) {
        c.z().f(str, i3);
    }

    private void c(byte[] bArr) {
        c.z().g(bArr);
    }

    private void d(byte[] bArr) {
        c.z().h(bArr);
    }

    private void e(byte[] bArr) {
        com.tencent.qav.log.a.a("VideoChannelServlet", "receiveOpenImAck");
        c.z().i(bArr);
    }

    private void f(int i3, byte[] bArr) {
        c.z().j(i3, bArr);
    }

    private void g(FromServiceMsg fromServiceMsg, int i3) {
        if (fromServiceMsg.isSuccess()) {
            f(i3, fh.a(fromServiceMsg.getWupBuffer()));
            return;
        }
        com.tencent.qav.log.a.b("VideoChannelServlet", String.format("cmd: " + i3 + " failed", Integer.valueOf(fromServiceMsg.getResultCode())));
    }

    private void h(int i3, int i16, byte[] bArr) {
        QLog.i("VideoChannelServlet", 2, "receiveSSOMultiVideoMsg type: " + i3 + " cmd: " + i16);
        c.z().k(i3, i16, bArr);
    }

    private void i(byte[] bArr) {
        c.z().l(bArr);
    }

    private void j(byte[] bArr) {
        c.z().m(bArr);
    }

    private void k(byte[] bArr) {
        c.z().n(bArr);
    }

    private void l(Intent intent, Bundle bundle) {
        int i3 = bundle.getInt("app_id");
        ToServiceMsg gatewayIpMsg = MsfMsgUtil.getGatewayIpMsg(null);
        gatewayIpMsg.setTimeout(30000L);
        gatewayIpMsg.setNeedCallback(true);
        gatewayIpMsg.setNeedRemindSlowNetwork(false);
        gatewayIpMsg.setAppId(i3);
        sendToMSF(intent, gatewayIpMsg);
    }

    private void m(Intent intent, Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, this.f342366d.getAccount(), "VideoCCSvc.Adaptation");
        toServiceMsg.putWupBuffer(byteArray);
        toServiceMsg.setTimeout(10000L);
        sendToMSF(intent, toServiceMsg);
    }

    private void n(Intent intent, Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, String.valueOf(bundle.getLong("uin")), BaseConstants.CMD_REPORTSTAT);
        toServiceMsg.putWupBuffer(byteArray);
        toServiceMsg.setNeedCallback(false);
        sendToMSF(intent, toServiceMsg);
    }

    private void o(Intent intent, Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, this.f342366d.getAccount(), "MultiVideo.s2cack");
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.putWupBuffer(byteArray);
        sendToMSF(intent, toServiceMsg);
    }

    private void p(Intent intent, Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, this.f342366d.getAccount(), "MultiVideo.c2s");
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.putWupBuffer(byteArray);
        sendToMSF(intent, toServiceMsg);
    }

    private void q(Bundle bundle, Packet packet) {
        String string = bundle.getString("sso_cmd");
        packet.setServantName(string);
        packet.setFuncName(string);
        packet.setSSOCommand(string);
        packet.setTimeout(10000L);
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        if (byteArray != null) {
            packet.putSendData(fh.b(byteArray));
        }
        com.tencent.qav.log.a.a("VideoChannelServlet", "sendSSOMultiVideoMsg ssoCmd:= " + string);
    }

    private void r(Intent intent, Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, this.f342366d.getAccount(), "SharpSvr.s2cack");
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.putWupBuffer(byteArray);
        sendToMSF(intent, toServiceMsg);
    }

    private void s(Intent intent, Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        ToServiceMsg toServiceMsg = new ToServiceMsg(null, this.f342366d.getAccount(), "SharpSvr.c2s");
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.putWupBuffer(byteArray);
        sendToMSF(intent, toServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new String[]{"SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c", MiniConst.Spark.CMD_PUSH_SPARK_REWARD, "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCreateRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoEnterRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoInviteRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoQueryRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoDeleteUser", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoMultiTerminalSync", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS", "trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap", "trpc.qqrtc.open_utils.OpenUtils.SsoGetSign", "videohubRelay2OpenSSO.openim.pbvideoapp"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            this.f342366d = getAppRuntime();
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg == null) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        com.tencent.qav.log.a.a("VideoChannelServlet", String.format("onReceive cmd=%s", serviceCmd));
        if ("SharpSvr.s2c".equalsIgnoreCase(serviceCmd)) {
            if (!ax.d()) {
                j(fromServiceMsg.getWupBuffer());
                return;
            }
            return;
        }
        if ("videohubRelay2OpenSSO.openim.pbvideoapp".equalsIgnoreCase(serviceCmd)) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            com.tencent.qav.log.a.a("VideoChannelServlet", "onReceive cmd=" + serviceCmd + " wupBuffer buffer_len=" + wupBuffer.length);
            byte[] a16 = fh.a(wupBuffer);
            com.tencent.qav.log.a.a("VideoChannelServlet", "onReceive cmd=" + serviceCmd + " remove wup head bytes buffer_len=" + a16.length);
            e(a16);
            return;
        }
        if ("SharpSvr.c2sack".equalsIgnoreCase(serviceCmd)) {
            i(fromServiceMsg.getWupBuffer());
            return;
        }
        if ("MultiVideo.s2c".equalsIgnoreCase(serviceCmd)) {
            d(fromServiceMsg.getWupBuffer());
            return;
        }
        if ("MultiVideo.c2sack".equalsIgnoreCase(serviceCmd)) {
            c(fromServiceMsg.getWupBuffer());
            return;
        }
        if (BaseConstants.CMD_GETGATEWAYIP.equalsIgnoreCase(serviceCmd)) {
            String str = (String) fromServiceMsg.getAttribute(BaseConstants.CMD_GETGATEWAYIP);
            if (str != null) {
                com.tencent.qav.log.a.a("VideoChannelServlet", String.format(">>> ip=%s", str));
                b(str, 0);
                return;
            }
            return;
        }
        if ("VideoCCSvc.Adaptation".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                k(fromServiceMsg.getWupBuffer());
                return;
            } else {
                com.tencent.qav.log.a.b("VideoChannelServlet", String.format("onReceive get config fail, resultCode=%s", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCreateRoom".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, 512);
            return;
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoEnterRoom".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, 513);
            return;
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoInviteRoom".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, 514);
            return;
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoMultiTerminalSync".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, 517);
            return;
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, WnsNetworkConst.WRITE_FAIL);
            return;
        }
        if ("trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, WnsNetworkConst.NETWORK_DISABLE);
            return;
        }
        if ("trpc.qqrtc.open_utils.OpenUtils.SsoGetSign".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
            return;
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoQueryRoom".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, 515);
            return;
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoDeleteUser".equalsIgnoreCase(serviceCmd)) {
            g(fromServiceMsg, 516);
        } else {
            if (MiniConst.Spark.CMD_PUSH_SPARK_REWARD.equals(serviceCmd)) {
                if (ax.d()) {
                    a(fromServiceMsg);
                    return;
                }
                return;
            }
            com.tencent.qav.log.a.g("VideoChannelServlet", "onReceive handle not process cmd.");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        int i3 = extras.getInt(AppConstants.Key.SHARE_REQ_TYPE, -1);
        com.tencent.qav.log.a.a("VideoChannelServlet", String.format("onSend reqType=%s", Integer.valueOf(i3)));
        if (i3 != 100) {
            switch (i3) {
                case 1:
                    s(intent, extras);
                    return;
                case 2:
                    r(intent, extras);
                    return;
                case 3:
                    p(intent, extras);
                    return;
                case 4:
                    o(intent, extras);
                    return;
                case 5:
                    l(intent, extras);
                    return;
                case 6:
                    m(intent, extras);
                    return;
                case 7:
                    n(intent, extras);
                    return;
                default:
                    com.tencent.qav.log.a.g("VideoChannelServlet", "onSend handle not define reqType.");
                    return;
            }
        }
        q(extras, packet);
    }
}
