package com.tencent.mobileqq.app.notification;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.c;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static String a(QQAppInterface qQAppInterface, Message message, String str) {
        String str2;
        try {
            AbsStructMsg d16 = i.d(message.msgData);
            if (d16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
                    return str;
                }
                return str;
            }
            int i3 = d16.mMsgServiceID;
            if (i3 == 61) {
                str2 = qQAppInterface.getApp().getResources().getString(R.string.f171497fi4);
            } else if (i3 == 107) {
                str2 = qQAppInterface.getApp().getResources().getString(R.string.f171480f83);
            } else {
                str2 = d16.mMsgBrief;
            }
            return str2;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg error:" + e16.getMessage(), e16);
                return str;
            }
            return str;
        }
    }

    @Nullable
    public static String b(QQAppInterface qQAppInterface, Message message) {
        if (c.e(message.msgtype)) {
            return e.t(qQAppInterface.getApp(), message);
        }
        int i3 = message.msgtype;
        if (i3 == -2009) {
            return qQAppInterface.getMessageFacade().T(qQAppInterface.getApp(), message, true);
        }
        if (i3 == -2040) {
            MessageForApproval messageForApproval = new MessageForApproval();
            messageForApproval.msgData = message.msgData;
            return messageForApproval.getFullTitle();
        }
        if (i3 == -2041) {
            return qQAppInterface.getApp().getString(R.string.f170422q2) + " " + qQAppInterface.getApp().getString(R.string.f170421pz);
        }
        CharSequence charSequence = "";
        if (i3 == -2011) {
            return a(qQAppInterface, message, "");
        }
        if (((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(message)) {
            return qQAppInterface.getApp().getString(R.string.aeg);
        }
        int i16 = message.msgtype;
        if (i16 == -7001) {
            return qQAppInterface.getApp().getString(R.string.cdl);
        }
        if (i16 == -2057) {
            return MessageForTroopStory.MSG_CONTENT;
        }
        if (i16 == -2059) {
            MessageForTroopPobing messageForTroopPobing = new MessageForTroopPobing();
            messageForTroopPobing.msgData = message.msgData;
            messageForTroopPobing.doParse();
            return messageForTroopPobing.getSummaryMsg();
        }
        if (c.f(i16)) {
            return e.s(qQAppInterface.getApp(), message);
        }
        if (message.msgtype == -2079) {
            return qQAppInterface.getApp().getString(R.string.f238107iv);
        }
        CharSequence messageText = message.getMessageText();
        ITroopRobotService iTroopRobotService = (ITroopRobotService) qQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
        if (iTroopRobotService.hasRobotNewsClassId(message)) {
            if (!iTroopRobotService.hasProcessedMoreDetail(message)) {
                iTroopRobotService.preProcessMessageMoreDetail(message);
            }
            String generateMoreDetailMsg = iTroopRobotService.generateMoreDetailMsg(message);
            if (!TextUtils.isEmpty(generateMoreDetailMsg)) {
                messageText = generateMoreDetailMsg;
            }
        } else if (message.msgtype == -5040 && com.tencent.mobileqq.mutualmark.oldlogic.c.c(qQAppInterface, message)) {
            messageText = com.tencent.mobileqq.mutualmark.oldlogic.c.g(message.f203106msg);
        }
        if (messageText != null) {
            charSequence = messageText;
        }
        if (charSequence instanceof QQText) {
            return ((QQText) charSequence).toPlainText();
        }
        return new QQText(charSequence.toString(), 3).toPlainText();
    }
}
