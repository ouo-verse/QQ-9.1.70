package com.tencent.av;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avsdkconfig.pb.CommonConfig$Ability;
import com.tencent.av.avsdkconfig.pb.CommonConfig$CertainAbility;
import com.tencent.av.avsdkconfig.pb.CommonConfig$CodecConfigRsp;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.s;
import com.tencent.av.utils.ae;
import com.tencent.av.utils.af;
import com.tencent.av.utils.ag;
import com.tencent.av.utils.at;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import cooperation.qzone.util.WnsNetworkConst;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.longconn.hd_video$MsgBody;
import tencent.im.cs.longconn.hd_video$RspBody;
import tencent.im.cs.longconn.hd_video$VideoHead;
import tencent.im.oidb.cmd0x625.Oidb_0x625$Open2Tiny_ReqBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625$Open2Tiny_RspBody;
import tencent.im.oidb.cmd0x625.Oidb_0x625$OpenIDInfoReq;
import tencent.im.oidb.cmd0x625.Oidb_0x625$TinyIDInfoRsp;
import tencent.im.oidb.cmd0x626.Oidb_0x626$OpenIDInfoRsp;
import tencent.im.oidb.cmd0x626.Oidb_0x626$Tiny2Open_RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02$ReqBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02$RspBody;
import tencent.im.oidb.cmd0xa02.cmd0xa02$TinyID;
import tencent.im.oidb.cmd0xa02.cmd0xa02$TinyID2UserAccInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x158.SubMsgType0x158$SharpVideoMsg;

/* compiled from: P */
/* loaded from: classes3.dex */
public class t extends MSFServlet {

    /* renamed from: d, reason: collision with root package name */
    private VideoAppInterface f74639d;

    /* renamed from: e, reason: collision with root package name */
    private final List<f> f74640e;

    public t() {
        ArrayList arrayList = new ArrayList(2);
        this.f74640e = arrayList;
        arrayList.add(new g());
    }

    public static void A(VideoAppInterface videoAppInterface, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            NewIntent newIntent = new NewIntent(videoAppInterface.getApplicationContext(), t.class);
            newIntent.putExtra("reqType", 100);
            newIntent.putExtra("sso_cmd", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoS2CInviteOfflineAck");
            newIntent.putExtra("wup_buffer", bArr);
            videoAppInterface.startServlet(newIntent);
            return;
        }
        QLog.d("VideoServlet", 2, "sendOfflinePushSharpAck, videoMsg content null");
    }

    private void B(Packet packet, Bundle bundle) {
        String string = bundle.getString("sso_cmd");
        String string2 = bundle.getString("traceId");
        if (!TextUtils.isEmpty(string2) && "trpc.qqrtc.av_appsvr.AvAppsvr.SsoCreateRoom".equals(string)) {
            packet.setTraceInfo(string2);
        }
        packet.setServantName(string);
        packet.setFuncName(string);
        packet.setSSOCommand(string);
        packet.setTimeout(10000L);
        byte[] byteArray = bundle.getByteArray("wup_buffer");
        if (byteArray != null) {
            packet.putSendData(fh.b(byteArray));
        }
        AVCoreLog.d("VideoServlet", "sendSSOMultiVideoMsg ssoCmd:= " + string);
    }

