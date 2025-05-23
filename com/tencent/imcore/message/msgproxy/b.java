package com.tencent.imcore.message.msgproxy;

import android.text.TextUtils;
import com.tencent.bugly.library.BuglyAppVersionMode;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.s;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements ad.c {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static String[] l(String str) {
        if (str != null && str.length() > 0 && str.charAt(0) == 22) {
            return str.split("\\|");
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return f.e(messageRecord);
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean b(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (!(messageRecord instanceof MessageForText) && !(messageRecord instanceof MessageForPic) && !(messageRecord instanceof MessageForMixedMsg) && !(messageRecord instanceof MessageForReplyText)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        return s.j(i3);
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean d(MessageRecord messageRecord, MessageRecord messageRecord2) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord, (Object) messageRecord2)).booleanValue();
        }
        if ((messageRecord2 instanceof MessageForUniteGrayTip) && (messageRecord instanceof MessageForUniteGrayTip)) {
            MessageForUniteGrayTip messageForUniteGrayTip = (MessageForUniteGrayTip) messageRecord;
            g gVar2 = ((MessageForUniteGrayTip) messageRecord2).tipParam;
            if (gVar2 != null && (gVar = messageForUniteGrayTip.tipParam) != null && gVar2.f213691n > gVar.f213691n) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public MessageRecord e(ArrayList<MessageRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        }
        return new MessageForLongMsg(arrayList);
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean f(MessageRecord messageRecord) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (ad.M(messageRecord.msgtype) && (messageRecord instanceof MessageForUniteGrayTip) && (gVar = ((MessageForUniteGrayTip) messageRecord).tipParam) != null) {
            return gVar.f213695r;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 480;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean h(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
        }
        return ((QQAppInterface) appRuntime).getConversationFacade().j0(messageRecord.frienduin);
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean i(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return com.tencent.biz.anonymous.a.n(messageRecord);
    }

    @Override // com.tencent.imcore.message.ad.c
    public void j(Exception exc, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) exc, (Object) list);
        } else {
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(exc, " addToTailWhenException ");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.imcore.message.ad.c
    public boolean k(MessageRecord messageRecord, MessageRecord messageRecord2, String str, String str2) {
        MessageForPic messageForPic;
        String str3;
        MessageForPtt messageForPtt;
        String str4;
        MessageForPtt messageForPtt2;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, messageRecord, messageRecord2, str, str2)).booleanValue();
        }
        int i3 = messageRecord2.msgtype;
        if (i3 == -2002) {
            if (!(messageRecord2 instanceof MessageForPtt) || !(messageRecord instanceof MessageForPtt) || (str4 = (messageForPtt = (MessageForPtt) messageRecord).urlAtServer) == null || str4.length() <= 0 || (str5 = (messageForPtt2 = (MessageForPtt) messageRecord2).urlAtServer) == null || str5.length() <= 0) {
                return false;
            }
            return messageForPtt.urlAtServer.equals(messageForPtt2.urlAtServer);
        }
        if (i3 == -2011) {
            if (QLog.isColorLevel()) {
                QLog.d(BuglyAppVersionMode.DEBUG, 2, "c2c" + Arrays.toString(messageRecord.msgData) + ProgressTracer.SEPARATOR + Arrays.toString(messageRecord2.msgData));
            }
            return Arrays.equals(messageRecord2.msgData, messageRecord.msgData);
        }
        if (i3 == -2000) {
            if (str != null && str2 != null && str.length() > 0 && str2.length() > 0 && str.charAt(0) == 22 && str2.charAt(0) == 22) {
                String[] l3 = l(str2);
                String[] l16 = l(str);
                if (l3 == 0 || l16 == 0 || !l3[1].equals(l16[1]) || !l3[2].equals(l16[2])) {
                    return false;
                }
                if (messageRecord2.issend != 2 && !messageRecord2.isSendFromLocal()) {
                    if (str.contains(AppConstants.SDCARD_PATH)) {
                        String[] split = l16[0].split("/");
                        Object obj = split[split.length - 1].split("\\.")[0];
                        String md5 = MD5.toMD5(l3[4]);
                        if (md5.equals(obj)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + l3[1] + ",picType:" + l3[2] + ",Path:" + md5);
                            }
                            return true;
                        }
                    } else {
                        return l16[0].equals(l3[0]);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MsgProxyUtils", 2, "-------->compMsgContent: samePic: picSize:" + l3[1] + ",picType:" + l3[2] + ",isSend == true");
                    }
                    return true;
                }
            } else {
                MessageForPic messageForPic2 = (MessageForPic) messageRecord;
                String str6 = messageForPic2.uuid;
                if (str6 == null || str6.length() <= 0 || (str3 = (messageForPic = (MessageForPic) messageRecord2).uuid) == null || str3.length() <= 0) {
                    return false;
                }
                return messageForPic2.uuid.equals(messageForPic.uuid);
            }
        } else {
            if (i3 == -2007 && messageRecord.msgtype == -2007) {
                return Arrays.equals(messageRecord2.msgData, messageRecord.msgData);
            }
            if (i3 == -8018 && messageRecord.msgtype == -8018) {
                return Arrays.equals(messageRecord2.msgData, messageRecord.msgData);
            }
            if (i3 == -2058 && messageRecord.msgtype == -2058) {
                if (((messageRecord2 instanceof MessageForMarketFace) && (messageRecord instanceof MessageForMarketFace)) || (((messageRecord2 instanceof MessageForText) && (messageRecord instanceof MessageForText)) || ((messageRecord2 instanceof MessageForPic) && (messageRecord instanceof MessageForPic)))) {
                    return Arrays.equals(messageRecord2.msgData, messageRecord.msgData);
                }
            } else {
                if (i3 == -1035 && messageRecord.msgtype == -1035) {
                    return Arrays.equals(messageRecord2.msgData, messageRecord.msgData);
                }
                if (i3 == -1034 && messageRecord.msgtype == -1034) {
                    if (messageRecord2.time == messageRecord.time && messageRecord2.uniseq == messageRecord.uniseq) {
                        return true;
                    }
                    return false;
                }
                if (i3 == -1042 && messageRecord.msgtype == -1042) {
                    if (messageRecord2.time == messageRecord.time) {
                        return true;
                    }
                    return false;
                }
                if (i3 == -2015 && messageRecord.msgtype == -2015) {
                    if (messageRecord2.time == messageRecord.time && messageRecord2.uniseq == messageRecord.uniseq) {
                        return true;
                    }
                    return false;
                }
                if (i3 == -7007 && messageRecord.msgtype == -7007) {
                    if (messageRecord2.time == messageRecord.time && messageRecord2.uniseq == messageRecord.uniseq) {
                        return true;
                    }
                    return false;
                }
                if (i3 == -2060 && messageRecord.msgtype == -2060) {
                    return ((MessageForPLNews) messageRecord2).msgEquals((MessageForPLNews) messageRecord);
                }
                if (i3 != -2065 && i3 != -2062 && i3 != -4023 && i3 != -2066 && i3 != -7009 && i3 != -7010 && i3 != -7011 && i3 != -7012 && i3 != -7013 && i3 != -7015) {
                    if (i3 == -2005) {
                        if (!(messageRecord2 instanceof MessageForFile) || !(messageRecord instanceof MessageForFile)) {
                            return false;
                        }
                        if (messageRecord2.msgUid == messageRecord.msgUid && messageRecord2.msgseq == messageRecord.msgseq) {
                            return true;
                        }
                        return false;
                    }
                    if (i3 == -2017) {
                        return false;
                    }
                    if (i3 == -5008) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.MsgProxyUtils", 2, "AAShare.compMsgContent recRecord.msgUid=", Long.valueOf(messageRecord2.msgUid), ",cacheRecord.msgUid,", Long.valueOf(messageRecord.msgUid));
                        }
                        if (messageRecord2.msgUid == messageRecord.msgUid) {
                            return true;
                        }
                        return false;
                    }
                    if (i3 != -2022 && i3 != -2079) {
                        if (TextUtils.equals(str, str2)) {
                            return true;
                        }
                    } else {
                        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord2;
                        if (!TextUtils.isEmpty(messageForShortVideo.md5)) {
                            MessageForShortVideo messageForShortVideo2 = (MessageForShortVideo) messageRecord;
                            if (!TextUtils.isEmpty(messageForShortVideo2.md5)) {
                                return messageForShortVideo2.md5.equals(messageForShortVideo.md5);
                            }
                        }
                        if (!TextUtils.isEmpty(messageForShortVideo.uuid)) {
                            MessageForShortVideo messageForShortVideo3 = (MessageForShortVideo) messageRecord;
                            if (!TextUtils.isEmpty(messageForShortVideo3.uuid)) {
                                return messageForShortVideo3.uuid.equals(messageForShortVideo.uuid);
                            }
                        }
                        return false;
                    }
                } else {
                    if (messageRecord2.uniseq == messageRecord.uniseq) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
