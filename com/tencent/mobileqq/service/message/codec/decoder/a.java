package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg$PicRec;
import msf.msgcomm.msg_comm$AppShareInfo;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$PluginInfo;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void c(BaseMessageHandler baseMessageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, long j3, long j16, boolean z16) {
        boolean z17;
        long j17;
        boolean z18;
        BaseMessageHandler baseMessageHandler2;
        boolean z19;
        boolean z26;
        msg_comm$AppShareInfo msg_comm_appshareinfo;
        long j18;
        boolean z27;
        String str;
        boolean z28;
        String str2;
        msg_comm$AppShareInfo msg_comm_appshareinfo2 = msg_comm_msg.appshare_info.get();
        if (msg_comm_msg.appshare_info.has()) {
            long j19 = msg_comm_appshareinfo2.appshare_id.get() & 4294967295L;
            msg_comm$PluginInfo msg_comm_plugininfo = msg_comm_appshareinfo2.appshare_resource.get();
            String str3 = "AppShareInfoDecoder";
            if (!msg_comm_appshareinfo2.appshare_resource.has() || msg_comm_plugininfo == null || z16) {
                z17 = false;
            } else {
                AppShareID a16 = com.tencent.mobileqq.utils.h.a(msg_comm_plugininfo);
                if (QLog.isColorLevel()) {
                    QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared appShareID:" + a16.toString());
                }
                AppShareID appShareID = (AppShareID) DBMethodProxy.find(baseMessageHandler.getEM(), AppShareID.class, "strPkgName=?", new String[]{a16.strPkgName});
                if (appShareID == null) {
                    baseMessageHandler.getEM().persist(a16);
                    if (QLog.isColorLevel()) {
                        QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared Persist DB appid = " + a16.strPkgName);
                    }
                } else if (a16.uiNewVer == appShareID.uiNewVer && Math.abs(appShareID.updateTime - a16.updateTime) <= 86400000) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared Not need update DB appid = " + a16.strPkgName);
                    }
                } else {
                    baseMessageHandler.getEM().remove(appShareID);
                    baseMessageHandler.getEM().persist(a16);
                    if (QLog.isColorLevel()) {
                        QLog.d("AppShareInfoDecoder", 2, "<--decodeC2CMsgPkg_AppShared Update DB appid = " + a16.strPkgName);
                    }
                }
                ((com.tencent.mobileqq.service.message.e) baseMessageHandler.getApp().getMsgCache()).e(a16.strPkgName, a16);
                z17 = true;
            }
            if (msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.get().rich_text.has()) {
                List<im_msg_body$Elem> list2 = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
                String string = BaseApplication.getContext().getString(R.string.him);
                Iterator<im_msg_body$Elem> it = list2.iterator();
                boolean z29 = false;
                boolean z36 = false;
                RichMsg$PicRec richMsg$PicRec = null;
                String str4 = null;
                while (it.hasNext()) {
                    im_msg_body$Elem next = it.next();
                    boolean has = next.text.has();
                    Iterator<im_msg_body$Elem> it5 = it;
                    boolean has2 = next.not_online_image.has();
                    if (has2) {
                        z36 = true;
                    }
                    if (has) {
                        z29 = true;
                    }
                    if (QLog.isColorLevel()) {
                        z19 = z29;
                        StringBuilder sb5 = new StringBuilder();
                        z26 = z36;
                        sb5.append("<--decodeC2CMsgPkg_AppShared hasText:");
                        sb5.append(has);
                        sb5.append(",hasNotOnlineImage:");
                        sb5.append(has2);
                        QLog.d(str3, 2, sb5.toString());
                    } else {
                        z19 = z29;
                        z26 = z36;
                    }
                    if (has2) {
                        im_msg_body$NotOnlineImage im_msg_body_notonlineimage = next.not_online_image.get();
                        int i3 = im_msg_body_notonlineimage.file_len.get();
                        if (im_msg_body_notonlineimage.download_path.has()) {
                            str2 = im_msg_body_notonlineimage.download_path.get().toStringUtf8();
                            if (QLog.isColorLevel()) {
                                QLog.d(str3, 2, "<--decodeC2CMsgPkg_AppShared: serverPath:" + str2);
                            }
                        } else {
                            str2 = null;
                        }
                        if (str2 != null) {
                            RichMsg$PicRec richMsg$PicRec2 = new RichMsg$PicRec();
                            richMsg$PicRec2.localPath.set(str2);
                            long j26 = i3;
                            richMsg$PicRec2.size.set(j26);
                            richMsg$PicRec2.type.set(1);
                            richMsg$PicRec2.uuid.set(str2);
                            String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(str2, j26, 1, false, str2);
                            if (QLog.isColorLevel()) {
                                QLog.d(str3, 2, "<--decodeC2CMsgPkg_AppShared: content:" + makeTransFileProtocolData);
                            }
                            richMsg$PicRec = richMsg$PicRec2;
                            string = makeTransFileProtocolData;
                        }
                    } else if (has) {
                        im_msg_body$Text im_msg_body_text = next.text.get();
                        str4 = im_msg_body_text.str.get().toStringUtf8();
                        if (QLog.isColorLevel()) {
                            QLog.d(str3, 2, "<--decodeC2CMsgPkg_AppShared actionUrl:" + str4 + ",hasLink:" + im_msg_body_text.link.has() + ",str:" + im_msg_body_text.str.has() + ",strC:" + im_msg_body_text.str.get().toStringUtf8());
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("<--decodeC2CMsgPkg_AppShared : bytes:");
                            sb6.append(im_msg_body_text.str.get().size());
                            sb6.append(",cont:");
                            sb6.append(im_msg_body_text.str.get());
                            sb6.append(",content:");
                            sb6.append(Arrays.toString(im_msg_body_text.str.get().toByteArray()));
                            QLog.d(str3, 2, sb6.toString());
                        }
                    } else {
                        if (next.custom_face.has()) {
                            im_msg_body$CustomFace im_msg_body_customface = next.custom_face.get();
                            String str5 = im_msg_body_customface.str_file_path.get();
                            String str6 = im_msg_body_customface.str_shortcut.get();
                            String str7 = im_msg_body_customface.str_big_url.get();
                            String str8 = im_msg_body_customface.str_orig_url.get();
                            String str9 = im_msg_body_customface.str_thumb_url.get();
                            long j27 = im_msg_body_customface.uint32_file_id.get() & 4294967295L;
                            z27 = z17;
                            msg_comm_appshareinfo = msg_comm_appshareinfo2;
                            j18 = j19;
                            long j28 = im_msg_body_customface.uint32_file_type.get() & 4294967295L;
                            long j29 = im_msg_body_customface.uint32_server_ip.get() & 4294967295L;
                            long j36 = im_msg_body_customface.uint32_server_port.get() & 4294967295L;
                            String str10 = str4;
                            String str11 = str3;
                            long j37 = im_msg_body_customface.uint32_useful.get() & 4294967295L;
                            byte[] byteArray = im_msg_body_customface.bytes_md5.get().toByteArray();
                            byte[] byteArray2 = im_msg_body_customface.bytes_signature.get().toByteArray();
                            byte[] byteArray3 = im_msg_body_customface.bytes_flag.get().toByteArray();
                            String bytes2HexStr = HexUtil.bytes2HexStr(byteArray);
                            String bytes2HexStr2 = HexUtil.bytes2HexStr(byteArray2);
                            String bytes2HexStr3 = HexUtil.bytes2HexStr(byteArray3);
                            if (QLog.isColorLevel()) {
                                str = str11;
                                QLog.d(str, 2, "<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:" + str5 + ", shortCut:" + str6 + ", fileID:" + j27 + ", fileType:" + j28 + ", serverIP:" + j29 + ", serverPort" + j36 + ", useful" + j37 + ",md5:" + bytes2HexStr + ",signature:" + bytes2HexStr2 + ",flag:" + bytes2HexStr3 + ",downURLBig:" + str7 + ",downURLOri:" + str8 + ",downURLThum:" + str9);
                            } else {
                                str = str11;
                            }
                            String str12 = "http://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=" + str5 + "&gid=" + j3 + "&time=" + j16 + "&msfid=" + baseMessageHandler.getApp().getCurrentAccountUin();
                            richMsg$PicRec = new RichMsg$PicRec();
                            richMsg$PicRec.localPath.set(str12);
                            richMsg$PicRec.size.set(0L);
                            z28 = true;
                            richMsg$PicRec.type.set(1);
                            richMsg$PicRec.uuid.set(str12);
                            string = TransfileUtile.makeTransFileProtocolData(str12, 0L, 1, false, str12);
                            z36 = true;
                            str4 = str10;
                        } else {
                            msg_comm_appshareinfo = msg_comm_appshareinfo2;
                            j18 = j19;
                            z27 = z17;
                            str = str3;
                            z28 = true;
                            z36 = z26;
                        }
                        str3 = str;
                        z29 = z19;
                        z17 = z27;
                        msg_comm_appshareinfo2 = msg_comm_appshareinfo;
                        j19 = j18;
                        it = it5;
                    }
                    msg_comm_appshareinfo = msg_comm_appshareinfo2;
                    j18 = j19;
                    z27 = z17;
                    str = str3;
                    z36 = z26;
                    z28 = true;
                    str3 = str;
                    z29 = z19;
                    z17 = z27;
                    msg_comm_appshareinfo2 = msg_comm_appshareinfo;
                    j19 = j18;
                    it = it5;
                }
                msg_comm$AppShareInfo msg_comm_appshareinfo3 = msg_comm_appshareinfo2;
                long j38 = j19;
                z18 = z17;
                String str13 = str3;
                String str14 = str4;
                if (z36 && !z29) {
                    MessageForPic messageForPic = (MessageForPic) q.d(-2000);
                    messageForPic.msgtype = -2000;
                    messageForPic.msgData = richMsg$PicRec.toByteArray();
                    messageForPic.f203106msg = string;
                    messageForPic.parse();
                    list.add(messageForPic);
                    baseMessageHandler2 = baseMessageHandler;
                    j17 = j38;
                } else {
                    if (!z36 && z29) {
                        MessageRecord messageRecord = (MessageForText) q.d(-1000);
                        messageRecord.msgtype = -1000;
                        messageRecord.f203106msg = str14;
                        list.add(messageRecord);
                        return;
                    }
                    if (str14 == null) {
                        return;
                    }
                    String trim = str14.trim();
                    if (QLog.isColorLevel()) {
                        QLog.d(str13, 2, "<--decodeC2CMsgPkg_AppShared: hasPicCnt:" + z36 + ",hasTextCnt:" + z29);
                    }
                    baseMessageHandler2 = baseMessageHandler;
                    com.tencent.mobileqq.app.handler.a.a(baseMessageHandler2, String.valueOf(com.tencent.mobileqq.utils.h.f(j38)));
                    c.a b16 = com.tencent.mobileqq.utils.c.b(msg_comm_appshareinfo3.appshare_cookie.get().toByteArray());
                    if (QLog.isColorLevel()) {
                        QLog.d(str13, 2, "<--decodeC2CMsgPkg_AppShared: content:" + string + ",opType:" + b16.f307514b);
                    }
                    j17 = j38;
                    String d16 = com.tencent.mobileqq.utils.c.d(string, trim, j17, b16.f307516d);
                    if (QLog.isColorLevel()) {
                        QLog.d(str13, 2, "<--decodeC2CMsgPkg_AppShared : content:" + string + ",encodeMsg:" + d16);
                    }
                    MessageRecord d17 = q.d(b16.f307514b);
                    d17.msgtype = b16.f307514b;
                    d17.f203106msg = d16;
                    list.add(d17);
                }
            } else {
                j17 = j19;
                z18 = z17;
                baseMessageHandler2 = baseMessageHandler;
            }
            if (z18) {
                return;
            }
            baseMessageHandler2.startGetShareAppIDInfo(Long.valueOf(j17));
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
        } else {
            if (!msg_comm_msg.appshare_info.has()) {
                return;
            }
            c(messageHandler, list, msg_comm_msg, 0L, 0L, aVar.f286157l);
        }
    }
}
