package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import com.tencent.component.network.utils.Base64;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.ae;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.notonlinefile.tencent_im_msg_hummer_resv_notonlinefile$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GroupFile;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$NotOnlineFile;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$TransElem;
import tencent.im.msg.obj_msg$MsgContentInfo;
import tencent.im.msg.obj_msg$ObjMsg;
import tencent.im.msg.resv21.hummer_resv_21$FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21$ForwardExtFileInfo;
import tencent.im.msg.resv21.hummer_resv_21$ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4$MsgBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f207251a;

    public c(QQAppInterface qQAppInterface) {
        this.f207251a = qQAppInterface;
    }

    private boolean a(MessageRecord messageRecord) {
        if (messageRecord == null || TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("_m_ForwardFileType"))) {
            return false;
        }
        return true;
    }

    private boolean b(hummer_resv_21$ResvAttr hummer_resv_21_resvattr) {
        if (hummer_resv_21_resvattr == null) {
            return false;
        }
        return hummer_resv_21_resvattr.forward_ext_file_info.has();
    }

    private int e(PBBytesField pBBytesField) {
        if (pBBytesField.has()) {
            byte[] byteArray = pBBytesField.get().toByteArray();
            try {
                tencent_im_msg_hummer_resv_notonlinefile$ResvAttr tencent_im_msg_hummer_resv_notonlinefile_resvattr = new tencent_im_msg_hummer_resv_notonlinefile$ResvAttr();
                tencent_im_msg_hummer_resv_notonlinefile_resvattr.mergeFrom(byteArray);
                return tencent_im_msg_hummer_resv_notonlinefile_resvattr.uint32_file_from_scene.get();
            } catch (Exception e16) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeFromSceneFlagForBuddyMsg err : ", e16);
                return 0;
            }
        }
        return 0;
    }

    private void n(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, str2);
        }
    }

    public void c(ArrayList<MessageRecord> arrayList, ByteStringMicro byteStringMicro, msg_comm$Msg msg_comm_msg) {
        if (QLog.isColorLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeBuddyFilePBMsg: startTime[" + System.currentTimeMillis() + "]");
        }
        MessageRecord d16 = q.d(-2005);
        try {
            SubMsgType0x4$MsgBody mergeFrom = new SubMsgType0x4$MsgBody().mergeFrom(byteStringMicro.toByteArray());
            hummer_resv_21$ResvAttr hummer_resv_21_resvattr = mergeFrom.resv_attr.get();
            if (b(hummer_resv_21_resvattr)) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode multi buddy file message. " + QFileUtils.F(this.f207251a, d16, false));
                if (o(hummer_resv_21_resvattr, d16)) {
                    d16.isMultiMsg = true;
                    com.tencent.mobileqq.filemanager.util.k.d(d16, msg_comm_msg);
                    arrayList.add(d16);
                    return;
                }
                return;
            }
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy file message. " + QFileUtils.F(this.f207251a, d16, false));
            if (!mergeFrom.msg_not_online_file.has()) {
                return;
            }
            im_msg_body$NotOnlineFile im_msg_body_notonlinefile = mergeFrom.msg_not_online_file.get();
            if (im_msg_body_notonlinefile.bytes_file_name.has()) {
                String stringUtf8 = im_msg_body_notonlinefile.bytes_file_name.get().toStringUtf8();
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileName[" + stringUtf8 + "]");
                d16.saveExtInfoToExtStr("_backup_ForwardFileName", stringUtf8);
            } else {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileName is null");
            }
            if (im_msg_body_notonlinefile.uint32_file_type.has()) {
                int i3 = im_msg_body_notonlinefile.uint32_file_type.get();
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileType[" + i3 + "]");
                d16.saveExtInfoToExtStr("_backup_ForwardFileType", String.valueOf(i3));
            } else {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileType is null");
            }
            if (im_msg_body_notonlinefile.bytes_file_md5.has()) {
                d16.saveExtInfoToExtStr("_backup_ForwardMd5", vb1.a.b(im_msg_body_notonlinefile.bytes_file_md5.get().toByteArray()));
            }
            if (im_msg_body_notonlinefile.bytes_file_uuid.has()) {
                String stringUtf82 = im_msg_body_notonlinefile.bytes_file_uuid.get().toStringUtf8();
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy uuid[" + stringUtf82 + "]");
                d16.saveExtInfoToExtStr("_backup_ForwardUuid", stringUtf82);
            } else {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy uuid is null");
            }
            if (im_msg_body_notonlinefile.uint64_file_size.has()) {
                d16.saveExtInfoToExtStr("_backup_ForwardSize", String.valueOf(im_msg_body_notonlinefile.uint64_file_size.get()));
            }
            if (mergeFrom.file_image_info.has()) {
                hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo = mergeFrom.file_image_info.get();
                if (hummer_resv_21_fileimginfo.uint32_file_width.has()) {
                    d16.saveExtInfoToExtStr("_backup_ForwardImgWidth", hummer_resv_21_fileimginfo.uint32_file_width.get() + "");
                }
                if (hummer_resv_21_fileimginfo.uint32_file_height.has()) {
                    d16.saveExtInfoToExtStr("_backup_ForwardImgHeight", hummer_resv_21_fileimginfo.uint32_file_height.get() + "");
                }
            }
            com.tencent.mobileqq.filemanager.util.k.c(d16, e(im_msg_body_notonlinefile.bytes_pb_reserve));
            arrayList.add(d16);
            if (QLog.isColorLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeBuddyFilePBMsg: endTime[" + System.currentTimeMillis() + "]");
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", e16);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        r12 = r4.group_file.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
    
        if (r12.bytes_pb_reserve.has() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        com.tencent.qphone.base.util.QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : elem has not reserve info");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ac, code lost:
    
        r4 = r12.bytes_pb_reserve.get().toByteArray();
        r5 = new tencent.im.msg.resv21.hummer_resv_21$ResvAttr();
        r6 = (com.tencent.mobileqq.data.MessageForFile) com.tencent.mobileqq.service.message.q.d(-2005);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c3, code lost:
    
        r5.mergeFrom(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cb, code lost:
    
        if (b(r5) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00cd, code lost:
    
        com.tencent.qphone.base.util.QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode multi disc file message. " + com.tencent.mobileqq.filemanager.util.QFileUtils.F(r10.f207251a, r6, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ec, code lost:
    
        if (o(r5, r6) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ee, code lost:
    
        r6.isMultiMsg = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        r11.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0223, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f5, code lost:
    
        com.tencent.qphone.base.util.QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc file message. " + com.tencent.mobileqq.filemanager.util.QFileUtils.F(r10.f207251a, r6, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0116, code lost:
    
        if (r12.bytes_filename.has() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0118, code lost:
    
        r0 = r12.bytes_filename.get().toStringUtf8();
        com.tencent.qphone.base.util.QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileName[" + r0 + "]");
        r6.saveExtInfoToExtStr("_backup_ForwardFileName", com.tencent.mobileqq.filemanager.util.FileManagerUtil.getFileName(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0154, code lost:
    
        if (r12.uint64_file_size.has() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0156, code lost:
    
        r6.saveExtInfoToExtStr("_backup_ForwardSize", r12.uint64_file_size.get() + "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0177, code lost:
    
        if (r12.bytes_file_id.has() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0179, code lost:
    
        r12 = r12.bytes_file_id.get().toStringUtf8();
        com.tencent.qphone.base.util.QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileId[" + r12 + "]");
        r6.saveExtInfoToExtStr("_backup_ForwardUuid", r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ae, code lost:
    
        if (r5.file_image_info.has() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01b0, code lost:
    
        r12 = r5.file_image_info.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01be, code lost:
    
        if (r12.uint32_file_width.has() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01c0, code lost:
    
        r6.saveExtInfoToExtStr("_backup_ForwardImgWidth", r12.uint32_file_width.get() + "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01e1, code lost:
    
        if (r12.uint32_file_height.has() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01e3, code lost:
    
        r6.saveExtInfoToExtStr("_backup_ForwardImgHeight", r12.uint32_file_height.get() + "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01fe, code lost:
    
        r11.add(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0205, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0207, code lost:
    
        com.tencent.qphone.base.util.QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeDiscFilepb: endTime[" + java.lang.System.currentTimeMillis() + "]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a2, code lost:
    
        com.tencent.qphone.base.util.QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileId is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
    
        com.tencent.qphone.base.util.QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileName is null");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0224, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0225, code lost:
    
        r11.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(ArrayList<MessageRecord> arrayList, msg_comm$Msg msg_comm_msg) {
        if (QLog.isColorLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeDiscFilepb: startTime[" + System.currentTimeMillis() + "]");
        }
        if (msg_comm_msg == null) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : msg is null");
            return false;
        }
        if (!msg_comm_msg.msg_body.has()) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : msg has not body");
            return false;
        }
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
        if (!im_msg_body_msgbody.rich_text.has()) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : rich_text has not body");
            return false;
        }
        im_msg_body$RichText im_msg_body_richtext = im_msg_body_msgbody.rich_text.get();
        if (!im_msg_body_richtext.elems.has()) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : rich_text has not elems");
            return false;
        }
        Iterator<im_msg_body$Elem> it = im_msg_body_richtext.elems.get().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            im_msg_body$Elem next = it.next();
            if (next.group_file.has()) {
                break;
            }
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : elem has not group_file");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(ArrayList<MessageRecord> arrayList, msg_comm$Msg msg_comm_msg) {
        boolean z16;
        TroopFileData f16;
        TroopFileData a16;
        int i3 = 2;
        if (msg_comm_msg == null) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : msg is null");
            return false;
        }
        if (!msg_comm_msg.msg_body.has()) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : msg has not body");
            return false;
        }
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
        if (!im_msg_body_msgbody.rich_text.has()) {
            return false;
        }
        im_msg_body$RichText im_msg_body_richtext = im_msg_body_msgbody.rich_text.get();
        if (!im_msg_body_richtext.elems.has()) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : rich_text has not elems");
            return false;
        }
        boolean z17 = false;
        for (im_msg_body$Elem im_msg_body_elem : im_msg_body_richtext.elems.get()) {
            if (im_msg_body_elem.trans_elem_info.has()) {
                if (!im_msg_body_elem.trans_elem_info.has()) {
                    QLog.e("FileMultiMsgPackageHandle<QFile>", i3, "<FileAssistant>decodeGroupFilePb : elem has not trans_elem_info");
                } else {
                    im_msg_body$TransElem im_msg_body_transelem = im_msg_body_elem.trans_elem_info.get();
                    int i16 = im_msg_body_transelem.elem_type.get();
                    if (i16 != 24) {
                        QLog.e("FileMultiMsgPackageHandle<QFile>", i3, "<FileAssistant>decodeGroupFilePb : trans_elem_info type:" + i16);
                    } else {
                        int size = im_msg_body_transelem.elem_value.get().size();
                        byte[] byteArray = im_msg_body_transelem.elem_value.get().toByteArray();
                        int i17 = 0;
                        int i18 = 0;
                        boolean z18 = z17;
                        int i19 = size;
                        while (i19 > 3) {
                            int i26 = i18 + 1;
                            if (i18 > 100) {
                                break;
                            }
                            byte b16 = byteArray[i17];
                            int shortData = PkgTools.getShortData(byteArray, i17 + 1);
                            int i27 = shortData + 3;
                            int i28 = i19 - i27;
                            int i29 = i27 + i17;
                            if (b16 == 1) {
                                byte[] bArr = new byte[shortData];
                                PkgTools.copyData(bArr, 0, byteArray, i17 + 3, shortData);
                                try {
                                    obj_msg$ObjMsg mergeFrom = new obj_msg$ObjMsg().mergeFrom(bArr);
                                    if (mergeFrom.msg_content_info.get(0).msg_file.bytes_ext.has()) {
                                        try {
                                            byte[] decode = Base64.decode(new JSONObject(mergeFrom.msg_content_info.get(0).msg_file.bytes_ext.get().toStringUtf8()).optString("ExtInfo"), 0);
                                            hummer_resv_21$ResvAttr hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
                                            hummer_resv_21_resvattr.mergeFrom(decode);
                                            MessageRecord messageRecord = (MessageForTroopFile) q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
                                            if (o(hummer_resv_21_resvattr, messageRecord)) {
                                                arrayList.add(messageRecord);
                                                com.tencent.mobileqq.filemanager.util.k.d(messageRecord, msg_comm_msg);
                                                messageRecord.isMultiMsg = true;
                                                z16 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            z18 = true;
                                        } catch (Exception e16) {
                                            e16.printStackTrace();
                                        }
                                        if (!z16 && (f16 = TroopFileUtils.f(mergeFrom)) != null) {
                                            ae h16 = h(msg_comm_msg.msg_head.group_info.group_code.get());
                                            a16 = h16.a(this.f207251a, f16.fileUrl);
                                            if (a16 != null) {
                                                h16.c(this.f207251a, f16.fileUrl, f16);
                                            } else {
                                                f16 = a16;
                                            }
                                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
                                            messageForTroopFile.msgtype = MessageRecord.MSG_TYPE_TROOP_OBJ_MSG;
                                            messageForTroopFile.f203106msg = HardCodeUtil.qqStr(R.string.mjm);
                                            com.tencent.mobileqq.filemanager.util.k.d(messageForTroopFile, msg_comm_msg);
                                            try {
                                                messageForTroopFile.msgData = MessagePkgUtils.getBytesFromObject(f16);
                                            } catch (Exception e17) {
                                                e17.printStackTrace();
                                            }
                                            messageForTroopFile.parse();
                                            arrayList.add(messageForTroopFile);
                                            z18 = true;
                                        }
                                    }
                                    z16 = false;
                                    if (!z16) {
                                        ae h162 = h(msg_comm_msg.msg_head.group_info.group_code.get());
                                        a16 = h162.a(this.f207251a, f16.fileUrl);
                                        if (a16 != null) {
                                        }
                                        MessageForTroopFile messageForTroopFile2 = (MessageForTroopFile) q.d(MessageRecord.MSG_TYPE_TROOP_OBJ_MSG);
                                        messageForTroopFile2.msgtype = MessageRecord.MSG_TYPE_TROOP_OBJ_MSG;
                                        messageForTroopFile2.f203106msg = HardCodeUtil.qqStr(R.string.mjm);
                                        com.tencent.mobileqq.filemanager.util.k.d(messageForTroopFile2, msg_comm_msg);
                                        messageForTroopFile2.msgData = MessagePkgUtils.getBytesFromObject(f16);
                                        messageForTroopFile2.parse();
                                        arrayList.add(messageForTroopFile2);
                                        z18 = true;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            i18 = i26;
                            i17 = i29;
                            i19 = i28;
                        }
                        z17 = z18;
                    }
                }
            }
            i3 = 2;
        }
        return z17;
    }

    public im_msg_body$MsgBody g(int i3, MessageRecord messageRecord) {
        if (messageRecord == null) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "getMultiMsgBody : message is null");
            return null;
        }
        if (i3 == 1) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "process type:" + extInfoFromExtStr);
            if (TextUtils.isEmpty(extInfoFromExtStr)) {
                QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "getMultiMsgBody : message extInfo type null");
                return null;
            }
        }
        int i16 = messageRecord.istroop;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 3000) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "attention, this is a default way to handle, peerType[" + messageRecord.istroop + "] " + QFileUtils.E(this.f207251a, messageRecord));
                    }
                    return j(messageRecord);
                }
                return k(messageRecord);
            }
            return m(messageRecord);
        }
        return j(messageRecord);
    }

    public ae h(long j3) {
        return ae.b(j3);
    }

    public t i(MessageForTroopFile messageForTroopFile) {
        return TroopFileUtils.m(this.f207251a, messageForTroopFile);
    }

    public im_msg_body$MsgBody j(MessageRecord messageRecord) {
        im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
        SubMsgType0x4$MsgBody subMsgType0x4$MsgBody = new SubMsgType0x4$MsgBody();
        im_msg_body$NotOnlineFile im_msg_body_notonlinefile = new im_msg_body$NotOnlineFile();
        im_msg_body_notonlinefile.uint32_client_type.set(0);
        if (a(messageRecord)) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package multi buddy file message. " + QFileUtils.E(this.f207251a, messageRecord));
            FileManagerEntity E = this.f207251a.getFileManagerDataCenter().E(messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop);
            if (E != null && E.getCloudType() == 0) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package multi buddy file message but found online file." + QFileUtils.E(this.f207251a, messageRecord));
                return null;
            }
            hummer_resv_21$ResvAttr l3 = l(messageRecord);
            im_msg_body_notonlinefile.uint64_file_size.set(Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize")));
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            im_msg_body_notonlinefile.bytes_file_name.set(ByteStringMicro.copyFrom(extInfoFromExtStr.getBytes()));
            im_msg_body_notonlinefile.uint32_subcmd.set(2);
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                im_msg_body_notonlinefile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(extInfoFromExtStr2)));
            }
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage fileMd5 is " + extInfoFromExtStr2);
            subMsgType0x4$MsgBody.msg_not_online_file.set(im_msg_body_notonlinefile);
            int fileType = FileManagerUtil.getFileType(extInfoFromExtStr);
            if (fileType == 0 || fileType == 2) {
                String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
                String extInfoFromExtStr4 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
                if (!TextUtils.isEmpty(extInfoFromExtStr3) && !TextUtils.isEmpty(extInfoFromExtStr4)) {
                    hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo = new hummer_resv_21$FileImgInfo();
                    hummer_resv_21_fileimginfo.uint32_file_height.set(Integer.valueOf(extInfoFromExtStr4).intValue());
                    hummer_resv_21_fileimginfo.uint32_file_width.set(Integer.valueOf(extInfoFromExtStr3).intValue());
                    subMsgType0x4$MsgBody.file_image_info.set(hummer_resv_21_fileimginfo);
                }
            }
            subMsgType0x4$MsgBody.resv_attr.set(l3);
        } else {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package normal buddy file message. " + QFileUtils.E(this.f207251a, messageRecord));
            FileManagerEntity E2 = this.f207251a.getFileManagerDataCenter().E(messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop);
            if (E2 != null) {
                if (E2.getCloudType() == 0) {
                    QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package normal buddy file message but found online file." + QFileUtils.E(this.f207251a, messageRecord));
                    return null;
                }
                im_msg_body_notonlinefile.uint64_file_size.set(E2.fileSize);
                if (!TextUtils.isEmpty(E2.fileName)) {
                    im_msg_body_notonlinefile.bytes_file_name.set(ByteStringMicro.copyFrom(E2.fileName.getBytes()));
                } else {
                    QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: offline file name is null. " + QFileUtils.E(this.f207251a, messageRecord));
                }
                if (!TextUtils.isEmpty(E2.Uuid)) {
                    im_msg_body_notonlinefile.bytes_file_uuid.set(ByteStringMicro.copyFrom(E2.Uuid.getBytes()));
                } else {
                    QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: offline file uuid is null. " + QFileUtils.E(this.f207251a, messageRecord));
                }
                if (!TextUtils.isEmpty(E2.strFileMd5)) {
                    im_msg_body_notonlinefile.bytes_file_md5.set(ByteStringMicro.copyFrom(E2.strFileMd5.getBytes()));
                } else if (!TextUtils.isEmpty(E2.str10Md5)) {
                    im_msg_body_notonlinefile.bytes_file_md5.set(ByteStringMicro.copyFrom(E2.str10Md5.getBytes()));
                }
                hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo2 = new hummer_resv_21$FileImgInfo();
                int fileType2 = FileManagerUtil.getFileType(E2.fileName);
                if (fileType2 == 0 || fileType2 == 2) {
                    hummer_resv_21_fileimginfo2.uint32_file_width.set(E2.imgWidth);
                    hummer_resv_21_fileimginfo2.uint32_file_height.set(E2.imgHeight);
                }
                im_msg_body_notonlinefile.uint32_subcmd.set(2);
                subMsgType0x4$MsgBody.msg_not_online_file.set(im_msg_body_notonlinefile);
                subMsgType0x4$MsgBody.file_image_info.set(hummer_resv_21_fileimginfo2);
            } else {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage. error, get file entity is null. msgUniseq[" + messageRecord.uniseq + "]");
            }
        }
        im_msg_body_msgbody.msg_content.set(ByteStringMicro.copyFrom(subMsgType0x4$MsgBody.toByteArray()));
        return im_msg_body_msgbody;
    }

    public im_msg_body$MsgBody k(MessageRecord messageRecord) {
        im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body$GroupFile im_msg_body_groupfile = new im_msg_body$GroupFile();
        if (a(messageRecord)) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleDiscFileMessage: package multi disc file message. " + QFileUtils.E(this.f207251a, messageRecord));
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            im_msg_body_groupfile.bytes_filename.set(ByteStringMicro.copyFrom(extInfoFromExtStr.getBytes()));
            im_msg_body_groupfile.uint64_file_size.set(Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize")));
            im_msg_body_groupfile.bytes_file_id.set(ByteStringMicro.copyFrom(messageRecord.getExtInfoFromExtStr("_m_ForwardUuid").getBytes()));
            hummer_resv_21$ResvAttr l3 = l(messageRecord);
            int fileType = FileManagerUtil.getFileType(extInfoFromExtStr);
            if (fileType == 0 || fileType == 2) {
                String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
                String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
                if (!TextUtils.isEmpty(extInfoFromExtStr3) && !TextUtils.isEmpty(extInfoFromExtStr2)) {
                    hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo = new hummer_resv_21$FileImgInfo();
                    hummer_resv_21_fileimginfo.uint32_file_width.set(Integer.valueOf(extInfoFromExtStr2).intValue());
                    hummer_resv_21_fileimginfo.uint32_file_height.set(Integer.valueOf(extInfoFromExtStr3).intValue());
                    l3.file_image_info.set(hummer_resv_21_fileimginfo);
                }
            }
            im_msg_body_groupfile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(l3.toByteArray()));
        } else {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleDiscFileMessage: package normal disc file message. " + QFileUtils.E(this.f207251a, messageRecord));
            FileManagerEntity E = this.f207251a.getFileManagerDataCenter().E(messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop);
            if (E != null) {
                String str = E.fileName;
                im_msg_body_groupfile.bytes_filename.set(ByteStringMicro.copyFrom(str.getBytes()));
                im_msg_body_groupfile.uint64_file_size.set(E.fileSize);
                im_msg_body_groupfile.bytes_file_id.set(ByteStringMicro.copyFrom(E.Uuid.getBytes()));
                hummer_resv_21$ResvAttr hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
                hummer_resv_21$FileImgInfo hummer_resv_21_fileimginfo2 = new hummer_resv_21$FileImgInfo();
                int fileType2 = FileManagerUtil.getFileType(str);
                if (fileType2 == 0 || fileType2 == 2) {
                    hummer_resv_21_fileimginfo2.uint32_file_width.set(E.imgWidth);
                    hummer_resv_21_fileimginfo2.uint32_file_height.set(E.imgHeight);
                }
                hummer_resv_21_resvattr.file_image_info.set(hummer_resv_21_fileimginfo2);
                im_msg_body_groupfile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(hummer_resv_21_resvattr.toByteArray()));
            } else {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleDiscFileMessage. error, get file entity is null. msgUniseq[" + messageRecord.uniseq + "]");
            }
        }
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.group_file.set(im_msg_body_groupfile);
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        im_msg_body_msgbody.rich_text.set(im_msg_body_richtext);
        return im_msg_body_msgbody;
    }

    public hummer_resv_21$ResvAttr l(MessageRecord messageRecord) {
        hummer_resv_21$ResvAttr hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
        hummer_resv_21$ForwardExtFileInfo hummer_resv_21_forwardextfileinfo = new hummer_resv_21$ForwardExtFileInfo();
        int parseInt = Integer.parseInt(messageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileType:" + parseInt);
        }
        hummer_resv_21_forwardextfileinfo.uint32_file_type.set(parseInt);
        long parseLong = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin"));
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo sendUin:" + parseLong);
        }
        hummer_resv_21_forwardextfileinfo.uint64_sender_uin.set(parseLong);
        long parseLong2 = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin"));
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo recvUin:" + parseLong2);
        }
        hummer_resv_21_forwardextfileinfo.uint64_receiver_uin.set(parseLong2);
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileUuid:" + extInfoFromExtStr);
        }
        hummer_resv_21_forwardextfileinfo.bytes_file_uuid.set(ByteStringMicro.copyFrom(extInfoFromExtStr.getBytes()));
        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileIdCrc:" + extInfoFromExtStr2);
        }
        hummer_resv_21_forwardextfileinfo.str_fileidcrc.set(extInfoFromExtStr2);
        String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileName:" + extInfoFromExtStr3);
        }
        hummer_resv_21_forwardextfileinfo.str_file_name.set(extInfoFromExtStr3);
        long parseLong3 = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileSize:" + parseLong3);
        }
        hummer_resv_21_forwardextfileinfo.uint64_file_size.set(parseLong3);
        String extInfoFromExtStr4 = messageRecord.getExtInfoFromExtStr("_m_ForwardSha");
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo strSHA1:" + extInfoFromExtStr4);
        }
        hummer_resv_21_forwardextfileinfo.bytes_file_sha1.set(ByteStringMicro.copyFrom(extInfoFromExtStr4.getBytes()));
        String extInfoFromExtStr5 = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
        if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileMd5:" + extInfoFromExtStr5);
        }
        hummer_resv_21_forwardextfileinfo.bytes_file_md5.set(ByteStringMicro.copyFrom(extInfoFromExtStr5.getBytes()));
        String extInfoFromExtStr6 = messageRecord.getExtInfoFromExtStr("_m_ForwardDeadTime");
        if (!TextUtils.isEmpty(extInfoFromExtStr6)) {
            long parseLong4 = Long.parseLong(extInfoFromExtStr6);
            if (QLog.isDevelopLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo deadTime:" + extInfoFromExtStr6);
            }
            hummer_resv_21_forwardextfileinfo.int64_dead_time.set(parseLong4);
        }
        String extInfoFromExtStr7 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
        if (!TextUtils.isEmpty(extInfoFromExtStr7)) {
            int parseInt2 = Integer.parseInt(extInfoFromExtStr7);
            if (QLog.isDevelopLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo imgWidth:" + extInfoFromExtStr7);
            }
            hummer_resv_21_forwardextfileinfo.uint32_img_width.set(parseInt2);
        }
        String extInfoFromExtStr8 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
        if (!TextUtils.isEmpty(extInfoFromExtStr8)) {
            int parseInt3 = Integer.parseInt(extInfoFromExtStr8);
            if (QLog.isDevelopLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo imgWidth:" + extInfoFromExtStr8);
            }
            hummer_resv_21_forwardextfileinfo.uint32_img_height.set(parseInt3);
        }
        String extInfoFromExtStr9 = messageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
        if (!TextUtils.isEmpty(extInfoFromExtStr9)) {
            long parseLong5 = Long.parseLong(extInfoFromExtStr9);
            if (QLog.isDevelopLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo videoDur:" + extInfoFromExtStr9);
            }
            hummer_resv_21_forwardextfileinfo.uint64_video_duration.set(parseLong5);
        }
        String extInfoFromExtStr10 = messageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
        if (!TextUtils.isEmpty(extInfoFromExtStr10)) {
            int parseInt4 = Integer.parseInt(extInfoFromExtStr10);
            if (QLog.isDevelopLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo bizId:" + extInfoFromExtStr10);
            }
            hummer_resv_21_forwardextfileinfo.uint32_bus_id.set(parseInt4);
        }
        hummer_resv_21_resvattr.forward_ext_file_info.set(hummer_resv_21_forwardextfileinfo);
        return hummer_resv_21_resvattr;
    }

    public im_msg_body$MsgBody m(MessageRecord messageRecord) {
        im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
        obj_msg$ObjMsg obj_msg_objmsg = new obj_msg$ObjMsg();
        obj_msg$MsgContentInfo obj_msg_msgcontentinfo = new obj_msg$MsgContentInfo();
        obj_msg$MsgContentInfo.MsgFile msgFile = new obj_msg$MsgContentInfo.MsgFile();
        if (a(messageRecord)) {
            if (QLog.isColorLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "handleTroopFileMessage: package multi troop file message. " + QFileUtils.E(this.f207251a, messageRecord));
            }
            msgFile.bytes_file_path.set(ByteStringMicro.copyFrom(messageRecord.getExtInfoFromExtStr("_m_ForwardUuid").getBytes()));
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                msgFile.uint32_bus_id.set(Integer.parseInt(extInfoFromExtStr));
            }
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            msgFile.str_file_name.set(extInfoFromExtStr2);
            msgFile.uint64_file_size.set(Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize")));
            String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("_m_ForwardDeadTime");
            if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
                msgFile.int64_dead_time.set(Long.parseLong(extInfoFromExtStr3));
            }
            String extInfoFromExtStr4 = messageRecord.getExtInfoFromExtStr("_m_ForwardSha");
            if (extInfoFromExtStr4 != null) {
                msgFile.bytes_file_sha1.set(ByteStringMicro.copyFrom(extInfoFromExtStr4.getBytes()));
            }
            String extInfoFromExtStr5 = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            if (extInfoFromExtStr5 != null) {
                msgFile.bytes_file_md5.set(ByteStringMicro.copyFrom(extInfoFromExtStr5.getBytes()));
            }
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage fileMd5 is " + extInfoFromExtStr5);
            int fileType = FileManagerUtil.getFileType(extInfoFromExtStr2);
            JSONObject jSONObject = new JSONObject();
            if (fileType == 0 || fileType == 2) {
                try {
                    try {
                        int parseInt = Integer.parseInt(messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth"));
                        int parseInt2 = Integer.parseInt(messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight"));
                        jSONObject.put("width", parseInt);
                        jSONObject.put("height", parseInt2);
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                    String extInfoFromExtStr6 = messageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
                    if (!TextUtils.isEmpty(extInfoFromExtStr6)) {
                        jSONObject.put("duration", Integer.parseInt(extInfoFromExtStr6));
                    }
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
            jSONObject.put("ExtInfo", Base64.encodeToString(l(messageRecord).toByteArray(), 2));
            msgFile.bytes_ext.set(ByteStringMicro.copyFrom(jSONObject.toString().getBytes()));
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "handleTroopFileMessage: package normal troop file message. " + QFileUtils.E(this.f207251a, messageRecord));
            }
            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) messageRecord;
            t i3 = i(messageForTroopFile);
            if (i3 != null) {
                String str = i3.f294985s;
                if (!TextUtils.isEmpty(str)) {
                    msgFile.bytes_file_path.set(ByteStringMicro.copyFrom(str.getBytes()));
                    if (QLog.isDebugVersion()) {
                        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage: get troop fileId[" + str + "] " + QFileUtils.E(this.f207251a, messageRecord));
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "handleTroopFileMessage: error, can not get troop fileId. " + QFileUtils.E(this.f207251a, messageRecord));
                }
                msgFile.uint32_bus_id.set(i3.f294988v);
                String str2 = i3.f294987u;
                msgFile.str_file_name.set(str2);
                msgFile.uint64_file_size.set(i3.f294976j);
                msgFile.int64_dead_time.set(messageForTroopFile.lastTime);
                String str3 = i3.f294986t;
                if (!TextUtils.isEmpty(str3)) {
                    msgFile.bytes_file_sha1.set(ByteStringMicro.copyFrom(str3.getBytes()));
                } else if (QLog.isDebugVersion()) {
                    QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage: error, can not get sha. " + QFileUtils.E(this.f207251a, messageRecord));
                }
                int fileType2 = FileManagerUtil.getFileType(str2);
                JSONObject jSONObject2 = new JSONObject();
                if (fileType2 == 0 || fileType2 == 2) {
                    try {
                        try {
                            int i16 = messageForTroopFile.width;
                            int i17 = messageForTroopFile.height;
                            jSONObject2.put("width", i16);
                            jSONObject2.put("height", i17);
                        } catch (NumberFormatException e18) {
                            e18.printStackTrace();
                        }
                        jSONObject2.put("duration", messageForTroopFile.duration);
                    } catch (JSONException e19) {
                        e19.printStackTrace();
                    }
                }
                msgFile.bytes_ext.set(ByteStringMicro.copyFrom(jSONObject2.toString().getBytes()));
            }
        }
        obj_msg_msgcontentinfo.msg_file.set(msgFile);
        obj_msg_objmsg.uint32_msg_type.set(6);
        obj_msg_objmsg.msg_content_info.add(obj_msg_msgcontentinfo);
        im_msg_body$TransElem im_msg_body_transelem = new im_msg_body$TransElem();
        byte[] byteArray = obj_msg_objmsg.toByteArray();
        im_msg_body_transelem.elem_type.set(24);
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) byteArray.length);
        byte[] bArr = new byte[byteArray.length + 3];
        bArr[0] = 1;
        System.arraycopy(allocate.array(), 0, bArr, 1, 2);
        System.arraycopy(byteArray, 0, bArr, 3, byteArray.length);
        im_msg_body_transelem.elem_value.set(ByteStringMicro.copyFrom(bArr));
        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
        im_msg_body_elem.trans_elem_info.set(im_msg_body_transelem);
        im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
        im_msg_body_richtext.elems.add(im_msg_body_elem);
        im_msg_body_msgbody.rich_text.set(im_msg_body_richtext);
        return im_msg_body_msgbody;
    }

    public boolean o(hummer_resv_21$ResvAttr hummer_resv_21_resvattr, MessageRecord messageRecord) {
        if (!hummer_resv_21_resvattr.forward_ext_file_info.has()) {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "saveResvAttrToMr : resvAttr has no forward_ext_file_info");
            return false;
        }
        hummer_resv_21$ForwardExtFileInfo hummer_resv_21_forwardextfileinfo = hummer_resv_21_resvattr.forward_ext_file_info.get();
        if (!hummer_resv_21_forwardextfileinfo.uint32_file_type.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_file_type");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardFileType", String.valueOf(hummer_resv_21_forwardextfileinfo.uint32_file_type.get()));
        }
        if (!hummer_resv_21_forwardextfileinfo.uint64_sender_uin.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_sender_uin");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardSenderUin", String.valueOf(hummer_resv_21_forwardextfileinfo.uint64_sender_uin.get()));
        }
        if (!hummer_resv_21_forwardextfileinfo.uint64_receiver_uin.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_receiver_uin");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardReceiverUin", String.valueOf(hummer_resv_21_forwardextfileinfo.uint64_receiver_uin.get()));
        }
        if (!hummer_resv_21_forwardextfileinfo.bytes_file_uuid.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_uuid");
        } else {
            String str = new String(hummer_resv_21_forwardextfileinfo.bytes_file_uuid.get().toByteArray());
            messageRecord.saveExtInfoToExtStr("_m_ForwardUuid", str);
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr uuid:" + str);
        }
        if (hummer_resv_21_forwardextfileinfo.str_fileidcrc.has()) {
            String str2 = hummer_resv_21_forwardextfileinfo.str_fileidcrc.get();
            messageRecord.saveExtInfoToExtStr("_m_ForwardFileIdCrc", str2);
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr fileIdCrc:" + str2);
        }
        if (!hummer_resv_21_forwardextfileinfo.str_file_name.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no str_file_name");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardFileName", hummer_resv_21_forwardextfileinfo.str_file_name.get());
        }
        if (!hummer_resv_21_forwardextfileinfo.uint64_file_size.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_file_size");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(hummer_resv_21_forwardextfileinfo.uint64_file_size.get()));
        }
        if (!hummer_resv_21_forwardextfileinfo.bytes_file_sha1.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_sha1");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardSha", hummer_resv_21_forwardextfileinfo.bytes_file_sha1.get().toStringUtf8());
        }
        if (!hummer_resv_21_forwardextfileinfo.bytes_file_md5.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_md5");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardMd5", hummer_resv_21_forwardextfileinfo.bytes_file_md5.get().toStringUtf8());
        }
        if (!hummer_resv_21_forwardextfileinfo.uint32_bus_id.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_bus_id");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardBusType", hummer_resv_21_forwardextfileinfo.uint32_bus_id.get() + "");
        }
        if (!hummer_resv_21_forwardextfileinfo.int64_dead_time.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no int64_dead_time");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardDeadTime", String.valueOf(hummer_resv_21_forwardextfileinfo.int64_dead_time.get()));
        }
        if (!hummer_resv_21_forwardextfileinfo.uint32_img_width.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_img_width");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(hummer_resv_21_forwardextfileinfo.uint32_img_width.get()));
        }
        if (!hummer_resv_21_forwardextfileinfo.uint32_img_height.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_img_height");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(hummer_resv_21_forwardextfileinfo.uint32_img_height.get()));
        }
        if (!hummer_resv_21_forwardextfileinfo.uint64_video_duration.has()) {
            n("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_video_duration");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardDuration", String.valueOf(hummer_resv_21_forwardextfileinfo.uint64_video_duration.get()));
        }
        return true;
    }
}
