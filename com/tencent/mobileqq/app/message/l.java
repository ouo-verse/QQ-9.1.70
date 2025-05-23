package com.tencent.mobileqq.app.message;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.proto.FMTransC2CMsgInfo;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.ac;
import com.tencent.mobileqq.service.message.k;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Random;
import msf.msgsvc.msg_ctrl$MsgCtrl;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import msf.msgsvc.msg_svc$PbSendMsgResp;
import msf.msgsvc.msg_svc$RoutingHead;
import org.slf4j.Marker;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class l extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    ArrayList<String> f196025v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements BaseMessageProcessor.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f196026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FMTransC2CMsgInfo f196027b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f196028c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte[] f196029d;

        a(String str, FMTransC2CMsgInfo fMTransC2CMsgInfo, int i3, byte[] bArr) {
            this.f196026a = str;
            this.f196027b = fMTransC2CMsgInfo;
            this.f196028c = i3;
            this.f196029d = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, l.this, str, fMTransC2CMsgInfo, Integer.valueOf(i3), bArr);
            }
        }

        @Override // com.tencent.imcore.message.BaseMessageProcessor.c
        public ToServiceMsg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ToServiceMsg createToServiceMsg = ((BaseMessageProcessor) l.this).f116343b.createToServiceMsg(BaseConstants.CMD_MSG_PBSENDMSG);
            createToServiceMsg.extraData.putString("uin", this.f196026a);
            createToServiceMsg.extraData.putLong("msgsize", 0L);
            createToServiceMsg.extraData.putLong("uniseq", this.f196027b.uniseq);
            createToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
            createToServiceMsg.extraData.putString("uuid", this.f196027b.uuid);
            createToServiceMsg.extraData.putByte("cmd", (byte) 0);
            createToServiceMsg.extraData.putByte("keyType", (byte) 0);
            createToServiceMsg.extraData.putInt(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, this.f196027b.busiType);
            createToServiceMsg.extraData.putString("toUin", this.f196026a);
            createToServiceMsg.extraData.putLong("queueSeq", this.f196027b.queueSeq);
            createToServiceMsg.extraData.putLong("sessionid", this.f196027b.sessionId);
            createToServiceMsg.extraData.putInt(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, s.g(this.f196027b.msgUid));
            createToServiceMsg.addAttribute(BaseConstants.Attribute_TAG_LOGSTR, String.valueOf(this.f196027b.msgSeq));
            createToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
            createToServiceMsg.extraData.putInt("transC2CCmd", this.f196028c);
            ac acVar = new ac();
            acVar.f286177a = this.f196027b.subCmd;
            acVar.f286178b = this.f196029d;
            AppInterface appInterface = ((BaseMessageProcessor) l.this).f116342a;
            String str = this.f196026a;
            FMTransC2CMsgInfo fMTransC2CMsgInfo = this.f196027b;
            msg_svc$PbSendMsgReq a16 = com.tencent.mobileqq.service.message.p.a(appInterface, 13, str, acVar, fMTransC2CMsgInfo.msgSeq, s.g(fMTransC2CMsgInfo.msgUid));
            l.this.M(a16, this.f196027b);
            l.this.O(a16, this.f196027b, acVar);
            FileManagerEntity fileManagerEntity = this.f196027b.entity;
            if (fileManagerEntity != null) {
                createToServiceMsg.extraData.putLong("tmpSessionType", fileManagerEntity.tmpSessionType);
            }
            if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(this.f196026a)) {
                l.this.K(a16);
            }
            createToServiceMsg.putWupBuffer(a16.toByteArray());
            createToServiceMsg.extraData.putLong(com.tencent.mobileqq.filemanager.app.d.class.getName(), this.f196027b.observerSeq);
            return createToServiceMsg;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements BaseMessageProcessor.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f196031a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f196032b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f196033c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f196034d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f196035e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ byte[] f196036f;

        b(String str, long j3, int i3, long j16, int i16, byte[] bArr) {
            this.f196031a = str;
            this.f196032b = j3;
            this.f196033c = i3;
            this.f196034d = j16;
            this.f196035e = i16;
            this.f196036f = bArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, l.this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16), bArr);
            }
        }

        @Override // com.tencent.imcore.message.BaseMessageProcessor.c
        public ToServiceMsg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ToServiceMsg createToServiceMsg = ((BaseMessageProcessor) l.this).f116343b.createToServiceMsg(BaseConstants.CMD_MSG_PBSENDMSG);
            createToServiceMsg.extraData.putString("uin", this.f196031a);
            createToServiceMsg.extraData.putByte("cmd", (byte) 0);
            createToServiceMsg.extraData.putByte("keyType", (byte) 0);
            createToServiceMsg.extraData.putByte("sendType", (byte) 0);
            createToServiceMsg.extraData.putInt(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 1025);
            createToServiceMsg.extraData.putString("toUin", this.f196031a);
            createToServiceMsg.extraData.putLong("sessionid", this.f196032b);
            createToServiceMsg.extraData.putInt(QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, this.f196033c);
            createToServiceMsg.extraData.putLong("msgsize", 0L);
            createToServiceMsg.addAttribute(BaseConstants.Attribute_TAG_LOGSTR, String.valueOf(this.f196034d));
            createToServiceMsg.extraData.putInt("ROUNTING_TYPE", 9);
            createToServiceMsg.extraData.putInt("transC2CCmd", this.f196035e);
            ac acVar = new ac();
            acVar.f286177a = this.f196035e;
            acVar.f286178b = this.f196036f;
            createToServiceMsg.putWupBuffer(com.tencent.mobileqq.service.message.p.a(((BaseMessageProcessor) l.this).f116342a, 9, this.f196031a, acVar, this.f196034d, this.f196033c).toByteArray());
            return createToServiceMsg;
        }
    }

    public l(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
        } else {
            this.f196025v = new ArrayList<>(20);
        }
    }

    private void G(FileManagerEntity fileManagerEntity, msg_svc$RoutingHead msg_svc_routinghead) {
        if (fileManagerEntity.tmpSessionFromPhone == null) {
            fileManagerEntity.tmpSessionFromPhone = "";
        }
        msg_svc_routinghead.address_list.from_phone.set(fileManagerEntity.tmpSessionFromPhone);
        if (fileManagerEntity.tmpSessionToPhone == null) {
            fileManagerEntity.tmpSessionToPhone = "";
        }
        msg_svc_routinghead.address_list.to_phone.set(fileManagerEntity.tmpSessionToPhone);
        msg_svc_routinghead.address_list.to_uin.set(Long.parseLong(fileManagerEntity.peerUin.replace(Marker.ANY_NON_NULL_MARKER, "")));
        byte[] bArr = fileManagerEntity.tmpSessionSig;
        if (bArr != null && bArr.length > 0) {
            msg_svc_routinghead.address_list.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_routinghead.address_list.setHasFlag(true);
        msg_svc_routinghead.setHasFlag(true);
    }

    private void H(FileManagerEntity fileManagerEntity, msg_svc$RoutingHead msg_svc_routinghead) {
        msg_svc_routinghead.business_wpa_tmp.to_uin.set(Long.parseLong(fileManagerEntity.peerUin));
        byte[] bArr = fileManagerEntity.tmpSessionSig;
        if (bArr != null && bArr.length > 0) {
            msg_svc_routinghead.business_wpa_tmp.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_routinghead.business_wpa_tmp.setHasFlag(true);
        msg_svc_routinghead.setHasFlag(true);
    }

    private void I(FileManagerEntity fileManagerEntity, msg_svc$RoutingHead msg_svc_routinghead) {
        msg_svc_routinghead.nearby_dating_tmp.to_uin.set(Long.parseLong(fileManagerEntity.peerUin));
        byte[] bArr = fileManagerEntity.tmpSessionSig;
        if (bArr != null && bArr.length > 0) {
            msg_svc_routinghead.nearby_dating_tmp.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_routinghead.nearby_dating_tmp.setHasFlag(true);
        msg_svc_routinghead.setHasFlag(true);
    }

    private void J(FileManagerEntity fileManagerEntity, msg_svc$RoutingHead msg_svc_routinghead) {
        long j3;
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "addTempSessionData add disctmp Info");
        }
        try {
            j3 = Long.parseLong(fileManagerEntity.tmpSessionRelatedUin);
        } catch (Exception unused) {
            QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + fileManagerEntity.tmpSessionRelatedUin + "]");
            j3 = 0;
        }
        msg_svc_routinghead.dis_tmp.dis_uin.set(j3);
        msg_svc_routinghead.dis_tmp.to_uin.set(Long.parseLong(fileManagerEntity.peerUin));
        msg_svc_routinghead.dis_tmp.setHasFlag(true);
        msg_svc_routinghead.setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        im_msg_body$RichText im_msg_body_richtext;
        if (!msg_svc_pbsendmsgreq.msg_body.rich_text.has()) {
            im_msg_body_richtext = new im_msg_body$RichText();
        } else {
            im_msg_body_richtext = msg_svc_pbsendmsgreq.msg_body.rich_text.get();
        }
        generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
        int i3 = 0;
        while (true) {
            if (i3 >= im_msg_body_richtext.elems.size()) {
                break;
            }
            im_msg_body$Elem im_msg_body_elem = im_msg_body_richtext.elems.get(i3);
            if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.get().bytes_pb_reserve.has()) {
                try {
                    generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                im_msg_body_richtext.elems.remove(i3);
                break;
            }
            i3++;
        }
        generalflags_resvattr.uint32_device_type.set(com.tencent.mobileqq.filemanager.fileassistant.util.h.d());
        im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
        im_msg_body_generalflags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr.toByteArray()));
        im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
        im_msg_body_elem2.general_flags.set(im_msg_body_generalflags);
        im_msg_body_richtext.elems.add(im_msg_body_elem2);
        msg_svc_pbsendmsgreq.msg_body.rich_text.set(im_msg_body_richtext);
    }

    private void L(FileManagerEntity fileManagerEntity, msg_svc$RoutingHead msg_svc_routinghead) {
        long j3;
        try {
            j3 = Long.parseLong(fileManagerEntity.tmpSessionRelatedUin);
        } catch (Exception unused) {
            QLog.e("Q.msg.BaseMessageProcessor", 1, "case to long faild, relatedUin[" + fileManagerEntity.tmpSessionRelatedUin + "]");
            j3 = 0;
        }
        msg_svc_routinghead.grp_tmp.group_uin.set(j3);
        msg_svc_routinghead.grp_tmp.to_uin.set(Long.parseLong(fileManagerEntity.peerUin));
        msg_svc_routinghead.grp_tmp.setHasFlag(true);
        msg_svc_routinghead.setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, FMTransC2CMsgInfo fMTransC2CMsgInfo) {
        FileManagerEntity fileManagerEntity = fMTransC2CMsgInfo.entity;
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.i("IMG_FILE_QR", 1, "add image QrInfo , info is null, maybe is not qr image");
                return;
            }
            return;
        }
        String filePath = fileManagerEntity.getFilePath();
        FileManagerEntity fileManagerEntity2 = fMTransC2CMsgInfo.entity;
        msg_ctrl$MsgCtrl msgCtrl = JumpShareUtils.getMsgCtrl(filePath, fileManagerEntity2.imgWidth, fileManagerEntity2.imgHeight, fileManagerEntity2.strQRUrl);
        if (msgCtrl != null) {
            msg_svc_pbsendmsgreq.msg_ctrl.set(msgCtrl);
            try {
                if (QLog.isColorLevel()) {
                    if (msgCtrl.resv_resv_info.has()) {
                        QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_flag:" + msgCtrl.resv_resv_info.get().uint32_flag.get());
                        QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint64_reserv2:" + msgCtrl.resv_resv_info.get().uint64_reserv2.get());
                        QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint64_reserv3:" + msgCtrl.resv_resv_info.get().uint64_reserv3.get());
                        QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_create_time:" + msgCtrl.resv_resv_info.get().uint32_create_time.get());
                        QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_pic_width:" + msgCtrl.resv_resv_info.get().uint32_pic_width.get());
                        QLog.i("IMG_FILE_QR", 1, "reqFeeds with ImageInfo has uint32_pic_height:" + msgCtrl.resv_resv_info.get().uint32_pic_height.get());
                    } else {
                        QLog.i("IMG_FILE_QR", 1, "eqFeeds without ImageInfo");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void N(FileManagerEntity fileManagerEntity, msg_svc$RoutingHead msg_svc_routinghead) {
        msg_svc_routinghead.accost_tmp.to_uin.set(Long.parseLong(fileManagerEntity.peerUin));
        byte[] bArr = fileManagerEntity.tmpSessionSig;
        if (bArr != null && bArr.length > 0) {
            msg_svc_routinghead.accost_tmp.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_routinghead.accost_tmp.setHasFlag(true);
        msg_svc_routinghead.setHasFlag(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, FMTransC2CMsgInfo fMTransC2CMsgInfo, ac acVar) {
        FileManagerEntity fileManagerEntity;
        if (fMTransC2CMsgInfo != null && (fileManagerEntity = fMTransC2CMsgInfo.entity) != null) {
            msg_svc$RoutingHead msg_svc_routinghead = msg_svc_pbsendmsgreq.routing_head;
            int i3 = (int) fileManagerEntity.tmpSessionType;
            if (i3 != 100) {
                if (i3 != 102) {
                    if (i3 != 109) {
                        if (i3 != 124) {
                            if (i3 != 127) {
                                if (i3 != 104) {
                                    if (i3 != 105) {
                                        return;
                                    } else {
                                        J(fileManagerEntity, msg_svc_routinghead);
                                    }
                                } else {
                                    L(fileManagerEntity, msg_svc_routinghead);
                                }
                            } else {
                                P(fileManagerEntity, msg_svc_routinghead);
                            }
                        } else {
                            H(fileManagerEntity, msg_svc_routinghead);
                        }
                    } else {
                        I(fileManagerEntity, msg_svc_routinghead);
                    }
                } else {
                    G(fileManagerEntity, msg_svc_routinghead);
                }
            } else {
                N(fileManagerEntity, msg_svc_routinghead);
            }
            if (acVar != null && acVar.f286178b != null) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession msg0x211[" + i3 + "]");
                }
                msg_svc_routinghead.trans_0x211.setHasFlag(false);
                msg_svc_pbsendmsgreq.msg_body.msg_content.setHasFlag(false);
                msg_svc_pbsendmsgreq.msg_body.rich_text.setHasFlag(true);
                msg_svc_pbsendmsgreq.msg_body.rich_text.trans_211_tmp_msg.setHasFlag(true);
                msg_svc_pbsendmsgreq.msg_body.rich_text.trans_211_tmp_msg.bytes_msg_body.set(ByteStringMicro.copyFrom(acVar.f286178b));
                msg_svc_pbsendmsgreq.msg_body.rich_text.trans_211_tmp_msg.uint32_c2c_cmd.set(4);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "tmpsession Bug msgContext or msgContext.msg null!");
            }
        }
    }

    private void P(FileManagerEntity fileManagerEntity, msg_svc$RoutingHead msg_svc_routinghead) {
        msg_svc_routinghead.comm_tmp.to_uin.set(Long.parseLong(fileManagerEntity.peerUin));
        byte[] bArr = fileManagerEntity.tmpSessionSig;
        if (bArr != null && bArr.length > 0) {
            msg_svc_routinghead.comm_tmp.sig.set(ByteStringMicro.copyFrom(bArr));
        }
        msg_svc_routinghead.comm_tmp.c2c_type.set(1);
        msg_svc_routinghead.comm_tmp.svr_type.set(149);
        msg_svc_routinghead.comm_tmp.setHasFlag(true);
        msg_svc_routinghead.setHasFlag(true);
    }

    private void R(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        if (bVar == null) {
            S(toServiceMsg, fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("wk", 2, "onReceive, MessageConstants.CMD_TRANSSERVICE_REQOFFFILEPACK: " + ((int) bVar.f286296k));
        }
        byte b16 = bVar.f286296k;
        if (b16 == 6) {
            T(toServiceMsg, fromServiceMsg, bVar);
        } else if (b16 == 2) {
            e0(toServiceMsg, fromServiceMsg, bVar);
        } else if (b16 == 1) {
            U(toServiceMsg, fromServiceMsg, bVar);
        }
    }

    private void T(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        if (bVar == null) {
            this.f116343b.handleError(toServiceMsg, fromServiceMsg);
            return;
        }
        int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
        StatictisInfo statictisInfo = new StatictisInfo();
        statictisInfo.errCode = fromServiceMsg.getResultCode();
        statictisInfo.retryCount = i3;
        this.f116343b.notifyCallBack(toServiceMsg, 5003, true, new Object[]{bVar.f286298m, statictisInfo});
    }

    private void U(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        if (bVar != null && bVar.f286287b == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("wk", 2, "handleSendOfflineFileResp-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
            }
            int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = fromServiceMsg.getResultCode();
            statictisInfo.retryCount = i3;
            this.f116343b.notifyCallBack(toServiceMsg, 5004, true, new Object[]{bVar, statictisInfo});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("wk", 2, "handleSendOfflineFileResp-->handleError");
        }
        this.f116343b.handleError(toServiceMsg, fromServiceMsg);
    }

    private void V(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, String str2, int i3, int i16, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp) {
        if (529 == i3) {
            if (i16 != 1025) {
                if (i16 != 1055) {
                    if (i16 != 1028) {
                        if (i16 != 1029) {
                            if (i16 != 1032) {
                                if (i16 != 1033) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + i16);
                                        return;
                                    }
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync suc");
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file suc");
                            }
                            ((QQAppInterface) this.f116342a).getQlinkServiceMgr().c(toServiceMsg.extraData.getLong("sessionid"));
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt suc");
                            return;
                        }
                        return;
                    }
                    if (msg_svc_pbsendmsgresp.send_time.has()) {
                        Q(str2 + String.valueOf(msg_svc_pbsendmsgresp.send_time.get()));
                    }
                    ((QQAppInterface) this.f116342a).getFileTransferHandler().W(toServiceMsg, fromServiceMsg, toServiceMsg.extraData.getLong("sessionid"));
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  suc");
                        return;
                    }
                    return;
                }
                ((QQAppInterface) this.f116342a).getFileTransferHandler().s0(toServiceMsg, fromServiceMsg);
                return;
            }
            ((QQAppInterface) this.f116342a).getFileTransferHandler().Y(str, toServiceMsg.extraData.getLong("sessionid"), true);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + i3);
        }
    }

    private void Y(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp;
        int i3;
        String str2;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp");
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        long j3 = toServiceMsg.extraData.getLong("uniseq");
        long j16 = toServiceMsg.extraData.getLong("queueSeq");
        long j17 = toServiceMsg.extraData.getLong("msgSeq");
        String string = toServiceMsg.extraData.getString("uin");
        String string2 = toServiceMsg.extraData.getString("uuid");
        int i16 = toServiceMsg.extraData.getInt("transC2CCmd");
        int i17 = toServiceMsg.extraData.getInt(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY);
        long j18 = toServiceMsg.extraData.getLong("tmpSessionType");
        try {
            msg_svc_pbsendmsgresp = new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
            str = string2;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                str = string2;
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp::invalid.", e16);
            } else {
                str = string2;
            }
            msg_svc_pbsendmsgresp = null;
        }
        if (msg_svc_pbsendmsgresp != null && msg_svc_pbsendmsgresp.result.has()) {
            if (msg_svc_pbsendmsgresp.result.get() != 0) {
                i3 = msg_svc_pbsendmsgresp.result.get();
            } else {
                i3 = 0;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
            }
            i3 = 4;
        }
        msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp2 = msg_svc_pbsendmsgresp;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:");
            sb5.append(serviceCmd);
            str2 = serviceCmd;
            sb5.append("----replyCode:");
            sb5.append(i3);
            sb5.append(",sendC2CMessage resp : peerUin:");
            sb5.append(string);
            sb5.append(",uniseq:");
            sb5.append(j3);
            sb5.append(",msgSeq:");
            sb5.append(j17);
            sb5.append(",transc2ccmd:");
            sb5.append(i16);
            QLog.d("Q.msg.BaseMessageProcessor", 2, sb5.toString());
        } else {
            str2 = serviceCmd;
        }
        fromServiceMsg.extraData.putLong("ServerReplyCode", i3);
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j16);
        if (handlerFromQueue == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExResp: ---cmd:" + str2 + ",no SendMessageHandler found.");
                return;
            }
            return;
        }
        if (i3 == 255) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.f116343b.retrySendMessage(handlerFromQueue, "server")) {
            return;
        }
        b0(toServiceMsg, fromServiceMsg, j3, j16, j17, string, str, i16, i17, j18, i3, msg_svc_pbsendmsgresp2);
    }

    private void Z(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp");
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        String string = toServiceMsg.extraData.getString("uin");
        int i16 = toServiceMsg.extraData.getInt("transC2CCmd");
        try {
            msg_svc_pbsendmsgresp = new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp::invalid.", e16);
            }
            msg_svc_pbsendmsgresp = null;
        }
        boolean z16 = false;
        if (msg_svc_pbsendmsgresp != null && msg_svc_pbsendmsgresp.result.has()) {
            if (msg_svc_pbsendmsgresp.result.get() != 0) {
                i3 = msg_svc_pbsendmsgresp.result.get();
            } else {
                i3 = 0;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "server did not return a valid result code, use 4 instead.");
            }
            i3 = 4;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:" + serviceCmd + "----replyCode:" + i3 + ",sendC2CMessage resp : peerUin:" + string + ",msgSeq:" + j3 + ",transc2ccmd:" + i16);
        }
        fromServiceMsg.extraData.putLong("ServerReplyCode", i3);
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j3);
        if (handlerFromQueue == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageResp: ---cmd:" + serviceCmd + ",no SendMessageHandler found.");
                return;
            }
            return;
        }
        if (i3 == 255) {
            z16 = true;
        }
        if (z16 && this.f116343b.retrySendMessage(handlerFromQueue, "server")) {
            return;
        }
        a0(toServiceMsg, j3, string, i16, i3);
    }

    private void a0(ToServiceMsg toServiceMsg, long j3, String str, int i3, int i16) {
        if (i16 != 0 && i16 != 241) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send failed:" + i16 + ", transc2ccmd:" + i3);
            }
            this.f116343b.removeSendMessageHandler(j3);
            if (133 == i3) {
                ((QQAppInterface) this.f116342a).getFileTransferHandler().f0(str, toServiceMsg.extraData.getLong("sessionid"), false);
                return;
            } else {
                if (135 == i3) {
                    ((QQAppInterface) this.f116342a).getFileTransferHandler().Y(str, toServiceMsg.extraData.getLong("sessionid"), false);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : send successfully.");
        }
        this.f116343b.removeSendMessageHandler(j3);
        if (133 == i3) {
            ((QQAppInterface) this.f116342a).getFileTransferHandler().f0(str, toServiceMsg.extraData.getLong("sessionid"), true);
        }
        if (135 == i3) {
            ((QQAppInterface) this.f116342a).getFileTransferHandler().Y(str, toServiceMsg.extraData.getLong("sessionid"), true);
        } else if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageResp : can not handle transc2ccmd:" + i3);
        }
    }

    private void b0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, long j3, long j16, long j17, String str, String str2, int i3, int i16, long j18, int i17, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp) {
        if (i17 != 0 && i17 != 241) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send failed:" + i17 + ", transc2ccmd:" + i3);
            }
            if ((j18 == 100 || j18 == 127) && msg_svc_pbsendmsgresp != null && msg_svc_pbsendmsgresp.errmsg.has()) {
                c.c(this.f116342a, str, msg_svc_pbsendmsgresp.errmsg.get(), 1001, false, false);
                fromServiceMsg.setMsgFail();
                AppInterface appInterface = this.f116342a;
                ReportController.o(appInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, j18 == 100 ? "0" : "1", "" + i17, "", "");
            }
            this.f116343b.removeSendMessageHandler(j17);
            c0(toServiceMsg, fromServiceMsg, str, i3, i16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : send successfully.");
        }
        this.f116343b.removeSendMessageHandler(j16);
        if (msg_svc_pbsendmsgresp.send_time.has() && j3 != 0) {
            long j19 = msg_svc_pbsendmsgresp.send_time.get() & 4294967295L;
            this.f116343b.updateSendC2CMessageTimeByUniseq(str, 0, j3, j19);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "updateSendTransMsgTime: sendBuddyPb: respData.uSendTime:" + j19 + ",peerUin:" + str);
                V(toServiceMsg, fromServiceMsg, str, str2, i3, i16, msg_svc_pbsendmsgresp);
            }
        }
        V(toServiceMsg, fromServiceMsg, str, str2, i3, i16, msg_svc_pbsendmsgresp);
    }

    private void c0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, int i3, int i16) {
        if (529 == i3) {
            if (i16 != 1025) {
                if (i16 != 1055) {
                    if (i16 != 1028) {
                        if (i16 != 1029) {
                            if (i16 != 1032) {
                                if (i16 != 1033) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + i16);
                                        return;
                                    }
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file state sync fail");
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageProcessor", 2, "QLINK_<---handleSendTransMessageExResp : qlink send file fail");
                            }
                            ((QQAppInterface) this.f116342a).getQlinkServiceMgr().b(toServiceMsg.extraData.getLong("sessionid"));
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
                            return;
                        }
                        return;
                    }
                    ((QQAppInterface) this.f116342a).getFileTransferHandler().W(toServiceMsg, fromServiceMsg, toServiceMsg.extraData.getLong("sessionid"));
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
                        return;
                    }
                    return;
                }
                ((QQAppInterface) this.f116342a).getFileTransferHandler().s0(toServiceMsg, fromServiceMsg);
                return;
            }
            ((QQAppInterface) this.f116342a).getFileTransferHandler().Y(str, toServiceMsg.extraData.getLong("sessionid"), false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("Q.msg.BaseMessageProcessor", 2, "<---handleSendTransMessageExResp : can not handle transc2ccmd:" + i3);
        }
    }

    private void d0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, int i3, int i16) {
        if (529 == i3) {
            if (i16 != 1025) {
                if (i16 != 1033) {
                    if (i16 != 1055) {
                        if (i16 != 1028) {
                            if (i16 != 1029) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : should not come here for the moment, busiType" + i16);
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send file receipt fail");
                                return;
                            }
                            return;
                        }
                        ((QQAppInterface) this.f116342a).getFileTransferHandler().W(toServiceMsg, fromServiceMsg, toServiceMsg.extraData.getLong("sessionid"));
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExResp : send offline file  fail");
                            return;
                        }
                        return;
                    }
                    ((QQAppInterface) this.f116342a).getFileTransferHandler().s0(toServiceMsg, fromServiceMsg);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---handleSendTransMessageExError : qlink send file state fail");
                    return;
                }
                return;
            }
            ((QQAppInterface) this.f116342a).getFileTransferHandler().Y(str, toServiceMsg.extraData.getLong("sessionid"), false);
        }
    }

    private void e0(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, k.b bVar) {
        if (bVar != null && bVar.f286287b == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("wk", 2, "handleSetOfflineFileState-->notify NOTIFY_TYPE_SEND_OFFLINE_FILE");
            }
            int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = fromServiceMsg.getResultCode();
            statictisInfo.retryCount = i3;
            this.f116343b.notifyCallBack(toServiceMsg, 5005, true, new Object[]{bVar, statictisInfo});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("wk", 2, "handleSetOfflineFileState-->handleError");
        }
        this.f116343b.handleError(toServiceMsg, fromServiceMsg);
    }

    public boolean Q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.f196025v.contains(str)) {
            if (this.f196025v.size() >= 20) {
                this.f196025v.remove(0);
            }
            this.f196025v.add(str);
            return false;
        }
        return true;
    }

    public void S(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
        if (QLog.isColorLevel()) {
            QLog.d("wk", 2, "handleReqOffFilePackError, count: " + i3);
        }
        if (i3 < 2) {
            toServiceMsg.extraData.putInt("retryIndex", i3 + 1);
            this.f116343b.send(toServiceMsg);
            return;
        }
        StatictisInfo statictisInfo = new StatictisInfo();
        statictisInfo.errCode = fromServiceMsg.getResultCode();
        statictisInfo.retryCount = i3;
        if (fromServiceMsg.getResultCode() == 1000) {
            statictisInfo.errCode = BaseConstants.CODE_SERVER_RETURN_ERROR;
            statictisInfo.detailErrorReason = fromServiceMsg.extraData.getLong("ServerReplyCode", StatictisInfo.DETAIL_REASON_UNKNOWN);
        }
        statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
        String string = toServiceMsg.extraData.getString("uin");
        if (toServiceMsg.extraData.getInt("offfile_type") == 0) {
            this.f116343b.notifyCallBack(toServiceMsg, 3006, false, string);
            return;
        }
        if (toServiceMsg.extraData.getInt("offfile_type") == 1) {
            this.f116343b.notifyCallBack(toServiceMsg, 5003, false, new Object[]{string, statictisInfo});
        } else if (toServiceMsg.extraData.getInt("offfile_type") == 2) {
            this.f116343b.notifyCallBack(toServiceMsg, 5005, false, new Object[]{string, statictisInfo});
        } else if (toServiceMsg.extraData.getInt("offfile_type") == 3) {
            this.f116343b.notifyCallBack(toServiceMsg, 5004, false, new Object[]{string, statictisInfo});
        }
    }

    public void W(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        long j3 = toServiceMsg.extraData.getLong("msgSeq");
        String string = toServiceMsg.extraData.getString("uin");
        long j16 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        int i3 = toServiceMsg.extraData.getInt("transC2CCmd");
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><E><---handleSendTransMessageError: ---cmd:" + serviceCmd + ",sendC2CMessage error : peerUin:" + string + ",msgSeq:" + j3 + ",transc2ccmd:" + i3);
        }
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageError, msf said:RESNDMSG");
                }
                if (this.f116343b.retrySendMessage(handlerFromQueue, "msf")) {
                    return;
                }
            }
            if (480000 == j16 || handlerFromQueue.c()) {
                this.f116343b.removeSendMessageHandler(j3);
                if (133 == i3) {
                    ((QQAppInterface) this.f116342a).getFileTransferHandler().f0(string, toServiceMsg.extraData.getLong("sessionid"), false);
                } else if (135 == i3) {
                    ((QQAppInterface) this.f116342a).getFileTransferHandler().Y(string, toServiceMsg.extraData.getLong("sessionid"), false);
                }
            }
        }
    }

    public void X(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        long j16 = toServiceMsg.extraData.getLong("uniseq");
        long j17 = toServiceMsg.extraData.getLong("queueSeq");
        long j18 = toServiceMsg.extraData.getLong("msgSeq");
        String string = toServiceMsg.extraData.getString("uin");
        long j19 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        int i3 = toServiceMsg.extraData.getInt("transC2CCmd");
        int i16 = toServiceMsg.extraData.getInt(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            j3 = j19;
            sb5.append("<PbSendMsg><E><---handleSendTransMessageExError: ---cmd:");
            sb5.append(serviceCmd);
            sb5.append(",sendC2CMessage error : peerUin:");
            sb5.append(string);
            sb5.append(",uniseq:");
            sb5.append(j16);
            sb5.append(",msgSeq:");
            sb5.append(j18);
            sb5.append(",transc2ccmd:");
            sb5.append(i3);
            QLog.d("Q.msg.BaseMessageProcessor", 2, sb5.toString());
        } else {
            j3 = j19;
        }
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j17);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "<PbSendMsg><R><---handleSendTransMessageExError, msf said:RESNDMSG");
                }
                if (this.f116343b.retrySendMessage(handlerFromQueue, "msf")) {
                    return;
                }
            }
            if (480000 == j3 || handlerFromQueue.c()) {
                this.f116343b.removeSendMessageHandler(j17);
                d0(toServiceMsg, fromServiceMsg, string, i3, i16);
            }
        }
    }

    public boolean f0(String str, int i3, byte[] bArr, FMTransC2CMsgInfo fMTransC2CMsgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), bArr, fMTransC2CMsgInfo)).booleanValue();
        }
        int i16 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i16 + 1;
        long j3 = i16;
        fMTransC2CMsgInfo.queueSeq = j3;
        s(true, true, true, j3, new a(str, fMTransC2CMsgInfo, i3, bArr));
        return true;
    }

    public boolean g0(String str, long j3, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, str, Long.valueOf(j3), Integer.valueOf(i3), bArr)).booleanValue();
        }
        int i16 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i16 + 1;
        long j16 = i16;
        s(true, true, true, j16, new b(str, j3, Math.abs(new Random().nextInt()), j16, i3, bArr));
        return true;
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        } else if (i3 == 7001) {
            S(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
            return;
        }
        switch (i3) {
            case 7001:
                if (objArr != null && objArr.length == 3) {
                    R((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], (k.b) objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            case 7002:
                if (objArr != null && objArr.length == 3) {
                    Z((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            case 7003:
                if (objArr != null && objArr.length == 3) {
                    Y((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
        } else if (i3 == 7001) {
            S(toServiceMsg, fromServiceMsg);
        }
    }
}
