package com.tencent.mobileqq.pic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class n extends a {
    static IPatchRedirector $redirector_;

    public static int i(AppInterface appInterface, int i3, String str) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && appInterface != null && ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).getTroopMask(str) == GroupMsgMask.ASSISTANT) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i3 == 3000) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (i3 == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (i3 == 10014) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (!z17) {
            if (z16) {
                return 0;
            }
            if (z18) {
                return 2;
            }
            if (z19) {
                return 3;
            }
            if (z26) {
                return 4;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i3, int i16, int i17) {
        return (i3 * 8) + (i16 * 2) + i17;
    }

    public static long k(AppInterface appInterface, String str, long j3) {
        long j16;
        String serverConfigValue;
        if (str == null) {
            return j3;
        }
        try {
            serverConfigValue = ((IDep) QRoute.api(IDep.class)).getServerConfigValue(appInterface, ServerConfigManager.ConfigType.common, str);
        } catch (Exception unused) {
        }
        if (serverConfigValue != null) {
            Long valueOf = Long.valueOf(serverConfigValue);
            j16 = valueOf.longValue();
            try {
                a.e(str, valueOf.longValue());
            } catch (Exception unused2) {
            }
            f.b("PIC_TAG_PRELOAD", "getLongConfig", "key:" + str + ",value:" + j16 + ",defValue:" + j3);
            return j16;
        }
        a.e(str, j3);
        j16 = j3;
        f.b("PIC_TAG_PRELOAD", "getLongConfig", "key:" + str + ",value:" + j16 + ",defValue:" + j3);
        return j16;
    }

    public static long[] l() {
        String string = a.f258588a.getString("PeakFlowTimePeriod", "20-23;0-1");
        if (string != null && string != "") {
            String[] split = string.split(";");
            if (split == null) {
                return new long[0];
            }
            long[] jArr = new long[split.length * 2];
            int i3 = 0;
            for (String str : split) {
                String[] split2 = str.split("-");
                if (split2 != null && split2.length == 2) {
                    jArr[i3] = Long.valueOf(split2[0]).longValue();
                    jArr[i3 + 1] = Long.valueOf(split2[1]).longValue();
                    i3 += 2;
                } else {
                    return new long[0];
                }
            }
            return jArr;
        }
        return new long[0];
    }

    public static void m(AppInterface appInterface, TransferRequest transferRequest) {
        if (transferRequest == null) {
            return;
        }
        MessageRecord messageRecord = transferRequest.mRec;
        if (!(messageRecord instanceof MessageForPic) || transferRequest.mFileType == 65537) {
            return;
        }
        MessageForPic messageForPic = (MessageForPic) messageRecord;
        f.b("PIC_TAG_PRELOAD", "updateDownState", "Before update, networkType:" + messageForPic.preDownNetworkType + ",state:" + messageForPic.preDownState + ",uniseq:" + messageForPic.uniseq);
        int i3 = transferRequest.mDownMode;
        if (i3 == 1) {
            messageForPic.preDownState = 1;
        } else if (i3 == 3) {
            messageForPic.preDownState = 4;
        } else {
            int i16 = messageForPic.preDownState;
            if (i16 != 1 && i16 != 4) {
                messageForPic.preDownState = 0;
            }
        }
        f.b("PIC_TAG_PRELOAD", "updateDownState", "After update, networkType:" + messageForPic.preDownNetworkType + ",state:" + messageForPic.preDownState + ",uniseq:" + messageForPic.uniseq);
        o(appInterface, messageForPic);
    }

    public static void n(AppInterface appInterface, MessageForPic messageForPic) {
        if (appInterface != null && messageForPic != null && messageForPic.preDownState == 0) {
            messageForPic.preDownState = 1;
            messageForPic.preDownNetworkType = a.a();
            f.b("PIC_TAG_PRELOAD", "updateDownState4SD", "networkType:" + messageForPic.preDownNetworkType + ",state:" + messageForPic.preDownState + ",uniseq:" + messageForPic.uniseq);
            o(appInterface, messageForPic);
        }
    }

    public static void o(AppInterface appInterface, MessageForPic messageForPic) {
        if (appInterface != null && messageForPic != null) {
            f.b("PIC_TAG_PRELOAD", "updateMsg", "uniseq:" + messageForPic.uniseq + ",network:" + messageForPic.preDownNetworkType + "state:" + messageForPic.preDownState);
            messageForPic.serial();
            MessageRecord queryMsgItemByUniseq = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq);
            if (messageForPic.subMsgId == MessageForPic.defaultSuMsgId) {
                if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(queryMsgItemByUniseq)) {
                    ((IMsgStructing) QRoute.api(IMsgStructing.class)).updateMsgAfterDownload(appInterface, queryMsgItemByUniseq, messageForPic);
                    return;
                } else {
                    ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForPic.frienduin, messageForPic.istroop, messageForPic.uniseq, messageForPic.msgData);
                    return;
                }
            }
            if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(queryMsgItemByUniseq)) {
                ((IMsgMixed) QRoute.api(IMsgMixed.class)).updateMsgAfterDownload(appInterface, queryMsgItemByUniseq, messageForPic);
            }
        }
    }
}
