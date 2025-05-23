package com.tencent.av.utils;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_head$InstCtrl;
import tencent.im.msg.im_msg_head$InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0xb.C2CType0x211_SubC2CType0xb$MsgBody;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoC2CHandler extends BusinessHandler {

    /* renamed from: i, reason: collision with root package name */
    static String f76884i = "VideoC2CHandler";

    /* renamed from: d, reason: collision with root package name */
    public String f76885d;

    /* renamed from: e, reason: collision with root package name */
    public long f76886e;

    /* renamed from: f, reason: collision with root package name */
    public C2CType0x211_SubC2CType0xb$MsgBody.MsgHeader f76887f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f76888h;

    public VideoC2CHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f76885d = null;
        this.f76886e = 0L;
        this.f76887f = new C2CType0x211_SubC2CType0xb$MsgBody.MsgHeader();
        this.f76888h = qQAppInterface;
    }

    private msg_svc$PbSendMsgReq D2(int i3, String str, com.tencent.mobileqq.service.message.ac acVar, long j3, int i16, long j16) {
        return com.tencent.mobileqq.service.message.p.a(this.f76888h, i3, str, acVar, j3, i16);
    }

    private void E2(C2CType0x211_SubC2CType0xb$MsgBody.MsgHeader msgHeader) {
        String str = this.f76885d;
        if (str != null) {
            msgHeader.uint64_to_uin.set(i.g(str));
        }
        long j3 = this.f76886e;
        if (j3 != 0) {
            msgHeader.uint64_room_id.set(j3);
        }
        msgHeader.setHasFlag(true);
    }

    public void F2() {
        C2CType0x211_SubC2CType0xb$MsgBody c2CType0x211_SubC2CType0xb$MsgBody = new C2CType0x211_SubC2CType0xb$MsgBody();
        E2(this.f76887f);
        this.f76887f.uint32_body_type.set(102);
        this.f76887f.uint32_session_type.set(0);
        c2CType0x211_SubC2CType0xb$MsgBody.msg_msg_header.set(this.f76887f);
        c2CType0x211_SubC2CType0xb$MsgBody.setHasFlag(true);
        G2(1L, 102, c2CType0x211_SubC2CType0xb$MsgBody, 1L);
    }

    public ToServiceMsg G2(long j3, int i3, C2CType0x211_SubC2CType0xb$MsgBody c2CType0x211_SubC2CType0xb$MsgBody, long j16) {
        byte[] byteArray = c2CType0x211_SubC2CType0xb$MsgBody.toByteArray();
        if (QLog.isColorLevel()) {
            QLog.d(f76884i, 2, "send0x211C2CQavMsg QavMsgRecord:" + j16);
        }
        return H2(j3, this.f76885d, 529, 11, i3, byteArray, j16);
    }

    public ToServiceMsg H2(long j3, String str, int i3, int i16, int i17, byte[] bArr, long j16) {
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_MSG_PBSENDMSG);
        createToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
        createToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
        createToServiceMsg.extraData.putBoolean("ISFROM_QAV", true);
        createToServiceMsg.addAttribute("cookie", Long.valueOf(j3));
        long genMsgUid = FileManagerUtil.genMsgUid();
        long genMsgSeq = FileManagerUtil.genMsgSeq();
        com.tencent.mobileqq.service.message.ac acVar = new com.tencent.mobileqq.service.message.ac();
        acVar.f286177a = i16;
        acVar.f286178b = bArr;
        msg_svc$PbSendMsgReq D2 = D2(13, str, acVar, genMsgSeq, com.tencent.mobileqq.service.message.s.g(genMsgUid), j16);
        im_msg_head$InstInfo im_msg_head_instinfo = new im_msg_head$InstInfo();
        im_msg_head_instinfo.uint32_apppid.set(AppSetting.f());
        im_msg_head_instinfo.uint32_instid.set(AppSetting.f());
        im_msg_head_instinfo.setHasFlag(true);
        D2.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(im_msg_head_instinfo);
        im_msg_head$InstInfo im_msg_head_instinfo2 = new im_msg_head$InstInfo();
        im_msg_head_instinfo.uint32_apppid.set(AppSetting.f());
        im_msg_head_instinfo.uint32_instid.set(AppSetting.f());
        im_msg_head_instinfo2.setHasFlag(true);
        im_msg_head$InstCtrl im_msg_head_instctrl = D2.routing_head.trans_0x211.inst_ctrl;
        im_msg_head_instctrl.msg_from_inst = im_msg_head_instinfo2;
        im_msg_head_instctrl.setHasFlag(true);
        createToServiceMsg.putWupBuffer(D2.toByteArray());
        sendPbReq(createToServiceMsg);
        return createToServiceMsg;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(BaseConstants.CMD_MSG_PBSENDMSG);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