    private void C(String str, SubMsgType0x158$SharpVideoMsg subMsgType0x158$SharpVideoMsg) {
        if (subMsgType0x158$SharpVideoMsg != null && subMsgType0x158$SharpVideoMsg.video_buff.get() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "sendSharpVideoAckV2, seq: " + subMsgType0x158$SharpVideoMsg.msg_seq.get() + ", videoMsg.type:" + subMsgType0x158$SharpVideoMsg.type.get() + ", videoMsg.to_uin.size:" + subMsgType0x158$SharpVideoMsg.rpt_to_uin.get().size() + ", videoMsg,video_buff" + Arrays.toString(subMsgType0x158$SharpVideoMsg.video_buff.get().toByteArray()));
            }
            NewIntent newIntent = new NewIntent(this.f74639d.getApplication(), t.class);
            newIntent.putExtra("reqType", 100);
            newIntent.putExtra("sso_cmd", str);
            newIntent.putExtra("wup_buffer", subMsgType0x158$SharpVideoMsg.video_buff.get().toByteArray());
            service(newIntent);
            return;
        }
        QLog.d("VideoServlet", 2, "sendSharpVideoAckV2, videoMsg content null");
    }

    private void D(byte[] bArr, String str) {
        QLog.w("VideoServlet", 1, "showNotification() enter");
        if (bArr == null) {
            QLog.w("VideoServlet", 1, "showNotification() return ! video_buff = null");
            return;
        }
        s.a f16 = s.f(bArr);
        if (f16 != null && f16.a()) {
            ag.h("VideoServlet", n.b(3, String.valueOf(f16.f74247h), new int[0]), this.f74639d, f16, str);
        } else {
            QLog.w("VideoServlet", 1, "showNotification() return ! videoPacket == null && videoPacket is not isRequestMsg");
        }
    }

    private long a(String str) {
        long g16;
        if (str == null) {
            return 0L;
        }
        if (str.length() > 0) {
            try {
                g16 = com.tencent.av.utils.i.g(str);
                if (g16 < 10000) {
                    return 0L;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return g16;
    }

    public static SubMsgType0x158$SharpVideoMsg b(FromServiceMsg fromServiceMsg) {
        ArrayList<MsgInfo> arrayList;
        boolean z16;
        MsgType0x210 G;
        try {
            if (QLog.isDevelopLevel()) {
                QLog.i("VideoServlet", 2, "decodeS2CV2Packet buffer: " + Arrays.toString(fromServiceMsg.getWupBuffer()));
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
                QLog.w("VideoServlet", 1, "decodeS2CV2Packet doesn't has msgInfoList return");
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            long j3 = svcReqPushMsg.lUin;
            int i3 = svcReqPushMsg.svrip;
            Iterator<MsgInfo> it = arrayList.iterator();
            SubMsgType0x158$SharpVideoMsg subMsgType0x158$SharpVideoMsg = null;
            while (it.hasNext()) {
                MsgInfo next = it.next();
                if (528 == next.shMsgType && (G = com.tencent.imcore.message.g.G(next.vMsg)) != null && G.uSubMsgType == 344) {
                    subMsgType0x158$SharpVideoMsg = new SubMsgType0x158$SharpVideoMsg();
                    subMsgType0x158$SharpVideoMsg.mergeFrom(G.vProtobuf);
                    DelMsgInfo delMsgInfo = new DelMsgInfo();
                    delMsgInfo.lFromUin = next.lFromUin;
                    delMsgInfo.shMsgSeq = next.shMsgSeq;
                    delMsgInfo.uMsgTime = next.uMsgTime;
                    delMsgInfo.vMsgCookies = next.vMsgCookies;
                    arrayList2.add(delMsgInfo);
                }
            }
            x(j3, arrayList2, i3, fromServiceMsg.getRequestSsoSeq());
            if (subMsgType0x158$SharpVideoMsg == null) {
                QLog.e("VideoServlet", 1, "decodeS2CV2Packet failed.");
            }
            return subMsgType0x158$SharpVideoMsg;
        } catch (Exception e16) {
            QLog.e("VideoServlet", 1, "decodeS2CV2Packet decode exception: " + e16);
            return null;
        }
    }

    private boolean c(String str, FromServiceMsg fromServiceMsg) {
        long j3;
        int i3;
        SessionInfo f16;
        if (!m(str)) {
            return false;
        }
        if (!fromServiceMsg.isSuccess()) {
            QLog.i("VideoServlet", 1, "dispatchAndDealDavSSOCmd response fail cmd:=" + str);
            return false;
        }
        byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
        hd_video$RspBody f17 = f(a16);
        if (f17 != null && f17.msg_video_head.has()) {
            i3 = f17.msg_video_head.int32_sub_service_type.get();
            j3 = f17.msg_video_head.uint64_room_id.get();
        } else {
            j3 = 0;
            i3 = 0;
        }
        QLog.w("VideoServlet", 1, "dispatchAndDealDavSSOCmd onReceive[c2s ack], seq[" + str + "], serviceType[" + i3 + "], roomId[" + j3 + "]");
        if (i3 == 1013) {
            return false;
        }
        if ("trpc.qqrtc.av_appsvr.AvAppsvr.SsoCreateRoom".equalsIgnoreCase(str) && (f16 = n.e().f()) != null) {
            f16.d(j3);
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "avideo onReceive set sessioninfo roomid ,id = " + j3);
            }
            ((VideoNodeReporter) this.f74639d.B(4)).B(j3);
        }
        try {
            QLog.w("VideoServlet", 1, "<-- dispatchAndDealDavSSOCmd onReceive() cmd = " + str + ", bodyType = " + s.f(a16).f74243d);
        } catch (Exception unused) {
            QLog.i("VideoServlet", 1, "VideoPackageUtils.parse failed");
        }
        j(a16);
        return true;
    }

    private int d() {
        if (AudioUtil.g() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "phone ring mode is slient");
                return 1;
            }
            return 1;
        }
        return 0;
    }

    private void e(Packet packet, Bundle bundle) {
        com.tencent.av.utils.e.m("inviteMember_msg", bundle);
        packet.setServantName("MultiVideo");
        packet.setFuncName("MultiVideoMsg");
        packet.setSSOCommand("QQRTCSvc.group_video_invite_list");
        packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
        long j3 = bundle.getLong("groupuin");
        long j16 = bundle.getLong("groupcode");
        ReqGroupVideo$ReqGetInvitedMemberList reqGroupVideo$ReqGetInvitedMemberList = new ReqGroupVideo$ReqGetInvitedMemberList();
        reqGroupVideo$ReqGetInvitedMemberList.uint64_group.set(j3);
        reqGroupVideo$ReqGetInvitedMemberList.uint64_room_id.set(j16);
        QLog.d("VideoServlet", 1, "getInvitedMemberList [uint64_group=" + j3 + "] [uint64_room_id=" + j16 + "] ", new Throwable("\u6253\u5370\u5806\u6808"));
        packet.putSendData(fh.b(reqGroupVideo$ReqGetInvitedMemberList.toByteArray()));
    }

    private static hd_video$RspBody f(byte[] bArr) {
        int i3;
        hd_video$RspBody hd_video_rspbody = new hd_video$RspBody();
        if (bArr != null) {
            try {
                hd_video_rspbody = hd_video_rspbody.mergeFrom(bArr);
                if (hd_video_rspbody.msg_video_head.has()) {
                    hd_video$VideoHead hd_video_videohead = hd_video_rspbody.msg_video_head.get();
                    int i16 = hd_video_videohead.enum_body_type.get();
                    long j3 = hd_video_videohead.uint64_uin.get();
                    if (hd_video_videohead.int32_sub_service_type.has()) {
                        i3 = hd_video_videohead.int32_sub_service_type.get();
                    } else {
                        i3 = -1;
                    }
                    int i17 = hd_video_videohead.uint32_seq.get();
                    long j16 = hd_video_videohead.uint64_room_id.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, " video-process bodyType=" + i16 + ", subServiceType=" + i3 + ", uin=" + j3 + ", seq=" + i17 + ", roomId=" + j16);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("VideoServlet", 2, " video-process head not exist");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("VideoServlet", 2, " video-process invalid format:" + e16.toString());
                    return null;
                }
                return null;
            }
        }
        return hd_video_rspbody;
    }

    private void h(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        ((VideoAppInterface) getAppRuntime()).receiveToService(toServiceMsg, fromServiceMsg);
    }

    private boolean k(FromServiceMsg fromServiceMsg, String str, byte[] bArr, long j3, long j16, long j17, long j18, long j19, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        long[] t16 = t(bArr, "SharpSvr.s2c", "--video--");
        int i3 = (int) t16[0];
        QLog.w("VideoServlet", 1, "avideo onReceive[CMD_SHARPVIDEO_S2C] seq[" + j18 + "], msg_type[" + j3 + "], type[" + j17 + "], serviceType[" + i3 + "], roomId[" + t16[1] + "], traceId[" + str2 + "]|" + currentTimeMillis);
        if (i3 == 1013) {
            return true;
        }
        if (j3 == 3) {
            u.e("Video:Servlet", 5000L);
            D(bArr, str2);
            r.h0().P3(209, String.valueOf(j16));
            r.h0().P3(200, String.valueOf(j16));
            if (r.h0().M() == 0) {
                r.h0().P3(205, String.valueOf(j16));
            } else {
                r.h0().P3(204, String.valueOf(j16));
            }
            this.f74639d.n(j16, j18 + "-" + j19, com.tencent.mobileqq.service.message.e.K0());
            VideoAppInterface videoAppInterface = this.f74639d;
            if (videoAppInterface.F) {
                videoAppInterface.F = false;
            }
            videoAppInterface.G = true;
            RtcNodeReportReceiverHelper.y(str2, videoAppInterface.getCurrentAccountUin(), String.valueOf(j16), true, 0L);
            RtcNodeReportReceiverHelper.w(str2, 3);
            RtcNodeReportReceiverHelper.x(str2);
            Object attribute = fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF);
            if (attribute != null) {
                r.h0().Z2(String.valueOf(j16), ((Long) attribute).longValue());
            }
        }
        try {
            QLog.w("tagSharpSvr", 1, "<-- onReceive() cmd = " + str + " , msg_type = " + j3 + ", bodyType = " + s.f(bArr).f74243d);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    private void l(FromServiceMsg fromServiceMsg, String str) {
        String str2;
        int i3;
        t tVar;
        long j3;
        Object obj;
        if (af.H()) {
            return;
        }
        try {
            SubMsgType0x158$SharpVideoMsg b16 = b(fromServiceMsg);
            if (b16 != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("VideoServlet", 2, "handleSharpVideoS2CV2 sharpVideoMsg != null");
                }
                String str3 = b16.trace_info.trace_id.get();
                if (TextUtils.isEmpty(str3)) {
                    QLog.e("VideoServlet", 1, "handleSharpVideoS2CV2 empty traceId");
                }
                try {
                    if (k(fromServiceMsg, str, b16.video_buff.get().toByteArray(), b16.msg_type.get(), b16.from_uin.get(), b16.type.get(), b16.msg_seq.get(), b16.msg_uid.get(), str3)) {
                        return;
                    }
                    if (b16.msg_type.get() == 3) {
                        str2 = "VideoServlet";
                        i3 = 1;
                        try {
                            QLog.i(str2, 1, "handleSharpVideoS2CV2 receive invite and send ack");
                            tVar = this;
                            try {
                                tVar.C("trpc.qqrtc.av_appsvr.AvAppsvr.SsoS2CInviteAck", b16);
                            } catch (Exception e16) {
                                e = e16;
                                QLog.e(str2, i3, "handleSharpVideoS2CV2 exception: " + e);
                                return;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            QLog.e(str2, i3, "handleSharpVideoS2CV2 exception: " + e);
                            return;
                        }
                    } else {
                        tVar = this;
                        str2 = "VideoServlet";
                        i3 = 1;
                    }
                    if (!zv.b.a().f453493c && zv.b.a().f453491b != i3 && fromServiceMsg.getAttributes() != null && (obj = fromServiceMsg.getAttributes().get(BaseConstants.TIMESTAMP_NET2MSF_BOOT)) != null) {
                        zv.b.a().f453520t = ((Long) obj).longValue();
                    }
                    VideoAppInterface videoAppInterface = tVar.f74639d;
                    if (videoAppInterface != null) {
                        j3 = videoAppInterface.getLongAccountUin();
                    } else {
                        j3 = 0;
                    }
                    if (b16.rpt_to_uin.get() != null && b16.rpt_to_uin.get().size() > 0) {
                        j3 = b16.rpt_to_uin.get().get(0).longValue();
                    }
                    i(b16.video_buff.get().toByteArray(), b16.from_uin.get(), j3, b16.msg_time.get());
                } catch (Exception e18) {
                    e = e18;
                    str2 = "VideoServlet";
                    i3 = 1;
                }
            }
        } catch (Exception e19) {
            e = e19;
            str2 = "VideoServlet";
            i3 = 1;
        }
    }

    private static boolean m(String str) {
        if (!"trpc.qqrtc.av_appsvr.AvAppsvr.SsoCreateRoom".equalsIgnoreCase(str) && !"trpc.qqrtc.av_appsvr.AvAppsvr.SsoInviteUser".equalsIgnoreCase(str) && !"trpc.qqrtc.av_appsvr.AvAppsvr.SsoRefuseInvite".equalsIgnoreCase(str) && !"trpc.qqrtc.av_appsvr.AvAppsvr.SsoIgnoreInvite".equalsIgnoreCase(str) && !"trpc.qqrtc.av_appsvr.AvAppsvr.SsoQueryInfo".equalsIgnoreCase(str) && !"trpc.qqrtc.av_appsvr.AvAppsvr.SsoAcceptInvite".equalsIgnoreCase(str) && !"trpc.qqrtc.av_appsvr.SharpQuality.SsoSdkInfoReport".equalsIgnoreCase(str) && !"trpc.qqrtc.av_appsvr.AvAppsvr.SsoLogOut".equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    private void q(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        long j3;
        com.tencent.av.utils.e.m("onRspGroupVideoInviteMemberMsgMsg", intent.getExtras());
        int length = fromServiceMsg.getWupBuffer().length - 4;
        byte[] bArr = new byte[length];
        PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        try {
            ReqGroupVideo$RspGetInvitedMemberList reqGroupVideo$RspGetInvitedMemberList = new ReqGroupVideo$RspGetInvitedMemberList();
            reqGroupVideo$RspGetInvitedMemberList.mergeFrom(bArr);
            common$ErrorInfo common_errorinfo = reqGroupVideo$RspGetInvitedMemberList.result.get();
            int F2 = MessageHandler.F2(common_errorinfo);
            if (common_errorinfo.bytes_errmsg.has()) {
                str = common_errorinfo.bytes_errmsg.get().toStringUtf8();
            } else {
                str = "";
            }
            long j16 = reqGroupVideo$RspGetInvitedMemberList.uint64_group.get();
            long j17 = reqGroupVideo$RspGetInvitedMemberList.uint64_room_id.get();
            ArrayList<com.tencent.av.gaudio.a> arrayList = new ArrayList<>();
            if (reqGroupVideo$RspGetInvitedMemberList.rpt_member_list.has()) {
                int i3 = 0;
                while (i3 < reqGroupVideo$RspGetInvitedMemberList.rpt_member_list.size()) {
                    arrayList.add(new com.tencent.av.gaudio.a(reqGroupVideo$RspGetInvitedMemberList.rpt_member_list.get(i3).get().uint64_member_uin.get(), r8.uint32_invite_timestamp.get()));
                    i3++;
                    F2 = F2;
                }
            }
            int i16 = F2;
            boolean booleanExtra = intent.getBooleanExtra("requestInviteMemberMode", true);
            try {
                VideoAppInterface videoAppInterface = this.f74639d;
                if (videoAppInterface instanceof VideoAppInterface) {
                    if (!booleanExtra) {
                        j3 = j17;
                        r.h0().q2(j16, j17, arrayList);
                    } else {
                        j3 = j17;
                        videoAppInterface.k0(new Object[]{Integer.valueOf(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES), Long.valueOf(j16), Long.valueOf(j3), arrayList});
                    }
                } else {
                    j3 = j17;
                    videoAppInterface.k0(new Object[]{Integer.valueOf(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK), Long.valueOf(j16), Long.valueOf(j3), arrayList});
                }
                QLog.w("VideoServlet", 1, "onRspGroupVideoInviteMemberMsgMsg, uint32_errcode[" + i16 + "], bytes_errmsg[" + str + "]groupID=" + j16 + ",uint64_roomId=" + j3 + ",single = " + booleanExtra + ",inviteListSize =" + reqGroupVideo$RspGetInvitedMemberList.rpt_member_list.size());
            } catch (Exception e16) {
                e = e16;
                QLog.w("VideoServlet", 1, "onRspGroupVideoInviteMemberMsgMsg, Exception", e);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void r(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        com.tencent.av.utils.e.m("onRspGroupVideoTerminateMsg", intent.getExtras());
        int length = fromServiceMsg.getWupBuffer().length - 4;
        byte[] bArr = new byte[length];
        PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        try {
            ReqGroupVideo$RspGroupVideoTerminate reqGroupVideo$RspGroupVideoTerminate = new ReqGroupVideo$RspGroupVideoTerminate();
            reqGroupVideo$RspGroupVideoTerminate.mergeFrom(bArr);
            common$ErrorInfo common_errorinfo = reqGroupVideo$RspGroupVideoTerminate.result.get();
            int F2 = MessageHandler.F2(common_errorinfo);
            if (common_errorinfo.bytes_errmsg.has()) {
                str = common_errorinfo.bytes_errmsg.get().toStringUtf8();
            } else {
                str = "";
            }
            QLog.w("VideoServlet", 1, "onRspGroupVideoTerminateMsg, errorCode[" + F2 + "], errorMsg[" + str + "]");
        } catch (Exception e16) {
            QLog.w("VideoServlet", 1, "onRspGroupVideoTerminateMsg, Exception", e16);
        }
    }

    private boolean s(byte[] bArr) {
        CommonConfig$CodecConfigRsp commonConfig$CodecConfigRsp = new CommonConfig$CodecConfigRsp();
        try {
            commonConfig$CodecConfigRsp.mergeFrom(bArr);
            List<CommonConfig$Ability> list = commonConfig$CodecConfigRsp.ability.get();
            if (list.isEmpty()) {
                QLog.d("VideoServlet", 1, "abilityList is empty");
                return false;
            }
            ArrayList<CommonConfig$CertainAbility> arrayList = new ArrayList();
            for (CommonConfig$Ability commonConfig$Ability : list) {
                if (commonConfig$Ability.scenes.get() == 1) {
                    arrayList.addAll(commonConfig$Ability.certain_ability.get());
                }
            }
            if (arrayList.isEmpty()) {
                QLog.d("VideoServlet", 1, "SCENES_NOT_REALTIME is empty");
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            for (CommonConfig$CertainAbility commonConfig$CertainAbility : arrayList) {
                if (commonConfig$CertainAbility.f73258protocol.get() == 3) {
                    arrayList2.addAll(commonConfig$CertainAbility.ability_info.get());
                }
            }
            if (!arrayList2.isEmpty()) {
                return true;
            }
            QLog.d("VideoServlet", 1, "VideoSR is empty");
            return false;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("VideoServlet", 1, "parseAndSaveCommonConfig fail", e16);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long[] t(byte[] bArr, String str, String str2) {
        String str3;
        int i3;
        long j3;
        int i16;
        String str4;
        hd_video$MsgBody mergeFrom;
        int length;
        hd_video$RspBody mergeFrom2;
        int length2;
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("parseVideoMsgSubServiceTypeAndRoomID,");
            sb5.append(str2);
            sb5.append(" parseSubType:");
            sb5.append(str);
            sb5.append(", buff.len=");
            if (bArr == null) {
                length2 = 0;
            } else {
                length2 = bArr.length;
            }
            sb5.append(length2);
            QLog.d("VideoServlet", 2, sb5.toString());
        }
        long j16 = -1;
        if (!"SharpSvr.c2sack".equalsIgnoreCase(str)) {
            str3 = "VideoServlet";
            if ("SharpSvr.s2c".equalsIgnoreCase(str)) {
                hd_video$MsgBody hd_video_msgbody = new hd_video$MsgBody();
                if (bArr != null) {
                    try {
                        mergeFrom = hd_video_msgbody.mergeFrom(bArr);
                    } catch (Exception e16) {
                        e = e16;
                        str4 = " invalid format:";
                    }
                    if (!mergeFrom.msg_video_head.has()) {
                        str4 = " invalid format:";
                        try {
                            if (QLog.isColorLevel()) {
                                QLog.e(str3, 2, str2 + " head not exist");
                            }
                        } catch (Exception e17) {
                            e = e17;
                            i16 = -1;
                            if (QLog.isColorLevel()) {
                                i3 = 2;
                                QLog.e(str3, 2, str2 + str4 + e.toString());
                                j3 = j16;
                                long[] jArr = new long[i3];
                                jArr[0] = i16;
                                jArr[1] = j3;
                                if (QLog.isDevelopLevel()) {
                                }
                                return jArr;
                            }
                            i3 = 2;
                            j3 = j16;
                            long[] jArr2 = new long[i3];
                            jArr2[0] = i16;
                            jArr2[1] = j3;
                            if (QLog.isDevelopLevel()) {
                            }
                            return jArr2;
                        }
                    } else {
                        hd_video$VideoHead hd_video_videohead = mergeFrom.msg_video_head.get();
                        int i17 = hd_video_videohead.enum_body_type.get();
                        long j17 = hd_video_videohead.uint64_uin.get();
                        if (hd_video_videohead.int32_sub_service_type.has()) {
                            i16 = hd_video_videohead.int32_sub_service_type.get();
                        } else {
                            i16 = -1;
                        }
                        try {
                            int i18 = hd_video_videohead.uint32_seq.get();
                            str4 = " invalid format:";
                            try {
                                long j18 = hd_video_videohead.uint64_room_id.get();
                                try {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(str3, 2, str2 + " bodyType=" + i17 + ", subServiceType=" + i16 + ", uin=" + j17 + ", seq=" + i18 + ", roomId=" + j18);
                                    }
                                    j16 = j18;
                                } catch (Exception e18) {
                                    e = e18;
                                    j16 = j18;
                                    if (QLog.isColorLevel()) {
                                    }
                                    i3 = 2;
                                    j3 = j16;
                                    long[] jArr22 = new long[i3];
                                    jArr22[0] = i16;
                                    jArr22[1] = j3;
                                    if (QLog.isDevelopLevel()) {
                                    }
                                    return jArr22;
                                }
                            } catch (Exception e19) {
                                e = e19;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            str4 = " invalid format:";
                        }
                        i3 = 2;
                        j3 = j16;
                    }
                }
                i3 = 2;
                i16 = -1;
                j3 = j16;
            } else {
                i3 = 2;
                j3 = -1;
                i16 = -1;
            }
        } else {
            hd_video$RspBody hd_video_rspbody = new hd_video$RspBody();
            if (bArr == null) {
                str3 = "VideoServlet";
            } else {
                try {
                    mergeFrom2 = hd_video_rspbody.mergeFrom(bArr);
                } catch (Exception e27) {
                    e = e27;
                    str3 = "VideoServlet";
                }
                if (!mergeFrom2.msg_video_head.has()) {
                    str3 = "VideoServlet";
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e(str3, 2, str2 + " head not exist");
                        }
                    } catch (Exception e28) {
                        e = e28;
                    }
                } else {
                    hd_video$VideoHead hd_video_videohead2 = mergeFrom2.msg_video_head.get();
                    int i19 = hd_video_videohead2.enum_body_type.get();
                    try {
                        long j19 = hd_video_videohead2.uint64_uin.get();
                        if (hd_video_videohead2.int32_sub_service_type.has()) {
                            i16 = hd_video_videohead2.int32_sub_service_type.get();
                        } else {
                            i16 = -1;
                        }
                        try {
                            int i26 = hd_video_videohead2.uint32_seq.get();
                            long j26 = hd_video_videohead2.uint64_room_id.get();
                            try {
                                if (!QLog.isColorLevel()) {
                                    str3 = "VideoServlet";
                                } else {
                                    str3 = "VideoServlet";
                                    try {
                                        QLog.d(str3, 2, str2 + " bodyType=" + i19 + ", subServiceType=" + i16 + ", uin=" + j19 + ", seq=" + i26 + ", roomId=" + j26);
                                    } catch (Exception e29) {
                                        e = e29;
                                        j16 = j26;
                                        if (QLog.isColorLevel()) {
                                        }
                                        j3 = j16;
                                        i3 = 2;
                                        long[] jArr222 = new long[i3];
                                        jArr222[0] = i16;
                                        jArr222[1] = j3;
                                        if (QLog.isDevelopLevel()) {
                                        }
                                        return jArr222;
                                    }
                                }
                                j16 = j26;
                            } catch (Exception e36) {
                                e = e36;
                                str3 = "VideoServlet";
                            }
                        } catch (Exception e37) {
                            e = e37;
                            str3 = "VideoServlet";
                        }
                    } catch (Exception e38) {
                        e = e38;
                        str3 = "VideoServlet";
                    }
                    j3 = j16;
                    i3 = 2;
                }
                i16 = -1;
                if (QLog.isColorLevel()) {
                    QLog.e(str3, 2, str2 + " invalid format:" + e.toString());
                }
                j3 = j16;
                i3 = 2;
            }
            i16 = -1;
            j3 = j16;
            i3 = 2;
        }
        long[] jArr2222 = new long[i3];
        jArr2222[0] = i16;
        jArr2222[1] = j3;
        if (QLog.isDevelopLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("parseVideoMsgSubServiceTypeAndRoomID,");
            sb6.append(str2);
            sb6.append(" parseSubType = ");
            sb6.append(str);
            sb6.append(", buff.len = ");
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            sb6.append(length);
            sb6.append(",subServiceType = ");
            sb6.append(i16);
            sb6.append(",roomId = ");
            sb6.append(j3);
            QLog.d(str3, 2, sb6.toString());
        }
        return jArr2222;
    }

    private void w(Packet packet, Bundle bundle) {
        com.tencent.av.utils.e.m("reqGroupVideoTerminateMsg", bundle);
        packet.setServantName("MultiVideo");
        packet.setFuncName("MultiVideoMsg");
        packet.setSSOCommand("QQRTCSvc.group_video_terminate_msg");
        packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
        long j3 = bundle.getLong("selfuin");
        long j16 = bundle.getLong("groupuin");
        long j17 = bundle.getLong("groupcode");
        ReqGroupVideo$ReqGroupVideoTerminate reqGroupVideo$ReqGroupVideoTerminate = new ReqGroupVideo$ReqGroupVideoTerminate();
        reqGroupVideo$ReqGroupVideoTerminate.uint64_operator.set(j3);
        reqGroupVideo$ReqGroupVideoTerminate.uint64_group.set(j16);
        reqGroupVideo$ReqGroupVideoTerminate.uint64_room_id.set(j17);
        packet.putSendData(fh.b(reqGroupVideo$ReqGroupVideoTerminate.toByteArray()));
    }

    private static void x(long j3, ArrayList<DelMsgInfo> arrayList, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("VideoServlet", 2, "send0x210Ack uin: " + j3 + " svrip: " + i3 + " seq: " + i16);
        }
        if (arrayList != null && arrayList.size() > 0) {
            if (QLog.isDevelopLevel()) {
                QLog.i("VideoServlet", 2, "send0x210Ack delMsgInfos size > 0");
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("delMsgInfos", arrayList);
            bundle.putInt("svrip", i3);
            bundle.putInt("seq", i16);
            bundle.putLong("lUin", j3);
            QIPCClientHelper.getInstance().getClient().callServer("QavQIPCModule", "action_send_0x210_ack", bundle, null);
        }
    }

    private void y(MultiVideoMsg multiVideoMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoServlet", 2, "sendMultiVideoAck, seq: " + multiVideoMsg.msg_seq + ", videoMsg.type:" + ((int) multiVideoMsg.type) + ", videoMsg.from_uin:" + multiVideoMsg.from_uin + ", videoMsg.to_uin.size:" + multiVideoMsg.to_uin.size() + ", +videoMsg.to_uin.size():" + multiVideoMsg.to_uin.size());
        }
        NewIntent newIntent = new NewIntent(this.f74639d.getApplication(), t.class);
        newIntent.putExtra("reqType", 9);
        newIntent.putExtra("ver", multiVideoMsg.ver);
        newIntent.putExtra("type", multiVideoMsg.type);
        newIntent.putExtra("cscmd", multiVideoMsg.csCmd);
        newIntent.putExtra("subcmd", multiVideoMsg.subCmd);
        newIntent.putExtra(ShortVideoConstants.FROM_UIN, multiVideoMsg.from_uin);
        newIntent.putExtra("to_uin", multiVideoMsg.to_uin.get(0));
        newIntent.putExtra("video_buff", multiVideoMsg.video_buff);
        newIntent.putExtra("msg_seq", multiVideoMsg.msg_seq);
        newIntent.putExtra("msg_uid", multiVideoMsg.msg_uid);
        newIntent.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, multiVideoMsg.msg_type);
        newIntent.putExtra(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, multiVideoMsg.msg_time);
        newIntent.putExtra("erroMsg", "success");
        service(newIntent);
    }

    private void z(Packet packet, Bundle bundle) {
        packet.setServantName("MultiVideo");
        packet.setFuncName("MultiVideoMsg");
        packet.setSSOCommand("MultiVideo.c2s");
        packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
        MultiVideoMsg multiVideoMsg = new MultiVideoMsg();
        multiVideoMsg.ver = bundle.getByte("ver");
        multiVideoMsg.type = bundle.getByte("type");
        multiVideoMsg.csCmd = bundle.getShort("cscmd");
        multiVideoMsg.from_uin = a(String.valueOf(bundle.getLong(ShortVideoConstants.FROM_UIN)));
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(bundle.getLong("toUin")));
        multiVideoMsg.to_uin = arrayList;
        multiVideoMsg.msg_time = bundle.getLong(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
        multiVideoMsg.msg_type = bundle.getLong(QQHealthReportApiImpl.MSG_TYPE_KEY);
        multiVideoMsg.msg_seq = bundle.getLong("msg_seq");
        multiVideoMsg.msg_uid = bundle.getLong("msg_uid");
        multiVideoMsg.video_buff = bundle.getByteArray("vMsg");
        packet.addRequestPacket("MultiVideoMsg", multiVideoMsg);
    }

    public f g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (f fVar : this.f74640e) {
            if (fVar != null && fVar.a(str)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        return new String[]{"VideoCCSvc.Adaptation", "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCreateRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoEnterRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoInviteRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoQueryRoom", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoDeleteUser", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoMultiTerminalSync", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS", "trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap", "trpc.qqrtc.open_utils.OpenUtils.SsoGetSign", "trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS", "trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoCreateRoom", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoInviteUser", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoRefuseInvite", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoIgnoreInvite", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoQueryInfo", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoAcceptInvite", "trpc.qqrtc.av_appsvr.SharpQuality.SsoSdkInfoReport", "trpc.qqrtc.av_appsvr.AvAppsvr.SsoLogOut"};
    }

    void i(byte[] bArr, long j3, long j16, long j17) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", String.valueOf(j16));
        bundle.putString("fromUin", com.tencent.av.utils.i.a(j3));
        bundle.putByteArray("buffer", bArr);
        bundle.putLong("time", j17);
        r.h0().l0().receiveSharpVideoMsg(bundle);
        if (QLog.isDevelopLevel()) {
            QLog.w("VideoServlet", 1, "handleSharpVideoMessage selfUin[" + j16 + "]");
        }
    }

    void j(byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("buffer", bArr);
        r.h0().l0().receiveSharpVideoAck(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("VideoServlet", 2, "handle Sharp Video c2s Ack Message OK");
        }
    }

    void n(Intent intent, FromServiceMsg fromServiceMsg) {
        VideoProcessExitMonitor Q;
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase(serviceCmd)) {
            String str = (String) fromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
            if (str != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "parse getGatewayIpMsg Ok " + str + " cmd " + serviceCmd);
                }
                r.h0().c2(str, 0);
                return;
            }
            return;
        }
        if (MsfMsgUtil.getSetConnStatusMsg(null, 0).getServiceCmd().equalsIgnoreCase(serviceCmd)) {
            Integer num = (Integer) fromServiceMsg.getAttribute("status");
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, String.format("onReceive SetConnStatusMsg status=%s", num));
            }
            if (num == null || (Q = this.f74639d.Q()) == null) {
                return;
            }
            Q.o(num.intValue());
            return;
        }
        if ("OidbSvc.0x625".equalsIgnoreCase(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive");
            }
            if (fromServiceMsg.isSuccess()) {
                try {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr = new byte[length];
                    PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                    if (oidb_sso_oidbssopkg.uint32_result.get() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + oidb_sso_oidbssopkg.uint32_result.get());
                        }
                    } else if (oidb_sso_oidbssopkg.bytes_bodybuffer.has()) {
                        Oidb_0x625$Open2Tiny_RspBody oidb_0x625$Open2Tiny_RspBody = new Oidb_0x625$Open2Tiny_RspBody();
                        oidb_0x625$Open2Tiny_RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        List<Oidb_0x625$TinyIDInfoRsp> list = oidb_0x625$Open2Tiny_RspBody.msg_tinyid_rsp_info.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + list.toString());
                        }
                    }
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                    }
                    e16.printStackTrace();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                return;
            }
            return;
        }
        if ("OidbSvc.0xa02".equalsIgnoreCase(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
            }
            if (fromServiceMsg.isSuccess()) {
                try {
                    int length2 = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr2 = new byte[length2];
                    PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length2);
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg2.mergeFrom(bArr2);
                    if (oidb_sso_oidbssopkg2.uint32_result.get() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + oidb_sso_oidbssopkg2.uint32_result.get());
                            return;
                        }
                        return;
                    }
                    if (oidb_sso_oidbssopkg2.bytes_bodybuffer.has()) {
                        cmd0xa02$RspBody cmd0xa02_rspbody = new cmd0xa02$RspBody();
                        cmd0xa02_rspbody.mergeFrom(oidb_sso_oidbssopkg2.bytes_bodybuffer.get().toByteArray());
                        List<cmd0xa02$TinyID2UserAccInfo> list2 = cmd0xa02_rspbody.rpt_tinyid2useracc_info.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + list2.toString());
                        }
                        r.h0().t1(ae.i(list2));
                        return;
                    }
                    return;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                    }
                    e17.printStackTrace();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
                return;
            }
            return;
        }
        if ("QQRTCSvc.echo".equalsIgnoreCase(serviceCmd)) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_QQRTCSVC_ECHO onReceive isSuccess = " + isSuccess);
            }
            r.h0().d(isSuccess);
            return;
        }
        if ("QQRTCSvc.group_video_terminate_msg".equalsIgnoreCase(serviceCmd)) {
            r(intent, fromServiceMsg);
            return;
        }
        if ("QQRTCSvc.group_video_invite_list".equalsIgnoreCase(serviceCmd)) {
            q(intent, fromServiceMsg);
            return;
        }
        if (BaseConstants.CMD_REPORTSTAT.equals(serviceCmd)) {
            ClientLogReport.instance().handleServerResp(intent, fromServiceMsg);
            return;
        }
        if ("QQRTCSvc.chatroom_get_msg".equalsIgnoreCase(serviceCmd)) {
            o(serviceCmd, intent, fromServiceMsg);
            return;
        }
        if ("QQRTCSvc.chatroom_send_msg".equalsIgnoreCase(serviceCmd)) {
            o(serviceCmd, intent, fromServiceMsg);
            return;
        }
        if ("trpc.qqrtc.sharpsvrconfig.UniversalConfigSSO.SsoGetUniversalConfig".equalsIgnoreCase(serviceCmd)) {
            p(intent, fromServiceMsg);
            return;
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCreateRoom".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(512, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                AVCoreLog.e("VideoServlet", String.format("CMD_MULTI_VIDEO_CREATE_ROOM fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoEnterRoom".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(513, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                AVCoreLog.e("VideoServlet", String.format("CMD_MULTI_VIDEO_ENTER_ROOM fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoInviteRoom".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(514, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                AVCoreLog.e("VideoServlet", String.format("CMD_MULTI_VIDEO_INVITE_ROOM fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoMultiTerminalSync".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(517, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                AVCoreLog.e("VideoServlet", String.format("CMD_MULTI_VIDEO_MUL_TERM_SYNC fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoCommChannelCS".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(WnsNetworkConst.WRITE_FAIL, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                AVCoreLog.e("VideoServlet", String.format("CMD_MULTI_VIDEO_CHANNEL_C2S fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.open_utils.OpenUtils.SsoGetRoomUinOpenIdMap".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(WnsNetworkConst.NETWORK_DISABLE, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                com.tencent.qav.log.a.b("VideoServlet", String.format("CMD_OPEN_GET_UIN_OPENID_MAP fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.open_utils.OpenUtils.SsoGetSign".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                com.tencent.qav.log.a.b("VideoServlet", String.format("CMD_OPEN_GET_SIGN fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoQueryRoom".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(515, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                AVCoreLog.e("VideoServlet", String.format("CMD_MULTI_VIDEO_QUERY_ROOM fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if ("trpc.qqrtc.mav_appsvr.MavAppsvr.SsoDeleteUser".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                r.h0().l0().receiveSSOMultiVideoAck(516, fh.a(fromServiceMsg.getWupBuffer()));
                return;
            } else {
                AVCoreLog.e("VideoServlet", String.format("CMD_MULTI_VIDEO_DELETE_ROOM fail", Integer.valueOf(fromServiceMsg.getResultCode())));
                return;
            }
        }
        if (c(serviceCmd, fromServiceMsg)) {
            if (!zv.b.a().f453493c || fromServiceMsg.getAttributes() == null) {
                return;
            }
            if (zv.b.a().f453489a == 0) {
                Object obj = fromServiceMsg.getAttributes().get(BaseConstants.TIMESTAMP_NET2MSF_BOOT);
                if (obj != null) {
                    zv.b.a().f453501g = ((Long) obj).longValue();
                }
                Object obj2 = fromServiceMsg.getAttributes().get(BaseConstants.TIME_MSF2NET_BOOT_SHARP_C2S);
                if (obj2 != null) {
                    zv.b.a().f453499f = ((Long) obj2).longValue();
                    return;
                }
                return;
            }
            if (zv.b.a().f453489a == 2) {
                zv.b.a().f453489a = 4;
                Object obj3 = fromServiceMsg.getAttributes().get(BaseConstants.TIME_MSF2NET_BOOT_SHARP_C2S);
                if (obj3 != null) {
                    zv.b.a().f453507j = ((Long) obj3).longValue();
                    return;
                }
                return;
            }
            return;
        }
        h(intent, fromServiceMsg);
        Bundle extras = intent.getExtras();
        byte[] byteArray = extras.getByteArray("vMsg");
        String valueOf = (byteArray == null || byteArray.length <= 2) ? "null" : String.valueOf((int) byteArray[2]);
        if (QLog.isColorLevel()) {
            QLog.d("VideoServlet", 2, "handleRecieveMsg: cmd = " + serviceCmd + ", friendUin = " + extras.getLong("toUin") + ", buffer[2] = " + valueOf + ", result = " + fromServiceMsg.isSuccess());
        }
    }

    void o(String str, Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        com.tencent.av.utils.e.m("onRspChatRoom", intent.getExtras());
        int length = fromServiceMsg.getWupBuffer().length - 4;
        if (fromServiceMsg.isSuccess() && length > 0) {
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        ChatRoomMng D = this.f74639d.D();
        if (D != null) {
            D.n(str, fromServiceMsg.isSuccess(), fromServiceMsg.getResultCode(), intent, bArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        super.onCreate();
        VideoAppInterface videoAppInterface = (VideoAppInterface) getAppRuntime();
        this.f74639d = videoAppInterface;
        videoAppInterface.f73117f0 = System.currentTimeMillis();
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        SessionInfo f16;
        if (fromServiceMsg == null) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        long a16 = intent != null ? at.a(intent) : 0L;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onReceive, cmd[");
        sb5.append(serviceCmd);
        sb5.append("], seq[");
        sb5.append(a16);
        sb5.append("], request[");
        sb5.append(intent != null);
        sb5.append("], currentThread[");
        sb5.append(Thread.currentThread().getId());
        sb5.append("]");
        QLog.w("VideoServlet", 1, sb5.toString());
        if ("SharpSvr.c2s".equalsIgnoreCase(serviceCmd)) {
            ReportController.o(null, "CliOper", "", "", "0X80088B1", "0X80088B1", 0, 0, "", "", "", "");
        }
        if (intent != null) {
            n(intent, fromServiceMsg);
            return;
        }
        if ("SharpSvr.s2c".equalsIgnoreCase(serviceCmd)) {
            if (this.f74639d != null) {
                r.h0().h3(System.currentTimeMillis());
                QLog.d("VideoServlet", 1, "[videoKeepLive] update invite timeMs:=" + r.h0().w0());
            }
            l(fromServiceMsg, serviceCmd);
            return;
        }
        if ("SharpSvr.c2sack".equalsIgnoreCase(serviceCmd)) {
            if (zv.b.a().f453493c && fromServiceMsg.getAttributes() != null) {
                if (zv.b.a().f453489a == 0) {
                    Object obj = fromServiceMsg.getAttributes().get(BaseConstants.TIMESTAMP_NET2MSF_BOOT);
                    if (obj != null) {
                        zv.b.a().f453501g = ((Long) obj).longValue();
                    }
                    Object obj2 = fromServiceMsg.getAttributes().get(BaseConstants.TIME_MSF2NET_BOOT_SHARP_C2S);
                    if (obj2 != null) {
                        zv.b.a().f453499f = ((Long) obj2).longValue();
                    }
                } else if (zv.b.a().f453489a == 2) {
                    zv.b.a().f453489a = 4;
                    Object obj3 = fromServiceMsg.getAttributes().get(BaseConstants.TIME_MSF2NET_BOOT_SHARP_C2S);
                    if (obj3 != null) {
                        zv.b.a().f453507j = ((Long) obj3).longValue();
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "Receive sharp video message c2s ack,cmd=SharpSvr.c2sack");
            }
            SharpVideoMsg sharpVideoMsg = (SharpVideoMsg) decodePacket(fromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
            long[] t16 = t(sharpVideoMsg.video_buff, "SharpSvr.c2sack", "--video--");
            int i3 = (int) t16[0];
            long j3 = t16[1];
            QLog.w("VideoServlet", 1, "avideo onReceive[c2s ack], seq[" + sharpVideoMsg.msg_seq + "], msg_type[" + sharpVideoMsg.msg_type + "], type[" + ((int) sharpVideoMsg.type) + "], serviceType[" + i3 + "], roomId[" + j3 + "]");
            if (i3 == 1013) {
                return;
            }
            if (sharpVideoMsg.msg_type == 2 && (f16 = n.e().f()) != null) {
                f16.d(j3);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoServlet", 2, "avideo onReceive set sessioninfo roomid ,id = " + j3);
                }
                ((VideoNodeReporter) this.f74639d.B(4)).B(j3);
            }
            try {
                QLog.w("tagSharpSvr", 1, "<-- onReceive() cmd = " + serviceCmd + " , msg_type = " + sharpVideoMsg.msg_type + ", bodyType = " + s.f(sharpVideoMsg.video_buff).f74243d);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            j(sharpVideoMsg.video_buff);
            return;
        }
        if ("MultiVideo.s2c".equalsIgnoreCase(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "Receive multi video message s2c ,cmd=MultiVideo.s2c");
            }
            MultiVideoMsg multiVideoMsg = (MultiVideoMsg) decodePacket(fromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
            y(multiVideoMsg);
            Bundle bundle = new Bundle();
            bundle.putByteArray("buffer", multiVideoMsg.video_buff);
            r.h0().l0().receiveMultiVideoMsg(bundle);
            return;
        }
        if ("MultiVideo.c2sack".equalsIgnoreCase(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "Receive multi video message c2s ack,cmd=MultiVideo.c2sack");
            }
            MultiVideoMsg multiVideoMsg2 = (MultiVideoMsg) decodePacket(fromServiceMsg.getWupBuffer(), "MultiVideoMsg", new MultiVideoMsg());
            Bundle bundle2 = new Bundle();
            bundle2.putByteArray("buffer", multiVideoMsg2.video_buff);
            r.h0().l0().receiveMultiVideoAck(bundle2);
            return;
        }
        if ("OidbSvc.0x625".equalsIgnoreCase(serviceCmd)) {
            if (fromServiceMsg.isSuccess()) {
                try {
                    ByteBuffer wrap = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                    byte[] bArr = new byte[wrap.getInt() - 4];
                    wrap.get(bArr);
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg.mergeFrom(bArr);
                    if (oidb_sso_oidbssopkg.uint32_result.get() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive uint32_result = " + oidb_sso_oidbssopkg.uint32_result.get());
                        }
                    } else if (oidb_sso_oidbssopkg.bytes_bodybuffer.has()) {
                        Oidb_0x625$Open2Tiny_RspBody oidb_0x625$Open2Tiny_RspBody = new Oidb_0x625$Open2Tiny_RspBody();
                        oidb_0x625$Open2Tiny_RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        List<Oidb_0x625$TinyIDInfoRsp> list = oidb_0x625$Open2Tiny_RspBody.msg_tinyid_rsp_info.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive list = " + list.toString());
                        }
                    }
                    return;
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive Exception!");
                    }
                    e17.printStackTrace();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onReceive not success!");
                return;
            }
            return;
        }
        if ("OidbSvc.0xa02".equalsIgnoreCase(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive");
            }
            if (fromServiceMsg.isSuccess()) {
                try {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    byte[] bArr2 = new byte[length];
                    PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
                    oidb_sso_oidbssopkg2.mergeFrom(bArr2);
                    if (oidb_sso_oidbssopkg2.uint32_result.get() != 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive uint32_result = " + oidb_sso_oidbssopkg2.uint32_result.get());
                        }
                    } else if (oidb_sso_oidbssopkg2.bytes_bodybuffer.has()) {
                        Oidb_0x626$Tiny2Open_RspBody oidb_0x626$Tiny2Open_RspBody = new Oidb_0x626$Tiny2Open_RspBody();
                        oidb_0x626$Tiny2Open_RspBody.mergeFrom(oidb_sso_oidbssopkg2.bytes_bodybuffer.get().toByteArray());
                        List<Oidb_0x626$OpenIDInfoRsp> list2 = oidb_0x626$Tiny2Open_RspBody.msg_openid_rsp_info.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive list = " + list2.toString());
                        }
                    }
                    return;
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive Exception!");
                    }
                    e18.printStackTrace();
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoServlet", 2, "CMD_OIDB_0x626 onReceive not success!");
                return;
            }
            return;
        }
        h(intent, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        boolean z16;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        long a16 = at.a(intent);
        if (a16 == 0) {
            a16 = com.tencent.av.utils.e.d();
            at.f(intent, a16);
        }
        int i3 = extras.getInt("reqType", -1);
        QLog.w("VideoServlet", 1, "onSend, reqType[" + i3 + "], seq[" + a16 + "]");
        if (i3 == 24) {
            v(packet, extras);
            return;
        }
        if (i3 != 100) {
            switch (i3) {
                case 3:
                    packet.setServantName("VideoSvc");
                    packet.setFuncName("SendVideoMsg");
                    packet.setSSOCommand("VideoCCSvc.Adaptation");
                    VideoCallMsg videoCallMsg = new VideoCallMsg();
                    videoCallMsg.ver = (byte) 1;
                    videoCallMsg.type = (byte) 1;
                    videoCallMsg.lUin = a(extras.getString("selfuin"));
                    videoCallMsg.lPeerUin = extras.getLong("toUin");
                    videoCallMsg.uDateTime = (int) (System.currentTimeMillis() / 1000);
                    videoCallMsg.cVerifyType = (byte) 0;
                    videoCallMsg.uSeqId = 0;
                    videoCallMsg.uSessionId = 0;
                    videoCallMsg.vMsg = extras.getByteArray("vMsg");
                    packet.addRequestPacket("VideoCallMsg", videoCallMsg);
                    return;
                case 4:
                    ReportController.o(null, "CliOper", "", "", "0X80088B0", "0X80088B0", 0, 0, "", "", "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!!=====");
                    }
                    packet.setServantName("SharpSvr");
                    packet.setFuncName("c2s");
                    packet.setSSOCommand("SharpSvr.c2s");
                    packet.setNoResponse();
                    packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
                    SharpVideoMsg sharpVideoMsg = new SharpVideoMsg();
                    sharpVideoMsg.ver = (byte) 1;
                    sharpVideoMsg.type = (byte) 1;
                    sharpVideoMsg.from_uin = a(String.valueOf(extras.getLong("selfuin")));
                    ArrayList<Long> arrayList = new ArrayList<>();
                    arrayList.add(Long.valueOf(extras.getLong("toUin")));
                    sharpVideoMsg.to_uin = arrayList;
                    sharpVideoMsg.msg_time = 0L;
                    sharpVideoMsg.msg_type = 0L;
                    sharpVideoMsg.msg_seq = 0L;
                    sharpVideoMsg.msg_uid = 0L;
                    sharpVideoMsg.video_buff = extras.getByteArray("vMsg");
                    packet.addRequestPacket("SharpVideoMsg", sharpVideoMsg);
                    try {
                        QLog.w("tagSharpSvr", 1, "--> onSend() cmd = SharpSvr.c2s , msg_type = " + sharpVideoMsg.msg_type + ", bodyType = " + s.f(sharpVideoMsg.video_buff).f74243d);
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                case 5:
                    ToServiceMsg toServiceMsg = new ToServiceMsg(null, this.f74639d.getCurrentAccountUin(), "SharpSvr.s2cack");
                    toServiceMsg.setMsfCommand(MsfCommand.sendVideoAck);
                    toServiceMsg.setNeedCallback(false);
                    SharpVideoMsg sharpVideoMsg2 = new SharpVideoMsg();
                    sharpVideoMsg2.ver = extras.getByte("ver");
                    sharpVideoMsg2.type = extras.getByte("type");
                    sharpVideoMsg2.from_uin = a(String.valueOf(extras.getLong(ShortVideoConstants.FROM_UIN)));
                    ArrayList<Long> arrayList2 = new ArrayList<>();
                    arrayList2.add(Long.valueOf(extras.getLong("to_uin")));
                    sharpVideoMsg2.to_uin = arrayList2;
                    sharpVideoMsg2.msg_time = extras.getLong(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
                    sharpVideoMsg2.msg_type = extras.getLong(QQHealthReportApiImpl.MSG_TYPE_KEY);
                    sharpVideoMsg2.msg_seq = extras.getLong("msg_seq");
                    sharpVideoMsg2.msg_uid = extras.getLong("msg_uid");
                    sharpVideoMsg2.video_buff = extras.getByteArray("video_buff");
                    sharpVideoMsg2.call_type = extras.getShort(AudienceReportConst.TERMINAL_TYPE);
                    sharpVideoMsg2.client_state = d();
                    UniPacket uniPacket = new UniPacket();
                    uniPacket.setServantName("SharpSvr");
                    uniPacket.setFuncName("s2cack");
                    uniPacket.put("SharpVideoMsg", sharpVideoMsg2);
                    toServiceMsg.putWupBuffer(uniPacket.encode());
                    toServiceMsg.addAttribute("stype", Long.valueOf(sharpVideoMsg2.msg_type));
                    if (QLog.isColorLevel()) {
                        QLog.i("VideoServlet", 2, "send sharp s2c ack message,cmd=s2cack seq:" + sharpVideoMsg2.msg_seq + " type:" + sharpVideoMsg2.msg_type);
                    }
                    try {
                        QLog.w("tagSharpSvr", 1, "--> onSend() cmd = SharpSvr.s2cack , msg_type = " + sharpVideoMsg2.msg_type + ", bodyType = " + s.f(sharpVideoMsg2.video_buff).f74243d);
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    sendToMSF(intent, toServiceMsg);
                    return;
                case 6:
                    StrupBuff strupBuff = new StrupBuff();
                    strupBuff.prefix = "";
                    ArrayList arrayList3 = new ArrayList();
                    String string = extras.getString("vMsg");
                    if (string != null) {
                        arrayList3.add(string.getBytes(StandardCharsets.UTF_8));
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("custom_set", arrayList3);
                    strupBuff.logstring = new HashMap(hashMap);
                    strupBuff.encoding = (byte) 2;
                    packet.setSSOCommand(BaseConstants.CMD_REPORTSTAT);
                    packet.setServantName("QQService.CliLogSvc.MainServantObj");
                    packet.setFuncName("UploadReq");
                    packet.addRequestPacket("Data", strupBuff);
                    packet.setNoResponse();
                    return;
                case 7:
                    ToServiceMsg gatewayIpMsg = MsfMsgUtil.getGatewayIpMsg(null);
                    gatewayIpMsg.setTimeout(30000L);
                    gatewayIpMsg.setNeedCallback(true);
                    gatewayIpMsg.setNeedRemindSlowNetwork(false);
                    gatewayIpMsg.setAppId(this.f74639d.getAppid());
                    sendToMSF(intent, gatewayIpMsg);
                    return;
                case 8:
                    z(packet, extras);
                    return;
                case 9:
                    packet.setServantName("MultiVideo");
                    packet.setFuncName("MultiVideos2cack");
                    packet.setSSOCommand("MultiVideo.s2cack");
                    MultiVideoMsg multiVideoMsg = new MultiVideoMsg();
                    multiVideoMsg.ver = extras.getByte("ver");
                    multiVideoMsg.type = extras.getByte("type");
                    multiVideoMsg.csCmd = extras.getShort("cscmd");
                    multiVideoMsg.subCmd = extras.getShort("subcmd");
                    multiVideoMsg.from_uin = a(String.valueOf(extras.getLong(ShortVideoConstants.FROM_UIN)));
                    ArrayList<Long> arrayList4 = new ArrayList<>();
                    arrayList4.add(Long.valueOf(extras.getLong("to_uin")));
                    multiVideoMsg.to_uin = arrayList4;
                    multiVideoMsg.msg_time = extras.getLong(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME);
                    multiVideoMsg.msg_type = extras.getLong(QQHealthReportApiImpl.MSG_TYPE_KEY);
                    multiVideoMsg.msg_seq = extras.getLong("msg_seq");
                    multiVideoMsg.msg_uid = extras.getLong("msg_uid");
                    multiVideoMsg.video_buff = extras.getByteArray("video_buff");
                    packet.addRequestPacket("MultiVideoMsg", multiVideoMsg);
                    return;
                case 10:
                    int i16 = extras.getInt("status");
                    if (QLog.isColorLevel()) {
                        z16 = true;
                        QLog.d("VideoServlet", 2, String.format("onSend SetConnStatusMsg status=%s", Integer.valueOf(i16)));
                    } else {
                        z16 = true;
                    }
                    ToServiceMsg setConnStatusMsg = MsfMsgUtil.getSetConnStatusMsg(null, i16);
                    setConnStatusMsg.setTimeout(30000L);
                    setConnStatusMsg.setNeedCallback(z16);
                    setConnStatusMsg.setNeedRemindSlowNetwork(false);
                    setConnStatusMsg.setAppId(this.f74639d.getAppid());
                    sendToMSF(intent, setConnStatusMsg);
                    return;
                default:
                    switch (i3) {
                        case 12:
                            w(packet, extras);
                            return;
                        case 13:
                            intent.putExtra("requestInviteMemberMode", extras.getBoolean("selfuin"));
                            e(packet, extras);
                            return;
                        case 14:
                            Oidb_0x625$Open2Tiny_ReqBody oidb_0x625$Open2Tiny_ReqBody = new Oidb_0x625$Open2Tiny_ReqBody();
                            ArrayList arrayList5 = (ArrayList) extras.getSerializable("openid_list");
                            for (int i17 = 0; i17 < arrayList5.size(); i17++) {
                                Oidb_0x625$OpenIDInfoReq oidb_0x625$OpenIDInfoReq = new Oidb_0x625$OpenIDInfoReq();
                                oidb_0x625$OpenIDInfoReq.bytes_openid.set(ByteStringMicro.copyFromUtf8((String) arrayList5.get(i17)));
                                oidb_0x625$OpenIDInfoReq.uint32_acounttype.set(101);
                                oidb_0x625$OpenIDInfoReq.uint32_appid.set(1600000144);
                                oidb_0x625$Open2Tiny_ReqBody.msg_openid_req_info.add(oidb_0x625$OpenIDInfoReq);
                            }
                            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                            oidb_sso_oidbssopkg.uint32_command.set(1573);
                            oidb_sso_oidbssopkg.uint32_service_type.set(0);
                            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x625$Open2Tiny_ReqBody.toByteArray()));
                            byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
                            byte[] bArr = new byte[byteArray.length + 4];
                            PkgTools.dWord2Byte(bArr, 0, byteArray.length + 4);
                            PkgTools.copyData(bArr, 4, byteArray, byteArray.length);
                            packet.setSSOCommand("OidbSvc.0x625");
                            packet.putSendData(bArr);
                            if (QLog.isColorLevel()) {
                                QLog.d("VideoServlet", 2, "CMD_OIDB_0x625 onSend");
                                return;
                            }
                            return;
                        case 15:
                            cmd0xa02$ReqBody cmd0xa02_reqbody = new cmd0xa02$ReqBody();
                            ArrayList arrayList6 = (ArrayList) extras.getSerializable("tinyid_list");
                            for (int i18 = 0; i18 < arrayList6.size(); i18++) {
                                cmd0xa02$TinyID cmd0xa02_tinyid = new cmd0xa02$TinyID();
                                cmd0xa02_tinyid.uint64_tinyid.set(((Long) arrayList6.get(i18)).longValue());
                                cmd0xa02_reqbody.rpt_tinyid.add(cmd0xa02_tinyid);
                            }
                            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
                            oidb_sso_oidbssopkg2.uint32_command.set(2562);
                            oidb_sso_oidbssopkg2.uint32_service_type.set(0);
                            oidb_sso_oidbssopkg2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xa02_reqbody.toByteArray()));
                            byte[] byteArray2 = oidb_sso_oidbssopkg2.toByteArray();
                            byte[] bArr2 = new byte[byteArray2.length + 4];
                            PkgTools.dWord2Byte(bArr2, 0, byteArray2.length + 4);
                            PkgTools.copyData(bArr2, 4, byteArray2, byteArray2.length);
                            packet.setSSOCommand("OidbSvc.0xa02");
                            packet.putSendData(bArr2);
                            if (QLog.isColorLevel()) {
                                QLog.d("VideoServlet", 2, "CMD_OIDB_0xA02 onSend");
                                return;
                            }
                            return;
                        default:
                            switch (i3) {
                                case 18:
                                    if (QLog.isColorLevel()) {
                                        QLog.d("VideoServlet", 2, "=====send sharp SharpSvr.c2s!!!! 0xc2=====");
                                    }
                                    packet.setServantName("SharpSvr");
                                    packet.setFuncName("c2s");
                                    packet.setSSOCommand("SharpSvr.c2s");
                                    packet.setNoResponse();
                                    packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
                                    SharpVideoMsg sharpVideoMsg3 = new SharpVideoMsg();
                                    sharpVideoMsg3.ver = (byte) 1;
                                    sharpVideoMsg3.type = (byte) -62;
                                    sharpVideoMsg3.from_uin = a(String.valueOf(extras.getLong("selfuin")));
                                    ArrayList<Long> arrayList7 = new ArrayList<>();
                                    arrayList7.add(Long.valueOf(extras.getLong("toUin")));
                                    sharpVideoMsg3.to_uin = arrayList7;
                                    sharpVideoMsg3.msg_time = 0L;
                                    sharpVideoMsg3.msg_type = 0L;
                                    sharpVideoMsg3.msg_seq = 0L;
                                    sharpVideoMsg3.msg_uid = 0L;
                                    sharpVideoMsg3.video_buff = extras.getByteArray("vMsg");
                                    packet.addRequestPacket("SharpVideoMsg", sharpVideoMsg3);
                                    return;
                                case 19:
                                    boolean z17 = extras.getBoolean("keepAlive");
                                    if (QLog.isColorLevel()) {
                                        QLog.d("VideoServlet", 2, String.format("onSend keepProcessAliveMsg keepAlive=%s", Boolean.valueOf(z17)));
                                    }
                                    ToServiceMsg keepProcessAliveMsg = MsfMsgUtil.keepProcessAliveMsg(null, z17);
                                    keepProcessAliveMsg.setNeedRemindSlowNetwork(false);
                                    keepProcessAliveMsg.setAppId(this.f74639d.getAppid());
                                    sendToMSF(intent, keepProcessAliveMsg);
                                    return;
                                case 20:
                                    packet.setSSOCommand("QQRTCSvc.echo");
                                    packet.setTimeout(10000L);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("VideoServlet", 2, "onSend with cmd: CMD_QQRTCSVC_ECHO");
                                    }
                                    packet.putSendData(fh.b(extras.getByteArray("vMsg")));
                                    return;
                                case 21:
                                    u(packet, extras);
                                    return;
                                default:
                                    ToServiceMsg toServiceMsg2 = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("onSend, toMsg[");
                                        sb5.append(toServiceMsg2);
                                        sb5.append("], cmd[");
                                        sb5.append(toServiceMsg2 == null ? "null" : toServiceMsg2.getServiceCmd());
                                        sb5.append("]");
                                        QLog.d("VideoServlet", 2, sb5.toString());
                                    }
                                    if (toServiceMsg2 != null) {
                                        f g16 = g(toServiceMsg2.getServiceCmd());
                                        if (g16 != null) {
                                            packet.setServantName(g16.c());
                                            packet.setFuncName(g16.b());
                                        }
                                        packet.setSSOCommand(toServiceMsg2.getServiceCmd());
                                        packet.putSendData(toServiceMsg2.getWupBuffer());
                                        packet.setTimeout(toServiceMsg2.getTimeout());
                                        packet.setAttributes(toServiceMsg2.getAttributes());
                                        if (toServiceMsg2.isNeedCallback()) {
                                            return;
                                        }
                                        packet.setNoResponse();
                                        return;
                                    }
                                    return;
                            }
                    }
            }
        }
        B(packet, extras);
    }

    void p(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        int length = fromServiceMsg.getWupBuffer().length - 4;
        if (fromServiceMsg.isSuccess() && length > 0) {
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        if (bArr == null) {
            QLog.i("VideoServlet", 1, "onRspCommonConfigMsg, empty bytes");
            vu.a.c().r(false);
            return;
        }
        boolean s16 = s(bArr);
        QLog.i("VideoServlet", 1, "onRspCommonConfigMsg, support video SR[" + s16 + "]");
        vu.a.c().r(s16);
    }

    void u(Packet packet, Bundle bundle) {
        com.tencent.av.utils.e.m("reqChatRoom", bundle);
        String string = bundle.getString("ssoCmd");
        f g16 = g(string);
        if (g16 != null) {
            packet.setServantName(g16.c());
            packet.setFuncName(g16.b());
        }
        packet.setSSOCommand(string);
        packet.setTimeout(10000L);
        byte[] byteArray = bundle.getByteArray("vMsg");
        if (byteArray != null) {
            packet.putSendData(fh.b(byteArray));
        }
    }

    void v(Packet packet, Bundle bundle) {
        QLog.i("VideoServlet", 1, "reqCommonConfigMsg");
        packet.setServantName("trpc.qqrtc.sharpsvrconfig.UniversalConfigSSO");
        packet.setFuncName("SsoGetUniversalConfig");
        packet.setSSOCommand("trpc.qqrtc.sharpsvrconfig.UniversalConfigSSO.SsoGetUniversalConfig");
        packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.TRUE);
        packet.setTimeout(10000L);
        byte[] byteArray = bundle.getByteArray("vMsg");
        if (byteArray != null) {
            packet.putSendData(fh.b(byteArray));
        }
    }
}
