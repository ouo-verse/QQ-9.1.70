package com.tencent.mobileqq.graytip;

import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<MessageRecord> f213674a;

    /* renamed from: b, reason: collision with root package name */
    private static final c f213675b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f213674a = new ArrayList(1);
            f213675b = new c();
        }
    }

    @Deprecated(message = "\u8001\u7684\u5c0f\u7070\u6761\u63a5\u53e3\u5df2\u7ecf\u5e9f\u5f03\uff0c\u65b0\u7684NT\u63a5\u53e3\u4e3a com.tencent.qqnt.graytips.api.INtGrayTipApi.addLocalGrayTip")
    public static boolean a(AppRuntime appRuntime, MessageForUniteGrayTip messageForUniteGrayTip) {
        if (messageForUniteGrayTip == null || f213675b.a(appRuntime, messageForUniteGrayTip)) {
            return false;
        }
        if ((!messageForUniteGrayTip.tipParam.f213678a && !ad.D(messageForUniteGrayTip.msgtype)) || (!messageForUniteGrayTip.tipParam.f213680c && !ad.C(messageForUniteGrayTip.msgtype))) {
            if (QLog.isColorLevel()) {
                QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, error param");
            }
            return false;
        }
        if (b(appRuntime, messageForUniteGrayTip)) {
            return false;
        }
        ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).addMessage(messageForUniteGrayTip, appRuntime.getAccount(), false, messageForUniteGrayTip.tipParam.f213679b, true, !r0.f213690m);
        return true;
    }

    static boolean b(AppRuntime appRuntime, MessageForUniteGrayTip messageForUniteGrayTip) {
        g gVar;
        g gVar2;
        List<MessageRecord> msgList = ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).getMsgList(messageForUniteGrayTip.frienduin, messageForUniteGrayTip.istroop);
        if (msgList != null && !msgList.isEmpty()) {
            g gVar3 = messageForUniteGrayTip.tipParam;
            if (gVar3 != null && gVar3.f213693p != null) {
                for (MessageRecord messageRecord : msgList) {
                    if ((messageRecord instanceof MessageForUniteGrayTip) && (gVar2 = ((MessageForUniteGrayTip) messageRecord).tipParam) != null) {
                        g gVar4 = messageForUniteGrayTip.tipParam;
                        if (gVar4.f213685h == gVar2.f213685h && gVar4.f213693p.equals(gVar2.f213693p)) {
                            if (QLog.isColorLevel()) {
                                QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, repeat grayTip in cache");
                            }
                            return true;
                        }
                    }
                }
            }
            for (int size = msgList.size() - 1; size >= 0; size--) {
                if (msgList.size() - size <= 10 && (msgList.get(size) instanceof MessageForUniteGrayTip)) {
                    MessageForUniteGrayTip messageForUniteGrayTip2 = (MessageForUniteGrayTip) msgList.get(size);
                    if (messageForUniteGrayTip2.tipParam != null && (gVar = messageForUniteGrayTip.tipParam) != null) {
                        int[] iArr = gVar.f213692o;
                        if (iArr != null) {
                            for (int i3 : iArr) {
                                if (i3 == messageForUniteGrayTip2.tipParam.f213685h) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, mutex grayTip in cache");
                                    }
                                    return true;
                                }
                            }
                        }
                        int[] iArr2 = messageForUniteGrayTip2.tipParam.f213692o;
                        if (iArr2 != null) {
                            for (int i16 : iArr2) {
                                if (i16 == messageForUniteGrayTip.tipParam.f213685h) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, mutex grayTip in cache");
                                    }
                                    return true;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean c() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("reedit_revoke_msg");
    }

    public static void d(AppRuntime appRuntime, MessageForUniteGrayTip messageForUniteGrayTip) {
        if (f213674a.size() > 0) {
            ArrayList arrayList = new ArrayList(2);
            for (MessageRecord messageRecord : f213674a) {
                if (messageRecord.msgUid == messageForUniteGrayTip.msgUid) {
                    arrayList.add(messageRecord);
                }
            }
            if (arrayList.size() > 0) {
                messageForUniteGrayTip.updateUniteGrayTipMsgData(appRuntime);
                if (QLog.isColorLevel()) {
                    QLog.d("UniteGrayTipMsgUtil", 2, "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe msgGray.msgUid =", Long.valueOf(messageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(messageForUniteGrayTip.uniseq));
                }
            }
            List<MessageRecord> list = f213674a;
            list.removeAll(list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UniteGrayTipMsgUtil", 2, "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe not find msgGray.msgUid =", Long.valueOf(messageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(messageForUniteGrayTip.uniseq));
        }
    }

    public static boolean e(MessageRecord messageRecord) {
        if (messageRecord.msgtype == -2031) {
            return true;
        }
        if (messageRecord instanceof MessageForUniteGrayTip) {
            g gVar = ((MessageForUniteGrayTip) messageRecord).tipParam;
            if (gVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("UniteGrayTipMsgUtil", 2, "addGrayTipMsg failed, mutex grayTip in cache");
                }
                return false;
            }
            if (gVar.f213685h == 1) {
                return true;
            }
        }
        return false;
    }

    public static void f(List<MessageRecord> list) {
        f213674a.addAll(list);
    }
}
