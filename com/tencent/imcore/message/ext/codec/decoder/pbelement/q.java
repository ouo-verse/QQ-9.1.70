package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GroupFile;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.resv21.hummer_resv_21$ResvAttr;

/* compiled from: P */
/* loaded from: classes7.dex */
public class q extends af {
    static IPatchRedirector $redirector_;

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(2:21|22)|23|(2:25|(11:27|28|(5:30|31|32|33|(8:35|36|(1:38)(1:50)|39|40|41|42|(2:44|45)(1:46)))|54|36|(0)(0)|39|40|41|42|(0)(0)))|55|28|(0)|54|36|(0)(0)|39|40|41|42|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x019f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01a0, code lost:
    
        r0.printStackTrace();
        com.tencent.qphone.base.util.QLog.e("GroupFileElemDecoder", 1, "internalDiscOfflineFile: Exception is " + r0.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg) {
        im_msg_body$GroupFile im_msg_body_groupfile;
        long j3;
        String str;
        long j16;
        String str2;
        int i3;
        int i16;
        boolean z16;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        MessageHandler msgHandler = qQAppInterface.getMsgHandler();
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.group_file.has()) {
                    im_msg_body_groupfile = next.group_file.get();
                    break;
                }
            } else {
                im_msg_body_groupfile = null;
                break;
            }
        }
        im_msg_body$GroupFile im_msg_body_groupfile2 = im_msg_body_groupfile;
        if (im_msg_body_groupfile2 == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:GroupFile;\n");
        }
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        if (msg_comm_msghead.discuss_info.has()) {
            j3 = msg_comm_msghead.discuss_info.get().discuss_uin.get();
        } else {
            j3 = 0;
        }
        long j17 = msg_comm_msghead.from_uin.get();
        long j18 = msg_comm_msghead.msg_time.get();
        long j19 = msg_comm_msghead.msg_seq.get();
        long longAccountUin = msgHandler.Q.getLongAccountUin();
        if (MessageHandlerUtils.msgFilter(msgHandler.Q, 3000, String.valueOf(j3), String.valueOf(j17), j18, j19)) {
            return;
        }
        try {
            str = new String(im_msg_body_groupfile2.bytes_filename.get().toByteArray(), "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            str = "";
        }
        String str3 = str;
        if (msg_comm_msg.msg_body.has()) {
            im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
            if (im_msg_body_msgbody.rich_text.attr.has()) {
                j16 = com.tencent.mobileqq.service.message.s.f(im_msg_body_msgbody.rich_text.attr.get().random.get());
                MessageForFile messageForFile = (MessageForFile) com.tencent.mobileqq.service.message.q.d(-2005);
                messageForFile.msgtype = -2005;
                if (im_msg_body_groupfile2.bytes_pb_reserve.has()) {
                    hummer_resv_21$ResvAttr hummer_resv_21_resvattr = new hummer_resv_21$ResvAttr();
                    try {
                        hummer_resv_21_resvattr.mergeFrom(im_msg_body_groupfile2.bytes_pb_reserve.get().toByteArray());
                    } catch (InvalidProtocolBufferMicroException e17) {
                        e17.printStackTrace();
                    }
                    if (hummer_resv_21_resvattr.file_image_info.has()) {
                        int i17 = hummer_resv_21_resvattr.file_image_info.uint32_file_height.get();
                        int i18 = hummer_resv_21_resvattr.file_image_info.uint32_file_width.get();
                        str2 = str3;
                        messageForFile.saveExtInfoToExtStr("file_pic_width", String.valueOf(i18));
                        messageForFile.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(i17));
                        i16 = i17;
                        i3 = i18;
                        String str4 = str2;
                        messageForFile.uniseq = msgHandler.Q.getFileTransferHandler().O(messageForFile.uniseq, j3, j17, j19, j16, j18, im_msg_body_groupfile2, i3, i16);
                        long j26 = im_msg_body_groupfile2.uint64_file_size.get();
                        if (j17 == longAccountUin) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        messageForFile.f203106msg = TransfileUtile.makeTransFileProtocolData(str4, j26, 0, z16);
                        messageForFile.doParse();
                        messageForFile.fileName = FileManagerUtil.getFileName(new String(im_msg_body_groupfile2.bytes_filename.get().toByteArray(), "UTF-8"));
                        list2.add(messageForFile);
                        ((AIOMessageSpreadManager) qQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).p(messageForFile);
                        if (QLog.isColorLevel()) {
                            QLog.d("GroupFileElemDecoder", 2, "GroupDiscFile.msg: " + im_msg_body_groupfile2.bytes_filename.get() + ";");
                            return;
                        }
                        return;
                    }
                }
                str2 = str3;
                i3 = 0;
                i16 = 0;
                String str42 = str2;
                messageForFile.uniseq = msgHandler.Q.getFileTransferHandler().O(messageForFile.uniseq, j3, j17, j19, j16, j18, im_msg_body_groupfile2, i3, i16);
                long j262 = im_msg_body_groupfile2.uint64_file_size.get();
                if (j17 == longAccountUin) {
                }
                messageForFile.f203106msg = TransfileUtile.makeTransFileProtocolData(str42, j262, 0, z16);
                messageForFile.doParse();
                messageForFile.fileName = FileManagerUtil.getFileName(new String(im_msg_body_groupfile2.bytes_filename.get().toByteArray(), "UTF-8"));
                list2.add(messageForFile);
                ((AIOMessageSpreadManager) qQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).p(messageForFile);
                if (QLog.isColorLevel()) {
                }
            }
        }
        j16 = 0;
        MessageForFile messageForFile2 = (MessageForFile) com.tencent.mobileqq.service.message.q.d(-2005);
        messageForFile2.msgtype = -2005;
        if (im_msg_body_groupfile2.bytes_pb_reserve.has()) {
        }
        str2 = str3;
        i3 = 0;
        i16 = 0;
        String str422 = str2;
        messageForFile2.uniseq = msgHandler.Q.getFileTransferHandler().O(messageForFile2.uniseq, j3, j17, j19, j16, j18, im_msg_body_groupfile2, i3, i16);
        long j2622 = im_msg_body_groupfile2.uint64_file_size.get();
        if (j17 == longAccountUin) {
        }
        messageForFile2.f203106msg = TransfileUtile.makeTransFileProtocolData(str422, j2622, 0, z16);
        messageForFile2.doParse();
        messageForFile2.fileName = FileManagerUtil.getFileName(new String(im_msg_body_groupfile2.bytes_filename.get().toByteArray(), "UTF-8"));
        list2.add(messageForFile2);
        ((AIOMessageSpreadManager) qQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).p(messageForFile2);
        if (QLog.isColorLevel()) {
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        d(list, list2, sb5, msg_comm_msg);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        return im_msg_body_elem.group_file.has();
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1000;
    }
}
