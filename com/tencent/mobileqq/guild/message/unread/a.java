package com.tencent.mobileqq.guild.message.unread;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d$MyChannelInfo;
import tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d$ReqBody;
import tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ChannelMsgReadedReportHandler f230833a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Oidb0xf6d$MyChannelInfo> f230834b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f230835c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.message.unread.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C7859a implements BaseGuildMessageHandler.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ oidb_sso$OIDBSSOPkg f230836a;

        C7859a(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
            this.f230836a = oidb_sso_oidbssopkg;
        }

        @Override // com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler.a
        public ToServiceMsg a() {
            ToServiceMsg createToServiceMsg = a.this.f230833a.createToServiceMsg("OidbSvcTrpcTcp.0xf6d_1");
            createToServiceMsg.putWupBuffer(this.f230836a.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            createToServiceMsg.setEnableFastResend(true);
            return createToServiceMsg;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChannelMsgReadedReportHandler channelMsgReadedReportHandler) {
        this.f230833a = channelMsgReadedReportHandler;
    }

    private void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        long j16 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        this.f230833a.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f230833a.getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901) {
                QLog.e("BatchMsgReadedReportProcessor", 1, "handleSendMsgReadedReportError: resendMsg reqSeq " + j3);
                if (this.f230833a.retrySendMessage(handlerFromQueue, "msf")) {
                    return;
                }
            }
            if (480000 == j16 || handlerFromQueue.c()) {
                QLog.e("BatchMsgReadedReportProcessor", 1, "handleSendMsgReadedReportError, all retry: reqSeq " + j3);
                this.f230833a.removeSendMessageHandler(j3);
                e();
                return;
            }
            return;
        }
        e();
    }

    private void d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Oidb0xf6d$RspBody oidb0xf6d$RspBody) {
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        if (this.f230833a.getHandlerFromQueue(j3) != null) {
            this.f230833a.removeSendMessageHandler(j3);
        }
        e();
    }

    private void e() {
        Oidb0xf6d$ReqBody oidb0xf6d$ReqBody = new Oidb0xf6d$ReqBody();
        synchronized (this.f230834b) {
            if (this.f230834b.size() == 0) {
                QLog.i("BatchMsgReadedReportProcessor", 1, "reportSvrNext end");
                this.f230835c = false;
                return;
            }
            this.f230835c = true;
            try {
                oidb0xf6d$ReqBody.uint64_member_id.set(Long.valueOf(this.f230833a.getApp().getCurrentUin()).longValue());
                oidb0xf6d$ReqBody.uint32_type.set(2);
                if (this.f230834b.size() <= 500) {
                    oidb0xf6d$ReqBody.rpt_msg_my_channel_list.addAll(this.f230834b);
                    this.f230834b.clear();
                } else {
                    List<Oidb0xf6d$MyChannelInfo> subList = this.f230834b.subList(0, 500);
                    oidb0xf6d$ReqBody.rpt_msg_my_channel_list.addAll(subList);
                    subList.clear();
                }
                QLog.i("BatchMsgReadedReportProcessor", 1, "reportSvrNex size:" + oidb0xf6d$ReqBody.rpt_msg_my_channel_list.size());
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(3949);
                oidb_sso_oidbssopkg.uint32_service_type.set(1);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb0xf6d$ReqBody.toByteArray()));
                this.f230833a.processRequest(true, true, false, 0L, new C7859a(oidb_sso_oidbssopkg));
            } catch (Exception e16) {
                QLog.e("BatchMsgReadedReportProcessor", 1, e16.toString());
                this.f230835c = false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d$RspBody, com.tencent.mobileqq.pb.MessageMicro] */
    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (obj != null && fromServiceMsg.getResultCode() == 1000) {
            ?? r16 = new MessageMicro<Oidb0xf6d$RspBody>() { // from class: tencent.im.group_pro_proto.oidb0xf6d.Oidb0xf6d$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Oidb0xf6d$RspBody.class);
            };
            try {
                i3 = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, r16);
            } catch (Exception unused) {
                QLog.e("BatchMsgReadedReportProcessor", 1, "handleSendMsgReadedReportError : parseOIDBPkg error");
                i3 = -1;
            }
            QLog.i("BatchMsgReadedReportProcessor", 1, "handleSendMsgReadedReport, retCode:" + i3);
            if (i3 != 0) {
                c(toServiceMsg, fromServiceMsg);
                return;
            } else {
                d(toServiceMsg, fromServiceMsg, r16);
                return;
            }
        }
        c(toServiceMsg, fromServiceMsg);
    }
}
