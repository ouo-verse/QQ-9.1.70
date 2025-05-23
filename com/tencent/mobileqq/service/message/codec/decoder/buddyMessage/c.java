package com.tencent.mobileqq.service.message.codec.decoder.buddyMessage;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import localpb.richMsg.RichMsg$PicRec;
import localpb.richMsg.RichMsg$PttRec;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$NotOnlineFile;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements com.tencent.mobileqq.service.message.codec.decoder.d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(MessageHandler messageHandler, List<MessageRecord> list, int i3, msg_comm$Msg msg_comm_msg, long j3, boolean z16, boolean z17, boolean z18, long j16, boolean z19, int i16) {
        int i17;
        String substring;
        StringBuilder sb5 = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
        sb5.append(" c2cCmd:");
        sb5.append(i3);
        sb5.append(";friendUin:");
        sb5.append(j3);
        sb5.append(";isReaded:");
        sb5.append(z16);
        sb5.append(";isPullRoam:");
        sb5.append(z17);
        sb5.append(";isSelfSender:");
        sb5.append(z18);
        sb5.append(";\n");
        long j17 = msg_comm_msg.msg_head.get().msg_time.get();
        long j18 = msg_comm_msg.msg_head.get().from_uin.get();
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().rich_text.has()) {
            im_msg_body$RichText im_msg_body_richtext = msg_comm_msg.msg_body.get().rich_text.get();
            im_msg_body$NotOnlineFile im_msg_body_notonlinefile = im_msg_body_richtext.not_online_file.get();
            if (!im_msg_body_richtext.not_online_file.has()) {
                sb5.append("hasNotOnlineFile:");
                sb5.append(im_msg_body_richtext.not_online_file.has());
                sb5.append(";hasUUID:");
                sb5.append(im_msg_body_notonlinefile.bytes_file_uuid.has());
                if (QLog.isColorLevel()) {
                    QLog.d("OfflineFileDecoder", 2, sb5.toString());
                    return;
                }
                return;
            }
            if (i3 == 169 || i3 == 243) {
                if (z19) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("OfflineFileDecoder", 2, "<FileAssistant>offlineFile come: c2cCmd[" + i3 + "]");
                }
                messageHandler.Q.getFileTransferHandler().V(messageHandler, list, msg_comm_msg, im_msg_body_notonlinefile, String.valueOf(j3), z16, z17, j16, i16, null);
                return;
            }
            String str = im_msg_body_notonlinefile.bytes_file_uuid.get().toStringUtf8() + j17;
            String stringUtf8 = im_msg_body_notonlinefile.bytes_file_uuid.get().toStringUtf8();
            sb5.append("     NotOnLineFile info : serverPath:");
            sb5.append(stringUtf8);
            sb5.append(";fileKey :");
            sb5.append(str);
            sb5.append(";");
            if (!messageHandler.a3().Q(str)) {
                String stringUtf82 = im_msg_body_notonlinefile.bytes_file_name.get().toStringUtf8();
                sb5.append("strFileName:");
                sb5.append(stringUtf82);
                sb5.append(";");
                long j19 = im_msg_body_notonlinefile.uint64_file_size.get();
                String str2 = null;
                if (i3 != 241 && !s.k(stringUtf82, i3)) {
                    if (i3 == 242 || s.l(stringUtf82, i3)) {
                        if (!stringUtf82.equals("")) {
                            if (!stringUtf82.contains("_")) {
                                substring = stringUtf82.substring(0, stringUtf82.length() - 4);
                                i17 = 1;
                            } else {
                                i17 = 1;
                                substring = stringUtf82.substring(stringUtf82.lastIndexOf("_") + 1, stringUtf82.length() - 4);
                            }
                            String str3 = j18 + substring;
                            sb5.append("c2cCmd:0xf2;key:");
                            sb5.append(str3);
                            sb5.append(";");
                            if (!z19) {
                                if (com.tencent.mobileqq.streamtransfile.b.k(str3)) {
                                    sb5.append("DuplicateKey:");
                                    sb5.append(str3);
                                    sb5.append(";");
                                    if (QLog.isColorLevel()) {
                                        QLog.d("OfflineFileDecoder", 2, sb5.toString());
                                    }
                                    com.tencent.mobileqq.streamtransfile.b.y(str3);
                                    return;
                                }
                                com.tencent.mobileqq.streamtransfile.b.g(str3);
                            }
                        } else {
                            i17 = 1;
                            if (QLog.isColorLevel()) {
                                QLog.d("OfflineFileDecoder", 2, "offline ptt no filename");
                            }
                        }
                        str2 = TransfileUtile.makeTransFileProtocolData(stringUtf8, j19, 2, false, stringUtf8, null, "ftn");
                        RichMsg$PttRec richMsg$PttRec = new RichMsg$PttRec();
                        richMsg$PttRec.localPath.set(stringUtf8);
                        richMsg$PttRec.size.set(j19);
                        richMsg$PttRec.type.set(2);
                        richMsg$PttRec.uuid.set(stringUtf8);
                        richMsg$PttRec.isRead.set(false);
                        richMsg$PttRec.serverStorageSource.set("ftn");
                        richMsg$PttRec.isReport.set(0);
                        richMsg$PttRec.version.set(5);
                        richMsg$PttRec.msgRecTime.set(System.currentTimeMillis() / 1000);
                        richMsg$PttRec.msgTime.set(j17);
                        MessageForPtt messageForPtt = (MessageForPtt) q.d(-2002);
                        messageForPtt.msgtype = -2002;
                        messageForPtt.msgData = richMsg$PttRec.toByteArray();
                        messageForPtt.parse();
                        list.add(messageForPtt);
                        ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportPTTPV(messageHandler.Q, i17, false, 4);
                    }
                } else {
                    RichMsg$PicRec richMsg$PicRec = new RichMsg$PicRec();
                    richMsg$PicRec.localPath.set(stringUtf8);
                    richMsg$PicRec.size.set(j19);
                    richMsg$PicRec.type.set(1);
                    richMsg$PicRec.isRead.set(false);
                    richMsg$PicRec.uuid.set(stringUtf8);
                    richMsg$PicRec.serverStorageSource.set("ftn");
                    richMsg$PicRec.version.set(5);
                    richMsg$PicRec.isReport.set(0);
                    MessageForPic messageForPic = (MessageForPic) q.d(-2000);
                    messageForPic.msgtype = -2000;
                    messageForPic.msgData = richMsg$PicRec.toByteArray();
                    messageForPic.parse();
                    list.add(messageForPic);
                }
                sb5.append("protocolStr:");
                sb5.append(str2);
                sb5.append(";");
            } else {
                sb5.append("rcv a repeated offline file push msg");
            }
            if (QLog.isColorLevel()) {
                QLog.d("OfflineFileDecoder", 2, sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("OfflineFileDecoder", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + msg_comm_msg.msg_body.has() + "hasRichT:" + msg_comm_msg.msg_body.get().rich_text.has());
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        long j3 = msg_comm_msg.msg_head.from_uin.get();
        int i3 = msg_comm_msg.msg_head.c2c_cmd.get();
        long j16 = aVar.f286338a;
        boolean z17 = aVar.f286154i;
        boolean z18 = aVar.f286155j;
        if (j3 == aVar.f286148c) {
            z16 = true;
        } else {
            z16 = false;
        }
        c(messageHandler, list, i3, msg_comm_msg, j16, z17, z18, z16, aVar.f286151f, aVar.f286157l, aVar.f286152g);
    }
}
