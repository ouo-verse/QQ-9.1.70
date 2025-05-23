package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.resv.notonlinefile.tencent_im_msg_hummer_resv_notonlinefile$ResvAttr;
import tencent.im.msg.im_msg_body$NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21$FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21$ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3$FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3$ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        boolean z16;
        if (msg_comm_msg.msg_head.c2c_cmd.get() != 6 && !msg_comm_msg.msg_head.c2c_tmp_msg_head.has()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            new k().a(messageHandler, msg_comm_msg, list, aVar);
        }
        if (!msg_comm_msg.msg_head.c2c_tmp_msg_head.has()) {
            if (nx.a.b(BaseApplication.getContext(), String.valueOf(msg_comm_msg.msg_head.get().from_uin.get()))) {
                if (!com.tencent.qqnt.contact.friends.b.f355778a.c(String.valueOf(msg_comm_msg.msg_head.get().from_uin.get()), "MsgType0x211Decoder")) {
                    aVar.f286163r = 1025;
                }
            } else if (nx.a.b(BaseApplication.getContext(), String.valueOf(msg_comm_msg.msg_head.get().to_uin.get())) && !com.tencent.qqnt.contact.friends.b.f355778a.c(String.valueOf(msg_comm_msg.msg_head.get().to_uin.get()), "MsgType0x211Decoder")) {
                aVar.f286163r = 1025;
            }
        }
    }

    private int d(PBBytesField pBBytesField) {
        if (pBBytesField.has()) {
            byte[] byteArray = pBBytesField.get().toByteArray();
            try {
                tencent_im_msg_hummer_resv_notonlinefile$ResvAttr tencent_im_msg_hummer_resv_notonlinefile_resvattr = new tencent_im_msg_hummer_resv_notonlinefile$ResvAttr();
                tencent_im_msg_hummer_resv_notonlinefile_resvattr.mergeFrom(byteArray);
                return tencent_im_msg_hummer_resv_notonlinefile_resvattr.uint32_file_from_scene.get();
            } catch (Exception e16) {
                QLog.i("MsgType0x211Decoder", 2, "decodeFromSceneFlagForBuddyMsg err : ", e16);
                return 0;
            }
        }
        return 0;
    }

    private void e(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar, List<MessageRecord> list) {
        if (QLog.isDevelopLevel()) {
            QLog.d("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
        }
        if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().msg_content.has()) {
            try {
                byte[] byteArray = msg_comm_msg.msg_body.get().msg_content.get().toByteArray();
                int i3 = msg_comm_msg.msg_head.get().c2c_cmd.get();
                if (QLog.isDevelopLevel()) {
                    QLog.d("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i3 + "]");
                }
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 7) {
                            if (i3 != 8) {
                                if (i3 != 9) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i3 + "] is not implemented");
                                        return;
                                    }
                                    return;
                                }
                                i(messageHandler, msg_comm_msg, byteArray);
                                return;
                            }
                            h(messageHandler, msg_comm_msg, byteArray);
                            return;
                        }
                        return;
                    }
                    g(messageHandler, msg_comm_msg, aVar, list, byteArray);
                    return;
                }
                f(messageHandler, aVar, byteArray);
            } catch (Exception e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", e16);
                }
            }
        }
    }

    private void f(MessageHandler messageHandler, com.tencent.mobileqq.service.message.a aVar, byte[] bArr) {
        int i3;
        String str;
        SubMsgType0x3$MsgBody subMsgType0x3$MsgBody = new SubMsgType0x3$MsgBody();
        try {
            subMsgType0x3$MsgBody.mergeFrom(bArr);
            int i16 = 0;
            if (subMsgType0x3$MsgBody.msg_fail_notify.has()) {
                SubMsgType0x3$FailNotify subMsgType0x3$FailNotify = subMsgType0x3$MsgBody.msg_fail_notify.get();
                if (subMsgType0x3$FailNotify.uint32_sessionid.has()) {
                    int i17 = subMsgType0x3$FailNotify.uint32_sessionid.get();
                    if (subMsgType0x3$FailNotify.uint32_retCode.has()) {
                        i16 = subMsgType0x3$FailNotify.uint32_retCode.get();
                    } else if (QLog.isColorLevel()) {
                        QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + i17 + "], failNotify has not RetCode");
                    }
                    if (subMsgType0x3$FailNotify.bytes_reason.has()) {
                        str = new String(subMsgType0x3$FailNotify.bytes_reason.get().toStringUtf8());
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + i17 + "], failNotify has not reason");
                        }
                        str = "";
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + i17 + "], retCode[" + i16 + "], reason[" + str + "]");
                    }
                    messageHandler.Q.getFileTransferHandler().Z(String.valueOf(aVar.f286338a), i17, i16, str);
                    return;
                }
                if (QLog.isDebugVersion()) {
                    QLog.e("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
                    return;
                }
                return;
            }
            if (subMsgType0x3$MsgBody.msg_progress_notify.has()) {
                SubMsgType0x3$ProgressNotify subMsgType0x3$ProgressNotify = subMsgType0x3$MsgBody.msg_progress_notify.get();
                if (subMsgType0x3$ProgressNotify.uint32_sessionid.has()) {
                    int i18 = subMsgType0x3$ProgressNotify.uint32_sessionid.get();
                    if (subMsgType0x3$ProgressNotify.uint32_progress.has()) {
                        i3 = subMsgType0x3$ProgressNotify.uint32_progress.get();
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + i18 + "], progressNotify has not Progress");
                        }
                        i3 = 0;
                    }
                    if (subMsgType0x3$ProgressNotify.uint32_average_speed.has()) {
                        i16 = subMsgType0x3$ProgressNotify.uint32_average_speed.get();
                    } else if (QLog.isColorLevel()) {
                        QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + i18 + "], progressNotify has not AverageSpeed");
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + i18 + "], progress[" + i3 + "], speed[" + i16 + "]");
                    }
                    messageHandler.Q.getFileTransferHandler().a0(String.valueOf(aVar.f286338a), i18, i3, i16);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
                    return;
                }
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.e("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", e16);
            }
        }
    }

    private void g(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar, List<MessageRecord> list, byte[] bArr) {
        hummer_resv_21$ResvAttr hummer_resv_21_resvattr;
        hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo;
        if (QLog.isColorLevel()) {
            QLog.d("MsgType0x211Decoder", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
        }
        try {
            SubMsgType0x4$MsgBody mergeFrom = new SubMsgType0x4$MsgBody().mergeFrom(bArr);
            if (mergeFrom.msg_not_online_file.has()) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has  NotOnlineFile");
                }
                im_msg_body$NotOnlineFile im_msg_body_notonlinefile = mergeFrom.msg_not_online_file.get();
                if (mergeFrom.resv_attr.has()) {
                    hummer_resv_21_resvattr = mergeFrom.resv_attr.get();
                } else {
                    hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
                }
                hummer_resv_21$ResvAttr hummer_resv_21_resvattr2 = hummer_resv_21_resvattr;
                if (mergeFrom.file_image_info.has()) {
                    hummer_resv_21_fileimginfo = mergeFrom.file_image_info.get();
                    hummer_resv_21_resvattr2.file_image_info.set(hummer_resv_21_fileimginfo);
                } else {
                    hummer_resv_21_fileimginfo = null;
                }
                if (aVar.f286157l) {
                    MessageRecord messageRecord = new MessageRecord();
                    long j3 = msg_comm_msg.msg_head.get().msg_time.get();
                    long j16 = msg_comm_msg.msg_head.get().from_uin.get();
                    messageRecord.f203106msg = im_msg_body_notonlinefile.bytes_file_name.get().toStringUtf8();
                    messageRecord.senderuin = Long.toString(j16);
                    messageRecord.msgtype = -2005;
                    messageRecord.frienduin = Long.toString(aVar.f286338a);
                    messageRecord.time = j3;
                    if (hummer_resv_21_fileimginfo != null) {
                        messageRecord.saveExtInfoToExtStr("file_pic_width", String.valueOf(hummer_resv_21_fileimginfo.uint32_file_width.get()));
                        messageRecord.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(hummer_resv_21_fileimginfo.uint32_file_height.get()));
                        QLog.i("MsgType0x211Decoder", 1, "Insert ThumbSize toMsg height[" + hummer_resv_21_fileimginfo.uint32_file_width.get() + "], width[" + hummer_resv_21_fileimginfo.uint32_file_height.get() + "]");
                    }
                    list.add(messageRecord);
                } else {
                    messageHandler.Q.getFileTransferHandler().V(messageHandler, list, msg_comm_msg, im_msg_body_notonlinefile, String.valueOf(aVar.f286338a), aVar.f286154i, aVar.f286155j, aVar.f286151f, aVar.f286152g, hummer_resv_21_resvattr2);
                }
                if (!list.isEmpty()) {
                    com.tencent.mobileqq.filemanager.util.k.c(list.get(0), d(im_msg_body_notonlinefile.bytes_pb_reserve));
                    return;
                }
                return;
            }
            if (mergeFrom.msg_wlan_recved_notify.has()) {
                if (QLog.isDevelopLevel()) {
                    QLog.e("MsgType0x211Decoder", 4, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has  msg_wlan_recved_notify");
                }
                messageHandler.Q.getFileTransferHandler().t0(mergeFrom.msg_wlan_recved_notify.get());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", e16);
            }
        }
    }

    private void h(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, byte[] bArr) {
        byte[] bArr2;
        long j3 = msg_comm_msg.msg_head.get().from_uin.get();
        int i3 = msg_comm_msg.msg_head.get().msg_seq.get();
        long j16 = msg_comm_msg.msg_head.get().msg_uid.get();
        long j17 = msg_comm_msg.msg_head.get().msg_time.get();
        if (msg_comm_msg.msg_head.get().c2c_tmp_msg_head.has()) {
            byte[] byteArray = msg_comm_msg.msg_head.get().c2c_tmp_msg_head.get().toByteArray();
            try {
                byte[] byteArray2 = msg_comm_msg.msg_head.get().c2c_tmp_msg_head.get().sig.get().toByteArray();
                if (byteArray2 != null) {
                    ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).addTmpSig(String.valueOf(j3), byteArray2);
                }
            } catch (Exception unused) {
            }
            bArr2 = byteArray;
        } else {
            bArr2 = null;
        }
        messageHandler.Q.getQlinkServiceMgr().d(j3, i3, j16, j17, bArr2, bArr);
    }

    private void i(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, byte[] bArr) {
        if (QLog.isDevelopLevel()) {
            QLog.d("MsgType0x211Decoder", 4, "<dataline printer> message come: cmd[0x211, 0x9]");
        }
        try {
            ((DataLineHandler) messageHandler.Q.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).G3(msg_comm_msg, new C2CType0x211_SubC2CType0x9$MsgBody().mergeFrom(bArr));
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MsgType0x211Decoder", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
        } else {
            c(messageHandler, msg_comm_msg, list, aVar);
            e(messageHandler, msg_comm_msg, aVar, list);
        }
    }
}
